package io.gitee.lianghang.lhmybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Table> tableList;
    private String basePackage;

    public Table getTableByName(String tableName){
        for(Table table:tableList){
            if(table.getName().equals(tableName)){
                return table;
            }
        }
        return null;
    }

    public List<Table> getAssociatedListByTableName(String tableName){
        List<Table> associatedList=new ArrayList<>();
        for(Table tableItem:tableList){
            for(ForeignKey foreignKeyItem:tableItem.getForeignKeyList()){
                if (foreignKeyItem.getReferencedTableName().equals(tableName)) {
                    associatedList.add(tableItem);
                    break;
                }
            }
        }
        return associatedList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
