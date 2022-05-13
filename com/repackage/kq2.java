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
import com.repackage.d02;
import com.repackage.rl2;
/* loaded from: classes6.dex */
public class kq2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public z64 a;
    public SwanAppMenuHeaderView b;
    public a02 c;
    public Context d;

    /* loaded from: classes6.dex */
    public class a implements y64 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq2 a;

        public a(kq2 kq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq2Var;
        }

        @Override // com.repackage.y64
        public boolean b(View view2, a74 a74Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, a74Var)) == null) ? this.a.v(a74Var) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq2 a;

        public b(kq2 kq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq2Var;
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

    /* loaded from: classes6.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq2 a;

        public c(kq2 kq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq2Var;
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

    /* loaded from: classes6.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq2 a;

        public d(kq2 kq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq2Var;
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

    /* loaded from: classes6.dex */
    public class e implements oc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kq2 a;

        public e(kq2 kq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kq2Var;
        }

        @Override // com.repackage.oc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03 f = m03.f(this.a.d, R.string.obfuscated_res_0x7f0f1305);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.oc2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                m03 f = m03.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f010c);
                f.l(2);
                f.G();
                this.a.C();
            }
        }

        @Override // com.repackage.oc2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || z) {
                return;
            }
            m03 f = m03.f(this.a.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f010b);
            f.l(2);
            f.G();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kq2 b;

        public f(kq2 kq2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kq2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kq2Var;
            this.a = str;
        }

        @Override // com.repackage.nc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03 f = m03.f(this.b.d, R.string.obfuscated_res_0x7f0f1305);
                f.l(2);
                f.G();
            }
        }

        @Override // com.repackage.nc2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || z) {
                return;
            }
            m03 f = m03.f(this.b.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0154);
            f.l(2);
            f.G();
        }

        @Override // com.repackage.nc2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                s72.t();
                if (!kq2.k(this.b.c.getActivity())) {
                    m03 g = m03.g(this.b.d, bk2.l0().f(this.b.d));
                    g.l(2);
                    g.q(2);
                    g.G();
                    this.b.C();
                    return;
                }
                kq2.p("addmyswan", this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class g implements nc2 {
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

        @Override // com.repackage.nc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                m03 f = m03.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f1305);
                f.l(2);
                f.G();
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.repackage.nc2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (!z) {
                    m03 f = m03.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0154);
                    f.l(2);
                    f.G();
                }
                h hVar = this.b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // com.repackage.nc2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                s72.t();
                if (kq2.k(this.a)) {
                    h hVar = this.b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.a.getApplicationContext();
                m03 g = m03.g(applicationContext, bk2.l0().f(applicationContext));
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

    /* loaded from: classes6.dex */
    public interface h {
        void onFail();

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755550299, "Lcom/repackage/kq2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755550299, "Lcom/repackage/kq2;");
                return;
            }
        }
        e = eh1.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public kq2(z64 z64Var, a02 a02Var) {
        this(z64Var, a02Var, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z64Var, a02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((z64) objArr2[0], (a02) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String N = t03.J().r().N();
            if (TextUtils.isEmpty(N) && hVar != null) {
                hVar.onFail();
            }
            if (!s72.n(N)) {
                SwanFavorDataManager.h().b(N, new g(activity, hVar));
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
        boolean a2 = bk2.M().a();
        bk2.M().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(bk2.M().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a2) {
            m03 f2 = m03.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f0107);
            f2.m(R.drawable.obfuscated_res_0x7f08013e);
            f2.l(2);
            f2.B();
        } else {
            m03 f3 = m03.f(activity.getApplicationContext(), R.string.obfuscated_res_0x7f0f0108);
            f3.m(R.drawable.obfuscated_res_0x7f0801a2);
            f3.l(2);
            f3.B();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? bk2.l0().a(activity) : invokeL.booleanValue;
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
        x73 x73Var = new x73();
        x73Var.e = str;
        if (!TextUtils.isEmpty(str2)) {
            x73Var.a("page", str2);
            x73Var.g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            x73Var.b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            x73Var.a(str4, str5);
        }
        SwanAppActivity activity = hm2.U().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(x73Var);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().D());
            if (activity != null) {
                dd3.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            d02 V = hm2.U().V();
            if (V == null) {
                m03.f(this.d, R.string.obfuscated_res_0x7f0f019e).G();
                return;
            }
            d02.b i = V.i("navigateTo");
            i.n(d02.g, d02.i);
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
            d02 L1 = this.c.L1();
            if (L1 == null) {
                m03.f(this.d, R.string.obfuscated_res_0x7f0f019e).G();
                return;
            }
            d02.b i = L1.i("navigateTo");
            i.n(d02.g, d02.i);
            i.k("authority", null).a();
            o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.setAttentionBtnStates(s72.n(t03.J().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            pe3.b(this.d).c(uq2.b(oe3.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        rl2.a launchInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (tw2.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                m03.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0127).G();
                return;
            }
            if (e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (u03.a0() != null) {
                launchInfo = u03.a0().V();
            } else {
                launchInfo = ((SwanAppActivity) this.c.getActivity()).getLaunchInfo();
            }
            h63.i(this.c.getContext(), launchInfo);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (tw2.H()) {
                if (e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                m03.f(this.d.getApplicationContext(), R.string.obfuscated_res_0x7f0f0126).G();
                return;
            }
            String e2 = oe3.n().e();
            SwanFavorDataManager.h().b(str, new f(this, e2));
            p("addmyswan", e2);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            pa2 l = pa2.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.L2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d02 L1 = this.c.L1();
            if (L1 == null) {
                m03.f(this.d, R.string.obfuscated_res_0x7f0f019e).G();
                return;
            }
            d02.b i = L1.i("navigateTo");
            i.n(d02.g, d02.i);
            i.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String N = t03.J().r().N();
            if (TextUtils.isEmpty(N)) {
                return;
            }
            if (s72.n(N)) {
                m(N);
            } else {
                l(N);
            }
        }
    }

    public boolean v(a74 a74Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, a74Var)) == null) {
            if (this.c == null || this.d == null) {
                return false;
            }
            int c2 = a74Var.c();
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
                        return bk2.K().j(a74Var);
                }
            } else {
                oe3.d();
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
                string = this.d.getString(R.string.obfuscated_res_0x7f0f1326);
            } else {
                string = this.d.getString(R.string.obfuscated_res_0x7f0f1325);
            }
            m03 g2 = m03.g(this.d, string);
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
            ce3.a(hm2.U().getActivity());
            ux1.k("SwanAppMenuHelper", "restart");
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
            ce3.a((SwanAppActivity) context);
        }
    }

    public void z() {
        u03 r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.a == null || this.c == null || this.d == null || (r = t03.J().r()) == null) {
            return;
        }
        r.x();
        this.a.o(new a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.b.setAttentionBtnShow(bk2.t().b());
            this.b.setOnAttentionBtnClickListener(new c(this));
            if (r.v0()) {
                return;
            }
            this.b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public kq2(z64 z64Var, a02 a02Var, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {z64Var, a02Var, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = z64Var;
        this.b = swanAppMenuHeaderView;
        this.c = a02Var;
        if (a02Var != null) {
            this.d = a02Var.getContext();
        }
    }
}
