package d.a.c.e.b.b.a.c;

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
/* loaded from: classes8.dex */
public class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Bundle f44032a;

    public a(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44032a = bundle;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44032a.keySet() : (Set) invokeV.objValue;
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (obj instanceof Boolean) {
                this.f44032a.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                this.f44032a.putByte(str, ((Byte) obj).byteValue());
            } else if (obj instanceof Short) {
                this.f44032a.putShort(str, ((Short) obj).shortValue());
            } else if (obj instanceof Integer) {
                this.f44032a.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Character) {
                this.f44032a.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Long) {
                this.f44032a.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Float) {
                this.f44032a.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Double) {
                this.f44032a.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                this.f44032a.putString(str, (String) obj);
            } else if (obj instanceof Bundle) {
                this.f44032a.putBundle(str, (Bundle) obj);
            } else if (obj instanceof ArrayList) {
                ArrayList<String> arrayList = (ArrayList) obj;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                String str2 = arrayList.get(0);
                if (str2 instanceof String) {
                    this.f44032a.putStringArrayList(str, arrayList);
                } else if (str2 instanceof Integer) {
                    this.f44032a.putIntegerArrayList(str, arrayList);
                } else if (str2 instanceof Parcelable) {
                    this.f44032a.putParcelableArrayList(str, arrayList);
                }
            } else if (obj instanceof SparseArray) {
                this.f44032a.putSparseParcelableArray(str, (SparseArray) obj);
            } else if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                if (componentType == Boolean.TYPE) {
                    this.f44032a.putBooleanArray(str, (boolean[]) obj);
                } else if (componentType == Byte.TYPE) {
                    this.f44032a.putByteArray(str, (byte[]) obj);
                } else if (componentType == Character.TYPE) {
                    this.f44032a.putCharArray(str, (char[]) obj);
                } else if (componentType == Double.TYPE) {
                    this.f44032a.putDoubleArray(str, (double[]) obj);
                } else if (componentType == Float.TYPE) {
                    this.f44032a.putFloatArray(str, (float[]) obj);
                } else if (componentType == Integer.TYPE) {
                    this.f44032a.putIntArray(str, (int[]) obj);
                } else if (componentType == Long.TYPE) {
                    this.f44032a.putLongArray(str, (long[]) obj);
                } else if (componentType == Short.TYPE) {
                    this.f44032a.putShortArray(str, (short[]) obj);
                } else if (componentType == String.class) {
                    this.f44032a.putStringArray(str, (String[]) obj);
                } else if (d.a.c.e.b.a.a.e(componentType, Parcelable.class)) {
                    this.f44032a.putParcelableArray(str, (Parcelable[]) obj);
                }
            } else if (obj instanceof CharSequence) {
                this.f44032a.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof IBinder) {
            } else {
                if (obj instanceof Parcelable) {
                    this.f44032a.putParcelable(str, (Parcelable) obj);
                } else if (obj instanceof Serializable) {
                    this.f44032a.putSerializable(str, (Serializable) obj);
                }
            }
        }
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object d2 = d(str);
            if (d2 != null) {
                d.a.c.e.b.b.a.e.c cVar = new d.a.c.e.b.b.a.e.c(type);
                d.a.c.e.b.b.a.d.h a2 = d.a.c.e.b.b.a.e.g.a(d2);
                if (a2 != null) {
                    return a2.a(cVar);
                }
                return null;
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public Object d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.f44032a.get(str) : invokeL.objValue;
    }
}
