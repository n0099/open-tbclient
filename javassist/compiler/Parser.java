package javassist.compiler;

import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.BVideoView;
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
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;
/* loaded from: classes.dex */
public final class Parser implements j {
    private static final int[] b = {0, 0, 0, 0, 1, 6, 0, 0, 0, 1, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0};

    /* renamed from: a  reason: collision with root package name */
    private Lex f2789a;

    public Parser(Lex lex) {
        this.f2789a = lex;
    }

    public boolean a() {
        return this.f2789a.b() >= 0;
    }

    private Declarator c(SymbolTable symbolTable) {
        int b2 = this.f2789a.b();
        if (a(b2) || b2 == 344) {
            this.f2789a.a();
            return new Declarator(b2, d());
        }
        return new Declarator(A(symbolTable), d());
    }

    private static boolean a(int i) {
        return i == 301 || i == 303 || i == 306 || i == 334 || i == 324 || i == 326 || i == 317 || i == 312;
    }

    private Declarator d(SymbolTable symbolTable) {
        Declarator c = c(symbolTable);
        if (this.f2789a.a() != 400) {
            throw new SyntaxError(this.f2789a);
        }
        String c2 = this.f2789a.c();
        c.setVariable(new Symbol(c2));
        c.addArrayDim(d());
        symbolTable.append(c2, c);
        return c;
    }

    public Stmnt a(SymbolTable symbolTable) {
        int b2 = this.f2789a.b();
        if (b2 == 123) {
            return e(symbolTable);
        }
        if (b2 == 59) {
            this.f2789a.a();
            return new Stmnt(66);
        } else if (b2 == 400 && this.f2789a.a(1) == 58) {
            this.f2789a.a();
            String c = this.f2789a.c();
            this.f2789a.a();
            return Stmnt.make(76, new Symbol(c), a(symbolTable));
        } else if (b2 == 320) {
            return f(symbolTable);
        } else {
            if (b2 == 346) {
                return g(symbolTable);
            }
            if (b2 == 311) {
                return h(symbolTable);
            }
            if (b2 == 318) {
                return i(symbolTable);
            }
            if (b2 == 343) {
                return n(symbolTable);
            }
            if (b2 == 337) {
                return j(symbolTable);
            }
            if (b2 == 338) {
                return m(symbolTable);
            }
            if (b2 == 333) {
                return o(symbolTable);
            }
            if (b2 == 340) {
                return p(symbolTable);
            }
            if (b2 == 302) {
                return q(symbolTable);
            }
            if (b2 == 309) {
                return r(symbolTable);
            }
            return a(symbolTable, false);
        }
    }

    private Stmnt e(SymbolTable symbolTable) {
        if (this.f2789a.a() != 123) {
            throw new SyntaxError(this.f2789a);
        }
        Stmnt stmnt = null;
        SymbolTable symbolTable2 = new SymbolTable(symbolTable);
        while (this.f2789a.b() != 125) {
            Stmnt a2 = a(symbolTable2);
            if (a2 != null) {
                stmnt = (Stmnt) ASTList.concat(stmnt, new Stmnt(66, a2));
            }
        }
        this.f2789a.a();
        if (stmnt == null) {
            return new Stmnt(66);
        }
        return stmnt;
    }

    private Stmnt f(SymbolTable symbolTable) {
        Stmnt stmnt;
        int a2 = this.f2789a.a();
        ASTree v = v(symbolTable);
        Stmnt a3 = a(symbolTable);
        if (this.f2789a.b() == 313) {
            this.f2789a.a();
            stmnt = a(symbolTable);
        } else {
            stmnt = null;
        }
        return new Stmnt(a2, v, new ASTList(a3, new ASTList(stmnt)));
    }

    private Stmnt g(SymbolTable symbolTable) {
        return new Stmnt(this.f2789a.a(), v(symbolTable), a(symbolTable));
    }

