package com.kwai.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.RequiresApi;
/* loaded from: classes5.dex */
public class KwaiHdrCodecCapabilities {
    private static KwaiHdrCodecCapabilities sHdrCapabilitiesUtil = null;
    private boolean misInited = false;
    private String mHdr10 = "";
    private String mHdrDolby = "";
    private String mHdrVp9 = "";

    public static synchronized KwaiHdrCodecCapabilities getInstance() {
        KwaiHdrCodecCapabilities kwaiHdrCodecCapabilities;
        synchronized (KwaiHdrCodecCapabilities.class) {
            if (sHdrCapabilitiesUtil == null) {
                sHdrCapabilitiesUtil = new KwaiHdrCodecCapabilities();
            }
            kwaiHdrCodecCapabilities = sHdrCapabilitiesUtil;
        }
        return kwaiHdrCodecCapabilities;
    }

    public String getHdr10() {
        return this.mHdr10;
    }

    public String getHdrDolby() {
        return this.mHdrDolby;
    }

    public String getHdrVp9() {
        return this.mHdrVp9;
    }

    @RequiresApi(api = 16)
    @TargetApi(21)
    public void init(Context context) {
        String[] supportedTypes;
        if (this.misInited) {
            return;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    if (str.equalsIgnoreCase("video/hevc")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType("video/hevc").profileLevels) {
                            if (codecProfileLevel.profile == 4096 && !this.mHdr10.contains("HEVCProfileMain10HDR10")) {
                                this.mHdr10 = "HEVCProfileMain10HDR10";
                            }
                        }
                    }
                    if (str.equalsIgnoreCase("video/x-vnd.on2.vp9")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecInfoAt.getCapabilitiesForType("video/x-vnd.on2.vp9").profileLevels) {
                            switch (codecProfileLevel2.profile) {
                                case 4096:
                                    if (this.mHdrVp9.contains("VP9Profile2HDR")) {
                                        break;
                                    } else {
                                        this.mHdrVp9 += "VP9Profile2HDR, ";
                                        break;
                                    }
                                case 8192:
                                    if (this.mHdrVp9.contains("VP9Profile3HDR")) {
                                        break;
                                    } else {
                                        this.mHdrVp9 += "VP9Profile3HDR, ";
                                        break;
                                    }
                            }
                        }
                    }
                    if (str.equalsIgnoreCase("video/dolby-vision")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel3 : codecInfoAt.getCapabilitiesForType("video/dolby-vision").profileLevels) {
                            switch (codecProfileLevel3.profile) {
                                case 1:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvavPer")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvavPer, ";
                                        break;
                                    }
                                case 2:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvavPen")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvavPen, ";
                                        break;
                                    }
                                case 4:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvheDer")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvheDer, ";
                                        break;
                                    }
                                case 8:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvheDen")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvheDen, ";
                                        break;
                                    }
                                case 16:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvheDtr")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvheDtr, ";
                                        break;
                                    }
                                case 32:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvheStn")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvheStn, ";
                                        break;
                                    }
                                case 64:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvheDth")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvheDth, ";
                                        break;
                                    }
                                case 128:
                                    if (this.mHdrDolby.contains("DolbyVisionProfileDvheDtb")) {
                                        break;
                                    } else {
                                        this.mHdrDolby += "DolbyVisionProfileDvheDtb, ";
                                        break;
                                    }
                            }
                        }
                    }
                }
            }
        }
        this.misInited = true;
    }
}
