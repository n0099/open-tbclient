package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h kwB = new h();
    static h kwC;
    static h kwD;
    int kwA;
    boolean kws = true;
    boolean kwt = true;
    boolean kwu = false;
    boolean kwv = false;
    boolean kww = false;
    boolean kwx = true;
    boolean kwy = true;
    boolean kwz = true;

    h() {
    }

    static {
        kwB.kws = true;
        kwB.kwt = false;
        kwB.kwu = false;
        kwB.kwv = false;
        kwB.kww = true;
        kwB.kwx = false;
        kwB.kwy = false;
        kwB.kwA = 0;
        kwC = new h();
        kwC.kws = true;
        kwC.kwt = true;
        kwC.kwu = false;
        kwC.kwv = false;
        kwC.kww = false;
        kwB.kwA = 1;
        kwD = new h();
        kwD.kws = false;
        kwD.kwt = true;
        kwD.kwu = false;
        kwD.kwv = true;
        kwD.kww = false;
        kwD.kwz = false;
        kwD.kwA = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String IM(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String ET(int i) {
        if (this.kwv) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String IN(String str) {
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
            return IN(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String G(Class cls) {
        return b(cls, cls.getName(), this.kws);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.kww);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(G(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.kwt) {
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
        if (this.kwu && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
