package repo;

import entities.Customer;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private List<Customer> costumersList;

    public Optional<Customer> findById(long index) {
        return costumersList.stream().filter(p -> p.getId() == index).findFirst();
    }

    public void addCostumer (Customer customer) {
            costumersList.add(customer);
        }

        public void updateCostumer (Customer customer) {
            int index = costumersList.indexOf(customer);
            costumersList.set(index, customer);
        }

        public void deleteCostumer (Optional<Customer> customer) {
            costumersList.remove(customer);
        }

        public void deleteById (float id) {
            costumersList.removeIf(p -> p.getId() == id);
        }

        public List<Customer> getCustomersList() {
            return Collections.unmodifiableList(costumersList);
        }


    }