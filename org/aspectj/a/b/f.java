package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes3.dex */
abstract class f implements org.aspectj.lang.c {
    String name;
    int pHW;
    Class qkA;
    a qkB;
    private String qkC;
    ClassLoader qkq = null;
    String qkz;
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
        this.pHW = -1;
        this.pHW = i;
        this.name = str;
        this.qkA = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (useCache) {
            if (this.qkB == null) {
                try {
                    this.qkB = new b();
                } catch (Throwable th) {
                    useCache = false;
                }
            } else {
                str = this.qkB.get(hVar.qkN);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (useCache) {
            this.qkB.set(hVar.qkN, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.qkP);
    }

    public int eJv() {
        if (this.pHW == -1) {
            this.pHW = Sd(0);
        }
        return this.pHW;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Sc(1);
        }
        return this.name;
    }

    public Class eJw() {
        if (this.qkA == null) {
            this.qkA = Se(2);
        }
        return this.qkA;
    }

    public String eJx() {
        if (this.qkz == null) {
            this.qkz = eJw().getName();
        }
        return this.qkz;
    }

    private ClassLoader eJy() {
        if (this.qkq == null) {
            this.qkq = getClass().getClassLoader();
        }
        return this.qkq;
    }

    String Sc(int i) {
        int i2 = 0;
        int indexOf = this.qkC.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.qkC.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.qkC.length();
        }
        return this.qkC.substring(i2, indexOf);
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
        private SoftReference qkD;

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
            return (String[]) this.qkD.get();
        }

        private String[] eJA() {
            String[] strArr = new String[3];
            this.qkD = new SoftReference(strArr);
            return strArr;
        }
    }
}
