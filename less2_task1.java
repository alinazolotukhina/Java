import org.json.JSONObject;

public class SqlQueryBuilder {
    public static void main(String[] args) {
        JSONObject filterParams = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        StringBuilder whereClause = new StringBuilder();

        boolean hasPreviousParam = false;

        for (String key : filterParams.keySet()) {
            String value = filterParams.getString(key);
            if (!value.equals("null")) {
                if (hasPreviousParam) {
                    whereClause.append(" and ");
                }
                whereClause.append(key).append("='").append(value).append("'");
                hasPreviousParam = true;
            }
        }

        String sqlWhereClause = whereClause.toString();
        System.out.println("WHERE " + sqlWhereClause);
    }
}
