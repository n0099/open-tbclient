package com.yy.gslbsdk.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.control.IpVersionController;
import com.yy.gslbsdk.db.DBAccessMgr;
import com.yy.gslbsdk.db.HostTB;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.flow.DnsResolveFlow;
import com.yy.gslbsdk.flow.QualityDetectFlow;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.LocalDNSProtocolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public enum AsynTaskMgr {
    INSTANCE;
    
    public static final String TAG = "AsynTaskMgr";
    public static int KTaskUpdateHost = 1;
    public static int KTaskParseLocalDns = 2;
    public HandlerThread mHandlerThread = null;
    public Handler mHandler = null;
    public AtomicBoolean mMonitorStarted = new AtomicBoolean(false);

    /* loaded from: classes7.dex */
    public static class AsynTaskHandler extends Handler {
        public AsynTaskHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == AsynTaskMgr.KTaskUpdateHost) {
                AsynTaskMgr.INSTANCE.doUpdateHost(message.getData());
            } else if (message.what == AsynTaskMgr.KTaskParseLocalDns) {
                AsynTaskMgr.INSTANCE.doParseLocalDns(message.getData());
            }
        }
    }

    AsynTaskMgr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doParseLocalDns(Bundle bundle) {
        String string = bundle.getString("host");
        if (string == null || string.length() == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        DnsInfo requestProtocol = LocalDNSProtocolMgr.requestProtocol(string);
        if (requestProtocol != null) {
            NetStatusInfo cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo();
            requestProtocol.setNt(cachedNetStatusInfo.getNetType());
            DnsInfo dnsInfo = new DnsInfo();
            if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, cachedNetStatusInfo, string, dnsInfo) == 0) {
                requestProtocol.setUip(dnsInfo.getUip());
            }
            IpVersionController.getInstance().putLocalDNSIntoCache(requestProtocol);
        } else {
            LogTools.printError(TAG, "local parse error");
        }
        LogTools.printDebug(TAG, "parse local dns, timespent = " + (System.currentTimeMillis() - currentTimeMillis) + ", host = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateHost(Bundle bundle) {
        if (bundle != null) {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("hostList");
            boolean z = bundle.getBoolean("isPre");
            if (stringArrayList == null || GlobalTools.APP_CONTEXT == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            DBAccessMgr dBAccessMgr = DBAccessMgr.getInstance(GlobalTools.APP_CONTEXT);
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                List<HostTB> hostByHost = dBAccessMgr.getHostByHost(next);
                if (hostByHost.isEmpty()) {
                    HostTB hostTB = new HostTB();
                    hostTB.setHost(next);
                    hostTB.setInsertTime(currentTimeMillis);
                    hostTB.setIsPre(z ? 1 : 0);
                    dBAccessMgr.addHost(hostTB);
                } else {
                    HostTB hostTB2 = hostByHost.get(0);
                    hostTB2.setInsertTime(currentTimeMillis);
                    if (hostTB2.getIsPre() == 0) {
                        hostTB2.setIsPre(z ? 1 : 0);
                    }
                    dBAccessMgr.updateHost(hostTB2);
                }
            }
            List<HostTB> allHost = dBAccessMgr.getAllHost();
            int size = allHost.size();
            if (size > GlobalTools.KEEP_HOST_NUM) {
                for (int i2 = size - 1; i2 > 0; i2--) {
                    if (allHost.get(i2).getIsPre() != 1) {
                        LogTools.printDebug(TAG, "remove host " + allHost.get(i2).getHost());
                        dBAccessMgr.delHost(allHost.get(i2));
                        size += -1;
                        if (size <= GlobalTools.KEEP_HOST_NUM) {
                            break;
                        }
                    }
                }
            }
            allHost.clear();
        }
    }

    public boolean isHandlerRunning() {
        return this.mHandlerThread.isAlive();
    }

    public boolean isMonitorRunning() {
        return this.mMonitorStarted.get();
    }

    public void parseLocalDns(String str) {
        Message obtain = Message.obtain();
        obtain.what = KTaskParseLocalDns;
        Bundle bundle = new Bundle();
        bundle.putString("host", str);
        obtain.setData(bundle);
        this.mHandler.sendMessage(obtain);
    }

    public void post(Runnable runnable) {
        this.mHandler.post(runnable);
    }

    public void postDelayed(Runnable runnable, long j) {
        this.mHandler.removeCallbacks(runnable);
        this.mHandler.postDelayed(runnable, j);
    }

    public synchronized void start() {
        HandlerThread handlerThread = new HandlerThread("gslb_asyn_task");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new AsynTaskHandler(this.mHandlerThread.getLooper());
    }

    public void startMonitors() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.yy.gslbsdk.thread.AsynTaskMgr.1
            @Override // java.lang.Runnable
            public void run() {
                if (AsynTaskMgr.this.mMonitorStarted.compareAndSet(false, true)) {
                    DnsResolveFlow.getInstance().beginNetworkMonitor();
                    DnsResolveFlow.getInstance().beginTTLMonitor();
                }
            }
        }, GlobalTools.MONITOR_DELAY);
    }

    public synchronized void stop() {
        this.mHandlerThread.quit();
    }

    public void stopMonitors() {
        if (this.mMonitorStarted.compareAndSet(true, false)) {
            DnsResolveFlow.getInstance().stopNetworkMonitor();
            QualityDetectFlow.getInstance().stopAllMonitor();
        }
    }

    public void updateHost(ArrayList<String> arrayList, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = KTaskUpdateHost;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("hostList", arrayList);
        bundle.putBoolean("isPre", z);
        obtain.setData(bundle);
        this.mHandler.sendMessage(obtain);
    }
}
