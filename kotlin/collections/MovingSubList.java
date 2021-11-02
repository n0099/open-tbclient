package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlin/collections/MovingSubList;", ExifInterface.LONGITUDE_EAST, "Ljava/util/RandomAccess;", "Lkotlin/collections/AbstractList;", "", "index", "get", "(I)Ljava/lang/Object;", "fromIndex", "toIndex", "", "move", "(II)V", "_size", "I", "", "list", "Ljava/util/List;", "getSize", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class MovingSubList<E> extends AbstractList<E> implements RandomAccess {
    public int _size;
    public int fromIndex;
    public final List<E> list;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends E> */
    /* JADX WARN: Multi-variable type inference failed */
    public MovingSubList(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i2) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(i2, this._size);
        return this.list.get(this.fromIndex + i2);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this._size;
    }

    public final void move(int i2, int i3) {
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, this.list.size());
        this.fromIndex = i2;
        this._size = i3 - i2;
    }
}
