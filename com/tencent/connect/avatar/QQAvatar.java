package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
/* loaded from: classes10.dex */
public class QQAvatar extends BaseApi {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_SDK_AVATAR_SET_IMAGE = "FROM_SDK_AVATAR_SET_IMAGE";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IUiListener f75802a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQAvatar(QQToken qQToken) {
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

    private Intent a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, activity)) == null) {
            Intent intent = new Intent();
            intent.setClass(activity, ImageActivity.class);
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iUiListener, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048576, this, activity, uri, iUiListener, i2) == null) {
            IUiListener iUiListener2 = this.f75802a;
            if (iUiListener2 != null) {
                iUiListener2.onCancel();
            }
            this.f75802a = iUiListener;
            Bundle bundle = new Bundle();
            bundle.putString("picture", uri.toString());
            bundle.putInt("exitAnim", i2);
            bundle.putString("appid", this.f75827c.getAppId());
            bundle.putString("access_token", this.f75827c.getAccessToken());
            bundle.putLong("expires_in", this.f75827c.getExpireTimeInSecond());
            bundle.putString("openid", this.f75827c.getOpenId());
            Intent a2 = a(activity);
            if (a(a2)) {
                a(activity, bundle, a2);
                d.a().a(this.f75827c.getOpenId(), this.f75827c.getAppId(), Constants.VIA_SET_AVATAR, "12", "18", "0");
                return;
            }
            d.a().a(this.f75827c.getOpenId(), this.f75827c.getAppId(), Constants.VIA_SET_AVATAR, "12", "18", "1");
        }
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, uri, iUiListener) == null) {
            IUiListener iUiListener2 = this.f75802a;
            if (iUiListener2 != null) {
                iUiListener2.onCancel();
            }
            this.f75802a = iUiListener;
            if (!i.b(activity)) {
                Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            } else if (i.c(activity, "8.0.0") < 0) {
                Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            } else {
                String a2 = l.a(activity);
                StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_avatar_edit?");
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.length() > 20) {
                        a2 = a2.substring(0, 20) + "...";
                    }
                    stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a2), 2));
                }
                String appId = this.f75827c.getAppId();
                String openId = this.f75827c.getOpenId();
                if (!TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!TextUtils.isEmpty(openId)) {
                    stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openId), 2));
                }
                String a3 = l.a(activity, uri);
                if (!TextUtils.isEmpty(a3)) {
                    try {
                        activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                        stringBuffer.append("&set_uri=" + Base64.encodeToString(l.i(uri.toString()), 2));
                    } catch (Exception e2) {
                        SLog.e("QQAvatar", "Exception", e2);
                    }
                }
                if (!TextUtils.isEmpty(a3)) {
                    stringBuffer.append("&set_path=" + Base64.encodeToString(l.i(a3), 2));
                }
                stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
                SLog.v("QQAVATAR", "-->set avatar, url: " + stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
                intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                intent.setData(Uri.parse(stringBuffer.toString()));
                if (a(intent)) {
                    UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_AVATAR, iUiListener);
                    a(activity, Constants.REQUEST_EDIT_AVATAR, intent, false);
                }
            }
        }
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, activity, uri, iUiListener) == null) {
            IUiListener iUiListener2 = this.f75802a;
            if (iUiListener2 != null) {
                iUiListener2.onCancel();
            }
            this.f75802a = iUiListener;
            if (!i.b(activity)) {
                Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            } else if (i.c(activity, "8.0.5") < 0) {
                Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置头像功能。", 1).show();
            } else {
                String a2 = l.a(activity);
                StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_dynamic_avatar_edit?");
                if (!TextUtils.isEmpty(a2)) {
                    if (a2.length() > 20) {
                        a2 = a2.substring(0, 20) + "...";
                    }
                    stringBuffer.append("&app_name=" + Base64.encodeToString(l.i(a2), 2));
                }
                String appId = this.f75827c.getAppId();
                String openId = this.f75827c.getOpenId();
                if (!TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!TextUtils.isEmpty(openId)) {
                    stringBuffer.append("&open_id=" + Base64.encodeToString(l.i(openId), 2));
                }
                String a3 = l.a(activity, uri);
                if (!TextUtils.isEmpty(a3)) {
                    try {
                        activity.grantUriPermission("com.tencent.mobileqq", uri, 3);
                        stringBuffer.append("&video_uri=");
                        stringBuffer.append(Base64.encodeToString(l.i(uri.toString()), 2));
                    } catch (Exception e2) {
                        SLog.e("QQAvatar", "Exception", e2);
                    }
                }
                if (!TextUtils.isEmpty(a3)) {
                    stringBuffer.append("&video_path=" + Base64.encodeToString(l.i(a3), 2));
                }
                stringBuffer.append("&sdk_version=" + Base64.encodeToString(l.i(Constants.SDK_VERSION), 2));
                SLog.v("QQAVATAR", "-->set dynamic avatar, url: " + stringBuffer.toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("FROM_WHERE", FROM_SDK_AVATAR_SET_IMAGE);
                intent.putExtra(EmotionResourceInfo.JSON_KEY_PKG_NAME, activity.getPackageName());
                intent.setData(Uri.parse(stringBuffer.toString()));
                if (a(intent)) {
                    UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_DYNAMIC_AVATAR, iUiListener);
                    a(activity, Constants.REQUEST_EDIT_DYNAMIC_AVATAR, intent, false);
                }
            }
        }
    }

    private void a(Activity activity, Bundle bundle, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, this, activity, bundle, intent) == null) {
            a(bundle);
            intent.putExtra(Constants.KEY_ACTION, "action_avatar");
            intent.putExtra(Constants.KEY_PARAMS, bundle);
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_AVATER, this.f75802a);
            a(activity, intent, Constants.REQUEST_AVATER);
        }
    }

    private void a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bundle) == null) {
            QQToken qQToken = this.f75827c;
            if (qQToken != null) {
                bundle.putString("appid", qQToken.getAppId());
                if (this.f75827c.isSessionValid()) {
                    bundle.putString(Constants.PARAM_KEY_STR, this.f75827c.getAccessToken());
                    bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
                }
                String openId = this.f75827c.getOpenId();
                if (openId != null) {
                    bundle.putString("hopenid", openId);
                }
                bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
                try {
                    bundle.putString("pf", f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString("pf", Constants.DEFAULT_PF));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bundle.putString("pf", Constants.DEFAULT_PF);
                }
            }
            bundle.putString("sdkv", Constants.SDK_VERSION);
            bundle.putString("sdkp", "a");
        }
    }
}
