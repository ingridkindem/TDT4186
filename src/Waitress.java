/**
 * This class implements the consumer part of the producer/consumer problem.
 * One waitress instance corresponds to one consumer.
 * The waitresses will work as the consumers.
 * When a customer is fetched, the waitress uses some time before taking the customer’s order.
 * After the customer is finished ordering and done eating, the waitress can fetch a new customer from the waiting area.
 * Note that the customers should be fetched from the waiting area in a first come – first serve manner.
 * This means that the earlier the customer enters the waiting area, the sooner he/she is fetched.
 */
public class Waitress implements Runnable {
    private WaitingArea  waitingArea;


    Waitress(WaitingArea waitingArea) {
        this.waitingArea = waitingArea;

    }

    @Override
    public void run() {
        while (!waitingArea. || SushiBar.isOpen){
            Customer nextCustomer = waitingArea.next();

            // Waiting time befor ordering
            try{
                Thread.sleep(SushiBar.waitressWait);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            nextCustomer.order();

            // Waiting for customer to eat up
            try{
                Thread.sleep(SushiBar.customerWait);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            SushiBar.write(Thread.currentThread().getName() + " Customer " + nextCustomer.getCustomerID() + " is now leaving");

            if((waitingArea.queue.next() == -1) && (!SushiBar.isOpen)){
                SushiBar.write(Thread.currentThread().getName() + "***** NO MORE CUSTOMERS - THE SHOP IS CLOSED NOW. *****");
                SushiBar.write(Thread.currentThread().getName() + "TotalOrders: " + SushiBar.totalOrders.get());
                SushiBar.write(Thread.currentThread().getName() + "ServedOrders: " + SushiBar.servedOrders.get());
                SushiBar.write(Thread.currentThread().getName() + "TakeAwayOrders: " + SushiBar.takeawayOrders.get());
            }

        }



    }


}

