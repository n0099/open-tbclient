package kotlin.collections;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;
@Deprecated(level = DeprecationLevel.ERROR, message = "This class is not going to be stabilized and is to be removed soon.")
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, d2 = {"Lkotlin/collections/UIntIterator;", "", "Lkotlin/UInt;", "()V", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "next-pVg5ArA", "()I", "nextUInt", "nextUInt-pVg5ArA", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public abstract class UIntIterator implements Iterator<UInt>, KMappedMarker {
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m1724boximpl(m2096nextpVg5ArA());
    }

    /* renamed from: next-pVg5ArA  reason: not valid java name */
    public final int m2096nextpVg5ArA() {
        return mo1799nextUIntpVg5ArA();
    }

    /* renamed from: nextUInt-pVg5ArA */
    public abstract int mo1799nextUIntpVg5ArA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
