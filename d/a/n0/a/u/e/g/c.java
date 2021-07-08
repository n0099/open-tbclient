package d.a.n0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.n0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.d f47552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47553f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47554g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f47555h;

        public a(c cVar, d.a.n0.a.h0.g.d dVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47555h = cVar;
            this.f47552e = dVar;
            this.f47553f = str;
            this.f47554g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.h0.g.d dVar = this.f47552e;
                boolean z = true;
                if (!((dVar == null || !dVar.o2(this.f47553f, true)) ? false : false)) {
                    d.a.n0.a.e0.d.b("Api-NavigationBar", "set title fail");
                    this.f47555h.d(this.f47554g, new d.a.n0.a.u.h.b(1001));
                }
                this.f47555h.d(this.f47554g, new d.a.n0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.d f47556e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47557f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47558g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47559h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f47560i;
        public final /* synthetic */ c j;

        public b(c cVar, d.a.n0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f47556e = dVar;
            this.f47557f = str;
            this.f47558g = str2;
            this.f47559h = str3;
            this.f47560i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.h0.g.d dVar = this.f47556e;
                if (dVar != null && dVar.v2(this.f47557f, true)) {
                    if (!this.f47556e.m2(SwanAppConfigData.s(this.f47559h), true)) {
                        d.a.n0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                        this.j.d(this.f47558g, new d.a.n0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f47560i;
                    if (jSONObject != null) {
                        this.f47556e.k2(jSONObject.optInt("duration"), this.f47560i.optString("timingFunc"));
                        d.a.n0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                    }
                    this.j.d(this.f47558g, new d.a.n0.a.u.h.b(0));
                    return;
                }
                d.a.n0.a.e0.d.b("Api-NavigationBar", "set title color fail");
                this.j.d(this.f47558g, new d.a.n0.a.u.h.b(1001));
            }
        }
    }

    /* renamed from: d.a.n0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0912c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.g.d f47561e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47562f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f47563g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f47564h;

        public RunnableC0912c(c cVar, d.a.n0.a.h0.g.d dVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47564h = cVar;
            this.f47561e = dVar;
            this.f47562f = str;
            this.f47563g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean O1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.h0.g.d dVar = this.f47561e;
                if (dVar == null) {
                    d.a.n0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                    this.f47564h.d(this.f47562f, new d.a.n0.a.u.h.b(1001));
                    return;
                }
                if (this.f47563g) {
                    O1 = dVar.D2();
                } else {
                    O1 = dVar.O1();
                }
                if (!O1) {
                    String str = this.f47563g ? "show" : "hide";
                    d.a.n0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                    this.f47564h.d(this.f47562f, new d.a.n0.a.u.h.b(1001));
                    return;
                }
                this.f47564h.d(this.f47562f, new d.a.n0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull d.a.n0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.n0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final d.a.n0.a.u.h.b r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
            if (W == null) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new d.a.n0.a.u.h.b(1001);
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-NavigationBar", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new d.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new RunnableC0912c(this, W.m(), optString, z));
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeLZ.objValue;
    }

    public d.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigationBar", "start hide navigation bar loading");
            }
            return r(str, false);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public d.a.n0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigationBar", "set navigation bar color");
            }
            d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
            if (W == null) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new d.a.n0.a.u.h.b(1001);
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-NavigationBar", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new d.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new b(this, W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public d.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigationBar", "set navigation bar title");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-NavigationBar", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
                return new d.a.n0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("title");
            d.a.n0.a.h0.g.g W = d.a.n0.a.g1.f.V().W();
            if (W == null) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new d.a.n0.a.u.h.b(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                d.a.n0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new d.a.n0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, W.m(), optString, optString2));
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public d.a.n0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-NavigationBar", "start show navigation bar loading");
            }
            d.a.n0.a.a2.e Q = d.a.n0.a.a2.e.Q();
            if (Q != null && Q.d0()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
                }
                return new d.a.n0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return r(str, true);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }
}
