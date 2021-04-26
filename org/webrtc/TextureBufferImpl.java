package org.webrtc;

import android.graphics.Matrix;
import android.os.Handler;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import org.webrtc.VideoFrame;
/* loaded from: classes7.dex */
public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    public final int height;
    public final int id;
    public final RefCountDelegate refCountDelegate;
    public final Handler toI420Handler;
    public final Matrix transformMatrix;
    public final VideoFrame.TextureBuffer.Type type;
    public final int unscaledHeight;
    public final int unscaledWidth;
    public final int width;
    public final YuvConverter yuvConverter;

    public TextureBufferImpl(int i2, int i3, int i4, int i5, VideoFrame.TextureBuffer.Type type, int i6, Matrix matrix, Handler handler, YuvConverter yuvConverter, @Nullable Runnable runnable) {
        this.unscaledWidth = i2;
        this.unscaledHeight = i3;
        this.width = i4;
        this.height = i5;
        this.type = type;
        this.id = i6;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    public TextureBufferImpl(int i2, int i3, VideoFrame.TextureBuffer.Type type, int i4, Matrix matrix, Handler handler, YuvConverter yuvConverter, @Nullable Runnable runnable) {
        this.unscaledWidth = i2;
        this.unscaledHeight = i3;
        this.width = i2;
        this.height = i3;
        this.type = type;
        this.id = i4;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter;
        this.refCountDelegate = new RefCountDelegate(runnable);
    }

    private TextureBufferImpl applyTransformMatrix(Matrix matrix, int i2, int i3, int i4, int i5) {
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        retain();
        return new TextureBufferImpl(i2, i3, i4, i5, this.type, this.id, matrix2, this.toI420Handler, this.yuvConverter, new Runnable() { // from class: org.webrtc._$$Lambda$9teQ5BwuCad_aBl5uXiVcJ4zLnU
            @Override // java.lang.Runnable
            public final void run() {
                TextureBufferImpl.this.release();
            }
        });
    }

    public TextureBufferImpl applyTransformMatrix(Matrix matrix, int i2, int i3) {
        return applyTransformMatrix(matrix, i2, i3, i2, i3);
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.Buffer cropAndScale(int i2, int i3, int i4, int i5, int i6, int i7) {
        Matrix matrix = new Matrix();
        int i8 = this.height;
        matrix.preTranslate(i2 / this.width, (i8 - (i3 + i5)) / i8);
        matrix.preScale(i4 / this.width, i5 / this.height);
        return applyTransformMatrix(matrix, Math.round((this.unscaledWidth * i4) / this.width), Math.round((this.unscaledHeight * i5) / this.height), i6, i7);
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getHeight() {
        return this.height;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public int getTextureId() {
        return this.id;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    @Override // org.webrtc.VideoFrame.TextureBuffer
    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    public int getUnscaledHeight() {
        return this.unscaledHeight;
    }

    public int getUnscaledWidth() {
        return this.unscaledWidth;
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public int getWidth() {
        return this.width;
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void release() {
        this.refCountDelegate.release();
    }

    @Override // org.webrtc.VideoFrame.Buffer, org.webrtc.RefCounted
    public void retain() {
        this.refCountDelegate.retain();
    }

    @Override // org.webrtc.VideoFrame.Buffer
    public VideoFrame.I420Buffer toI420() {
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable() { // from class: org.webrtc._$$Lambda$TextureBufferImpl$LiRTMmF7eRfFNZfCJkIBMN6wcLQ
            @Override // java.util.concurrent.Callable
            public final Object call() {
                VideoFrame.I420Buffer convert;
                convert = r0.yuvConverter.convert(TextureBufferImpl.this);
                return convert;
            }
        });
    }
}
