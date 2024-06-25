public class Cuboid {
    double panjang;
    double lebar;
    double tinggi;

    public double volume() {
        return panjang * lebar * tinggi;
    }
    public double luasPermukaan() {
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }
}
