package com.yy.gslbsdk.cache;

import android.content.Context;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.ServerV6TB;
import com.yy.gslbsdk.device.DeviceMgr;
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
/* loaded from: classes8.dex */
public class ServerIPV6Mgr {
    public static final String TAG = "ServerIPV6Mgr";
    public static String curLocalDNSIp;
    public static ServerIPV6Mgr mServerIPMgr;
    public static final String[] SERVER_IP_CTL = {"240E:E9:5005:11FF::7", "240e:83:600:100:9::2"};
    public static final String[] SERVER_IP_CNC = {"2408:873D:2012:200:FF::7", "2408:8706:0:7a02:9::4"};
    public static final String[] SERVER_IP_CMC = {"2409:8C20:1831:307:FF::7", "2409:8C00:8401:2:9::2"};
    public static final String[] SERVER_IP_EDU = new String[0];
    public static final String[] SERVER_IP_PUBLIC = new String[0];
    public static final String[] SERVER_IP_LOCALIZE = new String[0];
    public List<Integer> mListUsedIsp = null;
    public LinkedList<ServerIPInfo> mBestServerIpCache = new LinkedList<>();
    public ConcurrentMap<Integer, ArrayList<ServerV6TB>> mIspServerIpCache = new ConcurrentHashMap();

    public static ServerIPV6Mgr getInstance() {
        if (mServerIPMgr == null) {
            mServerIPMgr = new ServerIPV6Mgr();
        }
        return mServerIPMgr;
    }

    public synchronized void clearBestServerIPCache() {
        this.mBestServerIpCache.clear();
    }

    public synchronized LinkedList<ServerIPInfo> getBestServerIPCache() {
        return (LinkedList) this.mBestServerIpCache.clone();
    }

