package javassist.compiler;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.BVideoView;
import javassist.CtField;
import javassist.NotFoundException;
import javassist.bytecode.an;
import javassist.bytecode.as;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.AssignExpr;
import javassist.compiler.ast.BinExpr;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.CondExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;
import javassist.v;
/* loaded from: classes.dex */
public class TypeChecker extends javassist.compiler.ast.a implements as, j {

    /* renamed from: a  reason: collision with root package name */
    protected int f2790a;
    protected int b;
    protected String c;
    protected MemberResolver d;
    protected javassist.h e;
    protected an g = null;

    public TypeChecker(javassist.h hVar, javassist.c cVar) {
        this.d = new MemberResolver(cVar);
        this.e = hVar;
    }

    protected static String a(int[] iArr, int[] iArr2, String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        int length = iArr.length;
        if (length > 0) {
            int i = 0;
            while (true) {
                a(stringBuffer, iArr[i], iArr2[i], strArr[i]);
                i++;
                if (i >= length) {
                    break;
                }
                stringBuffer.append(',');
            }
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    protected static StringBuffer a(StringBuffer stringBuffer, int i, int i2, String str) {
        String str2;
        if (i == 307) {
            str2 = MemberResolver.d(str);
        } else if (i == 412) {
            str2 = "Object";
        } else {
            try {
                str2 = MemberResolver.a(i);
            } catch (CompileError e) {
                str2 = "?";
            }
        }
        stringBuffer.append(str2);
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                stringBuffer.append("[]");
                i2 = i3;
            } else {
                return stringBuffer;
            }
        }
    }

    public void a(an anVar) {
        this.g = anVar;
    }

    protected static void b() {
        throw new CompileError("fatal");
    }

    protected String c() {
        return MemberResolver.c(this.e.n());
    }

    protected String d() {
        return MemberResolver.c(MemberResolver.a(this.e).n());
    }

    protected String d(ASTList aSTList) {
        return this.d.b(aSTList);
    }

    @Override // javassist.compiler.ast.a
    public void a(NewExpr newExpr) {
        if (newExpr.isArray()) {
            b(newExpr);
            return;
        }
        javassist.h a2 = this.d.a(newExpr.getClassName());
        String n = a2.n();
        a(a2, MethodDecl.initName, newExpr.getArguments());
        this.f2790a = 307;
        this.b = 0;
        this.c = MemberResolver.c(n);
    }

