package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\fR\u0016\u0010\u0012\u001a\u00020\u00078V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$7", "Ljava/util/RandomAccess;", "Lkotlin/collections/AbstractList;", "", "element", "contains", "(Z)Z", "", "index", "get", "(I)Ljava/lang/Boolean;", "indexOf", "(Z)I", "isEmpty", "()Z", "lastIndexOf", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ArraysKt___ArraysJvmKt$asList$7 extends AbstractList<Boolean> implements RandomAccess {
    public final /* synthetic */ boolean[] $this_asList;

    public ArraysKt___ArraysJvmKt$asList$7(boolean[] zArr) {
        this.$this_asList = zArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Boolean) {
            return contains(((Boolean) obj).booleanValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Boolean) {
            return indexOf(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Boolean) {
            return lastIndexOf(((Boolean) obj).booleanValue());
        }
        return -1;
    }

    public boolean contains(boolean z) {
        return ArraysKt___ArraysKt.contains(this.$this_asList, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.collections.AbstractList, java.util.List
    public Boolean get(int i2) {
        return Boolean.valueOf(this.$this_asList[i2]);
    }

    public int indexOf(boolean z) {
        return ArraysKt___ArraysKt.indexOf(this.$this_asList, z);
    }

    public int lastIndexOf(boolean z) {
        return ArraysKt___ArraysKt.lastIndexOf(this.$this_asList, z);
    }
}