    private void addIspServerIpCache(List<ServerV6TB> list) {
        for (int i = 0; i < list.size(); i++) {
            ServerV6TB serverV6TB = list.get(i);
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

    public String getOneServerIPByUnKnownISP(Context context) {
        if (this.mListUsedIsp == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> list = this.mListUsedIsp;
        for (int i = 0; i < list.size(); i++) {
            int intValue = list.get(i).intValue();
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

    public ArrayList<String> getServerIpListFromCache(int i) {
        ArrayList<ServerV6TB> arrayList;
        ArrayList arrayList2;
        String ip;
        ArrayList<String> arrayList3 = new ArrayList<>();
        ConcurrentMap<Integer, ArrayList<ServerV6TB>> concurrentMap = this.mIspServerIpCache;
        if (concurrentMap != null && concurrentMap.containsKey(Integer.valueOf(i)) && (arrayList = this.mIspServerIpCache.get(Integer.valueOf(i))) != null && !arrayList.isEmpty()) {
            synchronized (arrayList) {
                arrayList2 = (ArrayList) arrayList.clone();
            }
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                ServerV6TB serverV6TB = (ServerV6TB) arrayList2.get(i2);
                if (serverV6TB != null && (ip = serverV6TB.getIp()) != null) {
                    arrayList3.add(ip);
                }
            }
        }
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015 A[Catch: all -> 0x005c, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:7:0x000f, B:9:0x0015, B:11:0x001d, B:13:0x002b, B:14:0x002e, B:16:0x0037, B:18:0x004b, B:19:0x0051, B:21:0x0056), top: B:28:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void resetBestServerIPCache(ServerIPInfo serverIPInfo) {
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
                int i = 0;
                int size = this.mBestServerIpCache.size();
                while (true) {
                    if (i >= size) {
                        break;
                    } else if (serverIPInfo.getScore() < this.mBestServerIpCache.get(i).getScore()) {
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

    private ArrayList<String> getServerIpListFromDb(Context context, int i) {
        String ip;
        ArrayList<String> arrayList = new ArrayList<>();
        List<ServerV6TB> serverV6ByIsp = DBAccessMgr.getInstance(context).getServerV6ByIsp(i);
        if (serverV6ByIsp != null && !serverV6ByIsp.isEmpty()) {
            for (int i2 = 0; i2 < serverV6ByIsp.size(); i2++) {
                ServerV6TB serverV6TB = serverV6ByIsp.get(i2);
                if (serverV6TB != null && (ip = serverV6TB.getIp()) != null) {
                    arrayList.add(ip);
                }
            }
        }
        return arrayList;
    }

    public boolean canUpdate(Context context, int i) {
        List<ServerV6TB> allServerV6 = DBAccessMgr.getInstance(context).getAllServerV6();
        if (allServerV6 == null || allServerV6.isEmpty() || i <= allServerV6.get(0).getVer()) {
            return false;
        }
        return true;
    }

    public String getOneServerIPByKnownISP(Context context, int i) {
        ArrayList<String> serverIpListFromCache = getServerIpListFromCache(i);
        if (serverIpListFromCache == null || serverIpListFromCache.isEmpty()) {
            serverIpListFromCache = getServerIpListFromDb(context, i);
        }
        if (serverIpListFromCache != null && !serverIpListFromCache.isEmpty()) {
            return serverIpListFromCache.get(0);
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    public ArrayList<String> getServerIPByKnownISP(Context context, int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> serverIpListFromCache = getServerIpListFromCache(i);
        Collections.shuffle(serverIpListFromCache);
        if (serverIpListFromCache.isEmpty()) {
            serverIpListFromCache = getServerIpListFromDb(context, i);
        }
        if (!serverIpListFromCache.isEmpty()) {
            for (int i2 = 0; i2 < 2 && i2 < serverIpListFromCache.size(); i2++) {
                arrayList.add(serverIpListFromCache.get(i2));
            }
        }
        ArrayList<String> serverIpListFromCache2 = getServerIpListFromCache(5);
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
            int intValue = this.mListUsedIsp.get(i4).intValue();
            if (i != intValue) {
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
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                serverIpListFromCache.remove(arrayList.get(i5));
            }
            for (int i6 = 0; i6 < serverIpListFromCache.size() && arrayList.size() < 3; i6++) {
                arrayList.add(serverIpListFromCache.get(i6));
            }
        }
        return arrayList;
    }

    public void initServerIP(final Context context, String str) {
        boolean z;
        curLocalDNSIp = RuntimeTools.execCmd(GlobalTools.CMD_GET_LOCALDNS_IP);
        initUsedIsp(str, context);
        ConcurrentMap<Integer, ArrayList<ServerV6TB>> concurrentMap = this.mIspServerIpCache;
        if (concurrentMap == null || concurrentMap.isEmpty()) {
            List<ServerV6TB> allServerV6 = DBAccessMgr.getInstance(context).getAllServerV6();
            if (allServerV6 != null && !allServerV6.isEmpty()) {
                for (int i = 0; i < allServerV6.size(); i++) {
                    if (this.mListUsedIsp.contains(Integer.valueOf(allServerV6.get(i).getIsp()))) {
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
                for (int i2 = 0; i2 < this.mListUsedIsp.size(); i2++) {
                    int intValue = this.mListUsedIsp.get(i2).intValue();
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
                AsynTaskMgr.INSTANCE.post(new Runnable() { // from class: com.yy.gslbsdk.cache.ServerIPV6Mgr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
                        List<ServerV6TB> allServerV62 = dBAccessMgr.getAllServerV6();
                        if (allServerV62 != null && !allServerV62.isEmpty()) {
                            LogTools.printDebug(ServerIPV6Mgr.TAG, String.format(Locale.US, "initServerIP db server ip is not empty, size is %d ", Integer.valueOf(allServerV62.size())));
                            return;
                        }
                        for (int i3 = 0; i3 < ServerIPV6Mgr.this.mListUsedIsp.size(); i3++) {
                            List<ServerV6TB> list = (List) ServerIPV6Mgr.this.mIspServerIpCache.get(Integer.valueOf(ServerIPV6Mgr.this.mListUsedIsp.get(i3).intValue()));
                            if (list != null && list.size() > 0) {
                                for (ServerV6TB serverV6TB2 : list) {
                                    dBAccessMgr.addServerV6(serverV6TB2);
                                }
                            }
                        }
                    }
                });
            }
        }
        LogTools.printDebug(TAG, "initServerIP...");
    }

    public int updateServerIP(Context context, String str) {
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

    public ArrayList<String> getServerIPByUnKnownISP(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        boolean equalsIgnoreCase = "CN".equalsIgnoreCase(GlobalTools.APP_LOCALIZE_CODE);
        for (int i = 0; i < this.mListUsedIsp.size(); i++) {
            int intValue = this.mListUsedIsp.get(i).intValue();
            ArrayList<String> serverIpListFromCache = getServerIpListFromCache(intValue);
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
                ArrayList<String> serverIpListFromCache2 = getServerIpListFromCache(intValue2);
                if (serverIpListFromCache2.isEmpty()) {
                    serverIpListFromCache2 = getServerIpListFromDb(context, intValue2);
                }
                for (int i6 = 0; i6 < serverIpListFromCache2.size(); i6++) {
                    String str = serverIpListFromCache2.get(i6);
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

    public void initUsedIsp(String str, Context context) {
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
