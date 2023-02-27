package com.yy.gslbsdk.control;

import android.text.TextUtils;
import com.kuaishou.weapon.p0.u;
import com.yy.gslbsdk.cache.DataCacheMgr;
import com.yy.gslbsdk.device.NetStatusInfo;
import com.yy.gslbsdk.flow.DnsResolveFlow;
import com.yy.gslbsdk.protocol.DnsInfo;
import com.yy.gslbsdk.protocol.ResInfo;
import com.yy.gslbsdk.thread.ThreadInfo;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.gslbsdk.util.GlobalTools;
import com.yy.gslbsdk.util.LogTools;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class ActiveRefreshController {
    public static final String TAG = "ActiveRefreshController";
    public static ActiveRefreshController sInstance;

    public static synchronized ActiveRefreshController getInstance() {
        ActiveRefreshController activeRefreshController;
        synchronized (ActiveRefreshController.class) {
            if (sInstance == null) {
                sInstance = new ActiveRefreshController();
            }
            activeRefreshController = sInstance;
        }
        return activeRefreshController;
    }

    public static void refreshHostCache(ResInfo resInfo) {
        if (resInfo == null) {
            return;
        }
        final NetStatusInfo cachedNetStatusInfo = DataCacheMgr.INSTANCE.getCachedNetStatusInfo();
        final ArrayList arrayList = new ArrayList();
        List<Map<String, String>> listRefresh = resInfo.getListRefresh();
        if (listRefresh != null && !listRefresh.isEmpty()) {
            for (int i = 0; i < listRefresh.size(); i++) {
                try {
                    Map<String, String> map = listRefresh.get(i);
                    if (map != null && !map.isEmpty()) {
                        String str = map.get(u.A);
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = map.get("ut");
                            if (!TextUtils.isEmpty(str2) && TextUtils.isDigitsOnly(str2)) {
                                long longValue = Long.valueOf(str2).longValue() * 1000;
                                if (longValue >= 1) {
                                    DnsInfo dnsInfo = new DnsInfo();
                                    if (IpVersionController.getInstance().getHttpDNSFromCache(GlobalTools.APP_CONTEXT, cachedNetStatusInfo, str, dnsInfo) == 0 && dnsInfo.getEndTime() - (dnsInfo.getTtl() * 1000) < longValue) {
                                        arrayList.add(str);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    LogTools.printWarning(TAG, e);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            ThreadInfo threadInfo = new ThreadInfo("Refresh-" + cachedNetStatusInfo + "-" + arrayList.toString());
            threadInfo.setThreadMainOper(new ThreadInfo.ThreadMainOper() { // from class: com.yy.gslbsdk.control.ActiveRefreshController.1
                @Override // com.yy.gslbsdk.thread.ThreadInfo.ThreadMainOper
                public void handleOper(String str3) {
                    DnsResolveFlow.getInstance().handleDnsSync((String[]) arrayList.toArray(new String[0]), "", cachedNetStatusInfo);
                }
            });
            ThreadPoolMgr.getInstance().addTask(threadInfo);
        }
    }
}
