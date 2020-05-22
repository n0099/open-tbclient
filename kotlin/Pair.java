package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.q;
@h
/* loaded from: classes7.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.Pair */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = pair.first;
        }
        if ((i & 2) != 0) {
            obj2 = pair.second;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final Pair<A, B> copy(A a, B b) {
        return new Pair<>(a, b);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                if (!q.l(this.first, pair.first) || !q.l(this.second, pair.second)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.first;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.second;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    public Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
