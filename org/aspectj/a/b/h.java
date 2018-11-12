package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h iss = new h();
    static h ist;
    static h isu;
    boolean isj = true;
    boolean isk = true;
    boolean isl = false;
    boolean ism = false;
    boolean isn = false;
    boolean iso = true;
    boolean isp = true;
    boolean isq = true;
    int isr;

    h() {
    }

    static {
        iss.isj = true;
        iss.isk = false;
        iss.isl = false;
        iss.ism = false;
        iss.isn = true;
        iss.iso = false;
        iss.isp = false;
        iss.isr = 0;
        ist = new h();
        ist.isj = true;
        ist.isk = true;
        ist.isl = false;
        ist.ism = false;
        ist.isn = false;
        iss.isr = 1;
        isu = new h();
        isu.isj = false;
        isu.isk = true;
        isu.isl = false;
        isu.ism = true;
        isu.isn = false;
        isu.isq = false;
        isu.isr = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zc(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String yN(int i) {
        if (this.ism) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String zd(String str) {
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
            return zd(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String D(Class cls) {
        return b(cls, cls.getName(), this.isj);
    }

    public String i(Class cls, String str) {
        return b(cls, str, this.isn);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(D(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.isk) {
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
        if (this.isl && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
