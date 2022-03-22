package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.MessageLite;
import com.kwad.yoga.YogaNodeJNIBase;
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

    public CodedInputStream(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.currentLimit = Integer.MAX_VALUE;
        this.recursionLimit = 64;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.buffer = bArr;
        this.bufferSize = i2 + i;
        this.bufferPos = i;
        this.totalBytesRetired = -i;
        this.input = null;
    }

    public static int decodeZigZag32(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? (-(i & 1)) ^ (i >>> 1) : invokeI.intValue;
    }

    public static long decodeZigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65539, null, j)) == null) ? (-(j & 1)) ^ (j >>> 1) : invokeJ.longValue;
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream)) == null) ? new CodedInputStream(inputStream) : (CodedInputStream) invokeL.objValue;
    }

    private void recomputeBufferSizeAfterLimit() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            int i = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i;
            int i2 = this.totalBytesRetired + i;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                int i4 = i2 - i3;
                this.bufferSizeAfterLimit = i4;
                this.bufferSize = i - i4;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }
    }

    private boolean refillBuffer(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, this, z)) == null) {
            int i = this.bufferPos;
            int i2 = this.bufferSize;
            if (i >= i2) {
                int i3 = this.totalBytesRetired;
                if (i3 + i2 == this.currentLimit) {
                    if (z) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    return false;
                }
                this.totalBytesRetired = i3 + i2;
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
                    int i4 = this.totalBytesRetired + this.bufferSize + this.bufferSizeAfterLimit;
                    if (i4 > this.sizeLimit || i4 < 0) {
                        throw InvalidProtocolBufferException.sizeLimitExceeded();
                    }
                    return true;
                }
            }
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        return invokeZ.booleanValue;
    }

    public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.lastTag != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.totalBytesRetired + this.bufferPos);
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

    public void popLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }
    }

    public int pushLimit(int i) throws InvalidProtocolBufferException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= 0) {
                int i2 = i + this.totalBytesRetired + this.bufferPos;
                int i3 = this.currentLimit;
                if (i2 <= i3) {
                    this.currentLimit = i2;
                    recomputeBufferSizeAfterLimit();
                    return i3;
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
            int i = this.bufferSize;
            int i2 = this.bufferPos;
            if (readRawVarint32 <= i - i2 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i2, readRawVarint32);
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

    public void readGroup(int i, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048590, this, i, builder, extensionRegistryLite) == null) {
            int i2 = this.recursionDepth;
            if (i2 < this.recursionLimit) {
                this.recursionDepth = i2 + 1;
                builder.mergeFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
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
            int i = this.bufferPos;
            this.bufferPos = i + 1;
            return bArr[i];
        }
        return invokeV.byteValue;
    }

    public byte[] readRawBytes(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(1048596, this, i)) != null) {
            return (byte[]) invokeI.objValue;
        }
        if (i >= 0) {
            int i2 = this.totalBytesRetired;
            int i3 = this.bufferPos;
            int i4 = i2 + i3 + i;
            int i5 = this.currentLimit;
            if (i4 <= i5) {
                int i6 = this.bufferSize;
                if (i <= i6 - i3) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, i3, bArr, 0, i);
                    this.bufferPos += i;
                    return bArr;
                } else if (i < 4096) {
                    byte[] bArr2 = new byte[i];
                    int i7 = i6 - i3;
                    System.arraycopy(this.buffer, i3, bArr2, 0, i7);
                    this.bufferPos = this.bufferSize;
                    refillBuffer(true);
                    while (true) {
                        int i8 = i - i7;
                        int i9 = this.bufferSize;
                        if (i8 > i9) {
                            System.arraycopy(this.buffer, 0, bArr2, i7, i9);
                            int i10 = this.bufferSize;
                            i7 += i10;
                            this.bufferPos = i10;
                            refillBuffer(true);
                        } else {
                            System.arraycopy(this.buffer, 0, bArr2, i7, i8);
                            this.bufferPos = i8;
                            return bArr2;
                        }
                    }
                } else {
                    this.totalBytesRetired = i2 + i6;
                    this.bufferPos = 0;
                    this.bufferSize = 0;
                    int i11 = i6 - i3;
                    int i12 = i - i11;
                    ArrayList<byte[]> arrayList = new ArrayList();
                    while (i12 > 0) {
                        int min = Math.min(i12, 4096);
                        byte[] bArr3 = new byte[min];
                        int i13 = 0;
                        while (i13 < min) {
                            InputStream inputStream = this.input;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i13, min - i13);
                            if (read == -1) {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                            this.totalBytesRetired += read;
                            i13 += read;
                        }
                        i12 -= min;
                        arrayList.add(bArr3);
                    }
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(this.buffer, i3, bArr4, 0, i11);
                    for (byte[] bArr5 : arrayList) {
                        System.arraycopy(bArr5, 0, bArr4, i11, bArr5.length);
                        i11 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                skipRawBytes((i5 - i2) - i3);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            byte readRawByte = readRawByte();
            if (readRawByte >= 0) {
                return readRawByte;
            }
            int i2 = readRawByte & ByteCompanionObject.MAX_VALUE;
            byte readRawByte2 = readRawByte();
            if (readRawByte2 >= 0) {
                i = readRawByte2 << 7;
            } else {
                i2 |= (readRawByte2 & ByteCompanionObject.MAX_VALUE) << 7;
                byte readRawByte3 = readRawByte();
                if (readRawByte3 >= 0) {
                    i = readRawByte3 << YogaNodeJNIBase.LAYOUT_BORDER_START_INDEX;
                } else {
                    i2 |= (readRawByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                    byte readRawByte4 = readRawByte();
                    if (readRawByte4 < 0) {
                        int i3 = i2 | ((readRawByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                        byte readRawByte5 = readRawByte();
                        int i4 = i3 | (readRawByte5 << 28);
                        if (readRawByte5 < 0) {
                            for (int i5 = 0; i5 < 5; i5++) {
                                if (readRawByte() >= 0) {
                                    return i4;
                                }
                            }
                            throw InvalidProtocolBufferException.malformedVarint();
                        }
                        return i4;
                    }
                    i = readRawByte4 << 21;
                }
            }
            return i2 | i;
        }
        return invokeV.intValue;
    }

    public long readRawVarint64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= (readRawByte & ByteCompanionObject.MAX_VALUE) << i;
                if ((readRawByte & 128) == 0) {
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
    public void readUnknownGroup(int i, MessageLite.Builder builder) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i, builder) == null) {
            readGroup(i, builder, (ExtensionRegistryLite) null);
        }
    }

    public void resetSizeCounter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.totalBytesRetired = -this.bufferPos;
        }
    }

    public int setRecursionLimit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            if (i >= 0) {
                int i2 = this.recursionLimit;
                this.recursionLimit = i;
                return i2;
            }
            throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
        }
        return invokeI.intValue;
    }

    public int setSizeLimit(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            if (i >= 0) {
                int i2 = this.sizeLimit;
                this.sizeLimit = i;
                return i2;
            }
            throw new IllegalArgumentException("Size limit cannot be negative: " + i);
        }
        return invokeI.intValue;
    }

    public boolean skipField(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            int tagWireType = WireFormat.getTagWireType(i);
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
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i), 4));
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

    public void skipRawBytes(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeI(1048615, this, i) != null) {
            return;
        }
        if (i >= 0) {
            int i2 = this.totalBytesRetired;
            int i3 = this.bufferPos;
            int i4 = i2 + i3 + i;
            int i5 = this.currentLimit;
            if (i4 <= i5) {
                int i6 = this.bufferSize;
                if (i <= i6 - i3) {
                    this.bufferPos = i3 + i;
                    return;
                }
                int i7 = i6 - i3;
                this.bufferPos = i6;
                refillBuffer(true);
                while (true) {
                    int i8 = i - i7;
                    int i9 = this.bufferSize;
                    if (i8 > i9) {
                        i7 += i9;
                        this.bufferPos = i9;
                        refillBuffer(true);
                    } else {
                        this.bufferPos = i8;
                        return;
                    }
                }
            } else {
                skipRawBytes((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        } else {
            throw InvalidProtocolBufferException.negativeSize();
        }
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) ? newInstance(bArr, 0, bArr.length) : (CodedInputStream) invokeL.objValue;
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65542, null, bArr, i, i2)) == null) {
            CodedInputStream codedInputStream = new CodedInputStream(bArr, i, i2);
            try {
                codedInputStream.pushLimit(i2);
                return codedInputStream;
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        return (CodedInputStream) invokeLII.objValue;
    }

    public <T extends MessageLite> T readGroup(int i, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048589, this, i, parser, extensionRegistryLite)) == null) {
            int i2 = this.recursionDepth;
            if (i2 < this.recursionLimit) {
                this.recursionDepth = i2 + 1;
                T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
                checkLastTagWas(WireFormat.makeTag(i, 4));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i, inputStream)) == null) {
            if ((i & 128) == 0) {
                return i;
            }
            int i2 = i & 127;
            int i3 = 7;
            while (i3 < 32) {
                int read = inputStream.read();
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                i2 |= (read & 127) << i3;
                if ((read & 128) == 0) {
                    return i2;
                }
                i3 += 7;
            }
            while (i3 < 64) {
                int read2 = inputStream.read();
                if (read2 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if ((read2 & 128) == 0) {
                    return i2;
                }
                i3 += 7;
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        return invokeIL.intValue;
    }
}
