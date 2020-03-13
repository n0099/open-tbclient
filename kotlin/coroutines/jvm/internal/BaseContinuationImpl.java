package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.h;
import kotlin.i;
import kotlin.jvm.internal.q;
import kotlin.l;
@h
/* loaded from: classes7.dex */
public abstract class BaseContinuationImpl implements Serializable, kotlin.coroutines.a<Object>, b {
    private final kotlin.coroutines.a<Object> completion;

    protected abstract Object invokeSuspend(Object obj);

    public BaseContinuationImpl(kotlin.coroutines.a<Object> aVar) {
        this.completion = aVar;
    }

    public final kotlin.coroutines.a<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.coroutines.a
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        e.c(this);
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            kotlin.coroutines.a<Object> aVar = baseContinuationImpl.completion;
            if (aVar == null) {
                q.dKw();
            }
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m570constructorimpl(i.N(th));
            }
            if (invokeSuspend != kotlin.coroutines.intrinsics.a.dKq()) {
                Result.a aVar3 = Result.Companion;
                obj = Result.m570constructorimpl(invokeSuspend);
                baseContinuationImpl.releaseIntercepted();
                if (aVar instanceof BaseContinuationImpl) {
                    baseContinuationImpl = (BaseContinuationImpl) aVar;
                } else {
                    aVar.resumeWith(obj);
                    return;
                }
            } else {
                return;
            }
        }
    }

    protected void releaseIntercepted() {
    }

    public kotlin.coroutines.a<l> create(kotlin.coroutines.a<?> aVar) {
        q.j(aVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public kotlin.coroutines.a<l> create(Object obj, kotlin.coroutines.a<?> aVar) {
        q.j(aVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("Continuation at ");
        StackTraceElement stackTraceElement = getStackTraceElement();
        return append.append(stackTraceElement != null ? stackTraceElement : getClass().getName()).toString();
    }

    public b getCallerFrame() {
        kotlin.coroutines.a<Object> aVar = this.completion;
        if (!(aVar instanceof b)) {
            aVar = null;
        }
        return (b) aVar;
    }

    public StackTraceElement getStackTraceElement() {
        return d.a(this);
    }
}
