package com.facebook.animated.giflite.decoder;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class GifMetadataDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTROL_INDEX_DELAY = 1;
    public static final int CONTROL_INDEX_DISPOSE = 0;
    public static final int DEFAULT_FRAME_DURATION_MS = 100;
    public static final int MAX_BLOCK_SIZE = 256;
    public static final char[] NETSCAPE;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] block;
    public int mCurrentOffset;
    public boolean mDecoded;
    public final List<int[]> mFrameControls;
    public final InputStream mInputStream;
    public int mLoopCount;
    @Nullable
    public final OutputStream mOutputStream;
    public boolean shouldFixStream;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1285631365, "Lcom/facebook/animated/giflite/decoder/GifMetadataDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1285631365, "Lcom/facebook/animated/giflite/decoder/GifMetadataDecoder;");
                return;
            }
        }
        NETSCAPE = new char[]{'N', 'E', 'T', 'S', 'C', 'A', 'P', 'E', '2', IStringUtil.EXTENSION_SEPARATOR, '0'};
    }

    public GifMetadataDecoder(InputStream inputStream, @Nullable OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.block = new byte[256];
        this.mFrameControls = new ArrayList();
        this.mLoopCount = 1;
        this.mDecoded = false;
        this.mCurrentOffset = 0;
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
    }

    private void addFrame(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, iArr) == null) {
            this.mFrameControls.add(Arrays.copyOf(iArr, iArr.length));
        }
    }

    private void copyFromIsToOs(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, inputStream, outputStream, i) == null) {
            while (i > 0) {
                int read = inputStream.read(this.block, 0, Math.min(256, i));
                i -= 256;
                outputStream.write(this.block, 0, read);
            }
        }
    }

    public static GifMetadataDecoder create(InputStream inputStream, @Nullable OutputStream outputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream, outputStream)) == null) {
            GifMetadataDecoder gifMetadataDecoder = new GifMetadataDecoder(inputStream, outputStream);
            gifMetadataDecoder.decode();
            return gifMetadataDecoder;
        }
        return (GifMetadataDecoder) invokeLL.objValue;
    }

    private void ignoreColorTable(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            skipAndWriteBytes(i * 3);
        }
    }

    private void initFixedOutputStream() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, this) == null) || this.shouldFixStream || this.mOutputStream == null) {
            return;
        }
        this.shouldFixStream = true;
        this.mInputStream.reset();
        copyFromIsToOs(this.mInputStream, this.mOutputStream, this.mCurrentOffset - 2);
        this.mInputStream.skip(2L);
    }

    private boolean isNetscape() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            int length = this.block.length;
            char[] cArr = NETSCAPE;
            if (length < cArr.length) {
                return false;
            }
            int length2 = cArr.length;
            for (int i = 0; i < length2; i++) {
                if (NETSCAPE[i] != ((char) this.block[i])) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    private int readAndWriteNextByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int readNextByte = readNextByte();
            writeNextByte(readNextByte);
            return readNextByte;
        }
        return invokeV.intValue;
    }

    private int readBlock() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int readAndWriteNextByte = readAndWriteNextByte();
            int i = 0;
            if (readAndWriteNextByte > 0) {
                while (i < readAndWriteNextByte) {
                    i += readIntoBlock(i, readAndWriteNextByte - i);
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    private void readGifInfo() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            validateAndIgnoreHeader();
            int[] iArr = {0, 0};
            boolean z = false;
            while (!z) {
                int readAndWriteNextByte = readAndWriteNextByte();
                if (readAndWriteNextByte == 33) {
                    int readAndWriteNextByte2 = readAndWriteNextByte();
                    if (readAndWriteNextByte2 == 1) {
                        addFrame(iArr);
                        skipExtension();
                    } else if (readAndWriteNextByte2 == 249) {
                        readGraphicsControlExtension(iArr);
                    } else if (readAndWriteNextByte2 != 255) {
                        skipExtension();
                    } else {
                        readBlock();
                        if (isNetscape()) {
                            readNetscapeExtension();
                        } else {
                            skipExtension();
                        }
                    }
                } else if (readAndWriteNextByte == 44) {
                    addFrame(iArr);
                    skipImage();
                } else if (readAndWriteNextByte != 59) {
                    throw new IOException("Unknown block header [" + Integer.toHexString(readAndWriteNextByte) + PreferencesUtil.RIGHT_MOUNT);
                } else {
                    z = true;
                }
            }
        }
    }

    private void readGraphicsControlExtension(int[] iArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, iArr) == null) {
            skipAndWriteBytes(1);
            iArr[0] = (readAndWriteNextByte() & 28) >> 2;
            iArr[1] = readTwoByteInt() * 10;
            if (iArr[1] == 0) {
                iArr[1] = 100;
                initFixedOutputStream();
            }
            writeTwoByteInt(iArr[1] / 10);
            skipAndWriteBytes(2);
        }
    }

    private int readIntoBlock(int i, int i2) throws IOException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65548, this, i, i2)) == null) {
            int read = this.mInputStream.read(this.block, i, i2);
            this.mCurrentOffset += i2;
            if (this.shouldFixStream) {
                this.mOutputStream.write(this.block, i, i2);
            }
            if (read != -1) {
                return read;
            }
            throw new EOFException("Unexpected end of gif file");
        }
        return invokeII.intValue;
    }

    private void readNetscapeExtension() throws IOException {
        int readBlock;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            do {
                readBlock = readBlock();
                byte[] bArr = this.block;
                if (bArr[0] == 1) {
                    this.mLoopCount = (bArr[1] & 255) | ((bArr[2] & 255) << 8);
                    continue;
                }
            } while (readBlock > 0);
        }
    }

    private int readNextByte() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            int read = this.mInputStream.read();
            this.mCurrentOffset++;
            if (read != -1) {
                return read;
            }
            throw new EOFException("Unexpected end of gif file");
        }
        return invokeV.intValue;
    }

    private int readTwoByteInt() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? readNextByte() | (readNextByte() << 8) : invokeV.intValue;
    }

    private void skipAndWriteBytes(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i) == null) {
            if (this.shouldFixStream) {
                copyFromIsToOs(this.mInputStream, this.mOutputStream, i);
            } else {
                this.mInputStream.skip(i);
            }
            this.mCurrentOffset += i;
        }
    }

    private void skipExtension() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            do {
            } while (readBlock() > 0);
        }
    }

    private void skipImage() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            skipAndWriteBytes(8);
            int readAndWriteNextByte = readAndWriteNextByte();
            if ((readAndWriteNextByte & 128) != 0) {
                ignoreColorTable(2 << (readAndWriteNextByte & 7));
            }
            skipAndWriteBytes(1);
            skipExtension();
        }
    }

    private void validateAndIgnoreHeader() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            readIntoBlock(0, 6);
            byte[] bArr = this.block;
            if ('G' == ((char) bArr[0]) && 'I' == ((char) bArr[1]) && 'F' == ((char) bArr[2]) && '8' == ((char) bArr[3]) && ('7' == ((char) bArr[4]) || '9' == ((char) bArr[4])) && 'a' == ((char) this.block[5])) {
                skipAndWriteBytes(4);
                int readAndWriteNextByte = readAndWriteNextByte();
                boolean z = (readAndWriteNextByte & 128) != 0;
                int i = 2 << (readAndWriteNextByte & 7);
                skipAndWriteBytes(2);
                if (z) {
                    ignoreColorTable(i);
                    return;
                }
                return;
            }
            throw new IOException("Illegal header for gif");
        }
    }

    private void writeNextByte(int i) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65556, this, i) == null) && this.shouldFixStream) {
            this.mOutputStream.write(i);
        }
    }

    private void writeTwoByteInt(int i) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65557, this, i) == null) {
            writeNextByte(i);
            writeNextByte(i >> 8);
        }
    }

    public void decode() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.mDecoded) {
                this.mDecoded = true;
                readGifInfo();
                return;
            }
            throw new IllegalStateException("decode called multiple times");
        }
    }

    public int getFrameCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mDecoded) {
                return this.mFrameControls.size();
            }
            throw new IllegalStateException("getFrameCount called before decode");
        }
        return invokeV.intValue;
    }

    public int getFrameDisposal(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.mDecoded) {
                return this.mFrameControls.get(i)[0];
            }
            throw new IllegalStateException("getFrameDisposal called before decode");
        }
        return invokeI.intValue;
    }

    public int getFrameDurationMs(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (this.mDecoded) {
                if (i >= getFrameCount()) {
                    return 1;
                }
                return this.mFrameControls.get(i)[1];
            }
            throw new IllegalStateException("getFrameDurationMs called before decode");
        }
        return invokeI.intValue;
    }

    public int getLoopCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mDecoded) {
                return this.mLoopCount;
            }
            throw new IllegalStateException("getLoopCount called before decode");
        }
        return invokeV.intValue;
    }
}
