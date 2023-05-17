package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes9.dex */
public final class WireInput {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType = null;
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 1024;
    public static final String ENCOUNTERED_A_MALFORMED_VARINT = "WireInput encountered a malformed varint.";
    public static final String ENCOUNTERED_A_NEGATIVE_SIZE = "Encountered a negative size";
    public static final String INPUT_ENDED_UNEXPECTEDLY = "The input ended unexpectedly in the middle of a field";
    public static final String PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO = "Protocol message contained an invalid tag (zero).";
    public static final String PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG = "Protocol message end-group tag did not match expected tag.";
    public static final int RECURSION_LIMIT = 64;
    public static final String UTF_8 = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] buffer;
    public long bufferOffset;
    public int currentLimit;
    public final InputStream input;
    public boolean inputStreamAtEof;
    public int lastTag;
    public int limit;
    public int pos;
    public int recursionDepth;

    public static int decodeZigZag32(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? (-(i & 1)) ^ (i >>> 1) : invokeI.intValue;
    }

    public static long decodeZigZag64(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) ? (-(j & 1)) ^ (j >>> 1) : invokeJ.longValue;
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[WireType.values().length];
        try {
            iArr2[WireType.END_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[WireType.FIXED32.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[WireType.FIXED64.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[WireType.LENGTH_DELIMITED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[WireType.START_GROUP.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$squareup$wire$WireType = iArr2;
        return iArr2;
    }

    public int readFixed32() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
        }
        return invokeV.intValue;
    }

    public String readString() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int readVarint32 = readVarint32();
            if (bytesRemaining() >= readVarint32) {
                String str = new String(this.buffer, this.pos, readVarint32, "UTF-8");
                this.pos += readVarint32;
                return str;
            }
            return new String(readRawBytes(readVarint32), "UTF-8");
        }
        return (String) invokeV.objValue;
    }

    public WireInput(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bufferOffset = 0L;
        this.pos = 0;
        this.currentLimit = Integer.MAX_VALUE;
        this.input = inputStream;
        this.buffer = new byte[1024];
    }

    public int pushLimit(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i >= 0) {
                int i2 = (int) (i + this.bufferOffset + this.pos);
                int i3 = this.currentLimit;
                if (i2 <= i3) {
                    this.currentLimit = i2;
                    return i3;
                }
                throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
            }
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        return invokeI.intValue;
    }

    public WireInput(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.bufferOffset = 0L;
        this.pos = 0;
        this.currentLimit = Integer.MAX_VALUE;
        this.input = null;
        this.buffer = bArr;
        this.bufferOffset = -i;
        this.pos = i;
        this.limit = i + i2;
        this.inputStreamAtEof = true;
    }

    private int bytesRemaining() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.limit - this.pos;
        }
        return invokeV.intValue;
    }

    public long getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bufferOffset + this.pos;
        }
        return invokeV.longValue;
    }

    public boolean isAtEnd() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getPosition() == this.currentLimit) {
                return true;
            }
            refillBuffer(1);
            if (bytesRemaining() == 0 && this.inputStreamAtEof) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ByteString readBytes() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return readBytes(readVarint32());
        }
        return (ByteString) invokeV.objValue;
    }

    public byte readRawByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            refillBuffer(1);
            if (bytesRemaining() != 0) {
                byte[] bArr = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                return bArr[i];
            }
            throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
        }
        return invokeV.byteValue;
    }

    public int readTag() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readVarint32 = readVarint32();
            this.lastTag = readVarint32;
            if (readVarint32 != 0) {
                return readVarint32;
            }
            throw new IOException(PROTOCOL_MESSAGE_CONTAINED_AN_INVALID_TAG_ZERO);
        }
        return invokeV.intValue;
    }

    public long readVarint64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                byte readRawByte = readRawByte();
                j |= (readRawByte & ByteCompanionObject.MAX_VALUE) << i;
                if ((readRawByte & 128) == 0) {
                    return j;
                }
            }
            throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
        }
        return invokeV.longValue;
    }

    public void skipGroup() throws IOException {
        int readTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            do {
                readTag = readTag();
                if (readTag == 0) {
                    return;
                }
            } while (!skipField(readTag));
        }
    }

    public static WireInput newInstance(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, inputStream)) == null) {
            return new WireInput(inputStream);
        }
        return (WireInput) invokeL.objValue;
    }

    public void checkLastTagWas(int i) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.lastTag == i) {
            return;
        }
        throw new IOException(PROTOCOL_MESSAGE_END_GROUP_TAG_DID_NOT_MATCH_EXPECTED_TAG);
    }

    public void popLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.currentLimit = i;
        }
    }

    public ByteString readBytes(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (bytesRemaining() >= i) {
                ByteString of = ByteString.of(this.buffer, this.pos, i);
                this.pos += i;
                return of;
            }
            return ByteString.of(readRawBytes(i));
        }
        return (ByteString) invokeI.objValue;
    }

    public static WireInput newInstance(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            return new WireInput(bArr, 0, bArr.length);
        }
        return (WireInput) invokeL.objValue;
    }

    public static WireInput newInstance(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65544, null, bArr, i, i2)) == null) {
            return new WireInput(bArr, i, i2);
        }
        return (WireInput) invokeLII.objValue;
    }

    private void refillBuffer(int i) throws IOException {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65545, this, i) == null) && (i2 = this.pos) >= this.limit && !this.inputStreamAtEof) {
            this.bufferOffset += i2;
            this.pos = 0;
            int min = Math.min(i, 1024);
            int i3 = 0;
            while (i3 < min) {
                int read = this.input.read(this.buffer, i3, 1024 - i3);
                if (read == -1) {
                    this.limit = i3;
                    this.inputStreamAtEof = true;
                    return;
                }
                i3 += read;
            }
            this.limit = i3;
            this.inputStreamAtEof = false;
        }
    }

    private boolean skipField(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
            switch ($SWITCH_TABLE$com$squareup$wire$WireType()[WireType.valueOf(i).ordinal()]) {
                case 1:
                    readVarint64();
                    return false;
                case 2:
                    readFixed64();
                    return false;
                case 3:
                    readRawBytes(readVarint32());
                    return false;
                case 4:
                    skipGroup();
                    checkLastTagWas((i & (-8)) | WireType.END_GROUP.value());
                    return false;
                case 5:
                    return true;
                case 6:
                    readFixed32();
                    return false;
                default:
                    throw new AssertionError();
            }
        }
        return invokeI.booleanValue;
    }

    public byte[] readRawBytes(int i) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            if (i >= 0) {
                byte[] bArr = new byte[i];
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i - i2;
                    refillBuffer(i3);
                    if (bytesRemaining() != 0) {
                        int min = Math.min(i3, bytesRemaining());
                        System.arraycopy(this.buffer, this.pos, bArr, i2, min);
                        this.pos += min;
                        i2 += min;
                    } else {
                        throw new EOFException(INPUT_ENDED_UNEXPECTEDLY);
                    }
                }
                return bArr;
            }
            throw new IOException(ENCOUNTERED_A_NEGATIVE_SIZE);
        }
        return (byte[]) invokeI.objValue;
    }

    public long readFixed64() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            byte readRawByte = readRawByte();
            return ((readRawByte() & 255) << 8) | (readRawByte & 255) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48) | ((readRawByte() & 255) << 56);
        }
        return invokeV.longValue;
    }

    public int readVarint32() throws IOException {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
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
                    i = readRawByte3 << 14;
                } else {
                    i2 |= (readRawByte3 & ByteCompanionObject.MAX_VALUE) << 14;
                    byte readRawByte4 = readRawByte();
                    if (readRawByte4 >= 0) {
                        i = readRawByte4 << 21;
                    } else {
                        int i3 = i2 | ((readRawByte4 & ByteCompanionObject.MAX_VALUE) << 21);
                        byte readRawByte5 = readRawByte();
                        int i4 = i3 | (readRawByte5 << 28);
                        if (readRawByte5 < 0) {
                            for (int i5 = 0; i5 < 5; i5++) {
                                if (readRawByte() >= 0) {
                                    return i4;
                                }
                            }
                            throw new IOException(ENCOUNTERED_A_MALFORMED_VARINT);
                        }
                        return i4;
                    }
                }
            }
            return i2 | i;
        }
        return invokeV.intValue;
    }
}
