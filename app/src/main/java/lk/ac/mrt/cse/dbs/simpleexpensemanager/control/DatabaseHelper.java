package lk.ac.mrt.cse.dbs.simpleexpensemanager.control;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    //  Account table
    public static final String ACCOUNT_TABLE = "account";
    //  Account table columns
    public static final String COLUMN_BANK_NAME = "bankName";
    public static final String COLUMN_ACCOUNT_NO = "accountNo";
    public static final String COLUMN_ACCOUNT_HOLDER_NAME = "accountHolderName";
    public static final String COLUMN_BALANCE = "balance";

    //  Transaction table
    public static final String TRANSACTION_TABLE = "account_Transaction";
    //  Transaction table columns
    public static final String COLUMN_TRANSACTION_ID = "transactionId";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_EXPENSE_TYPE = "expenseType";
    public static final String COLUMN_AMOUNT = "amount";

    //  Account table creation query
    public static final String createAccountTableQuery = "CREATE TABLE " + ACCOUNT_TABLE + " (" +
            COLUMN_ACCOUNT_NO + " TEXT PRIMARY KEY, " +
            COLUMN_BANK_NAME + " TEXT, " +
            COLUMN_ACCOUNT_HOLDER_NAME + " TEXT, " +
            COLUMN_BALANCE + " REAL)";

    //  Transaction table creation query
    public static final String createTransactionTableQuery = "CREATE TABLE " + TRANSACTION_TABLE + " ( " +
            COLUMN_TRANSACTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_DATE + " TEXT," +
            COLUMN_ACCOUNT_NO + " TEXT," +
            COLUMN_EXPENSE_TYPE + " TEXT," +
            COLUMN_AMOUNT + " REAL);";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // creating required tables
        sqLiteDatabase.execSQL(createAccountTableQuery);
        sqLiteDatabase.execSQL(createTransactionTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ACCOUNT_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TRANSACTION_TABLE);

        // create new tables
        onCreate(sqLiteDatabase);
    }
}
