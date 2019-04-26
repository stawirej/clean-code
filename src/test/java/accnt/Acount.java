package accnt;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

final class Acount {

    protected String accntNr;

    Acount(String accntNr) {
        this.accntNr = accntNr;
    }

    public String fetch(
            String machine,
            int p,
            String db,
            String u,
            String pass) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try {
            Connection c = DriverManager.getConnection("jdbc:postgresql://"
                                   + machine + ":" + p + "/" + db, u, pass);
            final ArrayList<Double> list = new ArrayList<Double>();
            if (u.equals("admin")) {
                ResultSet rs = c.createStatement()
                        .executeQuery("select salary from users");
                while (rs.next()) {
                    //Retrieve by column name
                    double value = rs.getDouble("salary");
                    list.add(value);
                    PrintWriter pw = new PrintWriter(new FileWriter("C:\\salaries_" + u + ".txt"));
                    pw.print(value);
                    pw.close();
                }
            } else {
                ResultSet rs = c.createStatement()
                        .executeQuery("select salary from users where role not in ('admin')");
                while (rs.next()) {
                    double value = rs.getDouble("salary");
                    list.add(value);
                }
                final double value = rs.getDouble("salary");
                list.add(value);
            }

            System.out.println("Retrieved: " + list.size());

            String collect = list.stream().map(aDouble -> "<p>" + aDouble + "</p>")
                    .collect(Collectors.joining("\n"));

            return String.format("<html>\n" +
                                         "<head>\n" +
                                         "<title>%s%s</title>\n" +
                                         "</head>\n" +
                                         "<body>\n" +
                                         "\n" +
                                         "<h1>Salaries</h1>\n" +
                                         "%s" +
                                         "\n" +
                                         "</body>\n" +
                                         "</html>", u, accntNr, collect);

        } catch (Exception e) {
            //Something bad happend
        }
        return null;
    }
}
