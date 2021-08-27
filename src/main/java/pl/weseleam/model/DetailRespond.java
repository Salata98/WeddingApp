package pl.weseleam.model;

public class DetailRespond {

    private String response;

    public DetailRespond(){}



    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "DetailRespond{" +
                "response='" + response + '\'' +
                '}';
    }
}
