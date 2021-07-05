package d.a.q0.a.d2;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Boolean> f47250a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Boolean> f47251b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.d2.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0712a implements d.a.q0.a.v2.e1.b<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47252e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f47253f;

        public C0712a(String str, d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47252e = str;
            this.f47253f = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                boolean z = true;
                z = (fVar == null || fVar.f47631d || fVar.j != 1) ? false : false;
                a.f47250a.put(this.f47252e, Boolean.valueOf(z));
                this.f47253f.onCallback(Boolean.valueOf(z));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(113300354, "Ld/a/q0/a/d2/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(113300354, "Ld/a/q0/a/d2/a;");
                return;
            }
        }
        f47250a = new ConcurrentHashMap();
        f47251b = new ConcurrentHashMap();
    }

    public static void b(d.a.q0.a.v2.e1.b<Boolean> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bVar) == null) {
            String appId = d.a.q0.a.a2.d.g().getAppId();
            Boolean bool = f47250a.get(appId);
            if (bool != null) {
                bVar.onCallback(bool);
            } else {
                d.a.q0.a.a2.d.g().r().T().e("mapp_custom_screenshot_image", new C0712a(appId, bVar));
            }
        }
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Boolean bool = f47251b.get(d.a.q0.a.a2.d.g().getAppId());
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, null) == null) {
            f47251b.clear();
            f47250a.clear();
        }
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            f47251b.put(d.a.q0.a.a2.d.g().getAppId(), Boolean.valueOf(z));
        }
    }
}
