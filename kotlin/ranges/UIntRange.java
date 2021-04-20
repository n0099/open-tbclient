package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0017\u001a\u00020\u00038V@\u0016X\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u00020\u00038V@\u0016X\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/UInt;", "value", "", "contains-WZ4Q5Ns", "(I)Z", "contains", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "getEndInclusive", "()Lkotlin/UInt;", "endInclusive", "getStart", IntentConfig.START, "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final UIntRange EMPTY = new UIntRange(-1, 0, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "Lkotlin/ranges/UIntRange;", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public Companion() {
        }

        public final UIntRange getEMPTY() {
            return UIntRange.EMPTY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public UIntRange(int i, int i2) {
        super(i, i2, 1, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return m1509containsWZ4Q5Ns(uInt.m760unboximpl());
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m1509containsWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(getFirst(), i) <= 0 && UnsignedKt.uintCompare(i, getLast()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (getFirst() != uIntRange.getFirst() || getLast() != uIntRange.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return UnsignedKt.uintCompare(getFirst(), getLast()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return UInt.m754toStringimpl(getFirst()) + IStringUtil.TOP_PATH + UInt.m754toStringimpl(getLast());
    }

    public /* synthetic */ UIntRange(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.ranges.ClosedRange
    public UInt getEndInclusive() {
        return UInt.m711boximpl(getLast());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.ranges.ClosedRange
    public UInt getStart() {
        return UInt.m711boximpl(getFirst());
    }
}
