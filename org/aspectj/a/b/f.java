package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int its;
    ClassLoader izc = null;
    String izm;
    Class izn;
    a izo;
    private String izp;
    String name;
    private static boolean dkS = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] izq = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        void set(int i, String str);

        String zj(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.its = -1;
        this.its = i;
        this.name = str;
        this.izn = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dkS) {
            if (this.izo == null) {
                try {
                    this.izo = new b();
                } catch (Throwable th) {
                    dkS = false;
                }
            } else {
                str = this.izo.zj(hVar.izB);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dkS) {
            this.izo.set(hVar.izB, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.izD);
    }

    public int getModifiers() {
        if (this.its == -1) {
            this.its = zg(0);
        }
        return this.its;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zf(1);
        }
        return this.name;
    }

    public Class ccd() {
        if (this.izn == null) {
            this.izn = zh(2);
        }
        return this.izn;
    }

    public String cce() {
        if (this.izm == null) {
            this.izm = ccd().getName();
        }
        return this.izm;
    }

    private ClassLoader ccf() {
        if (this.izc == null) {
            this.izc = getClass().getClassLoader();
        }
        return this.izc;
    }

    String zf(int i) {
        int i2 = 0;
        int indexOf = this.izp.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.izp.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.izp.length();
        }
        return this.izp.substring(i2, indexOf);
    }

    int zg(int i) {
        return Integer.parseInt(zf(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zh(int i) {
        return org.aspectj.a.b.b.b(zf(i), ccf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zi(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zf(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), ccf());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference izr;

        public b() {
            cch();
        }

        @Override // org.aspectj.a.b.f.a
        public String zj(int i) {
            String[] ccg = ccg();
            if (ccg == null) {
                return null;
            }
            return ccg[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] ccg = ccg();
            if (ccg == null) {
                ccg = cch();
            }
            ccg[i] = str;
        }

        private String[] ccg() {
            return (String[]) this.izr.get();
        }

        private String[] cch() {
            String[] strArr = new String[3];
            this.izr = new SoftReference(strArr);
            return strArr;
        }
    }
}
