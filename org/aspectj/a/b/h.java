package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h jTj = new h();
    static h jTk;
    static h jTl;
    boolean jTa = true;
    boolean jTb = true;
    boolean jTc = false;
    boolean jTd = false;
    boolean jTe = false;
    boolean jTf = true;
    boolean jTg = true;
    boolean jTh = true;
    int jTi;

    h() {
    }

    static {
        jTj.jTa = true;
        jTj.jTb = false;
        jTj.jTc = false;
        jTj.jTd = false;
        jTj.jTe = true;
        jTj.jTf = false;
        jTj.jTg = false;
        jTj.jTi = 0;
        jTk = new h();
        jTk.jTa = true;
        jTk.jTb = true;
        jTk.jTc = false;
        jTk.jTd = false;
        jTk.jTe = false;
        jTj.jTi = 1;
        jTl = new h();
        jTl.jTa = false;
        jTl.jTb = true;
        jTl.jTc = false;
        jTl.jTd = true;
        jTl.jTe = false;
        jTl.jTh = false;
        jTl.jTi = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String FR(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Dc(int i) {
        if (this.jTd) {
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
        return b(cls, cls.getName(), this.jTa);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.jTe);
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
            if (!this.jTb) {
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
        if (this.jTc && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
