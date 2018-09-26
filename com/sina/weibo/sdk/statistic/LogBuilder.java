package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LogBuilder {
    private static final String APPKEY = "WEIBO_APPKEY";
    private static final String CHANNEL = "WEIBO_CHANNEL";
    public static final String KEY_AID = "aid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_CHANNEL = "channel";
    private static final String KEY_DURATION = "duration";
    public static final String KEY_END_TIME = "endtime";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_EXTEND = "extend";
    public static final String KEY_HASH = "key_hash";
    public static final String KEY_PACKAGE_NAME = "packagename";
    private static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_START_TIME = "starttime";
    private static final String KEY_TIME = "time";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    private static final int MAX_COUNT = 500;
    public static final long MAX_INTERVAL = 86400000;

    public static String getAppKey(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get(APPKEY);
                if (obj != null) {
                    LogUtil.i(WBAgent.TAG, "APPKEY: " + String.valueOf(obj));
                    return String.valueOf(obj);
                }
                LogUtil.e(WBAgent.TAG, "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml." + e);
        }
        return null;
    }

    public static String getChannel(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString(CHANNEL);
                if (string != null) {
                    LogUtil.i(WBAgent.TAG, "CHANNEL: " + string.trim());
                    return string.trim();
                }
                LogUtil.e(WBAgent.TAG, "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml." + e);
        }
        return null;
    }

    public static String getVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            LogUtil.i(WBAgent.TAG, "versionName: " + packageInfo.versionName);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(WBAgent.TAG, "Could not read versionName from AndroidManifest.xml." + e);
            return null;
        }
    }

    public static String getPageLogs(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<PageLog> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            sb.append(getLogInfo(it.next()).toString()).append(",");
        }
        return sb.toString();
    }

    private static JSONObject getLogInfo(PageLog pageLog) {
        JSONObject jSONObject = new JSONObject();
        try {
            switch (pageLog.getType()) {
                case SESSION_START:
                    jSONObject.put("type", 0);
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    break;
                case SESSION_END:
                    jSONObject.put("type", 1);
                    jSONObject.put("time", pageLog.getEndTime() / 1000);
                    jSONObject.put(KEY_DURATION, pageLog.getDuration() / 1000);
                    break;
                case FRAGMENT:
                    jSONObject.put("type", 2);
                    jSONObject.put("page_id", pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    jSONObject.put(KEY_DURATION, pageLog.getDuration() / 1000);
                    break;
                case EVENT:
                    jSONObject.put("type", 3);
                    jSONObject.put("page_id", pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    addEventData(jSONObject, (EventLog) pageLog);
                    break;
                case ACTIVITY:
                    jSONObject.put("type", 4);
                    jSONObject.put("page_id", pageLog.getPage_id());
                    jSONObject.put("time", pageLog.getStartTime() / 1000);
                    jSONObject.put(KEY_DURATION, pageLog.getDuration() / 1000);
                    break;
                case APP_AD_START:
                    AdEventLog adEventLog = (AdEventLog) pageLog;
                    jSONObject.put("type", 0);
                    jSONObject.put("page_id", adEventLog.getmImei());
                    jSONObject.put("time", adEventLog.getStartTime());
                    jSONObject.put("aid", adEventLog.getmAid());
                    addEventData(jSONObject, adEventLog);
                    break;
            }
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "get page log error." + e);
        }
        return jSONObject;
    }

    private static JSONObject addEventData(JSONObject jSONObject, EventLog eventLog) {
        int i;
        try {
            jSONObject.put("event_id", eventLog.getEvent_id());
            if (eventLog.getExtend() != null) {
                Map<String, String> extend = eventLog.getExtend();
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (String str : extend.keySet()) {
                    if (i2 >= 10) {
                        break;
                    }
                    if (TextUtils.isEmpty(extend.get(str))) {
                        i = i2;
                    } else {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(str).append(":").append(extend.get(str));
                        i = i2 + 1;
                    }
                    i2 = i;
                }
                jSONObject.put(KEY_EXTEND, sb.toString());
            }
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, "add event log error." + e);
        }
        return jSONObject;
    }

    public static List<JSONArray> getValidUploadLogs(String str) {
        String buildUploadLogs = buildUploadLogs(str);
        if (TextUtils.isEmpty(buildUploadLogs)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONArray jSONArray2 = new JSONObject(buildUploadLogs).getJSONArray("applogs");
            int i = 0;
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i2);
                if (isDataValid(currentTimeMillis, jSONObject.getLong("time") * 1000)) {
                    if (i < 500) {
                        jSONArray.put(jSONObject);
                        i++;
                    } else {
                        arrayList.add(jSONArray);
                        jSONArray = new JSONArray();
                        i = 0;
                    }
                }
            }
            if (jSONArray.length() > 0) {
                arrayList.add(jSONArray);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private static String buildUploadLogs(String str) {
        String appLogs = LogFileUtil.getAppLogs(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME));
        if (TextUtils.isEmpty(appLogs) && TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{applogs:[");
        if (!TextUtils.isEmpty(appLogs)) {
            sb.append(appLogs);
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (sb.charAt(sb.length() - 1) == ',') {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        sb.append("]}");
        return sb.toString();
    }

    private static boolean isDataValid(long j, long j2) {
        return j - j2 < 86400000;
    }
}
