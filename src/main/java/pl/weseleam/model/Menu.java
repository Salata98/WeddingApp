package pl.weseleam.model;

public enum Menu {
    NORMAL("Mięsne"),
    VEGETARIAN("Wegetariańskie");

    private final String description;

    private Menu(String description){
       this.description = description;
    }

    public String getDescription() {
        return description;
   }
}