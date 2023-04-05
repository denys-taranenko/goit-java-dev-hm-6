package databaseutil;

import entity.*;
import util.FileSQLReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<Worker> findMaxSalaryWorker() {

        List<Worker> workers = new ArrayList<>();

        String sql = FileSQLReader.readFromFile("src/main/java/sql/find_max_salary_worker.sql");

        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                workers.add(Worker.builder().id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .birthday(LocalDate.parse(rs.getString("BIRTHDAY")))
                        .level(rs.getString("LEVEL"))
                        .salary(rs.getInt("SALARY")).build());
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return workers;

    }

    public List<ProjectWithDuration> findLongestProject() {

        List<ProjectWithDuration> projectWithDurations = new ArrayList<>();
        String sql = FileSQLReader.readFromFile("src/main/java/sql/find_longest_project.sql");

        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                projectWithDurations.add(ProjectWithDuration.builder().id(rs.getInt("ID"))
                        .startDate(LocalDate.parse(rs.getString("START_DATE")))
                        .finishDate(LocalDate.parse(rs.getString("FINISH_DATE")))
                        .durMonths(rs.getInt("DURATION_MONTHS")).build());
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectWithDurations;

    }

    public List<MaxProjectClient> findMaxProjectClient() {

        List<MaxProjectClient> maxProjectClients = new ArrayList<>();
        String sql = FileSQLReader.readFromFile("src/main/java/sql/find_max_projects_client.sql");

        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maxProjectClients.add(MaxProjectClient.builder().id(rs.getInt("ID"))
                        .name(rs.getString("NAME"))
                        .projectCount(rs.getInt("PROJECT_COUNT")).build());
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maxProjectClients;

    }

    public List<YOWorker> findYoungestOldestWorker() {

        List<YOWorker> yoWorkers = new ArrayList<>();
        String sql = FileSQLReader.readFromFile("src/main/java/sql/find_youngest_oldest_workers.sql");

        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                yoWorkers.add(YOWorker.builder().type(rs.getString("TYPE"))
                        .name(rs.getString("NAME"))
                        .birthday(LocalDate.parse(rs.getString("BIRTHDAY"))).build());
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return yoWorkers;

    }

    public List<ProjectPrice> printProjectPrice() {

        List<ProjectPrice> projectPrices = new ArrayList<>();
        String sql = FileSQLReader.readFromFile("src/main/java/sql/print_project_prices.sql");

        try (Statement st = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                projectPrices.add(ProjectPrice.builder().id(rs.getInt("ID"))
                        .price(rs.getInt("PRICE")).build());
                st.close();
            }
        } catch (SQLException e) {
            return null;
        }

        return projectPrices;

    }
}
