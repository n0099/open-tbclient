package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nKo = new h();
    static h nKp;
    static h nKq;
    boolean nKf = true;
    boolean nKg = true;
    boolean nKh = false;
    boolean nKi = false;
    boolean nKj = false;
    boolean nKk = true;
    boolean nKl = true;
    boolean nKm = true;
    int nKn;

    h() {
    }

    static {
        nKo.nKf = true;
        nKo.nKg = false;
        nKo.nKh = false;
        nKo.nKi = false;
        nKo.nKj = true;
        nKo.nKk = false;
        nKo.nKl = false;
        nKo.nKn = 0;
        nKp = new h();
        nKp.nKf = true;
        nKp.nKg = true;
        nKp.nKh = false;
        nKp.nKi = false;
        nKp.nKj = false;
        nKo.nKn = 1;
        nKq = new h();
        nKq.nKf = false;
        nKq.nKg = true;
        nKq.nKh = false;
        nKq.nKi = true;
        nKq.nKj = false;
        nKq.nKm = false;
        nKq.nKn = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String So(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String NU(int i) {
        if (this.nKi) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(HanziToPinyin.Token.SEPARATOR).toString();
        }
        return "";
    }

    String Sp(String str) {
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
            return Sp(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nKf);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nKj);
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
            if (!this.nKg) {
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
        if (this.nKh && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
