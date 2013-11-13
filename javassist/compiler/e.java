package javassist.compiler;

import com.baidu.location.BDLocation;
import java.util.ArrayList;
import javassist.bytecode.Bytecode;
/* loaded from: classes.dex */
class e extends c {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f2842a;
    CodeGen b;
    int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CodeGen codeGen) {
        super(codeGen);
        this.f2842a = new ArrayList();
        this.b = codeGen;
        this.d = -1;
    }

    private int a(int i) {
        if (this.d < 0) {
            this.d = this.b.b();
            this.b.b(i);
        }
        return this.d;
    }

    private void a(Bytecode bytecode) {
        bytecode.g(BDLocation.TypeServerError);
        this.f2842a.add(new int[]{bytecode.h(), this.d});
        bytecode.j(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.compiler.c
    public boolean a(Bytecode bytecode, int i) {
        switch (i) {
            case 172:
                bytecode.o(a(1));
                a(bytecode);
                bytecode.n(this.d);
                return false;
            case 173:
                bytecode.q(a(2));
                a(bytecode);
                bytecode.p(this.d);
                return false;
            case 174:
                bytecode.u(a(1));
                a(bytecode);
                bytecode.t(this.d);
                return false;
            case 175:
                bytecode.s(a(2));
                a(bytecode);
                bytecode.r(this.d);
                return false;
            case 176:
                bytecode.l(a(1));
                a(bytecode);
                bytecode.k(this.d);
                return false;
            case 177:
                a(bytecode);
                return false;
            default:
                throw new RuntimeException("fatal");
        }
    }
}
