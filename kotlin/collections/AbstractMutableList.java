package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableList;
@SinceKotlin(version = "1.1")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t\b\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlin/collections/AbstractMutableList;", "E", "Ljava/util/List;", "Lkotlin/jvm/internal/markers/KMutableList;", "Ljava/util/AbstractList;", "", "index", "element", "", "add", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public abstract class AbstractMutableList<E> extends java.util.AbstractList<E> implements List<E>, KMutableList {
    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i2, E e2);

    public abstract int getSize();

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i2) {
        return removeAt(i2);
    }

    public abstract E removeAt(int i2);

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i2, E e2);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }
}
