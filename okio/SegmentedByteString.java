package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class SegmentedByteString extends ByteString {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient int[] directory;
    public final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Util.checkOffsetAndCount(buffer.size, 0L, i);
        Segment segment = buffer.head;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i) {
            int i7 = segment.limit;
            int i8 = segment.pos;
            if (i7 != i8) {
                i5 += i7 - i8;
                i6++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i6];
        this.directory = new int[i6 * 2];
        Segment segment2 = buffer.head;
        int i9 = 0;
        while (i4 < i) {
            this.segments[i9] = segment2.data;
            i4 += segment2.limit - segment2.pos;
            if (i4 > i) {
                i4 = i;
            }
            int[] iArr = this.directory;
            iArr[i9] = i4;
            iArr[this.segments.length + i9] = segment2.pos;
            segment2.shared = true;
            i9++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
            if (binarySearch < 0) {
                return ~binarySearch;
            }
            return binarySearch;
        }
        return invokeI.intValue;
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteString)) == null) {
            return toByteString().hmacSha1(byteString);
        }
        return (ByteString) invokeL.objValue;
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteString)) == null) {
            return toByteString().hmacSha256(byteString);
        }
        return (ByteString) invokeL.objValue;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charset)) == null) {
            return toByteString().string(charset);
        }
        return (String) invokeL.objValue;
    }

    @Override // okio.ByteString
    public ByteString substring(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            return toByteString().substring(i);
        }
        return (ByteString) invokeI.objValue;
    }

    private ByteString toByteString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            return new ByteString(toByteArray());
        }
        return (ByteString) invokeV.objValue;
    }

    private Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return toByteString();
        }
        return invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String base64() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return toByteString().base64();
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String base64Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return toByteString().base64Url();
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String hex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return toByteString().hex();
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public byte[] internalArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return toByteArray();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString md5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return toByteString().md5();
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return toByteString().sha1();
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return toByteString().sha256();
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.directory[this.segments.length - 1];
        }
        return invokeV.intValue;
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return toByteString().toAsciiLowercase();
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return toByteString().toAsciiUppercase();
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return toByteString().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String utf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return toByteString().utf8();
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ByteString) {
                ByteString byteString = (ByteString) obj;
                if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // okio.ByteString
    public byte getByte(int i) {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i, 1L);
            int segment = segment(i);
            if (segment == 0) {
                i2 = 0;
            } else {
                i2 = this.directory[segment - 1];
            }
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            return bArr[segment][(i - i2) + iArr[bArr.length + segment]];
        }
        return invokeI.byteValue;
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, outputStream) == null) {
            if (outputStream != null) {
                int length = this.segments.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int[] iArr = this.directory;
                    int i3 = iArr[length + i];
                    int i4 = iArr[i];
                    outputStream.write(this.segments[i], i3, i4 - i2);
                    i++;
                    i2 = i4;
                }
                return;
            }
            throw new IllegalArgumentException("out == null");
        }
    }

    @Override // okio.ByteString
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.hashCode;
            if (i != 0) {
                return i;
            }
            int length = this.segments.length;
            int i2 = 0;
            int i3 = 0;
            int i4 = 1;
            while (i2 < length) {
                byte[] bArr = this.segments[i2];
                int[] iArr = this.directory;
                int i5 = iArr[length + i2];
                int i6 = iArr[i2];
                int i7 = (i6 - i3) + i5;
                while (i5 < i7) {
                    i4 = (i4 * 31) + bArr[i5];
                    i5++;
                }
                i2++;
                i3 = i6;
            }
            this.hashCode = i4;
            return i4;
        }
        return invokeV.intValue;
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            byte[] bArr2 = new byte[iArr[bArr.length - 1]];
            int length = bArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr2 = this.directory;
                int i3 = iArr2[length + i];
                int i4 = iArr2[i];
                System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
                i++;
                i2 = i4;
            }
            return bArr2;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, bArr, i)) == null) {
            return toByteString().indexOf(bArr, i);
        }
        return invokeLI.intValue;
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, bArr, i)) == null) {
            return toByteString().lastIndexOf(bArr, i);
        }
        return invokeLI.intValue;
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) {
            return toByteString().substring(i, i2);
        }
        return (ByteString) invokeII.objValue;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), byteString, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i < 0 || i > size() - i3) {
                return false;
            }
            int segment = segment(i);
            while (i3 > 0) {
                if (segment == 0) {
                    i4 = 0;
                } else {
                    i4 = this.directory[segment - 1];
                }
                int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
                int[] iArr = this.directory;
                byte[][] bArr = this.segments;
                if (!byteString.rangeEquals(i2, bArr[segment], (i - i4) + iArr[bArr.length + segment], min)) {
                    return false;
                }
                i += min;
                i2 += min;
                i3 -= min;
                segment++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
                return false;
            }
            int segment = segment(i);
            while (i3 > 0) {
                if (segment == 0) {
                    i4 = 0;
                } else {
                    i4 = this.directory[segment - 1];
                }
                int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
                int[] iArr = this.directory;
                byte[][] bArr2 = this.segments;
                if (!Util.arrayRangeEquals(bArr2[segment], (i - i4) + iArr[bArr2.length + segment], bArr, i2, min)) {
                    return false;
                }
                i += min;
                i2 += min;
                i3 -= min;
                segment++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // okio.ByteString
    public void write(Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, buffer) == null) {
            int length = this.segments.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int[] iArr = this.directory;
                int i3 = iArr[length + i];
                int i4 = iArr[i];
                Segment segment = new Segment(this.segments[i], i3, (i3 + i4) - i2, true, false);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    segment.prev = segment;
                    segment.next = segment;
                    buffer.head = segment;
                } else {
                    segment2.prev.push(segment);
                }
                i++;
                i2 = i4;
            }
            buffer.size += i2;
        }
    }
}
