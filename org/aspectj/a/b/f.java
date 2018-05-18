package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hAb = null;
    int hAl;
    String hAm;
    Class hAn;
    a hAo;
    private String hAp;
    String name;
    private static boolean cFG = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hAq = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void au(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hAl = -1;
        this.hAl = i;
        this.name = str;
        this.hAn = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cFG) {
            if (this.hAo == null) {
                try {
                    this.hAo = new b();
                } catch (Throwable th) {
                    cFG = false;
                }
            } else {
                str = this.hAo.get(hVar.hAB);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cFG) {
            this.hAo.au(hVar.hAB, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hAD);
    }

    public int getModifiers() {
        if (this.hAl == -1) {
            this.hAl = wl(0);
        }
        return this.hAl;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wk(1);
        }
        return this.name;
    }

    public Class bJz() {
        if (this.hAn == null) {
            this.hAn = wm(2);
        }
        return this.hAn;
    }

    public String bJA() {
        if (this.hAm == null) {
            this.hAm = bJz().getName();
        }
        return this.hAm;
    }

    private ClassLoader bJB() {
        if (this.hAb == null) {
            this.hAb = getClass().getClassLoader();
        }
        return this.hAb;
    }

    String wk(int i) {
        int i2 = 0;
        int indexOf = this.hAp.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hAp.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hAp.length();
        }
        return this.hAp.substring(i2, indexOf);
    }

    int wl(int i) {
        return Integer.parseInt(wk(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wm(int i) {
        return org.aspectj.a.b.b.b(wk(i), bJB());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wn(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wk(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bJB());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hAr;

        public b() {
            bJD();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] bJC = bJC();
            if (bJC == null) {
                return null;
            }
            return bJC[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void au(int i, String str) {
            String[] bJC = bJC();
            if (bJC == null) {
                bJC = bJD();
            }
            bJC[i] = str;
        }

        private String[] bJC() {
            return (String[]) this.hAr.get();
        }

        private String[] bJD() {
            String[] strArr = new String[3];
            this.hAr = new SoftReference(strArr);
            return strArr;
        }
    }
}
