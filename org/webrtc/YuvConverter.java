package org.webrtc;

import android.graphics.Matrix;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import org.webrtc.GlGenericDrawer;
import org.webrtc.ThreadUtils;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class YuvConverter {
    public static final String FRAGMENT_SHADER = "uniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      sample(tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      sample(tc + 1.5 * xUnit).rgb);\n}\n";
    public final ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
    public final GlTextureFrameBuffer i420TextureFrameBuffer = new GlTextureFrameBuffer(6408);
    public final ShaderCallbacks shaderCallbacks = new ShaderCallbacks();
    public final GlGenericDrawer drawer = new GlGenericDrawer(FRAGMENT_SHADER, this.shaderCallbacks);

    /* loaded from: classes7.dex */
    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        public float[] coeffs;
        public int coeffsLoc;
        public float stepSize;
        public int xUnitLoc;
        public static final float[] yCoeffs = {0.256788f, 0.504129f, 0.0979059f, 0.0627451f};
        public static final float[] uCoeffs = {-0.148223f, -0.290993f, 0.439216f, 0.501961f};
        public static final float[] vCoeffs = {0.439216f, -0.367788f, -0.0714274f, 0.501961f};

        public ShaderCallbacks() {
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
            this.xUnitLoc = glShader.getUniformLocation("xUnit");
            this.coeffsLoc = glShader.getUniformLocation("coeffs");
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i2, int i3, int i4, int i5) {
            GLES20.glUniform4fv(this.coeffsLoc, 1, this.coeffs, 0);
            int i6 = this.xUnitLoc;
            float f2 = this.stepSize;
            float f3 = i2;
            GLES20.glUniform2f(i6, (fArr[0] * f2) / f3, (f2 * fArr[1]) / f3);
        }

        public void setPlaneU() {
            this.coeffs = uCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneV() {
            this.coeffs = vCoeffs;
            this.stepSize = 2.0f;
        }

        public void setPlaneY() {
            this.coeffs = yCoeffs;
            this.stepSize = 1.0f;
        }
    }

    public YuvConverter() {
        this.threadChecker.detachThread();
    }

    public VideoFrame.I420Buffer convert(VideoFrame.TextureBuffer textureBuffer) {
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
        GLES20.glReadPixels(0, 0, this.i420TextureFrameBuffer.getWidth(), this.i420TextureFrameBuffer.getHeight(), 6408, 5121, nativeAllocateByteBuffer);
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
        return JavaI420Buffer.wrap(width, height, slice, i2, slice2, i2, nativeAllocateByteBuffer.slice(), i2, new Runnable() { // from class: org.webrtc._$$Lambda$YuvConverter$7X4NRtBwZ8S7c3AW7UqovfxQVrk
            @Override // java.lang.Runnable
            public final void run() {
                JniCommon.nativeFreeByteBuffer(nativeAllocateByteBuffer);
            }
        });
    }

    public void release() {
        this.threadChecker.checkIsOnValidThread();
        this.drawer.release();
        this.i420TextureFrameBuffer.release();
        this.threadChecker.detachThread();
    }
}
