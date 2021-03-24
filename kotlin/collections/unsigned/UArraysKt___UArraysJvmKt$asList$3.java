package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Ljava/util/RandomAccess;", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "element", "", "contains-7apg3OU", "(B)Z", "contains", "", "index", "get", "(I)Lkotlin/UByte;", "indexOf-7apg3OU", "(B)I", "indexOf", "isEmpty", "()Z", "lastIndexOf-7apg3OU", "lastIndexOf", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class UArraysKt___UArraysJvmKt$asList$3 extends AbstractList<UByte> implements RandomAccess {
    public final /* synthetic */ byte[] $this_asList;

    public UArraysKt___UArraysJvmKt$asList$3(byte[] bArr) {
        this.$this_asList = bArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m1001contains7apg3OU(((UByte) obj).m687unboximpl());
        }
        return false;
    }

    /* renamed from: contains-7apg3OU  reason: not valid java name */
    public boolean m1001contains7apg3OU(byte b2) {
        return UByteArray.m691contains7apg3OU(this.$this_asList, b2);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UByteArray.m696getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof UByte) {
            return m1002indexOf7apg3OU(((UByte) obj).m687unboximpl());
        }
        return -1;
    }

    /* renamed from: indexOf-7apg3OU  reason: not valid java name */
    public int m1002indexOf7apg3OU(byte b2) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, b2);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UByteArray.m698isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof UByte) {
            return m1003lastIndexOf7apg3OU(((UByte) obj).m687unboximpl());
        }
        return -1;
    }

    /* renamed from: lastIndexOf-7apg3OU  reason: not valid java name */
    public int m1003lastIndexOf7apg3OU(byte b2) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, b2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.collections.AbstractList, java.util.List
    public UByte get(int i) {
        return UByte.m640boximpl(UByteArray.m695getimpl(this.$this_asList, i));
    }
}
