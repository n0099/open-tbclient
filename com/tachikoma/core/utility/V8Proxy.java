package com.tachikoma.core.utility;

import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8Value;
import com.tachikoma.core.bridge.JSContext;
import com.tachikoma.core.bridge.TKJSContext;
import com.tachikoma.core.exception.TKExceptionDispatcher;
import java.util.List;
/* loaded from: classes7.dex */
public class V8Proxy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public V8Proxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static V8Array createV8Array(V8Value v8Value, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v8Value, objArr)) == null) {
            V8Array v8Array = new V8Array(v8Value.getRuntime());
            if (objArr != null) {
                for (Object obj : objArr) {
                    v8Array.push(obj);
                }
            }
            return v8Array;
        }
        return (V8Array) invokeLL.objValue;
    }

    public static V8Array createV8Array(V8Value v8Value, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, v8Value, strArr)) == null) {
            V8Array v8Array = new V8Array(v8Value.getRuntime());
            if (strArr != null) {
                for (String str : strArr) {
                    v8Array.push(str);
                }
            }
            return v8Array;
        }
        return (V8Array) invokeLL.objValue;
    }

    public static int executeIntegerFunction(V8Object v8Object, TKJSContext tKJSContext, String str, int... iArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, v8Object, tKJSContext, str, iArr)) == null) {
            try {
                if (iArr == null) {
                    return v8Object.executeIntegerFunction(str, null);
                }
                V8Array makeV8Array = tKJSContext.context().makeV8Array();
                for (int i : iArr) {
                    makeV8Array.push(i);
                }
                return v8Object.executeIntegerFunction(str, makeV8Array);
            } catch (Exception e) {
                TKExceptionDispatcher.dispatchJSException(e, "executeIntegerFunction: name is " + str, tKJSContext.hashCode());
                return -1;
            }
        }
        return invokeLLLL.intValue;
    }

    public static Pair<V8Object, Object> executeJsFunction(V8Object v8Object, TKJSContext tKJSContext, String str, Object... objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8Object, tKJSContext, str, objArr)) == null) {
            try {
                V8Object v8Object2 = (V8Object) v8Object.executeJSFunction(str, objArr);
                JSContext.V8AssociateReference associateReference = tKJSContext.context().getAssociateReference(v8Object2);
                Object obj = associateReference.nativeObject;
                associateReference.close();
                return new Pair<>(v8Object2, obj);
            } catch (Exception e) {
                TKExceptionDispatcher.dispatchJSException(e, "executeJsFunction: name is " + str, tKJSContext.hashCode());
                return null;
            }
        }
        return (Pair) invokeLLLL.objValue;
    }

    @Nullable
    public static Object getAssociateJsObject(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(list.size() - 1);
        }
        return invokeL.objValue;
    }

    public static TKJSContext getTKContext(List<Object> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (list == null || list.size() - 2 < 0) {
                return null;
            }
            return (TKJSContext) list.get(list.size() - 2);
        }
        return (TKJSContext) invokeL.objValue;
    }

    public static int getV8IntValue(V8Object v8Object, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, v8Object, str)) == null) {
            if (!isV8Valid(v8Object) || v8Object.get(str) == null || (v8Object.get(str) instanceof V8Object)) {
                return -1;
            }
            return ((Number) v8Object.get(str)).intValue();
        }
        return invokeLL.intValue;
    }

    public static int getV8IntValueSafely(V8Object v8Object, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, v8Object, str, i)) == null) {
            try {
                return getV8IntValue(v8Object, str);
            } catch (Exception unused) {
                return i;
            }
        }
        return invokeLLI.intValue;
    }

    @Nullable
    public static <T> T getV8ValueSafely(V8Object v8Object, String str, Class<T> cls) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, v8Object, str, cls)) == null) {
            if (isV8Valid(v8Object)) {
                if ((v8Object.get(str) instanceof V8Object) && ((V8Object) v8Object.get(str)).isUndefined()) {
                    return null;
                }
                return (T) v8Object.get(str);
            }
            return null;
        }
        return (T) invokeLLL.objValue;
    }

    public static boolean isV8Valid(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, v8Object)) == null) ? (v8Object == null || v8Object.isUndefined() || v8Object.isReleased()) ? false : true : invokeL.booleanValue;
    }

    public static void release(V8Value v8Value) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, v8Value) == null) || v8Value == null || v8Value.isReleased()) {
            return;
        }
        v8Value.close();
    }
}
