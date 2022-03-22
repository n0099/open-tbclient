package com.kwad.v8.debug.mirror;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8ResultUndefined;
/* loaded from: classes7.dex */
public class Mirror implements Releasable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String IS_ARRAY = "isArray";
    public static final String IS_BOOLEAN = "isBoolean";
    public static final String IS_FUNCTION = "isFunction";
    public static final String IS_NULL = "isNull";
    public static final String IS_NUMBER = "isNumber";
    public static final String IS_OBJECT = "isObject";
    public static final String IS_STRING = "isString";
    public static final String IS_UNDEFINED = "isUndefined";
    public static final String IS_VALUE = "isValue";
    public transient /* synthetic */ FieldHolder $fh;
    public V8Object v8Object;

    public Mirror(V8Object v8Object) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v8Object};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v8Object = v8Object.twin();
    }

    public static ValueMirror createMirror(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, v8Object)) == null) ? isNull(v8Object) ? new NullMirror(v8Object) : isUndefined(v8Object) ? new UndefinedMirror(v8Object) : isFunction(v8Object) ? new FunctionMirror(v8Object) : isArray(v8Object) ? new ArrayMirror(v8Object) : isObject(v8Object) ? new ObjectMirror(v8Object) : isString(v8Object) ? new StringMirror(v8Object) : isNumber(v8Object) ? new NumberMirror(v8Object) : isBoolean(v8Object) ? new BooleanMirror(v8Object) : new ValueMirror(v8Object) : (ValueMirror) invokeL.objValue;
    }

    public static boolean isArray(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_ARRAY, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isBoolean(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_BOOLEAN, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isFunction(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_FUNCTION, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isNull(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_NULL, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isNumber(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_NUMBER, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isObject(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_OBJECT, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isString(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_STRING, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isUndefined(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_UNDEFINED, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isValue(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, v8Object)) == null) {
            try {
                return v8Object.executeBooleanFunction(IS_VALUE, null);
            } catch (V8ResultUndefined unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        V8Object v8Object;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (v8Object = this.v8Object) == null || v8Object.isReleased()) {
            return;
        }
        this.v8Object.close();
        this.v8Object = null;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj != null && (obj instanceof Mirror)) {
                return this.v8Object.equals(((Mirror) obj).v8Object);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.v8Object.hashCode() : invokeV.intValue;
    }

    public boolean isArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isFrame() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isFunction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isProperty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isUndefined() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.v8Object.executeBooleanFunction(IS_UNDEFINED, null) : invokeV.booleanValue;
    }

    public boolean isValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.v8.Releasable
    @Deprecated
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            close();
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.v8Object.toString() : (String) invokeV.objValue;
    }
}
