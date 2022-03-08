package org.apache.commons.lang3.text;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class StrLookup<V> {
    public static /* synthetic */ Interceptable $ic;
    public static final StrLookup<String> NONE_LOOKUP;
    public static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: org.apache.commons.lang3.text.StrLookup$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class MapStrLookup<V> extends StrLookup<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<String, V> map;

        public MapStrLookup(Map<String, V> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.map = map;
        }

        @Override // org.apache.commons.lang3.text.StrLookup
        public String lookup(String str) {
            InterceptResult invokeL;
            V v;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                Map<String, V> map = this.map;
                if (map == null || (v = map.get(str)) == null) {
                    return null;
                }
                return v.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class SystemPropertiesStrLookup extends StrLookup<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SystemPropertiesStrLookup() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // org.apache.commons.lang3.text.StrLookup
        public String lookup(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (str.length() > 0) {
                    try {
                        return System.getProperty(str);
                    } catch (SecurityException unused) {
                        return null;
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public /* synthetic */ SystemPropertiesStrLookup(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(717958007, "Lorg/apache/commons/lang3/text/StrLookup;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(717958007, "Lorg/apache/commons/lang3/text/StrLookup;");
                return;
            }
        }
        NONE_LOOKUP = new MapStrLookup(null);
        SYSTEM_PROPERTIES_LOOKUP = new SystemPropertiesStrLookup(null);
    }

    public StrLookup() {
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

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) ? new MapStrLookup(map) : (StrLookup) invokeL.objValue;
    }

    public static StrLookup<?> noneLookup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? NONE_LOOKUP : (StrLookup) invokeV.objValue;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? SYSTEM_PROPERTIES_LOOKUP : (StrLookup) invokeV.objValue;
    }

    public abstract String lookup(String str);
}
