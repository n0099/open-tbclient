package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int imh;
    ClassLoader irS = null;
    String isc;
    Class isd;
    a ise;
    private String isf;
    String name;
    private static boolean dek = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] isg = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String yM(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.imh = -1;
        this.imh = i;
        this.name = str;
        this.isd = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dek) {
            if (this.ise == null) {
                try {
                    this.ise = new b();
                } catch (Throwable th) {
                    dek = false;
                }
            } else {
                str = this.ise.yM(hVar.isr);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dek) {
            this.ise.set(hVar.isr, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.ist);
    }

    public int getModifiers() {
        if (this.imh == -1) {
            this.imh = yJ(0);
        }
        return this.imh;
    }

    public String getName() {
        if (this.name == null) {
            this.name = yI(1);
        }
        return this.name;
    }

    public Class bZX() {
        if (this.isd == null) {
            this.isd = yK(2);
        }
        return this.isd;
    }

    public String bZY() {
        if (this.isc == null) {
            this.isc = bZX().getName();
        }
        return this.isc;
    }

    private ClassLoader bZZ() {
        if (this.irS == null) {
            this.irS = getClass().getClassLoader();
        }
        return this.irS;
    }

    String yI(int i) {
        int i2 = 0;
        int indexOf = this.isf.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.isf.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.isf.length();
        }
        return this.isf.substring(i2, indexOf);
    }

    int yJ(int i) {
        return Integer.parseInt(yI(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class yK(int i) {
        return org.aspectj.a.b.b.b(yI(i), bZZ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] yL(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(yI(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bZZ());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference ish;

        public b() {
            cab();
        }

        @Override // org.aspectj.a.b.f.a
        public String yM(int i) {
            String[] caa = caa();
            if (caa == null) {
                return null;
            }
            return caa[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] caa = caa();
            if (caa == null) {
                caa = cab();
            }
            caa[i] = str;
        }

        private String[] caa() {
            return (String[]) this.ish.get();
        }

        private String[] cab() {
            String[] strArr = new String[3];
            this.ish = new SoftReference(strArr);
            return strArr;
        }
    }
}
