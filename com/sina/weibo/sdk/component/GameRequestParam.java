package com.sina.weibo.sdk.component;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.constant.WBConstants;
/* loaded from: classes3.dex */
public class GameRequestParam extends BrowserRequestParamBase {
    private String mAppKey;
    private WeiboAuthListener mAuthListener;
    private String mAuthListenerKey;
    private String mToken;

    /* loaded from: classes3.dex */
    public interface WidgetRequestCallback {
        void onWebViewResult(String str);
    }

    public GameRequestParam(Context context) {
        super(context);
        this.mLaucher = BrowserLauncher.WIDGET;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    protected void onSetupRequestParam(Bundle bundle) {
        this.mAppKey = bundle.getString("source");
        this.mToken = bundle.getString("access_token");
        this.mAuthListenerKey = bundle.getString(AuthRequestParam.EXTRA_KEY_LISTENER);
        if (!TextUtils.isEmpty(this.mAuthListenerKey)) {
            this.mAuthListener = WeiboCallbackManager.getInstance(this.mContext).getWeiboAuthListener(this.mAuthListenerKey);
        }
        this.mUrl = buildUrl(this.mUrl);
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void onCreateRequestParamBundle(Bundle bundle) {
        bundle.putString("access_token", this.mToken);
        bundle.putString("source", this.mAppKey);
        WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance(this.mContext);
        if (this.mAuthListener != null) {
            this.mAuthListenerKey = weiboCallbackManager.genCallbackKey();
            weiboCallbackManager.setWeiboAuthListener(this.mAuthListenerKey, this.mAuthListener);
            bundle.putString(AuthRequestParam.EXTRA_KEY_LISTENER, this.mAuthListenerKey);
        }
    }

    private String buildUrl(String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("version", WBConstants.WEIBO_SDK_VERSION_CODE);
        if (!TextUtils.isEmpty(this.mAppKey)) {
            buildUpon.appendQueryParameter("source", this.mAppKey);
        }
        if (!TextUtils.isEmpty(this.mToken)) {
            buildUpon.appendQueryParameter("access_token", this.mToken);
        }
        return buildUpon.build().toString();
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public void setAppKey(String str) {
        this.mAppKey = str;
    }

    public WeiboAuthListener getAuthListener() {
        return this.mAuthListener;
    }

    public String getAuthListenerKey() {
        return this.mAuthListenerKey;
    }

    public void setAuthListener(WeiboAuthListener weiboAuthListener) {
        this.mAuthListener = weiboAuthListener;
    }

    @Override // com.sina.weibo.sdk.component.BrowserRequestParamBase
    public void execRequest(Activity activity, int i) {
    }
}
