package org.webrtc;

import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.GLES20;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import org.webrtc.RendererCommon;
import org.webrtc.VideoFrame;
/* loaded from: classes2.dex */
public class VideoFrameDrawer {
    public static /* synthetic */ Interceptable $ic;
    public static final float[] srcPoints;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] dstPoints;
    @Nullable
    public VideoFrame lastI420Frame;
    public int renderHeight;
    public final Matrix renderMatrix;
    public final Point renderSize;
    public int renderWidth;
    public final YuvUploader yuvUploader;

    /* renamed from: org.webrtc.VideoFrameDrawer$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2012539936, "Lorg/webrtc/VideoFrameDrawer$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2012539936, "Lorg/webrtc/VideoFrameDrawer$1;");
                    return;
                }
            }
            int[] iArr = new int[VideoFrame.TextureBuffer.Type.values().length];
            $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type = iArr;
            try {
                iArr[VideoFrame.TextureBuffer.Type.OES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[VideoFrame.TextureBuffer.Type.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class YuvUploader {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public ByteBuffer copyBuffer;
        @Nullable
        public int[] yuvTextures;

        public YuvUploader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ YuvUploader(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Nullable
        public int[] getYuvTextures() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.yuvTextures : (int[]) invokeV.objValue;
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.copyBuffer = null;
                int[] iArr = this.yuvTextures;
                if (iArr != null) {
                    GLES20.glDeleteTextures(3, iArr, 0);
                    this.yuvTextures = null;
                }
            }
        }

        @Nullable
        public int[] uploadFromBuffer(VideoFrame.I420Buffer i420Buffer) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, i420Buffer)) == null) ? uploadYuvData(i420Buffer.getWidth(), i420Buffer.getHeight(), new int[]{i420Buffer.getStrideY(), i420Buffer.getStrideU(), i420Buffer.getStrideV()}, new ByteBuffer[]{i420Buffer.getDataY(), i420Buffer.getDataU(), i420Buffer.getDataV()}) : (int[]) invokeL.objValue;
        }

        @Nullable
        public int[] uploadYuvData(int i2, int i3, int[] iArr, ByteBuffer[] byteBufferArr) {
            InterceptResult invokeCommon;
            ByteBuffer byteBuffer;
            ByteBuffer byteBuffer2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, byteBufferArr})) == null) {
                int i4 = i2 / 2;
                int[] iArr2 = {i2, i4, i4};
                int i5 = i3 / 2;
                int[] iArr3 = {i3, i5, i5};
                int i6 = 0;
                for (int i7 = 0; i7 < 3; i7++) {
                    if (iArr[i7] > iArr2[i7]) {
                        i6 = Math.max(i6, iArr2[i7] * iArr3[i7]);
                    }
                }
                if (i6 > 0 && ((byteBuffer2 = this.copyBuffer) == null || byteBuffer2.capacity() < i6)) {
                    this.copyBuffer = ByteBuffer.allocateDirect(i6);
                }
                if (this.yuvTextures == null) {
                    this.yuvTextures = new int[3];
                    for (int i8 = 0; i8 < 3; i8++) {
                        this.yuvTextures[i8] = GlUtil.generateTexture(3553);
                    }
                }
                for (int i9 = 0; i9 < 3; i9++) {
                    GLES20.glActiveTexture(33984 + i9);
                    GLES20.glBindTexture(3553, this.yuvTextures[i9]);
                    if (iArr[i9] == iArr2[i9]) {
                        byteBuffer = byteBufferArr[i9];
                    } else {
                        YuvHelper.copyPlane(byteBufferArr[i9], iArr[i9], this.copyBuffer, iArr2[i9], iArr2[i9], iArr3[i9]);
                        byteBuffer = this.copyBuffer;
                    }
                    GLES20.glTexImage2D(3553, 0, 6409, iArr2[i9], iArr3[i9], 0, 6409, 5121, byteBuffer);
                }
                return this.yuvTextures;
            }
            return (int[]) invokeCommon.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2076115789, "Lorg/webrtc/VideoFrameDrawer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2076115789, "Lorg/webrtc/VideoFrameDrawer;");
                return;
            }
        }
        srcPoints = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
    }

    public VideoFrameDrawer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dstPoints = new float[6];
        this.renderSize = new Point();
        this.yuvUploader = new YuvUploader(null);
        this.renderMatrix = new Matrix();
    }

    private void calculateTransformedRenderSize(int i2, int i3, @Nullable Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65538, this, i2, i3, matrix) == null) {
            if (matrix == null) {
                this.renderWidth = i2;
                this.renderHeight = i3;
                return;
            }
            matrix.mapPoints(this.dstPoints, srcPoints);
            for (int i4 = 0; i4 < 3; i4++) {
                float[] fArr = this.dstPoints;
                int i5 = i4 * 2;
                int i6 = i5 + 0;
                fArr[i6] = fArr[i6] * i2;
                int i7 = i5 + 1;
                fArr[i7] = fArr[i7] * i3;
            }
            float[] fArr2 = this.dstPoints;
            this.renderWidth = distance(fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
            float[] fArr3 = this.dstPoints;
            this.renderHeight = distance(fArr3[0], fArr3[1], fArr3[4], fArr3[5]);
        }
    }

    public static int distance(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (int) Math.round(Math.hypot(f4 - f2, f5 - f3)) : invokeCommon.intValue;
    }

    public static void drawTexture(RendererCommon.GlDrawer glDrawer, VideoFrame.TextureBuffer textureBuffer, Matrix matrix, int i2, int i3, int i4, int i5, int i6, int i7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{glDrawer, textureBuffer, matrix, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)}) == null) {
            Matrix matrix2 = new Matrix(textureBuffer.getTransformMatrix());
            matrix2.preConcat(matrix);
            float[] convertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(matrix2);
            int i8 = AnonymousClass1.$SwitchMap$org$webrtc$VideoFrame$TextureBuffer$Type[textureBuffer.getType().ordinal()];
            if (i8 == 1) {
                glDrawer.drawOes(textureBuffer.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, i2, i3, i4, i5, i6, i7);
            } else if (i8 != 2) {
                throw new RuntimeException("Unknown texture type.");
            } else {
                glDrawer.drawRgb(textureBuffer.getTextureId(), convertMatrixFromAndroidGraphicsMatrix, i2, i3, i4, i5, i6, i7);
            }
        }
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon.GlDrawer glDrawer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, videoFrame, glDrawer) == null) {
            drawFrame(videoFrame, glDrawer, null);
        }
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon.GlDrawer glDrawer, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoFrame, glDrawer, matrix) == null) {
            drawFrame(videoFrame, glDrawer, matrix, 0, 0, videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight());
        }
    }

    public void drawFrame(VideoFrame videoFrame, RendererCommon.GlDrawer glDrawer, @Nullable Matrix matrix, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{videoFrame, glDrawer, matrix, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            calculateTransformedRenderSize(videoFrame.getRotatedWidth(), videoFrame.getRotatedHeight(), matrix);
            boolean z = videoFrame.getBuffer() instanceof VideoFrame.TextureBuffer;
            this.renderMatrix.reset();
            this.renderMatrix.preTranslate(0.5f, 0.5f);
            if (!z) {
                this.renderMatrix.preScale(1.0f, -1.0f);
            }
            this.renderMatrix.preRotate(videoFrame.getRotation());
            this.renderMatrix.preTranslate(-0.5f, -0.5f);
            if (matrix != null) {
                this.renderMatrix.preConcat(matrix);
            }
            if (z) {
                this.lastI420Frame = null;
                drawTexture(glDrawer, (VideoFrame.TextureBuffer) videoFrame.getBuffer(), this.renderMatrix, this.renderWidth, this.renderHeight, i2, i3, i4, i5);
                return;
            }
            if (videoFrame != this.lastI420Frame) {
                this.lastI420Frame = videoFrame;
                VideoFrame.I420Buffer i420 = videoFrame.getBuffer().toI420();
                this.yuvUploader.uploadFromBuffer(i420);
                i420.release();
            }
            glDrawer.drawYuv(this.yuvUploader.getYuvTextures(), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.renderMatrix), this.renderWidth, this.renderHeight, i2, i3, i4, i5);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.yuvUploader.release();
            this.lastI420Frame = null;
        }
    }
}
