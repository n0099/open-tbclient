package d.h.c.c;

import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import d.h.c.c.y0;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class i<R, C, V> implements y0<R, C, V> {
    public transient Set<y0.a<R, C, V>> cellSet;
    public transient Collection<V> values;

    /* loaded from: classes6.dex */
    public class a extends a1<y0.a<R, C, V>, V> {
        public a(i iVar, Iterator it) {
            super(it);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.h.c.c.a1
        /* renamed from: b */
        public V a(y0.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractSet<y0.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof y0.a) {
                y0.a aVar = (y0.a) obj;
                Map map = (Map) Maps.x(i.this.rowMap(), aVar.getRowKey());
                return map != null && n.d(map.entrySet(), Maps.j(aVar.getColumnKey(), aVar.getValue()));
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<y0.a<R, C, V>> iterator() {
            return i.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof y0.a) {
                y0.a aVar = (y0.a) obj;
                Map map = (Map) Maps.x(i.this.rowMap(), aVar.getRowKey());
                return map != null && n.e(map.entrySet(), Maps.j(aVar.getColumnKey(), aVar.getValue()));
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return i.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return i.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return i.this.size();
        }
    }

    public abstract Iterator<y0.a<R, C, V>> cellIterator();

    @Override // d.h.c.c.y0
    public Set<y0.a<R, C, V>> cellSet() {
        Set<y0.a<R, C, V>> set = this.cellSet;
        if (set == null) {
            Set<y0.a<R, C, V>> createCellSet = createCellSet();
            this.cellSet = createCellSet;
            return createCellSet;
        }
        return set;
    }

    @Override // d.h.c.c.y0
    public abstract void clear();

    @Override // d.h.c.c.y0
    public abstract Set<C> columnKeySet();

    @Override // d.h.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        return map != null && Maps.w(map, obj2);
    }

    @Override // d.h.c.c.y0
    public boolean containsColumn(Object obj) {
        return Maps.w(columnMap(), obj);
    }

    @Override // d.h.c.c.y0
    public boolean containsRow(Object obj) {
        return Maps.w(rowMap(), obj);
    }

    @Override // d.h.c.c.y0
    public boolean containsValue(Object obj) {
        for (Map<C, V> map : rowMap().values()) {
            if (map.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<y0.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    @Override // d.h.c.c.y0
    public boolean equals(Object obj) {
        return Tables.b(this, obj);
    }

    @Override // d.h.c.c.y0
    public V get(Object obj, Object obj2) {
        Map map = (Map) Maps.x(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.x(map, obj2);
    }

    @Override // d.h.c.c.y0
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // d.h.c.c.y0
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // d.h.c.c.y0
    public abstract V put(R r, C c2, V v);

    @Override // d.h.c.c.y0
    public void putAll(y0<? extends R, ? extends C, ? extends V> y0Var) {
        for (y0.a<? extends R, ? extends C, ? extends V> aVar : y0Var.cellSet()) {
            put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        }
    }

    @Override // d.h.c.c.y0
    public abstract V remove(Object obj, Object obj2);

    @Override // d.h.c.c.y0
    public abstract Set<R> rowKeySet();

    public String toString() {
        return rowMap().toString();
    }

    @Override // d.h.c.c.y0
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }
        return collection;
    }

    public Iterator<V> valuesIterator() {
        return new a(this, cellSet().iterator());
    }
}
