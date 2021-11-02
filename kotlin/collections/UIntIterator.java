package kotlin.collections;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.jvm.internal.markers.KMappedMarker;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lkotlin/collections/UIntIterator;", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "Lkotlin/UInt;", "next-pVg5ArA", "()I", UnitedSchemeConstants.UNITED_SCHEME_NEXT, "nextUInt-pVg5ArA", "nextUInt", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@ExperimentalUnsignedTypes
/* loaded from: classes3.dex */
public abstract class UIntIterator implements Iterator<UInt>, KMappedMarker {
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UInt next() {
        return UInt.m732boximpl(m1080nextpVg5ArA());
    }

    /* renamed from: next-pVg5ArA  reason: not valid java name */
    public final int m1080nextpVg5ArA() {
        return mo799nextUIntpVg5ArA();
    }

    /* renamed from: nextUInt-pVg5ArA */
    public abstract int mo799nextUIntpVg5ArA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
