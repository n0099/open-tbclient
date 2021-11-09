package com.tencent.connect.common;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import com.google.protobuf.CodedInputStream;
import com.tencent.open.a.d;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.l;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AssistActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f69909a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f69910b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69911c;

    /* renamed from: d  reason: collision with root package name */
    public String f69912d;

    /* renamed from: e  reason: collision with root package name */
    public QQStayReceiver f69913e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69914f;

    /* loaded from: classes2.dex */
    public class QQStayReceiver extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AssistActivity f69917a;

        public QQStayReceiver(AssistActivity assistActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {assistActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69917a = assistActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                String str = "#";
                Uri uri = (Uri) intent.getParcelableExtra("uriData");
                Intent intent2 = new Intent();
                try {
                    String uri2 = uri.toString();
                    if (!uri2.contains("#")) {
                        str = "?";
                    }
                    for (String str2 : uri2.substring(uri2.indexOf(str) + 1).split("&")) {
                        String[] split = str2.split("=");
                        intent2.putExtra(split[0], split[1]);
                    }
                } catch (Exception e2) {
                    SLog.i("openSDK_LOG.AssistActivity", "QQStayReceiver parse uri error : " + e2.getMessage());
                }
                intent2.putExtra(Constants.KEY_ACTION, "action_share");
                intent2.setData(uri);
                this.f69917a.setResult(-1, intent2);
            }
        }
    }

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
        this.f69911c = false;
        this.f69909a = false;
        this.f69910b = new Handler(this) { // from class: com.tencent.connect.common.AssistActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ AssistActivity f69915a;

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
                this.f69915a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 0 && !this.f69915a.isFinishing()) {
                    SLog.w("openSDK_LOG.AssistActivity", "-->finish by timeout");
                    this.f69915a.finish();
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
                if (l.a(this, string3)) {
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
            if (l.a(this, string3)) {
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
            SLog.i("openSDK_LOG.AssistActivity", sb.toString());
            super.onActivityResult(i2, i3, intent);
            if (i2 == 0) {
                return;
            }
            if (intent != null) {
                intent.putExtra(Constants.KEY_ACTION, "action_login");
            }
            setResultData(i2, intent);
            if (!this.f69914f) {
                SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish immediate");
                finish();
                return;
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) { // from class: com.tencent.connect.common.AssistActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AssistActivity f69916a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69916a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SLog.i("openSDK_LOG.AssistActivity", "onActivityResult finish delay");
                        this.f69916a.finish();
                    }
                }
            }, 200L);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            getWindow().addFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
            requestWindowFeature(1);
            super.onCreate(bundle);
            this.f69914f = getIntent().getBooleanExtra(Constants.KEY_RESTORE_LANDSCAPE, false);
            SLog.i("openSDK_LOG.AssistActivity", "--onCreate-- mRestoreLandscape=" + this.f69914f);
            if (getIntent() == null) {
                SLog.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
                finish();
            }
            Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
            int intExtra = intent == null ? 0 : intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
            this.f69912d = intent == null ? "" : intent.getStringExtra("appid");
            Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
            if (bundle != null) {
                this.f69911c = bundle.getBoolean("RESTART_FLAG");
                this.f69909a = bundle.getBoolean("RESUME_FLAG", false);
            }
            if (this.f69911c) {
                SLog.d("openSDK_LOG.AssistActivity", "is restart");
            } else if (bundleExtra != null) {
                SLog.w("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
                a(bundleExtra);
            } else if (intent != null) {
                SLog.i("openSDK_LOG.AssistActivity", "--onCreate--activityIntent not null, will start activity, reqcode = " + intExtra);
                try {
                    String queryParameter = intent.getData().getQueryParameter("share_id");
                    IntentFilter intentFilter = new IntentFilter(Constants.SHARE_QQ_AND_STAY + queryParameter);
                    if (this.f69913e == null) {
                        this.f69913e = new QQStayReceiver();
                    }
                    registerReceiver(this.f69913e, intentFilter);
                } catch (Exception e2) {
                    SLog.i("openSDK_LOG.AssistActivity", "registerReceiver exception : " + e2.getMessage());
                }
                startActivityForResult(intent, intExtra);
            } else {
                SLog.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "-->onDestroy");
            super.onDestroy();
            QQStayReceiver qQStayReceiver = this.f69913e;
            if (qQStayReceiver != null) {
                unregisterReceiver(qQStayReceiver);
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent");
            super.onNewIntent(intent);
            int intExtra = intent.getIntExtra(Constants.KEY_REQUEST_CODE, -1);
            if (intExtra == 10108) {
                intent.putExtra(Constants.KEY_ACTION, "action_request_avatar");
                if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                    moveTaskToBack(true);
                }
                setResult(-1, intent);
                if (isFinishing()) {
                    return;
                }
                finish();
            } else if (intExtra == 10109) {
                intent.putExtra(Constants.KEY_ACTION, "action_request_set_emotion");
                if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                    moveTaskToBack(true);
                }
                setResult(-1, intent);
                if (isFinishing()) {
                    return;
                }
                finish();
            } else if (intExtra == 10110) {
                intent.putExtra(Constants.KEY_ACTION, "action_request_dynamic_avatar");
                if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                    moveTaskToBack(true);
                }
                setResult(-1, intent);
                if (isFinishing()) {
                    return;
                }
                finish();
            } else if (intExtra == 10111) {
                intent.putExtra(Constants.KEY_ACTION, "joinGroup");
                if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                    moveTaskToBack(true);
                }
                setResult(-1, intent);
                if (isFinishing()) {
                    return;
                }
                finish();
            } else if (intExtra == 10112) {
                intent.putExtra(Constants.KEY_ACTION, "bindGroup");
                if (intent.getBooleanExtra(Constants.KEY_STAY, false)) {
                    moveTaskToBack(true);
                }
                setResult(-1, intent);
                if (isFinishing()) {
                    return;
                }
                finish();
            } else {
                intent.putExtra(Constants.KEY_ACTION, "action_share");
                setResult(-1, intent);
                if (isFinishing()) {
                    return;
                }
                SLog.i("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "-->onPause");
            this.f69910b.removeMessages(0);
            super.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "-->onResume");
            super.onResume();
            Intent intent = getIntent();
            if (intent.getBooleanExtra(ImageViewerConfig.IS_LOGIN, false)) {
                return;
            }
            if (!intent.getBooleanExtra("is_qq_mobile_share", false) && this.f69911c && !isFinishing()) {
                finish();
            }
            if (this.f69909a) {
                this.f69910b.sendMessage(this.f69910b.obtainMessage(0));
                return;
            }
            this.f69909a = true;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
            bundle.putBoolean("RESTART_FLAG", true);
            bundle.putBoolean("RESUME_FLAG", this.f69909a);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "-->onStart");
            super.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SLog.i("openSDK_LOG.AssistActivity", "-->onStop");
            super.onStop();
        }
    }

    public void setResultData(int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, intent) == null) {
            if (intent == null) {
                SLog.w("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
                setResult(0);
                if (i2 == 11101) {
                    d.a().a("", this.f69912d, "2", "1", "7", "2");
                    return;
                }
                return;
            }
            try {
                String stringExtra = intent.getStringExtra(Constants.KEY_RESPONSE);
                SLog.d("openSDK_LOG.AssistActivity", "--setResultDataForLogin-- ");
                if (!TextUtils.isEmpty(stringExtra)) {
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    String optString = jSONObject.optString("openid");
                    String optString2 = jSONObject.optString("access_token");
                    String optString3 = jSONObject.optString("proxy_code");
                    long optLong = jSONObject.optLong("proxy_expires_in");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        SLog.i("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
                        setResult(-1, intent);
                        d.a().a(optString, this.f69912d, "2", "1", "7", "0");
                    } else if (!TextUtils.isEmpty(optString3) && optLong != 0) {
                        SLog.i("openSDK_LOG.AssistActivity", "--setResultData--proxy_code and proxy_expires_in are valid");
                        setResult(-1, intent);
                    } else {
                        SLog.w("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                        setResult(0, intent);
                        d.a().a("", this.f69912d, "2", "1", "7", "1");
                    }
                } else {
                    SLog.w("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                    setResult(-1, intent);
                }
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
                e2.printStackTrace();
            }
        }
    }
}
