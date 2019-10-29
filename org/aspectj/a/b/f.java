package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int koK;
    ClassLoader kwK = null;
    String kwT;
    Class kwU;
    a kwV;
    private String kwW;
    String name;
    private static boolean eXj = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] kwX = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void aQ(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.koK = -1;
        this.koK = i;
        this.name = str;
        this.kwU = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eXj) {
            if (this.kwV == null) {
                try {
                    this.kwV = new b();
                } catch (Throwable th) {
                    eXj = false;
                }
            } else {
                str = this.kwV.get(hVar.kxi);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eXj) {
            this.kwV.aQ(hVar.kxi, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.kxk);
    }

    public int cNq() {
        if (this.koK == -1) {
            this.koK = Dn(0);
        }
        return this.koK;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Dm(1);
        }
        return this.name;
    }

    public Class cNr() {
        if (this.kwU == null) {
            this.kwU = Do(2);
        }
        return this.kwU;
    }

    public String cNs() {
        if (this.kwT == null) {
            this.kwT = cNr().getName();
        }
        return this.kwT;
    }

    private ClassLoader cNt() {
        if (this.kwK == null) {
            this.kwK = getClass().getClassLoader();
        }
        return this.kwK;
    }

    String Dm(int i) {
        int i2 = 0;
        int indexOf = this.kwW.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.kwW.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.kwW.length();
        }
        return this.kwW.substring(i2, indexOf);
    }

    int Dn(int i) {
        return Integer.parseInt(Dm(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Do(int i) {
        return org.aspectj.a.b.b.b(Dm(i), cNt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Dp(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Dm(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cNt());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference kwY;

        public b() {
            cNv();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] cNu = cNu();
            if (cNu == null) {
                return null;
            }
            return cNu[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aQ(int i, String str) {
            String[] cNu = cNu();
            if (cNu == null) {
                cNu = cNv();
            }
            cNu[i] = str;
        }

        private String[] cNu() {
            return (String[]) this.kwY.get();
        }

        private String[] cNv() {
            String[] strArr = new String[3];
            this.kwY = new SoftReference(strArr);
            return strArr;
        }
    }
}
