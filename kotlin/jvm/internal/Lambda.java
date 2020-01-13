package kotlin.jvm.internal;

import java.io.Serializable;
/* loaded from: classes5.dex */
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
        String a = t.a((Lambda) this);
        q.i(a, "Reflection.renderLambdaToString(this)");
        return a;
    }
}
