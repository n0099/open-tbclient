package com.hihonor.push.framework.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.framework.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class MessageCodec {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUNDLE_NEXT = "_next_item_";
    public static final String BUNDLE_VALUE = "_value_";
    public static final String PACKED_TYPE = "_packed_type_";
    public static final String TAG = "MessageCodec";
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_NULL = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public MessageCodec() {
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

    public static Bundle formMessageEntity(IMessageEntity iMessageEntity, Bundle bundle) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, iMessageEntity, bundle)) == null) {
            if (iMessageEntity != null && bundle != null) {
                for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        if (field.isAnnotationPresent(Packed.class)) {
                            try {
                                formMessageField(iMessageEntity, field, bundle);
                            } catch (IllegalAccessException | IllegalArgumentException unused) {
                                String str = "encode, get value of the field exception, field name: " + field.getName();
                            }
                        }
                    }
                }
            }
            return bundle;
        }
        return (Bundle) invokeLL.objValue;
    }

    public static void formMessageField(IMessageEntity iMessageEntity, Field field, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, iMessageEntity, field, bundle) == null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            put(field.getName(), field.get(iMessageEntity), bundle);
            field.setAccessible(isAccessible);
        }
    }

    public static Object newInstance(Field field, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, field, bundle)) == null) {
            String name = field.getName();
            Object obj = bundle.get(name);
            if (obj instanceof Bundle) {
                try {
                    Bundle bundle2 = (Bundle) obj;
                    int i = bundle2.getInt(PACKED_TYPE, -1);
                    if (i == 1) {
                        return parseGenericType(field.getGenericType(), bundle2);
                    }
                    if (i == 0) {
                        return parseMessageEntity((Bundle) obj, (IMessageEntity) field.getType().newInstance());
                    }
                } catch (Exception unused) {
                    String str = "decode, read value of the field exception, field name: " + name;
                    return null;
                }
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public static List<Object> parseGenericType(Type type, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, type, bundle)) != null) {
            return (List) invokeLL.objValue;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            bundle = bundle.getBundle("_next_item_");
            if (bundle == null) {
                return arrayList;
            }
            Object obj = bundle.get("_value_");
            if (!obj.getClass().isPrimitive() && !(obj instanceof Serializable)) {
                if (obj instanceof Bundle) {
                    Bundle bundle2 = (Bundle) obj;
                    int i = bundle2.getInt(PACKED_TYPE, -1);
                    if (i == 1) {
                        throw new InstantiationException("Nested List can not be supported");
                    }
                    if (i != 0) {
                        throw new InstantiationException("Unknown type can not be supported");
                    }
                    obj = parseMessageEntity(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance());
                } else {
                    continue;
                }
            }
            arrayList.add(obj);
        }
    }

    public static IMessageEntity parseMessageEntity(Bundle bundle, IMessageEntity iMessageEntity) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bundle, iMessageEntity)) == null) {
            if (bundle != null && iMessageEntity != null) {
                bundle.setClassLoader(iMessageEntity.getClass().getClassLoader());
                for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        if (field.isAnnotationPresent(Packed.class)) {
                            try {
                                parseMessageField(iMessageEntity, field, bundle);
                            } catch (IllegalAccessException | IllegalArgumentException unused) {
                                String str = "decode, set value of the field exception, field name:" + field.getName();
                            }
                        }
                    }
                }
            }
            return iMessageEntity;
        }
        return (IMessageEntity) invokeLL.objValue;
    }

    public static void parseMessageField(IMessageEntity iMessageEntity, Field field, Bundle bundle) {
        Object newInstance;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, iMessageEntity, field, bundle) == null) || (newInstance = newInstance(field, bundle)) == null) {
            return;
        }
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        field.set(iMessageEntity, newInstance);
        field.setAccessible(isAccessible);
    }

    public static void put(String str, Object obj, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65543, null, str, obj, bundle) == null) || obj == null || putGenericType(str, obj, bundle)) {
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof List) {
            putList(str, (List) obj, bundle);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj instanceof IMessageEntity) {
            Bundle formMessageEntity = formMessageEntity((IMessageEntity) obj, new Bundle());
            formMessageEntity.putInt(PACKED_TYPE, 0);
            bundle.putBundle(str, formMessageEntity);
        } else {
            String str2 = "cannot support type, " + str;
        }
    }

    public static boolean putGenericType(String str, Object obj, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, str, obj, bundle)) == null) {
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
                return true;
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
                return true;
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Short) obj).shortValue());
                return true;
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
                return true;
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Float) obj).floatValue());
                return true;
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
                return true;
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
                return true;
            } else {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static void putList(String str, List list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, list, bundle) == null) {
            Bundle bundle2 = null;
            for (Object obj : list) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle.putBundle(str, bundle2);
                    bundle2.putInt(PACKED_TYPE, 1);
                }
                bundle2 = putNext("_value_", bundle2, obj);
            }
        }
    }

    public static Bundle putNext(String str, Bundle bundle, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, str, bundle, obj)) == null) {
            Bundle bundle2 = new Bundle();
            put(str, obj, bundle2);
            bundle.putBundle("_next_item_", bundle2);
            return bundle2;
        }
        return (Bundle) invokeLLL.objValue;
    }
}
