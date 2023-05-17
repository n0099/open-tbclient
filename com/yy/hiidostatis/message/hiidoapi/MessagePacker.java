package com.yy.hiidostatis.message.hiidoapi;

import android.content.Context;
import android.net.wifi.WifiInfo;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.mutiprocess.live.YyLiveRoomConfig;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.defs.controller.OaidController;
import com.yy.hiidostatis.defs.obj.Act;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.GeneralProxy;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.hdid.GAIDClient;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.message.MessageMonitor;
import com.yy.hiidostatis.message.MessageStore;
import com.yy.hiidostatis.message.Packer;
import com.yy.hiidostatis.message.Task;
import com.yy.hiidostatis.message.log.TraceLog;
import com.yy.hiidostatis.pref.HdStatisConfig;
import com.yy.hiidostatis.provider.GlobalProvider;
import com.yy.hiidostatis.provider.MessageConfig;
import com.yy.hiidostatis.provider.MessageConfigFactory;
import com.yy.hiidostatis.provider.NamedProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public class MessagePacker implements Packer {
    public static final String KEY_MAGIC = "HiidoData";
    public static final int MESSAGE_CACHE_SIZE = 3000;
    public MessageConfig config;
    public volatile boolean isInited;
    public volatile boolean isRunning;
    public MessageMonitor monitor;
    public Task sender;
    public MessageStore store;
    public volatile boolean initedFailed = false;
    public ConcurrentLinkedQueue<StatisContent> cache = new ConcurrentLinkedQueue<>();
    public ConcurrentHashMap<Integer, Packer.OnSavedListener> listens = new ConcurrentHashMap<>();
    public AtomicInteger saveCount = new AtomicInteger();

    public MessagePacker(MessageConfig messageConfig, MessageMonitor messageMonitor) {
        this.config = messageConfig;
        this.monitor = messageMonitor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners(final List<Packer.OnSavedListener> list) {
        if (list == null) {
            return;
        }
        ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.message.hiidoapi.MessagePacker.2
            @Override // java.lang.Runnable
            public void run() {
                for (Packer.OnSavedListener onSavedListener : list) {
                    onSavedListener.onSaved(true);
                }
                list.clear();
            }
        });
    }

    @Override // com.yy.hiidostatis.message.Packer
    public boolean addMessage(StatisContent statisContent) {
        return addMessage(statisContent, null);
    }

    @Override // com.yy.hiidostatis.message.Packer
    public void onInited(boolean z) {
        if (z) {
            this.store = (MessageStore) GlobalProvider.instance.get(MessageStore.class, this.config);
            this.sender = (Task) GlobalProvider.instance.get(NamedProvider.SEND_MODULE_TASK, this.config);
            this.isInited = true;
            this.initedFailed = false;
            return;
        }
        this.initedFailed = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void packContent(StatisContent statisContent) {
        packForSpecialAct(statisContent);
        if (statisContent.isFillCommon() || statisContent.isFillConcrete()) {
            if (statisContent.isFillCommon()) {
                CommonFiller.fillCommonNew(this.config.getApplicationContext(), statisContent, statisContent.getAct(), MessageConfig.SDK_VER);
            }
            if (statisContent.isFillConcrete()) {
                CommonFiller.fillConcreteInfoNew(this.config.getApplicationContext(), statisContent);
            }
        }
        if (this.config.getUidProvider() != null) {
            statisContent.put("uid", this.config.getUidProvider().getCurrentUid());
        }
        statisContent.put("act", statisContent.getAct());
        statisContent.put("app", this.config.getAppId());
        statisContent.put("appkey", this.config.getAppkey());
        statisContent.put("from", this.config.getFrom());
        statisContent.put("ver", this.config.getVer());
        statisContent.put(BaseStatisContent.SESSIONID, this.config.getSessionId());
        statisContent.put(BaseStatisContent.AUTOID, statisContent.getAutoId());
        statisContent.put(BaseStatisContent.CREPID, this.monitor.getProcessId());
        if (this.config.getAppsflyer() != null) {
            statisContent.put(BaseStatisContent.MDSR, this.config.getAppsflyer());
        }
        statisContent.put(BaseStatisContent.TIMEZONE, ArdUtil.getTimeZone());
        statisContent.put("oaid", OaidController.INSTANCE.oaid());
        statisContent.put(BaseStatisContent.BDCUID, this.config.getBdCuid());
        if (this.config.isGaidEnable()) {
            statisContent.put(Config.GAID, GAIDClient.getGAID(this.config.getApplicationContext()));
        }
    }

    private void packForSpecialAct(StatisContent statisContent) {
        try {
            String act = statisContent.getAct();
            Context applicationContext = this.config.getApplicationContext();
            if (act.equals(Act.MBSDK_INSTALL.toString())) {
                statisContent.put("htype", DeviceProxy.getType(applicationContext));
                statisContent.put("hfrom", DeviceProxy.getHFrom(applicationContext));
                statisContent.put("htime", DeviceProxy.getCreateTime(applicationContext));
                statisContent.put("sdpm", DeviceProxy.getSdPermission(applicationContext));
            } else {
                int i = 1;
                if (act.equals(Act.MBSDK_RUN.toString())) {
                    if (!ArdUtil.isRoot()) {
                        i = 0;
                    }
                    statisContent.put("root", i);
                    WifiInfo wifiInfo = ArdUtil.getWifiInfo(applicationContext);
                    if (wifiInfo != null) {
                        statisContent.put("bssid", wifiInfo.getBSSID());
                        statisContent.put(YyLiveRoomConfig.KEY_SSID, wifiInfo.getSSID());
                        statisContent.put("rssi", wifiInfo.getRssi());
                    }
                } else if (act.equals(Act.MBSDK_DO.toString())) {
                    statisContent.put("htype", DeviceProxy.getType(applicationContext));
                    statisContent.put("hfrom", DeviceProxy.getHFrom(applicationContext));
                    statisContent.put("htime", DeviceProxy.getCreateTime(applicationContext));
                    statisContent.put("sdpm", DeviceProxy.getSdPermission(applicationContext));
                    statisContent.put("srvtm", GeneralProxy.getGeneralConfigInstance(applicationContext, HdStatisConfig.getConfig(this.config.getAppkey())).getSrvTime());
                } else if (act.equals(Act.MBSDK_EVENT.toString())) {
                    statisContent.put("srvtm", GeneralProxy.getGeneralConfigInstance(applicationContext, HdStatisConfig.getConfig(this.config.getAppkey())).getSrvTime());
                } else if (act.equals(Act.MBSDK_APPLIST.toString())) {
                    String str = statisContent.get("applist");
                    if (str != null && !str.isEmpty()) {
                        String substring = Coder.encryptMD5(statisContent.get("act") + statisContent.get("time") + "HiidoData").toLowerCase().substring(0, 8);
                        L.verbose("StatisAPI", "des key is %s", substring);
                        statisContent.put("applist", Coder.encryptDES(str, substring));
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.yy.hiidostatis.message.Packer
    public boolean addMessage(StatisContent statisContent, Packer.OnSavedListener onSavedListener) {
        if (this.initedFailed) {
            TraceLog.dropMessageLog(statisContent.getAct(), statisContent.getGuid());
            return false;
        } else if (this.cache.size() > 3000) {
            L.debug(this, "cache out size", new Object[0]);
            TraceLog.dropMessageLog(statisContent.getAct(), statisContent.getGuid());
            return false;
        } else {
            StatisContent copyByNewGuid = statisContent.copyByNewGuid();
            copyByNewGuid.setAutoId(this.monitor.getAutoId(copyByNewGuid.getAct()));
            TraceLog.addMessageLog(this.config.getAppkey(), statisContent);
            if (onSavedListener != null) {
                this.listens.put(Integer.valueOf(copyByNewGuid.getTmpId()), onSavedListener);
            }
            this.cache.add(copyByNewGuid);
            execute();
            return true;
        }
    }

    public void execute() {
        if (!this.isRunning && this.isInited) {
            this.isRunning = true;
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.message.hiidoapi.MessagePacker.1
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    try {
                        MessagePacker.this.monitor.commit();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        ArrayList arrayList = new ArrayList(MessagePacker.this.cache.size() + 10);
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = null;
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sb2 = new StringBuilder();
                        boolean z = false;
                        while (!MessagePacker.this.cache.isEmpty()) {
                            StatisContent statisContent = (StatisContent) MessagePacker.this.cache.poll();
                            if (MessagePacker.this.listens.containsKey(Integer.valueOf(statisContent.getTmpId()))) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(MessagePacker.this.listens.remove(Integer.valueOf(statisContent.getTmpId())));
                            }
                            if (statisContent.getPriority() == StatisContent.Priority.PRIORITY_HIGH) {
                                z = true;
                            }
                            MessagePacker.this.packContent(statisContent);
                            if (statisContent.isNotSave()) {
                                arrayList2.add(statisContent);
                                sb.append(statisContent.getGuid());
                                sb.append(",");
                            } else {
                                arrayList.add(statisContent);
                                sb2.append(statisContent.getGuid());
                                sb2.append(",");
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            i = MessagePacker.this.store.save(arrayList);
                            TraceLog.saveMessageLog(sb2.toString());
                        } else {
                            i = 0;
                        }
                        if (!arrayList2.isEmpty()) {
                            i = MessagePacker.this.store.notSave(arrayList2);
                            TraceLog.saveMessageLog(sb.toString());
                        }
                        MessagePacker.this.notifyListeners(arrayList3);
                        int addAndGet = MessagePacker.this.saveCount.addAndGet(arrayList.size());
                        L.debug(this, "save count:" + addAndGet, new Object[0]);
                        if (z || i >= MessagePacker.this.config.getBatchThreshold() || (MessageConfigFactory.getMainConfig() != null && MessageConfigFactory.getMainConfig().getInterval() == 0)) {
                            MessagePacker.this.sender.execute();
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        }
    }
}
