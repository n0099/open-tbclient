package d.b.c.b.a;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f41976a;

    public static String a(String str, Object obj, List list) {
        int i;
        Map map;
        StringBuffer stringBuffer = new StringBuffer("");
        if (obj == null) {
            stringBuffer.append(str + "[] = null\n");
            return stringBuffer.toString();
        }
        int i2 = 0;
        if (obj.getClass().isArray()) {
            if (Array.getLength(obj) <= 0) {
                stringBuffer.append(str + "[] = empty\n");
            } else if (!f(Array.get(obj, 0))) {
                stringBuffer.append(str + " = [");
                while (i2 < Array.getLength(obj) - 1) {
                    Object c2 = c(Array.get(obj, i2));
                    stringBuffer.append(c2 + ",");
                    i2++;
                }
                stringBuffer.append(Array.get(obj, Array.getLength(obj) - 1) + "]\n");
            } else {
                while (i2 < Array.getLength(obj)) {
                    Object obj2 = Array.get(obj, i2);
                    stringBuffer.append(k(str + "[" + i2 + "]", obj2, list));
                    i2++;
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
                    int i3 = 0;
                    for (Object obj3 : keySet) {
                        Object obj4 = map2.get(obj3);
                        Object c3 = c(obj3);
                        Object c4 = c(obj4);
                        if (f(c4) || f(c3)) {
                            map = map2;
                            stringBuffer.append(k(str + "[" + c3 + "]", c4, list));
                        } else if (i3 == 0) {
                            stringBuffer.append(str + " = [");
                            map = map2;
                        } else {
                            map = map2;
                            if (i3 == size - 1) {
                                stringBuffer.append(c3 + " = " + c4 + "]\n");
                            } else {
                                stringBuffer.append(c3 + " = " + c4 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                            }
                        }
                        i3++;
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
                    i = collection.size();
                } else if (z2) {
                    HashSet hashSet = (HashSet) obj;
                    it = hashSet.iterator();
                    i = hashSet.size();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    int i4 = 0;
                    while (it.hasNext()) {
                        Object c5 = c(it.next());
                        if (f(c5)) {
                            stringBuffer.append(k(str + "[" + i4 + "]", c5, list));
                        } else if (i4 == 0) {
                            stringBuffer.append(str + " = [");
                        } else if (i4 == i - 1) {
                            stringBuffer.append(c5 + "]\n");
                        } else {
                            stringBuffer.append(c5 + StringUtil.ARRAY_ELEMENT_SEPARATOR);
                        }
                        i4++;
                    }
                } else {
                    stringBuffer.append(str + "[] = empty\n");
                }
            } else if (z3) {
                SparseArray sparseArray = (SparseArray) obj;
                int size2 = sparseArray.size();
                if (size2 > 0) {
                    for (int i5 = 0; i5 < size2; i5++) {
                        Integer valueOf = Integer.valueOf(sparseArray.keyAt(i5));
                        Object valueAt = sparseArray.valueAt(i5);
                        Object c6 = c(valueOf);
                        Object c7 = c(valueAt);
                        if (f(c7) || f(c6)) {
                            stringBuffer.append(k(str + "[" + c6 + "]", c7, list));
                        } else if (i5 == 0) {
                            stringBuffer.append(str + " = [");
                        } else if (i5 == size2 - 1) {
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

    /* JADX WARN: Removed duplicated region for block: B:16:0x005a A[Catch: IllegalAccessException -> 0x008b, TryCatch #0 {IllegalAccessException -> 0x008b, blocks: (B:3:0x0007, B:6:0x000f, B:9:0x0016, B:12:0x0048, B:14:0x004e, B:16:0x005a, B:17:0x006d, B:18:0x0072, B:10:0x0029), top: B:24:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, Object obj, List list) {
        Class<?> cls;
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
                    f41976a++;
                    i(cls.getDeclaredFields(), obj, stringBuffer, list);
                    f41976a--;
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

    public static Object c(Object obj) {
        if (obj == null || obj.getClass() != String.class) {
            return obj;
        }
        return "\"" + obj + "\"";
    }

    public static String d() {
        StringBuffer stringBuffer = new StringBuffer("");
        for (int i = 0; i < f41976a; i++) {
            stringBuffer.append("    ");
        }
        return stringBuffer.toString();
    }

    public static boolean e(Object obj) {
        return obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Hashtable) || (obj instanceof HashMap) || (obj instanceof SparseArray) || (obj instanceof HashSet) || (obj instanceof List) || (obj instanceof AbstractMap);
    }

    public static boolean f(Object obj) {
        Class<?> cls;
        return (obj == null || (obj instanceof Boolean) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof String) || (cls = obj.getClass()) == Boolean.TYPE || cls == Boolean.class || cls == Short.TYPE || cls == Short.class || cls == Byte.TYPE || cls == Byte.class || cls == Integer.TYPE || cls == Integer.class || cls == Long.TYPE || cls == Long.class || cls == Float.TYPE || cls == Float.class || cls == Character.TYPE || cls == Character.class || cls == Double.TYPE || cls == Double.class || cls == String.class) ? false : true;
    }

    @SuppressLint({"DefaultLocale"})
    public static boolean g(Class<?> cls) {
        String[] strArr = {"activity", "content", "listener", "view", "drawable"};
        for (int i = 0; i < 5; i++) {
            if (cls.getSimpleName().toLowerCase().endsWith(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void h(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer("");
        if (c.f41978a) {
            stringBuffer.append("Message_Type: " + str + "\n");
            stringBuffer.append(j("", obj));
            stringBuffer.append("----------------------------------------------------------\n");
            String[] split = stringBuffer.toString().split("\n");
            for (String str2 : split) {
                BdLog.i(str2);
            }
        }
    }

    public static void i(Field[] fieldArr, Object obj, StringBuffer stringBuffer, List list) throws IllegalAccessException {
        for (int i = 0; i < fieldArr.length; i++) {
            fieldArr[i].setAccessible(true);
            if (!Modifier.isStatic(fieldArr[i].getModifiers())) {
                stringBuffer.append(k(d() + fieldArr[i].getName(), fieldArr[i].get(obj), list));
            }
        }
    }

    public static String j(String str, Object obj) {
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

    public static String k(String str, Object obj, List list) {
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
}
