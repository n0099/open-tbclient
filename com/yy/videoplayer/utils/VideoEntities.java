package com.yy.videoplayer.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.mobstat.Config;
import com.yy.videoplayer.Constant;
import java.util.Locale;
/* loaded from: classes4.dex */
public class VideoEntities {

    /* loaded from: classes4.dex */
    public static class VideoData {
        public byte[] data;
        public long pts;
    }

    /* loaded from: classes4.dex */
    public static class VideoInfo {
        public int width = 0;
        public int height = 0;
        public double frameRate = 0.0d;
        public double bitRateInKbps = 0.0d;
        public boolean videoStabilization = false;
    }

    /* loaded from: classes4.dex */
    public static class WaterMark {
        public int height;
        public int offsetx;
        public int offsety;
        public Constant.WaterMarkOrigin origin;
        public byte[] rgba32data;
        public int width;
    }

    /* loaded from: classes4.dex */
    public static class RectSize {
        public int mHeight;
        public int mWidth;

        public RectSize(int i, int i2) {
            this.mWidth = i;
            this.mHeight = i2;
        }
    }

    /* loaded from: classes4.dex */
    public static class VideoSizes {
        public int mViewHeight;
        public int mViewWidth;
        public int mViewX;
        public int mViewY;
        public int mVideoWidth = 64;
        public int mVideoHeight = 64;
        public int mVideoSurfaceWidth = 64;
        public int mVideoSurfaceHeight = 64;
        public int mVideoParentWidth = 64;
        public int mVideoParentHeight = 64;

        public String toString() {
            return String.format(Locale.getDefault(), "mViewX = %d, mViewY = %d, \nmViewWidth = %d, mViewHeight = %d, \nmVideoWidth = %d, mVideoHeight = %d, \nmVideoSurfaceWidth = %d, mVideoSurfaceHeight = %d", Integer.valueOf(this.mViewX), Integer.valueOf(this.mViewY), Integer.valueOf(this.mViewWidth), Integer.valueOf(this.mViewHeight), Integer.valueOf(this.mVideoWidth), Integer.valueOf(this.mVideoHeight), Integer.valueOf(this.mVideoSurfaceWidth), Integer.valueOf(this.mVideoSurfaceHeight));
        }
    }

    /* loaded from: classes4.dex */
    public static class VideoParameters implements Parcelable {
        public static final Parcelable.Creator<VideoParameters> CREATOR = new Parcelable.Creator<VideoParameters>() { // from class: com.yy.videoplayer.utils.VideoEntities.VideoParameters.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VideoParameters createFromParcel(Parcel parcel) {
                return new VideoParameters(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public VideoParameters[] newArray(int i) {
                return new VideoParameters[i];
            }
        };
        public int bitRateInKbps;
        public int cameraFacing;
        public CodecItem.CodecId codecId;
        public int frameRate;
        public int height;
        public boolean saveVideoToFile;
        public String videoFileName;
        public boolean videoStabilization;
        public int width;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.width);
            parcel.writeInt(this.height);
            parcel.writeInt(this.frameRate);
            parcel.writeInt(this.bitRateInKbps);
            parcel.writeInt(this.cameraFacing);
            parcel.writeString(this.videoFileName);
            parcel.writeValue(Boolean.valueOf(this.videoStabilization));
            parcel.writeValue(Boolean.valueOf(this.saveVideoToFile));
            parcel.writeValue(this.codecId);
        }

        public VideoParameters() {
            this.width = 720;
            this.height = 1280;
            this.frameRate = 24;
            this.bitRateInKbps = FeatureCodes.FACE;
            this.codecId = CodecItem.CodecId.HARD_ENCODER_H264;
            this.videoStabilization = true;
            this.cameraFacing = 1;
            this.saveVideoToFile = false;
            this.videoFileName = "/storage/sdcard0/SimpleCapture.Video.HARD_ENCODER_H264";
        }

