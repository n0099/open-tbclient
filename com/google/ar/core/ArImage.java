package com.google.ar.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class ArImage extends a.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Session f33139e;

    /* renamed from: f  reason: collision with root package name */
    public long f33140f;

    /* loaded from: classes6.dex */
    public class a extends a.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final long f33141a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33142b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArImage f33143c;

        public a(ArImage arImage, long j, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {arImage, Long.valueOf(j), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33143c = arImage;
            this.f33141a = j;
            this.f33142b = i2;
        }

        @Override // android.media.Image.Plane
        public final ByteBuffer getBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArImage arImage = this.f33143c;
                return arImage.nativeGetBuffer(arImage.f33139e.f33154a, this.f33141a, this.f33142b).asReadOnlyBuffer();
            }
            return (ByteBuffer) invokeV.objValue;
        }

        @Override // android.media.Image.Plane
        public final int getPixelStride() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArImage arImage = this.f33143c;
                int nativeGetPixelStride = arImage.nativeGetPixelStride(arImage.f33139e.f33154a, this.f33141a, this.f33142b);
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
                ArImage arImage = this.f33143c;
                int nativeGetRowStride = arImage.nativeGetRowStride(arImage.f33139e.f33154a, this.f33141a, this.f33142b);
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
    public native ByteBuffer nativeGetBuffer(long j, long j2, int i2);

    private native int nativeGetFormat(long j, long j2);

    private native int nativeGetHeight(long j, long j2);

    private native int nativeGetNumberOfPlanes(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetPixelStride(long j, long j2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetRowStride(long j, long j2, int i2);

    private native long nativeGetTimestamp(long j, long j2);

    private native int nativeGetWidth(long j, long j2);

    public static native void nativeLoadSymbols();

    @Override // android.media.Image, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            nativeClose(this.f33140f);
            this.f33140f = 0L;
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
            int nativeGetFormat = nativeGetFormat(this.f33139e.f33154a, this.f33140f);
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
            int nativeGetHeight = nativeGetHeight(this.f33139e.f33154a, this.f33140f);
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
            int nativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.f33139e.f33154a, this.f33140f);
            if (nativeGetNumberOfPlanes != -1) {
                a[] aVarArr = new a[nativeGetNumberOfPlanes];
                for (int i2 = 0; i2 < nativeGetNumberOfPlanes; i2++) {
                    aVarArr[i2] = new a(this, this.f33140f, i2);
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
            long nativeGetTimestamp = nativeGetTimestamp(this.f33139e.f33154a, this.f33140f);
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
            int nativeGetWidth = nativeGetWidth(this.f33139e.f33154a, this.f33140f);
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
