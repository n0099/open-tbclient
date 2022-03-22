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
import c.m.a.a0;
import c.m.a.b3;
import c.m.a.c4;
import c.m.a.e3;
import c.m.a.h2;
import c.m.a.m0;
import c.m.a.n;
import c.m.a.o0;
import c.m.a.q0;
import c.m.a.r0;
import c.m.a.t2;
import c.m.a.u0;
import c.m.a.v;
import c.m.a.v1;
import c.m.a.w;
import c.m.a.x2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CloseParentView;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class H5Activity extends Activity implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f44003b;

    /* renamed from: c  reason: collision with root package name */
    public CloseParentView f44004c;

    /* renamed from: d  reason: collision with root package name */
    public n f44005d;

    /* renamed from: e  reason: collision with root package name */
    public Info f44006e;

    /* renamed from: f  reason: collision with root package name */
    public String f44007f;

    /* renamed from: g  reason: collision with root package name */
    public String f44008g;

    /* renamed from: h  reason: collision with root package name */
    public long f44009h;
    public c4 i;

    public H5Activity() {
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
        this.f44009h = 0L;
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
        intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Info info = this.f44006e;
            if (info != null && info.getXn() > 0) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 > 11 && i2 < 19) {
                    decorView = getWindow().getDecorView();
                    i = 8;
                } else if (Build.VERSION.SDK_INT >= 19) {
                    decorView = getWindow().getDecorView();
                    i = 4102;
                }
                decorView.setSystemUiVisibility(i);
            }
            Info info2 = this.f44006e;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 <= 25 || i3 >= 28) {
                String str = this.f44007f;
                int i4 = 1;
                if (!TextUtils.isEmpty(str) && str.length() > 3) {
                    String substring = str.substring(0, 3);
                    switch (substring.hashCode()) {
                        case 53431:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_NAVIGATION)) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53432:
                            if (substring.equals("602")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53433:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_FRS)) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 53434:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_PB)) {
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
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER)) {
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
                        i4 = 0;
                    } else if (c2 != 1) {
                        if (c2 == 2 || c2 == 3) {
                            i4 = info2.isVertical();
                        }
                    }
                    setRequestedOrientation(i4);
                }
                i4 = 2;
                setRequestedOrientation(i4);
            }
            WebView webView = ((e3) this.f44005d).f23428c;
            webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f44003b.addView(webView, 0);
            n nVar = this.f44005d;
            if (nVar instanceof e3) {
                ((e3) nVar).a(this.f44006e.getLoad(), this.f44006e);
            }
            ((e3) this.f44005d).f23427b = new w(this);
            this.f44004c.setCollectVisible(false);
            this.f44004c.setLocation(220);
            this.f44004c.setCountDown(this.f44006e.getCdt());
            this.f44004c.setOnCloseListener(new a0(this));
            t2 a = x2.a(this.a);
            a.o(new b3(this.f44006e));
            a.m();
            q0.c(this.f44006e.getId() + this.f44007f, "is_display", null);
            if (this.f44006e != null) {
                h2.g(this.a, this.f44006e.getId() + ":" + System.currentTimeMillis(), false);
            }
            r0.n(this.f44006e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Info info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (info = this.f44006e) != null && info.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d08d8);
            this.a = getApplicationContext();
            this.f44003b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f092484);
            this.f44004c = (CloseParentView) findViewById(R.id.obfuscated_res_0x7f09247b);
            this.f44009h = 0L;
            this.i = new c4(this);
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
                this.f44007f = intent.getStringExtra("pid");
                String stringExtra2 = intent.getStringExtra("traceid");
                this.f44006e = m0.a().b(v.c(stringExtra2, stringExtra, this.f44007f));
                n a = v.b().a(v.c(stringExtra2, stringExtra, this.f44007f));
                this.f44005d = a;
                if (a != null) {
                    if (this.f44006e != null) {
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
            t2 a = x2.a(this.a);
            a.b(new b3(this.f44006e));
            a.m();
            n nVar = this.f44005d;
            if (nVar != null) {
                e3 e3Var = (e3) nVar;
                WebView webView = e3Var.f23428c;
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(e3Var.f23428c);
                    }
                    e3Var.f23428c.removeAllViews();
                    e3Var.f23428c.stopLoading();
                    e3Var.f23428c.setWebChromeClient(null);
                    e3Var.f23428c.setWebViewClient(null);
                    e3Var.f23428c.destroy();
                }
                if (e3Var.f23427b != null) {
                    e3Var.f23427b = null;
                }
            }
            CloseParentView closeParentView = this.f44004c;
            if (closeParentView != null) {
                closeParentView.c();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Info info;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, keyEvent)) == null) {
            if (keyEvent.getKeyCode() != 4 || (info = this.f44006e) == null || info.getCb() > 0) {
                return super.onKeyDown(i, keyEvent);
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
                this.f44007f = bundle.getString("st_pid");
                this.f44006e = (Info) bundle.getSerializable("st_info");
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
            bundle.putString("st_pid", this.f44007f);
            bundle.putSerializable("st_info", this.f44006e);
        }
    }

    @Override // c.m.a.o0
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj) == null) {
            if (str.equals("hcl")) {
                finish();
                if (this.f44006e != null) {
                    q0.c(this.f44006e.getId() + this.f44007f, "is_dismiss", null);
                    q0.a(this.f44006e.getId() + this.f44007f);
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
                    t2 a = x2.a(this.a);
                    String str3 = (String) obj;
                    try {
                        a.f23575b = x2.d("vvsf", new b3(this.f44006e));
                        a.l("desc", str3);
                    } catch (JSONException unused) {
                    }
                    a.m();
                    q0.c(this.f44006e.getId() + this.f44007f, "VIDEO_SHOW_FAIL", (String) obj);
                } else if (str.equals("onRewardedAdFinish")) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue < 0 || intValue < this.f44006e.getVvt() * 0.9d) {
                        q0.c(this.f44006e.getId() + this.f44007f, "VIDEO_USER_EARNED_REWARD", null);
                    } else {
                        t2 a2 = x2.a(this.a);
                        b3 b3Var = new b3(this.f44006e);
                        long vvamount = this.f44006e.getVvamount();
                        try {
                            a2.f23575b = x2.d("vvss", b3Var);
                            a2.k("desc", vvamount);
                        } catch (JSONException unused2) {
                        }
                        a2.m();
                        q0.c(this.f44006e.getId() + this.f44007f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.f44006e.getVvamount()));
                    }
                    Info info = this.f44006e;
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
                    t2 a3 = x2.a(this.a);
                    b3 b3Var2 = new b3(this.f44006e);
                    int intValue2 = ((Integer) obj).intValue();
                    try {
                        a3.f23575b = x2.d("vvst", b3Var2);
                        a3.k("desc", intValue2);
                    } catch (JSONException unused3) {
                    }
                    a3.m();
                } else if (str.equals("onRewardedAdStart")) {
                    Info info2 = this.f44006e;
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
                } else if (str.equals("onT") && v1.d(this.f44006e, this.f44009h)) {
                    this.f44009h = System.currentTimeMillis();
                    if (TextUtils.isEmpty(this.f44008g)) {
                        this.f44008g = "";
                    }
                    try {
                        a((String) obj, this.f44008g);
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
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f44006e == null) {
            return;
        }
        q0.c(this.f44006e.getId() + this.f44007f, "is_click", null);
        if (u0.f23588d.f23590c && this.f44006e.getOpent() == 1) {
            return;
        }
        v1.a(this.a, str, this.f44006e, this.i, str2);
        t2 a = x2.a(this.a);
        a.h(new b3(this.f44006e), str);
        a.l("desc", str2);
        a.m();
        r0.p(this.f44006e, str2);
    }
}
