package org.webrtc;

import javax.annotation.Nullable;
import org.webrtc.EglBase;
/* loaded from: classes7.dex */
public class HardwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    @Deprecated
    public HardwareVideoDecoderFactory() {
        this(null);
    }

    public HardwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        super(context, new String[]{""}, MediaCodecUtils.SOFTWARE_IMPLEMENTATION_PREFIXES);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    @Nullable
    public /* bridge */ /* synthetic */ VideoDecoder createDecoder(VideoCodecInfo videoCodecInfo) {
        return super.createDecoder(videoCodecInfo);
    }

    @Override // org.webrtc.MediaCodecVideoDecoderFactory, org.webrtc.VideoDecoderFactory
    public /* bridge */ /* synthetic */ VideoCodecInfo[] getSupportedCodecs() {
        return super.getSupportedCodecs();
    }
}
