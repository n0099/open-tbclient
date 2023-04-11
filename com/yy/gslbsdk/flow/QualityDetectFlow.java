package com.yy.gslbsdk.flow;

import android.content.Context;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.cache.ServerIPMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.DelayTB;
import com.yy.gslbsdk.db.HijackTB;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.gslbsdk.device.DeviceMgr;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.network.HTTPMgr;
import com.yy.gslbsdk.protocol.CmdInfo;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.HijackInfo;
import com.yy.gslbsdk.protocol.ReportInfo;
import com.yy.gslbsdk.protocol.ReportProtocolMgr;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.protocol.StatsInfo;
import com.yy.gslbsdk.thread.TimerMgr;
import com.yy.gslbsdk.thread.TimerTaskInfo;
import com.yy.gslbsdk.util.FormatTools;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class QualityDetectFlow {
    public static final String TAG = "QualityDetectFlow";
    public static QualityDetectFlow mQualityDetectFlow;

    public static QualityDetectFlow getInstance() {
        if (mQualityDetectFlow == null) {
            mQualityDetectFlow = new QualityDetectFlow();
        }
        return mQualityDetectFlow;
    }

    public synchronized int stopAllMonitor() {
        TimerMgr.getInstance().stopAllWorker();
        return 0;
    }

    public boolean canReport(String str) {
        CmdInfo cmd;
        Context context = GlobalTools.APP_CONTEXT;
        if (context != null) {
            NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(context);
            DnsInfo dnsInfo = new DnsInfo();
            if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, networkInfo, str, dnsInfo) == 0 && (cmd = dnsInfo.getCmd()) != null && cmd.isRe()) {
                return true;
            }
        }
        return false;
    }

    private void calAvgDelay(HashMap<String, ReportInfo> hashMap) {
        if (hashMap != null) {
            for (ReportInfo reportInfo : hashMap.values()) {
                HashMap<String, StatsInfo> stats1 = reportInfo.getStats1();
                if (stats1 != null) {
                    for (StatsInfo statsInfo : stats1.values()) {
                        for (int i = 0; i < statsInfo.getIts().size(); i++) {
                            if (statsInfo.getIts().get(i)[1] != 0) {
                                statsInfo.getIts().get(i)[0] = statsInfo.getIts().get(i)[2] / statsInfo.getIts().get(i)[1];
                            }
                        }
                    }
                }
                HashMap<String, StatsInfo> stats15 = reportInfo.getStats15();
                if (stats15 != null) {
                    for (StatsInfo statsInfo2 : stats15.values()) {
                        for (int i2 = 0; i2 < statsInfo2.getIts().size(); i2++) {
                            if (statsInfo2.getIts().get(i2)[1] != 0) {
                                statsInfo2.getIts().get(i2)[0] = statsInfo2.getIts().get(i2)[2] / statsInfo2.getIts().get(i2)[1];
                            }
                        }
                    }
                }
            }
        }
    }

    private ReportInfo collectStats0Data(NetStatusInfo netStatusInfo) {
        int failedDnsCount = DataCacheMgr.INSTANCE.getFailedDnsCount();
        int localDnsCount = DataCacheMgr.INSTANCE.getLocalDnsCount();
        List<Long> listDnsCost = DataCacheMgr.INSTANCE.getListDnsCost();
        if (failedDnsCount == 0 && localDnsCount == 0 && listDnsCost.size() == 0) {
            return null;
        }
        ReportInfo reportInfo = new ReportInfo();
        reportInfo.setHost(GlobalTools.HTTPDNS_REPORT_HOST);
        reportInfo.setNetInfo(netStatusInfo);
        reportInfo.setView("");
        reportInfo.setFc(failedDnsCount);
        reportInfo.setLc(localDnsCount);
        StatsInfo statsInfo = new StatsInfo();
        statsInfo.setSip("0.0.0.0");
        Iterator<Long> it = listDnsCost.iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            long longValue = it.next().longValue();
            if (longValue < 0 || longValue > 20) {
                if (longValue > 20 && longValue <= 100) {
                    i = 1;
                } else if (longValue > 100 && longValue <= 200) {
                    i = 2;
                } else if (longValue > 200 && longValue <= 500) {
                    i = 3;
                } else if (longValue > 500) {
                    i = 4;
                } else {
                    i = -1;
                }
            }
            if (i != -1) {
                long[] jArr = statsInfo.getIts().get(i);
                jArr[1] = jArr[1] + 1;
                long[] jArr2 = statsInfo.getIts().get(i);
                jArr2[2] = jArr2[2] + longValue;
            }
        }
        for (int i2 = 0; i2 < statsInfo.getIts().size(); i2++) {
            long[] jArr3 = statsInfo.getIts().get(i2);
            if (jArr3[1] != 0) {
                jArr3[0] = jArr3[2] / jArr3[1];
            }
        }
        reportInfo.setStats0(statsInfo);
        return reportInfo;
    }

    private HashMap<String, ReportInfo> collectHijackData(List<HijackTB> list, NetStatusInfo netStatusInfo) {
        HashMap<String, ReportInfo> hashMap = new HashMap<>();
        String reportDate = DataCacheMgr.INSTANCE.getReportDate(GlobalTools.APP_CONTEXT);
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (!format.equals(reportDate) && netStatusInfo.getNetType() != 1 && netStatusInfo.getNetType() != 0 && (netStatusInfo.getNetType() == 2 || FormatTools.daysOfTwo(reportDate, format) >= 2)) {
            for (HijackTB hijackTB : list) {
                String host = hijackTB.getHost();
                if (!hashMap.containsKey(host)) {
                    ReportInfo reportInfo = new ReportInfo();
                    reportInfo.setHost(host);
                    reportInfo.setNetInfo(netStatusInfo);
                    DnsInfo dnsInfo = new DnsInfo();
                    if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, host, dnsInfo) == 0) {
                        reportInfo.setView(dnsInfo.getView());
                    } else {
                        reportInfo.setView("");
                    }
                    hashMap.put(host, reportInfo);
                }
                HijackInfo hijackInfo = new HijackInfo();
                hijackInfo.setUip(hijackTB.getUip());
                hijackInfo.setDnsip(hijackTB.getDnsip());
                hijackInfo.setHip(hijackTB.getHip());
                hashMap.get(host).getHijack().add(hijackInfo);
            }
        }
        return hashMap;
    }

    private HashMap<String, ReportInfo> collectMin15Data(List<DelayTB> list, NetStatusInfo netStatusInfo) {
        int i;
        HashMap<String, ReportInfo> hashMap = new HashMap<>();
        for (DelayTB delayTB : list) {
            String host = delayTB.getHost();
            if (!hashMap.containsKey(host)) {
                ReportInfo reportInfo = new ReportInfo();
                reportInfo.setHost(host);
                reportInfo.setNetInfo(netStatusInfo);
                DnsInfo dnsInfo = new DnsInfo();
                if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, host, dnsInfo) == 0) {
                    reportInfo.setView(dnsInfo.getView());
                } else {
                    reportInfo.setView("");
                }
                hashMap.put(host, reportInfo);
            }
            ReportInfo reportInfo2 = hashMap.get(host);
            if (!reportInfo2.getStats15().containsKey(delayTB.getIp())) {
                StatsInfo statsInfo = new StatsInfo();
                statsInfo.setSip(delayTB.getIp());
                reportInfo2.getStats15().put(statsInfo.getSip(), statsInfo);
            }
            StatsInfo statsInfo2 = reportInfo2.getStats15().get(delayTB.getIp());
            long delay = delayTB.getDelay();
            if (delay >= 0 && delay <= 50) {
                i = 0;
            } else if (delay > 50 && delay <= 100) {
                i = 1;
            } else if (delay > 100 && delay <= 200) {
                i = 2;
            } else if (delay > 200 && delay <= 300) {
                i = 3;
            } else if (delay > 300 && delay < 500) {
                i = 4;
            } else {
                i = -1;
            }
            if (i != -1) {
                long[] jArr = statsInfo2.getIts().get(i);
                jArr[1] = jArr[1] + 1;
                long[] jArr2 = statsInfo2.getIts().get(i);
                jArr2[2] = jArr2[2] + delay;
            }
        }
        return hashMap;
    }

    private HashMap<String, ReportInfo> collectMin1Data(List<DelayTB> list, NetStatusInfo netStatusInfo) {
        int i;
        HashMap<String, ReportInfo> hashMap = new HashMap<>();
        for (DelayTB delayTB : list) {
            String host = delayTB.getHost();
            if (!hashMap.containsKey(host)) {
                ReportInfo reportInfo = new ReportInfo();
                reportInfo.setHost(host);
                reportInfo.setNetInfo(netStatusInfo);
                DnsInfo dnsInfo = new DnsInfo();
                if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, netStatusInfo, host, dnsInfo) == 0) {
                    reportInfo.setView(dnsInfo.getView());
                } else {
                    reportInfo.setView("");
                }
                hashMap.put(host, reportInfo);
            }
            ReportInfo reportInfo2 = hashMap.get(host);
            if (!reportInfo2.getStats1().containsKey(delayTB.getIp())) {
                StatsInfo statsInfo = new StatsInfo();
                statsInfo.setSip(delayTB.getIp());
                reportInfo2.getStats1().put(statsInfo.getSip(), statsInfo);
            }
            StatsInfo statsInfo2 = reportInfo2.getStats1().get(delayTB.getIp());
            long delay = delayTB.getDelay();
            if (delay >= 500 && delay <= 600) {
                i = 0;
            } else if (delay > 600 && delay <= 800) {
                i = 1;
            } else if (delay > 800 && delay <= 1000) {
                i = 2;
            } else if (delay > 1000 && delay <= 2000) {
                i = 3;
            } else if (delay > 2000) {
                i = 4;
            } else {
                i = -1;
            }
            if (i != -1) {
                long[] jArr = statsInfo2.getIts().get(i);
                jArr[1] = jArr[1] + 1;
                long[] jArr2 = statsInfo2.getIts().get(i);
                jArr2[2] = jArr2[2] + delay;
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHijackMonitor() {
        NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT);
        ConcurrentHashMap<String, DnsInfo> allLocalDNSFromCache = IpVersionController.getInstance().getAllLocalDNSFromCache();
        LinkedList linkedList = new LinkedList();
        int i = 0;
        int i2 = 0;
        for (String str : allLocalDNSFromCache.keySet()) {
            linkedList.add(str);
            if (linkedList.size() == 5 || i2 == allLocalDNSFromCache.size() - 1) {
                ResInfo resInfo = new ResInfo();
                DnsResolveFlow.getInstance().handleHttpDNSIgnoreCache(networkInfo, (String[]) linkedList.toArray(new String[i]), resInfo, true);
                if (resInfo.getStatus() == 0) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        DnsInfo dnsInfo = allLocalDNSFromCache.get(str2);
                        LinkedList<String> ips = dnsInfo.getIps();
                        LinkedList<String> linkedList2 = null;
                        if (resInfo.getDns() != null && resInfo.getDns().get(str2) != null) {
                            linkedList2 = resInfo.getDns().get(str2).getIps();
                        }
                        if (ips != null && linkedList2 != null) {
                            Iterator<String> it2 = ips.iterator();
                            while (it2.hasNext()) {
                                String next = it2.next();
                                if (!FormatTools.containInList(linkedList2, next)) {
                                    addHijackData(str2, dnsInfo.getNt(), dnsInfo.getUip(), next);
                                    LogTools.printDebug(TAG, "add hijack data success: " + str2 + " " + dnsInfo.getNt() + " " + next);
                                }
                            }
                        }
                    }
                }
                linkedList.clear();
            }
            i2++;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleQualityMonitor() {
        DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
        for (ProbeTB probeTB : DataCacheMgr.INSTANCE.getALlProbe()) {
            String host = probeTB.getHost();
            DnsInfo dnsInfo = new DnsInfo();
            if (canProbe(host, dnsInfo)) {
                boolean canReport = canReport(host);
                Iterator<String> it = dnsInfo.getIps().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String replace = probeTB.getUrl().replace(host, next);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (probeTB.getMethod() == 1) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("host", host);
                        HTTPMgr.headHttp(replace, hashMap);
                    } else {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("host", host);
                        HTTPMgr.getHttp(replace, hashMap2);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (canReport) {
                        long j = currentTimeMillis2 - currentTimeMillis;
                        addReportData(host, next, j);
                        LogTools.printDebug(TAG, "Probe success: " + host + " " + next + " " + j + "ms");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStatsReport() {
        boolean z;
        boolean z2;
        boolean z3;
        if (GlobalTools.IS_BACKGOUND_MODEL) {
            return;
        }
        DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
        NetStatusInfo networkInfo = DeviceMgr.getNetworkInfo(GlobalTools.APP_CONTEXT);
        GlobalTools.STATS_REPORT_TIME += 3;
        ReportInfo collectStats0Data = collectStats0Data(networkInfo);
        if (collectStats0Data != null) {
            String reportProtocol = ReportProtocolMgr.reportProtocol(collectStats0Data);
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                String str = ServerIPMgr.reportUrl;
                if (GlobalTools.HTTPS_LEVEL == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                String[] post = HTTPMgr.post(str, reportProtocol, null, z3);
                if (post != null && post[0].equals(BasicPushStatus.SUCCESS_CODE)) {
                    DataCacheMgr.INSTANCE.resetFailedDnsCount();
                    DataCacheMgr.INSTANCE.resetLocalDnsCount();
                    DataCacheMgr.INSTANCE.resetListDnsCost();
                    LogTools.printDebug(TAG, "Report stats0 success: " + reportProtocol);
                    break;
                }
                i++;
            }
        }
        HashMap<String, ReportInfo> collectMin1Data = collectMin1Data(DataCacheMgr.INSTANCE.getAllDelayUpper(), networkInfo);
        calAvgDelay(collectMin1Data);
        for (ReportInfo reportInfo : collectMin1Data.values()) {
            String reportProtocol2 = ReportProtocolMgr.reportProtocol(reportInfo);
            String str2 = ServerIPMgr.reportUrl;
            if (GlobalTools.HTTPS_LEVEL == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            String[] post2 = HTTPMgr.post(str2, reportProtocol2, null, z2);
            if (post2 != null && post2[0].equals(BasicPushStatus.SUCCESS_CODE)) {
                DataCacheMgr.INSTANCE.deleteDelayByHostFromUpper(reportInfo.getHost());
                LogTools.printDebug(TAG, "Report min1 success: " + reportProtocol2);
            }
        }
        if (GlobalTools.STATS_REPORT_TIME >= 15) {
            GlobalTools.STATS_REPORT_TIME = 0;
            HashMap<String, ReportInfo> collectMin15Data = collectMin15Data(DataCacheMgr.INSTANCE.getAllDelayLower(), networkInfo);
            calAvgDelay(collectMin15Data);
            for (ReportInfo reportInfo2 : collectMin15Data.values()) {
                if (canReport(reportInfo2.getHost())) {
                    int invokeApiNum = DataCacheMgr.INSTANCE.getInvokeApiNum(reportInfo2.getHost());
                    int hitCacheNum = DataCacheMgr.INSTANCE.getHitCacheNum(reportInfo2.getHost());
                    reportInfo2.setTt(invokeApiNum);
                    reportInfo2.setCt(hitCacheNum);
                }
                String reportProtocol3 = ReportProtocolMgr.reportProtocol(reportInfo2);
                String str3 = ServerIPMgr.reportUrl;
                if (GlobalTools.HTTPS_LEVEL == 2) {
                    z = true;
                } else {
                    z = false;
                }
                String[] post3 = HTTPMgr.post(str3, reportProtocol3, null, z);
                if (post3 != null && post3[0].equals(BasicPushStatus.SUCCESS_CODE)) {
                    DataCacheMgr.INSTANCE.deleteDelayByHostFromLower(reportInfo2.getHost());
                    DataCacheMgr.INSTANCE.clearInvokeApiNum(reportInfo2.getHost());
                    DataCacheMgr.INSTANCE.clearHitCacheNum(reportInfo2.getHost());
                    LogTools.printDebug(TAG, "Report min15 success: " + reportProtocol3);
                }
            }
            for (ReportInfo reportInfo3 : collectHijackData(dBAccessMgr.getAllHijack(), networkInfo).values()) {
                String reportProtocol4 = ReportProtocolMgr.reportProtocol(reportInfo3);
                String[] postHttp = HTTPMgr.postHttp(ServerIPMgr.reportUrl, reportProtocol4);
                if (postHttp != null && postHttp[0].equals(BasicPushStatus.SUCCESS_CODE)) {
                    dBAccessMgr.delHijackByHost(reportInfo3.getHost());
                    DataCacheMgr.INSTANCE.setReportDate(GlobalTools.APP_CONTEXT, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    LogTools.printDebug(TAG, "Report hijack success: " + reportProtocol4);
                }
            }
        }
    }

    public synchronized void addHijackData(String str, int i, String str2, String str3) {
        if (GlobalTools.APP_CONTEXT != null) {
            DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
            HijackTB hijackTB = new HijackTB();
            hijackTB.setHost(str);
            hijackTB.setNt(i);
            hijackTB.setUip(str2);
            hijackTB.setHip(str3);
            hijackTB.setDnsip(ServerIPMgr.curLocalDNSIp);
            dBAccessMgr.delHijack(hijackTB);
            dBAccessMgr.addHijack(hijackTB);
        }
    }

    public synchronized void updateDectorList(String str, int i, int i2, String str2) {
        if (GlobalTools.APP_CONTEXT != null) {
            DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
            ProbeTB probeTB = new ProbeTB();
            probeTB.setHost(str);
            probeTB.setProtocol(i);
            probeTB.setMethod(i2);
            probeTB.setUrl(str2);
            DataCacheMgr.INSTANCE.addProbe(probeTB);
        }
    }

    public void addReportData(String str, String str2, long j) {
        Context context = GlobalTools.APP_CONTEXT;
        if (context != null) {
            DBAccessMgr.getInstance(context);
            DelayTB delayTB = new DelayTB();
            delayTB.setHost(str);
            delayTB.setIp(str2);
            delayTB.setDelay(j);
            DataCacheMgr.INSTANCE.addDelay(delayTB);
        }
    }

    public synchronized int beginHijackMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            TimerTaskInfo timerTaskInfo = new TimerTaskInfo();
            timerTaskInfo.setTaskName(GlobalTools.HIJACK_MONITOR_NAME);
            timerTaskInfo.setWorker(new TimerTask() { // from class: com.yy.gslbsdk.flow.QualityDetectFlow.2
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    QualityDetectFlow.this.handleHijackMonitor();
                }
            });
            TimerMgr.getInstance().addWorker(timerTaskInfo, 0L, GlobalTools.HIJACK_MONITOR_PERIOD);
            LogTools.printDebug(TAG, "beginHijackMonitor...");
            return 0;
        }
        return 5;
    }

    public synchronized int beginQualityMonitor() {
        if (GlobalTools.APP_CONTEXT != null) {
            TimerTaskInfo timerTaskInfo = new TimerTaskInfo();
            timerTaskInfo.setTaskName(GlobalTools.QUALITY_MONITOR_NAME);
            timerTaskInfo.setWorker(new TimerTask() { // from class: com.yy.gslbsdk.flow.QualityDetectFlow.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    QualityDetectFlow.this.handleQualityMonitor();
                }
            });
            TimerMgr.getInstance().addWorker(timerTaskInfo, 0L, GlobalTools.QUALITY_MONITOR_PERIOD);
            LogTools.printDebug(TAG, "beginQualityMonitor...");
            return 0;
        }
        return 5;
    }

    public synchronized int beginStatsReport() {
        if (GlobalTools.APP_CONTEXT != null) {
            TimerTaskInfo timerTaskInfo = new TimerTaskInfo();
            timerTaskInfo.setTaskName(GlobalTools.STATS_REPORT_NAME);
            timerTaskInfo.setWorker(new TimerTask() { // from class: com.yy.gslbsdk.flow.QualityDetectFlow.3
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    QualityDetectFlow.this.handleStatsReport();
                }
            });
            TimerMgr.getInstance().addWorker(timerTaskInfo, 0L, GlobalTools.STATS_REPORT_PERIOD);
            LogTools.printDebug(TAG, "beginStatsReport...");
            return 0;
        }
        return 5;
    }

    public boolean canProbe(String str, DnsInfo dnsInfo) {
        CmdInfo cmd;
        Context context = GlobalTools.APP_CONTEXT;
        if (context != null && dnsInfo != null) {
            if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, DeviceMgr.getNetworkInfo(context), str, dnsInfo) == 0 && (cmd = dnsInfo.getCmd()) != null && cmd.isPe() && System.currentTimeMillis() > dnsInfo.getProbeTime()) {
                return true;
            }
        }
        return false;
    }
}
