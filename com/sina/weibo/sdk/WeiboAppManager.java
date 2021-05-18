package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class WeiboAppManager {
    public static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    public static final String TAG = "com.sina.weibo.sdk.WeiboAppManager";
    public static final String WEIBO_4G_PACKAGENAME = "com.sina.weibog3";
    public static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    public static final String WEIBO_PACKAGENAME = "com.sina.weibo";
    public static WeiboAppManager sInstance;
    public Context mContext;
    public WbAppInfo wbAppInfo;

    public WeiboAppManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized WeiboAppManager getInstance(Context context) {
        WeiboAppManager weiboAppManager;
        synchronized (WeiboAppManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboAppManager(context);
            }
            weiboAppManager = sInstance;
        }
        return weiboAppManager;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007b, code lost:
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007c, code lost:
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WbAppInfo parseWbInfoByAsset(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            inputStream = context.createPackageContext(str, 2).getAssets().open(SDK_INT_FILE_NAME);
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = inputStream.read(bArr, 0, 4096);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    if (!TextUtils.isEmpty(sb.toString())) {
                        ApiUtils.validateWeiboSign(context, str);
                    }
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    int optInt = jSONObject.optInt("support_api", -1);
                    String optString = jSONObject.optString("authActivityName", null);
                    if (optInt != -1 && !TextUtils.isEmpty(optString)) {
                        WbAppInfo wbAppInfo = new WbAppInfo();
                        wbAppInfo.setPackageName(str);
                        wbAppInfo.setSupportVersion(optInt);
                        wbAppInfo.setAuthActivityName(optString);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return wbAppInfo;
                    }
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
    }

    public static WbAppInfo queryWbInfoByAsset(Context context) {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        WbAppInfo wbAppInfo = null;
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && serviceInfo.applicationInfo != null && !TextUtils.isEmpty(serviceInfo.packageName)) {
                    String str = resolveInfo.serviceInfo.packageName;
                    WbAppInfo parseWbInfoByAsset = parseWbInfoByAsset(context, str);
                    if (parseWbInfoByAsset != null) {
                        wbAppInfo = parseWbInfoByAsset;
                    }
                    if ("com.sina.weibo".equals(str) || WEIBO_4G_PACKAGENAME.equals(str)) {
                        break;
                    }
                }
            }
        }
        return wbAppInfo;
    }

    public static WbAppInfo queryWbInfoInternal(Context context) {
        return queryWbInfoByAsset(context);
    }

    public synchronized WbAppInfo getWbAppInfo() {
        return queryWbInfoInternal(this.mContext);
    }

    @Deprecated
    public boolean hasWbInstall() {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
    }
}