    private Stmnt h(SymbolTable symbolTable) {
        int a2 = this.f2789a.a();
        Stmnt a3 = a(symbolTable);
        if (this.f2789a.a() != 346 || this.f2789a.a() != 40) {
            throw new SyntaxError(this.f2789a);
        }
        ASTree b2 = b(symbolTable);
        if (this.f2789a.a() != 41 || this.f2789a.a() != 59) {
            throw new SyntaxError(this.f2789a);
        }
        return new Stmnt(a2, b2, a3);
    }

    private Stmnt i(SymbolTable symbolTable) {
        Stmnt a2;
        int a3 = this.f2789a.a();
        SymbolTable symbolTable2 = new SymbolTable(symbolTable);
        if (this.f2789a.a() != 40) {
            throw new SyntaxError(this.f2789a);
        }
        if (this.f2789a.b() == 59) {
            this.f2789a.a();
            a2 = null;
        } else {
            a2 = a(symbolTable2, true);
        }
        ASTree b2 = this.f2789a.b() == 59 ? null : b(symbolTable2);
        if (this.f2789a.a() != 59) {
            throw new CompileError("; is missing", this.f2789a);
        }
        Stmnt s = this.f2789a.b() != 41 ? s(symbolTable2) : null;
        if (this.f2789a.a() != 41) {
            throw new CompileError(") is missing", this.f2789a);
        }
        return new Stmnt(a3, a2, new ASTList(b2, new ASTList(s, a(symbolTable2))));
    }

    private Stmnt j(SymbolTable symbolTable) {
        return new Stmnt(this.f2789a.a(), v(symbolTable), k(symbolTable));
    }

    private Stmnt k(SymbolTable symbolTable) {
        if (this.f2789a.a() != 123) {
            throw new SyntaxError(this.f2789a);
        }
        SymbolTable symbolTable2 = new SymbolTable(symbolTable);
        Stmnt l = l(symbolTable2);
        if (l == null) {
            throw new CompileError("empty switch block", this.f2789a);
        }
        int operator = l.getOperator();
        if (operator != 304 && operator != 310) {
            throw new CompileError("no case or default in a switch block", this.f2789a);
        }
        Stmnt stmnt = new Stmnt(66, l);
        while (true) {
            Stmnt stmnt2 = stmnt;
            Stmnt stmnt3 = l;
            if (this.f2789a.b() != 125) {
                Stmnt l2 = l(symbolTable2);
                if (l2 != null) {
                    int operator2 = l2.getOperator();
                    if (operator2 == 304 || operator2 == 310) {
                        stmnt = (Stmnt) ASTList.concat(stmnt2, new Stmnt(66, l2));
                        l = l2;
                    } else {
                        l = (Stmnt) ASTList.concat(stmnt3, new Stmnt(66, l2));
                        stmnt = stmnt2;
                    }
                } else {
                    l = stmnt3;
                    stmnt = stmnt2;
                }
            } else {
                this.f2789a.a();
                return stmnt2;
            }
        }
    }

    private Stmnt l(SymbolTable symbolTable) {
        Stmnt stmnt;
        int b2 = this.f2789a.b();
        if (b2 != 304 && b2 != 310) {
            return a(symbolTable);
        }
        this.f2789a.a();
        if (b2 == 304) {
            stmnt = new Stmnt(b2, b(symbolTable));
        } else {
            stmnt = new Stmnt(310);
        }
        if (this.f2789a.a() != 58) {
            throw new CompileError(": is missing", this.f2789a);
        }
        return stmnt;
    }

    private Stmnt m(SymbolTable symbolTable) {
        int a2 = this.f2789a.a();
        if (this.f2789a.a() != 40) {
            throw new SyntaxError(this.f2789a);
        }
        ASTree b2 = b(symbolTable);
        if (this.f2789a.a() != 41) {
            throw new SyntaxError(this.f2789a);
        }
        return new Stmnt(a2, b2, e(symbolTable));
    }

