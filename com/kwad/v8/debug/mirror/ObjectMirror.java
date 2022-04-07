package com.kwad.v8.debug.mirror;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
/* loaded from: classes5.dex */
public class ObjectMirror extends ValueMirror {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PROPERTIES = "properties";
    public static final String PROPERTY_NAMES = "propertyNames";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class PropertyKind {
        public static final /* synthetic */ PropertyKind[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PropertyKind Indexed;
        public static final PropertyKind Named;
        public transient /* synthetic */ FieldHolder $fh;
        public int index;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1487440839, "Lcom/kwad/v8/debug/mirror/ObjectMirror$PropertyKind;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1487440839, "Lcom/kwad/v8/debug/mirror/ObjectMirror$PropertyKind;");
                    return;
                }
            }
            Named = new PropertyKind("Named", 0, 1);
            PropertyKind propertyKind = new PropertyKind("Indexed", 1, 2);
            Indexed = propertyKind;
            $VALUES = new PropertyKind[]{Named, propertyKind};
        }

        public PropertyKind(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.index = i2;
        }

        public static PropertyKind valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PropertyKind) Enum.valueOf(PropertyKind.class, str) : (PropertyKind) invokeL.objValue;
        }

        public static PropertyKind[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PropertyKind[]) $VALUES.clone() : (PropertyKind[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectMirror(V8Object v8Object) {
        super(v8Object);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((V8Object) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public PropertiesArray getProperties(PropertyKind propertyKind, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, propertyKind, i)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(propertyKind.index);
            v8Array.push(i);
            V8Array v8Array2 = null;
            try {
                v8Array2 = this.v8Object.executeArrayFunction(PROPERTIES, v8Array);
                return new PropertiesArray(v8Array2);
            } finally {
                v8Array.close();
                if (v8Array2 != null && !v8Array2.isReleased()) {
                    v8Array2.close();
                }
            }
        }
        return (PropertiesArray) invokeLI.objValue;
    }

    public String[] getPropertyNames(PropertyKind propertyKind, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, propertyKind, i)) == null) {
            V8Array v8Array = new V8Array(this.v8Object.getRuntime());
            v8Array.push(propertyKind.index);
            v8Array.push(i);
            V8Array v8Array2 = null;
            try {
                v8Array2 = this.v8Object.executeArrayFunction(PROPERTY_NAMES, v8Array);
                int length = v8Array2.length();
                String[] strArr = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    strArr[i2] = v8Array2.getString(i2);
                }
                return strArr;
            } finally {
                v8Array.close();
                if (v8Array2 != null) {
                    v8Array2.close();
                }
            }
        }
        return (String[]) invokeLI.objValue;
    }

    @Override // com.kwad.v8.debug.mirror.Mirror
    public boolean isObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.v8.debug.mirror.Mirror
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.v8Object.toString() : (String) invokeV.objValue;
    }
}
