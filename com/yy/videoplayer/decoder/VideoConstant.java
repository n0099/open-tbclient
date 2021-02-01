package com.yy.videoplayer.decoder;
/* loaded from: classes4.dex */
public final class VideoConstant {
    public static final int GUEST_UID_MAX = Integer.MAX_VALUE;
    public static final int GUEST_UID_MIN = 2140000000;
    public static final int IMAGE_COMPRESS_RATE = 75;
    public static final int IMAGE_SCALE_HEIGHT = 800;
    public static final int IMAGE_SCALE_WIDTH = 800;
    public static final int MAX_PHOTO_NUMBER = 8;
    public static final int MAX_REMARK_LENGTH = 20;
    public static final String MEDIACODE_CAMERA = "[Camera]";
    public static final String MEDIACODE_CAP = "[Capture]";
    public static final String MEDIACODE_DECODER = "[Decoder]";
    public static final String MEDIACODE_ENCODER = "[Encoder]";
    public static final String MEDIACODE_PREPRO = "[Preprocess]";
    public static final String MEDIACODE_RENDER = "[Render]";
    public static final String MEDIACODE_VIEW_LIVE_STAT = "[ViewLiveStat]";
    public static final int MIN_IMAGE_SIZE = 100;
    public static final int MOB_ONLINE = 2;
    public static final int OFF_LINE = 0;
    public static final int OTHER_ONLINE = 3;
    public static final int PORTRAIT_PICTURE_ID = 1;
    public static final int THUMBNAIL_WIDTH = 320;
    public static final int WIFI_ONLINE = 1;
    public static boolean powerfulCpuDevice;

    /* loaded from: classes4.dex */
    public enum CameraType {
        FACING_FRONT,
        FACING_BACK
    }

    /* loaded from: classes4.dex */
    public static final class CaptureVideoOrientation {
        public static final int LandscapeLeft = 4;
        public static final int LandscapeRight = 3;
        public static final int Portrait = 1;
        public static final int PortraitUpsideDown = 2;
    }

    /* loaded from: classes4.dex */
    public static final class DecoderType {
        public static final int ADNROID_HARD_DECODER2 = 2;
        public static final int ANDROID_HARD_DECODER1 = 1;
        public static final int IOS_HARD_DECODER = 3;
        public static final int SOFT_DEOCDER = 0;
    }

    /* loaded from: classes4.dex */
    public static final class ErrorType {
        public static final int Normal = 0;
        public static final int ParamError = -1;
        public static final int ViewNotFoundError = -2;
    }

    /* loaded from: classes4.dex */
    public static final class MediaQualityLevel {
        public static final int Custom = 4;
        public static final int High = 2;
        public static final int Known = 3;
        public static final int Low = 0;
        public static final int Medium = 1;
    }

    /* loaded from: classes4.dex */
    public enum MirrorMode {
        Disabled,
        Enabled
    }

    /* loaded from: classes4.dex */
    public enum OrientationType {
        Normal,
        Auto,
        Force
    }

    /* loaded from: classes4.dex */
    public static final class RenderType {
        public static final int MEDAICODEC_H264 = 0;
        public static final int MEDAICODEC_H265 = 1;
        public static final int MEDAICODEC_VP8 = 5;
        public static final int RENDERFRAMEBUFFER = 2;
        public static final int VIEW_CANVAS = 3;
        public static final int YMFRENDER = 4;
    }

    /* loaded from: classes4.dex */
    public enum RotationAngle {
        ROTATION_0,
        ROTATION_90,
        ROTATION_180,
        ROTATION_270
    }

    /* loaded from: classes4.dex */
    public enum ScaleMode {
        FillParent,
        AspectFit,
        ClipToBounds,
        Original
    }

    /* loaded from: classes4.dex */
    public static final class VideoEncodePreset {
        public static final int DEFAULT = 0;
        public static final int FAST = 5;
        public static final int FASTER = 4;
        public static final int MEDIUM = 6;
        public static final int SLOW = 7;
        public static final int SUPERFAST = 2;
        public static final int ULTRAFAST = 1;
        public static final int VERYFAST = 3;
    }

    /* loaded from: classes4.dex */
    public static final class VideoFormat {
        public static final int H264 = 2;
        public static final int H265 = 5;
        public static final int PICTURE = 1;
        public static final int UNKNOW = 0;
        public static final int VP8 = 4;
    }

    /* loaded from: classes4.dex */
    public enum VideoViewMode {
        SingeMode,
        MultiMode
    }

    /* loaded from: classes4.dex */
    public enum VideoViewType {
        GLView,
        SFView,
        TXView,
        SFHardView,
        TXHardView,
        CustomGLView
    }

    /* loaded from: classes4.dex */
    public static final class ViewState {
        public static final int STARTRENDER = 0;
        public static final int STOPRENDER = 1;
    }

    /* loaded from: classes4.dex */
    public enum ViewType {
        SURFACE_VIDEO_VIEW,
        NO_GL_VIDEO_VIEW,
        NO_GL_VIDEO_VIEW_MULTIVIDEO,
        CUSTOM_GL_VIDEO_VIEW_LOW,
        CUSTOM_GL_VIDEO_VIEW_LOW_MULTIVIDEO,
        CUSTOM_GL_VIDEO_VIEW_HIGH,
        CUSTOM_GL_VIDEO_VIEW_HIGH_MULTIVIDEO,
        GL_VIDEO_VIEW,
        GL_VIDEO_VIEW_MULTIVIDEO,
        GL_VIDEO_VIEW_GLSURFACE
    }

    /* loaded from: classes4.dex */
    public enum WaterMarkOrigin {
        LeftTop,
        LeftBottom,
        RightTop,
        RightBottom
    }

    /* loaded from: classes4.dex */
    public static class ExtraData {
        public int[] layouts;
        public int ssrc;

        public ExtraData(int[] iArr, int i) {
            this.layouts = iArr;
            this.ssrc = i;
        }
    }
}
