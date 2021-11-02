package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class AdStyleInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8719785586052076737L;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBrowseInfo adBrowseInfo;
    public BannerAdInfo bannerAdInfo;
    public FeedAdInfo feedAdInfo;
    public PlayDetailInfo playDetailInfo;
    public PlayEndInfo playEndInfo;

    /* loaded from: classes2.dex */
    public static class AdBrowseInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 124904139820344132L;
        public transient /* synthetic */ FieldHolder $fh;
        public int adBrowseDuration;
        public int enableAdBrowse;

        public AdBrowseInfo() {
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

    /* loaded from: classes2.dex */
    public static class BannerAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3388161368206579078L;
        public transient /* synthetic */ FieldHolder $fh;
        public int bannerAdType;
        public String bannerAdWebUrl;

        public BannerAdInfo() {
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

    /* loaded from: classes2.dex */
    public static class FeedAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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

    /* loaded from: classes2.dex */
    public static class PlayDetailInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1341583579732471663L;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionBarInfo actionBarInfo;
        public DetailCommonInfo detailCommonInfo;
        public DetailTopToolBarInfo detailTopToolBarInfo;
        public DetailWebCardInfo detailWebCardInfo;
        public PatchAdInfo patchAdInfo;
        public int type;
        public WidgetAdInfo widgetAdInfo;

        /* loaded from: classes2.dex */
        public static class ActionBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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
        }

        /* loaded from: classes2.dex */
        public static class DetailCommonInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 7929119539282758308L;
            public transient /* synthetic */ FieldHolder $fh;
            public int middleEndcardShowTime;
            public int rewardFullClickSwitch;

            public DetailCommonInfo() {
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

        /* loaded from: classes2.dex */
        public static class DetailTopToolBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 7018855616083214769L;
            public transient /* synthetic */ FieldHolder $fh;
            public String callButtonDescription;
            public long callButtonShowTime;
            public long maxTimeOut;
            public String rewardCallDescription;
            public String rewardIconUrl;
            public int style;

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
        }

        /* loaded from: classes2.dex */
        public static class DetailWebCardInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -3413444348973947395L;
            public transient /* synthetic */ FieldHolder $fh;
            public String cardData;
            public long cardShowTime;
            public String cardUrl;
            public long maxTimeOut;
            public int style;
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
        }

        /* loaded from: classes2.dex */
        public static class PatchAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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
        }

        /* loaded from: classes2.dex */
        public static class WidgetAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -7098364163341152274L;
            public transient /* synthetic */ FieldHolder $fh;
            public String downloadOngoingLabel;
            public String downloadResumeLabel;
            public String downloadStartLabel;
            public String installAppLabel;
            public String openAppLabel;
            public int type;
            public String widgetAdIcon;

            public WidgetAdInfo() {
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
            this.widgetAdInfo = new WidgetAdInfo();
            this.detailCommonInfo = new DetailCommonInfo();
        }
    }

    /* loaded from: classes2.dex */
    public static class PlayEndInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4733855071604625289L;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public AdWebCardInfo adWebCardInfo;
        @NonNull
        public EndTopToolBarInfo endTopToolBarInfo;
        @NonNull
        public HorizontalPatchAdInfo horizontalPatchAdInfo;
        public int showLandingPage3;
        public int type;

        /* loaded from: classes2.dex */
        public static class AdWebCardInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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
        }

        /* loaded from: classes2.dex */
        public static class EndTopToolBarInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
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
        }

        /* loaded from: classes2.dex */
        public static class HorizontalPatchAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 8415386955501326466L;
            public transient /* synthetic */ FieldHolder $fh;
            public String patchCardUrl;

            public HorizontalPatchAdInfo() {
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
            this.horizontalPatchAdInfo = new HorizontalPatchAdInfo();
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
        this.adBrowseInfo = new AdBrowseInfo();
        this.bannerAdInfo = new BannerAdInfo();
    }
}
