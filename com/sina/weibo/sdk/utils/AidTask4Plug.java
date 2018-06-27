package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.common.security.RSAUtil;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.meizu.cloud.pushsdk.constants.MeizuConstants;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AidTask4Plug {
    private static final String AID_FILE_NAME = "weibo_sdk_aid";
    private static final int MAX_RETRY_NUM = 3;
    private static final String TAG = "AidTask";
    private static final int VERSION = 1;
    public static final int WHAT_LOAD_AID_ERR = 1002;
    public static final int WHAT_LOAD_AID_SUC = 1001;
    private static AidTask4Plug sInstance;
    private String hash;
    private Map<String, AidInfo> mAidInfo = new HashMap(3);
    private String mAppKey;
    private Context mContext;
    private CallbackHandler mHandler;
    private String pkg;

    /* loaded from: classes2.dex */
    public interface AidResultCallBack {
        void onAidGenFailed(Exception exc);

        void onAidGenSuccessed(AidInfo aidInfo);
    }

    /* loaded from: classes2.dex */
    private static class CallbackHandler extends Handler {
        private WeakReference<AidResultCallBack> callBackReference;

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public void setCallback(AidResultCallBack aidResultCallBack) {
            if (this.callBackReference != null) {
                if (this.callBackReference.get() != aidResultCallBack) {
                    this.callBackReference = new WeakReference<>(aidResultCallBack);
                    return;
                }
                return;
            }
            this.callBackReference = new WeakReference<>(aidResultCallBack);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AidResultCallBack aidResultCallBack = this.callBackReference.get();
            switch (message.what) {
                case 1001:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenSuccessed(((AidInfo) message.obj).cloneAidInfo());
                        return;
                    }
                    return;
                case 1002:
                    if (aidResultCallBack != null) {
                        aidResultCallBack.onAidGenFailed((WeiboException) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class AidInfo {
        private String mAid;
        private String mSubCookie;

        public String getAid() {
            return this.mAid;
        }

        public String getSubCookie() {
            return this.mSubCookie;
        }

        public static AidInfo parseJson(String str) throws WeiboException {
            AidInfo aidInfo = new AidInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("error") || jSONObject.has(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE)) {
                    LogUtil.d(AidTask4Plug.TAG, "loadAidFromNet has error !!!");
                    throw new WeiboException("loadAidFromNet has error !!!");
                }
                aidInfo.mAid = jSONObject.optString("aid", "");
                aidInfo.mSubCookie = jSONObject.optString("sub", "");
                return aidInfo;
            } catch (JSONException e) {
                LogUtil.d(AidTask4Plug.TAG, "loadAidFromNet JSONException Msg : " + e.getMessage());
                throw new WeiboException("loadAidFromNet has error !!!");
            }
        }

        AidInfo cloneAidInfo() {
            AidInfo aidInfo = new AidInfo();
            aidInfo.mAid = this.mAid;
            aidInfo.mSubCookie = this.mSubCookie;
            return aidInfo;
        }
    }

    public synchronized void setAppkey(String str) {
        this.mAppKey = str;
    }

    private AidTask4Plug(Context context, final String str) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
        new Thread(new Runnable() { // from class: com.sina.weibo.sdk.utils.AidTask4Plug.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < 1; i++) {
                    try {
                        AidTask4Plug.this.getAidInfoFile(i, str).delete();
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }

    public static synchronized AidTask4Plug getInstance(Context context, String str) {
        AidTask4Plug aidTask4Plug;
        synchronized (AidTask4Plug.class) {
            if (sInstance == null) {
                sInstance = new AidTask4Plug(context, str);
            }
            aidTask4Plug = sInstance;
        }
        return aidTask4Plug;
    }

    public void aidTaskInit(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "aidTaskInit ");
            initAidInfo(str);
        }
    }

    private AidInfo aidTaskInit(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.e(TAG, "aidTaskInit ");
        return initAidInfo(str, str2, str3);
    }

    public AidInfo initAidInfo(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.mAppKey = str;
        this.pkg = str2;
        this.hash = str3;
        AidInfo loadAidInfoFromCache = loadAidInfoFromCache(str);
        if (loadAidInfoFromCache == null) {
            int i = 1;
            do {
                i++;
                try {
                    String loadAidFromNet = loadAidFromNet();
                    loadAidInfoFromCache = AidInfo.parseJson(loadAidFromNet);
                    cacheAidInfo(loadAidFromNet, str);
                    this.mAidInfo.put(str, loadAidInfoFromCache);
                    return loadAidInfoFromCache;
                } catch (WeiboException e) {
                    LogUtil.e(TAG, "AidTaskInit WeiboException Msg : " + e.getMessage());
                    if (i >= 3) {
                        return loadAidInfoFromCache;
                    }
                }
            } while (i >= 3);
            return loadAidInfoFromCache;
        }
        this.mAidInfo.put(str, loadAidInfoFromCache);
        return loadAidInfoFromCache;
    }

    private void initAidInfo(String str) {
        initAidInfo(str, null, null);
    }

    public AidInfo getAid4PlugSync(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        LogUtil.e(TAG, "getAidSync ");
        if (this.mAidInfo.get(str) == null) {
            aidTaskInit(str, str2, str3);
        }
        return this.mAidInfo.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=4] */
    protected synchronized AidInfo loadAidInfoFromCache(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        AidInfo aidInfo = null;
        synchronized (this) {
            try {
                fileInputStream = new FileInputStream(getAidInfoFile(1, str));
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    aidInfo = AidInfo.parseJson(new String(bArr));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return aidInfo;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        }
        return aidInfo;
    }

    public String loadAidFromCache(String str) {
        AidInfo loadAidInfoFromCache = loadAidInfoFromCache(str);
        return (loadAidInfoFromCache == null || loadAidInfoFromCache.getAid() == null) ? "" : loadAidInfoFromCache.getAid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File getAidInfoFile(int i, String str) {
        return new File(this.mContext.getFilesDir(), AID_FILE_NAME + str + i);
    }

    private String loadAidFromNet() throws WeiboException {
        String packageName = this.pkg == null ? this.mContext.getPackageName() : this.pkg;
        String sign = this.hash == null ? Utility.getSign(this.mContext, packageName) : this.hash;
        String mfp = getMfp(this.mContext);
        WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
        weiboParameters.put("appkey", this.mAppKey);
        weiboParameters.put("mfp", mfp);
        weiboParameters.put("packagename", packageName);
        weiboParameters.put("key_hash", sign);
        try {
            String openUrl = HttpManager.openUrl(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", weiboParameters);
            LogUtil.d(TAG, "loadAidFromNet response : " + openUrl);
            return openUrl;
        } catch (WeiboException e) {
            LogUtil.d(TAG, "loadAidFromNet WeiboException Msg : " + e.getMessage());
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [341=4] */
    private synchronized void cacheAidInfo(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(getAidInfoFile(1, str2));
                try {
                    fileOutputStream.write(str.getBytes());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Exception e2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private static String getMfp(Context context) {
        String str;
        try {
            str = new String(genMfpString(context).getBytes(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str = "";
        }
        LogUtil.d(TAG, "genMfpString() utf-8 string : " + str);
        try {
            String encryptRsa = encryptRsa(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
            LogUtil.d(TAG, "encryptRsa() string : " + encryptRsa);
            return encryptRsa;
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage());
            return "";
        }
    }

    private static String genMfpString(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String os = getOS();
            if (!TextUtils.isEmpty(os)) {
                jSONObject.put("1", os);
            }
            String imei = getImei(context);
            if (!TextUtils.isEmpty(imei)) {
                jSONObject.put("2", imei);
            }
            String meid = getMeid(context);
            if (!TextUtils.isEmpty(meid)) {
                jSONObject.put("3", meid);
            }
            String imsi = getImsi(context);
            if (!TextUtils.isEmpty(imsi)) {
                jSONObject.put("4", imsi);
            }
            String mac = getMac(context);
            if (!TextUtils.isEmpty(mac)) {
                jSONObject.put("5", mac);
            }
            String iccid = getIccid(context);
            if (!TextUtils.isEmpty(iccid)) {
                jSONObject.put(Constants.VIA_SHARE_TYPE_INFO, iccid);
            }
            String serialNo = getSerialNo();
            if (!TextUtils.isEmpty(serialNo)) {
                jSONObject.put("7", serialNo);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, androidId);
            }
            String cpu = getCpu();
            if (!TextUtils.isEmpty(cpu)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_JOININ_GROUP, cpu);
            }
            String model = getModel();
            if (!TextUtils.isEmpty(model)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, model);
            }
            String sdSize = getSdSize();
            if (!TextUtils.isEmpty(sdSize)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, sdSize);
            }
            String resolution = getResolution(context);
            if (!TextUtils.isEmpty(resolution)) {
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, resolution);
            }
            String ssid = getSsid(context);
            if (!TextUtils.isEmpty(ssid)) {
                jSONObject.put("17", ssid);
            }
            String deviceName = getDeviceName();
            if (!TextUtils.isEmpty(deviceName)) {
                jSONObject.put("18", deviceName);
            }
            String connectType = getConnectType(context);
            if (!TextUtils.isEmpty(connectType)) {
                jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, connectType);
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    private static String encryptRsa(String str, String str2) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] doFinal;
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, getPublicKey(str2));
        byte[] bytes = str.getBytes("UTF-8");
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            while (true) {
                try {
                    int splite = splite(bytes, i, 117);
                    if (splite == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(cipher.doFinal(bytes, i, splite));
                    LogUtil.d(TAG, "encryptRsa offset = " + i + "     len = " + splite + "     enBytes len = " + doFinal.length);
                    i += splite;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    throw th;
                }
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            LogUtil.d(TAG, "encryptRsa total enBytes len = " + byteArray.length);
            byte[] encodebyte = Base64.encodebyte(byteArray);
            LogUtil.d(TAG, "encryptRsa total base64byte len = " + encodebyte.length);
            String str3 = "01" + new String(encodebyte, "UTF-8");
            LogUtil.d(TAG, "encryptRsa total base64string : " + str3);
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                }
            }
            return str3;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    private static int splite(byte[] bArr, int i, int i2) {
        if (i >= bArr.length) {
            return -1;
        }
        return Math.min(bArr.length - i, i2);
    }

    private static PublicKey getPublicKey(String str) throws Exception {
        return KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes())));
    }

    private static String getOS() {
        try {
            return "Android " + Build.VERSION.RELEASE;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMeid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getImsi(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSubscriberId();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getMac(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) ? "" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getIccid(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getSimSerialNumber();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSerialNo() {
        try {
            Class<?> cls = Class.forName(MeizuConstants.CLS_NAME_SYSTEM_PROPERTIES);
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception e) {
            return "";
        }
    }

    private static String getAndroidId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e) {
            return "";
        }
    }

    private static String getCpu() {
        try {
            return Build.CPU_ABI;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getModel() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSdSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return Long.toString(statFs.getBlockCount() * statFs.getBlockSize());
        } catch (Exception e) {
            return "";
        }
    }

    private static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            return String.valueOf(displayMetrics.widthPixels) + "*" + String.valueOf(displayMetrics.heightPixels);
        } catch (Exception e) {
            return "";
        }
    }

    private static String getSsid(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                return connectionInfo.getSSID();
            }
        } catch (Exception e) {
        }
        return "";
    }

    private static String getDeviceName() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            return "";
        }
    }

    private static String getConnectType(Context context) {
        String str;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            str = "2G";
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            str = "3G";
                            break;
                        case 13:
                            str = "4G";
                            break;
                        default:
                            str = "none";
                            break;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    str = "wifi";
                }
                return str;
            }
            str = "none";
            return str;
        } catch (Exception e) {
            return "none";
        }
    }
}
