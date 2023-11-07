package edu.uniandes.hotelandes.hotel.room.hotelService.serviceBooking;

import edu.uniandes.hotelandes.hotel.room.service.HotelServiceService;
import edu.uniandes.hotelandes.user.UserService;
<<<<<<< HEAD
import java.util.Date;
import java.util.Random;
=======
import edu.uniandes.hotelandes.user.client.ClientService;
>>>>>>> feature-data-generation
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBookingGenerator {

<<<<<<< HEAD
  @Autowired private HotelServiceService hotelServiceService;

  @Autowired private UserService userService;

  public ServiceBooking generateServiceBooking(Faker faker) {
    Date bookingStart = faker.date().birthday();
    Date bookingEnd = faker.date().birthday();
    Byte serviceId = (byte) getValidServiceId();
    Byte userId = (byte) getValidClientId();
    return new ServiceBooking(null, bookingStart, bookingEnd, serviceId, userId);
  }

  private int getValidServiceId() {
    final var services = hotelServiceService.getServices();
    Random random = new Random();
    int id = services.get(random.nextInt(services.size())).id();
    return id;
  }

  private int getValidClientId() {
    boolean sent = true;
    final var users = userService.getUsers();
    Random random = new Random();
    int id = 0;
    while (sent) {
      if (users.get(random.nextInt(users.size())).role_id() == 1)
        ;
      id = users.get(random.nextInt(users.size())).id();
      sent = false;
    }
    return id;
  }
=======
        @Autowired
        private HotelServiceService hotelServiceService;

        @Autowired
        private ClientService clientService;

        public ServiceBooking generateServiceBooking(Faker faker) {
            Date bookingStart = faker.date().birthday();
            Date bookingEnd = faker.date().birthday();
            Byte serviceId = (byte) getValidServiceId();
            Byte userId = (byte) getValidClientId();
            return new ServiceBooking(null, bookingStart, bookingEnd, serviceId, userId);

        }

        private int getValidServiceId() {
            final var services = hotelServiceService.getServices();
            Random random = new Random();
            int id = services.get(random.nextInt(services.size())).id();
            return id;
        }

        private int getValidClientId() {
            final var clients = clientService.getClients();
            Random random = new Random();
            int id = clients.get(random.nextInt(clients.size())).id();
            return id;
        }
>>>>>>> feature-data-generation
}
