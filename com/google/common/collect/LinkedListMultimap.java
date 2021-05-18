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
        public final /* synthetic */ Object f31177e;

        public a(Object obj) {
            this.f31177e = obj;
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i2) {
            return new i(this.f31177e, i2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(this.f31177e);
            if (fVar == null) {
                return 0;
            }
            return fVar.f31190c;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends AbstractSequentialList<Map.Entry<K, V>> {
        public b() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<Map.Entry<K, V>> listIterator(int i2) {
            return new h(i2);
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
            public final /* synthetic */ h f31182f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, ListIterator listIterator, h hVar) {
                super(listIterator);
                this.f31182f = hVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.g.c.c.a1
            /* renamed from: c */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }

            @Override // d.g.c.c.b1, java.util.ListIterator
            public void set(V v) {
                this.f31182f.f(v);
            }
        }

        public d() {
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<V> listIterator(int i2) {
            h hVar = new h(i2);
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
        public g<K, V> f31188a;

        /* renamed from: b  reason: collision with root package name */
        public g<K, V> f31189b;

        /* renamed from: c  reason: collision with root package name */
        public int f31190c;

        public f(g<K, V> gVar) {
            this.f31188a = gVar;
            this.f31189b = gVar;
            gVar.j = null;
            gVar.f31195i = null;
            this.f31190c = 1;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g<K, V> extends d.g.c.c.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f31191e;

        /* renamed from: f  reason: collision with root package name */
        public V f31192f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f31193g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f31194h;

        /* renamed from: i  reason: collision with root package name */
        public g<K, V> f31195i;
        public g<K, V> j;

        public g(K k, V v) {
            this.f31191e = k;
            this.f31192f = v;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public K getKey() {
            return this.f31191e;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V getValue() {
            return this.f31192f;
        }

        @Override // d.g.c.c.b, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f31192f;
            this.f31192f = v;
            return v2;
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ListIterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public int f31196e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f31197f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f31198g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f31199h;

        /* renamed from: i  reason: collision with root package name */
        public int f31200i;

        public h(int i2) {
            this.f31200i = LinkedListMultimap.this.modCount;
            int size = LinkedListMultimap.this.size();
            n.t(i2, size);
            if (i2 >= size / 2) {
                this.f31199h = LinkedListMultimap.this.tail;
                this.f31196e = size;
                while (true) {
                    int i3 = i2 + 1;
                    if (i2 >= size) {
                        break;
                    }
                    previous();
                    i2 = i3;
                }
            } else {
                this.f31197f = LinkedListMultimap.this.head;
                while (true) {
                    int i4 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i4;
                }
            }
            this.f31198g = null;
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
            if (LinkedListMultimap.this.modCount != this.f31200i) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: c */
        public g<K, V> next() {
            b();
            LinkedListMultimap.checkElement(this.f31197f);
            g<K, V> gVar = this.f31197f;
            this.f31198g = gVar;
            this.f31199h = gVar;
            this.f31197f = gVar.f31193g;
            this.f31196e++;
            return gVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.ListIterator
        /* renamed from: d */
        public g<K, V> previous() {
            b();
            LinkedListMultimap.checkElement(this.f31199h);
            g<K, V> gVar = this.f31199h;
            this.f31198g = gVar;
            this.f31197f = gVar;
            this.f31199h = gVar.f31194h;
            this.f31196e--;
            return gVar;
        }

        public void e(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void f(V v) {
            n.w(this.f31198g != null);
            this.f31198g.f31192f = v;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f31197f != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            b();
            return this.f31199h != null;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f31196e;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f31196e - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            b();
            m.e(this.f31198g != null);
            g<K, V> gVar = this.f31198g;
            if (gVar != this.f31197f) {
                this.f31199h = gVar.f31194h;
                this.f31196e--;
            } else {
                this.f31197f = gVar.f31193g;
            }
            LinkedListMultimap.this.removeNode(this.f31198g);
            this.f31198g = null;
            this.f31200i = LinkedListMultimap.this.modCount;
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
            gVar3.f31193g = gVar2;
            gVar2.f31194h = gVar3;
            this.tail = gVar2;
            f<K, V> fVar = this.keyToKeyList.get(k);
            if (fVar == null) {
                this.keyToKeyList.put(k, new f<>(gVar2));
                this.modCount++;
            } else {
                fVar.f31190c++;
                g<K, V> gVar4 = fVar.f31189b;
                gVar4.f31195i = gVar2;
                gVar2.j = gVar4;
                fVar.f31189b = gVar2;
            }
        } else {
            this.keyToKeyList.get(k).f31190c++;
            gVar2.f31194h = gVar.f31194h;
            gVar2.j = gVar.j;
            gVar2.f31193g = gVar;
            gVar2.f31195i = gVar;
            g<K, V> gVar5 = gVar.j;
            if (gVar5 == null) {
                this.keyToKeyList.get(k).f31188a = gVar2;
            } else {
                gVar5.f31195i = gVar2;
            }
            g<K, V> gVar6 = gVar.f31194h;
            if (gVar6 == null) {
                this.head = gVar2;
            } else {
                gVar6.f31193g = gVar2;
            }
            gVar.f31194h = gVar2;
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
        g<K, V> gVar2 = gVar.f31194h;
        if (gVar2 != null) {
            gVar2.f31193g = gVar.f31193g;
        } else {
            this.head = gVar.f31193g;
        }
        g<K, V> gVar3 = gVar.f31193g;
        if (gVar3 != null) {
            gVar3.f31194h = gVar.f31194h;
        } else {
            this.tail = gVar.f31194h;
        }
        if (gVar.j == null && gVar.f31195i == null) {
            this.keyToKeyList.remove(gVar.f31191e).f31190c = 0;
            this.modCount++;
        } else {
            f<K, V> fVar = this.keyToKeyList.get(gVar.f31191e);
            fVar.f31190c--;
            g<K, V> gVar4 = gVar.j;
            if (gVar4 == null) {
                fVar.f31188a = gVar.f31195i;
            } else {
                gVar4.f31195i = gVar.f31195i;
            }
            g<K, V> gVar5 = gVar.f31195i;
            if (gVar5 == null) {
                fVar.f31189b = gVar.j;
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
        public final Set<K> f31183e;

        /* renamed from: f  reason: collision with root package name */
        public g<K, V> f31184f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f31185g;

        /* renamed from: h  reason: collision with root package name */
        public int f31186h;

        public e() {
            this.f31183e = Sets.d(LinkedListMultimap.this.keySet().size());
            this.f31184f = LinkedListMultimap.this.head;
            this.f31186h = LinkedListMultimap.this.modCount;
        }

        public final void a() {
            if (LinkedListMultimap.this.modCount != this.f31186h) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f31184f != null;
        }

        @Override // java.util.Iterator
        public K next() {
            g<K, V> gVar;
            a();
            LinkedListMultimap.checkElement(this.f31184f);
            g<K, V> gVar2 = this.f31184f;
            this.f31185g = gVar2;
            this.f31183e.add(gVar2.f31191e);
            do {
                gVar = this.f31184f.f31193g;
                this.f31184f = gVar;
                if (gVar == null) {
                    break;
                }
            } while (!this.f31183e.add(gVar.f31191e));
            return this.f31185g.f31191e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            m.e(this.f31185g != null);
            LinkedListMultimap.this.removeAllNodes(this.f31185g.f31191e);
            this.f31185g = null;
            this.f31186h = LinkedListMultimap.this.modCount;
        }

        public /* synthetic */ e(LinkedListMultimap linkedListMultimap, a aVar) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ListIterator<V> {

        /* renamed from: e  reason: collision with root package name */
        public final Object f31201e;

        /* renamed from: f  reason: collision with root package name */
        public int f31202f;

        /* renamed from: g  reason: collision with root package name */
        public g<K, V> f31203g;

        /* renamed from: h  reason: collision with root package name */
        public g<K, V> f31204h;

        /* renamed from: i  reason: collision with root package name */
        public g<K, V> f31205i;

        public i(Object obj) {
            this.f31201e = obj;
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            this.f31203g = fVar == null ? null : fVar.f31188a;
        }

        @Override // java.util.ListIterator
        public void add(V v) {
            this.f31205i = LinkedListMultimap.this.addNode(this.f31201e, v, this.f31203g);
            this.f31202f++;
            this.f31204h = null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f31203g != null;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f31205i != null;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public V next() {
            LinkedListMultimap.checkElement(this.f31203g);
            g<K, V> gVar = this.f31203g;
            this.f31204h = gVar;
            this.f31205i = gVar;
            this.f31203g = gVar.f31195i;
            this.f31202f++;
            return gVar.f31192f;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f31202f;
        }

        @Override // java.util.ListIterator
        public V previous() {
            LinkedListMultimap.checkElement(this.f31205i);
            g<K, V> gVar = this.f31205i;
            this.f31204h = gVar;
            this.f31203g = gVar;
            this.f31205i = gVar.j;
            this.f31202f--;
            return gVar.f31192f;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f31202f - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            m.e(this.f31204h != null);
            g<K, V> gVar = this.f31204h;
            if (gVar != this.f31203g) {
                this.f31205i = gVar.j;
                this.f31202f--;
            } else {
                this.f31203g = gVar.f31195i;
            }
            LinkedListMultimap.this.removeNode(this.f31204h);
            this.f31204h = null;
        }

        @Override // java.util.ListIterator
        public void set(V v) {
            n.w(this.f31204h != null);
            this.f31204h.f31192f = v;
        }

        public i(Object obj, int i2) {
            f fVar = (f) LinkedListMultimap.this.keyToKeyList.get(obj);
            int i3 = fVar == null ? 0 : fVar.f31190c;
            n.t(i2, i3);
            if (i2 >= i3 / 2) {
                this.f31205i = fVar == null ? null : fVar.f31189b;
                this.f31202f = i3;
                while (true) {
                    int i4 = i2 + 1;
                    if (i2 >= i3) {
                        break;
                    }
                    previous();
                    i2 = i4;
                }
            } else {
                this.f31203g = fVar == null ? null : fVar.f31188a;
                while (true) {
                    int i5 = i2 - 1;
                    if (i2 <= 0) {
                        break;
                    }
                    next();
                    i2 = i5;
                }
            }
            this.f31201e = obj;
            this.f31204h = null;
        }
    }

    public LinkedListMultimap(h0<? extends K, ? extends V> h0Var) {
        this(h0Var.keySet().size());
        putAll(h0Var);
    }
}
