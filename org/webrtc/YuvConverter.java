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
/* loaded from: classes8.dex */
public class YuvConverter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    public transient /* synthetic */ FieldHolder $fh;
    public final GlGenericDrawer drawer;
    public final GlTextureFrameBuffer i420TextureFrameBuffer;
    public final ShaderCallbacks shaderCallbacks;
    public final ThreadUtils.ThreadChecker threadChecker;

    /* renamed from: org.webrtc.YuvConverter$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void onPrepareShader(GlShader glShader, float[] fArr, int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{glShader, fArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
                GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
                int i5 = this.xUnitLoc;
                float f = this.stepSize;
                float f2 = i;
                GLES20.glUniform2f(i5, (fArr[0] * f) / f2, (f * fArr[1]) / f2);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int i = ((width + 7) / 8) * 8;
            int i2 = (height + 1) / 2;
            int i3 = height + i2;
            final ByteBuffer nativeAllocateByteBuffer = JniCommon.nativeAllocateByteBuffer(i * i3);
            int i4 = i / 4;
            Matrix matrix = new Matrix();
            matrix.preTranslate(0.5f, 0.5f);
            matrix.preScale(1.0f, -1.0f);
            matrix.preTranslate(-0.5f, -0.5f);
            this.i420TextureFrameBuffer.setSize(i4, i3);
            GLES20.glBindFramebuffer(36160, this.i420TextureFrameBuffer.getFrameBufferId());
            GlUtil.checkNoGLES2Error("glBindFramebuffer");
            this.shaderCallbacks.setPlaneY();
            VideoFrameDrawer.drawTexture(this.drawer, textureBuffer, matrix, width, height, 0, 0, i4, height);
            this.shaderCallbacks.setPlaneU();
            int i5 = i4 / 2;
            VideoFrameDrawer.drawTexture(this.drawer, textureBuffer, matrix, width, height, 0, height, i5, i2);
            this.shaderCallbacks.setPlaneV();
            VideoFrameDrawer.drawTexture(this.drawer, textureBuffer, matrix, width, height, i5, height, i5, i2);
            GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), GeneratedTexture.FORMAT, 5121, nativeAllocateByteBuffer);
            GlUtil.checkNoGLES2Error("YuvConverter.convert");
            GLES20.glBindFramebuffer(36160, 0);
            int i6 = (i * height) + 0;
            int i7 = i / 2;
            int i8 = i6 + i7;
            nativeAllocateByteBuffer.position(0);
            nativeAllocateByteBuffer.limit(i6);
            ByteBuffer slice = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i6);
            int i9 = ((i2 - 1) * i) + i7;
            nativeAllocateByteBuffer.limit(i6 + i9);
            ByteBuffer slice2 = nativeAllocateByteBuffer.slice();
            nativeAllocateByteBuffer.position(i8);
            nativeAllocateByteBuffer.limit(i8 + i9);
            return JavaI420Buffer.wrap(width, height, slice, i, slice2, i, nativeAllocateByteBuffer.slice(), i, new Runnable() { // from class: com.baidu.tieba.ou9
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
