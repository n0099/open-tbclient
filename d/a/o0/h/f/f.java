package d.a.o0.h.f;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.e.c;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f50480a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f50481b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50482c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f f50483d;

        public a(f fVar, boolean z, Context context, d.a.o0.a.y.b.a aVar) {
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
            this.f50483d = fVar;
            this.f50480a = z;
            this.f50481b = context;
            this.f50482c = aVar;
        }

        @Override // d.a.o0.a.h0.e.c.b
        public void a(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                if (z) {
                    if (this.f50480a) {
                        this.f50483d.g(this.f50481b, this.f50482c);
                        return;
                    }
                    d.a.o0.a.e0.a.c(this.f50481b, false);
                    this.f50483d.e(this.f50482c, true, "setEnableDebug:ok");
                    return;
                }
                d.a.o0.a.h0.e.c.c(this.f50481b, str);
                f fVar = this.f50483d;
                fVar.e(this.f50482c, false, fVar.f(str));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f50484e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.y.b.a f50485f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f50486g;

        public b(f fVar, Context context, d.a.o0.a.y.b.a aVar) {
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
            this.f50486g = fVar;
            this.f50484e = context;
            this.f50485f = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (bool.booleanValue()) {
                    d.a.o0.a.e0.a.c(this.f50484e, true);
                    this.f50486g.e(this.f50485f, true, "setEnableDebug:ok");
                    return;
                }
                d.m().p((Activity) this.f50484e, null);
                this.f50486g.e(this.f50485f, false, "internet error");
            }
        }
    }

    public f(d.a.o0.a.l0.c cVar) {
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
        d.a.o0.a.a2.e i2;
        SwanAppActivity x;
        d.a.o0.a.l0.a X0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject) == null) || (i2 = d.a.o0.a.a2.e.i()) == null || !i2.m0() || (x = i2.x()) == null) {
            return;
        }
        d.a.o0.a.t0.c frame = x.getFrame();
        if ((frame instanceof d.a.o0.h.o.d) && (X0 = ((d.a.o0.h.o.d) frame).X0()) != null) {
            X0.F(d.a.o0.h.f.a.a(jSONObject));
        }
    }

    public final void d(@NonNull d.a.o0.a.a2.e eVar, @NonNull Context context, @NonNull d.a.o0.a.y.b.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{eVar, context, aVar, Boolean.valueOf(z)}) == null) {
            d.a.o0.a.h0.e.c.a(eVar, context, new a(this, z, context, aVar));
        }
    }

    public final void e(d.a.o0.a.y.b.a aVar, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{aVar, Boolean.valueOf(z), str}) == null) {
            d.a.o0.h.d.c.b bVar = new d.a.o0.h.d.c.b();
            bVar.errMsg = str;
            d.a.o0.h.m0.c.a(aVar, z, bVar);
        }
    }

    public final String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? String.format("setEnableDebug:fail %s", str) : (String) invokeL.objValue;
    }

    public final void g(Context context, d.a.o0.a.y.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, aVar) == null) {
            d.m().o(new b(this, context, aVar));
        }
    }

    public void i(JsObject jsObject) {
        d.a.o0.a.y.b.a G;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (G = d.a.o0.a.y.b.a.G(jsObject)) == null) {
            return;
        }
        boolean m = G.m("enableDebug");
        d.a.o0.a.a2.e i2 = d.a.o0.a.a2.e.i();
        if (i2 == null) {
            e(G, false, f("internal error"));
            return;
        }
        SwanAppActivity x = i2.x();
        if (x == null) {
            e(G, false, f("internal error"));
        } else if (m == d.a.o0.a.e0.a.a()) {
            e(G, true, "setEnableDebug:ok");
        } else {
            d(i2, x, G, m);
        }
    }
}
