package d.g.c.c;

import com.google.common.collect.Range;
import java.lang.Comparable;
/* loaded from: classes6.dex */
public abstract class f<C extends Comparable> implements p0<C> {
    public abstract void add(Range<C> range);

    public void addAll(p0<C> p0Var) {
        addAll(p0Var.asRanges());
    }

    public void clear() {
        remove(Range.all());
    }

    public boolean contains(C c2) {
        return rangeContaining(c2) != null;
    }

    @Override // d.g.c.c.p0
    public abstract boolean encloses(Range<C> range);

    public boolean enclosesAll(p0<C> p0Var) {
        return enclosesAll(p0Var.asRanges());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p0) {
            return asRanges().equals(((p0) obj).asRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asRanges().hashCode();
    }

    public abstract boolean intersects(Range<C> range);

    @Override // d.g.c.c.p0
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    public abstract Range<C> rangeContaining(C c2);

    public abstract void remove(Range<C> range);

    @Override // d.g.c.c.p0
    public void removeAll(p0<C> p0Var) {
        removeAll(p0Var.asRanges());
    }

    public final String toString() {
        return asRanges().toString();
    }

    public void addAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            add(range);
        }
    }

    public boolean enclosesAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            if (!encloses(range)) {
                return false;
            }
        }
        return true;
    }

    public void removeAll(Iterable<Range<C>> iterable) {
        for (Range<C> range : iterable) {
            remove(range);
        }
    }
}
