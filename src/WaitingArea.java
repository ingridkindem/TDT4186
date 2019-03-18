import java.util.LinkedList;

/**
 * This class implements a waiting area used as the bounded buffer, in the producer/consumer problem.
 * The waiting area is a common resource shared between the producer and consumers.
 * Customers can only be added as long as there is room in the waiting area, dictated by 𝑤𝑎𝑖𝑡𝑖𝑛𝑔𝐴𝑟𝑒𝑎𝐶𝑎𝑝𝑎𝑐𝑖𝑡𝑦.
 * The waiting area should have:
 * - A way of keeping track of all the waiting customers
 * - A max capacity
 *
 * Functionality:
 * - Let customers enter when there is room
 * - A way for customers to be fetched by waitresses
 */
public class WaitingArea {

    private int capacity;
    public LinkedList<Customer> queue;



    public WaitingArea(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();

    }

    public synchronized void enter(Customer customer) {
        if (queue.size() != capacity ){
            this.queue.add(customer);
            SushiBar.customerCounter.increment();
            SushiBar.write(Thread.currentThread().getName() + " Customer " + customer.getCustomerID() + " is now waiting.");
            notify();

        }

    }


    public synchronized Customer next() {
        if (queue.size() != -1){
            Customer nextCustomer = queue.poll();
            SushiBar.write(Thread.currentThread().getName() + " Customer " + nextCustomer.getCustomerID() + " is now waiting.");
            notify();

            return nextCustomer;

        }

    }

}
