package d.a.q0.h.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.e.c;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f53278a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f53279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53280c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f53281d;

        public a(f fVar, boolean z, Context context, d.a.q0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Boolean.valueOf(z), context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53281d = fVar;
            this.f53278a = z;
            this.f53279b = context;
            this.f53280c = aVar;
        }

        @Override // d.a.q0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f53278a) {
                        this.f53281d.g(this.f53279b, this.f53280c);
                        return;
                    }
                    d.a.q0.a.e0.a.c(this.f53279b, false);
                    this.f53281d.e(this.f53280c, true, "setEnableDebug:ok");
                    return;
                }
                d.a.q0.a.h0.e.c.c(this.f53279b, str);
                f fVar = this.f53281d;
                fVar.e(this.f53280c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f53282e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.y.b.a f53283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f53284g;

        public b(f fVar, Context context, d.a.q0.a.y.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f53284g = fVar;
            this.f53282e = context;
            this.f53283f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    d.a.q0.a.e0.a.c(this.f53282e, true);
                    this.f53284g.e(this.f53283f, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.f53282e, null);
                this.f53284g.e(this.f53283f, false, "internet error");
            }
        }
    }

    public f(d.a.q0.a.l0.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void h(JSONObject jSONObject) {
        d.a.q0.a.a2.e i2;
        SwanAppActivity x;
        d.a.q0.a.l0.a X0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, jSONObject) == null) || (i2 = d.a.q0.a.a2.e.i()) == null || !i2.m0() || (x = i2.x()) == null) {
            return;
        }
        d.a.q0.a.t0.c frame = x.getFrame();
        if ((frame instanceof d.a.q0.h.o.d) && (X0 = ((d.a.q0.h.o.d) frame).X0()) != null) {
            X0.F(d.a.q0.h.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull d.a.q0.a.a2.e eVar, @NonNull Context context, @NonNull d.a.q0.a.y.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            d.a.q0.a.h0.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(d.a.q0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            d.a.q0.h.d.c.b bVar = new d.a.q0.h.d.c.b();
            bVar.errMsg = str;
            d.a.q0.h.m0.c.a(aVar, z, bVar);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, d.a.q0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            d.m().o(new b(this, context, aVar));
        }
    }

    public void i(JsObject jsObject) {
        d.a.q0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (G = d.a.q0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        boolean m = G.m("enableDebug");
        d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
        if (i2 == null) {
            e(G, false, f("internal error"));
            return;
        }
        SwanAppActivity x = i2.x();
        if (x == null) {
            e(G, false, f("internal error"));
        } else if (m == d.a.q0.a.e0.a.a()) {
            e(G, true, "setEnableDebug:ok");
        } else {
            d(i2, x, G, m);
        }
    }
}
