package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.h;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final kotlin.coroutines.c _context;
    private transient kotlin.coroutines.a<Object> intercepted;

    public ContinuationImpl(kotlin.coroutines.a<Object> aVar, kotlin.coroutines.c cVar) {
        super(aVar);
        this._context = cVar;
    }

    public ContinuationImpl(kotlin.coroutines.a<Object> aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }

    @Override // kotlin.coroutines.a
    public kotlin.coroutines.c getContext() {
        kotlin.coroutines.c cVar = this._context;
        if (cVar == null) {
            q.dKW();
        }
        return cVar;
    }

    public final kotlin.coroutines.a<Object> intercepted() {
        ContinuationImpl continuationImpl = this.intercepted;
        if (continuationImpl == null) {
            kotlin.coroutines.b bVar = (kotlin.coroutines.b) getContext().get(kotlin.coroutines.b.nDO);
            if (bVar == null || (continuationImpl = bVar.a(this)) == null) {
                continuationImpl = this;
            }
            this.intercepted = continuationImpl;
        }
        return continuationImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        kotlin.coroutines.a<?> aVar = this.intercepted;
        if (aVar != null && aVar != this) {
            c.b bVar = getContext().get(kotlin.coroutines.b.nDO);
            if (bVar == null) {
                q.dKW();
            }
            ((kotlin.coroutines.b) bVar).b(aVar);
        }
        this.intercepted = a.nDV;
    }
}
