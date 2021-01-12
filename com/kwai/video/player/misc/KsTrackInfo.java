package com.kwai.video.player.misc;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.kwai.video.player.KsMediaMeta;
/* loaded from: classes4.dex */
public class KsTrackInfo implements ITrackInfo {
    private KsMediaMeta.KSYStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public KsTrackInfo(KsMediaMeta.KSYStreamMeta kSYStreamMeta) {
        this.mStreamMeta = kSYStreamMeta;
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public IMediaFormat getFormat() {
        return new KsMediaFormat(this.mStreamMeta);
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getInfoInline() {
        StringBuilder sb = new StringBuilder(128);
        switch (this.mTrackType) {
            case 1:
                sb.append("VIDEO");
                sb.append(", ");
                sb.append(this.mStreamMeta.getCodecShortNameInline());
                sb.append(", ");
                sb.append(this.mStreamMeta.getBitrateInline());
                sb.append(", ");
                sb.append(this.mStreamMeta.getResolutionInline());
                break;
            case 2:
                sb.append("AUDIO");
                sb.append(", ");
                sb.append(this.mStreamMeta.getCodecShortNameInline());
                sb.append(", ");
                sb.append(this.mStreamMeta.getBitrateInline());
                sb.append(", ");
                sb.append(this.mStreamMeta.getSampleRateInline());
                break;
            case 3:
                sb.append("TIMEDTEXT");
                break;
            case 4:
                sb.append("SUBTITLE");
                break;
            default:
                sb.append(RomUtils.UNKNOWN);
                break;
        }
        return sb.toString();
    }

    @Override // com.kwai.video.player.misc.ITrackInfo
    public String getLanguage() {
        return (this.mStreamMeta == null || TextUtils.isEmpty(this.mStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
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
        return getClass().getSimpleName() + '{' + getInfoInline() + "}";
    }
}
