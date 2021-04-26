package org.webrtc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class EncodedImage {
    public final ByteBuffer buffer;
    public final long captureTimeMs;
    public final long captureTimeNs;
    public final boolean completeFrame;
    public final int encodedHeight;
    public final int encodedWidth;
    public final FrameType frameType;
    public final Integer qp;
    public final int rotation;

    /* loaded from: classes7.dex */
    public static class Builder {
        public ByteBuffer buffer;
        public long captureTimeNs;
        public boolean completeFrame;
        public int encodedHeight;
        public int encodedWidth;
        public FrameType frameType;
        public Integer qp;
        public int rotation;

        public Builder() {
        }

        public EncodedImage createEncodedImage() {
            return new EncodedImage(this.buffer, this.encodedWidth, this.encodedHeight, this.captureTimeNs, this.frameType, this.rotation, this.completeFrame, this.qp);
        }

        public Builder setBuffer(ByteBuffer byteBuffer) {
            this.buffer = byteBuffer;
            return this;
        }

        @Deprecated
        public Builder setCaptureTimeMs(long j) {
            this.captureTimeNs = TimeUnit.MILLISECONDS.toNanos(j);
            return this;
        }

        public Builder setCaptureTimeNs(long j) {
            this.captureTimeNs = j;
            return this;
        }

        public Builder setCompleteFrame(boolean z) {
            this.completeFrame = z;
            return this;
        }

        public Builder setEncodedHeight(int i2) {
            this.encodedHeight = i2;
            return this;
        }

        public Builder setEncodedWidth(int i2) {
            this.encodedWidth = i2;
            return this;
        }

        public Builder setFrameType(FrameType frameType) {
            this.frameType = frameType;
            return this;
        }

        public Builder setQp(Integer num) {
            this.qp = num;
            return this;
        }

        public Builder setRotation(int i2) {
            this.rotation = i2;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public enum FrameType {
        EmptyFrame(0),
        VideoFrameKey(3),
        VideoFrameDelta(4);
        
        public final int nativeIndex;

        FrameType(int i2) {
            this.nativeIndex = i2;
        }

        @CalledByNative("FrameType")
        public static FrameType fromNativeIndex(int i2) {
            FrameType[] values;
            for (FrameType frameType : values()) {
                if (frameType.getNative() == i2) {
                    return frameType;
                }
            }
            throw new IllegalArgumentException("Unknown native frame type: " + i2);
        }

        public int getNative() {
            return this.nativeIndex;
        }
    }

    @CalledByNative
    public EncodedImage(ByteBuffer byteBuffer, int i2, int i3, long j, FrameType frameType, int i4, boolean z, Integer num) {
        this.buffer = byteBuffer;
        this.encodedWidth = i2;
        this.encodedHeight = i3;
        this.captureTimeMs = TimeUnit.NANOSECONDS.toMillis(j);
        this.captureTimeNs = j;
        this.frameType = frameType;
        this.rotation = i4;
        this.completeFrame = z;
        this.qp = num;
    }

    public static Builder builder() {
        return new Builder();
    }
}
