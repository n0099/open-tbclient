package com.google.protobuf;

import com.baidu.android.common.others.lang.StringUtil;
import com.google.protobuf.ByteString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class LiteralByteString extends ByteString {
    public final byte[] bytes;
    public int hash = 0;

    /* loaded from: classes6.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        public final int limit;
        public int position;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.bytes;
                int i2 = this.position;
                this.position = i2 + 1;
                return bArr[i2];
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new NoSuchElementException(e2.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public LiteralByteString(byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(asReadOnlyByteBuffer());
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i2) {
        return this.bytes[i2];
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.bytes, i2, bArr, i3, i4);
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ByteString) && size() == ((ByteString) obj).size()) {
            if (size() == 0) {
                return true;
            }
            if (obj instanceof LiteralByteString) {
                return equalsRange((LiteralByteString) obj, 0, size());
            }
            if (obj instanceof RopeByteString) {
                return obj.equals(this);
            }
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + obj.getClass());
        }
        return false;
    }

    public boolean equalsRange(LiteralByteString literalByteString, int i2, int i3) {
        if (i3 <= literalByteString.size()) {
            if (i2 + i3 <= literalByteString.size()) {
                byte[] bArr = this.bytes;
                byte[] bArr2 = literalByteString.bytes;
                int offsetIntoBytes = getOffsetIntoBytes() + i3;
                int offsetIntoBytes2 = getOffsetIntoBytes();
                int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i2;
                while (offsetIntoBytes2 < offsetIntoBytes) {
                    if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                        return false;
                    }
                    offsetIntoBytes2++;
                    offsetIntoBytes3++;
                }
                return true;
            }
            throw new IllegalArgumentException("Ran off end of other: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + literalByteString.size());
        }
        throw new IllegalArgumentException("Length too large: " + i3 + size());
    }

    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        return 0;
    }

    @Override // com.google.protobuf.ByteString
    public int hashCode() {
        int i2 = this.hash;
        if (i2 == 0) {
            int size = size();
            i2 = partialHash(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.hash = i2;
        }
        return i2;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        return true;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int offsetIntoBytes = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i2, int i3, int i4) {
        byte[] bArr = this.bytes;
        int offsetIntoBytes = getOffsetIntoBytes() + i3;
        int i5 = i4 + offsetIntoBytes;
        while (offsetIntoBytes < i5) {
            i2 = (i2 * 31) + bArr[offsetIntoBytes];
            offsetIntoBytes++;
        }
        return i2;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i2, int i3, int i4) {
        int offsetIntoBytes = getOffsetIntoBytes() + i3;
        return Utf8.partialIsValidUtf8(i2, this.bytes, offsetIntoBytes, i4 + offsetIntoBytes);
    }

    @Override // com.google.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 > size()) {
                throw new IndexOutOfBoundsException("End index: " + i3 + " > " + size());
            }
            int i4 = i3 - i2;
            if (i4 >= 0) {
                if (i4 == 0) {
                    return ByteString.EMPTY;
                }
                return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i2, i4);
            }
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3);
        }
        throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
    }

    @Override // com.google.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), str);
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        return new LiteralByteIterator();
    }
}
