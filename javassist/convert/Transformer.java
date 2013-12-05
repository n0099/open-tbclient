package javassist.convert;

import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.an;
import javassist.bytecode.as;
import javassist.bytecode.y;
import javassist.h;
/* loaded from: classes.dex */
public abstract class Transformer implements as {

    /* renamed from: a  reason: collision with root package name */
    private Transformer f3017a;

    public abstract int a(h hVar, int i, CodeIterator codeIterator, y yVar);

    public Transformer c() {
        return this.f3017a;
    }

    public void a(y yVar, CodeAttribute codeAttribute) {
    }

    public void a(y yVar, h hVar, an anVar) {
        a(yVar, anVar.i());
    }

    public void a() {
    }

    public int b() {
        return 0;
    }

    public int d() {
        return 0;
    }
}
