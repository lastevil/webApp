public class Product {
    private final int id;
    private final String title;
    private final double coast;

    public Product(int id, String title, double coast) {
        this.id=id;
        this.title = title;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return
                "{ id = '" + id + "'" +
                ", title='" + title + "'" +
                ", coast=" + coast +
                "}";
    }
}
