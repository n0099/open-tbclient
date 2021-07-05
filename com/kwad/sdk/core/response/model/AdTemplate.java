package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5413539480595883024L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdInfo> adInfoList;
    public int contentType;
    public transient int downloadSource;
    public String extra;
    public String impAdExtra;
    public transient String installFrom;
    public long llsid;
    @Nullable
    public SceneImpl mAdScene;
    public int mBidEcpm;
    public transient boolean mContentPvReported;
    public transient String mCurrentTrendTitle;
    public transient boolean mDownloadFinishReported;
    public boolean mHasEntryAdClick;
    public int mInitVoiceStatus;
    public int mIsLeftSlipStatus;
    public boolean mIsTubeEpisodeList;
    public long mKsPlayerClickTimeParam;
    public LiveInfo mLiveInfo;
    public int mMediaPlayerType;
    public String mOriginJString;
    public PageInfo mPageInfo;
    public String mPcursor;
    public int mPhotoResponseType;
    public PreloadData mPreloadData;
    public transient boolean mPvReported;
    public transient String mTrendSlideType;
    public String mUniqueId;
    public VideoPlayerStatus mVideoPlayerStatus;
    public boolean needHide;
    public PhotoInfo photoInfo;
    public long posId;
    public int positionShow;
    public int realShowType;
    public int type;

    public AdTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.adInfoList = new ArrayList();
        this.photoInfo = new PhotoInfo();
        this.positionShow = -1;
        this.mUniqueId = "";
        this.downloadSource = 2;
        this.installFrom = "";
        this.mPreloadData = new PreloadData();
        this.mMediaPlayerType = 0;
        this.mLiveInfo = new LiveInfo();
        this.mVideoPlayerStatus = new VideoPlayerStatus();
        this.mKsPlayerClickTimeParam = -1L;
        this.mIsLeftSlipStatus = 0;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj) : invokeL.booleanValue;
    }

    public int getShowPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.positionShow : invokeV.intValue;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) || jSONObject == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.positionShow = i2;
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (JSONObject) invokeV.objValue;
    }
}
