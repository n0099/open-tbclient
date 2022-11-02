package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public abstract class ByteString implements Iterable<Byte> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY;
    public static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    public static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.protobuf.ByteString$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i);

    public abstract void copyTo(ByteBuffer byteBuffer);

    public abstract void copyToInternal(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract int getTreeDepth();

    public abstract int hashCode();

    public abstract boolean isBalanced();

    public abstract boolean isValidUtf8();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public abstract Iterator<Byte> iterator2();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    public abstract int partialHash(int i, int i2, int i3);

    public abstract int partialIsValidUtf8(int i, int i2, int i3);

    public abstract int peekCachedHashCode();

    public abstract int size();

    public abstract ByteString substring(int i, int i2);

    public abstract String toString(String str) throws UnsupportedEncodingException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    /* loaded from: classes7.dex */
    public static final class CodedBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] buffer;
        public final CodedOutputStream output;

        public CodedBuilder(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            byte[] bArr = new byte[i];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }

        public /* synthetic */ CodedBuilder(int i, AnonymousClass1 anonymousClass1) {
            this(i);
        }

        public ByteString build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.output.checkNoSpaceLeft();
                return new LiteralByteString(this.buffer);
            }
            return (ByteString) invokeV.objValue;
        }

        public CodedOutputStream getCodedOutput() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.output;
            }
            return (CodedOutputStream) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class Output extends OutputStream {
        public static /* synthetic */ Interceptable $ic;
        public static final byte[] EMPTY_BYTE_ARRAY;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] buffer;
        public int bufferPos;
        public final ArrayList<ByteString> flushedBuffers;
        public int flushedBuffersTotalBytes;
        public final int initialCapacity;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(577409463, "Lcom/google/protobuf/ByteString$Output;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(577409463, "Lcom/google/protobuf/ByteString$Output;");
                    return;
                }
            }
            EMPTY_BYTE_ARRAY = new byte[0];
        }

        public synchronized void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    this.flushedBuffers.clear();
                    this.flushedBuffersTotalBytes = 0;
                    this.bufferPos = 0;
                }
            }
        }

        public synchronized int size() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                synchronized (this) {
                    i = this.flushedBuffersTotalBytes + this.bufferPos;
                }
                return i;
            }
            return invokeV.intValue;
        }

        public synchronized ByteString toByteString() {
            InterceptResult invokeV;
            ByteString copyFrom;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                synchronized (this) {
                    flushLastBuffer();
                    copyFrom = ByteString.copyFrom(this.flushedBuffers);
                }
                return copyFrom;
            }
            return (ByteString) invokeV.objValue;
        }

        public Output(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (i >= 0) {
                this.initialCapacity = i;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] copyArray(byte[] bArr, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, this, bArr, i)) == null) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                return bArr2;
            }
            return (byte[]) invokeLI.objValue;
        }

        private void flushFullBuffer(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                int length = this.flushedBuffersTotalBytes + this.buffer.length;
                this.flushedBuffersTotalBytes = length;
                this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i, length >>> 1))];
                this.bufferPos = 0;
            }
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            ByteString[] byteStringArr;
            byte[] bArr;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, outputStream) == null) {
                synchronized (this) {
                    byteStringArr = (ByteString[]) this.flushedBuffers.toArray(new ByteString[this.flushedBuffers.size()]);
                    bArr = this.buffer;
                    i = this.bufferPos;
                }
                for (ByteString byteString : byteStringArr) {
                    byteString.writeTo(outputStream);
                }
                outputStream.write(copyArray(bArr, i));
            }
        }

        private void flushLastBuffer() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                int i = this.bufferPos;
                byte[] bArr = this.buffer;
                if (i < bArr.length) {
                    if (i > 0) {
                        this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i)));
                    }
                } else {
                    this.flushedBuffers.add(new LiteralByteString(this.buffer));
                    this.buffer = EMPTY_BYTE_ARRAY;
                }
                this.flushedBuffersTotalBytes += this.bufferPos;
                this.bufferPos = 0;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
            }
            return (String) invokeV.objValue;
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                synchronized (this) {
                    if (this.bufferPos == this.buffer.length) {
                        flushFullBuffer(1);
                    }
                    byte[] bArr = this.buffer;
                    int i2 = this.bufferPos;
                    this.bufferPos = i2 + 1;
                    bArr[i2] = (byte) i;
                }
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) {
                synchronized (this) {
                    if (i2 <= this.buffer.length - this.bufferPos) {
                        System.arraycopy(bArr, i, this.buffer, this.bufferPos, i2);
                        this.bufferPos += i2;
                    } else {
                        int length = this.buffer.length - this.bufferPos;
                        System.arraycopy(bArr, i, this.buffer, this.bufferPos, length);
                        int i3 = i2 - length;
                        flushFullBuffer(i3);
                        System.arraycopy(bArr, i + length, this.buffer, 0, i3);
                        this.bufferPos = i3;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1806905402, "Lcom/google/protobuf/ByteString;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1806905402, "Lcom/google/protobuf/ByteString;");
                return;
            }
        }
        EMPTY = new LiteralByteString(new byte[0]);
    }

    public ByteString() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static Output newOutput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new Output(128);
        }
        return (Output) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (size() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int size = size();
            byte[] bArr = new byte[size];
            copyToInternal(bArr, 0, 0, size);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public String toStringUtf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                return toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?", e);
            }
        }
        return (String) invokeV.objValue;
    }

    public static ByteString balancedConcat(Iterator<ByteString> it, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, it, i)) == null) {
            if (i == 1) {
                return it.next();
            }
            int i2 = i >>> 1;
            return balancedConcat(it, i2).concat(balancedConcat(it, i - i2));
        }
        return (ByteString) invokeLI.objValue;
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            return new LiteralByteString(str.getBytes(str2));
        }
        return (ByteString) invokeLL.objValue;
    }

    public static ByteString readChunk(InputStream inputStream, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, inputStream, i)) == null) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                return null;
            }
            return copyFrom(bArr, 0, i2);
        }
        return (ByteString) invokeLI.objValue;
    }

    public static ByteString readFrom(InputStream inputStream, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, inputStream, i)) == null) {
            return readFrom(inputStream, i, i);
        }
        return (ByteString) invokeLI.objValue;
    }

    public void copyTo(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, bArr, i) == null) {
            copyTo(bArr, 0, i, size());
        }
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        InterceptResult invokeL;
        Collection collection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iterable)) == null) {
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
        return (ByteString) invokeL.objValue;
    }

    public ByteString concat(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteString)) == null) {
            int size = size();
            int size2 = byteString.size();
            if (size + size2 < 2147483647L) {
                return RopeByteString.concatenate(this, byteString);
            }
            throw new IllegalArgumentException("ByteString would be too long: " + size + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + size2);
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, byteBuffer)) == null) {
            return copyFrom(byteBuffer, byteBuffer.remaining());
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString copyFromUtf8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                return new LiteralByteString(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?", e);
            }
        }
        return (ByteString) invokeL.objValue;
    }

    public static CodedBuilder newCodedBuilder(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return new CodedBuilder(i, null);
        }
        return (CodedBuilder) invokeI.objValue;
    }

    public static Output newOutput(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i)) == null) {
            return new Output(i);
        }
        return (Output) invokeI.objValue;
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, inputStream)) == null) {
            return readFrom(inputStream, 256, 8192);
        }
        return (ByteString) invokeL.objValue;
    }

    public boolean startsWith(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, byteString)) == null) {
            if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public ByteString substring(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            return substring(i, size());
        }
        return (ByteString) invokeI.objValue;
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, byteBuffer, i)) == null) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return new LiteralByteString(bArr);
        }
        return (ByteString) invokeLI.objValue;
    }

    public static ByteString copyFrom(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            return copyFrom(bArr, 0, bArr.length);
        }
        return (ByteString) invokeL.objValue;
    }

    public static ByteString copyFrom(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, bArr, i, i2)) == null) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return new LiteralByteString(bArr2);
        }
        return (ByteString) invokeLII.objValue;
    }

    public static ByteString readFrom(InputStream inputStream, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65552, null, inputStream, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                ByteString readChunk = readChunk(inputStream, i);
                if (readChunk == null) {
                    return copyFrom(arrayList);
                }
                arrayList.add(readChunk);
                i = Math.min(i * 2, i2);
            }
        } else {
            return (ByteString) invokeLII.objValue;
        }
    }

    public void copyTo(byte[] bArr, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048582, this, bArr, i, i2, i3) == null) {
            if (i >= 0) {
                if (i2 >= 0) {
                    if (i3 >= 0) {
                        int i4 = i + i3;
                        if (i4 <= size()) {
                            int i5 = i2 + i3;
                            if (i5 <= bArr.length) {
                                if (i3 > 0) {
                                    copyToInternal(bArr, i, i2, i3);
                                    return;
                                }
                                return;
                            }
                            throw new IndexOutOfBoundsException("Target end offset < 0: " + i5);
                        }
                        throw new IndexOutOfBoundsException("Source end offset < 0: " + i4);
                    }
                    throw new IndexOutOfBoundsException("Length < 0: " + i3);
                }
                throw new IndexOutOfBoundsException("Target offset < 0: " + i2);
            }
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }
        return (String) invokeV.objValue;
    }
}
