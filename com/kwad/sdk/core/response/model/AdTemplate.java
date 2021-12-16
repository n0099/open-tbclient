package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -5413539480595883024L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<AdInfo> adInfoList;
    public AggregatePageEntranceInfo aggregatePageEntranceInfo;
    public int contentType;
    public transient int downloadSource;
    public String extra;
    public String impAdExtra;
    public transient String installFrom;
    public boolean interactLandingPageShowing;
    public boolean isDrawAdHasLook;
    public boolean isWebViewDownload;
    public long llsid;
    @Nullable
    public SceneImpl mAdScene;
    public boolean mAdWebVideoPageShowing;
    public int mBidEcpm;
    public boolean mCheatingFlow;
    public transient boolean mContentPvReported;
    public transient boolean mDownloadFinishReported;
    public boolean mHasEntryAdClick;
    public boolean mHasSelected;
    public transient boolean mHorizontalFeedSuggestPvReported;
    public transient boolean mHorizontalRelatedSuggestPvReported;
    public int mInitVoiceStatus;
    public boolean mIsFromContent;
    public int mIsLeftSlipStatus;
    public boolean mIsNotNeedAvatarGuider;
    public boolean mIsTubeEpisodeList;
    public LiveInfo mLiveInfo;
    public transient Map<String, Object> mLocalParams;
    public int mMediaPlayerType;
    public transient String mMiniWindowId;
    public String mOriginJString;
    public long mOutClickTimeParam;
    public PageInfo mPageInfo;
    public String mPcursor;
    public int mPhotoResponseType;
    public PreloadData mPreloadData;
    public transient boolean mPvReported;
    public transient boolean mRelatedContentPvReported;
    public int mRequestCount;
    public boolean mRewardVerifyCalled;
    public transient boolean mTrackUrlReported;
    public String mUniqueId;
    public VideoPlayerStatus mVideoPlayerStatus;
    public volatile long mVisibleTimeParam;
    public boolean mXiaomiAppStoreDetailViewOpen;
    public boolean needHide;
    public NewsInfo newsInfo;
    public PhotoAd photoAd;
    public PhotoInfo photoInfo;
    public long posId;
    public int positionShow;
    public int realShowType;
    public int serverPosition;
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
        this.photoAd = new PhotoAd();
        this.newsInfo = new NewsInfo();
        this.aggregatePageEntranceInfo = new AggregatePageEntranceInfo();
        this.mLiveInfo = new LiveInfo();
        this.positionShow = -1;
        this.serverPosition = -1;
        this.mIsFromContent = false;
        this.isDrawAdHasLook = false;
        this.mUniqueId = "";
        this.mMiniWindowId = null;
        this.mHasSelected = false;
        this.downloadSource = 2;
        this.installFrom = "";
        this.mPreloadData = new PreloadData();
        this.mMediaPlayerType = 0;
        this.mVideoPlayerStatus = new VideoPlayerStatus();
        this.mOutClickTimeParam = -1L;
        this.mVisibleTimeParam = -1L;
        this.mIsLeftSlipStatus = 0;
        this.interactLandingPageShowing = false;
        this.mAdWebVideoPageShowing = false;
        this.mRewardVerifyCalled = false;
        this.mCheatingFlow = false;
        this.mXiaomiAppStoreDetailViewOpen = false;
        this.isWebViewDownload = false;
        this.mLocalParams = new HashMap();
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.afterParseJson(jSONObject);
            if (jSONObject != null && TextUtils.isEmpty(this.mOriginJString)) {
                this.mOriginJString = jSONObject.toString();
            }
            this.realShowType = this.contentType;
            if (TextUtils.isEmpty(this.mUniqueId)) {
                this.mUniqueId = String.valueOf(UUID.randomUUID());
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? obj instanceof AdTemplate ? this.mUniqueId.equals(((AdTemplate) obj).mUniqueId) : super.equals(obj) : invokeL.booleanValue;
    }

    @Nullable
    public <T> T getLocalParams(String str) {
        InterceptResult invokeL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (t = (T) this.mLocalParams.get(str)) == null) {
                return null;
            }
            return t;
        }
        return (T) invokeL.objValue;
    }

    public int getServerPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i2 = this.serverPosition;
            return i2 != -1 ? i2 : getShowPosition();
        }
        return invokeV.intValue;
    }

    public int getShowPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.positionShow : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            String str = this.mUniqueId;
            return str != null ? str.hashCode() : super.hashCode();
        }
        return invokeV.intValue;
    }

    @Nullable
    public Object putLocalParams(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, obj)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mLocalParams.put(str, obj);
        }
        return invokeLL.objValue;
    }

    public void setCheatingFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.mCheatingFlow) {
            return;
        }
        this.mCheatingFlow = z;
    }

    public void setServerPosition(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && this.serverPosition == -1) {
            this.serverPosition = i2;
        }
    }

    public void setShowPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.positionShow = i2;
        }
    }
}
