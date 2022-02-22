package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.HeifExifUtil;
import com.facebook.imageutils.ImageMetaData;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes3.dex */
public class EncodedImage implements Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BytesRange mBytesRange;
    @Nullable
    public ColorSpace mColorSpace;
    public int mExifOrientation;
    public int mHeight;
    public ImageFormat mImageFormat;
    @Nullable
    public final Supplier<FileInputStream> mInputStreamSupplier;
    @Nullable
    public final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
    public int mRotationAngle;
    public int mSampleSize;
    public int mStreamSize;
    public int mWidth;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
        this.mPooledByteBufferRef = closeableReference.m111clone();
        this.mInputStreamSupplier = null;
    }

    @Nullable
    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, encodedImage)) == null) {
            if (encodedImage != null) {
                return encodedImage.cloneOrNull();
            }
            return null;
        }
        return (EncodedImage) invokeL.objValue;
    }

    public static void closeSafely(@Nullable EncodedImage encodedImage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, encodedImage) == null) || encodedImage == null) {
            return;
        }
        encodedImage.close();
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, encodedImage)) == null) ? encodedImage.mRotationAngle >= 0 && encodedImage.mWidth >= 0 && encodedImage.mHeight >= 0 : invokeL.booleanValue;
    }

    private void parseMetaDataIfNeeded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (this.mWidth < 0 || this.mHeight < 0) {
                parseMetaData();
            }
        }
    }

    private ImageMetaData readImageMetaData() {
        InputStream inputStream;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65544, this)) != null) {
            return (ImageMetaData) invokeV.objValue;
        }
        try {
            inputStream = getInputStream();
            try {
                ImageMetaData decodeDimensionsAndColorSpace = BitmapUtil.decodeDimensionsAndColorSpace(inputStream);
                this.mColorSpace = decodeDimensionsAndColorSpace.getColorSpace();
                Pair<Integer, Integer> dimensions = decodeDimensionsAndColorSpace.getDimensions();
                if (dimensions != null) {
                    this.mWidth = ((Integer) dimensions.first).intValue();
                    this.mHeight = ((Integer) dimensions.second).intValue();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return decodeDimensionsAndColorSpace;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    private Pair<Integer, Integer> readWebPImageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            Pair<Integer, Integer> size = WebpUtil.getSize(getInputStream());
            if (size != null) {
                this.mWidth = ((Integer) size.first).intValue();
                this.mHeight = ((Integer) size.second).intValue();
            }
            return size;
        }
        return (Pair) invokeV.objValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CloseableReference.closeSafely(this.mPooledByteBufferRef);
        }
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, encodedImage) == null) {
            this.mImageFormat = encodedImage.getImageFormat();
            this.mWidth = encodedImage.getWidth();
            this.mHeight = encodedImage.getHeight();
            this.mRotationAngle = encodedImage.getRotationAngle();
            this.mExifOrientation = encodedImage.getExifOrientation();
            this.mSampleSize = encodedImage.getSampleSize();
            this.mStreamSize = encodedImage.getSize();
            this.mBytesRange = encodedImage.getBytesRange();
            this.mColorSpace = encodedImage.getColorSpace();
        }
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? CloseableReference.cloneOrNull(this.mPooledByteBufferRef) : (CloseableReference) invokeV.objValue;
    }

    @Nullable
    public BytesRange getBytesRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mBytesRange : (BytesRange) invokeV.objValue;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            parseMetaDataIfNeeded();
            return this.mColorSpace;
        }
        return (ColorSpace) invokeV.objValue;
    }

    public int getExifOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            parseMetaDataIfNeeded();
            return this.mExifOrientation;
        }
        return invokeV.intValue;
    }

    public String getFirstBytesAsHexString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = getByteBufferRef();
            if (byteBufferRef == null) {
                return "";
            }
            int min = Math.min(getSize(), i2);
            byte[] bArr = new byte[min];
            try {
                PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                if (pooledByteBuffer == null) {
                    return "";
                }
                pooledByteBuffer.read(0, bArr, 0, min);
                byteBufferRef.close();
                StringBuilder sb = new StringBuilder(min * 2);
                for (int i3 = 0; i3 < min; i3++) {
                    sb.append(String.format("%02X", Byte.valueOf(bArr[i3])));
                }
                return sb.toString();
            } finally {
                byteBufferRef.close();
            }
        }
        return (String) invokeI.objValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            parseMetaDataIfNeeded();
            return this.mHeight;
        }
        return invokeV.intValue;
    }

    public ImageFormat getImageFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            parseMetaDataIfNeeded();
            return this.mImageFormat;
        }
        return (ImageFormat) invokeV.objValue;
    }

    @Nullable
    public InputStream getInputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
            if (supplier != null) {
                return supplier.get();
            }
            CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
            if (cloneOrNull != null) {
                try {
                    return new PooledByteBufferInputStream((PooledByteBuffer) cloneOrNull.get());
                } finally {
                    CloseableReference.closeSafely(cloneOrNull);
                }
            }
            return null;
        }
        return (InputStream) invokeV.objValue;
    }

    public int getRotationAngle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            parseMetaDataIfNeeded();
            return this.mRotationAngle;
        }
        return invokeV.intValue;
    }

    public int getSampleSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSampleSize : invokeV.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
            if (closeableReference != null && closeableReference.get() != null) {
                return this.mPooledByteBufferRef.get().size();
            }
            return this.mStreamSize;
        }
        return invokeV.intValue;
    }

    @VisibleForTesting
    @Nullable
    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        InterceptResult invokeV;
        SharedReference<PooledByteBuffer> underlyingReferenceTestOnly;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            synchronized (this) {
                underlyingReferenceTestOnly = this.mPooledByteBufferRef != null ? this.mPooledByteBufferRef.getUnderlyingReferenceTestOnly() : null;
            }
            return underlyingReferenceTestOnly;
        }
        return (SharedReference) invokeV.objValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            parseMetaDataIfNeeded();
            return this.mWidth;
        }
        return invokeV.intValue;
    }

    public boolean isCompleteAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (this.mImageFormat == DefaultImageFormats.JPEG && this.mInputStreamSupplier == null) {
                Preconditions.checkNotNull(this.mPooledByteBufferRef);
                PooledByteBuffer pooledByteBuffer = this.mPooledByteBufferRef.get();
                return pooledByteBuffer.read(i2 + (-2)) == -1 && pooledByteBuffer.read(i2 - 1) == -39;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public synchronized boolean isValid() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                if (!CloseableReference.isValid(this.mPooledByteBufferRef)) {
                    z = this.mInputStreamSupplier != null;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public void parseMetaData() {
        Pair<Integer, Integer> dimensions;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
            this.mImageFormat = imageFormat_WrapIOException;
            if (DefaultImageFormats.isWebpFormat(imageFormat_WrapIOException)) {
                dimensions = readWebPImageSize();
            } else {
                dimensions = readImageMetaData().getDimensions();
            }
            if (imageFormat_WrapIOException == DefaultImageFormats.JPEG && this.mRotationAngle == -1) {
                if (dimensions != null) {
                    int orientation = JfifUtil.getOrientation(getInputStream());
                    this.mExifOrientation = orientation;
                    this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation);
                }
            } else if (imageFormat_WrapIOException == DefaultImageFormats.HEIF && this.mRotationAngle == -1) {
                int orientation2 = HeifExifUtil.getOrientation(getInputStream());
                this.mExifOrientation = orientation2;
                this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation2);
            } else {
                this.mRotationAngle = 0;
            }
        }
    }

    public void setBytesRange(@Nullable BytesRange bytesRange) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bytesRange) == null) {
            this.mBytesRange = bytesRange;
        }
    }

    public void setExifOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mExifOrientation = i2;
        }
    }

    public void setHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mHeight = i2;
        }
    }

    public void setImageFormat(ImageFormat imageFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, imageFormat) == null) {
            this.mImageFormat = imageFormat;
        }
    }

    public void setRotationAngle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mRotationAngle = i2;
        }
    }

    public void setSampleSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mSampleSize = i2;
        }
    }

    public void setStreamSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mStreamSize = i2;
        }
    }

    public void setWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mWidth = i2;
        }
    }

    public static boolean isValid(@Nullable EncodedImage encodedImage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, encodedImage)) == null) ? encodedImage != null && encodedImage.isValid() : invokeL.booleanValue;
    }

    @Nullable
    public EncodedImage cloneOrNull() {
        InterceptResult invokeV;
        EncodedImage encodedImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
            if (supplier != null) {
                encodedImage = new EncodedImage(supplier, this.mStreamSize);
            } else {
                CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
                if (cloneOrNull == null) {
                    encodedImage = null;
                } else {
                    try {
                        encodedImage = new EncodedImage(cloneOrNull);
                    } finally {
                        CloseableReference.closeSafely(cloneOrNull);
                    }
                }
            }
            if (encodedImage != null) {
                encodedImage.copyMetaDataFrom(this);
            }
            return encodedImage;
        }
        return (EncodedImage) invokeV.objValue;
    }

    public EncodedImage(Supplier<FileInputStream> supplier) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {supplier};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        Preconditions.checkNotNull(supplier);
        this.mPooledByteBufferRef = null;
        this.mInputStreamSupplier = supplier;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EncodedImage(Supplier<FileInputStream> supplier, int i2) {
        this(supplier);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {supplier, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                this((Supplier) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStreamSize = i2;
    }
}
