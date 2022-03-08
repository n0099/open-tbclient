package com.kwad.sdk.core.response.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class AdMatrixInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static final long serialVersionUID = -1399297421861223421L;
    public Styles styles = new Styles();
    public AdDataV2 adDataV2 = new AdDataV2();

    /* loaded from: classes8.dex */
    public static class ActionBarInfoNew extends BaseMatrixTemplate {
        public static final long serialVersionUID = -2897900789505229105L;
        public long maxTimeOut;
    }

    /* loaded from: classes8.dex */
    public static class AdDataV2 extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -8017805390945915342L;
        public List<TemplateData> templateDataList = new ArrayList();
        public BottomBannerInfo bottomBannerInfo = new BottomBannerInfo();
        public ActionBarInfoNew actionBarInfo = new ActionBarInfoNew();
        public FullPageActionBarInfo fullPageActionBarInfo = new FullPageActionBarInfo();
        public HalfCardInfo halfCardInfo = new HalfCardInfo();
        public EndCardInfo endCardInfo = new EndCardInfo();
        public InteractionInfo interactionInfo = new InteractionInfo();
        public InterstitialCardInfo interstitialCardInfo = new InterstitialCardInfo();
        public FeedInfo feedInfo = new FeedInfo();
        public SplashInfo splashInfo = new SplashInfo();
    }

    /* loaded from: classes8.dex */
    public static abstract class BaseMatrixTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 3594661163877934414L;
        public String templateId;
    }

    /* loaded from: classes8.dex */
    public static class BottomBannerInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 9099955467009566699L;
        public int bannerAdType;
        public int bannerSizeType;
    }

    /* loaded from: classes8.dex */
    public static class EndCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -1534468715847534303L;
    }

    /* loaded from: classes8.dex */
    public static class FeedInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -299328228771513399L;
    }

    /* loaded from: classes8.dex */
    public static class FullPageActionBarInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = 4774130082398115713L;
        public long maxTimeOut;
    }

    /* loaded from: classes8.dex */
    public static class HalfCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -3368566251206621911L;
    }

    /* loaded from: classes8.dex */
    public static class InteractionInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -1783857570602844781L;
    }

    /* loaded from: classes8.dex */
    public static class InterstitialCardInfo extends BaseMatrixTemplate {
        public static final long serialVersionUID = -5881505827627373593L;
    }

    /* loaded from: classes8.dex */
    public static class MatrixTemplate extends BaseMatrixTemplate {
        public static final long serialVersionUID = 1943039524913069727L;
        public String templateMd5;
        public String templateUrl;
        public String templateVersion;
        public long templateVersionCode;
    }

    /* loaded from: classes8.dex */
    public static class ShakeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 4528782399998808588L;
        public int acceleration;
        public boolean clickDisabled;
        public int componentIndex;
        public String subtitle;
    }

    /* loaded from: classes8.dex */
    public static class SplashInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 240426032769377332L;
        public SplashInteractionInfo interactionInfo = new SplashInteractionInfo();
    }

    /* loaded from: classes8.dex */
    public static class SplashInteractionInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -8105791433429537031L;
        public int interactiveStyle;
        public ShakeInfo shakeInfo = new ShakeInfo();
    }

    /* loaded from: classes8.dex */
    public static class Styles extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = 1713930699658485883L;
        public List<MatrixTemplate> templateList = new ArrayList();
    }

    /* loaded from: classes8.dex */
    public static class TemplateData extends BaseMatrixTemplate {
        public static final long serialVersionUID = -3330357033837521996L;
        public String data;
        public long templateDelayTime;
        public long templateShowTime;
    }
}
