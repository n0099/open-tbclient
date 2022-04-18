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
import com.repackage.ap9;
import com.repackage.ar9;
import com.repackage.bp9;
import com.repackage.cs9;
import com.repackage.fp9;
import com.repackage.gs9;
import com.repackage.ht9;
import com.repackage.js9;
import com.repackage.mr9;
import com.repackage.rp9;
import com.repackage.so9;
import com.repackage.tp9;
import com.repackage.vp9;
import com.repackage.wp9;
import com.repackage.yr9;
import com.repackage.zp9;
import com.win.opensdk.core.Info;
import com.win.opensdk.views.CloseParentView;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class H5Activity extends Activity implements tp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public CloseParentView c;
    public so9 d;
    public Info e;
    public String f;
    public String g;
    public long h;
    public ht9 i;

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
        this.h = 0L;
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
        char c;
        View decorView;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Info info = this.e;
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
            Info info2 = this.e;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 <= 25 || i3 >= 28) {
                String str = this.f;
                int i4 = 1;
                if (!TextUtils.isEmpty(str) && str.length() > 3) {
                    String substring = str.substring(0, 3);
                    switch (substring.hashCode()) {
                        case 53431:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_NAVIGATION)) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53432:
                            if (substring.equals("602")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53433:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_FRS)) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53434:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_PB)) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53435:
                        default:
                            c = 65535;
                            break;
                        case 53436:
                            if (substring.equals(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER)) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 53437:
                            if (substring.equals("607")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                    }
                    if (c == 0) {
                        i4 = 0;
                    } else if (c != 1) {
                        if (c == 2 || c == 3) {
                            i4 = info2.isVertical();
                        }
                    }
                    setRequestedOrientation(i4);
                }
                i4 = 2;
                setRequestedOrientation(i4);
            }
            WebView webView = ((js9) this.d).c;
            webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.b.addView(webView, 0);
            so9 so9Var = this.d;
            if (so9Var instanceof js9) {
                ((js9) so9Var).a(this.e.getLoad(), this.e);
            }
            ((js9) this.d).b = new bp9(this);
            this.c.setCollectVisible(false);
            this.c.setLocation(220);
            this.c.setCountDown(this.e.getCdt());
            this.c.setOnCloseListener(new fp9(this));
            yr9 a = cs9.a(this.a);
            a.o(new gs9(this.e));
            a.m();
            vp9.c(this.e.getId() + this.f, "is_display", null);
            if (this.e != null) {
                mr9.g(this.a, this.e.getId() + ":" + System.currentTimeMillis(), false);
            }
            wp9.n(this.e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Info info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (info = this.e) != null && info.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d08ce);
            this.a = getApplicationContext();
            this.b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f092460);
            this.c = (CloseParentView) findViewById(R.id.obfuscated_res_0x7f092457);
            this.h = 0L;
            this.i = new ht9(this);
            vp9.b("hcl", this);
            vp9.b("onT", this);
            vp9.b("onRewardedShowFail", this);
            vp9.b("onPlayProgress", this);
            vp9.b("onRewardedAdFinish", this);
            vp9.b("onRewardedAdStart", this);
            boolean z = false;
            try {
                Intent intent = getIntent();
                String stringExtra = intent.getStringExtra("id");
                this.f = intent.getStringExtra("pid");
                String stringExtra2 = intent.getStringExtra("traceid");
                this.e = rp9.a().b(ap9.c(stringExtra2, stringExtra, this.f));
                so9 a = ap9.b().a(ap9.c(stringExtra2, stringExtra, this.f));
                this.d = a;
                if (a != null) {
                    if (this.e != null) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
            yr9 a = cs9.a(this.a);
            a.b(new gs9(this.e));
            a.m();
            so9 so9Var = this.d;
            if (so9Var != null) {
                js9 js9Var = (js9) so9Var;
                WebView webView = js9Var.c;
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(js9Var.c);
                    }
                    js9Var.c.removeAllViews();
                    js9Var.c.stopLoading();
                    js9Var.c.setWebChromeClient(null);
                    js9Var.c.setWebViewClient(null);
                    js9Var.c.destroy();
                }
                if (js9Var.b != null) {
                    js9Var.b = null;
                }
            }
            CloseParentView closeParentView = this.c;
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
            if (keyEvent.getKeyCode() != 4 || (info = this.e) == null || info.getCb() > 0) {
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
                this.f = bundle.getString("st_pid");
                this.e = (Info) bundle.getSerializable("st_info");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putString("st_pid", this.f);
            bundle.putSerializable("st_info", this.e);
        }
    }

    @Override // com.repackage.tp9
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj) == null) {
            if (str.equals("hcl")) {
                finish();
                if (this.e != null) {
                    vp9.c(this.e.getId() + this.f, "is_dismiss", null);
                    vp9.a(this.e.getId() + this.f);
                }
                vp9.a("hcl");
                vp9.a("onT");
                vp9.a("onRewardedShowFail");
                vp9.a("onPlayProgress");
                vp9.a("onRewardedAdFinish");
                vp9.a("onRewardedAdStart");
                return;
            }
            try {
                if (str.equals("onRewardedShowFail")) {
                    yr9 a = cs9.a(this.a);
                    String str3 = (String) obj;
                    try {
                        a.b = cs9.d("vvsf", new gs9(this.e));
                        a.l("desc", str3);
                    } catch (JSONException unused) {
                    }
                    a.m();
                    vp9.c(this.e.getId() + this.f, "VIDEO_SHOW_FAIL", (String) obj);
                } else if (str.equals("onRewardedAdFinish")) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue < 0 || intValue < this.e.getVvt() * 0.9d) {
                        vp9.c(this.e.getId() + this.f, "VIDEO_USER_EARNED_REWARD", null);
                    } else {
                        yr9 a2 = cs9.a(this.a);
                        gs9 gs9Var = new gs9(this.e);
                        long vvamount = this.e.getVvamount();
                        try {
                            a2.b = cs9.d("vvss", gs9Var);
                            a2.k("desc", vvamount);
                        } catch (JSONException unused2) {
                        }
                        a2.m();
                        vp9.c(this.e.getId() + this.f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.e.getVvamount()));
                    }
                    Info info = this.e;
                    try {
                        wp9.o(info, 401, "");
                        if (info == null || TextUtils.isEmpty(info.getVv_finish_urls())) {
                            return;
                        }
                        wp9.K(info.getVv_finish_urls());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("onPlayProgress")) {
                    yr9 a3 = cs9.a(this.a);
                    gs9 gs9Var2 = new gs9(this.e);
                    int intValue2 = ((Integer) obj).intValue();
                    try {
                        a3.b = cs9.d("vvst", gs9Var2);
                        a3.k("desc", intValue2);
                    } catch (JSONException unused3) {
                    }
                    a3.m();
                } else if (str.equals("onRewardedAdStart")) {
                    Info info2 = this.e;
                    if (info2 != null) {
                        try {
                            if (TextUtils.isEmpty(info2.getVv_start_urls())) {
                                return;
                            }
                            wp9.o(info2, 400, "");
                            wp9.K(info2.getVv_start_urls());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (str.equals("onT") && ar9.d(this.e, this.h)) {
                    this.h = System.currentTimeMillis();
                    if (TextUtils.isEmpty(this.g)) {
                        this.g = "";
                    }
                    try {
                        a((String) obj, this.g);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.e == null) {
            return;
        }
        vp9.c(this.e.getId() + this.f, "is_click", null);
        if (zp9.d.c && this.e.getOpent() == 1) {
            return;
        }
        ar9.a(this.a, str, this.e, this.i, str2);
        yr9 a = cs9.a(this.a);
        a.h(new gs9(this.e), str);
        a.l("desc", str2);
        a.m();
        wp9.p(this.e, str2);
    }
}
