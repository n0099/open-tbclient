package kotlin.sequences;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class GeneratorSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    public T nextItem;
    public int nextState = -2;
    public final /* synthetic */ GeneratorSequence this$0;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public GeneratorSequence$iterator$1(GeneratorSequence generatorSequence) {
        this.this$0 = generatorSequence;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    private final void calcNext() {
        Function1 function1;
        T t;
        Function0 function0;
        if (this.nextState == -2) {
            function0 = this.this$0.getInitialValue;
            t = function0.invoke();
        } else {
            function1 = this.this$0.getNextValue;
            T t2 = this.nextItem;
            Intrinsics.checkNotNull(t2);
            t = function1.invoke(t2);
        }
        this.nextItem = t;
        this.nextState = t == 0 ? 0 : 1;
    }

    public final T getNextItem() {
        return this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        return this.nextState == 1;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t = this.nextItem;
            if (t != 0) {
                this.nextState = -1;
                return t;
            }
            throw new NullPointerException("null cannot be cast to non-null type T");
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(T t) {
        this.nextItem = t;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }
}
