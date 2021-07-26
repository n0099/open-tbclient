package d.a.o0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.e2.c.j.b;
import d.a.o0.a.k;
import d.a.o0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f48130g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f48131d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.a.h0.g.l.a f48132e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.a.h0.g.d f48133f;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<d.a.o0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48135f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48136g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f48137h;

        public a(i iVar, String str, d.a.o0.a.a2.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48137h = iVar;
            this.f48134e = str;
            this.f48135f = eVar;
            this.f48136g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.o0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.f48137h.C(this.f48135f, this.f48136g, this.f48134e);
                } else {
                    this.f48137h.d(this.f48134e, new d.a.o0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48138e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f48139f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48140g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48141h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f48142i;

        /* loaded from: classes7.dex */
        public class a extends d.a.o0.a.h0.g.l.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f48143a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48143a = bVar;
            }

            @Override // d.a.o0.a.h0.g.l.a, d.a.o0.a.h0.g.l.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.a();
                    d.a.o0.a.e0.d.g("Api-WebPopWindow", "swanId=" + this.f48143a.f48139f.f43885f + ", nowId=" + d.a.o0.a.a2.e.V());
                    if (TextUtils.equals(this.f48143a.f48139f.f43885f, d.a.o0.a.a2.e.V())) {
                        return;
                    }
                    this.f48143a.f48142i.B();
                }
            }

            @Override // d.a.o0.a.h0.g.l.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.a.o0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                    this.f48143a.f48142i.B();
                    if (this.f48143a.f48142i.f48133f == null || this.f48143a.f48142i.f48132e == null) {
                        return;
                    }
                    this.f48143a.f48142i.f48133f.F2(this.f48143a.f48142i.f48132e);
                }
            }
        }

        public b(i iVar, String str, d.a.o0.a.a2.e eVar, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, str, eVar, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48142i = iVar;
            this.f48138e = str;
            this.f48139f = eVar;
            this.f48140g = str2;
            this.f48141h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = d.a.o0.a.g1.f.V().getActivity()) == null) {
                return;
            }
            if (this.f48142i.f48131d != null && this.f48142i.f48131d.x()) {
                this.f48142i.d(this.f48138e, new d.a.o0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            d.a.o0.a.h0.g.g W = d.a.o0.a.g1.f.V().W();
            if (W == null) {
                return;
            }
            this.f48142i.f48133f = W.m();
            if (this.f48142i.f48133f == null) {
                return;
            }
            if (this.f48142i.f48132e != null) {
                this.f48142i.f48133f.F2(this.f48142i.f48132e);
            }
            this.f48142i.f48132e = new a(this);
            this.f48142i.f48133f.h2(this.f48142i.f48132e);
            i iVar = this.f48142i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f48140g);
            swanAppWebPopWindow.B0(d.a.o0.a.h.swan_app_baidu_guarantee_title);
            iVar.f48131d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f48141h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f48142i.f48131d;
                swanAppWebPopWindow2.w0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.x0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f48142i.f48131d;
            swanAppWebPopWindow3.u0();
            swanAppWebPopWindow3.D0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f48130g) {
                    e2.printStackTrace();
                }
            }
            this.f48142i.d(this.f48138e, new d.a.o0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1524991659, "Ld/a/o0/a/u/e/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1524991659, "Ld/a/o0/a/u/e/g/i;");
                return;
            }
        }
        f48130g = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(d.a.o0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.T().g(i(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new d.a.o0.a.u.h.b(202, "type is invalid"));
            }
        }
    }

    public final void B() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f48133f.V() && (swanAppWebPopWindow = this.f48131d) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void C(d.a.o0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            String D = D(eVar, str);
            if (D == null) {
                d(str2, new d.a.o0.a.u.h.b(202, "type is invalid"));
            } else {
                q0.b0(new b(this, str2, eVar, D, str));
            }
        }
    }

    public final String D(d.a.o0.a.a2.e eVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, str)) == null) {
            if (!TextUtils.equals(str, "protect") || eVar == null) {
                return null;
            }
            return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + eVar.D();
        }
        return (String) invokeLL.objValue;
    }

    public d.a.o0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (f48130g) {
                Log.d("Api-WebPopWindow", "start show web pop window action, params =" + str);
            }
            d.a.o0.a.a2.e Q = d.a.o0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.o0.a.u.h.b(202, "swanApp is null");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> a2 = d.a.o0.a.u.i.b.a(str);
            JSONObject jSONObject = (JSONObject) a2.second;
            if (((d.a.o0.a.u.h.b) a2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.o0.a.u.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.o0.a.u.h.b(202, "cb is invalid");
                }
                A(Q, optString, optString2);
                return new d.a.o0.a.u.h.b(0);
            }
            return new d.a.o0.a.u.h.b(202);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
