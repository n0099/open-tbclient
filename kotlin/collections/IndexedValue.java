package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\b\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lkotlin/collections/IndexedValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "component1", "()I", "component2", "()Ljava/lang/Object;", "index", "value", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "", "toString", "()Ljava/lang/String;", "I", "getIndex", "Ljava/lang/Object;", "getValue", "<init>", "(ILjava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class IndexedValue<T> {
    public final int index;
    public final T value;

    public IndexedValue(int i2, T t) {
        this.index = i2;
        this.value = t;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.collections.IndexedValue */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexedValue copy$default(IndexedValue indexedValue, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = indexedValue.index;
        }
        if ((i3 & 2) != 0) {
            obj = indexedValue.value;
        }
        return indexedValue.copy(i2, obj);
    }

    public final int component1() {
        return this.index;
    }

    public final T component2() {
        return this.value;
    }

    public final IndexedValue<T> copy(int i2, T t) {
        return new IndexedValue<>(i2, t);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof IndexedValue) {
                IndexedValue indexedValue = (IndexedValue) obj;
                return this.index == indexedValue.index && Intrinsics.areEqual(this.value, indexedValue.value);
            }
            return false;
        }
        return true;
    }

    public final int getIndex() {
        return this.index;
    }

    public final T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i2 = this.index * 31;
        T t = this.value;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    public String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + SmallTailInfo.EMOTION_SUFFIX;
    }
}
