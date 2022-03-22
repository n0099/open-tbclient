package com.kwad.v8.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.Releasable;
import com.kwad.v8.V8;
import com.kwad.v8.V8Array;
import com.kwad.v8.V8ArrayBuffer;
import com.kwad.v8.V8Object;
import com.kwad.v8.V8TypedArray;
import com.kwad.v8.V8Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class V8ObjectUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final TypeAdapter DEFAULT_TYPE_ADAPTER;
    public static final Object IGNORE;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class DefaultTypeAdapter implements TypeAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultTypeAdapter() {
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

        @Override // com.kwad.v8.utils.TypeAdapter
        public Object adapt(int i, Object obj) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, obj)) == null) ? TypeAdapter.DEFAULT : invokeIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class ListWrapper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<? extends Object> list;

        public ListWrapper(List<? extends Object> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.list = list;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? (obj instanceof ListWrapper) && ((ListWrapper) obj).list == this.list : invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? System.identityHashCode(this.list) : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(621138608, "Lcom/kwad/v8/utils/V8ObjectUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(621138608, "Lcom/kwad/v8/utils/V8ObjectUtils;");
                return;
            }
        }
        IGNORE = new Object();
        DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();
    }

    public V8ObjectUtils() {
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

    public static Object getTypedArray(V8Array v8Array, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, v8Array, i)) == null) {
            int length = v8Array.length();
            if (i == 1) {
                return v8Array.getIntegers(0, length);
            }
            if (i == 2) {
                return v8Array.getDoubles(0, length);
            }
            if (i == 3) {
                return v8Array.getBooleans(0, length);
            }
            if (i == 4) {
                return v8Array.getStrings(0, length);
            }
            throw new RuntimeException("Unsupported bulk load type: " + i);
        }
        return invokeLI.objValue;
    }

    public static Object getTypedArray(V8Array v8Array, int i, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, v8Array, i, obj)) == null) {
            int length = v8Array.length();
            if (i == 1) {
                int[] iArr = (int[]) obj;
                if (iArr == null || iArr.length < length) {
                    iArr = new int[length];
                }
                v8Array.getIntegers(0, length, iArr);
                return iArr;
            } else if (i == 2) {
                double[] dArr = (double[]) obj;
                if (dArr == null || dArr.length < length) {
                    dArr = new double[length];
                }
                v8Array.getDoubles(0, length, dArr);
                return dArr;
            } else if (i == 3) {
                boolean[] zArr = (boolean[]) obj;
                if (zArr == null || zArr.length < length) {
                    zArr = new boolean[length];
                }
                v8Array.getBooleans(0, length, zArr);
                return zArr;
            } else if (i == 4) {
                String[] strArr = (String[]) obj;
                if (strArr == null || strArr.length < length) {
                    strArr = new String[length];
                }
                v8Array.getStrings(0, length, strArr);
                return strArr;
            } else if (i != 9) {
                throw new RuntimeException("Unsupported bulk load type: " + i);
            } else {
                byte[] bArr = (byte[]) obj;
                if (bArr == null || bArr.length < length) {
                    bArr = new byte[length];
                }
                v8Array.getBytes(0, length, bArr);
                return bArr;
            }
        }
        return invokeLIL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, INVOKE]}, finally: {[INVOKE, INVOKE, INVOKE, CHECK_CAST, INVOKE, IF, INVOKE] complete} */
    public static Object getV8Result(V8 v8, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, v8, obj)) == null) {
            if (obj == null) {
                return null;
            }
            Hashtable hashtable = new Hashtable();
            try {
                Object v8Result = getV8Result(v8, obj, hashtable);
                if (v8Result instanceof V8Value) {
                    return ((V8Value) v8Result).twin();
                }
                for (V8Value v8Value : hashtable.values()) {
                    v8Value.close();
                }
                return v8Result;
            } finally {
                for (V8Value v8Value2 : hashtable.values()) {
                    v8Value2.close();
                }
            }
        }
        return invokeLL.objValue;
    }

    public static Object getV8Result(V8 v8, Object obj, Map<Object, V8Value> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, v8, obj, map)) == null) ? map.containsKey(obj) ? map.get(obj) : obj instanceof Map ? toV8Object(v8, (Map) obj, map) : obj instanceof List ? toV8Array(v8, (List) obj, map) : obj instanceof TypedArray ? toV8TypedArray(v8, (TypedArray) obj, map) : obj instanceof ArrayBuffer ? toV8ArrayBuffer(v8, (ArrayBuffer) obj, map) : obj : invokeLLL.objValue;
    }

    public static Object getValue(V8Array v8Array, int i) {
        InterceptResult invokeLI;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65542, null, v8Array, i)) != null) {
            return invokeLI.objValue;
        }
        V8Map v8Map = new V8Map();
        try {
            obj = v8Array.get(i);
            try {
                Object value = getValue(obj, v8Array.getType(i), v8Map, DEFAULT_TYPE_ADAPTER);
                if (value != obj || !(value instanceof V8Value)) {
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                    v8Map.close();
                    return value;
                }
                V8Value twin = ((V8Value) value).twin();
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.close();
                return twin;
            } catch (Throwable th) {
                th = th;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    public static Object getValue(V8Array v8Array, int i, TypeAdapter typeAdapter) {
        InterceptResult invokeLIL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLIL = interceptable.invokeLIL(65543, null, v8Array, i, typeAdapter)) != null) {
            return invokeLIL.objValue;
        }
        V8Map v8Map = new V8Map();
        try {
            obj = v8Array.get(i);
            try {
                Object value = getValue(obj, v8Array.getType(i), v8Map, typeAdapter);
                if (value != obj || !(value instanceof V8Value)) {
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                    v8Map.close();
                    return value;
                }
                V8Value twin = ((V8Value) value).twin();
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.close();
                return twin;
            } catch (Throwable th) {
                th = th;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    public static Object getValue(V8Object v8Object, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, v8Object, str)) == null) ? getValue(v8Object, str, DEFAULT_TYPE_ADAPTER) : invokeLL.objValue;
    }

    public static Object getValue(V8Object v8Object, String str, TypeAdapter typeAdapter) {
        InterceptResult invokeLLL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65545, null, v8Object, str, typeAdapter)) != null) {
            return invokeLLL.objValue;
        }
        V8Map v8Map = new V8Map();
        try {
            obj = v8Object.get(str);
            try {
                Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                if (value != obj || !(value instanceof V8Value)) {
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                    v8Map.close();
                    return value;
                }
                V8Value twin = ((V8Value) value).twin();
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.close();
                return twin;
            } catch (Throwable th) {
                th = th;
                if (obj instanceof Releasable) {
                    ((Releasable) obj).release();
                }
                v8Map.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            obj = null;
        }
    }

    public static Object getValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, obj)) == null) ? getValue(obj, DEFAULT_TYPE_ADAPTER) : invokeL.objValue;
    }

    public static Object getValue(Object obj, int i, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65547, null, obj, i, v8Map, typeAdapter)) == null) {
            Object adapt = typeAdapter.adapt(i, obj);
            if (TypeAdapter.DEFAULT != adapt) {
                return adapt;
            }
            if (i != 10) {
                if (i != 99) {
                    switch (i) {
                        case 0:
                            return null;
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            return obj;
                        case 5:
                            return toList((V8Array) obj, v8Map, typeAdapter);
                        case 6:
                            return toMap((V8Object) obj, v8Map, typeAdapter);
                        case 7:
                            return IGNORE;
                        case 8:
                            return new TypedArray((V8TypedArray) obj);
                        default:
                            throw new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(i));
                    }
                }
                return V8.getUndefined();
            }
            return new ArrayBuffer((V8ArrayBuffer) obj);
        }
        return invokeLILL.objValue;
    }

    public static Object getValue(Object obj, TypeAdapter typeAdapter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, obj, typeAdapter)) == null) {
            V8Map v8Map = new V8Map();
            try {
                return obj instanceof V8Value ? getValue(obj, ((V8Value) obj).getV8Type(), v8Map, typeAdapter) : obj;
            } finally {
                v8Map.close();
            }
        }
        return invokeLL.objValue;
    }

    public static void pushValue(V8 v8, V8Array v8Array, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, v8, v8Array, obj) == null) {
            Hashtable hashtable = new Hashtable();
            try {
                pushValue(v8, v8Array, obj, hashtable);
            } finally {
                for (V8Value v8Value : hashtable.values()) {
                    v8Value.close();
                }
            }
        }
    }

    public static void pushValue(V8 v8, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        V8Value v8Array2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65550, null, v8, v8Array, obj, map) == null) {
            if (obj == null) {
                v8Array.pushUndefined();
                return;
            }
            if (!(obj instanceof Integer)) {
                if (obj instanceof Long) {
                    v8Array.push(new Double(((Long) obj).longValue()));
                    return;
                } else if (!(obj instanceof Double) && !(obj instanceof Float)) {
                    if (obj instanceof String) {
                        v8Array.push((String) obj);
                        return;
                    } else if (!(obj instanceof Boolean)) {
                        if (obj instanceof TypedArray) {
                            v8Array2 = toV8TypedArray(v8, (TypedArray) obj, map);
                        } else if (obj instanceof ArrayBuffer) {
                            v8Array2 = toV8ArrayBuffer(v8, (ArrayBuffer) obj, map);
                        } else if (obj instanceof V8Value) {
                            v8Array.push((V8Value) obj);
                            return;
                        } else if (obj instanceof Map) {
                            v8Array2 = toV8Object(v8, (Map) obj, map);
                        } else if (!(obj instanceof List)) {
                            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
                        } else {
                            v8Array2 = toV8Array(v8, (List) obj, map);
                        }
                        v8Array.push(v8Array2);
                        return;
                    }
                }
            }
            v8Array.push(obj);
        }
    }

    public static void setValue(V8 v8, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        V8Value v8Array;
        double floatValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65551, null, v8, v8Object, str, obj, map) == null) {
            if (obj == null) {
                v8Object.addUndefined(str);
            } else if (obj instanceof Integer) {
                v8Object.add(str, ((Integer) obj).intValue());
            } else {
                if (obj instanceof Long) {
                    floatValue = ((Long) obj).longValue();
                } else if (obj instanceof Double) {
                    floatValue = ((Double) obj).doubleValue();
                } else if (!(obj instanceof Float)) {
                    if (obj instanceof String) {
                        v8Object.add(str, (String) obj);
                        return;
                    } else if (obj instanceof Boolean) {
                        v8Object.add(str, ((Boolean) obj).booleanValue());
                        return;
                    } else {
                        if (obj instanceof TypedArray) {
                            v8Array = toV8TypedArray(v8, (TypedArray) obj, map);
                        } else if (obj instanceof ArrayBuffer) {
                            v8Array = toV8ArrayBuffer(v8, (ArrayBuffer) obj, map);
                        } else if (obj instanceof V8Value) {
                            v8Object.add(str, (V8Value) obj);
                            return;
                        } else if (obj instanceof Map) {
                            v8Array = toV8Object(v8, (Map) obj, map);
                        } else if (!(obj instanceof List)) {
                            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
                        } else {
                            v8Array = toV8Array(v8, (List) obj, map);
                        }
                        v8Object.add(str, v8Array);
                        return;
                    }
                } else {
                    floatValue = ((Float) obj).floatValue();
                }
                v8Object.add(str, floatValue);
            }
        }
    }

    public static List<? super Object> toList(V8Array v8Array) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, v8Array)) == null) ? toList(v8Array, DEFAULT_TYPE_ADAPTER) : (List) invokeL.objValue;
    }

    public static List<? super Object> toList(V8Array v8Array, TypeAdapter typeAdapter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, v8Array, typeAdapter)) == null) {
            V8Map v8Map = new V8Map();
            try {
                return toList(v8Array, v8Map, typeAdapter);
            } finally {
                v8Map.close();
            }
        }
        return (List) invokeLL.objValue;
    }

    public static List<? super Object> toList(V8Array v8Array, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, v8Array, v8Map, typeAdapter)) == null) {
            if (v8Array == null) {
                return Collections.emptyList();
            }
            if (v8Map.containsKey(v8Array)) {
                return (List) v8Map.get(v8Array);
            }
            ArrayList arrayList = new ArrayList();
            v8Map.put2((V8Value) v8Array, (V8Array) arrayList);
            for (int i = 0; i < v8Array.length(); i++) {
                Object obj = null;
                try {
                    obj = v8Array.get(i);
                    Object value = getValue(obj, v8Array.getType(i), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        arrayList.add(value);
                    }
                } finally {
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, v8Object)) == null) ? toMap(v8Object, DEFAULT_TYPE_ADAPTER) : (Map) invokeL.objValue;
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, TypeAdapter typeAdapter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, v8Object, typeAdapter)) == null) {
            V8Map v8Map = new V8Map();
            try {
                return toMap(v8Object, v8Map, typeAdapter);
            } finally {
                v8Map.close();
            }
        }
        return (Map) invokeLL.objValue;
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        InterceptResult invokeLLL;
        String[] keys;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, v8Object, v8Map, typeAdapter)) == null) {
            if (v8Object == null) {
                return Collections.emptyMap();
            }
            if (v8Map.containsKey(v8Object)) {
                return (Map) v8Map.get(v8Object);
            }
            V8PropertyMap v8PropertyMap = new V8PropertyMap();
            v8Map.put2((V8Value) v8Object, (V8Object) v8PropertyMap);
            for (String str : v8Object.getKeys()) {
                Object obj = null;
                try {
                    obj = v8Object.get(str);
                    Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        v8PropertyMap.put((V8PropertyMap) str, (String) value);
                    }
                } finally {
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                }
            }
            return v8PropertyMap;
        }
        return (Map) invokeLLL.objValue;
    }

    public static V8Array toV8Array(V8 v8, List<? extends Object> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, v8, list)) == null) {
            Hashtable hashtable = new Hashtable();
            try {
                return toV8Array(v8, list, hashtable).twin();
            } finally {
                for (V8Value v8Value : hashtable.values()) {
                    v8Value.close();
                }
            }
        }
        return (V8Array) invokeLL.objValue;
    }

    public static V8Array toV8Array(V8 v8, List<? extends Object> list, Map<Object, V8Value> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65559, null, v8, list, map)) == null) {
            if (map.containsKey(new ListWrapper(list))) {
                return (V8Array) map.get(new ListWrapper(list));
            }
            V8Array v8Array = new V8Array(v8);
            map.put(new ListWrapper(list), v8Array);
            for (int i = 0; i < list.size(); i++) {
                try {
                    pushValue(v8, v8Array, list.get(i), map);
                } catch (IllegalStateException e2) {
                    v8Array.close();
                    throw e2;
                }
            }
            return v8Array;
        }
        return (V8Array) invokeLLL.objValue;
    }

    public static V8ArrayBuffer toV8ArrayBuffer(V8 v8, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65560, null, v8, arrayBuffer, map)) == null) {
            if (map.containsKey(arrayBuffer)) {
                return (V8ArrayBuffer) map.get(arrayBuffer);
            }
            V8ArrayBuffer v8ArrayBuffer = arrayBuffer.getV8ArrayBuffer();
            map.put(arrayBuffer, v8ArrayBuffer);
            return v8ArrayBuffer;
        }
        return (V8ArrayBuffer) invokeLLL.objValue;
    }

    public static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, v8, map)) == null) {
            Hashtable hashtable = new Hashtable();
            try {
                return toV8Object(v8, map, hashtable).twin();
            } finally {
                for (V8Value v8Value : hashtable.values()) {
                    v8Value.close();
                }
            }
        }
        return (V8Object) invokeLL.objValue;
    }

    public static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65562, null, v8, map, map2)) == null) {
            if (map2.containsKey(map)) {
                return (V8Object) map2.get(map);
            }
            V8Object v8Object = new V8Object(v8);
            map2.put(map, v8Object);
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    setValue(v8, v8Object, entry.getKey(), entry.getValue(), map2);
                }
                return v8Object;
            } catch (IllegalStateException e2) {
                v8Object.close();
                throw e2;
            }
        }
        return (V8Object) invokeLLL.objValue;
    }

    public static V8TypedArray toV8TypedArray(V8 v8, TypedArray typedArray, Map<Object, V8Value> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, v8, typedArray, map)) == null) {
            if (map.containsKey(typedArray)) {
                return (V8TypedArray) map.get(typedArray);
            }
            V8TypedArray v8TypedArray = typedArray.getV8TypedArray();
            map.put(typedArray, v8TypedArray);
            return v8TypedArray;
        }
        return (V8TypedArray) invokeLLL.objValue;
    }
}