        public VideoParameters(Parcel parcel) {
            this.width = 720;
            this.height = 1280;
            this.frameRate = 24;
            this.bitRateInKbps = FeatureCodes.FACE;
            this.codecId = CodecItem.CodecId.HARD_ENCODER_H264;
            this.videoStabilization = true;
            this.cameraFacing = 1;
            this.saveVideoToFile = false;
            this.videoFileName = "/storage/sdcard0/SimpleCapture.Video.HARD_ENCODER_H264";
            this.width = parcel.readInt();
            this.height = parcel.readInt();
            this.frameRate = parcel.readInt();
            this.bitRateInKbps = parcel.readInt();
            this.cameraFacing = parcel.readInt();
            this.videoFileName = parcel.readString();
            this.videoStabilization = ((Boolean) parcel.readValue(getClass().getClassLoader())).booleanValue();
            this.saveVideoToFile = ((Boolean) parcel.readValue(getClass().getClassLoader())).booleanValue();
            this.codecId = (CodecItem.CodecId) parcel.readValue(getClass().getClassLoader());
        }
    }

    /* loaded from: classes4.dex */
    public static class ScreenRecordConfig {
        private int mScreenWidth = 0;
        private int mScreenHeight = 0;

        public void setScreenSize(int i, int i2) {
            this.mScreenWidth = i;
            this.mScreenHeight = i2;
        }

        public int getWidth() {
            return this.mScreenWidth;
        }

        public int getHeight() {
            return this.mScreenHeight;
        }
    }

    /* loaded from: classes4.dex */
    public static class CameraPreviewConfig {
        private int mCameraFacing;
        private int mOrientation;
        private int mPreviewHeight;
        private int mPreviewWidth;

        public CameraPreviewConfig() {
            this.mPreviewWidth = 0;
            this.mPreviewHeight = 0;
        }

        public CameraPreviewConfig(int i, int i2, int i3, int i4) {
            this.mPreviewWidth = 0;
            this.mPreviewHeight = 0;
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
            this.mCameraFacing = i3;
            this.mOrientation = i4;
        }

        public void assign(CameraPreviewConfig cameraPreviewConfig) {
            this.mPreviewWidth = cameraPreviewConfig.mPreviewWidth;
            this.mPreviewHeight = cameraPreviewConfig.mPreviewHeight;
            this.mCameraFacing = cameraPreviewConfig.mCameraFacing;
            this.mOrientation = cameraPreviewConfig.mOrientation;
        }

        public void setPreviewSize(int i, int i2) {
            this.mPreviewWidth = i;
            this.mPreviewHeight = i2;
        }

        public int getWidth() {
            return this.mPreviewWidth;
        }

        public int getHeight() {
            return this.mPreviewHeight;
        }

        public void setCameraFacing(int i) {
            this.mCameraFacing = i;
        }

        public void setOrientation(int i) {
            this.mOrientation = i;
        }

        public int getOrientation() {
            return this.mOrientation;
        }

        public int getCameraFacing() {
            return this.mCameraFacing;
        }

        public String toString() {
            return String.format(Locale.getDefault(), "CameraPreviewConfig: Size(%d x %d), facing：%d, Orientation: %d", Integer.valueOf(this.mPreviewWidth), Integer.valueOf(this.mPreviewHeight), Integer.valueOf(this.mCameraFacing), Integer.valueOf(this.mOrientation));
        }
    }

    /* loaded from: classes4.dex */
    public static class ResolutionItem {
        public int height;
        public String showText;
        public int width;

        public ResolutionItem(int i, int i2) {
            this.width = i;
            this.height = i2;
            this.showText = "" + i + Config.EVENT_HEAT_X + i2;
        }

        public String toString() {
            return this.showText;
        }
    }

    /* loaded from: classes4.dex */
    public static class BitRateItem {
        public int bitrateInKbps;
        public String showText;

        public BitRateItem(int i) {
            this.bitrateInKbps = i;
            this.showText = "" + i + "Kbps";
        }

        public String toString() {
            return this.showText;
        }
    }

    /* loaded from: classes4.dex */
    public static class FrameRateItem {
        public int frameRate;
        public String showText;

        public FrameRateItem(int i) {
            this.frameRate = i;
            this.showText = "" + i + AlaRecorderLog.KEY_CANERA_START_FPS;
        }

        public String toString() {
            return this.showText;
        }
    }

    /* loaded from: classes4.dex */
    public static class CodecItem {
        public CodecId codecId;
        public String showText;

        /* loaded from: classes4.dex */
        public enum CodecId {
            SOFT_ENCODER_X264,
            HARD_ENCODER_H264,
            HARD_ENCODER_H265
        }

        public CodecItem(CodecId codecId) {
            this.codecId = codecId;
            this.showText = "" + codecId;
        }

        public String toString() {
            return this.showText;
        }
    }

    /* loaded from: classes4.dex */
    public static class CameraItem {
        public int cameraFacing;
        public String showText;

        public CameraItem(int i) {
            this.cameraFacing = i;
            if (i == 1) {
                this.showText = "前置";
            } else {
                this.showText = "后置";
            }
        }

        public String toString() {
            return this.showText;
        }
    }
}
