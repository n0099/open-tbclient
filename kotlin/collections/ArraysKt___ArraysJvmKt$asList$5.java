package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\rR\u0016\u0010\u0013\u001a\u00020\b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Ljava/util/RandomAccess;", "Lkotlin/collections/AbstractList;", "", "element", "", "contains", "(F)Z", "", "index", "get", "(I)Ljava/lang/Float;", "indexOf", "(F)I", "isEmpty", "()Z", "lastIndexOf", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {
    public final /* synthetic */ float[] $this_asList;

    public ArraysKt___ArraysJvmKt$asList$5(float[] fArr) {
        this.$this_asList = fArr;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Float) {
            return contains(((Number) obj).floatValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Float) {
            return indexOf(((Number) obj).floatValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.$this_asList.length == 0;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Float) {
            return lastIndexOf(((Number) obj).floatValue());
        }
        return -1;
    }

    public boolean contains(float f2) {
        for (float f3 : this.$this_asList) {
            if (Float.floatToIntBits(f3) == Float.floatToIntBits(f2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.collections.AbstractList, java.util.List
    public Float get(int i2) {
        return Float.valueOf(this.$this_asList[i2]);
    }

    public int indexOf(float f2) {
        float[] fArr = this.$this_asList;
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (Float.floatToIntBits(fArr[i2]) == Float.floatToIntBits(f2)) {
                return i2;
            }
        }
        return -1;
    }

    public int lastIndexOf(float f2) {
        float[] fArr = this.$this_asList;
        for (int length = fArr.length - 1; length >= 0; length--) {
            if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f2)) {
                return length;
            }
        }
        return -1;
    }
}
