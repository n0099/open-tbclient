package javassist.compiler;

import javassist.bytecode.Bytecode;
/* loaded from: classes.dex */
public abstract class c {
    c c;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(Bytecode bytecode, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(CodeGen codeGen) {
        this.c = codeGen.h;
        codeGen.h = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CodeGen codeGen) {
        codeGen.h = this.c;
    }
}
