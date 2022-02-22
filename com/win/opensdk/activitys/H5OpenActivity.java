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
import c.q.a.c3;
import c.q.a.d0;
import c.q.a.f;
import c.q.a.g0;
import c.q.a.g3;
import c.q.a.k1;
import c.q.a.l1;
import c.q.a.m1;
import c.q.a.y2;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.webviewbase.AdvancedWebView;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class H5OpenActivity extends Activity implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public AdvancedWebView f61034b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f61035c;

    /* renamed from: d  reason: collision with root package name */
    public Info f61036d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61037e;

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
        this.f61037e = false;
    }

    @Override // c.q.a.f
    public void a(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048576, this, i2, str, str2) == null) && this.f61037e) {
            y2 a = c3.a(this);
            a.f(new g3(this.f61036d), i2, str2);
            a.m();
            this.f61037e = false;
            Toast.makeText(this, getString(m1.win_loadp_error), 0).show();
        }
    }

    @Override // c.q.a.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && this.f61037e) {
            y2 a = c3.a(this);
            a.f(new g3(this.f61036d), 200, str);
            a.m();
            this.f61037e = false;
        }
    }

    @Override // c.q.a.f
    public void a(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bitmap) == null) {
        }
    }

    @Override // c.q.a.f
    public void a(String str, String str2, String str3, long j2, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, Long.valueOf(j2), str4, str5}) == null) {
        }
    }

    @Override // c.q.a.f
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
            AdvancedWebView advancedWebView = this.f61034b;
            if (advancedWebView != null) {
                advancedWebView.a(i2, i3, intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            AdvancedWebView advancedWebView = this.f61034b;
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
                this.f61036d = (Info) getIntent().getSerializableExtra("Key_H5OpenActData");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (this.f61036d == null) {
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            this.f61034b = new AdvancedWebView(this);
            this.f61037e = true;
            y2 a = c3.a(this);
            try {
                a.f30763b = c3.d("wbas", new g3(this.f61036d));
            } catch (JSONException unused) {
            }
            a.m();
            this.f61035c = (ProgressBar) findViewById(k1.win_h5_open_webview_process);
            FrameLayout frameLayout = (FrameLayout) findViewById(k1.win_h5_open_webview);
            this.a = frameLayout;
            frameLayout.removeAllViews();
            try {
                ((ViewGroup) this.f61034b.getParent()).removeView(this.f61034b);
            } catch (Exception unused2) {
            }
            this.a.addView(this.f61034b);
            this.f61034b.a(this, this);
            this.f61034b.setGeolocationEnabled(false);
            this.f61034b.setWebViewClient(new d0(this));
            this.f61034b.setWebChromeClient(new g0(this));
            Info info = this.f61036d;
            if (info == null || TextUtils.isEmpty(info.getOph5Url())) {
                Info info2 = this.f61036d;
                if (info2 != null && !TextUtils.isEmpty(info2.getOpen()) && !StringUtil.NULL_STRING.equals(this.f61036d.getOpen())) {
                    advancedWebView = this.f61034b;
                    open = this.f61036d.getOpen();
                }
                LogUtil.logActivity(this, "onCreate");
            }
            advancedWebView = this.f61034b;
            open = this.f61036d.getOph5Url();
            advancedWebView.loadUrl(open);
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AdvancedWebView advancedWebView = this.f61034b;
            if (advancedWebView != null) {
                advancedWebView.c();
            }
            super.onDestroy();
            this.f61037e = false;
            y2 a = c3.a(this);
            try {
                a.f30763b = c3.d("wbao", new g3(this.f61036d));
            } catch (JSONException unused) {
            }
            a.m();
        }
    }
}
