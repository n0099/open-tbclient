package com.yy.gslbsdk.cache;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.ServerTB;
import com.yy.gslbsdk.device.DeviceMgr;
import com.yy.gslbsdk.protocol.UpdateServerInfo;
import com.yy.gslbsdk.protocol.UpdateServerProtocolMgr;
import com.yy.gslbsdk.thread.AsynTaskMgr;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import com.yy.gslbsdk.util.RuntimeTools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes8.dex */
public class ServerIPMgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] SERVER_IP_CMC;
    public static final String[] SERVER_IP_CNC;
    public static final String[] SERVER_IP_CTL;
    public static final String[] SERVER_IP_EDU;
    public static final String[] SERVER_IP_LOCALIZE;
    public static final String[] SERVER_IP_PUBLIC;
    public static final String TAG = "ServerIPMgr";
    public static String curLocalDNSIp = null;
    public static ServerIPMgr mServerIPMgr = null;
    public static String reportUrl = "";
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList mBestServerIpCache;
    public ConcurrentMap mIspServerIpCache;
    public List mListUsedIsp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(671150278, "Lcom/yy/gslbsdk/cache/ServerIPMgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(671150278, "Lcom/yy/gslbsdk/cache/ServerIPMgr;");
                return;
            }
        }
        SERVER_IP_CTL = new String[]{"221.228.209.120", "183.36.121.65", "59.36.239.133", "106.38.197.33"};
        SERVER_IP_CNC = new String[]{"122.97.255.32", "58.251.123.214", "27.36.226.132", "123.125.184.139"};
        SERVER_IP_CMC = new String[]{"120.195.158.62", "120.197.129.137", "120.241.148.226", "111.13.164.42"};
        SERVER_IP_EDU = new String[]{"59.78.210.113"};
        SERVER_IP_PUBLIC = new String[0];
        SERVER_IP_LOCALIZE = new String[0];
    }

    public ServerIPMgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mListUsedIsp = null;
        this.mBestServerIpCache = new LinkedList();
        this.mIspServerIpCache = new ConcurrentHashMap();
    }

    public int updateServerIpByLocalDns(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) {
            return updateServerIP(context, GlobalTools.HTTPDNS_SERVER_HOST);
        }
        return invokeL.intValue;
    }

    public static ServerIPMgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mServerIPMgr == null) {
                mServerIPMgr = new ServerIPMgr();
            }
            return mServerIPMgr;
        }
        return (ServerIPMgr) invokeV.objValue;
    }

    public synchronized void clearBestServerIPCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.mBestServerIpCache.clear();
            }
        }
    }

    public synchronized LinkedList getBestServerIPCache() {
        InterceptResult invokeV;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                linkedList = (LinkedList) this.mBestServerIpCache.clone();
            }
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public ConcurrentMap getIspServerIpCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mIspServerIpCache;
        }
        return (ConcurrentMap) invokeV.objValue;
    }

    private ArrayList getServerIpListFromDb(Context context, int i) {
        InterceptResult invokeLI;
        String ip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i)) == null) {
            ArrayList arrayList = new ArrayList();
            List serverByIsp = DBAccessMgr.getInstance(context).getServerByIsp(i);
            if (serverByIsp != null && !serverByIsp.isEmpty()) {
                for (int i2 = 0; i2 < serverByIsp.size(); i2++) {
                    ServerTB serverTB = (ServerTB) serverByIsp.get(i2);
                    if (serverTB != null && (ip = serverTB.getIp()) != null) {
                        arrayList.add(ip);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public boolean canUpdate(Context context, int i) {
        InterceptResult invokeLI;
        ServerTB serverTB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i)) == null) {
            List allServer = DBAccessMgr.getInstance(context).getAllServer();
            if (allServer == null || allServer.isEmpty() || (serverTB = (ServerTB) allServer.get(0)) == null || i <= serverTB.getVer()) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public String getOneServerIPByKnownISP(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, context, i)) == null) {
            ArrayList serverIpListFromCache = getServerIpListFromCache(i);
            if (serverIpListFromCache == null || serverIpListFromCache.isEmpty()) {
                serverIpListFromCache = getServerIpListFromDb(context, i);
            }
            if (serverIpListFromCache != null && !serverIpListFromCache.isEmpty()) {
                return (String) serverIpListFromCache.get(0);
            }
            return null;
        }
        return (String) invokeLI.objValue;
    }

    public void addIspServerIpCache(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            for (int i = 0; i < list.size(); i++) {
                ServerTB serverTB = (ServerTB) list.get(i);
                if (serverTB != null) {
                    int isp = serverTB.getIsp();
                    if (!this.mListUsedIsp.contains(Integer.valueOf(isp))) {
                        continue;
                    } else if (this.mIspServerIpCache.containsKey(Integer.valueOf(isp))) {
                        ArrayList arrayList = (ArrayList) this.mIspServerIpCache.get(Integer.valueOf(isp));
                        if (arrayList != null && !arrayList.isEmpty()) {
                            synchronized (arrayList) {
                                arrayList.add(serverTB);
                            }
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(serverTB);
                        this.mIspServerIpCache.putIfAbsent(Integer.valueOf(isp), arrayList2);
                    }
                }
            }
        }
    }

    public String getOneServerIPByUnKnownISP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            if (this.mListUsedIsp == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List list = this.mListUsedIsp;
            for (int i = 0; i < list.size(); i++) {
                int intValue = ((Integer) list.get(i)).intValue();
                ArrayList serverIpListFromCache = getServerIpListFromCache(intValue);
                if (serverIpListFromCache == null || serverIpListFromCache.isEmpty()) {
                    serverIpListFromCache = getServerIpListFromDb(context, intValue);
                }
                if (serverIpListFromCache != null && !serverIpListFromCache.isEmpty()) {
                    arrayList.add(serverIpListFromCache.get(0));
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            Collections.shuffle(arrayList);
            return (String) arrayList.get(0);
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:9:0x0013, B:11:0x0019, B:13:0x0021, B:15:0x002f, B:16:0x0032, B:18:0x003b, B:20:0x004f, B:21:0x0055, B:23:0x005a), top: B:33:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void resetBestServerIPCache(ServerIPInfo serverIPInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, serverIPInfo) == null) {
            synchronized (this) {
                if (serverIPInfo != null) {
                    if (serverIPInfo.getIp() != null) {
                        Iterator it = this.mBestServerIpCache.iterator();
                        while (it.hasNext()) {
                            ServerIPInfo serverIPInfo2 = (ServerIPInfo) it.next();
                            if (serverIPInfo2 == null || serverIPInfo2.getIp().equals(serverIPInfo.getIp())) {
                                it.remove();
                                break;
                            }
                            while (it.hasNext()) {
                            }
                        }
                        int i = 0;
                        int size = this.mBestServerIpCache.size();
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (serverIPInfo.getScore() < ((ServerIPInfo) this.mBestServerIpCache.get(i)).getScore()) {
                                this.mBestServerIpCache.add(i, serverIPInfo);
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (i == size) {
                            this.mBestServerIpCache.add(serverIPInfo);
                        }
                    }
                }
            }
        }
    }

    public ArrayList getServerIPByKnownISP(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, context, i)) == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList serverIpListFromCache = getServerIpListFromCache(i);
            Collections.shuffle(serverIpListFromCache);
            if (serverIpListFromCache.isEmpty()) {
                serverIpListFromCache = getServerIpListFromDb(context, i);
            }
            if (!serverIpListFromCache.isEmpty()) {
                for (int i2 = 0; i2 < 2 && i2 < serverIpListFromCache.size(); i2++) {
                    arrayList.add(serverIpListFromCache.get(i2));
                }
            }
            ArrayList serverIpListFromCache2 = getServerIpListFromCache(5);
            if (serverIpListFromCache2.isEmpty()) {
                serverIpListFromCache2 = getServerIpListFromDb(context, 5);
            }
            if (!serverIpListFromCache2.isEmpty()) {
                for (int i3 = 0; i3 < 1 && i3 < serverIpListFromCache2.size(); i3++) {
                    arrayList.add(serverIpListFromCache2.get(i3));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < this.mListUsedIsp.size(); i4++) {
                int intValue = ((Integer) this.mListUsedIsp.get(i4)).intValue();
                if (i != intValue) {
                    ArrayList serverIpListFromCache3 = getServerIpListFromCache(intValue);
                    if (serverIpListFromCache3.isEmpty()) {
                        serverIpListFromCache3 = getServerIpListFromDb(context, intValue);
                    }
                    if (!serverIpListFromCache3.isEmpty()) {
                        arrayList2.addAll(serverIpListFromCache3);
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                Collections.shuffle(arrayList2);
                arrayList.add(arrayList2.get(0));
            }
            if (arrayList.size() < 3) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    serverIpListFromCache.remove(arrayList.get(i5));
                }
                for (int i6 = 0; i6 < serverIpListFromCache.size() && arrayList.size() < 3; i6++) {
                    arrayList.add(serverIpListFromCache.get(i6));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public void initServerIP(Context context, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, str) == null) {
            curLocalDNSIp = RuntimeTools.execCmd(GlobalTools.CMD_GET_LOCALDNS_IP);
            initUsedIsp(str, context);
            ConcurrentMap concurrentMap = this.mIspServerIpCache;
            if (concurrentMap == null || concurrentMap.isEmpty()) {
                List allServer = DBAccessMgr.getInstance(context).getAllServer();
                if (allServer != null && !allServer.isEmpty()) {
                    for (int i = 0; i < allServer.size(); i++) {
                        if (this.mListUsedIsp.contains(Integer.valueOf(((ServerTB) allServer.get(i)).getIsp()))) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    addIspServerIpCache(allServer);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(5, SERVER_IP_PUBLIC);
                    if ("CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE)) {
                        hashMap.put(1, SERVER_IP_CTL);
                        hashMap.put(2, SERVER_IP_CNC);
                        hashMap.put(3, SERVER_IP_CMC);
                    } else {
                        hashMap.put(6, SERVER_IP_LOCALIZE);
                    }
                    for (int i2 = 0; i2 < this.mListUsedIsp.size(); i2++) {
                        int intValue = ((Integer) this.mListUsedIsp.get(i2)).intValue();
                        String[] strArr = (String[]) hashMap.get(Integer.valueOf(intValue));
                        if (strArr != null && strArr.length > 0) {
                            ArrayList arrayList = new ArrayList(strArr.length);
                            for (String str2 : strArr) {
                                ServerTB serverTB = new ServerTB();
                                serverTB.setIp(str2);
                                serverTB.setIsp(intValue);
                                serverTB.setVer(0);
                                arrayList.add(serverTB);
                            }
                            Collections.shuffle(arrayList);
                            this.mIspServerIpCache.putIfAbsent(Integer.valueOf(intValue), arrayList);
                        }
                    }
                    AsynTaskMgr.INSTANCE.post(new Runnable(this, context) { // from class: com.yy.gslbsdk.cache.ServerIPMgr.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ServerIPMgr this$0;
                        public final /* synthetic */ Context val$context;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$context = context;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(this.val$context);
                                List allServer2 = dBAccessMgr.getAllServer();
                                if (allServer2 != null && !allServer2.isEmpty()) {
                                    LogTools.printDebug(ServerIPMgr.TAG, String.format(Locale.US, "initServerIP db server ip is not empty, size is %d ", Integer.valueOf(allServer2.size())));
                                    return;
                                }
                                for (int i3 = 0; i3 < this.this$0.mListUsedIsp.size(); i3++) {
                                    List<ServerTB> list = (List) this.this$0.mIspServerIpCache.get(Integer.valueOf(((Integer) this.this$0.mListUsedIsp.get(i3)).intValue()));
                                    if (list != null && list.size() > 0) {
                                        for (ServerTB serverTB2 : list) {
                                            dBAccessMgr.addServer(serverTB2);
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            }
            LogTools.printDebug(TAG, "initServerIP...");
        }
    }

    public ArrayList getServerIPByUnKnownISP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean equalsIgnoreCase = "CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE);
            for (int i = 0; i < this.mListUsedIsp.size(); i++) {
                int intValue = ((Integer) this.mListUsedIsp.get(i)).intValue();
                ArrayList serverIpListFromCache = getServerIpListFromCache(intValue);
                if (serverIpListFromCache.isEmpty()) {
                    serverIpListFromCache = getServerIpListFromDb(context, intValue);
                }
                if (!serverIpListFromCache.isEmpty()) {
                    if (equalsIgnoreCase) {
                        Collections.shuffle(serverIpListFromCache);
                        for (int i2 = 0; i2 < 1 && i2 < serverIpListFromCache.size(); i2++) {
                            arrayList.add(serverIpListFromCache.get(i2));
                        }
                    } else if (intValue == 6) {
                        for (int i3 = 0; i3 < 2 && i3 < serverIpListFromCache.size(); i3++) {
                            arrayList.add(serverIpListFromCache.get(i3));
                        }
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            serverIpListFromCache.remove(arrayList.get(i4));
                        }
                        if (!serverIpListFromCache.isEmpty()) {
                            Collections.shuffle(serverIpListFromCache);
                            arrayList.add(serverIpListFromCache.get(0));
                        }
                    } else if (intValue == 5) {
                        arrayList.add(serverIpListFromCache.get(0));
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (equalsIgnoreCase) {
                arrayList2.add(5);
            } else {
                arrayList2.add(6);
            }
            if (arrayList.size() < 3) {
                for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                    int intValue2 = ((Integer) arrayList2.get(i5)).intValue();
                    ArrayList serverIpListFromCache2 = getServerIpListFromCache(intValue2);
                    if (serverIpListFromCache2.isEmpty()) {
                        serverIpListFromCache2 = getServerIpListFromDb(context, intValue2);
                    }
                    for (int i6 = 0; i6 < serverIpListFromCache2.size(); i6++) {
                        String str = (String) serverIpListFromCache2.get(i6);
                        if (!arrayList.contains(str)) {
                            arrayList.add(str);
                            if (arrayList.size() >= 3) {
                                break;
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public ArrayList getServerIpListFromCache(int i) {
        InterceptResult invokeI;
        ArrayList arrayList;
        ArrayList arrayList2;
        String ip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            ArrayList arrayList3 = new ArrayList();
            ConcurrentMap concurrentMap = this.mIspServerIpCache;
            if (concurrentMap != null && concurrentMap.containsKey(Integer.valueOf(i)) && (arrayList = (ArrayList) this.mIspServerIpCache.get(Integer.valueOf(i))) != null && !arrayList.isEmpty()) {
                synchronized (arrayList) {
                    arrayList2 = (ArrayList) arrayList.clone();
                }
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    ServerTB serverTB = (ServerTB) arrayList2.get(i2);
                    if (serverTB != null && (ip = serverTB.getIp()) != null) {
                        arrayList3.add(ip);
                    }
                }
            }
            return arrayList3;
        }
        return (ArrayList) invokeI.objValue;
    }

    public void initUsedIsp(String str, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, context) == null) {
            List list = this.mListUsedIsp;
            if (list == null) {
                this.mListUsedIsp = new LinkedList();
            } else {
                list.clear();
            }
            if ("CN".equalsIgnoreCase(str)) {
                this.mListUsedIsp.add(1);
                this.mListUsedIsp.add(2);
                this.mListUsedIsp.add(3);
                this.mListUsedIsp.add(4);
                this.mListUsedIsp.add(5);
                int isp = DeviceMgr.getISP(context);
                if (isp != 0 && this.mListUsedIsp.remove(Integer.valueOf(isp))) {
                    this.mListUsedIsp.add(0, Integer.valueOf(isp));
                    return;
                }
                return;
            }
            this.mListUsedIsp.add(6);
            this.mListUsedIsp.add(5);
        }
    }

    public int updateServerIP(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, context, str)) == null) {
            ThreadInfo threadInfo = new ThreadInfo("UpdateServerIP");
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper(this, str, context) { // from class: com.yy.gslbsdk.cache.ServerIPMgr.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ServerIPMgr this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ String val$ip;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$ip = str;
                    this.val$context = context;
                }

                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str2) {
                    boolean z;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                        String str3 = this.val$ip;
                        if (GlobalTools.HTTPS_LEVEL != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        String[] requestProtocol = UpdateServerProtocolMgr.requestProtocol(str3, z);
                        if (requestProtocol == null) {
                            LogTools.printError(ServerIPMgr.TAG, "update server ip request error");
                            return;
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (UpdateServerProtocolMgr.responseProtocol(requestProtocol[1], linkedHashMap) != 0 || ServerIPV6Mgr.getInstance().updateServerIP(this.val$context, requestProtocol[1]) != 0) {
                            return;
                        }
                        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(this.val$context);
                        List allServer = dBAccessMgr.getAllServer();
                        if (allServer != null && allServer.size() > 0) {
                            ServerTB serverTB = (ServerTB) allServer.get(0);
                            Iterator it = linkedHashMap.values().iterator();
                            if (!it.hasNext()) {
                                return;
                            }
                            UpdateServerInfo updateServerInfo = (UpdateServerInfo) it.next();
                            if (updateServerInfo.getVer() == serverTB.getVer()) {
                                LogTools.printDebug(ServerIPMgr.TAG, String.format(Locale.US, "updateServerIP version is same. ver: %d", Integer.valueOf(updateServerInfo.getVer())));
                                return;
                            }
                        }
                        ArrayList arrayList = new ArrayList(linkedHashMap.size());
                        for (Integer num : linkedHashMap.keySet()) {
                            UpdateServerInfo updateServerInfo2 = (UpdateServerInfo) linkedHashMap.get(Integer.valueOf(num.intValue()));
                            Iterator it2 = updateServerInfo2.getIps().iterator();
                            while (it2.hasNext()) {
                                ServerTB serverTB2 = new ServerTB();
                                serverTB2.setIp((String) it2.next());
                                serverTB2.setIsp(updateServerInfo2.getIsp());
                                serverTB2.setVer(updateServerInfo2.getVer());
                                dBAccessMgr.addServer(serverTB2);
                                arrayList.add(serverTB2);
                            }
                        }
                        this.this$0.mIspServerIpCache.clear();
                        this.this$0.addIspServerIpCache(arrayList);
                        dBAccessMgr.delSomeServer(allServer);
                        this.this$0.clearBestServerIPCache();
                    }
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
            return 0;
        }
        return invokeLL.intValue;
    }
}
