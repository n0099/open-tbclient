package com.google.protobuf;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class BoundedByteString extends LiteralByteString {
    public final int bytesLength;
    public final int bytesOffset;

    /* loaded from: classes6.dex */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        public final int limit;
        public int position;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i2 = this.position;
            if (i2 < this.limit) {
                byte[] bArr = BoundedByteString.this.bytes;
                this.position = i2 + 1;
                return bArr[i2];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public BoundedByteString(byte[] bArr, int i2, int i3) {
        super(bArr);
        if (i2 < 0) {
            throw new IllegalArgumentException("Offset too small: " + i2);
        } else if (i3 >= 0) {
            if (i2 + i3 <= bArr.length) {
                this.bytesOffset = i2;
                this.bytesLength = i3;
                return;
            }
            throw new IllegalArgumentException("Offset+Length too large: " + i2 + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + i3);
        } else {
            throw new IllegalArgumentException("Length too small: " + i2);
        }
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public byte byteAt(int i2) {
        if (i2 >= 0) {
            if (i2 < size()) {
                return this.bytes[this.bytesOffset + i2];
            }
            throw new ArrayIndexOutOfBoundsException("Index too large: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + size());
        }
        throw new ArrayIndexOutOfBoundsException("Index too small: " + i2);
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i2, bArr, i3, i4);
    }

    @Override // com.google.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new BoundedByteIterator();
    }
}
