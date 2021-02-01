package com.yy.audioengine;
/* loaded from: classes4.dex */
public final class Constant {

    /* loaded from: classes4.dex */
    public enum AudioCoderType {
        SILK_CODEC,
        AAC_PLUS_CODEC,
        AAC_ELD_CODEC,
        SPEEX_CODEC_8,
        SPEEX_CODEC_4,
        SPEEX_CODEC_2,
        AAC_LC_CODEC,
        WAV_CODEC
    }

    /* loaded from: classes4.dex */
    public enum AudioDeviceErrorType {
        AudioDeviceInitCaptureSuccess,
        AudioDeviceInitCaptureErrorOrNoPermission,
        AudioDeviceReleaseCaptureSuccess,
        AudioDeviceInitCaptureErrorMayOnBackGround,
        AudioDeviceCaptureRuntimeError,
        AudioDeviceInitRenderSuccess,
        AudioDeviceInitRenderError,
        AudioDeviceRenderRuntimeError,
        AudioDeviceInitRenderErrorMayOnBackGround,
        AudioDeviceStartRenderSuccess,
        AudioDeviceStopRenderSuccess,
        AudioDeviceStartRenderError
    }

    /* loaded from: classes4.dex */
    public enum AudioEngineMode {
        Voip,
        Common,
        SpeechMsg,
        Broadcast,
        HDVOIP,
        KaraokeOffLine
    }

    /* loaded from: classes4.dex */
    public enum AudioSaverMode {
        AudioSaverOnlyCapture,
        AudioSaverOnlyRender,
        AudioSaverBoth
    }

    /* loaded from: classes4.dex */
    public enum AudioSaverWriteFileMode {
        AudioSaverFileAppend,
        AudioSaverFileOverride
    }

    /* loaded from: classes4.dex */
    public enum AudioSourceType {
        AudioSourceTypeMic,
        AudioSourceTypeOuterPCM,
        AudioSourceTypeMix
    }

    /* loaded from: classes4.dex */
    public enum DenoiseModuleType {
        AecImproveNsType,
        SpeexNsType,
        WebrtcNsType
    }

    /* loaded from: classes4.dex */
    public enum EncoderType {
        SILK,
        LC_AAC,
        EAAC_PLUS,
        OPUS_COMMON,
        OPUS_16KHZ,
        OPUS_48KHZ
    }

    /* loaded from: classes4.dex */
    public enum ReverbMode {
        ReverbNone,
        ReverbPopular,
        ReverbRNB,
        ReverbDance,
        ReverbKTV
    }

    /* loaded from: classes4.dex */
    public enum VoiceBeautifyMode {
        VoiceSoft,
        VoiceClearness,
        VoiceWarm,
        VoiceSweet,
        VoiceBrightness,
        VoiceVigorous
    }

    /* loaded from: classes4.dex */
    public enum VoiceChangerMode {
        VeoNone,
        VeoEthereal,
        VeoThriller,
        VeoLuBan,
        VeoLorie,
        VeoUncle,
        VeoDieFat,
        VeoBadBoy,
        VeoWarCraft,
        VeoHeavyMetal,
        VeoCold,
        VeoHeavyMechinery,
        VeoTrappedBeast,
        VeoPowerCurrent
    }
}
