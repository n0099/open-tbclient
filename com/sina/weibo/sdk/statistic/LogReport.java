package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sina.weibo.sdk.net.ConnectionFactory;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public class LogReport {
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String PRIVATE_CODE = "dqwef1864il4c9m6";
    private static final int SOCKET_TIMEOUT = 20000;
    private static String mAid;
    private static String mAppkey;
    private static String mChannel;
    private static String mKeyHash;
    public static LogReport mLogReport;
    private static String mPackageName;
    private static JSONObject mParams;
    private static String mVersionName;
    private static String UPLOADTIME = "uploadtime";
    private static String mBaseUrl = "https://api.weibo.com/2/proxy/sdk/statistic.json";

    public LogReport(Context context) {
        try {
            if (mPackageName == null) {
                mPackageName = context.getPackageName();
            }
            mAppkey = StatisticConfig.getAppkey(context);
            checkAid(context);
            mKeyHash = Utility.getSign(context, mPackageName);
            mVersionName = LogBuilder.getVersion(context);
            mChannel = StatisticConfig.getChannel(context);
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, e.toString());
        }
        initCommonParams();
    }

    private static JSONObject initCommonParams() {
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("appkey", mAppkey);
            mParams.put("platform", "Android");
            mParams.put("packagename", mPackageName);
            mParams.put("key_hash", mKeyHash);
            mParams.put("version", mVersionName);
            mParams.put("channel", mChannel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mParams;
    }

    private static boolean checkAid(Context context) {
        if (TextUtils.isEmpty(mAid)) {
            mAid = Utility.getAid(context, mAppkey);
        }
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("aid", mAid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(mAid)) {
            return false;
        }
        return true;
    }

    public static void setPackageName(String str) {
        mPackageName = str;
    }

    public static String getPackageName() {
        return mPackageName;
    }

    public static synchronized void uploadAppLogs(Context context, String str) {
        synchronized (LogReport.class) {
            if (mLogReport == null) {
                mLogReport = new LogReport(context);
            }
            if (!NetStateManager.isNetworkConnected(context)) {
                LogUtil.i(WBAgent.TAG, "network is not connected");
                LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), str, true);
            } else {
                List<JSONArray> validUploadLogs = LogBuilder.getValidUploadLogs(str);
                if (validUploadLogs == null) {
                    LogUtil.i(WBAgent.TAG, "applogs is null");
                } else {
                    ArrayList<JSONArray> arrayList = new ArrayList();
                    boolean checkAid = checkAid(context);
                    for (JSONArray jSONArray : validUploadLogs) {
                        boolean z = false;
                        if (checkAid) {
                            z = requestHttpExecute(mBaseUrl, "POST", mParams, jSONArray, context);
                        }
                        if (!z) {
                            arrayList.add(jSONArray);
                            LogUtil.e(WBAgent.TAG, "upload applogs error");
                        } else {
                            updateTime(context, Long.valueOf(System.currentTimeMillis()));
                        }
                    }
                    LogFileUtil.delete(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME));
                    if (arrayList.size() > 0) {
                        for (JSONArray jSONArray2 : arrayList) {
                            LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), jSONArray2.toString(), true);
                            LogUtil.d(WBAgent.TAG, "save failed_log");
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [227=6, 229=5, 230=5] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean requestHttpExecute(String str, String str2, JSONObject jSONObject, JSONArray jSONArray, Context context) {
        IOException e;
        UnsupportedEncodingException e2;
        HttpURLConnection createConnect;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z = false;
        if (TextUtils.isEmpty(mAppkey)) {
            LogUtil.e(WBAgent.TAG, "unexpected null AppKey");
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                if (jSONObject == null) {
                    try {
                        jSONObject = initCommonParams();
                    } catch (UnsupportedEncodingException e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                        return z;
                    } catch (IOException e5) {
                        e = e5;
                        e.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e6) {
                            }
                        }
                        return z;
                    }
                }
                try {
                    jSONObject.put("time", System.currentTimeMillis() / 1000);
                    jSONObject.put("length", jSONArray.length());
                    jSONObject.put("sign", getSign(jSONObject.getString("aid"), jSONObject.getString("appkey"), jSONObject.getLong("time")));
                    jSONObject.put("content", jSONArray);
                    LogUtil.d(WBAgent.TAG, "post content--- " + jSONObject.toString());
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
                createConnect = ConnectionFactory.createConnect(str + "?source=" + mAppkey, context);
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (StatisticConfig.isNeedGizp()) {
                    byteArrayOutputStream.write(gzipLogs(jSONObject.toString()));
                } else {
                    byteArrayOutputStream.write(jSONObject.toString().getBytes());
                }
                setPost(createConnect);
                createConnect.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(createConnect.getOutputStream());
                dataOutputStream.write(gzipLogs(jSONObject.toString()));
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = createConnect.getResponseCode();
                if (responseCode == 200) {
                    createConnect.getResponseMessage();
                    z = true;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                } else {
                    LogUtil.i(WBAgent.TAG, "status code = " + responseCode);
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e9) {
                        }
                    }
                }
            } catch (UnsupportedEncodingException e10) {
                e2 = e10;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e2.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                }
                return z;
            } catch (IOException e11) {
                e = e11;
                byteArrayOutputStream2 = byteArrayOutputStream;
                e.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e12) {
                    }
                }
                throw th;
            }
        }
        return z;
    }

    private static void setPost(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
        } catch (Exception e) {
        }
    }

    private static String getSign(String str, String str2, long j) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(str2).append(PRIVATE_CODE).append(j);
        String hexdigest = MD5.hexdigest(sb.toString());
        String substring = hexdigest.substring(hexdigest.length() - 6);
        String hexdigest2 = MD5.hexdigest(substring + substring.substring(0, 4));
        return substring + hexdigest2.substring(hexdigest2.length() - 1);
    }

    private static byte[] gzipLogs(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = str.getBytes("utf-8");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static long getTime(Context context) {
        return context.getSharedPreferences(UPLOADTIME, 0).getLong("lasttime", 0L);
    }

    private static void updateTime(Context context, Long l) {
        SharedPreferences.Editor edit = context.getSharedPreferences(UPLOADTIME, 0).edit();
        edit.putLong("lasttime", l.longValue());
        edit.commit();
    }
}
