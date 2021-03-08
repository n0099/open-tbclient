package com.yy.mediaframework.gles;

import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class Drawable2d {
    private static final int SIZEOF_FLOAT = 4;
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;
    private static final float[] TRIANGLE_COORDS = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
    private static final float[] TRIANGLE_TEX_COORDS = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static final FloatBuffer TRIANGLE_BUF = GlUtil.createFloatBuffer(TRIANGLE_COORDS);
    private static final FloatBuffer TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
    private static final float[] RECTANGLE_COORDS = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
    private static final float[] RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final FloatBuffer RECTANGLE_BUF = GlUtil.createFloatBuffer(RECTANGLE_COORDS);
    private static final FloatBuffer RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
    public static final float[] FULL_RECTANGLE_COORDS = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] FULL_RECTANGLE_TEX_COORDS_FLIP_HORIZONTAL = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] FULL_RECTANGLE_TEX_COORDS_FLIP_VERTICAL = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final FloatBuffer FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_COORDS);
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    public static final FloatBuffer FULL_RECTANGLE_TEX_HORIZONTAL_FLIP_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS_FLIP_HORIZONTAL);
    public static final FloatBuffer FULL_RECTANGLE_TEX_VERTICAL_FLIP_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS_FLIP_VERTICAL);

    /* loaded from: classes6.dex */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE,
        FULL_RECTANGLE_FLIP_HORIZONTAL,
        FULL_RECTANGLE_FLIP_VERTICAL
    }

    public Drawable2d(Prefab prefab) {
        switch (prefab) {
            case TRIANGLE:
                this.mVertexArray = TRIANGLE_BUF;
                this.mTexCoordArray = TRIANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = TRIANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case RECTANGLE:
                this.mVertexArray = RECTANGLE_BUF;
                this.mTexCoordArray = RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case FULL_RECTANGLE:
                this.mVertexArray = FULL_RECTANGLE_BUF;
                this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case FULL_RECTANGLE_FLIP_HORIZONTAL:
                this.mVertexArray = FULL_RECTANGLE_BUF;
                this.mTexCoordArray = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS_FLIP_HORIZONTAL);
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            case FULL_RECTANGLE_FLIP_VERTICAL:
                this.mVertexArray = FULL_RECTANGLE_BUF;
                this.mTexCoordArray = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS_FLIP_VERTICAL);
                this.mCoordsPerVertex = 2;
                this.mVertexStride = this.mCoordsPerVertex * 4;
                this.mVertexCount = FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex;
                break;
            default:
                throw new RuntimeException("Unknown shape " + prefab);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public Drawable2d() {
        this(Prefab.FULL_RECTANGLE);
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public String toString() {
        return this.mPrefab != null ? "[Drawable2d: " + this.mPrefab + "]" : "[Drawable2d: ...]";
    }

    public void clipVertex(int i, int i2, int i3, int i4, int i5) {
        float[] fArr = new float[8];
        float f = i / i2;
        float f2 = i3 / i4;
        System.arraycopy(FULL_RECTANGLE_COORDS, 0, fArr, 0, FULL_RECTANGLE_COORDS.length);
        if (i5 == 1) {
            if (f < f2) {
                float f3 = f2 / f;
                fArr[1] = fArr[1] * f3;
                fArr[3] = fArr[3] * f3;
                fArr[5] = fArr[5] * f3;
                fArr[7] = f3 * fArr[7];
            } else {
                float f4 = f / f2;
                fArr[0] = fArr[0] * f4;
                fArr[2] = fArr[2] * f4;
                fArr[4] = fArr[4] * f4;
                fArr[6] = f4 * fArr[6];
            }
        } else if (i5 == 0) {
            if (f < f2) {
                float f5 = f / f2;
                fArr[0] = fArr[0] * f5;
                fArr[2] = fArr[2] * f5;
                fArr[4] = fArr[4] * f5;
                fArr[6] = f5 * fArr[6];
            } else {
                float f6 = f2 / f;
                fArr[1] = fArr[1] * f6;
                fArr[3] = fArr[3] * f6;
                fArr[5] = fArr[5] * f6;
                fArr[7] = f6 * fArr[7];
            }
        } else if (f < f2) {
            float f7 = f / f2;
            fArr[0] = fArr[0] * f7;
            fArr[2] = fArr[2] * f7;
            fArr[4] = fArr[4] * f7;
            fArr[6] = f7 * fArr[6];
        } else {
            float f8 = f2 / f;
            fArr[1] = fArr[1] * f8;
            fArr[3] = fArr[3] * f8;
            fArr[5] = fArr[5] * f8;
            fArr[7] = f8 * fArr[7];
        }
        this.mVertexArray = GlUtil.createFloatBuffer(fArr);
    }

    public void resetVertex() {
        this.mVertexArray = FULL_RECTANGLE_BUF;
    }
}
