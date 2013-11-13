package javassist.compiler;

import com.tencent.mm.sdk.contact.RContact;
import javassist.CtBehavior;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.compiler.ast.Stmnt;
import javassist.v;
/* loaded from: classes.dex */
public class Javac {

    /* renamed from: a  reason: collision with root package name */
    JvstCodeGen f2834a;
    SymbolTable b;
    private Bytecode c;

    /* loaded from: classes.dex */
    public class CtFieldWithInit extends CtField {
    }

    public Javac(javassist.h hVar) {
        this(new Bytecode(hVar.h().c(), 0, 0), hVar);
    }

    public Javac(Bytecode bytecode, javassist.h hVar) {
        this.f2834a = new JvstCodeGen(bytecode, hVar, hVar.a());
        this.b = new SymbolTable();
        this.c = bytecode;
    }

    public Bytecode a(CtBehavior ctBehavior, String str) {
        javassist.h hVar;
        boolean z;
        try {
            a(ctBehavior.i_(), v.d(ctBehavior.b()));
            if (ctBehavior instanceof CtMethod) {
                this.f2834a.a((CtMethod) ctBehavior);
                hVar = ((CtMethod) ctBehavior).h();
            } else {
                hVar = javassist.h.l;
            }
            a(hVar, false);
            boolean z2 = hVar == javassist.h.l;
            if (str == null) {
                a(this.c, hVar);
            } else {
                Parser parser = new Parser(new Lex(str));
                Stmnt a2 = parser.a(new SymbolTable(this.b));
                if (parser.a()) {
                    throw new CompileError("the method/constructor body must be surrounded by {}");
                }
                if (ctBehavior instanceof CtConstructor) {
                    z = !((CtConstructor) ctBehavior).h();
                } else {
                    z = false;
                }
                this.f2834a.a(a2, z, z2);
            }
            return this.c;
        } catch (NotFoundException e) {
            throw new CompileError(e.toString());
        }
    }

    private static void a(Bytecode bytecode, javassist.h hVar) {
        int i;
        int i2;
        if (hVar instanceof CtPrimitiveType) {
            i = ((CtPrimitiveType) hVar).C();
            if (i == 175) {
                i2 = 14;
            } else if (i == 174) {
                i2 = 11;
            } else if (i == 173) {
                i2 = 9;
            } else if (i == 177) {
                i2 = 0;
            } else {
                i2 = 3;
            }
        } else {
            i = 176;
            i2 = 1;
        }
        if (i2 != 0) {
            bytecode.g(i2);
        }
        bytecode.g(i);
    }

    public int a(javassist.h[] hVarArr, boolean z) {
        return this.f2834a.a(hVarArr, z, RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR, "$args", "$$", this.b);
    }

    public int a(javassist.h hVar, boolean z) {
        this.f2834a.a(hVar);
        return this.f2834a.a(hVar, "$r", z ? "$_" : null, this.b);
    }

    public void a(String str, String str2) {
        this.f2834a.a(new d(this, str2, new Parser(new Lex(str)).b(this.b)), "$proceed");
    }
}
