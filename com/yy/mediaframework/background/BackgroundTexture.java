package com.yy.mediaframework.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import androidx.core.view.ViewCompat;
import com.yy.mediaframework.background.Background;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class BackgroundTexture {
    private static final String TAG = "BackgroundTexture";
    public int mbackgroundHeight;
    public int mbackgroundTextureId = -1;
    public int mbackgroundWidth;

    public BackgroundTexture(Background background) {
        this.mbackgroundWidth = 0;
        this.mbackgroundHeight = 0;
        if (background.bitmap != null) {
            YMFLog.info(this, "[Preview ]", "background texture bitmap not null.");
            createbackgroundTexture(background.bitmap, background.width, background.height, background.offsetX, background.offsetY, background.align);
        } else {
            YMFLog.info(this, "[Preview ]", "background texture bitmap is null, use default background instead.");
            createbackgroundTexture(createColorBitmap(background.width, background.height), background.width, background.height, background.offsetX, background.offsetY, background.align);
        }
        this.mbackgroundWidth = background.width;
        this.mbackgroundHeight = background.height;
    }

    private Bitmap createColorBitmap(int i, int i2) {
        YMFLog.info(this, "[Preview ]", "createColorBitmap, width:%d, height:%d", Integer.valueOf(i), Integer.valueOf(i2));
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawColor(ViewCompat.MEASURED_STATE_MASK);
        return createBitmap;
    }

    public void destroy() {
        if (this.mbackgroundTextureId > 0) {
            GLES20.glDeleteTextures(1, new int[]{this.mbackgroundTextureId}, 0);
            this.mbackgroundTextureId = -1;
            this.mbackgroundWidth = 0;
            this.mbackgroundHeight = 0;
        }
    }

    private int genbackgroundTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBlendFunc(770, 771);
        GLES20.glEnable(3042);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.wrap(new byte[i * i2 * 4]));
        return iArr[0];
    }

    private int genbackgroundTexture(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    private void createbackgroundTexture(Bitmap bitmap, int i, int i2, int i3, int i4, Background.Align align) {
        this.mbackgroundTextureId = genbackgroundTexture(bitmap);
    }
}
