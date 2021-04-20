package kotlin.collections;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0004\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/collections/ULongIterator;", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/ULong;", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "()Lkotlin/ULong;", "nextULong", "()J", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes7.dex */
public abstract class ULongIterator implements Iterator<ULong>, KMappedMarker {
    public abstract long nextULong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    public final ULong next() {
        return ULong.m780boximpl(nextULong());
    }
}
