package org.webrtc;

import android.graphics.Matrix;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.webrtc.TextureBufferImpl;
import org.webrtc.VideoFrame;
/* loaded from: classes3.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int height;
    public final int id;
    public final RefCountDelegate refCountDelegate;
    public final Handler toI420Handler;
    public final Matrix transformMatrix;
    public final VideoFrame.TextureBuffer.Type type;
    public final int unscaledHeight;
    public final int unscaledWidth;
    public final int width;
    public final YuvConverter yuvConverter;

    public TextureBufferImpl(int i2, int i3, VideoFrame.TextureBuffer.Type type, int i4, Matrix matrix, Handler handler, YuvConverter yuvConverter, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), type, Integer.valueOf(i4), matrix, handler, yuvConverter, runnable};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.unscaledWidth = i2;
        this.unscaledHeight = i3;
        this.width = i2;
        this.height = i3;
        this.type = type;
        this.id = i4;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public /* synthetic */ VideoFrame.I420Buffer a() throws Exception {
        return this.yuvConverter.convert(this);
    }

    public TextureBufferImpl applyTransformMatrix(Matrix matrix, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix, i2, i3)) == null) ? applyTransformMatrix(matrix, i2, i3, i2, i3) : (TextureBufferImpl) invokeLII.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            Matrix matrix = new Matrix();
            int i8 = this.height;
            matrix.preTranslate(i2 / this.width, (i8 - (i3 + i5)) / i8);
            matrix.preScale(i4 / this.width, i5 / this.height);
            return applyTransformMatrix(matrix, Math.round((this.unscaledWidth * i4) / this.width), Math.round((this.unscaledHeight * i5) / this.height), i6, i7);
        }
        return (VideoFrame.Buffer) invokeCommon.objValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.height : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public int getTextureId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.id : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.transformMatrix : (Matrix) invokeV.objValue;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.type : (VideoFrame.TextureBuffer.Type) invokeV.objValue;
    }

    public int getUnscaledHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.unscaledHeight : invokeV.intValue;
    }

    public int getUnscaledWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.unscaledWidth : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.width : invokeV.intValue;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.refCountDelegate.release();
        }
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.refCountDelegate.retain();
        }
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: h.c.x
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.util.concurrent.Callable
            public final Object call() {
                InterceptResult invokeV2;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) ? TextureBufferImpl.this.a() : invokeV2.objValue;
            }
        }) : (VideoFrame.I420Buffer) invokeV.objValue;
    }

    private TextureBufferImpl applyTransformMatrix(Matrix matrix, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{matrix, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            Matrix matrix2 = new Matrix(this.transformMatrix);
            matrix2.preConcat(matrix);
            retain();
            return new TextureBufferImpl(i2, i3, i4, i5, this.type, this.id, matrix2, this.toI420Handler, this.yuvConverter, new Runnable() { // from class: h.c.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TextureBufferImpl.this.release();
                    }
                }
            });
        }
        return (TextureBufferImpl) invokeCommon.objValue;
    }

    public TextureBufferImpl(int i2, int i3, int i4, int i5, VideoFrame.TextureBuffer.Type type, int i6, Matrix matrix, Handler handler, YuvConverter yuvConverter, @Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), type, Integer.valueOf(i6), matrix, handler, yuvConverter, runnable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.unscaledWidth = i2;
        this.unscaledHeight = i3;
        this.width = i4;
        this.height = i5;
        this.type = type;
        this.id = i6;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }
}
