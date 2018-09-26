package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int hNY;
    ClassLoader hRI = null;
    String hRT;
    Class hRU;
    a hRV;
    private String hRW;
    String name;
    private static boolean cUN = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hRX = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void av(int i, String str);

        String wE(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hNY = -1;
        this.hNY = i;
        this.name = str;
        this.hRU = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cUN) {
            if (this.hRV == null) {
                try {
                    this.hRV = new b();
                } catch (Throwable th) {
                    cUN = false;
                }
            } else {
                str = this.hRV.wE(hVar.hSi);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cUN) {
            this.hRV.av(hVar.hSi, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hSk);
    }

    public int getModifiers() {
        if (this.hNY == -1) {
            this.hNY = wB(0);
        }
        return this.hNY;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wA(1);
        }
        return this.name;
    }

    public Class bNG() {
        if (this.hRU == null) {
            this.hRU = wC(2);
        }
        return this.hRU;
    }

    public String bNH() {
        if (this.hRT == null) {
            this.hRT = bNG().getName();
        }
        return this.hRT;
    }

    private ClassLoader bNI() {
        if (this.hRI == null) {
            this.hRI = getClass().getClassLoader();
        }
        return this.hRI;
    }

    String wA(int i) {
        int i2 = 0;
        int indexOf = this.hRW.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hRW.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hRW.length();
        }
        return this.hRW.substring(i2, indexOf);
    }

    int wB(int i) {
        return Integer.parseInt(wA(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wC(int i) {
        return org.aspectj.a.b.b.b(wA(i), bNI());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wD(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wA(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bNI());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hRY;

        public b() {
            bNK();
        }

        @Override // org.aspectj.a.b.f.a
        public String wE(int i) {
            String[] bNJ = bNJ();
            if (bNJ == null) {
                return null;
            }
            return bNJ[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void av(int i, String str) {
            String[] bNJ = bNJ();
            if (bNJ == null) {
                bNJ = bNK();
            }
            bNJ[i] = str;
        }

        private String[] bNJ() {
            return (String[]) this.hRY.get();
        }

        private String[] bNK() {
            String[] strArr = new String[3];
            this.hRY = new SoftReference(strArr);
            return strArr;
        }
    }
}
