package javassist.convert;

import javassist.bytecode.CodeIterator;
/* loaded from: classes.dex */
public class TransformAfter extends TransformBefore {
    @Override // javassist.convert.TransformBefore
    protected int a(int i, CodeIterator codeIterator) {
        codeIterator.a(i);
        codeIterator.a(this.d);
        codeIterator.a(this.e);
        codeIterator.b(codeIterator.g(3));
        codeIterator.a(this.e);
        int f = codeIterator.f();
        int b = codeIterator.b();
        codeIterator.a(codeIterator.c(f), b);
        codeIterator.b(codeIterator.d(f + 1), b + 1);
        codeIterator.a(184, f);
        codeIterator.b(this.m, f + 1);
        codeIterator.a(b);
        return codeIterator.f();
    }
}
