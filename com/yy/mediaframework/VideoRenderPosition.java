package com.yy.mediaframework;

import com.yy.mediaframework.gpuimage.util.TextureRotationUtil;
import com.yy.mediaframework.model.Rect;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
/* loaded from: classes6.dex */
public class VideoRenderPosition {
    public static final int FILLMODE_INNERFIT = 1;
    public static final int FILLMODE_OUTERFIT = 2;
    private static final String TAG = "VideoRenderPositon";
    static final float[] VERTEX_COOR = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public int channalId;
    public int fillMode;
    private FloatBuffer mGLTextureBuffer;
    public Rect position;
    public int srcWidth = -1;
    public int srcHeight = -1;
    public int dstWidth = -1;
    public int dstHeight = -1;
    FloatBuffer mTargetVertexBuffer = ByteBuffer.allocateDirect(VERTEX_COOR.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public VideoRenderPosition(int i, Rect rect, int i2) {
        this.channalId = i;
        this.position = rect;
        this.fillMode = i2;
        this.mTargetVertexBuffer.put(VERTEX_COOR).position(0);
        this.mGLTextureBuffer = ByteBuffer.allocateDirect(TextureRotationUtil.FULL_RECTANGLE_TEX_COORDS.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
    }

    public FloatBuffer getPositionBuffer(boolean z) {
        if (this.position == null) {
            YMFLog.info(this, "[Util    ]", "getPositionBuffer:: position is null.");
            return this.mTargetVertexBuffer;
        }
        float f = (-1.0f) + (this.position.left * 2.0f);
        float f2 = (-1.0f) + (this.position.right * 2.0f);
        float f3 = (-1.0f) + (this.position.top * 2.0f);
        float f4 = (this.position.bottom * 2.0f) - 1.0f;
        if (z) {
            f3 = 0.0f - f3;
            f4 = 0.0f - f4;
        }
        this.mTargetVertexBuffer.put(0, f);
        this.mTargetVertexBuffer.put(1, f4);
        this.mTargetVertexBuffer.put(2, f2);
        this.mTargetVertexBuffer.put(3, f4);
        this.mTargetVertexBuffer.put(4, f);
        this.mTargetVertexBuffer.put(5, f3);
        this.mTargetVertexBuffer.put(6, f2);
        this.mTargetVertexBuffer.put(7, f3);
        return this.mTargetVertexBuffer;
    }

    public FloatBuffer convertPositionBuffer(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = (i3 * 1.0f) / i4;
        float f6 = (i * 1.0f) / i2;
        if (f5 <= f6) {
            f4 = -(f5 / f6);
            f3 = f5 / f6;
            f2 = -1.0f;
            f = 1.0f;
        } else {
            f = f6 / f5;
            f2 = -(f6 / f5);
            f3 = 1.0f;
            f4 = -1.0f;
        }
        this.mTargetVertexBuffer.put(0, f4);
        this.mTargetVertexBuffer.put(1, f2);
        this.mTargetVertexBuffer.put(2, f3);
        this.mTargetVertexBuffer.put(3, f2);
        this.mTargetVertexBuffer.put(4, f4);
        this.mTargetVertexBuffer.put(5, f);
        this.mTargetVertexBuffer.put(6, f3);
        this.mTargetVertexBuffer.put(7, f);
        return this.mTargetVertexBuffer;
    }

    public FloatBuffer convertTextureBuffer(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        if (this.srcWidth == 0 || this.srcHeight == 0 || this.dstWidth == 0 || this.dstHeight == 0) {
            YMFLog.warn(this, "[Util    ]", "invalid size, return default texture coordinations");
            return this.mGLTextureBuffer;
        }
        float f3 = (this.srcWidth * 1.0f) / this.srcHeight;
        float f4 = (this.dstWidth * 1.0f) / this.dstHeight;
        if (this.srcWidth * this.dstHeight != this.srcHeight * this.dstWidth) {
            if (this.srcWidth == 720 && this.srcHeight == 1280) {
                if (f3 < f4) {
                    f = (1.0f - (f3 / f4)) * 0.5f;
                    f2 = 0.0f;
                }
            } else if (this.srcWidth == 1280 && this.srcHeight == 720) {
                if (f3 > f4) {
                    f2 = 0.5f * (1.0f - (f4 / f3));
                    f = 0.0f;
                }
            } else if (this.srcWidth == 480 && this.srcHeight == 640) {
                if (f3 > f4) {
                    f2 = 0.5f * (1.0f - f4);
                    f = 0.0f;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
            } else if (this.srcWidth == 640 && this.srcHeight == 480) {
                if (f3 < f4) {
                    f = 0.0f;
                    f2 = 0.0f;
                } else {
                    f2 = 0.21875f;
                    f = 0.0f;
                }
            }
            float f5 = 1.0f - f2;
            float f6 = 1.0f - f;
            this.mGLTextureBuffer.put(0, f2);
            this.mGLTextureBuffer.put(1, f);
            this.mGLTextureBuffer.put(2, f5);
            this.mGLTextureBuffer.put(3, f);
            this.mGLTextureBuffer.put(4, f2);
            this.mGLTextureBuffer.put(5, f6);
            this.mGLTextureBuffer.put(6, f5);
            this.mGLTextureBuffer.put(7, f6);
            return this.mGLTextureBuffer;
        }
        f = 0.0f;
        f2 = 0.0f;
        float f52 = 1.0f - f2;
        float f62 = 1.0f - f;
        this.mGLTextureBuffer.put(0, f2);
        this.mGLTextureBuffer.put(1, f);
        this.mGLTextureBuffer.put(2, f52);
        this.mGLTextureBuffer.put(3, f);
        this.mGLTextureBuffer.put(4, f2);
        this.mGLTextureBuffer.put(5, f62);
        this.mGLTextureBuffer.put(6, f52);
        this.mGLTextureBuffer.put(7, f62);
        return this.mGLTextureBuffer;
    }

    public FloatBuffer getDefaultTextureBuffer() {
        this.mGLTextureBuffer.rewind();
        this.mGLTextureBuffer.put(TextureRotationUtil.TEXTURE_NO_ROTATION).position(0);
        return this.mGLTextureBuffer;
    }

    public FloatBuffer getDefaultVertexBuffer() {
        this.mTargetVertexBuffer.rewind();
        this.mTargetVertexBuffer.put(VERTEX_COOR).position(0);
        return this.mTargetVertexBuffer;
    }
}
