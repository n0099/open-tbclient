package kotlin.coroutines.experimental;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010,\u001a\u00060*j\u0002`+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-\u0082\u0002\u0004\n\u0002\b\t¨\u00060"}, d2 = {"Lkotlin/coroutines/experimental/SequenceBuilderIterator;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Iterator;", "Lkotlin/coroutines/experimental/Continuation;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/coroutines/experimental/SequenceBuilder;", "", "exceptionalState", "()Ljava/lang/Throwable;", "", "hasNext", "()Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "nextNotReady", "", "value", "resume", "(Lkotlin/Unit;)V", "exception", "resumeWithException", "(Ljava/lang/Throwable;)V", "yield", "(Ljava/lang/Object;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "", "iterator", "yieldAll", "(Ljava/util/Iterator;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/experimental/CoroutineContext;", "getContext", "()Lkotlin/coroutines/experimental/CoroutineContext;", "context", "nextIterator", "Ljava/util/Iterator;", "nextStep", "Lkotlin/coroutines/experimental/Continuation;", "getNextStep", "()Lkotlin/coroutines/experimental/Continuation;", "setNextStep", "(Lkotlin/coroutines/experimental/Continuation;)V", "nextValue", "Ljava/lang/Object;", "", "Lkotlin/coroutines/experimental/State;", "state", "I", "<init>", "()V", "kotlin-stdlib-coroutines"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class SequenceBuilderIterator<T> extends SequenceBuilder<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    public Iterator<? extends T> nextIterator;
    public Continuation<? super Unit> nextStep;
    public T nextValue;
    public int state;

    private final Throwable exceptionalState() {
        int i = this.state;
        if (i != 4) {
            if (i != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.state);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    private final T nextNotReady() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.coroutines.experimental.Continuation<? super kotlin.Unit>, kotlin.coroutines.experimental.Continuation<kotlin.Unit> */
    public final Continuation<Unit> getNextStep() {
        return this.nextStep;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.state;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw exceptionalState();
                }
                Iterator<? extends T> it = this.nextIterator;
                if (it == null) {
                    Intrinsics.throwNpe();
                }
                if (it.hasNext()) {
                    this.state = 2;
                    return true;
                }
                this.nextIterator = null;
            }
            this.state = 5;
            Continuation<? super Unit> continuation = this.nextStep;
            if (continuation == null) {
                Intrinsics.throwNpe();
            }
            this.nextStep = null;
            continuation.resume(Unit.INSTANCE);
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.state;
        if (i == 0 || i == 1) {
            return nextNotReady();
        }
        if (i == 2) {
            this.state = 1;
            Iterator<? extends T> it = this.nextIterator;
            if (it == null) {
                Intrinsics.throwNpe();
            }
            return it.next();
        } else if (i == 3) {
            this.state = 0;
            T t = this.nextValue;
            this.nextValue = null;
            return t;
        } else {
            throw exceptionalState();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.experimental.Continuation
    public void resumeWithException(Throwable th) {
        throw th;
    }

    public final void setNextStep(Continuation<? super Unit> continuation) {
        this.nextStep = continuation;
    }

    @Override // kotlin.coroutines.experimental.SequenceBuilder
    public Object yield(T t, Continuation<? super Unit> continuation) {
        this.nextValue = t;
        this.state = 3;
        setNextStep(CoroutineIntrinsics.normalizeContinuation(continuation));
        return IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
    }

    @Override // kotlin.coroutines.experimental.SequenceBuilder
    public Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation) {
        if (it.hasNext()) {
            this.nextIterator = it;
            this.state = 2;
            setNextStep(CoroutineIntrinsics.normalizeContinuation(continuation));
            return IntrinsicsKt__IntrinsicsJvmKt.getCOROUTINE_SUSPENDED();
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.coroutines.experimental.Continuation
    public void resume(Unit unit) {
        this.state = 4;
    }
}
