package com.yy.mediaframework.filters;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.baidu.mobstat.Config;
import com.yy.mediaframework.Constant;
import com.yy.mediaframework.YMFStreamSyncSourceManager;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.gpuimage.util.GLShaderProgram;
import com.yy.mediaframework.model.YYMediaSample;
import com.yy.mediaframework.model.YYMediaSampleAlloc;
import com.yy.mediaframework.utils.GLUtil;
import com.yy.mediaframework.utils.OESTO2DTool;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class OriginDataEntryFilter extends AbstractYYMediaFilter implements SurfaceTexture.OnFrameAvailableListener {
    public static final int ORIGIN_PIC_FORMAT_I420 = 1;
    public static final int ORIGIN_PIC_FORMAT_NV21 = 2;
    public static final int ORIGIN_PIC_FORMAT_RGBA = 0;
    private static final String TAG = "OriginDataEntryFilter";
    public static final String i420_fs = "precision highp float;varying vec2 vTextureCoord;uniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;void main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    gl_FragColor = vec4(rgb, 1);}";
    public static final String i420_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position =  aPosition;\n    vTextureCoord = aTextureCoord.xy;\n}\n";
    public static final String nv21_fs = "precision mediump float;   \nprecision mediump int;     \nvarying vec2 vTexCoord;   \nuniform sampler2D u_texY;  \nuniform sampler2D u_texUV; \nconst mat3 op = mat3(1.164, 1.164, 1.164, 0.0, -0.391, 2.018, 1.596, -0.813, 0.0); \nvoid main(void)   \n{                 \n   vec3 rgb, yuv; \n   yuv.x = texture2D(u_texY, vTexCoord).r - 0.0625;            \n   yuv.yz = texture2D(u_texUV, vTexCoord).ar - vec2(0.5, 0.5); \n   rgb = op * yuv;                 \n   rgb.r = clamp(rgb.r, 0.0, 1.0); \n   rgb.g = clamp(rgb.g, 0.0, 1.0); \n   rgb.b = clamp(rgb.b, 0.0, 1.0); \n   gl_FragColor = vec4(rgb, 1.0);  \n}                                  \n";
    public static final String nv21_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}";
    public static final String rgba_fs = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static final String rgba_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}";
    private ByteBuffer buffer_rgba;
    private ByteBuffer buffer_u;
    private ByteBuffer buffer_uv;
    private ByteBuffer buffer_v;
    private ByteBuffer buffer_y;
    private boolean mReady;
    private int mTextureHeight;
    private int mTextureWidth;
    private VideoLiveFilterContext mVideoLiveFilterContext;
    private static final float[] FULL_RECTANGLE_COORDS_180 = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
    private static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] FULL_RECTANGLE_COORDS_90 = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
    private static final float[] FULL_RECTANGLE_COORDS_270 = {1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f};
    private static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static FloatBuffer FULL_RECTANGLE_VERT_BUF = null;
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    private OESTO2DTool mOESTO2DTool = null;
    private int mTextureId_y = -1;
    private int mTextureId_u = -1;
    private int mTextureId_v = -1;
    private int mTextureId_rgba = -1;
    private int mTextureId_uv = -1;
    private int mScaleMode = 1;
    private byte[] mInputOriginData = null;
    private AtomicInteger mSrcWidth = new AtomicInteger(0);
    private AtomicInteger mSrcHeight = new AtomicInteger(0);
    private AtomicInteger mRotation = new AtomicInteger(-1);
    private AtomicInteger mFormat = new AtomicInteger(-1);
    private int mDstWidth = 0;
    private int mDstHeight = 0;
    private GLShaderProgram mRGBAShader = null;
    private GLShaderProgram mI420Shader = null;
    private GLShaderProgram mNV21Shader = null;
    private FloatBuffer mVertexCoordinate = null;
    private long feedFrameCounter = 0;
    private long feedCurrentTime = 0;
    private long lastPrintTime = 0;
    private List<Long> mCaptureRateList = new ArrayList();
    private long maxDealTime = 0;
    private long averageDealTime = 0;
    private List<Long> mCaptureAverageDealTimeList = new ArrayList();
    private List<Long> mCaptureMaxDealTimeList = new ArrayList();
    public float[] mMainTransformer = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private IntBuffer mFBO = null;
    private int mRenderTextureId = -1;
    private int mPositionLoc = -1;
    private int mTexCoordLoc = -1;
    private int mTextureUniform_y = -1;
    private int mTextureUniform_u = -1;
    private int mTextureUniform_v = -1;
    private int mTextureUniform_uv = -1;
    private boolean mUseTexture = false;
    private int mTextureOesTo2dId = -1;

    public OriginDataEntryFilter(VideoLiveFilterContext videoLiveFilterContext) {
        this.mReady = false;
        this.mVideoLiveFilterContext = videoLiveFilterContext;
        this.mReady = false;
    }

    @Override // com.yy.mediaframework.filters.AbstractYYMediaFilter
    public void deInit() {
        if (this.mReady) {
            deInitTextureSurface();
            if (this.mI420Shader != null) {
                this.mI420Shader.destory();
                this.mI420Shader = null;
            }
            if (this.mRGBAShader != null) {
                this.mRGBAShader.destory();
                this.mRGBAShader = null;
            }
            if (this.mNV21Shader != null) {
                this.mNV21Shader.destory();
                this.mNV21Shader = null;
            }
            if (this.mOESTO2DTool != null) {
                this.mOESTO2DTool.release();
                this.mOESTO2DTool = null;
            }
            this.mReady = false;
            this.mTextureWidth = 0;
            this.mTextureHeight = 0;
        }
    }

    private boolean checkAndWaitGlThreadIdle() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mVideoLiveFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.OriginDataEntryFilter.1
            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            return true;
        } catch (Exception e) {
            YMFLog.error(this, "[CCapture]", " checkAndWaitGlThreadIdel, error" + e.toString());
            return false;
        }
    }

    public void setOriginTextureToEncode(final int i, final int i2, final float[] fArr, final int i3, final int i4, final long j, final int i5, int i6) {
        this.mUseTexture = true;
        this.mScaleMode = i6;
        if (checkAndWaitGlThreadIdle()) {
            if (i2 != 3553) {
                if (this.mOESTO2DTool == null) {
                    this.mOESTO2DTool = new OESTO2DTool();
                }
                if (this.mTextureOesTo2dId == -1 || this.mTextureWidth != i3 || this.mTextureHeight != i4) {
                    if (this.mTextureOesTo2dId >= 0) {
                        GLES20.glDeleteTextures(1, new int[]{this.mTextureOesTo2dId}, 0);
                        this.mTextureOesTo2dId = -1;
                    }
                    this.mTextureOesTo2dId = GLUtil.genTexture(3553, i3, i4);
                    this.mTextureWidth = i3;
                    this.mTextureHeight = i4;
                }
                this.mTextureOesTo2dId = this.mOESTO2DTool.ConvertOES(i, i3, i4, this.mTextureOesTo2dId);
            }
            long currentTimeMillis = System.currentTimeMillis();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.mVideoLiveFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.OriginDataEntryFilter.2
                @Override // java.lang.Runnable
                public void run() {
                    YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
                    alloc.mWidth = i3;
                    alloc.mHeight = i4;
                    alloc.mEncodeWidth = OriginDataEntryFilter.this.mVideoLiveFilterContext.getVideoEncoderConfig().getEncodeWidth();
                    alloc.mEncodeHeight = OriginDataEntryFilter.this.mVideoLiveFilterContext.getVideoEncoderConfig().getEncodeHeight();
                    if (i2 != 3553) {
                        alloc.mMasterTextureId = OriginDataEntryFilter.this.mTextureOesTo2dId;
                    } else {
                        alloc.mMasterTextureId = i;
                    }
                    System.arraycopy(fArr, 0, alloc.mMainTransformer, 0, 16);
                    alloc.mMainTransformer = GLUtil.rotateTextureMatrix(alloc.mMainTransformer, i5);
                    alloc.mYYPtsMillions = j;
                    alloc.mTextureTarget = 3553;
                    GlUtil.checkGlError("end");
                    alloc.mOrientation = 0;
                    alloc.mUsedExternPts = true;
                    alloc.mUseExternalVideoFrame = true;
                    alloc.mExternalFrameScaleMode = OriginDataEntryFilter.this.mScaleMode;
                    if (YMFStreamSyncSourceManager.getInstance().getAndResetSyncSourceFlag(alloc.mYYPtsMillions)) {
                        YMFLog.info(this, Constant.MEDIACODE_SSRC, " ssrc :" + alloc.mYYPtsMillions + "," + YMFStreamSyncSourceManager.getInstance().mHighStreamFirstSsrc);
                    }
                    OriginDataEntryFilter.this.deliverToDownStream(alloc);
                    alloc.decRef();
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
                printCameraCaptureFrameRate(System.currentTimeMillis() - currentTimeMillis);
            } catch (Exception e) {
                YMFLog.error(this, "[CCapture]", " checkAndWaitGlThreadIdel, error" + e.toString());
            }
        }
    }

    public void setOriginFrameToEncode(final byte[] bArr, final int i, final int i2, final int i3, final int i4, final long j, int i5) {
        this.mUseTexture = false;
        this.mScaleMode = i5;
        if (checkAndWaitGlThreadIdle()) {
            if (this.mSrcWidth.get() != i2 || this.mSrcHeight.get() != i3 || this.mRotation.get() != i4 || this.mFormat.get() != i) {
                this.mVideoLiveFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.OriginDataEntryFilter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i4 == 270) {
                            FloatBuffer unused = OriginDataEntryFilter.FULL_RECTANGLE_VERT_BUF = GlUtil.createFloatBuffer(OriginDataEntryFilter.FULL_RECTANGLE_COORDS_90);
                            OriginDataEntryFilter.this.mDstHeight = i2;
                            OriginDataEntryFilter.this.mDstWidth = i3;
                        } else if (i4 == 180) {
                            FloatBuffer unused2 = OriginDataEntryFilter.FULL_RECTANGLE_VERT_BUF = GlUtil.createFloatBuffer(OriginDataEntryFilter.FULL_RECTANGLE_COORDS_180);
                            OriginDataEntryFilter.this.mDstHeight = i3;
                            OriginDataEntryFilter.this.mDstWidth = i2;
                        } else if (i4 == 90) {
                            FloatBuffer unused3 = OriginDataEntryFilter.FULL_RECTANGLE_VERT_BUF = GlUtil.createFloatBuffer(OriginDataEntryFilter.FULL_RECTANGLE_COORDS_270);
                            OriginDataEntryFilter.this.mDstHeight = i2;
                            OriginDataEntryFilter.this.mDstWidth = i3;
                        } else {
                            FloatBuffer unused4 = OriginDataEntryFilter.FULL_RECTANGLE_VERT_BUF = GlUtil.createFloatBuffer(OriginDataEntryFilter.FULL_RECTANGLE_COORDS);
                            OriginDataEntryFilter.this.mDstHeight = i3;
                            OriginDataEntryFilter.this.mDstWidth = i2;
                        }
                        OriginDataEntryFilter.this.mSrcWidth.set(i2);
                        OriginDataEntryFilter.this.mSrcHeight.set(i3);
                        OriginDataEntryFilter.this.mRotation.set(i4);
                        OriginDataEntryFilter.this.mFormat.set(i);
                        OriginDataEntryFilter.this.initTextureSurface(OriginDataEntryFilter.this.mDstWidth, OriginDataEntryFilter.this.mDstHeight, i);
                        YMFLog.info(this, "[CCapture]", "initTextureSurface width:" + i2 + " height:" + i3 + " rotation:" + i4);
                    }
                });
            }
            synchronized (this) {
                if (this.mInputOriginData == null || (this.mInputOriginData != null && this.mInputOriginData.length != i2 * i3 * 4)) {
                    this.mInputOriginData = new byte[i2 * i3 * 4];
                }
                System.arraycopy(bArr, 0, this.mInputOriginData, 0, bArr.length);
            }
            this.mVideoLiveFilterContext.getGlManager().post(new Runnable() { // from class: com.yy.mediaframework.filters.OriginDataEntryFilter.4
                @Override // java.lang.Runnable
                public void run() {
                    OriginDataEntryFilter.this.converterOriginFrameToTexture(bArr, j, i);
                }
            });
        }
    }

    private void converterI420ToTexture(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        GlUtil.checkGlError("converterI420ToTexture begin");
        GLES20.glBindTexture(3553, this.mTextureId_y);
        GLES20.glTexImage2D(3553, 0, 6409, this.mSrcWidth.get(), this.mSrcHeight.get(), 0, 6409, 5121, byteBuffer);
        GlUtil.checkGlError("converterI420ToTexture y");
        GLES20.glBindTexture(3553, this.mTextureId_u);
        GLES20.glTexImage2D(3553, 0, 6409, this.mSrcWidth.get() / 2, this.mSrcHeight.get() / 2, 0, 6409, 5121, byteBuffer2);
        GlUtil.checkGlError("converterI420ToTexture u");
        GLES20.glBindTexture(3553, this.mTextureId_v);
        GLES20.glTexImage2D(3553, 0, 6409, this.mSrcWidth.get() / 2, this.mSrcHeight.get() / 2, 0, 6409, 5121, byteBuffer3);
        GlUtil.checkGlError("converterI420ToTexture u");
        GLES20.glBindFramebuffer(36160, this.mFBO.get(0));
        GLES20.glBindTexture(3553, this.mRenderTextureId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mRenderTextureId, 0);
        GLES20.glViewport(0, 0, this.mDstWidth, this.mDstHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GlUtil.checkGlError("converterI420ToTexture begin");
        this.mI420Shader.useProgram();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mTextureId_y);
        GLES20.glUniform1i(this.mTextureUniform_y, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.mTextureId_u);
        GLES20.glUniform1i(this.mTextureUniform_u, 1);
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.mTextureId_v);
        GLES20.glUniform1i(this.mTextureUniform_v, 2);
        GlUtil.checkGlError("converterI420ToTexture 1");
        GLES20.glEnableVertexAttribArray(this.mPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 8, (Buffer) FULL_RECTANGLE_VERT_BUF);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 8, (Buffer) FULL_RECTANGLE_TEX_BUF);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.mPositionLoc);
        GLES20.glDisableVertexAttribArray(this.mTexCoordLoc);
        GLES20.glUseProgram(0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("draw");
    }

    private void converterRGBAToTexture(ByteBuffer byteBuffer) {
        if (this.mRGBAShader == null) {
            YMFLog.error(this, "[CCapture]", "converterRGBAToTexture shader null ");
            return;
        }
        GlUtil.checkGlError("converterRGBAToTexture begin");
        GLES20.glBindTexture(3553, this.mTextureId_rgba);
        GLES20.glTexImage2D(3553, 0, 6408, this.mSrcWidth.get(), this.mSrcHeight.get(), 0, 6408, 5121, byteBuffer);
        GlUtil.checkGlError("converterRGBAToTexture rgba");
        GLES20.glBindFramebuffer(36160, this.mFBO.get(0));
        GLES20.glBindTexture(3553, this.mRenderTextureId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mRenderTextureId, 0);
        GLES20.glViewport(0, 0, this.mDstWidth, this.mDstHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GlUtil.checkGlError("converterI420ToTexture begin");
        this.mRGBAShader.useProgram();
        this.mRGBAShader.setUniformTexture("uTexture0", 0, this.mTextureId_rgba, 3553);
        GLES20.glEnableVertexAttribArray(this.mPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 8, (Buffer) FULL_RECTANGLE_VERT_BUF);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 8, (Buffer) FULL_RECTANGLE_TEX_BUF);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.mPositionLoc);
        GLES20.glDisableVertexAttribArray(this.mTexCoordLoc);
        GLES20.glUseProgram(0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("draw");
    }

    private void converterNV21ToTexture(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        GlUtil.checkGlError("converterI420ToTexture begin");
        GLES20.glBindTexture(3553, this.mTextureId_y);
        GLES20.glTexImage2D(3553, 0, 6409, this.mSrcWidth.get(), this.mSrcHeight.get(), 0, 6409, 5121, byteBuffer);
        GlUtil.checkGlError("converterI420ToTexture y");
        GLES20.glBindTexture(3553, this.mTextureId_uv);
        GLES20.glTexImage2D(3553, 0, 6410, this.mSrcWidth.get() / 2, this.mSrcHeight.get() / 2, 0, 6410, 5121, byteBuffer2);
        GlUtil.checkGlError("converterI420ToTexture u");
        GLES20.glBindFramebuffer(36160, this.mFBO.get(0));
        GLES20.glBindTexture(3553, this.mRenderTextureId);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.mRenderTextureId, 0);
        GLES20.glViewport(0, 0, this.mDstWidth, this.mDstHeight);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GlUtil.checkGlError("converterI420ToTexture begin");
        this.mNV21Shader.useProgram();
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.mTextureId_y);
        GLES20.glUniform1i(this.mTextureUniform_y, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.mTextureId_uv);
        GLES20.glUniform1i(this.mTextureUniform_uv, 1);
        GlUtil.checkGlError("converterI420ToTexture 1");
        GLES20.glEnableVertexAttribArray(this.mPositionLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 8, (Buffer) FULL_RECTANGLE_VERT_BUF);
        GlUtil.checkGlError("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        GlUtil.checkGlError("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 8, (Buffer) FULL_RECTANGLE_TEX_BUF);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError("glDrawArrays");
        GLES20.glDisableVertexAttribArray(this.mPositionLoc);
        GLES20.glDisableVertexAttribArray(this.mTexCoordLoc);
        GLES20.glUseProgram(0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkGlError("draw");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void converterOriginFrameToTexture(byte[] bArr, long j, int i) {
        if (!this.mReady) {
            YMFLog.error(this, "[CCapture]", "converterOriginFrameToTexture no ready or format " + this.mReady);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        switch (i) {
            case 0:
                synchronized (this) {
                    System.arraycopy(this.mInputOriginData, 0, this.buffer_rgba.array(), this.buffer_rgba.arrayOffset(), this.mSrcWidth.get() * this.mSrcHeight.get() * 4);
                }
                converterRGBAToTexture(this.buffer_rgba);
                break;
            case 1:
                synchronized (this) {
                    System.arraycopy(this.mInputOriginData, 0, this.buffer_y.array(), this.buffer_y.arrayOffset(), this.mSrcWidth.get() * this.mSrcHeight.get());
                    System.arraycopy(this.mInputOriginData, this.mSrcWidth.get() * this.mSrcHeight.get(), this.buffer_u.array(), this.buffer_u.arrayOffset(), (this.mSrcWidth.get() * this.mSrcHeight.get()) / 4);
                    System.arraycopy(this.mInputOriginData, (this.mSrcWidth.get() * this.mSrcHeight.get()) + ((this.mSrcWidth.get() * this.mSrcHeight.get()) / 4), this.buffer_v.array(), this.buffer_v.arrayOffset(), (this.mSrcWidth.get() * this.mSrcHeight.get()) / 4);
                }
                converterI420ToTexture(this.buffer_y, this.buffer_u, this.buffer_v);
                break;
            case 2:
                synchronized (this) {
                    System.arraycopy(this.mInputOriginData, 0, this.buffer_y.array(), this.buffer_y.arrayOffset(), this.mSrcWidth.get() * this.mSrcHeight.get());
                    System.arraycopy(this.mInputOriginData, this.mSrcWidth.get() * this.mSrcHeight.get(), this.buffer_uv.array(), this.buffer_uv.arrayOffset(), (this.mSrcWidth.get() * this.mSrcHeight.get()) / 2);
                }
                converterNV21ToTexture(this.buffer_y, this.buffer_uv);
                break;
        }
        YYMediaSample alloc = YYMediaSampleAlloc.instance().alloc();
        alloc.mWidth = this.mDstWidth;
        alloc.mHeight = this.mDstHeight;
        alloc.mEncodeWidth = this.mVideoLiveFilterContext.getVideoEncoderConfig().getEncodeWidth();
        alloc.mEncodeHeight = this.mVideoLiveFilterContext.getVideoEncoderConfig().getEncodeHeight();
        alloc.mMasterTextureId = this.mRenderTextureId;
        alloc.mMainTransformer = this.mMainTransformer;
        alloc.mUsedExternPts = true;
        alloc.mUseExternalVideoFrame = true;
        alloc.mExternalFrameScaleMode = this.mScaleMode;
        this.mVideoLiveFilterContext.mPeripheralsPosition.fillMode = 1;
        alloc.mYYPtsMillions = j;
        alloc.mTextureTarget = 3553;
        GlUtil.checkGlError("end");
        alloc.mOrientation = alloc.mWidth >= alloc.mHeight ? 2 : 1;
        this.mVideoLiveFilterContext.mPeripheralsOrientation = alloc.mOrientation;
        if (YMFStreamSyncSourceManager.getInstance().getAndResetSyncSourceFlag(alloc.mYYPtsMillions)) {
            YMFLog.info(this, Constant.MEDIACODE_SSRC, " ssrc :" + alloc.mYYPtsMillions + "," + YMFStreamSyncSourceManager.getInstance().mHighStreamFirstSsrc);
        }
        deliverToDownStream(alloc);
        alloc.decRef();
        printCameraCaptureFrameRate(System.currentTimeMillis() - currentTimeMillis);
    }

    private void deInitTextureSurface() {
        if (this.mTextureId_y >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId_y}, 0);
            this.mTextureId_y = -1;
        }
        if (this.mTextureId_u >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId_u}, 0);
            this.mTextureId_u = -1;
        }
        if (this.mTextureId_v >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId_v}, 0);
            this.mTextureId_v = -1;
        }
        if (this.mTextureId_uv >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId_uv}, 0);
            this.mTextureId_uv = -1;
        }
        if (this.mTextureId_rgba >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureId_rgba}, 0);
            this.mTextureId_rgba = -1;
        }
        if (this.mTextureOesTo2dId >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mTextureOesTo2dId}, 0);
            this.mTextureOesTo2dId = -1;
        }
        if (this.mFBO != null) {
            GLES20.glDeleteFramebuffers(1, this.mFBO);
            this.mFBO = null;
        }
        if (this.mRenderTextureId >= 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mRenderTextureId}, 0);
        }
    }

    public int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTextureSurface(int i, int i2, int i3) {
        deInitTextureSurface();
        this.mFBO = IntBuffer.allocate(1);
        GLES20.glGenFramebuffers(1, this.mFBO);
        synchronized (this) {
            if (this.mInputOriginData == null || (this.mInputOriginData != null && this.mInputOriginData.length != i * i2 * 4)) {
                this.mInputOriginData = new byte[i * i2 * 4];
            }
        }
        if (this.mTextureId_y == -1 && i3 == 1) {
            this.mTextureId_y = createTexture();
            this.mTextureId_u = createTexture();
            this.mTextureId_v = createTexture();
            this.buffer_y = ByteBuffer.allocateDirect(i * i2);
            this.buffer_v = ByteBuffer.allocateDirect((i * i2) / 4);
            this.buffer_u = ByteBuffer.allocateDirect((i * i2) / 4);
            if (this.mI420Shader == null) {
                this.mI420Shader = new GLShaderProgram();
                this.mI420Shader.setProgram(i420_vs, "precision highp float;varying vec2 vTextureCoord;uniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;void main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    gl_FragColor = vec4(rgb, 1);}");
                this.mPositionLoc = GLES20.glGetAttribLocation(this.mI420Shader.programHandle(), "aPosition");
                this.mTexCoordLoc = GLES20.glGetAttribLocation(this.mI420Shader.programHandle(), "aTextureCoord");
                this.mTextureUniform_y = GLES20.glGetUniformLocation(this.mI420Shader.programHandle(), "tex_y");
                this.mTextureUniform_u = GLES20.glGetUniformLocation(this.mI420Shader.programHandle(), "tex_u");
                this.mTextureUniform_v = GLES20.glGetUniformLocation(this.mI420Shader.programHandle(), "tex_v");
                if (this.mPositionLoc < 0 || this.mTexCoordLoc < 0 || this.mTextureUniform_y < 0 || this.mTextureUniform_u < 0 || this.mTextureUniform_v < 0) {
                    YMFLog.error(this, "[CCapture]", " I420 glGetAttribLocation error!");
                    return;
                }
            }
        } else if (this.mTextureId_rgba == -1 && i3 == 0) {
            this.mTextureId_rgba = createTexture();
            this.buffer_rgba = ByteBuffer.allocateDirect(i * i2 * 4);
            if (this.mRGBAShader == null) {
                this.mRGBAShader = new GLShaderProgram();
                this.mRGBAShader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}");
                this.mPositionLoc = GLES20.glGetAttribLocation(this.mRGBAShader.programHandle(), "aPosition");
                this.mTexCoordLoc = GLES20.glGetAttribLocation(this.mRGBAShader.programHandle(), "aTextureCoord");
                if (this.mPositionLoc < 0 || this.mTexCoordLoc < 0) {
                    YMFLog.error(this, "[CCapture]", " RGBA glGetAttribLocation error!");
                    return;
                }
            }
        } else if (this.mTextureId_uv == -1 && i3 == 2) {
            this.mTextureId_y = createTexture();
            this.mTextureId_uv = createTexture();
            this.buffer_y = ByteBuffer.allocateDirect(i * i2);
            this.buffer_uv = ByteBuffer.allocateDirect((i * i2) / 2);
            if (this.mNV21Shader == null) {
                this.mNV21Shader = new GLShaderProgram();
                this.mNV21Shader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", nv21_fs);
            }
            this.mPositionLoc = GLES20.glGetAttribLocation(this.mNV21Shader.programHandle(), "aPosition");
            this.mTexCoordLoc = GLES20.glGetAttribLocation(this.mNV21Shader.programHandle(), "aTextureCoord");
            this.mTextureUniform_y = GLES20.glGetUniformLocation(this.mNV21Shader.programHandle(), "u_texY");
            this.mTextureUniform_uv = GLES20.glGetUniformLocation(this.mNV21Shader.programHandle(), "u_texUV");
            if (this.mPositionLoc < 0 || this.mTexCoordLoc < 0 || this.mTextureUniform_uv < 0 || this.mTextureUniform_y < 0) {
                YMFLog.error(this, "[CCapture]", " NV21 glGetAttribLocation error!");
                return;
            }
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.mRenderTextureId = iArr[0];
        GLES20.glBindTexture(3553, this.mRenderTextureId);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        this.mReady = true;
        YMFLog.info(this, "[CCapture]", "initTextureSurface:" + i + Config.EVENT_HEAT_X + i2 + " format:" + i3);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    private void printFrameRate(String str, List<Long> list, List<Long> list2, List<Long> list3) {
        if (list != null) {
            String str2 = " ";
            for (int i = 0; i < list.size(); i++) {
                str2 = str2 + list.get(i) + ":" + list2.get(i) + ":" + list3.get(i) + ", ";
            }
            YMFLog.info(this, "[CCapture]", "handleFrameAvailable feed data frame rate:[" + str2 + "] type:[" + str + "]");
        }
    }

    private void printCameraCaptureFrameRate(long j) {
        try {
            this.feedFrameCounter++;
            this.feedCurrentTime = System.currentTimeMillis();
            this.maxDealTime = this.maxDealTime < j ? j : this.maxDealTime;
            this.averageDealTime += j;
            if (this.feedCurrentTime - this.lastPrintTime >= 1000) {
                this.mCaptureRateList.add(Long.valueOf(this.feedFrameCounter));
                this.mCaptureAverageDealTimeList.add(Long.valueOf(this.averageDealTime / this.feedFrameCounter));
                this.mCaptureMaxDealTimeList.add(Long.valueOf(this.maxDealTime));
                if (this.mCaptureRateList.size() >= 5) {
                    printFrameRate("OriginCapture " + this.mUseTexture, this.mCaptureRateList, this.mCaptureAverageDealTimeList, this.mCaptureMaxDealTimeList);
                    this.mCaptureRateList.clear();
                    this.mCaptureMaxDealTimeList.clear();
                    this.mCaptureAverageDealTimeList.clear();
                }
                this.feedFrameCounter = 0L;
                this.lastPrintTime = this.feedCurrentTime;
                this.maxDealTime = 0L;
                this.averageDealTime = 0L;
            }
        } catch (Exception e) {
            YMFLog.error(this, "[CCapture]", "printCameraCaptureFrameRate exception:" + e.toString());
        }
    }
}
