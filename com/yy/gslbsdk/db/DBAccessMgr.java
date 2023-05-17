package com.yy.gslbsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes10.dex */
public class DBAccessMgr {
    public static final String TAG = "DBAccessMgr";
    public static DBAccessMgr instance;
    public static boolean noNeedDB;
    public SQLiteDatabase db;
    public DBInitMgr dbHelper;
    public boolean openDBFailed;

    public DBAccessMgr(Context context) {
        boolean z;
        this.db = null;
        this.dbHelper = null;
        this.openDBFailed = false;
        try {
            DBInitMgr dBInitMgr = new DBInitMgr(context, GlobalTools.DB_NAME, null, GlobalTools.DB_VERSION);
            this.dbHelper = dBInitMgr;
            this.db = dBInitMgr.getWritableDatabase();
            z = false;
        } catch (SQLiteException e) {
            LogTools.printError(TAG, String.format(Locale.US, "open db failed. %s ", e.getMessage()));
            this.openDBFailed = true;
            z = true;
        }
        if (!z) {
            return;
        }
        try {
            try {
                if (this.dbHelper != null) {
                    this.dbHelper.close();
                }
                if (this.db != null && this.db.isOpen()) {
                    this.db.close();
                }
            } catch (Exception e2) {
                LogTools.printError(TAG, String.format(Locale.US, "close db failed before open it again. %s ", e2.getMessage()));
            }
            try {
                DBInitMgr dBInitMgr2 = new DBInitMgr(context, GlobalTools.DB_NAME, null, GlobalTools.DB_VERSION);
                this.dbHelper = dBInitMgr2;
                this.db = dBInitMgr2.getWritableDatabase();
                this.openDBFailed = false;
            } catch (SQLiteException e3) {
                LogTools.printError(TAG, String.format(Locale.US, "open db failed again. %s ", e3.getMessage()));
                this.openDBFailed = true;
            }
        } finally {
            context.deleteDatabase(GlobalTools.DB_NAME);
        }
    }

