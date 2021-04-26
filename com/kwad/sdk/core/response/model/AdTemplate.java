package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AdTemplate extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final long serialVersionUID = -5413539480595883024L;
    public int contentType;
    public String extra;
    public String impAdExtra;
    public long llsid;
    @Nullable
    public SceneImpl mAdScene;
    public int mBidEcpm;
    public transient boolean mContentPvReported;
    public transient String mCurrentTrendTitle;
    public transient boolean mDownloadFinishReported;
    public boolean mHasEntryAdClick;
    public transient boolean mHorizontalFeedSuggestPvReported;
    public transient boolean mHorizontalRelatedSuggestPvReported;
    public int mInitVoiceStatus;
    public boolean mIsTubeEpisodeList;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public String mPcursor;
    public int mPhotoResponseType;
    public transient boolean mPvReported;
    public transient boolean mRelatedContentPvReported;
    public transient String mTrendSlideType;
    public boolean needHide;
    public long posId;
    public int realShowType;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = new PhotoInfo();
    public LiveInfo mLiveInfo = new LiveInfo();
    public int positionShow = -1;
    public boolean mIsFromContent = false;
    public String mUniqueId = "";
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public PreloadData mPreloadData = new PreloadData();
    public int mMediaPlayerType = 0;
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public long mKsPlayerClickTimeParam = -1;
    public int mIsLeftSlipStatus = 0;
    public transient Map<String, Object> mLocalParams = new HashMap();

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null && TextUtils.isEmpty(this.mOriginJString)) {
            this.mOriginJString = jSONObject.toString();
        }
        this.realShowType = this.contentType;
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj);
    }

    @Nullable
    public <T> T getLocalParams(String str) {
        T t;
        if (TextUtils.isEmpty(str) || (t = (T) this.mLocalParams.get(str)) == null) {
            return null;
        }
        return t;
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public int hashCode() {
        String str = this.mUniqueId;
        return str != null ? str.hashCode() : super.hashCode();
    }

    @Nullable
    public Object putLocalParams(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mLocalParams.put(str, obj);
    }

    public void setShowPosition(int i2) {
        this.positionShow = i2;
    }
}
