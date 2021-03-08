package com.yy.mediaframework;
/* loaded from: classes6.dex */
public final class Constant {
    public static final String DEFAULT_LOG_NAME = "yyvideosdk.txt";
    public static final String DEFAULT_LOG_PATH = "/yyvideosdk";
    public static final int IFRAME_INTERVAL = 3;
    public static final String MEDIACODE_API = "[Api     ]";
    public static final String MEDIACODE_BEAUTY = "[Beauty  ]";
    public static final String MEDIACODE_CAMERACAPTURE = "[CCapture]";
    public static final String MEDIACODE_DECODER = "[Decoder ]";
    public static final String MEDIACODE_ENCODER = "[Encoder ]";
    public static final String MEDIACODE_PREPROCESS = "[Preproce]";
    public static final String MEDIACODE_PREVIEW = "[Preview ]";
    public static final String MEDIACODE_PROCEDURE = "[Procedur]";
    public static final String MEDIACODE_RENDER = "[Render  ]";
    public static final String MEDIACODE_SCREENCAPTURE = "[SCapture]";
    public static final String MEDIACODE_SSRC = "[SSRC]";
    public static final String MEDIACODE_UTIL = "[Util    ]";
    public static float[] mtxIdentity = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* loaded from: classes6.dex */
    public static class AlignmentMask {
        public static final int ALIGN_16 = 15;
        public static final int ALIGN_2 = 1;
        public static final int ALIGN_32 = 31;
        public static final int ALIGN_4 = 3;
        public static final int ALIGN_8 = 7;
    }

    /* loaded from: classes6.dex */
    public enum AnchorStatus {
        AnchorStatus_Previewing,
        AnchorStatus_Encoding
    }

    /* loaded from: classes6.dex */
    public static final class CameraState {
        public static final int CAMERA_CAPTURE_STATUS_AUTHORIZED = 1;
        public static final int CAMERA_CAPTURE_STATUS_CLOSE = 5;
        public static final int CAMERA_CAPTURE_STATUS_DENIED = 4;
        public static final int CAMERA_CAPTURE_STATUS_NOT_DETERMINED = 2;
        public static final int CAMERA_CAPTURE_STATUS_RESTRICTED = 3;
        public static final int CAMERA_CAPTURE_STATUS_SUCCESS = 0;
    }

    /* loaded from: classes6.dex */
    public enum CaptureFpsMode {
        AlignEncoder,
        FullSpeed
    }

    /* loaded from: classes6.dex */
    public enum CaptureMode {
        TextureMode,
        YuvMode
    }

    /* loaded from: classes6.dex */
    public static class CaptureType {
        public static final int CAMERA = 1;
        public static final int CUSTOM = 3;
        public static final int NONE = 0;
        public static final int SCREEN = 2;
    }

    /* loaded from: classes6.dex */
    public static final class CaptureVideoOrientation {
        public static final int LandscapeLeft = 4;
        public static final int LandscapeRight = 3;
        public static final int Portrait = 1;
        public static final int PortraitUpsideDown = 2;
    }

    /* loaded from: classes6.dex */
    public static class CommonCfg {
        public static final String canvasOrGl = "canvasOrGl";
        public static final String captureFpsMode = "captureFpsMode";
        public static final String disableBeauty = "disableBeauty";
        public static final String encoderInput = "encoderInput";
        public static final String yuvCapture = "yuvCapture";
    }

    /* loaded from: classes6.dex */
    public enum EncodedStream {
        NoneStream,
        CameraStream,
        ScreenStream,
        OriginStream
    }

    /* loaded from: classes6.dex */
    public enum EncoderFilterType {
        ENCODER_FILTER_UNKNONWN,
        ENCODER_HARDWARE_H264,
        ENCODER_SOFTWARE_H264
    }

    /* loaded from: classes6.dex */
    public enum EncoderInputMode {
        SURFACE,
        BUFFER,
        UDEF
    }

    /* loaded from: classes6.dex */
    public enum ExtraPerformance {
        PsnrMode
    }

