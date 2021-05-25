package com.google.common.collect;

import com.google.common.collect.Sets;
import d.g.c.a.k;
import d.g.c.c.e0;
import d.g.c.c.h0;
import d.g.c.c.i0;
import d.g.c.c.m;
import d.g.c.c.n0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes6.dex */
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    public static final int DEFAULT_KEY_CAPACITY = 16;
    public static final int DEFAULT_VALUE_SET_CAPACITY = 2;
    public static final double VALUE_SET_LOAD_FACTOR = 1.0d;
    public static final long serialVersionUID = 1;
    public transient ValueEntry<K, V> multimapHeaderEntry;
    public transient int valueSetCapacity;

    /* loaded from: classes6.dex */
    public static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements c<K, V> {
        public ValueEntry<K, V> nextInValueBucket;
        public ValueEntry<K, V> predecessorInMultimap;
        public c<K, V> predecessorInValueSet;
        public final int smearedValueHash;
        public ValueEntry<K, V> successorInMultimap;
        public c<K, V> successorInValueSet;

        public ValueEntry(K k, V v, int i2, ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = i2;
            this.nextInValueBucket = valueEntry;
        }

        public ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        public boolean matchesValue(Object obj, int i2) {
            return this.smearedValueHash == i2 && k.a(getValue(), obj);
        }

        public void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.predecessorInValueSet = cVar;
        }

        public void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.successorInValueSet = cVar;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public ValueEntry<K, V> f31094e;

        /* renamed from: f  reason: collision with root package name */
        public ValueEntry<K, V> f31095f;

        public a() {
            this.f31094e = LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                ValueEntry<K, V> valueEntry = this.f31094e;
                this.f31095f = valueEntry;
                this.f31094e = valueEntry.successorInMultimap;
                return valueEntry;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31094e != LinkedHashMultimap.this.multimapHeaderEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            m.e(this.f31095f != null);
            LinkedHashMultimap.this.remove(this.f31095f.getKey(), this.f31095f.getValue());
            this.f31095f = null;
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends Sets.a<V> implements c<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public final K f31097e;

        /* renamed from: f  reason: collision with root package name */
        public ValueEntry<K, V>[] f31098f;

        /* renamed from: g  reason: collision with root package name */
        public int f31099g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f31100h = 0;

        /* renamed from: i  reason: collision with root package name */
        public c<K, V> f31101i = this;
        public c<K, V> j = this;

        /* loaded from: classes6.dex */
        public class a implements Iterator<V> {

            /* renamed from: e  reason: collision with root package name */
            public c<K, V> f31102e;

            /* renamed from: f  reason: collision with root package name */
            public ValueEntry<K, V> f31103f;

            /* renamed from: g  reason: collision with root package name */
            public int f31104g;

            public a() {
                this.f31102e = b.this.f31101i;
                this.f31104g = b.this.f31100h;
            }

            public final void a() {
                if (b.this.f31100h != this.f31104g) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f31102e != b.this;
            }

            @Override // java.util.Iterator
            public V next() {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) this.f31102e;
                    V value = valueEntry.getValue();
                    this.f31103f = valueEntry;
                    this.f31102e = valueEntry.getSuccessorInValueSet();
                    return value;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                a();
                m.e(this.f31103f != null);
                b.this.remove(this.f31103f.getValue());
                this.f31104g = b.this.f31100h;
                this.f31103f = null;
            }
        }

        public b(K k, int i2) {
            this.f31097e = k;
            this.f31098f = new ValueEntry[e0.a(i2, 1.0d)];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(V v) {
            int d2 = e0.d(v);
            int c2 = c() & d2;
            ValueEntry<K, V> valueEntry = this.f31098f[c2];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v, d2)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.f31097e, v, d2, valueEntry);
            LinkedHashMultimap.succeedsInValueSet(this.j, valueEntry3);
            LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
            LinkedHashMultimap.succeedsInMultimap(valueEntry3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.f31098f[c2] = valueEntry3;
            this.f31099g++;
            this.f31100h++;
            d();
            return true;
        }

        public final int c() {
            return this.f31098f.length - 1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f31098f, (Object) null);
            this.f31099g = 0;
            for (c<K, V> cVar = this.f31101i; cVar != this; cVar = cVar.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) cVar);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.f31100h++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int d2 = e0.d(obj);
            for (ValueEntry<K, V> valueEntry = this.f31098f[c() & d2]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, d2)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.google.common.collect.LinkedHashMultimap$c<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void d() {
            if (e0.b(this.f31099g, this.f31098f.length, 1.0d)) {
                int length = this.f31098f.length * 2;
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[length];
                this.f31098f = valueEntryArr;
                int i2 = length - 1;
                for (c cVar = (c<K, V>) this.f31101i; cVar != this; cVar = (c<K, V>) cVar.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) cVar;
                    int i3 = valueEntry.smearedValueHash & i2;
                    valueEntry.nextInValueBucket = valueEntryArr[i3];
                    valueEntryArr[i3] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getPredecessorInValueSet() {
            return this.j;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public c<K, V> getSuccessorInValueSet() {
            return this.f31101i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int d2 = e0.d(obj);
            int c2 = c() & d2;
            ValueEntry<K, V> valueEntry = null;
            for (ValueEntry<K, V> valueEntry2 = this.f31098f[c2]; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(obj, d2)) {
                    if (valueEntry == null) {
                        this.f31098f[c2] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.f31099g--;
                    this.f31100h++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setPredecessorInValueSet(c<K, V> cVar) {
            this.j = cVar;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.c
        public void setSuccessorInValueSet(c<K, V> cVar) {
            this.f31101i = cVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31099g;
        }
    }

    /* loaded from: classes6.dex */
    public interface c<K, V> {
        c<K, V> getPredecessorInValueSet();

        c<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(c<K, V> cVar);

        void setSuccessorInValueSet(c<K, V> cVar);
    }

    public LinkedHashMultimap(int i2, int i3) {
        super(n0.e(i2));
        this.valueSetCapacity = 2;
        m.b(i3, "expectedValuesPerKey");
        this.valueSetCapacity = i3;
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    public static <K, V> void deleteFromValueSet(c<K, V> cVar) {
        succeedsInValueSet(cVar.getPredecessorInValueSet(), cVar.getSuccessorInValueSet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.Map */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.google.common.collect.LinkedHashMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        ValueEntry<K, V> valueEntry = new ValueEntry<>(null, null, 0, null);
        this.multimapHeaderEntry = valueEntry;
        succeedsInMultimap(valueEntry, valueEntry);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        Map e2 = n0.e(12);
        for (int i2 = 0; i2 < readInt; i2++) {
            Object readObject = objectInputStream.readObject();
            e2.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i3 = 0; i3 < readInt2; i3++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) e2.get(readObject2)).add(objectInputStream.readObject());
        }
        setMap(e2);
    }

    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    public static <K, V> void succeedsInValueSet(c<K, V> cVar, c<K, V> cVar2) {
        cVar.setSuccessorInValueSet(cVar2);
        cVar2.setPredecessorInValueSet(cVar);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        for (K k : keySet()) {
            objectOutputStream.writeObject(k);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // com.google.common.collect.AbstractSetMultimap, d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.h0
    public void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
    public Iterator<Map.Entry<K, V>> entryIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get((LinkedHashMultimap<K, V>) obj);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ i0 keys() {
        return super.keys();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean putAll(h0 h0Var) {
        return super.putAll(h0Var);
    }

    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((LinkedHashMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.h0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // d.g.c.c.c
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c
    public Iterator<V> valueIterator() {
        return Maps.L(entryIterator());
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c, d.g.c.c.h0
    public Collection<V> values() {
        return super.values();
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i2, int i3) {
        return new LinkedHashMultimap<>(Maps.e(i2), Maps.e(i3));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createCollection() {
        return n0.f(this.valueSetCapacity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c, d.g.c.c.h0
    public Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.g.c.c.c, d.g.c.c.h0
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return super.replaceValues((LinkedHashMultimap<K, V>) k, (Iterable) iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> createCollection(K k) {
        return new b(k, this.valueSetCapacity);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(h0<? extends K, ? extends V> h0Var) {
        LinkedHashMultimap<K, V> create = create(h0Var.keySet().size(), 2);
        create.putAll(h0Var);
        return create;
    }
}
