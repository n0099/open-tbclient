package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.h;
@h
/* loaded from: classes7.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(kotlin.coroutines.a<Object> aVar) {
        super(aVar);
        if (aVar == null) {
            return;
        }
        if (aVar.getContext() == EmptyCoroutineContext.INSTANCE) {
            return;
        }
        throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
    }

    @Override // kotlin.coroutines.a
    public kotlin.coroutines.c getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
