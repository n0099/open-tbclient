package d.a.q0.a.j2;

import android.util.Log;
import androidx.annotation.NonNull;
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
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49108a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f49109b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f49110c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a.q0.a.j2.p.c f49111a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f49112b;

        /* renamed from: c  reason: collision with root package name */
        public final long f49113c;

        /* renamed from: d  reason: collision with root package name */
        public final String f49114d;

        public a(@NonNull d.a.q0.a.j2.p.c cVar, @NonNull String str) {
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
            this.f49111a = cVar;
            this.f49114d = str;
            this.f49113c = cVar.l();
            synchronized (n.f49110c) {
                if (n.f49109b) {
                    n.f49110c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(118841883, "Ld/a/q0/a/j2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(118841883, "Ld/a/q0/a/j2/n;");
                return;
            }
        }
        f49108a = d.a.q0.a.k.f49133a;
        f49109b = false;
        f49110c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(d.a.q0.a.n1.l.a()));
            if (d.a.q0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f49110c) {
                if (f49108a) {
                    Log.d("SwanReqStatisticManager", "size=" + f49110c.size());
                }
                f49109b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f49110c) {
                    if (aVar.f49113c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f49114d);
                            if (aVar.f49111a != null) {
                                aVar.f49111a.o(jSONObject);
                            }
                            if (aVar.f49112b != null) {
                                Iterator<String> keys = aVar.f49112b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f49112b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f49108a) {
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
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            synchronized (f49110c) {
                f49109b = true;
                f49110c.clear();
            }
        }
    }
}
