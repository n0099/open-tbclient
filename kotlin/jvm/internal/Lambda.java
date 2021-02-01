package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes6.dex */
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
