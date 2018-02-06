package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
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

    private static void checkAid(Context context) {
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
            if (!isNetworkConnected(context)) {
                LogUtil.i(WBAgent.TAG, "network is not connected");
                LogFileUtil.writeToFile(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME), str, true);
            } else {
                List<JSONArray> validUploadLogs = LogBuilder.getValidUploadLogs(str);
                if (validUploadLogs == null) {
                    LogUtil.i(WBAgent.TAG, "applogs is null");
                } else {
                    ArrayList<JSONArray> arrayList = new ArrayList();
                    checkAid(context);
                    for (JSONArray jSONArray : validUploadLogs) {
                        HttpResponse requestHttpExecute = requestHttpExecute(mBaseUrl, "POST", mParams, jSONArray);
                        if (requestHttpExecute == null || requestHttpExecute.getStatusLine().getStatusCode() != 200) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [243=6, 245=6, 249=6] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0150 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x0193 */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0166 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static HttpResponse requestHttpExecute(String str, String str2, JSONObject jSONObject, JSONArray jSONArray) {
        HttpClient httpClient;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        HttpClient httpClient2;
        HttpClient httpClient3;
        HttpGet httpGet;
        HttpResponse httpResponse = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            try {
                httpClient2 = HttpManager.getNewHttpClient();
                if (jSONObject == null) {
                    try {
                        jSONObject = initCommonParams();
                    } catch (UnsupportedEncodingException e) {
                        e = e;
                        byteArrayOutputStream = null;
                        httpClient3 = httpClient2;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        shutdownHttpClient(httpClient3);
                        return httpResponse;
                    } catch (ClientProtocolException e2) {
                        e = e2;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        shutdownHttpClient(httpClient2);
                        return httpResponse;
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        shutdownHttpClient(httpClient2);
                        return httpResponse;
                    } catch (Throwable th2) {
                        byteArrayOutputStream2 = null;
                        th = th2;
                        httpClient = httpClient2;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                        shutdownHttpClient(httpClient);
                        throw th;
                    }
                }
                try {
                    jSONObject.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, System.currentTimeMillis() / 1000);
                    jSONObject.put("length", jSONArray.length());
                    jSONObject.put("sign", getSign(jSONObject.getString("aid"), jSONObject.getString("appkey"), jSONObject.getLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME)));
                    jSONObject.put("content", jSONArray);
                    LogUtil.d(WBAgent.TAG, "post content--- " + jSONObject.toString());
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (UnsupportedEncodingException e6) {
            e = e6;
            byteArrayOutputStream = null;
            httpClient3 = null;
        } catch (ClientProtocolException e7) {
            e = e7;
            byteArrayOutputStream = null;
            httpClient2 = null;
        } catch (IOException e8) {
            e = e8;
            byteArrayOutputStream = null;
            httpClient2 = null;
        } catch (Throwable th4) {
            byteArrayOutputStream2 = null;
            httpClient = null;
            th = th4;
        }
        if (str2.equals("GET")) {
            byteArrayOutputStream = null;
            httpGet = new HttpGet(String.valueOf(str) + "?" + jSONObject.toString());
        } else if (!str2.equals("POST")) {
            httpGet = null;
            byteArrayOutputStream = null;
        } else if (TextUtils.isEmpty(mAppkey)) {
            LogUtil.e(WBAgent.TAG, "unexpected null AppKey");
            if (0 != 0) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e9) {
                }
            }
            shutdownHttpClient(httpClient2);
            return httpResponse;
        } else {
            HttpPost newHttpPost = getNewHttpPost(String.valueOf(str) + "?source=" + mAppkey, jSONObject);
            Log.i("weibo_demo", jSONObject.toString());
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                if (StatisticConfig.isNeedGizp()) {
                    byteArrayOutputStream.write(gzipLogs(jSONObject.toString()));
                } else {
                    byteArrayOutputStream.write(jSONObject.toString().getBytes());
                }
                newHttpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream.toByteArray()));
                httpGet = newHttpPost;
            } catch (UnsupportedEncodingException e10) {
                e = e10;
                httpClient3 = httpClient2;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e11) {
                    }
                }
                shutdownHttpClient(httpClient3);
                return httpResponse;
            } catch (ClientProtocolException e12) {
                e = e12;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e13) {
                    }
                }
                shutdownHttpClient(httpClient2);
                return httpResponse;
            } catch (IOException e14) {
                e = e14;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e15) {
                    }
                }
                shutdownHttpClient(httpClient2);
                return httpResponse;
            }
        }
        httpResponse = httpClient2.execute(httpGet);
        LogUtil.i(WBAgent.TAG, "status code = " + httpResponse.getStatusLine().getStatusCode());
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
            }
        }
        shutdownHttpClient(httpClient2);
        return httpResponse;
    }

    private static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            LogUtil.e(WBAgent.TAG, "unexpected null context in isNetworkConnected");
            return false;
        } else if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            return false;
        } else {
            try {
                networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (NullPointerException e) {
                networkInfo = null;
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
    }

    private static synchronized HttpPost getNewHttpPost(String str, JSONObject jSONObject) {
        HttpPost httpPost;
        synchronized (LogReport.class) {
            httpPost = new HttpPost(str);
            httpPost.setHeader("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            httpPost.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpPost.addHeader(HTTP.CONTENT_ENCODING, StatisticConfig.isNeedGizp() ? "gzip" : "charset=UTF-8");
            httpPost.addHeader("Accept", "*/*");
            httpPost.addHeader("Accept-Language", "en-us");
            httpPost.addHeader("Accept-Encoding", "gzip");
        }
        return httpPost;
    }

    private static String getSign(String str, String str2, long j) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(str2).append(PRIVATE_CODE).append(j);
        String hexdigest = MD5.hexdigest(sb.toString());
        String substring = hexdigest.substring(hexdigest.length() - 6);
        String hexdigest2 = MD5.hexdigest(String.valueOf(substring) + substring.substring(0, 4));
        return String.valueOf(substring) + hexdigest2.substring(hexdigest2.length() - 1);
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

    private static void shutdownHttpClient(HttpClient httpClient) {
        if (httpClient != null) {
            try {
                httpClient.getConnectionManager().closeExpiredConnections();
            } catch (Exception e) {
            }
        }
    }
}
