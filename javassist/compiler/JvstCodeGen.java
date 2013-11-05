package javassist.compiler;

import com.baidu.cloudsdk.social.core.SocialConstants;
import javassist.CtPrimitiveType;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.z;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.Symbol;
/* loaded from: classes.dex */
public class JvstCodeGen extends MemberCodeGen {
    private String A;
    private javassist.h B;
    private String C;
    String m;
    String n;
    javassist.h[] o;
    javassist.h p;
    String q;
    String r;
    h s;
    private int y;
    private boolean z;

    public JvstCodeGen(Bytecode bytecode, javassist.h hVar, javassist.c cVar) {
        super(bytecode, hVar, cVar);
        this.m = null;
        this.n = null;
        this.o = null;
        this.y = 0;
        this.z = false;
        this.A = null;
        this.B = null;
        this.p = null;
        this.q = null;
        this.C = null;
        this.r = null;
        this.s = null;
        a(new JvstTypeChecker(hVar, cVar, this));
    }

    private int h() {
        return (this.z ? 1 : 0) + this.y;
    }

    public void a(h hVar, String str) {
        this.r = str;
        this.s = hVar;
    }

    public void f() {
        if (this.i == 344) {
            this.f2785a.g(1);
            this.i = 307;
            this.j = 0;
            this.k = "java/lang/Object";
        }
    }

    @Override // javassist.compiler.MemberCodeGen, javassist.compiler.ast.a
    public void a(Member member) {
        String str = member.get();
        if (str.equals(this.m)) {
            a(this.f2785a, this.o, h());
            this.i = 307;
            this.j = 1;
            this.k = "java/lang/Object";
        } else if (str.equals("$sig")) {
            this.f2785a.c(z.a(this.p, this.o));
            this.f2785a.d("javassist/runtime/Desc", "getParams", "(Ljava/lang/String;)[Ljava/lang/Class;");
            this.i = 307;
            this.j = 1;
            this.k = "java/lang/Class";
        } else if (str.equals("$type")) {
            if (this.B == null) {
                throw new CompileError("$type is not available");
            }
            this.f2785a.c(z.b(this.B));
            c("getType");
        } else if (str.equals("$class")) {
            if (this.A == null) {
                throw new CompileError("$class is not available");
            }
            this.f2785a.c(this.A);
            c("getClazz");
        } else {
            super.a(member);
        }
    }

    private void c(String str) {
        this.f2785a.d("javassist/runtime/Desc", str, "(Ljava/lang/String;)Ljava/lang/Class;");
        this.i = 307;
        this.j = 0;
        this.k = "java/lang/Class";
    }

    @Override // javassist.compiler.MemberCodeGen, javassist.compiler.CodeGen
    protected void a(Expr expr, int i, ASTree aSTree, ASTree aSTree2, boolean z) {
        if ((aSTree instanceof Member) && ((Member) aSTree).get().equals(this.m)) {
            if (i != 61) {
                throw new CompileError("bad operator for " + this.m);
            }
            aSTree2.accept(this);
            if (this.j != 1 || this.i != 307) {
                throw new CompileError("invalid type for " + this.m);
            }
            a(this.o, this.f2785a);
            if (!z) {
                this.f2785a.g(87);
                return;
            }
            return;
        }
        super.a(expr, i, aSTree, aSTree2, z);
    }

    protected void a(javassist.h[] hVarArr, Bytecode bytecode) {
        if (hVarArr != null) {
            int h = h();
            int length = hVarArr.length;
            int i = h;
            for (int i2 = 0; i2 < length; i2++) {
                bytecode.g(89);
                bytecode.m(i2);
                bytecode.g(50);
                a(hVarArr[i2], bytecode);
                bytecode.b(i, hVarArr[i2]);
                i += a(this.i, this.j) ? 2 : 1;
            }
        }
    }

