package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00038V@\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u001c\u0010\u0018\u001a\u00020\u00038V@\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/UInt;", "value", "", "contains-WZ4Q5Ns", "(I)Z", "contains", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "", "toString", "()Ljava/lang/String;", "getEndInclusive-pVg5ArA", "endInclusive", "getStart-pVg5ArA", "start", "<init>", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes9.dex */
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final UIntRange EMPTY = new UIntRange(-1, 0, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "Lkotlin/ranges/UIntRange;", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
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

    public UIntRange(int i2, int i3) {
        super(i2, i3, 1, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return m1833containsWZ4Q5Ns(uInt.m778unboximpl());
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m1833containsWZ4Q5Ns(int i2) {
        return UnsignedKt.uintCompare(m1830getFirstpVg5ArA(), i2) <= 0 && UnsignedKt.uintCompare(i2, m1831getLastpVg5ArA()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public boolean equals(Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (m1830getFirstpVg5ArA() != uIntRange.m1830getFirstpVg5ArA() || m1831getLastpVg5ArA() != uIntRange.m1831getLastpVg5ArA()) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getEndInclusive() {
        return UInt.m729boximpl(m1834getEndInclusivepVg5ArA());
    }

    /* renamed from: getEndInclusive-pVg5ArA  reason: not valid java name */
    public int m1834getEndInclusivepVg5ArA() {
        return m1831getLastpVg5ArA();
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getStart() {
        return UInt.m729boximpl(m1835getStartpVg5ArA());
    }

    /* renamed from: getStart-pVg5ArA  reason: not valid java name */
    public int m1835getStartpVg5ArA() {
        return m1830getFirstpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m1830getFirstpVg5ArA() * 31) + m1831getLastpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return UnsignedKt.uintCompare(m1830getFirstpVg5ArA(), m1831getLastpVg5ArA()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression
    public String toString() {
        return UInt.m772toStringimpl(m1830getFirstpVg5ArA()) + IStringUtil.TOP_PATH + UInt.m772toStringimpl(m1831getLastpVg5ArA());
    }

    public /* synthetic */ UIntRange(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3);
    }
}
