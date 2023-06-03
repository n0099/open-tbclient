package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.sso.WeiboSsoManager;
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
import com.xiaomi.mipush.sdk.PushMessageHelper;
import org.apache.commons.codec.language.bm.Rule;
/* loaded from: classes10.dex */
public class BaseSsoHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    public static final String TAG = "BaseSsoHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public final int SSO_TYPE_INVALID;
    public WbAuthListener authListener;
    public Context mAuthActivity;
    public int ssoRequestCode;
    public int ssoRequestType;

    public void fillExtraIntent(Intent intent, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, intent, i) == null) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class AuthType {
        public static final /* synthetic */ AuthType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AuthType ALL;
        public static final AuthType SsoOnly;
        public static final AuthType WebOnly;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1643230560, "Lcom/sina/weibo/sdk/auth/BaseSsoHandler$AuthType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1643230560, "Lcom/sina/weibo/sdk/auth/BaseSsoHandler$AuthType;");
                    return;
                }
            }
            ALL = new AuthType(Rule.ALL, 0);
            SsoOnly = new AuthType("SsoOnly", 1);
            AuthType authType = new AuthType("WebOnly", 2);
            WebOnly = authType;
            $VALUES = new AuthType[]{ALL, SsoOnly, authType};
        }

        public AuthType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AuthType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AuthType) Enum.valueOf(AuthType.class, str);
            }
            return (AuthType) invokeL.objValue;
        }

        public static AuthType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AuthType[]) $VALUES.clone();
            }
            return (AuthType[]) invokeV.objValue;
        }
    }

    public BaseSsoHandler(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.SSO_TYPE_INVALID = 3;
        this.ssoRequestCode = -1;
        this.ssoRequestType = 3;
        this.mAuthActivity = activity;
        WeiboSsoManager.getInstance().init(activity, WbSdk.getAuthInfo().getAppKey());
    }

    public BaseSsoHandler(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.SSO_TYPE_INVALID = 3;
        this.ssoRequestCode = -1;
        this.ssoRequestType = 3;
        this.mAuthActivity = context;
        WeiboSsoManager.getInstance().init(context, WbSdk.getAuthInfo().getAppKey());
    }

    private void authorize(int i, WbAuthListener wbAuthListener, AuthType authType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, this, i, wbAuthListener, authType) == null) {
            resetIntentFillData();
            if (wbAuthListener != null) {
                this.authListener = wbAuthListener;
                if (authType == AuthType.WebOnly) {
                    startWebAuth();
                    return;
                }
                boolean z = false;
                if (authType == AuthType.SsoOnly) {
                    z = true;
                }
                WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo();
                if (isWbAppInstalled() && wbAppInfo != null) {
                    startClientAuth(i);
                    return;
                } else if (z) {
                    this.authListener.onFailure(new WbConnectErrorMessage());
                    return;
                } else {
                    startWebAuth();
                    return;
                }
            }
            throw new RuntimeException("please set auth listener");
        }
    }

    public void authorize(WbAuthListener wbAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wbAuthListener) == null) {
            authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.ALL);
        }
    }

    public void authorizeClientSso(WbAuthListener wbAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wbAuthListener) == null) {
            authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.SsoOnly);
        }
    }

    public void authorizeWeb(WbAuthListener wbAuthListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wbAuthListener) == null) {
            authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.WebOnly);
        }
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, intent) == null) && 32973 == i) {
            if (i2 == -1) {
                Context context = this.mAuthActivity;
                if (!SecurityHelper.checkResponseAppLegal(context, WeiboAppManager.getInstance(context).getWbAppInfo(), intent)) {
                    this.authListener.onFailure(new WbConnectErrorMessage(WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_MESSAGE, WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_CODE));
                    return;
                }
                String safeString = Utility.safeString(intent.getStringExtra("error"));
                String safeString2 = Utility.safeString(intent.getStringExtra(PushMessageHelper.ERROR_TYPE));
                String safeString3 = Utility.safeString(intent.getStringExtra("error_description"));
                LogUtil.d(TAG, "error: " + safeString + ", error_type: " + safeString2 + ", error_description: " + safeString3);
                if (TextUtils.isEmpty(safeString) && TextUtils.isEmpty(safeString2) && TextUtils.isEmpty(safeString3)) {
                    Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                    if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                        LogUtil.d(TAG, "Login Success! " + parseAccessToken.toString());
                        AccessTokenKeeper.writeAccessToken(this.mAuthActivity, parseAccessToken);
                        this.authListener.onSuccess(parseAccessToken);
                    }
                } else if (!"access_denied".equals(safeString) && !"OAuthAccessDeniedException".equals(safeString)) {
                    LogUtil.d(TAG, "Login failed: " + safeString);
                    this.authListener.onFailure(new WbConnectErrorMessage(safeString2, safeString3));
                } else {
                    LogUtil.d(TAG, "Login canceled by user.");
                    this.authListener.cancel();
                }
            } else if (i2 == 0) {
                this.authListener.cancel();
            }
        }
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return WbSdk.isWbInstall(this.mAuthActivity);
        }
        return invokeV.booleanValue;
    }

    public void resetIntentFillData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.ssoRequestCode = WbAuthConstants.REQUEST_CODE_SSO_AUTH;
        }
    }

    public void startClientAuth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            try {
                WbAppInfo wbAppInfo = WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo();
                Intent intent = new Intent();
                intent.setClassName(wbAppInfo.getPackageName(), wbAppInfo.getAuthActivityName());
                intent.putExtras(WbSdk.getAuthInfo().getAuthBundle());
                intent.putExtra(WBConstants.COMMAND_TYPE_KEY, 3);
                intent.putExtra(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
                intent.putExtra("aid", Utility.getAid(this.mAuthActivity, WbSdk.getAuthInfo().getAppKey()));
                if (!SecurityHelper.validateAppSignatureForIntent(this.mAuthActivity, intent)) {
                    this.authListener.onFailure(new WbConnectErrorMessage(WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_MESSAGE, WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_CODE));
                    return;
                }
                fillExtraIntent(intent, i);
                try {
                    ((Activity) this.mAuthActivity).startActivityForResult(intent, this.ssoRequestCode);
                } catch (Exception unused) {
                    if (this.authListener != null) {
                        this.authListener.onFailure(new WbConnectErrorMessage());
                    }
                }
            } catch (Exception unused2) {
            }
        }
    }

    public void startWebAuth() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AuthInfo authInfo = WbSdk.getAuthInfo();
            WeiboParameters weiboParameters = new WeiboParameters(authInfo.getAppKey());
            weiboParameters.put("client_id", authInfo.getAppKey());
            weiboParameters.put("redirect_uri", authInfo.getRedirectUrl());
            weiboParameters.put("scope", authInfo.getScope());
            weiboParameters.put("response_type", "code");
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
            String str2 = OAUTH2_BASE_URL + weiboParameters.encodeUrl();
            if (!NetworkHelper.hasInternetPermission(this.mAuthActivity)) {
                UIUtils.showAlert(this.mAuthActivity, V8ExceptionInfo.V8_EXCEPTION_ERROR, "Application requires permission to access the Internet");
                return;
            }
            if (this.authListener != null) {
                WeiboCallbackManager weiboCallbackManager = WeiboCallbackManager.getInstance();
                String genCallbackKey = weiboCallbackManager.genCallbackKey();
                weiboCallbackManager.setWeiboAuthListener(genCallbackKey, this.authListener);
                str = genCallbackKey;
            } else {
                str = null;
            }
            AuthWebViewRequestParam authWebViewRequestParam = new AuthWebViewRequestParam(authInfo, WebRequestType.AUTH, str, "微博登录", str2, this.mAuthActivity);
            Intent intent = new Intent(this.mAuthActivity, WeiboSdkWebActivity.class);
            Bundle bundle = new Bundle();
            authWebViewRequestParam.fillBundle(bundle);
            intent.putExtras(bundle);
            this.mAuthActivity.startActivity(intent);
        }
    }
}
