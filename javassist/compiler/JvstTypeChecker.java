package javassist.compiler;

import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.Symbol;
/* loaded from: classes.dex */
public class JvstTypeChecker extends TypeChecker {
    private JvstCodeGen h;

    public JvstTypeChecker(javassist.h hVar, javassist.c cVar, JvstCodeGen jvstCodeGen) {
        super(hVar, cVar);
        this.h = jvstCodeGen;
    }

    public void a() {
        if (this.f2822a == 344) {
            this.f2822a = 307;
            this.b = 0;
            this.c = "java/lang/Object";
        }
    }

    @Override // javassist.compiler.TypeChecker, javassist.compiler.ast.a
    public void a(Member member) {
        String str = member.get();
        if (str.equals(this.h.m)) {
            this.f2822a = 307;
            this.b = 1;
            this.c = "java/lang/Object";
        } else if (str.equals("$sig")) {
            this.f2822a = 307;
            this.b = 1;
            this.c = "java/lang/Class";
        } else if (str.equals("$type") || str.equals("$class")) {
            this.f2822a = 307;
            this.b = 0;
            this.c = "java/lang/Class";
        } else {
            super.a(member);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.TypeChecker
    public void a(Expr expr, int i, ASTree aSTree, ASTree aSTree2) {
        if ((aSTree instanceof Member) && ((Member) aSTree).get().equals(this.h.m)) {
            aSTree2.accept(this);
            javassist.h[] hVarArr = this.h.o;
            if (hVarArr != null) {
                for (javassist.h hVar : hVarArr) {
                    a(hVar);
                }
                return;
            }
            return;
        }
        super.a(expr, i, aSTree, aSTree2);
    }

    @Override // javassist.compiler.TypeChecker, javassist.compiler.ast.a
    public void a(CastExpr castExpr) {
        ASTList className = castExpr.getClassName();
        if (className != null && castExpr.getArrayDim() == 0) {
            ASTree head = className.head();
            if ((head instanceof Symbol) && className.tail() == null) {
                String str = ((Symbol) head).get();
                if (str.equals(this.h.q)) {
                    b(castExpr);
                    return;
                } else if (str.equals("$w")) {
                    c(castExpr);
                    return;
                }
            }
        }
        super.a(castExpr);
    }

    protected void b(CastExpr castExpr) {
        javassist.h hVar = this.h.p;
        castExpr.getOprand().accept(this);
        if (this.f2822a == 344 || CodeGen.d(this.f2822a) || this.b > 0) {
            a(hVar);
        } else if (hVar instanceof CtPrimitiveType) {
            this.f2822a = MemberResolver.a(((CtPrimitiveType) hVar).y());
            this.b = 0;
            this.c = null;
        }
    }

    protected void c(CastExpr castExpr) {
        castExpr.getOprand().accept(this);
        if (!CodeGen.d(this.f2822a) && this.b <= 0 && (this.d.a(this.f2822a, this.b, this.c) instanceof CtPrimitiveType)) {
            this.f2822a = 307;
            this.b = 0;
            this.c = "java/lang/Object";
        }
    }

    @Override // javassist.compiler.TypeChecker, javassist.compiler.ast.a
    public void a(CallExpr callExpr) {
        ASTree oprand1 = callExpr.oprand1();
        if (oprand1 instanceof Member) {
            String str = ((Member) oprand1).get();
            if (this.h.s != null && str.equals(this.h.r)) {
                this.h.s.a(this, (ASTList) callExpr.oprand2());
                return;
            } else if (str.equals("$cflow")) {
                a((ASTList) callExpr.oprand2());
                return;
            }
        }
        super.a(callExpr);
    }

    protected void a(ASTList aSTList) {
        this.f2822a = 324;
        this.b = 0;
        this.c = null;
    }

    @Override // javassist.compiler.TypeChecker
    public int c(ASTList aSTList) {
        int i;
        String str = this.h.n;
        int i2 = 0;
        while (aSTList != null) {
            ASTree head = aSTList.head();
            if ((head instanceof Member) && ((Member) head).get().equals(str)) {
                i = this.h.o != null ? this.h.o.length + i2 : i2;
            } else {
                i = i2 + 1;
            }
            aSTList = aSTList.tail();
            i2 = i;
        }
        return i2;
    }

    @Override // javassist.compiler.TypeChecker
    public void a(ASTList aSTList, int[] iArr, int[] iArr2, String[] strArr) {
        int i;
        javassist.h[] hVarArr = this.h.o;
        String str = this.h.n;
        int i2 = 0;
        while (aSTList != null) {
            ASTree head = aSTList.head();
            if ((head instanceof Member) && ((Member) head).get().equals(str)) {
                if (hVarArr != null) {
                    int length = hVarArr.length;
                    int i3 = 0;
                    i = i2;
                    while (i3 < length) {
                        b(hVarArr[i3]);
                        iArr[i] = this.f2822a;
                        iArr2[i] = this.b;
                        strArr[i] = this.c;
                        i3++;
                        i++;
                    }
                } else {
                    i = i2;
                }
            } else {
                head.accept(this);
                iArr[i2] = this.f2822a;
                iArr2[i2] = this.b;
                strArr[i2] = this.c;
                i = i2 + 1;
            }
            aSTList = aSTList.tail();
            i2 = i;
        }
    }

    protected void a(javassist.h hVar) {
        if (hVar == javassist.h.l) {
            a();
        } else {
            b(hVar);
        }
    }

    public void b(javassist.h hVar) {
        a(hVar, 0);
    }

    private void a(javassist.h hVar, int i) {
        if (hVar.m()) {
            this.f2822a = MemberResolver.a(((CtPrimitiveType) hVar).y());
            this.b = i;
            this.c = null;
        } else if (hVar.b()) {
            try {
                a(hVar.e(), i + 1);
            } catch (NotFoundException e) {
                throw new CompileError("undefined type: " + hVar.n());
            }
        } else {
            this.f2822a = 307;
            this.b = i;
            this.c = MemberResolver.c(hVar.n());
        }
    }
}
