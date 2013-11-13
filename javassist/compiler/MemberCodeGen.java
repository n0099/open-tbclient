package javassist.compiler;

import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.location.BDLocation;
import java.util.ArrayList;
import javassist.CtField;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ad;
import javassist.bytecode.an;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.Symbol;
import javassist.v;
/* loaded from: classes.dex */
public class MemberCodeGen extends CodeGen {
    protected MemberResolver t;
    protected javassist.h u;
    protected an v;
    protected boolean w;

    public MemberCodeGen(Bytecode bytecode, javassist.h hVar, javassist.c cVar) {
        super(bytecode);
        this.t = new MemberResolver(cVar);
        this.u = hVar;
        this.v = null;
    }

    public int g() {
        javassist.bytecode.i h = this.u.h();
        return h == null ? javassist.bytecode.i.n : h.m();
    }

    public void a(CtMethod ctMethod) {
        this.v = ctMethod.a();
        if (this.b != null) {
            this.b.a(this.v);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.CodeGen
    public String c() {
        return MemberResolver.c(this.u.n());
    }

    @Override // javassist.compiler.CodeGen
    protected String d() {
        return MemberResolver.c(MemberResolver.a(this.u).n());
    }

    @Override // javassist.compiler.CodeGen
    protected void e() {
        this.f2833a.k(0);
        this.f2833a.c(MemberResolver.a(this.u), MethodDecl.initName, "()V");
    }

    @Override // javassist.compiler.CodeGen
    protected void c(Stmnt stmnt) {
        boolean z;
        Bytecode bytecode = this.f2833a;
        Stmnt stmnt2 = (Stmnt) stmnt.getLeft();
        if (stmnt2 != null) {
            ASTList aSTList = (ASTList) stmnt.getRight().getLeft();
            Stmnt stmnt3 = (Stmnt) stmnt.getRight().getRight().getLeft();
            ArrayList arrayList = new ArrayList();
            e eVar = null;
            if (stmnt3 != null) {
                eVar = new e(this);
            }
            int h = bytecode.h();
            stmnt2.accept(this);
            int h2 = bytecode.h();
            if (h == h2) {
                throw new CompileError("empty try block");
            }
            boolean z2 = !this.c;
            if (z2) {
                bytecode.g(BDLocation.TypeServerError);
                arrayList.add(new Integer(bytecode.h()));
                bytecode.j(0);
            }
            int b = b();
            b(1);
            while (aSTList != null) {
                Pair pair = (Pair) aSTList.head();
                ASTList tail = aSTList.tail();
                Declarator declarator = (Declarator) pair.getLeft();
                Stmnt stmnt4 = (Stmnt) pair.getRight();
                declarator.setLocalVar(b);
                javassist.h a2 = this.t.a(declarator.getClassName());
                declarator.setClassName(MemberResolver.c(a2.n()));
                bytecode.a(h, h2, bytecode.h(), a2);
                bytecode.h(1);
                bytecode.l(b);
                this.c = false;
                if (stmnt4 != null) {
                    stmnt4.accept(this);
                }
                if (this.c) {
                    z = z2;
                } else {
                    bytecode.g(BDLocation.TypeServerError);
                    arrayList.add(new Integer(bytecode.h()));
                    bytecode.j(0);
                    z = true;
                }
                z2 = z;
                aSTList = tail;
            }
            if (stmnt3 != null) {
                eVar.a(this);
                int h3 = bytecode.h();
                bytecode.b(h, h3, h3, 0);
                bytecode.h(1);
                bytecode.l(b);
                this.c = false;
                stmnt3.accept(this);
                if (!this.c) {
                    bytecode.k(b);
                    bytecode.g(191);
                }
                a(eVar.f2842a, stmnt3);
            }
            a(arrayList, bytecode.h());
            this.c = !z2;
            if (stmnt3 != null && z2) {
                stmnt3.accept(this);
            }
        }
    }

    private void a(ArrayList arrayList, Stmnt stmnt) {
        Bytecode bytecode = this.f2833a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            int[] iArr = (int[]) arrayList.get(i);
            int i2 = iArr[0];
            bytecode.c(i2, (bytecode.h() - i2) + 1);
            f fVar = new f(this, iArr);
            stmnt.accept(this);
            fVar.a(this);
            if (!this.c) {
                bytecode.g(BDLocation.TypeServerError);
                bytecode.j((i2 + 3) - bytecode.h());
            }
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(NewExpr newExpr) {
        if (newExpr.isArray()) {
            b(newExpr);
            return;
        }
        javassist.h a2 = this.t.a(newExpr.getClassName());
        String n = a2.n();
        ASTList arguments = newExpr.getArguments();
        this.f2833a.d(n);
        this.f2833a.g(89);
        a(a2, MethodDecl.initName, arguments, false, true, -1, (g) null);
        this.i = 307;
        this.j = 0;
        this.k = MemberResolver.c(n);
    }

    public void b(NewExpr newExpr) {
        int arrayType = newExpr.getArrayType();
        ASTList arraySize = newExpr.getArraySize();
        ASTList className = newExpr.getClassName();
        ArrayInit initializer = newExpr.getInitializer();
        if (arraySize.length() > 1) {
            if (initializer != null) {
                throw new CompileError("sorry, multi-dimensional array initializer for new is not supported");
            }
            a(arrayType, className, arraySize);
            return;
        }
        a(arrayType, arraySize.head(), Declarator.astToClassName(className, '/'), initializer);
    }

    private void a(int i, ASTree aSTree, String str, ArrayInit arrayInit) {
        String str2;
        int i2;
        if (arrayInit == null) {
            if (aSTree == null) {
                throw new CompileError("no array size");
            }
            aSTree.accept(this);
        } else if (aSTree == null) {
            this.f2833a.m(arrayInit.length());
        } else {
            throw new CompileError("unnecessary array size specified for new");
        }
        if (i == 307) {
            String a2 = a(str);
            this.f2833a.e(MemberResolver.d(a2));
            str2 = a2;
        } else {
            str2 = null;
            switch (i) {
                case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
                    i2 = 4;
                    break;
                case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                    i2 = 8;
                    break;
                case 306:
                    i2 = 5;
                    break;
                case 312:
                    i2 = 7;
                    break;
                case 317:
                    i2 = 6;
                    break;
                case 324:
                    i2 = 10;
                    break;
                case 326:
                    i2 = 11;
                    break;
                case 334:
                    i2 = 9;
                    break;
                default:
                    i2 = 0;
                    f();
                    break;
            }
            this.f2833a.g(188);
            this.f2833a.a(i2);
        }
        if (arrayInit != null) {
            int length = arrayInit.length();
            int i3 = 0;
            ArrayInit arrayInit2 = arrayInit;
            while (i3 < length) {
                this.f2833a.g(89);
                this.f2833a.m(i3);
                arrayInit2.head().accept(this);
                if (!d(i)) {
                    d(this.i, i);
                }
                this.f2833a.g(f(i, 0));
                i3++;
                arrayInit2 = arrayInit2.tail();
            }
        }
        this.i = i;
        this.j = 1;
        this.k = str2;
    }

    private static void f() {
        throw new CompileError("bad new expression");
    }

    @Override // javassist.compiler.CodeGen
    protected void a(ArrayInit arrayInit, int i, int i2, String str) {
        a(i, (ASTree) null, str, arrayInit);
    }

    @Override // javassist.compiler.ast.a
    public void a(ArrayInit arrayInit) {
        throw new CompileError("array initializer is not supported");
    }

    protected void a(int i, ASTList aSTList, ASTList aSTList2) {
        String b;
        int length = aSTList2.length();
        int i2 = 0;
        while (aSTList2 != null) {
            ASTree head = aSTList2.head();
            if (head == null) {
                break;
            }
            int i3 = i2 + 1;
            head.accept(this);
            if (this.i == 324) {
                aSTList2 = aSTList2.tail();
                i2 = i3;
            } else {
                throw new CompileError("bad type for array size");
            }
        }
        this.i = i;
        this.j = length;
        if (i == 307) {
            this.k = a(aSTList);
            b = a(this.k, length);
        } else {
            b = b(i, length);
        }
        this.f2833a.a(b, i2);
    }

    @Override // javassist.compiler.ast.a
    public void a(CallExpr callExpr) {
        int i;
        javassist.h hVar;
        String str;
        boolean z;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        ASTree oprand1 = callExpr.oprand1();
        ASTList aSTList = (ASTList) callExpr.oprand2();
        g method = callExpr.getMethod();
        if (oprand1 instanceof Member) {
            String str2 = ((Member) oprand1).get();
            hVar = this.u;
            if (this.d || (method != null && method.a())) {
                i = -1;
                str = str2;
                z = false;
            } else {
                i = this.f2833a.h();
                this.f2833a.k(0);
                z3 = false;
                str = str2;
                z = false;
            }
        } else if (oprand1 instanceof Keyword) {
            hVar = this.u;
            if (this.d) {
                throw new CompileError("a constructor cannot be static");
            }
            this.f2833a.k(0);
            if (((Keyword) oprand1).get() != 336) {
                i = -1;
                z3 = false;
                str = MethodDecl.initName;
                z = true;
            } else {
                hVar = MemberResolver.a(hVar);
                i = -1;
                z3 = false;
                str = MethodDecl.initName;
                z = true;
            }
        } else if (!(oprand1 instanceof Expr)) {
            i = -1;
            z3 = false;
            hVar = null;
            str = null;
            z = false;
            a();
        } else {
            Expr expr = (Expr) oprand1;
            String str3 = ((Symbol) expr.oprand2()).get();
            int operator = expr.getOperator();
            if (operator == 35) {
                hVar = this.t.a(((Symbol) expr.oprand1()).get(), false);
            } else if (operator == 46) {
                ASTree oprand12 = expr.oprand1();
                boolean z5 = (oprand12 instanceof Keyword) && ((Keyword) oprand12).get() == 336;
                try {
                    oprand12.accept(this);
                    z2 = false;
                } catch (NoFieldException e) {
                    if (e.getExpr() != oprand12) {
                        throw e;
                    }
                    this.i = 307;
                    this.j = 0;
                    this.k = e.getField();
                    z2 = true;
                }
                if (this.j > 0) {
                    hVar = this.t.a("java.lang.Object", true);
                } else if (this.i == 307) {
                    hVar = this.t.a(this.k);
                } else {
                    hVar = null;
                    h();
                }
                z4 = z5;
                z3 = z2;
            } else {
                z3 = false;
                hVar = null;
                h();
            }
            i = -1;
            z = z4;
            str = str3;
        }
        a(hVar, str, aSTList, z3, z, i, method);
    }

    private static void h() {
        throw new CompileError("bad method");
    }

    public void a(javassist.h hVar, String str, ASTList aSTList, boolean z, boolean z2, int i, g gVar) {
        String str2;
        int d = d(aSTList);
        int[] iArr = new int[d];
        int[] iArr2 = new int[d];
        String[] strArr = new String[d];
        if (!z && gVar != null && gVar.a()) {
            this.f2833a.g(87);
            z = true;
        }
        int i2 = this.f2833a.i();
        a(aSTList, iArr, iArr2, strArr);
        int i3 = (this.f2833a.i() - i2) + 1;
        g a2 = gVar == null ? this.t.a(hVar, this.u, this.v, str, iArr, iArr2, strArr) : gVar;
        if (a2 == null) {
            if (str.equals(MethodDecl.initName)) {
                str2 = "constructor not found";
            } else {
                str2 = "Method " + str + " not found in " + hVar.n();
            }
            throw new CompileError(str2);
        }
        a(hVar, str, z, z2, i, i3, a2);
    }

    private void a(javassist.h hVar, String str, boolean z, boolean z2, int i, int i2, g gVar) {
        String b;
        int b2;
        boolean z3;
        javassist.h hVar2 = gVar.f2844a;
        an anVar = gVar.b;
        String g = anVar.g();
        int f = anVar.f();
        if (str.equals(MethodDecl.initName)) {
            z2 = true;
            if (hVar2 != hVar) {
                throw new CompileError("no such constructor: " + hVar.n());
            }
            if (hVar2 != this.u && javassist.bytecode.a.c(f)) {
                String a2 = a(g, hVar2, anVar);
                this.f2833a.g(1);
                b = a2;
                z3 = z;
                b2 = f;
            }
            b = g;
            z3 = z;
            b2 = f;
        } else {
            if (javassist.bytecode.a.c(f)) {
                if (hVar2 == this.u) {
                    z2 = true;
                    b = g;
                    z3 = z;
                    b2 = f;
                } else {
                    z2 = false;
                    b = (f & 8) == 0 ? z.b(hVar2.n(), g) : g;
                    str = a(str, g, b, anVar, hVar2);
                    b2 = javassist.bytecode.a.b(f) | 8;
                    z3 = true;
                }
            }
            b = g;
            z3 = z;
            b2 = f;
        }
        boolean z4 = false;
        if ((b2 & 8) != 0) {
            if (!z3) {
                z3 = true;
                if (i >= 0) {
                    this.f2833a.a(i, 0);
                } else {
                    z4 = true;
                }
            }
            this.f2833a.d(hVar2, str, b);
        } else if (z2) {
            this.f2833a.c(hVar2, str, b);
        } else {
            if (!v.a(hVar2.c()) || hVar2.q() != hVar.q()) {
                hVar2 = hVar;
            }
            if (hVar2.q()) {
                this.f2833a.a(hVar2, str, b, i2);
            } else if (z3) {
                throw new CompileError(str + " is not static");
            } else {
                this.f2833a.e(hVar2, str, b);
            }
        }
        a(b, z3, z4);
    }

    protected String a(String str, String str2, String str3, an anVar, javassist.h hVar) {
        a i;
        if (a(hVar, this.u) && (i = hVar.i()) != null) {
            return i.a(str, str2, str3, anVar);
        }
        throw new CompileError("Method " + str + " is private");
    }

    protected String a(String str, javassist.h hVar, an anVar) {
        a i;
        if (a(hVar, this.u) && (i = hVar.i()) != null) {
            return i.a(hVar, str, anVar);
        }
        throw new CompileError("the called constructor is private in " + hVar.n());
    }

    private boolean a(javassist.h hVar, javassist.h hVar2) {
        while (hVar2 != null) {
            try {
                hVar2 = hVar2.r();
                if (hVar2 == hVar) {
                    return true;
                }
            } catch (NotFoundException e) {
            }
        }
        return false;
    }

    public int d(ASTList aSTList) {
        return ASTList.length(aSTList);
    }

    public void a(ASTList aSTList, int[] iArr, int[] iArr2, String[] strArr) {
        int i = 0;
        while (aSTList != null) {
            aSTList.head().accept(this);
            iArr[i] = this.i;
            iArr2[i] = this.j;
            strArr[i] = this.k;
            i++;
            aSTList = aSTList.tail();
        }
    }

    void a(String str, boolean z, boolean z2) {
        int indexOf = str.indexOf(41);
        if (indexOf < 0) {
            h();
        }
        int i = indexOf + 1;
        char charAt = str.charAt(i);
        int i2 = 0;
        while (charAt == '[') {
            i2++;
            i++;
            charAt = str.charAt(i);
        }
        this.j = i2;
        if (charAt == 'L') {
            int indexOf2 = str.indexOf(59, i + 1);
            if (indexOf2 < 0) {
                h();
            }
            this.i = 307;
            this.k = str.substring(i + 1, indexOf2);
        } else {
            this.i = MemberResolver.a(charAt);
            this.k = null;
        }
        int i3 = this.i;
        if (z && z2) {
            if (a(i3, i2)) {
                this.f2833a.g(93);
                this.f2833a.g(88);
                this.f2833a.g(87);
            } else if (i3 == 344) {
                this.f2833a.g(87);
            } else {
                this.f2833a.g(95);
                this.f2833a.g(87);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.CodeGen
    public void a(Expr expr, int i, ASTree aSTree, ASTree aSTree2, boolean z) {
        int a2;
        int i2;
        int i3;
        CtField a3 = a(aSTree, false);
        boolean z2 = this.w;
        if (i != 61 && !z2) {
            this.f2833a.g(89);
        }
        if (i == 61) {
            ad a4 = a3.a();
            a(a4);
            if (a(a3, a4) == null) {
                i3 = b(a3, a4);
            } else {
                i3 = 0;
            }
            a2 = i3;
        } else {
            a2 = a(a3, z2);
        }
        int i4 = this.i;
        int i5 = this.j;
        String str = this.k;
        a(expr, i, aSTree2, i4, i5, str);
        boolean a5 = a(i4, i5);
        if (z) {
            if (z2) {
                i2 = a5 ? 92 : 89;
            } else {
                i2 = a5 ? 93 : 90;
            }
            this.f2833a.g(i2);
        }
        a(a3, z2, a2, a5);
        this.i = i4;
        this.j = i5;
        this.k = str;
    }

    private void a(CtField ctField, boolean z, int i, boolean z2) {
        if (i != 0) {
            if (z) {
                this.f2833a.a(179);
                this.f2833a.h(z2 ? -2 : -1);
            } else {
                this.f2833a.a(181);
                this.f2833a.h(z2 ? -3 : -2);
            }
            this.f2833a.j(i);
            return;
        }
        javassist.h c = ctField.c();
        an b = c.i().b(ctField.a(), z);
        this.f2833a.d(c, b.a(), b.g());
    }

    @Override // javassist.compiler.ast.a
    public void a(Member member) {
        e(member);
    }

    @Override // javassist.compiler.CodeGen
    protected void e(ASTree aSTree) {
        CtField a2 = a(aSTree, true);
        if (a2 == null) {
            f(aSTree);
            return;
        }
        boolean z = this.w;
        ASTree a3 = TypeChecker.a(a2);
        if (a3 == null) {
            a(a2, z);
            return;
        }
        a3.accept(this);
        a(a2.a());
    }

    private void f(ASTree aSTree) {
        if (this.j == 0) {
            throw new CompileError(".length applied to a non array");
        }
        this.f2833a.g(190);
        this.i = 324;
        this.j = 0;
    }

    private int a(CtField ctField, boolean z) {
        ad a2 = ctField.a();
        boolean a3 = a(a2);
        a a4 = a(ctField, a2);
        if (a4 != null) {
            an a5 = a4.a(a2, z);
            this.f2833a.d(ctField.c(), a5.a(), a5.g());
            return 0;
        }
        int b = b(ctField, a2);
        if (z) {
            this.f2833a.a(178);
            this.f2833a.h(a3 ? 2 : 1);
        } else {
            this.f2833a.a(180);
            this.f2833a.h(a3 ? 1 : 0);
        }
        this.f2833a.j(b);
        return b;
    }

    private a a(CtField ctField, ad adVar) {
        if (javassist.bytecode.a.c(adVar.c()) && ctField.c() != this.u) {
            javassist.h c = ctField.c();
            if (a(c, this.u)) {
                a i = c.i();
                if (i == null) {
                    throw new CompileError("fatal error.  bug?");
                }
                return i;
            }
            throw new CompileError("Field " + ctField.i() + " in " + c.n() + " is private.");
        }
        return null;
    }

    private boolean a(ad adVar) {
        String d = adVar.d();
        char charAt = d.charAt(0);
        int i = 0;
        int i2 = 0;
        while (charAt == '[') {
            i++;
            i2++;
            charAt = d.charAt(i2);
        }
        this.j = i;
        this.i = MemberResolver.a(charAt);
        if (charAt == 'L') {
            this.k = d.substring(i2 + 1, d.indexOf(59, i2 + 1));
        } else {
            this.k = null;
        }
        return charAt == 'J' || charAt == 'D';
    }

    private int b(CtField ctField, ad adVar) {
        y c = this.f2833a.c();
        return c.a(c.a(ctField.c().n()), adVar.b(), adVar.d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.CodeGen
    public void b(String str) {
        if (g() < 49) {
            super.b(str);
        } else {
            this.f2833a.v(this.f2833a.c().a(str));
        }
    }

    @Override // javassist.compiler.CodeGen
    protected void a(int i, boolean z, ASTree aSTree, Expr expr, boolean z2) {
        int i2;
        CtField a2 = a(aSTree, false);
        boolean z3 = this.w;
        if (!z3) {
            this.f2833a.g(89);
        }
        int a3 = a(a2, z3);
        boolean a4 = a(this.i, this.j);
        if (z3) {
            i2 = a4 ? 92 : 89;
        } else {
            i2 = a4 ? 93 : 90;
        }
        a(i2, z2, i, z, expr);
        a(a2, z3, a3, a4);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x0076 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [javassist.CtField] */
    /* JADX WARN: Type inference failed for: r0v4, types: [javassist.compiler.ast.Expr] */
    /* JADX WARN: Type inference failed for: r0v5, types: [javassist.compiler.ast.Expr] */
    protected CtField a(ASTree aSTree, boolean z) {
        CtField ctField;
        if (aSTree instanceof Member) {
            String str = ((Member) aSTree).get();
            try {
                CtField a2 = this.u.a(str);
                boolean d = v.d(a2.b());
                if (!d) {
                    if (this.d) {
                        throw new CompileError("not available in a static method: " + str);
                    }
                    this.f2833a.k(0);
                }
                this.w = d;
                return a2;
            } catch (NotFoundException e) {
                throw new NoFieldException(str, aSTree);
            }
        }
        if (aSTree instanceof Expr) {
            ?? r0 = (Expr) aSTree;
            int operator = r0.getOperator();
            if (operator == 35) {
                CtField b = this.t.b(((Symbol) r0.oprand1()).get(), (Symbol) r0.oprand2());
                this.w = true;
                return b;
            } else if (operator == 46) {
                try {
                    r0.oprand1().accept(this);
                    if (this.i == 307 && this.j == 0) {
                        ctField = this.t.a(this.k, (Symbol) r0.oprand2());
                    } else if (z && this.j > 0 && ((Symbol) r0.oprand2()).get().equals("length")) {
                        return null;
                    } else {
                        ctField = null;
                        i();
                    }
                    boolean d2 = v.d(ctField.b());
                    if (d2) {
                        this.f2833a.g(87);
                    }
                    this.w = d2;
                    r0 = ctField;
                    return r0;
                } catch (NoFieldException e2) {
                    if (e2.getExpr() != r0.oprand1()) {
                        throw e2;
                    }
                    CtField a3 = this.t.a(e2.getField(), (Symbol) r0.oprand2(), aSTree);
                    this.w = true;
                    return a3;
                }
            } else {
                i();
            }
        } else {
            i();
        }
        this.w = false;
        return null;
    }

    private static void i() {
        throw new CompileError("bad l-value");
    }

    @Override // javassist.compiler.CodeGen
    protected String a(ASTList aSTList) {
        return this.t.b(aSTList);
    }

    @Override // javassist.compiler.CodeGen
    protected String a(String str) {
        return this.t.b(str);
    }
}
