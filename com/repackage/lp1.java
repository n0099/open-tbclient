package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hk2;
import com.repackage.m53;
import com.repackage.mp1;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lp1 extends ko1 implements mp1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ lp1 b;

        public a(lp1 lp1Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lp1Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                this.b.z(k53Var, this.a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lp1 b;

        /* loaded from: classes6.dex */
        public class a implements hk2.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.hk2.a
            public void a(g33 g33Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, g33Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", g33Var.a().toString());
                    ul2.U().u(new ia2("locationChange", hashMap));
                }
            }

            @Override // com.repackage.hk2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    n73.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(lp1 lp1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lp1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lp1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (!f53.h(k53Var)) {
                    int b = k53Var.b();
                    n73.b("startLocationUpdate", 5000, f53.f(b), b, f53.f(b));
                    this.b.d(this.a, new hs1(b, f53.f(b)));
                } else if (!be3.M()) {
                    n73.b("startLocationUpdate", 5004, "user no permission", 10005, f53.f(10005));
                    this.b.d(this.a, new hs1(10005, f53.f(10005)));
                } else {
                    this.b.d(this.a, new hs1(0));
                    oj2.I().f(new a(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public boolean b;
        public String c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static c b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                c cVar = new c();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("type");
                    cVar.a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.a = CoordinateType.WGS84;
                    }
                    cVar.b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e) {
                    hx1.d("GetLocationApi", "# parseFromJSON error", e);
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.equals(this.a, CoordinateType.WGS84) || TextUtils.equals(this.a, "gcj02") || TextUtils.equals(this.a, "bd09ll")) && !TextUtils.isEmpty(this.c) : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lp1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startLocationUpdate", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                n73.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new hs1(1001, "SwanApp is null");
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    n73.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                    hx1.c("GetLocationApi", "empty cb");
                    return new hs1(201, "empty cb");
                }
                b0.e0().g(getContext(), "mapp_location", new b(this, optString));
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            oj2.I().e();
            return hs1.f();
        }
        return (hs1) invokeV.objValue;
    }

    @Override // com.repackage.mp1.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            hx1.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new hs1(1001, String.valueOf(i)));
        }
    }

    @Override // com.repackage.mp1.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.c, new hs1(10005, "system deny"));
        }
    }

    @Override // com.repackage.mp1.c
    public void g(c cVar, g33 g33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, g33Var) == null) {
            d(cVar.c, new hs1(0, "success", g33Var.a()));
        }
    }

    @Override // com.repackage.ko1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    public hs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                n73.b("getLocation", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new hs1(1001, "SwanApp is null");
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                c b2 = c.b(((JSONObject) s.second).toString());
                if (b2 != null && b2.a()) {
                    if (TextUtils.isEmpty(b2.c)) {
                        n73.b("getLocation", 1001, "empty cb", 201, "empty cb");
                        hx1.c("GetLocationApi", "empty cb");
                        return new hs1(201, "empty cb");
                    }
                    b0.e0().g(getContext(), "mapp_location", new a(this, b2));
                    return hs1.f();
                }
                n73.b("getLocation", 1001, "params is invalid", 201, "params is invalid");
                p("params is invalid", null, true);
                return new hs1(201, "params is invalid");
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public final void z(k53<m53.e> k53Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, k53Var, cVar, z) == null) {
            hx1.i("GetLocationApi", "authorized result is " + k53Var);
            if (f53.h(k53Var)) {
                mp1.d().e(cVar, this, z);
                return;
            }
            int b2 = k53Var.b();
            n73.b("getLocation", 5000, f53.f(b2), b2, f53.f(b2));
            d(cVar.c, new hs1(b2, f53.f(b2)));
        }
    }
}
