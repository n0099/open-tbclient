package com.yy.mediaframework.inteligence.dynamictexture;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public abstract class AbstractDynamicTexture implements IDynamicTexture {
    public int createTexture(Bitmap bitmap, int i, int i2, float f, float f2) {
        return createTexture(bitmap, i, i2, (int) ((i * f) - (bitmap.getWidth() / 2.0f)), (int) ((i2 * f2) - (bitmap.getHeight() / 2.0f)));
    }

    private int genTextureId(int i, int i2, Buffer buffer) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, buffer);
        return iArr[0];
    }

    public int createTexture(Bitmap bitmap, int i, int i2, int i3, int i4) {
        int genTextureId = genTextureId(i, i2, ByteBuffer.wrap(new byte[i * i2 * 4]));
        GLUtils.texSubImage2D(3553, 0, i3, i4, bitmap, 6408, 5121);
        return genTextureId;
    }

    public void deleteTexture(int i) {
        if (i != -1) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }

    public int getXVisibleoffset(int i, int i2) {
        float f = (float) (1280.0d / i2);
        if (f > ((float) (720.0d / i))) {
            return (int) ((i - (720.0f / f)) / 2.0f);
        }
        return 0;
    }

    public int getYVisibleoffset(int i, int i2) {
        float f = (float) (720.0d / i);
        if (((float) (1280.0d / i2)) < f) {
            return (int) ((i2 - (1280.0f / f)) / 2.0f);
        }
        return 0;
    }
}
