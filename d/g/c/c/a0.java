package d.g.c.c;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class a0<E> extends r<E> implements Set<E> {
    @Override // d.g.c.c.r, d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.g.c.c.r, d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // d.g.c.c.r, d.g.c.c.y
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    public boolean standardEquals(Object obj) {
        return Sets.a(this, obj);
    }

    public int standardHashCode() {
        return Sets.b(this);
    }

    @Override // d.g.c.c.r
    public boolean standardRemoveAll(Collection<?> collection) {
        d.g.c.a.n.p(collection);
        return Sets.g(this, collection);
    }
}
