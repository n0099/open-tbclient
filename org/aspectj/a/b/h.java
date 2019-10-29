package org.aspectj.a.b;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.lib.util.BdFileHelper;
import java.lang.reflect.Modifier;
/* loaded from: classes5.dex */
class h {
    static h kxj = new h();
    static h kxk;
    static h kxl;
    boolean kxa = true;
    boolean kxb = true;
    boolean kxc = false;
    boolean kxd = false;
    boolean kxe = false;
    boolean kxf = true;
    boolean kxg = true;
    boolean kxh = true;
    int kxi;

    h() {
    }

    static {
        kxj.kxa = true;
        kxj.kxb = false;
        kxj.kxc = false;
        kxj.kxd = false;
        kxj.kxe = true;
        kxj.kxf = false;
        kxj.kxg = false;
        kxj.kxi = 0;
        kxk = new h();
        kxk.kxa = true;
        kxk.kxb = true;
        kxk.kxc = false;
        kxk.kxd = false;
        kxk.kxe = false;
        kxj.kxi = 1;
        kxl = new h();
        kxl.kxa = false;
        kxl.kxb = true;
        kxl.kxc = false;
        kxl.kxd = true;
        kxl.kxe = false;
        kxl.kxh = false;
        kxl.kxi = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Hd(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Dq(int i) {
        if (this.kxd) {
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
        return b(cls, cls.getName(), this.kxa);
    }

    public String h(Class cls, String str) {
        return b(cls, str, this.kxe);
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
            if (!this.kxb) {
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
        if (this.kxc && clsArr != null && clsArr.length != 0) {
            stringBuffer.append(" throws ");
            a(stringBuffer, clsArr);
        }
    }
}
