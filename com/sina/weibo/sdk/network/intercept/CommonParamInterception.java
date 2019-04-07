package com.sina.weibo.sdk.network.intercept;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.exception.InterceptException;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class CommonParamInterception implements IRequestIntercept {
    public static String aidInfo;
    private static String appKey;

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean needIntercept(IRequestParam iRequestParam, Bundle bundle) {
        return true;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    @Override // com.sina.weibo.sdk.network.IRequestIntercept
    public boolean doIntercept(IRequestParam iRequestParam, Bundle bundle) throws InterceptException {
        Bundle postBundle;
        String str;
        if (TextUtils.isEmpty(aidInfo)) {
            aidInfo = loadAidFromCache(iRequestParam.getContext());
        }
        if (TextUtils.isEmpty(aidInfo)) {
            try {
                aidInfo = AidTask.getInstance(iRequestParam.getContext()).loadAidFromNet();
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(aidInfo)) {
            throw new InterceptException("aid get error");
        }
        if (!TextUtils.isEmpty(aidInfo)) {
            bundle.putString("aid", aidInfo);
        }
        String url = iRequestParam.getUrl();
        if (TextUtils.isEmpty(url) || url.startsWith("https://api.weibo.cn/2/sdk/login")) {
        }
        if (iRequestParam.getMethod() == IRequestParam.RequestType.GET) {
            postBundle = iRequestParam.getGetBundle();
        } else {
            postBundle = iRequestParam.getPostBundle();
        }
        Object obj = postBundle.get("access_token");
        Object obj2 = postBundle.get(Oauth2AccessToken.KEY_REFRESH_TOKEN);
        Object obj3 = postBundle.get(ISapiAccount.SAPI_ACCOUNT_PHONE);
        if (obj != null && (obj instanceof String)) {
            str = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str = (String) obj2;
        } else if (obj3 == null || !(obj3 instanceof String)) {
            str = "";
        } else {
            str = (String) obj3;
        }
        String timestamp = getTimestamp();
        bundle.putString("oauth_timestamp", timestamp);
        bundle.putString("oauth_sign", HttpManager.getOauthSign(iRequestParam.getContext(), aidInfo, str, appKey, timestamp));
        LogUtil.e("weiboSdk param", aidInfo + "  " + timestamp + "  " + appKey + "   " + str);
        if (iRequestParam.getMethod() == IRequestParam.RequestType.GET) {
            iRequestParam.getGetBundle().remove("appKey");
            return false;
        }
        iRequestParam.getPostBundle().remove("appKey");
        return false;
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public String loadAidFromCache(Context context) {
        AidTask.AidInfo loadAidInfoFromCache = loadAidInfoFromCache(context);
        return (loadAidInfoFromCache == null || loadAidInfoFromCache.getAid() == null) ? "" : loadAidInfoFromCache.getAid();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [120=4] */
    protected synchronized AidTask.AidInfo loadAidInfoFromCache(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        AidTask.AidInfo aidInfo2 = null;
        synchronized (this) {
            try {
                fileInputStream = new FileInputStream(getAidInfoFile(1, context));
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    aidInfo2 = AidTask.AidInfo.parseJson(new String(bArr));
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
                    return aidInfo2;
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
        return aidInfo2;
    }

    private File getAidInfoFile(int i, Context context) {
        return new File(context.getFilesDir(), "weibo_sdk_aid" + i);
    }
}
