package d.a.i.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.LongSparseArray;
import com.baidu.browser.core.BdCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes8.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static g f45690b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, d.a.i.a.k.e<String, Integer>> f45691c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45692a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1582529779, "Ld/a/i/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1582529779, "Ld/a/i/a/g;");
                return;
            }
        }
        f45691c = new HashMap<>();
    }

    public g() {
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
        new LongSparseArray();
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
        }
    }

    public static synchronized g c() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (g.class) {
                if (f45690b == null) {
                    f45690b = new g();
                }
                gVar = f45690b;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    @Deprecated
    public static int d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) {
            a(str2, str);
            d.a.i.a.k.e<String, Integer> eVar = f45691c.get(str);
            if (eVar == null) {
                eVar = new d.a.i.a.k.e<>(100);
                f45691c.put(str, eVar);
            }
            Integer c2 = eVar.c(str2);
            if (c2 == null) {
                try {
                    int identifier = c().b().getResources().getIdentifier(str2, str, c().b().getPackageName());
                    eVar.d(str2, Integer.valueOf(identifier));
                    return identifier;
                } catch (Error e2) {
                    e2.printStackTrace();
                    return 0;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return 0;
                }
            }
            return c2.intValue();
        }
        return invokeLL.intValue;
    }

    public final Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f45692a == null) {
                this.f45692a = BdCore.b().a();
            }
            Context context = this.f45692a;
            if (context != null) {
                return context;
            }
            throw new RuntimeException("context is null!");
        }
        return (Context) invokeV.objValue;
    }
}
