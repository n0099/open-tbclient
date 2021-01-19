package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes3.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pHX;
    String qkA;
    Class qkB;
    a qkC;
    private String qkD;
    ClassLoader qkr = null;
    private static boolean useCache = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.pHX = -1;
        this.pHX = i;
        this.name = str;
        this.qkB = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qkC == null) {
                try {
                    this.qkC = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qkC.get(hVar.qkO);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qkC.set(hVar.qkO, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qkQ);
    }

    public int eJv() {
        if (this.pHX == -1) {
            this.pHX = Sd(0);
        }
        return this.pHX;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sc(1);
        }
        return this.name;
    }

    public Class eJw() {
        if (this.qkB == null) {
            this.qkB = Se(2);
        }
        return this.qkB;
    }

    public String eJx() {
        if (this.qkA == null) {
            this.qkA = eJw().getName();
        }
        return this.qkA;
    }

    private ClassLoader eJy() {
        if (this.qkr == null) {
            this.qkr = getClass().getClassLoader();
        }
        return this.qkr;
    }

    String Sc(int i) {
        int i2 = 0;
        int indexOf = this.qkD.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qkD.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qkD.length();
        }
        return this.qkD.substring(i2, indexOf);
    }

    int Sd(int i) {
        return Integer.parseInt(Sc(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Se(int i) {
        return org.aspectj.a.b.b.b(Sc(i), eJy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Sf(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Sc(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), eJy());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b implements a {
        private SoftReference qkE;

        public b() {
            eJA();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] eJz = eJz();
            if (eJz == null) {
                return null;
            }
            return eJz[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] eJz = eJz();
            if (eJz == null) {
                eJz = eJA();
            }
            eJz[i] = str;
        }

        private String[] eJz() {
            return (String[]) this.qkE.get();
        }

        private String[] eJA() {
            String[] strArr = new String[3];
            this.qkE = new SoftReference(strArr);
            return strArr;
        }
    }
}
