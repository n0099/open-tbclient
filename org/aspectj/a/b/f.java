package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes7.dex */
abstract class f implements org.aspectj.lang.c {
    String nXC;
    Class nXD;
    a nXE;
    private String nXF;
    ClassLoader nXt = null;
    int nah;
    String name;
    private static boolean aqY = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] nXG = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public interface a {
        String get(int i);

        void set(int i, String str);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.nah = -1;
        this.nah = i;
        this.name = str;
        this.nXD = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (aqY) {
            if (this.nXE == null) {
                try {
                    this.nXE = new b();
                } catch (Throwable th) {
                    aqY = false;
                }
            } else {
                str = this.nXE.get(hVar.nXR);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (aqY) {
            this.nXE.set(hVar.nXR, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.nXT);
    }

    public int dTs() {
        if (this.nah == -1) {
            this.nah = Ll(0);
        }
        return this.nah;
    }

    public String getName() {
        if (this.name == null) {
            this.name = Lk(1);
        }
        return this.name;
    }

    public Class dTt() {
        if (this.nXD == null) {
            this.nXD = Lm(2);
        }
        return this.nXD;
    }

    public String dTu() {
        if (this.nXC == null) {
            this.nXC = dTt().getName();
        }
        return this.nXC;
    }

    private ClassLoader dTv() {
        if (this.nXt == null) {
            this.nXt = getClass().getClassLoader();
        }
        return this.nXt;
    }

    String Lk(int i) {
        int i2 = 0;
        int indexOf = this.nXF.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.nXF.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.nXF.length();
        }
        return this.nXF.substring(i2, indexOf);
    }

    int Ll(int i) {
        return Integer.parseInt(Lk(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class Lm(int i) {
        return org.aspectj.a.b.b.b(Lk(i), dTv());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] Ln(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(Lk(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), dTv());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static final class b implements a {
        private SoftReference nXH;

        public b() {
            dTx();
        }

        @Override // org.aspectj.a.b.f.a
        public String get(int i) {
            String[] dTw = dTw();
            if (dTw == null) {
                return null;
            }
            return dTw[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void set(int i, String str) {
            String[] dTw = dTw();
            if (dTw == null) {
                dTw = dTx();
            }
            dTw[i] = str;
        }

        private String[] dTw() {
            return (String[]) this.nXH.get();
        }

        private String[] dTx() {
            String[] strArr = new String[3];
            this.nXH = new SoftReference(strArr);
            return strArr;
        }
    }
}
