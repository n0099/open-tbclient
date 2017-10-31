package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hxE = null;
    int hxO;
    String hxP;
    Class hxQ;
    a hxR;
    private String hxS;
    String name;
    private static boolean che = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hxT = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        String xo(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hxO = -1;
        this.hxO = i;
        this.name = str;
        this.hxQ = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (che) {
            if (this.hxR == null) {
                try {
                    this.hxR = new b();
                } catch (Throwable th) {
                    che = false;
                }
            } else {
                str = this.hxR.xo(hVar.hye);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (che) {
            this.hxR.aj(hVar.hye, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hyg);
    }

    public int getModifiers() {
        if (this.hxO == -1) {
            this.hxO = xl(0);
        }
        return this.hxO;
    }

    public String getName() {
        if (this.name == null) {
            this.name = xk(1);
        }
        return this.name;
    }

    public Class bOU() {
        if (this.hxQ == null) {
            this.hxQ = xm(2);
        }
        return this.hxQ;
    }

    public String bOV() {
        if (this.hxP == null) {
            this.hxP = bOU().getName();
        }
        return this.hxP;
    }

    private ClassLoader bOW() {
        if (this.hxE == null) {
            this.hxE = getClass().getClassLoader();
        }
        return this.hxE;
    }

    String xk(int i) {
        int i2 = 0;
        int indexOf = this.hxS.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hxS.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hxS.length();
        }
        return this.hxS.substring(i2, indexOf);
    }

    int xl(int i) {
        return Integer.parseInt(xk(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class xm(int i) {
        return org.aspectj.a.b.b.b(xk(i), bOW());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] xn(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(xk(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bOW());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hxU;

        public b() {
            bOY();
        }

        @Override // org.aspectj.a.b.f.a
        public String xo(int i) {
            String[] bOX = bOX();
            if (bOX == null) {
                return null;
            }
            return bOX[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aj(int i, String str) {
            String[] bOX = bOX();
            if (bOX == null) {
                bOX = bOY();
            }
            bOX[i] = str;
        }

        private String[] bOX() {
            return (String[]) this.hxU.get();
        }

        private String[] bOY() {
            String[] strArr = new String[3];
            this.hxU = new SoftReference(strArr);
            return strArr;
        }
    }
}
