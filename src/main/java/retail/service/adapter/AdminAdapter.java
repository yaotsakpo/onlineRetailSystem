package retail.service.adapter;

import retail.domain.Admin;
import retail.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class AdminAdapter {

    public static Admin getAdminFromAdminDTO(AdminDTO adminDTO) {

        Admin admin = new Admin(adminDTO.getFirstName(), adminDTO.getLastName());
        admin.setPassword(adminDTO.getPassword());
        admin.setUsername(adminDTO.getUsername());
        admin.setEmail(adminDTO.getEmail());
        return admin;
    }

    public static AdminDTO getAdminDTOFromAdmin(Admin admin) {

        AdminDTO adminDTO = new AdminDTO(admin.getFirstName(), admin.getLastName());
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setId(admin.getId());
        adminDTO.setPassword(admin.getPassword());
        return adminDTO;
    }
    public static List<AdminDTO> getAllCustomerDTOsFromCustomers(List<Admin> admins){
        List<AdminDTO> adminDTOS = new ArrayList<>();
        for(Admin admin: admins){
            adminDTOS.add(AdminAdapter.getAdminDTOFromAdmin(admin));
        }
        return adminDTOS;
    }
}
