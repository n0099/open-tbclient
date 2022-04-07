package org.apache.commons.codec.binary4util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import org.apache.commons.base.BinaryDecoder;
import org.apache.commons.base.BinaryEncoder;
import org.apache.commons.base.DecoderException;
import org.apache.commons.base.EncoderException;
/* loaded from: classes8.dex */
public abstract class BaseNCodec implements BinaryEncoder, BinaryDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int EOF = -1;
    public static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    public static final byte PAD_DEFAULT = 61;
    public static final int PEM_CHUNK_SIZE = 64;
    public transient /* synthetic */ FieldHolder $fh;
    @Deprecated
    public final byte PAD;
    public final int chunkSeparatorLength;
    public final int encodedBlockSize;
    public final int lineLength;
    public final byte pad;
    public final int unencodedBlockSize;

    /* loaded from: classes8.dex */
    public static class Context {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] buffer;
        public int currentLinePos;
        public boolean eof;
        public int ibitWorkArea;
        public long lbitWorkArea;
        public int modulus;
        public int pos;
        public int readPos;

        public Context() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", Context.class.getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos)) : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseNCodec(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, PAD_DEFAULT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Byte) objArr2[4]).byteValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean isWhiteSpace(byte b) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b)) == null) ? b == 9 || b == 10 || b == 13 || b == 32 : invokeB.booleanValue;
    }

    private byte[] resizeBuffer(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            byte[] bArr = context.buffer;
            if (bArr == null) {
                context.buffer = new byte[getDefaultBufferSize()];
                context.pos = 0;
                context.readPos = 0;
            } else {
                byte[] bArr2 = new byte[bArr.length * 2];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                context.buffer = bArr2;
            }
            return context.buffer;
        }
        return (byte[]) invokeL.objValue;
    }

    public int available(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (context.buffer != null) {
                return context.pos - context.readPos;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean containsAlphabetOrPad(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            for (byte b : bArr) {
                if (this.pad == b || isInAlphabet(b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.commons.base.Decoder
    public Object decode(Object obj) throws DecoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof byte[]) {
                return decode((byte[]) obj);
            }
            if (obj instanceof String) {
                return decode((String) obj);
            }
            throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
        }
        return invokeL.objValue;
    }

    public abstract void decode(byte[] bArr, int i, int i2, Context context);

    @Override // org.apache.commons.base.Encoder
    public Object encode(Object obj) throws EncoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
            if (obj instanceof byte[]) {
                return encode((byte[]) obj);
            }
            throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
        }
        return invokeL.objValue;
    }

    public abstract void encode(byte[] bArr, int i, int i2, Context context);

    public String encodeAsString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bArr)) == null) ? org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr)) : (String) invokeL.objValue;
    }

    public String encodeToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bArr)) == null) ? org.apache.commons.base.binary4util.CodecStringUtils.newStringUtf8(encode(bArr)) : (String) invokeL.objValue;
    }

    public byte[] ensureBufferSize(int i, Context context) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048588, this, i, context)) == null) {
            byte[] bArr = context.buffer;
            return (bArr == null || bArr.length < context.pos + i) ? resizeBuffer(context) : bArr;
        }
        return (byte[]) invokeIL.objValue;
    }

    public int getDefaultBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 8192;
        }
        return invokeV.intValue;
    }

    public long getEncodedLength(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bArr)) == null) {
            int length = bArr.length;
            int i = this.unencodedBlockSize;
            long j = (((length + i) - 1) / i) * this.encodedBlockSize;
            int i2 = this.lineLength;
            return i2 > 0 ? j + ((((i2 + j) - 1) / i2) * this.chunkSeparatorLength) : j;
        }
        return invokeL.longValue;
    }

    public boolean hasData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? context.buffer != null : invokeL.booleanValue;
    }

    public abstract boolean isInAlphabet(byte b);

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, bArr, z)) == null) {
            for (byte b : bArr) {
                if (!isInAlphabet(b) && (!z || (b != this.pad && !isWhiteSpace(b)))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public int readResults(byte[] bArr, int i, int i2, Context context) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), context})) == null) {
            if (context.buffer == null) {
                return context.eof ? -1 : 0;
            }
            int min = Math.min(available(context), i2);
            System.arraycopy(context.buffer, context.readPos, bArr, i, min);
            int i3 = context.readPos + min;
            context.readPos = i3;
            if (i3 >= context.pos) {
                context.buffer = null;
            }
            return min;
        }
        return invokeCommon.intValue;
    }

    public BaseNCodec(int i, int i2, int i3, int i4, byte b) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Byte.valueOf(b)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.PAD = PAD_DEFAULT;
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        this.lineLength = i3 > 0 && i4 > 0 ? (i3 / i2) * i2 : 0;
        this.chunkSeparatorLength = i4;
        this.pad = b;
    }

    @Override // org.apache.commons.base.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) ? (bArr == null || bArr.length == 0) ? bArr : encode(bArr, 0, bArr.length) : (byte[]) invokeL.objValue;
    }

    public boolean isInAlphabet(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? isInAlphabet(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str), true) : invokeL.booleanValue;
    }

    public byte[] decode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? decode(org.apache.commons.base.binary4util.CodecStringUtils.getBytesUtf8(str)) : (byte[]) invokeL.objValue;
    }

    public byte[] encode(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048585, this, bArr, i, i2)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            Context context = new Context();
            encode(bArr, i, i2, context);
            encode(bArr, i, -1, context);
            int i3 = context.pos - context.readPos;
            byte[] bArr2 = new byte[i3];
            readResults(bArr2, 0, i3, context);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    @Override // org.apache.commons.base.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return bArr;
            }
            Context context = new Context();
            decode(bArr, 0, bArr.length, context);
            decode(bArr, 0, -1, context);
            int i = context.pos;
            byte[] bArr2 = new byte[i];
            readResults(bArr2, 0, i, context);
            return bArr2;
        }
        return (byte[]) invokeL.objValue;
    }
}
