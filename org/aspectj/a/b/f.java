package org.aspectj.a.b;

import com.baidu.mobstat.Config;
import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes5.dex */
abstract class f implements org.aspectj.lang.c {
    int jNG;
    String jTA;
    Class jTB;
    a jTC;
    private String jTD;
    ClassLoader jTq = null;
    String name;
    private static boolean eyr = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] jTE = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public interface a {
        String Dl(int i);

        void aL(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.jNG = -1;
        this.jNG = i;
        this.name = str;
        this.jTB = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (eyr) {
            if (this.jTC == null) {
                try {
                    this.jTC = new b();
                } catch (Throwable th) {
                    eyr = false;
                }
            } else {
                str = this.jTC.Dl(hVar.jTP);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (eyr) {
            this.jTC.aL(hVar.jTP, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.jTR);
    }

    public int getModifiers() {
        if (this.jNG == -1) {
            this.jNG = Di(0);
        }
        return this.jNG;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Dh(1);
        }
        return this.name;
    }

    public Class cCT() {
        if (this.jTB == null) {
            this.jTB = Dj(2);
        }
        return this.jTB;
    }

    public String cCU() {
        if (this.jTA == null) {
            this.jTA = cCT().getName();
        }
        return this.jTA;
    }

    private ClassLoader cCV() {
        if (this.jTq == null) {
            this.jTq = getClass().getClassLoader();
        }
        return this.jTq;
    }

    String Dh(int i) {
        int i2 = 0;
        int indexOf = this.jTD.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.jTD.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.jTD.length();
        }
        return this.jTD.substring(i2, indexOf);
    }

    int Di(int i) {
        return Integer.parseInt(Dh(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Dj(int i) {
        return org.aspectj.a.b.b.b(Dh(i), cCV());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Dk(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Dh(i), Config.TRACE_TODAY_VISIT_SPLIT);
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), cCV());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements a {
        private SoftReference jTF;

        public b() {
            cCX();
        }

        @Override // org.aspectj.a.b.f.a
        public String Dl(int i) {
            String[] cCW = cCW();
            if (cCW == null) {
                return null;
            }
            return cCW[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aL(int i, String str) {
            String[] cCW = cCW();
            if (cCW == null) {
                cCW = cCX();
            }
            cCW[i] = str;
        }

        private String[] cCW() {
            return (String[]) this.jTF.get();
        }

        private String[] cCX() {
            String[] strArr = new String[3];
            this.jTF = new SoftReference(strArr);
            return strArr;
        }
    }
}
