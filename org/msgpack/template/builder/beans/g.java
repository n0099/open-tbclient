package org.msgpack.template.builder.beans;

import java.lang.reflect.Method;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class g {
    private static WeakHashMap<Class<?>, Method[]> d = new WeakHashMap<>();
    private static final String[][] e = {new String[]{"java.lang.Class", "new", "java.lang.Boolean", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Byte", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Character", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Double", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Float", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Integer", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Long", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.Short", "", "", ""}, new String[]{"java.lang.Class", "new", "java.lang.String", "", "", ""}, new String[]{"java.lang.Class", "forName", "java.lang.String", "", "", ""}, new String[]{"java.lang.Class", "newInstance", "java.lang.Class", "java.lang.Integer", "", ""}, new String[]{"java.lang.reflect.Field", "get", "null", "", "", ""}, new String[]{"java.lang.Class", "forName", "java.lang.String", "", "", ""}};

    /* renamed from: a  reason: collision with root package name */
    private Object f3113a;
    private String b;
    private Object[] c;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f3113a == null) {
            sb.append("null");
        } else {
            Class<?> cls = this.f3113a.getClass();
            sb.append(cls == String.class ? "\"\"" : org.a.a.a.a.a(cls));
        }
        sb.append(String.valueOf('.') + this.b + '(');
        if (this.c != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.c.length) {
                    break;
                }
                if (i2 > 0) {
                    sb.append(", ");
                }
                if (this.c[i2] == null) {
                    sb.append("null");
                } else {
                    Class<?> cls2 = this.c[i2].getClass();
                    sb.append(cls2 == String.class ? String.valueOf('\"') + ((String) this.c[i2]) + '\"' : org.a.a.a.a.a(cls2));
                }
                i = i2 + 1;
            }
        }
        sb.append(')');
        sb.append(';');
        return sb.toString();
    }
}
