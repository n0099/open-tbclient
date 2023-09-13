package kotlin.ranges;

import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.player.ubc.FloatingStatPlugin;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.internal.UProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\"\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0086\u0002ø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0019\u0010\b\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\f\u001a\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001b"}, d2 = {"Lkotlin/ranges/ULongProgression;", "", "Lkotlin/ULong;", "start", "endInclusive", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", Config.TRACE_VISIT_FIRST, "getFirst-s-VKNKU", "()J", "J", FloatingStatPlugin.VALUE_LAST, "getLast-s-VKNKU", "getStep", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "isEmpty", "iterator", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes2.dex */
public class ULongProgression implements Iterable<ULong>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    public final long first;
    public final long last;
    public final long step;

    public /* synthetic */ ULongProgression(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lkotlin/ranges/ULongProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/ULongProgression;", "rangeStart", "Lkotlin/ULong;", "rangeEnd", "step", "", "fromClosedRange-7ftBX0g", "(JJJ)Lkotlin/ranges/ULongProgression;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }

        /* renamed from: fromClosedRange-7ftBX0g  reason: not valid java name */
        public final ULongProgression m2063fromClosedRange7ftBX0g(long j, long j2, long j3) {
            return new ULongProgression(j, j2, j3, null);
        }
    }

    public ULongProgression(long j, long j2, long j3) {
        if (j3 != 0) {
            if (j3 != Long.MIN_VALUE) {
                this.first = j;
                this.last = UProgressionUtilKt.m2040getProgressionLastElement7ftBX0g(j, j2, j3);
                this.step = j3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof ULongProgression) {
            if (!isEmpty() || !((ULongProgression) obj).isEmpty()) {
                ULongProgression uLongProgression = (ULongProgression) obj;
                if (m2061getFirstsVKNKU() != uLongProgression.m2061getFirstsVKNKU() || m2062getLastsVKNKU() != uLongProgression.m2062getLastsVKNKU() || this.step != uLongProgression.step) {
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: getFirst-s-VKNKU  reason: not valid java name */
    public final long m2061getFirstsVKNKU() {
        return this.first;
    }

    /* renamed from: getLast-s-VKNKU  reason: not valid java name */
    public final long m2062getLastsVKNKU() {
        return this.last;
    }

    public final long getStep() {
        return this.step;
    }

    public boolean isEmpty() {
        int i = (this.step > 0L ? 1 : (this.step == 0L ? 0 : -1));
        int ulongCompare = UnsignedKt.ulongCompare(m2061getFirstsVKNKU(), m2062getLastsVKNKU());
        if (i > 0) {
            if (ulongCompare > 0) {
                return true;
            }
        } else if (ulongCompare < 0) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public final Iterator<ULong> iterator() {
        return new ULongProgressionIterator(m2061getFirstsVKNKU(), m2062getLastsVKNKU(), this.step, null);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.step;
        return ((int) (j ^ (j >>> 32))) + (((((int) ULong.m1022constructorimpl(m2061getFirstsVKNKU() ^ ULong.m1022constructorimpl(m2061getFirstsVKNKU() >>> 32))) * 31) + ((int) ULong.m1022constructorimpl(m2062getLastsVKNKU() ^ ULong.m1022constructorimpl(m2062getLastsVKNKU() >>> 32)))) * 31);
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.step > 0) {
            sb = new StringBuilder();
            sb.append((Object) ULong.m1067toStringimpl(m2061getFirstsVKNKU()));
            sb.append(IStringUtil.TOP_PATH);
            sb.append((Object) ULong.m1067toStringimpl(m2062getLastsVKNKU()));
            sb.append(" step ");
            j = this.step;
        } else {
            sb = new StringBuilder();
            sb.append((Object) ULong.m1067toStringimpl(m2061getFirstsVKNKU()));
            sb.append(" downTo ");
            sb.append((Object) ULong.m1067toStringimpl(m2062getLastsVKNKU()));
            sb.append(" step ");
            j = -this.step;
        }
        sb.append(j);
        return sb.toString();
    }
}
