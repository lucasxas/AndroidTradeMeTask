package lucasxavier.trademetask.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable{

    @SerializedName("Name")
    private String name;

    @SerializedName("Number")
    private String number;

    @SerializedName("Path")
    private String path;

    @SerializedName("Subcategories")
    List<Category> subcategories = new ArrayList<>();

    private String summary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public String getSummary() {
        if (summary == null) {
            StringBuilder sb = new StringBuilder();
            int max_sub_categories = 5;
            for (int i = 0; i < subcategories.size() && i < max_sub_categories; i++) {
                Category c = subcategories.get(i);
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(c.getName());
            }
            summary = sb.toString();
        }
        return summary;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", path='" + path + '\'' +
                ", subcategories=" + subcategories +
                '}';
    }
}
