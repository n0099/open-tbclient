package d.a.q0.a.v1.c.d;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.q0.a.k;
import d.a.q0.a.v1.c.c;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51237a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1394912364, "Ld/a/q0/a/v1/c/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1394912364, "Ld/a/q0/a/v1/c/d/a;");
                return;
            }
        }
        f51237a = k.f49133a;
    }

    public static void a(Message message) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, message) == null) {
            if (f51237a) {
                Log.e("ChannelMsgProcessor", "MSG_TYPE_CS_DELEGATION");
            }
            int i2 = message.arg1;
            Bundle bundle2 = (Bundle) message.obj;
            String str = "";
            String str2 = null;
            if (bundle2 != null) {
                str2 = bundle2.getString("ai_apps_delegation_name", null);
                str = bundle2.getString("ai_apps_observer_id", "");
                bundle = bundle2.getBundle("ai_apps_data");
            } else {
                bundle = null;
            }
            d.a.q0.a.v1.a.a.b.a(i2, str2, str, bundle);
        }
    }

    public static void b(Message message) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, message) == null) {
            Bundle bundle2 = (Bundle) message.obj;
            String str = "";
            String str2 = null;
            if (bundle2 != null) {
                str2 = bundle2.getString("ai_apps_delegation_name", null);
                str = bundle2.getString("ai_apps_observer_id", "");
                bundle = bundle2.getBundle("ai_apps_data");
            } else {
                bundle = null;
            }
            d.a.q0.a.v1.a.a.b.a(-1000, str2, str, bundle);
        }
    }

    public static void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, message) == null) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                if (f51237a) {
                    throw new RuntimeException("delegation msg obj is not a bundle");
                }
                return;
            }
            Bundle bundle = (Bundle) obj;
            d.a.q0.a.v1.a.b.a.b bVar = new d.a.q0.a.v1.a.b.a.b(bundle.getString("key_observer_id", ""));
            bVar.b(bundle.getBundle("key_result_data"));
            d.a.q0.a.v1.a.b.b.a.b().c(bVar);
        }
    }

    public static void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65540, null, message) == null) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                if (f51237a) {
                    throw new RuntimeException("delegation msg obj is not a bundle");
                }
                return;
            }
            Bundle bundle = (Bundle) obj;
            d.a.q0.a.v1.a.b.a.b bVar = new d.a.q0.a.v1.a.b.a.b(bundle.getString("key_observer_id", ""));
            bVar.b(bundle.getBundle("key_result_data"));
            d.a.q0.a.v1.a.b.b.a.b().c(bVar);
        }
    }

    public static void e(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, null, i2, bundle) == null) {
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            c cVar = new c(126, bundle);
            cVar.a(i2);
            e2.h(cVar);
        }
    }

    public static void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bundle) == null) {
            d.a.q0.a.v1.c.a.e().h(new c(21, bundle));
        }
    }
}
