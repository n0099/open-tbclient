package com.yy.mediaframework.gpuimage.adapter;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLES30;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
@TargetApi(18)
/* loaded from: classes4.dex */
public class GlPboReader {
    private static final int DEFUALT_NUMBER_PBOS = 2;
    private static final String TAG = "GlPboReader";
    private final byte[] bpoBufferArray;
    private int mHeight;
    private int mPboBufferSize;
    private int mPboDownloadCount;
    int[] mPboIds;
    private int mWidth;
    int mPboIndex = 0;
    int mPboNumember = 2;
    private AtomicBoolean mIsInit = new AtomicBoolean(false);

    public GlPboReader(int i, int i2) {
        init(i, i2);
        this.bpoBufferArray = new byte[this.mPboBufferSize];
    }

    public static boolean isPboSupport(Context context) {
        return ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getDeviceConfigurationInfo().reqGlEsVersion >= 196608;
    }

    private void init(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mPboBufferSize = this.mWidth * i2 * 4;
        initPBO();
    }

    private void initPBO() {
        YMFLog.info(this, "[Beauty  ]", "initPBO");
        this.mPboIds = new int[2];
        GLES30.glGenBuffers(2, this.mPboIds, 0);
        for (int i = 0; i < 2; i++) {
            GLES30.glBindBuffer(35051, this.mPboIds[i]);
            GLES30.glBufferData(35051, this.mPboBufferSize, null, 35040);
        }
        GLES30.glBindBuffer(35051, 0);
        this.mIsInit.set(true);
    }

    public void deinitPBO() {
        GLES30.glDeleteBuffers(2, this.mPboIds, 0);
    }

    public ByteBuffer downloadGpuBufferWithPbo() {
        ByteBuffer byteBuffer;
        this.mPboIndex = (this.mPboIndex + 1) % this.mPboNumember;
        int i = (this.mPboIndex + 1) % this.mPboNumember;
        if (this.mPboDownloadCount < 1) {
            GLES30.glBindBuffer(35051, this.mPboIds[this.mPboIndex]);
            GLESNativeTool.glReadPixelWithJni(0, 0, this.mWidth, this.mHeight, 6408, 5121, 0);
            byteBuffer = null;
        } else {
            GLES30.glBindBuffer(35051, this.mPboIds[this.mPboIndex]);
            GLESNativeTool.glReadPixelWithJni(0, 0, this.mWidth, this.mHeight, 6408, 5121, 0);
            GLES30.glBindBuffer(35051, this.mPboIds[i]);
            ByteBuffer.wrap(this.bpoBufferArray);
            byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, this.mPboBufferSize, 1);
            GLES30.glUnmapBuffer(35051);
            GLES30.glBindBuffer(35051, 0);
        }
        this.mPboDownloadCount++;
        if (this.mPboDownloadCount == Integer.MAX_VALUE) {
            this.mPboDownloadCount = 1;
        }
        GLES30.glBindBuffer(35051, 0);
        return byteBuffer;
    }

    public void onImageSizeUpdate(int i, int i2) {
        if (this.mWidth != i || this.mHeight != i2) {
            deinitPBO();
            init(i, i2);
        }
    }
}
