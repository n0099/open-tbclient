package com.google.ar.core;

import android.graphics.Rect;
import android.media.Image;
import com.google.ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class ArImage extends com.baidu.tieba.e {
    public final Session a;
    public long b;

    private native void nativeClose(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native ByteBuffer nativeGetBuffer(long j, long j2, int i);

    private native int nativeGetFormat(long j, long j2);

    private native int nativeGetHeight(long j, long j2);

    private native int nativeGetNumberOfPlanes(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetPixelStride(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetRowStride(long j, long j2, int i);

    private native long nativeGetTimestamp(long j, long j2);

    private native int nativeGetWidth(long j, long j2);

    public static native void nativeLoadSymbols();

    /* loaded from: classes9.dex */
    public class a extends com.baidu.tieba.f {
        public final long a;
        public final int b;

        public a(long j, int i) {
            this.a = j;
            this.b = i;
        }

        @Override // android.media.Image.Plane
        public final ByteBuffer getBuffer() {
            ArImage arImage = ArImage.this;
            return arImage.nativeGetBuffer(arImage.a.a, this.a, this.b).asReadOnlyBuffer();
        }

        @Override // android.media.Image.Plane
        public final int getPixelStride() {
            ArImage arImage = ArImage.this;
            int nativeGetPixelStride = arImage.nativeGetPixelStride(arImage.a.a, this.a, this.b);
            if (nativeGetPixelStride != -1) {
                return nativeGetPixelStride;
            }
            throw new FatalException("Unknown error in ArImage.Plane.getPixelStride().");
        }

        @Override // android.media.Image.Plane
        public final int getRowStride() {
            ArImage arImage = ArImage.this;
            int nativeGetRowStride = arImage.nativeGetRowStride(arImage.a.a, this.a, this.b);
            if (nativeGetRowStride != -1) {
                return nativeGetRowStride;
            }
            throw new FatalException("Unknown error in ArImage.Plane.getRowStride().");
        }
    }

    @Override // android.media.Image, java.lang.AutoCloseable
    public void close() {
        nativeClose(this.b);
        this.b = 0L;
    }

    @Override // android.media.Image
    public Rect getCropRect() {
        throw new UnsupportedOperationException("Crop rect is unknown in this image.");
    }

    @Override // android.media.Image
    public int getFormat() {
        int nativeGetFormat = nativeGetFormat(this.a.a, this.b);
        if (nativeGetFormat != -1) {
            return nativeGetFormat;
        }
        throw new FatalException("Unknown error in ArImage.getFormat().");
    }

    @Override // android.media.Image
    public int getHeight() {
        int nativeGetHeight = nativeGetHeight(this.a.a, this.b);
        if (nativeGetHeight != -1) {
            return nativeGetHeight;
        }
        throw new FatalException("Unknown error in ArImage.getHeight().");
    }

    @Override // android.media.Image
    public Image.Plane[] getPlanes() {
        int nativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.a.a, this.b);
        if (nativeGetNumberOfPlanes != -1) {
            a[] aVarArr = new a[nativeGetNumberOfPlanes];
            for (int i = 0; i < nativeGetNumberOfPlanes; i++) {
                aVarArr[i] = new a(this.b, i);
            }
            return aVarArr;
        }
        throw new FatalException("Unknown error in ArImage.getPlanes().");
    }

    @Override // android.media.Image
    public long getTimestamp() {
        long nativeGetTimestamp = nativeGetTimestamp(this.a.a, this.b);
        if (nativeGetTimestamp != -1) {
            return nativeGetTimestamp;
        }
        throw new FatalException("Unknown error in ArImage.getTimestamp().");
    }

    @Override // android.media.Image
    public int getWidth() {
        int nativeGetWidth = nativeGetWidth(this.a.a, this.b);
        if (nativeGetWidth != -1) {
            return nativeGetWidth;
        }
        throw new FatalException("Unknown error in ArImage.getWidth().");
    }

    @Override // android.media.Image
    public void setCropRect(Rect rect) {
        throw new UnsupportedOperationException("This is a read-only image.");
    }

    @Override // android.media.Image
    public void setTimestamp(long j) {
        throw new UnsupportedOperationException("This is a read-only image.");
    }
}
