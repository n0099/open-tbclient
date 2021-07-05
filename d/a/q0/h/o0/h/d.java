package d.a.q0.h.o0.h;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.a2.e;
import d.a.q0.a.k;
import d.a.q0.h.o0.h.a;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f53574a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1439241094, "Ld/a/q0/h/o0/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1439241094, "Ld/a/q0/h/o0/h/d;");
                return;
            }
        }
        f53574a = k.f49133a;
    }

    public static void a(@NonNull e eVar, @NonNull a.e eVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, eVar, eVar2) == null) {
            long l = eVar.L().l("launch_time", 0L);
            if (l <= 0) {
                if (f53574a) {
                    Log.d("GameWebViewStatistic", "doH5GameLoadingFinishStats: launchTime is invalid.");
                    return;
                }
                return;
            }
            d.a.q0.a.j2.p.e eVar3 = new d.a.q0.a.j2.p.e();
            eVar3.f49119a = d.a.q0.a.j2.k.m(eVar.L().G());
            eVar3.f49124f = eVar.getAppId();
            eVar3.f49121c = eVar.L().T();
            eVar3.f49120b = "startup";
            eVar3.f49125g = eVar2.f53570a;
            eVar3.f49123e = eVar2.f53571b;
            eVar3.a("na_start", Long.valueOf(l));
            eVar3.a("h5_start", Long.valueOf(eVar2.f53572c));
            eVar3.a("h5_finish", Long.valueOf(eVar2.f53573d));
            d.a.q0.a.j2.k.u("1235", eVar3);
        }
    }
}
