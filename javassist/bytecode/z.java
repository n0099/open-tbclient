package javassist.bytecode;

import com.baidu.location.BDLocation;
import java.util.Map;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
/* loaded from: classes.dex */
public class z {
    public static String a(String str) {
        return str.replace('.', '/');
    }

    public static String b(String str) {
        return str.replace('/', '.');
    }

    public static String a(javassist.h hVar) {
        return hVar.b() ? b(hVar) : a(hVar.n());
    }

    public static String c(String str) {
        String str2;
        int i = 0;
        char charAt = str.charAt(0);
        int i2 = 0;
        while (charAt == '[') {
            i2++;
            i++;
            charAt = str.charAt(i);
        }
        if (charAt == 'L') {
            int i3 = i + 1;
            i = str.indexOf(59, i);
            str2 = str.substring(i3, i).replace('/', '.');
        } else if (charAt == 'V') {
            str2 = "void";
        } else if (charAt == 'I') {
            str2 = "int";
        } else if (charAt == 'B') {
            str2 = "byte";
        } else if (charAt == 'J') {
            str2 = "long";
        } else if (charAt == 'D') {
            str2 = "double";
        } else if (charAt == 'F') {
            str2 = "float";
        } else if (charAt == 'C') {
            str2 = "char";
        } else if (charAt == 'S') {
            str2 = "short";
        } else if (charAt == 'Z') {
            str2 = "boolean";
        } else {
            throw new RuntimeException("bad descriptor: " + str);
        }
        if (i + 1 != str.length()) {
            throw new RuntimeException("multiple descriptors?: " + str);
        }
        if (i2 != 0) {
            StringBuffer stringBuffer = new StringBuffer(str2);
            int i4 = i2;
            do {
                stringBuffer.append("[]");
                i4--;
            } while (i4 > 0);
            return stringBuffer.toString();
        }
        return str2;
    }

    public static String d(String str) {
        if (str.equals("void")) {
            return "V";
        }
        if (str.equals("int")) {
            return "I";
        }
        if (str.equals("byte")) {
            return "B";
        }
        if (str.equals("long")) {
            return "J";
        }
        if (str.equals("double")) {
            return "D";
        }
        if (str.equals("float")) {
            return "F";
        }
        if (str.equals("char")) {
            return "C";
        }
        if (str.equals("short")) {
            return "S";
        }
        if (str.equals("boolean")) {
            return "Z";
        }
        return "L" + a(str) + ";";
    }

    public static String a(String str, Map map) {
        int indexOf;
        int i;
        int i2 = 0;
        if (map != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i3 = 0;
            while (true) {
                int indexOf2 = str.indexOf(76, i2);
                if (indexOf2 >= 0 && (indexOf = str.indexOf(59, indexOf2)) >= 0) {
                    int i4 = indexOf + 1;
                    String str2 = (String) map.get(str.substring(indexOf2 + 1, indexOf));
                    if (str2 != null) {
                        stringBuffer.append(str.substring(i3, indexOf2));
                        stringBuffer.append('L');
                        stringBuffer.append(str2);
                        stringBuffer.append(';');
                        i = i4;
                    } else {
                        i = i3;
                    }
                    i3 = i;
                    i2 = i4;
                }
            }
            if (i3 != 0) {
                int length = str.length();
                if (i3 < length) {
                    stringBuffer.append(str.substring(i3, length));
                }
                return stringBuffer.toString();
            }
            return str;
        }
        return str;
    }

    public static String b(javassist.h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        a(stringBuffer, hVar);
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, javassist.h hVar) {
        if (hVar.b()) {
            stringBuffer.append('[');
            try {
                a(stringBuffer, hVar.e());
            } catch (NotFoundException e) {
                stringBuffer.append('L');
                String n = hVar.n();
                stringBuffer.append(a(n.substring(0, n.length() - 2)));
                stringBuffer.append(';');
            }
        } else if (hVar.m()) {
            stringBuffer.append(((CtPrimitiveType) hVar).y());
        } else {
            stringBuffer.append('L');
            stringBuffer.append(hVar.n().replace('.', '/'));
            stringBuffer.append(';');
        }
    }

    public static String a(javassist.h[] hVarArr) {
        return a(javassist.h.l, hVarArr);
    }

    public static String a(javassist.h hVar, javassist.h[] hVarArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        if (hVarArr != null) {
            for (javassist.h hVar2 : hVarArr) {
                a(stringBuffer, hVar2);
            }
        }
        stringBuffer.append(')');
        if (hVar != null) {
            a(stringBuffer, hVar);
        }
        return stringBuffer.toString();
    }

    public static String b(javassist.h[] hVarArr) {
        return a((javassist.h) null, hVarArr);
    }

