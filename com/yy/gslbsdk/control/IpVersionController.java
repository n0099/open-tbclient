package com.yy.gslbsdk.control;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes9.dex */
public class IpVersionController {
    public static final String IPV4_AND_V6 = "ipv4+v6";
    public static final String IPV4_BIZ = "ipv4-biz";
    public static final String IPV4_ONLY = "ipv4-only";
    public static final String IPV6_BIZ = "ipv6-biz";
    public static final String IPV6_ONLY = "ipv6-only";
    public static final int NUM_V4_IP = 2;
    public static final int NUM_V6_IP = 1;
    public static final String TAG = "IpVersionController";
    public static IpVersionController sInstance;
    public int mCurrIpVer = 0;

    public static IpVersionController getInstance() {
        if (sInstance == null) {
            sInstance = new IpVersionController();
        }
        return sInstance;
    }

    public void clearBestServerIPCache() {
        ServerIPV6Mgr.getInstance().clearBestServerIPCache();
        ServerIPMgr.getInstance().clearBestServerIPCache();
    }

    public ConcurrentHashMap<String, DnsInfo> getAllLocalDNSFromCache() {
        ConcurrentHashMap<String, DnsInfo> concurrentHashMap;
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

    public int getCurrIpVer() {
        if (this.mCurrIpVer == 0) {
            judgeIpVersion();
        }
        return this.mCurrIpVer;
    }

    public String getCurrIpVerStr() {
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

    public boolean isIpv4AndIpv6() {
        if (getCurrIpVer() == 3) {
            return true;
        }
        return false;
    }

    public boolean isIpv4Only() {
        if (getCurrIpVer() == 1) {
            return true;
        }
        return false;
    }

    public boolean isIpv6Only() {
        if (getCurrIpVer() == 2) {
            return true;
        }
        return false;
    }

    public static Map<Integer, List<String>> filterIpVer(List<String> list) {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
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

    /* JADX WARN: Removed duplicated region for block: B:44:0x0061 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0026 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> getCurrentIp() {
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

    public static int tellIpVer(String str) {
        boolean z;
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

    public int delResult(ResultTB resultTB) {
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

    public void putLocalDNSIntoCache(DnsInfo dnsInfo) {
        String str = dnsInfo.getIps().get(0);
        int tellIpVer = tellIpVer(str);
        if (tellIpVer == 6) {
            DataV6CacheMgr.INSTANCE.putLocalDNSIntoCache(dnsInfo);
        } else if (tellIpVer == 4) {
            DataCacheMgr.INSTANCE.putLocalDNSIntoCache(dnsInfo);
        } else {
            LogTools.printWarning(TAG, String.format(Locale.US, "tell ip version failed! %s", str));
        }
    }

    public int delResultByHost(String str) {
        return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).delResultV6ByHost(str) + 0 + DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).delResultByHost(str);
    }

    public void deleteHttpDNSFromMemCache(String str) {
        DataV6CacheMgr.INSTANCE.deleteHttpDNSFromMemCache(str);
        DataCacheMgr.INSTANCE.deleteHttpDNSFromMemCache(str);
    }

    public void resetBestServerIPCache(ServerIPInfo serverIPInfo) {
        if (tellIpVer(serverIPInfo.getIp()) == 6) {
            ServerIPV6Mgr.getInstance().resetBestServerIPCache(serverIPInfo);
        } else {
            ServerIPMgr.getInstance().resetBestServerIPCache(serverIPInfo);
        }
    }

    public void setEnableIpv6(boolean z) {
        NetworkStatus.updateEnableV6(z);
        DataCacheMgr.INSTANCE.getCachedNetStatusInfo().setNetworkStatus(NetworkStatus.getInstanceClone());
    }

    public void setNetworkStatus(int i) {
        NetworkStatus.updateStatus(i);
        DataCacheMgr.INSTANCE.getCachedNetStatusInfo().setNetworkStatus(NetworkStatus.getInstanceClone());
    }

    public ArrayList<String> getBestServerIPCache(NetworkStatus networkStatus) {
        int i;
        LogTools.printDebug(TAG, String.format(Locale.US, "getBestServerIPCache NetworkStatus: %s", networkStatus.toString()));
        ArrayList<String> arrayList = new ArrayList<>();
        if (networkStatus.canV6()) {
            LinkedList<ServerIPInfo> bestServerIPCache = ServerIPV6Mgr.getInstance().getBestServerIPCache();
            if (!bestServerIPCache.isEmpty()) {
                if (networkStatus.canV4()) {
                    i = 1;
                } else {
                    i = 2;
                }
                for (int i2 = 0; i2 < bestServerIPCache.size() && i2 < i; i2++) {
                    String ip = bestServerIPCache.get(i2).getIp();
                    if (ip != null && ip.trim().length() >= 1) {
                        arrayList.add(ip);
                    }
                }
            }
        }
        if (networkStatus.canV4()) {
            LinkedList<ServerIPInfo> bestServerIPCache2 = ServerIPMgr.getInstance().getBestServerIPCache();
            if (!bestServerIPCache2.isEmpty()) {
                for (int i3 = 0; i3 < bestServerIPCache2.size() && i3 < 2; i3++) {
                    String ip2 = bestServerIPCache2.get(i3).getIp();
                    if (ip2 != null && ip2.trim().length() >= 1) {
                        arrayList.add(ip2);
                    }
                }
            }
        }
        return arrayList;
    }

    public int getHttpDNSFromCache(Context context, NetStatusInfo netStatusInfo, String str, DnsInfo dnsInfo) {
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

    public int getLocalDNSFromCache(String str, DnsInfo dnsInfo) {
        int i;
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

    public String getOneServerIPByUnKnownISP(Context context, NetworkStatus networkStatus) {
        if (networkStatus.canV6()) {
            return ServerIPV6Mgr.getInstance().getOneServerIPByUnKnownISP(context);
        }
        return ServerIPMgr.getInstance().getOneServerIPByUnKnownISP(context);
    }

    public ArrayList<String> getServerIPByUnKnownISP(Context context, NetworkStatus networkStatus) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (networkStatus.canV6()) {
            arrayList.addAll(ServerIPV6Mgr.getInstance().getServerIPByUnKnownISP(context));
        }
        if (networkStatus.canV4()) {
            arrayList.addAll(ServerIPMgr.getInstance().getServerIPByUnKnownISP(context));
        }
        return arrayList;
    }

    public String getOneServerIPByKnownISP(Context context, int i, NetworkStatus networkStatus) {
        if (networkStatus.canV6()) {
            return ServerIPV6Mgr.getInstance().getOneServerIPByKnownISP(context, i);
        }
        return ServerIPMgr.getInstance().getOneServerIPByKnownISP(context, i);
    }

    public List<ResultTB> getResultByNetworkHost(String str, String str2, int i) {
        if (1 == i) {
            return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).getResultByNetworkHost(str, str2);
        }
        if (2 == i) {
            return DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT).getResultV6ByNetworkHost(str, str2);
        }
        return null;
    }

    public ArrayList<String> getServerIPByKnownISP(Context context, int i, NetworkStatus networkStatus) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (networkStatus.canV6()) {
            arrayList.addAll(ServerIPV6Mgr.getInstance().getServerIPByKnownISP(context, i));
        }
        if (networkStatus.canV4()) {
            arrayList.addAll(ServerIPMgr.getInstance().getServerIPByKnownISP(context, i));
        }
        return arrayList;
    }

    public List<ResultTB> getResultByNetworkHost(String str, String str2, NetworkStatus networkStatus) {
        List<ResultTB> list;
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

    public void judgeIpVersion() {
        List<String> currentIp = getCurrentIp();
        LogTools.printDebug(TAG, String.format(Locale.US, "judgeIpVersion listIp: %s", currentIp.toString()));
        this.mCurrIpVer = 0;
        for (int i = 0; i < currentIp.size(); i++) {
            int tellIpVer = tellIpVer(currentIp.get(i));
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

    public int putHttpDNSIntoCache(Context context, ResInfo resInfo) {
        boolean z;
        if (resInfo == null) {
            return 2;
        }
        LinkedHashMap<String, DnsInfo> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, DnsInfo> linkedHashMap2 = new LinkedHashMap<>();
        LinkedHashMap<String, DnsInfo> dns = resInfo.getDns();
        Iterator<String> it = dns.keySet().iterator();
        while (true) {
            boolean z2 = false;
            if (it.hasNext()) {
                String next = it.next();
                DnsInfo dnsInfo = dns.get(next);
                LinkedList<String> ips = dnsInfo.getIps();
                if (ips != null && !ips.isEmpty()) {
                    LinkedList<String> linkedList = new LinkedList<>();
                    LinkedList<String> linkedList2 = new LinkedList<>();
                    Iterator<String> it2 = ips.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        if (!TextUtils.isEmpty(next2)) {
                            int tellIpVer = tellIpVer(next2);
                            if (tellIpVer == 4) {
                                linkedList.add(next2);
                            } else if (tellIpVer == 6) {
                                linkedList2.add(next2);
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
                        linkedHashMap.put(next, dnsInfo2);
                    }
                    if (!z) {
                        DnsInfo dnsInfo3 = new DnsInfo();
                        dnsInfo3.cloneDnsInfo(dnsInfo);
                        dnsInfo3.setIps(linkedList2);
                        linkedHashMap2.put(next, dnsInfo3);
                    }
                } else if (dnsInfo.getStatus() == 6) {
                    linkedHashMap.put(next, dnsInfo);
                    linkedHashMap2.put(next, dnsInfo);
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
    }
}
