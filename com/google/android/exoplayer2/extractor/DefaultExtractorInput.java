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

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.streamLength;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.position + this.peekBufferPosition;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.position;
        }
        return invokeV.longValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void resetPeekPosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.peekBufferPosition = 0;
        }
    }

    public DefaultExtractorInput(DataSource dataSource, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataSource, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dataSource = dataSource;
        this.position = j;
        this.streamLength = j2;
        this.peekBuffer = new byte[65536];
    }

    private void commitBytesRead(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, this, i) == null) && i != -1) {
            this.position += i;
        }
    }

    private void ensureSpaceForPeek(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            int i2 = this.peekBufferPosition + i;
            byte[] bArr = this.peekBuffer;
            if (i2 > bArr.length) {
                this.peekBuffer = Arrays.copyOf(this.peekBuffer, Util.constrainValue(bArr.length * 2, 65536 + i2, i2 + 524288));
            }
        }
    }

    private int skipFromPeekBuffer(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, this, i)) == null) {
            int min = Math.min(this.peekBufferLength, i);
            updatePeekBuffer(min);
            return min;
        }
        return invokeI.intValue;
    }

    private void updatePeekBuffer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
            int i2 = this.peekBufferLength - i;
            this.peekBufferLength = i2;
            this.peekBufferPosition = 0;
            byte[] bArr = this.peekBuffer;
            if (i2 < bArr.length - 524288) {
                bArr = new byte[i2 + 65536];
            }
            System.arraycopy(this.peekBuffer, i, bArr, 0, this.peekBufferLength);
            this.peekBuffer = bArr;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void advancePeekPosition(int i) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            advancePeekPosition(i, false);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int skip(int i) throws IOException, InterruptedException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            int skipFromPeekBuffer = skipFromPeekBuffer(i);
            if (skipFromPeekBuffer == 0) {
                byte[] bArr = SCRATCH_SPACE;
                skipFromPeekBuffer = readFromDataSource(bArr, 0, Math.min(i, bArr.length), 0, true);
            }
            commitBytesRead(skipFromPeekBuffer);
            return skipFromPeekBuffer;
        }
        return invokeI.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void skipFully(int i) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            skipFully(i, false);
        }
    }

    private int readFromDataSource(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            if (!Thread.interrupted()) {
                int read = this.dataSource.read(bArr, i + i3, i2 - i3);
                if (read == -1) {
                    if (i3 == 0 && z) {
                        return -1;
                    }
                    throw new EOFException();
                }
                return i3 + read;
            }
            throw new InterruptedException();
        }
        return invokeCommon.intValue;
    }

    private int readFromPeekBuffer(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, this, bArr, i, i2)) == null) {
            int i3 = this.peekBufferLength;
            if (i3 == 0) {
                return 0;
            }
            int min = Math.min(i3, i2);
            System.arraycopy(this.peekBuffer, 0, bArr, i, min);
            updatePeekBuffer(min);
            return min;
        }
        return invokeLII.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void peekFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, bArr, i, i2) == null) {
            peekFully(bArr, i, i2, false);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, bArr, i, i2)) == null) {
            int readFromPeekBuffer = readFromPeekBuffer(bArr, i, i2);
            if (readFromPeekBuffer == 0) {
                readFromPeekBuffer = readFromDataSource(bArr, i, i2, 0, true);
            }
            commitBytesRead(readFromPeekBuffer);
            return readFromPeekBuffer;
        }
        return invokeLII.intValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i, i2) == null) {
            readFully(bArr, i, i2, false);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean advancePeekPosition(int i, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            ensureSpaceForPeek(i);
            int min = Math.min(this.peekBufferLength - this.peekBufferPosition, i);
            while (min < i) {
                min = readFromDataSource(this.peekBuffer, this.peekBufferPosition, i, min, z);
                if (min == -1) {
                    return false;
                }
            }
            int i2 = this.peekBufferPosition + i;
            this.peekBufferPosition = i2;
            this.peekBufferLength = Math.max(this.peekBufferLength, i2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean skipFully(int i, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            int skipFromPeekBuffer = skipFromPeekBuffer(i);
            while (skipFromPeekBuffer < i && skipFromPeekBuffer != -1) {
                byte[] bArr = SCRATCH_SPACE;
                skipFromPeekBuffer = readFromDataSource(bArr, -skipFromPeekBuffer, Math.min(i, bArr.length + skipFromPeekBuffer), skipFromPeekBuffer, z);
            }
            commitBytesRead(skipFromPeekBuffer);
            if (skipFromPeekBuffer != -1) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean peekFully(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (!advancePeekPosition(i2, z)) {
                return false;
            }
            System.arraycopy(this.peekBuffer, this.peekBufferPosition - i2, bArr, i, i2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public boolean readFully(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            int readFromPeekBuffer = readFromPeekBuffer(bArr, i, i2);
            while (readFromPeekBuffer < i2 && readFromPeekBuffer != -1) {
                readFromPeekBuffer = readFromDataSource(bArr, i, i2, readFromPeekBuffer, z);
            }
            commitBytesRead(readFromPeekBuffer);
            if (readFromPeekBuffer != -1) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorInput
    public void setRetryPosition(long j, Throwable th) throws Throwable {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048587, this, j, th) == null) {
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Assertions.checkArgument(z);
            this.position = j;
            throw th;
        }
    }
}
