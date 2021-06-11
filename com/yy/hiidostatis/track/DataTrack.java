package com.yy.hiidostatis.track;

import android.content.Context;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.api.StatisOption;
import com.yy.hiidostatis.defs.StatisAPI;
import com.yy.hiidostatis.inner.GeneralProxy;
import com.yy.hiidostatis.inner.implementation.TaskManagerNew;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.log.ActLog;
import com.yy.hiidostatis.inner.util.log.L;
import com.yy.hiidostatis.pref.HdStatisConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public enum DataTrack {
    instance;
    
    public static final int INTERVAL = 600000;
    public Context mContext;
    public StatisAPI mStatisAPI;
    public StatisOption mStatisOption;
    public IDataTrackListener mDataTrackListener = null;
    public volatile boolean mIsTrack = false;
    public volatile boolean mIsEnable = false;
    public volatile long mUid = -1;
    public long reportTime = 0;

    /* loaded from: classes7.dex */
    public interface IDataTrackListener {
        JSONObject getConfig(String str, long j, String str2);
    }

    DataTrack() {
    }

    private boolean isReport() {
        return this.mIsEnable && this.mIsTrack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reportFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
        try {
        } finally {
        }
        if (isReport()) {
            if (this.mStatisOption.getAppkey().equals(str)) {
                sendLogFail(str, str2, str3, str4, num, str5, str6, str7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reportTotal() {
        try {
            String appkey = this.mStatisOption.getAppkey();
            int cacheSize = ((TaskManagerNew) GeneralProxy.getGeneralStatisInstance(this.mContext, HdStatisConfig.getConfig(appkey)).getTaskManager()).cacheSize(this.mContext);
            int[] total = ActLog.getTotal(this.mContext, appkey);
            sendLogTotal(Integer.valueOf(cacheSize), Integer.valueOf(total[0]), Integer.valueOf(total[1]), Integer.valueOf(total[2]), Integer.valueOf(total[3]), Integer.valueOf(total[4]));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void reportTotalForce() {
        if (isReport()) {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.track.DataTrack.3
                @Override // java.lang.Runnable
                public void run() {
                    DataTrack.this.reportTotal();
                }
            });
        }
    }

    private void reportTotalInterval() {
        if (this.reportTime == 0 || System.currentTimeMillis() - this.reportTime >= 600000) {
            this.reportTime = System.currentTimeMillis();
            reportTotalForce();
        }
    }

    private void sendLogFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
        try {
            StatisContent statisContent = new StatisContent();
            statisContent.put("fguid", str2);
            statisContent.put("smk", str3);
            statisContent.put("fact", str4);
            statisContent.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, num.intValue());
            statisContent.put("host", str5);
            statisContent.put("fcode", str6);
            statisContent.put("fmsg", str7);
            statisContent.put("uid", HiidoSDK.instance().getOnStatisListener().getCurrentUid());
            this.mStatisAPI.reportStatisticContent("zhlogfail", statisContent, true, false, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void sendLogTotal(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6) {
        try {
            StatisContent statisContent = new StatisContent();
            if (num != null) {
                statisContent.put("buf", num.intValue());
            }
            statisContent.put("cur", num2.intValue());
            statisContent.put("fait", num3.intValue());
            statisContent.put("suc", num4.intValue());
            statisContent.put("del", num5.intValue());
            statisContent.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, num6.intValue());
            statisContent.put("uid", HiidoSDK.instance().getOnStatisListener().getCurrentUid());
            this.mStatisAPI.reportStatisticContent("zhlogtotal", statisContent, true, false, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void trigger(boolean z) {
        long currentUid = HiidoSDK.instance().getOnStatisListener().getCurrentUid();
        if (this.mUid == -1 || this.mUid != currentUid) {
            JSONObject config = this.mDataTrackListener.getConfig(this.mStatisOption.getAppkey(), currentUid, DeviceProxy.getHdid(this.mContext));
            L.brief("json = %s", config);
            this.mIsTrack = config != null && 1 == config.getJSONObject("tzConfig").getInt("open");
            this.mUid = currentUid;
            L.brief("mUid = %d", Long.valueOf(this.mUid));
            L.brief("mIsTrack = %b", Boolean.valueOf(this.mIsTrack));
        }
        if (!this.mIsTrack) {
            ActLog.setActLogListener(null);
            this.mStatisAPI = null;
            return;
        }
        if (this.mStatisAPI == null) {
            ActLog.setActLogListener(new ActLog.ActLogListener() { // from class: com.yy.hiidostatis.track.DataTrack.2
                @Override // com.yy.hiidostatis.inner.util.log.ActLog.ActLogListener
                public void sendFail(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7) {
                    DataTrack.this.reportFail(str, str2, str3, str4, num, str5, str6, str7);
                }
            });
            this.mStatisAPI = HiidoSDK.instance().createNewStatisApi();
            StatisOption statisOption = new StatisOption();
            statisOption.setAppkey("TZ-" + this.mStatisOption.getAppkey());
            statisOption.setAppId(this.mStatisOption.getAppId());
            statisOption.setFrom(this.mStatisOption.getFrom());
            statisOption.setVer(this.mStatisOption.getVer());
            this.mStatisAPI.init(this.mContext, statisOption);
        }
        if (z) {
            reportTotalForce();
        } else {
            reportTotalInterval();
        }
    }

    public void init(Context context, StatisOption statisOption, IDataTrackListener iDataTrackListener) {
        this.mDataTrackListener = iDataTrackListener;
        this.mContext = context;
        this.mStatisOption = statisOption;
        String metaDataParam = ArdUtil.getMetaDataParam(context, "HIIDO_DATATRACK_ENABLE");
        L.brief("mIsEnable = %s", metaDataParam);
        this.mIsEnable = Boolean.parseBoolean(metaDataParam);
        L.brief("mIsEnable = %b", Boolean.valueOf(this.mIsEnable));
    }

    public void triggerTrack(final boolean z) {
        if (this.mIsEnable) {
            ThreadPool.getPool().execute(new Runnable() { // from class: com.yy.hiidostatis.track.DataTrack.1
                @Override // java.lang.Runnable
                public void run() {
                    DataTrack.this.trigger(z);
                }
            });
        }
    }
}
