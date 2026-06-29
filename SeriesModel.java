public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int seriesEpisodes;

    public SeriesModel(String seriesId, String seriesName, int seriesAge, int seriesEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesEpisodes = seriesEpisodes;
    }

    public String getSeriesId() { return seriesId; }
    public String getSeriesName() { return seriesName; }
    public int getSeriesAge() { return seriesAge; }
    public int getSeriesEpisodes() { return seriesEpisodes; }

    public void setSeriesName(String seriesName) { this.seriesName = seriesName; }
    public void setSeriesAge(int seriesAge) { this.seriesAge = seriesAge; }
    public void setSeriesEpisodes(int seriesEpisodes) { this.seriesEpisodes = seriesEpisodes; }

    public String toString() {
        return "\nID: " + seriesId +
               "\nName: " + seriesName +
               "\nAge Restriction: " + seriesAge +
               "\nEpisodes: " + seriesEpisodes;
    }
}
