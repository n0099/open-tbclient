package com.google.ar.core;

import android.graphics.Rect;
import android.media.Image;
import com.google.ar.core.exceptions.FatalException;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class ArImage extends a.a.a {

    /* renamed from: e  reason: collision with root package name */
    public final Session f30927e;

    /* renamed from: f  reason: collision with root package name */
    public long f30928f;

    /* loaded from: classes6.dex */
    public class a extends a.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final long f30929a;

        /* renamed from: b  reason: collision with root package name */
        public final int f30930b;

        public a(long j, int i2) {
            this.f30929a = j;
            this.f30930b = i2;
        }

        @Override // android.media.Image.Plane
        public final ByteBuffer getBuffer() {
            ArImage arImage = ArImage.this;
            return arImage.nativeGetBuffer(arImage.f30927e.f30942a, this.f30929a, this.f30930b).asReadOnlyBuffer();
        }

        @Override // android.media.Image.Plane
        public final int getPixelStride() {
            ArImage arImage = ArImage.this;
            int nativeGetPixelStride = arImage.nativeGetPixelStride(arImage.f30927e.f30942a, this.f30929a, this.f30930b);
            if (nativeGetPixelStride != -1) {
                return nativeGetPixelStride;
            }
            throw new FatalException("Unknown error in ArImage.Plane.getPixelStride().");
        }

        @Override // android.media.Image.Plane
        public final int getRowStride() {
            ArImage arImage = ArImage.this;
            int nativeGetRowStride = arImage.nativeGetRowStride(arImage.f30927e.f30942a, this.f30929a, this.f30930b);
            if (nativeGetRowStride != -1) {
                return nativeGetRowStride;
            }
            throw new FatalException("Unknown error in ArImage.Plane.getRowStride().");
        }
    }

    private native void nativeClose(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native ByteBuffer nativeGetBuffer(long j, long j2, int i2);

    private native int nativeGetFormat(long j, long j2);

    private native int nativeGetHeight(long j, long j2);

    private native int nativeGetNumberOfPlanes(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetPixelStride(long j, long j2, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetRowStride(long j, long j2, int i2);

    private native long nativeGetTimestamp(long j, long j2);

    private native int nativeGetWidth(long j, long j2);

    public static native void nativeLoadSymbols();

    @Override // android.media.Image, java.lang.AutoCloseable
    public void close() {
        nativeClose(this.f30928f);
        this.f30928f = 0L;
    }

    @Override // android.media.Image
    public Rect getCropRect() {
        throw new UnsupportedOperationException("Crop rect is unknown in this image.");
    }

    @Override // android.media.Image
    public int getFormat() {
        int nativeGetFormat = nativeGetFormat(this.f30927e.f30942a, this.f30928f);
        if (nativeGetFormat != -1) {
            return nativeGetFormat;
        }
        throw new FatalException("Unknown error in ArImage.getFormat().");
    }

    @Override // android.media.Image
    public int getHeight() {
        int nativeGetHeight = nativeGetHeight(this.f30927e.f30942a, this.f30928f);
        if (nativeGetHeight != -1) {
            return nativeGetHeight;
        }
        throw new FatalException("Unknown error in ArImage.getHeight().");
    }

    @Override // android.media.Image
    public Image.Plane[] getPlanes() {
        int nativeGetNumberOfPlanes = nativeGetNumberOfPlanes(this.f30927e.f30942a, this.f30928f);
        if (nativeGetNumberOfPlanes != -1) {
            a[] aVarArr = new a[nativeGetNumberOfPlanes];
            for (int i2 = 0; i2 < nativeGetNumberOfPlanes; i2++) {
                aVarArr[i2] = new a(this.f30928f, i2);
            }
            return aVarArr;
        }
        throw new FatalException("Unknown error in ArImage.getPlanes().");
    }

    @Override // android.media.Image
    public long getTimestamp() {
        long nativeGetTimestamp = nativeGetTimestamp(this.f30927e.f30942a, this.f30928f);
        if (nativeGetTimestamp != -1) {
            return nativeGetTimestamp;
        }
        throw new FatalException("Unknown error in ArImage.getTimestamp().");
    }

    @Override // android.media.Image
    public int getWidth() {
        int nativeGetWidth = nativeGetWidth(this.f30927e.f30942a, this.f30928f);
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
