package org.webrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
import java.nio.ByteBuffer;
import org.webrtc.GlGenericDrawer;
import org.webrtc.JniCommon;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;
/* loaded from: classes4.dex */
public class YuvConverter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    public transient /* synthetic */ FieldHolder $fh;
    public final GlGenericDrawer drawer;
    public final GlTextureFrameBuffer i420TextureFrameBuffer;
    public final ShaderCallbacks shaderCallbacks;
    public final ThreadUtils.ThreadChecker threadChecker;

    /* renamed from: org.webrtc.YuvConverter$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public static final float[] uCoeffs;
        public static final float[] vCoeffs;
        public static final float[] yCoeffs;
        public transient /* synthetic */ FieldHolder $fh;
        public float[] coeffs;
        public int coeffsLoc;
        public float stepSize;
        public int xUnitLoc;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(916712069, "Lorg/webrtc/YuvConverter$ShaderCallbacks;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(916712069, "Lorg/webrtc/YuvConverter$ShaderCallbacks;");
                    return;
                }
            }
            yCoeffs = new float[]{0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
            uCoeffs = new float[]{-0.148223f, -0.290993f, 0.439216f, 0.501961f};
            vCoeffs = new float[]{0.439216f, -0.367788f, -0.0714274f, 0.501961f};
        }

        public ShaderCallbacks() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, glShader) == null) {
                this.xUnitLoc = glShader.getUniformLocation("xUnit");
                this.coeffsLoc = glShader.getUniformLocation("coeffs");
            }
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glShader, fArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
                int i6 = this.xUnitLoc;
                float f2 = this.stepSize;
                float f3 = i2;
                GLES20.glUniform2f(i6, (fArr[0] * f2) / f3, (f2 * fArr[1]) / f3);
            }
        }

        public void setPlaneU() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.coeffs = uCoeffs;
                this.stepSize = 2.0f;
            }
        }

        public void setPlaneV() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.coeffs = vCoeffs;
                this.stepSize = 2.0f;
            }
        }

        public void setPlaneY() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.coeffs = yCoeffs;
                this.stepSize = 1.0f;
            }
        }

        public /* synthetic */ ShaderCallbacks(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public YuvConverter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.threadChecker = new ThreadUtils.ThreadChecker();
        this.i420TextureFrameBuffer = new GlTextureFrameBuffer(GeneratedTexture.FORMAT);
        this.shaderCallbacks = new ShaderCallbacks(null);
        this.drawer = new GlGenericDrawer(FRAGMENT_SHADER, this.shaderCallbacks);
        this.threadChecker.detachThread();
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, textureBuffer)) == null) {
            this.threadChecker.checkIsOnValidThread();
            int width = textureBuffer.getWidth();
            int height = textureBuffer.getHeight();
            int i2 = ((width + 7) / 8) * 8;
            int i3 = (height + 1) / 2;
            int i4 = height + i3;
            final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i2 * i4);
            int i5 = i2 / 4;
            Matrix matrix = new Matrix();
            matrix.preTranslate(0.5f, 0.5f);
            matrix.preScale(1.0f, -1.0f);
            matrix.preTranslate(-0.5f, -0.5f);
            this.i420TextureFrameBuffer.setSize(i5, i4);
            GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
            GlUtil.checkNoGLES2Error("glBindFramebuffer");
            this.shaderCallbacks.setPlaneY();
            VideoFrameDrawer.drawTexture(this.drawer, textureBuffer, matrix, width, height, 0, 0, i5, height);
            this.shaderCallbacks.setPlaneU();
            int i6 = i5 / 2;
            VideoFrameDrawer.drawTexture(this.drawer, textureBuffer, matrix, width, height, 0, height, i6, i3);
            this.shaderCallbacks.setPlaneV();
            VideoFrameDrawer.drawTexture(this.drawer, textureBuffer, matrix, width, height, i6, height, i6, i3);
            GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), GeneratedTexture.FORMAT, 5121, nativeAllocateByteBuffer);
            GlUtil.checkNoGLES2Error("YuvConverter.convert");
            GLES20.glBindFramebuffer(36160, 0);
            int i7 = (i2 * height) + 0;
            int i8 = i2 / 2;
            int i9 = i7 + i8;
            nativeAllocateByteBuffer.position(0);
            nativeAllocateByteBuffer.limit(i7);
            ByteBuffer slice = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i7);
            int i10 = ((i3 - 1) * i2) + i8;
            nativeAllocateByteBuffer.limit(i7 + i10);
            ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i9);
            nativeAllocateByteBuffer.limit(i9 + i10);
            return JavaI420Buffer.wrap(width, height, slice, i2, slice2, i2, nativeAllocateByteBuffer.slice(), i2, new Runnable() { // from class: h.c.e0
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
                    }
                }
            });
        }
        return (VideoFrame.I420Buffer) invokeL.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.threadChecker.checkIsOnValidThread();
            this.drawer.release();
            this.i420TextureFrameBuffer.release();
            this.threadChecker.detachThread();
        }
    }
}
