package com.tencent.connect.common;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.open.TDialog;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Map;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class BaseApi {
    public static /* synthetic */ Interceptable $ic;
    public static String businessId;
    public static String installChannel;
    public static boolean isOEM;
    public static String registerChannel;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c f60642b;

    /* renamed from: c  reason: collision with root package name */
    public QQToken f60643c;

    /* loaded from: classes4.dex */
    public class TempRequestListener implements IRequestListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseApi a;

        /* renamed from: b  reason: collision with root package name */
        public final IUiListener f60644b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f60645c;

        public TempRequestListener(BaseApi baseApi, IUiListener iUiListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseApi, iUiListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseApi;
            this.f60644b = iUiListener;
            this.f60645c = new Handler(this, f.a().getMainLooper(), baseApi) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ BaseApi a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ TempRequestListener f60646b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr2 = {this, r8, baseApi};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i4 = newInitContext2.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            super((Looper) newInitContext2.callArgs[0]);
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.f60646b = this;
                    this.a = baseApi;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        if (message.what == 0) {
                            this.f60646b.f60644b.onComplete(message.obj);
                        } else {
                            this.f60646b.f60644b.onError(new UiError(message.what, (String) message.obj, null));
                        }
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = jSONObject;
                obtainMessage.what = 0;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(ConnectTimeoutException connectTimeoutException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, connectTimeoutException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = connectTimeoutException.getMessage();
                obtainMessage.what = -7;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(HttpUtils.HttpStatusException httpStatusException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, httpStatusException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = httpStatusException.getMessage();
                obtainMessage.what = -9;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, iOException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = iOException.getMessage();
                obtainMessage.what = -2;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(JSONException jSONException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, jSONException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = jSONException.getMessage();
                obtainMessage.what = -4;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(MalformedURLException malformedURLException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, malformedURLException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = malformedURLException.getMessage();
                obtainMessage.what = -3;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException networkUnavailableException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, networkUnavailableException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = networkUnavailableException.getMessage();
                obtainMessage.what = -10;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(SocketTimeoutException socketTimeoutException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, socketTimeoutException) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = socketTimeoutException.getMessage();
                obtainMessage.what = -8;
                this.f60645c.sendMessage(obtainMessage);
            }
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, exc) == null) {
                Message obtainMessage = this.f60645c.obtainMessage();
                obtainMessage.obj = exc.getMessage();
                obtainMessage.what = -6;
                this.f60645c.sendMessage(obtainMessage);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2044540083, "Lcom/tencent/connect/common/BaseApi;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2044540083, "Lcom/tencent/connect/common/BaseApi;");
        }
    }

    public BaseApi(c cVar, QQToken qQToken) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, qQToken};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f60642b = cVar;
        this.f60643c = qQToken;
    }

    public Bundle a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("format", "json");
            bundle.putString("status_os", Build.VERSION.RELEASE);
            bundle.putString("status_machine", Build.MODEL);
            bundle.putString("status_version", Build.VERSION.SDK);
            bundle.putString("sdkv", Constants.SDK_VERSION);
            bundle.putString("sdkp", "a");
            QQToken qQToken = this.f60643c;
            if (qQToken != null && qQToken.isSessionValid()) {
                bundle.putString("access_token", this.f60643c.getAccessToken());
                bundle.putString("oauth_consumer_key", this.f60643c.getAppId());
                bundle.putString("openid", this.f60643c.getOpenId());
                bundle.putString("appid_for_getting_config", this.f60643c.getAppId());
            }
            SharedPreferences sharedPreferences = f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
            if (isOEM) {
                bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
            } else {
                bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Bundle b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("appid", this.f60643c.getAppId());
            if (this.f60643c.isSessionValid()) {
                bundle.putString(Constants.PARAM_KEY_STR, this.f60643c.getAccessToken());
                bundle.putString(Constants.PARAM_KEY_TYPE, "0x80");
            }
            String openId = this.f60643c.getOpenId();
            if (openId != null) {
                bundle.putString("hopenid", openId);
            }
            bundle.putString(Constants.PARAM_PLATFORM, "androidqz");
            SharedPreferences sharedPreferences = f.a().getSharedPreferences(Constants.PREFERENCE_PF, 0);
            if (isOEM) {
                bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
            } else {
                bundle.putString("pf", sharedPreferences.getString("pf", Constants.DEFAULT_PF));
                bundle.putString("pf", Constants.DEFAULT_PF);
            }
            bundle.putString("sdkv", Constants.SDK_VERSION);
            bundle.putString("sdkp", "a");
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public Intent c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Intent intent = new Intent();
            Intent b2 = b(str);
            if (b2 == null || b2.getComponent() == null) {
                return null;
            }
            intent.setClassName(b2.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public void releaseResource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseApi(QQToken qQToken) {
        this(null, qQToken);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qQToken};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((c) objArr2[0], (QQToken) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Bundle a = a();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                a.putString("need_version", str);
            }
            sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version?");
            sb.append(HttpUtils.encodeUrl(a));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public Intent b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Intent intent = new Intent();
            if (l.c(f.a())) {
                intent.setClassName(Constants.PACKAGE_QQ_PAD, str);
                if (i.a(f.a(), intent)) {
                    return intent;
                }
            }
            intent.setClassName("com.tencent.mobileqq", str);
            if (i.a(f.a(), intent)) {
                return intent;
            }
            intent.setClassName(Constants.PACKAGE_TIM, str);
            if (i.a(f.a(), intent)) {
                return intent;
            }
            intent.setClassName(Constants.PACKAGE_QQ_SPEED, str);
            if (i.a(f.a(), intent)) {
                return intent;
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    private Intent a(Activity activity, Intent intent, Map<String, Object> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, activity, intent, map)) == null) {
            Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
            intent2.putExtra(ImageViewerConfig.IS_LOGIN, true);
            intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
            if (map == null) {
                return intent2;
            }
            try {
                if (map.containsKey(Constants.KEY_RESTORE_LANDSCAPE)) {
                    intent2.putExtra(Constants.KEY_RESTORE_LANDSCAPE, ((Boolean) map.get(Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
                }
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.BaseApi", "Exception", e2);
            }
            return intent2;
        }
        return (Intent) invokeLLL.objValue;
    }

    public void a(Activity activity, int i2, Intent intent, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, Integer.valueOf(i2), intent, Boolean.valueOf(z)}) == null) {
            Intent intent2 = new Intent(activity.getApplicationContext(), AssistActivity.class);
            if (z) {
                intent2.putExtra("is_qq_mobile_share", true);
            }
            intent2.putExtra(AssistActivity.EXTRA_INTENT, intent);
            activity.startActivityForResult(intent2, i2);
        }
    }

    public void a(Activity activity, Intent intent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, activity, intent, i2) == null) {
            a(activity, intent, i2, (Map<String, Object>) null);
        }
    }

    public void a(Activity activity, Intent intent, int i2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048580, this, activity, intent, i2, map) == null) {
            intent.putExtra(Constants.KEY_REQUEST_CODE, i2);
            activity.startActivityForResult(a(activity, intent, map), i2);
        }
    }

    public void a(Fragment fragment, Intent intent, int i2, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048582, this, fragment, intent, i2, map) == null) {
            intent.putExtra(Constants.KEY_REQUEST_CODE, i2);
            fragment.startActivityForResult(a(fragment.getActivity(), intent, map), i2);
        }
    }

    public boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, intent)) == null) {
            if (intent != null) {
                return i.a(f.a(), intent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void a(Activity activity, Bundle bundle, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, bundle, iUiListener) == null) {
            SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
            new TDialog(activity, "", "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html?" + HttpUtils.encodeUrl(bundle), null, this.f60643c).show();
        }
    }
}
