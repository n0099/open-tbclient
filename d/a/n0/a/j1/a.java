package d.a.n0.a.j1;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.h0.g.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.e0;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.r0;
import d.a.n0.k.n;
import d.a.n0.k.o;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45693e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public n f45694a;

    /* renamed from: b  reason: collision with root package name */
    public SwanAppMenuHeaderView f45695b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.h0.g.d f45696c;

    /* renamed from: d  reason: collision with root package name */
    public Context f45697d;

    /* renamed from: d.a.n0.a.j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0790a implements d.a.n0.k.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45698e;

        public C0790a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45698e = aVar;
        }

        @Override // d.a.n0.k.e
        public boolean b(View view, o oVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, oVar)) == null) ? this.f45698e.v(oVar) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45699a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45699a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45699a.f45694a.d();
                this.f45699a.A();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements SwanAppMenuHeaderView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45700a;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45700a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.e
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f45700a.f45694a.d();
                this.f45700a.u();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements SwanAppMenuHeaderView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45701a;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45701a = aVar;
        }

        @Override // com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView.f
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f45701a.f45694a.d();
                return this.f45701a.w();
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements d.a.n0.a.q0.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45702a;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45702a = aVar;
        }

        @Override // d.a.n0.a.q0.b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45702a.f45697d, d.a.n0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.n0.a.q0.b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45702a.f45697d.getApplicationContext(), d.a.n0.a.h.aiapps_cancel_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.n0.a.q0.b.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45702a.f45697d.getApplicationContext(), d.a.n0.a.h.aiapps_cancel_fav_success);
                f2.l(2);
                f2.F();
                this.f45702a.C();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements d.a.n0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45703a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f45704b;

        public f(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45704b = aVar;
            this.f45703a = str;
        }

        @Override // d.a.n0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45704b.f45697d, d.a.n0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.n0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45704b.f45697d.getApplicationContext(), d.a.n0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
            }
        }

        @Override // d.a.n0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.n0.a.j0.b.a.t();
                if (!a.k(this.f45704b.f45696c.h())) {
                    d.a.n0.a.z1.b.f.e g2 = d.a.n0.a.z1.b.f.e.g(this.f45704b.f45697d, d.a.n0.a.c1.a.e0().f(this.f45704b.f45697d));
                    g2.l(2);
                    g2.p(2);
                    g2.F();
                    this.f45704b.C();
                    return;
                }
                a.p("addmyswan", this.f45703a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class g implements d.a.n0.a.q0.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f45705a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f45706b;

        public g(Activity activity, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45705a = activity;
            this.f45706b = hVar;
        }

        @Override // d.a.n0.a.q0.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45705a.getApplicationContext(), d.a.n0.a.h.swanapp_tip_net_unavailable);
                f2.l(2);
                f2.F();
                h hVar = this.f45706b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // d.a.n0.a.q0.b.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(this.f45705a.getApplicationContext(), d.a.n0.a.h.aiapps_fav_fail);
                f2.l(2);
                f2.F();
                h hVar = this.f45706b;
                if (hVar != null) {
                    hVar.onFail();
                }
            }
        }

        @Override // d.a.n0.a.q0.b.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                d.a.n0.a.j0.b.a.t();
                if (a.k(this.f45705a)) {
                    h hVar = this.f45706b;
                    if (hVar != null) {
                        hVar.onSuccess();
                        return;
                    }
                    return;
                }
                Context applicationContext = this.f45705a.getApplicationContext();
                d.a.n0.a.z1.b.f.e g2 = d.a.n0.a.z1.b.f.e.g(applicationContext, d.a.n0.a.c1.a.e0().f(applicationContext));
                g2.l(2);
                g2.p(2);
                g2.F();
                h hVar2 = this.f45706b;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(708352204, "Ld/a/n0/a/j1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(708352204, "Ld/a/n0/a/j1/a;");
                return;
            }
        }
        f45693e = k.f45831a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(n nVar, d.a.n0.a.h0.g.d dVar) {
        this(nVar, dVar, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((n) objArr2[0], (d.a.n0.a.h0.g.d) objArr2[1], (SwanAppMenuHeaderView) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void h(@NonNull Activity activity, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, activity, hVar) == null) {
            String D = d.a.n0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D) && hVar != null) {
                hVar.onFail();
            }
            if (!d.a.n0.a.j0.b.a.n(D)) {
                SwanFavorDataManager.h().b(D, new g(activity, hVar));
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
        if (f45693e) {
            Log.d("SwanAppMenuHelper", "change night mode");
        }
        boolean a2 = d.a.n0.a.c1.a.H().a();
        d.a.n0.a.c1.a.H().e(!a2);
        if (activity instanceof SwanAppActivity) {
            ((SwanAppActivity) activity).onNightModeCoverChanged(d.a.n0.a.c1.a.H().a(), true);
        } else if (activity instanceof SwanAppErrorActivity) {
            ((SwanAppErrorActivity) activity).updateCurrentNightMode();
        }
        if (a2) {
            d.a.n0.a.z1.b.f.e f2 = d.a.n0.a.z1.b.f.e.f(activity.getApplicationContext(), d.a.n0.a.h.aiapps_browser_menu_toast_day_mode);
            f2.m(d.a.n0.a.e.aiapps_day_mode_toast_icon);
            f2.l(2);
            f2.A();
        } else {
            d.a.n0.a.z1.b.f.e f3 = d.a.n0.a.z1.b.f.e.f(activity.getApplicationContext(), d.a.n0.a.h.aiapps_browser_menu_toast_night_mode);
            f3.m(d.a.n0.a.e.aiapps_night_mode_toast_icon);
            f3.l(2);
            f3.A();
        }
        o("daynightmode");
    }

    public static boolean k(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, activity)) == null) ? d.a.n0.a.c1.a.e0().a(activity) : invokeL.booleanValue;
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
        d.a.n0.a.j2.p.f fVar = new d.a.n0.a.j2.p.f();
        fVar.f45821e = str;
        if (!TextUtils.isEmpty(str2)) {
            fVar.a("page", str2);
            fVar.f45823g = str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            fVar.f45818b = str3;
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            fVar.a(str4, str5);
        }
        SwanAppActivity activity = d.a.n0.a.g1.f.V().getActivity();
        if (activity != null) {
            activity.doUBCEventStatistic(fVar);
        }
    }

    public static void t(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65553, null, activity) == null) && (activity instanceof SwanAppErrorActivity)) {
            SwanLauncher.j().m(((SwanAppErrorActivity) activity).getLaunchInfo().C());
            if (activity != null) {
                d.a.n0.a.v2.f.j(activity);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (f45693e) {
                Log.d("SwanAppMenuHelper", "startAboutFragment");
            }
            d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
            if (W == null) {
                d.a.n0.a.z1.b.f.e.f(this.f45697d, d.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = W.i("navigateTo");
            i2.n(d.a.n0.a.h0.g.g.f44708g, d.a.n0.a.h0.g.g.f44710i);
            i2.k("about", null).a();
            o("about");
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (f45693e) {
                Log.d("SwanAppMenuHelper", "startSettingFragment");
            }
            d.a.n0.a.h0.g.g J1 = this.f45696c.J1();
            if (J1 == null) {
                d.a.n0.a.z1.b.f.e.f(this.f45697d, d.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = J1.i("navigateTo");
            i2.n(d.a.n0.a.h0.g.g.f44708g, d.a.n0.a.h0.g.g.f44710i);
            i2.k("authority", null).a();
            o("permission");
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f45695b.setAttentionBtnStates(d.a.n0.a.j0.b.a.n(d.a.n0.a.a2.d.g().getAppId()));
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            r0.b(this.f45697d).c(d.a.n0.a.l1.b.e(q0.n()));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        b.a launchInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (d.a.n0.a.u1.a.a.G()) {
                if (f45693e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add shortcut");
                }
                d.a.n0.a.z1.b.f.e.f(this.f45697d.getApplicationContext(), d.a.n0.a.h.aiapps_debug_forbid_shortcut).F();
                return;
            }
            if (f45693e) {
                Log.d("SwanAppMenuHelper", "add shortcut");
            }
            if (d.a.n0.a.a2.e.Q() != null) {
                launchInfo = d.a.n0.a.a2.e.Q().L();
            } else {
                launchInfo = ((SwanAppActivity) this.f45696c.h()).getLaunchInfo();
            }
            d.a.n0.a.f2.a.i(this.f45696c.q(), launchInfo);
            o("addshortcut");
        }
    }

    public final void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            if (d.a.n0.a.u1.a.a.G()) {
                if (f45693e) {
                    Log.d("SwanAppMenuHelper", "in debug mode cannot add favor");
                }
                d.a.n0.a.z1.b.f.e.f(this.f45697d.getApplicationContext(), d.a.n0.a.h.aiapps_debug_forbid_favor).F();
                return;
            }
            String h2 = q0.n().h();
            SwanFavorDataManager.h().b(str, new f(this, h2));
            p("addmyswan", h2);
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SwanFavorDataManager h2 = SwanFavorDataManager.h();
            e eVar = new e(this);
            d.a.n0.a.n0.l.c l = d.a.n0.a.n0.l.c.l();
            l.n(3);
            h2.c(str, eVar, l.k());
            o("deletemyswan");
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f45696c.C2();
            o("share");
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.n0.a.h0.g.g J1 = this.f45696c.J1();
            if (J1 == null) {
                d.a.n0.a.z1.b.f.e.f(this.f45697d, d.a.n0.a.h.aiapps_open_fragment_failed_toast).F();
                return;
            }
            g.b i2 = J1.i("navigateTo");
            i2.n(d.a.n0.a.h0.g.g.f44708g, d.a.n0.a.h0.g.g.f44710i);
            i2.k("settings", null).a();
            o("set");
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String D = d.a.n0.a.a2.d.g().r().D();
            if (TextUtils.isEmpty(D)) {
                return;
            }
            if (d.a.n0.a.j0.b.a.n(D)) {
                m(D);
            } else {
                l(D);
            }
        }
    }

    public boolean v(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, oVar)) == null) {
            if (this.f45696c == null || this.f45697d == null) {
                return false;
            }
            int c2 = oVar.c();
            if (c2 == 4) {
                n();
                return true;
            } else if (c2 == 5) {
                j(this.f45696c.h());
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
                        return d.a.n0.a.c1.a.G().h(oVar);
                }
            } else {
                q0.d();
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
            if (this.f45696c == null || this.f45697d == null) {
                return false;
            }
            if (D()) {
                string = this.f45697d.getString(d.a.n0.a.h.swanapp_write_to_clipborad_succ);
            } else {
                string = this.f45697d.getString(d.a.n0.a.h.swanapp_write_to_clipborad_fail);
            }
            d.a.n0.a.z1.b.f.e g2 = d.a.n0.a.z1.b.f.e.g(this.f45697d, string);
            g2.l(2);
            g2.F();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            o("refresh");
            e0.a(d.a.n0.a.g1.f.V().getActivity());
            d.a.n0.a.e0.d.h("SwanAppMenuHelper", "restart");
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (f45693e) {
                Log.d("SwanAppMenuHelper", "restart");
            }
            Context context = this.f45697d;
            if (context == null) {
                return;
            }
            e0.a((SwanAppActivity) context);
        }
    }

    public void z() {
        d.a.n0.a.a2.e r;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f45694a == null || this.f45696c == null || this.f45697d == null || (r = d.a.n0.a.a2.d.g().r()) == null) {
            return;
        }
        r.x();
        this.f45694a.l(new C0790a(this));
        SwanAppMenuHeaderView swanAppMenuHeaderView = this.f45695b;
        if (swanAppMenuHeaderView != null) {
            swanAppMenuHeaderView.setOnMenuHeaderClickListener(new b(this));
            this.f45695b.setAttentionBtnShow(true);
            this.f45695b.setOnAttentionBtnClickListener(new c(this));
            if (r.m0()) {
                return;
            }
            this.f45695b.setOnMenuHeaderLongClickListener(new d(this));
        }
    }

    public a(n nVar, d.a.n0.a.h0.g.d dVar, SwanAppMenuHeaderView swanAppMenuHeaderView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nVar, dVar, swanAppMenuHeaderView};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f45694a = nVar;
        this.f45695b = swanAppMenuHeaderView;
        this.f45696c = dVar;
        if (dVar != null) {
            this.f45697d = dVar.q();
        }
    }
}
