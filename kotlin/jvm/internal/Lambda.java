package kotlin.jvm.internal;

import java.io.Serializable;
@kotlin.h
/* loaded from: classes10.dex */
public abstract class Lambda<R> implements Serializable, p<R> {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.p
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String a2 = t.a((Lambda) this);
        q.m(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
