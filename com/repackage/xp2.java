package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.el2;
import com.repackage.qz1;
/* loaded from: classes7.dex */
public class xp2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public m64 a;
    public SwanAppMenuHeaderView b;
    public nz1 c;
    public Context d;

    /* loaded from: classes7.dex */
    public class a implements l64 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public a(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.repackage.l64
        public boolean b(View view2, n64 n64Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, n64Var)) == null) ? this.a.v(n64Var) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public b(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.f();
                this.a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public c(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.f();
                this.a.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public d(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.a.f();
                return this.a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements bc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp2 a;

        public e(xp2 xp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp2Var;
        }

        @Override // com.repackage.bc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zz2 f = zz2.f(this.a.d, R.string.obfuscated_res_0x7f0f131d);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.bc2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zz2 f = zz2.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f010f);
                f.l(2);
                f.G();
                this.a.C();
            }
        }

        @Override // com.repackage.bc2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            zz2 f = zz2.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f010e);
            f.l(2);
            f.G();
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ac2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xp2 b;

        public f(xp2 xp2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xp2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xp2Var;
            this.a = str;
        }

        @Override // com.repackage.ac2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zz2 f = zz2.f(this.b.d, R.string.obfuscated_res_0x7f0f131d);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.ac2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            zz2 f = zz2.f(this.b.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0157);
            f.l(2);
            f.G();
        }

        @Override // com.repackage.ac2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                f72.t();
                if (!xp2.k(this.b.c.getActivity())) {
                    zz2 g = zz2.g(this.b.d, oj2.l0().f(this.b.d));
                    g.l(2);
                    g.q(2);
                    g.G();
                    this.b.C();
                    return;
                }
                xp2.p("addmyswan", this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements ac2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ h b;

        public g(Activity activity, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = hVar;
        }

        @Override // com.repackage.ac2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zz2 f = zz2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f131d);
                f.l(2);
                f.G();
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.repackage.ac2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    zz2 f = zz2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0157);
                    f.l(2);
                    f.G();
                }
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.repackage.ac2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                f72.t();
                if (xp2.k(this.a)) {
                    h hVar = this.b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.a.getApplicationContext();
                zz2 g = zz2.g(applicationContext, oj2.l0().f(applicationContext));
                g.l(2);
                g.q(2);
                g.G();
                h hVar2 = this.b;
                if (hVar2 != null) {
                    hVar2.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755163977, "Lcom/repackage/xp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755163977, "Lcom/repackage/xp2;");
                return;
            }
        }
        e = rg1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xp2(m64 m64Var, nz1 nz1Var) {
        this(m64Var, nz1Var, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m64Var, nz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((m64) objArr2[0], (nz1) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String O = g03.K().q().O();
            if (TextUtils.isEmpty(O) && hVar != null) {
                hVar.onFail();
            }
            if (!f72.n(O)) {
                SwanFavorDataManager.h().b(O, new g(activity, hVar));
            } else if (hVar != null) {
                hVar.onSuccess();
            }
        }
    }

    public static void j(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, activity) == null) || activity == null) {
            return;
        }
        if (e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = oj2.M().a();
        oj2.M().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).x(oj2.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).D();
        }
        if (a2) {
            zz2 f2 = zz2.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f010a);
            f2.m(R.drawable.obfuscated_res_0x7f08013d);
            f2.l(2);
            f2.B();
        } else {
            zz2 f3 = zz2.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f010b);
            f3.m(R.drawable.obfuscated_res_0x7f0801a1);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? oj2.l0().a(activity) : invokeL.booleanValue;
    }

    public static void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, str) == null) {
            p(str, null);
        }
    }

    public static void p(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) {
            q(str, str2, null);
        }
    }

    public static void q(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, str2, str3) == null) {
            r(str, str2, str3, null, null);
        }
    }

    public static void r(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(65552, null, str, str2, str3, str4, str5) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        k73 k73Var = new k73();
        k73Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            k73Var.a("page", str2);
            k73Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            k73Var.b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            k73Var.a(str4, str5);
        }
        SwanAppActivity activity = ul2.U().getActivity();
        if (activity != null) {
            activity.N(k73Var);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).x().D());
            if (activity != null) {
                qc3.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            qz1 V = ul2.U().V();
            if (V == null) {
                zz2.f(this.d, R.string.obfuscated_res_0x7f0f01a1).G();
                return;
            }
            qz1.b i = V.i("navigateTo");
            i.n(qz1.g, qz1.i);
            i.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startSettingFragment");
            }
            qz1 M1 = this.c.M1();
            if (M1 == null) {
                zz2.f(this.d, R.string.obfuscated_res_0x7f0f01a1).G();
                return;
            }
            qz1.b i = M1.i("navigateTo");
            i.n(qz1.g, qz1.i);
            i.k("authority", null).a();
            o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setAttentionBtnStates(f72.n(g03.K().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ce3.b(this.d).c(hq2.b(be3.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        el2.a S;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (gw2.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                zz2.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f012a).G();
                return;
            }
            if (e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (h03.b0() != null) {
                S = h03.b0().W();
            } else {
                S = ((SwanAppActivity) this.c.getActivity()).S();
            }
            u53.i(this.c.getContext(), S);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (gw2.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                zz2.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0129).G();
                return;
            }
            String e2 = be3.n().e();
            SwanFavorDataManager.h().b(str, new f(this, e2));
            p("addmyswan", e2);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            ca2 l = ca2.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.M2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qz1 M1 = this.c.M1();
            if (M1 == null) {
                zz2.f(this.d, R.string.obfuscated_res_0x7f0f01a1).G();
                return;
            }
            qz1.b i = M1.i("navigateTo");
            i.n(qz1.g, qz1.i);
            i.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String O = g03.K().q().O();
            if (TextUtils.isEmpty(O)) {
                return;
            }
            if (f72.n(O)) {
                m(O);
            } else {
                l(O);
            }
        }
    }

    public boolean v(n64 n64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, n64Var)) == null) {
            if (this.c == null || this.d == null) {
                return false;
            }
            int c2 = n64Var.c();
            if (c2 == 4) {
                n();
                return true;
            } else if (c2 == 5) {
                j(this.c.getActivity());
                return true;
            } else if (c2 == 35) {
                i();
                return true;
            } else if (c2 == 49) {
                s();
                return true;
            } else if (c2 == 42) {
                y();
                return true;
            } else if (c2 != 43) {
                switch (c2) {
                    case 37:
                        B();
                        return true;
                    case 38:
                        u();
                        return true;
                    case 39:
                        x();
                        return true;
                    default:
                        return oj2.K().j(n64Var);
                }
            } else {
                be3.d();
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean w() {
        InterceptResult invokeV;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.c == null || this.d == null) {
                return false;
            }
            if (D()) {
                string = this.d.getString(R.string.obfuscated_res_0x7f0f133e);
            } else {
                string = this.d.getString(R.string.obfuscated_res_0x7f0f133d);
            }
            zz2 g2 = zz2.g(this.d, string);
            g2.l(2);
            g2.G();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o(Headers.REFRESH);
            pd3.a(ul2.U().getActivity());
            hx1.k("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "restart");
            }
            Context context = this.d;
            if (context == null) {
                return;
            }
            pd3.a((SwanAppActivity) context);
        }
    }

    public void z() {
        h03 q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.a == null || this.c == null || this.d == null || (q = g03.K().q()) == null) {
            return;
        }
        q.w();
        this.a.n(new a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.b.setAttentionBtnShow(oj2.t().b());
            this.b.setOnAttentionBtnClickListener(new c(this));
            if (q.w0()) {
                return;
            }
            this.b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public xp2(m64 m64Var, nz1 nz1Var, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m64Var, nz1Var, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = m64Var;
        this.b = swanAppMenuHeaderView;
        this.c = nz1Var;
        if (nz1Var != null) {
            this.d = nz1Var.getContext();
        }
    }
}
