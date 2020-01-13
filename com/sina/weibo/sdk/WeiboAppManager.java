package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class WeiboAppManager {
    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String TAG = WeiboAppManager.class.getName();
    private static final String WEIBO_4G_PACKAGENAME = "com.sina.weibog3";
    public static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static final String WEIBO_PACKAGENAME = "com.sina.weibo";
    private static WeiboAppManager sInstance;
    private Context mContext;
    private WbAppInfo wbAppInfo;

    private WeiboAppManager(Context context) {
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

    public synchronized WbAppInfo getWbAppInfo() {
        return queryWbInfoInternal(this.mContext);
    }

    public static WbAppInfo queryWbInfoInternal(Context context) {
        return queryWbInfoByAsset(context);
    }

    @Deprecated
    public boolean hasWbInstall() {
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        return (queryIntentServices == null || queryIntentServices.isEmpty()) ? false : true;
    }

    private static WbAppInfo queryWbInfoByAsset(Context context) {
        WbAppInfo wbAppInfo = null;
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.applicationInfo != null && !TextUtils.isEmpty(resolveInfo.serviceInfo.packageName)) {
                String str = resolveInfo.serviceInfo.packageName;
                WbAppInfo parseWbInfoByAsset = parseWbInfoByAsset(context, str);
                if (parseWbInfoByAsset == null) {
                    parseWbInfoByAsset = wbAppInfo;
                }
                if ("com.sina.weibo".equals(str) || WEIBO_4G_PACKAGENAME.equals(str)) {
                    return parseWbInfoByAsset;
                }
                wbAppInfo = parseWbInfoByAsset;
            }
        }
        return wbAppInfo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [140=5, 142=4, 143=4, 144=4] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static WbAppInfo parseWbInfoByAsset(Context context, String str) {
        InputStream inputStream;
        Throwable th;
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
                    if (TextUtils.isEmpty(sb.toString()) || !ApiUtils.validateWeiboSign(context, str)) {
                    }
                    JSONObject jSONObject = new JSONObject(sb.toString());
                    int optInt = jSONObject.optInt("support_api", -1);
                    String optString = jSONObject.optString("authActivityName", null);
                    if (optInt == -1 || TextUtils.isEmpty(optString)) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return null;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    }
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
                } catch (Exception e3) {
                    e = e3;
                    LogUtil.e(TAG, e.getMessage());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th3) {
            inputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            throw th;
        }
    }
}
