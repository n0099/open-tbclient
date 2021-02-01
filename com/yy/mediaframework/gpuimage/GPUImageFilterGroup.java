package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import android.os.Build;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.gpuimage.util.Rotation;
import com.yy.mediaframework.gpuimage.util.TextureRotationUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class GPUImageFilterGroup extends GPUImageFilter {
    private boolean m2DTextureEnable;
    protected List<GPUImageFilter> mFilters;
    private int[] mFrameBufferTextures;
    private int[] mFrameBuffers;
    private final FloatBuffer mGLCubeBuffer;
    private final FloatBuffer mGLTextureBuffer;
    private final FloatBuffer mGLTextureFlipBuffer;
    protected List<GPUImageFilter> mMergedFilters;

    public GPUImageFilterGroup() {
        this(null);
    }

    public GPUImageFilterGroup(List<GPUImageFilter> list) {
        this.m2DTextureEnable = false;
        this.mFilters = list;
        if (this.mFilters == null) {
            this.mFilters = new ArrayList();
        } else {
            updateMergedFilters();
        }
        this.mGLCubeBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.CUBE.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLCubeBuffer.put(TextureRotationUtil.CUBE).position(0);
        this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.TEXTURE_NO_ROTATION.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        float[] rotation = TextureRotationUtil.getRotation(Rotation.NORMAL, false, true);
        this.mGLTextureFlipBuffer = ByteBuffer.allocateDirect(rotation.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureFlipBuffer.put(rotation).position(0);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void enable2DTextureDraw(boolean z) {
        this.m2DTextureEnable = z;
    }

    public void addFilter(GPUImageFilter gPUImageFilter) {
        if (gPUImageFilter != null) {
            this.mFilters.add(gPUImageFilter);
            updateMergedFilters();
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        GPUImageFilter gPUImageFilter;
        GPUImageFilter gPUImageFilter2 = this.mMergedFilters.get(0);
        while (true) {
            gPUImageFilter = gPUImageFilter2;
            if (!(gPUImageFilter instanceof GPUImageFilterGroup)) {
                break;
            }
            gPUImageFilter2 = ((GPUImageFilterGroup) gPUImageFilter).getMergedFilters().get(0);
        }
        gPUImageFilter.setFragmentShader(GPUImageSingleFilter.FStoOESFS(gPUImageFilter.getFragmentShader()));
        super.onInit();
        for (GPUImageFilter gPUImageFilter3 : this.mFilters) {
            gPUImageFilter3.init();
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDestroy() {
        destroyFramebuffers();
        for (GPUImageFilter gPUImageFilter : this.mFilters) {
            gPUImageFilter.destroy();
        }
        super.onDestroy();
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
        if (this.mFrameBuffers != null) {
            destroyFramebuffers();
        }
        int size = this.mFilters.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mFilters.get(i3).onOutputSizeChanged(i, i2);
        }
        if (this.mMergedFilters != null && this.mMergedFilters.size() > 0) {
            int size2 = this.mMergedFilters.size();
            this.mFrameBuffers = new int[size2];
            this.mFrameBufferTextures = new int[size2];
            for (int i4 = 0; i4 < size2; i4++) {
                GLES20.glGenTextures(1, this.mFrameBufferTextures, i4);
                GLES20.glGenFramebuffers(1, this.mFrameBuffers, i4);
                GLES20.glBindTexture(3553, this.mFrameBufferTextures[i4]);
                GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i4]);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mFrameBufferTextures[i4], 0);
                GLES20.glBindTexture(3553, 0);
                GLES20.glBindFramebuffer(36160, 0);
            }
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr, boolean z, byte[] bArr, long j) {
        int i3;
        runPendingOnDrawTasks();
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null && this.mMergedFilters != null) {
            int size = this.mMergedFilters.size();
            int i4 = 0;
            int i5 = i;
            while (i4 < size) {
                GPUImageFilter gPUImageFilter = this.mMergedFilters.get(i4);
                if (gPUImageFilter instanceof GPUImageSTBeautyFilter3) {
                    ((GPUImageSTBeautyFilter3) gPUImageFilter).setMidImageTextureId(i5);
                    i3 = this.mFrameBufferTextures[0];
                } else {
                    i3 = i5;
                }
                GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i4]);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                if (i4 == 0) {
                    if (Build.VERSION.SDK_INT >= 15) {
                        gPUImageFilter.onDraw(i3, floatBuffer, floatBuffer2, 36197, fArr, false, bArr, j);
                    }
                } else if (i4 == size - 1) {
                    gPUImageFilter.onDraw(i3, this.mGLCubeBuffer, size % 2 == 0 ? this.mGLTextureFlipBuffer : this.mGLTextureBuffer, 3553, Constant.mtxIdentity, false, bArr, j);
                } else {
                    gPUImageFilter.onDraw(i3, this.mGLCubeBuffer, this.mGLTextureBuffer, 3553, Constant.mtxIdentity, false, bArr, j);
                }
                if (i4 < size - 1) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i3 = this.mFrameBufferTextures[i4];
                }
                i4++;
                i5 = i3;
            }
        }
    }

    public void onPreviewDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, byte[] bArr, long j) {
        runPendingOnDrawTasks();
        if (isInitialized() && this.mFrameBuffers != null && this.mFrameBufferTextures != null && this.mMergedFilters != null) {
            int size = this.mMergedFilters.size();
            int i2 = 0;
            int i3 = i;
            while (i2 < size) {
                GPUImageFilter gPUImageFilter = this.mMergedFilters.get(i2);
                boolean z = i2 < size + (-1);
                if (z) {
                    GLES20.glBindFramebuffer(36160, this.mFrameBuffers[i2]);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                }
                if (i2 == 0) {
                    if (Build.VERSION.SDK_INT >= 15) {
                        gPUImageFilter.onDraw(i3, floatBuffer, floatBuffer2, 36197, Constant.mtxIdentity, false, bArr, j);
                    }
                } else if (i2 == size - 1) {
                    gPUImageFilter.onDraw(i3, this.mGLCubeBuffer, size % 2 == 0 ? this.mGLTextureFlipBuffer : this.mGLTextureBuffer, 3553, Constant.mtxIdentity, false, bArr, j);
                } else {
                    gPUImageFilter.onDraw(i3, this.mGLCubeBuffer, this.mGLTextureBuffer, 3553, Constant.mtxIdentity, false, bArr, j);
                }
                if (z) {
                    GLES20.glBindFramebuffer(36160, 0);
                    i3 = this.mFrameBufferTextures[i2];
                }
                i2++;
            }
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public int getLastTextureID() {
        if (this.mMergedFilters != null) {
            return this.mFrameBufferTextures[this.mMergedFilters.size() - 1];
        }
        return 0;
    }

    public List<GPUImageFilter> getFilters() {
        return this.mFilters;
    }

    public List<GPUImageFilter> getMergedFilters() {
        return this.mMergedFilters;
    }

    public void updateMergedFilters() {
        if (this.mFilters != null) {
            if (this.mMergedFilters == null) {
                this.mMergedFilters = new ArrayList();
            } else {
                this.mMergedFilters.clear();
            }
            for (GPUImageFilter gPUImageFilter : this.mFilters) {
                if (gPUImageFilter instanceof GPUImageFilterGroup) {
                    ((GPUImageFilterGroup) gPUImageFilter).updateMergedFilters();
                    List<GPUImageFilter> mergedFilters = ((GPUImageFilterGroup) gPUImageFilter).getMergedFilters();
                    if (mergedFilters != null && !mergedFilters.isEmpty()) {
                        this.mMergedFilters.addAll(mergedFilters);
                    }
                } else {
                    this.mMergedFilters.add(gPUImageFilter);
                }
            }
        }
    }
}
