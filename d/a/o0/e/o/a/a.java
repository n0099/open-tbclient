package d.a.o0.e.o.a;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.r.e;
import d.a.o0.r.m;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class a implements m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49690a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1506145979, "Ld/a/o0/e/o/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1506145979, "Ld/a/o0/e/o/a/a;");
                return;
            }
        }
        f49690a = k.f46335a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.o0.r.m
    public boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            if (f49690a) {
                Log.d("OpenBehaviorUploader", "upload stat data -> " + jSONArray.toString());
            }
            d.a.o0.e.o.a.d.c cVar = new d.a.o0.e.o.a.d.c();
            HashMap hashMap = new HashMap(2);
            hashMap.put("cuid", e.h().getDeviceId(AppRuntime.getApplication()));
            hashMap.put("uuid", e.h().p(AppRuntime.getApplication()));
            d.a.o0.e.o.a.d.b.d().g(hashMap, jSONArray.toString().getBytes(), null, cVar);
            if (f49690a) {
                Log.d("OpenBehaviorUploader", "errorCode : " + cVar.f49695a);
                Log.d("OpenBehaviorUploader", "errorMsg : " + cVar.f49696b);
            }
            int i2 = cVar.f49695a;
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                d.a.o0.s.c.a();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
