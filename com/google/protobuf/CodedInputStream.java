package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes7.dex */
public final class CodedInputStream {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 4096;
    public static final int DEFAULT_RECURSION_LIMIT = 64;
    public static final int DEFAULT_SIZE_LIMIT = 67108864;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] buffer;
    public int bufferPos;
    public int bufferSize;
    public int bufferSizeAfterLimit;
    public int currentLimit;
    public final InputStream input;
    public int lastTag;
    public int recursionDepth;
    public int recursionLimit;
    public int sizeLimit;
    public int totalBytesRetired;

    public CodedInputStream(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = bArr;
        this.bufferSize = i3 + i2;
        this.bufferPos = i2;
        this.totalBytesRetired = -i2;
        this.input = null;
    }

    public static int decodeZigZag32(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? (-(i2 & 1)) ^ (i2 >>> 1) : invokeI.intValue;
    }

    public static long decodeZigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? (-(j & 1)) ^ (j >>> 1) : invokeJ.longValue;
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, inputStream)) == null) ? new CodedInputStream(inputStream) : (CodedInputStream) invokeL.objValue;
    }

    private void recomputeBufferSizeAfterLimit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int i2 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i2;
            int i3 = this.totalBytesRetired + i2;
            int i4 = this.currentLimit;
            if (i3 > i4) {
                int i5 = i3 - i4;
                this.bufferSizeAfterLimit = i5;
                this.bufferSize = i2 - i5;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }
    }

    private boolean refillBuffer(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, this, z)) == null) {
            int i2 = this.bufferPos;
            int i3 = this.bufferSize;
            if (i2 >= i3) {
                int i4 = this.totalBytesRetired;
                if (i4 + i3 == this.currentLimit) {
                    if (z) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    return false;
                }
                this.totalBytesRetired = i4 + i3;
                this.bufferPos = 0;
                InputStream inputStream = this.input;
                int read = inputStream == null ? -1 : inputStream.read(this.buffer);
                this.bufferSize = read;
                if (read == 0 || read < -1) {
                    throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.bufferSize + "\nThe InputStream implementation is buggy.");
                } else if (read == -1) {
                    this.bufferSize = 0;
                    if (z) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    return false;
                } else {
                    recomputeBufferSizeAfterLimit();
                    int i5 = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
                    if (i5 > this.sizeLimit || i5 < 0) {
                        throw InvalidProtocolBufferException.sizeLimitExceeded();
                    }
                    return true;
                }
            }
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        return invokeZ.booleanValue;
    }

    public void checkLastTagWas(int i2) throws InvalidProtocolBufferException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.lastTag != i2) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.currentLimit;
            if (i2 == Integer.MAX_VALUE) {
                return -1;
            }
            return i2 - (this.totalBytesRetired + this.bufferPos);
        }
        return invokeV.intValue;
    }

    public int getTotalBytesRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.totalBytesRetired + this.bufferPos : invokeV.intValue;
    }

    public boolean isAtEnd() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.bufferPos == this.bufferSize && !refillBuffer(false) : invokeV.booleanValue;
    }

    public void popLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.currentLimit = i2;
            recomputeBufferSizeAfterLimit();
        }
    }

    public int pushLimit(int i2) throws InvalidProtocolBufferException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = i2 + this.totalBytesRetired + this.bufferPos;
                int i4 = this.currentLimit;
                if (i3 <= i4) {
                    this.currentLimit = i3;
                    recomputeBufferSizeAfterLimit();
                    return i4;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        return invokeI.intValue;
    }

    public boolean readBool() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? readRawVarint32() != 0 : invokeV.booleanValue;
    }

    public ByteString readBytes() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            int i2 = this.bufferSize;
            int i3 = this.bufferPos;
            if (readRawVarint32 <= i2 - i3 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i3, readRawVarint32);
                this.bufferPos += readRawVarint32;
                return copyFrom;
            }
            return ByteString.copyFrom(readRawBytes(readRawVarint32));
        }
        return (ByteString) invokeV.objValue;
    }

    public double readDouble() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? Double.longBitsToDouble(readRawLittleEndian64()) : invokeV.doubleValue;
    }

    public int readEnum() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? readRawVarint32() : invokeV.intValue;
    }

    public int readFixed32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? readRawLittleEndian32() : invokeV.intValue;
    }

    public long readFixed64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? readRawLittleEndian64() : invokeV.longValue;
    }

    public float readFloat() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? Float.intBitsToFloat(readRawLittleEndian32()) : invokeV.floatValue;
    }

    public void readGroup(int i2, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i2, builder, extensionRegistryLite) == null) {
            int i3 = this.recursionDepth;
            if (i3 < this.recursionLimit) {
                this.recursionDepth = i3 + 1;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i2, 4));
                this.recursionDepth--;
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public int readInt32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? readRawVarint32() : invokeV.intValue;
    }

    public long readInt64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? readRawVarint64() : invokeV.longValue;
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, builder, extensionRegistryLite) == null) {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public byte readRawByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.bufferPos == this.bufferSize) {
                refillBuffer(true);
            }
            byte[] bArr = this.buffer;
            int i2 = this.bufferPos;
            this.bufferPos = i2 + 1;
            return bArr[i2];
        }
        return invokeV.byteValue;
    }

    public byte[] readRawBytes(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048596, this, i2)) != null) {
            return (byte[]) invokeI.objValue;
        }
        if (i2 >= 0) {
            int i3 = this.totalBytesRetired;
            int i4 = this.bufferPos;
            int i5 = i3 + i4 + i2;
            int i6 = this.currentLimit;
            if (i5 <= i6) {
                int i7 = this.bufferSize;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.buffer, i4, bArr, 0, i2);
                    this.bufferPos += i2;
                    return bArr;
                } else if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.buffer, i4, bArr2, 0, i8);
                    this.bufferPos = this.bufferSize;
                    refillBuffer(true);
                    while (true) {
                        int i9 = i2 - i8;
                        int i10 = this.bufferSize;
                        if (i9 > i10) {
                            System.arraycopy(this.buffer, 0, bArr2, i8, i10);
                            int i11 = this.bufferSize;
                            i8 += i11;
                            this.bufferPos = i11;
                            refillBuffer(true);
                        } else {
                            System.arraycopy(this.buffer, 0, bArr2, i8, i9);
                            this.bufferPos = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.totalBytesRetired = i3 + i7;
                    this.bufferPos = 0;
                    this.bufferSize = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    ArrayList<byte[]> arrayList = new ArrayList();
                    while (i13 > 0) {
                        int min = Math.min(i13, 4096);
                        byte[] bArr3 = new byte[min];
                        int i14 = 0;
                        while (i14 < min) {
                            InputStream inputStream = this.input;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, min - i14);
                            if (read == -1) {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                            this.totalBytesRetired += read;
                            i14 += read;
                        }
                        i13 -= min;
                        arrayList.add(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.buffer, i4, bArr4, 0, i12);
                    for (byte[] bArr5 : arrayList) {
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public int readRawLittleEndian32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) : invokeV.intValue;
    }

    public long readRawLittleEndian64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            byte readRawByte = readRawByte();
            return ((readRawByte() & 255) << 8) | (readRawByte & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
        }
        return invokeV.longValue;
    }

    public int readRawVarint32() throws IOException {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            byte readRawByte = readRawByte();
            if (readRawByte >= 0) {
                return readRawByte;
            }
            int i3 = readRawByte & ByteCompanionObject.MAX_VALUE;
            byte readRawByte2 = readRawByte();
            if (readRawByte2 >= 0) {
                i2 = readRawByte2 << 7;
            } else {
                i3 |= (readRawByte2 & ByteCompanionObject.MAX_VALUE) << 7;
                byte readRawByte3 = readRawByte();
                if (readRawByte3 >= 0) {
                    i2 = readRawByte3 << 14;
                } else {
                    i3 |= (readRawByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                    byte readRawByte4 = readRawByte();
                    if (readRawByte4 < 0) {
                        int i4 = i3 | ((readRawByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                        byte readRawByte5 = readRawByte();
                        int i5 = i4 | (readRawByte5 << 28);
                        if (readRawByte5 < 0) {
                            for (int i6 = 0; i6 < 5; i6++) {
                                if (readRawByte() >= 0) {
                                    return i5;
                                }
                            }
                            throw InvalidProtocolBufferException.malformedVarint();
                        }
                        return i5;
                    }
                    i2 = readRawByte4 << 21;
                }
            }
            return i3 | i2;
        }
        return invokeV.intValue;
    }

    public long readRawVarint64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                byte readRawByte = readRawByte();
                j |= (readRawByte & ByteCompanionObject.MAX_VALUE) << i2;
                if ((readRawByte & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        return invokeV.longValue;
    }

    public int readSFixed32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? readRawLittleEndian32() : invokeV.intValue;
    }

    public long readSFixed64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? readRawLittleEndian64() : invokeV.longValue;
    }

    public int readSInt32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? decodeZigZag32(readRawVarint32()) : invokeV.intValue;
    }

    public long readSInt64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? decodeZigZag64(readRawVarint64()) : invokeV.longValue;
    }

    public String readString() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= this.bufferSize - this.bufferPos && readRawVarint32 > 0) {
                String str = new String(this.buffer, this.bufferPos, readRawVarint32, "UTF-8");
                this.bufferPos += readRawVarint32;
                return str;
            }
            return new String(readRawBytes(readRawVarint32), "UTF-8");
        }
        return (String) invokeV.objValue;
    }

    public int readTag() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        return invokeV.intValue;
    }

    public int readUInt32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? readRawVarint32() : invokeV.intValue;
    }

    public long readUInt64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? readRawVarint64() : invokeV.longValue;
    }

    @Deprecated
    public void readUnknownGroup(int i2, MessageLite.Builder builder) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i2, builder) == null) {
            readGroup(i2, builder, (ExtensionRegistryLite) null);
        }
    }

    public void resetSizeCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.totalBytesRetired = -this.bufferPos;
        }
    }

    public int setRecursionLimit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = this.recursionLimit;
                this.recursionLimit = i2;
                return i3;
            }
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i2);
        }
        return invokeI.intValue;
    }

    public int setSizeLimit(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            if (i2 >= 0) {
                int i3 = this.sizeLimit;
                this.sizeLimit = i2;
                return i3;
            }
            throw new IllegalArgumentException("Size limit cannot be negative: " + i2);
        }
        return invokeI.intValue;
    }

    public boolean skipField(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                readInt32();
                return true;
            } else if (tagWireType == 1) {
                readRawLittleEndian64();
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i2), 4));
                return true;
            } else if (tagWireType != 4) {
                if (tagWireType == 5) {
                    readRawLittleEndian32();
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public void skipMessage() throws IOException {
        int readTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (skipField(readTag));
        }
    }

    public void skipRawBytes(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048615, this, i2) != null) {
            return;
        }
        if (i2 >= 0) {
            int i3 = this.totalBytesRetired;
            int i4 = this.bufferPos;
            int i5 = i3 + i4 + i2;
            int i6 = this.currentLimit;
            if (i5 <= i6) {
                int i7 = this.bufferSize;
                if (i2 <= i7 - i4) {
                    this.bufferPos = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.bufferPos = i7;
                refillBuffer(true);
                while (true) {
                    int i9 = i2 - i8;
                    int i10 = this.bufferSize;
                    if (i9 > i10) {
                        i8 += i10;
                        this.bufferPos = i10;
                        refillBuffer(true);
                    } else {
                        this.bufferPos = i9;
                        return;
                    }
                }
            } else {
                skipRawBytes((i6 - i3) - i4);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) ? newInstance(bArr, 0, bArr.length) : (CodedInputStream) invokeL.objValue;
    }

    public static CodedInputStream newInstance(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(AdIconUtil.BAIDU_LOGO_ID, null, bArr, i2, i3)) == null) {
            CodedInputStream codedInputStream = new CodedInputStream(bArr, i2, i3);
            try {
                codedInputStream.pushLimit(i3);
                return codedInputStream;
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (CodedInputStream) invokeLII.objValue;
    }

    public <T extends MessageLite> T readGroup(int i2, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048589, this, i2, parser, extensionRegistryLite)) == null) {
            int i3 = this.recursionDepth;
            if (i3 < this.recursionLimit) {
                this.recursionDepth = i3 + 1;
                T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i2, 4));
                this.recursionDepth--;
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        return (T) invokeILL.objValue;
    }

    public static int readRawVarint32(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            int read = inputStream.read();
            if (read != -1) {
                return readRawVarint32(read, inputStream);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        return invokeL.intValue;
    }

    public CodedInputStream(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = new byte[4096];
        this.bufferSize = 0;
        this.bufferPos = 0;
        this.totalBytesRetired = 0;
        this.input = inputStream;
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, parser, extensionRegistryLite)) == null) {
            int readRawVarint32 = readRawVarint32();
            if (this.recursionDepth < this.recursionLimit) {
                int pushLimit = pushLimit(readRawVarint32);
                this.recursionDepth++;
                T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(0);
                this.recursionDepth--;
                popLimit(pushLimit);
                return parsePartialFrom;
            }
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        return (T) invokeLL.objValue;
    }

    public static int readRawVarint32(int i2, InputStream inputStream) throws IOException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, inputStream)) == null) {
            if ((i2 & 128) == 0) {
                return i2;
            }
            int i3 = i2 & 127;
            int i4 = 7;
            while (i4 < 32) {
                int read = inputStream.read();
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                i3 |= (read & 127) << i4;
                if ((read & 128) == 0) {
                    return i3;
                }
                i4 += 7;
            }
            while (i4 < 64) {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if ((read2 & 128) == 0) {
                    return i3;
                }
                i4 += 7;
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        return invokeIL.intValue;
    }
}
