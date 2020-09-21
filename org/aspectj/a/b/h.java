package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h oKx = new h();
    static h oKy;
    static h oKz;
    boolean oKo = true;
    boolean oKp = true;
    boolean oKq = false;
    boolean oKr = false;
    boolean oKs = false;
    boolean oKt = true;
    boolean oKu = true;
    boolean oKv = true;
    int oKw;

    h() {
    }

    static {
        oKx.oKo = true;
        oKx.oKp = false;
        oKx.oKq = false;
        oKx.oKr = false;
        oKx.oKs = true;
        oKx.oKt = false;
        oKx.oKu = false;
        oKx.oKw = 0;
        oKy = new h();
        oKy.oKo = true;
        oKy.oKp = true;
        oKy.oKq = false;
        oKy.oKr = false;
        oKy.oKs = false;
        oKx.oKw = 1;
        oKz = new h();
        oKz.oKo = false;
        oKz.oKp = true;
        oKz.oKq = false;
        oKz.oKr = true;
        oKz.oKs = false;
        oKz.oKv = false;
        oKz.oKw = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String WS(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String OQ(int i) {
        if (this.oKr) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String WT(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    String b(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            return new StringBuffer().append(b(componentType, componentType.getName(), z)).append("[]").toString();
        } else if (z) {
            return WT(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.oKo);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.oKs);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(N(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.oKp) {
                if (clsArr.length == 0) {
                    stringBuffer.append("()");
                    return;
                } else {
                    stringBuffer.append("(..)");
                    return;
                }
            }
            stringBuffer.append("(");
            a(stringBuffer, clsArr);
            stringBuffer.append(")");
        }
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        if (this.oKq && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
