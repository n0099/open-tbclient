package e.a.q;
/* loaded from: classes7.dex */
public class b {
    public static void a(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                sb.append('\t');
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public static String b(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    char c2 = 0;
                    boolean z = false;
                    int i2 = 0;
                    while (i < str.length()) {
                        char charAt = str.charAt(i);
                        if (charAt == '\"') {
                            if (c2 != '\\') {
                                z = !z;
                            }
                            sb.append(charAt);
                        } else if (charAt != ',') {
                            if (charAt != '[') {
                                if (charAt != ']') {
                                    if (charAt != '{') {
                                        if (charAt != '}') {
                                            sb.append(charAt);
                                        }
                                    }
                                }
                                if (!z) {
                                    sb.append('\n');
                                    i2--;
                                    a(sb, i2);
                                }
                                sb.append(charAt);
                            }
                            sb.append(charAt);
                            if (!z) {
                                sb.append('\n');
                                i2++;
                                a(sb, i2);
                            }
                        } else {
                            sb.append(charAt);
                            if (c2 != '\\' && !z) {
                                sb.append('\n');
                                a(sb, i2);
                            }
                        }
                        i++;
                        c2 = charAt;
                    }
                    return sb.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return "";
    }
}
