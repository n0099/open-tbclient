package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AssistActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41770a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f41771b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41772c;

    /* renamed from: d  reason: collision with root package name */
    public String f41773d;

    public AssistActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41772c = false;
        this.f41770a = false;
        this.f41771b = new Handler(this) { // from class: com.tencent.connect.common.AssistActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AssistActivity f41774a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f41774a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 0 && !this.f41774a.isFinishing()) {
                    f.d("openSDK_LOG.AssistActivity", "-->finish by timeout");
                    this.f41774a.finish();
                }
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Bundle bundle) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            String string = bundle.getString("viaShareType");
            String string2 = bundle.getString("callbackAction");
            String string3 = bundle.getString("url");
            String string4 = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_OPEN_ID);
            String string5 = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
            String str4 = "";
            if ("shareToQQ".equals(string2)) {
                str2 = Constants.VIA_SHARE_TO_QQ;
                str3 = "10";
            } else if (!"shareToQzone".equals(string2)) {
                str = "";
                if (j.a(this, string3)) {
                    IUiListener listnerWithAction = UIListenerManager.getInstance().getListnerWithAction(string2);
                    if (listnerWithAction != null) {
                        listnerWithAction.onError(new UiError(-6, Constants.MSG_OPEN_BROWSER_ERROR, null));
                    }
                    d.a().a(string4, string5, str4, str, "3", "1", string, "0", "2", "0");
                    finish();
                } else {
                    d.a().a(string4, string5, str4, str, "3", "0", string, "0", "2", "0");
                }
                getIntent().removeExtra("shareH5");
            } else {
                str2 = Constants.VIA_SHARE_TO_QZONE;
                str3 = "11";
            }
            str = str3;
            str4 = str2;
            if (j.a(this, string3)) {
            }
            getIntent().removeExtra("shareH5");
        }
    }

    public static Intent getAssistActivityIntent(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? new Intent(context, AssistActivity.class) : (Intent) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("--onActivityResult--requestCode: ");
            sb.append(i2);
            sb.append(" | resultCode: ");
            sb.append(i3);
            sb.append("data = null ? ");
            sb.append(intent == null);
            f.c("openSDK_LOG.AssistActivity", sb.toString());
            super.onActivityResult(i2, i3, intent);
            if (i2 == 0) {
                return;
            }
            if (intent != null) {
                intent.putExtra(Constants.KEY_ACTION, "action_login");
            }
            setResultData(i2, intent);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            setRequestedOrientation(3);
            f.b("openSDK_LOG.AssistActivity", "--onCreate--");
            if (getIntent() == null) {
                f.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
                finish();
            }
            Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
            int intExtra = intent == null ? 0 : intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
            this.f41773d = intent == null ? "" : intent.getStringExtra("appid");
            Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
            if (bundle != null) {
                this.f41772c = bundle.getBoolean("RESTART_FLAG");
                this.f41770a = bundle.getBoolean("RESUME_FLAG", false);
            }
            if (this.f41772c) {
                f.b("openSDK_LOG.AssistActivity", "is restart");
            } else if (bundleExtra != null) {
                f.d("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
                a(bundleExtra);
            } else if (intent != null) {
                f.c("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
                startActivityForResult(intent, intExtra);
            } else {
                f.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            f.b("openSDK_LOG.AssistActivity", "-->onDestroy");
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            f.c("openSDK_LOG.AssistActivity", "--onNewIntent");
            super.onNewIntent(intent);
            intent.putExtra(Constants.KEY_ACTION, "action_share");
            setResult(-1, intent);
            if (isFinishing()) {
                return;
            }
            f.c("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            f.b("openSDK_LOG.AssistActivity", "-->onPause");
            this.f41771b.removeMessages(0);
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f.b("openSDK_LOG.AssistActivity", "-->onResume");
            super.onResume();
            Intent intent = getIntent();
            if (intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false)) {
                return;
            }
            if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.f41772c && !isFinishing()) {
                finish();
            }
            if (this.f41770a) {
                this.f41771b.sendMessage(this.f41771b.obtainMessage(0));
                return;
            }
            this.f41770a = true;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            f.b("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
            bundle.putBoolean("RESTART_FLAG", true);
            bundle.putBoolean("RESUME_FLAG", this.f41770a);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            f.b("openSDK_LOG.AssistActivity", "-->onStart");
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            f.b("openSDK_LOG.AssistActivity", "-->onStop");
            super.onStop();
        }
    }

    public void setResultData(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, intent) == null) {
            if (intent == null) {
                f.d("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
                setResult(0);
                if (i2 == 11101) {
                    d.a().a("", this.f41773d, "2", "1", "7", "2");
                    return;
                }
                return;
            }
            try {
                String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
                f.b("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- " + stringExtra);
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    String optString = jSONObject.optString("openid");
                    String optString2 = jSONObject.optString("access_token");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        f.c("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                        setResult(-1, intent);
                        d.a().a(optString, this.f41773d, "2", "1", "7", "0");
                    } else {
                        f.d("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                        setResult(0, intent);
                        d.a().a("", this.f41773d, "2", "1", "7", "1");
                    }
                } else {
                    f.d("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                }
            } catch (Exception e2) {
                f.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
                e2.printStackTrace();
            }
        }
    }
}
