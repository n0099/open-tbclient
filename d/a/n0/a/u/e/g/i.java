package d.a.n0.a.u.e.g;

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
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class i extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f47626g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public SwanAppWebPopWindow f47627d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.a.h0.g.l.a f47628e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.a.h0.g.d f47629f;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47631f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47632g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f47633h;

        public a(i iVar, String str, d.a.n0.a.a2.e eVar, String str2) {
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
            this.f47633h = iVar;
            this.f47630e = str;
            this.f47631f = eVar;
            this.f47632g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.n0.a.e2.c.d.h(iVar)) {
                    this.f47633h.C(this.f47631f, this.f47632g, this.f47630e);
                } else {
                    this.f47633h.d(this.f47630e, new d.a.n0.a.u.h.b(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f47635f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47636g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47637h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ i f47638i;

        /* loaded from: classes7.dex */
        public class a extends d.a.n0.a.h0.g.l.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f47639a;

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
                this.f47639a = bVar;
            }

            @Override // d.a.n0.a.h0.g.l.a, d.a.n0.a.h0.g.l.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.a();
                    d.a.n0.a.e0.d.g("Api-WebPopWindow", "swanId=" + this.f47639a.f47635f.f43381f + ", nowId=" + d.a.n0.a.a2.e.V());
                    if (TextUtils.equals(this.f47639a.f47635f.f43381f, d.a.n0.a.a2.e.V())) {
                        return;
                    }
                    this.f47639a.f47638i.B();
                }
            }

            @Override // d.a.n0.a.h0.g.l.b
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    d.a.n0.a.e0.d.g("Api-WebPopWindow", "call onFragmentDestroyed");
                    this.f47639a.f47638i.B();
                    if (this.f47639a.f47638i.f47629f == null || this.f47639a.f47638i.f47628e == null) {
                        return;
                    }
                    this.f47639a.f47638i.f47629f.F2(this.f47639a.f47638i.f47628e);
                }
            }
        }

        public b(i iVar, String str, d.a.n0.a.a2.e eVar, String str2, String str3) {
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
            this.f47638i = iVar;
            this.f47634e = str;
            this.f47635f = eVar;
            this.f47636g = str2;
            this.f47637h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = d.a.n0.a.g1.f.V().getActivity()) == null) {
                return;
            }
            if (this.f47638i.f47627d != null && this.f47638i.f47627d.x()) {
                this.f47638i.d(this.f47634e, new d.a.n0.a.u.h.b(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
            if (W == null) {
                return;
            }
            this.f47638i.f47629f = W.m();
            if (this.f47638i.f47629f == null) {
                return;
            }
            if (this.f47638i.f47628e != null) {
                this.f47638i.f47629f.F2(this.f47638i.f47628e);
            }
            this.f47638i.f47628e = new a(this);
            this.f47638i.f47629f.h2(this.f47638i.f47628e);
            i iVar = this.f47638i;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.f47636g);
            swanAppWebPopWindow.B0(d.a.n0.a.h.swan_app_baidu_guarantee_title);
            iVar.f47627d = swanAppWebPopWindow;
            if (TextUtils.equals(this.f47637h, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.f47638i.f47627d;
                swanAppWebPopWindow2.x0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.y0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.f47638i.f47627d;
            swanAppWebPopWindow3.w0();
            swanAppWebPopWindow3.D0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e2) {
                if (i.f47626g) {
                    e2.printStackTrace();
                }
            }
            this.f47638i.d(this.f47634e, new d.a.n0.a.u.h.b(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1231588652, "Ld/a/n0/a/u/e/g/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1231588652, "Ld/a/n0/a/u/e/g/i;");
                return;
            }
        }
        f47626g = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NonNull d.a.n0.a.u.c.b bVar) {
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
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void A(d.a.n0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, eVar, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                eVar.T().g(i(), "scope_web_window_pay_protected", new a(this, str2, eVar, str));
            } else {
                d(str2, new d.a.n0.a.u.h.b(202, "type is invalid"));
            }
        }
    }

    public final void B() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f47629f.W() && (swanAppWebPopWindow = this.f47627d) != null) {
            swanAppWebPopWindow.r();
        }
    }

    public final void C(d.a.n0.a.a2.e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, eVar, str, str2) == null) {
            String D = D(eVar, str);
            if (D == null) {
                d(str2, new d.a.n0.a.u.h.b(202, "type is invalid"));
            } else {
                q0.b0(new b(this, str2, eVar, D, str));
            }
        }
    }

    public final String D(d.a.n0.a.a2.e eVar, String str) {
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

    public d.a.n0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (f47626g) {
                Log.d("Api-WebPopWindow", "start show web pop window action, params =" + str);
            }
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.n0.a.u.h.b(202, "swanApp is null");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> a2 = d.a.n0.a.u.i.b.a(str);
            JSONObject jSONObject = (JSONObject) a2.second;
            if (((d.a.n0.a.u.h.b) a2.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new d.a.n0.a.u.h.b(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new d.a.n0.a.u.h.b(202, "cb is invalid");
                }
                A(Q, optString, optString2);
                return new d.a.n0.a.u.h.b(0);
            }
            return new d.a.n0.a.u.h.b(202);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
