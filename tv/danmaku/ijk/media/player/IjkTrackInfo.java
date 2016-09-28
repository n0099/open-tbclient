package tv.danmaku.ijk.media.player;

import android.text.TextUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class IjkTrackInfo implements ITrackInfo {
    private IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setMediaMeta(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.ITrackInfo
    public IMediaFormat getFormat() {
        return new IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.ITrackInfo
    public String getLanguage() {
        return (this.mStreamMeta == null || TextUtils.isEmpty(this.mStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // tv.danmaku.ijk.media.player.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setTrackType(int i) {
        this.mTrackType = i;
    }

    public String toString() {
        return String.valueOf(getClass().getSimpleName()) + '{' + getInfoInline() + "}";
    }

    @Override // tv.danmaku.ijk.media.player.ITrackInfo
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
                sb.append("UNKNOWN");
                break;
        }
        return sb.toString();
    }
}
