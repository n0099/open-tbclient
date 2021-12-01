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
import com.yy.gslbsdk.db.ServerV6TB;
import com.yy.gslbsdk.protocol.UpdateServerInfo;
import com.yy.gslbsdk.protocol.UpdateServerProtocolMgr;
import com.yy.gslbsdk.thread.AsynTaskMgr;
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
/* loaded from: classes3.dex */
public class ServerIPV6Mgr {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] SERVER_IP_CMC;
    public static final String[] SERVER_IP_CNC;
    public static final String[] SERVER_IP_CTL;
    public static final String[] SERVER_IP_EDU;
    public static final String[] SERVER_IP_LOCALIZE;
    public static final String[] SERVER_IP_PUBLIC;
    public static final String TAG = "ServerIPV6Mgr";
    public static String curLocalDNSIp;
    public static ServerIPV6Mgr mServerIPMgr;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<ServerIPInfo> mBestServerIpCache;
    public ConcurrentMap<Integer, ArrayList<ServerV6TB>> mIspServerIpCache;
    public List<Integer> mListUsedIsp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(941676198, "Lcom/yy/gslbsdk/cache/ServerIPV6Mgr;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(941676198, "Lcom/yy/gslbsdk/cache/ServerIPV6Mgr;");
                return;
            }
        }
        SERVER_IP_CTL = new String[]{"240E:E9:5005:11FF::7", "240e:83:600:100:9::2"};
        SERVER_IP_CNC = new String[]{"2408:873D:2012:200:FF::7", "2408:8706:0:102:9::2"};
        SERVER_IP_CMC = new String[]{"2409:8C20:1831:307:FF::7", "2409:8C00:8401:2:9::2"};
        SERVER_IP_EDU = new String[0];
        SERVER_IP_PUBLIC = new String[0];
        SERVER_IP_LOCALIZE = new String[0];
    }

    public ServerIPV6Mgr() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mListUsedIsp = null;
        this.mBestServerIpCache = new LinkedList<>();
        this.mIspServerIpCache = new ConcurrentHashMap();
    }

    private void addIspServerIpCache(List<ServerV6TB> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, list) == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ServerV6TB serverV6TB = list.get(i2);
                if (serverV6TB != null) {
                    int isp = serverV6TB.getIsp();
                    if (!this.mListUsedIsp.contains(Integer.valueOf(isp))) {
                        continue;
                    } else if (this.mIspServerIpCache.containsKey(Integer.valueOf(isp))) {
                        ArrayList<ServerV6TB> arrayList = this.mIspServerIpCache.get(Integer.valueOf(isp));
                        if (arrayList != null && !arrayList.isEmpty()) {
                            synchronized (arrayList) {
                                arrayList.add(serverV6TB);
                            }
                        }
                    } else {
                        ArrayList<ServerV6TB> arrayList2 = new ArrayList<>();
                        arrayList2.add(serverV6TB);
                        this.mIspServerIpCache.putIfAbsent(Integer.valueOf(isp), arrayList2);
                    }
                }
            }
        }
    }

    public static ServerIPV6Mgr getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (mServerIPMgr == null) {
                mServerIPMgr = new ServerIPV6Mgr();
            }
            return mServerIPMgr;
        }
        return (ServerIPV6Mgr) invokeV.objValue;
    }

    private ArrayList<String> getServerIpListFromDb(Context context, int i2) {
        InterceptResult invokeLI;
        String ip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, this, context, i2)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            List<ServerV6TB> serverV6ByIsp = DBAccessMgr.getInstance(context).getServerV6ByIsp(i2);
            if (serverV6ByIsp != null && !serverV6ByIsp.isEmpty()) {
                for (int i3 = 0; i3 < serverV6ByIsp.size(); i3++) {
                    ServerV6TB serverV6TB = serverV6ByIsp.get(i3);
                    if (serverV6TB != null && (ip = serverV6TB.getIp()) != null) {
                        arrayList.add(ip);
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public boolean canUpdate(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, context, i2)) == null) {
            List<ServerV6TB> allServerV6 = DBAccessMgr.getInstance(context).getAllServerV6();
            return (allServerV6 == null || allServerV6.isEmpty() || i2 <= allServerV6.get(0).getVer()) ? false : true;
        }
        return invokeLI.booleanValue;
    }

    public synchronized void clearBestServerIPCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                this.mBestServerIpCache.clear();
            }
        }
    }

    public synchronized LinkedList<ServerIPInfo> getBestServerIPCache() {
        InterceptResult invokeV;
        LinkedList<ServerIPInfo> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                linkedList = (LinkedList) this.mBestServerIpCache.clone();
            }
            return linkedList;
        }
        return (LinkedList) invokeV.objValue;
    }

    public String getOneServerIPByKnownISP(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i2)) == null) {
            ArrayList<String> serverIpListFromCache = getServerIpListFromCache(i2);
            if (serverIpListFromCache == null || serverIpListFromCache.isEmpty()) {
                serverIpListFromCache = getServerIpListFromDb(context, i2);
            }
            if (serverIpListFromCache == null || serverIpListFromCache.isEmpty()) {
                return null;
            }
            return serverIpListFromCache.get(0);
        }
        return (String) invokeLI.objValue;
    }

    public String getOneServerIPByUnKnownISP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            if (this.mListUsedIsp == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<Integer> list = this.mListUsedIsp;
            for (int i2 = 0; i2 < list.size(); i2++) {
                int intValue = list.get(i2).intValue();
                ArrayList<String> serverIpListFromCache = getServerIpListFromCache(intValue);
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.ArrayList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public ArrayList<String> getServerIPByKnownISP(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, context, i2)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> serverIpListFromCache = getServerIpListFromCache(i2);
            Collections.shuffle(serverIpListFromCache);
            if (serverIpListFromCache.isEmpty()) {
                serverIpListFromCache = getServerIpListFromDb(context, i2);
            }
            if (!serverIpListFromCache.isEmpty()) {
                for (int i3 = 0; i3 < 2 && i3 < serverIpListFromCache.size(); i3++) {
                    arrayList.add(serverIpListFromCache.get(i3));
                }
            }
            ArrayList<String> serverIpListFromCache2 = getServerIpListFromCache(5);
            if (serverIpListFromCache2.isEmpty()) {
                serverIpListFromCache2 = getServerIpListFromDb(context, 5);
            }
            if (!serverIpListFromCache2.isEmpty()) {
                for (int i4 = 0; i4 < 1 && i4 < serverIpListFromCache2.size(); i4++) {
                    arrayList.add(serverIpListFromCache2.get(i4));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i5 = 0; i5 < this.mListUsedIsp.size(); i5++) {
                int intValue = this.mListUsedIsp.get(i5).intValue();
                if (i2 != intValue) {
                    ArrayList<String> serverIpListFromCache3 = getServerIpListFromCache(intValue);
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
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    serverIpListFromCache.remove(arrayList.get(i6));
                }
                for (int i7 = 0; i7 < serverIpListFromCache.size() && arrayList.size() < 3; i7++) {
                    arrayList.add(serverIpListFromCache.get(i7));
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public ArrayList<String> getServerIPByUnKnownISP(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, context)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            boolean equalsIgnoreCase = "CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE);
            for (int i2 = 0; i2 < this.mListUsedIsp.size(); i2++) {
                int intValue = this.mListUsedIsp.get(i2).intValue();
                ArrayList<String> serverIpListFromCache = getServerIpListFromCache(intValue);
                if (serverIpListFromCache.isEmpty()) {
                    serverIpListFromCache = getServerIpListFromDb(context, intValue);
                }
                if (!serverIpListFromCache.isEmpty()) {
                    if (equalsIgnoreCase) {
                        Collections.shuffle(serverIpListFromCache);
                        for (int i3 = 0; i3 < 1 && i3 < serverIpListFromCache.size(); i3++) {
                            arrayList.add(serverIpListFromCache.get(i3));
                        }
                    } else if (intValue == 6) {
                        for (int i4 = 0; i4 < 2 && i4 < serverIpListFromCache.size(); i4++) {
                            arrayList.add(serverIpListFromCache.get(i4));
                        }
                        for (int i5 = 0; i5 < arrayList.size(); i5++) {
                            serverIpListFromCache.remove(arrayList.get(i5));
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
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    int intValue2 = ((Integer) arrayList2.get(i6)).intValue();
                    ArrayList<String> serverIpListFromCache2 = getServerIpListFromCache(intValue2);
                    if (serverIpListFromCache2.isEmpty()) {
                        serverIpListFromCache2 = getServerIpListFromDb(context, intValue2);
                    }
                    for (int i7 = 0; i7 < serverIpListFromCache2.size(); i7++) {
                        String str = serverIpListFromCache2.get(i7);
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

    public ArrayList<String> getServerIpListFromCache(int i2) {
        InterceptResult invokeI;
        ArrayList<ServerV6TB> arrayList;
        ArrayList arrayList2;
        String ip;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            ConcurrentMap<Integer, ArrayList<ServerV6TB>> concurrentMap = this.mIspServerIpCache;
            if (concurrentMap != null && concurrentMap.containsKey(Integer.valueOf(i2)) && (arrayList = this.mIspServerIpCache.get(Integer.valueOf(i2))) != null && !arrayList.isEmpty()) {
                synchronized (arrayList) {
                    arrayList2 = (ArrayList) arrayList.clone();
                }
                for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                    ServerV6TB serverV6TB = (ServerV6TB) arrayList2.get(i3);
                    if (serverV6TB != null && (ip = serverV6TB.getIp()) != null) {
                        arrayList3.add(ip);
                    }
                }
            }
            return arrayList3;
        }
        return (ArrayList) invokeI.objValue;
    }

    public void initServerIP(Context context, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            curLocalDNSIp = RuntimeTools.execCmd(GlobalTools.CMD_GET_LOCALDNS_IP);
            initUsedIsp(str);
            ConcurrentMap<Integer, ArrayList<ServerV6TB>> concurrentMap = this.mIspServerIpCache;
            if (concurrentMap == null || concurrentMap.isEmpty()) {
                List<ServerV6TB> allServerV6 = DBAccessMgr.getInstance(context).getAllServerV6();
                if (allServerV6 != null && !allServerV6.isEmpty()) {
                    for (int i2 = 0; i2 < allServerV6.size(); i2++) {
                        if (this.mListUsedIsp.contains(Integer.valueOf(allServerV6.get(i2).getIsp()))) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    addIspServerIpCache(allServerV6);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(5, SERVER_IP_PUBLIC);
                    if ("CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE)) {
                        hashMap.put(1, SERVER_IP_CTL);
                        hashMap.put(2, SERVER_IP_CNC);
                        hashMap.put(3, SERVER_IP_CMC);
                        hashMap.put(4, SERVER_IP_EDU);
                    } else {
                        hashMap.put(6, SERVER_IP_LOCALIZE);
                    }
                    for (int i3 = 0; i3 < this.mListUsedIsp.size(); i3++) {
                        int intValue = this.mListUsedIsp.get(i3).intValue();
                        String[] strArr = (String[]) hashMap.get(Integer.valueOf(intValue));
                        if (strArr != null && strArr.length > 0) {
                            ArrayList<ServerV6TB> arrayList = new ArrayList<>(strArr.length);
                            for (String str2 : strArr) {
                                ServerV6TB serverV6TB = new ServerV6TB();
                                serverV6TB.setIp(str2);
                                serverV6TB.setIsp(intValue);
                                serverV6TB.setVer(0);
                                arrayList.add(serverV6TB);
                            }
                            Collections.shuffle(arrayList);
                            this.mIspServerIpCache.putIfAbsent(Integer.valueOf(intValue), arrayList);
                        }
                    }
                    AsynTaskMgr.INSTANCE.post(new Runnable(this, context) { // from class: com.yy.gslbsdk.cache.ServerIPV6Mgr.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ServerIPV6Mgr this$0;
                        public final /* synthetic */ Context val$context;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, context};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
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
                                List<ServerV6TB> allServerV62 = dBAccessMgr.getAllServerV6();
                                if (allServerV62 != null && !allServerV62.isEmpty()) {
                                    LogTools.printDebug(ServerIPV6Mgr.TAG, String.format(Locale.US, "initServerIP db server ip is not empty, size is %d ", Integer.valueOf(allServerV62.size())));
                                    return;
                                }
                                for (int i4 = 0; i4 < this.this$0.mListUsedIsp.size(); i4++) {
                                    List<ServerV6TB> list = (List) this.this$0.mIspServerIpCache.get(Integer.valueOf(this.this$0.mListUsedIsp.get(i4).intValue()));
                                    if (list != null && list.size() > 0) {
                                        for (ServerV6TB serverV6TB2 : list) {
                                            dBAccessMgr.addServerV6(serverV6TB2);
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

    public void initUsedIsp(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            List<Integer> list = this.mListUsedIsp;
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
                return;
            }
            this.mListUsedIsp.add(6);
            this.mListUsedIsp.add(5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:9:0x0013, B:11:0x0019, B:13:0x0021, B:15:0x002f, B:16:0x0032, B:18:0x003b, B:20:0x004f, B:21:0x0055, B:23:0x005a), top: B:33:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void resetBestServerIPCache(ServerIPInfo serverIPInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, serverIPInfo) == null) {
            synchronized (this) {
                if (serverIPInfo != null) {
                    if (serverIPInfo.getIp() != null) {
                        Iterator<ServerIPInfo> it = this.mBestServerIpCache.iterator();
                        while (it.hasNext()) {
                            ServerIPInfo next = it.next();
                            if (next == null || next.getIp().equals(serverIPInfo.getIp())) {
                                it.remove();
                                break;
                            }
                            while (it.hasNext()) {
                            }
                        }
                        int i2 = 0;
                        int size = this.mBestServerIpCache.size();
                        while (true) {
                            if (i2 >= size) {
                                break;
                            } else if (serverIPInfo.getScore() < this.mBestServerIpCache.get(i2).getScore()) {
                                this.mBestServerIpCache.add(i2, serverIPInfo);
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 == size) {
                            this.mBestServerIpCache.add(serverIPInfo);
                        }
                    }
                }
            }
        }
    }

    public int updateServerIP(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, str)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (UpdateServerProtocolMgr.responseProtocolV6(str, linkedHashMap) != 0) {
                return 7;
            }
            DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
            List<ServerV6TB> allServerV6 = dBAccessMgr.getAllServerV6();
            if (allServerV6 != null && allServerV6.size() > 0) {
                ServerV6TB serverV6TB = allServerV6.get(0);
                Iterator it = linkedHashMap.values().iterator();
                if (!it.hasNext()) {
                    return 7;
                }
                UpdateServerInfo updateServerInfo = (UpdateServerInfo) it.next();
                if (updateServerInfo.getVer() == serverV6TB.getVer()) {
                    LogTools.printDebug(TAG, String.format(Locale.US, "updateServerIP version is same. ver: %d", Integer.valueOf(updateServerInfo.getVer())));
                    return 5;
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Integer num : linkedHashMap.keySet()) {
                UpdateServerInfo updateServerInfo2 = (UpdateServerInfo) linkedHashMap.get(Integer.valueOf(num.intValue()));
                Iterator<String> it2 = updateServerInfo2.getIps().iterator();
                while (it2.hasNext()) {
                    ServerV6TB serverV6TB2 = new ServerV6TB();
                    serverV6TB2.setIp(it2.next());
                    serverV6TB2.setIsp(updateServerInfo2.getIsp());
                    serverV6TB2.setVer(updateServerInfo2.getVer());
                    dBAccessMgr.addServerV6(serverV6TB2);
                    arrayList.add(serverV6TB2);
                }
            }
            this.mIspServerIpCache.clear();
            addIspServerIpCache(arrayList);
            dBAccessMgr.delSomeServerV6(allServerV6);
            clearBestServerIPCache();
            return 0;
        }
        return invokeLL.intValue;
    }
}
