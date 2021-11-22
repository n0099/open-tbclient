package com.google.protobuf;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.badge.BadgeDrawable;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes11.dex */
public class BoundedByteString extends LiteralByteString {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bytesLength;
    public final int bytesOffset;

    /* renamed from: com.google.protobuf.BoundedByteString$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int limit;
        public int position;
        public final /* synthetic */ BoundedByteString this$0;

        public /* synthetic */ BoundedByteIterator(BoundedByteString boundedByteString, AnonymousClass1 anonymousClass1) {
            this(boundedByteString);
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
                int i2 = this.position;
                if (i2 < this.limit) {
                    byte[] bArr = this.this$0.bytes;
                    this.position = i2 + 1;
                    return bArr[i2];
                }
                throw new NoSuchElementException();
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

        public BoundedByteIterator(BoundedByteString boundedByteString) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {boundedByteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = boundedByteString;
            int offsetIntoBytes = boundedByteString.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + boundedByteString.size();
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoundedByteString(byte[] bArr, int i2, int i3) {
        super(bArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 >= 0) {
                if (i2 < size()) {
                    return this.bytes[this.bytesOffset + i2];
                }
                throw new ArrayIndexOutOfBoundsException("Index too large: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + size());
            }
            throw new ArrayIndexOutOfBoundsException("Index too small: " + i2);
        }
        return invokeI.byteValue;
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i2, i3, i4) == null) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i2, bArr, i3, i4);
        }
    }

    @Override // com.google.protobuf.LiteralByteString
    public int getOffsetIntoBytes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bytesOffset : invokeV.intValue;
    }

    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.bytesLength : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.google.protobuf.ByteString$ByteIterator' to match base method */
    @Override // com.google.protobuf.LiteralByteString, com.google.protobuf.ByteString, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<Byte> iterator2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new BoundedByteIterator(this, null) : (ByteString.ByteIterator) invokeV.objValue;
    }
}