    private Stmnt n(SymbolTable symbolTable) {
        Stmnt stmnt = null;
        this.f2789a.a();
        Stmnt e = e(symbolTable);
        ASTList aSTList = null;
        while (this.f2789a.b() == 305) {
            this.f2789a.a();
            if (this.f2789a.a() != 40) {
                throw new SyntaxError(this.f2789a);
            }
            SymbolTable symbolTable2 = new SymbolTable(symbolTable);
            Declarator d = d(symbolTable2);
            if (d.getArrayDim() > 0 || d.getType() != 307) {
                throw new SyntaxError(this.f2789a);
            }
            if (this.f2789a.a() != 41) {
                throw new SyntaxError(this.f2789a);
            }
            aSTList = ASTList.append(aSTList, new Pair(d, e(symbolTable2)));
        }
        if (this.f2789a.b() == 316) {
            this.f2789a.a();
            stmnt = e(symbolTable);
        }
        return Stmnt.make(343, e, aSTList, stmnt);
    }

    private Stmnt o(SymbolTable symbolTable) {
        Stmnt stmnt = new Stmnt(this.f2789a.a());
        if (this.f2789a.b() != 59) {
            stmnt.setLeft(b(symbolTable));
        }
        if (this.f2789a.a() != 59) {
            throw new CompileError("; is missing", this.f2789a);
        }
        return stmnt;
    }

    private Stmnt p(SymbolTable symbolTable) {
        int a2 = this.f2789a.a();
        ASTree b2 = b(symbolTable);
        if (this.f2789a.a() != 59) {
            throw new CompileError("; is missing", this.f2789a);
        }
        return new Stmnt(a2, b2);
    }

    private Stmnt q(SymbolTable symbolTable) {
        return r(symbolTable);
    }

    private Stmnt r(SymbolTable symbolTable) {
        Stmnt stmnt = new Stmnt(this.f2789a.a());
        int a2 = this.f2789a.a();
        if (a2 == 400) {
            stmnt.setLeft(new Symbol(this.f2789a.c()));
            a2 = this.f2789a.a();
        }
        if (a2 != 59) {
            throw new CompileError("; is missing", this.f2789a);
        }
        return stmnt;
    }

    private Stmnt a(SymbolTable symbolTable, boolean z) {
        Stmnt stmnt;
        int d;
        int b2 = this.f2789a.b();
        while (b2 == 315) {
            this.f2789a.a();
            b2 = this.f2789a.b();
        }
        if (a(b2)) {
            return a(symbolTable, new Declarator(this.f2789a.a(), d()));
        }
        if (b2 == 400 && (d = d(0)) >= 0 && this.f2789a.a(d) == 400) {
            return a(symbolTable, new Declarator(A(symbolTable), d()));
        }
        if (z) {
            stmnt = s(symbolTable);
        } else {
            stmnt = new Stmnt(69, b(symbolTable));
        }
        if (this.f2789a.a() != 59) {
            throw new CompileError("; is missing", this.f2789a);
        }
        return stmnt;
    }

    private Stmnt s(SymbolTable symbolTable) {
        Stmnt stmnt = null;
        while (true) {
            stmnt = (Stmnt) ASTList.concat(stmnt, new Stmnt(66, new Stmnt(69, b(symbolTable))));
            if (this.f2789a.b() == 44) {
                this.f2789a.a();
            } else {
                return stmnt;
            }
        }
    }

    private Stmnt a(SymbolTable symbolTable, Declarator declarator) {
        int a2;
        Stmnt stmnt = null;
        do {
            stmnt = (Stmnt) ASTList.concat(stmnt, new Stmnt(68, b(symbolTable, declarator)));
            a2 = this.f2789a.a();
            if (a2 == 59) {
                return stmnt;
            }
        } while (a2 == 44);
        throw new CompileError("; is missing", this.f2789a);
    }

