package javassist.convert;

import javassist.bytecode.Bytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.h;
/* loaded from: classes.dex */
public class TransformBefore extends TransformCall {

    /* renamed from: a  reason: collision with root package name */
    protected h[] f2831a;
    protected int b;
    protected int c;
    protected byte[] d;
    protected byte[] e;

    @Override // javassist.convert.TransformCall, javassist.convert.Transformer
    public void a(y yVar, CodeAttribute codeAttribute) {
        super.a(yVar, codeAttribute);
        this.b = 0;
        this.c = codeAttribute.g();
        this.e = null;
        this.d = null;
    }

    @Override // javassist.convert.TransformCall
    protected int a(int i, int i2, CodeIterator codeIterator, int i3, y yVar) {
        if (this.m == 0) {
            this.m = yVar.c(yVar.a(this.j), yVar.a(this.k, z.b(this.g, z.b(this.f2831a) + 'V')));
            this.n = yVar;
        }
        if (this.d == null) {
            a(this.f2831a, yVar);
        }
        return a(i2, codeIterator);
    }

    protected int a(int i, CodeIterator codeIterator) {
        codeIterator.a(i);
        codeIterator.a(this.d);
        codeIterator.a(this.e);
        int g = codeIterator.g(3);
        codeIterator.a(184, g);
        codeIterator.b(this.m, g + 1);
        codeIterator.a(this.e);
        return codeIterator.f();
    }

    @Override // javassist.convert.Transformer
    public int b() {
        return this.b;
    }

    protected void a(h[] hVarArr, y yVar) {
        Bytecode bytecode = new Bytecode(yVar, 0, 0);
        Bytecode bytecode2 = new Bytecode(yVar, 0, 0);
        int i = this.c;
        int length = hVarArr == null ? 0 : hVarArr.length;
        bytecode2.k(i);
        a(bytecode, bytecode2, 0, length, hVarArr, i + 1);
        bytecode.l(i);
        this.d = bytecode.f();
        this.e = bytecode2.f();
    }

    private void a(Bytecode bytecode, Bytecode bytecode2, int i, int i2, h[] hVarArr, int i3) {
        if (i < i2) {
            a(bytecode, bytecode2, i + 1, i2, hVarArr, i3 + bytecode2.a(i3, hVarArr[i]));
            bytecode.b(i3, hVarArr[i]);
            return;
        }
        this.b = i3 - this.c;
    }
}
