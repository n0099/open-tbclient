package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h imY = new h();
    static h imZ;
    static h ina;
    boolean imP = true;
    boolean imQ = true;
    boolean imR = false;
    boolean imS = false;
    boolean imT = false;
    boolean imU = true;
    boolean imV = true;
    boolean imW = true;
    int imX;

    h() {
    }

    static {
        imY.imP = true;
        imY.imQ = false;
        imY.imR = false;
        imY.imS = false;
        imY.imT = true;
        imY.imU = false;
        imY.imV = false;
        imY.imX = 0;
        imZ = new h();
        imZ.imP = true;
        imZ.imQ = true;
        imZ.imR = false;
        imZ.imS = false;
        imZ.imT = false;
        imY.imX = 1;
        ina = new h();
        ina.imP = false;
        ina.imQ = true;
        ina.imR = false;
        ina.imS = true;
        ina.imT = false;
        ina.imW = false;
        ina.imX = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wZ(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zz(int i) {
        if (this.imS) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String xa(String str) {
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
            return xa(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.imP);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.imT);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(o(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.imQ) {
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
        if (this.imR && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
