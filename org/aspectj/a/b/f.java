package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int inG;
    String inH;
    Class inI;
    a inJ;
    private String inK;
    ClassLoader inw = null;
    String name;
    private static boolean djs = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] inL = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void as(int i, String str);

        String zy(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.inG = -1;
        this.inG = i;
        this.name = str;
        this.inI = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (djs) {
            if (this.inJ == null) {
                try {
                    this.inJ = new b();
                } catch (Throwable th) {
                    djs = false;
                }
            } else {
                str = this.inJ.zy(hVar.inW);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (djs) {
            this.inJ.as(hVar.inW, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.inY);
    }

    public int getModifiers() {
        if (this.inG == -1) {
            this.inG = zv(0);
        }
        return this.inG;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zu(1);
        }
        return this.name;
    }

    public Class bRK() {
        if (this.inI == null) {
            this.inI = zw(2);
        }
        return this.inI;
    }

    public String bRL() {
        if (this.inH == null) {
            this.inH = bRK().getName();
        }
        return this.inH;
    }

    private ClassLoader bRM() {
        if (this.inw == null) {
            this.inw = getClass().getClassLoader();
        }
        return this.inw;
    }

    String zu(int i) {
        int i2 = 0;
        int indexOf = this.inK.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.inK.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.inK.length();
        }
        return this.inK.substring(i2, indexOf);
    }

    int zv(int i) {
        return Integer.parseInt(zu(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zw(int i) {
        return org.aspectj.a.b.b.b(zu(i), bRM());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zx(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zu(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bRM());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference inM;

        public b() {
            bRO();
        }

        @Override // org.aspectj.a.b.f.a
        public String zy(int i) {
            String[] bRN = bRN();
            if (bRN == null) {
                return null;
            }
            return bRN[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void as(int i, String str) {
            String[] bRN = bRN();
            if (bRN == null) {
                bRN = bRO();
            }
            bRN[i] = str;
        }

        private String[] bRN() {
            return (String[]) this.inM.get();
        }

        private String[] bRO() {
            String[] strArr = new String[3];
            this.inM = new SoftReference(strArr);
            return strArr;
        }
    }
}
