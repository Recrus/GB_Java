package Lesson_2;
import java.util.HashMap;
import java.util.Map;

public class HW2_1 {
    public static void main(String[] args) {
        String jsonFilters = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        Map<String, String> filters = parseJsonFilters(jsonFilters);
        StringBuilder whereClause = new StringBuilder();

        boolean isFirstFilter = true;
        for (String key : filters.keySet()) {
            String value = filters.get(key);
            if (!value.equals("null")) {
                if (!isFirstFilter) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append(" = '").append(value).append("'");
                isFirstFilter = false;
            }
        }

        String sqlQuery = "SELECT * FROM students WHERE " + whereClause.toString();
        System.out.println(sqlQuery);
    }

    public static Map<String, String> parseJsonFilters(String jsonFilters) {
        Map<String, String> filters = new HashMap<>();

        String trimmedJson = jsonFilters.substring(1, jsonFilters.length() - 1);

        String[] pairs = trimmedJson.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1].trim().replace("\"", "");
            filters.put(key, value);
        }

        return filters;
    }
}
