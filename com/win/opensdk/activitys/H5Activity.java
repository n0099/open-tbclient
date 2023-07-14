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
import com.baidu.pass.biometrics.face.liveness.PassFaceRecogManager;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.D2;
import com.win.opensdk.F;
import com.win.opensdk.F2;
import com.win.opensdk.G;
import com.win.opensdk.K;
import com.win.opensdk.L1;
import com.win.opensdk.M;
import com.win.opensdk.M1;
import com.win.opensdk.N;
import com.win.opensdk.V1;
import com.win.opensdk.Z1;
import com.win.opensdk.core.Info;
import com.win.opensdk.d1;
import com.win.opensdk.e1;
import com.win.opensdk.f1;
import com.win.opensdk.g0;
import com.win.opensdk.m2;
import com.win.opensdk.views.CloseParentView;
import org.json.JSONException;
/* loaded from: classes10.dex */
public class H5Activity extends Activity implements L1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ViewGroup b;
    public CloseParentView c;
    public D2 d;
    public Info e;
    public String f;
    public String g;
    public long h;
    public m2 i;

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

    @Override // android.app.Activity
    public void onBackPressed() {
        Info info;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (info = this.e) != null && info.getCb() == 0) {
            super.onBackPressed();
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x00a3 */
    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: int */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [boolean] */
    public final void a() {
        boolean z;
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
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
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
                    if (c != 0) {
                        if (c != 1) {
                            if (c == 2 || c == 3) {
                                i4 = info2.isVertical();
                            }
                        }
                    } else {
                        i4 = 0;
                    }
                    setRequestedOrientation(i4);
                }
                i4 = 2;
                setRequestedOrientation(i4);
            }
            WebView webView = ((g0) this.d).c;
            webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.b.addView(webView, 0);
            D2 d2 = this.d;
            if (d2 instanceof g0) {
                ((g0) d2).a(this.e.getLoad(), this.e);
            }
            ((g0) this.d).b = new F(this);
            this.c.setCollectVisible(false);
            this.c.setLocation(PassFaceRecogManager.j);
            this.c.setCountDown(this.e.getCdt());
            this.c.setOnCloseListener(new G(this));
            d1 a = e1.a(this.a);
            try {
                a.b = e1.a("as", new f1(this.e));
            } catch (JSONException unused) {
            }
            a.a();
            M1.a(this.e.getId() + this.f, "is_display", null);
            if (this.e != null) {
                Z1.a(this.a, this.e.getId() + ":" + System.currentTimeMillis(), false);
            }
            M.a(this.e);
        }
    }

    public final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) && this.e != null) {
            M1.a(this.e.getId() + this.f, "is_click", null);
            if (N.d.c && this.e.getOpent() == 1) {
                return;
            }
            V1.a(this.a, str, this.e, this.i, str2);
            e1.a(this.a).a(new f1(this.e), str).a("desc", str2).a();
            M.a(this.e, str2);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x01eb -> B:82:0x01ee). Please submit an issue!!! */
    @Override // com.win.opensdk.L1
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj) == null) {
            if (str.equals("hcl")) {
                finish();
                if (this.e != null) {
                    M1.a(this.e.getId() + this.f, "is_dismiss", null);
                    M1.a(this.e.getId() + this.f);
                }
                M1.a("hcl");
                M1.a("onT");
                M1.a("onRewardedShowFail");
                M1.a("onPlayProgress");
                M1.a("onRewardedAdFinish");
                M1.a("onRewardedAdStart");
                M1.a("onCustomEvent");
                return;
            }
            try {
                if (str.equals("onRewardedShowFail")) {
                    d1 a = e1.a(this.a);
                    String str3 = (String) obj;
                    try {
                        a.b = e1.a("vvsf", new f1(this.e));
                        a.a("desc", str3);
                    } catch (JSONException unused) {
                    }
                    a.a();
                    M1.a(this.e.getId() + this.f, "VIDEO_SHOW_FAIL", (String) obj);
                } else if (str.equals("onRewardedAdFinish")) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue >= 0 && intValue >= this.e.getVvt() * 0.9d) {
                        d1 a2 = e1.a(this.a);
                        f1 f1Var = new f1(this.e);
                        long vvamount = this.e.getVvamount();
                        try {
                            a2.b = e1.a("vvss", f1Var);
                            a2.a("desc", vvamount);
                        } catch (JSONException unused2) {
                        }
                        a2.a();
                        M1.a(this.e.getId() + this.f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.e.getVvamount()));
                    } else {
                        M1.a(this.e.getId() + this.f, "VIDEO_USER_EARNED_REWARD", null);
                    }
                    Info info = this.e;
                    try {
                        M.a(info, 401, "");
                        if (info != null && !TextUtils.isEmpty(info.getVv_finish_urls())) {
                            M.g(info.getVv_finish_urls());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (str.equals("onPlayProgress")) {
                    d1 a3 = e1.a(this.a);
                    f1 f1Var2 = new f1(this.e);
                    int intValue2 = ((Integer) obj).intValue();
                    try {
                        a3.b = e1.a("vvst", f1Var2);
                        a3.a("desc", intValue2);
                    } catch (JSONException unused3) {
                    }
                    a3.a();
                } else if (str.equals("onRewardedAdStart")) {
                    Info info2 = this.e;
                    if (info2 != null) {
                        try {
                            if (!TextUtils.isEmpty(info2.getVv_start_urls())) {
                                M.a(info2, 400, "");
                                M.g(info2.getVv_start_urls());
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } else {
                    try {
                        if (str.equals("onT")) {
                            if (V1.a(this.e, this.h)) {
                                this.h = System.currentTimeMillis();
                                if (TextUtils.isEmpty(this.g)) {
                                    this.g = "";
                                }
                                a((String) obj, this.g);
                            }
                        } else if (str.equals("onCustomEvent")) {
                            M.a(this.e, Integer.parseInt(str2), (String) obj);
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0a28);
            this.a = getApplicationContext();
            this.b = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f092a09);
            this.c = (CloseParentView) findViewById(R.id.obfuscated_res_0x7f092a00);
            this.h = 0L;
            this.i = new m2(this);
            M1.a("hcl", this);
            M1.a("onT", this);
            M1.a("onRewardedShowFail", this);
            M1.a("onPlayProgress", this);
            M1.a("onRewardedAdFinish", this);
            M1.a("onRewardedAdStart", this);
            M1.a("onCustomEvent", this);
            boolean z = false;
            try {
                Intent intent = getIntent();
                String stringExtra = intent.getStringExtra("id");
                this.f = intent.getStringExtra("pid");
                String stringExtra2 = intent.getStringExtra("traceid");
                this.e = K.a().a(F2.a(stringExtra2, stringExtra, this.f));
                D2 a = F2.a().a(F2.a(stringExtra2, stringExtra, this.f));
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
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            e1.a(this.a).a(new f1(this.e)).a();
            D2 d2 = this.d;
            if (d2 != null) {
                g0 g0Var = (g0) d2;
                WebView webView = g0Var.c;
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(g0Var.c);
                    }
                    g0Var.c.removeAllViews();
                    g0Var.c.stopLoading();
                    g0Var.c.setWebChromeClient(null);
                    g0Var.c.setWebViewClient(null);
                    g0Var.c.destroy();
                }
                if (g0Var.b != null) {
                    g0Var.b = null;
                }
            }
            CloseParentView closeParentView = this.c;
            if (closeParentView != null) {
                closeParentView.b();
            }
        }
    }
}