    public void b(NewExpr newExpr) {
        int arrayType = newExpr.getArrayType();
        ASTList arraySize = newExpr.getArraySize();
        ASTList className = newExpr.getClassName();
        ArrayInit initializer = newExpr.getInitializer();
        if (initializer != null) {
            initializer.accept(this);
        }
        if (arraySize.length() > 1) {
            a(arrayType, className, arraySize);
            return;
        }
        ASTree head = arraySize.head();
        if (head != null) {
            head.accept(this);
        }
        this.f2790a = arrayType;
        this.b = 1;
        if (arrayType == 307) {
            this.c = d(className);
        } else {
            this.c = null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:9:0x0000 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [javassist.compiler.ast.ArrayInit] */
    /* JADX WARN: Type inference failed for: r2v1, types: [javassist.compiler.ast.ASTList] */
    /* JADX WARN: Type inference failed for: r2v2, types: [javassist.compiler.ast.ASTList] */
    @Override // javassist.compiler.ast.a
    public void a(ArrayInit arrayInit) {
        while (arrayInit != 0) {
            ASTree head = arrayInit.head();
            arrayInit = arrayInit.tail();
            if (head != null) {
                head.accept(this);
            }
        }
    }

    protected void a(int i, ASTList aSTList, ASTList aSTList2) {
        int length = aSTList2.length();
        int i2 = 0;
        while (aSTList2 != null) {
            ASTree head = aSTList2.head();
            if (head == null) {
                break;
            }
            i2++;
            head.accept(this);
            aSTList2 = aSTList2.tail();
        }
        this.f2790a = i;
        this.b = length;
        if (i == 307) {
            this.c = d(aSTList);
        } else {
            this.c = null;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(AssignExpr assignExpr) {
        int operator = assignExpr.getOperator();
        ASTree oprand1 = assignExpr.oprand1();
        ASTree oprand2 = assignExpr.oprand2();
        if (oprand1 instanceof Variable) {
            a(assignExpr, operator, (Variable) oprand1, ((Variable) oprand1).getDeclarator(), oprand2);
        } else if ((oprand1 instanceof Expr) && ((Expr) oprand1).getOperator() == 65) {
            a((Expr) assignExpr, operator, (Expr) oprand1, oprand2);
        } else {
            a(assignExpr, operator, oprand1, oprand2);
        }
    }

    private void a(Expr expr, int i, Variable variable, Declarator declarator, ASTree aSTree) {
        int type = declarator.getType();
        int arrayDim = declarator.getArrayDim();
        String className = declarator.getClassName();
        if (i != 61) {
            a(variable);
        }
        aSTree.accept(this);
        this.f2790a = type;
        this.b = arrayDim;
        this.c = className;
    }

    private void a(Expr expr, int i, Expr expr2, ASTree aSTree) {
        a(expr2.oprand1(), expr2.oprand2());
        int i2 = this.f2790a;
        int i3 = this.b;
        String str = this.c;
        aSTree.accept(this);
        this.f2790a = i2;
        this.b = i3;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Expr expr, int i, ASTree aSTree, ASTree aSTree2) {
        b(b(aSTree));
        int i2 = this.f2790a;
        int i3 = this.b;
        String str = this.c;
        aSTree2.accept(this);
        this.f2790a = i2;
        this.b = i3;
        this.c = str;
    }

    @Override // javassist.compiler.ast.a
    public void a(CondExpr condExpr) {
        e(condExpr.condExpr());
        condExpr.thenExpr().accept(this);
        int i = this.f2790a;
        int i2 = this.b;
        String str = this.c;
        condExpr.elseExpr().accept(this);
        if (i2 == 0 && i2 == this.b) {
            if (CodeGen.c(i, this.f2790a)) {
                condExpr.setThen(new CastExpr(this.f2790a, 0, condExpr.thenExpr()));
            } else if (CodeGen.c(this.f2790a, i)) {
                condExpr.setElse(new CastExpr(i, 0, condExpr.elseExpr()));
                this.f2790a = i;
            }
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(BinExpr binExpr) {
        int operator = binExpr.getOperator();
        if (CodeGen.c(operator) >= 0) {
            if (operator == 43) {
                Expr b = b(binExpr);
                if (b != null) {
                    binExpr.setOprand1(CallExpr.makeCall(Expr.make(46, b, new Member("toString")), null));
                    binExpr.setOprand2(null);
                    this.c = "java/lang/String";
                    return;
                }
                return;
            }
            ASTree oprand1 = binExpr.oprand1();
            ASTree oprand2 = binExpr.oprand2();
            oprand1.accept(this);
            int i = this.f2790a;
            oprand2.accept(this);
            if (!a(binExpr, operator, oprand1, oprand2)) {
                a(binExpr, operator, i);
                return;
            }
            return;
        }
        e(binExpr);
    }

    private Expr b(BinExpr binExpr) {
        ASTree oprand1 = binExpr.oprand1();
        ASTree oprand2 = binExpr.oprand2();
        if (oprand2 == null) {
            oprand1.accept(this);
            return null;
        }
        if (d(oprand1)) {
            Expr b = b((BinExpr) oprand1);
            if (b != null) {
                oprand2.accept(this);
                this.f2790a = 307;
                this.b = 0;
                this.c = "java/lang/StringBuffer";
                return b(b, oprand2);
            }
        } else {
            oprand1.accept(this);
        }
        int i = this.f2790a;
        int i2 = this.b;
        String str = this.c;
        oprand2.accept(this);
        if (a(binExpr, 43, oprand1, oprand2)) {
            return null;
        }
        if ((i == 307 && i2 == 0 && "java/lang/String".equals(str)) || (this.f2790a == 307 && this.b == 0 && "java/lang/String".equals(this.c))) {
            NewExpr newExpr = new NewExpr(ASTList.make(new Symbol("java"), new Symbol("lang"), new Symbol("StringBuffer")), null);
            this.f2790a = 307;
            this.b = 0;
            this.c = "java/lang/StringBuffer";
            return b(b(newExpr, oprand1), oprand2);
        }
        a(binExpr, 43, i);
        return null;
    }

    private boolean a(BinExpr binExpr, int i, ASTree aSTree, ASTree aSTree2) {
        ASTree compute;
        ASTree a2 = a(aSTree);
        ASTree a3 = a(aSTree2);
        if ((a2 instanceof StringL) && (a3 instanceof StringL) && i == 43) {
            compute = new StringL(((StringL) a2).get() + ((StringL) a3).get());
        } else if (a2 instanceof IntConst) {
            compute = ((IntConst) a2).compute(i, a3);
        } else {
            compute = a2 instanceof DoubleConst ? ((DoubleConst) a2).compute(i, a3) : null;
        }
        if (compute == null) {
            return false;
        }
        binExpr.setOperator(43);
        binExpr.setOprand1(compute);
        binExpr.setOprand2(null);
        compute.accept(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASTree a(ASTree aSTree) {
        ASTree b;
        if (aSTree instanceof BinExpr) {
            BinExpr binExpr = (BinExpr) aSTree;
            if (binExpr.getOperator() == 43 && binExpr.oprand2() == null) {
                return binExpr.getLeft();
            }
            return aSTree;
        } else if (!(aSTree instanceof Expr)) {
            return (!(aSTree instanceof Member) || (b = b((Member) aSTree)) == null) ? aSTree : b;
        } else {
            Expr expr = (Expr) aSTree;
            int operator = expr.getOperator();
            if (operator == 35) {
                ASTree b2 = b((Member) expr.oprand2());
                return b2 != null ? b2 : aSTree;
            } else if (operator == 43 && expr.getRight() == null) {
                return expr.getLeft();
            } else {
                return aSTree;
            }
        }
    }

    private static ASTree b(Member member) {
        return a(member.getField());
    }

    public static ASTree a(CtField ctField) {
        Object f;
        if (ctField != null && (f = ctField.f()) != null) {
            if (f instanceof String) {
                return new StringL((String) f);
            }
            if ((f instanceof Double) || (f instanceof Float)) {
                return new DoubleConst(((Number) f).doubleValue(), f instanceof Double ? BdWebErrorView.ERROR_CODE_405 : BdWebErrorView.ERROR_CODE_404);
            } else if (f instanceof Number) {
                return new IntConst(((Number) f).longValue(), f instanceof Long ? BdWebErrorView.ERROR_CODE_403 : 402);
            } else if (f instanceof Boolean) {
                return new Keyword(((Boolean) f).booleanValue() ? BdWebErrorView.ERROR_CODE_410 : BdWebErrorView.ERROR_CODE_411);
            } else {
                return null;
            }
        }
        return null;
    }

    private static boolean d(ASTree aSTree) {
        return (aSTree instanceof BinExpr) && ((BinExpr) aSTree).getOperator() == 43;
    }

    private static Expr b(ASTree aSTree, ASTree aSTree2) {
        return CallExpr.makeCall(Expr.make(46, aSTree, new Member("append")), new ASTList(aSTree2));
    }

    private void a(BinExpr binExpr, int i, int i2) {
        int i3 = this.f2790a;
        if (i == 364 || i == 366 || i == 370) {
            this.f2790a = i2;
        } else {
            b(binExpr, i2, i3);
        }
        if (CodeGen.e(this.f2790a)) {
            this.f2790a = 324;
        }
    }

    private void e(ASTree aSTree) {
        int d = CodeGen.d(aSTree);
        if (d == 358) {
            BinExpr binExpr = (BinExpr) aSTree;
            binExpr.oprand1().accept(this);
            int i = this.f2790a;
            int i2 = this.b;
            binExpr.oprand2().accept(this);
            if (i2 == 0 && this.b == 0) {
                b(binExpr, i, this.f2790a);
            }
        } else if (d == 33) {
            ((Expr) aSTree).oprand1().accept(this);
        } else if (d == 369 || d == 368) {
            BinExpr binExpr2 = (BinExpr) aSTree;
            binExpr2.oprand1().accept(this);
            binExpr2.oprand2().accept(this);
        } else {
            aSTree.accept(this);
        }
        this.f2790a = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
        this.b = 0;
    }

    private void b(BinExpr binExpr, int i, int i2) {
        if (CodeGen.c(i, i2)) {
            binExpr.setLeft(new CastExpr(i2, 0, binExpr.oprand1()));
        } else {
            this.f2790a = i;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(CastExpr castExpr) {
        String d = d(castExpr.getClassName());
        castExpr.getOprand().accept(this);
        this.f2790a = castExpr.getType();
        this.b = castExpr.getArrayDim();
        this.c = d;
    }

    @Override // javassist.compiler.ast.a
    public void a(InstanceOfExpr instanceOfExpr) {
        instanceOfExpr.getOprand().accept(this);
        this.f2790a = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
        this.b = 0;
    }

    @Override // javassist.compiler.ast.a
    public void c(Expr expr) {
        int operator = expr.getOperator();
        ASTree oprand1 = expr.oprand1();
        if (operator == 46) {
            String str = ((Symbol) expr.oprand2()).get();
            if (str.equals("length")) {
                try {
                    b(expr);
                } catch (NoFieldException e) {
                    f(expr);
                }
            } else if (str.equals("class")) {
                a(expr);
            } else {
                f(expr);
            }
        } else if (operator == 35) {
            if (((Symbol) expr.oprand2()).get().equals("class")) {
                a(expr);
            } else {
                f(expr);
            }
        } else if (operator == 65) {
            a(oprand1, expr.oprand2());
        } else if (operator == 362 || operator == 363) {
            a(operator, oprand1, expr);
        } else if (operator == 33) {
            e(expr);
        } else if (operator == 67) {
            b();
        } else {
            oprand1.accept(this);
            if (!a(expr, operator, oprand1)) {
                if ((operator == 45 || operator == 126) && CodeGen.e(this.f2790a)) {
                    this.f2790a = 324;
                }
            }
        }
    }

    private boolean a(Expr expr, int i, ASTree aSTree) {
        long j;
        ASTree a2 = a(aSTree);
        if (a2 instanceof IntConst) {
            IntConst intConst = (IntConst) a2;
            long j2 = intConst.get();
            if (i == 45) {
                j = -j2;
            } else if (i != 126) {
                return false;
            } else {
                j = j2 ^ (-1);
            }
            intConst.set(j);
        } else if (!(a2 instanceof DoubleConst)) {
            return false;
        } else {
            DoubleConst doubleConst = (DoubleConst) a2;
            if (i != 45) {
                return false;
            }
            doubleConst.set(-doubleConst.get());
        }
        expr.setOperator(43);
        return true;
    }

    @Override // javassist.compiler.ast.a
    public void a(CallExpr callExpr) {
        javassist.h hVar;
        String str = null;
        ASTree oprand1 = callExpr.oprand1();
        ASTList aSTList = (ASTList) callExpr.oprand2();
        if (oprand1 instanceof Member) {
            str = ((Member) oprand1).get();
            hVar = this.e;
        } else if (oprand1 instanceof Keyword) {
            str = MethodDecl.initName;
            if (((Keyword) oprand1).get() == 336) {
                hVar = MemberResolver.a(this.e);
            } else {
                hVar = this.e;
            }
        } else if (oprand1 instanceof Expr) {
            Expr expr = (Expr) oprand1;
            String str2 = ((Symbol) expr.oprand2()).get();
            int operator = expr.getOperator();
            if (operator == 35) {
                hVar = this.d.a(((Symbol) expr.oprand1()).get(), false);
            } else if (operator == 46) {
                ASTree oprand12 = expr.oprand1();
                try {
                    oprand12.accept(this);
                } catch (NoFieldException e) {
                    if (e.getExpr() != oprand12) {
                        throw e;
                    }
                    this.f2790a = 307;
                    this.b = 0;
                    this.c = e.getField();
                    expr.setOperator(35);
                    expr.setOprand1(new Symbol(MemberResolver.d(this.c)));
                }
                if (this.b > 0) {
                    hVar = this.d.a("java.lang.Object", true);
                } else if (this.f2790a == 307) {
                    hVar = this.d.a(this.c);
                } else {
                    hVar = null;
                    a();
                }
            } else {
                hVar = null;
                a();
            }
            str = str2;
        } else {
            hVar = null;
            b();
        }
        callExpr.setMethod(a(hVar, str, aSTList));
    }

    private static void a() {
        throw new CompileError("bad method");
    }

    public g a(javassist.h hVar, String str, ASTList aSTList) {
        String str2;
        int c = c(aSTList);
        int[] iArr = new int[c];
        int[] iArr2 = new int[c];
        String[] strArr = new String[c];
        a(aSTList, iArr, iArr2, strArr);
        g a2 = this.d.a(hVar, this.e, this.g, str, iArr, iArr2, strArr);
        if (a2 == null) {
            String n = hVar.n();
            String a3 = a(iArr, iArr2, strArr);
            if (str.equals(MethodDecl.initName)) {
                str2 = "cannot find constructor " + n + a3;
            } else {
                str2 = str + a3 + " not found in " + n;
            }
            throw new CompileError(str2);
        }
        a(a2.b.g());
        return a2;
    }

    public int c(ASTList aSTList) {
        return ASTList.length(aSTList);
    }

    public void a(ASTList aSTList, int[] iArr, int[] iArr2, String[] strArr) {
        int i = 0;
        while (aSTList != null) {
            aSTList.head().accept(this);
            iArr[i] = this.f2790a;
            iArr2[i] = this.b;
            strArr[i] = this.c;
            i++;
            aSTList = aSTList.tail();
        }
    }

    void a(String str) {
        int indexOf = str.indexOf(41);
        if (indexOf < 0) {
            a();
        }
        int i = indexOf + 1;
        char charAt = str.charAt(i);
        int i2 = 0;
        while (charAt == '[') {
            i2++;
            i++;
            charAt = str.charAt(i);
        }
        this.b = i2;
        if (charAt == 'L') {
            int indexOf2 = str.indexOf(59, i + 1);
            if (indexOf2 < 0) {
                a();
            }
            this.f2790a = 307;
            this.c = str.substring(i + 1, indexOf2);
            return;
        }
        this.f2790a = MemberResolver.a(charAt);
        this.c = null;
    }

    private void f(ASTree aSTree) {
        b(b(aSTree));
    }

    private void b(CtField ctField) {
        int i = 0;
        String d = ctField.a().d();
        char charAt = d.charAt(0);
        int i2 = 0;
        while (charAt == '[') {
            i++;
            i2++;
            charAt = d.charAt(i2);
        }
        this.b = i;
        this.f2790a = MemberResolver.a(charAt);
        if (charAt == 'L') {
            this.c = d.substring(i2 + 1, d.indexOf(59, i2 + 1));
        } else {
            this.c = null;
        }
    }

    protected CtField b(ASTree aSTree) {
        CompileError compileError;
        if (aSTree instanceof Member) {
            Member member = (Member) aSTree;
            String str = member.get();
            try {
                CtField a2 = this.e.a(str);
                if (v.d(a2.b())) {
                    member.setField(a2);
                }
                return a2;
            } catch (NotFoundException e) {
                throw new NoFieldException(str, aSTree);
            }
        }
        if (aSTree instanceof Expr) {
            Expr expr = (Expr) aSTree;
            int operator = expr.getOperator();
            if (operator == 35) {
                Member member2 = (Member) expr.oprand2();
                CtField b = this.d.b(((Symbol) expr.oprand1()).get(), member2);
                member2.setField(b);
                return b;
            } else if (operator == 46) {
                try {
                    expr.oprand1().accept(this);
                    try {
                    } catch (CompileError e2) {
                        compileError = e2;
                    }
                    if (this.f2790a != 307 || this.b != 0) {
                        compileError = null;
                        ASTree oprand1 = expr.oprand1();
                        if (oprand1 instanceof Symbol) {
                            return a(expr, ((Symbol) oprand1).get());
                        }
                        if (compileError != null) {
                            throw compileError;
                        }
                    } else {
                        return this.d.a(this.c, (Symbol) expr.oprand2());
                    }
                } catch (NoFieldException e3) {
                    if (e3.getExpr() != expr.oprand1()) {
                        throw e3;
                    }
                    return a(expr, e3.getField());
                }
            }
        }
        throw new CompileError("bad filed access");
    }

    private CtField a(Expr expr, String str) {
        Member member = (Member) expr.oprand2();
        CtField a2 = this.d.a(str, member, expr);
        expr.setOperator(35);
        expr.setOprand1(new Symbol(MemberResolver.d(str)));
        member.setField(a2);
        return a2;
    }

    public void a(Expr expr) {
        this.f2790a = 307;
        this.b = 0;
        this.c = "java/lang/Class";
    }

    public void b(Expr expr) {
        expr.oprand1().accept(this);
        if (this.b == 0) {
            throw new NoFieldException("length", expr);
        }
        this.f2790a = 324;
        this.b = 0;
    }

    public void a(ASTree aSTree, ASTree aSTree2) {
        aSTree.accept(this);
        int i = this.f2790a;
        int i2 = this.b;
        String str = this.c;
        aSTree2.accept(this);
        this.f2790a = i;
        this.b = i2 - 1;
        this.c = str;
    }

    private void a(int i, ASTree aSTree, Expr expr) {
        ASTree oprand2 = aSTree == null ? expr.oprand2() : aSTree;
        if (oprand2 instanceof Variable) {
            Declarator declarator = ((Variable) oprand2).getDeclarator();
            this.f2790a = declarator.getType();
            this.b = declarator.getArrayDim();
            return;
        }
        if (oprand2 instanceof Expr) {
            Expr expr2 = (Expr) oprand2;
            if (expr2.getOperator() == 65) {
                a(expr2.oprand1(), expr2.oprand2());
                int i2 = this.f2790a;
                if (i2 == 324 || i2 == 303 || i2 == 306 || i2 == 334) {
                    this.f2790a = 324;
                    return;
                }
                return;
            }
        }
        c(oprand2);
    }

    protected void c(ASTree aSTree) {
        b(b(aSTree));
        int i = this.f2790a;
        if (i == 324 || i == 303 || i == 306 || i == 334) {
            this.f2790a = 324;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(Member member) {
        f(member);
    }

    @Override // javassist.compiler.ast.a
    public void a(Variable variable) {
        Declarator declarator = variable.getDeclarator();
        this.f2790a = declarator.getType();
        this.b = declarator.getArrayDim();
        this.c = declarator.getClassName();
    }

    @Override // javassist.compiler.ast.a
    public void a(Keyword keyword) {
        this.b = 0;
        int i = keyword.get();
        switch (i) {
            case 336:
            case 339:
                this.f2790a = 307;
                if (i == 339) {
                    this.c = c();
                    return;
                } else {
                    this.c = d();
                    return;
                }
            case BdWebErrorView.ERROR_CODE_410 /* 410 */:
            case BdWebErrorView.ERROR_CODE_411 /* 411 */:
                this.f2790a = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
                return;
            case BdWebErrorView.ERROR_CODE_412 /* 412 */:
                this.f2790a = BdWebErrorView.ERROR_CODE_412;
                return;
            default:
                b();
                return;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(StringL stringL) {
        this.f2790a = 307;
        this.b = 0;
        this.c = "java/lang/String";
    }

    @Override // javassist.compiler.ast.a
    public void a(IntConst intConst) {
        this.b = 0;
        int type = intConst.getType();
        if (type == 402 || type == 401) {
            this.f2790a = type == 402 ? 324 : 306;
        } else {
            this.f2790a = 326;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(DoubleConst doubleConst) {
        this.b = 0;
        if (doubleConst.getType() == 405) {
            this.f2790a = 312;
        } else {
            this.f2790a = 317;
        }
    }
}
