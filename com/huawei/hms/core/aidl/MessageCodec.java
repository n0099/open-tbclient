package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MessageCodec {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_NULL = -1;
    public static final String VAL_TYPE = "_val_type_";
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

    private Bundle a(String str, Bundle bundle, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, bundle, obj)) == null) {
            Bundle bundle2 = new Bundle();
            writeValue(str, obj, bundle2);
            bundle.putBundle("_next_item_", bundle2);
            return bundle2;
        }
        return (Bundle) invokeLLL.objValue;
    }

    private void b(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, this, iMessageEntity, field, bundle) == null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            writeValue(field.getName(), field.get(iMessageEntity), bundle);
            field.setAccessible(isAccessible);
        }
    }

    private Object a(Field field, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, field, bundle)) == null) {
            String name = field.getName();
            Object obj = bundle.get(name);
            if (obj instanceof Bundle) {
                try {
                    Bundle bundle2 = (Bundle) obj;
                    int i = bundle2.getInt("_val_type_", -1);
                    if (i == 1) {
                        return readList(field.getGenericType(), bundle2);
                    }
                    if (i == 0) {
                        return decode((Bundle) obj, (IMessageEntity) field.getType().newInstance());
                    }
                } catch (Exception unused) {
                    Log.e(com.hihonor.push.framework.aidl.MessageCodec.TAG, "decode, read value of the field exception, field name: " + name);
                    return null;
                }
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public IMessageEntity decode(Bundle bundle, IMessageEntity iMessageEntity) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bundle, iMessageEntity)) == null) {
            if (bundle == null) {
                return iMessageEntity;
            }
            bundle.setClassLoader(getClass().getClassLoader());
            for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            a(iMessageEntity, field, bundle);
                        } catch (IllegalAccessException | IllegalArgumentException unused) {
                            Log.e(com.hihonor.push.framework.aidl.MessageCodec.TAG, "decode, set value of the field exception, field name:" + field.getName());
                        }
                    }
                }
            }
            return iMessageEntity;
        }
        return (IMessageEntity) invokeLL.objValue;
    }

    public Bundle encode(IMessageEntity iMessageEntity, Bundle bundle) {
        InterceptResult invokeLL;
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iMessageEntity, bundle)) == null) {
            for (Class<?> cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Packed.class)) {
                        try {
                            b(iMessageEntity, field, bundle);
                        } catch (IllegalAccessException | IllegalArgumentException unused) {
                            Log.e(com.hihonor.push.framework.aidl.MessageCodec.TAG, "encode, get value of the field exception, field name: " + field.getName());
                        }
                    }
                }
            }
            return bundle;
        }
        return (Bundle) invokeLL.objValue;
    }

    private void a(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        Object a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, this, iMessageEntity, field, bundle) == null) && (a = a(field, bundle)) != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, a);
            field.setAccessible(isAccessible);
        }
    }

    private boolean a(String str, Object obj, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, obj, bundle)) == null) {
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

    public void writeValue(String str, Object obj, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048580, this, str, obj, bundle) != null) || obj == null || a(str, obj, bundle)) {
            return;
        }
        if (obj instanceof CharSequence) {
            bundle.putCharSequence(str, (CharSequence) obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str, (Parcelable) obj);
        } else if (obj instanceof byte[]) {
            bundle.putByteArray(str, (byte[]) obj);
        } else if (obj instanceof List) {
            writeList(str, (List) obj, bundle);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str, (Serializable) obj);
        } else if (obj instanceof IMessageEntity) {
            Bundle encode = encode((IMessageEntity) obj, new Bundle());
            encode.putInt("_val_type_", 0);
            bundle.putBundle(str, encode);
        } else {
            Log.e(com.hihonor.push.framework.aidl.MessageCodec.TAG, "cannot support type, " + str);
        }
    }

    public List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, type, bundle)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle2 = bundle.getBundle("_next_item_"); bundle2 != null; bundle2 = bundle2.getBundle("_next_item_")) {
                Object obj = bundle2.get("_value_");
                if (!obj.getClass().isPrimitive() && !(obj instanceof String) && !(obj instanceof Serializable)) {
                    if (obj instanceof Bundle) {
                        Bundle bundle3 = (Bundle) obj;
                        int i = bundle3.getInt("_val_type_", -1);
                        if (i != 1) {
                            if (i == 0) {
                                arrayList.add(decode(bundle3, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                            } else {
                                throw new InstantiationException("Unknown type can not be supported");
                            }
                        } else {
                            throw new InstantiationException("Nested List can not be supported");
                        }
                    } else {
                        continue;
                    }
                } else {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void writeList(String str, List list, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, list, bundle) == null) {
            Bundle bundle2 = null;
            for (Object obj : list) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle.putBundle(str, bundle2);
                    bundle2.putInt("_val_type_", 1);
                }
                bundle2 = a("_value_", bundle2, obj);
            }
        }
    }
}
