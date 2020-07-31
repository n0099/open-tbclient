package com.kascend.chushou.constants;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes6.dex */
public class AdExtraInfo implements Serializable {
    public List<AdTrackInfo> cTrack;
    public List<AdTrackInfo> clTrack;
    public List<AdTrackInfo> dTrack;
    public List<AdTrackInfo> dlTrack;
    public List<AdTrackInfo> eTrack;
    public String mActType;
    public long mAdvertAutoRefreshTimes;
    public String mAdvertDeepLink;
    public String mAdvertLink;
    public long mAdvertMaxFreshIntervalSecond;
    public long mAdvertMinFreshIntervalSecond;
    public String mAdvertRefreshUrl;
    public boolean mAutoPlayAudio;
    public String mClickId;
    public int mClickTimes;
    public String mCode;
    public String mDesc;
    public String mHtmpSnippet;
    public long mIntervalTime;
    public String mMarketId;
    public String mNavType;
    public String mPgkName;
    public String mPositionId;
    public String mShowType;
    public String marketPositionCode;
    public List<AdTrackInfo> vTrack;
    public boolean vTrackShow;
    public int mDisplayTagLocation = 1;
    public int mAdvertWidth = -1;
    public int mAdvertHeight = -1;
    public boolean mAdvertSelfOpen = false;

    public AdExtraInfo() {
        this.vTrackShow = false;
        this.vTrackShow = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdExtraInfo)) {
            return false;
        }
        AdExtraInfo adExtraInfo = (AdExtraInfo) obj;
        if (TextUtils.equals(this.mCode, adExtraInfo.mCode)) {
            return TextUtils.equals(this.mAdvertLink, adExtraInfo.mAdvertLink);
        }
        return false;
    }

    public int hashCode() {
        return ((this.mCode.hashCode() + 527) * 31) + this.mAdvertLink.hashCode();
    }

    public String toString() {
        return "AdExtraInfo{mCode='" + this.mCode + "', mMarketId='" + this.mMarketId + "', mPositionId='" + this.mPositionId + "', mDesc='" + this.mDesc + "', mClickTimes=" + this.mClickTimes + ", mHtmpSnippet='" + this.mHtmpSnippet + "', mActType='" + this.mActType + "', mNavType='" + this.mNavType + "', mShowType='" + this.mShowType + "', mAdvertLink='" + this.mAdvertLink + "', vTrack=" + this.vTrack + ", cTrack=" + this.cTrack + ", dTrack=" + this.dTrack + ", dlTrack=" + this.dlTrack + ", clTrack=" + this.clTrack + '}';
    }
}
