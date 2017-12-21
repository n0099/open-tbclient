package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hMW = null;
    int hNg;
    String hNh;
    Class hNi;
    a hNj;
    private String hNk;
    String name;
    private static boolean cql = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hNl = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ar(int i, String str);

        String yd(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hNg = -1;
        this.hNg = i;
        this.name = str;
        this.hNi = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cql) {
            if (this.hNj == null) {
                try {
                    this.hNj = new b();
                } catch (Throwable th) {
                    cql = false;
                }
            } else {
                str = this.hNj.yd(hVar.hNw);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cql) {
            this.hNj.ar(hVar.hNw, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hNy);
    }

    public int getModifiers() {
        if (this.hNg == -1) {
            this.hNg = ya(0);
        }
        return this.hNg;
    }

    public String getName() {
        if (this.name == null) {
            this.name = xZ(1);
        }
        return this.name;
    }

    public Class bSN() {
        if (this.hNi == null) {
            this.hNi = yb(2);
        }
        return this.hNi;
    }

    public String bSO() {
        if (this.hNh == null) {
            this.hNh = bSN().getName();
        }
        return this.hNh;
    }

    private ClassLoader bSP() {
        if (this.hMW == null) {
            this.hMW = getClass().getClassLoader();
        }
        return this.hMW;
    }

    String xZ(int i) {
        int i2 = 0;
        int indexOf = this.hNk.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hNk.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hNk.length();
        }
        return this.hNk.substring(i2, indexOf);
    }

    int ya(int i) {
        return Integer.parseInt(xZ(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class yb(int i) {
        return org.aspectj.a.b.b.b(xZ(i), bSP());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] yc(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(xZ(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bSP());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hNm;

        public b() {
            bSR();
        }

        @Override // org.aspectj.a.b.f.a
        public String yd(int i) {
            String[] bSQ = bSQ();
            if (bSQ == null) {
                return null;
            }
            return bSQ[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ar(int i, String str) {
            String[] bSQ = bSQ();
            if (bSQ == null) {
                bSQ = bSR();
            }
            bSQ[i] = str;
        }

        private String[] bSQ() {
            return (String[]) this.hNm.get();
        }

        private String[] bSR() {
            String[] strArr = new String[3];
            this.hNm = new SoftReference(strArr);
            return strArr;
        }
    }
}
