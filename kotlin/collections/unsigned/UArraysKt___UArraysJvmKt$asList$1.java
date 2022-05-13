package kotlin.collections.unsigned;

import com.baidu.sofire.sharedpreferences.SharedPreferenceManager;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysKt;
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0011J\b\u0010\u0014\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0017"}, d2 = {"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$1", "Lkotlin/collections/AbstractList;", "Lkotlin/UInt;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-WZ4Q5Ns", "(I)Z", SharedPreferenceManager.OPERATION_GET_PERFIX, "index", "get-pVg5ArA", "(I)I", "indexOf", "indexOf-WZ4Q5Ns", "isEmpty", "lastIndexOf", "lastIndexOf-WZ4Q5Ns", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class UArraysKt___UArraysJvmKt$asList$1 extends AbstractList<UInt> implements RandomAccess {
    public final /* synthetic */ int[] $this_asList;

    public UArraysKt___UArraysJvmKt$asList$1(int[] iArr) {
        this.$this_asList = iArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m1168containsWZ4Q5Ns(((UInt) obj).m834unboximpl());
        }
        return false;
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m1168containsWZ4Q5Ns(int i) {
        return UIntArray.m838containsWZ4Q5Ns(this.$this_asList, i);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return UInt.m777boximpl(m1169getpVg5ArA(i));
    }

    /* renamed from: get-pVg5ArA  reason: not valid java name */
    public int m1169getpVg5ArA(int i) {
        return UIntArray.m842getpVg5ArA(this.$this_asList, i);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return UIntArray.m843getSizeimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof UInt) {
            return m1170indexOfWZ4Q5Ns(((UInt) obj).m834unboximpl());
        }
        return -1;
    }

    /* renamed from: indexOf-WZ4Q5Ns  reason: not valid java name */
    public int m1170indexOfWZ4Q5Ns(int i) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, i);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return UIntArray.m845isEmptyimpl(this.$this_asList);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof UInt) {
            return m1171lastIndexOfWZ4Q5Ns(((UInt) obj).m834unboximpl());
        }
        return -1;
    }

    /* renamed from: lastIndexOf-WZ4Q5Ns  reason: not valid java name */
    public int m1171lastIndexOfWZ4Q5Ns(int i) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, i);
    }
}
