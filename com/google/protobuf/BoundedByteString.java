package com.google.protobuf;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes9.dex */
public class BoundedByteString extends LiteralByteString {
    public final int bytesLength;
    public final int bytesOffset;

    /* loaded from: classes9.dex */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        public final int limit;
        public int position;

        public BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.position < this.limit) {
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i = this.position;
            if (i < this.limit) {
                byte[] bArr = BoundedByteString.this.bytes;
                this.position = i + 1;
                return bArr[i];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public BoundedByteString(byte[] bArr, int i, int i2) {
        super(bArr);
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= bArr.length) {
                    this.bytesOffset = i;
                    this.bytesLength = i2;
                    return;
                }
                throw new IllegalArgumentException("Offset+Length too large: " + i + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + i2);
            }
            throw new IllegalArgumentException("Length too small: " + i);
        }
        throw new IllegalArgumentException("Offset too small: " + i);
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public byte byteAt(int i) {
        if (i >= 0) {
            if (i < size()) {
                return this.bytes[this.bytesOffset + i];
            }
            throw new ArrayIndexOutOfBoundsException("Index too large: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + size());
        }
        throw new ArrayIndexOutOfBoundsException("Index too small: " + i);
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i, bArr, i2, i3);
    }

    @Override // com.google.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new BoundedByteIterator();
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }
}
