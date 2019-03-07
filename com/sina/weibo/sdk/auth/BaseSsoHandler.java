package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.AuthWebViewRequestParam;
/* loaded from: classes2.dex */
public class BaseSsoHandler {
    protected static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    protected WbAuthListener authListener;
    protected Context mAuthActivity;
    protected final int SSO_TYPE_INVALID = 3;
    protected int ssoRequestCode = -1;
    protected int ssoRequestType = 3;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    public BaseSsoHandler(Activity activity) {
        this.mAuthActivity = activity;
        AidTask.getInstance(this.mAuthActivity).aidTaskInit(WbSdk.getAuthInfo().getAppKey());
    }

    public BaseSsoHandler(Context context) {
        this.mAuthActivity = context;
        AidTask.getInstance(this.mAuthActivity).aidTaskInit(WbSdk.getAuthInfo().getAppKey());
    }

    public void authorize(WbAuthListener wbAuthListener) {
        authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.ALL);
    }

    public void authorizeClientSso(WbAuthListener wbAuthListener) {
        authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.SsoOnly);
    }

    public void authorizeWeb(WbAuthListener wbAuthListener) {
        authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.WebOnly);
    }

    private void authorize(int i, WbAuthListener wbAuthListener, AuthType authType) {
        resetIntentFillData();
        if (wbAuthListener == null) {
            throw new RuntimeException("please set auth listener");
        }
        this.authListener = wbAuthListener;
        if (authType == AuthType.WebOnly) {
            if (wbAuthListener != null) {
                startWebAuth();
                return;
            }
            return;
        }
        boolean z = false;
        if (authType == AuthType.SsoOnly) {
            z = true;
        }
        if (isWbAppInstalled()) {
            startClientAuth(i);
        } else if (z) {
            this.authListener.onFailure(new WbConnectErrorMessage());
        } else {
            startWebAuth();
        }
    }

    protected void startClientAuth(int i) {
        try {
            WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo();
            Intent intent = new Intent();
            intent.setClassName(wbAppInfo.getPackageName(), wbAppInfo.getAuthActivityName());
            intent.putExtras(WbSdk.getAuthInfo().getAuthBundle());
            intent.putExtra(WBConstants.COMMAND_TYPE_KEY, 3);
            intent.putExtra(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
            intent.putExtra("aid", Utility.getAid(this.mAuthActivity, WbSdk.getAuthInfo().getAppKey()));
            if (SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
                fillExtraIntent(intent, i);
                try {
                    ((Activity) this.mAuthActivity).startActivityForResult(intent, this.ssoRequestCode);
                } catch (Exception e) {
                    if (this.authListener != null) {
                        this.authListener.onFailure(new WbConnectErrorMessage());
                    }
                    couldNotStartWbSsoActivity();
                }
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillExtraIntent(Intent intent, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetIntentFillData() {
        this.ssoRequestCode = WbAuthConstants.REQUEST_CODE_SSO_AUTH;
    }

    protected void startWebAuth() {
        AuthInfo authInfo = WbSdk.getAuthInfo();
        WeiboParameters weiboParameters = new WeiboParameters(authInfo.getAppKey());
        weiboParameters.put("client_id", authInfo.getAppKey());
        weiboParameters.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, authInfo.getRedirectUrl());
        weiboParameters.put("scope", authInfo.getScope());
        weiboParameters.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
        weiboParameters.put("version", WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        weiboParameters.put("luicode", "10000360");
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.mAuthActivity);
        if (readAccessToken != null && !TextUtils.isEmpty(readAccessToken.getToken())) {
            weiboParameters.put("trans_token", readAccessToken.getToken());
            weiboParameters.put("trans_access_token", readAccessToken.getToken());
        }
        weiboParameters.put("lfid", "OP_" + authInfo.getAppKey());
        String aid = Utility.getAid(this.mAuthActivity, authInfo.getAppKey());
        if (!TextUtils.isEmpty(aid)) {
            weiboParameters.put("aid", aid);
        }
        weiboParameters.put("packagename", authInfo.getPackageName());
        weiboParameters.put("key_hash", authInfo.getKeyHash());
        String str = OAUTH2_BASE_URL + weiboParameters.encodeUrl();
        if (!NetworkHelper.hasInternetPermission(this.mAuthActivity)) {
            UIUtils.showAlert(this.mAuthActivity, "Error", "Application requires permission to access the Internet");
            return;
        }
        String str2 = null;
        if (this.authListener != null) {
            WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
            str2 = weiboCallbackManager.genCallbackKey();
            weiboCallbackManager.setWeiboAuthListener(str2, this.authListener);
        }
        AuthWebViewRequestParam authWebViewRequestParam = new AuthWebViewRequestParam(authInfo, WebRequestType.AUTH, str2, "微博登录", str, this.mAuthActivity);
        Intent intent = new Intent(this.mAuthActivity, WeiboSdkWebActivity.class);
        Bundle bundle = new Bundle();
        authWebViewRequestParam.fillBundle(bundle);
        intent.putExtras(bundle);
        this.mAuthActivity.startActivity(intent);
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        if (32973 == i) {
            if (i2 == -1) {
                if (!SecurityHelper.checkResponseAppLegal(this.mAuthActivity, WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo(), intent)) {
                    this.authListener.onFailure(new WbConnectErrorMessage(WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_MESSAGE, WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_CODE));
                    return;
                }
                String safeString = Utility.safeString(intent.getStringExtra("error"));
                String safeString2 = Utility.safeString(intent.getStringExtra("error_type"));
                String safeString3 = Utility.safeString(intent.getStringExtra("error_description"));
                LogUtil.d(WBAgent.TAG, "error: " + safeString + ", error_type: " + safeString2 + ", error_description: " + safeString3);
                if (TextUtils.isEmpty(safeString) && TextUtils.isEmpty(safeString2) && TextUtils.isEmpty(safeString3)) {
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                    if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                        LogUtil.d(WBAgent.TAG, "Login Success! " + parseAccessToken.toString());
                        AccessTokenKeeper.writeAccessToken(this.mAuthActivity, parseAccessToken);
                        this.authListener.onSuccess(parseAccessToken);
                    }
                } else if ("access_denied".equals(safeString) || "OAuthAccessDeniedException".equals(safeString)) {
                    LogUtil.d(WBAgent.TAG, "Login canceled by user.");
                    this.authListener.cancel();
                } else {
                    LogUtil.d(WBAgent.TAG, "Login failed: " + safeString);
                    this.authListener.onFailure(new WbConnectErrorMessage(safeString2, safeString3));
                }
            } else if (i2 == 0) {
                if (intent != null) {
                    this.authListener.cancel();
                } else {
                    this.authListener.cancel();
                }
            }
        }
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.mAuthActivity);
    }

    protected void couldNotStartWbSsoActivity() {
    }
}
