package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveEndResultData extends BaseResultData implements b, Serializable {
    private static final long serialVersionUID = -7751086347399213067L;
    public QLivePushEndInfo mQLivePushEndInfo = new QLivePushEndInfo();

    /* loaded from: classes4.dex */
    public static class QLivePushEndInfo implements b, Serializable {
        public static final String KET_CONFIG_DISPLAY_LIKE_USER_COUNT = "displayLikeUserCount";
        public static final String KET_CONFIG_DISPLAY_WATCHING_USER_COUNT = "displayWatchingUserCount";
        public static final String KET_CONFIG_LIKE_USER_COUNT = "likeUserCount";
        public static final String KET_CONFIG_LIVE_DURATION = "liveDuration";
        public static final String KET_CONFIG_TOTAL_WATCHING_DURATION = "totalWatchingDuration";
        public static final String KET_CONFIG_WATCHING_USER_COUNT = "watchingUserCount";
        private static final long serialVersionUID = 7611577990274486211L;
        public int mLikeUserCount;
        public long mLiveDuration;
        public long mTotalWatchingDuration;
        public int mWatchingUserCount;
        public String mDisplayWatchingUserCount = "0";
        public String mDisplayLikeUserCount = "0";

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
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
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, KET_CONFIG_TOTAL_WATCHING_DURATION, this.mTotalWatchingDuration);
            o.a(jSONObject, KET_CONFIG_WATCHING_USER_COUNT, this.mWatchingUserCount);
            o.a(jSONObject, KET_CONFIG_DISPLAY_WATCHING_USER_COUNT, this.mDisplayWatchingUserCount);
            o.a(jSONObject, KET_CONFIG_LIVE_DURATION, this.mLiveDuration);
            o.a(jSONObject, KET_CONFIG_LIKE_USER_COUNT, this.mLikeUserCount);
            o.a(jSONObject, KET_CONFIG_DISPLAY_LIKE_USER_COUNT, this.mDisplayLikeUserCount);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mQLivePushEndInfo.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        return this.mQLivePushEndInfo.toJson();
    }
}