    public static String a(String str, String str2) {
        int indexOf = str2.indexOf(41);
        if (indexOf >= 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2.substring(0, indexOf));
            stringBuffer.append('L');
            stringBuffer.append(str.replace('.', '/'));
            stringBuffer.append(';');
            stringBuffer.append(str2.substring(indexOf));
            return stringBuffer.toString();
        }
        return str2;
    }

    public static String b(String str, String str2) {
        return str2.charAt(0) != '(' ? str2 : "(L" + str.replace('.', '/') + ';' + str2.substring(1);
    }

    public static String c(String str, String str2) {
        int indexOf = str2.indexOf(41);
        if (indexOf >= 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2.substring(0, indexOf + 1));
            stringBuffer.append('L');
            stringBuffer.append(str.replace('.', '/'));
            stringBuffer.append(';');
            return stringBuffer.toString();
        }
        return str2;
    }

    public static javassist.h[] a(String str, javassist.c cVar) {
        int i = 0;
        if (str.charAt(0) != '(') {
            return null;
        }
        javassist.h[] hVarArr = new javassist.h[f(str)];
        int i2 = 1;
        while (true) {
            int i3 = i + 1;
            i2 = a(cVar, str, i2, hVarArr, i);
            if (i2 <= 0) {
                return hVarArr;
            }
            i = i3;
        }
    }

    public static boolean d(String str, String str2) {
        if (str.charAt(0) != '(') {
            return false;
        }
        int i = 0;
        while (true) {
            char charAt = str.charAt(i);
            if (charAt != str2.charAt(i)) {
                return false;
            }
            if (charAt != ')') {
                i++;
            } else {
                return true;
            }
        }
    }

    public static String e(String str) {
        return str.substring(0, str.indexOf(41) + 1);
    }

    public static javassist.h b(String str, javassist.c cVar) {
        int indexOf = str.indexOf(41);
        if (indexOf < 0) {
            return null;
        }
        javassist.h[] hVarArr = new javassist.h[1];
        a(cVar, str, indexOf + 1, hVarArr, 0);
        return hVarArr[0];
    }

    public static int f(String str) {
        int i = 0;
        int i2 = 1;
        while (true) {
            char charAt = str.charAt(i2);
            if (charAt != ')') {
                int i3 = i2;
                char c = charAt;
                while (c == '[') {
                    i3++;
                    c = str.charAt(i3);
                }
                if (c == 'L') {
                    i2 = str.indexOf(59, i3) + 1;
                    if (i2 <= 0) {
                        throw new IndexOutOfBoundsException("bad descriptor");
                    }
                } else {
                    i2 = i3 + 1;
                }
                i++;
            } else {
                return i;
            }
        }
    }

    public static javassist.h c(String str, javassist.c cVar) {
        javassist.h[] hVarArr = new javassist.h[1];
        return a(cVar, str, 0, hVarArr, 0) >= 0 ? hVarArr[0] : cVar.c(str.replace('/', '.'));
    }

    private static int a(javassist.c cVar, String str, int i, javassist.h[] hVarArr, int i2) {
        int i3;
        String str2;
        int i4 = 0;
        char charAt = str.charAt(i);
        while (charAt == '[') {
            i4++;
            i++;
            charAt = str.charAt(i);
        }
        if (charAt == 'L') {
            int i5 = i + 1;
            int indexOf = str.indexOf(59, i5);
            i3 = indexOf + 1;
            str2 = str.substring(i5, indexOf).replace('/', '.');
        } else {
            javassist.h a2 = a(charAt);
            if (a2 == null) {
                return -1;
            }
            int i6 = i + 1;
            if (i4 == 0) {
                hVarArr[i2] = a2;
                return i6;
            }
            String n = a2.n();
            i3 = i6;
            str2 = n;
        }
        if (i4 > 0) {
            StringBuffer stringBuffer = new StringBuffer(str2);
            while (true) {
                int i7 = i4;
                i4 = i7 - 1;
                if (i7 <= 0) {
                    break;
                }
                stringBuffer.append("[]");
            }
            str2 = stringBuffer.toString();
        }
        hVarArr[i2] = cVar.c(str2);
        return i3;
    }

    static javassist.h a(char c) {
        switch (c) {
            case BDLocation.TypeOffLineLocation /* 66 */:
                return javassist.h.f;
            case BDLocation.TypeOffLineLocationFail /* 67 */:
                return javassist.h.e;
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
                return javassist.h.k;
            case 'F':
                return javassist.h.j;
            case 'I':
                return javassist.h.h;
            case 'J':
                return javassist.h.i;
            case 'S':
                return javassist.h.g;
            case 'V':
                return javassist.h.l;
            case 'Z':
                return javassist.h.d;
            default:
                return null;
        }
    }

    public static int g(String str) {
        return a(str, true);
    }

    public static int h(String str) {
        return -a(str, false);
    }

    private static int a(String str, boolean z) {
        char c;
        int i;
        char charAt = str.charAt(0);
        if (charAt == '(') {
            int i2 = 1;
            int i3 = 0;
            while (true) {
                char charAt2 = str.charAt(i2);
                if (charAt2 == ')') {
                    c = str.charAt(i2 + 1);
                    i = i3;
                    break;
                }
                char c2 = charAt2;
                boolean z2 = false;
                while (c2 == '[') {
                    i2++;
                    c2 = str.charAt(i2);
                    z2 = true;
                }
                if (c2 == 'L') {
                    i2 = str.indexOf(59, i2) + 1;
                    if (i2 <= 0) {
                        throw new IndexOutOfBoundsException("bad descriptor");
                    }
                } else {
                    i2++;
                }
                if (!z2 && (c2 == 'J' || c2 == 'D')) {
                    i3 -= 2;
                } else {
                    i3--;
                }
            }
        } else {
            c = charAt;
            i = 0;
        }
        if (z) {
            if (c == 'J' || c == 'D') {
                return i + 2;
            }
            if (c != 'V') {
                return i + 1;
            }
            return i;
        }
        return i;
    }
}
