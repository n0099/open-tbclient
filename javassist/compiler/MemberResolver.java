package javassist.compiler;

import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.location.BDLocation;
import com.tencent.mm.sdk.contact.RContact;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import javassist.CtField;
import javassist.NotFoundException;
import javassist.bytecode.an;
import javassist.bytecode.z;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Symbol;
import javassist.v;
/* loaded from: classes.dex */
public class MemberResolver implements j {
    private static WeakHashMap b = new WeakHashMap();

    /* renamed from: a  reason: collision with root package name */
    private javassist.c f3001a;
    private Hashtable c = null;

    public MemberResolver(javassist.c cVar) {
        this.f3001a = cVar;
    }

    public javassist.c a() {
        return this.f3001a;
    }

    private static void b() {
        throw new CompileError("fatal");
    }

    public g a(javassist.h hVar, javassist.h hVar2, an anVar, String str, int[] iArr, int[] iArr2, String[] strArr) {
        int a2;
        g gVar = null;
        if (anVar != null && hVar == hVar2 && anVar.a().equals(str) && (a2 = a(anVar.g(), iArr, iArr2, strArr)) != -1) {
            g gVar2 = new g(hVar, anVar, a2);
            if (a2 == 0) {
                return gVar2;
            }
            gVar = gVar2;
        }
        g a3 = a(hVar, str, iArr, iArr2, strArr, gVar != null);
        return a3 == null ? gVar : a3;
    }

    private g a(javassist.h hVar, String str, int[] iArr, int[] iArr2, String[] strArr, boolean z) {
        g gVar;
        boolean z2;
        javassist.h f;
        g gVar2;
        int a2;
        g gVar3 = null;
        javassist.bytecode.i h = hVar.h();
        if (h != null) {
            List k = h.k();
            int size = k.size();
            int i = 0;
            while (i < size) {
                an anVar = (an) k.get(i);
                if (anVar.a().equals(str) && (a2 = a(anVar.g(), iArr, iArr2, strArr)) != -1) {
                    g gVar4 = new g(hVar, anVar, a2);
                    if (a2 != 0) {
                        if (gVar3 == null || gVar3.c > a2) {
                            gVar2 = gVar4;
                            i++;
                            gVar3 = gVar2;
                        }
                    } else {
                        return gVar4;
                    }
                }
                gVar2 = gVar3;
                i++;
                gVar3 = gVar2;
            }
        }
        if (z) {
            gVar = null;
            z2 = z;
        } else {
            gVar = gVar3;
            z2 = gVar3 != null;
        }
        int c = hVar.c();
        boolean e = v.e(c);
        if (!e) {
            try {
                javassist.h f2 = hVar.f();
                if (f2 != null) {
                    g a3 = a(f2, str, iArr, iArr2, strArr, z2);
                    if (a3 != null) {
                        return a3;
                    }
                }
            } catch (NotFoundException e2) {
            }
        }
        if (e || v.f(c)) {
            try {
                for (javassist.h hVar2 : hVar.d()) {
                    g a4 = a(hVar2, str, iArr, iArr2, strArr, z2);
                    if (a4 != null) {
                        return a4;
                    }
                }
                if (e && (f = hVar.f()) != null) {
                    g a5 = a(f, str, iArr, iArr2, strArr, z2);
                    if (a5 != null) {
                        return a5;
                    }
                }
            } catch (NotFoundException e3) {
            }
        }
        return gVar;
    }

