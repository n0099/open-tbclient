package kotlin.collections;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.RandomAccess;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"kotlin/collections/ArraysKt___ArraysJvmKt$asList$5", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "index", "(I)Ljava/lang/Float;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ArraysKt___ArraysJvmKt$asList$5 extends AbstractList<Float> implements RandomAccess {
    public final /* synthetic */ float[] $this_asList;

    public ArraysKt___ArraysJvmKt$asList$5(float[] fArr) {
        this.$this_asList = fArr;
    }

    public boolean contains(float f) {
        boolean z;
        for (float f2 : this.$this_asList) {
            if (Float.floatToIntBits(f2) == Float.floatToIntBits(f)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.collections.AbstractList, java.util.List
    public Float get(int i) {
        return Float.valueOf(this.$this_asList[i]);
    }

    public int indexOf(float f) {
        boolean z;
        float[] fArr = this.$this_asList;
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (Float.floatToIntBits(fArr[i]) == Float.floatToIntBits(f)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(float f) {
        boolean z;
        float[] fArr = this.$this_asList;
        int length = fArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i = length - 1;
            if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return length;
            }
            if (i < 0) {
                return -1;
            }
            length = i;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Float)) {
            return false;
        }
        return contains(((Number) obj).floatValue());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        return indexOf(((Number) obj).floatValue());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        return lastIndexOf(((Number) obj).floatValue());
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.$this_asList.length;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        if (this.$this_asList.length == 0) {
            return true;
        }
        return false;
    }
}
