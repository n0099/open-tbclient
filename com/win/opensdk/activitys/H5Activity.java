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
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.face.liveness.activity.PassLivenessRecogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.win.opensdk.G;
import com.win.opensdk.G1;
import com.win.opensdk.H;
import com.win.opensdk.H1;
import com.win.opensdk.L;
import com.win.opensdk.N;
import com.win.opensdk.O;
import com.win.opensdk.Q1;
import com.win.opensdk.R;
import com.win.opensdk.U1;
import com.win.opensdk.Y0;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.core.Info;
import com.win.opensdk.g2;
import com.win.opensdk.h0;
import com.win.opensdk.views.CloseParentView;
import com.win.opensdk.w2;
import com.win.opensdk.y2;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class H5Activity extends Activity implements G1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39729a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f39730b;

    /* renamed from: c  reason: collision with root package name */
    public CloseParentView f39731c;

    /* renamed from: d  reason: collision with root package name */
    public w2 f39732d;

    /* renamed from: e  reason: collision with root package name */
    public Info f39733e;

    /* renamed from: f  reason: collision with root package name */
    public String f39734f;

    /* renamed from: g  reason: collision with root package name */
    public String f39735g;

    /* renamed from: h  reason: collision with root package name */
    public long f39736h;

    /* renamed from: i  reason: collision with root package name */
    public g2 f39737i;

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
        this.f39736h = 0L;
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
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
            Info info = this.f39733e;
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
            Info info2 = this.f39733e;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 <= 25 || i4 >= 28) {
                String str = this.f39734f;
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
            WebView webView = ((h0) this.f39732d).f39816c;
            webView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f39730b.addView(webView, 0);
            w2 w2Var = this.f39732d;
            if (w2Var instanceof h0) {
                ((h0) w2Var).a(this.f39733e.getLoad(), this.f39733e);
            }
            ((h0) this.f39732d).f39815b = new G(this);
            this.f39731c.setCollectVisible(false);
            this.f39731c.setLocation(PassLivenessRecogActivity.S);
            this.f39731c.setCountDown(this.f39733e.getCdt());
            this.f39731c.setOnCloseListener(new H(this));
            Z0.a(this.f39729a).b(new a1(this.f39733e)).a();
            H1.a(this.f39733e.getId() + this.f39734f, "is_display", null);
            if (this.f39733e != null) {
                U1.a(this.f39729a, this.f39733e.getId() + ":" + System.currentTimeMillis(), false);
            }
            N.a(this.f39733e);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f39733e.getCb() == 0) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.win_layout_activity_h5);
            this.f39729a = getApplicationContext();
            this.f39730b = (ViewGroup) findViewById(R.id.win_parent);
            this.f39731c = (CloseParentView) findViewById(R.id.win_close_parent);
            this.f39736h = 0L;
            this.f39737i = new g2(this);
            H1.a("hcl", this);
            H1.a("onT", this);
            H1.a("onRewardedShowFail", this);
            H1.a("onPlayProgress", this);
            H1.a("onRewardedAdFinish", this);
            H1.a("onRewardedAdStart", this);
            boolean z = false;
            try {
                Intent intent = getIntent();
                String stringExtra = intent.getStringExtra("id");
                this.f39734f = intent.getStringExtra("pid");
                String stringExtra2 = intent.getStringExtra("traceid");
                this.f39733e = L.a().a(y2.a(stringExtra2, stringExtra, this.f39734f));
                w2 a2 = y2.a().a(y2.a(stringExtra2, stringExtra, this.f39734f));
                this.f39732d = a2;
                if (a2 != null) {
                    if (this.f39733e != null) {
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
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDestroy();
            Z0.a(this.f39729a).a(new a1(this.f39733e)).a();
            w2 w2Var = this.f39732d;
            if (w2Var != null) {
                h0 h0Var = (h0) w2Var;
                WebView webView = h0Var.f39816c;
                if (webView != null) {
                    ViewGroup viewGroup = (ViewGroup) webView.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(h0Var.f39816c);
                    }
                    h0Var.f39816c.removeAllViews();
                    h0Var.f39816c.stopLoading();
                    h0Var.f39816c.setWebChromeClient(null);
                    h0Var.f39816c.setWebViewClient(null);
                    h0Var.f39816c.destroy();
                }
                if (h0Var.f39815b != null) {
                    h0Var.f39815b = null;
                }
            }
            CloseParentView closeParentView = this.f39731c;
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
            if (keyEvent.getKeyCode() != 4 || (info = this.f39733e) == null || info.getCb() > 0) {
                return super.onKeyDown(i2, keyEvent);
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.win.opensdk.G1
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, obj) == null) {
            if (str.equals("hcl")) {
                finish();
                H1.a(this.f39733e.getId() + this.f39734f, "is_dismiss", null);
                H1.a(this.f39733e.getId() + this.f39734f);
                H1.a("hcl");
                H1.a("onT");
                H1.a("onRewardedShowFail");
                H1.a("onPlayProgress");
                H1.a("onRewardedAdFinish");
                H1.a("onRewardedAdStart");
                return;
            }
            try {
                if (str.equals("onRewardedShowFail")) {
                    Y0 a2 = Z0.a(this.f39729a);
                    String str3 = (String) obj;
                    try {
                        a2.f39714b = Z0.a("vvsf", new a1(this.f39733e));
                        a2.a("desc", str3);
                    } catch (JSONException unused) {
                    }
                    a2.a();
                    H1.a(this.f39733e.getId() + this.f39734f, "VIDEO_SHOW_FAIL", (String) obj);
                } else if (str.equals("onRewardedAdFinish")) {
                    int intValue = ((Integer) obj).intValue();
                    if (intValue < 0 || intValue < this.f39733e.getVvt() * 0.9d) {
                        H1.a(this.f39733e.getId() + this.f39734f, "VIDEO_USER_EARNED_REWARD", null);
                    } else {
                        Y0 a3 = Z0.a(this.f39729a);
                        a1 a1Var = new a1(this.f39733e);
                        long vvamount = this.f39733e.getVvamount();
                        try {
                            a3.f39714b = Z0.a("vvss", a1Var);
                            a3.a("desc", vvamount);
                        } catch (JSONException unused2) {
                        }
                        a3.a();
                        H1.a(this.f39733e.getId() + this.f39734f, "VIDEO_USER_EARNED_REWARD", Long.valueOf(this.f39733e.getVvamount()));
                    }
                    Info info = this.f39733e;
                    try {
                        N.a(info, 401, "");
                        if (info == null || TextUtils.isEmpty(info.getVv_finish_urls())) {
                            return;
                        }
                        N.g(info.getVv_finish_urls());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (str.equals("onPlayProgress")) {
                    Y0 a4 = Z0.a(this.f39729a);
                    a1 a1Var2 = new a1(this.f39733e);
                    int intValue2 = ((Integer) obj).intValue();
                    try {
                        a4.f39714b = Z0.a("vvst", a1Var2);
                        a4.a("desc", intValue2);
                    } catch (JSONException unused3) {
                    }
                    a4.a();
                } else if (str.equals("onRewardedAdStart")) {
                    Info info2 = this.f39733e;
                    if (info2 != null) {
                        try {
                            if (TextUtils.isEmpty(info2.getVv_start_urls())) {
                                return;
                            }
                            N.a(info2, 400, "");
                            N.g(info2.getVv_start_urls());
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                } else if (str.equals("onT") && Q1.a(this.f39733e, this.f39736h)) {
                    this.f39736h = System.currentTimeMillis();
                    if (TextUtils.isEmpty(this.f39735g)) {
                        this.f39735g = "";
                    }
                    try {
                        a((String) obj, this.f39735g);
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
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.f39733e == null) {
            return;
        }
        H1.a(this.f39733e.getId() + this.f39734f, "is_click", null);
        if (O.f39604d.f39607c && this.f39733e.getOpent() == 1) {
            return;
        }
        Q1.a(this.f39729a, str, this.f39733e, this.f39737i, str2);
        Z0.a(this.f39729a).a(new a1(this.f39733e), str).a("desc", str2).a();
        N.a(this.f39733e, str2);
    }
}
