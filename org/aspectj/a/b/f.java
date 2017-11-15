package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader hyO = null;
    int hyY;
    String hyZ;
    Class hza;
    a hzb;
    private String hzc;
    String name;
    private static boolean chr = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] hzd = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void aj(int i, String str);

        String xs(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.hyY = -1;
        this.hyY = i;
        this.name = str;
        this.hza = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (chr) {
            if (this.hzb == null) {
                try {
                    this.hzb = new b();
                } catch (Throwable th) {
                    chr = false;
                }
            } else {
                str = this.hzb.xs(hVar.hzo);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (chr) {
            this.hzb.aj(hVar.hzo, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.hzq);
    }

    public int getModifiers() {
        if (this.hyY == -1) {
            this.hyY = xp(0);
        }
        return this.hyY;
    }

    public String getName() {
        if (this.name == null) {
            this.name = xo(1);
        }
        return this.name;
    }

    public Class bPh() {
        if (this.hza == null) {
            this.hza = xq(2);
        }
        return this.hza;
    }

    public String bPi() {
        if (this.hyZ == null) {
            this.hyZ = bPh().getName();
        }
        return this.hyZ;
    }

    private ClassLoader bPj() {
        if (this.hyO == null) {
            this.hyO = getClass().getClassLoader();
        }
        return this.hyO;
    }

    String xo(int i) {
        int i2 = 0;
        int indexOf = this.hzc.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.hzc.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.hzc.length();
        }
        return this.hzc.substring(i2, indexOf);
    }

    int xp(int i) {
        return Integer.parseInt(xo(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class xq(int i) {
        return org.aspectj.a.b.b.b(xo(i), bPj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] xr(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(xo(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bPj());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference hze;

        public b() {
            bPl();
        }

        @Override // org.aspectj.a.b.f.a
        public String xs(int i) {
            String[] bPk = bPk();
            if (bPk == null) {
                return null;
            }
            return bPk[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aj(int i, String str) {
            String[] bPk = bPk();
            if (bPk == null) {
                bPk = bPl();
            }
            bPk[i] = str;
        }

        private String[] bPk() {
            return (String[]) this.hze.get();
        }

        private String[] bPl() {
            String[] strArr = new String[3];
            this.hze = new SoftReference(strArr);
            return strArr;
        }
    }
}
