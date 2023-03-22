package kotlin.reflect.jvm.internal.impl.protobuf;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
/* loaded from: classes9.dex */
public class LiteralByteString extends ByteString {
    public final byte[] bytes;
    public int hash = 0;

    public int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int getTreeDepth() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isBalanced() {
        return true;
    }

    /* loaded from: classes9.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        public final int limit;
        public int position;

        public LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.bytes;
                int i = this.position;
                this.position = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public LiteralByteString(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte byteAt(int i) {
        return this.bytes[i];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.bytes, getOffsetIntoBytes(), size(), str);
    }

    public static int hashCode(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.bytes, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return equalsRange((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(String.valueOf(obj.getClass()));
        StringBuilder sb = new StringBuilder(valueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean equalsRange(LiteralByteString literalByteString, int i, int i2) {
        if (i2 <= literalByteString.size()) {
            if (i + i2 <= literalByteString.size()) {
                byte[] bArr = this.bytes;
                byte[] bArr2 = literalByteString.bytes;
                int offsetIntoBytes = getOffsetIntoBytes() + i2;
                int offsetIntoBytes2 = getOffsetIntoBytes();
                int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i;
                while (offsetIntoBytes2 < offsetIntoBytes) {
                    if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                        return false;
                    }
                    offsetIntoBytes2++;
                    offsetIntoBytes3++;
                }
                return true;
            }
            int size = literalByteString.size();
            StringBuilder sb = new StringBuilder(59);
            sb.append("Ran off end of other: ");
            sb.append(i);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(i2);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        int size2 = size();
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Length too large: ");
        sb2.append(i2);
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public int hashCode() {
        int i = this.hash;
        if (i == 0) {
            int size = size();
            i = partialHash(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.hash = i;
        }
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int offsetIntoBytes = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator' to match base method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        return hashCode(i, this.bytes, getOffsetIntoBytes() + i2, i3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        int offsetIntoBytes = getOffsetIntoBytes() + i2;
        return Utf8.partialIsValidUtf8(i, this.bytes, offsetIntoBytes, i3 + offsetIntoBytes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.bytes, getOffsetIntoBytes() + i, i2);
    }
}
