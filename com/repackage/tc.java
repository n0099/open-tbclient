package com.repackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes7.dex */
public class tc implements vc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle a;

    public tc(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bundle;
    }

    @Override // com.repackage.vc
    public void a(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            if (obj instanceof Boolean) {
                this.a.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                this.a.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof Short) {
                this.a.putShort(str, ((Short) obj).shortValue());
            } else if (obj instanceof Integer) {
                this.a.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Character) {
                this.a.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Long) {
                this.a.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                this.a.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                this.a.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                this.a.putString(str, (String) obj);
            } else if (obj instanceof Bundle) {
                this.a.putBundle(str, (Bundle) obj);
            } else if (obj instanceof ArrayList) {
                ArrayList<String> arrayList = (ArrayList) obj;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                String str2 = arrayList.get(0);
                if (str2 instanceof String) {
                    this.a.putStringArrayList(str, arrayList);
                } else if (str2 instanceof Integer) {
                    this.a.putIntegerArrayList(str, arrayList);
                } else if (str2 instanceof Parcelable) {
                    this.a.putParcelableArrayList(str, arrayList);
                }
            } else if (obj instanceof SparseArray) {
                this.a.putSparseParcelableArray(str, (SparseArray) obj);
            } else if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    this.a.putBooleanArray(str, (boolean[]) obj);
                } else if (componentType == Byte.TYPE) {
                    this.a.putByteArray(str, (byte[]) obj);
                } else if (componentType == Character.TYPE) {
                    this.a.putCharArray(str, (char[]) obj);
                } else if (componentType == Double.TYPE) {
                    this.a.putDoubleArray(str, (double[]) obj);
                } else if (componentType == Float.TYPE) {
                    this.a.putFloatArray(str, (float[]) obj);
                } else if (componentType == Integer.TYPE) {
                    this.a.putIntArray(str, (int[]) obj);
                } else if (componentType == Long.TYPE) {
                    this.a.putLongArray(str, (long[]) obj);
                } else if (componentType == Short.TYPE) {
                    this.a.putShortArray(str, (short[]) obj);
                } else if (componentType == String.class) {
                    this.a.putStringArray(str, (String[]) obj);
                } else if (yb.e(componentType, Parcelable.class)) {
                    this.a.putParcelableArray(str, (Parcelable[]) obj);
                }
            } else if (obj instanceof CharSequence) {
                this.a.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof IBinder) {
            } else {
                if (obj instanceof Parcelable) {
                    this.a.putParcelable(str, (Parcelable) obj);
                } else if (obj instanceof Serializable) {
                    this.a.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    @Override // com.repackage.vc
    public Object b(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, type)) == null) {
            Object c = c(str);
            if (c != null) {
                yd ydVar = new yd(type);
                id a = ce.a(c);
                if (a != null) {
                    return a.a(ydVar);
                }
                return null;
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public Object c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.a.get(str) : invokeL.objValue;
    }

    @Override // com.repackage.vc
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.keySet() : (Set) invokeV.objValue;
    }
}
