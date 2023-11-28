package com.yy.hiidostatis.api;

import android.content.Context;
import android.os.Build;
import com.yy.hiidostatis.defs.controller.HttpSendController;
import com.yy.hiidostatis.defs.interf.IMetricsAPI;
import com.yy.hiidostatis.defs.obj.ActionResult;
import com.yy.hiidostatis.defs.obj.Counter;
import com.yy.hiidostatis.defs.obj.MetricsPkg;
import com.yy.hiidostatis.defs.obj.MetricsValue;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.implementation.CommonFiller;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MetricsWorker implements IMetricsAPI {
    public static final String ACT = "mmetric";
    public String appKey;
    public String appVer;
    public Context context;
    public AtomicInteger count = new AtomicInteger(0);
    public long expire;
    public HttpSendController httpSendController;
    public String mac;
    public int maxCount;
    public String osVer;
    @Deprecated
    public int period;
    @Deprecated
    public int periodCount;
    public MetricsPkg pkg;
    public String sdkVer;

    private String notNull(String str) {
        return str == null ? "" : str;
    }

    public MetricsWorker(Context context, int i, HttpSendController httpSendController, long j, String str, String str2, String str3) {
        this.maxCount = i;
        this.httpSendController = httpSendController;
        this.expire = j;
        this.appKey = str;
        this.appVer = str2;
        this.context = context;
        this.sdkVer = str3;
        this.pkg = new MetricsPkg(i);
    }

    @Deprecated
    public MetricsWorker(Context context, int i, HttpSendController httpSendController, long j, String str, String str2, String str3, int i2) {
        this.maxCount = i;
        this.httpSendController = httpSendController;
        this.expire = j;
        this.appKey = str;
        this.appVer = str2;
        this.context = context;
        this.sdkVer = str3;
        this.period = i2;
        this.pkg = new MetricsPkg(i);
    }

    private void sendPkg(MetricsPkg metricsPkg) {
        try {
            for (JSONObject jSONObject : metricsPkg.toJson()) {
                String content = toContent(jSONObject);
                if (content != null) {
                    this.httpSendController.send(content, this.expire);
                }
            }
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    private String toContent(JSONObject jSONObject) {
        String str;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        try {
            StatisContent statisContent = new StatisContent();
            String valueOf = String.valueOf(Util.wallTimeSec());
            statisContent.put("act", ACT);
            statisContent.put("time", valueOf);
            statisContent.put("key", CommonFiller.calKey(ACT, valueOf));
            statisContent.put("appkey", this.appKey);
            statisContent.put("ver", notNull(this.appVer));
            statisContent.put(BaseStatisContent.SDKVER, notNull(this.sdkVer));
            statisContent.put("sys", 2);
            if (this.osVer == null) {
                str = ArdUtil.getOS();
                this.osVer = str;
            } else {
                str = this.osVer;
            }
            statisContent.put("osver", notNull(str));
            statisContent.put("model", notNull(Build.MODEL));
            statisContent.put("net", ArdUtil.getNetworkTypeNew(this.context));
            statisContent.put(BaseStatisContent.NTM, ArdUtil.getNtm(this.context));
            statisContent.put("hdid", DeviceProxy.getHdid(this.context));
            statisContent.put("imei", CommonFiller.getIMEI(this.context));
            statisContent.put("mac", CommonFiller.getMacAddr(this.context));
            statisContent.put(BaseStatisContent.SJP, ArdUtil.getSjp(this.context));
            statisContent.put(BaseStatisContent.GUID, StringUtil.geneGuid());
            System.currentTimeMillis();
            statisContent.put("clienttime", String.valueOf(jSONObject.getLong("clienttime") / 1000));
            if (jSONObject.has("reqdata")) {
                jSONArray = jSONObject.getJSONArray("reqdata");
            } else {
                jSONArray = null;
            }
            if (jSONObject.has("counterdata")) {
                jSONArray2 = jSONObject.getJSONArray("counterdata");
            } else {
                jSONArray2 = null;
            }
            if (jSONObject.has("flatdata")) {
                jSONArray3 = jSONObject.getJSONArray("flatdata");
            } else {
                jSONArray3 = null;
            }
            if (jSONArray != null) {
                statisContent.put("reqdata", notNull(jSONArray.toString()));
            }
            if (jSONArray2 != null) {
                statisContent.put("counterdata", notNull(jSONArray2.toString()));
            }
            if (jSONArray3 != null) {
                statisContent.put("flatdata", notNull(jSONArray3.toString()));
            }
            return statisContent.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public MetricsPkg cutPiece() {
        MetricsPkg metricsPkg;
        synchronized (this) {
            if (this.count.get() > this.maxCount) {
                metricsPkg = this.pkg;
                this.pkg = new MetricsPkg(this.maxCount);
                this.count.set(0);
            } else {
                metricsPkg = null;
            }
        }
        return metricsPkg;
    }

    @Deprecated
    public void onTimer() {
        int i = this.periodCount + 1;
        this.periodCount = i;
        if (i >= this.period) {
            this.periodCount = 0;
            sendNow();
        }
    }

    public void sendNow() {
        MetricsPkg metricsPkg = this.pkg;
        this.pkg = new MetricsPkg(this.maxCount);
        this.count.set(0);
        if (!metricsPkg.isEmpty()) {
            sendPkg(metricsPkg);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportCount(int i, String str, String str2, long j) {
        reportCount(i, str, str2, j, 1);
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportReturnCode(int i, String str, long j, String str2) {
        reportReturnCode(i, str, j, str2, null);
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportCount(int i, String str, String str2, long j, int i2) {
        MetricsPkg cutPiece;
        Counter counter = new Counter(i, str, str2);
        counter.count(j, i2);
        if (this.pkg.addCounter(counter) && this.count.incrementAndGet() > this.maxCount && (cutPiece = cutPiece()) != null) {
            sendPkg(cutPiece);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportReturnCode(int i, String str, long j, String str2, Map<String, String> map) {
        MetricsPkg cutPiece;
        this.pkg.addActionResult(new ActionResult(i, str, j, str2, map));
        if (this.count.incrementAndGet() > this.maxCount && (cutPiece = cutPiece()) != null) {
            sendPkg(cutPiece);
        }
    }

    @Override // com.yy.hiidostatis.defs.interf.IMetricsAPI
    public void reportSrcData(int i, String str, String str2, long j, Map<String, String> map) {
        MetricsPkg cutPiece;
        this.pkg.addMetricsValue(new MetricsValue(i, str, str2, j, map));
        if (this.count.incrementAndGet() > this.maxCount && (cutPiece = cutPiece()) != null) {
            sendPkg(cutPiece);
        }
    }
}
