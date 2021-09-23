package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.I;
import com.win.opensdk.J;
import com.win.opensdk.R;
import com.win.opensdk.Y0;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.core.Info;
import com.win.opensdk.v2;
import com.win.opensdk.webviewbase.AdvancedWebView;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class H5OpenActivity extends Activity implements v2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdvancedWebView f77278a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f77279b;

    /* renamed from: c  reason: collision with root package name */
    public Info f77280c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f77281d;

    public H5OpenActivity() {
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
        this.f77281d = false;
    }

    @Override // com.win.opensdk.v2
    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) && this.f77281d) {
            Z0.a(this).a(new a1(this.f77280c), i2, str2).a();
            this.f77281d = false;
            Toast.makeText(this, getString(R.string.win_loadp_error), 0).show();
        }
    }

    @Override // com.win.opensdk.v2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f77278a.setVisibility(0);
            if (this.f77281d) {
                Z0.a(this).a(new a1(this.f77280c), 200, str).a();
                this.f77281d = false;
            }
        }
    }

    @Override // com.win.opensdk.v2
    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) {
            this.f77278a.setVisibility(4);
        }
    }

    @Override // com.win.opensdk.v2
    public void a(String str, String str2, String str3, long j2, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Long.valueOf(j2), str4, str5}) == null) {
        }
    }

    @Override // com.win.opensdk.v2
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            AdvancedWebView advancedWebView = this.f77278a;
            if (advancedWebView != null) {
                advancedWebView.a(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdvancedWebView advancedWebView = this.f77278a;
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
            setContentView(R.layout.win_layout_h5_open_activity);
            try {
                this.f77280c = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f77280c == null) {
                return;
            }
            this.f77281d = true;
            Y0 a2 = Z0.a(this);
            try {
                a2.f77254b = Z0.a("wbas", new a1(this.f77280c));
            } catch (JSONException unused) {
            }
            a2.a();
            this.f77279b = (ProgressBar) findViewById(R.id.win_h5_open_webview_process);
            AdvancedWebView advancedWebView2 = (AdvancedWebView) findViewById(R.id.win_h5_open_webview);
            this.f77278a = advancedWebView2;
            advancedWebView2.a(this, this);
            this.f77278a.setGeolocationEnabled(false);
            this.f77278a.setMixedContentAllowed(false);
            this.f77278a.setCookiesEnabled(true);
            this.f77278a.setThirdPartyCookiesEnabled(true);
            this.f77278a.setWebViewClient(new I(this));
            this.f77278a.setWebChromeClient(new J(this));
            Info info = this.f77280c;
            if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
                Info info2 = this.f77280c;
                if (info2 == null || TextUtils.isEmpty(info2.getOpen()) || StringUtil.NULL_STRING.equals(this.f77280c.getOpen())) {
                    return;
                }
                advancedWebView = this.f77278a;
                open = this.f77280c.getOpen();
            } else {
                advancedWebView = this.f77278a;
                open = this.f77280c.getOph5Url();
            }
            advancedWebView.loadUrl(open);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdvancedWebView advancedWebView = this.f77278a;
            if (advancedWebView != null) {
                advancedWebView.c();
            }
            super.onDestroy();
            this.f77281d = false;
            Y0 a2 = Z0.a(this);
            try {
                a2.f77254b = Z0.a("wbao", new a1(this.f77280c));
            } catch (JSONException unused) {
            }
            a2.a();
        }
    }
}
