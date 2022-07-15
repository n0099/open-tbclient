package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
@KsJson
/* loaded from: classes5.dex */
public class AdMatrixInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -1399297421861223421L;
    public Styles styles = new Styles();
    public AdDataV2 adDataV2 = new AdDataV2();

    @KsJson
    /* loaded from: classes5.dex */
    public static class ActionBarInfoNew extends BaseMatrixTemplate {
        public static final long serialVersionUID = -2897900789505229105L;
        public int cardType;
        public long maxTimeOut;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class AdDataV2 extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -8017805390945915342L;
        public List<TemplateData> templateDataList = new ArrayList();
        public BottomBannerInfo bottomBannerInfo = new BottomBannerInfo();
        public ActionBarInfoNew actionBarInfo = new ActionBarInfoNew();
        public FullPageActionBarInfo fullPageActionBarInfo = new FullPageActionBarInfo();
        public AggregationCardInfo aggregationCardInfo = new AggregationCardInfo();
        public HalfCardInfo halfCardInfo = new HalfCardInfo();
        public EndCardInfo endCardInfo = new EndCardInfo();
        public InteractionInfo interactionInfo = new InteractionInfo();
        public InterstitialCardInfo interstitialCardInfo = new InterstitialCardInfo();
        public FeedInfo feedInfo = new FeedInfo();
        public ComplianceCardInfo complianceCardInfo = new ComplianceCardInfo();
        public DownloadConfirmCardInfo downloadConfirmCardInfo = new DownloadConfirmCardInfo();
        public SplashInfo splashInfo = new SplashInfo();
        public FullScreenInfo fullScreenInfo = new FullScreenInfo();
        public RewardWatchOnceInfo rewardWatchOnceInfo = new RewardWatchOnceInfo();
        public MerchantLiveReservationInfo merchantLiveReservationInfo = new MerchantLiveReservationInfo();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class AdInteractionInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -8105791433429537031L;
        public int interactiveStyle;
        public ShakeInfo shakeInfo = new ShakeInfo();
        public RotateInfo rotateInfo = new RotateInfo();
        public SplashSlideInfo slideInfo = new SplashSlideInfo();
        public SplashActionBarInfo splashActionBarInfo = new SplashActionBarInfo();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class AggregationCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 6065340139053228242L;
        public int changeTime;
        public long intervalTime;
        public int maxTimesPerDay;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static abstract class BaseMatrixTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 3594661163877934414L;
        public String templateId;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class BottomBannerInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 9099955467009566699L;
        public int bannerAdType;
        public int bannerSizeType;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class ComplianceCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 7699515232185092385L;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class DownloadConfirmCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 7078836735619380575L;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class DownloadTexts extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -2293710579116352440L;
        public String adActionDescription;
        public String installAppLabel;
        public String openAppLabel;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class EndCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -1534468715847534303L;
        public int cardShowPlayCount;
        public int cardType;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class FeedInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -299328228771513399L;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class FullPageActionBarInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 4774130082398115713L;
        public long maxTimeOut;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class FullScreenInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 6260475900625987915L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class HalfCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -3368566251206621911L;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class InteractionInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -1783857570602844781L;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class InterstitialCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -5881505827627373593L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class MatrixTemplate extends BaseMatrixTemplate {
        public static final long serialVersionUID = 1943039524913069727L;
        public String templateMd5;
        public String templateUrl;
        public String templateVersion;
        public long templateVersionCode;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class MerchantLiveReservationInfo extends BaseMatrixTemplate implements Serializable {
        public static final int MIN_COUNT = 50;
        public static final long serialVersionUID = -6879010521415024815L;
        public int bookUserCount;
        public List<String> bookUserUrlList;
        public boolean displayBookCount;
        public boolean displayWeakCard;
        public String liveStartTime;
        public LiveReservationPlayEndInfo playEndCard;
        public String title;
        public String userHeadUrl;

        @KsJson
        /* loaded from: classes5.dex */
        public static class LiveReservationPlayEndInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            public static final long serialVersionUID = 1682477964084325954L;
            public String detailBtnTitle = "查看详情";
            public String reservationBtnTitle = "立即预约";
        }

        @Nullable
        public String getFormattedLiveSubscribeCount() {
            int i = this.bookUserCount;
            if (i < 50) {
                return null;
            }
            if (i < 10000) {
                return this.bookUserCount + "人";
            }
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            return decimalFormat.format(this.bookUserCount / 10000.0f) + "万人";
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.title) && TextUtils.isEmpty(this.liveStartTime) && TextUtils.isEmpty(this.userHeadUrl);
        }

        public boolean needShowSubscriberCount() {
            return this.displayBookCount && this.bookUserCount >= 50;
        }
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class RewardWatchOnceInfo extends BaseMatrixTemplate implements Serializable {
        public static final long serialVersionUID = 9167958667367942353L;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class RotateDegreeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -479509878557048331L;
        public int direction;
        public int rotateDegree;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class RotateInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -237926423883960071L;
        public String subTitle;
        public String title;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public RotateDegreeInfo x = new RotateDegreeInfo();
        public RotateDegreeInfo y = new RotateDegreeInfo();
        public RotateDegreeInfo z = new RotateDegreeInfo();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class ShakeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 4528782399998808588L;
        public int acceleration;
        public boolean clickDisabled;
        public int componentIndex;
        public String subtitle;
        public String title;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class SplashActionBarInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -2897900789505229105L;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public String title;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class SplashInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 240426032769377332L;
        public AdInteractionInfo interactionInfo = new AdInteractionInfo();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class SplashSlideInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -5771966197460897593L;
        public int convertDistance;
        public DownloadTexts downloadTexts = new DownloadTexts();
        public int style;
        public String subtitle;
        public String title;
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class Styles extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 1713930699658485883L;
        public List<MatrixTemplate> templateList = new ArrayList();
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class TemplateData extends BaseMatrixTemplate {
        public static final long serialVersionUID = -3330357033837521996L;
        public String data;
        public long templateDelayTime;
        public long templateShowTime;
    }
}
