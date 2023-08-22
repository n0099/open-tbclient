package com.huawei.hms.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class JsonUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BYTE_BYTE = "_byte_";
    public static final String LIST_FIELD_VALUE = "_value_";
    public static final String LIST_ITEM_VALUE = "_list_item_";
    public static final String LIST_SIZE = "_list_size_";
    public static final String MAP_MAP = "_map_";
    public static final String NEXT_ITEM = "_next_item_";
    public static final String PRE_PKG = "com.huawei";
    public static final String TAG = "JsonUtil";
    public static final int VAL_BYTE = 2;
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_MAP = 3;
    public static final int VAL_NULL = -1;
    public static final String VAL_TYPE = "_val_type_";
    public transient /* synthetic */ FieldHolder $fh;

    public JsonUtil() {
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

    public static String createInnerJsonString(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        InterceptResult invokeL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iMessageEntity)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        boolean isAccessible = field.isAccessible();
                        setAccessible(field, true);
                        String name = field.getName();
                        Object obj = field.get(iMessageEntity);
                        setAccessible(field, isAccessible);
                        disposeType(name, obj, jSONObject);
                    }
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String createJsonString(IMessageEntity iMessageEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iMessageEntity)) == null) {
            if (iMessageEntity == null) {
                HMSLog.e(TAG, "createJsonString error, the input IMessageEntity is null");
                return "";
            }
            try {
                return createInnerJsonString(iMessageEntity);
            } catch (IllegalAccessException e) {
                HMSLog.e(TAG, "catch IllegalAccessException " + e.getMessage());
                return "";
            } catch (JSONException e2) {
                HMSLog.e(TAG, "catch JSONException " + e2.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean disposeType(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, obj, jSONObject)) == null) {
            if (obj instanceof String) {
                jSONObject.put(str, (String) obj);
                return true;
            } else if (obj instanceof Integer) {
                jSONObject.put(str, ((Integer) obj).intValue());
                return true;
            } else if (obj instanceof Short) {
                jSONObject.put(str, (Short) obj);
                return true;
            } else if (obj instanceof Long) {
                jSONObject.put(str, (Long) obj);
                return true;
            } else if (obj instanceof Float) {
                jSONObject.put(str, (Float) obj);
                return true;
            } else if (obj instanceof Double) {
                jSONObject.put(str, (Double) obj);
                return true;
            } else if (obj instanceof Boolean) {
                jSONObject.put(str, (Boolean) obj);
                return true;
            } else if (obj instanceof JSONObject) {
                jSONObject.put(str, (JSONObject) obj);
                return true;
            } else if (obj instanceof byte[]) {
                writeByte(str, (byte[]) obj, jSONObject);
                return true;
            } else if (obj instanceof List) {
                writeList(str, (List) obj, jSONObject);
                return true;
            } else if (obj instanceof Map) {
                writeMap(str, (Map) obj, jSONObject);
                return true;
            } else {
                if (obj instanceof IMessageEntity) {
                    try {
                        jSONObject.put(str, createInnerJsonString((IMessageEntity) obj));
                        return true;
                    } catch (IllegalAccessException e) {
                        HMSLog.e(TAG, "IllegalAccessException , " + e);
                    }
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Object readJson(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, iMessageEntity, field, jSONObject)) == null) {
            Object objectValue = getObjectValue(field.getName(), jSONObject);
            if (objectValue != null) {
                try {
                    if (field.getType().getName().startsWith(PRE_PKG) && (field.getType().newInstance() instanceof IMessageEntity)) {
                        return jsonToEntity((String) objectValue, (IMessageEntity) field.getType().newInstance());
                    }
                    if ((objectValue instanceof JSONObject) && ((JSONObject) objectValue).has("_val_type_")) {
                        int i = ((JSONObject) objectValue).getInt("_val_type_");
                        if (i != 1 && i != 0) {
                            if (i == 2) {
                                return readByte((JSONObject) objectValue);
                            }
                            if (i == 3) {
                                return readMap(field.getGenericType(), (JSONObject) objectValue);
                            }
                            HMSLog.e(TAG, "cannot support type : " + i);
                        }
                        return readList(field.getGenericType(), (JSONObject) objectValue);
                    }
                    return objectValue;
                } catch (InstantiationException unused) {
                    HMSLog.e(TAG, "InstantiationException  ");
                }
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public static Object getInfoFromJsonobject(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.has(str2)) {
                        return null;
                    }
                    Object obj = jSONObject.get(str2);
                    if (obj instanceof String) {
                        return obj;
                    }
                } catch (JSONException unused) {
                    HMSLog.e(TAG, "getInfoFromJsonobject:parser json error :" + str2);
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object getObjectValue(String str, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, jSONObject)) == null) {
            if (jSONObject.has(str)) {
                return jSONObject.get(str);
            }
            if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
                return jSONObject.getJSONObject("header").get(str);
            }
            if (jSONObject.has("body") && jSONObject.getJSONObject("body").has(str)) {
                return jSONObject.getJSONObject("body").get(str);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, jSONObject, str)) == null) {
            if (jSONObject != null && jSONObject.has(str)) {
                return jSONObject.getInt(str);
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jSONObject, str)) == null) {
            if (jSONObject != null && jSONObject.has(str)) {
                return jSONObject.getString(str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static void setAccessible(Field field, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65550, null, field, z) == null) {
            AccessController.doPrivileged(new PrivilegedAction(field, z) { // from class: com.huawei.hms.utils.JsonUtil.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Field val$field;
                public final /* synthetic */ boolean val$flag;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {field, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$field = field;
                    this.val$flag = z;
                }

                @Override // java.security.PrivilegedAction
                public Object run() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.val$field.setAccessible(this.val$flag);
                        return null;
                    }
                    return invokeV.objValue;
                }
            });
        }
    }

    public static IMessageEntity jsonToEntity(String str, IMessageEntity iMessageEntity) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, iMessageEntity)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        if (field.isAnnotationPresent(Packed.class)) {
                            try {
                                readFiled(iMessageEntity, field, jSONObject);
                            } catch (IllegalAccessException unused) {
                                HMSLog.e(TAG, "jsonToEntity, set value of the field exception, field name:" + field.getName());
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                HMSLog.e(TAG, "catch JSONException when parse jsonString" + e.getMessage());
            }
            return iMessageEntity;
        }
        return (IMessageEntity) invokeLL.objValue;
    }

    public static List<Object> readList(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, type, jSONObject)) == null) {
            int i = jSONObject.getInt(LIST_SIZE);
            int i2 = jSONObject.getInt("_val_type_");
            ArrayList arrayList = new ArrayList(i);
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = jSONObject.get(LIST_ITEM_VALUE + i3);
                if (i2 == 0) {
                    arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                } else if (i2 == 1) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static Map readMap(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, type, jSONObject)) == null) {
            Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
            JSONArray jSONArray = new JSONArray(jSONObject.getString(MAP_MAP));
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i += 2) {
                if (cls.newInstance() instanceof IMessageEntity) {
                    hashMap.put(jSONArray.get(i), jsonToEntity(jSONArray.getString(i + 1), (IMessageEntity) cls.newInstance()));
                } else {
                    hashMap.put(jSONArray.get(i), jSONArray.get(i + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static byte[] readByte(JSONObject jSONObject) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            try {
                return Base64.decode(jSONObject.getString(BYTE_BYTE));
            } catch (IllegalArgumentException e) {
                HMSLog.e(TAG, "readByte failed : " + e.getMessage());
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static void readFiled(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object readJson;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, iMessageEntity, field, jSONObject) == null) && (readJson = readJson(iMessageEntity, field, jSONObject)) != null) {
            boolean isAccessible = field.isAccessible();
            setAccessible(field, true);
            field.set(iMessageEntity, readJson);
            setAccessible(field, isAccessible);
        }
    }

    public static void writeByte(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, str, bArr, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("_val_type_", 2);
            try {
                jSONObject2.put(BYTE_BYTE, Base64.encode(bArr));
            } catch (IllegalArgumentException e) {
                HMSLog.e(TAG, "writeByte failed : " + e.getMessage());
            }
            jSONObject.put(str, jSONObject2);
        }
    }

    public static void writeList(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, str, list, jSONObject) == null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("_val_type_", 1);
            jSONObject2.put(LIST_SIZE, list.size());
            for (int i = 0; i < list.size(); i++) {
                disposeType(LIST_ITEM_VALUE + i, list.get(i), jSONObject2);
                if (list.get(i) instanceof IMessageEntity) {
                    jSONObject2.put("_val_type_", 0);
                }
            }
            jSONObject.put(str, jSONObject2);
        }
    }

    public static void writeMap(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, str, map, jSONObject) == null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof IMessageEntity) {
                    jSONArray.put(createInnerJsonString((IMessageEntity) key));
                } else {
                    jSONArray.put(key);
                }
                if (value instanceof IMessageEntity) {
                    jSONArray.put(createInnerJsonString((IMessageEntity) value));
                } else {
                    jSONArray.put(value);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("_val_type_", 3);
            jSONObject2.put(MAP_MAP, jSONArray.toString());
            jSONObject.put(str, jSONObject2);
        }
    }
}
