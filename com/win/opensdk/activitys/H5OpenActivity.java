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
import b.q.a.c3;
import b.q.a.d0;
import b.q.a.f;
import b.q.a.g0;
import b.q.a.g3;
import b.q.a.k1;
import b.q.a.l1;
import b.q.a.m1;
import b.q.a.y2;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class H5OpenActivity extends Activity implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f70486a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedWebView f70487b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f70488c;

    /* renamed from: d  reason: collision with root package name */
    public Info f70489d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f70490e;

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
        this.f70490e = false;
    }

    @Override // b.q.a.f
    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) && this.f70490e) {
            y2 a2 = c3.a(this);
            a2.f(new g3(this.f70489d), i2, str2);
            a2.m();
            this.f70490e = false;
            Toast.makeText(this, getString(m1.win_loadp_error), 0).show();
        }
    }

    @Override // b.q.a.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f70490e) {
            y2 a2 = c3.a(this);
            a2.f(new g3(this.f70489d), 200, str);
            a2.m();
            this.f70490e = false;
        }
    }

    @Override // b.q.a.f
    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) {
        }
    }

    @Override // b.q.a.f
    public void a(String str, String str2, String str3, long j, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Long.valueOf(j), str4, str5}) == null) {
        }
    }

    @Override // b.q.a.f
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
            AdvancedWebView advancedWebView = this.f70487b;
            if (advancedWebView != null) {
                advancedWebView.a(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdvancedWebView advancedWebView = this.f70487b;
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
            setContentView(l1.win_layout_h5_open_activity);
            try {
                this.f70489d = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f70489d == null) {
                finish();
                return;
            }
            this.f70487b = new AdvancedWebView(this);
            this.f70490e = true;
            y2 a2 = c3.a(this);
            try {
                a2.f33579b = c3.d("wbas", new g3(this.f70489d));
            } catch (JSONException unused) {
            }
            a2.m();
            this.f70488c = (ProgressBar) findViewById(k1.win_h5_open_webview_process);
            FrameLayout frameLayout = (FrameLayout) findViewById(k1.win_h5_open_webview);
            this.f70486a = frameLayout;
            frameLayout.removeAllViews();
            try {
                ((ViewGroup) this.f70487b.getParent()).removeView(this.f70487b);
            } catch (Exception unused2) {
            }
            this.f70486a.addView(this.f70487b);
            this.f70487b.a(this, this);
            this.f70487b.setGeolocationEnabled(false);
            this.f70487b.setWebViewClient(new d0(this));
            this.f70487b.setWebChromeClient(new g0(this));
            Info info = this.f70489d;
            if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
                Info info2 = this.f70489d;
                if (info2 == null || TextUtils.isEmpty(info2.getOpen()) || StringUtil.NULL_STRING.equals(this.f70489d.getOpen())) {
                    return;
                }
                advancedWebView = this.f70487b;
                open = this.f70489d.getOpen();
            } else {
                advancedWebView = this.f70487b;
                open = this.f70489d.getOph5Url();
            }
            advancedWebView.loadUrl(open);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdvancedWebView advancedWebView = this.f70487b;
            if (advancedWebView != null) {
                advancedWebView.c();
            }
            super.onDestroy();
            this.f70490e = false;
            y2 a2 = c3.a(this);
            try {
                a2.f33579b = c3.d("wbao", new g3(this.f70489d));
            } catch (JSONException unused) {
            }
            a2.m();
        }
    }
}
