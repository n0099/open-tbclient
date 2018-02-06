package com.sina.weibo.sdk.api.pay;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.share.IWeiboDownloadListener;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
/* loaded from: classes3.dex */
public class WeiboPayImpl {
    private static final String TAG = WeiboPayImpl.class.getName();
    private String mAppKey;
    private Context mContext;
    private IWeiboDownloadListener mDownloadListener;
    private WeiboAppManager.WeiboInfo mWeiboInfo;
    private boolean mNeedDownloadWeibo = true;
    private Dialog mDownloadConfirmDialog = null;

    public WeiboPayImpl(Context context, String str, boolean z) {
        this.mWeiboInfo = null;
        this.mContext = context;
        this.mAppKey = str;
        this.mWeiboInfo = WeiboAppManager.getInstance(context).getWeiboInfo();
        if (this.mWeiboInfo != null) {
            LogUtil.d(TAG, this.mWeiboInfo.toString());
        } else {
            LogUtil.d(TAG, "WeiboInfo is null");
        }
        AidTask.getInstance(context).aidTaskInit(str);
    }

    public boolean launchWeiboPay(Activity activity, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("rawdata", str);
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, 4);
        bundle.putString(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
        return launchWeiboActivity(activity, WBConstants.ACTIVITY_WEIBO_PAY, this.mWeiboInfo.getPackageName(), this.mAppKey, bundle);
    }

    private boolean launchWeiboActivity(Activity activity, String str, String str2, String str3, Bundle bundle) {
        if (activity == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            LogUtil.e(TAG, "launchWeiboActivity fail, invalid arguments");
            return false;
        }
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(str);
        String packageName = activity.getPackageName();
        intent.putExtra(WBConstants.Base.SDK_VER, WBConstants.WEIBO_SDK_VERSION_CODE);
        intent.putExtra(WBConstants.Base.APP_PKG, packageName);
        intent.putExtra(WBConstants.Base.APP_KEY, str3);
        intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(activity, packageName)));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            LogUtil.d(TAG, "launchWeiboActivity intent=" + intent + ", extra=" + intent.getExtras());
            activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
            return true;
        } catch (ActivityNotFoundException e) {
            LogUtil.e(TAG, e.getMessage());
            return false;
        }
    }

    public int getWeiboAppSupportAPI() {
        if (this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            return -1;
        }
        return this.mWeiboInfo.getSupportApi();
    }

    public boolean isWeiboAppInstalled() {
        return true;
    }

    public boolean isWeiboAppSupportAPI() {
        return getWeiboAppSupportAPI() >= 10350;
    }

    public boolean isSupportWeiboPay() {
        return getWeiboAppSupportAPI() >= 10353;
    }

    public void registerWeiboDownloadListener(IWeiboDownloadListener iWeiboDownloadListener) {
        this.mDownloadListener = iWeiboDownloadListener;
    }

    private boolean checkEnvironment(boolean z) throws WeiboShareException {
        return true;
    }
}
