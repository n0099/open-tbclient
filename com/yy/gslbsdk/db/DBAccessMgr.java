package com.yy.gslbsdk.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class DBAccessMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "DBAccessMgr";
    public static DBAccessMgr instance;
    public static boolean noNeedDB;
    public transient /* synthetic */ FieldHolder $fh;
    public SQLiteDatabase db;
    public DBInitMgr dbHelper;
    public boolean openDBFailed;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1667456534, "Lcom/yy/gslbsdk/db/DBAccessMgr;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1667456534, "Lcom/yy/gslbsdk/db/DBAccessMgr;");
        }
    }

    public DBAccessMgr(Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.db = null;
        this.dbHelper = null;
        this.openDBFailed = false;
        try {
            DBInitMgr dBInitMgr = new DBInitMgr(context, GlobalTools.DB_NAME, null, GlobalTools.DB_VERSION);
            this.dbHelper = dBInitMgr;
            this.db = dBInitMgr.getWritableDatabase();
            z = false;
        } catch (SQLiteException e2) {
            LogTools.printError(TAG, String.format(Locale.US, "open db failed. %s ", e2.getMessage()));
            this.openDBFailed = true;
            z = true;
        }
        if (z) {
            try {
                try {
                    if (this.dbHelper != null) {
                        this.dbHelper.close();
                    }
                    if (this.db != null && this.db.isOpen()) {
                        this.db.close();
                    }
                } catch (Exception e3) {
                    LogTools.printError(TAG, String.format(Locale.US, "close db failed before open it again. %s ", e3.getMessage()));
                }
                try {
                    DBInitMgr dBInitMgr2 = new DBInitMgr(context, GlobalTools.DB_NAME, null, GlobalTools.DB_VERSION);
                    this.dbHelper = dBInitMgr2;
                    this.db = dBInitMgr2.getWritableDatabase();
                    this.openDBFailed = false;
                } catch (SQLiteException e4) {
                    LogTools.printError(TAG, String.format(Locale.US, "open db failed again. %s ", e4.getMessage()));
                    this.openDBFailed = true;
                }
            } finally {
                context.deleteDatabase(GlobalTools.DB_NAME);
            }
        }
    }

    public static synchronized DBAccessMgr getInstance(Context context) {
        InterceptResult invokeL;
        DBAccessMgr dBAccessMgr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
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
        return (DBAccessMgr) invokeL.objValue;
    }

    public synchronized void Close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                this.db.close();
                this.dbHelper.close();
            }
        }
    }

    public synchronized Long addHijack(HijackTB hijackTB) {
        InterceptResult invokeL;
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hijackTB)) == null) {
            synchronized (this) {
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
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return valueOf;
                }
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public synchronized Long addHost(HostTB hostTB) {
        InterceptResult invokeL;
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hostTB)) == null) {
            synchronized (this) {
                if (!noNeedDB && !this.openDBFailed) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("host", hostTB.getHost());
                    contentValues.put(HostTB.INSERTTIME, Long.valueOf(hostTB.getInsertTime()));
                    contentValues.put(HostTB.ISPRE, Integer.valueOf(hostTB.getIsPre()));
                    Long.valueOf(0L);
                    try {
                        valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_HOST, null, contentValues));
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return valueOf;
                }
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public synchronized Long addOrUpdate(ResultTB resultTB, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, resultTB, z)) == null) {
            synchronized (this) {
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
        }
        return (Long) invokeLZ.objValue;
    }

    public synchronized Long addOrUpdateV6(ResultTB resultTB, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, resultTB, z)) == null) {
            synchronized (this) {
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
        }
        return (Long) invokeLZ.objValue;
    }

    public synchronized Long addResult(ResultTB resultTB) {
        InterceptResult invokeL;
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, resultTB)) == null) {
            synchronized (this) {
                if (!noNeedDB && !this.openDBFailed) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("network", resultTB.getNetwork());
                    contentValues.put("host", resultTB.getHost());
                    contentValues.put("ip", resultTB.getIp());
                    contentValues.put(ResultTB.TTL, Integer.valueOf(resultTB.getTtl()));
                    contentValues.put("end_time", Long.valueOf(resultTB.getEndTime()));
                    contentValues.put("cmd", resultTB.getCmd());
                    contentValues.put("update_time", Long.valueOf(resultTB.getUpdateTime()));
                    contentValues.put(ResultTB.VIEW, resultTB.getView());
                    contentValues.put("uip", resultTB.getUip());
                    Long.valueOf(0L);
                    try {
                        valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_RESULT, null, contentValues));
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return valueOf;
                }
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public synchronized Long addResultV6(ResultTB resultTB) {
        InterceptResult invokeL;
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, resultTB)) == null) {
            synchronized (this) {
                if (!noNeedDB && !this.openDBFailed) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("network", resultTB.getNetwork());
                    contentValues.put("host", resultTB.getHost());
                    contentValues.put("ip", resultTB.getIp());
                    contentValues.put(ResultTB.TTL, Integer.valueOf(resultTB.getTtl()));
                    contentValues.put("end_time", Long.valueOf(resultTB.getEndTime()));
                    contentValues.put("cmd", resultTB.getCmd());
                    contentValues.put("update_time", Long.valueOf(resultTB.getUpdateTime()));
                    contentValues.put(ResultTB.VIEW, resultTB.getView());
                    contentValues.put("uip", resultTB.getUip());
                    Long.valueOf(0L);
                    try {
                        valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_RESULT_V6, null, contentValues));
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return valueOf;
                }
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public synchronized Long addServer(ServerTB serverTB) {
        InterceptResult invokeL;
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, serverTB)) == null) {
            synchronized (this) {
                if (!noNeedDB && !this.openDBFailed) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("isp", Integer.valueOf(serverTB.getIsp()));
                    contentValues.put("ip", serverTB.getIp());
                    contentValues.put("ver", Integer.valueOf(serverTB.getVer()));
                    Long.valueOf(0L);
                    try {
                        valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_SERVER, null, contentValues));
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return valueOf;
                }
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public synchronized Long addServerV6(ServerV6TB serverV6TB) {
        InterceptResult invokeL;
        Long valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, serverV6TB)) == null) {
            synchronized (this) {
                if (!noNeedDB && !this.openDBFailed) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("isp", Integer.valueOf(serverV6TB.getIsp()));
                    contentValues.put("ip", serverV6TB.getIp());
                    contentValues.put("ver", Integer.valueOf(serverV6TB.getVer()));
                    Long.valueOf(0L);
                    try {
                        valueOf = Long.valueOf(this.db.insert(DBInitMgr.TB_SERVER_V6, null, contentValues));
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return valueOf;
                }
                return 0L;
            }
        }
        return (Long) invokeL.objValue;
    }

    public synchronized int delHijack(HijackTB hijackTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, hijackTB)) == null) {
            synchronized (this) {
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
                        } catch (Exception e2) {
                            LogTools.printWarning(TAG, e2);
                        }
                        return i;
                    } catch (Exception e3) {
                        LogTools.printWarning(TAG, e3);
                        return -1;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delHijackByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            synchronized (this) {
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
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return i;
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delHost(HostTB hostTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hostTB)) == null) {
            synchronized (this) {
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
                        } catch (Exception e2) {
                            LogTools.printWarning(TAG, e2);
                        }
                        return i;
                    } catch (Exception e3) {
                        LogTools.printWarning(TAG, e3);
                        return -1;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delResult(ResultTB resultTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, resultTB)) == null) {
            synchronized (this) {
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
                        } catch (Exception e2) {
                            LogTools.printWarning(TAG, e2);
                        }
                        return i;
                    } catch (Exception e3) {
                        LogTools.printWarning(TAG, e3);
                        return -1;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delResultByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            synchronized (this) {
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return i;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delResultV6(ResultTB resultTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, resultTB)) == null) {
            synchronized (this) {
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
                        } catch (Exception e2) {
                            LogTools.printWarning(TAG, e2);
                        }
                        return i;
                    } catch (Exception e3) {
                        LogTools.printWarning(TAG, e3);
                        return -1;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delResultV6ByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return i;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delServer(ServerTB serverTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, serverTB)) == null) {
            synchronized (this) {
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
                        } catch (Exception e2) {
                            LogTools.printWarning(TAG, e2);
                        }
                        return i;
                    } catch (Exception e3) {
                        LogTools.printWarning(TAG, e3);
                        return -1;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int delServerV6(ServerV6TB serverV6TB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, serverV6TB)) == null) {
            synchronized (this) {
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
                        } catch (Exception e2) {
                            LogTools.printWarning(TAG, e2);
                        }
                        return i;
                    } catch (Exception e3) {
                        LogTools.printWarning(TAG, e3);
                        return -1;
                    }
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized void delSomeServer(List<ServerTB> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            synchronized (this) {
                if (list == null) {
                    return;
                }
                for (ServerTB serverTB : list) {
                    delServer(serverTB);
                }
            }
        }
    }

    public synchronized void delSomeServerV6(List<ServerV6TB> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            synchronized (this) {
                if (list == null) {
                    return;
                }
                for (ServerV6TB serverV6TB : list) {
                    delServerV6(serverV6TB);
                }
            }
        }
    }

    public synchronized List<HijackTB> getAllHijack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<HostTB> getAllHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<ServerTB> getAllServer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized List<ServerV6TB> getAllServerV6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public SQLiteDatabase getDb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.db : (SQLiteDatabase) invokeV.objValue;
    }

    public DBInitMgr getDbHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.dbHelper : (DBInitMgr) invokeV.objValue;
    }

    public synchronized List<HostTB> getHostByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeL.objValue;
    }

    public synchronized List<ResultTB> getResultByNetworkHost(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, str, str2)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
                try {
                    Cursor query = this.db.query(DBInitMgr.TB_RESULT, null, "network=? and host=?", new String[]{str, str2}, null, null, null);
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeLL.objValue;
    }

    public synchronized List<ResultTB> getResultV6ByNetworkHost(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeLL.objValue;
    }

    public synchronized List<ServerTB> getServerByIsp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeI.objValue;
    }

    public synchronized List<ServerV6TB> getServerV6ByIsp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                if (noNeedDB || this.openDBFailed) {
                    return arrayList;
                }
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
                } catch (Exception e2) {
                    LogTools.printWarning(TAG, e2);
                }
                return arrayList;
            }
        }
        return (List) invokeI.objValue;
    }

    public synchronized int updateHost(HostTB hostTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, hostTB)) == null) {
            synchronized (this) {
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
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return i;
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int updateResult(ResultTB resultTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, resultTB)) == null) {
            synchronized (this) {
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
                        contentValues.put(ResultTB.TTL, Integer.valueOf(resultTB.getTtl()));
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
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return i;
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public synchronized int updateResultV6(ResultTB resultTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, resultTB)) == null) {
            synchronized (this) {
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
                        contentValues.put(ResultTB.TTL, Integer.valueOf(resultTB.getTtl()));
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
                    } catch (Exception e2) {
                        LogTools.printWarning(TAG, e2);
                    }
                    return i;
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
