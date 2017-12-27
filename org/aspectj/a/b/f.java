package org.aspectj.a.b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
/* loaded from: classes2.dex */
abstract class f implements org.aspectj.lang.c {
    int idF;
    String idG;
    Class idH;
    a idI;
    private String idJ;
    ClassLoader idu = null;
    String name;
    private static boolean deQ = true;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    static Class[] idK = new Class[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void aq(int i, String str);

        String zH(int i);
    }

    protected abstract String b(h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(int i, String str, Class cls) {
        this.idF = -1;
        this.idF = i;
        this.name = str;
        this.idH = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(h hVar) {
        String str = null;
        if (deQ) {
            if (this.idI == null) {
                try {
                    this.idI = new b();
                } catch (Throwable th) {
                    deQ = false;
                }
            } else {
                str = this.idI.zH(hVar.idV);
            }
        }
        if (str == null) {
            str = b(hVar);
        }
        if (deQ) {
            this.idI.aq(hVar.idV, str);
        }
        return str;
    }

    public final String toString() {
        return a(h.idX);
    }

    public int getModifiers() {
        if (this.idF == -1) {
            this.idF = zE(0);
        }
        return this.idF;
    }

    public String getName() {
        if (this.name == null) {
            this.name = zD(1);
        }
        return this.name;
    }

    public Class bQL() {
        if (this.idH == null) {
            this.idH = zF(2);
        }
        return this.idH;
    }

    public String bQM() {
        if (this.idG == null) {
            this.idG = bQL().getName();
        }
        return this.idG;
    }

    private ClassLoader bQN() {
        if (this.idu == null) {
            this.idu = getClass().getClassLoader();
        }
        return this.idu;
    }

    String zD(int i) {
        int i2 = 0;
        int indexOf = this.idJ.indexOf(45);
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.idJ.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.idJ.length();
        }
        return this.idJ.substring(i2, indexOf);
    }

    int zE(int i) {
        return Integer.parseInt(zD(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class zF(int i) {
        return org.aspectj.a.b.b.b(zD(i), bQN());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class[] zG(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(zD(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = org.aspectj.a.b.b.b(stringTokenizer.nextToken(), bQN());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements a {
        private SoftReference idL;

        public b() {
            bQP();
        }

        @Override // org.aspectj.a.b.f.a
        public String zH(int i) {
            String[] bQO = bQO();
            if (bQO == null) {
                return null;
            }
            return bQO[i];
        }

        @Override // org.aspectj.a.b.f.a
        public void aq(int i, String str) {
            String[] bQO = bQO();
            if (bQO == null) {
                bQO = bQP();
            }
            bQO[i] = str;
        }

        private String[] bQO() {
            return (String[]) this.idL.get();
        }

        private String[] bQP() {
            String[] strArr = new String[3];
            this.idL = new SoftReference(strArr);
            return strArr;
        }
    }
}
