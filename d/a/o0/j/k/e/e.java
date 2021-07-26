package d.a.o0.j.k.e;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.c1.d.d;
import d.a.o0.a.k;
import d.a.o0.j.k.f.d;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends d.a.o0.j.k.a<d.a.o0.a.h1.c.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f50969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j.n.c f50970b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j.b f50971c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f50972d;

        public a(e eVar, Context context, d.a.o0.j.n.c cVar, d.a.o0.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context, cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50972d = eVar;
            this.f50969a = context;
            this.f50970b = cVar;
            this.f50971c = bVar;
        }

        @Override // d.a.o0.j.k.f.d.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.e0.d.l("map", "location permission fail");
            }
        }

        @Override // d.a.o0.j.k.f.d.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                d.a.o0.a.e0.d.l("map", "location permission success");
                this.f50972d.e(this.f50969a, this.f50970b, this.f50971c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j.n.c f50973a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j.b f50974b;

        public b(e eVar, d.a.o0.j.n.c cVar, d.a.o0.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, cVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50973a = cVar;
            this.f50974b = bVar;
        }

        @Override // d.a.o0.a.c1.d.d.a
        public void a(d.a.o0.a.c2.f.k0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                d.a.o0.a.e0.d.g("map", "get location " + bVar.a().toString());
                BaiduMap map = this.f50973a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bVar.f44265c, bVar.f44264b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) bVar.f44267e).latitude(bVar.f44265c).longitude(bVar.f44264b).build());
                this.f50974b.q(true);
            }
        }

        @Override // d.a.o0.a.c1.d.d.a
        public void onFailed(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                d.a.o0.a.e0.d.g("map", "get location error " + i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1515865746, "Ld/a/o0/j/k/e/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1515865746, "Ld/a/o0/j/k/e/e;");
                return;
            }
        }
        boolean z = k.f46335a;
    }

    public e() {
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

    public static e f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new e() : (e) invokeV.objValue;
    }

    @Override // d.a.o0.j.k.a
    public boolean b(Context context, d.a.o0.a.h1.c.c cVar, d.a.o0.a.h1.b bVar, d.a.o0.a.a2.e eVar, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, cVar, bVar, eVar, jSONObject)) == null) ? g(context, cVar, bVar, eVar) : invokeLLLLL.booleanValue;
    }

    public final void e(Context context, d.a.o0.j.n.c cVar, d.a.o0.j.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, cVar, bVar) == null) {
            d.a.o0.a.c1.a.E().b("gcj02", true, false, new b(this, cVar, bVar));
        }
    }

    public final boolean g(Context context, d.a.o0.a.h1.c.c cVar, d.a.o0.a.h1.b bVar, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar, bVar, eVar)) == null) {
            d.a.o0.a.e0.d.g("map", "MoveToLocationAction start");
            d.a.o0.a.p.e.d B = d.a.o0.a.g1.f.V().B(cVar.f43982g);
            if (!(B instanceof d.a.o0.a.p.e.b)) {
                d.a.o0.a.e0.d.b("map", "WebViewManager is null");
                return false;
            }
            d.a.o0.j.b c2 = d.a.o0.j.c.b().c((d.a.o0.a.p.e.b) B);
            d.a.o0.j.n.c d2 = c2.d(cVar.f43981f);
            if (d2 == null) {
                d.a.o0.a.e0.d.b("map", "can not find map by id " + cVar.f43981f);
                return false;
            } else if (!d2.k) {
                d.a.o0.a.e0.d.l("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e2 = c2.e();
                if (e2 != null && c2.h()) {
                    d2.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e2.getLatitude(), e2.getLongitude())));
                    d2.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d2.l.getMap().setMyLocationEnabled(true);
                    d2.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e2.getRadius()).latitude(e2.getLatitude()).longitude(e2.getLongitude()).build());
                    d.a.o0.a.e0.d.g("map", "MoveToLocationAction end");
                    return true;
                }
                d.a.o0.j.k.f.d.b(context, new a(this, context, d2, c2));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
