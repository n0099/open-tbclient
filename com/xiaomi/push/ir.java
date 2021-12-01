package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
/* loaded from: classes3.dex */
public final class ir {
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(is isVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
                if (obj == null && obj2 == null) {
                    return 0;
                }
                if (obj == null) {
                    return -1;
                }
                if (obj2 == null) {
                    return 1;
                }
                return obj instanceof List ? ir.a((List) obj, (List) obj2) : obj instanceof Set ? ir.a((Set) obj, (Set) obj2) : obj instanceof Map ? ir.a((Map) obj, (Map) obj2) : obj instanceof byte[] ? ir.a((byte[]) obj, (byte[]) obj2) : ir.a((Comparable) obj, (Comparable) obj2);
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56371657, "Lcom/xiaomi/push/ir;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56371657, "Lcom/xiaomi/push/ir;");
                return;
            }
        }
        a = new a(null);
    }

    public static int a(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            if (b2 < b3) {
                return -1;
            }
            return b3 < b2 ? 1 : 0;
        }
        return invokeCommon.intValue;
    }

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65538, null, i2, i3)) == null) {
            if (i2 < i3) {
                return -1;
            }
            return i3 < i2 ? 1 : 0;
        }
        return invokeII.intValue;
    }

    public static int a(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (j2 < j3) {
                return -1;
            }
            return j3 < j2 ? 1 : 0;
        }
        return invokeCommon.intValue;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, comparable, comparable2)) == null) ? comparable.compareTo(comparable2) : invokeLL.intValue;
    }

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
    }

    public static int a(ByteBuffer byteBuffer, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, byteBuffer, bArr, i2)) == null) {
            int remaining = byteBuffer.remaining();
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i2, remaining);
            return remaining;
        }
        return invokeLLI.intValue;
    }

    public static int a(List list, List list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, list, list2)) == null) {
            int a2 = a(list.size(), list2.size());
            if (a2 != 0) {
                return a2;
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                int compare = a.compare(list.get(i2), list2.get(i2));
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int a(Map map, Map map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, map, map2)) == null) {
            int a2 = a(map.size(), map2.size());
            if (a2 != 0) {
                return a2;
            }
            TreeMap treeMap = new TreeMap(a);
            treeMap.putAll(map);
            Iterator it = treeMap.entrySet().iterator();
            TreeMap treeMap2 = new TreeMap(a);
            treeMap2.putAll(map2);
            Iterator it2 = treeMap2.entrySet().iterator();
            while (it.hasNext() && it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Map.Entry entry2 = (Map.Entry) it2.next();
                int compare = a.compare(entry.getKey(), entry2.getKey());
                if (compare != 0) {
                    return compare;
                }
                int compare2 = a.compare(entry.getValue(), entry2.getValue());
                if (compare2 != 0) {
                    return compare2;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int a(Set set, Set set2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, set, set2)) == null) {
            int a2 = a(set.size(), set2.size());
            if (a2 != 0) {
                return a2;
            }
            TreeSet treeSet = new TreeSet(a);
            treeSet.addAll(set);
            TreeSet treeSet2 = new TreeSet(a);
            treeSet2.addAll(set2);
            Iterator it = treeSet.iterator();
            Iterator it2 = treeSet2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int compare = a.compare(it.next(), it2.next());
                if (compare != 0) {
                    return compare;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static int a(short s, short s2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{Short.valueOf(s), Short.valueOf(s2)})) == null) {
            if (s < s2) {
                return -1;
            }
            return s2 < s ? 1 : 0;
        }
        return invokeCommon.intValue;
    }

    public static int a(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? Boolean.valueOf(z).compareTo(Boolean.valueOf(z2)) : invokeCommon.intValue;
    }

    public static int a(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, bArr, bArr2)) == null) {
            int a2 = a(bArr.length, bArr2.length);
            if (a2 != 0) {
                return a2;
            }
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int a3 = a(bArr[i2], bArr2[i2]);
                if (a3 != 0) {
                    return a3;
                }
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public static String a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65549, null, b2)) == null) ? Integer.toHexString((b2 | 256) & 511).toUpperCase().substring(1) : (String) invokeB.objValue;
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, byteBuffer)) == null) ? m566a(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m567a(byteBuffer)) : (ByteBuffer) invokeL.objValue;
    }

    public static void a(ByteBuffer byteBuffer, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, byteBuffer, sb) == null) {
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset();
            int limit = byteBuffer.limit();
            int i2 = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
            for (int i3 = arrayOffset; i3 < i2; i3++) {
                if (i3 > arrayOffset) {
                    sb.append(" ");
                }
                sb.append(a(array[i3]));
            }
            if (limit != i2) {
                sb.append("...");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m566a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, byteBuffer)) == null) ? byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity() : invokeL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m567a(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, byteBuffer)) == null) {
            if (m566a(byteBuffer)) {
                return byteBuffer.array();
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            a(byteBuffer, bArr, 0);
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }
}