    public synchronized int delHost(HostTB hostTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                if (hostTB.getId() != -1) {
                    linkedList.add("_id=?");
                    linkedList2.add(String.valueOf(hostTB.getId()));
                }
                if (hostTB.getHost() != null) {
                    linkedList.add("host=?");
                    linkedList2.add(String.valueOf(hostTB.getHost()));
                }
                if (hostTB.getIsPre() != -1) {
                    linkedList.add("is_pre=?");
                    linkedList2.add(String.valueOf(hostTB.getIsPre()));
                }
                String str = "";
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    str = str + ((String) linkedList.get(i2));
                    if (i2 != linkedList.size() - 1) {
                        str = str + " and ";
                    }
                }
                try {
                    i = this.db.delete(DBInitMgr.TB_HOST, str, (String[]) linkedList2.toArray(new String[0]));
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
                return i;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return -1;
            }
        }
        return 0;
    }

    public synchronized int delServer(ServerTB serverTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                if (serverTB.getId() != -1) {
                    linkedList.add("_id=?");
                    linkedList2.add(String.valueOf(serverTB.getId()));
                }
                if (serverTB.getIsp() != -1) {
                    linkedList.add("isp=?");
                    linkedList2.add(String.valueOf(serverTB.getIsp()));
                }
                if (serverTB.getIp() != null) {
                    linkedList.add("ip=?");
                    linkedList2.add(String.valueOf(serverTB.getIp()));
                }
                String str = "";
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    str = str + ((String) linkedList.get(i2));
                    if (i2 != linkedList.size() - 1) {
                        str = str + " and ";
                    }
                }
                try {
                    i = this.db.delete(DBInitMgr.TB_SERVER, str, (String[]) linkedList2.toArray(new String[0]));
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
                return i;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return -1;
            }
        }
        return 0;
    }

    public synchronized int delServerV6(ServerV6TB serverV6TB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                if (serverV6TB.getId() != -1) {
                    linkedList.add("_id=?");
                    linkedList2.add(String.valueOf(serverV6TB.getId()));
                }
                if (serverV6TB.getIsp() != -1) {
                    linkedList.add("isp=?");
                    linkedList2.add(String.valueOf(serverV6TB.getIsp()));
                }
                if (serverV6TB.getIp() != null) {
                    linkedList.add("ip=?");
                    linkedList2.add(String.valueOf(serverV6TB.getIp()));
                }
                String str = "";
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    str = str + ((String) linkedList.get(i2));
                    if (i2 != linkedList.size() - 1) {
                        str = str + " and ";
                    }
                }
                try {
                    i = this.db.delete(DBInitMgr.TB_SERVER_V6, str, (String[]) linkedList2.toArray(new String[0]));
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
                return i;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return -1;
            }
        }
        return 0;
    }

    public static synchronized DBAccessMgr getInstance(Context context) {
        DBAccessMgr dBAccessMgr;
        synchronized (DBAccessMgr.class) {
            if (Build.VERSION.SDK_INT == 28) {
                noNeedDB = true;
            }
            if (instance == null) {
                instance = new DBAccessMgr(context);
            }
            dBAccessMgr = instance;
        }
        return dBAccessMgr;
    }

    public synchronized void delSomeServer(List<ServerTB> list) {
        if (list == null) {
            return;
        }
        for (ServerTB serverTB : list) {
            delServer(serverTB);
        }
    }

    public synchronized void delSomeServerV6(List<ServerV6TB> list) {
        if (list == null) {
            return;
        }
        for (ServerV6TB serverV6TB : list) {
            delServerV6(serverV6TB);
        }
    }

    public synchronized void Close() {
        this.db.close();
        this.dbHelper.close();
    }

    public SQLiteDatabase getDb() {
        return this.db;
    }

    public DBInitMgr getDbHelper() {
        return this.dbHelper;
    }

    public synchronized Long addHijack(HijackTB hijackTB) {
        Long valueOf;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("host", hijackTB.getHost());
            contentValues.put("nt", Integer.valueOf(hijackTB.getNt()));
            contentValues.put("uip", hijackTB.getUip());
            contentValues.put(HijackTB.DNSIP, hijackTB.getDnsip());
            contentValues.put(HijackTB.HIP, hijackTB.getHip());
            Long.valueOf(0L);
            try {
                valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_HIJACK, null, contentValues));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return valueOf;
        }
        return 0L;
    }

    public synchronized Long addResult(ResultTB resultTB) {
        Long valueOf;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("network", resultTB.getNetwork());
            contentValues.put("host", resultTB.getHost());
            contentValues.put("ip", resultTB.getIp());
            contentValues.put("ttl", Integer.valueOf(resultTB.getTtl()));
            contentValues.put("end_time", Long.valueOf(resultTB.getEndTime()));
            contentValues.put("cmd", resultTB.getCmd());
            contentValues.put("update_time", Long.valueOf(resultTB.getUpdateTime()));
            contentValues.put(ResultTB.VIEW, resultTB.getView());
            contentValues.put("uip", resultTB.getUip());
            Long.valueOf(0L);
            try {
                valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_RESULT, null, contentValues));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return valueOf;
        }
        return 0L;
    }

    public synchronized Long addResultV6(ResultTB resultTB) {
        Long valueOf;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("network", resultTB.getNetwork());
            contentValues.put("host", resultTB.getHost());
            contentValues.put("ip", resultTB.getIp());
            contentValues.put("ttl", Integer.valueOf(resultTB.getTtl()));
            contentValues.put("end_time", Long.valueOf(resultTB.getEndTime()));
            contentValues.put("cmd", resultTB.getCmd());
            contentValues.put("update_time", Long.valueOf(resultTB.getUpdateTime()));
            contentValues.put(ResultTB.VIEW, resultTB.getView());
            contentValues.put("uip", resultTB.getUip());
            Long.valueOf(0L);
            try {
                valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_RESULT_V6, null, contentValues));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return valueOf;
        }
        return 0L;
    }

    public synchronized int delHijackByHost(String str) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (str != null && str.length() > 0) {
                linkedList.add("host=?");
                linkedList2.add(str);
            }
            String str2 = "";
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                str2 = str2 + ((String) linkedList.get(i2));
                if (i2 != linkedList.size() - 1) {
                    str2 = str2 + " and ";
                }
            }
            try {
                i = this.db.delete(DBInitMgr.TB_HIJACK, str2, (String[]) linkedList2.toArray(new String[0]));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return i;
        }
        return 0;
    }

    public synchronized int delResultByHost(String str) {
        int i = 0;
        if (noNeedDB || this.openDBFailed) {
            return 0;
        }
        if (str == null) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList.add("host=?");
        linkedList2.add(str);
        String str2 = "";
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            str2 = str2 + ((String) linkedList.get(i2));
            if (i2 != linkedList.size() - 1) {
                str2 = str2 + " and ";
            }
        }
        try {
            i = this.db.delete(DBInitMgr.TB_RESULT, str2, (String[]) linkedList2.toArray(new String[0]));
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
        return i;
    }

    public synchronized int delResultV6ByHost(String str) {
        int i = 0;
        if (noNeedDB || this.openDBFailed) {
            return 0;
        }
        if (str == null) {
            return 0;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList.add("host=?");
        linkedList2.add(str);
        String str2 = "";
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            str2 = str2 + ((String) linkedList.get(i2));
            if (i2 != linkedList.size() - 1) {
                str2 = str2 + " and ";
            }
        }
        try {
            i = this.db.delete(DBInitMgr.TB_RESULT_V6, str2, (String[]) linkedList2.toArray(new String[0]));
        } catch (Exception e) {
            LogTools.printWarning(TAG, e);
        }
        return i;
    }

    public synchronized List<HostTB> getHostByHost(String str) {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                Cursor query = this.db.query(DBInitMgr.TB_HOST, null, "host=?", new String[]{String.valueOf(str)}, null, null, null);
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    HostTB hostTB = new HostTB();
                    hostTB.setId(query.getInt(0));
                    hostTB.setHost(query.getString(1));
                    hostTB.setIsPre(query.getInt(2));
                    hostTB.setInsertTime(query.getLong(3));
                    arrayList.add(hostTB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized List<ServerTB> getServerByIsp(int i) {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                SQLiteDatabase sQLiteDatabase = this.db;
                Cursor query = sQLiteDatabase.query(DBInitMgr.TB_SERVER, null, "isp=" + i, null, null, null, "_id");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    ServerTB serverTB = new ServerTB();
                    serverTB.setId(query.getInt(0));
                    serverTB.setIsp(query.getInt(1));
                    serverTB.setIp(query.getString(2));
                    serverTB.setVer(query.getInt(3));
                    arrayList.add(serverTB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized List<ServerV6TB> getServerV6ByIsp(int i) {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                SQLiteDatabase sQLiteDatabase = this.db;
                Cursor query = sQLiteDatabase.query(DBInitMgr.TB_SERVER_V6, null, "isp=" + i, null, null, null, "_id");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    ServerV6TB serverV6TB = new ServerV6TB();
                    serverV6TB.setId(query.getInt(0));
                    serverV6TB.setIsp(query.getInt(1));
                    serverV6TB.setIp(query.getString(2));
                    serverV6TB.setVer(query.getInt(3));
                    arrayList.add(serverV6TB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized int updateHost(HostTB hostTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            if (hostTB.getHost() != null) {
                contentValues.put("host", hostTB.getHost());
            }
            if (hostTB.getIsPre() != -1) {
                contentValues.put(HostTB.ISPRE, Integer.valueOf(hostTB.getIsPre()));
            }
            if (hostTB.getInsertTime() != -1) {
                contentValues.put(HostTB.INSERTTIME, Long.valueOf(hostTB.getInsertTime()));
            }
            try {
                i = this.db.update(DBInitMgr.TB_HOST, contentValues, "_id=?", new String[]{String.valueOf(hostTB.getId())});
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return i;
        }
        return 0;
    }

    public synchronized Long addHost(HostTB hostTB) {
        Long valueOf;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("host", hostTB.getHost());
            contentValues.put(HostTB.INSERTTIME, Long.valueOf(hostTB.getInsertTime()));
            contentValues.put(HostTB.ISPRE, Integer.valueOf(hostTB.getIsPre()));
            Long.valueOf(0L);
            try {
                valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_HOST, null, contentValues));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return valueOf;
        }
        return 0L;
    }

    public synchronized Long addServer(ServerTB serverTB) {
        Long valueOf;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isp", Integer.valueOf(serverTB.getIsp()));
            contentValues.put("ip", serverTB.getIp());
            contentValues.put("ver", Integer.valueOf(serverTB.getVer()));
            Long.valueOf(0L);
            try {
                valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_SERVER, null, contentValues));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return valueOf;
        }
        return 0L;
    }

    public synchronized Long addServerV6(ServerV6TB serverV6TB) {
        Long valueOf;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isp", Integer.valueOf(serverV6TB.getIsp()));
            contentValues.put("ip", serverV6TB.getIp());
            contentValues.put("ver", Integer.valueOf(serverV6TB.getVer()));
            Long.valueOf(0L);
            try {
                valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_SERVER_V6, null, contentValues));
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return valueOf;
        }
        return 0L;
    }

    public synchronized Long addOrUpdate(ResultTB resultTB, boolean z) {
        if (!noNeedDB && !this.openDBFailed) {
            List<ResultTB> resultByNetworkHost = getResultByNetworkHost(resultTB.getNetwork(), resultTB.getHost());
            if (resultByNetworkHost.isEmpty()) {
                return addResult(resultTB);
            }
            if (z) {
                resultTB.setId(resultByNetworkHost.get(0).getId());
                updateResult(resultTB);
            }
            return 0L;
        }
        return 0L;
    }

    public synchronized Long addOrUpdateV6(ResultTB resultTB, boolean z) {
        if (!noNeedDB && !this.openDBFailed) {
            List<ResultTB> resultV6ByNetworkHost = getResultV6ByNetworkHost(resultTB.getNetwork(), resultTB.getHost());
            if (resultV6ByNetworkHost.isEmpty()) {
                return addResultV6(resultTB);
            }
            if (z) {
                resultTB.setId(resultV6ByNetworkHost.get(0).getId());
                updateResultV6(resultTB);
            }
            return 0L;
        }
        return 0L;
    }

    public synchronized int delHijack(HijackTB hijackTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                if (hijackTB.getId() != -1) {
                    linkedList.add("_id=?");
                    linkedList2.add(String.valueOf(hijackTB.getId()));
                }
                if (hijackTB.getHost() != null) {
                    linkedList.add("host=?");
                    linkedList2.add(String.valueOf(hijackTB.getHost()));
                }
                if (hijackTB.getNt() != -1) {
                    linkedList.add("nt=?");
                    linkedList2.add(String.valueOf(hijackTB.getNt()));
                }
                if (hijackTB.getUip() != null) {
                    linkedList.add("uip=?");
                    linkedList2.add(String.valueOf(hijackTB.getUip()));
                }
                if (hijackTB.getDnsip() != null) {
                    linkedList.add("dnsip=?");
                    linkedList2.add(String.valueOf(hijackTB.getDnsip()));
                }
                if (hijackTB.getHip() != null) {
                    linkedList.add("hip=?");
                    linkedList2.add(String.valueOf(hijackTB.getHip()));
                }
                String str = "";
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    str = str + ((String) linkedList.get(i2));
                    if (i2 != linkedList.size() - 1) {
                        str = str + " and ";
                    }
                }
                try {
                    i = this.db.delete(DBInitMgr.TB_HIJACK, str, (String[]) linkedList2.toArray(new String[0]));
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
                return i;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return -1;
            }
        }
        return 0;
    }

    public synchronized int delResult(ResultTB resultTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                if (resultTB.getId() != -1) {
                    linkedList.add("_id=?");
                    linkedList2.add(String.valueOf(resultTB.getId()));
                }
                if (resultTB.getNetwork() != null) {
                    linkedList.add("network=?");
                    linkedList2.add(String.valueOf(resultTB.getNetwork()));
                }
                if (resultTB.getHost() != null) {
                    linkedList.add("host=?");
                    linkedList2.add(String.valueOf(resultTB.getHost()));
                }
                if (resultTB.getIp() != null) {
                    linkedList.add("ip=?");
                    linkedList2.add(String.valueOf(resultTB.getIp()));
                }
                String str = "";
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    str = str + ((String) linkedList.get(i2));
                    if (i2 != linkedList.size() - 1) {
                        str = str + " and ";
                    }
                }
                try {
                    i = this.db.delete(DBInitMgr.TB_RESULT, str, (String[]) linkedList2.toArray(new String[0]));
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
                return i;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return -1;
            }
        }
        return 0;
    }

    public synchronized int delResultV6(ResultTB resultTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                if (resultTB.getId() != -1) {
                    linkedList.add("_id=?");
                    linkedList2.add(String.valueOf(resultTB.getId()));
                }
                if (resultTB.getNetwork() != null) {
                    linkedList.add("network=?");
                    linkedList2.add(String.valueOf(resultTB.getNetwork()));
                }
                if (resultTB.getHost() != null) {
                    linkedList.add("host=?");
                    linkedList2.add(String.valueOf(resultTB.getHost()));
                }
                if (resultTB.getIp() != null) {
                    linkedList.add("ip=?");
                    linkedList2.add(String.valueOf(resultTB.getIp()));
                }
                String str = "";
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    str = str + ((String) linkedList.get(i2));
                    if (i2 != linkedList.size() - 1) {
                        str = str + " and ";
                    }
                }
                try {
                    i = this.db.delete(DBInitMgr.TB_RESULT_V6, str, (String[]) linkedList2.toArray(new String[0]));
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
                return i;
            } catch (Exception e2) {
                LogTools.printWarning(TAG, e2);
                return -1;
            }
        }
        return 0;
    }

    public synchronized int updateResult(ResultTB resultTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            if (resultTB.getNetwork() != null) {
                contentValues.put("network", resultTB.getNetwork());
            }
            if (resultTB.getHost() != null) {
                contentValues.put("host", resultTB.getHost());
            }
            if (resultTB.getIp() != null) {
                contentValues.put("ip", resultTB.getIp());
            }
            if (resultTB.getTtl() != -1) {
                contentValues.put("ttl", Integer.valueOf(resultTB.getTtl()));
            }
            if (resultTB.getEndTime() != -1) {
                contentValues.put("end_time", Long.valueOf(resultTB.getEndTime()));
            }
            if (resultTB.getCmd() != null) {
                contentValues.put("cmd", resultTB.getCmd());
            }
            if (resultTB.getUpdateTime() != -1) {
                contentValues.put("update_time", Long.valueOf(resultTB.getUpdateTime()));
            }
            if (resultTB.getView() != null) {
                contentValues.put(ResultTB.VIEW, resultTB.getView());
            }
            if (resultTB.getUip() != null) {
                contentValues.put("uip", resultTB.getUip());
            }
            try {
                i = this.db.update(DBInitMgr.TB_RESULT, contentValues, "_id=?", new String[]{String.valueOf(resultTB.getId())});
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return i;
        }
        return 0;
    }

    public synchronized int updateResultV6(ResultTB resultTB) {
        int i = 0;
        if (!noNeedDB && !this.openDBFailed) {
            ContentValues contentValues = new ContentValues();
            if (resultTB.getNetwork() != null) {
                contentValues.put("network", resultTB.getNetwork());
            }
            if (resultTB.getHost() != null) {
                contentValues.put("host", resultTB.getHost());
            }
            if (resultTB.getIp() != null) {
                contentValues.put("ip", resultTB.getIp());
            }
            if (resultTB.getTtl() != -1) {
                contentValues.put("ttl", Integer.valueOf(resultTB.getTtl()));
            }
            if (resultTB.getEndTime() != -1) {
                contentValues.put("end_time", Long.valueOf(resultTB.getEndTime()));
            }
            if (resultTB.getCmd() != null) {
                contentValues.put("cmd", resultTB.getCmd());
            }
            if (resultTB.getUpdateTime() != -1) {
                contentValues.put("update_time", Long.valueOf(resultTB.getUpdateTime()));
            }
            if (resultTB.getView() != null) {
                contentValues.put(ResultTB.VIEW, resultTB.getView());
            }
            if (resultTB.getUip() != null) {
                contentValues.put("uip", resultTB.getUip());
            }
            try {
                i = this.db.update(DBInitMgr.TB_RESULT_V6, contentValues, "_id=?", new String[]{String.valueOf(resultTB.getId())});
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return i;
        }
        return 0;
    }

    public synchronized List<HijackTB> getAllHijack() {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                Cursor query = this.db.query(DBInitMgr.TB_HIJACK, null, null, null, null, null, null);
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    HijackTB hijackTB = new HijackTB();
                    hijackTB.setId(query.getInt(0));
                    hijackTB.setHost(query.getString(1));
                    hijackTB.setNt(query.getInt(2));
                    hijackTB.setUip(query.getString(3));
                    hijackTB.setDnsip(query.getString(4));
                    hijackTB.setHip(query.getString(5));
                    arrayList.add(hijackTB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized List<HostTB> getAllHost() {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                Cursor query = this.db.query(DBInitMgr.TB_HOST, null, null, null, null, null, "insert_time DESC");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    HostTB hostTB = new HostTB();
                    hostTB.setId(query.getInt(0));
                    hostTB.setHost(query.getString(1));
                    hostTB.setIsPre(query.getInt(2));
                    hostTB.setInsertTime(query.getLong(3));
                    arrayList.add(hostTB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized List<ServerTB> getAllServer() {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                Cursor query = this.db.query(DBInitMgr.TB_SERVER, null, null, null, null, null, "_id");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    ServerTB serverTB = new ServerTB();
                    serverTB.setId(query.getInt(0));
                    serverTB.setIsp(query.getInt(1));
                    serverTB.setIp(query.getString(2));
                    serverTB.setVer(query.getInt(3));
                    arrayList.add(serverTB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    public synchronized List<ServerV6TB> getAllServerV6() {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                Cursor query = this.db.query(DBInitMgr.TB_SERVER_V6, null, null, null, null, null, "_id");
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    ServerV6TB serverV6TB = new ServerV6TB();
                    serverV6TB.setId(query.getInt(0));
                    serverV6TB.setIsp(query.getInt(1));
                    serverV6TB.setIp(query.getString(2));
                    serverV6TB.setVer(query.getInt(3));
                    arrayList.add(serverV6TB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0095, code lost:
        if (r1 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0097, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a3, code lost:
        if (r1 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a7, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<ResultTB> getResultByNetworkHost(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            Cursor cursor = null;
            try {
                cursor = this.db.query(DBInitMgr.TB_RESULT, null, "network=? and host=?", new String[]{str, str2}, null, null, null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    ResultTB resultTB = new ResultTB();
                    resultTB.setId(cursor.getInt(0));
                    resultTB.setNetwork(cursor.getString(1));
                    resultTB.setHost(cursor.getString(2));
                    resultTB.setIp(cursor.getString(3));
                    resultTB.setTtl(cursor.getInt(4));
                    resultTB.setEndTime(cursor.getLong(5));
                    resultTB.setCmd(cursor.getString(6));
                    resultTB.setUpdateTime(cursor.getLong(7));
                    resultTB.setView(cursor.getString(8));
                    resultTB.setUip(cursor.getString(9));
                    resultTB.setSource(cursor.getInt(10));
                    arrayList.add(resultTB);
                    cursor.moveToNext();
                }
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
        } else {
            return arrayList;
        }
    }

    public synchronized List<ResultTB> getResultV6ByNetworkHost(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!noNeedDB && !this.openDBFailed) {
            try {
                Cursor query = this.db.query(DBInitMgr.TB_RESULT_V6, null, "network=? and host=?", new String[]{str, str2}, null, null, null);
                query.moveToFirst();
                while (!query.isAfterLast()) {
                    ResultTB resultTB = new ResultTB();
                    resultTB.setId(query.getInt(0));
                    resultTB.setNetwork(query.getString(1));
                    resultTB.setHost(query.getString(2));
                    resultTB.setIp(query.getString(3));
                    resultTB.setTtl(query.getInt(4));
                    resultTB.setEndTime(query.getLong(5));
                    resultTB.setCmd(query.getString(6));
                    resultTB.setUpdateTime(query.getLong(7));
                    resultTB.setView(query.getString(8));
                    resultTB.setUip(query.getString(9));
                    resultTB.setSource(query.getInt(10));
                    arrayList.add(resultTB);
                    query.moveToNext();
                }
                query.close();
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return arrayList;
    }
}
