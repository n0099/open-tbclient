package d.a.q0.n.l;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n.c;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f54106d;

    /* renamed from: e  reason: collision with root package name */
    public static Map<String, a> f54107e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<String, Map<String, a>> f54108f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f54109a;

    /* renamed from: b  reason: collision with root package name */
    public final String f54110b;

    /* renamed from: c  reason: collision with root package name */
    public final AbiType f54111c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1207354761, "Ld/a/q0/n/l/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1207354761, "Ld/a/q0/n/l/a;");
                return;
            }
        }
        f54106d = c.f53910a;
        f54107e = new HashMap();
        f54108f = new HashMap();
    }

    public a(@NonNull String str, @NonNull AbiType abiType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, abiType};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54109a = TextUtils.isEmpty(str) ? "" : str;
        this.f54111c = abiType;
        this.f54110b = a(str, abiType);
        if (f54106d) {
            Log.i("SoBundleId", "SoBundleId: " + this.f54110b + " libName=" + str + " abi=" + abiType);
        }
    }

    public static String a(String str, AbiType abiType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, abiType)) == null) {
            return "so_" + str + "_" + abiType.id;
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized Map<String, a> b(@NonNull String str) {
        InterceptResult invokeL;
        HashMap hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (a.class) {
                hashMap = new HashMap(c(str));
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static synchronized Map<String, a> c(@NonNull String str) {
        InterceptResult invokeL;
        Map<String, a> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            synchronized (a.class) {
                map = f54108f.get(str);
                if (map == null) {
                    map = new HashMap<>();
                    if (!TextUtils.isEmpty(str)) {
                        for (AbiType abiType : AbiType.values()) {
                            a aVar = new a(str, abiType);
                            map.put(aVar.f54110b, aVar);
                        }
                        f54107e.putAll(map);
                        f54108f.put(str, map);
                    }
                }
            }
            return map;
        }
        return (Map) invokeL.objValue;
    }

    @Nullable
    public static synchronized a d(String str, AbiType abiType) {
        InterceptResult invokeLL;
        a e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, abiType)) == null) {
            synchronized (a.class) {
                e2 = e(str, a(str, abiType));
            }
            return e2;
        }
        return (a) invokeLL.objValue;
    }

    @Nullable
    public static synchronized a e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2)) == null) {
            synchronized (a.class) {
                if (f54106d) {
                    Log.i("SoBundleId", "of: start libName=" + str + " bundleId=" + str2);
                }
                a aVar = null;
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    c(str);
                    a aVar2 = f54107e.get(str2);
                    if (f54106d) {
                        Log.i("SoBundleId", "of: end libName=" + str + " soBundleId=" + aVar2);
                    }
                    if (aVar2 != null) {
                        if (TextUtils.equals(str, aVar2.f54109a)) {
                            aVar = aVar2;
                        }
                    }
                    return aVar;
                }
                return null;
            }
        }
        return (a) invokeLL.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f54110b : (String) invokeV.objValue;
    }
}
