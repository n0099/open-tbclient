package d.a.q0.g.i.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.k2.g.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f53019c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1226118847, "Ld/a/q0/g/i/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1226118847, "Ld/a/q0/g/i/b/b;");
                return;
            }
        }
        f53019c = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("GetSwanGameDuration");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean b(Long l, Long l2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, l, l2)) == null) ? l.longValue() / 86400000 == l2.longValue() / 86400000 : invokeLL.booleanValue;
    }

    @Override // d.a.q0.g.f.a
    public d.a.q0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (jSONObject == null) {
                bVar.onFail(202, "params may be error");
                return null;
            }
            if (f53019c) {
                Log.e("GetSwanGameDuration", "params is " + jSONObject.toString());
            }
            String optString = jSONObject.optString("swanGameId");
            if (TextUtils.isEmpty(optString)) {
                bVar.onFail(202, "params may be error");
            } else {
                d.a.q0.a.k2.g.b a2 = h.a();
                if (!b(Long.valueOf(a2.getLong(optString + "_LastPause", 0L)), Long.valueOf(System.currentTimeMillis()))) {
                    d.a.q0.a.k2.g.b a3 = h.a();
                    a3.putLong(optString + "_Duration", 0L);
                }
                d.a.q0.a.k2.g.b a4 = h.a();
                long j = a4.getLong(optString + "_Duration", 0L);
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("swanGameDuration", j);
                    jSONObject2.put("data", jSONObject3);
                } catch (JSONException e2) {
                    if (f53019c) {
                        e2.printStackTrace();
                    }
                }
                bVar.a(jSONObject2);
            }
            return null;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }
}
