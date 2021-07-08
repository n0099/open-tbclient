package d.a.n0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.c1.d.d;
import d.a.n0.a.e2.c.i;
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.g1.f;
import d.a.n0.a.u.c.d;
import d.a.n0.a.u.e.i.b;
import d.a.n0.a.v2.q0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d implements b.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.u.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0919a implements d.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f47644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47645f;

        public C0919a(a aVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47645f = aVar;
            this.f47644e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f47645f.t(iVar, this.f47644e, false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f47647f;

        /* renamed from: d.a.n0.a.u.e.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0920a implements d.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0920a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.n0.a.c1.d.d.a
            public void a(d.a.n0.a.c2.f.k0.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", bVar.a().toString());
                    f.V().v(new d.a.n0.a.o0.d.b("locationChange", hashMap));
                }
            }

            @Override // d.a.n0.a.c1.d.d.a
            public void onFailed(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                }
            }
        }

        public b(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47647f = aVar;
            this.f47646e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    int b2 = iVar.b();
                    this.f47647f.d(this.f47646e, new d.a.n0.a.u.h.b(b2, d.a.n0.a.e2.c.d.f(b2)));
                } else if (!q0.L()) {
                    this.f47647f.d(this.f47646e, new d.a.n0.a.u.h.b(10005, d.a.n0.a.e2.c.d.f(10005)));
                } else {
                    this.f47647f.d(this.f47646e, new d.a.n0.a.u.h.b(0));
                    d.a.n0.a.c1.a.E().e(new C0920a(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f47648a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f47649b;

        /* renamed from: c  reason: collision with root package name */
        public String f47650c;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                    cVar.f47648a = optString;
                    if (TextUtils.isEmpty(optString)) {
                        cVar.f47648a = CoordinateType.WGS84;
                    }
                    cVar.f47649b = jSONObject.optBoolean("altitude");
                    String optString2 = jSONObject.optString("cb");
                    cVar.f47650c = optString2;
                    if (TextUtils.isEmpty(optString2)) {
                        return null;
                    }
                    return cVar;
                } catch (JSONException e2) {
                    if (d.a.n0.a.u.c.d.f47438c) {
                        Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                    }
                    d.a.n0.a.e0.d.b("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                    return null;
                }
            }
            return (c) invokeL.objValue;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.equals(this.f47648a, CoordinateType.WGS84) || TextUtils.equals(this.f47648a, "gcj02") || TextUtils.equals(this.f47648a, "bd09ll")) && !TextUtils.isEmpty(this.f47650c) : invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.n0.a.u.c.b bVar) {
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

    @Override // d.a.n0.a.u.e.i.b.c
    public void b(c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            d.a.n0.a.e0.d.b("Api-GetLocationAction", "request location error code : " + i2);
            d(cVar.f47650c, new d.a.n0.a.u.h.b(1001, String.valueOf(i2)));
        }
    }

    @Override // d.a.n0.a.u.e.i.b.c
    public void f(c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, str) == null) {
            d(cVar.f47650c, new d.a.n0.a.u.h.b(10005, "system deny"));
        }
    }

    @Override // d.a.n0.a.u.e.i.b.c
    public void g(c cVar, d.a.n0.a.c2.f.k0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, bVar) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-GetLocationAction", "convert info : " + bVar.a());
            }
            d(cVar.f47650c, new d.a.n0.a.u.h.b(0, "success", bVar.a()));
        }
    }

    public d.a.n0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-GetLocationAction", "handle: " + str);
            }
            e Q = e.Q();
            if (Q == null) {
                return new d.a.n0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-GetLocationAction", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-GetLocationAction", "parse fail");
                }
                return bVar;
            }
            c b3 = c.b(((JSONObject) b2.second).toString());
            if (b3 != null && b3.a()) {
                if (TextUtils.isEmpty(b3.f47650c)) {
                    d.a.n0.a.e0.d.b("Api-GetLocationAction", "empty cb");
                    return new d.a.n0.a.u.h.b(201, "empty cb");
                }
                Q.T().g(i(), "mapp_location", new C0919a(this, b3));
                return new d.a.n0.a.u.h.b(0);
            }
            d.a.n0.a.e0.d.b("Api-GetLocationAction", "params is invalid");
            return new d.a.n0.a.u.h.b(201, "params is invalid");
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public final void t(i<b.e> iVar, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048580, this, iVar, cVar, z) == null) {
            d.a.n0.a.e0.d.g("Api-GetLocationAction", "authorized result is " + iVar);
            if (d.a.n0.a.e2.c.d.h(iVar)) {
                d.a.n0.a.u.e.i.b.d().e(cVar, this, z);
                return;
            }
            int b2 = iVar.b();
            d(cVar.f47650c, new d.a.n0.a.u.h.b(b2, d.a.n0.a.e2.c.d.f(b2)));
        }
    }

    public d.a.n0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (d.a.n0.a.u.c.d.f47438c) {
                Log.d("Api-GetLocationAction", "handle: " + str);
            }
            e Q = e.Q();
            if (Q == null) {
                return new d.a.n0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<d.a.n0.a.u.h.b, JSONObject> b2 = d.a.n0.a.u.i.b.b("Api-GetLocationAction", str);
            d.a.n0.a.u.h.b bVar = (d.a.n0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.n0.a.u.c.d.f47438c) {
                    d.a.n0.a.e0.d.b("Api-GetLocationAction", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.n0.a.u.h.b(201, "empty cb");
            }
            Q.T().g(i(), "mapp_location", new b(this, optString));
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    public d.a.n0.a.u.h.b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            d.a.n0.a.c1.a.E().d();
            return new d.a.n0.a.u.h.b(0);
        }
        return (d.a.n0.a.u.h.b) invokeV.objValue;
    }
}
