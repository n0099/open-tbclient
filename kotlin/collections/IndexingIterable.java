package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\b¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlin/collections/IndexingIterable;", "T", "Ljava/lang/Iterable;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "Lkotlin/collections/IndexedValue;", "iterator", "()Ljava/util/Iterator;", "Lkotlin/Function0;", "iteratorFactory", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class IndexingIterable<T> implements Iterable<IndexedValue<? extends T>>, KMappedMarker {
    public final Function0<Iterator<T>> iteratorFactory;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends java.util.Iterator<? extends T>> */
    /* JADX WARN: Multi-variable type inference failed */
    public IndexingIterable(Function0<? extends Iterator<? extends T>> iteratorFactory) {
        Intrinsics.checkNotNullParameter(iteratorFactory, "iteratorFactory");
        this.iteratorFactory = iteratorFactory;
    }

    @Override // java.lang.Iterable
    public Iterator<IndexedValue<T>> iterator() {
        return new IndexingIterator(this.iteratorFactory.invoke());
    }
}