    /* loaded from: classes6.dex */
    public static class HiidoEncCodecID {
        public static final int ENC_CODEC_H264_HARD = 3;
        public static final int ENC_CODEC_H264_SOFT = 1;
        public static final int ENC_CODEC_H265_HARD = 4;
        public static final int ENC_CODEC_H265_SOFT = 2;
        public static final int ENC_CODEC_NONE = 0;
        public static final int ENC_CODEC_VP8_HARD = 6;
        public static final int ENC_CODEC_VP8_SOFT = 5;
        public static final int ENC_CODEC_VP9_HARD = 8;
        public static final int ENC_CODEC_VP9_SOFT = 7;
    }

    /* loaded from: classes6.dex */
    public static class MIME {
        public static final String H264 = "video/avc";
        public static final String H265 = "video/hevc";
    }

    /* loaded from: classes6.dex */
    public static final class MediaLibraryPictureFormat {
        public static final int kMediaLibraryPictureFmtI410 = 1;
        public static final int kMediaLibraryPictureFmtI411 = 2;
        public static final int kMediaLibraryPictureFmtI420 = 3;
        public static final int kMediaLibraryPictureFmtI422 = 4;
        public static final int kMediaLibraryPictureFmtI440 = 5;
        public static final int kMediaLibraryPictureFmtI444 = 6;
        public static final int kMediaLibraryPictureFmtNV12 = 7;
        public static final int kMediaLibraryPictureFmtNV16 = 9;
        public static final int kMediaLibraryPictureFmtNV21 = 8;
        public static final int kMediaLibraryPictureFmtNV61 = 10;
        public static final int kMediaLibraryPictureFmtRGB15 = 15;
        public static final int kMediaLibraryPictureFmtRGB16 = 16;
        public static final int kMediaLibraryPictureFmtRGB24 = 17;
        public static final int kMediaLibraryPictureFmtRGB32 = 18;
        public static final int kMediaLibraryPictureFmtRGBA = 19;
        public static final int kMediaLibraryPictureFmtUYVY = 13;
        public static final int kMediaLibraryPictureFmtUnknown = 0;
        public static final int kMediaLibraryPictureFmtVYUY = 14;
        public static final int kMediaLibraryPictureFmtYUYV = 11;
        public static final int kMediaLibraryPictureFmtYVYU = 12;
    }

    /* loaded from: classes6.dex */
    public static final class MediaLibraryVideoCodec {
        public static final int kMediaLibraryVideoCodecH264 = 2;
        public static final int kMediaLibraryVideoCodecH265 = 5;
        public static final int kMediaLibraryVideoCodecPicture = 1;
        public static final int kMediaLibraryVideoCodecUnknown = 0;
        public static final int kMediaLibraryVideoCodecVP8 = 4;
    }

    /* loaded from: classes6.dex */
    public enum MultiLianmaiMode {
        NormalMode,
        TwoPersonMode,
        ThreePersonMode,
        FourPersonMode,
        FivePersonMode,
        SixPersonMode,
        SevenPersonMode,
        EightPersonMode,
        NinePersonMode
    }

    /* loaded from: classes6.dex */
    public enum OrientationType {
        Normal,
        Auto,
        Forace
    }

    /* loaded from: classes6.dex */
    public enum PreviewMode {
        TextureMode,
        GlSurfaceMode,
        CanvasMode
    }

    /* loaded from: classes6.dex */
    public static class ProgramType {
        public static final int PROGRAM_TYPE_I420 = 3;
        public static final int PROGRAM_TYPE_NV12 = 2;
        public static final int PROGRAM_TYPE_NV21 = 1;
        public static final int PROGRAM_TYPE_OES = 4;
        public static final int PROGRAM_TYPE_TEX2D = 0;
        public static final int PROGRAM_TYPE_UDEF = 4;
    }

    /* loaded from: classes6.dex */
    public static class RGBFormat {
        public static final int RGB = 20;
        public static final int RGB565 = 52;
        public static final int RGBA = 36;
        public static final int UDEF = 68;
    }

