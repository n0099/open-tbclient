package com.kwai.video.player.misc;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.kwai.video.player.KsMediaMeta;
/* loaded from: classes6.dex */
public class KsTrackInfo implements ITrackInfo {
    public KsMediaMeta.KSYStreamMeta mStreamMeta;
    public int mTrackType = 0;

    public KsTrackInfo(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        this.mStreamMeta = kSYStreamMeta;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new KsMediaFormat(this.mStreamMeta);
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getInfoInline() {
        String resolutionInline;
        StringBuilder sb = new StringBuilder(128);
        int i = this.mTrackType;
        if (i == 1) {
            sb.append(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO);
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            resolutionInline = this.mStreamMeta.getResolutionInline();
        } else if (i != 2) {
            resolutionInline = i != 3 ? i != 4 ? RomUtils.UNKNOWN : "SUBTITLE" : "TIMEDTEXT";
        } else {
            sb.append("AUDIO");
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            resolutionInline = this.mStreamMeta.getSampleRateInline();
        }
        sb.append(resolutionInline);
        return sb.toString();
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getLanguage() {
        KsMediaMeta.KSYStreamMeta kSYStreamMeta = this.mStreamMeta;
        return (kSYStreamMeta == null || TextUtils.isEmpty(kSYStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        this.mStreamMeta = kSYStreamMeta;
    }

    public void setTrackType(int i) {
        this.mTrackType = i;
    }

    public String toString() {
        return KsTrackInfo.class.getSimpleName() + '{' + getInfoInline() + "}";
    }
}
