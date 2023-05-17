package kotlin.reflect.jvm.internal.pcollections;
/* loaded from: classes10.dex */
public final class IntTree<V> {
    public static final IntTree<Object> EMPTYNODE = new IntTree<>();
    public final long key;
    public final IntTree<V> left;
    public final IntTree<V> right;
    public final int size;
    public final V value;

    public IntTree() {
        this.size = 0;
        this.key = 0L;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private long minKey() {
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            return this.key;
        }
        return intTree.minKey() + this.key;
    }

    public IntTree(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        this.key = j;
        this.value = v;
        this.left = intTree;
        this.right = intTree2;
        this.size = intTree.size + 1 + intTree2.size;
    }

    public static <V> IntTree<V> rebalanced(long j, V v, IntTree<V> intTree, IntTree<V> intTree2) {
        int i = intTree.size;
        int i2 = intTree2.size;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                IntTree<V> intTree3 = intTree.left;
                IntTree<V> intTree4 = intTree.right;
                if (intTree4.size < intTree3.size * 2) {
                    long j2 = intTree.key;
                    return new IntTree<>(j2 + j, intTree.value, intTree3, new IntTree(-j2, v, intTree4.withKey(intTree4.key + j2), intTree2));
                }
                IntTree<V> intTree5 = intTree4.left;
                IntTree<V> intTree6 = intTree4.right;
                long j3 = intTree4.key;
                long j4 = intTree.key + j3 + j;
                V v2 = intTree4.value;
                IntTree intTree7 = new IntTree(-j3, intTree.value, intTree3, intTree5.withKey(intTree5.key + j3));
                long j5 = intTree.key;
                long j6 = intTree4.key;
                return new IntTree<>(j4, v2, intTree7, new IntTree((-j5) - j6, v, intTree6.withKey(intTree6.key + j6 + j5), intTree2));
            } else if (i2 >= i * 5) {
                IntTree<V> intTree8 = intTree2.left;
                IntTree<V> intTree9 = intTree2.right;
                if (intTree8.size < intTree9.size * 2) {
                    long j7 = intTree2.key;
                    return new IntTree<>(j7 + j, intTree2.value, new IntTree(-j7, v, intTree, intTree8.withKey(intTree8.key + j7)), intTree9);
                }
                IntTree<V> intTree10 = intTree8.left;
                IntTree<V> intTree11 = intTree8.right;
                long j8 = intTree8.key;
                long j9 = intTree2.key;
                long j10 = j8 + j9 + j;
                V v3 = intTree8.value;
                IntTree intTree12 = new IntTree((-j9) - j8, v, intTree, intTree10.withKey(intTree10.key + j8 + j9));
                long j11 = intTree8.key;
                return new IntTree<>(j10, v3, intTree12, new IntTree(-j11, intTree2.value, intTree11.withKey(intTree11.key + j11), intTree9));
            }
        }
        return new IntTree<>(j, v, intTree, intTree2);
    }

    private IntTree<V> rebalanced(IntTree<V> intTree, IntTree<V> intTree2) {
        if (intTree == this.left && intTree2 == this.right) {
            return this;
        }
        return rebalanced(this.key, this.value, intTree, intTree2);
    }

    private IntTree<V> withKey(long j) {
        if (this.size != 0 && j != this.key) {
            return new IntTree<>(j, this.value, this.left, this.right);
        }
        return this;
    }

    public V get(long j) {
        if (this.size == 0) {
            return null;
        }
        long j2 = this.key;
        if (j < j2) {
            return this.left.get(j - j2);
        }
        if (j > j2) {
            return this.right.get(j - j2);
        }
        return this.value;
    }

    public IntTree<V> minus(long j) {
        if (this.size == 0) {
            return this;
        }
        long j2 = this.key;
        if (j < j2) {
            return rebalanced(this.left.minus(j - j2), this.right);
        }
        if (j > j2) {
            return rebalanced(this.left, this.right.minus(j - j2));
        }
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            IntTree<V> intTree2 = this.right;
            return intTree2.withKey(intTree2.key + j2);
        }
        IntTree<V> intTree3 = this.right;
        if (intTree3.size == 0) {
            return intTree.withKey(intTree.key + j2);
        }
        long minKey = intTree3.minKey();
        long j3 = this.key;
        long j4 = minKey + j3;
        V v = this.right.get(j4 - j3);
        IntTree<V> minus = this.right.minus(j4 - this.key);
        IntTree<V> withKey = minus.withKey((minus.key + this.key) - j4);
        IntTree<V> intTree4 = this.left;
        return rebalanced(j4, v, intTree4.withKey((intTree4.key + this.key) - j4), withKey);
    }

    public IntTree<V> plus(long j, V v) {
        if (this.size == 0) {
            return new IntTree<>(j, v, this, this);
        }
        long j2 = this.key;
        if (j < j2) {
            return rebalanced(this.left.plus(j - j2, v), this.right);
        }
        if (j > j2) {
            return rebalanced(this.left, this.right.plus(j - j2, v));
        }
        if (v == this.value) {
            return this;
        }
        return new IntTree<>(j, v, this.left, this.right);
    }
}
