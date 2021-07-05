package d.a.q0.a.u.e.m;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.k2.c;
import d.a.q0.a.u.c.d;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.u.e.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0981a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f51072a;

        public C0981a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51072a = aVar;
        }

        @Override // d.a.q0.a.u.e.m.a.b
        public d.a.q0.a.u.h.b a(e eVar, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, str)) == null) {
                JSONObject A = a.A(this.f51072a.v(eVar).getString(str, null));
                if (A == null) {
                    return new d.a.q0.a.u.h.b(202, "JSONException");
                }
                return new d.a.q0.a.u.h.b(0, A);
            }
            return (d.a.q0.a.u.h.b) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        d.a.q0.a.u.h.b a(e eVar, String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.q0.a.u.c.b bVar) {
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
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static JSONObject A(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("key")) {
                        jSONObject.remove("key");
                    }
                    return jSONObject;
                } catch (JSONException unused) {
                    if (d.f50740c) {
                        Log.d("Api-Storage", "parseDataAsJsonResult:data is not json.");
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str == null) {
                str = "";
            }
            try {
                jSONObject2.put("data", str);
                return jSONObject2;
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static String B(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject.isNull("data")) {
                return null;
            }
            return jSONObject.optString("data");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String C(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject.isNull("key")) {
                return null;
            }
            return jSONObject.optString("key");
        }
        return (String) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start remove storage");
            }
            e i2 = e.i();
            if (y() && i2 == null) {
                return new d.a.q0.a.u.h.b(1001, "swan app is null");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Storage", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-Storage", "parse fail");
                }
                return bVar;
            }
            String C = C((JSONObject) b2.second);
            if (C == null) {
                return new d.a.q0.a.u.h.b(202);
            }
            v(i2).remove(C);
            H();
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start remove storage sync");
            }
            return D(str);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start set storage");
            }
            if (str != null && str.length() > 3145728) {
                return new d.a.q0.a.u.h.b(1001, "exceed storage item max length");
            }
            e i2 = e.i();
            if (y() && i2 == null) {
                return new d.a.q0.a.u.h.b(1001, "swan app is null");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Storage", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-Storage", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String C = C(jSONObject);
            if (C == null) {
                return new d.a.q0.a.u.h.b(202);
            }
            if (c.b(C)) {
                return new d.a.q0.a.u.h.b(1001, "exceed storage key max length");
            }
            String B = B(jSONObject);
            if (B == null) {
                return new d.a.q0.a.u.h.b(202);
            }
            if (c.c(B)) {
                return new d.a.q0.a.u.h.b(1001, "exceed storage item max length");
            }
            if (z(i2, C, B)) {
                if (d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-Storage", "exceed storage max length");
                }
                return new d.a.q0.a.u.h.b(1003, "exceed storage max length");
            }
            v(i2).putString(C, B);
            H();
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start set storage sync");
            }
            return F(str);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.q0.a.q2.d.f50163h.b();
        }
    }

    public d.a.q0.a.u.h.b r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start clear storage");
            }
            e i2 = e.i();
            if (y() && i2 == null) {
                return new d.a.q0.a.u.h.b(1001, "swan app is null");
            }
            v(i2).edit().clear().apply();
            H();
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public d.a.q0.a.u.h.b s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start clear storage sync");
            }
            return r();
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public d.a.q0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start get storage");
            }
            return u(str, new C0981a(this));
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.q0.a.u.h.b u(String str, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, bVar)) == null) {
            e i2 = e.i();
            if (y() && i2 == null) {
                return new d.a.q0.a.u.h.b(1001, "swan app is null");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-Storage", str);
            d.a.q0.a.u.h.b bVar2 = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar2.isSuccess()) {
                if (d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-Storage", "parse fail");
                }
                return bVar2;
            }
            String C = C((JSONObject) b2.second);
            if (C == null) {
                return new d.a.q0.a.u.h.b(202);
            }
            return bVar.a(i2, C);
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public d.a.q0.t.b v(@NonNull e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) ? eVar.U().g() : (d.a.q0.t.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            e i2 = e.i();
            if (i2 == null) {
                return new d.a.q0.a.u.h.b(1001, "swan app is null");
            }
            c U = i2.U();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) U.g().a()));
                jSONObject.put("currentSize", U.e() / 1024);
                jSONObject.put("limitSize", U.n() / 1024);
                return new d.a.q0.a.u.h.b(0, jSONObject);
            } catch (JSONException e2) {
                if (d.f50740c) {
                    e2.printStackTrace();
                }
                return new d.a.q0.a.u.h.b(202, "JSONException");
            }
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public d.a.q0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (d.f50740c) {
                Log.d("Api-Storage", "start get storage sync");
            }
            return t(str);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean z(@Nullable e eVar, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, eVar, str, str2)) == null) {
            if (eVar == null) {
                return false;
            }
            return eVar.U().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }
}
