package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.web.BaseWebViewRequestData;
import com.sina.weibo.sdk.web.WebRequestType;
/* loaded from: classes7.dex */
public abstract class BaseWebViewRequestParam {
    public BaseWebViewRequestData baseData;
    public Context context;
    public String transaction;

    /* renamed from: com.sina.weibo.sdk.web.param.BaseWebViewRequestParam$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$sina$weibo$sdk$web$WebRequestType;

        static {
            int[] iArr = new int[WebRequestType.values().length];
            $SwitchMap$com$sina$weibo$sdk$web$WebRequestType = iArr;
            try {
                iArr[WebRequestType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sina$weibo$sdk$web$WebRequestType[WebRequestType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sina$weibo$sdk$web$WebRequestType[WebRequestType.AUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface ExtraTaskCallback {
        void onComplete(String str);

        void onException(String str);
    }

    public BaseWebViewRequestParam() {
    }

    public abstract void childFillBundle(Bundle bundle);

    public void doExtraTask(ExtraTaskCallback extraTaskCallback) {
    }

    public Bundle fillBundle(Bundle bundle) {
        BaseWebViewRequestData baseWebViewRequestData = this.baseData;
        if (baseWebViewRequestData != null) {
            bundle.putSerializable(SchemeCollecter.CLASSIFY_BASE, baseWebViewRequestData);
            int i2 = AnonymousClass1.$SwitchMap$com$sina$weibo$sdk$web$WebRequestType[this.baseData.getType().ordinal()];
            if (i2 == 1) {
                bundle.putInt("type", 0);
            } else if (i2 == 2) {
                bundle.putInt("type", 1);
            } else if (i2 == 3) {
                bundle.putInt("type", 2);
            }
            bundle.putString(WBConstants.TRAN, this.transaction);
            childFillBundle(bundle);
            return bundle;
        }
        throw new NullPointerException("构造方法错误，请使用全参数的构造方法构建");
    }

    public BaseWebViewRequestData getBaseData() {
        return this.baseData;
    }

    public Context getContext() {
        return this.context;
    }

    public abstract String getRequestUrl();

    public boolean hasExtraTask() {
        return false;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void transformBundle(Bundle bundle) {
        this.baseData = (BaseWebViewRequestData) bundle.getSerializable(SchemeCollecter.CLASSIFY_BASE);
        this.transaction = bundle.getString(WBConstants.TRAN);
        transformChildBundle(bundle);
    }

    public abstract void transformChildBundle(Bundle bundle);

    public abstract void updateRequestUrl(String str);

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i2, String str2, String str3, Context context) {
        this.baseData = new BaseWebViewRequestData(authInfo, webRequestType, str, i2, str2, str3);
        this.context = context;
        this.transaction = String.valueOf(System.currentTimeMillis());
    }
}
