package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hyX = null;
    int hzh;
    String hzi;
    Class hzj;
    a hzk;
    private String hzl;
    String name;
    private static boolean cEx = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hzm = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void au(int i, String str);

        String get(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hzh = -1;
        this.hzh = i;
        this.name = str;
        this.hzj = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (cEx) {
            if (this.hzk == null) {
                try {
                    this.hzk = new b();
                } catch (Throwable th) {
                    cEx = false;
                }
            } else {
                str = this.hzk.get(hVar.hzx);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (cEx) {
            this.hzk.au(hVar.hzx, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hzz);
    }

    public int getModifiers() {
        if (this.hzh == -1) {
            this.hzh = wm(0);
        }
        return this.hzh;
    }

    public String getName() {
        if (this.name == null) {
            this.name = wl(1);
        }
        return this.name;
    }

    public Class bJB() {
        if (this.hzj == null) {
            this.hzj = wn(2);
        }
        return this.hzj;
    }

    public String bJC() {
        if (this.hzi == null) {
            this.hzi = bJB().getName();
        }
        return this.hzi;
    }

    private ClassLoader bJD() {
        if (this.hyX == null) {
            this.hyX = getClass().getClassLoader();
        }
        return this.hyX;
    }

    String wl(int i) {
        int i2 = 0;
        int indexOf = this.hzl.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hzl.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hzl.length();
        }
        return this.hzl.substring(i2, indexOf);
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
        private SoftReference hzn;

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
            return (String[]) this.hzn.get();
        }

        private String[] bJF() {
            String[] strArr = new String[3];
            this.hzn = new SoftReference(strArr);
            return strArr;
        }
    }
}
