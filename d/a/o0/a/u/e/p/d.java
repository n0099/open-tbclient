package d.a.o0.a.u.e.p;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f48329d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1524723695, "Ld/a/o0/a/u/e/p/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1524723695, "Ld/a/o0/a/u/e/p/d;");
                return;
            }
        }
        f48329d = k.f46335a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NonNull d.a.o0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void r(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || str == null || str.length() <= 3145728) {
            return;
        }
        throw new IllegalArgumentException("params过大，len=" + str.length() + "\n" + str.substring(0, 204800));
    }

    public static String t(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj instanceof String) {
                String str = (String) obj;
                return !TextUtils.isEmpty(str) ? str : "log info is invalid";
            } else if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                return jSONObject.length() != 0 ? jSONObject.toString() : "log info is invalid";
            } else {
                return "log info is invalid";
            }
        }
        return (String) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (f48329d) {
                Log.d("Api-Log", "start logToFile action, params = " + str);
                r(str);
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-Log", str);
            if (!((d.a.o0.a.u.h.b) b2.first).isSuccess()) {
                d.a.o0.a.e0.d.b("Api-Log", "parse failed, params = " + str);
                return (d.a.o0.a.u.h.b) b2.first;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            d.a.o0.a.e0.d.h(jSONObject.optString("tag", "logToFile-swanjsLog"), t(jSONObject.opt("data")));
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
