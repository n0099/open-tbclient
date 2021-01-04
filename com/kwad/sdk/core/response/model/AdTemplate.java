package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.live.mode.LiveInfo;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdTemplate implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = -5413539480595883024L;
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
    private int positionShow = -1;
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
        this.contentType = jSONObject.optInt(CameraActivityConfig.KEY_CONTENT_TYPE, 0);
        this.realShowType = this.contentType;
        this.needHide = jSONObject.optBoolean("needHide");
        this.impAdExtra = jSONObject.optString("impAdExtra");
        JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AdInfo adInfo = new AdInfo();
                    adInfo.parseJson(optJSONObject);
                    this.adInfoList.add(adInfo);
                }
            }
        }
        this.photoInfo.parseJson(jSONObject.optJSONObject("photoInfo"));
        this.mUniqueId = jSONObject.optString("uniqueId");
        if (TextUtils.isEmpty(this.mUniqueId)) {
            this.mUniqueId = String.valueOf(UUID.randomUUID());
        }
    }

    public void setShowPosition(int i) {
        this.positionShow = i;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "posId", this.posId);
        o.a(jSONObject, "type", this.type);
        o.a(jSONObject, CameraActivityConfig.KEY_CONTENT_TYPE, this.contentType);
        o.a(jSONObject, "adInfo", this.adInfoList);
        o.a(jSONObject, "photoInfo", this.photoInfo);
        o.a(jSONObject, "uniqueId", this.mUniqueId);
        o.a(jSONObject, "needHide", this.needHide);
        o.a(jSONObject, "impAdExtra", this.impAdExtra);
        return jSONObject;
    }
}
