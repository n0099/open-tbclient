package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u0000B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0019\u0010\u000e\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "value", "", "append", "(Ljava/lang/Object;)V", "start", "()V", "take", "()Ljava/lang/Object;", "", "a", "[Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "", "i", "I", "n", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class ThreadState {
    public Object[] a;
    public final CoroutineContext context;

    /* renamed from: i  reason: collision with root package name */
    public int f62484i;

    public ThreadState(CoroutineContext coroutineContext, int i2) {
        this.context = coroutineContext;
        this.a = new Object[i2];
    }

    public final void append(Object obj) {
        Object[] objArr = this.a;
        int i2 = this.f62484i;
        this.f62484i = i2 + 1;
        objArr[i2] = obj;
    }

    public final CoroutineContext getContext() {
        return this.context;
    }

    public final void start() {
        this.f62484i = 0;
    }

    public final Object take() {
        Object[] objArr = this.a;
        int i2 = this.f62484i;
        this.f62484i = i2 + 1;
        return objArr[i2];
    }
}
