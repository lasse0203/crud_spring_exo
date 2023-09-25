package mappers;

import com.example.tp_crud_spring.models.ContactDTO;
import entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);
    ContactDTO contactToContactDto(Contact contact);
    Contact contactDtoToContact(ContactDTO dto);
}
