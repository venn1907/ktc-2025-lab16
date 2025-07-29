package classes;

import java.util.ArrayList;
import java.util.List;

public class ContactManagement {
    private List<Contact> contactList;

    public ContactManagement() {
        contactList = new ArrayList<>();
    }

    public void printContact(Contact contact) {
        System.out.println(
                "ID: " + contact.getId() + "; Name: " + contact.getName() + "; Phone: " + contact.getPhone() +
                        "; Email: " + contact.getEmail() + "; Address: " + contact.getAddress());
    }

    public boolean isExisted(int id) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getId() == id) {
                return true;
            }
        }

        return false;
    }

    public boolean isExisted(String input) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getEmail().equals(input) || contactList.get(i).getPhone().equals(input)) {
                return true;
            }
        }

        return false;
    }

    public void getContactList() {
        System.out.println("Danh sach lien he:");
        for (Contact contact : contactList) {
            printContact(contact);
        }
    }

    public void getContact(String phone) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getPhone().equals(phone)) {
                printContact(contactList.get(i));
                return;
            }
        }

        System.out.println("Khong tim thay lien he nay");
    }

    public void addContact(String name, String phone, String email, String address) {
        int id = contactList.isEmpty() ? 0 : contactList.get(contactList.size() - 1).getId() + 1;

        Contact contact = new Contact(id, name, phone, email, address);
        contactList.add(contact);
        System.out.println("Da them lien he thanh cong");
    }

    public void updateContact(Contact contact) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getId() == contact.getId()) {
                if (!"".equals(contact.getName())) {
                    contactList.get(i).setName(contact.getName());
                }
                if (!"".equals(contact.getPhone())) {
                    contactList.get(i).setPhone(contact.getPhone());
                }
                if (!"".equals(contact.getEmail())) {
                    contactList.get(i).setEmail(contact.getEmail());
                }
                if (!"".equals(contact.getAddress())) {
                    contactList.get(i).setAddress(contact.getAddress());
                }
                System.out.println("Da cap nhat lien he thanh cong");
                return;
            }
        }

        System.out.println("Khong tim thay lien he nay");
    }

    public void removeContact(int id) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getId() == id) {
                contactList.remove(i);
                System.out.println("Da xoa lien he thanh cong");
                return;
            }
        }

        System.out.println("Khong tim thay lien he nay");
    }

}
