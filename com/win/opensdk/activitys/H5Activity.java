package com.win.opensdk.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.p.a.a0;
import c.p.a.a2;
import c.p.a.c3;
import c.p.a.g3;
import c.p.a.h4;
import c.p.a.j3;
import c.p.a.k1;
import c.p.a.l1;
import c.p.a.m0;
import c.p.a.m2;
import c.p.a.n;
import c.p.a.o0;
import c.p.a.q0;
import c.p.a.r0;
import c.p.a.u0;
import c.p.a.v;
import c.p.a.w;
import c.p.a.y2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CloseParentView;
import org.json.JSONException;
/* loaded from: classes4.dex */
public class H5Activity extends Activity implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f63198b;

    /* renamed from: c  reason: collision with root package name */
    public CloseParentView f63199c;

    /* renamed from: d  reason: collision with root package name */
    public n f63200d;

    /* renamed from: e  reason: collision with root package name */
    public Info f63201e;

    /* renamed from: f  reason: collision with root package name */
    public String f63202f;

    /* renamed from: g  reason: collision with root package name */
    public String f63203g;

    /* renamed from: h  reason: collision with root package name */
    public long f63204h;

    /* renamed from: i  reason: collision with root package name */
    public h4 f63205i;

    public H5Activity() {
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
        this.f63204h = 0L;
    }

    public static void a(Context context, Info info, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, info, str) == null) || context == null || info == null) {
            return;
        }
        Intent intent = new Intent(context, H5Activity.class);
        intent.putExtra("pid", str);
        intent.putExtra("id", info.getId());
        intent.putExtra("traceid", info.getTraceid());
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x00a3 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: int */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    public final void a() {
        char c2;
        View decorView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Info info = this.f63201e;
            if (info != null && info.getXn() > 0) {
                int i3 = Build.VERSION.SDK_INT;
                if (i3 > 11 && i3 < 19) {
                    decorView = getWindow().getDecorView();
                    i2 = 8;
                } else if (Build.VERSION.SDK_INT >= 19) {
                    decorView = getWindow().getDecorView();
                    i2 = 4102;
                }
                decorView.setSystemUiVisibility(i2);
            }
            Info info2 = this.f63201e;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 <= 25 || i4 >= 28) {
                String str = this.f63202f;
                int i5 = 1;
                if (!TextUtils.isEmpty(str) && str.length() > 3) {
                    String substring = str.substring(0, 3);
                    switch (substring.hashCode()) {
                        case 53431:
                            if (substring.equals("601")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53432:
                            if (substring.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE602)) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53433:
                            if (substring.equals("603")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53434:
                            if (substring.equals("604")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53435:
                        default:
                            c2 = 65535;
                            break;
                        case 53436:
                            if (substring.equals("606")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53437:
                            if (substring.equals("607")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 0) {
                        i5 = 0;
                    } else if (c2 != 1) {
                        if (c2 == 2 || c2 == 3) {
                            i5 = info2.isVertical();
                        }
                    }
                    setRequestedOrientation(i5);
                }
                i5 = 2;
                setRequestedOrientation(i5);
            }
            WebView webView = ((j3) this.f63200d).f31180c;
            webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f63198b.addView(webView, 0);
            n nVar = this.f63200d;
            if (nVar instanceof j3) {
                ((j3) nVar).a(this.f63201e.getLoad(), this.f63201e);
            }
            ((j3) this.f63200d).f31179b = new w(this);
            this.f63199c.setCollectVisible(false);
            this.f63199c.setLocation(220);
            this.f63199c.setCountDown(this.f63201e.getCdt());
            this.f63199c.setOnCloseListener(new a0(this));
            y2 a = c3.a(this.a);
            a.o(new g3(this.f63201e));
            a.m();
            q0.c(this.f63201e.getId() + this.f63202f, "is_display", null);
            if (this.f63201e != null) {
                m2.g(this.a, this.f63201e.getId() + ":" + System.currentTimeMillis(), false);
            }
            r0.n(this.f63201e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Info info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (info = this.f63201e) != null && info.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(l1.win_layout_activity_h5);
            this.a = getApplicationContext();
            this.f63198b = (ViewGroup) findViewById(k1.win_parent);
            this.f63199c = (CloseParentView) findViewById(k1.win_close_parent);
            this.f63204h = 0L;
            this.f63205i = new h4(this);
            q0.b("hcl", this);
            q0.b("onT", this);
            q0.b("onRewardedShowFail", this);
            q0.b("onPlayProgress", this);
            q0.b("onRewardedAdFinish", this);
            q0.b("onRewardedAdStart", this);
            boolean z = false;
            try {
                Intent intent = getIntent();
                String stringExtra = intent.getStringExtra("id");
                this.f63202f = intent.getStringExtra("pid");
                String stringExtra2 = intent.getStringExtra("traceid");
                this.f63201e = m0.a().b(v.c(stringExtra2, stringExtra, this.f63202f));
                n a = v.b().a(v.c(stringExtra2, stringExtra, this.f63202f));
                this.f63200d = a;
                if (a != null) {
                    if (this.f63201e != null) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!z) {
                finish();
            }
            try {
                a();
            } catch (Exception unused) {
                finish();
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            y2 a = c3.a(this.a);
            a.b(new g3(this.f63201e));
            a.m();
            n nVar = this.f63200d;
            if (nVar != null) {
                j3 j3Var = (j3) nVar;
                WebView webView = j3Var.f31180c;
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(j3Var.f31180c);
                    }
                    j3Var.f31180c.removeAllViews();
                    j3Var.f31180c.stopLoading();
                    j3Var.f31180c.setWebChromeClient(null);
                    j3Var.f31180c.setWebViewClient(null);
                    j3Var.f31180c.destroy();
                }
                if (j3Var.f31179b != null) {
                    j3Var.f31179b = null;
                }
            }
            CloseParentView closeParentView = this.f63199c;
            if (closeParentView != null) {
                closeParentView.b();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (keyEvent.getKeyCode() != 4 || (info = this.f63201e) == null || info.getCb() > 0) {
                return super.onKeyDown(i2, keyEvent);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
            try {
                this.f63202f = bundle.getString("st_pid");
                this.f63201e = (Info) bundle.getSerializable("st_info");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("st_pid", this.f63202f);
            bundle.putSerializable("st_info", this.f63201e);
        }
    }

    @Override // c.p.a.o0
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj) == null) {
            if (str.equals("hcl")) {
                finish();
                if (this.f63201e != null) {
                    q0.c(this.f63201e.getId() + this.f63202f, "is_dismiss", null);
                    q0.a(this.f63201e.getId() + this.f63202f);
                }
                q0.a("hcl");
                q0.a("onT");
                q0.a("onRewardedShowFail");
                q0.a("onPlayProgress");
                q0.a("onRewardedAdFinish");
                q0.a("onRewardedAdStart");
                return;
            }
            try {
                if (str.equals("onRewardedShowFail")) {
                    y2 a = c3.a(this.a);
                    String str3 = (String) obj;
                    try {
                        a.f31377b = c3.d("vvsf", new g3(this.f63201e));
                        a.l("desc", str3);
                    } catch (JSONException unused) {
                    }
                    a.m();
                    q0.c(this.f63201e.getId() + this.f63202f, "VIDEO_SHOW_FAIL", (String) obj);
                } else if (str.equals("onRewardedAdFinish")) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue < 0 || intValue < this.f63201e.getVvt() * 0.9d) {
                        q0.c(this.f63201e.getId() + this.f63202f, "VIDEO_USER_EARNED_REWARD", null);
                    } else {
                        y2 a2 = c3.a(this.a);
                        g3 g3Var = new g3(this.f63201e);
                        long vvamount = this.f63201e.getVvamount();
                        try {
                            a2.f31377b = c3.d("vvss", g3Var);
                            a2.k("desc", vvamount);
                        } catch (JSONException unused2) {
                        }
                        a2.m();
                        q0.c(this.f63201e.getId() + this.f63202f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.f63201e.getVvamount()));
                    }
                    Info info = this.f63201e;
                    try {
                        r0.o(info, 401, "");
                        if (info == null || TextUtils.isEmpty(info.getVv_finish_urls())) {
                            return;
                        }
                        r0.K(info.getVv_finish_urls());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (str.equals("onPlayProgress")) {
                    y2 a3 = c3.a(this.a);
                    g3 g3Var2 = new g3(this.f63201e);
                    int intValue2 = ((Integer) obj).intValue();
                    try {
                        a3.f31377b = c3.d("vvst", g3Var2);
                        a3.k("desc", intValue2);
                    } catch (JSONException unused3) {
                    }
                    a3.m();
                } else if (str.equals("onRewardedAdStart")) {
                    Info info2 = this.f63201e;
                    if (info2 != null) {
                        try {
                            if (TextUtils.isEmpty(info2.getVv_start_urls())) {
                                return;
                            }
                            r0.o(info2, 400, "");
                            r0.K(info2.getVv_start_urls());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else if (str.equals("onT") && a2.d(this.f63201e, this.f63204h)) {
                    this.f63204h = System.currentTimeMillis();
                    if (TextUtils.isEmpty(this.f63203g)) {
                        this.f63203g = "";
                    }
                    try {
                        a((String) obj, this.f63203g);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f63201e == null) {
            return;
        }
        q0.c(this.f63201e.getId() + this.f63202f, "is_click", null);
        if (u0.f31323d.f31325c && this.f63201e.getOpent() == 1) {
            return;
        }
        a2.a(this.a, str, this.f63201e, this.f63205i, str2);
        y2 a = c3.a(this.a);
        a.h(new g3(this.f63201e), str);
        a.l("desc", str2);
        a.m();
        r0.p(this.f63201e, str2);
    }
}
