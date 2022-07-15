package com.repackage;

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
import com.repackage.h54;
import com.repackage.hk2;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a54 extends s44<tm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements h54.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ q54 b;
        public final /* synthetic */ o44 c;
        public final /* synthetic */ a54 d;

        public a(a54 a54Var, Context context, q54 q54Var, o44 o44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a54Var, context, q54Var, o44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a54Var;
            this.a = context;
            this.b = q54Var;
            this.c = o44Var;
        }

        @Override // com.repackage.h54.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hx1.o("map", "location permission fail");
            }
        }

        @Override // com.repackage.h54.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hx1.o("map", "location permission success");
                this.d.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hk2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q54 a;
        public final /* synthetic */ o44 b;

        public b(a54 a54Var, q54 q54Var, o44 o44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a54Var, q54Var, o44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q54Var;
            this.b = o44Var;
        }

        @Override // com.repackage.hk2.a
        public void a(g33 g33Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g33Var) == null) {
                hx1.i("map", "get location " + g33Var.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(g33Var.c, g33Var.b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) g33Var.e).latitude(g33Var.c).longitude(g33Var.b).build());
                this.b.p(true);
            }
        }

        @Override // com.repackage.hk2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                hx1.i("map", "get location error " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755905807, "Lcom/repackage/a54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755905807, "Lcom/repackage/a54;");
                return;
            }
        }
        boolean z = rg1.a;
    }

    public a54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static a54 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a54() : (a54) invokeV.objValue;
    }

    @Override // com.repackage.s44
    public boolean b(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tm2Var, qm2Var, h03Var, jSONObject)) == null) ? g(context, tm2Var, qm2Var, h03Var) : invokeLLLLL.booleanValue;
    }

    public final void e(Context context, q54 q54Var, o44 o44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, q54Var, o44Var) == null) {
            oj2.I().b("gcj02", true, false, new b(this, q54Var, o44Var));
        }
    }

    public final boolean g(Context context, tm2 tm2Var, qm2 qm2Var, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tm2Var, qm2Var, h03Var)) == null) {
            hx1.i("map", "MoveToLocationAction start");
            pm1 A = ul2.U().A(tm2Var.c);
            if (!(A instanceof nm1)) {
                hx1.c("map", "WebViewManager is null");
                return false;
            }
            o44 c = p44.b().c((nm1) A);
            q54 d = c.d(tm2Var.b);
            if (d == null) {
                hx1.c("map", "can not find map by id " + tm2Var.b);
                return false;
            } else if (!d.k) {
                hx1.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e = c.e();
                if (e != null && c.g()) {
                    d.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e.getLatitude(), e.getLongitude())));
                    d.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d.l.getMap().setMyLocationEnabled(true);
                    d.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e.getRadius()).latitude(e.getLatitude()).longitude(e.getLongitude()).build());
                    hx1.i("map", "MoveToLocationAction end");
                    return true;
                }
                h54.b(context, new a(this, context, d, c));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
