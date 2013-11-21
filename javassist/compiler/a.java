package javassist.compiler;

import java.util.HashMap;
import java.util.Map;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.SyntheticAttribute;
import javassist.bytecode.ad;
import javassist.bytecode.an;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.compiler.ast.MethodDecl;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private javassist.h f2823a;
    private int b = 1;
    private HashMap c = new HashMap();

    public a(javassist.h hVar) {
        this.f2823a = hVar;
    }

    public String a(javassist.h hVar, String str, an anVar) {
        String str2 = "<init>:" + str;
        String str3 = (String) this.c.get(str2);
        if (str3 == null) {
            str3 = z.a("javassist.runtime.Inner", str);
            javassist.bytecode.i g = this.f2823a.g();
            try {
                y c = g.c();
                javassist.c a2 = this.f2823a.a();
                an anVar2 = new an(c, MethodDecl.initName, str3);
                anVar2.a(0);
                anVar2.a(new SyntheticAttribute(c));
                ExceptionsAttribute h = anVar.h();
                if (h != null) {
                    anVar2.a(h.a(c, (Map) null));
                }
                javassist.h[] a3 = z.a(str, a2);
                Bytecode bytecode = new Bytecode(c);
                bytecode.k(0);
                int i = 1;
                for (javassist.h hVar2 : a3) {
                    i += bytecode.a(i, hVar2);
                }
                bytecode.d(i + 1);
                bytecode.c(this.f2823a, MethodDecl.initName, str);
                bytecode.b((javassist.h) null);
                anVar2.a(bytecode.e());
                g.a(anVar2);
                this.c.put(str2, str3);
            } catch (CannotCompileException e) {
                throw new CompileError(e);
            } catch (NotFoundException e2) {
                throw new CompileError(e2);
            }
        }
        return str3;
    }

    public String a(String str, String str2, String str3, an anVar) {
        String str4 = str + ":" + str2;
        String str5 = (String) this.c.get(str4);
        if (str5 == null) {
            javassist.bytecode.i g = this.f2823a.g();
            str5 = a(g);
            try {
                y c = g.c();
                javassist.c a2 = this.f2823a.a();
                an anVar2 = new an(c, str5, str3);
                anVar2.a(8);
                anVar2.a(new SyntheticAttribute(c));
                ExceptionsAttribute h = anVar.h();
                if (h != null) {
                    anVar2.a(h.a(c, (Map) null));
                }
                javassist.h[] a3 = z.a(str3, a2);
                Bytecode bytecode = new Bytecode(c);
                int i = 0;
                for (javassist.h hVar : a3) {
                    i += bytecode.a(i, hVar);
                }
                bytecode.d(i);
                if (str2 == str3) {
                    bytecode.d(this.f2823a, str, str2);
                } else {
                    bytecode.e(this.f2823a, str, str2);
                }
                bytecode.b(z.b(str2, a2));
                anVar2.a(bytecode.e());
                g.a(anVar2);
                this.c.put(str4, str5);
            } catch (CannotCompileException e) {
                throw new CompileError(e);
            } catch (NotFoundException e2) {
                throw new CompileError(e2);
            }
        }
        return str5;
    }

    public an a(ad adVar, boolean z) {
        String str;
        String b = adVar.b();
        String str2 = b + ":getter";
        Object obj = this.c.get(str2);
        if (obj != null) {
            return (an) obj;
        }
        javassist.bytecode.i g = this.f2823a.g();
        String a2 = a(g);
        try {
            y c = g.c();
            javassist.c a3 = this.f2823a.a();
            String d = adVar.d();
            if (z) {
                str = "()" + d;
            } else {
                str = "(" + z.b(this.f2823a) + ")" + d;
            }
            an anVar = new an(c, a2, str);
            anVar.a(8);
            anVar.a(new SyntheticAttribute(c));
            Bytecode bytecode = new Bytecode(c);
            if (z) {
                bytecode.b(Bytecode.f2730a, b, d);
            } else {
                bytecode.k(0);
                bytecode.a(Bytecode.f2730a, b, d);
                bytecode.d(1);
            }
            bytecode.b(z.c(d, a3));
            anVar.a(bytecode.e());
            g.a(anVar);
            this.c.put(str2, anVar);
            return anVar;
        } catch (CannotCompileException e) {
            throw new CompileError(e);
        } catch (NotFoundException e2) {
            throw new CompileError(e2);
        }
    }

    public an b(ad adVar, boolean z) {
        String str;
        int a2;
        String b = adVar.b();
        String str2 = b + ":setter";
        Object obj = this.c.get(str2);
        if (obj != null) {
            return (an) obj;
        }
        javassist.bytecode.i g = this.f2823a.g();
        String a3 = a(g);
        try {
            y c = g.c();
            javassist.c a4 = this.f2823a.a();
            String d = adVar.d();
            if (z) {
                str = "(" + d + ")V";
            } else {
                str = "(" + z.b(this.f2823a) + d + ")V";
            }
            an anVar = new an(c, a3, str);
            anVar.a(8);
            anVar.a(new SyntheticAttribute(c));
            Bytecode bytecode = new Bytecode(c);
            if (z) {
                a2 = bytecode.a(0, z.c(d, a4));
                bytecode.g(Bytecode.f2730a, b, d);
            } else {
                bytecode.k(0);
                a2 = bytecode.a(1, z.c(d, a4)) + 1;
                bytecode.f(Bytecode.f2730a, b, d);
            }
            bytecode.b((javassist.h) null);
            bytecode.d(a2);
            anVar.a(bytecode.e());
            g.a(anVar);
            this.c.put(str2, anVar);
            return anVar;
        } catch (CannotCompileException e) {
            throw new CompileError(e);
        } catch (NotFoundException e2) {
            throw new CompileError(e2);
        }
    }

    private String a(javassist.bytecode.i iVar) {
        String sb;
        do {
            StringBuilder append = new StringBuilder().append("access$");
            int i = this.b;
            this.b = i + 1;
            sb = append.append(i).toString();
        } while (iVar.c(sb) != null);
        return sb;
    }
}
