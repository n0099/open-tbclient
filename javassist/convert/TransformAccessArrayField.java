package javassist.convert;

import com.baidu.loginshare.e;
import javassist.CannotCompileException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.an;
import javassist.bytecode.analysis.Analyzer;
import javassist.bytecode.analysis.c;
import javassist.bytecode.n;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.f;
import javassist.h;
/* loaded from: classes.dex */
public final class TransformAccessArrayField extends Transformer {

    /* renamed from: a  reason: collision with root package name */
    private final String f2830a;
    private final f b;
    private c[] c;
    private int d;

    @Override // javassist.convert.Transformer
    public void a(y yVar, h hVar, an anVar) {
        CodeIterator j = anVar.i().j();
        while (j.e()) {
            try {
                int f = j.f();
                int c = j.c(f);
                if (c == 50) {
                    a(hVar, anVar);
                }
                if (c == 50 || c == 51 || c == 52 || c == 49 || c == 48 || c == 46 || c == 47 || c == 53) {
                    a(yVar, j, f, c, d(c));
                } else if (c == 83 || c == 84 || c == 85 || c == 82 || c == 81 || c == 79 || c == 80 || c == 86) {
                    a(yVar, j, f, c, e(c));
                }
            } catch (Exception e) {
                throw new CannotCompileException(e);
            }
        }
    }

    @Override // javassist.convert.Transformer
    public void a() {
        this.c = null;
        this.d = -1;
    }

    @Override // javassist.convert.Transformer
    public int a(h hVar, int i, CodeIterator codeIterator, y yVar) {
        return i;
    }

    private c a(int i) {
        return this.c[i - this.d];
    }

    private void a(h hVar, an anVar) {
        if (this.c == null) {
            this.c = new Analyzer().a(hVar, anVar);
            this.d = 0;
        }
    }

    private int a(int i, int i2) {
        if (this.d > -1) {
            this.d += i2;
        }
        return i + i2;
    }

    private String b(int i) {
        h a2;
        c a3 = a(i);
        if (a3 == null || (a2 = a3.d().a()) == null) {
            return null;
        }
        return z.a(a2);
    }

    private int a(y yVar, CodeIterator codeIterator, int i, int i2, String str) {
        String str2 = null;
        String c = c(i2);
        if (c != null) {
            if (i2 == 50) {
                String b = b(codeIterator.g());
                if (b != null) {
                    if (!"java/lang/Object".equals(b)) {
                        str2 = b;
                    }
                } else {
                    return i;
                }
            }
            codeIterator.a(0, i);
            n a2 = codeIterator.a(i, str2 != null ? 5 : 2, false);
            int i3 = a2.f2802a;
            int b2 = yVar.b(yVar.a(this.f2830a), c, str);
            codeIterator.a(184, i3);
            codeIterator.b(b2, i3 + 1);
            if (str2 != null) {
                int a3 = yVar.a(str2);
                codeIterator.a(192, i3 + 3);
                codeIterator.b(a3, i3 + 4);
            }
            return a(i3, a2.b);
        }
        return i;
    }

    private String c(int i) {
        String l;
        switch (i) {
            case 46:
                l = this.b.i();
                break;
            case 47:
                l = this.b.k();
                break;
            case 48:
                l = this.b.g();
                break;
            case 49:
                l = this.b.e();
                break;
            case 50:
                l = this.b.m();
                break;
            case 51:
                l = this.b.a();
                break;
            case 52:
                l = this.b.c();
                break;
            case 53:
                l = this.b.o();
                break;
            case 79:
                l = this.b.j();
                break;
            case e.i /* 80 */:
                l = this.b.l();
                break;
            case 81:
                l = this.b.h();
                break;
            case 82:
                l = this.b.f();
                break;
            case 83:
                l = this.b.n();
                break;
            case 84:
                l = this.b.b();
                break;
            case 85:
                l = this.b.d();
                break;
            case 86:
                l = this.b.p();
                break;
            default:
                l = null;
                break;
        }
        if (l.equals("")) {
            return null;
        }
        return l;
    }

    private String d(int i) {
        switch (i) {
            case 46:
                return "(Ljava/lang/Object;I)I";
            case 47:
                return "(Ljava/lang/Object;I)J";
            case 48:
                return "(Ljava/lang/Object;I)F";
            case 49:
                return "(Ljava/lang/Object;I)D";
            case 50:
                return "(Ljava/lang/Object;I)Ljava/lang/Object;";
            case 51:
                return "(Ljava/lang/Object;I)B";
            case 52:
                return "(Ljava/lang/Object;I)C";
            case 53:
                return "(Ljava/lang/Object;I)S";
            default:
                throw new BadBytecode(i);
        }
    }

    private String e(int i) {
        switch (i) {
            case 79:
                return "(Ljava/lang/Object;II)V";
            case e.i /* 80 */:
                return "(Ljava/lang/Object;IJ)V";
            case 81:
                return "(Ljava/lang/Object;IF)V";
            case 82:
                return "(Ljava/lang/Object;ID)V";
            case 83:
                return "(Ljava/lang/Object;ILjava/lang/Object;)V";
            case 84:
                return "(Ljava/lang/Object;IB)V";
            case 85:
                return "(Ljava/lang/Object;IC)V";
            case 86:
                return "(Ljava/lang/Object;IS)V";
            default:
                throw new BadBytecode(i);
        }
    }
}
