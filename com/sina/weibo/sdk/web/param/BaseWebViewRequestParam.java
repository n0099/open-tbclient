package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.web.BaseWebViewRequestData;
import com.sina.weibo.sdk.web.WebRequestType;
/* loaded from: classes6.dex */
public abstract class BaseWebViewRequestParam {
    private BaseWebViewRequestData baseData;
    protected Context context;
    private String transaction;

    /* loaded from: classes6.dex */
    public interface ExtraTaskCallback {
        void onComplete(String str);

        void onException(String str);
    }

    protected abstract void childFillBundle(Bundle bundle);

    public abstract String getRequestUrl();

    protected abstract void transformChildBundle(Bundle bundle);

    public abstract void updateRequestUrl(String str);

    public BaseWebViewRequestParam() {
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context) {
        this.baseData = new BaseWebViewRequestData(authInfo, webRequestType, str, i, str2, str3);
        this.context = context;
        this.transaction = String.valueOf(System.currentTimeMillis());
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    public Bundle fillBundle(Bundle bundle) {
        if (this.baseData == null) {
            throw new NullPointerException("构造方法错误，请使用全参数的构造方法构建");
        }
        bundle.putSerializable(SchemeCollecter.CLASSIFY_BASE, this.baseData);
        switch (this.baseData.getType()) {
            case DEFAULT:
                bundle.putInt("type", 0);
                break;
            case SHARE:
                bundle.putInt("type", 1);
                break;
            case AUTH:
                bundle.putInt("type", 2);
                break;
        }
        bundle.putString(WBConstants.TRAN, this.transaction);
        childFillBundle(bundle);
        return bundle;
    }

    public void transformBundle(Bundle bundle) {
        this.baseData = (BaseWebViewRequestData) bundle.getSerializable(SchemeCollecter.CLASSIFY_BASE);
        this.transaction = bundle.getString(WBConstants.TRAN);
        transformChildBundle(bundle);
    }

    public boolean hasExtraTask() {
        return false;
    }

    public void doExtraTask(ExtraTaskCallback extraTaskCallback) {
    }

    public BaseWebViewRequestData getBaseData() {
        return this.baseData;
    }
}
