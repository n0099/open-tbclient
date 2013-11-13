package javassist.compiler;

import javassist.bytecode.Bytecode;
/* loaded from: classes.dex */
class b extends c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f2840a;
    final /* synthetic */ CodeGen b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CodeGen codeGen, CodeGen codeGen2, int i) {
        super(codeGen2);
        this.b = codeGen;
        this.f2840a = i;
    }

    @Override // javassist.compiler.c
    protected boolean a(Bytecode bytecode, int i) {
        bytecode.k(this.f2840a);
        bytecode.g(195);
        return false;
    }
}
