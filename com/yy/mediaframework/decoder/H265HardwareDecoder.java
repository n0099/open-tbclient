package com.yy.mediaframework.decoder;

import androidx.annotation.NonNull;
import com.yy.mediaframework.decoder.OMXDecoderRank;
import com.yy.mediaframework.model.DecodeVideoSample;
/* loaded from: classes4.dex */
public class H265HardwareDecoder extends BaseHardwareDecoder {
    private static final String MIME = "video/hevc";
    static String codeName;
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.video.", "OMX.TI.", "OMX.SEC.", "OMX.Exynos.", "OMX.Nvidia.", "OMX.IMG.", "OMX.amlogic", "OMX.MTK.", "OMX.k3."};
    private static final String[] unSupportedH264HwCodecPrefixes = {"OMX.Nvidia.h264.decode.secure", "OMX.SEC.avcdec", "OMX.TI.DUCATI1.VIDEO.DECODER", "OMX.SEC.AVC.Decoder"};

    static {
        OMXDecoderRank.DecoderInfo bestH265Decoder = OMXDecoderRank.instance().getBestH265Decoder();
        if (bestH265Decoder != null) {
            codeName = bestH265Decoder.name();
        }
    }

    @Override // com.yy.mediaframework.decoder.BaseHardwareDecoder, com.yy.mediaframework.decoder.BaseDecoder
    public long drainDecoder(@NonNull DecodeVideoSample decodeVideoSample) {
        return super.drainDecoder(decodeVideoSample);
    }

    public H265HardwareDecoder(int i, int i2) {
        super(i, i2, codeName, "video/hevc");
    }
}
