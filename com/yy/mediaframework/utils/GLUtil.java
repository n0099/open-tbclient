package com.yy.mediaframework.utils;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import com.yy.mediaframework.PictureInPictureDisplayInfo;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class GLUtil {
    private static final String TAG = "GLUtil";

    public static int genTexture(int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(i, iArr[0]);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        GLES20.glTexParameteri(i, 10242, 33071);
        GLES20.glTexParameteri(i, 10243, 33071);
        GLES20.glTexImage2D(i, 0, 6408, i2, i3, 0, 6408, 5121, null);
        return iArr[0];
    }

    public static int genTextureWithBitmap(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glActiveTexture(33989);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    public static void updateVertexBuffer(FloatBuffer floatBuffer, PictureInPictureDisplayInfo pictureInPictureDisplayInfo) {
        if (pictureInPictureDisplayInfo == null) {
            YMFLog.error((Object) null, "[Util    ]", "invalid PictureInPictureDisplayInfo");
            return;
        }
        floatBuffer.put(0, 1.0f - pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(1, (pictureInPictureDisplayInfo.bottomOffset - 1.0f) + pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(2, 1.0f);
        floatBuffer.put(3, (pictureInPictureDisplayInfo.bottomOffset - 1.0f) + pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(4, 1.0f - pictureInPictureDisplayInfo.scaleRatio);
        floatBuffer.put(5, pictureInPictureDisplayInfo.bottomOffset - 1.0f);
        floatBuffer.put(6, 1.0f);
        floatBuffer.put(7, pictureInPictureDisplayInfo.bottomOffset - 1.0f);
    }

    public static float[] rotateTextureMatrix(float[] fArr, float f) {
        float[] fArr2 = new float[16];
        Matrix.setRotateM(fArr2, 0, f, 0.0f, 0.0f, -1.0f);
        adjustOrigin(fArr2);
        return multiplyMatrices(fArr, fArr2);
    }

    private static void adjustOrigin(float[] fArr) {
        fArr[12] = fArr[12] - ((fArr[0] + fArr[4]) * 0.5f);
        fArr[13] = fArr[13] - ((fArr[1] + fArr[5]) * 0.5f);
        fArr[12] = fArr[12] + 0.5f;
        fArr[13] = fArr[13] + 0.5f;
    }

    public static float[] multiplyMatrices(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        Matrix.multiplyMM(fArr3, 0, fArr, 0, fArr2, 0);
        return fArr3;
    }
}
