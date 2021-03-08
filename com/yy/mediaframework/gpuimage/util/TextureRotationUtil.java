package com.yy.mediaframework.gpuimage.util;
/* loaded from: classes6.dex */
public class TextureRotationUtil {
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_ROTATED_90 = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    public static final float[] TEXTURE_ROTATED_180 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] TEXTURE_ROTATED_270 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    private TextureRotationUtil() {
    }

    public static float[] getRotation(Rotation rotation, boolean z, boolean z2) {
        float[] fArr;
        switch (rotation) {
            case ROTATION_90:
                fArr = TEXTURE_ROTATED_90;
                break;
            case ROTATION_180:
                fArr = TEXTURE_ROTATED_180;
                break;
            case ROTATION_270:
                fArr = TEXTURE_ROTATED_270;
                break;
            default:
                fArr = TEXTURE_NO_ROTATION;
                break;
        }
        float[] fArr2 = z ? new float[]{flip(fArr[0]), fArr[1], flip(fArr[2]), fArr[3], flip(fArr[4]), fArr[5], flip(fArr[6]), fArr[7]} : fArr;
        return z2 ? new float[]{fArr2[0], flip(fArr2[1]), fArr2[2], flip(fArr2[3]), fArr2[4], flip(fArr2[5]), fArr2[6], flip(fArr2[7])} : fArr2;
    }

    private static float flip(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }
}