    /* loaded from: classes6.dex */
    public static class RotateAngle {
        public static final int ROTATION_0 = 0;
        public static final int ROTATION_180 = 180;
        public static final int ROTATION_270 = 270;
        public static final int ROTATION_90 = 90;
    }

    /* loaded from: classes6.dex */
    public enum ScaleMode {
        AspectFill,
        AspectFit,
        ScacleToFill
    }

    /* loaded from: classes6.dex */
    public static class TextureType {
        public static final int Texture_2D = 69;
        public static final int Texture_OES = 70;
    }

    /* loaded from: classes6.dex */
    public static class VideoCommonConfigMode {
        public static final int Normal = 0;
        public static final int YUV_CANVAS_NOBEAUTY_YUV = 1;
        public static final int YUV_TEXTURE = 2;
    }

    /* loaded from: classes6.dex */
    public static class VideoEncodePreset {
        public static final long VIDEO_ENCODE_PRESET_DEFAULT = 0;
        public static final long VIDEO_ENCODE_PRESET_FAST = 5;
        public static final long VIDEO_ENCODE_PRESET_FASTER = 4;
        public static final long VIDEO_ENCODE_PRESET_MEDIUM = 6;
        public static final long VIDEO_ENCODE_PRESET_SLOW = 7;
        public static final long VIDEO_ENCODE_PRESET_SUPERFAST = 2;
        public static final long VIDEO_ENCODE_PRESET_ULTRAFAST = 1;
        public static final long VIDEO_ENCODE_PRESET_VERYFAST = 3;
    }

    /* loaded from: classes6.dex */
    public static final class VideoFrameType {
        public static final int kVideoBFrame = 2;
        public static final int kVideoEncodedDataFrame = 8;
        public static final int kVideoFrameNodeNV12 = 101;
        public static final int kVideoFrameNodeNV21 = 102;
        public static final int kVideoFrameNodeYV12 = 100;
        public static final int kVideoH265HeadFrame = 9;
        public static final int kVideoHeaderFrame = 7;
        public static final int kVideoIDRFrame = 4;
        public static final int kVideoIFrame = 0;
        public static final int kVideoPFrame = 1;
        public static final int kVideoPFrameSEI = 3;
        public static final int kVideoPPSFrame = 6;
        public static final int kVideoSPSFrame = 5;
        public static final int kVideoUnknowFrame = 255;
    }

    /* loaded from: classes6.dex */
    public enum VideoStreamType {
        Camera,
        Screen,
        OriginData,
        Undef
    }

    /* loaded from: classes6.dex */
    public enum WaterMarkOrigin {
        LeftTop,
        LeftBottom,
        RightTop,
        RightBottom
    }

    /* loaded from: classes6.dex */
    public static class YMFScaleMode {
        public static final int ASPECT_FIT = 0;
        public static final int CLIP_TO_BOUNDS = 1;
    }

    /* loaded from: classes6.dex */
    public static class YUVFormat {
        public static final int I420 = 2;
        public static final int NV12 = 1;
        public static final int NV21 = 0;
        public static final int UDEF = 4;
        public static final int YV12 = 3;
    }

    /* loaded from: classes6.dex */
    public class PublishType {
        public static final int VIDEO_STREAM_TYPE_HIGH = 0;
        public static final int VIDEO_STREAM_TYPE_LOW = 1;

        public PublishType() {
        }
    }

    /* loaded from: classes6.dex */
    public static class EncoderState {
        public static final int EncoderStateError = 4;
        public static final int EncoderStateInit = 0;
        public static final int EncoderStateStarted = 2;
        public static final int EncoderStateStarting = 1;
        public static final int EncoderStateStoped = 3;

        public static boolean isStart(int i) {
            return i == 1 || i == 2;
        }

        public static boolean isStoped(int i) {
            return i == 3;
        }

        public static boolean blockStream(int i) {
            return i == 3 || i == 0;
        }
    }
}
