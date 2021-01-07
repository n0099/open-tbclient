package org.aspectj.a.b;

import java.lang.reflect.Modifier;
/* loaded from: classes4.dex */
class h {
    static h qpq = new h();
    static h qpr;
    static h qps;
    boolean qph = true;
    boolean qpi = true;
    boolean qpj = false;
    boolean qpk = false;
    boolean qpl = false;
    boolean qpm = true;
    boolean qpn = true;
    boolean qpo = true;
    int qpp;

    h() {
    }

    static {
        qpq.qph = true;
        qpq.qpi = false;
        qpq.qpj = false;
        qpq.qpk = false;
        qpq.qpl = true;
        qpq.qpm = false;
        qpq.qpn = false;
        qpq.qpp = 0;
        qpr = new h();
        qpr.qph = true;
        qpr.qpi = true;
        qpr.qpj = false;
        qpr.qpk = false;
        qpr.qpl = false;
        qpq.qpp = 1;
        qps = new h();
        qps.qph = false;
        qps.qpi = true;
        qps.qpj = false;
        qps.qpk = true;
        qps.qpl = false;
        qps.qpo = false;
        qps.qpp = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String acq(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String TN(int i) {
        if (this.qpk) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(" ").toString();
        }
        return "";
    }

    String acr(String str) {
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
            return acr(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String H(Class cls) {
        return b(cls, cls.getName(), this.qph);
    }

    public String l(Class cls, String str) {
        return b(cls, str, this.qpl);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(H(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.qpi) {
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
        if (this.qpj && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
