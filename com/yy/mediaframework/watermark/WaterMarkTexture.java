package com.yy.mediaframework.watermark;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.yy.mediaframework.utils.YMFLog;
import com.yy.mediaframework.watermark.WaterMark;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class WaterMarkTexture {
    public int mWaterMarkTextureId = -1;
    public int mWatermarkHeight;
    public int mWatermarkWidth;

    public WaterMarkTexture(WaterMark waterMark) {
        this.mWatermarkWidth = 0;
        this.mWatermarkHeight = 0;
        createWaterMarkTexture(waterMark.bitmap, waterMark.width, waterMark.height, waterMark.offsetX, waterMark.offsetY, waterMark.align);
        this.mWatermarkWidth = waterMark.width;
        this.mWatermarkHeight = waterMark.height;
    }

    public void destroy() {
        if (this.mWaterMarkTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mWaterMarkTextureId}, 0);
            this.mWaterMarkTextureId = -1;
            this.mWatermarkWidth = 0;
            this.mWatermarkHeight = 0;
        }
    }

    private int genWaterMarkTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.wrap(new byte[i * i2 * 4]));
        return iArr[0];
    }

    private void createWaterMarkTexture(Bitmap bitmap, int i, int i2, int i3, int i4, WaterMark.Align align) {
        int i5;
        int i6;
        this.mWaterMarkTextureId = genWaterMarkTexture(i, i2);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (align == WaterMark.Align.LeftTop) {
            i5 = i4;
            i6 = i3;
        } else if (align == WaterMark.Align.RightTop) {
            i6 = (i - width) - i3;
            i5 = i4;
        } else if (align == WaterMark.Align.LeftBottom) {
            i5 = (i2 - height) - i4;
            i6 = i3;
        } else if (align == WaterMark.Align.RightBottom) {
            i6 = (i - width) - i3;
            i5 = (i2 - height) - i4;
        } else {
            i5 = 0;
            i6 = 0;
        }
        YMFLog.info(this, "[Beauty  ]", "createWaterMarkTexture txtId:" + this.mWaterMarkTextureId + ", width:" + i + ", height:" + i2 + ", bmpWidth:" + width + ", bmpHeight:" + height + ", offsetX:" + i3 + ", offsetY:" + i4 + ", align:" + align + ", srcX:" + i6 + ", srcY:" + i5);
        GLUtils.texSubImage2D(3553, 0, i6, i5, bitmap, 6408, 5121);
        GLES20.glBindTexture(3553, 0);
    }
}
