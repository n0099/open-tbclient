package d.a.n0.a.j2;

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
    public static final boolean f45806a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f45807b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<a> f45808c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final d.a.n0.a.j2.p.c f45809a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f45810b;

        /* renamed from: c  reason: collision with root package name */
        public final long f45811c;

        /* renamed from: d  reason: collision with root package name */
        public final String f45812d;

        public a(@NonNull d.a.n0.a.j2.p.c cVar, @NonNull String str) {
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
            this.f45809a = cVar;
            this.f45812d = str;
            this.f45811c = cVar.l();
            synchronized (n.f45808c) {
                if (n.f45807b) {
                    n.f45808c.add(this);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(708382398, "Ld/a/n0/a/j2/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(708382398, "Ld/a/n0/a/j2/n;");
                return;
            }
        }
        f45806a = d.a.n0.a.k.f45831a;
        f45807b = false;
        f45808c = new ArrayList();
    }

    public static void c(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, hybridUbcFlow) == null) && "670".equals(hybridUbcFlow.j())) {
            hybridUbcFlow.A("networkStatus", String.valueOf(d.a.n0.a.n1.l.a()));
            if (d.a.n0.a.r1.l.b.o || (f2 = hybridUbcFlow.f("na_first_meaningful_paint")) == null) {
                return;
            }
            long g2 = f2.g();
            synchronized (f45808c) {
                if (f45806a) {
                    Log.d("SwanReqStatisticManager", "size=" + f45808c.size());
                }
                f45807b = false;
                JSONArray jSONArray = new JSONArray();
                for (a aVar : f45808c) {
                    if (aVar.f45811c <= g2) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("type", aVar.f45812d);
                            if (aVar.f45809a != null) {
                                aVar.f45809a.o(jSONObject);
                            }
                            if (aVar.f45810b != null) {
                                Iterator<String> keys = aVar.f45810b.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    jSONObject.put(next, aVar.f45810b.get(next));
                                }
                            }
                            jSONArray.put(jSONObject);
                        } catch (JSONException e2) {
                            if (f45806a) {
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
            synchronized (f45808c) {
                f45807b = true;
                f45808c.clear();
            }
        }
    }
}
