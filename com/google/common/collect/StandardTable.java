package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import d.g.c.a.n;
import d.g.c.a.o;
import d.g.c.a.r;
import d.g.c.c.v;
import d.g.c.c.y0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class StandardTable<R, C, V> extends d.g.c.c.i<R, C, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final Map<R, Map<C, V>> backingMap;
    public transient Set<C> columnKeySet;
    public transient StandardTable<R, C, V>.f columnMap;
    public final r<? extends Map<C, V>> factory;
    public transient Map<R, Map<C, V>> rowMap;

    /* loaded from: classes6.dex */
    public class b implements Iterator<y0.a<R, C, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final Iterator<Map.Entry<R, Map<C, V>>> f32075e;

        /* renamed from: f  reason: collision with root package name */
        public Map.Entry<R, Map<C, V>> f32076f;

        /* renamed from: g  reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f32077g;

        public b() {
            this.f32075e = StandardTable.this.backingMap.entrySet().iterator();
            this.f32077g = Iterators.j();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public y0.a<R, C, V> next() {
            if (!this.f32077g.hasNext()) {
                Map.Entry<R, Map<C, V>> next = this.f32075e.next();
                this.f32076f = next;
                this.f32077g = next.getValue().entrySet().iterator();
            }
            Map.Entry<C, V> next2 = this.f32077g.next();
            return Tables.c(this.f32076f.getKey(), next2.getKey(), next2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f32075e.hasNext() || this.f32077g.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f32077g.remove();
            if (this.f32076f.getValue().isEmpty()) {
                this.f32075e.remove();
                this.f32076f = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends Maps.u<R, V> {

        /* renamed from: h  reason: collision with root package name */
        public final C f32079h;

        /* loaded from: classes6.dex */
        public class a extends Sets.a<Map.Entry<R, V>> {
            public a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                c.this.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.containsMapping(entry.getKey(), c.this.f32079h, entry.getValue());
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                c cVar = c.this;
                return !StandardTable.this.containsColumn(cVar.f32079h);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return StandardTable.this.removeMapping(entry.getKey(), c.this.f32079h, entry.getValue());
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Predicates.g(Predicates.e(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                int i2 = 0;
                for (Map<C, V> map : StandardTable.this.backingMap.values()) {
                    if (map.containsKey(c.this.f32079h)) {
                        i2++;
                    }
                }
                return i2;
            }
        }

        /* loaded from: classes6.dex */
        public class b extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<Map.Entry<R, Map<C, V>>> f32082g;

            /* loaded from: classes6.dex */
            public class a extends d.g.c.c.b<R, V> {

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ Map.Entry f32084e;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public a(Map.Entry entry) {
                    this.f32084e = entry;
                }

                @Override // d.g.c.c.b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f32084e.getKey();
                }

                @Override // d.g.c.c.b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) this.f32084e.getValue()).get(c.this.f32079h);
                }

                @Override // d.g.c.c.b, java.util.Map.Entry
                public V setValue(V v) {
                    C c2 = c.this.f32079h;
                    n.p(v);
                    return (V) ((Map) this.f32084e.getValue()).put(c2, v);
                }
            }

            public b() {
                this.f32082g = StandardTable.this.backingMap.entrySet().iterator();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.common.collect.AbstractIterator
            /* renamed from: d */
            public Map.Entry<R, V> a() {
                while (this.f32082g.hasNext()) {
                    Map.Entry<R, Map<C, V>> next = this.f32082g.next();
                    if (next.getValue().containsKey(c.this.f32079h)) {
                        return new a(next);
                    }
                }
                return b();
            }
        }

        /* renamed from: com.google.common.collect.StandardTable$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0354c extends Maps.m<R, V> {
            public C0354c() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                c cVar = c.this;
                return StandardTable.this.contains(obj, cVar.f32079h);
            }

            @Override // com.google.common.collect.Maps.m, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                c cVar = c.this;
                return StandardTable.this.remove(obj, cVar.f32079h) != null;
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.o(Predicates.g(Predicates.e(collection))));
            }
        }

        /* loaded from: classes6.dex */
        public class d extends Maps.t<R, V> {
            public d() {
                super(c.this);
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && c.this.d(Maps.N(Predicates.d(obj)));
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return c.this.d(Maps.N(Predicates.e(collection)));
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return c.this.d(Maps.N(Predicates.g(Predicates.e(collection))));
            }
        }

        public c(C c2) {
            n.p(c2);
            this.f32079h = c2;
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<R, V>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.u
        public Set<R> b() {
            return new C0354c();
        }

        @Override // com.google.common.collect.Maps.u
        public Collection<V> c() {
            return new d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.contains(obj, this.f32079h);
        }

        public boolean d(o<? super Map.Entry<R, V>> oVar) {
            Iterator<Map.Entry<R, Map<C, V>>> it = StandardTable.this.backingMap.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<R, Map<C, V>> next = it.next();
                Map<C, V> value = next.getValue();
                V v = value.get(this.f32079h);
                if (v != null && oVar.apply(Maps.j(next.getKey(), v))) {
                    value.remove(this.f32079h);
                    z = true;
                    if (value.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return (V) StandardTable.this.get(obj, this.f32079h);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r, V v) {
            return (V) StandardTable.this.put(r, this.f32079h, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return (V) StandardTable.this.remove(obj, this.f32079h);
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AbstractIterator<C> {

        /* renamed from: g  reason: collision with root package name */
        public final Map<C, V> f32088g;

        /* renamed from: h  reason: collision with root package name */
        public final Iterator<Map<C, V>> f32089h;

        /* renamed from: i  reason: collision with root package name */
        public Iterator<Map.Entry<C, V>> f32090i;

        public d() {
            this.f32088g = StandardTable.this.factory.get();
            this.f32089h = StandardTable.this.backingMap.values().iterator();
            this.f32090i = Iterators.h();
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            while (true) {
                if (this.f32090i.hasNext()) {
                    Map.Entry<C, V> next = this.f32090i.next();
                    if (!this.f32088g.containsKey(next.getKey())) {
                        this.f32088g.put(next.getKey(), next.getValue());
                        return next.getKey();
                    }
                } else if (this.f32089h.hasNext()) {
                    this.f32090i = this.f32089h.next().entrySet().iterator();
                } else {
                    return b();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends StandardTable<R, C, V>.i<C> {
        public e() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return StandardTable.this.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z = false;
            if (obj == null) {
                return false;
            }
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().remove(obj)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            n.p(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (Iterators.r(next.keySet().iterator(), collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            n.p(collection);
            Iterator<Map<C, V>> it = StandardTable.this.backingMap.values().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map<C, V> next = it.next();
                if (next.keySet().retainAll(collection)) {
                    z = true;
                    if (next.isEmpty()) {
                        it.remove();
                    }
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.u(iterator());
        }
    }

    /* loaded from: classes6.dex */
    public class f extends Maps.u<C, Map<R, V>> {

        /* loaded from: classes6.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<C, Map<R, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0355a implements d.g.c.a.g<C, Map<R, V>> {
                public C0355a() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.g.c.a.g
                /* renamed from: a */
                public Map<R, V> apply(C c2) {
                    return StandardTable.this.column(c2);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (StandardTable.this.containsColumn(entry.getKey())) {
                        return f.this.get(entry.getKey()).equals(entry.getValue());
                    }
                    return false;
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.d(StandardTable.this.columnKeySet(), new C0355a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (contains(obj)) {
                    StandardTable.this.removeColumn(((Map.Entry) obj).getKey());
                    return true;
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                n.p(collection);
                return Sets.h(this, collection.iterator());
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.google.common.collect.StandardTable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                n.p(collection);
                Iterator it = Lists.k(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(Maps.j(next, StandardTable.this.column(next)))) {
                        StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.columnKeySet().size();
            }
        }

        /* loaded from: classes6.dex */
        public class b extends Maps.t<C, Map<R, V>> {
            public b() {
                super(f.this);
            }

            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry<C, Map<R, V>> entry : f.this.entrySet()) {
                    if (entry.getValue().equals(obj)) {
                        StandardTable.this.removeColumn(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.google.common.collect.StandardTable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                n.p(collection);
                Iterator it = Lists.k(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: com.google.common.collect.StandardTable */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.t, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                n.p(collection);
                Iterator it = Lists.k(StandardTable.this.columnKeySet().iterator()).iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!collection.contains(StandardTable.this.column(next))) {
                        StandardTable.this.removeColumn(next);
                        z = true;
                    }
                }
                return z;
            }
        }

        public f() {
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a();
        }

        @Override // com.google.common.collect.Maps.u
        public Collection<Map<R, V>> c() {
            return new b();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsColumn(obj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Map<R, V> get(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.column(obj);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Map<R, V> remove(Object obj) {
            if (StandardTable.this.containsColumn(obj)) {
                return StandardTable.this.removeColumn(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.u, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return StandardTable.this.columnKeySet();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends Maps.l<C, V> {

        /* renamed from: e  reason: collision with root package name */
        public final R f32096e;

        /* renamed from: f  reason: collision with root package name */
        public Map<C, V> f32097f;

        /* loaded from: classes6.dex */
        public class a implements Iterator<Map.Entry<C, V>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Iterator f32099e;

            public a(Iterator it) {
                this.f32099e = it;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<C, V> next() {
                return g.this.e((Map.Entry) this.f32099e.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f32099e.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f32099e.remove();
                g.this.d();
            }
        }

        /* loaded from: classes6.dex */
        public class b extends v<C, V> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Map.Entry f32101e;

            public b(g gVar, Map.Entry entry) {
                this.f32101e = entry;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.y
            /* renamed from: b */
            public Map.Entry<C, V> delegate() {
                return this.f32101e;
            }

            @Override // d.g.c.c.v, java.util.Map.Entry
            public boolean equals(Object obj) {
                return standardEquals(obj);
            }

            @Override // d.g.c.c.v, java.util.Map.Entry
            public V setValue(V v) {
                n.p(v);
                return (V) super.setValue(v);
            }
        }

        public g(R r) {
            n.p(r);
            this.f32096e = r;
        }

        @Override // com.google.common.collect.Maps.l
        public Iterator<Map.Entry<C, V>> a() {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return Iterators.j();
            }
            return new a(b2.entrySet().iterator());
        }

        public Map<C, V> b() {
            Map<C, V> map = this.f32097f;
            if (map == null || (map.isEmpty() && StandardTable.this.backingMap.containsKey(this.f32096e))) {
                Map<C, V> c2 = c();
                this.f32097f = c2;
                return c2;
            }
            return this.f32097f;
        }

        public Map<C, V> c() {
            return StandardTable.this.backingMap.get(this.f32096e);
        }

        @Override // com.google.common.collect.Maps.l, java.util.AbstractMap, java.util.Map
        public void clear() {
            Map<C, V> b2 = b();
            if (b2 != null) {
                b2.clear();
            }
            d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map<C, V> b2 = b();
            return (obj == null || b2 == null || !Maps.w(b2, obj)) ? false : true;
        }

        public void d() {
            if (b() == null || !this.f32097f.isEmpty()) {
                return;
            }
            StandardTable.this.backingMap.remove(this.f32096e);
            this.f32097f = null;
        }

        public Map.Entry<C, V> e(Map.Entry<C, V> entry) {
            return new b(this, entry);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Map<C, V> b2 = b();
            if (obj == null || b2 == null) {
                return null;
            }
            return (V) Maps.x(b2, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C c2, V v) {
            n.p(c2);
            n.p(v);
            Map<C, V> map = this.f32097f;
            if (map != null && !map.isEmpty()) {
                return this.f32097f.put(c2, v);
            }
            return (V) StandardTable.this.put(this.f32096e, c2, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return null;
            }
            V v = (V) Maps.y(b2, obj);
            d();
            return v;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            Map<C, V> b2 = b();
            if (b2 == null) {
                return 0;
            }
            return b2.size();
        }
    }

    /* loaded from: classes6.dex */
    public class h extends Maps.u<R, Map<C, V>> {

        /* loaded from: classes6.dex */
        public class a extends StandardTable<R, C, V>.i<Map.Entry<R, Map<C, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$h$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class C0356a implements d.g.c.a.g<R, Map<C, V>> {
                public C0356a() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.g.c.a.g
                /* renamed from: a */
                public Map<C, V> apply(R r) {
                    return StandardTable.this.row(r);
                }
            }

            public a() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && d.g.c.c.n.d(StandardTable.this.backingMap.entrySet(), entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.d(StandardTable.this.backingMap.keySet(), new C0356a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    return entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.backingMap.entrySet().remove(entry);
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.backingMap.size();
            }
        }

        public h() {
        }

        @Override // com.google.common.collect.Maps.u
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.containsRow(obj);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: d */
        public Map<C, V> get(Object obj) {
            if (StandardTable.this.containsRow(obj)) {
                return StandardTable.this.row(obj);
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e */
        public Map<C, V> remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return StandardTable.this.backingMap.remove(obj);
        }
    }

    /* loaded from: classes6.dex */
    public abstract class i<T> extends Sets.a<T> {
        public i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.backingMap.isEmpty();
        }
    }

    public StandardTable(Map<R, Map<C, V>> map, r<? extends Map<C, V>> rVar) {
        this.backingMap = map;
        this.factory = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean containsMapping(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(get(obj, obj2));
    }

    private Map<C, V> getOrCreate(R r) {
        Map<C, V> map = this.backingMap.get(r);
        if (map == null) {
            Map<C, V> map2 = this.factory.get();
            this.backingMap.put(r, map2);
            return map2;
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<R, V> removeColumn(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> it = this.backingMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<R, Map<C, V>> next = it.next();
            V remove = next.getValue().remove(obj);
            if (remove != null) {
                linkedHashMap.put(next.getKey(), remove);
                if (next.getValue().isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2, Object obj3) {
        if (containsMapping(obj, obj2, obj3)) {
            remove(obj, obj2);
            return true;
        }
        return false;
    }

    @Override // d.g.c.c.i
    public Iterator<y0.a<R, C, V>> cellIterator() {
        return new b();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public Set<y0.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public void clear() {
        this.backingMap.clear();
    }

    @Override // d.g.c.c.y0
    public Map<R, V> column(C c2) {
        return new c(c2);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public Set<C> columnKeySet() {
        Set<C> set = this.columnKeySet;
        if (set == null) {
            e eVar = new e();
            this.columnKeySet = eVar;
            return eVar;
        }
        return set;
    }

    @Override // d.g.c.c.y0
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.f fVar = this.columnMap;
        if (fVar == null) {
            StandardTable<R, C, V>.f fVar2 = new f();
            this.columnMap = fVar2;
            return fVar2;
        }
        return fVar;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.contains(obj, obj2)) ? false : true;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        for (Map<C, V> map : this.backingMap.values()) {
            if (Maps.w(map, obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsRow(Object obj) {
        return obj != null && Maps.w(this.backingMap, obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public Iterator<C> createColumnKeyIterator() {
        return new d();
    }

    public Map<R, Map<C, V>> createRowMap() {
        return new h();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public V get(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return (V) super.get(obj, obj2);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public V put(R r, C c2, V v) {
        n.p(r);
        n.p(c2);
        n.p(v);
        return getOrCreate(r).put(c2, v);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public V remove(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.x(this.backingMap, obj)) == null) {
            return null;
        }
        V v = (V) map.remove(obj2);
        if (map.isEmpty()) {
            this.backingMap.remove(obj);
        }
        return v;
    }

    @Override // d.g.c.c.y0
    public Map<C, V> row(R r) {
        return new g(r);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // d.g.c.c.y0
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map == null) {
            Map<R, Map<C, V>> createRowMap = createRowMap();
            this.rowMap = createRowMap;
            return createRowMap;
        }
        return map;
    }

    @Override // d.g.c.c.y0
    public int size() {
        int i2 = 0;
        for (Map<C, V> map : this.backingMap.values()) {
            i2 += map.size();
        }
        return i2;
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public Collection<V> values() {
        return super.values();
    }
}
