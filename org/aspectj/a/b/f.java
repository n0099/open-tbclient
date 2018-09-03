package org.aspectj.a.b;

import com.baidu.ar.util.SystemInfoUtil;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int hFE;
    Class hJA;
    a hJB;
    private String hJC;
    ClassLoader hJo = null;
    String hJz;
    String name;
    private static boolean cOW = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hJD = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void au(int i, String str);

        String wf(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hFE = -1;
        this.hFE = i;
        this.name = str;
        this.hJA = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cOW) {
            if (this.hJB == null) {
                try {
                    this.hJB = new b();
                } catch (Throwable th) {
                    cOW = false;
                }
            } else {
                str = this.hJB.wf(hVar.hJO);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cOW) {
            this.hJB.au(hVar.hJO, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hJQ);
    }

    public int getModifiers() {
        if (this.hFE == -1) {
            this.hFE = wc(0);
        }
        return this.hFE;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wb(1);
        }
        return this.name;
    }

    public Class bKP() {
        if (this.hJA == null) {
            this.hJA = wd(2);
        }
        return this.hJA;
    }

    public String bKQ() {
        if (this.hJz == null) {
            this.hJz = bKP().getName();
        }
        return this.hJz;
    }

    private ClassLoader bKR() {
        if (this.hJo == null) {
            this.hJo = getClass().getClassLoader();
        }
        return this.hJo;
    }

    String wb(int i) {
        int i2 = 0;
        int indexOf = this.hJC.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hJC.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hJC.length();
        }
        return this.hJC.substring(i2, indexOf);
    }

    int wc(int i) {
        return Integer.parseInt(wb(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wd(int i) {
        return org.aspectj.a.b.b.b(wb(i), bKR());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] we(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wb(i), SystemInfoUtil.COLON);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bKR());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hJE;

        public b() {
            bKT();
        }

        @Override // org.aspectj.a.b.f.a
        public String wf(int i) {
            String[] bKS = bKS();
            if (bKS == null) {
                return null;
            }
            return bKS[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void au(int i, String str) {
            String[] bKS = bKS();
            if (bKS == null) {
                bKS = bKT();
            }
            bKS[i] = str;
        }

        private String[] bKS() {
            return (String[]) this.hJE.get();
        }

        private String[] bKT() {
            String[] strArr = new String[3];
            this.hJE = new SoftReference(strArr);
            return strArr;
        }
    }
}
