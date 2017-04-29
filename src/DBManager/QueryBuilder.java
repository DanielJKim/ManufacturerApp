package DBManager;

import java.util.ArrayList;

/**
 * Status: complete.
 */
class QueryBuilder {

    /**
     * Creates an insert statement
     * @param tablename - search of the table to be inserted into
     * @param fields - values of the attributes of the table to be inserted into
     * @return returns the query string
     */
    String createInsertStatement(String tablename, ArrayList<String> fields) {
        // Query string
        String query = "";
        // Put the table search into the query string
        query = query.concat("insert into " + tablename + " values(");
        // Put the fields into the query string
        for(int i = 0; i < fields.size(); i++) {
            if(i == fields.size()-1) {
                query = query.concat(fields.get(i) + ")");
            } else {
                query = query.concat(fields.get(i) + ",");
            }
        }
        return query;
    }

    /**
     * Creates an update statement
     * @param tablename - search of the table to update in
     * @param fields - search of fields to update
     * @param options - options to specify which fields to update
     * @return returns the query string
     */
    String createUpdateStatement(String tablename, ArrayList<String> fields, String options) {
        // Query string
        String query = "";
        // Put the table search in the query string
        query = query.concat("update " + tablename + " set ");
        // Put fields into query string
        for(int i = 0; i < fields.size(); i++) {
            if(i == fields.size()-1) {
                query = query.concat(fields.get(i));
            } else {
                query = query.concat(fields.get(i) + ",");
            }
        }
        // Put options into query string
        if(options != null && !options.isEmpty()) {
           query = query.concat(" where " + options);
        }
        return query;
    }

    /**
     * Creates a select statement
     * @param tablename - names of the tables to be selected from
     * @param fields - fields to be selected
     * @param options - options for selection
     * @return returns the query string
     */
    String createSelectStatement(String tablename, String fields, String options) {
        // Query string
        String query = "";
        // Put the fields and table search in the query string
        query = query.concat("select " + fields + " from " + tablename);
        // Put options into query string
        if(options != null && !options.isEmpty()) {
           query = query.concat(" where " + options);
        }
        return query;
    }

    String createLikeStatement(String tablename, String fields, ArrayList<ArrayList<String>> options) {
        String query = "select " + fields + " from " + tablename;
        if(options != null && !options.isEmpty()) {
            query = query.concat(" where ");
            System.out.println("0" + query);
            for(int i = 0; i < options.size(); i++) {
                if (options.get(i).size() > 0) {
                    if (!options.get(i).get(1).isEmpty()) {
                        query = query.concat(options.get(i).get(0) + " like '%" + options.get(i).get(1) + "%'");
                        System.out.println(options.size());
                        System.out.println("I: " + i);
                        if (i < options.size() - 1) {
                            System.out.println("yay");
                            query = query.concat(" and ");
                        }
                    }
                }
                System.out.println("1" + query);
            }
        }
        System.out.println("2" + query);
        return query;
    }

    String createLikeStatement1(String tablename, String fields, ArrayList<ArrayList<String>> options) {
        String query = "select " + fields + " from " + tablename;
        if(options != null && !options.isEmpty()) {
            query = query.concat(" where ");
            System.out.println("0" + query);
            for(int i = 0; i < options.size(); i++) {
                if (options.get(i).size() > 0) {
                    if (!options.get(i).get(0).isEmpty()) {
                        if(options.get(i).get(0).equals("=")) {
                            query = query.concat(options.get(i).get(1) + "='" + options.get(i).get(2) + "'");
                        } else if(options.get(i).get(0).equals("like")) {
                            query = query.concat(options.get(i).get(1) + " like UPPER('%" + options.get(i).get(2) + "%')");
                        } else if(options.get(i).get(0).equals("in")) {
                            query = query.concat(options.get(i).get(1) + " in (" + options.get(i).get(2) + ")");
                        }
                        if (i < options.size() - 1) {
                            query = query.concat(" and ");
                        }
                    }
                }
                System.out.println("1" + query);
            }
        }
        System.out.println("2" + query);
        return query;
    }
}
