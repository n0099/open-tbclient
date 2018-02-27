package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    ClassLoader ilY = null;
    int imj;
    String imk;
    Class iml;
    a imm;
    private String imn;
    String name;
    private static boolean dmr = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] imo = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void ar(int i, String str);

        String zy(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.imj = -1;
        this.imj = i;
        this.name = str;
        this.iml = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (dmr) {
            if (this.imm == null) {
                try {
                    this.imm = new b();
                } catch (Throwable th) {
                    dmr = false;
                }
            } else {
                str = this.imm.zy(hVar.imz);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (dmr) {
            this.imm.ar(hVar.imz, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.imB);
    }

    public int getModifiers() {
        if (this.imj == -1) {
            this.imj = zv(0);
        }
        return this.imj;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zu(1);
        }
        return this.name;
    }

    public Class bRX() {
        if (this.iml == null) {
            this.iml = zw(2);
        }
        return this.iml;
    }

    public String bRY() {
        if (this.imk == null) {
            this.imk = bRX().getName();
        }
        return this.imk;
    }

    private ClassLoader bRZ() {
        if (this.ilY == null) {
            this.ilY = getClass().getClassLoader();
        }
        return this.ilY;
    }

    String zu(int i) {
        int i2 = 0;
        int indexOf = this.imn.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.imn.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.imn.length();
        }
        return this.imn.substring(i2, indexOf);
    }

    int zv(int i) {
        return Integer.parseInt(zu(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zw(int i) {
        return org.aspectj.a.b.b.b(zu(i), bRZ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zx(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zu(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bRZ());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference imp;

        public b() {
            bSb();
        }

        @Override // org.aspectj.a.b.f.a
        public String zy(int i) {
            String[] bSa = bSa();
            if (bSa == null) {
                return null;
            }
            return bSa[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void ar(int i, String str) {
            String[] bSa = bSa();
            if (bSa == null) {
                bSa = bSb();
            }
            bSa[i] = str;
        }

        private String[] bSa() {
            return (String[]) this.imp.get();
        }

        private String[] bSb() {
            String[] strArr = new String[3];
            this.imp = new SoftReference(strArr);
            return strArr;
        }
    }
}
