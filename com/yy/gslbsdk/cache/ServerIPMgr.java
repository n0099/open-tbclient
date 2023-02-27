package com.yy.gslbsdk.cache;

import android.content.Context;
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
    public static final String TAG = "ServerIPMgr";
    public static String curLocalDNSIp = null;
    public static ServerIPMgr mServerIPMgr = null;
    public static String reportUrl = "";
    public static final String[] SERVER_IP_CTL = {"221.228.209.120", "183.36.121.65", "59.36.239.133", "106.38.197.33"};
    public static final String[] SERVER_IP_CNC = {"122.97.255.32", "58.251.123.214", "27.36.226.132", "123.125.184.139"};
    public static final String[] SERVER_IP_CMC = {"120.195.158.62", "120.197.129.137", "120.241.148.226", "111.13.164.42"};
    public static final String[] SERVER_IP_EDU = {"59.78.210.113"};
    public static final String[] SERVER_IP_PUBLIC = new String[0];
    public static final String[] SERVER_IP_LOCALIZE = new String[0];
    public List<Integer> mListUsedIsp = null;
    public LinkedList<ServerIPInfo> mBestServerIpCache = new LinkedList<>();
    public ConcurrentMap<Integer, ArrayList<ServerTB>> mIspServerIpCache = new ConcurrentHashMap();

    public static ServerIPMgr getInstance() {
        if (mServerIPMgr == null) {
            mServerIPMgr = new ServerIPMgr();
        }
        return mServerIPMgr;
    }

    public synchronized void clearBestServerIPCache() {
        this.mBestServerIpCache.clear();
    }

    public synchronized LinkedList<ServerIPInfo> getBestServerIPCache() {
        return (LinkedList) this.mBestServerIpCache.clone();
    }

    public ConcurrentMap<Integer, ArrayList<ServerTB>> getIspServerIpCache() {
        return this.mIspServerIpCache;
    }

    public int updateServerIpByLocalDns(Context context) {
        return updateServerIP(context, GlobalTools.HTTPDNS_SERVER_HOST);
    }

    private ArrayList<String> getServerIpListFromDb(Context context, int i) {
        String ip;
        ArrayList<String> arrayList = new ArrayList<>();
        List<ServerTB> serverByIsp = DBAccessMgr.getInstance(context).getServerByIsp(i);
        if (serverByIsp != null && !serverByIsp.isEmpty()) {
            for (int i2 = 0; i2 < serverByIsp.size(); i2++) {
                ServerTB serverTB = serverByIsp.get(i2);
                if (serverTB != null && (ip = serverTB.getIp()) != null) {
                    arrayList.add(ip);
                }
            }
        }
        return arrayList;
    }

    public void addIspServerIpCache(List<ServerTB> list) {
        for (int i = 0; i < list.size(); i++) {
            ServerTB serverTB = list.get(i);
            if (serverTB != null) {
                int isp = serverTB.getIsp();
                if (!this.mListUsedIsp.contains(Integer.valueOf(isp))) {
                    continue;
                } else if (this.mIspServerIpCache.containsKey(Integer.valueOf(isp))) {
                    ArrayList<ServerTB> arrayList = this.mIspServerIpCache.get(Integer.valueOf(isp));
                    if (arrayList != null && !arrayList.isEmpty()) {
                        synchronized (arrayList) {
                            arrayList.add(serverTB);
                        }
                    }
                } else {
                    ArrayList<ServerTB> arrayList2 = new ArrayList<>();
                    arrayList2.add(serverTB);
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
        ArrayList<ServerTB> arrayList;
        ArrayList arrayList2;
        String ip;
        ArrayList<String> arrayList3 = new ArrayList<>();
        ConcurrentMap<Integer, ArrayList<ServerTB>> concurrentMap = this.mIspServerIpCache;
        if (concurrentMap != null && concurrentMap.containsKey(Integer.valueOf(i)) && (arrayList = this.mIspServerIpCache.get(Integer.valueOf(i))) != null && !arrayList.isEmpty()) {
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

    public boolean canUpdate(Context context, int i) {
        ServerTB serverTB;
        List<ServerTB> allServer = DBAccessMgr.getInstance(context).getAllServer();
        if (allServer == null || allServer.isEmpty() || (serverTB = allServer.get(0)) == null || i <= serverTB.getVer()) {
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

    public int updateServerIP(final Context context, final String str) {
        ThreadInfo threadInfo = new ThreadInfo("UpdateServerIP");
        threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.cache.ServerIPMgr.2
            @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
            public void handleOper(String str2) {
                boolean z;
                String str3 = str;
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
                if (UpdateServerProtocolMgr.responseProtocol(requestProtocol[1], linkedHashMap) != 0 || ServerIPV6Mgr.getInstance().updateServerIP(context, requestProtocol[1]) != 0) {
                    return;
                }
                DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
                List<ServerTB> allServer = dBAccessMgr.getAllServer();
                if (allServer != null && allServer.size() > 0) {
                    ServerTB serverTB = allServer.get(0);
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
                    Iterator<String> it2 = updateServerInfo2.getIps().iterator();
                    while (it2.hasNext()) {
                        ServerTB serverTB2 = new ServerTB();
                        serverTB2.setIp(it2.next());
                        serverTB2.setIsp(updateServerInfo2.getIsp());
                        serverTB2.setVer(updateServerInfo2.getVer());
                        dBAccessMgr.addServer(serverTB2);
                        arrayList.add(serverTB2);
                    }
                }
                ServerIPMgr.this.mIspServerIpCache.clear();
                ServerIPMgr.this.addIspServerIpCache(arrayList);
                dBAccessMgr.delSomeServer(allServer);
                ServerIPMgr.this.clearBestServerIPCache();
            }
        });
        ThreadPoolMgr.getInstance().addTask(threadInfo);
        return 0;
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
        ConcurrentMap<Integer, ArrayList<ServerTB>> concurrentMap = this.mIspServerIpCache;
        if (concurrentMap == null || concurrentMap.isEmpty()) {
            List<ServerTB> allServer = DBAccessMgr.getInstance(context).getAllServer();
            if (allServer != null && !allServer.isEmpty()) {
                for (int i = 0; i < allServer.size(); i++) {
                    if (this.mListUsedIsp.contains(Integer.valueOf(allServer.get(i).getIsp()))) {
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
                    int intValue = this.mListUsedIsp.get(i2).intValue();
                    String[] strArr = (String[]) hashMap.get(Integer.valueOf(intValue));
                    if (strArr != null && strArr.length > 0) {
                        ArrayList<ServerTB> arrayList = new ArrayList<>(strArr.length);
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
                AsynTaskMgr.INSTANCE.post(new Runnable() { // from class: com.yy.gslbsdk.cache.ServerIPMgr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(context);
                        List<ServerTB> allServer2 = dBAccessMgr.getAllServer();
                        if (allServer2 != null && !allServer2.isEmpty()) {
                            LogTools.printDebug(ServerIPMgr.TAG, String.format(Locale.US, "initServerIP db server ip is not empty, size is %d ", Integer.valueOf(allServer2.size())));
                            return;
                        }
                        for (int i3 = 0; i3 < ServerIPMgr.this.mListUsedIsp.size(); i3++) {
                            List<ServerTB> list = (List) ServerIPMgr.this.mIspServerIpCache.get(Integer.valueOf(ServerIPMgr.this.mListUsedIsp.get(i3).intValue()));
                            if (list != null && list.size() > 0) {
                                for (ServerTB serverTB2 : list) {
                                    dBAccessMgr.addServer(serverTB2);
                                }
                            }
                        }
                    }
                });
            }
        }
        LogTools.printDebug(TAG, "initServerIP...");
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
