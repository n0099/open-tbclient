package com.google.common.collect;

import d.h.c.a.n;
import d.h.c.c.c1;
import d.h.c.c.e0;
import d.h.c.c.m;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import kotlin.UShort;
/* loaded from: classes6.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    public static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    public static final long serialVersionUID = 0;
    public final transient Object[] alternatingKeysAndValues;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object f31081e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f31082f;

    /* loaded from: classes6.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final transient ImmutableMap<K, V> f31083e;

        /* renamed from: f  reason: collision with root package name */
        public final transient Object[] f31084f;

        /* renamed from: g  reason: collision with root package name */
        public final transient int f31085g;

        /* renamed from: h  reason: collision with root package name */
        public final transient int f31086h;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.f31083e = immutableMap;
            this.f31084f = objArr;
            this.f31085g = i;
            this.f31086h = i2;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                return value != null && value.equals(this.f31083e.get(key));
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f31086h;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.List
                public Map.Entry<K, V> get(int i) {
                    n.n(i, EntrySet.this.f31086h);
                    int i2 = i * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.f31084f[EntrySet.this.f31085g + i2], EntrySet.this.f31084f[i2 + (EntrySet.this.f31085g ^ 1)]);
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31086h;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public c1<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes6.dex */
    public static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: e  reason: collision with root package name */
        public final transient ImmutableMap<K, ?> f31087e;

        /* renamed from: f  reason: collision with root package name */
        public final transient ImmutableList<K> f31088f;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f31087e = immutableMap;
            this.f31088f = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f31088f;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f31087e.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31087e.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public c1<K> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes6.dex */
    public static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: e  reason: collision with root package name */
        public final transient Object[] f31089e;

        /* renamed from: f  reason: collision with root package name */
        public final transient int f31090f;

        /* renamed from: g  reason: collision with root package name */
        public final transient int f31091g;

        public KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.f31089e = objArr;
            this.f31090f = i;
            this.f31091g = i2;
        }

        @Override // java.util.List
        public Object get(int i) {
            n.n(i, this.f31091g);
            return this.f31089e[(i * 2) + this.f31090f];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f31091g;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i) {
        this.f31081e = obj;
        this.alternatingKeysAndValues = objArr;
        this.f31082f = i;
    }

    public static IllegalArgumentException a(Object obj, Object obj2, Object[] objArr, int i) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i] + "=" + objArr[i ^ 1]);
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            m.a(objArr[0], objArr[1]);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        n.t(i, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object createHashTable(Object[] objArr, int i, int i2, int i3) {
        if (i == 1) {
            m.a(objArr[i3], objArr[i3 ^ 1]);
            return null;
        }
        int i4 = i2 - 1;
        int i5 = 0;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            while (i5 < i) {
                int i6 = (i5 * 2) + i3;
                Object obj = objArr[i6];
                Object obj2 = objArr[i6 ^ 1];
                m.a(obj, obj2);
                int c2 = e0.c(obj.hashCode());
                while (true) {
                    int i7 = c2 & i4;
                    int i8 = bArr[i7] & 255;
                    if (i8 == 255) {
                        break;
                    } else if (objArr[i8].equals(obj)) {
                        throw a(obj, obj2, objArr, i8);
                    } else {
                        c2 = i7 + 1;
                    }
                }
            }
            return bArr;
        } else if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            while (i5 < i) {
                int i9 = (i5 * 2) + i3;
                Object obj3 = objArr[i9];
                Object obj4 = objArr[i9 ^ 1];
                m.a(obj3, obj4);
                int c3 = e0.c(obj3.hashCode());
                while (true) {
                    int i10 = c3 & i4;
                    int i11 = sArr[i10] & UShort.MAX_VALUE;
                    if (i11 == 65535) {
                        break;
                    } else if (objArr[i11].equals(obj3)) {
                        throw a(obj3, obj4, objArr, i11);
                    } else {
                        c3 = i10 + 1;
                    }
                }
            }
            return sArr;
        } else {
            int[] iArr = new int[i2];
            Arrays.fill(iArr, -1);
            while (i5 < i) {
                int i12 = (i5 * 2) + i3;
                Object obj5 = objArr[i12];
                Object obj6 = objArr[i12 ^ 1];
                m.a(obj5, obj6);
                int c4 = e0.c(obj5.hashCode());
                while (true) {
                    int i13 = c4 & i4;
                    int i14 = iArr[i13];
                    if (i14 == -1) {
                        break;
                    } else if (objArr[i14].equals(obj5)) {
                        throw a(obj5, obj6, objArr, i14);
                    } else {
                        c4 = i13 + 1;
                    }
                }
            }
            return iArr;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f31082f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f31082f));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f31082f);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) get(this.f31081e, this.alternatingKeysAndValues, this.f31082f, 0, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f31082f;
    }

    public static Object get(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            if (objArr[i2].equals(obj2)) {
                return objArr[i2 ^ 1];
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int c2 = e0.c(obj2.hashCode());
                while (true) {
                    int i3 = c2 & length;
                    int i4 = bArr[i3] & 255;
                    if (i4 == 255) {
                        return null;
                    }
                    if (objArr[i4].equals(obj2)) {
                        return objArr[i4 ^ 1];
                    }
                    c2 = i3 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int c3 = e0.c(obj2.hashCode());
                while (true) {
                    int i5 = c3 & length2;
                    int i6 = sArr[i5] & UShort.MAX_VALUE;
                    if (i6 == 65535) {
                        return null;
                    }
                    if (objArr[i6].equals(obj2)) {
                        return objArr[i6 ^ 1];
                    }
                    c3 = i5 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int c4 = e0.c(obj2.hashCode());
                while (true) {
                    int i7 = c4 & length3;
                    int i8 = iArr[i7];
                    if (i8 == -1) {
                        return null;
                    }
                    if (objArr[i8].equals(obj2)) {
                        return objArr[i8 ^ 1];
                    }
                    c4 = i7 + 1;
                }
            }
        }
    }
}
