package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class AdStyleInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 8719785586052076737L;
    public transient /* synthetic */ FieldHolder $fh;
    public AdBrowseInfo adBrowseInfo;
    public ExtraDisplayInfo extraDisplayInfo;
    public FeedAdInfo feedAdInfo;
    public PlayDetailInfo playDetailInfo;
    public PlayEndInfo playEndInfo;
    public boolean slideClick;

    /* loaded from: classes2.dex */
    public static class AdBrowseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
    public static class ExposeTagInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String text;

        public ExposeTagInfo() {
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
    public static class ExtraDisplayInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<ExposeTagInfo> exposeTagInfoList;

        public ExtraDisplayInfo() {
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
    public static class FeedAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
    public static class PlayDetailInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1341583579732471663L;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionBarInfo actionBarInfo;
        public DetailCommonInfo detailCommonInfo;
        public DetailTopToolBarInfo detailTopToolBarInfo;
        public DetailWebCardInfo detailWebCardInfo;
        public DrawAdInfo drawAdInfo;
        public PatchAdInfo patchAdInfo;
        public int type;
        public WidgetAdInfo widgetAdInfo;

        /* loaded from: classes2.dex */
        public static class ActionBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class DetailCommonInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class DetailTopToolBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class DetailWebCardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class DrawAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -793446066208523006L;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean forcedWatch;

            public DrawAdInfo() {
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
        public static class PatchAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = 2983090319692390903L;
            public transient /* synthetic */ FieldHolder $fh;
            public String strongStyleAdMark;
            public long strongStyleAppearTime;
            public String strongStyleCardUrl;
            public boolean strongStyleEnableClose;
            public long strongStyleShowTime;
            public String strongStyleSubTitle;
            public String strongStyleTitle;
            public int typePortrait;
            public String weakStyleAdMark;
            public long weakStyleAppearTime;
            public String weakStyleDownloadingTitle;
            public boolean weakStyleEnableClose;
            public String weakStyleIcon;
            public long weakStyleShowTime;
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
        public static class PatchEcInfo extends PatchAdInfo implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int PLATFORM_TYPE_JD = 2;
            public static final int PLATFORM_TYPE_KWAI = 0;
            public static final int PLATFORM_TYPE_TAOBAO = 1;
            public static final long serialVersionUID = -2026969232988644879L;
            public transient /* synthetic */ FieldHolder $fh;
            public String linkCode;
            public String nebulaKwaiLink;
            public int platformTypeCode;
            public String strongStyleItemId;
            public String strongStyleItemPrice;
            public String strongStyleItemUrl;
            public String strongStylePicUrl;
            public String strongStylePriceAfterComm;
            public String strongStyleUserCommAmountBuying;
            public String strongStyleUserCommAmountSharing;

            public PatchEcInfo() {
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

            public String getLinkCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.linkCode : (String) invokeV.objValue;
            }

            public String getNebulaKwaiLink() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.nebulaKwaiLink : (String) invokeV.objValue;
            }

            public String getStrongStyleItemId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.strongStyleItemId : (String) invokeV.objValue;
            }

            public String getStrongStyleItemPrice() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.strongStyleItemPrice : (String) invokeV.objValue;
            }

            public String getStrongStyleItemUrl() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.strongStyleItemUrl : (String) invokeV.objValue;
            }

            public String getStrongStylePicUrl() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.strongStylePicUrl : (String) invokeV.objValue;
            }

            public String getStrongStylePriceAfterComm() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.strongStylePriceAfterComm : (String) invokeV.objValue;
            }

            public String getStrongStyleUserCommAmountBuying() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.strongStyleUserCommAmountBuying : (String) invokeV.objValue;
            }

            public String getStrongStyleUserCommAmountSharing() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.strongStyleUserCommAmountSharing : (String) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public static class WidgetAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
            this.drawAdInfo = new DrawAdInfo();
        }
    }

    /* loaded from: classes2.dex */
    public static class PlayEndInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class AdWebCardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class EndTopToolBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        public static class HorizontalPatchAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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
        this.extraDisplayInfo = new ExtraDisplayInfo();
    }
}
