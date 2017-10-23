package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int hnF;
    String hnG;
    Class hnH;
    a hnI;
    private String hnJ;
    ClassLoader hnv = null;
    String name;
    private static boolean bZx = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hnK = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ah(int i, String str);

        String wR(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hnF = -1;
        this.hnF = i;
        this.name = str;
        this.hnH = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (bZx) {
            if (this.hnI == null) {
                try {
                    this.hnI = new b();
                } catch (Throwable th) {
                    bZx = false;
                }
            } else {
                str = this.hnI.wR(hVar.hnV);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (bZx) {
            this.hnI.ah(hVar.hnV, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hnX);
    }

    public int getModifiers() {
        if (this.hnF == -1) {
            this.hnF = wO(0);
        }
        return this.hnF;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wN(1);
        }
        return this.name;
    }

    public Class bLw() {
        if (this.hnH == null) {
            this.hnH = wP(2);
        }
        return this.hnH;
    }

    public String bLx() {
        if (this.hnG == null) {
            this.hnG = bLw().getName();
        }
        return this.hnG;
    }

    private ClassLoader bLy() {
        if (this.hnv == null) {
            this.hnv = getClass().getClassLoader();
        }
        return this.hnv;
    }

    String wN(int i) {
        int i2 = 0;
        int indexOf = this.hnJ.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hnJ.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hnJ.length();
        }
        return this.hnJ.substring(i2, indexOf);
    }

    int wO(int i) {
        return Integer.parseInt(wN(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wP(int i) {
        return org.aspectj.a.b.b.b(wN(i), bLy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wQ(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wN(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bLy());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hnL;

        public b() {
            bLA();
        }

        @Override // org.aspectj.a.b.f.a
        public String wR(int i) {
            String[] bLz = bLz();
            if (bLz == null) {
                return null;
            }
            return bLz[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ah(int i, String str) {
            String[] bLz = bLz();
            if (bLz == null) {
                bLz = bLA();
            }
            bLz[i] = str;
        }

        private String[] bLz() {
            return (String[]) this.hnL.get();
        }

        private String[] bLA() {
            String[] strArr = new String[3];
            this.hnL = new SoftReference(strArr);
            return strArr;
        }
    }
}
