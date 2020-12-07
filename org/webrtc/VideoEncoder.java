package org.webrtc;

import android.support.annotation.Nullable;
import org.webrtc.EncodedImage;
/* loaded from: classes12.dex */
public interface VideoEncoder {

    /* loaded from: classes12.dex */
    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        @CalledByNative("BitrateAllocation")
        public BitrateAllocation(int[][] iArr) {
            this.bitratesBbs = iArr;
        }

        public int getSum() {
            int[][] iArr = this.bitratesBbs;
            int length = iArr.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i;
                for (int i4 : iArr[i2]) {
                    i3 += i4;
                }
                i2++;
                i = i3;
            }
            return i;
        }
    }

    /* loaded from: classes12.dex */
    public interface Callback {
        void onEncodedFrame(EncodedImage encodedImage, CodecSpecificInfo codecSpecificInfo);
    }

    /* loaded from: classes12.dex */
    public static class CodecSpecificInfo {
    }

    /* loaded from: classes12.dex */
    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    /* loaded from: classes12.dex */
    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    /* loaded from: classes12.dex */
    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    /* loaded from: classes12.dex */
    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        @CalledByNative("EncodeInfo")
        public EncodeInfo(EncodedImage.FrameType[] frameTypeArr) {
            this.frameTypes = frameTypeArr;
        }
    }

    /* loaded from: classes12.dex */
    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();
        @Nullable
        public final Integer high;
        @Nullable
        public final Integer low;
        public final boolean on;

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        public ScalingSettings(int i, int i2) {
            this.on = true;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }

        @Deprecated
        public ScalingSettings(boolean z) {
            this.on = z;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean z, int i, int i2) {
            this.on = z;
            this.low = Integer.valueOf(i);
            this.high = Integer.valueOf(i2);
        }

        public String toString() {
            if (this.on) {
                return "[ " + this.low + ", " + this.high + " ]";
            }
            return "OFF";
        }
    }

    /* loaded from: classes12.dex */
    public static class Settings {
        public final boolean automaticResizeOn;
        public final int height;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int startBitrate;
        public final int width;

        @CalledByNative("Settings")
        public Settings(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            this.numberOfCores = i;
            this.width = i2;
            this.height = i3;
            this.startBitrate = i4;
            this.maxFramerate = i5;
            this.numberOfSimulcastStreams = i6;
            this.automaticResizeOn = z;
        }
    }

    @CalledByNative
    long createNativeVideoEncoder();

    @CalledByNative
    VideoCodecStatus encode(VideoFrame videoFrame, EncodeInfo encodeInfo);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback callback);

    @CalledByNative
    boolean isHardwareEncoder();

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus setRateAllocation(BitrateAllocation bitrateAllocation, int i);
}