    private Declarator b(SymbolTable symbolTable, Declarator declarator) {
        if (this.f2789a.a() != 400 || declarator.getType() == 344) {
            throw new SyntaxError(this.f2789a);
        }
        String c = this.f2789a.c();
        Symbol symbol = new Symbol(c);
        int d = d();
        ASTree aSTree = null;
        if (this.f2789a.b() == 61) {
            this.f2789a.a();
            aSTree = t(symbolTable);
        }
        Declarator make = declarator.make(symbol, d, aSTree);
        symbolTable.append(c, make);
        return make;
    }

    private ASTree t(SymbolTable symbolTable) {
        return this.f2789a.b() == 123 ? u(symbolTable) : b(symbolTable);
    }

    private ArrayInit u(SymbolTable symbolTable) {
        this.f2789a.a();
        ArrayInit arrayInit = new ArrayInit(b(symbolTable));
        while (this.f2789a.b() == 44) {
            this.f2789a.a();
            ASTList.append(arrayInit, b(symbolTable));
        }
        if (this.f2789a.a() != 125) {
            throw new SyntaxError(this.f2789a);
        }
        return arrayInit;
    }

    private ASTree v(SymbolTable symbolTable) {
        if (this.f2789a.a() != 40) {
            throw new SyntaxError(this.f2789a);
        }
        ASTree b2 = b(symbolTable);
        if (this.f2789a.a() != 41) {
            throw new SyntaxError(this.f2789a);
        }
        return b2;
    }

    public ASTree b(SymbolTable symbolTable) {
        ASTree w = w(symbolTable);
        return !b(this.f2789a.b()) ? w : AssignExpr.makeAssign(this.f2789a.a(), w, b(symbolTable));
    }

    private static boolean b(int i) {
        return i == 61 || i == 351 || i == 352 || i == 353 || i == 354 || i == 355 || i == 356 || i == 360 || i == 361 || i == 365 || i == 367 || i == 371;
    }

    private ASTree w(SymbolTable symbolTable) {
        ASTree x = x(symbolTable);
        if (this.f2789a.b() == 63) {
            this.f2789a.a();
            ASTree b2 = b(symbolTable);
            if (this.f2789a.a() != 58) {
                throw new CompileError(": is missing", this.f2789a);
            }
            return new CondExpr(x, b2, b(symbolTable));
        }
        return x;
    }

    private ASTree x(SymbolTable symbolTable) {
        ASTree y = y(symbolTable);
        while (true) {
            int c = c(this.f2789a.b());
            if (c == 0) {
                return y;
            }
            y = a(symbolTable, y, c);
        }
    }

    private ASTree a(SymbolTable symbolTable, ASTree aSTree) {
        int b2 = this.f2789a.b();
        if (a(b2)) {
            this.f2789a.a();
            return new InstanceOfExpr(b2, d(), aSTree);
        }
        return new InstanceOfExpr(A(symbolTable), d(), aSTree);
    }

    private ASTree a(SymbolTable symbolTable, ASTree aSTree, int i) {
        int a2 = this.f2789a.a();
        if (a2 == 323) {
            return a(symbolTable, aSTree);
        }
        ASTree y = y(symbolTable);
        while (true) {
            int c = c(this.f2789a.b());
            if (c == 0 || i <= c) {
                break;
            }
            y = a(symbolTable, y, c);
        }
        return BinExpr.makeBin(a2, aSTree, y);
    }

    private int c(int i) {
        if (33 <= i && i <= 63) {
            return b[i - 33];
        }
        if (i == 94) {
            return 7;
        }
        if (i == 124) {
            return 8;
        }
        if (i == 369) {
            return 9;
        }
        if (i == 368) {
            return 10;
        }
        if (i == 358 || i == 350) {
            return 5;
        }
        if (i == 357 || i == 359 || i == 323) {
            return 4;
        }
        if (i == 364 || i == 366 || i == 370) {
            return 3;
        }
        return 0;
    }

