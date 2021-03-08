package com.yy.mediaframework.gpuimage;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gpuimage.util.Rotation;
import com.yy.mediaframework.gpuimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class GPUImageSingleFilter extends GPUImageFilter {
    public static final String FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final String FILTER_VERTEX_SHADER = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}";
    private boolean m2DTextureEnable;
    private GPUImageFilter mFilter;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    protected int mGLProgId;
    private FloatBuffer mGLTextureFlipBuffer;
    private boolean mIsInitialized;

    public GPUImageSingleFilter() {
        this(new GPUImageFilter("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", FStoOESFS("varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}")));
    }

    public static String FStoOESFS(String str) {
        if (!str.startsWith("#extension GL_OES_EGL_image_external : require")) {
            return "#extension GL_OES_EGL_image_external : require\n".concat(str.replace("sampler2D inputImageTexture;", "samplerExternalOES inputImageTexture;"));
        }
        return str;
    }

    public GPUImageSingleFilter(GPUImageFilter gPUImageFilter) {
        this.m2DTextureEnable = false;
        if (gPUImageFilter instanceof GPUImageFilterGroup) {
            throw new RuntimeException("GPUImageSingleFilter can't wrap GPUImageFilterGroup");
        }
        this.mFilter = gPUImageFilter;
        float[] rotation = TextureRotationUtil.getRotation(Rotation.NORMAL, false, true);
        this.mGLTextureFlipBuffer = ByteBuffer.allocateDirect(rotation.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureFlipBuffer.put(rotation).position(0);
    }

    public GPUImageFilter getGPUImageFilter() {
        return this.mFilter;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onImageSizeChanged(int i, int i2) {
        this.mFilter.onImageSizeChanged(i, i2);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public int getLastTextureID() {
        return this.mFrameBufferTextures[0];
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        this.mFilter.initForExternalTextureInput(!this.m2DTextureEnable);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDestroy() {
        destroyFramebuffers();
        this.mFilter.destroy();
    }

    private void destroyFramebuffers() {
        if (this.mFrameBufferTextures != null) {
            GLES20.glDeleteTextures(this.mFrameBufferTextures.length, this.mFrameBufferTextures, 0);
            this.mFrameBufferTextures = null;
        }
        if (this.mFrameBuffers != null) {
            GLES20.glDeleteFramebuffers(this.mFrameBuffers.length, this.mFrameBuffers, 0);
            this.mFrameBuffers = null;
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        this.mFilter.onOutputSizeChanged(i, i2);
        if (this.mFrameBuffers != null) {
            destroyFramebuffers();
        }
        this.mFrameBuffers = new int[1];
        this.mFrameBufferTextures = new int[1];
        GLES20.glGenFramebuffers(1, this.mFrameBuffers, 0);
        GLES20.glGenTextures(1, this.mFrameBufferTextures, 0);
        GLES20.glBindTexture(3553, this.mFrameBufferTextures[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[0], 0);
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            throw new RuntimeException("Framebuffer not complete, status=" + glCheckFramebufferStatus);
        }
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void checkTextureTypeUpdate(int i) {
        this.mFilter.checkTextureTypeUpdate(i);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void enable2DTextureDraw(boolean z) {
        this.m2DTextureEnable = z;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    @TargetApi(15)
    public void onDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr, boolean z, byte[] bArr, long j) {
        GlUtil.checkGlError("glFramebufferRenderbuffer");
        runPendingOnDrawTasks();
        GlUtil.checkGlError("glFramebufferRenderbuffer");
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null) {
            GLES20.glBindFramebuffer(36160, this.mFrameBuffers[0]);
            GLES20.glClear(16640);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GlUtil.checkGlError("glFramebufferRenderbuffer");
            if (this.m2DTextureEnable) {
                this.mFilter.onDraw(i, floatBuffer, floatBuffer2, 3553, fArr, z, bArr, j);
            } else {
                this.mFilter.onDraw(i, floatBuffer, floatBuffer2, 36197, fArr, z, bArr, j);
            }
            GlUtil.checkGlError("glFramebufferRenderbuffer end of filter drawing");
        }
    }
}
