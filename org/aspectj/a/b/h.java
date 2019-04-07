package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h jTi = new h();
    static h jTj;
    static h jTk;
    boolean jSZ = true;
    boolean jTa = true;
    boolean jTb = false;
    boolean jTc = false;
    boolean jTd = false;
    boolean jTe = true;
    boolean jTf = true;
    boolean jTg = true;
    int jTh;

    h() {
    }

    static {
        jTi.jSZ = true;
        jTi.jTa = false;
        jTi.jTb = false;
        jTi.jTc = false;
        jTi.jTd = true;
        jTi.jTe = false;
        jTi.jTf = false;
        jTi.jTh = 0;
        jTj = new h();
        jTj.jSZ = true;
        jTj.jTa = true;
        jTj.jTb = false;
        jTj.jTc = false;
        jTj.jTd = false;
        jTi.jTh = 1;
        jTk = new h();
        jTk.jSZ = false;
        jTk.jTa = true;
        jTk.jTb = false;
        jTk.jTc = true;
        jTk.jTd = false;
        jTk.jTg = false;
        jTk.jTh = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String FR(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Dc(int i) {
        if (this.jTc) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String FS(String str) {
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
            return FS(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String G(Class cls) {
        return b(cls, cls.getName(), this.jSZ);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.jTd);
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
            if (!this.jTa) {
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
        if (this.jTb && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