    private ASTree y(SymbolTable symbolTable) {
        switch (this.f2789a.b()) {
            case 33:
            case 43:
            case 45:
            case 126:
            case 362:
            case 363:
                int a2 = this.f2789a.a();
                if (a2 == 45) {
                    int b2 = this.f2789a.b();
                    switch (b2) {
                        case BdWebErrorView.ERROR_CODE_401 /* 401 */:
                        case 402:
                        case BdWebErrorView.ERROR_CODE_403 /* 403 */:
                            this.f2789a.a();
                            return new IntConst(-this.f2789a.d(), b2);
                        case BdWebErrorView.ERROR_CODE_404 /* 404 */:
                        case BdWebErrorView.ERROR_CODE_405 /* 405 */:
                            this.f2789a.a();
                            return new DoubleConst(-this.f2789a.e(), b2);
                    }
                }
                return Expr.make(a2, y(symbolTable));
            case 40:
                return z(symbolTable);
            default:
                return B(symbolTable);
        }
    }

    private ASTree z(SymbolTable symbolTable) {
        int a2 = this.f2789a.a(1);
        if (a(a2) && b()) {
            this.f2789a.a();
            this.f2789a.a();
            int d = d();
            if (this.f2789a.a() != 41) {
                throw new CompileError(") is missing", this.f2789a);
            }
            return new CastExpr(a2, d, y(symbolTable));
        } else if (a2 == 400 && c()) {
            this.f2789a.a();
            ASTList A = A(symbolTable);
            int d2 = d();
            if (this.f2789a.a() != 41) {
                throw new CompileError(") is missing", this.f2789a);
            }
            return new CastExpr(A, d2, y(symbolTable));
        } else {
            return B(symbolTable);
        }
    }

    private boolean b() {
        int i;
        int i2 = 2;
        do {
            i = i2 + 1;
            if (this.f2789a.a(i2) != 91) {
                return this.f2789a.a(i + (-1)) == 41;
            }
            i2 = i + 1;
        } while (this.f2789a.a(i) == 93);
        return false;
    }

    private boolean c() {
        int d = d(1);
        if (d >= 0 && this.f2789a.a(d) == 41) {
            int a2 = this.f2789a.a(d + 1);
            return a2 == 40 || a2 == 412 || a2 == 406 || a2 == 400 || a2 == 339 || a2 == 336 || a2 == 328 || a2 == 410 || a2 == 411 || a2 == 403 || a2 == 402 || a2 == 401 || a2 == 405 || a2 == 404;
        }
        return false;
    }

    private int d(int i) {
        int i2;
        do {
            int i3 = i + 1;
            if (this.f2789a.a(i3) != 46) {
                do {
                    i2 = i3 + 1;
                    if (this.f2789a.a(i3) != 91) {
                        return i2 - 1;
                    }
                    i3 = i2 + 1;
                } while (this.f2789a.a(i2) == 93);
                return -1;
            }
            i = i3 + 1;
        } while (this.f2789a.a(i) == 400);
        return -1;
    }

    private int d() {
        int i = 0;
        while (this.f2789a.b() == 91) {
            i++;
            this.f2789a.a();
            if (this.f2789a.a() != 93) {
                throw new CompileError("] is missing", this.f2789a);
            }
        }
        return i;
    }

