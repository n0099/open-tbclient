package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B%\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u00048B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlin/sequences/SubSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "", "n", "drop", "(I)Lkotlin/sequences/Sequence;", "", "iterator", "()Ljava/util/Iterator;", "take", "getCount", "()I", "count", "endIndex", "I", "sequence", "Lkotlin/sequences/Sequence;", "startIndex", "<init>", "(Lkotlin/sequences/Sequence;II)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    public final int endIndex;
    public final Sequence<T> sequence;
    public final int startIndex;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.sequences.Sequence<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(Sequence<? extends T> sequence, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.startIndex = i2;
        this.endIndex = i3;
        if (i2 >= 0) {
            if (this.endIndex >= 0) {
                if (this.endIndex >= this.startIndex) {
                    return;
                }
                throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + this.endIndex + " < " + this.startIndex).toString());
            }
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + this.endIndex).toString());
        }
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + this.startIndex).toString());
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int i2) {
        return i2 >= getCount() ? SequencesKt__SequencesKt.emptySequence() : new SubSequence(this.sequence, this.startIndex + i2, this.endIndex);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new SubSequence$iterator$1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int i2) {
        if (i2 >= getCount()) {
            return this;
        }
        Sequence<T> sequence = this.sequence;
        int i3 = this.startIndex;
        return new SubSequence(sequence, i3, i2 + i3);
    }
}
