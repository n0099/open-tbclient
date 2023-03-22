package kotlin.ranges;

import com.baidu.mobstat.Config;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, d2 = {"Lkotlin/ranges/UIntProgressionIterator;", "Lkotlin/collections/UIntIterator;", Config.TRACE_VISIT_FIRST, "Lkotlin/UInt;", "last", "step", "", "(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "I", "hasNext", "", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "nextUInt", "nextUInt-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class UIntProgressionIterator extends UIntIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public /* synthetic */ UIntProgressionIterator(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public UIntProgressionIterator(int i, int i2, int i3) {
        this.finalElement = i2;
        boolean z = true;
        int uintCompare = UnsignedKt.uintCompare(i, i2);
        if (i3 <= 0 ? uintCompare < 0 : uintCompare > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = UInt.m862constructorimpl(i3);
        this.next = this.hasNext ? i : this.finalElement;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.UIntIterator
    /* renamed from: nextUInt-pVg5ArA */
    public int mo931nextUIntpVg5ArA() {
        int i = this.next;
        if (i == this.finalElement) {
            if (this.hasNext) {
                this.hasNext = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.next = UInt.m862constructorimpl(this.step + i);
        }
        return i;
    }
}
