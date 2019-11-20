package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.util.BdFileHelper;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h kws = new h();
    static h kwt;
    static h kwu;
    boolean kwj = true;
    boolean kwk = true;
    boolean kwl = false;
    boolean kwm = false;
    boolean kwn = false;
    boolean kwo = true;
    boolean kwp = true;
    boolean kwq = true;
    int kwr;

    h() {
    }

    static {
        kws.kwj = true;
        kws.kwk = false;
        kws.kwl = false;
        kws.kwm = false;
        kws.kwn = true;
        kws.kwo = false;
        kws.kwp = false;
        kws.kwr = 0;
        kwt = new h();
        kwt.kwj = true;
        kwt.kwk = true;
        kwt.kwl = false;
        kwt.kwm = false;
        kwt.kwn = false;
        kws.kwr = 1;
        kwu = new h();
        kwu.kwj = false;
        kwu.kwk = true;
        kwu.kwl = false;
        kwu.kwm = true;
        kwu.kwn = false;
        kwu.kwq = false;
        kwu.kwr = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Hd(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Dp(int i) {
        if (this.kwm) {
            String modifier = Modifier.toString(i);
            return modifier.length() == 0 ? "" : new StringBuffer().append(modifier).append(HanziToPinyin.Token.SEPARATOR).toString();
        }
        return "";
    }

    String He(String str) {
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
            return He(str).replace('$', BdFileHelper.EXTENSION_SEPARATOR);
        } else {
            return str.replace('$', BdFileHelper.EXTENSION_SEPARATOR);
        }
    }

    public String E(Class cls) {
        return b(cls, cls.getName(), this.kwj);
    }

    public String h(Class cls, String str) {
        return b(cls, str, this.kwn);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(E(clsArr[i]));
        }
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr != null) {
            if (!this.kwk) {
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
        if (this.kwl && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
