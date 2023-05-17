package com.yy.gslbsdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.yy.gslbsdk.util.LogTools;
/* loaded from: classes10.dex */
public class DBInitMgr extends SQLiteOpenHelper {
    public static final String TAG = "DBInitMgr";
    public static final String TB_DELAY = "gslb_delay";
    public static final String TB_HIJACK = "gslb_hijack";
    public static final String TB_HOST = "gslb_host";
    public static final String TB_IDX_RESULT = "gslb_result_idx";
    public static final String TB_IDX_RESULT_V6 = "gslb_result_v6_idx";
    public static final String TB_PROBE = "gslb_probe";
    public static final String TB_RESULT = "gslb_result";
    public static final String TB_RESULT_V6 = "gslb_result_v6";
    public static final String TB_SERVER = "gslb_server";
    public static final String TB_SERVER_V6 = "gslb_server_v6";

    public DBInitMgr(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    private void createTbDelay(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_delay(_id INTEGER PRIMARY KEY AUTOINCREMENT,host TEXT,ip TEXT,delay INTEGER)");
        LogTools.printInfo(TAG, "CREATE TABLE gslb_delay");
    }

    private void createTbHijack(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_hijack(_id INTEGER PRIMARY KEY AUTOINCREMENT,host TEXT,nt INTEGER,uip TEXT,dnsip TEXT,hip TEXT)");
    }

    private void createTbHost(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_host(_id INTEGER PRIMARY KEY AUTOINCREMENT,host TEXT,is_pre INTEGER,insert_time INTEGER)");
    }

    private void createTbProbe(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_probe(_id INTEGER PRIMARY KEY AUTOINCREMENT,host TEXT,protocol INTEGER,method INTEGER,url TEXT)");
    }

    private void createTbResult(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_result(_id INTEGER PRIMARY KEY AUTOINCREMENT,network TEXT,host TEXT,ip TEXT,ttl INTEGER,end_time INTEGER,cmd TEXT,update_time INTEGER,_view TEXT,uip TEXT,src INTEGER)");
        sQLiteDatabase.execSQL("CREATE INDEX gslb_result_idx ON gslb_result(network,host)");
    }

    private void createTbResultV6(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_result_v6(_id INTEGER PRIMARY KEY AUTOINCREMENT,network TEXT,host TEXT,ip TEXT,ttl INTEGER,end_time INTEGER,cmd TEXT,update_time INTEGER,_view TEXT,uip TEXT,src INTEGER)");
        sQLiteDatabase.execSQL("CREATE INDEX gslb_result_v6_idx ON gslb_result_v6(network,host)");
    }

    private void createTbServer(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_server(_id INTEGER PRIMARY KEY AUTOINCREMENT,isp INTEGER,ip TEXT,ver TEXT)");
    }

    private void createTbServerV6(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS gslb_server_v6(_id INTEGER PRIMARY KEY AUTOINCREMENT,isp INTEGER,ip TEXT,ver TEXT)");
    }

    private void dropTbDelay(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_delay");
    }

    private void dropTbHijack(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_hijack");
    }

    private void dropTbHost(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_host");
        LogTools.printInfo(TAG, "DROP TABLE gslb_host");
    }

    private void dropTbProbe(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_probe");
    }

    private void dropTbResult(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP INDEX gslb_result_idx ON gslb_result");
        } catch (Exception unused) {
            LogTools.printInfo(TAG, "drop index error");
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_result");
    }

    private void dropTbResultV6(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP INDEX gslb_result_v6_idx ON gslb_result_v6");
        } catch (Exception unused) {
            LogTools.printInfo(TAG, "drop index error");
        }
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_result_v6");
    }

    private void dropTbServer(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_server");
    }

    private void dropTbServerV6(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS gslb_server_v6");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        createTbHost(sQLiteDatabase);
        createTbResult(sQLiteDatabase);
        createTbResultV6(sQLiteDatabase);
        createTbServer(sQLiteDatabase);
        createTbServerV6(sQLiteDatabase);
        createTbHijack(sQLiteDatabase);
        LogTools.printInfo(TAG, "create all table");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        dropTbHost(sQLiteDatabase);
        dropTbProbe(sQLiteDatabase);
        dropTbResult(sQLiteDatabase);
        dropTbResultV6(sQLiteDatabase);
        dropTbServer(sQLiteDatabase);
        dropTbServerV6(sQLiteDatabase);
        dropTbDelay(sQLiteDatabase);
        dropTbHijack(sQLiteDatabase);
        onCreate(sQLiteDatabase);
        LogTools.printInfo(TAG, "upgrade all table");
    }
}
