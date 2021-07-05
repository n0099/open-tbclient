package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class LiveEndResultData extends BaseResultData implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7751086347399213067L;
    public transient /* synthetic */ FieldHolder $fh;
    public QLivePushEndInfo mQLivePushEndInfo;

    /* loaded from: classes7.dex */
    public static class QLivePushEndInfo implements b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String KET_CONFIG_DISPLAY_LIKE_USER_COUNT = "displayLikeUserCount";
        public static final String KET_CONFIG_DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
        public static final String KET_CONFIG_LIKE_USER_COUNT = "likeUserCount";
        public static final String KET_CONFIG_LIVE_DURATION = "liveDuration";
        public static final String KET_CONFIG_TOTAL_WATCHING_DURATION = "totalWatchingDuration";
        public static final String KET_CONFIG_WATCHING_USER_COUNT = "watchingUserCount";
        public static final long serialVersionUID = 7611577990274486211L;
        public transient /* synthetic */ FieldHolder $fh;
        public String mDisplayLikeUserCount;
        public String mDisplayWatchingUserCount;
        public int mLikeUserCount;
        public long mLiveDuration;
        public long mTotalWatchingDuration;
        public int mWatchingUserCount;

        public QLivePushEndInfo() {
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
            this.mDisplayWatchingUserCount = "0";
            this.mDisplayLikeUserCount = "0";
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.mTotalWatchingDuration = jSONObject.optLong(KET_CONFIG_TOTAL_WATCHING_DURATION);
            this.mWatchingUserCount = jSONObject.optInt(KET_CONFIG_WATCHING_USER_COUNT);
            this.mDisplayWatchingUserCount = jSONObject.optString(KET_CONFIG_DISPLAY_WATCHING_USER_COUNT, "0");
            this.mLiveDuration = jSONObject.optLong(KET_CONFIG_LIVE_DURATION);
            this.mLikeUserCount = jSONObject.optInt(KET_CONFIG_LIKE_USER_COUNT);
            this.mDisplayLikeUserCount = jSONObject.optString(KET_CONFIG_DISPLAY_LIKE_USER_COUNT, "0");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, KET_CONFIG_TOTAL_WATCHING_DURATION, this.mTotalWatchingDuration);
                o.a(jSONObject, KET_CONFIG_WATCHING_USER_COUNT, this.mWatchingUserCount);
                o.a(jSONObject, KET_CONFIG_DISPLAY_WATCHING_USER_COUNT, this.mDisplayWatchingUserCount);
                o.a(jSONObject, KET_CONFIG_LIVE_DURATION, this.mLiveDuration);
                o.a(jSONObject, KET_CONFIG_LIKE_USER_COUNT, this.mLikeUserCount);
                o.a(jSONObject, KET_CONFIG_DISPLAY_LIKE_USER_COUNT, this.mDisplayLikeUserCount);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public LiveEndResultData() {
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
        this.mQLivePushEndInfo = new QLivePushEndInfo();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            super.parseJson(jSONObject);
            if (jSONObject == null) {
                return;
            }
            this.mQLivePushEndInfo.parseJson(jSONObject);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mQLivePushEndInfo.toJson() : (JSONObject) invokeV.objValue;
    }
}
