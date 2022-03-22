package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SocialApiIml extends BaseApi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;

    /* loaded from: classes7.dex */
    public class a extends DefaultUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SocialApiIml a;

        /* renamed from: b  reason: collision with root package name */
        public IUiListener f43684b;

        /* renamed from: c  reason: collision with root package name */
        public String f43685c;

        /* renamed from: d  reason: collision with root package name */
        public String f43686d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f43687e;

        /* renamed from: f  reason: collision with root package name */
        public Activity f43688f;

        public a(SocialApiIml socialApiIml, Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {socialApiIml, activity, iUiListener, str, str2, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = socialApiIml;
            this.f43684b = iUiListener;
            this.f43685c = str;
            this.f43686d = str2;
            this.f43687e = bundle;
            this.f43688f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43684b.onCancel();
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                try {
                    str = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    SLog.e("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", e2);
                    str = null;
                }
                this.f43687e.putString("encrytoken", str);
                SocialApiIml socialApiIml = this.a;
                socialApiIml.a((Context) socialApiIml.a, this.f43685c, this.f43687e, this.f43686d, this.f43684b);
                if (TextUtils.isEmpty(str)) {
                    SLog.d("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                    this.a.writeEncryToken(this.f43688f);
                }
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                SLog.d("openSDK_LOG.SocialApiIml", "OpenApi, EncryptTokenListener() onError" + uiError.errorMessage);
                this.f43684b.onError(uiError);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, bundle, iUiListener) == null) {
            a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
        }
    }

    @Override // com.tencent.connect.common.BaseApi
    public Intent b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Intent intent = new Intent();
            intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_QZONE, str);
            Intent intent2 = new Intent();
            intent2.setClassName("com.tencent.mobileqq", str);
            Intent intent3 = new Intent();
            intent3.setClassName(com.tencent.connect.common.Constants.PACKAGE_QQ_PAD, str);
            if (l.c(f.a()) && i.a(f.a(), intent3)) {
                return intent3;
            }
            if (!i.a(f.a(), intent2) || i.c(f.a(), "4.7") < 0) {
                if (i.a(f.a(), intent) && i.a(i.a(f.a(), com.tencent.connect.common.Constants.PACKAGE_QZONE), "4.2") >= 0 && i.a(f.a(), intent.getComponent().getPackageName(), com.tencent.connect.common.Constants.SIGNATRUE_QZONE)) {
                    return intent;
                }
                return null;
            }
            return intent2;
        }
        return (Intent) invokeL.objValue;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, bundle, iUiListener) == null) {
            a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
        }
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, bundle, iUiListener) == null) {
            this.a = activity;
            Intent c2 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
            if (c2 == null) {
                SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
                c2 = c(SocialConstants.ACTIVITY_INVITE);
            }
            bundle.putAll(b());
            a(activity, c2, SocialConstants.ACTION_INVITE, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
        }
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, activity, bundle, iUiListener) == null) {
            this.a = activity;
            Intent c2 = c(SocialConstants.ACTIVITY_STORY);
            bundle.putAll(b());
            a(activity, c2, SocialConstants.ACTION_STORY, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            String accessToken = this.f43645c.getAccessToken();
            String appId = this.f43645c.getAppId();
            String openId = this.f43645c.getOpenId();
            if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
                str = null;
            } else {
                str = l.f("tencent&sdk&qazxc***14969%%" + accessToken + appId + openId + "qzone3.4");
            }
            com.tencent.open.b.b bVar = new com.tencent.open.b.b(context);
            WebSettings settings = bVar.getSettings();
            settings.setDomStorageEnabled(true);
            settings.setJavaScriptEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setSavePassword(false);
            String a2 = h.a().a(context, "https://login.imgcache.qq.com");
            bVar.loadDataWithBaseURL(a2, "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.f43645c.getOpenId() + "_" + this.f43645c.getAppId() + "\"]=\"" + str + "\";</script></head><body></body></html>", SapiWebView.DATA_MIME_TYPE, IMAudioTransRequest.CHARSET, a2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialApiIml(com.tencent.connect.auth.c cVar, QQToken qQToken) {
        super(cVar, qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, qQToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.tencent.connect.auth.c) objArr2[0], (QQToken) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65541, this, activity, str, bundle, iUiListener) == null) {
            this.a = activity;
            Intent c2 = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
            if (c2 == null) {
                SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
                c2 = c(SocialConstants.ACTIVITY_ASK_GIFT);
            }
            Intent intent = c2;
            bundle.putAll(b());
            if (SocialConstants.ACTION_ASK.equals(str)) {
                bundle.putString("type", "request");
            } else if (SocialConstants.ACTION_GIFT.equals(str)) {
                bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
            }
            a(activity, intent, str, bundle, h.a().a(f.a(), "https://login.imgcache.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, intent, str, bundle, str2, iUiListener, Boolean.valueOf(z)}) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("-->handleIntent action = ");
            sb.append(str);
            sb.append(", activityIntent = null ? ");
            boolean z2 = true;
            sb.append(intent == null);
            SLog.i("openSDK_LOG.SocialApiIml", sb.toString());
            if (intent != null) {
                a(activity, intent, str, bundle, iUiListener);
                return;
            }
            g a2 = g.a(f.a(), this.f43645c.getAppId());
            if (!z && !a2.b("C_LoginH5")) {
                z2 = false;
            }
            if (z2) {
                a(activity, str, bundle, str2, iUiListener);
            } else {
                a(activity, bundle, iUiListener);
            }
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65539, this, activity, intent, str, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
            intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, str);
            intent.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundle);
            UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_SOCIAL_API, iUiListener);
            a(activity, intent, com.tencent.connect.common.Constants.REQUEST_SOCIAL_API);
        }
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, this, activity, str, bundle, str2, iUiListener) == null) {
            SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
            Intent b2 = b("com.tencent.open.agent.AgentActivity");
            IUiListener aVar = new a(this, activity, iUiListener, str, str2, bundle);
            Intent b3 = b("com.tencent.open.agent.EncryTokenActivity");
            if (b3 != null && b2 != null && b2.getComponent() != null && b3.getComponent() != null && b2.getComponent().getPackageName().equals(b3.getComponent().getPackageName())) {
                b3.putExtra("oauth_consumer_key", this.f43645c.getAppId());
                b3.putExtra("openid", this.f43645c.getOpenId());
                b3.putExtra("access_token", this.f43645c.getAccessToken());
                b3.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
                if (a(b3)) {
                    SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                    UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_SOCIAL_H5, aVar);
                    a(activity, b3, com.tencent.connect.common.Constants.REQUEST_SOCIAL_H5);
                    return;
                }
                return;
            }
            SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
            String f2 = l.f("tencent&sdk&qazxc***14969%%" + this.f43645c.getAccessToken() + this.f43645c.getAppId() + this.f43645c.getOpenId() + "qzone3.4");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SocialConstants.PARAM_ENCRY_EOKEN, f2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            aVar.onComplete(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, this, context, str, bundle, str2, iUiListener) == null) {
            SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
            CookieSyncManager.createInstance(context);
            bundle.putString("oauth_consumer_key", this.f43645c.getAppId());
            if (this.f43645c.isSessionValid()) {
                bundle.putString("access_token", this.f43645c.getAccessToken());
            }
            String openId = this.f43645c.getOpenId();
            if (openId != null) {
                bundle.putString("openid", openId);
            }
            try {
                bundle.putString("pf", f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF));
            } catch (Exception e2) {
                e2.printStackTrace();
                bundle.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
            }
            String str3 = str2 + HttpUtils.encodeUrl(bundle);
            SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
            if (!SocialConstants.ACTION_CHALLENGE.equals(str) && !SocialConstants.ACTION_BRAG.equals(str)) {
                new TDialog(this.a, str, str3, iUiListener, this.f43645c).show();
                return;
            }
            SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            new c(this.a, str, str3, iUiListener, this.f43645c).show();
        }
    }
}
