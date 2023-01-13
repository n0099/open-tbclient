package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes8.dex */
public class LiteralByteString extends ByteString {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] bytes;
    public int hash;

    /* renamed from: com.google.protobuf.LiteralByteString$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public int getOffsetIntoBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int getTreeDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isBalanced() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public int position;
        public final /* synthetic */ LiteralByteString this$0;

        public LiteralByteIterator(LiteralByteString literalByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {literalByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = literalByteString;
            this.position = 0;
            this.limit = literalByteString.size();
        }

        public /* synthetic */ LiteralByteIterator(LiteralByteString literalByteString, AnonymousClass1 anonymousClass1) {
            this(literalByteString);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.position < this.limit) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return Byte.valueOf(nextByte());
            }
            return (Byte) invokeV.objValue;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    byte[] bArr = this.this$0.bytes;
                    int i = this.position;
                    this.position = i + 1;
                    return bArr[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new NoSuchElementException(e.getMessage());
                }
            }
            return invokeV.byteValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                throw new UnsupportedOperationException();
            }
        }
    }

    public LiteralByteString(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hash = 0;
        this.bytes = bArr;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return this.bytes[i];
        }
        return invokeI.byteValue;
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    @Override // com.google.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, outputStream) == null) {
            outputStream.write(toByteArray());
        }
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(asReadOnlyByteBuffer());
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new LiteralByteIterator(this, null);
        }
        return (ByteString.ByteIterator) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size());
        }
        return (CodedInputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public int peekCachedHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.hash;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.bytes.length;
        }
        return invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, bArr, i, i2, i3) == null) {
            System.arraycopy(this.bytes, i, bArr, i2, i3);
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
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
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + obj.getClass());
        }
        return invokeL.booleanValue;
    }

    public boolean equalsRange(LiteralByteString literalByteString, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, literalByteString, i, i2)) == null) {
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
                throw new IllegalArgumentException("Ran off end of other: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + literalByteString.size());
            }
            throw new IllegalArgumentException("Length too large: " + i2 + size());
        }
        return invokeLII.booleanValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048592, this, i, i2, i3)) == null) {
            byte[] bArr = this.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i2;
            int i4 = i3 + offsetIntoBytes;
            while (offsetIntoBytes < i4) {
                i = (i * 31) + bArr[offsetIntoBytes];
                offsetIntoBytes++;
            }
            return i;
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048593, this, i, i2, i3)) == null) {
            int offsetIntoBytes = getOffsetIntoBytes() + i2;
            return Utf8.partialIsValidUtf8(i, this.bytes, offsetIntoBytes, i3 + offsetIntoBytes);
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) {
            if (i >= 0) {
                if (i2 <= size()) {
                    int i3 = i2 - i;
                    if (i3 >= 0) {
                        if (i3 == 0) {
                            return ByteString.EMPTY;
                        }
                        return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i, i3);
                    }
                    throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
                }
                throw new IndexOutOfBoundsException("End index: " + i2 + " > " + size());
            }
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        return (ByteString) invokeII.objValue;
    }
}
