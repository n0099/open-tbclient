package com.google.common.primitives;

import com.baidu.android.common.others.lang.StringUtil;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class Bytes {

    /* loaded from: classes6.dex */
    public static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        public static final long serialVersionUID = 0;
        public final byte[] array;
        public final int end;
        public final int start;

        public ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object obj) {
            return (obj instanceof Byte) && Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ByteArrayAsList) {
                ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
                int size = size();
                if (byteArrayAsList.size() != size) {
                    return false;
                }
                for (int i = 0; i < size; i++) {
                    if (this.array[this.start + i] != byteArrayAsList.array[byteArrayAsList.start + i]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                byte b2 = this.array[i2];
                Bytes.c(b2);
                i = (i * 31) + b2;
            }
            return i;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object obj) {
            int d2;
            if (!(obj instanceof Byte) || (d2 = Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return d2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object obj) {
            int e2;
            if (!(obj instanceof Byte) || (e2 = Bytes.e(this.array, ((Byte) obj).byteValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return e2 - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i, int i2) {
            n.v(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            byte[] bArr = this.array;
            int i3 = this.start;
            return new ByteArrayAsList(bArr, i + i3, i3 + i2);
        }

        public byte[] toByteArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    sb.append((int) this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        public ByteArrayAsList(byte[] bArr, int i, int i2) {
            this.array = bArr;
            this.start = i;
            this.end = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Byte get(int i) {
            n.n(i, size());
            return Byte.valueOf(this.array[this.start + i]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.AbstractList, java.util.List
        public Byte set(int i, Byte b2) {
            n.n(i, size());
            byte[] bArr = this.array;
            int i2 = this.start;
            byte b3 = bArr[i2 + i];
            n.p(b2);
            bArr[i2 + i] = b2.byteValue();
            return Byte.valueOf(b3);
        }
    }

    public static int c(byte b2) {
        return b2;
    }

    public static int d(byte[] bArr, byte b2, int i, int i2) {
        while (i < i2) {
            if (bArr[i] == b2) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int e(byte[] bArr, byte b2, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (bArr[i3] == b2) {
                return i3;
            }
        }
        return -1;
    }
}
