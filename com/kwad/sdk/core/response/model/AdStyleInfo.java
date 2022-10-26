package com.kwad.sdk.core.response.model;

import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public class AdStyleInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 8719785586052076737L;
    public String playableExtraData;
    public boolean slideClick;
    public PlayDetailInfo playDetailInfo = new PlayDetailInfo();
    public PlayEndInfo playEndInfo = new PlayEndInfo();
    public FeedAdInfo feedAdInfo = new FeedAdInfo();
    public AdBrowseInfo adBrowseInfo = new AdBrowseInfo();
    public ExtraDisplayInfo extraDisplayInfo = new ExtraDisplayInfo();

    /* loaded from: classes7.dex */
    public class AdBrowseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 124904139820344132L;
        public int adBrowseDuration;
        public int enableAdBrowse;
    }

    /* loaded from: classes7.dex */
    public class ExposeTagInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public String text;
    }

    /* loaded from: classes7.dex */
    public class ExtraDisplayInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public List exposeTagInfoList;
    }

    /* loaded from: classes7.dex */
    public class FeedAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -7200581738130214277L;
        public double heightRatio;
        public String templateConfig;
    }

    /* loaded from: classes7.dex */
    public class PlayDetailInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -1341583579732471663L;
        public int type;
        public DetailWebCardInfo detailWebCardInfo = new DetailWebCardInfo();
        public DetailTopToolBarInfo detailTopToolBarInfo = new DetailTopToolBarInfo();
        public ActionBarInfo actionBarInfo = new ActionBarInfo();
        public PatchAdInfo patchAdInfo = new PatchAdInfo();
        public DetailCommonInfo detailCommonInfo = new DetailCommonInfo();
        public DrawAdInfo drawAdInfo = new DrawAdInfo();

        /* loaded from: classes7.dex */
        public class ActionBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 8435676971458116236L;
            public long cardShowTime;
            public long lightBtnShowTime;
            public long translateBtnShowTime;
        }

        /* loaded from: classes7.dex */
        public class DetailCommonInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 7929119539282758308L;
            public int middleEndcardShowTime;
            public int rewardFullClickSwitch;
            public int rewardInteractionType;
        }

        /* loaded from: classes7.dex */
        public class DetailTopToolBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 7018855616083214769L;
            public String callButtonDescription;
            public long callButtonShowTime;
            public long maxTimeOut;
            public String rewardCallDescription;
            public String rewardIconUrl;
            public int style;
        }

        /* loaded from: classes7.dex */
        public class DetailWebCardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -3413444348973947395L;
            public String cardData;
            public long cardShowTime;
            public int cardType;
            public String cardUrl;
            public long maxTimeOut;
            public int style;
            public long typeLandscape;
            public long typePortrait;
        }

        /* loaded from: classes7.dex */
        public class DrawAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -793446066208523006L;
            public boolean forcedWatch;
        }

        /* loaded from: classes7.dex */
        public class PatchAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 2983090319692390903L;
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
        }

        /* loaded from: classes7.dex */
        public class PatchEcInfo extends PatchAdInfo implements Serializable {
            public static final int PLATFORM_TYPE_JD = 2;
            public static final int PLATFORM_TYPE_KWAI = 0;
            public static final int PLATFORM_TYPE_TAOBAO = 1;
            public static final long serialVersionUID = -2026969232988644879L;
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

            public String getLinkCode() {
                return this.linkCode;
            }

            public String getNebulaKwaiLink() {
                return this.nebulaKwaiLink;
            }

            public String getStrongStyleItemId() {
                return this.strongStyleItemId;
            }

            public String getStrongStyleItemPrice() {
                return this.strongStyleItemPrice;
            }

            public String getStrongStyleItemUrl() {
                return this.strongStyleItemUrl;
            }

            public String getStrongStylePicUrl() {
                return this.strongStylePicUrl;
            }

            public String getStrongStylePriceAfterComm() {
                return this.strongStylePriceAfterComm;
            }

            public String getStrongStyleUserCommAmountBuying() {
                return this.strongStyleUserCommAmountBuying;
            }

            public String getStrongStyleUserCommAmountSharing() {
                return this.strongStyleUserCommAmountSharing;
            }
        }

        /* loaded from: classes7.dex */
        public class WidgetAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -7098364163341152274L;
            public String downloadOngoingLabel;
            public String downloadResumeLabel;
            public String downloadStartLabel;
            public String installAppLabel;
            public String openAppLabel;
            public int type;
            public String widgetAdIcon;
        }
    }

    /* loaded from: classes7.dex */
    public class PlayEndInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 4733855071604625289L;
        public AdWebCardInfo adWebCardInfo = new AdWebCardInfo();
        public EndTopToolBarInfo endTopToolBarInfo = new EndTopToolBarInfo();
        public int showLandingPage3;
        public int type;

        /* loaded from: classes7.dex */
        public class AdWebCardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 5629721137592788675L;
            public String cardData;
            public long cardDelayTime;
            public int cardShowPlayCount;
            public long cardShowTime;
            public String cardUrl;
            public long typeLandscape;
            public long typePortrait;
        }

        /* loaded from: classes7.dex */
        public class EndTopToolBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -3850938239125130621L;
            public String callButtonDescription;
            public String rewardIconUrl;
        }
    }
}
