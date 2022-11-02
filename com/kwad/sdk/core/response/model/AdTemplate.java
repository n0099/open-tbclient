package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@KsJson
/* loaded from: classes8.dex */
public class AdTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -5413539480595883024L;
    public long adLoadTotalTime;
    public long adShowStartTimeStamp;
    public int adStyle;
    public long checkDataTime;
    public int contentType;
    public long downloadDuration;
    public String extra;
    public String impAdExtra;
    public boolean inPlayAgain;
    public long llsid;
    public long loadDataTime;
    @Nullable
    public SceneImpl mAdScene;
    public int mBidEcpm;
    public transient boolean mDownloadFinishReported;
    public long mDownloadFinishTime;
    public long mDownloadSize;
    public int mDownloadType;
    public int mInitVoiceStatus;
    public long mLoadDataTime;
    public boolean mLoadFromCache;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public int mPhotoResponseType;
    public transient boolean mPvReported;
    public transient boolean mTrackUrlReported;
    public boolean notNetworkRequest;
    public long posId;
    public int realShowType;
    public long showStartTime;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = createPhotoInfo();
    public int positionShow = -1;
    public transient int adxResult = -1;
    public int serverPosition = -1;
    public boolean mIsFromContent = false;
    public boolean hasEnterAdWebViewLandPageActivity = false;
    public String mUniqueId = "";
    public transient String mMiniWindowId = null;
    public boolean mHasSelected = false;
    public transient int downloadSource = 2;
    public transient String installFrom = "";
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
    public AdTemplate mPlayAgain = null;
    public boolean isPlayAgainData = false;
    public boolean watched = false;
    public boolean converted = false;
    public boolean fromCache = false;
    public transient Map<String, Object> mLocalParams = new HashMap();

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject != null) {
            if (TextUtils.isEmpty(this.mOriginJString)) {
                this.mOriginJString = jSONObject.toString();
            }
            PhotoInfo createPhotoInfo = createPhotoInfo();
            createPhotoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
            setPhotoInfo(createPhotoInfo);
        }
        this.realShowType = this.contentType;
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        r.a(jSONObject, "photoInfo", this.photoInfo);
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void beforeToJson(JSONObject jSONObject) {
        super.beforeToJson(jSONObject);
        if (TextUtils.isEmpty(this.mOriginJString)) {
            return;
        }
        try {
            s.merge(jSONObject, new JSONObject(this.mOriginJString));
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }

    public PhotoInfo createPhotoInfo() {
        return new PhotoInfo();
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

    public Map<String, Object> getLocalParams() {
        return this.mLocalParams;
    }

    public AdTemplate getPlayAgain() {
        return this.mPlayAgain;
    }

    public int getServerPosition() {
        int i = this.serverPosition;
        return i != -1 ? i : getShowPosition();
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public boolean hasPlayAgain() {
        return this.mPlayAgain != null;
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

    public void setPhotoInfo(PhotoInfo photoInfo) {
        this.photoInfo = photoInfo;
    }

    public void setPlayAgain(AdTemplate adTemplate) {
        this.mPlayAgain = adTemplate;
    }

    public void setServerPosition(int i) {
        if (this.serverPosition == -1) {
            this.serverPosition = i;
        }
    }

    public void setShowPosition(int i) {
        this.positionShow = i;
    }
}
