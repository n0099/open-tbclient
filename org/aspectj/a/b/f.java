package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    int mMi;
    ClassLoader nLN = null;
    String nLW;
    Class nLX;
    a nLY;
    private String nLZ;
    String name;
    private static boolean fRD = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nMa = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.mMi = -1;
        this.mMi = i;
        this.name = str;
        this.nLX = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (fRD) {
            if (this.nLY == null) {
                try {
                    this.nLY = new b();
                } catch (Throwable th) {
                    fRD = false;
                }
            } else {
                str = this.nLY.get(hVar.nMl);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (fRD) {
            this.nLY.set(hVar.nMl, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nMn);
    }

    public int dND() {
        if (this.mMi == -1) {
            this.mMi = NX(0);
        }
        return this.mMi;
    }

    public String getName() {
        if (this.name == null) {
            this.name = NW(1);
        }
        return this.name;
    }

    public Class dNE() {
        if (this.nLX == null) {
            this.nLX = NY(2);
        }
        return this.nLX;
    }

    public String dNF() {
        if (this.nLW == null) {
            this.nLW = dNE().getName();
        }
        return this.nLW;
    }

    private ClassLoader dNG() {
        if (this.nLN == null) {
            this.nLN = getClass().getClassLoader();
        }
        return this.nLN;
    }

    String NW(int i) {
        int i2 = 0;
        int indexOf = this.nLZ.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nLZ.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nLZ.length();
        }
        return this.nLZ.substring(i2, indexOf);
    }

    int NX(int i) {
        return Integer.parseInt(NW(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class NY(int i) {
        return org.aspectj.a.b.b.b(NW(i), dNG());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] NZ(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(NW(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dNG());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nMb;

        public b() {
            dNI();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dNH = dNH();
            if (dNH == null) {
                return null;
            }
            return dNH[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dNH = dNH();
            if (dNH == null) {
                dNH = dNI();
            }
            dNH[i] = str;
        }

        private String[] dNH() {
            return (String[]) this.nMb.get();
        }

        private String[] dNI() {
            String[] strArr = new String[3];
            this.nMb = new SoftReference(strArr);
            return strArr;
        }
    }
}
