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
import com.repackage.hj2;
import com.repackage.m43;
import com.repackage.mo1;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lo1 extends kn1 implements mo1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ lo1 b;

        public a(lo1 lo1Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo1Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lo1Var;
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                this.b.z(k43Var, this.a, false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lo1 b;

        /* loaded from: classes6.dex */
        public class a implements hj2.a {
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

            @Override // com.repackage.hj2.a
            public void a(g23 g23Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, g23Var) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", g23Var.a().toString());
                    uk2.U().u(new i92("locationChange", hashMap));
                }
            }

            @Override // com.repackage.hj2.a
            public void onFailed(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    n63.b("startLocationUpdate", 4000, "sdk's errCode is " + i, -1, "");
                }
            }
        }

        public b(lo1 lo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lo1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (!f43.h(k43Var)) {
                    int b = k43Var.b();
                    n63.b("startLocationUpdate", 5000, f43.f(b), b, f43.f(b));
                    this.b.d(this.a, new hr1(b, f43.f(b)));
                } else if (!bd3.M()) {
                    n63.b("startLocationUpdate", 5004, "user no permission", 10005, f43.f(10005));
                    this.b.d(this.a, new hr1(10005, f43.f(10005)));
                } else {
                    this.b.d(this.a, new hr1(0));
                    oi2.I().f(new a(this));
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
                    hw1.d("GetLocationApi", "# parseFromJSON error", e);
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
    public lo1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public hr1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#startLocationUpdate", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                n63.b("startLocationUpdate", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new hr1(1001, "SwanApp is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    n63.b("startLocationUpdate", 1001, "empty cb", 201, "empty cb");
                    hw1.c("GetLocationApi", "empty cb");
                    return new hr1(201, "empty cb");
                }
                a0.d0().g(getContext(), "mapp_location", new b(this, optString));
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            oi2.I().e();
            return hr1.f();
        }
        return (hr1) invokeV.objValue;
    }

    @Override // com.repackage.mo1.c
    public void b(c cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, cVar, i) == null) {
            hw1.c("GetLocationApi", "request location error code : " + i);
            d(cVar.c, new hr1(1001, String.valueOf(i)));
        }
    }

    @Override // com.repackage.mo1.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, str) == null) {
            d(cVar.c, new hr1(10005, "system deny"));
        }
    }

    @Override // com.repackage.mo1.c
    public void g(c cVar, g23 g23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cVar, g23Var) == null) {
            d(cVar.c, new hr1(0, "success", g23Var.a()));
        }
    }

    @Override // com.repackage.kn1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "LocationService" : (String) invokeV.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "GetLocationApi" : (String) invokeV.objValue;
    }

    public hr1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getLocation", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                n63.b("getLocation", 2001, "SwanApp is null", 1001, "SwanApp is null");
                return new hr1(1001, "SwanApp is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                c b2 = c.b(((JSONObject) s.second).toString());
                if (b2 != null && b2.a()) {
                    if (TextUtils.isEmpty(b2.c)) {
                        n63.b("getLocation", 1001, "empty cb", 201, "empty cb");
                        hw1.c("GetLocationApi", "empty cb");
                        return new hr1(201, "empty cb");
                    }
                    a0.d0().g(getContext(), "mapp_location", new a(this, b2));
                    return hr1.f();
                }
                n63.b("getLocation", 1001, "params is invalid", 201, "params is invalid");
                p("params is invalid", null, true);
                return new hr1(201, "params is invalid");
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    public final void z(k43<m43.e> k43Var, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, k43Var, cVar, z) == null) {
            hw1.i("GetLocationApi", "authorized result is " + k43Var);
            if (f43.h(k43Var)) {
                mo1.d().e(cVar, this, z);
                return;
            }
            int b2 = k43Var.b();
            n63.b("getLocation", 5000, f43.f(b2), b2, f43.f(b2));
            d(cVar.c, new hr1(b2, f43.f(b2)));
        }
    }
}
