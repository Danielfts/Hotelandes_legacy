package edu.uniandes.hotelandes.hotel.room.type;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomTypeRepository implements RoomTypeDao{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoomTypeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertRoomType(RoomType roomType) {
        final var sql = "INSERT INTO hotel_room_type(name, description, capacity, price) VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(sql, roomType.name(), roomType.description(), roomType.capacity(), roomType.pricePerNight());
    }

    @Override
    public Optional<RoomType> selectRoomTypeById(int id) {
        final var sql = "SELECT id, name, description, capacity, price FROM hotel_room_type WHERE id = ?";
        final var roomTypes = jdbcTemplate.query(sql, new RoomTypeRowMapper(), id);
        return roomTypes.stream().findFirst();
    }

    @Override
    public List<RoomType> selectRoomTypes() {
        final var sql = "SELECT id, name, description, capacity, pricePerNight FROM RoomType";
        return jdbcTemplate.query(sql, new RoomTypeRowMapper());
    }

    @Override
    public int updateRoomType(int id, RoomType roomType) {
        final var sql = "UPDATE RoomType SET name = ?, description = ?, capacity = ?, pricePerNight = ? WHERE id = ?";
        return jdbcTemplate.update(sql, roomType.name(), roomType.description(), roomType.capacity(), roomType.pricePerNight(), id);
    }

    @Override
    public int deleteRoomType(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRoomType'");
    }

    
    

}