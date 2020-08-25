package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes10.dex */
class h {
    static h oAA = new h();
    static h oAB;
    static h oAC;
    boolean oAr = true;
    boolean oAs = true;
    boolean oAt = false;
    boolean oAu = false;
    boolean oAv = false;
    boolean oAw = true;
    boolean oAx = true;
    boolean oAy = true;
    int oAz;

    h() {
    }

    static {
        oAA.oAr = true;
        oAA.oAs = false;
        oAA.oAt = false;
        oAA.oAu = false;
        oAA.oAv = true;
        oAA.oAw = false;
        oAA.oAx = false;
        oAA.oAz = 0;
        oAB = new h();
        oAB.oAr = true;
        oAB.oAs = true;
        oAB.oAt = false;
        oAB.oAu = false;
        oAB.oAv = false;
        oAA.oAz = 1;
        oAC = new h();
        oAC.oAr = false;
        oAC.oAs = true;
        oAC.oAt = false;
        oAC.oAu = true;
        oAC.oAv = false;
        oAC.oAy = false;
        oAC.oAz = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Wq(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Ol(int i) {
        if (this.oAu) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String Wr(String str) {
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
            return Wr(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.oAr);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.oAv);
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
            if (!this.oAs) {
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
        if (this.oAt && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
