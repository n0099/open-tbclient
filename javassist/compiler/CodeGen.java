package javassist.compiler;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.location.BDLocation;
import com.baidu.zeus.bouncycastle.DERTags;
import com.tencent.mm.sdk.contact.RContact;
import java.util.ArrayList;
import java.util.Arrays;
import javassist.bytecode.Bytecode;
import javassist.bytecode.as;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.AssignExpr;
import javassist.compiler.ast.BinExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.CondExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.FieldDecl;
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;
/* loaded from: classes.dex */
public abstract class CodeGen extends javassist.compiler.ast.a implements as, j {
    static final int[] l = {43, 99, 98, 97, 96, 45, 103, 102, 101, 100, 42, SocialAPIErrorCodes.ERROR_INVALID_TIMESTAMP, SocialAPIErrorCodes.ERROR_INVALID_SIGNATURE_ALGORITHM, 105, 104, 47, SocialAPIErrorCodes.ERROR_EXPIRED_ACCESS_TOKEN, SocialAPIErrorCodes.ERROR_MISS_ACCESS_TOKEN, 109, 108, 37, SocialAPIErrorCodes.ERROR_INVALID_RESPONSE_TYPE, 114, 113, SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY, SocialAPIErrorCodes.ERROR_UPLOAD_FILE_SIZE_TOO_LARGE, 0, 0, 129, DERTags.TAGGED, 94, 0, 0, 131, 130, 38, 0, 0, RContact.MM_CONTACTFLAG_ALL, 126, 364, 0, 0, SocialAPIErrorCodes.ERROR_INVALID_STATE, SocialAPIErrorCodes.ERROR_INVALID_AUTHORIZED_CODE, 366, 0, 0, SocialAPIErrorCodes.ERROR_INVALID_BDUSS, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED, 370, 0, 0, SocialAPIErrorCodes.ERROR_INVALID_UPLOAD_FILE, SocialAPIErrorCodes.ERROR_UPLOAD_FILE_SIZE_TOO_LARGE};
    private static final int[] n = {358, 159, 160, 350, 160, 159, 357, 164, 163, 359, 162, BDLocation.TypeNetWorkLocation, 60, BDLocation.TypeNetWorkLocation, 162, 62, 163, 164};
    private static final int[] o = {358, RContact.MM_CONTACTIMGFLAG_LOCAL_EXIST, 154, 350, 154, RContact.MM_CONTACTIMGFLAG_LOCAL_EXIST, 357, 158, 157, 359, 156, 155, 60, 155, 156, 62, 157, 158};
    private static final int[] p = {0, 144, 143, 142, 141, 0, 140, 139, 138, 137, 0, 136, 135, 134, 133, 0};

    /* renamed from: a  reason: collision with root package name */
    protected Bytecode f2998a;
    protected int i;
    protected int j;
    protected String k;
    private int m = -1;
    TypeChecker b = null;
    protected boolean c = false;
    public boolean d = false;
    protected ArrayList e = null;
    protected ArrayList g = null;
    protected c h = null;

    protected abstract String a(String str);

    protected abstract String a(ASTList aSTList);

    protected abstract void a(int i, boolean z, ASTree aSTree, Expr expr, boolean z2);

    protected abstract void a(ArrayInit arrayInit, int i, int i2, String str);

    protected abstract void a(Expr expr, int i, ASTree aSTree, ASTree aSTree2, boolean z);

    protected abstract String c();

    protected abstract String d();

    protected abstract void e();

    protected abstract void e(ASTree aSTree);

    public CodeGen(Bytecode bytecode) {
        this.f2998a = bytecode;
    }

    public void a(TypeChecker typeChecker) {
        this.b = typeChecker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a() {
        throw new CompileError("fatal");
    }

    public static boolean a(int i, int i2) {
        return i2 == 0 && (i == 312 || i == 326);
    }

    public int b() {
        return this.f2998a.g();
    }

    public void a(int i) {
        this.f2998a.d(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        this.f2998a.e(i);
    }

    protected int a(Declarator declarator) {
        int localVar = declarator.getLocalVar();
        if (localVar < 0) {
            int b = b();
            declarator.setLocalVar(b);
            b(1);
            return b;
        }
        return localVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    stringBuffer.append('[');
                    i = i2;
                } else {
                    stringBuffer.append('L');
                    stringBuffer.append(str);
                    stringBuffer.append(';');
                    return stringBuffer.toString();
                }
            }
        } else {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(int i, int i2) {
        char c = 'I';
        switch (i) {
            case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
                c = 'Z';
                break;
            case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                c = 'B';
                break;
            case 306:
                c = 'C';
                break;
            case 312:
                c = 'D';
                break;
            case 317:
                c = 'F';
                break;
            case 326:
                c = 'J';
                break;
            case 334:
                c = 'S';
                break;
            case 344:
                c = 'V';
                break;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0) {
                stringBuffer.append('[');
                i2 = i3;
            } else {
                stringBuffer.append(c);
                return stringBuffer.toString();
            }
        }
    }

    public void a(ASTree aSTree) {
        b(aSTree);
        aSTree.accept(this);
    }

    public boolean a(boolean z, ASTree aSTree) {
        b(aSTree);
        return b(z, aSTree);
    }

    public void b(ASTree aSTree) {
        if (this.b != null) {
            aSTree.accept(this.b);
        }
    }

    @Override // javassist.compiler.ast.a
    public void b(ASTList aSTList) {
        a();
    }

    @Override // javassist.compiler.ast.a
    public void a(Pair pair) {
        a();
    }

    @Override // javassist.compiler.ast.a
    public void a(Symbol symbol) {
        a();
    }

    @Override // javassist.compiler.ast.a
    public void a(FieldDecl fieldDecl) {
        fieldDecl.getInit().accept(this);
    }

