package com.yy.mediaframework.gpuimage.adapter;

import android.content.Context;
import android.opengl.GLES20;
import com.yy.mediaframework.YYVideoSDK;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes4.dex */
public class GlTextureImageReader {
    public boolean mGlPboSupported;
    private byte[] mPixBytes = null;
    private ByteBuffer mPixBuffer = null;
    private GlPboReader mGlPboReader = null;
    private int mReaderFrameBuffer = -1;
    private int mWidth = 0;
    private int mHeight = 0;

    public GlTextureImageReader(Context context, int i, int i2) {
        this.mGlPboSupported = false;
        this.mGlPboSupported = GlPboReader.isPboSupport(context);
        if (YYVideoSDK.getInstance().mIsEmulator) {
            this.mGlPboSupported = false;
            YMFLog.warn(this, "[Util    ]", "isEmulator Not used pbo");
        }
        init(i, i2);
    }

    private void init(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.mReaderFrameBuffer = iArr[0];
        this.mPixBuffer = ByteBuffer.allocateDirect(i * i2 * 4);
        if (this.mGlPboSupported) {
            this.mGlPboReader = new GlPboReader(i, i2);
            this.mPixBytes = new byte[i * i2 * 4];
        } else {
            this.mPixBuffer.order(ByteOrder.nativeOrder());
        }
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void destroy() {
        if (this.mReaderFrameBuffer > 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.mReaderFrameBuffer}, 0);
            this.mReaderFrameBuffer = -1;
        }
        if (this.mGlPboSupported && this.mGlPboReader != null) {
            this.mGlPboReader.deinitPBO();
            this.mGlPboReader = null;
        }
    }

    public void checkImageSize(int i, int i2) {
        if (this.mWidth != i || this.mHeight != i2) {
            destroy();
            init(i, i2);
        }
    }

    public byte[] read(int i, int i2, int i3) {
        byte[] bArr = null;
        if (this.mReaderFrameBuffer > 0) {
            checkImageSize(i2, i3);
            GLES20.glBindFramebuffer(36160, this.mReaderFrameBuffer);
            GLES20.glBindTexture(3553, i);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
            if (this.mGlPboSupported && this.mGlPboReader != null) {
                this.mPixBuffer = this.mGlPboReader.downloadGpuBufferWithPbo();
                if (this.mPixBuffer == null) {
                    GLES20.glBindTexture(3553, 0);
                    GLES20.glBindFramebuffer(36160, 0);
                } else if (this.mPixBuffer.hasArray()) {
                    bArr = this.mPixBuffer.array();
                } else {
                    this.mPixBuffer.position(0);
                    this.mPixBuffer.get(this.mPixBytes);
                    bArr = this.mPixBytes;
                }
            } else {
                this.mPixBuffer.clear();
                GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, this.mPixBuffer);
                bArr = this.mPixBuffer.array();
            }
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        return bArr;
    }
}
