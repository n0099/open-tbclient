package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AdStyleInfo implements com.kwad.sdk.core.b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8719785586052076737L;
    public transient /* synthetic */ FieldHolder $fh;
    public FeedAdInfo feedAdInfo;
    public PlayDetailInfo playDetailInfo;
    public PlayEndInfo playEndInfo;

    /* loaded from: classes7.dex */
    public static class FeedAdInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7200581738130214277L;
        public transient /* synthetic */ FieldHolder $fh;
        public double heightRatio;
        public String templateConfig;

        public FeedAdInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class PlayDetailInfo implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1341583579732471663L;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionBarInfo actionBarInfo;
        public DetailTopToolBarInfo detailTopToolBarInfo;
        public DetailWebCardInfo detailWebCardInfo;
        public PatchAdInfo patchAdInfo;
        public int type;

        /* loaded from: classes7.dex */
        public static class ActionBarInfo implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8435676971458116236L;
            public transient /* synthetic */ FieldHolder $fh;
            public long cardShowTime;
            public long lightBtnShowTime;
            public long translateBtnShowTime;

            public ActionBarInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                    return;
                }
                this.translateBtnShowTime = jSONObject.optLong("translateBtnShowTime");
                this.lightBtnShowTime = jSONObject.optLong("lightBtnShowTime");
                this.cardShowTime = jSONObject.optLong("cardShowTime");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    o.a(jSONObject, "translateBtnShowTime", this.translateBtnShowTime);
                    o.a(jSONObject, "lightBtnShowTime", this.lightBtnShowTime);
                    o.a(jSONObject, "cardShowTime", this.cardShowTime);
                    return jSONObject;
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public static class DetailTopToolBarInfo implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 7018855616083214769L;
            public transient /* synthetic */ FieldHolder $fh;
            public String callButtonDescription;
            public long callButtonShowTime;
            public String rewardCallDescription;
            public String rewardIconUrl;

            public DetailTopToolBarInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                    return;
                }
                this.callButtonShowTime = jSONObject.optLong("callButtonShowTime");
                this.callButtonDescription = jSONObject.optString("callButtonDescription");
                this.rewardIconUrl = jSONObject.optString("rewardIconUrl");
                this.rewardCallDescription = jSONObject.optString("rewardCallDescription");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    o.a(jSONObject, "callButtonShowTime", this.callButtonShowTime);
                    o.a(jSONObject, "callButtonDescription", this.callButtonDescription);
                    o.a(jSONObject, "rewardIconUrl", this.rewardIconUrl);
                    o.a(jSONObject, "rewardCallDescription", this.rewardCallDescription);
                    return jSONObject;
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public static class DetailWebCardInfo implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3413444348973947395L;
            public transient /* synthetic */ FieldHolder $fh;
            public String cardData;
            public long cardShowTime;
            public String cardUrl;
            public long maxTimeOut;
            public long typeLandscape;
            public long typePortrait;

            public DetailWebCardInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
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
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    o.a(jSONObject, "maxTimeOut", this.maxTimeOut);
                    o.a(jSONObject, "typeLandscape", this.typeLandscape);
                    o.a(jSONObject, "typePortrait", this.typePortrait);
                    o.a(jSONObject, "cardUrl", this.cardUrl);
                    o.a(jSONObject, "cardData", this.cardData);
                    o.a(jSONObject, "cardShowTime", this.cardShowTime);
                    return jSONObject;
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public static class PatchAdInfo implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2983090319692390903L;
            public transient /* synthetic */ FieldHolder $fh;
            public String strongStyleAdMark;
            public long strongStyleAppearTime;
            public String strongStyleCardUrl;
            public boolean strongStyleEnableClose;
            public String strongStyleSubTitle;
            public String strongStyleTitle;
            public int typePortrait;
            public String weakStyleAdMark;
            public long weakStyleAppearTime;
            public String weakStyleDownloadingTitle;
            public boolean weakStyleEnableClose;
            public String weakStyleIcon;
            public String weakStyleTitle;

            public PatchAdInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
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
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                return (JSONObject) invokeV.objValue;
            }
        }

        public PlayDetailInfo() {
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
            this.detailWebCardInfo = new DetailWebCardInfo();
            this.detailTopToolBarInfo = new DetailTopToolBarInfo();
            this.actionBarInfo = new ActionBarInfo();
            this.patchAdInfo = new PatchAdInfo();
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
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
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "type", this.type);
                o.a(jSONObject, "detailWebCardInfo", this.detailWebCardInfo);
                o.a(jSONObject, "detailTopToolBarInfo", this.detailTopToolBarInfo);
                o.a(jSONObject, "actionBarInfo", this.actionBarInfo);
                o.a(jSONObject, "patchAdInfo", this.patchAdInfo);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class PlayEndInfo implements com.kwad.sdk.core.b, Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4733855071604625289L;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public AdWebCardInfo adWebCardInfo;
        @NonNull
        public EndTopToolBarInfo endTopToolBarInfo;
        public int showLandingPage;
        public int type;

        /* loaded from: classes7.dex */
        public static class AdWebCardInfo implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 5629721137592788675L;
            public transient /* synthetic */ FieldHolder $fh;
            public String cardData;
            public long cardDelayTime;
            public int cardShowPlayCount;
            public long cardShowTime;
            public String cardUrl;
            public long typeLandscape;
            public long typePortrait;

            public AdWebCardInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
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
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
                return (JSONObject) invokeV.objValue;
            }
        }

        /* loaded from: classes7.dex */
        public static class EndTopToolBarInfo implements com.kwad.sdk.core.b, Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3850938239125130621L;
            public transient /* synthetic */ FieldHolder $fh;
            public String callButtonDescription;
            public String rewardIconUrl;

            public EndTopToolBarInfo() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public void parseJson(@Nullable JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                    return;
                }
                this.callButtonDescription = jSONObject.optString("callButtonDescription");
                this.rewardIconUrl = jSONObject.optString("rewardIconUrl");
            }

            @Override // com.kwad.sdk.core.b
            public JSONObject toJson() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    JSONObject jSONObject = new JSONObject();
                    o.a(jSONObject, "callButtonDescription", this.callButtonDescription);
                    o.a(jSONObject, "rewardIconUrl", this.rewardIconUrl);
                    return jSONObject;
                }
                return (JSONObject) invokeV.objValue;
            }
        }

        public PlayEndInfo() {
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
            this.adWebCardInfo = new AdWebCardInfo();
            this.endTopToolBarInfo = new EndTopToolBarInfo();
        }

        public void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.showLandingPage = jSONObject.optInt("showLandingPage3");
            this.adWebCardInfo.parseJson(jSONObject.optJSONObject("adWebCardInfo"));
            this.endTopToolBarInfo.parseJson(jSONObject.optJSONObject("endTopToolBarInfo"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                o.a(jSONObject, "type", this.type);
                o.a(jSONObject, "adWebCardInfo", this.adWebCardInfo);
                o.a(jSONObject, "showLandingPage3", this.showLandingPage);
                o.a(jSONObject, "endTopToolBarInfo", this.endTopToolBarInfo);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public AdStyleInfo() {
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
        this.playDetailInfo = new PlayDetailInfo();
        this.playEndInfo = new PlayEndInfo();
        this.feedAdInfo = new FeedAdInfo();
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.playEndInfo.parseJson(jSONObject.optJSONObject("playEndInfo"));
        this.playDetailInfo.parseJson(jSONObject.optJSONObject("playDetailInfo"));
        this.feedAdInfo.parseJson(jSONObject.optJSONObject("feedAdInfo"));
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "playDetailInfo", this.playDetailInfo);
            o.a(jSONObject, "playEndInfo", this.playEndInfo);
            o.a(jSONObject, "feedAdInfo", this.feedAdInfo);
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }
}
