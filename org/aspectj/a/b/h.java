package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.lang.reflect.Modifier;
/* loaded from: classes7.dex */
class h {
    static h nKA;
    static h nKB;
    static h nKz = new h();
    boolean nKq = true;
    boolean nKr = true;
    boolean nKs = false;
    boolean nKt = false;
    boolean nKu = false;
    boolean nKv = true;
    boolean nKw = true;
    boolean nKx = true;
    int nKy;

    h() {
    }

    static {
        nKz.nKq = true;
        nKz.nKr = false;
        nKz.nKs = false;
        nKz.nKt = false;
        nKz.nKu = true;
        nKz.nKv = false;
        nKz.nKw = false;
        nKz.nKy = 0;
        nKA = new h();
        nKA.nKq = true;
        nKA.nKr = true;
        nKA.nKs = false;
        nKA.nKt = false;
        nKA.nKu = false;
        nKz.nKy = 1;
        nKB = new h();
        nKB.nKq = false;
        nKB.nKr = true;
        nKB.nKs = false;
        nKB.nKt = true;
        nKB.nKu = false;
        nKB.nKx = false;
        nKB.nKy = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Sp(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String NU(int i) {
        if (this.nKt) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(HanziToPinyin.Token.SEPARATOR).toString();
        }
        return "";
    }

    String Sq(String str) {
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
            return Sq(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public String N(Class cls) {
        return b(cls, cls.getName(), this.nKq);
    }

    public String k(Class cls, String str) {
        return b(cls, str, this.nKu);
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
            if (!this.nKr) {
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
        if (this.nKs && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
