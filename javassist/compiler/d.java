package javassist.compiler;

import javassist.bytecode.Bytecode;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.Member;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2841a;
    final /* synthetic */ ASTree b;
    final /* synthetic */ Javac c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Javac javac, String str, ASTree aSTree) {
        this.c = javac;
        this.f2841a = str;
        this.b = aSTree;
    }

    @Override // javassist.compiler.h
    public void a(JvstCodeGen jvstCodeGen, Bytecode bytecode, ASTList aSTList) {
        ASTree member = new Member(this.f2841a);
        if (this.b != null) {
            member = Expr.make(46, this.b, member);
        }
        jvstCodeGen.a((ASTree) CallExpr.makeCall(member, aSTList));
        jvstCodeGen.f();
    }

    @Override // javassist.compiler.h
    public void a(JvstTypeChecker jvstTypeChecker, ASTList aSTList) {
        ASTree member = new Member(this.f2841a);
        if (this.b != null) {
            member = Expr.make(46, this.b, member);
        }
        CallExpr.makeCall(member, aSTList).accept(jvstTypeChecker);
        jvstTypeChecker.a();
    }
}
