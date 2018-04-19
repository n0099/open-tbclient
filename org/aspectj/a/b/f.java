package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hza = null;
    int hzk;
    String hzl;
    Class hzm;
    a hzn;
    private String hzo;
    String name;
    private static boolean cEA = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hzp = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void au(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hzk = -1;
        this.hzk = i;
        this.name = str;
        this.hzm = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cEA) {
            if (this.hzn == null) {
                try {
                    this.hzn = new b();
                } catch (Throwable th) {
                    cEA = false;
                }
            } else {
                str = this.hzn.get(hVar.hzA);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cEA) {
            this.hzn.au(hVar.hzA, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hzC);
    }

    public int getModifiers() {
        if (this.hzk == -1) {
            this.hzk = wm(0);
        }
        return this.hzk;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wl(1);
        }
        return this.name;
    }

    public Class bJB() {
        if (this.hzm == null) {
            this.hzm = wn(2);
        }
        return this.hzm;
    }

    public String bJC() {
        if (this.hzl == null) {
            this.hzl = bJB().getName();
        }
        return this.hzl;
    }

    private ClassLoader bJD() {
        if (this.hza == null) {
            this.hza = getClass().getClassLoader();
        }
        return this.hza;
    }

    String wl(int i) {
        int i2 = 0;
        int indexOf = this.hzo.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hzo.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hzo.length();
        }
        return this.hzo.substring(i2, indexOf);
    }

    int wm(int i) {
        return Integer.parseInt(wl(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class wn(int i) {
        return org.aspectj.a.b.b.b(wl(i), bJD());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] wo(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(wl(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bJD());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hzq;

        public b() {
            bJF();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] bJE = bJE();
            if (bJE == null) {
                return null;
            }
            return bJE[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void au(int i, String str) {
            String[] bJE = bJE();
            if (bJE == null) {
                bJE = bJF();
            }
            bJE[i] = str;
        }

        private String[] bJE() {
            return (String[]) this.hzq.get();
        }

        private String[] bJF() {
            String[] strArr = new String[3];
            this.hzq = new SoftReference(strArr);
            return strArr;
        }
    }
}
