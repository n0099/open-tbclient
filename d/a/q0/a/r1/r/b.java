package d.a.q0.a.r1.r;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class b implements d.a.q0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<Runnable, String> f50502b;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.a.r1.r.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0932b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f50503a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(464162767, "Ld/a/q0/a/r1/r/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(464162767, "Ld/a/q0/a/r1/r/b$b;");
                    return;
                }
            }
            f50503a = new b(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1019476301, "Ld/a/q0/a/r1/r/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1019476301, "Ld/a/q0/a/r1/r/b;");
                return;
            }
        }
        e.k();
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0932b.f50503a : (b) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50502b.isEmpty()) {
            return;
        }
        if (d.a.q0.a.f1.f.a.f47786a) {
            Log.d("SwanPerformance", "main process batch handle thread, size = " + this.f50502b.size());
        }
        for (Map.Entry<Runnable, String> entry : this.f50502b.entrySet()) {
            if (entry != null) {
                ExecutorUtilsExt.postOnElastic(entry.getKey(), entry.getValue(), 2);
            }
        }
        this.f50502b.clear();
    }

    public void c(Message message) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) || message == null || (obj = message.obj) == null || !(obj instanceof Bundle)) {
            return;
        }
        Bundle bundle = (Bundle) obj;
        boolean z = bundle.getBoolean("is_timeout", false);
        String string = bundle.getString("app_id", null);
        if (d.a.q0.a.f1.f.a.f47786a) {
            Log.e("SwanPerformance", "main process launch end，timeout = " + z + " ; appId = " + string);
        }
        a();
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (d.a.q0.a.f1.f.a.f47786a) {
                Log.e("SwanPerformance", "main process launch start，appId = " + str);
            }
            System.currentTimeMillis();
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50502b = new ConcurrentHashMap();
    }
}
