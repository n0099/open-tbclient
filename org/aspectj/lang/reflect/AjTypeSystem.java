package org.aspectj.lang.reflect;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.internal.lang.reflect.AjTypeImpl;
/* loaded from: classes8.dex */
public class AjTypeSystem {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Class, WeakReference<AjType>> ajTypes;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1182306934, "Lorg/aspectj/lang/reflect/AjTypeSystem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1182306934, "Lorg/aspectj/lang/reflect/AjTypeSystem;");
                return;
            }
        }
        ajTypes = Collections.synchronizedMap(new WeakHashMap());
    }

    public AjTypeSystem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static <T> AjType<T> getAjType(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) {
            WeakReference<AjType> weakReference = ajTypes.get(cls);
            if (weakReference != null) {
                AjType<T> ajType = weakReference.get();
                if (ajType != null) {
                    return ajType;
                }
                AjTypeImpl ajTypeImpl = new AjTypeImpl(cls);
                ajTypes.put(cls, new WeakReference<>(ajTypeImpl));
                return ajTypeImpl;
            }
            AjTypeImpl ajTypeImpl2 = new AjTypeImpl(cls);
            ajTypes.put(cls, new WeakReference<>(ajTypeImpl2));
            return ajTypeImpl2;
        }
        return (AjType) invokeL.objValue;
    }
}
