package d.a.q0.u2;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static c f64806b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<String, d.a.q0.u2.d.a> f64807a;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64807a = new ConcurrentHashMap<>();
    }

    public static c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f64806b == null) {
                synchronized (c.class) {
                    if (f64806b == null) {
                        f64806b = new c();
                    }
                }
            }
            return f64806b;
        }
        return (c) invokeV.objValue;
    }

    public ConcurrentHashMap<String, d.a.q0.u2.d.a> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64807a : (ConcurrentHashMap) invokeV.objValue;
    }

    public d.a.q0.u2.d.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            ConcurrentHashMap<String, d.a.q0.u2.d.a> concurrentHashMap = this.f64807a;
            if (concurrentHashMap == null) {
                return null;
            }
            return concurrentHashMap.get(str);
        }
        return (d.a.q0.u2.d.a) invokeL.objValue;
    }

    public void d(String str) {
        ConcurrentHashMap<String, d.a.q0.u2.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f64807a) == null) {
            return;
        }
        Iterator<String> it = concurrentHashMap.keySet().iterator();
        while (it.hasNext()) {
            d.a.q0.u2.d.a aVar = this.f64807a.get(it.next());
            if (aVar != null && str.equals(aVar.f64809b)) {
                it.remove();
            }
        }
    }

    public void e(boolean z) {
        ConcurrentHashMap<String, d.a.q0.u2.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (concurrentHashMap = this.f64807a) == null) {
            return;
        }
        for (String str : concurrentHashMap.keySet()) {
            d.a.q0.u2.d.a aVar = this.f64807a.get(str);
            if (aVar != null) {
                aVar.f64812e = z;
            }
        }
    }

    public void f(boolean z, String str) {
        ConcurrentHashMap<String, d.a.q0.u2.d.a> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, str) == null) || TextUtils.isEmpty(str) || (concurrentHashMap = this.f64807a) == null) {
            return;
        }
        for (String str2 : concurrentHashMap.keySet()) {
            d.a.q0.u2.d.a aVar = this.f64807a.get(str2);
            if (aVar != null && str.equals(aVar.f64809b)) {
                aVar.f64812e = z;
            }
        }
    }

    public void g(HashMap<String, d.a.q0.u2.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
            this.f64807a.clear();
            if (hashMap == null) {
                return;
            }
            this.f64807a.putAll(hashMap);
        }
    }

    public void h(String str, HashMap<String, d.a.q0.u2.d.a> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, hashMap) == null) {
            if (this.f64807a == null) {
                this.f64807a = new ConcurrentHashMap<>();
            }
            d(str);
            this.f64807a.putAll(hashMap);
        }
    }
}
