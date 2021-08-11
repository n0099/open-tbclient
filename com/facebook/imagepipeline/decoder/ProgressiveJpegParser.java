package com.facebook.imagepipeline.decoder;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.common.util.StreamUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class ProgressiveJpegParser {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 16384;
    public static final int NOT_A_JPEG = 6;
    public static final int READ_FIRST_JPEG_BYTE = 0;
    public static final int READ_MARKER_FIRST_BYTE_OR_ENTROPY_DATA = 2;
    public static final int READ_MARKER_SECOND_BYTE = 3;
    public static final int READ_SECOND_JPEG_BYTE = 1;
    public static final int READ_SIZE_FIRST_BYTE = 4;
    public static final int READ_SIZE_SECOND_BYTE = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBestScanEndOffset;
    public int mBestScanNumber;
    public final ByteArrayPool mByteArrayPool;
    public int mBytesParsed;
    public boolean mEndMarkerRead;
    public int mLastByteRead;
    public int mNextFullScanNumber;
    public int mParserState;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteArrayPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mByteArrayPool = (ByteArrayPool) Preconditions.checkNotNull(byteArrayPool);
        this.mBytesParsed = 0;
        this.mLastByteRead = 0;
        this.mNextFullScanNumber = 0;
        this.mBestScanEndOffset = 0;
        this.mBestScanNumber = 0;
        this.mParserState = 0;
    }

    private boolean doParseMoreData(InputStream inputStream) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, inputStream)) == null) {
            int i2 = this.mBestScanNumber;
            while (this.mParserState != 6 && (read = inputStream.read()) != -1) {
                try {
                    int i3 = this.mBytesParsed + 1;
                    this.mBytesParsed = i3;
                    if (this.mEndMarkerRead) {
                        this.mParserState = 6;
                        this.mEndMarkerRead = false;
                        return false;
                    }
                    int i4 = this.mParserState;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                if (i4 != 3) {
                                    if (i4 == 4) {
                                        this.mParserState = 5;
                                    } else if (i4 != 5) {
                                        Preconditions.checkState(false);
                                    } else {
                                        int i5 = ((this.mLastByteRead << 8) + read) - 2;
                                        StreamUtil.skip(inputStream, i5);
                                        this.mBytesParsed += i5;
                                        this.mParserState = 2;
                                    }
                                } else if (read == 255) {
                                    this.mParserState = 3;
                                } else if (read == 0) {
                                    this.mParserState = 2;
                                } else if (read == 217) {
                                    this.mEndMarkerRead = true;
                                    newScanOrImageEndFound(i3 - 2);
                                    this.mParserState = 2;
                                } else {
                                    if (read == 218) {
                                        newScanOrImageEndFound(i3 - 2);
                                    }
                                    if (doesMarkerStartSegment(read)) {
                                        this.mParserState = 4;
                                    } else {
                                        this.mParserState = 2;
                                    }
                                }
                            } else if (read == 255) {
                                this.mParserState = 3;
                            }
                        } else if (read == 216) {
                            this.mParserState = 2;
                        } else {
                            this.mParserState = 6;
                        }
                    } else if (read == 255) {
                        this.mParserState = 1;
                    } else {
                        this.mParserState = 6;
                    }
                    this.mLastByteRead = read;
                } catch (IOException e2) {
                    Throwables.propagate(e2);
                }
            }
            return (this.mParserState == 6 || this.mBestScanNumber == i2) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean doesMarkerStartSegment(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 == 1) {
                return false;
            }
            return ((i2 >= 208 && i2 <= 215) || i2 == 217 || i2 == 216) ? false : true;
        }
        return invokeI.booleanValue;
    }

    private void newScanOrImageEndFound(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            if (this.mNextFullScanNumber > 0) {
                this.mBestScanEndOffset = i2;
            }
            int i3 = this.mNextFullScanNumber;
            this.mNextFullScanNumber = i3 + 1;
            this.mBestScanNumber = i3;
        }
    }

    public int getBestScanEndOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBestScanEndOffset : invokeV.intValue;
    }

    public int getBestScanNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBestScanNumber : invokeV.intValue;
    }

    public boolean isEndMarkerRead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEndMarkerRead : invokeV.booleanValue;
    }

    public boolean isJpeg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBytesParsed > 1 && this.mParserState != 6 : invokeV.booleanValue;
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, encodedImage)) == null) {
            if (this.mParserState != 6 && encodedImage.getSize() > this.mBytesParsed) {
                PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), this.mByteArrayPool.get(16384), this.mByteArrayPool);
                try {
                    StreamUtil.skip(pooledByteArrayBufferedInputStream, this.mBytesParsed);
                    return doParseMoreData(pooledByteArrayBufferedInputStream);
                } catch (IOException e2) {
                    Throwables.propagate(e2);
                    return false;
                } finally {
                    Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
