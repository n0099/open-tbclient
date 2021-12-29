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
/* loaded from: classes3.dex */
public class AdTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -5413539480595883024L;
    public int contentType;
    public String extra;
    public String impAdExtra;
    public long llsid;
    @Nullable
    public SceneImpl mAdScene;
    public int mBidEcpm;
    public transient boolean mContentPvReported;
    public transient boolean mDownloadFinishReported;
    public boolean mHasEntryAdClick;
    public transient boolean mHorizontalFeedSuggestPvReported;
    public transient boolean mHorizontalRelatedSuggestPvReported;
    public int mInitVoiceStatus;
    public boolean mIsNotNeedAvatarGuider;
    public boolean mIsTubeEpisodeList;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public String mPcursor;
    public int mPhotoResponseType;
    public transient boolean mPvReported;
    public transient boolean mRelatedContentPvReported;
    public int mRequestCount;
    public transient boolean mTrackUrlReported;
    public boolean needHide;
    public long posId;
    public int realShowType;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = new PhotoInfo();
    public PhotoAd photoAd = new PhotoAd();
    public NewsInfo newsInfo = new NewsInfo();
    public AggregatePageEntranceInfo aggregatePageEntranceInfo = new AggregatePageEntranceInfo();
    public LiveInfo mLiveInfo = new LiveInfo();
    public int positionShow = -1;
    public int serverPosition = -1;
    public boolean mIsFromContent = false;
    public boolean isDrawAdHasLook = false;
    public String mUniqueId = "";
    public transient String mMiniWindowId = null;
    public boolean mHasSelected = false;
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public PreloadData mPreloadData = new PreloadData();
    public int mMediaPlayerType = 0;
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public long mOutClickTimeParam = -1;
    public volatile long mVisibleTimeParam = -1;
    public int mIsLeftSlipStatus = 0;
    public boolean interactLandingPageShowing = false;
    public boolean mAdWebVideoPageShowing = false;
    public boolean mRewardVerifyCalled = false;
    public boolean mCheatingFlow = false;
    public boolean mXiaomiAppStoreDetailViewOpen = false;
    public boolean isWebViewDownload = false;
    public transient Map<String, Object> mLocalParams = new HashMap();

    @Override // com.kwad.sdk.core.response.kwai.a
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

    public int getServerPosition() {
        int i2 = this.serverPosition;
        return i2 != -1 ? i2 : getShowPosition();
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

    public void setCheatingFlow(boolean z) {
        if (this.mCheatingFlow) {
            return;
        }
        this.mCheatingFlow = z;
    }

    public void setServerPosition(int i2) {
        if (this.serverPosition == -1) {
            this.serverPosition = i2;
        }
    }

    public void setShowPosition(int i2) {
        this.positionShow = i2;
    }
}
