package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hnL = null;
    int hnV;
    String hnW;
    Class hnX;
    a hnY;
    private String hnZ;
    String name;
    private static boolean bZJ = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hoa = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ah(int i, String str);

        String wS(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hnV = -1;
        this.hnV = i;
        this.name = str;
        this.hnX = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (bZJ) {
            if (this.hnY == null) {
                try {
                    this.hnY = new b();
                } catch (Throwable th) {
                    bZJ = false;
                }
            } else {
                str = this.hnY.wS(hVar.hol);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (bZJ) {
            this.hnY.ah(hVar.hol, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hon);
    }

    public int getModifiers() {
        if (this.hnV == -1) {
            this.hnV = wP(0);
        }
        return this.hnV;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wO(1);
        }
        return this.name;
    }

    public Class bLE() {
        if (this.hnX == null) {
            this.hnX = wQ(2);
        }
        return this.hnX;
    }

    public String bLF() {
        if (this.hnW == null) {
            this.hnW = bLE().getName();
        }
        return this.hnW;
    }

    private ClassLoader bLG() {
        if (this.hnL == null) {
            this.hnL = getClass().getClassLoader();
        }
        return this.hnL;
    }

    String wO(int i) {
        int i2 = 0;
        int indexOf = this.hnZ.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hnZ.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hnZ.length();
        }
        return this.hnZ.substring(i2, indexOf);
    }

    int wP(int i) {
        return Integer.parseInt(wO(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wQ(int i) {
        return org.aspectj.a.b.b.b(wO(i), bLG());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wR(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wO(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bLG());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hob;

        public b() {
            bLI();
        }

        @Override // org.aspectj.a.b.f.a
        public String wS(int i) {
            String[] bLH = bLH();
            if (bLH == null) {
                return null;
            }
            return bLH[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ah(int i, String str) {
            String[] bLH = bLH();
            if (bLH == null) {
                bLH = bLI();
            }
            bLH[i] = str;
        }

        private String[] bLH() {
            return (String[]) this.hob.get();
        }

        private String[] bLI() {
            String[] strArr = new String[3];
            this.hob = new SoftReference(strArr);
            return strArr;
        }
    }
}
