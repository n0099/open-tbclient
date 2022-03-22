package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.m.a.b3;
import c.m.a.d0;
import c.m.a.f;
import c.m.a.g0;
import c.m.a.t2;
import c.m.a.x2;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class H5OpenActivity extends Activity implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedWebView f44010b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f44011c;

    /* renamed from: d  reason: collision with root package name */
    public Info f44012d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44013e;

    public H5OpenActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44013e = false;
    }

    @Override // c.m.a.f
    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && this.f44013e) {
            t2 a = x2.a(this);
            a.f(new b3(this.f44012d), i, str2);
            a.m();
            this.f44013e = false;
            Toast.makeText(this, getString(R.string.obfuscated_res_0x7f0f1557), 0).show();
        }
    }

    @Override // c.m.a.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f44013e) {
            t2 a = x2.a(this);
            a.f(new b3(this.f44012d), 200, str);
            a.m();
            this.f44013e = false;
        }
    }

    @Override // c.m.a.f
    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) {
        }
    }

    @Override // c.m.a.f
    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Long.valueOf(j), str4, str5}) == null) {
        }
    }

    @Override // c.m.a.f
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            AdvancedWebView advancedWebView = this.f44010b;
            if (advancedWebView != null) {
                advancedWebView.a(i, i2, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdvancedWebView advancedWebView = this.f44010b;
            if (advancedWebView == null || advancedWebView.k()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        AdvancedWebView advancedWebView;
        String open;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d08da);
            try {
                this.f44012d = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f44012d == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            this.f44010b = new AdvancedWebView(this);
            this.f44013e = true;
            t2 a = x2.a(this);
            try {
                a.f23575b = x2.d("wbas", new b3(this.f44012d));
            } catch (JSONException unused) {
            }
            a.m();
            this.f44011c = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f092480);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09247f);
            this.a = frameLayout;
            frameLayout.removeAllViews();
            try {
                ((ViewGroup) this.f44010b.getParent()).removeView(this.f44010b);
            } catch (Exception unused2) {
            }
            this.a.addView(this.f44010b);
            this.f44010b.b(this, this);
            this.f44010b.setGeolocationEnabled(false);
            this.f44010b.setWebViewClient(new d0(this));
            this.f44010b.setWebChromeClient(new g0(this));
            Info info = this.f44012d;
            if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
                Info info2 = this.f44012d;
                if (info2 != null && !TextUtils.isEmpty(info2.getOpen()) && !StringUtil.NULL_STRING.equals(this.f44012d.getOpen())) {
                    advancedWebView = this.f44010b;
                    open = this.f44012d.getOpen();
                }
                LogUtil.logActivity(this, "onCreate");
            }
            advancedWebView = this.f44010b;
            open = this.f44012d.getOph5Url();
            advancedWebView.loadUrl(open);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdvancedWebView advancedWebView = this.f44010b;
            if (advancedWebView != null) {
                advancedWebView.l();
            }
            super.onDestroy();
            this.f44013e = false;
            t2 a = x2.a(this);
            try {
                a.f23575b = x2.d("wbao", new b3(this.f44012d));
            } catch (JSONException unused) {
            }
            a.m();
        }
    }
}
