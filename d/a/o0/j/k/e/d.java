package d.a.o0.j.k.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.o0.j.k.a<d.a.o0.a.h1.c.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1515865715, "Ld/a/o0/j/k/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1515865715, "Ld/a/o0/j/k/e/d;");
                return;
            }
        }
        boolean z = k.f46335a;
    }

    public d() {
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

    public static d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new d() : (d) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.j.k.a
    /* renamed from: d */
    public boolean b(Context context, d.a.o0.a.h1.c.b bVar, d.a.o0.a.h1.b bVar2, d.a.o0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar, bVar2, eVar, jSONObject)) == null) ? f(context, bVar, bVar2, eVar) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, d.a.o0.a.h1.c.b bVar, d.a.o0.a.h1.b bVar2, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, bVar, bVar2, eVar)) == null) {
            d.a.o0.a.e0.d.g("map", "IncludePointsAction start");
            d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(bVar.f43982g);
            if (!(B instanceof d.a.o0.a.p.e.b)) {
                d.a.o0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            d.a.o0.j.n.c d2 = d.a.o0.j.c.b().c((d.a.o0.a.p.e.b) B).d(bVar.f43981f);
            if (d2 == null) {
                d.a.o0.a.e0.d.b("map", "can not find map by id " + bVar.f43981f);
                return false;
            }
            d.a.o0.a.e0.d.g("map", "IncludePointsAction end");
            return g(bVar, d2);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(d.a.o0.a.h1.c.b bVar, d.a.o0.j.n.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bVar, cVar)) == null) {
            if (bVar == null || !bVar.isValid()) {
                return false;
            }
            BaiduMap map = cVar.l.getMap();
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            Iterator<d.a.o0.a.h1.c.h.c> it = bVar.D.iterator();
            while (it.hasNext()) {
                d.a.o0.a.h1.c.h.c next = it.next();
                builder.include(new LatLng(next.f45809e, next.f45810f));
            }
            LatLngBounds build = builder.build();
            int[] iArr = bVar.E;
            map.animateMapStatus(MapStatusUpdateFactory.newLatLngBounds(build, iArr[3], iArr[0], iArr[1], iArr[2]));
            return true;
        }
        return invokeLL.booleanValue;
    }
}
