package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hJY = null;
    int hKi;
    String hKj;
    Class hKk;
    a hKl;
    private String hKm;
    String name;
    private static boolean cpY = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hKn = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ar(int i, String str);

        String xQ(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hKi = -1;
        this.hKi = i;
        this.name = str;
        this.hKk = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cpY) {
            if (this.hKl == null) {
                try {
                    this.hKl = new b();
                } catch (Throwable th) {
                    cpY = false;
                }
            } else {
                str = this.hKl.xQ(hVar.hKy);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cpY) {
            this.hKl.ar(hVar.hKy, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hKA);
    }

    public int getModifiers() {
        if (this.hKi == -1) {
            this.hKi = xN(0);
        }
        return this.hKi;
    }

    public String getName() {
        if (this.name == null) {
            this.name = xM(1);
        }
        return this.name;
    }

    public Class bSd() {
        if (this.hKk == null) {
            this.hKk = xO(2);
        }
        return this.hKk;
    }

    public String bSe() {
        if (this.hKj == null) {
            this.hKj = bSd().getName();
        }
        return this.hKj;
    }

    private ClassLoader bSf() {
        if (this.hJY == null) {
            this.hJY = getClass().getClassLoader();
        }
        return this.hJY;
    }

    String xM(int i) {
        int i2 = 0;
        int indexOf = this.hKm.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hKm.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hKm.length();
        }
        return this.hKm.substring(i2, indexOf);
    }

    int xN(int i) {
        return Integer.parseInt(xM(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class xO(int i) {
        return org.aspectj.a.b.b.b(xM(i), bSf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] xP(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(xM(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bSf());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hKo;

        public b() {
            bSh();
        }

        @Override // org.aspectj.a.b.f.a
        public String xQ(int i) {
            String[] bSg = bSg();
            if (bSg == null) {
                return null;
            }
            return bSg[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ar(int i, String str) {
            String[] bSg = bSg();
            if (bSg == null) {
                bSg = bSh();
            }
            bSg[i] = str;
        }

        private String[] bSg() {
            return (String[]) this.hKo.get();
        }

        private String[] bSh() {
            String[] strArr = new String[3];
            this.hKo = new SoftReference(strArr);
            return strArr;
        }
    }
}
