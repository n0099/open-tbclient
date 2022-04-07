package com.tachikoma.core.utility;

import android.content.Context;
import android.util.TypedValue;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class TKConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TKConverter() {
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

    public static Object doConverter(Object obj, Class cls) {
        InterceptResult invokeLL;
        Object valueOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, cls)) == null) {
            if (Integer.TYPE.equals(cls)) {
                try {
                    valueOf = Integer.valueOf(obj.toString());
                } catch (NumberFormatException unused) {
                    valueOf = Integer.valueOf(Float.valueOf(obj.toString()).intValue());
                }
            } else {
                valueOf = obj;
            }
            if (Byte.TYPE.equals(cls)) {
                valueOf = Byte.valueOf(obj.toString());
            }
            if (Short.TYPE.equals(cls)) {
                valueOf = Short.valueOf(obj.toString());
            }
            if (Long.TYPE.equals(cls)) {
                valueOf = Long.valueOf(obj.toString());
            }
            if (Float.TYPE.equals(cls)) {
                valueOf = Float.valueOf(obj.toString());
            }
            if (Double.TYPE.equals(cls)) {
                valueOf = Double.valueOf(obj.toString());
            }
            if (Boolean.TYPE.equals(cls)) {
                valueOf = Boolean.valueOf(obj.toString());
            }
            if (Character.TYPE.equals(cls)) {
                valueOf = Character.valueOf(obj.toString().charAt(0));
            }
            return cls.getName().equals("java.lang.String") ? obj.toString() : valueOf;
        }
        return invokeLL.objValue;
    }

    public static float dp2px(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65538, null, context, f)) == null) ? TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()) : invokeLF.floatValue;
    }

    public static float px2dp(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65539, null, context, f)) == null) ? (f / context.getResources().getDisplayMetrics().density) + 0.5f : invokeLF.floatValue;
    }

    public static Object toV8Value(Object obj, JSContext jSContext) {
        InterceptResult invokeLL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, jSContext)) == null) {
            if ((obj instanceof Number) || (obj instanceof String) || (obj instanceof Boolean)) {
                return obj;
            }
            if (!(obj instanceof Map)) {
                if (obj instanceof List) {
                    V8Array makeV8Array = jSContext.makeV8Array();
                    for (Object obj2 : (List) obj) {
                        Object v8Value = toV8Value(obj2, jSContext);
                        makeV8Array.push(v8Value);
                        if (v8Value instanceof V8Value) {
                            ((V8Value) v8Value).close();
                        }
                    }
                    return makeV8Array;
                }
                return null;
            }
            V8Object makeObject = jSContext.makeObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                if (entry.getKey() instanceof String) {
                    String str = (String) entry.getKey();
                    Object v8Value2 = toV8Value(entry.getValue(), jSContext);
                    if ((v8Value2 instanceof Long) || (v8Value2 instanceof Double) || (v8Value2 instanceof Float)) {
                        makeObject.add(str, ((Number) v8Value2).doubleValue());
                    } else {
                        if (v8Value2 instanceof Integer) {
                            intValue = ((Integer) v8Value2).intValue();
                        } else if (v8Value2 instanceof Short) {
                            intValue = ((Short) v8Value2).intValue();
                        } else if (v8Value2 instanceof String) {
                            makeObject.add(str, (String) v8Value2);
                        } else if (v8Value2 instanceof Boolean) {
                            makeObject.add(str, ((Boolean) v8Value2).booleanValue());
                        } else if (v8Value2 instanceof V8Value) {
                            V8Value v8Value3 = (V8Value) v8Value2;
                            makeObject.add(str, v8Value3);
                            v8Value3.close();
                        } else {
                            makeObject.addNull(str);
                        }
                        makeObject.add(str, intValue);
                    }
                }
            }
            return makeObject;
        }
        return invokeLL.objValue;
    }
}
