package com.yy.gslbsdk.control;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.cache.DataV6CacheMgr;
import com.yy.gslbsdk.cache.ServerIPInfo;
import com.yy.gslbsdk.cache.ServerIPMgr;
import com.yy.gslbsdk.cache.ServerIPV6Mgr;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.ResultTB;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class IpVersionController {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IPV4_AND_V6 = "ipv4+v6";
    public static final String IPV4_BIZ = "ipv4-biz";
    public static final String IPV4_ONLY = "ipv4-only";
    public static final String IPV6_BIZ = "ipv6-biz";
    public static final String IPV6_ONLY = "ipv6-only";
    public static final int NUM_V4_IP = 2;
    public static final int NUM_V6_IP = 1;
    public static final String TAG = "IpVersionController";
    public static IpVersionController sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrIpVer;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1943902324, "Lcom/yy/gslbsdk/control/IpVersionController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1943902324, "Lcom/yy/gslbsdk/control/IpVersionController;");
        }
    }

    public IpVersionController() {
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
        this.mCurrIpVer = 0;
    }

    public static IpVersionController getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sInstance == null) {
                sInstance = new IpVersionController();
            }
            return sInstance;
        }
        return (IpVersionController) invokeV.objValue;
    }

    public void clearBestServerIPCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ServerIPV6Mgr.getInstance().clearBestServerIPCache();
            ServerIPMgr.getInstance().clearBestServerIPCache();
        }
    }

    public int getCurrIpVer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mCurrIpVer == 0) {
                judgeIpVersion();
            }
            return this.mCurrIpVer;
        }
        return invokeV.intValue;
    }

    public String getCurrIpVerStr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int currIpVer = getCurrIpVer();
            if (currIpVer != 1) {
                if (currIpVer != 2) {
                    if (currIpVer != 3) {
                        return "unknown";
                    }
                    return IPV4_AND_V6;
                }
                return IPV6_ONLY;
            }
            return IPV4_ONLY;
        }
        return (String) invokeV.objValue;
    }

    public boolean isIpv4AndIpv6() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (getCurrIpVer() == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIpv4Only() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (getCurrIpVer() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isIpv6Only() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (getCurrIpVer() == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static Map filterIpVer(List list) {
        InterceptResult invokeL;
        LinkedList linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    String str = (String) list.get(i);
                    int tellIpVer = tellIpVer(str);
                    if (tellIpVer == 6) {
                        linkedList = linkedList3;
                    } else if (tellIpVer == 4) {
                        linkedList = linkedList2;
                    } else {
                        linkedList = new LinkedList();
                    }
                    linkedList.add(str);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(4, linkedList2);
            hashMap.put(6, linkedList3);
            LogTools.printDebug(TAG, String.format(Locale.US, "filterIpVer listV4 : %s, listV6 : %s, all: %s", linkedList2.toString(), linkedList3.toString(), list.toString()));
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0065 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x002a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List getCurrentIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    String name = nextElement.getName();
                    if (!name.contains("usb")) {
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress nextElement2 = inetAddresses.nextElement();
                            if (!nextElement2.isLoopbackAddress() && !nextElement2.isLinkLocalAddress()) {
                                boolean z = false;
                                if (arrayList.size() < 1) {
                                    arrayList.add(name);
                                } else {
                                    String str = (String) arrayList.get(0);
                                    if (str != null && str.equals(name)) {
                                    }
                                    String hostAddress = nextElement2.getHostAddress();
                                    if (!z) {
                                        arrayList.add(hostAddress);
                                    }
                                }
                                z = true;
                                String hostAddress2 = nextElement2.getHostAddress();
                                if (!z) {
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                LogTools.printWarning(TAG, e);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void judgeIpVersion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            List currentIp = getCurrentIp();
            LogTools.printDebug(TAG, String.format(Locale.US, "judgeIpVersion listIp: %s", currentIp.toString()));
            this.mCurrIpVer = 0;
            for (int i = 0; i < currentIp.size(); i++) {
                int tellIpVer = tellIpVer((String) currentIp.get(i));
                if (tellIpVer == 4) {
                    this.mCurrIpVer |= 1;
                } else if (tellIpVer == 6) {
                    this.mCurrIpVer |= 2;
                }
            }
            if (currentIp.size() > 0 && this.mCurrIpVer != 0) {
                LogTools.printDebug(TAG, String.format(Locale.US, "judgeIpVersion ip version: %s", getCurrIpVerStr()));
            }
        }
    }

    public static int tellIpVer(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str.contains(":")) {
                return 6;
            }
            if (7 <= str.length() && str.length() <= 15) {
                int i = 0;
                while (true) {
                    if (i < str.length()) {
                        if (str.charAt(i) != '.' && !Character.isDigit(str.charAt(i))) {
                            z = false;
                            break;
                        }
                        i++;
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return 4;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public int delResult(ResultTB resultTB) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, resultTB)) == null) {
            int tellIpVer = tellIpVer(resultTB.getIp());
            if (tellIpVer == 6) {
                return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).delResultV6(resultTB);
            }
            if (tellIpVer == 4) {
                return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).delResult(resultTB);
            }
            LogTools.printError(TAG, String.format(Locale.US, "tell ip version failed! %s", resultTB.getIp()));
            return 0;
        }
        return invokeL.intValue;
    }

    public int delResultByHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).delResultV6ByHost(str) + 0 + DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).delResultByHost(str);
        }
        return invokeL.intValue;
    }

    public void deleteHttpDNSFromMemCache(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            DataV6CacheMgr.INSTANCE.deleteHttpDNSFromMemCache(str);
            DataCacheMgr.INSTANCE.deleteHttpDNSFromMemCache(str);
        }
    }

    public void resetBestServerIPCache(ServerIPInfo serverIPInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, serverIPInfo) == null) {
            if (tellIpVer(serverIPInfo.getIp()) == 6) {
                ServerIPV6Mgr.getInstance().resetBestServerIPCache(serverIPInfo);
            } else {
                ServerIPMgr.getInstance().resetBestServerIPCache(serverIPInfo);
            }
        }
    }

    public void setEnableIpv6(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            NetworkStatus.updateEnableV6(z);
            DataCacheMgr.INSTANCE.getCachedNetStatusInfo().setNetworkStatus(NetworkStatus.getInstanceClone());
        }
    }

    public void setNetworkStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            NetworkStatus.updateStatus(i);
            DataCacheMgr.INSTANCE.getCachedNetStatusInfo().setNetworkStatus(NetworkStatus.getInstanceClone());
        }
    }

    public ConcurrentHashMap getAllLocalDNSFromCache() {
        InterceptResult invokeV;
        ConcurrentHashMap concurrentHashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (NetworkStatus.getInstanceClone().canV6()) {
                concurrentHashMap = DataV6CacheMgr.INSTANCE.getAllLocalDNSFromCache();
            } else {
                concurrentHashMap = null;
            }
            if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                return DataCacheMgr.INSTANCE.getAllLocalDNSFromCache();
            }
            return concurrentHashMap;
        }
        return (ConcurrentHashMap) invokeV.objValue;
    }

    public ArrayList getBestServerIPCache(NetworkStatus networkStatus) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, networkStatus)) == null) {
            LogTools.printDebug(TAG, String.format(Locale.US, "getBestServerIPCache NetworkStatus: %s", networkStatus.toString()));
            ArrayList arrayList = new ArrayList();
            if (networkStatus.canV6()) {
                LinkedList bestServerIPCache = ServerIPV6Mgr.getInstance().getBestServerIPCache();
                if (!bestServerIPCache.isEmpty()) {
                    if (networkStatus.canV4()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    for (int i2 = 0; i2 < bestServerIPCache.size() && i2 < i; i2++) {
                        String ip = ((ServerIPInfo) bestServerIPCache.get(i2)).getIp();
                        if (ip != null && ip.trim().length() >= 1) {
                            arrayList.add(ip);
                        }
                    }
                }
            }
            if (networkStatus.canV4()) {
                LinkedList bestServerIPCache2 = ServerIPMgr.getInstance().getBestServerIPCache();
                if (!bestServerIPCache2.isEmpty()) {
                    for (int i3 = 0; i3 < bestServerIPCache2.size() && i3 < 2; i3++) {
                        String ip2 = ((ServerIPInfo) bestServerIPCache2.get(i3)).getIp();
                        if (ip2 != null && ip2.trim().length() >= 1) {
                            arrayList.add(ip2);
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public int getHttpDNSFromCache(Context context, NetStatusInfo netStatusInfo, String str, DnsInfo dnsInfo) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, netStatusInfo, str, dnsInfo)) == null) {
            LogTools.printDebug(TAG, String.format(Locale.US, "getHttpDNSFromCache getCurrIpVerStr: %s, netId: %s, NetworkStatus: %s", getCurrIpVerStr(), netStatusInfo.getNetStatusID(), Integer.valueOf(netStatusInfo.getNetworkStatus().getStatus())));
            DnsInfo dnsInfo2 = new DnsInfo();
            int httpDNSFromCache = DataCacheMgr.INSTANCE.getHttpDNSFromCache(context, netStatusInfo.getNetStatusID(), str, dnsInfo2);
            DnsInfo dnsInfo3 = new DnsInfo();
            int httpDNSFromCache2 = DataV6CacheMgr.INSTANCE.getHttpDNSFromCache(context, netStatusInfo.getNetStatusID(), str, dnsInfo3);
            long max = Math.max(dnsInfo2.getEndTime(), dnsInfo3.getEndTime());
            if (httpDNSFromCache2 == 0) {
                dnsInfo.cloneDnsInfo(dnsInfo3);
                dnsInfo.getIps().addAll(dnsInfo2.getIps());
                dnsInfo.setEndTime(max);
            } else if (httpDNSFromCache != 0) {
                return 2;
            } else {
                dnsInfo.cloneDnsInfo(dnsInfo2);
                dnsInfo.getIps().addAll(dnsInfo3.getIps());
                dnsInfo.setEndTime(max);
            }
            return 0;
        }
        return invokeLLLL.intValue;
    }

    public int getLocalDNSFromCache(String str, DnsInfo dnsInfo) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, str, dnsInfo)) == null) {
            NetworkStatus instanceClone = NetworkStatus.getInstanceClone();
            if (instanceClone.canV6()) {
                i = DataV6CacheMgr.INSTANCE.getLocalDNSFromCache(str, dnsInfo);
            } else {
                i = 2;
            }
            if (i != 0 && instanceClone.canV4()) {
                return DataCacheMgr.INSTANCE.getLocalDNSFromCache(str, dnsInfo);
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public String getOneServerIPByUnKnownISP(Context context, NetworkStatus networkStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, context, networkStatus)) == null) {
            if (networkStatus.canV6()) {
                return ServerIPV6Mgr.getInstance().getOneServerIPByUnKnownISP(context);
            }
            return ServerIPMgr.getInstance().getOneServerIPByUnKnownISP(context);
        }
        return (String) invokeLL.objValue;
    }

    public String getOneServerIPByKnownISP(Context context, int i, NetworkStatus networkStatus) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048586, this, context, i, networkStatus)) == null) {
            if (networkStatus.canV6()) {
                return ServerIPV6Mgr.getInstance().getOneServerIPByKnownISP(context, i);
            }
            return ServerIPMgr.getInstance().getOneServerIPByKnownISP(context, i);
        }
        return (String) invokeLIL.objValue;
    }

    public List getResultByNetworkHost(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048588, this, str, str2, i)) == null) {
            if (1 == i) {
                return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).getResultByNetworkHost(str, str2);
            }
            if (2 == i) {
                return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).getResultV6ByNetworkHost(str, str2);
            }
            return null;
        }
        return (List) invokeLLI.objValue;
    }

    public List getResultByNetworkHost(String str, String str2, NetworkStatus networkStatus) {
        InterceptResult invokeLLL;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, str, str2, networkStatus)) == null) {
            if (networkStatus.canV6()) {
                list = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).getResultV6ByNetworkHost(str, str2);
            } else {
                list = null;
            }
            if (list == null || list.isEmpty()) {
                return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).getResultByNetworkHost(str, str2);
            }
            return list;
        }
        return (List) invokeLLL.objValue;
    }

    public ArrayList getServerIPByKnownISP(Context context, int i, NetworkStatus networkStatus) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048590, this, context, i, networkStatus)) == null) {
            ArrayList arrayList = new ArrayList();
            if (networkStatus.canV6()) {
                arrayList.addAll(ServerIPV6Mgr.getInstance().getServerIPByKnownISP(context, i));
            }
            if (networkStatus.canV4()) {
                arrayList.addAll(ServerIPMgr.getInstance().getServerIPByKnownISP(context, i));
            }
            return arrayList;
        }
        return (ArrayList) invokeLIL.objValue;
    }

    public ArrayList getServerIPByUnKnownISP(Context context, NetworkStatus networkStatus) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, networkStatus)) == null) {
            ArrayList arrayList = new ArrayList();
            if (networkStatus.canV6()) {
                arrayList.addAll(ServerIPV6Mgr.getInstance().getServerIPByUnKnownISP(context));
            }
            if (networkStatus.canV4()) {
                arrayList.addAll(ServerIPMgr.getInstance().getServerIPByUnKnownISP(context));
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public int putHttpDNSIntoCache(Context context, ResInfo resInfo) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, context, resInfo)) == null) {
            if (resInfo == null) {
                return 2;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            LinkedHashMap dns = resInfo.getDns();
            Iterator it = dns.keySet().iterator();
            while (true) {
                boolean z2 = false;
                if (it.hasNext()) {
                    String str = (String) it.next();
                    DnsInfo dnsInfo = (DnsInfo) dns.get(str);
                    LinkedList ips = dnsInfo.getIps();
                    if (ips != null && !ips.isEmpty()) {
                        LinkedList linkedList = new LinkedList();
                        LinkedList linkedList2 = new LinkedList();
                        Iterator it2 = ips.iterator();
                        while (it2.hasNext()) {
                            String str2 = (String) it2.next();
                            if (!TextUtils.isEmpty(str2)) {
                                int tellIpVer = tellIpVer(str2);
                                if (tellIpVer == 4) {
                                    linkedList.add(str2);
                                } else if (tellIpVer == 6) {
                                    linkedList2.add(str2);
                                }
                            }
                        }
                        if (!linkedList.isEmpty() && linkedList2.isEmpty()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (linkedList.isEmpty() && !linkedList2.isEmpty()) {
                            z2 = true;
                        }
                        if (!z2) {
                            DnsInfo dnsInfo2 = new DnsInfo();
                            dnsInfo2.cloneDnsInfo(dnsInfo);
                            dnsInfo2.setIps(linkedList);
                            linkedHashMap.put(str, dnsInfo2);
                        }
                        if (!z) {
                            DnsInfo dnsInfo3 = new DnsInfo();
                            dnsInfo3.cloneDnsInfo(dnsInfo);
                            dnsInfo3.setIps(linkedList2);
                            linkedHashMap2.put(str, dnsInfo3);
                        }
                    } else if (dnsInfo.getStatus() == 6) {
                        linkedHashMap.put(str, dnsInfo);
                        linkedHashMap2.put(str, dnsInfo);
                    }
                } else {
                    ResInfo resInfo2 = new ResInfo();
                    resInfo2.updateResInfo(resInfo);
                    resInfo2.setDns(linkedHashMap);
                    DataCacheMgr.INSTANCE.putHttpDNSIntoCache(context, resInfo2);
                    ResInfo resInfo3 = new ResInfo();
                    resInfo3.updateResInfo(resInfo);
                    resInfo3.setDns(linkedHashMap2);
                    DataV6CacheMgr.INSTANCE.putHttpDNSIntoCache(context, resInfo3);
                    return 0;
                }
            }
        } else {
            return invokeLL.intValue;
        }
    }

    public void putLocalDNSIntoCache(DnsInfo dnsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dnsInfo) == null) {
            String str = (String) dnsInfo.getIps().get(0);
            int tellIpVer = tellIpVer(str);
            if (tellIpVer == 6) {
                DataV6CacheMgr.INSTANCE.putLocalDNSIntoCache(dnsInfo);
            } else if (tellIpVer == 4) {
                DataCacheMgr.INSTANCE.putLocalDNSIntoCache(dnsInfo);
            } else {
                LogTools.printWarning(TAG, String.format(Locale.US, "tell ip version failed! %s", str));
            }
        }
    }
}
