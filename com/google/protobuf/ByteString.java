package com.google.protobuf;

import com.google.android.material.badge.BadgeDrawable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class ByteString implements Iterable<Byte> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);
    public static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final int MIN_READ_FROM_CHUNK_SIZE = 256;

    /* loaded from: classes6.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* loaded from: classes6.dex */
    public static final class CodedBuilder {
        public final byte[] buffer;
        public final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        public CodedBuilder(int i2) {
            byte[] bArr = new byte[i2];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }
    }

    public static ByteString balancedConcat(Iterator<ByteString> it, int i2) {
        if (i2 == 1) {
            return it.next();
        }
        int i3 = i2 >>> 1;
        return balancedConcat(it, i3).concat(balancedConcat(it, i2 - i3));
    }

    public static ByteString copyFrom(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new LiteralByteString(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new LiteralByteString(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public static CodedBuilder newCodedBuilder(int i2) {
        return new CodedBuilder(i2);
    }

    public static Output newOutput(int i2) {
        return new Output(i2);
    }

    public static ByteString readChunk(InputStream inputStream, int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i3, i2 - i3);
            if (read == -1) {
                break;
            }
            i3 += read;
        }
        if (i3 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i3);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i2);

    public ByteString concat(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (size + size2 < 2147483647L) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + size2);
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i2) {
        copyTo(bArr, 0, i2, size());
    }

    public abstract void copyToInternal(byte[] bArr, int i2, int i3, int i4);

    public abstract boolean equals(Object obj);

    public abstract int getTreeDepth();

    public abstract int hashCode();

    public abstract boolean isBalanced();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public abstract Iterator<Byte> iterator2();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i2, int i3, int i4);

    public abstract int partialIsValidUtf8(int i2, int i3, int i4);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public ByteString substring(int i2) {
        return substring(i2, size());
    }

    public abstract ByteString substring(int i2, int i3);

    public byte[] toByteArray() {
        int size = size();
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public String toStringUtf8() {
        try {
            return toString("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported?", e2);
        }
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i2) throws IOException {
        return readFrom(inputStream, i2, i2);
    }

    public void copyTo(byte[] bArr, int i2, int i3, int i4) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("Target offset < 0: " + i3);
        } else if (i4 >= 0) {
            int i5 = i2 + i4;
            if (i5 <= size()) {
                int i6 = i3 + i4;
                if (i6 <= bArr.length) {
                    if (i4 > 0) {
                        copyToInternal(bArr, i2, i3, i4);
                        return;
                    }
                    return;
                }
                throw new IndexOutOfBoundsException("Target end offset < 0: " + i6);
            }
            throw new IndexOutOfBoundsException("Source end offset < 0: " + i5);
        } else {
            throw new IndexOutOfBoundsException("Length < 0: " + i4);
        }
    }

    public static ByteString readFrom(InputStream inputStream, int i2, int i3) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i2);
            if (readChunk == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(readChunk);
            i2 = Math.min(i2 * 2, i3);
        }
    }

    /* loaded from: classes6.dex */
    public static final class Output extends OutputStream {
        public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        public byte[] buffer;
        public int bufferPos;
        public final ArrayList<ByteString> flushedBuffers;
        public int flushedBuffersTotalBytes;
        public final int initialCapacity;

        public Output(int i2) {
            if (i2 >= 0) {
                this.initialCapacity = i2;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i2];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] bArr, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
            return bArr2;
        }

        private void flushFullBuffer(int i2) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i2, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i2 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i2 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i2 > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i2)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i2) {
            if (this.bufferPos == this.buffer.length) {
                flushFullBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i3 = this.bufferPos;
            this.bufferPos = i3 + 1;
            bArr[i3] = (byte) i2;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i2;
            synchronized (this) {
                byteStringArr = (ByteString[]) this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
                bArr = this.buffer;
                i2 = this.bufferPos;
            }
            for (ByteString byteString : byteStringArr) {
                byteString.writeTo(outputStream);
            }
            outputStream.write(copyArray(bArr, i2));
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i2, int i3) {
            if (i3 <= this.buffer.length - this.bufferPos) {
                System.arraycopy(bArr, i2, this.buffer, this.bufferPos, i3);
                this.bufferPos += i3;
            } else {
                int length = this.buffer.length - this.bufferPos;
                System.arraycopy(bArr, i2, this.buffer, this.bufferPos, length);
                int i4 = i3 - length;
                flushFullBuffer(i4);
                System.arraycopy(bArr, i2 + length, this.buffer, 0, i4);
                this.bufferPos = i4;
            }
        }
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i2) {
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            for (ByteString byteString : iterable) {
                collection.add(byteString);
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return EMPTY;
        }
        return balancedConcat(collection.iterator(), collection.size());
    }
}