    private int a(String str, int[] iArr, int[] iArr2, String[] strArr) {
        int i;
        int length = iArr.length;
        if (length != z.f(str)) {
            return -1;
        }
        int length2 = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 1; i4 < length2; i4 = i) {
            int i5 = i4 + 1;
            char charAt = str.charAt(i4);
            if (charAt == ')') {
                if (i2 != length) {
                    return -1;
                }
                return i3;
            } else if (i2 >= length) {
                return -1;
            } else {
                i = i5;
                char c = charAt;
                int i6 = 0;
                while (c == '[') {
                    i6++;
                    int i7 = i + 1;
                    char charAt2 = str.charAt(i);
                    i = i7;
                    c = charAt2;
                }
                if (iArr[i2] == 412) {
                    if (i6 == 0 && c != 'L') {
                        return -1;
                    }
                    if (c == 'L') {
                        i = str.indexOf(59, i) + 1;
                    }
                } else if (iArr2[i2] != i6) {
                    if (i6 != 0 || c != 'L' || !str.startsWith("java/lang/Object;", i)) {
                        return -1;
                    }
                    i = str.indexOf(59, i) + 1;
                    i3++;
                    if (i <= 0) {
                        return -1;
                    }
                } else if (c == 'L') {
                    int indexOf = str.indexOf(59, i);
                    if (indexOf < 0 || iArr[i2] != 307) {
                        return -1;
                    }
                    String substring = str.substring(i, indexOf);
                    if (!substring.equals(strArr[i2])) {
                        try {
                            if (a(strArr[i2]).a(a(substring))) {
                                i3++;
                            } else {
                                return -1;
                            }
                        } catch (NotFoundException e) {
                            i3++;
                        }
                    }
                    i = indexOf + 1;
                } else {
                    int a2 = a(c);
                    int i8 = iArr[i2];
                    if (a2 == i8) {
                        continue;
                    } else if (a2 == 324 && (i8 == 334 || i8 == 303 || i8 == 306)) {
                        i3++;
                    } else {
                        return -1;
                    }
                }
                i2++;
                i3 = i3;
            }
        }
        return -1;
    }

    public CtField a(String str, Symbol symbol, ASTree aSTree) {
        String str2 = symbol.get();
        try {
            javassist.h a2 = a(d(str), true);
            try {
                return a2.a(str2);
            } catch (NotFoundException e) {
                throw new NoFieldException(c(a2.n()) + RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR + str2, aSTree);
            }
        } catch (CompileError e2) {
            throw new NoFieldException(str + "/" + str2, aSTree);
        }
    }

    public CtField a(String str, Symbol symbol) {
        return b(d(str), symbol);
    }

    public CtField b(String str, Symbol symbol) {
        try {
            return a(str, false).a(symbol.get());
        } catch (NotFoundException e) {
            throw new CompileError("no such field: " + symbol.get());
        }
    }

    public javassist.h a(ASTList aSTList) {
        return a(Declarator.astToClassName(aSTList, '.'), false);
    }

    public javassist.h a(String str) {
        return a(d(str), false);
    }

    public javassist.h a(int i, int i2, String str) {
        String a2;
        if (i == 307) {
            javassist.h a3 = a(str);
            if (i2 <= 0) {
                return a3;
            }
            a2 = a3.n();
        } else {
            a2 = a(i);
        }
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                a2 = a2 + "[]";
                i2 = i3;
            } else {
                return a(a2, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i) {
        switch (i) {
            case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
                return "boolean";
            case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                return "byte";
            case 306:
                return "char";
            case 312:
                return "double";
            case 317:
                return "float";
            case 324:
                return "int";
            case 326:
                return "long";
            case 334:
                return "short";
            case 344:
                return "void";
            default:
                b();
                return "";
        }
    }

    public javassist.h a(String str, boolean z) {
        javassist.h e;
        Hashtable c = c();
        Object obj = c.get(str);
        if (obj == "<invalid>") {
            throw new CompileError("no such class: " + str);
        }
        if (obj != null) {
            try {
                return this.f3001a.c((String) obj);
            } catch (NotFoundException e2) {
            }
        }
        try {
            e = b(str, z);
        } catch (NotFoundException e3) {
            e = e(str);
        }
        c.put(str, e.n());
        return e;
    }

    private Hashtable c() {
        Hashtable hashtable;
        Hashtable hashtable2 = this.c;
        if (hashtable2 == null) {
            synchronized (MemberResolver.class) {
                WeakReference weakReference = (WeakReference) b.get(this.f3001a);
                hashtable = weakReference != null ? (Hashtable) weakReference.get() : hashtable2;
                if (hashtable == null) {
                    hashtable = new Hashtable();
                    b.put(this.f3001a, new WeakReference(hashtable));
                }
            }
            this.c = hashtable;
            return hashtable;
        }
        return hashtable2;
    }

    private javassist.h e(String str) {
        javassist.h c;
        if (str.indexOf(46) < 0) {
            Iterator d = this.f3001a.d();
            while (d.hasNext()) {
                String str2 = (String) d.next();
                try {
                    c = this.f3001a.c(str2 + '.' + str);
                } catch (NotFoundException e) {
                    if (str2.endsWith("." + str)) {
                        c = this.f3001a.c(str2);
                    } else {
                        continue;
                    }
                }
                return c;
            }
        }
        c().put(str, "<invalid>");
        throw new CompileError("no such class: " + str);
    }

    private javassist.h b(String str, boolean z) {
        javassist.h hVar;
        javassist.h hVar2 = null;
        while (true) {
            try {
                hVar = hVar2;
                hVar2 = this.f3001a.c(str);
            } catch (NotFoundException e) {
                int lastIndexOf = str.lastIndexOf(46);
                if (z || lastIndexOf < 0) {
                    throw e;
                }
                StringBuffer stringBuffer = new StringBuffer(str);
                stringBuffer.setCharAt(lastIndexOf, '$');
                str = stringBuffer.toString();
                hVar2 = hVar;
            }
            if (hVar2 != null) {
                return hVar2;
            }
        }
    }

    public String b(ASTList aSTList) {
        if (aSTList == null) {
            return null;
        }
        return c(a(aSTList).n());
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        return c(a(str).n());
    }

    public static javassist.h a(javassist.h hVar) {
        try {
            javassist.h f = hVar.f();
            if (f != null) {
                return f;
            }
        } catch (NotFoundException e) {
        }
        throw new CompileError("cannot find the super class of " + hVar.n());
    }

    public static String c(String str) {
        return str.replace('.', '/');
    }

    public static String d(String str) {
        return str.replace('/', '.');
    }

    public static int a(char c) {
        switch (c) {
            case BDLocation.TypeOffLineLocation /* 66 */:
                return BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC;
            case BDLocation.TypeOffLineLocationFail /* 67 */:
                return 306;
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
                return 312;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case com.baidu.loginshare.e.i /* 80 */:
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                b();
                return 344;
            case 'F':
                return 317;
            case 'I':
                return 324;
            case 'J':
                return 326;
            case 'L':
            case '[':
                return 307;
            case 'S':
                return 334;
            case 'V':
                return 344;
            case 'Z':
                return BVideoView.MEDIA_ERROR_NO_INPUTFILE;
        }
    }
}
