package d.a.c.b.a;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f40891a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2063786982, "Ld/a/c/b/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2063786982, "Ld/a/c/b/a/a;");
        }
    }

    public static String a(String str, Object obj, List list) {
        InterceptResult invokeLLL;
        int i2;
        Map map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, obj, list)) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            if (obj == null) {
                stringBuffer.append(str + "[] = null\n");
                return stringBuffer.toString();
            }
            int i3 = 0;
            if (obj.getClass().isArray()) {
                if (Array.getLength(obj) <= 0) {
                    stringBuffer.append(str + "[] = empty\n");
                } else if (!f(Array.get(obj, 0))) {
                    stringBuffer.append(str + " = [");
                    while (i3 < Array.getLength(obj) - 1) {
                        Object c2 = c(Array.get(obj, i3));
                        stringBuffer.append(c2 + ",");
                        i3++;
                    }
                    stringBuffer.append(Array.get(obj, Array.getLength(obj) - 1) + "]\n");
                } else {
                    while (i3 < Array.getLength(obj)) {
                        Object obj2 = Array.get(obj, i3);
                        stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + i3 + PreferencesUtil.RIGHT_MOUNT, obj2, list));
                        i3++;
                    }
                }
            } else {
                boolean z = obj instanceof Collection;
                boolean z2 = obj instanceof HashSet;
                boolean z3 = obj instanceof SparseArray;
                if ((obj instanceof AbstractMap) || (obj instanceof HashMap) || (obj instanceof Hashtable)) {
                    Map map2 = (Map) obj;
                    Set keySet = map2.keySet();
                    int size = keySet.size();
                    if (size > 0) {
                        int i4 = 0;
                        for (Object obj3 : keySet) {
                            Object obj4 = map2.get(obj3);
                            Object c3 = c(obj3);
                            Object c4 = c(obj4);
                            if (f(c4) || f(c3)) {
                                map = map2;
                                stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + c3 + PreferencesUtil.RIGHT_MOUNT, c4, list));
                            } else if (i4 == 0) {
                                stringBuffer.append(str + " = [");
                                map = map2;
                            } else {
                                map = map2;
                                if (i4 == size - 1) {
                                    stringBuffer.append(c3 + " = " + c4 + "]\n");
                                } else {
                                    stringBuffer.append(c3 + " = " + c4 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                                }
                            }
                            i4++;
                            map2 = map;
                        }
                    } else {
                        stringBuffer.append(str + "[] = empty\n");
                    }
                } else if (z || z2) {
                    Iterator it = null;
                    if (z) {
                        Collection collection = (Collection) obj;
                        it = collection.iterator();
                        i2 = collection.size();
                    } else if (z2) {
                        HashSet hashSet = (HashSet) obj;
                        it = hashSet.iterator();
                        i2 = hashSet.size();
                    } else {
                        i2 = 0;
                    }
                    if (i2 > 0) {
                        int i5 = 0;
                        while (it.hasNext()) {
                            Object c5 = c(it.next());
                            if (f(c5)) {
                                stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + i5 + PreferencesUtil.RIGHT_MOUNT, c5, list));
                            } else if (i5 == 0) {
                                stringBuffer.append(str + " = [");
                            } else if (i5 == i2 - 1) {
                                stringBuffer.append(c5 + "]\n");
                            } else {
                                stringBuffer.append(c5 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                            }
                            i5++;
                        }
                    } else {
                        stringBuffer.append(str + "[] = empty\n");
                    }
                } else if (z3) {
                    SparseArray sparseArray = (SparseArray) obj;
                    int size2 = sparseArray.size();
                    if (size2 > 0) {
                        for (int i6 = 0; i6 < size2; i6++) {
                            Integer valueOf = Integer.valueOf(sparseArray.keyAt(i6));
                            Object valueAt = sparseArray.valueAt(i6);
                            Object c6 = c(valueOf);
                            Object c7 = c(valueAt);
                            if (f(c7) || f(c6)) {
                                stringBuffer.append(k(str + PreferencesUtil.LEFT_MOUNT + c6 + PreferencesUtil.RIGHT_MOUNT, c7, list));
                            } else if (i6 == 0) {
                                stringBuffer.append(str + " = [");
                            } else if (i6 == size2 - 1) {
                                stringBuffer.append(c6 + " = " + c7 + "]\n");
                            } else {
                                stringBuffer.append(c6 + " = " + c7 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                            }
                        }
                    } else {
                        stringBuffer.append(str + "[] = empty\n");
                    }
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: IllegalAccessException -> 0x008f, TryCatch #0 {IllegalAccessException -> 0x008f, blocks: (B:5:0x000b, B:8:0x0013, B:11:0x001a, B:14:0x004c, B:16:0x0052, B:18:0x005e, B:19:0x0071, B:20:0x0076, B:12:0x002d), top: B:30:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, Object obj, List list) {
        InterceptResult invokeLLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, obj, list)) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            try {
                cls = obj.getClass();
            } catch (IllegalAccessException e2) {
                stringBuffer.append(e2.toString());
            }
            if (str != null && !str.equals("")) {
                stringBuffer.append(str + " = {\n");
                while (cls != null && g(cls)) {
                    if (cls.getSimpleName().equals("Object")) {
                        f40891a++;
                        i(cls.getDeclaredFields(), obj, stringBuffer, list);
                        f40891a--;
                    }
                    cls = cls.getSuperclass();
                }
                stringBuffer.append(d() + "}\n");
                return stringBuffer.toString();
            }
            stringBuffer.append(d() + cls.getSimpleName() + " = {\n");
            while (cls != null) {
                if (cls.getSimpleName().equals("Object")) {
                }
                cls = cls.getSuperclass();
            }
            stringBuffer.append(d() + "}\n");
            return stringBuffer.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static Object c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj == null || obj.getClass() != String.class) {
                return obj;
            }
            return "\"" + obj + "\"";
        }
        return invokeL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (int i2 = 0; i2 < f40891a; i2++) {
                stringBuffer.append("    ");
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public static boolean e(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj)) == null) ? obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Hashtable) || (obj instanceof HashMap) || (obj instanceof SparseArray) || (obj instanceof HashSet) || (obj instanceof List) || (obj instanceof AbstractMap) : invokeL.booleanValue;
    }

    public static boolean f(Object obj) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) ? (obj == null || (obj instanceof Boolean) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof String) || (cls = obj.getClass()) == Boolean.TYPE || cls == Boolean.class || cls == Short.TYPE || cls == Short.class || cls == Byte.TYPE || cls == Byte.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Character.TYPE || cls == Character.class || cls == Double.TYPE || cls == Double.class || cls == String.class) ? false : true : invokeL.booleanValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean g(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) {
            String[] strArr = {"activity", "content", "listener", "view", "drawable"};
            for (int i2 = 0; i2 < 5; i2++) {
                if (cls.getSimpleName().toLowerCase().endsWith(strArr[i2])) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void h(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, obj) == null) {
            StringBuffer stringBuffer = new StringBuffer("");
            if (c.f40893a) {
                stringBuffer.append("Message_Type: " + str + "\n");
                stringBuffer.append(j("", obj));
                stringBuffer.append("----------------------------------------------------------\n");
                String[] split = stringBuffer.toString().split("\n");
                for (String str2 : split) {
                    BdLog.i(str2);
                }
            }
        }
    }

    public static void i(Field[] fieldArr, Object obj, StringBuffer stringBuffer, List list) throws IllegalAccessException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, fieldArr, obj, stringBuffer, list) == null) {
            for (int i2 = 0; i2 < fieldArr.length; i2++) {
                fieldArr[i2].setAccessible(true);
                if (!Modifier.isStatic(fieldArr[i2].getModifiers())) {
                    stringBuffer.append(k(d() + fieldArr[i2].getName(), fieldArr[i2].get(obj), list));
                }
            }
        }
    }

    public static String j(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, obj)) == null) {
            if (obj == null) {
                return str + ": null\n";
            } else if (e(obj)) {
                return a(str, obj, new ArrayList());
            } else {
                if (f(obj)) {
                    return b(str, obj, new ArrayList());
                }
                return str + " = " + obj.toString() + "\n\r";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String k(String str, Object obj, List list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, obj, list)) == null) {
            if (obj == null) {
                return str + " = null\n";
            } else if (e(obj)) {
                return a(str, obj, list);
            } else {
                if (f(obj)) {
                    if (!list.contains(obj)) {
                        list.add(obj);
                        return b(str, obj, list);
                    }
                    return str + " = <already visited>\n";
                }
                return str + " = " + c(obj) + "\n";
            }
        }
        return (String) invokeLLL.objValue;
    }
}
