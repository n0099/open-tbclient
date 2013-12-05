package javassist.compiler;

import javassist.bytecode.an;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public javassist.h f3009a;
    public an b;
    public int c;

    public g(javassist.h hVar, an anVar, int i) {
        this.f3009a = hVar;
        this.b = anVar;
        this.c = i;
    }

    public boolean a() {
        return (this.b.f() & 8) != 0;
    }
}
