package d.a.o0.j.k.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.j.n.b;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends d.a.o0.j.k.a<d.a.o0.a.h1.c.f> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements b.InterfaceC1146b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h1.c.f f50975a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.h1.b f50976b;

        public a(g gVar, d.a.o0.a.h1.c.f fVar, d.a.o0.a.h1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, fVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50975a = fVar;
            this.f50976b = bVar;
        }

        @Override // d.a.o0.j.n.b.InterfaceC1146b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.f50975a.C)) {
                    this.f50976b.c(this.f50975a.C, null);
                }
                d.a.o0.a.e0.d.g("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1515865808, "Ld/a/o0/j/k/e/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1515865808, "Ld/a/o0/j/k/e/g;");
                return;
            }
        }
        boolean z = k.f46335a;
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new g() : (g) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, d.a.o0.a.h1.c.f fVar, d.a.o0.a.h1.b bVar, d.a.o0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, fVar, bVar, eVar, jSONObject)) == null) ? f(context, fVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, d.a.o0.a.h1.c.f fVar, d.a.o0.a.h1.b bVar, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, fVar, bVar, eVar)) == null) {
            d.a.o0.a.e0.d.g("map", "TranslateMarkerAction start");
            d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(fVar.f43982g);
            if (!(B instanceof d.a.o0.a.p.e.b)) {
                d.a.o0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            d.a.o0.j.n.c d2 = d.a.o0.j.c.b().c((d.a.o0.a.p.e.b) B).d(fVar.f43981f);
            if (d2 == null) {
                d.a.o0.a.e0.d.b("map", "can not find map by id " + fVar.f43981f);
                return false;
            }
            return g(fVar, d2, bVar);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(d.a.o0.a.h1.c.f fVar, d.a.o0.j.n.c cVar, d.a.o0.a.h1.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, fVar, cVar, bVar)) == null) {
            if (fVar.isValid()) {
                d.a.o0.a.h1.c.h.c cVar2 = fVar.E;
                LatLng latLng = new LatLng(cVar2.f45809e, cVar2.f45810f);
                List<d.a.o0.j.n.b> K = cVar.K(fVar.D);
                d.a.o0.a.e0.d.g("map", "TranslateMarkerAction animation start");
                if (K != null) {
                    for (d.a.o0.j.n.b bVar2 : K) {
                        bVar2.c(cVar, latLng, fVar, new a(this, fVar, bVar));
                    }
                }
                d.a.o0.a.e0.d.g("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
