package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class SocialOperation extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String GAME_FRIEND_ADD_MESSAGE = "add_msg";
    public static final String GAME_FRIEND_LABEL = "friend_label";
    public static final String GAME_FRIEND_OPENID = "fopen_id";
    public static final String GAME_SIGNATURE = "signature";
    public static final String GAME_UNION_ID = "unionid";
    public static final String GAME_UNION_NAME = "union_name";
    public static final String GAME_ZONE_ID = "zoneid";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialOperation(QQToken qQToken) {
        super(qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((QQToken) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, activity, str, str2, iUiListener) == null) {
            SLog.i("openSDK_LOG.GameAppOperation", "-->bindQQGroup()  -- start");
            if (activity == null) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, activity is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                    return;
                }
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("mqqapi://opensdk/bind_group?src_type=app&version=1");
            String appId = this.f76028c.getAppId();
            if (TextUtils.isEmpty(appId)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appId is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1003, "appid is null", "please login."));
                    return;
                }
                return;
            }
            String openId = this.f76028c.getOpenId();
            if (TextUtils.isEmpty(openId)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, openid is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1004, "openid params is null", "please login."));
                    return;
                }
                return;
            }
            String a2 = l.a(activity);
            if (TextUtils.isEmpty(a2)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, appname is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1005, "appName params is null", ""));
                }
            } else if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization id is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1006, "organizationId params is null", ""));
                }
            } else if (TextUtils.isEmpty(str2)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->bindQQGroup, organization name is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1007, "organizationName params is null", ""));
                }
            } else {
                stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a2), 2));
                stringBuffer.append("&organization_id=" + Base64.encodeToString(l.i(str), 2));
                stringBuffer.append("&organization_name=" + Base64.encodeToString(l.i(str2), 2));
                stringBuffer.append("&openid=" + Base64.encodeToString(l.i(openId), 2));
                stringBuffer.append("&appid=" + Base64.encodeToString(l.i(appId), 2));
                stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
                SLog.v("openSDK_LOG.GameAppOperation", "-->bindQQGroup, url: " + stringBuffer.toString());
                Uri parse = Uri.parse(stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                if (a(intent) && i.c(activity, "8.1.0") >= 0) {
                    DefaultUiListener defaultUiListener = new DefaultUiListener(this, iUiListener, activity, intent) { // from class: com.tencent.open.SocialOperation.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ IUiListener f76101a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Activity f76102b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Intent f76103c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ SocialOperation f76104d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iUiListener, activity, intent};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f76104d = this;
                            this.f76101a = iUiListener;
                            this.f76102b = activity;
                            this.f76103c = intent;
                        }

                        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                        public void onCancel() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            }
                        }

                        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                        public void onComplete(Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                                SLog.w("openSDK_LOG.GameAppOperation", "-->bind group resp is: " + obj);
                                if (obj == null) {
                                    IUiListener iUiListener2 = this.f76101a;
                                    if (iUiListener2 != null) {
                                        iUiListener2.onError(new UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                                    }
                                } else if (((JSONObject) obj).optInt("bind") != 1) {
                                    try {
                                        this.f76104d.a(this.f76102b, (int) Constants.REQUEST_BIND_GROUP, this.f76103c, false);
                                    } catch (Exception e2) {
                                        SLog.e("openSDK_LOG.GameAppOperation", "-->bind group, start activity exception.", e2);
                                        this.f76104d.a(this.f76102b);
                                    }
                                } else {
                                    IUiListener iUiListener3 = this.f76101a;
                                    if (iUiListener3 != null) {
                                        iUiListener3.onError(new UiError(3002, "该群已绑定！", "绑定过的群不能再次绑定。"));
                                    }
                                    SLog.i("openSDK_LOG.GameAppOperation", "-->bindQQGroup() binded return.");
                                }
                            }
                        }

                        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                        public void onError(UiError uiError) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                                SLog.v("openSDK_LOG.GameAppOperation", "-->bindQQGroup, error: " + uiError);
                                IUiListener iUiListener2 = this.f76101a;
                                if (iUiListener2 != null) {
                                    iUiListener2.onError(uiError);
                                }
                            }
                        }
                    };
                    Bundle a3 = a();
                    a3.putString("appid", appId);
                    a3.putString("orgid", str);
                    HttpUtils.requestAsync(this.f76028c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", a3, "GET", new BaseApi.TempRequestListener(this, defaultUiListener));
                    SLog.i("openSDK_LOG.GameAppOperation", "-->bindQQGroup() do.");
                    return;
                }
                SLog.w("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
                a(activity);
            }
        }
    }

    public void joinGroup(Activity activity, String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iUiListener) == null) {
            SLog.i("openSDK_LOG.GameAppOperation", "joinQQGroup()");
            if (activity == null) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, activity is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                }
            } else if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, params is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1006, "param organizationId is null", "organizationId param of api can not be null."));
                }
            } else {
                Intent intent = new Intent();
                String appId = this.f76028c.getAppId();
                if (TextUtils.isEmpty(appId)) {
                    SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, appid is empty.");
                    if (iUiListener != null) {
                        iUiListener.onError(new UiError(1003, "appid is null", "appid is null, please login."));
                        return;
                    }
                    return;
                }
                String openId = this.f76028c.getOpenId();
                if (TextUtils.isEmpty(openId)) {
                    SLog.e("openSDK_LOG.GameAppOperation", "-->joinGroup, openid is empty.");
                    if (iUiListener != null) {
                        iUiListener.onError(new UiError(1004, "openid is null", "openid is null, please login."));
                        return;
                    }
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer("mqqapi://opensdk/join_group?src_type=app&version=1");
                stringBuffer.append("&openid=" + Base64.encodeToString(l.i(openId), 2));
                stringBuffer.append("&appid=" + Base64.encodeToString(l.i(appId), 2));
                stringBuffer.append("&organization_id=" + Base64.encodeToString(l.i(str), 2));
                stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
                intent.setData(Uri.parse(stringBuffer.toString()));
                if (a(intent) && i.c(activity, "8.1.0") >= 0) {
                    DefaultUiListener defaultUiListener = new DefaultUiListener(this, iUiListener, activity, intent) { // from class: com.tencent.open.SocialOperation.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ IUiListener f76097a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ Activity f76098b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ Intent f76099c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ SocialOperation f76100d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, iUiListener, activity, intent};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f76100d = this;
                            this.f76097a = iUiListener;
                            this.f76098b = activity;
                            this.f76099c = intent;
                        }

                        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                        public void onCancel() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            }
                        }

                        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                        public void onComplete(Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                                SLog.w("openSDK_LOG.GameAppOperation", "-->join group resp is: " + obj);
                                if (obj == null) {
                                    IUiListener iUiListener2 = this.f76097a;
                                    if (iUiListener2 != null) {
                                        iUiListener2.onError(new UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                                    }
                                } else if (((JSONObject) obj).optInt("bind") == 1) {
                                    try {
                                        this.f76100d.a(this.f76098b, (int) Constants.REQUEST_JOIN_GROUP, this.f76099c, false);
                                    } catch (Exception e2) {
                                        SLog.e("openSDK_LOG.GameAppOperation", "-->join group, start activity exception.", e2);
                                        this.f76100d.a(this.f76098b);
                                    }
                                } else {
                                    IUiListener iUiListener3 = this.f76097a;
                                    if (iUiListener3 != null) {
                                        iUiListener3.onError(new UiError(3003, "该组织未绑群，无法加入", "该组织未绑群，无法加入。"));
                                    }
                                }
                            }
                        }

                        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                        public void onError(UiError uiError) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                                SLog.v("openSDK_LOG.GameAppOperation", "-->joinQQGroup, error: " + uiError);
                                IUiListener iUiListener2 = this.f76097a;
                                if (iUiListener2 != null) {
                                    iUiListener2.onError(uiError);
                                }
                            }
                        }
                    };
                    Bundle a2 = a();
                    a2.putString("appid", appId);
                    a2.putString("orgid", str);
                    HttpUtils.requestAsync(this.f76028c, activity, "https://openmobile.qq.com/cgi-bin/qunopensdk/check_group", a2, "GET", new BaseApi.TempRequestListener(this, defaultUiListener));
                    SLog.i("openSDK_LOG.GameAppOperation", "-->joinQQGroup() do.");
                    return;
                }
                SLog.w("openSDK_LOG.GameAppOperation", "-->bind group, there is no activity, show download page.");
                a(activity);
            }
        }
    }

    public void makeFriend(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, activity, bundle) == null) {
            SLog.i("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- start");
            if (bundle == null) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->makeFriend params is null");
                d.a().a(this.f76028c.getOpenId(), this.f76028c.getAppId(), Constants.VIA_MAKE_FRIEND, "14", "18", "1");
                return;
            }
            String string = bundle.getString(GAME_FRIEND_OPENID);
            if (TextUtils.isEmpty(string)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid is empty.");
                d.a().a(this.f76028c.getOpenId(), this.f76028c.getAppId(), Constants.VIA_MAKE_FRIEND, "14", "18", "1");
                return;
            }
            String string2 = bundle.getString(GAME_FRIEND_LABEL);
            String string3 = bundle.getString(GAME_FRIEND_ADD_MESSAGE);
            String a2 = l.a(activity);
            String openId = this.f76028c.getOpenId();
            String appId = this.f76028c.getAppId();
            SLog.v("openSDK_LOG.GameAppOperation", "-->make friend, fOpenid: " + string + " | label: " + string2 + " | message: " + string3 + " | openid: " + openId + " | appid:" + appId);
            StringBuffer stringBuffer = new StringBuffer("mqqapi://gamesdk/add_friend?src_type=app&version=1");
            StringBuilder sb = new StringBuilder();
            sb.append("&fopen_id=");
            sb.append(Base64.encodeToString(l.i(string), 2));
            stringBuffer.append(sb.toString());
            if (!TextUtils.isEmpty(openId)) {
                stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openId), 2));
            }
            if (!TextUtils.isEmpty(appId)) {
                stringBuffer.append("&app_id=" + appId);
            }
            if (!TextUtils.isEmpty(string2)) {
                stringBuffer.append("&friend_label=" + Base64.encodeToString(l.i(string2), 2));
            }
            if (!TextUtils.isEmpty(string3)) {
                stringBuffer.append("&add_msg=" + Base64.encodeToString(l.i(string3), 2));
            }
            if (!TextUtils.isEmpty(a2)) {
                stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a2), 2));
            }
            SLog.v("openSDK_LOG.GameAppOperation", "-->make friend, url: " + stringBuffer.toString());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(stringBuffer.toString()));
            if (a(intent) && !l.f(activity, "5.1.0")) {
                SLog.i("openSDK_LOG.GameAppOperation", "-->makeFriend target activity found, qqver greater than 5.1.0");
                try {
                    activity.startActivity(intent);
                    d.a().a(this.f76028c.getOpenId(), this.f76028c.getAppId(), Constants.VIA_MAKE_FRIEND, "14", "18", "0");
                } catch (Exception e2) {
                    SLog.e("openSDK_LOG.GameAppOperation", "-->make friend, start activity exception.", e2);
                    a(activity);
                    d.a().a(this.f76028c.getOpenId(), this.f76028c.getAppId(), Constants.VIA_MAKE_FRIEND, "14", "18", "1");
                }
            } else {
                SLog.w("openSDK_LOG.GameAppOperation", "-->make friend, there is no activity.");
                a(activity);
                d.a().a(this.f76028c.getOpenId(), this.f76028c.getAppId(), Constants.VIA_MAKE_FRIEND, "14", "18", "1");
            }
            SLog.i("openSDK_LOG.GameAppOperation", "-->makeFriend()  -- end");
        }
    }

    public void unBindGroup(Context context, String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, context, str, iUiListener) == null) {
            SLog.i("openSDK_LOG.GameAppOperation", "unBindQQGroup()");
            if (context == null) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->uinBindGroup, activity is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1001, "param acitivty is null", "activity param of api can not be null."));
                }
            } else if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.GameAppOperation", "-->unBindGroup, params is empty.");
                if (iUiListener != null) {
                    iUiListener.onError(new UiError(1006, "param organizationId is null", "organizationId param of api can not be null."));
                }
            } else {
                String appId = this.f76028c.getAppId();
                if (TextUtils.isEmpty(appId)) {
                    SLog.e("openSDK_LOG.GameAppOperation", "-->unBindGroup, appid is empty.");
                    if (iUiListener != null) {
                        iUiListener.onError(new UiError(1003, "param appId is null", "appid is null please login."));
                        return;
                    }
                    return;
                }
                DefaultUiListener defaultUiListener = new DefaultUiListener(this, iUiListener) { // from class: com.tencent.open.SocialOperation.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ IUiListener f76095a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ SocialOperation f76096b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iUiListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f76096b = this;
                        this.f76095a = iUiListener;
                    }

                    @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                    public void onCancel() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        }
                    }

                    @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                    public void onComplete(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                            SLog.w("openSDK_LOG.GameAppOperation", "-->unbind group resp is: " + obj);
                            if (obj == null) {
                                IUiListener iUiListener2 = this.f76095a;
                                if (iUiListener2 != null) {
                                    iUiListener2.onError(new UiError(4001, "服务端错误，请稍后重试", "资格检查回包为null。"));
                                    return;
                                }
                                return;
                            }
                            JSONObject jSONObject = (JSONObject) obj;
                            IUiListener iUiListener3 = this.f76095a;
                            if (iUiListener3 != null) {
                                iUiListener3.onComplete(jSONObject);
                            }
                        }
                    }

                    @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
                    public void onError(UiError uiError) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, uiError) == null) {
                            SLog.v("openSDK_LOG.GameAppOperation", "-->unbindQQGroup, error: " + uiError);
                            IUiListener iUiListener2 = this.f76095a;
                            if (iUiListener2 != null) {
                                iUiListener2.onError(uiError);
                            }
                        }
                    }
                };
                Bundle a2 = a();
                a2.putString("appid", appId);
                a2.putString("orgid", str);
                HttpUtils.requestAsync(this.f76028c, context, "https://openmobile.qq.com/cgi-bin/qunopensdk/unbind", a2, "GET", new BaseApi.TempRequestListener(this, defaultUiListener));
                SLog.i("openSDK_LOG.GameAppOperation", "-->unBindQQGroup() do.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, activity) == null) {
            a(activity, "");
        }
    }

    private void a(Activity activity, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, activity, str) == null) {
            new TDialog(activity, "", a(str), null, this.f76028c).show();
        }
    }
}
