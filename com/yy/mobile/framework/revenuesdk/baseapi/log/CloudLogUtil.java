package com.yy.mobile.framework.revenuesdk.baseapi.log;

import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.heytap.mcssdk.constant.b;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudLogUtil {
    public static final String TAG = "CloudLogUtil";
    public static String mAppId = "";
    public static String mAppName = "";
    public static String mClientVer = "";
    public static String mDevice = "";
    public static String mDeviceId = "";
    public static String mOS = "";
    public static String mSdkVersion = "";
    public static String mUid = "";
    public static List<JSONObject> waitingJsonList = new LinkedList();
    public static int QUEUE_MAX_WAITING_NUM = 30;
    public static int LOG_LOOP_TIME_INTERVAL = 30;
    public static int LOP_LOPP_START_TIME_DELAY = 5;
    public static volatile boolean startLogLoop = false;

    public static synchronized void startLogLoop() {
        synchronized (CloudLogUtil.class) {
            if (startLogLoop) {
                return;
            }
            startLogLoop = true;
            Log.d(TAG, "addLogContent startLogLoop()");
            ThreadPool.getDefault().scheduledIO().scheduleAtFixedRate(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.d(CloudLogUtil.TAG, "do logLoop force send log");
                    CloudLogUtil.addLogContent((JSONObject) null, true);
                }
            }, LOP_LOPP_START_TIME_DELAY, LOG_LOOP_TIME_INTERVAL, TimeUnit.SECONDS);
        }
    }

    public static synchronized void addLogContent(final String str, final String str2) {
        synchronized (CloudLogUtil.class) {
            Log.d(TAG, "addLogContent startLogLoop:" + startLogLoop);
            ThreadPool.getDefault().scheduledIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tag", str);
                        jSONObject.put("uid", CloudLogUtil.mUid);
                        jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, CloudLogUtil.mAppId);
                        jSONObject.put(Config.DEVICE_PART, CloudLogUtil.mDevice);
                        jSONObject.put("os", CloudLogUtil.mOS);
                        jSONObject.put("appName", CloudLogUtil.mAppName);
                        jSONObject.put("clientVer", CloudLogUtil.mClientVer);
                        jSONObject.put(b.C, CloudLogUtil.mSdkVersion);
                        jSONObject.put("deviceId", CloudLogUtil.mDeviceId);
                        jSONObject.put("timestamp", System.currentTimeMillis());
                        jSONObject.put(LocalFilesFilterKt.FILTER_NAME_LOG, str2);
                        CloudLogUtil.addLogContent(jSONObject, false);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            startLogLoop();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050 A[Catch: all -> 0x0086, TryCatch #0 {, blocks: (B:5:0x0005, B:6:0x000a, B:9:0x0016, B:14:0x0022, B:16:0x0050, B:17:0x0060, B:19:0x0066, B:20:0x0073), top: B:26:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void addLogContent(JSONObject jSONObject, boolean z) {
        boolean z2;
        synchronized (CloudLogUtil.class) {
            if (jSONObject != null) {
                waitingJsonList.add(jSONObject);
            }
            if (waitingJsonList.size() < QUEUE_MAX_WAITING_NUM && (!z || waitingJsonList.size() <= 0)) {
                z2 = false;
                Log.d(TAG, "addLogContent waiting size:" + waitingJsonList.size() + " upload:" + z2 + " force:" + z);
                if (z2) {
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    for (JSONObject jSONObject2 : waitingJsonList) {
                        jSONArray.put(jSONObject2);
                        arrayList.add(jSONObject2);
                    }
                    waitingJsonList.clear();
                    LogContent logContent = new LogContent();
                    logContent.content = jSONArray;
                    logContent.copyWaitingJsonList = arrayList;
                    sendLog(logContent);
                }
            }
            z2 = true;
            Log.d(TAG, "addLogContent waiting size:" + waitingJsonList.size() + " upload:" + z2 + " force:" + z);
            if (z2) {
            }
        }
    }

    public static synchronized void doRetrySendLog(LogContent logContent) {
        synchronized (CloudLogUtil.class) {
            if (logContent != null) {
                if (logContent.copyWaitingJsonList != null && logContent.content != null) {
                    int andIncrement = logContent.retryCount.getAndIncrement();
                    Log.d(TAG, "doRetrySendLog retryTime:" + andIncrement);
                    sendLog(logContent);
                }
            }
        }
    }

    public static synchronized void retrySendLog(final LogContent logContent) {
        synchronized (CloudLogUtil.class) {
            Log.d(TAG, "delayToRetrySendLog");
            if (logContent != null && logContent.copyWaitingJsonList != null && logContent.content != null) {
                ThreadPool.getDefault().scheduledIO().schedule(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.4
                    @Override // java.lang.Runnable
                    public void run() {
                        CloudLogUtil.doRetrySendLog(LogContent.this);
                    }
                }, 5L, TimeUnit.SECONDS);
            }
        }
    }

    public static synchronized void sendLog(final LogContent logContent) {
        synchronized (CloudLogUtil.class) {
            ThreadPool.getDefault().scheduledIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.baseapi.log.CloudLogUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("project", "yylive-lpfmmobileturnover");
                        jSONObject.put("region", "cn-shenzhen");
                        jSONObject.put("logStore", "turnover");
                        jSONObject.put("content", LogContent.this.content);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    String postJson = HttpLoader.postJson("https://cloud-log.yy.com/api/log/put", jSONObject.toString());
                    Log.d(CloudLogUtil.TAG, "sendLog res=" + postJson);
                    boolean z = true;
                    if (postJson != null && !postJson.isEmpty()) {
                        try {
                            int i = new JSONObject(postJson).getInt("code");
                            Log.d(CloudLogUtil.TAG, "sendLog code=" + i);
                            if (i != 1000) {
                                if (LogContent.this.retryCount.get() > 3) {
                                    z = false;
                                }
                                Log.d(CloudLogUtil.TAG, "sendLog->2 isRetry=" + z + " retryCount=" + LogContent.this.retryCount);
                                if (z) {
                                    CloudLogUtil.retrySendLog(LogContent.this);
                                    return;
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    if (LogContent.this.retryCount.get() > 3) {
                        z = false;
                    }
                    Log.d(CloudLogUtil.TAG, "sendLog->1 isRetry=" + z + " retryCount=" + LogContent.this.retryCount);
                    if (z) {
                        CloudLogUtil.retrySendLog(LogContent.this);
                    }
                }
            });
        }
    }
}
