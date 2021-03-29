package org.webrtc;

import javax.annotation.Nullable;
import org.webrtc.EglBase;
/* loaded from: classes7.dex */
public class PlatformSoftwareVideoDecoderFactory extends MediaCodecVideoDecoderFactory {
    public PlatformSoftwareVideoDecoderFactory(@Nullable EglBase.Context context) {
        super(context, MediaCodecUtils.SOFTWARE_IMPLEMENTATION_PREFIXES, new String[0]);
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
