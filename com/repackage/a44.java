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
import com.repackage.h44;
import com.repackage.hj2;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a44 extends s34<tl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements h44.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ q44 b;
        public final /* synthetic */ o34 c;
        public final /* synthetic */ a44 d;

        public a(a44 a44Var, Context context, q44 q44Var, o34 o34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a44Var, context, q44Var, o34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a44Var;
            this.a = context;
            this.b = q44Var;
            this.c = o34Var;
        }

        @Override // com.repackage.h44.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hw1.o("map", "location permission fail");
            }
        }

        @Override // com.repackage.h44.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hw1.o("map", "location permission success");
                this.d.e(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements hj2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q44 a;
        public final /* synthetic */ o34 b;

        public b(a44 a44Var, q44 q44Var, o34 o34Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a44Var, q44Var, o34Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q44Var;
            this.b = o34Var;
        }

        @Override // com.repackage.hj2.a
        public void a(g23 g23Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, g23Var) == null) {
                hw1.i("map", "get location " + g23Var.a().toString());
                BaiduMap map = this.a.l.getMap();
                map.animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(g23Var.c, g23Var.b)));
                map.setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                map.setMyLocationEnabled(true);
                map.setMyLocationData(new MyLocationData.Builder().accuracy((float) g23Var.e).latitude(g23Var.c).longitude(g23Var.b).build());
                this.b.p(true);
            }
        }

        @Override // com.repackage.hj2.a
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                hw1.i("map", "get location error " + i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755906768, "Lcom/repackage/a44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755906768, "Lcom/repackage/a44;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public a44() {
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

    public static a44 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a44() : (a44) invokeV.objValue;
    }

    @Override // com.repackage.s34
    public boolean b(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048576, this, context, tl2Var, ql2Var, hz2Var, jSONObject)) == null) ? g(context, tl2Var, ql2Var, hz2Var) : invokeLLLLL.booleanValue;
    }

    public final void e(Context context, q44 q44Var, o34 o34Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, q44Var, o34Var) == null) {
            oi2.I().b("gcj02", true, false, new b(this, q44Var, o34Var));
        }
    }

    public final boolean g(Context context, tl2 tl2Var, ql2 ql2Var, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tl2Var, ql2Var, hz2Var)) == null) {
            hw1.i("map", "MoveToLocationAction start");
            pl1 A = uk2.U().A(tl2Var.c);
            if (!(A instanceof nl1)) {
                hw1.c("map", "WebViewManager is null");
                return false;
            }
            o34 c = p34.b().c((nl1) A);
            q44 d = c.d(tl2Var.b);
            if (d == null) {
                hw1.c("map", "can not find map by id " + tl2Var.b);
                return false;
            } else if (!d.k) {
                hw1.o("map", "can not move to location because showLocation is not set");
                return false;
            } else {
                BDLocation e = c.e();
                if (e != null && c.g()) {
                    d.l.getMap().animateMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(e.getLatitude(), e.getLongitude())));
                    d.l.getMap().setMyLocationConfiguration(new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, null));
                    d.l.getMap().setMyLocationEnabled(true);
                    d.l.getMap().setMyLocationData(new MyLocationData.Builder().accuracy(e.getRadius()).latitude(e.getLatitude()).longitude(e.getLongitude()).build());
                    hw1.i("map", "MoveToLocationAction end");
                    return true;
                }
                h44.b(context, new a(this, context, d, c));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
