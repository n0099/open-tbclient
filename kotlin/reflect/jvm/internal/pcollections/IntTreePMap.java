package kotlin.reflect.jvm.internal.pcollections;
/* loaded from: classes10.dex */
public final class IntTreePMap<V> {
    public static final IntTreePMap<Object> EMPTY = new IntTreePMap<>(IntTree.EMPTYNODE);
    public final IntTree<V> root;

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) EMPTY;
    }

    public IntTreePMap(IntTree<V> intTree) {
        this.root = intTree;
    }

    private IntTreePMap<V> withRoot(IntTree<V> intTree) {
        if (intTree == this.root) {
            return this;
        }
        return new IntTreePMap<>(intTree);
    }

    public V get(int i) {
        return this.root.get(i);
    }

    public IntTreePMap<V> minus(int i) {
        return withRoot(this.root.minus(i));
    }

    public IntTreePMap<V> plus(int i, V v) {
        return withRoot(this.root.plus(i, v));
    }
}
