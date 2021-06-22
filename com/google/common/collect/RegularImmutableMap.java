package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.e0;
import d.g.c.c.m;
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
    public final transient Object f31413e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f31414f;

    /* loaded from: classes6.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final transient ImmutableMap<K, V> f31415e;

        /* renamed from: f  reason: collision with root package name */
        public final transient Object[] f31416f;

        /* renamed from: g  reason: collision with root package name */
        public final transient int f31417g;

        /* renamed from: h  reason: collision with root package name */
        public final transient int f31418h;

        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i2, int i3) {
            this.f31415e = immutableMap;
            this.f31416f = objArr;
            this.f31417g = i2;
            this.f31418h = i3;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                return value != null && value.equals(this.f31415e.get(key));
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i2) {
            return asList().copyIntoArray(objArr, i2);
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
                    return EntrySet.this.f31418h;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.List
                public Map.Entry<K, V> get(int i2) {
                    n.n(i2, EntrySet.this.f31418h);
                    int i3 = i2 * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.f31416f[EntrySet.this.f31417g + i3], EntrySet.this.f31416f[i3 + (EntrySet.this.f31417g ^ 1)]);
                }
            };
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31418h;
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
        public final transient ImmutableMap<K, ?> f31419e;

        /* renamed from: f  reason: collision with root package name */
        public final transient ImmutableList<K> f31420f;

        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f31419e = immutableMap;
            this.f31420f = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f31420f;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f31419e.get(obj) != null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i2) {
            return asList().copyIntoArray(objArr, i2);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31419e.size();
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
        public final transient Object[] f31421e;

        /* renamed from: f  reason: collision with root package name */
        public final transient int f31422f;

        /* renamed from: g  reason: collision with root package name */
        public final transient int f31423g;

        public KeysOrValuesAsList(Object[] objArr, int i2, int i3) {
            this.f31421e = objArr;
            this.f31422f = i2;
            this.f31423g = i3;
        }

        @Override // java.util.List
        public Object get(int i2) {
            n.n(i2, this.f31423g);
            return this.f31421e[(i2 * 2) + this.f31422f];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f31423g;
        }
    }

    public RegularImmutableMap(Object obj, Object[] objArr, int i2) {
        this.f31413e = obj;
        this.alternatingKeysAndValues = objArr;
        this.f31414f = i2;
    }

    public static IllegalArgumentException a(Object obj, Object obj2, Object[] objArr, int i2) {
        return new IllegalArgumentException("Multiple entries with same key: " + obj + "=" + obj2 + " and " + objArr[i2] + "=" + objArr[i2 ^ 1]);
    }

    public static <K, V> RegularImmutableMap<K, V> create(int i2, Object[] objArr) {
        if (i2 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i2 == 1) {
            m.a(objArr[0], objArr[1]);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        n.t(i2, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i2, ImmutableSet.chooseTableSize(i2), 0), objArr, i2);
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
    public static Object createHashTable(Object[] objArr, int i2, int i3, int i4) {
        if (i2 == 1) {
            m.a(objArr[i4], objArr[i4 ^ 1]);
            return null;
        }
        int i5 = i3 - 1;
        int i6 = 0;
        if (i3 <= 128) {
            byte[] bArr = new byte[i3];
            Arrays.fill(bArr, (byte) -1);
            while (i6 < i2) {
                int i7 = (i6 * 2) + i4;
                Object obj = objArr[i7];
                Object obj2 = objArr[i7 ^ 1];
                m.a(obj, obj2);
                int c2 = e0.c(obj.hashCode());
                while (true) {
                    int i8 = c2 & i5;
                    int i9 = bArr[i8] & 255;
                    if (i9 == 255) {
                        break;
                    } else if (objArr[i9].equals(obj)) {
                        throw a(obj, obj2, objArr, i9);
                    } else {
                        c2 = i8 + 1;
                    }
                }
            }
            return bArr;
        } else if (i3 <= 32768) {
            short[] sArr = new short[i3];
            Arrays.fill(sArr, (short) -1);
            while (i6 < i2) {
                int i10 = (i6 * 2) + i4;
                Object obj3 = objArr[i10];
                Object obj4 = objArr[i10 ^ 1];
                m.a(obj3, obj4);
                int c3 = e0.c(obj3.hashCode());
                while (true) {
                    int i11 = c3 & i5;
                    int i12 = sArr[i11] & UShort.MAX_VALUE;
                    if (i12 == 65535) {
                        break;
                    } else if (objArr[i12].equals(obj3)) {
                        throw a(obj3, obj4, objArr, i12);
                    } else {
                        c3 = i11 + 1;
                    }
                }
            }
            return sArr;
        } else {
            int[] iArr = new int[i3];
            Arrays.fill(iArr, -1);
            while (i6 < i2) {
                int i13 = (i6 * 2) + i4;
                Object obj5 = objArr[i13];
                Object obj6 = objArr[i13 ^ 1];
                m.a(obj5, obj6);
                int c4 = e0.c(obj5.hashCode());
                while (true) {
                    int i14 = c4 & i5;
                    int i15 = iArr[i14];
                    if (i15 == -1) {
                        break;
                    } else if (objArr[i15].equals(obj5)) {
                        throw a(obj5, obj6, objArr, i15);
                    } else {
                        c4 = i14 + 1;
                    }
                }
            }
            return iArr;
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f31414f);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f31414f));
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f31414f);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) get(this.f31413e, this.alternatingKeysAndValues, this.f31414f, 0, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f31414f;
    }

    public static Object get(Object obj, Object[] objArr, int i2, int i3, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i2 == 1) {
            if (objArr[i3].equals(obj2)) {
                return objArr[i3 ^ 1];
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
                    int i4 = c2 & length;
                    int i5 = bArr[i4] & 255;
                    if (i5 == 255) {
                        return null;
                    }
                    if (objArr[i5].equals(obj2)) {
                        return objArr[i5 ^ 1];
                    }
                    c2 = i4 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int c3 = e0.c(obj2.hashCode());
                while (true) {
                    int i6 = c3 & length2;
                    int i7 = sArr[i6] & UShort.MAX_VALUE;
                    if (i7 == 65535) {
                        return null;
                    }
                    if (objArr[i7].equals(obj2)) {
                        return objArr[i7 ^ 1];
                    }
                    c3 = i6 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int c4 = e0.c(obj2.hashCode());
                while (true) {
                    int i8 = c4 & length3;
                    int i9 = iArr[i8];
                    if (i9 == -1) {
                        return null;
                    }
                    if (objArr[i9].equals(obj2)) {
                        return objArr[i9 ^ 1];
                    }
                    c4 = i8 + 1;
                }
            }
        }
    }
}
