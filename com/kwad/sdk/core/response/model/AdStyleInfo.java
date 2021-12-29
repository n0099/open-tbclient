package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes3.dex */
public class AdStyleInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = 8719785586052076737L;
    public boolean slideClick;
    public PlayDetailInfo playDetailInfo = new PlayDetailInfo();
    public PlayEndInfo playEndInfo = new PlayEndInfo();
    public FeedAdInfo feedAdInfo = new FeedAdInfo();
    public AdBrowseInfo adBrowseInfo = new AdBrowseInfo();
    public ExtraDisplayInfo extraDisplayInfo = new ExtraDisplayInfo();

    /* loaded from: classes3.dex */
    public static class AdBrowseInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 124904139820344132L;
        public int adBrowseDuration;
        public int enableAdBrowse;
    }

    /* loaded from: classes3.dex */
    public static class ExposeTagInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public String text;
    }

    /* loaded from: classes3.dex */
    public static class ExtraDisplayInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public List<ExposeTagInfo> exposeTagInfoList;
    }

    /* loaded from: classes3.dex */
    public static class FeedAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -7200581738130214277L;
        public double heightRatio;
        public String templateConfig;
    }

    /* loaded from: classes3.dex */
    public static class PlayDetailInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -1341583579732471663L;
        public int type;
        public DetailWebCardInfo detailWebCardInfo = new DetailWebCardInfo();
        public DetailTopToolBarInfo detailTopToolBarInfo = new DetailTopToolBarInfo();
        public ActionBarInfo actionBarInfo = new ActionBarInfo();
        public PatchAdInfo patchAdInfo = new PatchAdInfo();
        public WidgetAdInfo widgetAdInfo = new WidgetAdInfo();
        public DetailCommonInfo detailCommonInfo = new DetailCommonInfo();
        public DrawAdInfo drawAdInfo = new DrawAdInfo();

        /* loaded from: classes3.dex */
        public static class ActionBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 8435676971458116236L;
            public long cardShowTime;
            public long lightBtnShowTime;
            public long translateBtnShowTime;
        }

        /* loaded from: classes3.dex */
        public static class DetailCommonInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 7929119539282758308L;
            public int middleEndcardShowTime;
            public int rewardFullClickSwitch;
        }

        /* loaded from: classes3.dex */
        public static class DetailTopToolBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 7018855616083214769L;
            public String callButtonDescription;
            public long callButtonShowTime;
            public long maxTimeOut;
            public String rewardCallDescription;
            public String rewardIconUrl;
            public int style;
        }

        /* loaded from: classes3.dex */
        public static class DetailWebCardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -3413444348973947395L;
            public String cardData;
            public long cardShowTime;
            public String cardUrl;
            public long maxTimeOut;
            public int style;
            public long typeLandscape;
            public long typePortrait;
        }

        /* loaded from: classes3.dex */
        public static class DrawAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -793446066208523006L;
            public boolean forcedWatch;
        }

        /* loaded from: classes3.dex */
        public static class PatchAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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

        /* loaded from: classes3.dex */
        public static class PatchEcInfo extends PatchAdInfo implements Serializable {
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

        /* loaded from: classes3.dex */
        public static class WidgetAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
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

    /* loaded from: classes3.dex */
    public static class PlayEndInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 4733855071604625289L;
        @NonNull
        public AdWebCardInfo adWebCardInfo = new AdWebCardInfo();
        @NonNull
        public EndTopToolBarInfo endTopToolBarInfo = new EndTopToolBarInfo();
        @NonNull
        public HorizontalPatchAdInfo horizontalPatchAdInfo = new HorizontalPatchAdInfo();
        public int showLandingPage3;
        public int type;

        /* loaded from: classes3.dex */
        public static class AdWebCardInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 5629721137592788675L;
            public String cardData;
            public long cardDelayTime;
            public int cardShowPlayCount;
            public long cardShowTime;
            public String cardUrl;
            public long typeLandscape;
            public long typePortrait;
        }

        /* loaded from: classes3.dex */
        public static class EndTopToolBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = -3850938239125130621L;
            public String callButtonDescription;
            public String rewardIconUrl;
        }

        /* loaded from: classes3.dex */
        public static class HorizontalPatchAdInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 8415386955501326466L;
            public String patchCardUrl;
        }
    }
}
