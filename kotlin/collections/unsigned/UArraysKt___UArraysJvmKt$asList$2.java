package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0018"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$2", "Ljava/util/RandomAccess;", "Lkotlin/collections/AbstractList;", "Lkotlin/ULong;", "element", "", "contains-VKZWuLQ", "(J)Z", "contains", "", "index", "get-s-VKNKU", "(I)J", "get", "indexOf-VKZWuLQ", "(J)I", "indexOf", "isEmpty", "()Z", "lastIndexOf-VKZWuLQ", "lastIndexOf", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class UArraysKt___UArraysJvmKt$asList$2 extends AbstractList<ULong> implements RandomAccess {
    public final /* synthetic */ long[] $this_asList;

    public UArraysKt___UArraysJvmKt$asList$2(long[] jArr) {
        this.$this_asList = jArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m1103containsVKZWuLQ(((ULong) obj).m851unboximpl());
        }
        return false;
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m1103containsVKZWuLQ(long j) {
        return ULongArray.m855containsVKZWuLQ(this.$this_asList, j);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i2) {
        return ULong.m802boximpl(m1104getsVKNKU(i2));
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public long m1104getsVKNKU(int i2) {
        return ULongArray.m859getsVKNKU(this.$this_asList, i2);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return ULongArray.m860getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ULong) {
            return m1105indexOfVKZWuLQ(((ULong) obj).m851unboximpl());
        }
        return -1;
    }

    /* renamed from: indexOf-VKZWuLQ  reason: not valid java name */
    public int m1105indexOfVKZWuLQ(long j) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, j);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ULongArray.m862isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ULong) {
            return m1106lastIndexOfVKZWuLQ(((ULong) obj).m851unboximpl());
        }
        return -1;
    }

    /* renamed from: lastIndexOf-VKZWuLQ  reason: not valid java name */
    public int m1106lastIndexOfVKZWuLQ(long j) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, j);
    }
}