    @Override // javassist.compiler.ast.a
    public void a(MethodDecl methodDecl) {
        ASTList modifiers = methodDecl.getModifiers();
        a(1);
        ASTList aSTList = modifiers;
        while (aSTList != null) {
            aSTList = aSTList.tail();
            if (((Keyword) aSTList.head()).get() == 335) {
                a(0);
                this.d = true;
            }
        }
        for (ASTList params = methodDecl.getParams(); params != null; params = params.tail()) {
            b((Declarator) params.head());
        }
        a(methodDecl.getBody(), methodDecl.isConstructor(), methodDecl.getReturn().getType() == 344);
    }

    public void a(Stmnt stmnt, boolean z, boolean z2) {
        if (stmnt != null) {
            if (z && d(stmnt)) {
                e();
            }
            this.c = false;
            stmnt.accept(this);
            if (!this.c) {
                if (z2) {
                    this.f2998a.g(177);
                    this.c = true;
                    return;
                }
                throw new CompileError("no return statement");
            }
        }
    }

    private boolean d(Stmnt stmnt) {
        ASTree head;
        Stmnt stmnt2 = stmnt.getOperator() == 66 ? (Stmnt) stmnt.head() : stmnt;
        if (stmnt2 != null && stmnt2.getOperator() == 69 && (head = stmnt2.head()) != null && (head instanceof Expr) && ((Expr) head).getOperator() == 67) {
            ASTree head2 = ((Expr) head).head();
            if (head2 instanceof Keyword) {
                int i = ((Keyword) head2).get();
                return (i == 339 || i == 336) ? false : true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:67:0x0061 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [javassist.compiler.ast.Stmnt] */
    /* JADX WARN: Type inference failed for: r7v1, types: [javassist.compiler.ast.ASTList] */
    /* JADX WARN: Type inference failed for: r7v2, types: [javassist.compiler.ast.ASTList] */
    @Override // javassist.compiler.ast.a
    public void a(Stmnt stmnt) {
        if (stmnt != 0) {
            int operator = stmnt.getOperator();
            if (operator == 69) {
                ASTree left = stmnt.getLeft();
                b(left);
                if (left instanceof AssignExpr) {
                    a((AssignExpr) left, false);
                } else if (g(left)) {
                    Expr expr = (Expr) left;
                    a(expr.getOperator(), expr.oprand1(), expr, false);
                } else {
                    left.accept(this);
                    if (a(this.i, this.j)) {
                        this.f2998a.g(88);
                    } else if (this.i != 344) {
                        this.f2998a.g(87);
                    }
                }
            } else if (operator == 68 || operator == 66) {
                while (stmnt != 0) {
                    ASTree head = stmnt.head();
                    stmnt = stmnt.tail();
                    if (head != null) {
                        head.accept(this);
                    }
                }
            } else if (operator == 320) {
                e((Stmnt) stmnt);
            } else if (operator == 346 || operator == 311) {
                a((Stmnt) stmnt, operator == 346);
            } else if (operator == 318) {
                f((Stmnt) stmnt);
            } else if (operator == 302 || operator == 309) {
                b((Stmnt) stmnt, operator == 302);
            } else if (operator == 333) {
                b((Stmnt) stmnt);
            } else if (operator == 340) {
                h(stmnt);
            } else if (operator == 343) {
                c((Stmnt) stmnt);
            } else if (operator == 337) {
                g((Stmnt) stmnt);
            } else if (operator == 338) {
                i(stmnt);
            } else {
                this.c = false;
                throw new CompileError("sorry, not supported statement: TokenId " + operator);
            }
        }
    }

    private void e(Stmnt stmnt) {
        int i;
        boolean z = false;
        ASTree head = stmnt.head();
        Stmnt stmnt2 = (Stmnt) stmnt.tail().head();
        Stmnt stmnt3 = (Stmnt) stmnt.tail().tail().head();
        a(false, head);
        int h = this.f2998a.h();
        this.f2998a.j(0);
        this.c = false;
        if (stmnt2 != null) {
            stmnt2.accept(this);
        }
        boolean z2 = this.c;
        this.c = false;
        if (stmnt3 == null || z2) {
            i = 0;
        } else {
            this.f2998a.g(BDLocation.TypeServerError);
            i = this.f2998a.h();
            this.f2998a.j(0);
        }
        this.f2998a.c(h, (this.f2998a.h() - h) + 1);
        if (stmnt3 != null) {
            stmnt3.accept(this);
            if (!z2) {
                this.f2998a.c(i, (this.f2998a.h() - i) + 1);
            }
            if (z2 && this.c) {
                z = true;
            }
            this.c = z;
        }
    }

    private void a(Stmnt stmnt, boolean z) {
        int i;
        ArrayList arrayList = this.e;
        ArrayList arrayList2 = this.g;
        this.e = new ArrayList();
        this.g = new ArrayList();
        ASTree head = stmnt.head();
        Stmnt stmnt2 = (Stmnt) stmnt.tail();
        if (z) {
            this.f2998a.g(BDLocation.TypeServerError);
            i = this.f2998a.h();
            this.f2998a.j(0);
        } else {
            i = 0;
        }
        int h = this.f2998a.h();
        if (stmnt2 != null) {
            stmnt2.accept(this);
        }
        int h2 = this.f2998a.h();
        if (z) {
            this.f2998a.c(i, (h2 - i) + 1);
        }
        boolean a2 = a(true, head);
        this.f2998a.j((h - this.f2998a.h()) + 1);
        a(this.e, this.f2998a.h());
        a(this.g, h2);
        this.g = arrayList2;
        this.e = arrayList;
        this.c = a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ArrayList arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            int intValue = ((Integer) arrayList.get(i2)).intValue();
            this.f2998a.c(intValue, (i - intValue) + 1);
        }
    }

    private void f(Stmnt stmnt) {
        int i;
        ArrayList arrayList = this.e;
        ArrayList arrayList2 = this.g;
        this.e = new ArrayList();
        this.g = new ArrayList();
        Stmnt stmnt2 = (Stmnt) stmnt.head();
        ASTList tail = stmnt.tail();
        ASTree head = tail.head();
        ASTList tail2 = tail.tail();
        Stmnt stmnt3 = (Stmnt) tail2.head();
        Stmnt stmnt4 = (Stmnt) tail2.tail();
        if (stmnt2 != null) {
            stmnt2.accept(this);
        }
        int h = this.f2998a.h();
        if (head != null) {
            a(false, head);
            i = this.f2998a.h();
            this.f2998a.j(0);
        } else {
            i = 0;
        }
        if (stmnt4 != null) {
            stmnt4.accept(this);
        }
        int h2 = this.f2998a.h();
        if (stmnt3 != null) {
            stmnt3.accept(this);
        }
        this.f2998a.g(BDLocation.TypeServerError);
        this.f2998a.j((h - this.f2998a.h()) + 1);
        int h3 = this.f2998a.h();
        if (head != null) {
            this.f2998a.c(i, (h3 - i) + 1);
        }
        a(this.e, h3);
        a(this.g, h2);
        this.g = arrayList2;
        this.e = arrayList;
        this.c = false;
    }

    private void g(Stmnt stmnt) {
        a(stmnt.head());
        ArrayList arrayList = this.e;
        this.e = new ArrayList();
        int h = this.f2998a.h();
        this.f2998a.g(171);
        int i = 3 - (h & 3);
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            this.f2998a.a(0);
            i = i2;
        }
        Stmnt stmnt2 = (Stmnt) stmnt.tail();
        int i3 = 0;
        Stmnt stmnt3 = stmnt2;
        while (stmnt3 != null) {
            int i4 = ((Stmnt) stmnt3.head()).getOperator() == 304 ? i3 + 1 : i3;
            stmnt3 = stmnt3.tail();
            i3 = i4;
        }
        int h2 = this.f2998a.h();
        this.f2998a.b(4);
        this.f2998a.f(i3);
        this.f2998a.b(i3 * 8);
        long[] jArr = new long[i3];
        int i5 = 0;
        int i6 = -1;
        for (Stmnt stmnt4 = stmnt2; stmnt4 != null; stmnt4 = stmnt4.tail()) {
            Stmnt stmnt5 = (Stmnt) stmnt4.head();
            int operator = stmnt5.getOperator();
            if (operator == 310) {
                i6 = this.f2998a.h();
            } else if (operator != 304) {
                a();
            } else {
                jArr[i5] = (f(stmnt5.head()) << 32) + ((this.f2998a.h() - h) & (-1));
                i5++;
            }
            this.c = false;
            ((Stmnt) stmnt5.tail()).accept(this);
        }
        Arrays.sort(jArr);
        int i7 = h2 + 8;
        for (int i8 = 0; i8 < i3; i8++) {
            this.f2998a.d(i7, (int) (jArr[i8] >>> 32));
            this.f2998a.d(i7 + 4, (int) jArr[i8]);
            i7 += 8;
        }
        if (i6 < 0 || this.e.size() > 0) {
            this.c = false;
        }
        int h3 = this.f2998a.h();
        if (i6 < 0) {
            i6 = h3;
        }
        this.f2998a.d(h2, i6 - h);
        a(this.e, h3);
        this.e = arrayList;
    }

    private int f(ASTree aSTree) {
        b(aSTree);
        ASTree a2 = TypeChecker.a(aSTree);
        if (a2 instanceof IntConst) {
            return (int) ((IntConst) a2).get();
        }
        throw new CompileError("bad case label");
    }

    private void b(Stmnt stmnt, boolean z) {
        if (stmnt.head() != null) {
            throw new CompileError("sorry, not support labeled break or continue");
        }
        this.f2998a.g(BDLocation.TypeServerError);
        Integer num = new Integer(this.f2998a.h());
        this.f2998a.j(0);
        if (z) {
            this.e.add(num);
        } else {
            this.g.add(num);
        }
    }

    protected void b(Stmnt stmnt) {
        c(stmnt.getLeft());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(ASTree aSTree) {
        int i = 176;
        if (aSTree == null) {
            i = 177;
        } else {
            a(aSTree);
            if (this.j <= 0) {
                int i2 = this.i;
                if (i2 == 312) {
                    i = 175;
                } else if (i2 == 317) {
                    i = 174;
                } else if (i2 == 326) {
                    i = 173;
                } else if (!d(i2)) {
                    i = 172;
                }
            }
        }
        for (c cVar = this.h; cVar != null; cVar = cVar.c) {
            if (cVar.a(this.f2998a, i)) {
                this.c = true;
                return;
            }
        }
        this.f2998a.g(i);
        this.c = true;
    }

    private void h(Stmnt stmnt) {
        a(stmnt.getLeft());
        if (this.i != 307 || this.j > 0) {
            throw new CompileError("bad throw statement");
        }
        this.f2998a.g(191);
        this.c = true;
    }

    protected void c(Stmnt stmnt) {
        this.c = false;
    }

    private void i(Stmnt stmnt) {
        int i;
        int a2 = a(this.e);
        int a3 = a(this.g);
        a(stmnt.head());
        if (this.i != 307 && this.j == 0) {
            throw new CompileError("bad type expr for synchronized block");
        }
        Bytecode bytecode = this.f2998a;
        int g = bytecode.g();
        bytecode.e(1);
        bytecode.g(89);
        bytecode.l(g);
        bytecode.g(194);
        b bVar = new b(this, this, g);
        int h = bytecode.h();
        Stmnt stmnt2 = (Stmnt) stmnt.tail();
        if (stmnt2 != null) {
            stmnt2.accept(this);
        }
        int h2 = bytecode.h();
        if (this.c) {
            i = 0;
        } else {
            bVar.a(bytecode, 0);
            bytecode.g(BDLocation.TypeServerError);
            i = bytecode.h();
            bytecode.j(0);
        }
        if (h < h2) {
            int h3 = bytecode.h();
            bVar.a(bytecode, 0);
            bytecode.g(191);
            bytecode.b(h, h2, h3, 0);
        }
        if (!this.c) {
            bytecode.c(i, (bytecode.h() - i) + 1);
        }
        bVar.a(this);
        if (a(this.e) != a2 || a(this.g) != a3) {
            throw new CompileError("sorry, cannot break/continue in synchronized block");
        }
    }

    private static int a(ArrayList arrayList) {
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    private static boolean g(ASTree aSTree) {
        if (aSTree instanceof Expr) {
            int operator = ((Expr) aSTree).getOperator();
            return operator == 362 || operator == 363;
        }
        return false;
    }

    @Override // javassist.compiler.ast.a
    public void b(Declarator declarator) {
        int i;
        declarator.setLocalVar(b());
        declarator.setClassName(a(declarator.getClassName()));
        if (a(declarator.getType(), declarator.getArrayDim())) {
            i = 2;
        } else {
            i = 1;
        }
        b(i);
        ASTree initializer = declarator.getInitializer();
        if (initializer != null) {
            b(initializer);
            a((Expr) null, 61, (Variable) null, declarator, initializer, false);
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(AssignExpr assignExpr) {
        a(assignExpr, true);
    }

    protected void a(AssignExpr assignExpr, boolean z) {
        int operator = assignExpr.getOperator();
        ASTree oprand1 = assignExpr.oprand1();
        ASTree oprand2 = assignExpr.oprand2();
        if (oprand1 instanceof Variable) {
            a(assignExpr, operator, (Variable) oprand1, ((Variable) oprand1).getDeclarator(), oprand2, z);
        } else if ((oprand1 instanceof Expr) && ((Expr) oprand1).getOperator() == 65) {
            a((Expr) assignExpr, operator, (Expr) oprand1, oprand2, z);
        } else {
            a(assignExpr, operator, oprand1, oprand2, z);
        }
    }

    protected static void a(Expr expr) {
        String str;
        if (expr == null) {
            str = "incompatible type for assignment";
        } else {
            str = "incompatible type for " + expr.getName();
        }
        throw new CompileError(str);
    }

    private void a(Expr expr, int i, Variable variable, Declarator declarator, ASTree aSTree, boolean z) {
        int type = declarator.getType();
        int arrayDim = declarator.getArrayDim();
        String className = declarator.getClassName();
        int a2 = a(declarator);
        if (i != 61) {
            a(variable);
        }
        if (expr == null && (aSTree instanceof ArrayInit)) {
            a((ArrayInit) aSTree, type, arrayDim, className);
        } else {
            a(expr, i, aSTree, type, arrayDim, className);
        }
        if (z) {
            if (a(type, arrayDim)) {
                this.f2998a.g(92);
            } else {
                this.f2998a.g(89);
            }
        }
        if (arrayDim > 0) {
            this.f2998a.l(a2);
        } else if (type == 312) {
            this.f2998a.s(a2);
        } else if (type == 317) {
            this.f2998a.u(a2);
        } else if (type == 326) {
            this.f2998a.q(a2);
        } else if (d(type)) {
            this.f2998a.l(a2);
        } else {
            this.f2998a.o(a2);
        }
        this.i = type;
        this.j = arrayDim;
        this.k = className;
    }

    private void a(Expr expr, int i, Expr expr2, ASTree aSTree, boolean z) {
        b(expr2.oprand1(), expr2.oprand2());
        if (i != 61) {
            this.f2998a.g(92);
            this.f2998a.g(e(this.i, this.j));
        }
        int i2 = this.i;
        int i3 = this.j;
        String str = this.k;
        a(expr, i, aSTree, i2, i3, str);
        if (z) {
            if (a(i2, i3)) {
                this.f2998a.g(94);
            } else {
                this.f2998a.g(91);
            }
        }
        this.f2998a.g(f(i2, i3));
        this.i = i2;
        this.j = i3;
        this.k = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Expr expr, int i, ASTree aSTree, int i2, int i3, String str) {
        if (i == 354 && i3 == 0 && i2 == 307) {
            a(expr, i2, i3, str, aSTree);
        } else {
            aSTree.accept(this);
            if (a(this.i, this.j, this.k, i2, i3, str, false) || (i != 61 && i3 > 0)) {
                a(expr);
            }
            if (i != 61) {
                int i4 = x[i - 351];
                int c = c(i4);
                if (c < 0) {
                    a();
                }
                a(expr, i4, c, i2);
            }
        }
        if (i != 61 || (i3 == 0 && !d(i2))) {
            d(this.i, i2);
        }
    }

    private void a(Expr expr, int i, int i2, String str, ASTree aSTree) {
        if (!"java/lang/String".equals(str)) {
            a(expr);
        }
        g(i, i2);
        aSTree.accept(this);
        g(this.i, this.j);
        this.f2998a.e("java.lang.String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.i = 307;
        this.j = 0;
        this.k = "java/lang/String";
    }

    private boolean a(int i, int i2, String str, int i3, int i4, String str2, boolean z) {
        if (i2 == i4 || i == 412) {
            return false;
        }
        if (i4 == 0 && i3 == 307 && "java/lang/Object".equals(str2)) {
            return false;
        }
        return (z && i2 == 0 && i == 307 && "java/lang/Object".equals(str)) ? false : true;
    }

    @Override // javassist.compiler.ast.a
    public void a(CondExpr condExpr) {
        b(false, condExpr.condExpr());
        int h = this.f2998a.h();
        this.f2998a.j(0);
        condExpr.thenExpr().accept(this);
        int i = this.j;
        this.f2998a.g(BDLocation.TypeServerError);
        int h2 = this.f2998a.h();
        this.f2998a.j(0);
        this.f2998a.c(h, (this.f2998a.h() - h) + 1);
        condExpr.elseExpr().accept(this);
        if (i != this.j) {
            throw new CompileError("type mismatch in ?:");
        }
        this.f2998a.c(h2, (this.f2998a.h() - h2) + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i) {
        int[] iArr = l;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2 += 5) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // javassist.compiler.ast.a
    public void a(BinExpr binExpr) {
        int operator = binExpr.getOperator();
        int c = c(operator);
        if (c >= 0) {
            binExpr.oprand1().accept(this);
            ASTree oprand2 = binExpr.oprand2();
            if (oprand2 != null) {
                int i = this.i;
                int i2 = this.j;
                String str = this.k;
                oprand2.accept(this);
                if (i2 != this.j) {
                    throw new CompileError("incompatible array types");
                }
                if (operator == 43 && i2 == 0 && (i == 307 || this.i == 307)) {
                    a(binExpr, i, i2, str);
                    return;
                } else {
                    a(binExpr, operator, c, i);
                    return;
                }
            }
            return;
        }
        b(true, (ASTree) binExpr);
        this.f2998a.j(7);
        this.f2998a.m(0);
        this.f2998a.g(BDLocation.TypeServerError);
        this.f2998a.j(4);
        this.f2998a.m(1);
    }

    private void a(Expr expr, int i, int i2, int i3) {
        int i4;
        if (this.j != 0) {
            b(expr);
        }
        int i5 = this.i;
        if (i == 364 || i == 366 || i == 370) {
            if (i5 == 324 || i5 == 334 || i5 == 306 || i5 == 303) {
                this.i = i3;
            } else {
                b(expr);
            }
        } else {
            a(i3, i5, expr);
        }
        int f = f(this.i);
        if (f >= 0 && (i4 = l[i2 + f + 1]) != 0) {
            if (f == 3 && this.i != 301) {
                this.i = 324;
            }
            this.f2998a.g(i4);
            return;
        }
        b(expr);
    }

    private void a(Expr expr, int i, int i2, String str) {
        int i3 = this.i;
        int i4 = this.j;
        boolean a2 = a(i3, i4);
        boolean z = i3 == 307 && "java/lang/String".equals(this.k);
        if (a2) {
            g(i3, i4);
        }
        if (a(i, i2)) {
            this.f2998a.g(91);
            this.f2998a.g(87);
        } else {
            this.f2998a.g(95);
        }
        g(i, i2);
        this.f2998a.g(95);
        if (!a2 && !z) {
            g(i3, i4);
        }
        this.f2998a.e("java.lang.String", "concat", "(Ljava/lang/String;)Ljava/lang/String;");
        this.i = 307;
        this.j = 0;
        this.k = "java/lang/String";
    }

    private void g(int i, int i2) {
        if (d(i) || i2 > 0) {
            this.f2998a.d("java.lang.String", "valueOf", "(Ljava/lang/Object;)Ljava/lang/String;");
        } else if (i == 312) {
            this.f2998a.d("java.lang.String", "valueOf", "(D)Ljava/lang/String;");
        } else if (i == 317) {
            this.f2998a.d("java.lang.String", "valueOf", "(F)Ljava/lang/String;");
        } else if (i == 326) {
            this.f2998a.d("java.lang.String", "valueOf", "(J)Ljava/lang/String;");
        } else if (i == 301) {
            this.f2998a.d("java.lang.String", "valueOf", "(Z)Ljava/lang/String;");
        } else if (i == 306) {
            this.f2998a.d("java.lang.String", "valueOf", "(C)Ljava/lang/String;");
        } else if (i == 344) {
            throw new CompileError("void type expression");
        } else {
            this.f2998a.d("java.lang.String", "valueOf", "(I)Ljava/lang/String;");
        }
    }

    private boolean b(boolean z, ASTree aSTree) {
        int d = d(aSTree);
        if (d == 358) {
            BinExpr binExpr = (BinExpr) aSTree;
            a(z, binExpr.getOperator(), b(binExpr), binExpr);
        } else if (d == 33) {
            b(z ? false : true, ((Expr) aSTree).oprand1());
        } else {
            boolean z2 = d == 369;
            if (z2 || d == 368) {
                BinExpr binExpr2 = (BinExpr) aSTree;
                b(z2 ? false : true, binExpr2.oprand1());
                int h = this.f2998a.h();
                this.f2998a.j(0);
                b(z2, binExpr2.oprand2());
                this.f2998a.c(h, (this.f2998a.h() - h) + 3);
                if (z != z2) {
                    this.f2998a.j(6);
                    this.f2998a.g(BDLocation.TypeServerError);
                }
            } else if (a(aSTree, z)) {
                this.f2998a.g(BDLocation.TypeServerError);
                return true;
            } else {
                aSTree.accept(this);
                if (this.i != 301 || this.j != 0) {
                    throw new CompileError("boolean expr is required");
                }
                this.f2998a.g(z ? 154 : RContact.MM_CONTACTIMGFLAG_LOCAL_EXIST);
            }
        }
        this.i = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
        this.j = 0;
        return false;
    }

    private static boolean a(ASTree aSTree, boolean z) {
        if (aSTree instanceof Keyword) {
            int i = ((Keyword) aSTree).get();
            return z ? i == 410 : i == 411;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(ASTree aSTree) {
        if (aSTree instanceof Expr) {
            Expr expr = (Expr) aSTree;
            int operator = expr.getOperator();
            if (operator == 33) {
                return 33;
            }
            if (!(expr instanceof BinExpr) || operator == 368 || operator == 369 || operator == 38 || operator == 124) {
                return operator;
            }
            return 358;
        }
        return 32;
    }

    private int b(BinExpr binExpr) {
        binExpr.oprand1().accept(this);
        int i = this.i;
        int i2 = this.j;
        binExpr.oprand2().accept(this);
        if (i2 != this.j) {
            if (i != 412 && this.i != 412) {
                throw new CompileError("incompatible array types");
            }
            if (this.i == 412) {
                this.j = i2;
            }
        }
        if (i == 412) {
            return this.i;
        }
        return i;
    }

    private void a(boolean z, int i, int i2, BinExpr binExpr) {
        if (this.j == 0) {
            a(i2, this.i, binExpr);
        }
        int f = f(this.i);
        if (f == -1 || this.j > 0) {
            if (i == 358) {
                this.f2998a.g(z ? 165 : 166);
            } else if (i == 350) {
                this.f2998a.g(z ? 166 : 165);
            } else {
                b((Expr) binExpr);
            }
        } else if (f == 3) {
            int[] iArr = n;
            for (int i3 = 0; i3 < iArr.length; i3 += 3) {
                if (iArr[i3] == i) {
                    this.f2998a.g(iArr[i3 + (z ? 1 : 2)]);
                    return;
                }
            }
            b((Expr) binExpr);
        } else {
            if (f == 0) {
                if (i == 60 || i == 357) {
                    this.f2998a.g(152);
                } else {
                    this.f2998a.g(151);
                }
            } else if (f == 1) {
                if (i == 60 || i == 357) {
                    this.f2998a.g(150);
                } else {
                    this.f2998a.g(149);
                }
            } else if (f == 2) {
                this.f2998a.g(148);
            } else {
                a();
            }
            int[] iArr2 = o;
            for (int i4 = 0; i4 < iArr2.length; i4 += 3) {
                if (iArr2[i4] == i) {
                    this.f2998a.g(iArr2[i4 + (z ? 1 : 2)]);
                    return;
                }
            }
            b((Expr) binExpr);
        }
    }

    protected static void b(Expr expr) {
        throw new CompileError("invalid types for " + expr.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean d(int i) {
        return i == 307 || i == 412;
    }

    private static int f(int i) {
        if (i == 312) {
            return 0;
        }
        if (i == 317) {
            return 1;
        }
        if (i == 326) {
            return 2;
        }
        return (d(i) || i == 344) ? -1 : 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(int i) {
        return f(i) == 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(int i, int i2) {
        int f = f(i);
        int f2 = f(i2);
        return f >= 0 && f2 >= 0 && f > f2;
    }

    private void a(int i, int i2, Expr expr) {
        int i3;
        boolean z;
        int f = f(i);
        int f2 = f(i2);
        if (f2 >= 0 || f >= 0) {
            if (f2 < 0 || f < 0) {
                b(expr);
            }
            if (f <= f2) {
                this.i = i;
                z = false;
                i3 = p[(f2 * 4) + f];
                f2 = f;
            } else {
                i3 = p[(f * 4) + f2];
                z = true;
            }
            if (z) {
                if (f2 == 0 || f2 == 2) {
                    if (f == 0 || f == 2) {
                        this.f2998a.g(94);
                    } else {
                        this.f2998a.g(93);
                    }
                    this.f2998a.g(88);
                    this.f2998a.g(i3);
                    this.f2998a.g(94);
                    this.f2998a.g(88);
                } else if (f2 == 1) {
                    if (f == 2) {
                        this.f2998a.g(91);
                        this.f2998a.g(87);
                    } else {
                        this.f2998a.g(95);
                    }
                    this.f2998a.g(i3);
                    this.f2998a.g(95);
                } else {
                    a();
                }
            } else if (i3 != 0) {
                this.f2998a.g(i3);
            }
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(CastExpr castExpr) {
        String a2 = a(castExpr.getClassName());
        String a3 = a(castExpr, a2);
        int i = this.i;
        this.i = castExpr.getType();
        this.j = castExpr.getArrayDim();
        this.k = a2;
        if (a3 == null) {
            d(i, this.i);
        } else {
            this.f2998a.a(a3);
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(InstanceOfExpr instanceOfExpr) {
        this.f2998a.b(a(instanceOfExpr, a(instanceOfExpr.getClassName())));
        this.i = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
        this.j = 0;
    }

    private String a(CastExpr castExpr, String str) {
        ASTree oprand = castExpr.getOprand();
        int arrayDim = castExpr.getArrayDim();
        int type = castExpr.getType();
        oprand.accept(this);
        int i = this.i;
        if (a(i, this.j, this.k, type, arrayDim, str, true) || i == 344 || type == 344) {
            throw new CompileError("invalid cast");
        }
        if (type == 307) {
            if (!d(i)) {
                throw new CompileError("invalid cast");
            }
            return a(str, arrayDim);
        } else if (arrayDim > 0) {
            return b(type, arrayDim);
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, int i2) {
        int i3 = 0;
        if (i != i2) {
            int f = f(i);
            int i4 = (f < 0 || f >= 3) ? 0 : p[(f * 4) + f(i2)];
            if (i2 == 312) {
                i3 = 135;
            } else if (i2 == 317) {
                i3 = 134;
            } else if (i2 == 326) {
                i3 = 133;
            } else if (i2 == 334) {
                i3 = 147;
            } else if (i2 == 306) {
                i3 = 146;
            } else if (i2 == 303) {
                i3 = 145;
            }
            if (i4 != 0) {
                this.f2998a.g(i4);
            }
            if ((i4 == 0 || i4 == 136 || i4 == 139 || i4 == 142) && i3 != 0) {
                this.f2998a.g(i3);
            }
        }
    }

    @Override // javassist.compiler.ast.a
    public void c(Expr expr) {
        int operator = expr.getOperator();
        ASTree oprand1 = expr.oprand1();
        if (operator == 46) {
            if (((Symbol) expr.oprand2()).get().equals("class")) {
                e(expr);
            } else {
                e((ASTree) expr);
            }
        } else if (operator == 35) {
            e((ASTree) expr);
        } else if (operator == 65) {
            a(oprand1, expr.oprand2());
        } else if (operator == 362 || operator == 363) {
            a(operator, oprand1, expr, true);
        } else if (operator == 33) {
            b(false, (ASTree) expr);
            this.f2998a.j(7);
            this.f2998a.m(1);
            this.f2998a.g(BDLocation.TypeServerError);
            this.f2998a.j(4);
            this.f2998a.m(0);
        } else if (operator == 67) {
            a();
        } else {
            expr.oprand1().accept(this);
            int f = f(this.i);
            if (this.j > 0) {
                d(expr);
            }
            if (operator == 45) {
                if (f == 0) {
                    this.f2998a.g(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
                } else if (f == 1) {
                    this.f2998a.g(SocialAPIErrorCodes.ERROR_INVALID_REDIRECT_URI);
                } else if (f == 2) {
                    this.f2998a.g(SocialAPIErrorCodes.ERROR_INVALID_MEDIA_TYPE);
                } else if (f == 3) {
                    this.f2998a.g(SocialAPIErrorCodes.ERROR_INVALID_GRANT_TYPE);
                    this.i = 324;
                } else {
                    d(expr);
                }
            } else if (operator == 126) {
                if (f == 3) {
                    this.f2998a.m(-1);
                    this.f2998a.g(130);
                    this.i = 324;
                } else if (f == 2) {
                    this.f2998a.a(-1L);
                    this.f2998a.g(131);
                } else {
                    d(expr);
                }
            } else if (operator == 43) {
                if (f == -1) {
                    d(expr);
                }
            } else {
                a();
            }
        }
    }

    protected static void d(Expr expr) {
        throw new CompileError("invalid type for " + expr.getName());
    }

    public void e(Expr expr) {
        ASTree oprand1 = expr.oprand1();
        if (!(oprand1 instanceof Symbol)) {
            throw new CompileError("fatal error: badly parsed .class expr");
        }
        String str = ((Symbol) oprand1).get();
        if (str.startsWith("[")) {
            int indexOf = str.indexOf("[L");
            if (indexOf >= 0) {
                String substring = str.substring(indexOf + 2, str.length() - 1);
                String a2 = a(substring);
                if (!substring.equals(a2)) {
                    String d = MemberResolver.d(a2);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int i = indexOf;
                        indexOf = i - 1;
                        if (i < 0) {
                            break;
                        }
                        stringBuffer.append('[');
                    }
                    stringBuffer.append('L').append(d).append(';');
                    str = stringBuffer.toString();
                }
            }
        } else {
            str = MemberResolver.d(a(MemberResolver.c(str)));
        }
        b(str);
        this.i = 307;
        this.j = 0;
        this.k = "java/lang/Class";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        int h = this.f2998a.h();
        this.f2998a.c(str);
        this.f2998a.d("java.lang.Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        int h2 = this.f2998a.h();
        this.f2998a.g(BDLocation.TypeServerError);
        int h3 = this.f2998a.h();
        this.f2998a.j(0);
        this.f2998a.a(h, h2, this.f2998a.h(), "java.lang.ClassNotFoundException");
        this.f2998a.h(1);
        this.f2998a.d("javassist.runtime.DotClass", "fail", "(Ljava/lang/ClassNotFoundException;)Ljava/lang/NoClassDefFoundError;");
        this.f2998a.g(191);
        this.f2998a.c(h3, (this.f2998a.h() - h3) + 1);
    }

    public void a(ASTree aSTree, ASTree aSTree2) {
        b(aSTree, aSTree2);
        this.f2998a.g(e(this.i, this.j));
    }

    protected void b(ASTree aSTree, ASTree aSTree2) {
        aSTree.accept(this);
        int i = this.i;
        int i2 = this.j;
        if (i2 == 0) {
            throw new CompileError("bad array access");
        }
        String str = this.k;
        aSTree2.accept(this);
        if (f(this.i) != 3 || this.j > 0) {
            throw new CompileError("bad array index");
        }
        this.i = i;
        this.j = i2 - 1;
        this.k = str;
    }

    protected static int e(int i, int i2) {
        if (i2 > 0) {
            return 50;
        }
        switch (i) {
            case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
            case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                return 51;
            case 306:
                return 52;
            case 312:
                return 49;
            case 317:
                return 48;
            case 324:
                return 46;
            case 326:
                return 47;
            case 334:
                return 53;
            default:
                return 50;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int f(int i, int i2) {
        if (i2 > 0) {
            return 83;
        }
        switch (i) {
            case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
            case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                return 84;
            case 306:
                return 85;
            case 312:
                return 82;
            case 317:
                return 81;
            case 324:
                return 79;
            case 326:
                return 80;
            case 334:
                return 86;
            default:
                return 83;
        }
    }

    private void a(int i, ASTree aSTree, Expr expr, boolean z) {
        boolean z2 = aSTree == null;
        ASTree oprand2 = z2 ? expr.oprand2() : aSTree;
        if (oprand2 instanceof Variable) {
            Declarator declarator = ((Variable) oprand2).getDeclarator();
            int type = declarator.getType();
            this.i = type;
            this.j = declarator.getArrayDim();
            int a2 = a(declarator);
            if (this.j > 0) {
                d(expr);
            }
            if (type == 312) {
                this.f2998a.r(a2);
                if (z && z2) {
                    this.f2998a.g(92);
                }
                this.f2998a.a(1.0d);
                this.f2998a.g(i == 362 ? 99 : 103);
                if (z && !z2) {
                    this.f2998a.g(92);
                }
                this.f2998a.s(a2);
                return;
            } else if (type == 326) {
                this.f2998a.p(a2);
                if (z && z2) {
                    this.f2998a.g(92);
                }
                this.f2998a.a(1L);
                this.f2998a.g(i == 362 ? 97 : 101);
                if (z && !z2) {
                    this.f2998a.g(92);
                }
                this.f2998a.q(a2);
                return;
            } else if (type == 317) {
                this.f2998a.t(a2);
                if (z && z2) {
                    this.f2998a.g(89);
                }
                this.f2998a.a(1.0f);
                this.f2998a.g(i == 362 ? 98 : 102);
                if (z && !z2) {
                    this.f2998a.g(89);
                }
                this.f2998a.u(a2);
                return;
            } else if (type == 303 || type == 306 || type == 334 || type == 324) {
                if (z && z2) {
                    this.f2998a.n(a2);
                }
                int i2 = i != 362 ? -1 : 1;
                if (a2 > 255) {
                    this.f2998a.g(196);
                    this.f2998a.g(132);
                    this.f2998a.j(a2);
                    this.f2998a.j(i2);
                } else {
                    this.f2998a.g(132);
                    this.f2998a.a(a2);
                    this.f2998a.a(i2);
                }
                if (z && !z2) {
                    this.f2998a.n(a2);
                    return;
                }
                return;
            } else {
                d(expr);
                return;
            }
        }
        if (oprand2 instanceof Expr) {
            Expr expr2 = (Expr) oprand2;
            if (expr2.getOperator() == 65) {
                a(i, z2, expr2, z);
                return;
            }
        }
        a(i, z2, oprand2, expr, z);
    }

    public void a(int i, boolean z, Expr expr, boolean z2) {
        b(expr.oprand1(), expr.oprand2());
        int i2 = this.i;
        int i3 = this.j;
        if (i3 > 0) {
            d(expr);
        }
        this.f2998a.g(92);
        this.f2998a.g(e(i2, this.j));
        a(a(i2, i3) ? 94 : 91, z2, i, z, expr);
        this.f2998a.g(f(i2, i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, boolean z, int i2, boolean z2, Expr expr) {
        int i3 = this.i;
        if (z && z2) {
            this.f2998a.g(i);
        }
        if (i3 == 324 || i3 == 303 || i3 == 306 || i3 == 334) {
            this.f2998a.m(1);
            this.f2998a.g(i2 == 362 ? 96 : 100);
            this.i = 324;
        } else if (i3 == 326) {
            this.f2998a.a(1L);
            this.f2998a.g(i2 == 362 ? 97 : 101);
        } else if (i3 == 317) {
            this.f2998a.a(1.0f);
            this.f2998a.g(i2 == 362 ? 98 : 102);
        } else if (i3 == 312) {
            this.f2998a.a(1.0d);
            this.f2998a.g(i2 == 362 ? 99 : 103);
        } else {
            d(expr);
        }
        if (z && !z2) {
            this.f2998a.g(i);
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(Variable variable) {
        Declarator declarator = variable.getDeclarator();
        this.i = declarator.getType();
        this.j = declarator.getArrayDim();
        this.k = declarator.getClassName();
        int a2 = a(declarator);
        if (this.j > 0) {
            this.f2998a.k(a2);
            return;
        }
        switch (this.i) {
            case 307:
                this.f2998a.k(a2);
                return;
            case 312:
                this.f2998a.r(a2);
                return;
            case 317:
                this.f2998a.t(a2);
                return;
            case 326:
                this.f2998a.p(a2);
                return;
            default:
                this.f2998a.n(a2);
                return;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(Keyword keyword) {
        this.j = 0;
        int i = keyword.get();
        switch (i) {
            case 336:
            case 339:
                if (this.d) {
                    throw new CompileError("not-available: " + (i == 339 ? "this" : "super"));
                }
                this.f2998a.k(0);
                this.i = 307;
                if (i == 339) {
                    this.k = c();
                    return;
                } else {
                    this.k = d();
                    return;
                }
            case BdWebErrorView.ERROR_CODE_410 /* 410 */:
                this.f2998a.m(1);
                this.i = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
                return;
            case BdWebErrorView.ERROR_CODE_411 /* 411 */:
                this.f2998a.m(0);
                this.i = BVideoView.MEDIA_ERROR_NO_INPUTFILE;
                return;
            case BdWebErrorView.ERROR_CODE_412 /* 412 */:
                this.f2998a.g(1);
                this.i = BdWebErrorView.ERROR_CODE_412;
                return;
            default:
                a();
                return;
        }
    }

    @Override // javassist.compiler.ast.a
    public void a(StringL stringL) {
        this.i = 307;
        this.j = 0;
        this.k = "java/lang/String";
        this.f2998a.c(stringL.get());
    }

    @Override // javassist.compiler.ast.a
    public void a(IntConst intConst) {
        this.j = 0;
        long j = intConst.get();
        int type = intConst.getType();
        if (type == 402 || type == 401) {
            this.i = type == 402 ? 324 : 306;
            this.f2998a.m((int) j);
            return;
        }
        this.i = 326;
        this.f2998a.a(j);
    }

    @Override // javassist.compiler.ast.a
    public void a(DoubleConst doubleConst) {
        this.j = 0;
        if (doubleConst.getType() == 405) {
            this.i = 312;
            this.f2998a.a(doubleConst.get());
            return;
        }
        this.i = 317;
        this.f2998a.a((float) doubleConst.get());
    }
}
