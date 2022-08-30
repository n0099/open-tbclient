package com.facebook.imageformat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.imageformat.ImageFormat;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImageFormatChecker {
    public static /* synthetic */ Interceptable $ic;
    public static ImageFormatChecker sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
    public final ImageFormat.FormatChecker mDefaultFormatChecker;
    public int mMaxHeaderLength;

    public ImageFormatChecker() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDefaultFormatChecker = new DefaultImageFormatChecker();
        updateMaxHeaderLength();
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) ? getInstance().determineImageFormat(inputStream) : (ImageFormat) invokeL.objValue;
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            try {
                return getImageFormat(inputStream);
            } catch (IOException e) {
                throw Throwables.propagate(e);
            }
        }
        return (ImageFormat) invokeL.objValue;
    }

    public static synchronized ImageFormatChecker getInstance() {
        InterceptResult invokeV;
        ImageFormatChecker imageFormatChecker;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (ImageFormatChecker.class) {
                if (sInstance == null) {
                    sInstance = new ImageFormatChecker();
                }
                imageFormatChecker = sInstance;
            }
            return imageFormatChecker;
        }
        return (ImageFormatChecker) invokeV.objValue;
    }

    public static int readHeaderFromStream(int i, InputStream inputStream, byte[] bArr) throws IOException {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65541, null, i, inputStream, bArr)) == null) {
            Preconditions.checkNotNull(inputStream);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkArgument(bArr.length >= i);
            if (inputStream.markSupported()) {
                try {
                    inputStream.mark(i);
                    return ByteStreams.read(inputStream, bArr, 0, i);
                } finally {
                    inputStream.reset();
                }
            }
            return ByteStreams.read(inputStream, bArr, 0, i);
        }
        return invokeILL.intValue;
    }

    private void updateMaxHeaderLength() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
            List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
            if (list != null) {
                for (ImageFormat.FormatChecker formatChecker : list) {
                    this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, formatChecker.getHeaderSize());
                }
            }
        }
    }

    public ImageFormat determineImageFormat(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) {
            Preconditions.checkNotNull(inputStream);
            int i = this.mMaxHeaderLength;
            byte[] bArr = new byte[i];
            int readHeaderFromStream = readHeaderFromStream(i, inputStream, bArr);
            ImageFormat determineFormat = this.mDefaultFormatChecker.determineFormat(bArr, readHeaderFromStream);
            if (determineFormat == null || determineFormat == ImageFormat.UNKNOWN) {
                List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
                if (list != null) {
                    for (ImageFormat.FormatChecker formatChecker : list) {
                        ImageFormat determineFormat2 = formatChecker.determineFormat(bArr, readHeaderFromStream);
                        if (determineFormat2 != null && determineFormat2 != ImageFormat.UNKNOWN) {
                            return determineFormat2;
                        }
                    }
                }
                return ImageFormat.UNKNOWN;
            }
            return determineFormat;
        }
        return (ImageFormat) invokeL.objValue;
    }

    public void setCustomImageFormatCheckers(@Nullable List<ImageFormat.FormatChecker> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.mCustomImageFormatCheckers = list;
            updateMaxHeaderLength();
        }
    }

    public static ImageFormat getImageFormat(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageFormat imageFormat = getImageFormat(fileInputStream);
                Closeables.closeQuietly(fileInputStream);
                return imageFormat;
            } catch (IOException unused2) {
                fileInputStream2 = fileInputStream;
                ImageFormat imageFormat2 = ImageFormat.UNKNOWN;
                Closeables.closeQuietly(fileInputStream2);
                return imageFormat2;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                Closeables.closeQuietly(fileInputStream2);
                throw th;
            }
        }
        return (ImageFormat) invokeL.objValue;
    }
}
