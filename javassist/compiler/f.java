package javassist.compiler;

import com.baidu.location.BDLocation;
import javassist.bytecode.Bytecode;
/* loaded from: classes.dex */
class f extends c {

    /* renamed from: a  reason: collision with root package name */
    int f2827a;
    int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CodeGen codeGen, int[] iArr) {
        super(codeGen);
        this.b = iArr[0];
        this.f2827a = iArr[1];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.c
    public boolean a(Bytecode bytecode, int i) {
        switch (i) {
            case 172:
                bytecode.o(this.f2827a);
                break;
            case 173:
                bytecode.q(this.f2827a);
                break;
            case 174:
                bytecode.u(this.f2827a);
                break;
            case 175:
                bytecode.s(this.f2827a);
                break;
            case 176:
                bytecode.l(this.f2827a);
                break;
            case 177:
                break;
            default:
                throw new RuntimeException("fatal");
        }
        bytecode.g(BDLocation.TypeServerError);
        bytecode.j((this.b - bytecode.h()) + 3);
        return true;
    }
}
