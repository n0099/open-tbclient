package kotlin.sequences;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "drop", "()V", "", "hasNext", "()Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Ljava/lang/Object;", "", "iterator", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "", "position", "I", "getPosition", "()I", "setPosition", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class SubSequence$iterator$1 implements Iterator<T>, KMappedMarker {
    public final Iterator<T> iterator;
    public int position;
    public final /* synthetic */ SubSequence this$0;

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    public SubSequence$iterator$1(SubSequence subSequence) {
        Sequence sequence;
        this.this$0 = subSequence;
        sequence = subSequence.sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drop() {
        int i;
        while (r0 < i && this.iterator.hasNext()) {
            this.iterator.next();
            this.position++;
        }
    }

    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        drop();
        int i2 = this.position;
        i = this.this$0.endIndex;
        return i2 < i && this.iterator.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        int i;
        drop();
        int i2 = this.position;
        i = this.this$0.endIndex;
        if (i2 < i) {
            this.position++;
            return this.iterator.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setPosition(int i) {
        this.position = i;
    }
}
