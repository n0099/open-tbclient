package org.aspectj.a.b;

import com.baidu.ar.util.SystemInfoUtil;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int hIU;
    ClassLoader hOP = null;
    String hOZ;
    Class hPa;
    a hPb;
    private String hPc;
    String name;
    private static boolean cOw = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hPd = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void av(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hIU = -1;
        this.hIU = i;
        this.name = str;
        this.hPa = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cOw) {
            if (this.hPb == null) {
                try {
                    this.hPb = new b();
                } catch (Throwable th) {
                    cOw = false;
                }
            } else {
                str = this.hPb.get(hVar.hPo);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cOw) {
            this.hPb.av(hVar.hPo, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hPq);
    }

    public int getModifiers() {
        if (this.hIU == -1) {
            this.hIU = wF(0);
        }
        return this.hIU;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wE(1);
        }
        return this.name;
    }

    public Class bPo() {
        if (this.hPa == null) {
            this.hPa = wG(2);
        }
        return this.hPa;
    }

    public String bPp() {
        if (this.hOZ == null) {
            this.hOZ = bPo().getName();
        }
        return this.hOZ;
    }

    private ClassLoader bPq() {
        if (this.hOP == null) {
            this.hOP = getClass().getClassLoader();
        }
        return this.hOP;
    }

    String wE(int i) {
        int i2 = 0;
        int indexOf = this.hPc.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hPc.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hPc.length();
        }
        return this.hPc.substring(i2, indexOf);
    }

    int wF(int i) {
        return Integer.parseInt(wE(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wG(int i) {
        return org.aspectj.a.b.b.b(wE(i), bPq());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wH(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wE(i), SystemInfoUtil.COLON);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bPq());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hPe;

        public b() {
            bPs();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] bPr = bPr();
            if (bPr == null) {
                return null;
            }
            return bPr[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void av(int i, String str) {
            String[] bPr = bPr();
            if (bPr == null) {
                bPr = bPs();
            }
            bPr[i] = str;
        }

        private String[] bPr() {
            return (String[]) this.hPe.get();
        }

        private String[] bPs() {
            String[] strArr = new String[3];
            this.hPe = new SoftReference(strArr);
            return strArr;
        }
    }
}
