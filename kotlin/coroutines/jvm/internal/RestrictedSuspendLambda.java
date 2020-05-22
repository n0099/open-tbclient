package kotlin.coroutines.jvm.internal;

import kotlin.h;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
@h
/* loaded from: classes7.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements p<Object> {
    private final int arity;

    @Override // kotlin.jvm.internal.p
    public int getArity() {
        return this.arity;
    }

    public RestrictedSuspendLambda(int i, kotlin.coroutines.a<Object> aVar) {
        super(aVar);
        this.arity = i;
    }

    public RestrictedSuspendLambda(int i) {
        this(i, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() == null) {
            String a = t.a(this);
            q.l((Object) a, "Reflection.renderLambdaToString(this)");
            return a;
        }
        return super.toString();
    }
}
