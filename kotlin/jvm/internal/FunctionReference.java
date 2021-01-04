package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public class FunctionReference extends CallableReference implements FunctionBase, kotlin.reflect.e {
    private final int arity;

    public FunctionReference(int i) {
        this.arity = i;
    }

    public FunctionReference(int i, Object obj) {
        super(obj);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.e getReflected() {
        return (kotlin.reflect.e) super.getReflected();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        return s.a(this);
    }

    @Override // kotlin.reflect.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.reflect.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.e
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (getOwner() != null ? getOwner().equals(functionReference.getOwner()) : functionReference.getOwner() == null) {
                if (getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && p.l(getBoundReceiver(), functionReference.getBoundReceiver())) {
                    return true;
                }
            }
            return false;
        } else if (obj instanceof kotlin.reflect.e) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        kotlin.reflect.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "<init>".equals(getName()) ? "constructor (Kotlin reflection is not available)" : "function " + getName() + " (Kotlin reflection is not available)";
    }
}
