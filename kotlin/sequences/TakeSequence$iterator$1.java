package kotlin.sequences;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"kotlin/sequences/TakeSequence$iterator$1", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "hasNext", "()Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "", CustomDialogData.POS_LEFT, "I", "getLeft", "()I", "setLeft", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class TakeSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    public final Iterator<T> iterator;
    public int left;
    public final /* synthetic */ TakeSequence this$0;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public TakeSequence$iterator$1(TakeSequence takeSequence) {
        int i2;
        Sequence sequence;
        this.this$0 = takeSequence;
        i2 = takeSequence.count;
        this.left = i2;
        sequence = takeSequence.sequence;
        this.iterator = sequence.iterator();
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getLeft() {
        return this.left;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.left > 0 && this.iterator.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        int i2 = this.left;
        if (i2 != 0) {
            this.left = i2 - 1;
            return this.iterator.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setLeft(int i2) {
        this.left = i2;
    }
}
