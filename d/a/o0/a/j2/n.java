package d.a.o0.a.j2;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46310a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f46311b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f46312c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a.o0.a.j2.p.c f46313a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f46314b;

        /* renamed from: c  reason: collision with root package name */
        public final long f46315c;

        /* renamed from: d  reason: collision with root package name */
        public final String f46316d;

        public a(@NonNull d.a.o0.a.j2.p.c cVar, @NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46313a = cVar;
            this.f46316d = str;
            this.f46315c = cVar.l();
            synchronized (n.f46312c) {
                if (n.f46311b) {
                    n.f46312c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(511868893, "Ld/a/o0/a/j2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(511868893, "Ld/a/o0/a/j2/n;");
                return;
            }
        }
        f46310a = d.a.o0.a.k.f46335a;
        f46311b = false;
        f46312c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(d.a.o0.a.n1.l.a()));
            if (d.a.o0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f46312c) {
                if (f46310a) {
                    Log.d("SwanReqStatisticManager", "size=" + f46312c.size());
                }
                f46311b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f46312c) {
                    if (aVar.f46315c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f46316d);
                            if (aVar.f46313a != null) {
                                aVar.f46313a.o(jSONObject);
                            }
                            if (aVar.f46314b != null) {
                                Iterator<String> keys = aVar.f46314b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f46314b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f46310a) {
                                Log.e("SwanReqStatisticManager", "appendRequestRecord", e2);
                            }
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    hybridUbcFlow.A("requests", jSONArray.toString());
                }
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (f46312c) {
                f46311b = true;
                f46312c.clear();
            }
        }
    }
}