    private ASTList A(SymbolTable symbolTable) {
        ASTList aSTList = null;
        while (this.f2789a.a() == 400) {
            aSTList = ASTList.append(aSTList, new Symbol(this.f2789a.c()));
            if (this.f2789a.b() == 46) {
                this.f2789a.a();
            } else {
                return aSTList;
            }
        }
        throw new SyntaxError(this.f2789a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
        throw new javassist.compiler.SyntaxError(r7.f2789a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ASTree B(SymbolTable symbolTable) {
        int b2 = this.f2789a.b();
        switch (b2) {
            case BdWebErrorView.ERROR_CODE_401 /* 401 */:
            case 402:
            case BdWebErrorView.ERROR_CODE_403 /* 403 */:
                this.f2789a.a();
                return new IntConst(this.f2789a.d(), b2);
            case BdWebErrorView.ERROR_CODE_404 /* 404 */:
            case BdWebErrorView.ERROR_CODE_405 /* 405 */:
                this.f2789a.a();
                return new DoubleConst(this.f2789a.e(), b2);
            default:
                ASTree C = C(symbolTable);
                while (true) {
                    switch (this.f2789a.b()) {
                        case 35:
                            this.f2789a.a();
                            if (this.f2789a.a() != 400) {
                                throw new CompileError("missing static member name", this.f2789a);
                            }
                            C = Expr.make(35, new Symbol(a(C)), new Member(this.f2789a.c()));
                            break;
                        case 40:
                            C = b(symbolTable, C);
                            break;
                        case 46:
                            this.f2789a.a();
                            int a2 = this.f2789a.a();
                            if (a2 == 307) {
                                C = a(C, 0);
                                break;
                            } else if (a2 == 400) {
                                C = Expr.make(46, C, new Member(this.f2789a.c()));
                                break;
                            } else {
                                throw new CompileError("missing member name", this.f2789a);
                            }
                        case 91:
                            if (this.f2789a.a(1) == 93) {
                                int d = d();
                                if (this.f2789a.a() == 46 && this.f2789a.a() == 307) {
                                    C = a(C, d);
                                    break;
                                }
                            } else {
                                ASTree F = F(symbolTable);
                                if (F == null) {
                                    throw new SyntaxError(this.f2789a);
                                }
                                C = Expr.make(65, C, F);
                                break;
                            }
                            break;
                        case 362:
                        case 363:
                            C = Expr.make(this.f2789a.a(), (ASTree) null, C);
                            break;
                        default:
                            return C;
                    }
                }
                break;
        }
    }

    private ASTree a(ASTree aSTree, int i) {
        String a2 = a(aSTree);
        if (i > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                int i2 = i - 1;
                if (i <= 0) {
                    break;
                }
                stringBuffer.append('[');
                i = i2;
            }
            stringBuffer.append('L').append(a2.replace('.', '/')).append(';');
            a2 = stringBuffer.toString();
        }
        return Expr.make(46, new Symbol(a2), new Member("class"));
    }

    private ASTree a(int i, int i2) {
        String str;
        if (i2 > 0) {
            return Expr.make(46, new Symbol(CodeGen.b(i, i2)), new Member("class"));
        }
        switch (i) {
            case BVideoView.MEDIA_ERROR_NO_INPUTFILE /* 301 */:
                str = "java.lang.Boolean";
                break;
            case BVideoView.MEDIA_ERROR_NO_SUPPORTED_CODEC /* 303 */:
                str = "java.lang.Byte";
                break;
            case 306:
                str = "java.lang.Character";
                break;
            case 312:
                str = "java.lang.Double";
                break;
            case 317:
                str = "java.lang.Float";
                break;
            case 324:
                str = "java.lang.Integer";
                break;
            case 326:
                str = "java.lang.Long";
                break;
            case 334:
                str = "java.lang.Short";
                break;
            case 344:
                str = "java.lang.Void";
                break;
            default:
                throw new CompileError("invalid builtin type: " + i);
        }
        return Expr.make(35, new Symbol(str), new Member("TYPE"));
    }

    private ASTree b(SymbolTable symbolTable, ASTree aSTree) {
        int operator;
        if (aSTree instanceof Keyword) {
            int i = ((Keyword) aSTree).get();
            if (i != 339 && i != 336) {
                throw new SyntaxError(this.f2789a);
            }
        } else if (!(aSTree instanceof Symbol) && (aSTree instanceof Expr) && (operator = ((Expr) aSTree).getOperator()) != 46 && operator != 35) {
            throw new SyntaxError(this.f2789a);
        }
        return CallExpr.makeCall(aSTree, G(symbolTable));
    }

    private String a(ASTree aSTree) {
        StringBuffer stringBuffer = new StringBuffer();
        a(aSTree, stringBuffer);
        return stringBuffer.toString();
    }

    private void a(ASTree aSTree, StringBuffer stringBuffer) {
        if (aSTree instanceof Symbol) {
            stringBuffer.append(((Symbol) aSTree).get());
            return;
        }
        if (aSTree instanceof Expr) {
            Expr expr = (Expr) aSTree;
            if (expr.getOperator() == 46) {
                a(expr.oprand1(), stringBuffer);
                stringBuffer.append('.');
                a(expr.oprand2(), stringBuffer);
                return;
            }
        }
        throw new CompileError("bad static member access", this.f2789a);
    }

    private ASTree C(SymbolTable symbolTable) {
        int a2 = this.f2789a.a();
        switch (a2) {
            case 40:
                ASTree b2 = b(symbolTable);
                if (this.f2789a.a() != 41) {
                    throw new CompileError(") is missing", this.f2789a);
                }
                return b2;
            case 328:
                return D(symbolTable);
            case 336:
            case 339:
            case BdWebErrorView.ERROR_CODE_410 /* 410 */:
            case BdWebErrorView.ERROR_CODE_411 /* 411 */:
            case BdWebErrorView.ERROR_CODE_412 /* 412 */:
                return new Keyword(a2);
            case BdWebErrorView.ERROR_CODE_400 /* 400 */:
                String c = this.f2789a.c();
                Declarator lookup = symbolTable.lookup(c);
                if (lookup == null) {
                    return new Member(c);
                }
                return new Variable(c, lookup);
            case BdWebErrorView.ERROR_CODE_406 /* 406 */:
                return new StringL(this.f2789a.c());
            default:
                if (a(a2) || a2 == 344) {
                    int d = d();
                    if (this.f2789a.a() == 46 && this.f2789a.a() == 307) {
                        return a(a2, d);
                    }
                }
                throw new SyntaxError(this.f2789a);
        }
    }

    private NewExpr D(SymbolTable symbolTable) {
        ArrayInit arrayInit = null;
        int b2 = this.f2789a.b();
        if (a(b2)) {
            this.f2789a.a();
            ASTList E = E(symbolTable);
            if (this.f2789a.b() == 123) {
                arrayInit = u(symbolTable);
            }
            return new NewExpr(b2, E, arrayInit);
        }
        if (b2 == 400) {
            ASTList A = A(symbolTable);
            int b3 = this.f2789a.b();
            if (b3 == 40) {
                return new NewExpr(A, G(symbolTable));
            }
            if (b3 == 91) {
                ASTList E2 = E(symbolTable);
                if (this.f2789a.b() == 123) {
                    arrayInit = u(symbolTable);
                }
                return NewExpr.makeObjectArray(A, E2, arrayInit);
            }
        }
        throw new SyntaxError(this.f2789a);
    }

    private ASTList E(SymbolTable symbolTable) {
        ASTList aSTList = null;
        while (this.f2789a.b() == 91) {
            aSTList = ASTList.append(aSTList, F(symbolTable));
        }
        return aSTList;
    }

    private ASTree F(SymbolTable symbolTable) {
        this.f2789a.a();
        if (this.f2789a.b() == 93) {
            this.f2789a.a();
            return null;
        }
        ASTree b2 = b(symbolTable);
        if (this.f2789a.a() != 93) {
            throw new CompileError("] is missing", this.f2789a);
        }
        return b2;
    }

    private ASTList G(SymbolTable symbolTable) {
        if (this.f2789a.a() != 40) {
            throw new CompileError("( is missing", this.f2789a);
        }
        ASTList aSTList = null;
        if (this.f2789a.b() != 41) {
            while (true) {
                aSTList = ASTList.append(aSTList, b(symbolTable));
                if (this.f2789a.b() != 44) {
                    break;
                }
                this.f2789a.a();
            }
        }
        if (this.f2789a.a() != 41) {
            throw new CompileError(") is missing", this.f2789a);
        }
        return aSTList;
    }
}
