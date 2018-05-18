package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h hAC = new h();
    static h hAD;
    static h hAE;
    int hAB;
    boolean hAt = true;
    boolean hAu = true;
    boolean hAv = false;
    boolean hAw = false;
    boolean hAx = false;
    boolean hAy = true;
    boolean hAz = true;
    boolean hAA = true;

    h() {
    }

    static {
        hAC.hAt = true;
        hAC.hAu = false;
        hAC.hAv = false;
        hAC.hAw = false;
        hAC.hAx = true;
        hAC.hAy = false;
        hAC.hAz = false;
        hAC.hAB = 0;
        hAD = new h();
        hAD.hAt = true;
        hAD.hAu = true;
        hAD.hAv = false;
        hAD.hAw = false;
        hAD.hAx = false;
        hAC.hAB = 1;
        hAE = new h();
        hAE.hAt = false;
        hAE.hAu = true;
        hAE.hAv = false;
        hAE.hAw = true;
        hAE.hAx = false;
        hAE.hAA = false;
        hAE.hAB = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wO(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wo(int i) {
        if (this.hAw) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wP(String str) {
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
            return wP(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String n(Class cls) {
        return b(cls, cls.getName(), this.hAt);
    }

    public String d(Class cls, String str) {
        return b(cls, str, this.hAx);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(n(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.hAu) {
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
        if (this.hAv && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
