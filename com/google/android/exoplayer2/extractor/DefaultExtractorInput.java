package com.google.android.exoplayer2.extractor;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes7.dex */
public final class DefaultExtractorInput implements ExtractorInput {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PEEK_MAX_FREE_SPACE = 524288;
    public static final int PEEK_MIN_FREE_SPACE_AFTER_RESIZE = 65536;
    public static final byte[] SCRATCH_SPACE;
    public transient /* synthetic */ FieldHolder $fh;
    public final DataSource dataSource;
    public byte[] peekBuffer;
    public int peekBufferLength;
    public int peekBufferPosition;
    public long position;
    public final long streamLength;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1342896131, "Lcom/google/android/exoplayer2/extractor/DefaultExtractorInput;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1342896131, "Lcom/google/android/exoplayer2/extractor/DefaultExtractorInput;");
                return;
            }
        }
        SCRATCH_SPACE = new byte[4096];
    }

    public DefaultExtractorInput(DataSource dataSource, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dataSource = dataSource;
        this.position = j2;
        this.streamLength = j3;
        this.peekBuffer = new byte[65536];
    }

    private void commitBytesRead(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || i2 == -1) {
            return;
        }
        this.position += i2;
    }

    private void ensureSpaceForPeek(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            int i3 = this.peekBufferPosition + i2;
            byte[] bArr = this.peekBuffer;
            if (i3 > bArr.length) {
                this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i3, i3 + 524288));
            }
        }
    }

    private int readFromDataSource(byte[] bArr, int i2, int i3, int i4, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            if (!Thread.interrupted()) {
                int read = this.dataSource.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    if (i4 == 0 && z) {
                        return -1;
                    }
                    throw new EOFException();
                }
                return i4 + read;
            }
            throw new InterruptedException();
        }
        return invokeCommon.intValue;
    }

    private int readFromPeekBuffer(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, this, bArr, i2, i3)) == null) {
            int i4 = this.peekBufferLength;
            if (i4 == 0) {
                return 0;
            }
            int min = Math.min(i4, i3);
            System.arraycopy(this.peekBuffer, 0, bArr, i2, min);
            updatePeekBuffer(min);
            return min;
        }
        return invokeLII.intValue;
    }

    private int skipFromPeekBuffer(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i2)) == null) {
            int min = Math.min(this.peekBufferLength, i2);
            updatePeekBuffer(min);
            return min;
        }
        return invokeI.intValue;
    }

    private void updatePeekBuffer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i2) == null) {
            int i3 = this.peekBufferLength - i2;
            this.peekBufferLength = i3;
            this.peekBufferPosition = 0;
            byte[] bArr = this.peekBuffer;
            if (i3 < bArr.length - 524288) {
                bArr = new byte[i3 + 65536];
            }
            System.arraycopy(this.peekBuffer, i2, bArr, 0, this.peekBufferLength);
            this.peekBuffer = bArr;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            ensureSpaceForPeek(i2);
            int min = Math.min(this.peekBufferLength - this.peekBufferPosition, i2);
            while (min < i2) {
                min = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i2, min, z);
                if (min == -1) {
                    return false;
                }
            }
            int i3 = this.peekBufferPosition + i2;
            this.peekBufferPosition = i3;
            this.peekBufferLength = Math.max(this.peekBufferLength, i3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.streamLength : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.position + this.peekBufferPosition : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.position : invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (advancePeekPosition(i3, z)) {
                System.arraycopy(this.peekBuffer, this.peekBufferPosition - i3, bArr, i2, i3);
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i2, i3)) == null) {
            int readFromPeekBuffer = readFromPeekBuffer(bArr, i2, i3);
            if (readFromPeekBuffer == 0) {
                readFromPeekBuffer = readFromDataSource(bArr, i2, i3, 0, true);
            }
            commitBytesRead(readFromPeekBuffer);
            return readFromPeekBuffer;
        }
        return invokeLII.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            int readFromPeekBuffer = readFromPeekBuffer(bArr, i2, i3);
            while (readFromPeekBuffer < i3 && readFromPeekBuffer != -1) {
                readFromPeekBuffer = readFromDataSource(bArr, i2, i3, readFromPeekBuffer, z);
            }
            commitBytesRead(readFromPeekBuffer);
            return readFromPeekBuffer != -1;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.peekBufferPosition = 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j2, E e2) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048587, this, j2, e2) == null) {
            Assertions.checkArgument(j2 >= 0);
            this.position = j2;
            throw e2;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i2) throws IOException, InterruptedException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            int skipFromPeekBuffer = skipFromPeekBuffer(i2);
            if (skipFromPeekBuffer == 0) {
                byte[] bArr = SCRATCH_SPACE;
                skipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(i2, bArr.length), 0, true);
            }
            commitBytesRead(skipFromPeekBuffer);
            return skipFromPeekBuffer;
        }
        return invokeI.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int skipFromPeekBuffer = skipFromPeekBuffer(i2);
            while (skipFromPeekBuffer < i2 && skipFromPeekBuffer != -1) {
                byte[] bArr = SCRATCH_SPACE;
                skipFromPeekBuffer = readFromDataSource(bArr, -skipFromPeekBuffer, Math.min(i2, bArr.length + skipFromPeekBuffer), skipFromPeekBuffer, z);
            }
            commitBytesRead(skipFromPeekBuffer);
            return skipFromPeekBuffer != -1;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i2, i3) == null) {
            peekFully(bArr, i2, i3, false);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i2, i3) == null) {
            readFully(bArr, i2, i3, false);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            advancePeekPosition(i2, false);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            skipFully(i2, false);
        }
    }
}
