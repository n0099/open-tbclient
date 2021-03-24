package com.kwai.player;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.RequiresApi;
/* loaded from: classes6.dex */
public class KwaiHdrCodecCapabilities {
    public static KwaiHdrCodecCapabilities sHdrCapabilitiesUtil;
    public boolean misInited = false;
    public String mHdr10 = "";
    public String mHdrDolby = "";
    public String mHdrVp9 = "";

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
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        String str2;
        if (this.misInited) {
            return;
        }
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                for (String str3 : codecInfoAt.getSupportedTypes()) {
                    if (str3.equalsIgnoreCase("video/hevc")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecInfoAt.getCapabilitiesForType("video/hevc").profileLevels) {
                            if (codecProfileLevel.profile == 4096 && !this.mHdr10.contains("HEVCProfileMain10HDR10")) {
                                this.mHdr10 = "HEVCProfileMain10HDR10";
                            }
                        }
                    }
                    if (str3.equalsIgnoreCase("video/x-vnd.on2.vp9")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecInfoAt.getCapabilitiesForType("video/x-vnd.on2.vp9").profileLevels) {
                            int i2 = codecProfileLevel2.profile;
                            if (i2 != 4096) {
                                if (i2 == 8192 && !this.mHdrVp9.contains("VP9Profile3HDR")) {
                                    sb2 = new StringBuilder();
                                    sb2.append(this.mHdrVp9);
                                    str2 = "VP9Profile3HDR, ";
                                    sb2.append(str2);
                                    this.mHdrVp9 = sb2.toString();
                                }
                            } else if (!this.mHdrVp9.contains("VP9Profile2HDR")) {
                                sb2 = new StringBuilder();
                                sb2.append(this.mHdrVp9);
                                str2 = "VP9Profile2HDR, ";
                                sb2.append(str2);
                                this.mHdrVp9 = sb2.toString();
                            }
                        }
                    }
                    if (str3.equalsIgnoreCase("video/dolby-vision")) {
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel3 : codecInfoAt.getCapabilitiesForType("video/dolby-vision").profileLevels) {
                            int i3 = codecProfileLevel3.profile;
                            if (i3 != 1) {
                                if (i3 != 2) {
                                    if (i3 != 4) {
                                        if (i3 != 8) {
                                            if (i3 != 16) {
                                                if (i3 != 32) {
                                                    if (i3 != 64) {
                                                        if (i3 == 128 && !this.mHdrDolby.contains("DolbyVisionProfileDvheDtb")) {
                                                            sb = new StringBuilder();
                                                            sb.append(this.mHdrDolby);
                                                            str = "DolbyVisionProfileDvheDtb, ";
                                                            sb.append(str);
                                                            this.mHdrDolby = sb.toString();
                                                        }
                                                    } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDth")) {
                                                        sb = new StringBuilder();
                                                        sb.append(this.mHdrDolby);
                                                        str = "DolbyVisionProfileDvheDth, ";
                                                        sb.append(str);
                                                        this.mHdrDolby = sb.toString();
                                                    }
                                                } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheStn")) {
                                                    sb = new StringBuilder();
                                                    sb.append(this.mHdrDolby);
                                                    str = "DolbyVisionProfileDvheStn, ";
                                                    sb.append(str);
                                                    this.mHdrDolby = sb.toString();
                                                }
                                            } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDtr")) {
                                                sb = new StringBuilder();
                                                sb.append(this.mHdrDolby);
                                                str = "DolbyVisionProfileDvheDtr, ";
                                                sb.append(str);
                                                this.mHdrDolby = sb.toString();
                                            }
                                        } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDen")) {
                                            sb = new StringBuilder();
                                            sb.append(this.mHdrDolby);
                                            str = "DolbyVisionProfileDvheDen, ";
                                            sb.append(str);
                                            this.mHdrDolby = sb.toString();
                                        }
                                    } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvheDer")) {
                                        sb = new StringBuilder();
                                        sb.append(this.mHdrDolby);
                                        str = "DolbyVisionProfileDvheDer, ";
                                        sb.append(str);
                                        this.mHdrDolby = sb.toString();
                                    }
                                } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvavPen")) {
                                    sb = new StringBuilder();
                                    sb.append(this.mHdrDolby);
                                    str = "DolbyVisionProfileDvavPen, ";
                                    sb.append(str);
                                    this.mHdrDolby = sb.toString();
                                }
                            } else if (!this.mHdrDolby.contains("DolbyVisionProfileDvavPer")) {
                                sb = new StringBuilder();
                                sb.append(this.mHdrDolby);
                                str = "DolbyVisionProfileDvavPer, ";
                                sb.append(str);
                                this.mHdrDolby = sb.toString();
                            }
                        }
                    }
                }
            }
        }
        this.misInited = true;
    }
}
