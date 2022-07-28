package vttp2022.weatherapp.model;

import jakarta.json.JsonObject;

public class Conditions {
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static Conditions createJson(JsonObject object) {
        Conditions c = new Conditions();
        c.description = "%S - %s".formatted(object.getString("main"), object.getString("description"));
        return c;
    }
}
