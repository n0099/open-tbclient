package com.google.android.gms.common.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes7.dex */
public final class ArrayUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ArrayUtils() {
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

    public static Object[] concat(Object[]... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, objArr)) == null) {
            if (objArr.length != 0) {
                int i = 0;
                for (Object[] objArr2 : objArr) {
                    i += objArr2.length;
                }
                Object[] copyOf = Arrays.copyOf(objArr[0], i);
                int length = objArr[0].length;
                for (int i2 = 1; i2 < objArr.length; i2++) {
                    Object[] objArr3 = objArr[i2];
                    int length2 = objArr3.length;
                    System.arraycopy(objArr3, 0, copyOf, length, length2);
                    length += length2;
                }
                return copyOf;
            }
            return (Object[]) Array.newInstance(objArr.getClass(), 0);
        }
        return (Object[]) invokeL.objValue;
    }

    public static byte[] concatByteArrays(byte[]... bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr.length != 0) {
                int i = 0;
                for (byte[] bArr2 : bArr) {
                    i += bArr2.length;
                }
                byte[] copyOf = Arrays.copyOf(bArr[0], i);
                int length = bArr[0].length;
                for (int i2 = 1; i2 < bArr.length; i2++) {
                    byte[] bArr3 = bArr[i2];
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, copyOf, length, length2);
                    length += length2;
                }
                return copyOf;
            }
            return new byte[0];
        }
        return (byte[]) invokeL.objValue;
    }

    public static int[] toPrimitiveArray(Collection collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, collection)) == null) {
            int i = 0;
            if (collection != null && collection.size() != 0) {
                int[] iArr = new int[collection.size()];
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    iArr[i] = ((Integer) it.next()).intValue();
                    i++;
                }
                return iArr;
            }
            return new int[0];
        }
        return (int[]) invokeL.objValue;
    }

    public static boolean contains(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, iArr, i)) == null) {
            if (iArr == null) {
                return false;
            }
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static void writeArray(StringBuilder sb, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, sb, dArr) == null) {
            int length = dArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Double.toString(dArr[i]));
            }
        }
    }

    public static void writeStringArray(StringBuilder sb, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, sb, strArr) == null) {
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append("\"");
                sb.append(strArr[i]);
                sb.append("\"");
            }
        }
    }

    public static boolean contains(Object[] objArr, Object obj) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, objArr, obj)) == null) {
            if (objArr != null) {
                i = objArr.length;
            } else {
                i = 0;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (Objects.equal(objArr[i2], obj)) {
                    if (i2 >= 0) {
                        return true;
                    }
                } else {
                    i2++;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void writeArray(StringBuilder sb, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, sb, fArr) == null) {
            int length = fArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Float.toString(fArr[i]));
            }
        }
    }

    public static ArrayList newArrayList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new ArrayList();
        }
        return (ArrayList) invokeV.objValue;
    }

    public static Object[] removeAll(Object[] objArr, Object... objArr2) {
        InterceptResult invokeLL;
        int length;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, objArr, objArr2)) == null) {
            if (objArr == null) {
                return null;
            }
            if (objArr2 != null && (length = objArr2.length) != 0) {
                Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr.length);
                if (length == 1) {
                    i = 0;
                    for (Object obj : objArr) {
                        if (!Objects.equal(objArr2[0], obj)) {
                            objArr3[i] = obj;
                            i++;
                        }
                    }
                } else {
                    int i2 = 0;
                    for (Object obj2 : objArr) {
                        if (!contains(objArr2, obj2)) {
                            objArr3[i2] = obj2;
                            i2++;
                        }
                    }
                    i = i2;
                }
                if (objArr3 == null) {
                    return null;
                }
                if (i == objArr3.length) {
                    return objArr3;
                }
                return Arrays.copyOf(objArr3, i);
            }
            return Arrays.copyOf(objArr, objArr.length);
        }
        return (Object[]) invokeLL.objValue;
    }

    public static ArrayList toArrayList(Object[] objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, objArr)) == null) {
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj : objArr) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static Integer[] toWrapperArray(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, iArr)) == null) {
            if (iArr == null) {
                return null;
            }
            int length = iArr.length;
            Integer[] numArr = new Integer[length];
            for (int i = 0; i < length; i++) {
                numArr[i] = Integer.valueOf(iArr[i]);
            }
            return numArr;
        }
        return (Integer[]) invokeL.objValue;
    }

    public static void writeArray(StringBuilder sb, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, sb, iArr) == null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Integer.toString(iArr[i]));
            }
        }
    }

    public static void writeArray(StringBuilder sb, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, sb, jArr) == null) {
            int length = jArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Long.toString(jArr[i]));
            }
        }
    }

    public static void writeArray(StringBuilder sb, Object[] objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, sb, objArr) == null) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(objArr[i]);
            }
        }
    }

    public static void writeArray(StringBuilder sb, boolean[] zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, sb, zArr) == null) {
            int length = zArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    sb.append(",");
                }
                sb.append(Boolean.toString(zArr[i]));
            }
        }
    }
}
