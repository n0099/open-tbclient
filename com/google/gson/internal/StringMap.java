package com.google.gson.internal;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
/* loaded from: classes.dex */
public final class StringMap extends AbstractMap {
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MINIMUM_CAPACITY = 4;
    private Set entrySet;
    private Set keySet;
    private int size;
    private Collection values;
    private static final Map.Entry[] EMPTY_TABLE = new LinkedEntry[2];
    private static final int seed = new Random().nextInt();
    private LinkedEntry[] table = (LinkedEntry[]) EMPTY_TABLE;
    private int threshold = -1;
    private LinkedEntry header = new LinkedEntry();

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return (obj instanceof String) && getEntry((String) obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        LinkedEntry entry;
        if (!(obj instanceof String) || (entry = getEntry((String) obj)) == null) {
            return null;
        }
        return entry.value;
    }

    private LinkedEntry getEntry(String str) {
        if (str == null) {
            return null;
        }
        int hash = hash(str);
        LinkedEntry[] linkedEntryArr = this.table;
        for (LinkedEntry linkedEntry = linkedEntryArr[(linkedEntryArr.length - 1) & hash]; linkedEntry != null; linkedEntry = linkedEntry.next) {
            String str2 = linkedEntry.key;
            if (str2 == str || (linkedEntry.hash == hash && str.equals(str2))) {
                return linkedEntry;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.AbstractMap, java.util.Map
    public Object put(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        int hash = hash(str);
        LinkedEntry[] linkedEntryArr = this.table;
        int length = (linkedEntryArr.length - 1) & hash;
        for (LinkedEntry linkedEntry = linkedEntryArr[length]; linkedEntry != null; linkedEntry = linkedEntry.next) {
            if (linkedEntry.hash == hash && str.equals(linkedEntry.key)) {
                Object obj2 = linkedEntry.value;
                linkedEntry.value = obj;
                return obj2;
            }
        }
        int i = this.size;
        this.size = i + 1;
        if (i > this.threshold) {
            length = (doubleCapacity().length - 1) & hash;
        }
        addNewEntry(str, obj, hash, length);
        return null;
    }

    private void addNewEntry(String str, Object obj, int i, int i2) {
        LinkedEntry linkedEntry = this.header;
        LinkedEntry linkedEntry2 = linkedEntry.prv;
        LinkedEntry linkedEntry3 = new LinkedEntry(str, obj, i, this.table[i2], linkedEntry, linkedEntry2);
        LinkedEntry[] linkedEntryArr = this.table;
        linkedEntry.prv = linkedEntry3;
        linkedEntry2.nxt = linkedEntry3;
        linkedEntryArr[i2] = linkedEntry3;
    }

    private LinkedEntry[] makeTable(int i) {
        LinkedEntry[] linkedEntryArr = new LinkedEntry[i];
        this.table = linkedEntryArr;
        this.threshold = (i >> 1) + (i >> 2);
        return linkedEntryArr;
    }

    private LinkedEntry[] doubleCapacity() {
        int i;
        LinkedEntry[] linkedEntryArr = this.table;
        int length = linkedEntryArr.length;
        if (length == MAXIMUM_CAPACITY) {
            return linkedEntryArr;
        }
        LinkedEntry[] makeTable = makeTable(length * 2);
        if (this.size == 0) {
            return makeTable;
        }
        for (int i2 = 0; i2 < length; i2++) {
            LinkedEntry linkedEntry = linkedEntryArr[i2];
            if (linkedEntry != null) {
                int i3 = linkedEntry.hash & length;
                makeTable[i2 | i3] = linkedEntry;
                LinkedEntry linkedEntry2 = null;
                LinkedEntry linkedEntry3 = linkedEntry;
                for (LinkedEntry linkedEntry4 = linkedEntry.next; linkedEntry4 != null; linkedEntry4 = linkedEntry4.next) {
                    int i4 = linkedEntry4.hash & length;
                    if (i4 != i3) {
                        if (linkedEntry2 == null) {
                            makeTable[i2 | i4] = linkedEntry4;
                        } else {
                            linkedEntry2.next = linkedEntry4;
                        }
                        i = i4;
                    } else {
                        linkedEntry3 = linkedEntry2;
                        i = i3;
                    }
                    i3 = i;
                    linkedEntry2 = linkedEntry3;
                    linkedEntry3 = linkedEntry4;
                }
                if (linkedEntry2 != null) {
                    linkedEntry2.next = null;
                }
            }
        }
        return makeTable;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        int hash = hash((String) obj);
        LinkedEntry[] linkedEntryArr = this.table;
        int length = hash & (linkedEntryArr.length - 1);
        LinkedEntry linkedEntry = linkedEntryArr[length];
        LinkedEntry linkedEntry2 = null;
        while (linkedEntry != null) {
            if (linkedEntry.hash != hash || !obj.equals(linkedEntry.key)) {
                LinkedEntry linkedEntry3 = linkedEntry;
                linkedEntry = linkedEntry.next;
                linkedEntry2 = linkedEntry3;
            } else {
                if (linkedEntry2 == null) {
                    linkedEntryArr[length] = linkedEntry.next;
                } else {
                    linkedEntry2.next = linkedEntry.next;
                }
                this.size--;
                unlink(linkedEntry);
                return linkedEntry.value;
            }
        }
        return null;
    }

    private void unlink(LinkedEntry linkedEntry) {
        linkedEntry.prv.nxt = linkedEntry.nxt;
        linkedEntry.nxt.prv = linkedEntry.prv;
        linkedEntry.prv = null;
        linkedEntry.nxt = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.size != 0) {
            Arrays.fill(this.table, (Object) null);
            this.size = 0;
        }
        LinkedEntry linkedEntry = this.header;
        LinkedEntry linkedEntry2 = linkedEntry.nxt;
        while (linkedEntry2 != linkedEntry) {
            LinkedEntry linkedEntry3 = linkedEntry2.nxt;
            linkedEntry2.prv = null;
            linkedEntry2.nxt = null;
            linkedEntry2 = linkedEntry3;
        }
        linkedEntry.prv = linkedEntry;
        linkedEntry.nxt = linkedEntry;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LinkedEntry implements Map.Entry {
        final int hash;
        final String key;
        LinkedEntry next;
        LinkedEntry nxt;
        LinkedEntry prv;
        Object value;

        LinkedEntry() {
            this(null, null, 0, null, null, null);
            this.prv = this;
            this.nxt = this;
        }

        LinkedEntry(String str, Object obj, int i, LinkedEntry linkedEntry, LinkedEntry linkedEntry2, LinkedEntry linkedEntry3) {
            this.key = str;
            this.value = obj;
            this.hash = i;
            this.next = linkedEntry;
            this.nxt = linkedEntry2;
            this.prv = linkedEntry3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Map.Entry
        public final String getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object value = entry.getValue();
                if (this.key.equals(entry.getKey())) {
                    if (this.value == null) {
                        if (value != null) {
                            return false;
                        }
                    } else if (!this.value.equals(value)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
        }

        public final String toString() {
            return this.key + "=" + this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeMapping(Object obj, Object obj2) {
        if (obj == null || !(obj instanceof String)) {
            return false;
        }
        int hash = hash((String) obj);
        LinkedEntry[] linkedEntryArr = this.table;
        int length = hash & (linkedEntryArr.length - 1);
        LinkedEntry linkedEntry = linkedEntryArr[length];
        LinkedEntry linkedEntry2 = null;
        while (linkedEntry != null) {
            if (linkedEntry.hash != hash || !obj.equals(linkedEntry.key)) {
                LinkedEntry linkedEntry3 = linkedEntry;
                linkedEntry = linkedEntry.next;
                linkedEntry2 = linkedEntry3;
            } else if (obj2 != null ? !obj2.equals(linkedEntry.value) : linkedEntry.value != null) {
                return false;
            } else {
                if (linkedEntry2 == null) {
                    linkedEntryArr[length] = linkedEntry.next;
                } else {
                    linkedEntry2.next = linkedEntry.next;
                }
                this.size--;
                unlink(linkedEntry);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public abstract class LinkedHashIterator implements Iterator {
        LinkedEntry lastReturned;
        LinkedEntry next;

        private LinkedHashIterator() {
            this.next = StringMap.this.header.nxt;
            this.lastReturned = null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.next != StringMap.this.header;
        }

        final LinkedEntry nextEntry() {
            LinkedEntry linkedEntry = this.next;
            if (linkedEntry == StringMap.this.header) {
                throw new NoSuchElementException();
            }
            this.next = linkedEntry.nxt;
            this.lastReturned = linkedEntry;
            return linkedEntry;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            StringMap.this.remove(this.lastReturned.key);
            this.lastReturned = null;
        }
    }

    /* loaded from: classes.dex */
    final class KeySet extends AbstractSet {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedHashIterator() { // from class: com.google.gson.internal.StringMap.KeySet.1
                {
                    StringMap stringMap = StringMap.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                public final String next() {
                    return nextEntry().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StringMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StringMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i = StringMap.this.size;
            StringMap.this.remove(obj);
            return StringMap.this.size != i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StringMap.this.clear();
        }
    }

    /* loaded from: classes.dex */
    final class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new LinkedHashIterator() { // from class: com.google.gson.internal.StringMap.Values.1
                {
                    StringMap stringMap = StringMap.this;
                }

                @Override // java.util.Iterator
                public final Object next() {
                    return nextEntry().value;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StringMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return StringMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StringMap.this.clear();
        }
    }

    /* loaded from: classes.dex */
    final class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new LinkedHashIterator() { // from class: com.google.gson.internal.StringMap.EntrySet.1
                {
                    StringMap stringMap = StringMap.this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Iterator
                public final Map.Entry next() {
                    return nextEntry();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object obj2 = StringMap.this.get(entry.getKey());
                return obj2 != null && obj2.equals(entry.getValue());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return StringMap.this.removeMapping(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StringMap.this.size;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StringMap.this.clear();
        }
    }

    private static int hash(String str) {
        int i = seed;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int charAt = i + str.charAt(i2);
            int i3 = (charAt + charAt) << 10;
            i = i3 ^ (i3 >>> 6);
        }
        int i4 = ((i >>> 20) ^ (i >>> 12)) ^ i;
        return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
    }
}
