package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import d.h.c.a.n;
import d.h.c.c.b1;
import d.h.c.c.g0;
import d.h.c.c.h0;
import d.h.c.c.i0;
import d.h.c.c.m;
import d.h.c.c.n0;
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
public class LinkedListMultimap<K, V> extends d.h.c.c.c<K, V> implements g0<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public transient g<K, V> head;
    public transient Map<K, f<K, V>> keyToKeyList;
    public transient int modCount;
    public transient int size;
    public transient g<K, V> tail;

    /* loaded from: classes6.dex */
    public class a extends AbstractSequentialList<V> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object f30969e;

        public a(Object obj) {
            this.f30969e = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i) {
            return new i(this.f30969e, i);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f30969e);
            if (fVar == null) {
                return 0;
            }
            return fVar.f30981c;
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
            public final /* synthetic */ h f30974f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f30974f = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.h.c.c.a1
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // d.h.c.c.b1, java.util.ListIterator
            public void set(V v) {
                this.f30974f.f(v);
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
        public g<K, V> f30979a;

        /* renamed from: b  reason: collision with root package name */
        public g<K, V> f30980b;

        /* renamed from: c  reason: collision with root package name */
        public int f30981c;

        public f(g<K, V> gVar) {
            this.f30979a = gVar;
            this.f30980b = gVar;
            gVar.j = null;
            gVar.i = null;
            this.f30981c = 1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g<K, V> extends d.h.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f30982e;

        /* renamed from: f  reason: collision with root package name */
        public V f30983f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30984g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30985h;
        public g<K, V> i;
        public g<K, V> j;

        public g(K k, V v) {
            this.f30982e = k;
            this.f30983f = v;
        }

        @Override // d.h.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f30982e;
        }

        @Override // d.h.c.c.b, java.util.Map.Entry
        public V getValue() {
            return this.f30983f;
        }

        @Override // d.h.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f30983f;
            this.f30983f = v;
            return v2;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public int f30986e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f30987f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30988g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30989h;
        public int i;

        public h(int i) {
            this.i = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            n.t(i, size);
            if (i >= size / 2) {
                this.f30989h = LinkedListMultimap.this.tail;
                this.f30986e = size;
                while (true) {
                    int i2 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i2;
                }
            } else {
                this.f30987f = LinkedListMultimap.this.head;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            }
            this.f30988g = null;
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
            LinkedListMultimap.checkElement(this.f30987f);
            g<K, V> gVar = this.f30987f;
            this.f30988g = gVar;
            this.f30989h = gVar;
            this.f30987f = gVar.f30984g;
            this.f30986e++;
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: d */
        public g<K, V> previous() {
            b();
            LinkedListMultimap.checkElement(this.f30989h);
            g<K, V> gVar = this.f30989h;
            this.f30988g = gVar;
            this.f30987f = gVar;
            this.f30989h = gVar.f30985h;
            this.f30986e--;
            return gVar;
        }

        public void e(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void f(V v) {
            n.w(this.f30988g != null);
            this.f30988g.f30983f = v;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f30987f != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f30989h != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f30986e;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f30986e - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            m.e(this.f30988g != null);
            g<K, V> gVar = this.f30988g;
            if (gVar != this.f30987f) {
                this.f30989h = gVar.f30985h;
                this.f30986e--;
            } else {
                this.f30987f = gVar.f30984g;
            }
            LinkedListMultimap.this.removeNode(this.f30988g);
            this.f30988g = null;
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
            gVar3.f30984g = gVar2;
            gVar2.f30985h = gVar3;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k);
            if (fVar == null) {
                this.keyToKeyList.put(k, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f30981c++;
                g<K, V> gVar4 = fVar.f30980b;
                gVar4.i = gVar2;
                gVar2.j = gVar4;
                fVar.f30980b = gVar2;
            }
        } else {
            this.keyToKeyList.get(k).f30981c++;
            gVar2.f30985h = gVar.f30985h;
            gVar2.j = gVar.j;
            gVar2.f30984g = gVar;
            gVar2.i = gVar;
            g<K, V> gVar5 = gVar.j;
            if (gVar5 == null) {
                this.keyToKeyList.get(k).f30979a = gVar2;
            } else {
                gVar5.i = gVar2;
            }
            g<K, V> gVar6 = gVar.f30985h;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f30984g = gVar2;
            }
            gVar.f30985h = gVar2;
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
        g<K, V> gVar2 = gVar.f30985h;
        if (gVar2 != null) {
            gVar2.f30984g = gVar.f30984g;
        } else {
            this.head = gVar.f30984g;
        }
        g<K, V> gVar3 = gVar.f30984g;
        if (gVar3 != null) {
            gVar3.f30985h = gVar.f30985h;
        } else {
            this.tail = gVar.f30985h;
        }
        if (gVar.j == null && gVar.i == null) {
            this.keyToKeyList.remove(gVar.f30982e).f30981c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f30982e);
            fVar.f30981c--;
            g<K, V> gVar4 = gVar.j;
            if (gVar4 == null) {
                fVar.f30979a = gVar.i;
            } else {
                gVar4.i = gVar.i;
            }
            g<K, V> gVar5 = gVar.i;
            if (gVar5 == null) {
                fVar.f30980b = gVar.j;
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

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // d.h.c.c.h0
    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // d.h.c.c.h0
    public boolean containsKey(Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // d.h.c.c.c
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.a(this);
    }

    @Override // d.h.c.c.c
    public Set<K> createKeySet() {
        return new c();
    }

    @Override // d.h.c.c.c
    public i0<K> createKeys() {
        return new Multimaps.c(this);
    }

    @Override // d.h.c.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.h0, d.h.c.c.g0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((LinkedListMultimap<K, V>) obj);
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ i0 keys() {
        return super.keys();
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public boolean put(K k, V v) {
        addNode(k, v, null);
        return true;
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ boolean putAll(h0 h0Var) {
        return super.putAll(h0Var);
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.c, d.h.c.c.h0, d.h.c.c.g0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedListMultimap<K, V>) obj, iterable);
    }

    @Override // d.h.c.c.h0
    public int size() {
        return this.size;
    }

    @Override // d.h.c.c.c
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
    @Override // d.h.c.c.c
    public List<Map.Entry<K, V>> createEntries() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.c
    public List<V> createValues() {
        return new d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.c, d.h.c.c.h0
    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    @Override // d.h.c.c.h0, d.h.c.c.g0
    public List<V> get(K k) {
        return new a(k);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.h.c.c.c, d.h.c.c.h0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.h0, d.h.c.c.g0
    public List<V> removeAll(Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    @Override // d.h.c.c.c, d.h.c.c.h0, d.h.c.c.g0
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
    @Override // d.h.c.c.c, d.h.c.c.h0
    public List<V> values() {
        return (List) super.values();
    }

    public static <K, V> LinkedListMultimap<K, V> create(h0<? extends K, ? extends V> h0Var) {
        return new LinkedListMultimap<>(h0Var);
    }

    /* loaded from: classes6.dex */
    public class e implements Iterator<K> {

        /* renamed from: e  reason: collision with root package name */
        public final Set<K> f30975e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f30976f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30977g;

        /* renamed from: h  reason: collision with root package name */
        public int f30978h;

        public e() {
            this.f30975e = Sets.d(LinkedListMultimap.this.keySet().size());
            this.f30976f = LinkedListMultimap.this.head;
            this.f30978h = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f30978h) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f30976f != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            LinkedListMultimap.checkElement(this.f30976f);
            g<K, V> gVar2 = this.f30976f;
            this.f30977g = gVar2;
            this.f30975e.add(gVar2.f30982e);
            do {
                gVar = this.f30976f.f30984g;
                this.f30976f = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f30975e.add(gVar.f30982e));
            return this.f30977g.f30982e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f30977g != null);
            LinkedListMultimap.this.removeAllNodes(this.f30977g.f30982e);
            this.f30977g = null;
            this.f30978h = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ListIterator<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Object f30990e;

        /* renamed from: f  reason: collision with root package name */
        public int f30991f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f30992g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f30993h;
        public g<K, V> i;

        public i(Object obj) {
            this.f30990e = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.f30992g = fVar == null ? null : fVar.f30979a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.i = LinkedListMultimap.this.addNode(this.f30990e, v, this.f30992g);
            this.f30991f++;
            this.f30993h = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f30992g != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.i != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.checkElement(this.f30992g);
            g<K, V> gVar = this.f30992g;
            this.f30993h = gVar;
            this.i = gVar;
            this.f30992g = gVar.i;
            this.f30991f++;
            return gVar.f30983f;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f30991f;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.checkElement(this.i);
            g<K, V> gVar = this.i;
            this.f30993h = gVar;
            this.f30992g = gVar;
            this.i = gVar.j;
            this.f30991f--;
            return gVar.f30983f;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f30991f - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            m.e(this.f30993h != null);
            g<K, V> gVar = this.f30993h;
            if (gVar != this.f30992g) {
                this.i = gVar.j;
                this.f30991f--;
            } else {
                this.f30992g = gVar.i;
            }
            LinkedListMultimap.this.removeNode(this.f30993h);
            this.f30993h = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            n.w(this.f30993h != null);
            this.f30993h.f30983f = v;
        }

        public i(Object obj, int i) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i2 = fVar == null ? 0 : fVar.f30981c;
            n.t(i, i2);
            if (i >= i2 / 2) {
                this.i = fVar == null ? null : fVar.f30980b;
                this.f30991f = i2;
                while (true) {
                    int i3 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            } else {
                this.f30992g = fVar == null ? null : fVar.f30979a;
                while (true) {
                    int i4 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i4;
                }
            }
            this.f30990e = obj;
            this.f30993h = null;
        }
    }

    public LinkedListMultimap(h0<? extends K, ? extends V> h0Var) {
        this(h0Var.keySet().size());
        putAll(h0Var);
    }
}
