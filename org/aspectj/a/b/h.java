package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes2.dex */
class h {
    static h ior = new h();
    static h ios;
    static h iot;
    boolean ioi = true;
    boolean ioj = true;
    boolean iok = false;
    boolean iol = false;
    boolean iom = false;
    boolean ion = true;
    boolean ioo = true;
    boolean iop = true;
    int ioq;

    h() {
    }

    static {
        ior.ioi = true;
        ior.ioj = false;
        ior.iok = false;
        ior.iol = false;
        ior.iom = true;
        ior.ion = false;
        ior.ioo = false;
        ior.ioq = 0;
        ios = new h();
        ios.ioi = true;
        ios.ioj = true;
        ios.iok = false;
        ios.iol = false;
        ios.iom = false;
        ior.ioq = 1;
        iot = new h();
        iot.ioi = false;
        iot.ioj = true;
        iot.iok = false;
        iot.iol = true;
        iot.iom = false;
        iot.iop = false;
        iot.ioq = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String wU(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zz(int i) {
        if (this.iol) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String wV(String str) {
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
            return wV(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String o(Class cls) {
        return b(cls, cls.getName(), this.ioi);
    }

    public String e(Class cls, String str) {
        return b(cls, str, this.iom);
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
            if (!this.ioj) {
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
        if (this.iok && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
