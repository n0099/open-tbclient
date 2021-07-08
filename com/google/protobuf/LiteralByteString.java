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
/* loaded from: classes6.dex */
public class LiteralByteString extends ByteString {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] bytes;
    public int hash;

    /* renamed from: com.google.protobuf.LiteralByteString$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public int position;
        public final /* synthetic */ LiteralByteString this$0;

        public /* synthetic */ LiteralByteIterator(LiteralByteString literalByteString, AnonymousClass1 anonymousClass1) {
            this(literalByteString);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.position < this.limit : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                try {
                    byte[] bArr = this.this$0.bytes;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    return bArr[i2];
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new NoSuchElementException(e2.getMessage());
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

        public LiteralByteIterator(LiteralByteString literalByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {literalByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = literalByteString;
            this.position = 0;
            this.limit = literalByteString.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Byte.valueOf(nextByte()) : (Byte) invokeV.objValue;
        }
    }

    public LiteralByteString(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.hash = 0;
        this.bytes = bArr;
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
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
    public byte byteAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.bytes[i2] : invokeI.byteValue;
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    @Override // com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048580, this, bArr, i2, i3, i4) == null) {
            System.arraycopy(this.bytes, i2, bArr, i3, i4);
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
        return invokeL.booleanValue;
    }

    public boolean equalsRange(LiteralByteString literalByteString, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, literalByteString, i2, i3)) == null) {
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
        return invokeLII.booleanValue;
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
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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

    @Override // com.google.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size()) : (CodedInputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size()) : (InputStream) invokeV.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialHash(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048592, this, i2, i3, i4)) == null) {
            byte[] bArr = this.bytes;
            int offsetIntoBytes = getOffsetIntoBytes() + i3;
            int i5 = i4 + offsetIntoBytes;
            while (offsetIntoBytes < i5) {
                i2 = (i2 * 31) + bArr[offsetIntoBytes];
                offsetIntoBytes++;
            }
            return i2;
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int partialIsValidUtf8(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048593, this, i2, i3, i4)) == null) {
            int offsetIntoBytes = getOffsetIntoBytes() + i3;
            return Utf8.partialIsValidUtf8(i2, this.bytes, offsetIntoBytes, i4 + offsetIntoBytes);
        }
        return invokeIII.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int peekCachedHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.hash : invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.bytes.length : invokeV.intValue;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
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
        return (ByteString) invokeII.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public String toString(String str) throws UnsupportedEncodingException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? new String(this.bytes, getOffsetIntoBytes(), size(), str) : (String) invokeL.objValue;
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, outputStream) == null) {
            outputStream.write(toByteArray());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new LiteralByteIterator(this, null) : (ByteString.ByteIterator) invokeV.objValue;
    }
}
