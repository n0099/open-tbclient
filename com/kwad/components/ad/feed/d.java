package com.kwad.components.ad.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.feed.a.l;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d extends AbstractKsFeedAd implements com.kwad.components.core.internal.api.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsFeedAd.AdInteractionListener cJ;
    public com.kwad.components.core.widget.b cK;
    public com.kwad.components.core.widget.b cL;
    public boolean cM;
    public KsAdVideoPlayConfig cN;
    public AdInfo mAdInfo;
    @NonNull
    public AdTemplate mAdTemplate;
    public int mWidth;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int cS;
        public int size;

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.size = i;
        }

        public final int ba() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.cS : invokeV.intValue;
        }

        public final boolean bb() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.cS + 1;
                this.cS = i;
                return i == this.size;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void aZ();
    }

    public d(@NonNull AdTemplate adTemplate, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cN = new KsAdVideoPlayConfig.Builder().build();
        this.mAdTemplate = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.cM = z;
        this.mWidth = i;
    }

    @Nullable
    private com.kwad.components.core.widget.b F(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, context)) != null) {
            return (com.kwad.components.core.widget.b) invokeL.objValue;
        }
        if (!this.cM || !com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate)) {
            return c.a(context, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.a.a.aD(this.mAdInfo));
        }
        l lVar = null;
        try {
            l lVar2 = new l(context);
            try {
                lVar2.setVideoPlayConfig(this.cN);
                return lVar2;
            } catch (Throwable th) {
                th = th;
                lVar = lVar2;
                com.kwad.components.core.b.a.b(th);
                return lVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.widget.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar, z) == null) || bVar == null) {
            return;
        }
        bVar.setInnerAdInteractionListener(new b.InterfaceC0376b(this, z, bVar) { // from class: com.kwad.components.ad.feed.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d cP;
            public final /* synthetic */ boolean cQ;
            public final /* synthetic */ com.kwad.components.core.widget.b cR;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Boolean.valueOf(z), bVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.cP = this;
                this.cQ = z;
                this.cR = bVar;
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onAdClicked() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.cP.cJ == null) {
                    return;
                }
                this.cP.cJ.onAdClicked();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onAdShow() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.cP.cJ != null) {
                        this.cP.cJ.onAdShow();
                    }
                    if (this.cQ) {
                        com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                        u.a aVar = new u.a();
                        FeedType fromInt = FeedType.fromInt(this.cP.mAdTemplate.type);
                        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                        }
                        aVar.templateId = String.valueOf(fromInt.getType());
                        fVar.a(aVar);
                        com.kwad.components.core.m.c.ox().a(this.cP.mAdTemplate, null, fVar);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onDislikeClicked() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.cP.cJ == null) {
                    return;
                }
                this.cP.cJ.onDislikeClicked();
                try {
                    if (this.cR.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.cR.getParent()).removeView(this.cR);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onDownloadTipsDialogDismiss() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.cP.cJ == null) {
                    return;
                }
                try {
                    this.cP.cJ.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0376b
            public final void onDownloadTipsDialogShow() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.cP.cJ == null) {
                    return;
                }
                try {
                    this.cP.cJ.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void aY() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || this.mAdTemplate == null) {
            return;
        }
        com.kwad.sdk.core.diskcache.a.a sS = com.kwad.sdk.core.diskcache.a.a.sS();
        sS.remove("feed_ad_cache_" + this.mAdTemplate.posId);
    }

    private boolean isVideoSoundEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.cN;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                    return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                }
            }
            return com.kwad.sdk.core.response.a.a.bh(this.mAdInfo);
        }
        return invokeV.booleanValue;
    }

    public final com.kwad.components.core.widget.b a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                bVar.aZ();
                return null;
            }
            com.kwad.components.core.widget.b F = F(context);
            this.cL = F;
            if (F != null) {
                this.cL.setMargin(com.kwad.sdk.b.kwai.a.a(context, 16.0f));
                com.kwad.components.core.widget.b bVar2 = this.cL;
                if (bVar2 instanceof l) {
                    l lVar = (l) bVar2;
                    int i = this.mWidth;
                    if (i > 0) {
                        lVar.setWidth(i);
                    }
                    lVar.a(this.mAdTemplate, new l.a(this, bVar) { // from class: com.kwad.components.ad.feed.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b cO;
                        public final /* synthetic */ d cP;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.cP = this;
                            this.cO = bVar;
                        }

                        @Override // com.kwad.components.ad.feed.a.l.a
                        public final void aZ() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                d dVar = this.cP;
                                dVar.a(dVar.cL, false);
                                b bVar3 = this.cO;
                                if (bVar3 != null) {
                                    bVar3.aZ();
                                }
                            }
                        }
                    });
                    return this.cL;
                }
                bVar2.c((com.kwad.components.core.widget.b) this.mAdTemplate);
                com.kwad.components.core.widget.b bVar3 = this.cL;
                if (bVar3 instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) bVar3).a(this.cN);
                }
                a(this.cL, true);
            }
            bVar.aZ();
            return this.cL;
        }
        return (com.kwad.components.core.widget.b) invokeL.objValue;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAdTemplate : (AdTemplate) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? com.kwad.sdk.core.response.a.a.aq(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            com.kwad.components.core.widget.b bVar = this.cK;
            if (bVar == null) {
                aY();
                com.kwad.components.core.widget.b bVar2 = this.cL;
                if (bVar2 != null) {
                    this.cK = bVar2;
                    return bVar2;
                } else if (context == null) {
                    return null;
                } else {
                    this.cK = F(context);
                }
            } else if (bVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.cK.getParent()).removeView(this.cK);
            }
            com.kwad.components.core.widget.b bVar3 = this.cK;
            if (bVar3 != null) {
                bVar3.c((com.kwad.components.core.widget.b) this.mAdTemplate);
                com.kwad.components.core.widget.b bVar4 = this.cK;
                if (bVar4 instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) bVar4).a(this.cN);
                }
                com.kwad.components.core.widget.b bVar5 = this.cK;
                a(bVar5, !(bVar5 instanceof l));
            }
            return this.cK;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.ap(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? com.kwad.sdk.core.response.a.a.aD(this.mAdInfo) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, adExposureFailedReason) == null) {
            try {
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, i, adExposureFailedReason);
            } catch (Exception e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, adInteractionListener) == null) {
            this.cJ = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            AdTemplate adTemplate = this.mAdTemplate;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.aA(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ksAdVideoPlayConfig) == null) {
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                    this.cN.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                    this.cN.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    this.cN.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
                }
                com.kwad.components.core.widget.b bVar = this.cL;
                if (bVar instanceof l) {
                    ((l) bVar).setVideoPlayConfig(this.cN);
                }
            }
            if (isVideoSoundEnable()) {
                adTemplate = this.mAdTemplate;
                i = 2;
            } else {
                adTemplate = this.mAdTemplate;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.cN.setVideoSoundEnable(z);
            if (this.cN.isVideoSoundEnable()) {
                adTemplate = this.mAdTemplate;
                i = 2;
            } else {
                adTemplate = this.mAdTemplate;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }
}
