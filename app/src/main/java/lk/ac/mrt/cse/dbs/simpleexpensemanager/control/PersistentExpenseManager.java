package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;

import android.content.Context;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentTransactionDAO;

public class PersistentExpenseManager extends ExpenseManager {
    private final Context context;
    private static final String DATABASE="200435P";
    private static final int DATABASE_VERSION = 1;

    public PersistentExpenseManager(Context context) {
        this.context=context;
        setup();
    }

    @Override
    public void setup() {
        // Begin generating persistent manager implementation

        DatabaseHelper databaseHelper =new DatabaseHelper(this.context,DATABASE,null,DATABASE_VERSION);

        TransactionDAO persistentTransactionDAO = new PersistentTransactionDAO(databaseHelper);
        setTransactionsDAO(persistentTransactionDAO);

        AccountDAO persistentAccountDAO = new PersistentAccountDAO(databaseHelper);
        setAccountsDAO(persistentAccountDAO);

        // End
    }
}