    @Override // javassist.compiler.CodeGen, javassist.compiler.ast.a
    public void a(CastExpr castExpr) {
        ASTList className = castExpr.getClassName();
        if (className != null && castExpr.getArrayDim() == 0) {
            ASTree head = className.head();
            if ((head instanceof Symbol) && className.tail() == null) {
                String str = ((Symbol) head).get();
                if (str.equals(this.q)) {
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
        castExpr.getOprand().accept(this);
        if (this.i == 344 || d(this.i) || this.j > 0) {
            a(this.p, this.f2785a);
        } else if (this.p instanceof CtPrimitiveType) {
            int a2 = MemberResolver.a(((CtPrimitiveType) this.p).y());
            d(this.i, a2);
            this.i = a2;
            this.j = 0;
            this.k = null;
        } else {
            throw new CompileError("invalid cast");
        }
    }

    protected void c(CastExpr castExpr) {
        castExpr.getOprand().accept(this);
        if (!d(this.i) && this.j <= 0) {
            javassist.h a2 = this.t.a(this.i, this.j, this.k);
            if (a2 instanceof CtPrimitiveType) {
                CtPrimitiveType ctPrimitiveType = (CtPrimitiveType) a2;
                String z = ctPrimitiveType.z();
                this.f2785a.d(z);
                this.f2785a.g(89);
                if (ctPrimitiveType.D() > 1) {
                    this.f2785a.g(94);
                } else {
                    this.f2785a.g(93);
                }
                this.f2785a.g(88);
                this.f2785a.c(z, MethodDecl.initName, "(" + ctPrimitiveType.y() + ")V");
                this.i = 307;
                this.j = 0;
                this.k = "java/lang/Object";
            }
        }
    }

    @Override // javassist.compiler.MemberCodeGen, javassist.compiler.ast.a
    public void a(CallExpr callExpr) {
        ASTree oprand1 = callExpr.oprand1();
        if (oprand1 instanceof Member) {
            String str = ((Member) oprand1).get();
            if (this.s != null && str.equals(this.r)) {
                this.s.a(this, this.f2785a, (ASTList) callExpr.oprand2());
                return;
            } else if (str.equals("$cflow")) {
                c((ASTList) callExpr.oprand2());
                return;
            }
        }
        super.a(callExpr);
    }

    protected void c(ASTList aSTList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aSTList == null || aSTList.tail() != null) {
            throw new CompileError("bad $cflow");
        }
        a(stringBuffer, aSTList.head());
        String stringBuffer2 = stringBuffer.toString();
        Object[] b = this.t.a().b(stringBuffer2);
        if (b == null) {
            throw new CompileError("no such $cflow: " + stringBuffer2);
        }
        this.f2785a.b((String) b[0], (String) b[1], "Ljavassist/runtime/Cflow;");
        this.f2785a.e("javassist.runtime.Cflow", "value", "()I");
        this.i = 324;
        this.j = 0;
        this.k = null;
    }

    private static void a(StringBuffer stringBuffer, ASTree aSTree) {
        if (aSTree instanceof Symbol) {
            stringBuffer.append(((Symbol) aSTree).get());
            return;
        }
        if (aSTree instanceof Expr) {
            Expr expr = (Expr) aSTree;
            if (expr.getOperator() == 46) {
                a(stringBuffer, expr.oprand1());
                stringBuffer.append('.');
                a(stringBuffer, expr.oprand2());
                return;
            }
        }
        throw new CompileError("bad $cflow");
    }

    @Override // javassist.compiler.MemberCodeGen
    public int d(ASTList aSTList) {
        int i;
        String str = this.n;
        int i2 = 0;
        while (aSTList != null) {
            ASTree head = aSTList.head();
            if ((head instanceof Member) && ((Member) head).get().equals(str)) {
                i = this.o != null ? this.o.length + i2 : i2;
            } else {
                i = i2 + 1;
            }
            aSTList = aSTList.tail();
            i2 = i;
        }
        return i2;
    }

    @Override // javassist.compiler.MemberCodeGen
    public void a(ASTList aSTList, int[] iArr, int[] iArr2, String[] strArr) {
        int i;
        javassist.h[] hVarArr = this.o;
        String str = this.n;
        int i2 = 0;
        while (aSTList != null) {
            ASTree head = aSTList.head();
            if ((head instanceof Member) && ((Member) head).get().equals(str)) {
                if (hVarArr != null) {
                    int length = hVarArr.length;
                    int i3 = 0;
                    i = i2;
                    int h = h();
                    while (i3 < length) {
                        javassist.h hVar = hVarArr[i3];
                        h += this.f2785a.a(h, hVar);
                        b(hVar);
                        iArr[i] = this.i;
                        iArr2[i] = this.j;
                        strArr[i] = this.k;
                        i3++;
                        i++;
                    }
                } else {
                    i = i2;
                }
            } else {
                head.accept(this);
                iArr[i2] = this.i;
                iArr2[i2] = this.j;
                strArr[i2] = this.k;
                i = i2 + 1;
            }
            aSTList = aSTList.tail();
            i2 = i;
        }
    }

    @Override // javassist.compiler.CodeGen
    protected void b(Stmnt stmnt) {
        ASTree left = stmnt.getLeft();
        if (left != null && this.p == javassist.h.l) {
            a(left);
            if (a(this.i, this.j)) {
                this.f2785a.g(88);
            } else if (this.i != 344) {
                this.f2785a.g(87);
            }
            left = null;
        }
        c(left);
    }

    public int a(javassist.h hVar, String str, String str2, SymbolTable symbolTable) {
        this.p = hVar;
        this.q = str;
        this.C = str2;
        if (str2 == null) {
            return -1;
        }
        int b = b();
        a(a(hVar, str2, b, symbolTable) + b);
        return b;
    }

    public void a(javassist.h hVar) {
        this.B = hVar;
    }

    public int a(javassist.h[] hVarArr, boolean z, String str, String str2, String str3, SymbolTable symbolTable) {
        return a(hVarArr, z, str, str2, str3, !z, 0, c(), symbolTable);
    }

    public int a(javassist.h[] hVarArr, boolean z, String str, String str2, String str3, boolean z2, int i, String str4, SymbolTable symbolTable) {
        this.o = hVarArr;
        this.m = str2;
        this.n = str3;
        this.y = i;
        this.z = z2;
        if (str4 != null) {
            this.A = MemberResolver.d(str4);
        }
        this.d = z;
        if (z2) {
            String str5 = str + SocialConstants.FALSE;
            symbolTable.append(str5, new Declarator(307, MemberResolver.c(str4), 0, i, new Symbol(str5)));
            i++;
        }
        for (int i2 = 0; i2 < hVarArr.length; i2++) {
            i += a(hVarArr[i2], str + (i2 + 1), i, symbolTable);
        }
        if (b() < i) {
            a(i);
        }
        return i;
    }

    private int a(javassist.h hVar, String str, int i, SymbolTable symbolTable) {
        if (hVar == javassist.h.l) {
            this.i = 307;
            this.j = 0;
            this.k = "java/lang/Object";
        } else {
            b(hVar);
        }
        symbolTable.append(str, new Declarator(this.i, this.k, this.j, i, new Symbol(str)));
        return a(this.i, this.j) ? 2 : 1;
    }

    public static int a(Bytecode bytecode, javassist.h[] hVarArr, int i) {
        int i2;
        if (hVarArr == null) {
            bytecode.m(0);
            bytecode.e("java.lang.Object");
            return 1;
        }
        javassist.h[] hVarArr2 = new javassist.h[1];
        int length = hVarArr.length;
        bytecode.m(length);
        bytecode.e("java.lang.Object");
        int i3 = 0;
        while (i3 < length) {
            bytecode.g(89);
            bytecode.m(i3);
            if (hVarArr[i3].m()) {
                CtPrimitiveType ctPrimitiveType = (CtPrimitiveType) hVarArr[i3];
                String z = ctPrimitiveType.z();
                bytecode.d(z);
                bytecode.g(89);
                hVarArr2[0] = ctPrimitiveType;
                bytecode.c(z, MethodDecl.initName, z.a(javassist.h.l, hVarArr2));
                i2 = bytecode.a(i, ctPrimitiveType) + i;
            } else {
                bytecode.k(i);
                i2 = i + 1;
            }
            bytecode.g(83);
            i3++;
            i = i2;
        }
        return 8;
    }

    protected void a(javassist.h hVar, Bytecode bytecode) {
        if (hVar == javassist.h.l) {
            f();
        } else if (this.i == 344) {
            throw new CompileError("invalid type for " + this.q);
        } else {
            if (hVar instanceof CtPrimitiveType) {
                CtPrimitiveType ctPrimitiveType = (CtPrimitiveType) hVar;
                String z = ctPrimitiveType.z();
                bytecode.a(z);
                bytecode.e(z, ctPrimitiveType.A(), ctPrimitiveType.B());
                b(hVar);
                return;
            }
            bytecode.a(hVar);
            b(hVar);
        }
    }

    public void b(javassist.h hVar) {
        a(hVar, 0);
    }

    private void a(javassist.h hVar, int i) {
        if (hVar.m()) {
            this.i = MemberResolver.a(((CtPrimitiveType) hVar).y());
            this.j = i;
            this.k = null;
        } else if (hVar.b()) {
            try {
                a(hVar.e(), i + 1);
            } catch (NotFoundException e) {
                throw new CompileError("undefined type: " + hVar.n());
            }
        } else {
            this.i = 307;
            this.j = i;
            this.k = MemberResolver.c(hVar.n());
        }
    }
}
