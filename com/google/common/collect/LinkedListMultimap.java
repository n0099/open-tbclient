package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import d.g.c.a.n;
import d.g.c.c.b1;
import d.g.c.c.g0;
import d.g.c.c.h0;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.n0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public class LinkedListMultimap<K, V> extends d.g.c.c.c<K, V> implements g0<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public transient g<K, V> head;
    public transient Map<K, f<K, V>> keyToKeyList;
    public transient int modCount;
    public transient int size;
    public transient g<K, V> tail;

    /* loaded from: classes6.dex */
    public class a extends AbstractSequentialList<V> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f30874e;

        public a(Object obj) {
            this.f30874e = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            return new i(this.f30874e, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f30874e);
            if (fVar == null) {
                return 0;
            }
            return fVar.f30886c;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i) {
            return new h(i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends Sets.a<K> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedListMultimap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new e(LinkedListMultimap.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return !LinkedListMultimap.this.removeAll(obj).isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedListMultimap.this.keyToKeyList.size();
        }
    }

    /* loaded from: classes6.dex */
    public class d extends AbstractSequentialList<V> {

        /* loaded from: classes6.dex */
        public class a extends b1<Map.Entry<K, V>, V> {

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h f30879f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f30879f = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a1
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // d.g.c.c.b1, java.util.ListIterator
            public void set(V v) {
                this.f30879f.f(v);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            h hVar = new h(i);
            return new a(this, hVar, hVar);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return LinkedListMultimap.this.size;
        }
    }

    /* loaded from: classes6.dex */
    public static class f<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public g<K, V> f30884a;

        /* renamed from: b  reason: collision with root package name */
        public g<K, V> f30885b;

        /* renamed from: c  reason: collision with root package name */
        public int f30886c;

        public f(g<K, V> gVar) {
            this.f30884a = gVar;
            this.f30885b = gVar;
            gVar.j = null;
            gVar.i = null;
            this.f30886c = 1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g<K, V> extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f30887e;

        /* renamed from: f  reason: collision with root package name */
        public V f30888f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30889g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30890h;
        public g<K, V> i;
        public g<K, V> j;

        public g(K k, V v) {
            this.f30887e = k;
            this.f30888f = v;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f30887e;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            return this.f30888f;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f30888f;
            this.f30888f = v;
            return v2;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public int f30891e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f30892f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30893g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30894h;
        public int i;

        public h(int i) {
            this.i = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            n.t(i, size);
            if (i >= size / 2) {
                this.f30894h = LinkedListMultimap.this.tail;
                this.f30891e = size;
                while (true) {
                    int i2 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i2;
                }
            } else {
                this.f30892f = LinkedListMultimap.this.head;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            }
            this.f30893g = null;
        }

        public void a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        public final void b() {
            if (LinkedListMultimap.this.modCount != this.i) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c */
        public g<K, V> next() {
            b();
            LinkedListMultimap.checkElement(this.f30892f);
            g<K, V> gVar = this.f30892f;
            this.f30893g = gVar;
            this.f30894h = gVar;
            this.f30892f = gVar.f30889g;
            this.f30891e++;
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: d */
        public g<K, V> previous() {
            b();
            LinkedListMultimap.checkElement(this.f30894h);
            g<K, V> gVar = this.f30894h;
            this.f30893g = gVar;
            this.f30892f = gVar;
            this.f30894h = gVar.f30890h;
            this.f30891e--;
            return gVar;
        }

        public void e(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void f(V v) {
            n.w(this.f30893g != null);
            this.f30893g.f30888f = v;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f30892f != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f30894h != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f30891e;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f30891e - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            m.e(this.f30893g != null);
            g<K, V> gVar = this.f30893g;
            if (gVar != this.f30892f) {
                this.f30894h = gVar.f30890h;
                this.f30891e--;
            } else {
                this.f30892f = gVar.f30889g;
            }
            LinkedListMultimap.this.removeNode(this.f30893g);
            this.f30893g = null;
            this.i = LinkedListMultimap.this.modCount;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Object obj) {
            e((Map.Entry) obj);
            throw null;
        }
    }

    public LinkedListMultimap() {
        this(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g<K, V> addNode(K k, V v, g<K, V> gVar) {
        g<K, V> gVar2 = new g<>(k, v);
        if (this.head == null) {
            this.tail = gVar2;
            this.head = gVar2;
            this.keyToKeyList.put(k, new f<>(gVar2));
            this.modCount++;
        } else if (gVar == null) {
            g<K, V> gVar3 = this.tail;
            gVar3.f30889g = gVar2;
            gVar2.f30890h = gVar3;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k);
            if (fVar == null) {
                this.keyToKeyList.put(k, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f30886c++;
                g<K, V> gVar4 = fVar.f30885b;
                gVar4.i = gVar2;
                gVar2.j = gVar4;
                fVar.f30885b = gVar2;
            }
        } else {
            this.keyToKeyList.get(k).f30886c++;
            gVar2.f30890h = gVar.f30890h;
            gVar2.j = gVar.j;
            gVar2.f30889g = gVar;
            gVar2.i = gVar;
            g<K, V> gVar5 = gVar.j;
            if (gVar5 == null) {
                this.keyToKeyList.get(k).f30884a = gVar2;
            } else {
                gVar5.i = gVar2;
            }
            g<K, V> gVar6 = gVar.f30890h;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f30889g = gVar2;
            }
            gVar.f30890h = gVar2;
            gVar.j = gVar2;
        }
        this.size++;
        return gVar2;
    }

    public static void checkElement(Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    private List<V> getCopy(Object obj) {
        return Collections.unmodifiableList(Lists.k(new i(obj)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.LinkedListMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllNodes(Object obj) {
        Iterators.d(new i(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeNode(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f30890h;
        if (gVar2 != null) {
            gVar2.f30889g = gVar.f30889g;
        } else {
            this.head = gVar.f30889g;
        }
        g<K, V> gVar3 = gVar.f30889g;
        if (gVar3 != null) {
            gVar3.f30890h = gVar.f30890h;
        } else {
            this.tail = gVar.f30890h;
        }
        if (gVar.j == null && gVar.i == null) {
            this.keyToKeyList.remove(gVar.f30887e).f30886c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f30887e);
            fVar.f30886c--;
            g<K, V> gVar4 = gVar.j;
            if (gVar4 == null) {
                fVar.f30884a = gVar.i;
            } else {
                gVar4.i = gVar.i;
            }
            g<K, V> gVar5 = gVar.i;
            if (gVar5 == null) {
                fVar.f30885b = gVar.j;
            } else {
                gVar5.j = gVar.j;
            }
        }
        this.size--;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // d.g.c.c.h0
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // d.g.c.c.h0
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // d.g.c.c.c
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // d.g.c.c.c
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // d.g.c.c.c
    public i0<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // d.g.c.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ i0 keys() {
        return super.keys();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public boolean put(K k, V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean putAll(h0 h0Var) {
        return super.putAll(h0Var);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // d.g.c.c.h0
    public int size() {
        return this.size;
    }

    @Override // d.g.c.c.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public LinkedListMultimap(int i2) {
        this.keyToKeyList = n0.c(i2);
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i2) {
        return new LinkedListMultimap<>(i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c
    public List<V> createValues() {
        return new d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // d.g.c.c.h0, d.g.c.c.g0
    public List<V> get(K k) {
        return new a(k);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.h0, d.g.c.c.g0
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        i iVar = new i(k);
        Iterator<? extends V> it = iterable.iterator();
        while (iVar.hasNext() && it.hasNext()) {
            iVar.next();
            iVar.set(it.next());
        }
        while (iVar.hasNext()) {
            iVar.next();
            iVar.remove();
        }
        while (it.hasNext()) {
            iVar.add(it.next());
        }
        return copy;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(h0<? extends K, ? extends V> h0Var) {
        return new LinkedListMultimap<>(h0Var);
    }

    /* loaded from: classes6.dex */
    public class e implements Iterator<K> {

        /* renamed from: e  reason: collision with root package name */
        public final Set<K> f30880e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f30881f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30882g;

        /* renamed from: h  reason: collision with root package name */
        public int f30883h;

        public e() {
            this.f30880e = Sets.d(LinkedListMultimap.this.keySet().size());
            this.f30881f = LinkedListMultimap.this.head;
            this.f30883h = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f30883h) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f30881f != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            LinkedListMultimap.checkElement(this.f30881f);
            g<K, V> gVar2 = this.f30881f;
            this.f30882g = gVar2;
            this.f30880e.add(gVar2.f30887e);
            do {
                gVar = this.f30881f.f30889g;
                this.f30881f = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f30880e.add(gVar.f30887e));
            return this.f30882g.f30887e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f30882g != null);
            LinkedListMultimap.this.removeAllNodes(this.f30882g.f30887e);
            this.f30882g = null;
            this.f30883h = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ListIterator<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Object f30895e;

        /* renamed from: f  reason: collision with root package name */
        public int f30896f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30897g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30898h;
        public g<K, V> i;

        public i(Object obj) {
            this.f30895e = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.f30897g = fVar == null ? null : fVar.f30884a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.i = LinkedListMultimap.this.addNode(this.f30895e, v, this.f30897g);
            this.f30896f++;
            this.f30898h = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f30897g != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.i != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.checkElement(this.f30897g);
            g<K, V> gVar = this.f30897g;
            this.f30898h = gVar;
            this.i = gVar;
            this.f30897g = gVar.i;
            this.f30896f++;
            return gVar.f30888f;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f30896f;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.checkElement(this.i);
            g<K, V> gVar = this.i;
            this.f30898h = gVar;
            this.f30897g = gVar;
            this.i = gVar.j;
            this.f30896f--;
            return gVar.f30888f;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f30896f - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            m.e(this.f30898h != null);
            g<K, V> gVar = this.f30898h;
            if (gVar != this.f30897g) {
                this.i = gVar.j;
                this.f30896f--;
            } else {
                this.f30897g = gVar.i;
            }
            LinkedListMultimap.this.removeNode(this.f30898h);
            this.f30898h = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            n.w(this.f30898h != null);
            this.f30898h.f30888f = v;
        }

        public i(Object obj, int i) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = fVar == null ? 0 : fVar.f30886c;
            n.t(i, i2);
            if (i >= i2 / 2) {
                this.i = fVar == null ? null : fVar.f30885b;
                this.f30896f = i2;
                while (true) {
                    int i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            } else {
                this.f30897g = fVar == null ? null : fVar.f30884a;
                while (true) {
                    int i4 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i4;
                }
            }
            this.f30895e = obj;
            this.f30898h = null;
        }
    }

    public LinkedListMultimap(h0<? extends K, ? extends V> h0Var) {
        this(h0Var.keySet().size());
        putAll(h0Var);
    }
}
