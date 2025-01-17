package org.example;

public class Coordenadas {
    private double longitud;
    private double latitud;

    public Coordenadas(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Override
    public String toString() {
        return "Coordenadas{" +
                "longitud=" + longitud +
                ", latitud=" + latitud +
                '}';
    }
    public double calcularDistanciaCoordenadas(Coordenadas coord) {
        final double RADIO_TIERRA = 6371000; // metros
        double dLat = Math.toRadians(latitud - coord.latitud);
        double dLon = Math.toRadians(longitud - coord.longitud);
        double lat1 = Math.toRadians(coord.latitud);
        double lat2 = Math.toRadians(latitud);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) *
                        Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return c * RADIO_TIERRA;
    }
}
