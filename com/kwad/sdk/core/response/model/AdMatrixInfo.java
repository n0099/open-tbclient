package com.kwad.sdk.core.response.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AdMatrixInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1399297421861223421L;
    public transient /* synthetic */ FieldHolder $fh;
    public AdDataV2 adDataV2;
    public Styles styles;

    /* loaded from: classes2.dex */
    public static class ActionBarInfoNew extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2897900789505229105L;
        public transient /* synthetic */ FieldHolder $fh;
        public long maxTimeOut;

        public ActionBarInfoNew() {
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
    public static class AdDataV2 extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8017805390945915342L;
        public transient /* synthetic */ FieldHolder $fh;
        public ActionBarInfoNew actionBarInfo;
        public BottomBannerInfo bottomBannerInfo;
        public EndCardInfo endCardInfo;
        public FeedInfo feedInfo;
        public FullPageActionBarInfo fullPageActionBarInfo;
        public HalfCardInfo halfCardInfo;
        public InteractionInfo interactionInfo;
        public InterstitialCardInfo interstitialCardInfo;
        public SplashInfo splashInfo;
        public List<TemplateData> templateDataList;

        public AdDataV2() {
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
            this.templateDataList = new ArrayList();
            this.bottomBannerInfo = new BottomBannerInfo();
            this.actionBarInfo = new ActionBarInfoNew();
            this.fullPageActionBarInfo = new FullPageActionBarInfo();
            this.halfCardInfo = new HalfCardInfo();
            this.endCardInfo = new EndCardInfo();
            this.interactionInfo = new InteractionInfo();
            this.interstitialCardInfo = new InterstitialCardInfo();
            this.feedInfo = new FeedInfo();
            this.splashInfo = new SplashInfo();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class BaseMatrixTemplate extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3594661163877934414L;
        public transient /* synthetic */ FieldHolder $fh;
        public String templateId;

        public BaseMatrixTemplate() {
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
    public static class BottomBannerInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 9099955467009566699L;
        public transient /* synthetic */ FieldHolder $fh;
        public int bannerAdType;
        public int bannerSizeType;

        public BottomBannerInfo() {
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
    public static class EndCardInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1534468715847534303L;
        public transient /* synthetic */ FieldHolder $fh;

        public EndCardInfo() {
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
    public static class FeedInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -299328228771513399L;
        public transient /* synthetic */ FieldHolder $fh;

        public FeedInfo() {
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
    public static class FullPageActionBarInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4774130082398115713L;
        public transient /* synthetic */ FieldHolder $fh;
        public long maxTimeOut;

        public FullPageActionBarInfo() {
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
    public static class HalfCardInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3368566251206621911L;
        public transient /* synthetic */ FieldHolder $fh;

        public HalfCardInfo() {
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
    public static class InteractionInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -1783857570602844781L;
        public transient /* synthetic */ FieldHolder $fh;

        public InteractionInfo() {
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
    public static class InterstitialCardInfo extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5881505827627373593L;
        public transient /* synthetic */ FieldHolder $fh;

        public InterstitialCardInfo() {
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
    public static class MatrixTemplate extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1943039524913069727L;
        public transient /* synthetic */ FieldHolder $fh;
        public String templateMd5;
        public String templateUrl;
        public String templateVersion;
        public long templateVersionCode;

        public MatrixTemplate() {
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
    public static class ShakeInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4528782399998808588L;
        public transient /* synthetic */ FieldHolder $fh;
        public int acceleration;
        public boolean clickDisabled;
        public int componentIndex;
        public String subtitle;

        public ShakeInfo() {
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
    public static class SplashInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 240426032769377332L;
        public transient /* synthetic */ FieldHolder $fh;
        public SplashInteractionInfo interactionInfo;

        public SplashInfo() {
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
            this.interactionInfo = new SplashInteractionInfo();
        }
    }

    /* loaded from: classes2.dex */
    public static class SplashInteractionInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8105791433429537031L;
        public transient /* synthetic */ FieldHolder $fh;
        public int interactiveStyle;
        public ShakeInfo shakeInfo;

        public SplashInteractionInfo() {
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
            this.shakeInfo = new ShakeInfo();
        }
    }

    /* loaded from: classes2.dex */
    public static class Styles extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 1713930699658485883L;
        public transient /* synthetic */ FieldHolder $fh;
        public List<MatrixTemplate> templateList;

        public Styles() {
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
            this.templateList = new ArrayList();
        }
    }

    /* loaded from: classes2.dex */
    public static class TemplateData extends BaseMatrixTemplate {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3330357033837521996L;
        public transient /* synthetic */ FieldHolder $fh;
        public String data;
        public long templateDelayTime;
        public long templateShowTime;

        public TemplateData() {
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

    public AdMatrixInfo() {
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
        this.styles = new Styles();
        this.adDataV2 = new AdDataV2();
    }
}
