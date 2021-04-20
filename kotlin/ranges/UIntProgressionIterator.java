package kotlin.ranges;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.NoSuchElementException;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0019\u0010\u000b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", "", "hasNext", "()Z", "Lkotlin/UInt;", "nextUInt", "()I", "finalElement", "I", "Z", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "step", Config.TRACE_VISIT_FIRST, "last", "", "<init>", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class UIntProgressionIterator extends UIntIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public UIntProgressionIterator(int i, int i2, int i3) {
        this.finalElement = i2;
        boolean z = true;
        int uintCompare = UnsignedKt.uintCompare(i, i2);
        if (i3 <= 0 ? uintCompare < 0 : uintCompare > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = UInt.m717constructorimpl(i3);
        this.next = this.hasNext ? i : this.finalElement;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.UIntIterator
    public int nextUInt() {
        int i = this.next;
        if (i == this.finalElement) {
            if (this.hasNext) {
                this.hasNext = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.next = UInt.m717constructorimpl(this.step + i);
        }
        return i;
    }

    public /* synthetic */ UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }
}
