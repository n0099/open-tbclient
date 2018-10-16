package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public abstract class Lambda implements FunctionBase {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        return s.a(this);
    }
}
