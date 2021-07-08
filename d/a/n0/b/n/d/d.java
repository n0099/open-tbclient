package d.a.n0.b.n.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.n0.a.j2.p.f;
import d.a.n0.a.k;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49005a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1953873352, "Ld/a/n0/b/n/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1953873352, "Ld/a/n0/b/n/d/d;");
                return;
            }
        }
        f49005a = k.f45831a;
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65537, null, str, str2, str3, str4, str5) == null) {
            f fVar = new f();
            fVar.f45817a = "swan";
            fVar.f45818b = str;
            fVar.f45823g = str2;
            if (TextUtils.equals(str, PrefetchEvent.STATE_CLICK)) {
                fVar.f45821e = str3;
            }
            fVar.f45822f = str5;
            fVar.a("source", str4);
            if (f49005a) {
                Log.d("LoginAndGetMobileStatics", "staticLoginResult: event = " + fVar.f());
            }
            d.a.n0.a.j2.k.u("1372", fVar);
        }
    }
}
