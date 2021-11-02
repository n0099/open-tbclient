package kotlin.sequences;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bR*\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "ensureItemIterator", "()Z", "hasNext", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "", "itemIterator", "Ljava/util/Iterator;", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class FlatteningSequence$iterator$1 implements Iterator<E>, KMappedMarker {
    public Iterator<? extends E> itemIterator;
    public final Iterator<T> iterator;
    public final /* synthetic */ FlatteningSequence this$0;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public FlatteningSequence$iterator$1(FlatteningSequence flatteningSequence) {
        Sequence sequence;
        this.this$0 = flatteningSequence;
        sequence = flatteningSequence.sequence;
        this.iterator = sequence.iterator();
    }

    private final boolean ensureItemIterator() {
        Function1 function1;
        Function1 function12;
        Iterator<? extends E> it = this.itemIterator;
        if (it != 0 && !it.hasNext()) {
            this.itemIterator = null;
        }
        while (true) {
            if (this.itemIterator == null) {
                if (!this.iterator.hasNext()) {
                    return false;
                }
                Object next = this.iterator.next();
                function1 = this.this$0.iterator;
                function12 = this.this$0.transformer;
                Iterator<? extends E> it2 = (Iterator) function1.invoke(function12.invoke(next));
                if (it2.hasNext()) {
                    this.itemIterator = it2;
                    break;
                }
            } else {
                break;
            }
        }
        return true;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Iterator<? extends E>, java.util.Iterator<E> */
    public final Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return ensureItemIterator();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [E, java.lang.Object] */
    @Override // java.util.Iterator
    public E next() {
        if (ensureItemIterator()) {
            Iterator<? extends E> it = this.itemIterator;
            Intrinsics.checkNotNull(it);
            return it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(Iterator<? extends E> it) {
        this.itemIterator = it;
    }
}
