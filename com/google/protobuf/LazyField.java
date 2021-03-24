package com.google.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes6.dex */
public class LazyField {
    public ByteString bytes;
    public final MessageLite defaultInstance;
    public final ExtensionRegistryLite extensionRegistry;
    public volatile boolean isDirty = false;
    public volatile MessageLite value;

    /* loaded from: classes6.dex */
    public static class LazyEntry<K> implements Map.Entry<K, Object> {
        public Map.Entry<K, LazyField> entry;

        public LazyField getField() {
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.entry.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.entry.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.entry.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        public LazyEntry(Map.Entry<K, LazyField> entry) {
            this.entry = entry;
        }
    }

    /* loaded from: classes6.dex */
    public static class LazyIterator<K> implements Iterator<Map.Entry<K, Object>> {
        public Iterator<Map.Entry<K, Object>> iterator;

        public LazyIterator(Iterator<Map.Entry<K, Object>> it) {
            this.iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.iterator.next();
            return next.getValue() instanceof LazyField ? new LazyEntry(next) : next;
        }
    }

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        this.defaultInstance = messageLite;
        this.extensionRegistry = extensionRegistryLite;
        this.bytes = byteString;
    }

    private void ensureInitialized() {
        if (this.value != null) {
            return;
        }
        synchronized (this) {
            if (this.value != null) {
                return;
            }
            try {
                if (this.bytes != null) {
                    this.value = this.defaultInstance.getParserForType().parseFrom(this.bytes, this.extensionRegistry);
                }
            } catch (IOException unused) {
            }
        }
    }

    public boolean equals(Object obj) {
        ensureInitialized();
        return this.value.equals(obj);
    }

    public int getSerializedSize() {
        if (this.isDirty) {
            return this.value.getSerializedSize();
        }
        return this.bytes.size();
    }

    public MessageLite getValue() {
        ensureInitialized();
        return this.value;
    }

    public int hashCode() {
        ensureInitialized();
        return this.value.hashCode();
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.value = messageLite;
        this.bytes = null;
        this.isDirty = true;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (!this.isDirty) {
            return this.bytes;
        }
        synchronized (this) {
            if (!this.isDirty) {
                return this.bytes;
            }
            this.bytes = this.value.toByteString();
            this.isDirty = false;
            return this.bytes;
        }
    }

    public String toString() {
        ensureInitialized();
        return this.value.toString();
    }
}
