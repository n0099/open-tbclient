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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.B2;
import com.win.opensdk.H;
import com.win.opensdk.I;
import com.win.opensdk.core.Info;
import com.win.opensdk.d1;
import com.win.opensdk.e1;
import com.win.opensdk.f1;
import com.win.opensdk.webviewbase.AdvancedWebView;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class H5OpenActivity extends Activity implements B2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public AdvancedWebView b;
    public ProgressBar c;
    public Info d;
    public boolean e;

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
        this.e = false;
    }

    @Override // com.win.opensdk.B2
    public void a(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) && this.e) {
            e1.a(this).a(new f1(this.d), i, str2).a();
            this.e = false;
            Toast.makeText(this, getString(R.string.obfuscated_res_0x7f0f155b), 0).show();
        }
    }

    @Override // com.win.opensdk.B2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.e) {
            e1.a(this).a(new f1(this.d), 200, str).a();
            this.e = false;
        }
    }

    @Override // com.win.opensdk.B2
    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) {
        }
    }

    @Override // com.win.opensdk.B2
    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Long.valueOf(j), str4, str5}) == null) {
        }
    }

    @Override // com.win.opensdk.B2
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
            AdvancedWebView advancedWebView = this.b;
            if (advancedWebView != null) {
                advancedWebView.a(i, i2, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdvancedWebView advancedWebView = this.b;
            if (advancedWebView == null || advancedWebView.b()) {
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
            setContentView(R.layout.obfuscated_res_0x7f0d08e1);
            try {
                this.d = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.d == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            this.b = new AdvancedWebView(this);
            this.e = true;
            d1 a = e1.a(this);
            try {
                a.b = e1.a("wbas", new f1(this.d));
            } catch (JSONException unused) {
            }
            a.a();
            this.c = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f092500);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0924ff);
            this.a = frameLayout;
            frameLayout.removeAllViews();
            try {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            } catch (Exception unused2) {
            }
            this.a.addView(this.b);
            this.b.a(this, this);
            this.b.setGeolocationEnabled(false);
            this.b.setWebViewClient(new H(this));
            this.b.setWebChromeClient(new I(this));
            Info info = this.d;
            if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
                Info info2 = this.d;
                if (info2 != null && !TextUtils.isEmpty(info2.getOpen()) && !StringUtil.NULL_STRING.equals(this.d.getOpen())) {
                    advancedWebView = this.b;
                    open = this.d.getOpen();
                }
                LogUtil.logActivity(this, "onCreate");
            }
            advancedWebView = this.b;
            open = this.d.getOph5Url();
            advancedWebView.loadUrl(open);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdvancedWebView advancedWebView = this.b;
            if (advancedWebView != null) {
                advancedWebView.c();
            }
            super.onDestroy();
            this.e = false;
            d1 a = e1.a(this);
            try {
                a.b = e1.a("wbao", new f1(this.d));
            } catch (JSONException unused) {
            }
            a.a();
        }
    }
}
