package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdStyleInfo implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8719785586052076737L;
    public PlayDetailInfo playDetailInfo = new PlayDetailInfo();
    public PlayEndInfo playEndInfo = new PlayEndInfo();
    public FeedAdInfo feedAdInfo = new FeedAdInfo();

    /* loaded from: classes4.dex */
    public static class FeedAdInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -7200581738130214277L;
        public double heightRatio;
        public String templateConfig;
    }

    /* loaded from: classes4.dex */
    public static class PlayDetailInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -1341583579732471663L;
        public int type;
        public DetailWebCardInfo detailWebCardInfo = new DetailWebCardInfo();
        public DetailTopToolBarInfo detailTopToolBarInfo = new DetailTopToolBarInfo();
        public ActionBarInfo actionBarInfo = new ActionBarInfo();
        public PatchAdInfo patchAdInfo = new PatchAdInfo();

        /* loaded from: classes4.dex */
        public static class ActionBarInfo implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = 8435676971458116236L;
            public long cardShowTime;
            public long lightBtnShowTime;
            public long translateBtnShowTime;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
                this.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
                this.cardShowTime = jSONObject.optLong("cardShowTime");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "translateBtnShowTime", this.translateBtnShowTime);
                o.a(jSONObject, "lightBtnShowTime", this.lightBtnShowTime);
                o.a(jSONObject, "cardShowTime", this.cardShowTime);
                return jSONObject;
            }
        }

        /* loaded from: classes4.dex */
        public static class DetailTopToolBarInfo implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = 7018855616083214769L;
            public String callButtonDescription;
            public long callButtonShowTime;
            public String rewardCallDescription;
            public String rewardIconUrl;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
                this.callButtonDescription = jSONObject.optString("callButtonDescription");
                this.rewardIconUrl = jSONObject.optString("rewardIconUrl");
                this.rewardCallDescription = jSONObject.optString("rewardCallDescription");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "callButtonShowTime", this.callButtonShowTime);
                o.a(jSONObject, "callButtonDescription", this.callButtonDescription);
                o.a(jSONObject, "rewardIconUrl", this.rewardIconUrl);
                o.a(jSONObject, "rewardCallDescription", this.rewardCallDescription);
                return jSONObject;
            }
        }

        /* loaded from: classes4.dex */
        public static class DetailWebCardInfo implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = -3413444348973947395L;
            public String cardData;
            public long cardShowTime;
            public String cardUrl;
            public long maxTimeOut;
            public long typeLandscape;
            public long typePortrait;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.maxTimeOut = jSONObject.optLong("maxTimeOut");
                this.typeLandscape = jSONObject.optLong("typeLandscape");
                this.typePortrait = jSONObject.optLong("typePortrait");
                this.cardUrl = jSONObject.optString("cardUrl");
                this.cardData = jSONObject.optString("cardData");
                this.cardShowTime = jSONObject.optLong("cardShowTime");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "maxTimeOut", this.maxTimeOut);
                o.a(jSONObject, "typeLandscape", this.typeLandscape);
                o.a(jSONObject, "typePortrait", this.typePortrait);
                o.a(jSONObject, "cardUrl", this.cardUrl);
                o.a(jSONObject, "cardData", this.cardData);
                o.a(jSONObject, "cardShowTime", this.cardShowTime);
                return jSONObject;
            }
        }

        /* loaded from: classes4.dex */
        public static class PatchAdInfo implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = 2983090319692390903L;
            private String strongStyleAdMark;
            public long strongStyleAppearTime;
            public String strongStyleCardUrl;
            private boolean strongStyleEnableClose;
            private String strongStyleSubTitle;
            private String strongStyleTitle;
            private int typePortrait;
            public String weakStyleAdMark;
            public long weakStyleAppearTime;
            public String weakStyleDownloadingTitle;
            public boolean weakStyleEnableClose;
            public String weakStyleIcon;
            public String weakStyleTitle;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.weakStyleIcon = jSONObject.optString("weakStyleIcon");
                this.weakStyleTitle = jSONObject.optString("weakStyleTitle");
                this.weakStyleDownloadingTitle = jSONObject.optString("weakStyleDownloadingTitle");
                this.weakStyleAdMark = jSONObject.optString("weakStyleAdMark");
                this.weakStyleAppearTime = jSONObject.optLong("weakStyleAppearTime");
                this.weakStyleEnableClose = jSONObject.optBoolean("weakStyleEnableClose", true);
                this.typePortrait = jSONObject.optInt("typePortrait");
                this.strongStyleCardUrl = jSONObject.optString("strongStyleCardUrl");
                this.strongStyleAppearTime = jSONObject.optLong("strongStyleAppearTime");
                this.strongStyleTitle = jSONObject.optString("strongStyleTitle");
                this.strongStyleSubTitle = jSONObject.optString("strongStyleSubTitle");
                this.strongStyleAdMark = jSONObject.optString("strongStyleAdMark");
                this.strongStyleEnableClose = jSONObject.optBoolean("strongStyleEnableClose", true);
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "weakStyleIcon", this.weakStyleIcon);
                o.a(jSONObject, "weakStyleTitle", this.weakStyleTitle);
                o.a(jSONObject, "weakStyleDownloadingTitle", this.weakStyleDownloadingTitle);
                o.a(jSONObject, "weakStyleAdMark", this.weakStyleAdMark);
                o.a(jSONObject, "weakStyleAppearTime", this.weakStyleAppearTime);
                o.a(jSONObject, "weakStyleEnableClose", this.weakStyleEnableClose);
                o.a(jSONObject, "typePortrait", this.typePortrait);
                o.a(jSONObject, "strongStyleCardUrl", this.strongStyleCardUrl);
                o.a(jSONObject, "strongStyleAppearTime", this.strongStyleAppearTime);
                o.a(jSONObject, "strongStyleTitle", this.strongStyleTitle);
                o.a(jSONObject, "strongStyleSubTitle", this.strongStyleSubTitle);
                o.a(jSONObject, "strongStyleAdMark", this.strongStyleAdMark);
                o.a(jSONObject, "strongStyleEnableClose", this.strongStyleEnableClose);
                return jSONObject;
            }
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.detailWebCardInfo.parseJson(jSONObject.optJSONObject("detailWebCardInfo"));
            this.detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
            this.actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
            this.patchAdInfo.parseJson(jSONObject.optJSONObject("patchAdInfo"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "type", this.type);
            o.a(jSONObject, "detailWebCardInfo", this.detailWebCardInfo);
            o.a(jSONObject, "detailTopToolBarInfo", this.detailTopToolBarInfo);
            o.a(jSONObject, "actionBarInfo", this.actionBarInfo);
            o.a(jSONObject, "patchAdInfo", this.patchAdInfo);
            return jSONObject;
        }
    }

    /* loaded from: classes4.dex */
    public static class PlayEndInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 4733855071604625289L;
        @NonNull
        public AdWebCardInfo adWebCardInfo = new AdWebCardInfo();
        @NonNull
        public EndTopToolBarInfo endTopToolBarInfo = new EndTopToolBarInfo();
        public int showLandingPage;
        public int type;

        /* loaded from: classes4.dex */
        public static class AdWebCardInfo implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = 5629721137592788675L;
            public String cardData;
            public long cardDelayTime;
            public int cardShowPlayCount;
            public long cardShowTime;
            public String cardUrl;
            public long typeLandscape;
            public long typePortrait;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.typeLandscape = jSONObject.optLong("typeLandscape");
                this.typePortrait = jSONObject.optLong("typePortrait");
                this.cardUrl = jSONObject.optString("cardUrl");
                this.cardShowTime = jSONObject.optLong("cardShowTime");
                this.cardDelayTime = jSONObject.optLong("cardDelayTime");
                this.cardData = jSONObject.optString("cardData");
                this.cardShowPlayCount = jSONObject.optInt("cardShowPlayCount");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "typeLandscape", this.typeLandscape);
                o.a(jSONObject, "typePortrait", this.typePortrait);
                o.a(jSONObject, "cardUrl", this.cardUrl);
                o.a(jSONObject, "cardShowTime", this.cardShowTime);
                o.a(jSONObject, "cardDelayTime", this.cardDelayTime);
                o.a(jSONObject, "cardData", this.cardData);
                o.a(jSONObject, "cardShowPlayCount", this.cardShowPlayCount);
                return jSONObject;
            }
        }

        /* loaded from: classes4.dex */
        public static class EndTopToolBarInfo implements com.kwad.sdk.core.b, Serializable {
            private static final long serialVersionUID = -3850938239125130621L;
            public String callButtonDescription;
            public String rewardIconUrl;

            public void parseJson(@Nullable JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                this.callButtonDescription = jSONObject.optString("callButtonDescription");
                this.rewardIconUrl = jSONObject.optString("rewardIconUrl");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "callButtonDescription", this.callButtonDescription);
                o.a(jSONObject, "rewardIconUrl", this.rewardIconUrl);
                return jSONObject;
            }
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.showLandingPage = jSONObject.optInt("showLandingPage3");
            this.adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
            this.endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "type", this.type);
            o.a(jSONObject, "adWebCardInfo", this.adWebCardInfo);
            o.a(jSONObject, "showLandingPage3", this.showLandingPage);
            o.a(jSONObject, "endTopToolBarInfo", this.endTopToolBarInfo);
            return jSONObject;
        }
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        this.playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        this.feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "playDetailInfo", this.playDetailInfo);
        o.a(jSONObject, "playEndInfo", this.playEndInfo);
        o.a(jSONObject, "feedAdInfo", this.feedAdInfo);
        return jSONObject;
    }
}
