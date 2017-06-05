public class Baloon extends Aircraft implements IFlyable  {
  private WeatherTower weatherTower = new WeatherTower();

  Baloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  public void updateConditions() {
    switch (weatherTower.getWeather(this.coordinates)) {
      case "RAIN": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): It's rain a man!");
        break;
      } case "FOG": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Is it pollution or fog..?");
        break;
      } case "SUN": {
        coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): Wow the view is unbeliable now!");
        break;
      } case "SNOW": {
        coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): We should go down, now it's snowing..");
        break;
      }
    }
    if (coordinates.getHeight() <= 0) {
      System.out.println(this.getClass().getName() + "#" + this.name + "(" + this.id + "): exploded ...");
      weatherTower.unregister(this);
    } else if (coordinates.getHeight() > 100)
      coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
  }

  public void registerTower(WeatherTower weatherTower) {
      this.weatherTower = weatherTower;
  }
}
