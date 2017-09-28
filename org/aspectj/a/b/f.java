package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hnM = null;
    int hnW;
    String hnX;
    Class hnY;
    a hnZ;
    private String hoa;
    String name;
    private static boolean bZJ = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hob = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ah(int i, String str);

        String wS(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hnW = -1;
        this.hnW = i;
        this.name = str;
        this.hnY = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (bZJ) {
            if (this.hnZ == null) {
                try {
                    this.hnZ = new b();
                } catch (Throwable th) {
                    bZJ = false;
                }
            } else {
                str = this.hnZ.wS(hVar.hom);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (bZJ) {
            this.hnZ.ah(hVar.hom, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hoo);
    }

    public int getModifiers() {
        if (this.hnW == -1) {
            this.hnW = wP(0);
        }
        return this.hnW;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wO(1);
        }
        return this.name;
    }

    public Class bLF() {
        if (this.hnY == null) {
            this.hnY = wQ(2);
        }
        return this.hnY;
    }

    public String bLG() {
        if (this.hnX == null) {
            this.hnX = bLF().getName();
        }
        return this.hnX;
    }

    private ClassLoader bLH() {
        if (this.hnM == null) {
            this.hnM = getClass().getClassLoader();
        }
        return this.hnM;
    }

    String wO(int i) {
        int i2 = 0;
        int indexOf = this.hoa.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hoa.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hoa.length();
        }
        return this.hoa.substring(i2, indexOf);
    }

    int wP(int i) {
        return Integer.parseInt(wO(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wQ(int i) {
        return org.aspectj.a.b.b.b(wO(i), bLH());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wR(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wO(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bLH());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hoc;

        public b() {
            bLJ();
        }

        @Override // org.aspectj.a.b.f.a
        public String wS(int i) {
            String[] bLI = bLI();
            if (bLI == null) {
                return null;
            }
            return bLI[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ah(int i, String str) {
            String[] bLI = bLI();
            if (bLI == null) {
                bLI = bLJ();
            }
            bLI[i] = str;
        }

        private String[] bLI() {
            return (String[]) this.hoc.get();
        }

        private String[] bLJ() {
            String[] strArr = new String[3];
            this.hoc = new SoftReference(strArr);
            return strArr;
        }
    }
}
