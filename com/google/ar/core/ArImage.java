package com.google.ar.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.y;
import com.baidu.tieba.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class ArImage extends y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Session a;
    public long b;

    /* loaded from: classes7.dex */
    public class a extends z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final long a;
        public final int b;
        public final /* synthetic */ ArImage c;

        public a(ArImage arImage, long j, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arImage, Long.valueOf(j), Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = arImage;
            this.a = j;
            this.b = i;
        }

        @Override // android.media.Image.Plane
        public final ByteBuffer getBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArImage arImage = this.c;
                return arImage.nativeGetBuffer(arImage.a.a, this.a, this.b).asReadOnlyBuffer();
            }
            return (ByteBuffer) invokeV.objValue;
        }

        @Override // android.media.Image.Plane
        public final int getPixelStride() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArImage arImage = this.c;
                int nativeGetPixelStride = arImage.nativeGetPixelStride(arImage.a.a, this.a, this.b);
                if (nativeGetPixelStride != -1) {
                    return nativeGetPixelStride;
                }
                throw new FatalException("Unknown error in ArImage.Plane.getPixelStride().");
            }
            return invokeV.intValue;
        }

        @Override // android.media.Image.Plane
        public final int getRowStride() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArImage arImage = this.c;
                int nativeGetRowStride = arImage.nativeGetRowStride(arImage.a.a, this.a, this.b);
                if (nativeGetRowStride != -1) {
                    return nativeGetRowStride;
                }
                throw new FatalException("Unknown error in ArImage.Plane.getRowStride().");
            }
            return invokeV.intValue;
        }
    }

    private native void nativeClose(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native ByteBuffer nativeGetBuffer(long j, long j2, int i);

    private native int nativeGetFormat(long j, long j2);

    private native int nativeGetHeight(long j, long j2);

    private native int nativeGetNumberOfPlanes(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetPixelStride(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetRowStride(long j, long j2, int i);

    private native long nativeGetTimestamp(long j, long j2);

    private native int nativeGetWidth(long j, long j2);

    public static native void nativeLoadSymbols();

    @Override // android.media.Image, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nativeClose(this.b);
            this.b = 0L;
        }
    }

    @Override // android.media.Image
    public Rect getCropRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new UnsupportedOperationException("Crop rect is unknown in this image.");
        }
        return (Rect) invokeV.objValue;
    }

    @Override // android.media.Image
    public int getFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int nativeGetFormat = nativeGetFormat(this.a.a, this.b);
            if (nativeGetFormat != -1) {
                return nativeGetFormat;
            }
            throw new FatalException("Unknown error in ArImage.getFormat().");
        }
        return invokeV.intValue;
    }

    @Override // android.media.Image
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int nativeGetHeight = nativeGetHeight(this.a.a, this.b);
            if (nativeGetHeight != -1) {
                return nativeGetHeight;
            }
            throw new FatalException("Unknown error in ArImage.getHeight().");
        }
        return invokeV.intValue;
    }

    @Override // android.media.Image
    public Image.Plane[] getPlanes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int nativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.a.a, this.b);
            if (nativeGetNumberOfPlanes != -1) {
                a[] aVarArr = new a[nativeGetNumberOfPlanes];
                for (int i = 0; i < nativeGetNumberOfPlanes; i++) {
                    aVarArr[i] = new a(this, this.b, i);
                }
                return aVarArr;
            }
            throw new FatalException("Unknown error in ArImage.getPlanes().");
        }
        return (Image.Plane[]) invokeV.objValue;
    }

    @Override // android.media.Image
    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            long nativeGetTimestamp = nativeGetTimestamp(this.a.a, this.b);
            if (nativeGetTimestamp != -1) {
                return nativeGetTimestamp;
            }
            throw new FatalException("Unknown error in ArImage.getTimestamp().");
        }
        return invokeV.longValue;
    }

    @Override // android.media.Image
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int nativeGetWidth = nativeGetWidth(this.a.a, this.b);
            if (nativeGetWidth != -1) {
                return nativeGetWidth;
            }
            throw new FatalException("Unknown error in ArImage.getWidth().");
        }
        return invokeV.intValue;
    }

    @Override // android.media.Image
    public void setCropRect(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rect) == null) {
            throw new UnsupportedOperationException("This is a read-only image.");
        }
    }

    @Override // android.media.Image
    public void setTimestamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            throw new UnsupportedOperationException("This is a read-only image.");
        }
    }
}
