package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdTemplate implements com.kwad.sdk.core.b, Serializable {
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
    public int mInitVoiceStatus;
    public boolean mIsTubeEpisodeList;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public String mPcursor;
    public int mPhotoResponseType;
    public transient boolean mPvReported;
    public transient String mTrendSlideType;
    public boolean needHide;
    public long posId;
    public int realShowType;
    public int type;
    public List<AdInfo> adInfoList = new ArrayList();
    public PhotoInfo photoInfo = new PhotoInfo();
    public int positionShow = -1;
    public String mUniqueId = "";
    public transient int downloadSource = 2;
    public transient String installFrom = "";
    public PreloadData mPreloadData = new PreloadData();
    public int mMediaPlayerType = 0;
    public LiveInfo mLiveInfo = new LiveInfo();
    public VideoPlayerStatus mVideoPlayerStatus = new VideoPlayerStatus();
    public long mKsPlayerClickTimeParam = -1;
    public int mIsLeftSlipStatus = 0;

    public boolean equals(@Nullable Object obj) {
        return obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj);
    }

    public int getShowPosition() {
        return this.positionShow;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mOriginJString = jSONObject.toString();
        this.posId = jSONObject.optLong("posId");
        this.type = jSONObject.optInt("type");
        int optInt = jSONObject.optInt("contentType", 0);
        this.contentType = optInt;
        this.realShowType = optInt;
        this.needHide = jSONObject.optBoolean("needHide");
        this.impAdExtra = jSONObject.optString("impAdExtra");
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    AdInfo adInfo = new AdInfo();
                    adInfo.parseJson(optJSONObject);
                    this.adInfoList.add(adInfo);
                }
            }
        }
        this.photoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
        String optString = jSONObject.optString("uniqueId");
        this.mUniqueId = optString;
        if (TextUtils.isEmpty(optString)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    public void setShowPosition(int i2) {
        this.positionShow = i2;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.posId);
        o.a(jSONObject, "type", this.type);
        o.a(jSONObject, "contentType", this.contentType);
        o.a(jSONObject, "adInfo", this.adInfoList);
        o.a(jSONObject, "photoInfo", this.photoInfo);
        o.a(jSONObject, "uniqueId", this.mUniqueId);
        o.a(jSONObject, "needHide", this.needHide);
        o.a(jSONObject, "impAdExtra", this.impAdExtra);
        return jSONObject;
    }
}
