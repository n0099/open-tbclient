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
/* loaded from: classes10.dex */
public final class SegmentedByteString extends ByteString {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient int[] directory;
    public final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(Buffer buffer, int i2) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {buffer, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((byte[]) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Util.checkOffsetAndCount(buffer.size, 0L, i2);
        Segment segment = buffer.head;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2) {
            int i8 = segment.limit;
            int i9 = segment.pos;
            if (i8 != i9) {
                i6 += i8 - i9;
                i7++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.segments = new byte[i7];
        this.directory = new int[i7 * 2];
        Segment segment2 = buffer.head;
        int i10 = 0;
        while (i5 < i2) {
            this.segments[i10] = segment2.data;
            i5 += segment2.limit - segment2.pos;
            if (i5 > i2) {
                i5 = i2;
            }
            int[] iArr = this.directory;
            iArr[i10] = i5;
            iArr[this.segments.length + i10] = segment2.pos;
            segment2.shared = true;
            i10++;
            segment2 = segment2.next;
        }
    }

    private int segment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i2 + 1);
            return binarySearch >= 0 ? binarySearch : ~binarySearch;
        }
        return invokeI.intValue;
    }

    private ByteString toByteString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? new ByteString(toByteArray()) : (ByteString) invokeV.objValue;
    }

    private Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? toByteString() : invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer() : (ByteBuffer) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String base64() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? toByteString().base64() : (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String base64Url() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? toByteString().base64Url() : (String) invokeV.objValue;
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
    public byte getByte(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Util.checkOffsetAndCount(this.directory[this.segments.length - 1], i2, 1L);
            int segment = segment(i2);
            int i3 = segment == 0 ? 0 : this.directory[segment - 1];
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            return bArr[segment][(i2 - i3) + iArr[bArr.length + segment]];
        }
        return invokeI.byteValue;
    }

    @Override // okio.ByteString
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.hashCode;
            if (i2 != 0) {
                return i2;
            }
            int length = this.segments.length;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i3 < length) {
                byte[] bArr = this.segments[i3];
                int[] iArr = this.directory;
                int i6 = iArr[length + i3];
                int i7 = iArr[i3];
                int i8 = (i7 - i4) + i6;
                while (i6 < i8) {
                    i5 = (i5 * 31) + bArr[i6];
                    i6++;
                }
                i3++;
                i4 = i7;
            }
            this.hashCode = i5;
            return i5;
        }
        return invokeV.intValue;
    }

    @Override // okio.ByteString
    public String hex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? toByteString().hex() : (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString hmacSha1(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, byteString)) == null) ? toByteString().hmacSha1(byteString) : (ByteString) invokeL.objValue;
    }

    @Override // okio.ByteString
    public ByteString hmacSha256(ByteString byteString) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteString)) == null) ? toByteString().hmacSha256(byteString) : (ByteString) invokeL.objValue;
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, bArr, i2)) == null) ? toByteString().indexOf(bArr, i2) : invokeLI.intValue;
    }

    @Override // okio.ByteString
    public byte[] internalArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? toByteArray() : (byte[]) invokeV.objValue;
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, bArr, i2)) == null) ? toByteString().lastIndexOf(bArr, i2) : invokeLI.intValue;
    }

    @Override // okio.ByteString
    public ByteString md5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? toByteString().md5() : (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i2, ByteString byteString, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), byteString, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 < 0 || i2 > size() - i4) {
                return false;
            }
            int segment = segment(i2);
            while (i4 > 0) {
                int i5 = segment == 0 ? 0 : this.directory[segment - 1];
                int min = Math.min(i4, ((this.directory[segment] - i5) + i5) - i2);
                int[] iArr = this.directory;
                byte[][] bArr = this.segments;
                if (!byteString.rangeEquals(i3, bArr[segment], (i2 - i5) + iArr[bArr.length + segment], min)) {
                    return false;
                }
                i2 += min;
                i3 += min;
                i4 -= min;
                segment++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // okio.ByteString
    public ByteString sha1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? toByteString().sha1() : (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString sha256() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? toByteString().sha256() : (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.directory[this.segments.length - 1] : invokeV.intValue;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, charset)) == null) ? toByteString().string(charset) : (String) invokeL.objValue;
    }

    @Override // okio.ByteString
    public ByteString substring(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? toByteString().substring(i2) : (ByteString) invokeI.objValue;
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? toByteString().toAsciiLowercase() : (ByteString) invokeV.objValue;
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? toByteString().toAsciiUppercase() : (ByteString) invokeV.objValue;
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
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr2 = this.directory;
                int i4 = iArr2[length + i2];
                int i5 = iArr2[i2];
                System.arraycopy(this.segments[i2], i4, bArr2, i3, i5 - i3);
                i2++;
                i3 = i5;
            }
            return bArr2;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? toByteString().toString() : (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public String utf8() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? toByteString().utf8() : (String) invokeV.objValue;
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, outputStream) == null) {
            if (outputStream != null) {
                int length = this.segments.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    int[] iArr = this.directory;
                    int i4 = iArr[length + i2];
                    int i5 = iArr[i2];
                    outputStream.write(this.segments[i2], i4, i5 - i3);
                    i2++;
                    i3 = i5;
                }
                return;
            }
            throw new IllegalArgumentException("out == null");
        }
    }

    @Override // okio.ByteString
    public ByteString substring(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) ? toByteString().substring(i2, i3) : (ByteString) invokeII.objValue;
    }

    @Override // okio.ByteString
    public void write(Buffer buffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, buffer) == null) {
            int length = this.segments.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int[] iArr = this.directory;
                int i4 = iArr[length + i2];
                int i5 = iArr[i2];
                Segment segment = new Segment(this.segments[i2], i4, (i4 + i5) - i3, true, false);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    segment.prev = segment;
                    segment.next = segment;
                    buffer.head = segment;
                } else {
                    segment2.prev.push(segment);
                }
                i2++;
                i3 = i5;
            }
            buffer.size += i3;
        }
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
                return false;
            }
            int segment = segment(i2);
            while (i4 > 0) {
                int i5 = segment == 0 ? 0 : this.directory[segment - 1];
                int min = Math.min(i4, ((this.directory[segment] - i5) + i5) - i2);
                int[] iArr = this.directory;
                byte[][] bArr2 = this.segments;
                if (!Util.arrayRangeEquals(bArr2[segment], (i2 - i5) + iArr[bArr2.length + segment], bArr, i3, min)) {
                    return false;
                }
                i2 += min;
                i3 += min;
                i4 -= min;
                segment++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
