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
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class d extends AbstractKsFeedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsFeedAd.AdInteractionListener a;
    public com.kwad.components.core.widget.b b;
    public com.kwad.components.core.widget.b c;
    public boolean d;
    public int e;
    @NonNull
    public AdTemplate f;
    public AdInfo g;
    public KsAdVideoPlayConfig h;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

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
            this.a = i;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.b + 1;
                this.b = i;
                return i == this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
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
        this.h = new KsAdVideoPlayConfig.Builder().build();
        this.f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.g = com.kwad.sdk.core.response.a.d.i(adTemplate);
        this.d = z;
        this.e = i;
    }

    @Nullable
    private com.kwad.components.core.widget.b a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, this, context)) != null) {
            return (com.kwad.components.core.widget.b) invokeL.objValue;
        }
        if (!this.d || !com.kwad.sdk.core.response.a.b.r(this.f)) {
            return c.a(context, FeedType.fromInt(this.f.type), com.kwad.sdk.core.response.a.a.Y(this.g));
        }
        l lVar = null;
        try {
            l lVar2 = new l(context);
            try {
                lVar2.setVideoPlayConfig(this.h);
                return lVar2;
            } catch (Throwable th) {
                th = th;
                lVar = lVar2;
                com.kwad.sdk.crash.a.a(th);
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
        bVar.setInnerAdInteractionListener(new b.InterfaceC0528b(this, z, bVar) { // from class: com.kwad.components.ad.feed.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ boolean a;
            public final /* synthetic */ com.kwad.components.core.widget.b b;
            public final /* synthetic */ d c;

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
                this.c = this;
                this.a = z;
                this.b = bVar;
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.c.a == null) {
                    return;
                }
                this.c.a.onAdClicked();
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.c.a != null) {
                        this.c.a.onAdShow();
                    }
                    if (this.a) {
                        f fVar = new f();
                        u.a aVar = new u.a();
                        FeedType fromInt = FeedType.fromInt(this.c.f.type);
                        if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                            fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                        }
                        aVar.a = String.valueOf(fromInt.getType());
                        fVar.a(aVar);
                        com.kwad.components.core.l.c.a().a(this.c.f, null, fVar);
                    }
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.c.a == null) {
                    return;
                }
                this.c.a.onDislikeClicked();
                try {
                    if (this.b.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.b.getParent()).removeView(this.b);
                    }
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.a(e);
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.c.a == null) {
                    return;
                }
                try {
                    this.c.a.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0528b
            public final void e() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.c.a == null) {
                    return;
                }
                try {
                    this.c.a.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.h;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                    return kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                }
            }
            return com.kwad.sdk.core.response.a.a.ay(this.g);
        }
        return invokeV.booleanValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.f == null) {
            return;
        }
        com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
        a2.c("feed_ad_cache_" + this.f.posId);
    }

    public final com.kwad.components.core.widget.b a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                bVar.a();
                return null;
            }
            com.kwad.components.core.widget.b a2 = a(context);
            this.c = a2;
            if (a2 != null) {
                this.c.setMargin(com.kwad.sdk.b.kwai.a.a(context, 16.0f));
                com.kwad.components.core.widget.b bVar2 = this.c;
                if (bVar2 instanceof l) {
                    l lVar = (l) bVar2;
                    int i = this.e;
                    if (i > 0) {
                        lVar.setWidth(i);
                    }
                    lVar.a(this.f, new l.a(this, bVar) { // from class: com.kwad.components.ad.feed.d.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ b a;
                        public final /* synthetic */ d b;

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
                            this.b = this;
                            this.a = bVar;
                        }

                        @Override // com.kwad.components.ad.feed.a.l.a
                        public final void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                d dVar = this.b;
                                dVar.a(dVar.c, false);
                                b bVar3 = this.a;
                                if (bVar3 != null) {
                                    bVar3.a();
                                }
                            }
                        }
                    });
                    return this.c;
                }
                bVar2.a((com.kwad.components.core.widget.b) this.f);
                com.kwad.components.core.widget.b bVar3 = this.c;
                if (bVar3 instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) bVar3).a(this.h);
                }
                a(this.c, true);
            }
            bVar.a();
            return this.c;
        }
        return (com.kwad.components.core.widget.b) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.M(this.g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public final View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            com.kwad.components.core.widget.b bVar = this.b;
            if (bVar == null) {
                b();
                com.kwad.components.core.widget.b bVar2 = this.c;
                if (bVar2 != null) {
                    this.b = bVar2;
                    return bVar2;
                } else if (context == null) {
                    return null;
                } else {
                    this.b = a(context);
                }
            } else if (bVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.b.getParent()).removeView(this.b);
            }
            com.kwad.components.core.widget.b bVar3 = this.b;
            if (bVar3 != null) {
                bVar3.a((com.kwad.components.core.widget.b) this.f);
                com.kwad.components.core.widget.b bVar4 = this.b;
                if (bVar4 instanceof com.kwad.components.ad.feed.a.c) {
                    ((com.kwad.components.ad.feed.a.c) bVar4).a(this.h);
                }
                com.kwad.components.core.widget.b bVar5 = this.b;
                a(bVar5, !(bVar5 instanceof l));
            }
            return this.b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.L(this.g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.Y(this.g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, adExposureFailedReason) == null) {
            try {
                com.kwad.sdk.core.report.a.a(this.f, i, adExposureFailedReason);
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInteractionListener) == null) {
            this.a = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setBidEcpm(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            AdTemplate adTemplate = this.f;
            adTemplate.mBidEcpm = i;
            com.kwad.sdk.core.report.a.l(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public final void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksAdVideoPlayConfig) == null) {
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0) {
                    this.h.setVideoSoundEnable(kSAdVideoPlayConfigImpl.isVideoSoundEnable());
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() != 0) {
                    this.h.setVideoAutoPlayType(kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    this.h.setDataFlowAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
                }
                com.kwad.components.core.widget.b bVar = this.c;
                if (bVar instanceof l) {
                    ((l) bVar).setVideoPlayConfig(this.h);
                }
            }
            if (a()) {
                adTemplate = this.f;
                i = 2;
            } else {
                adTemplate = this.f;
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
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.h.setVideoSoundEnable(z);
            if (this.h.isVideoSoundEnable()) {
                adTemplate = this.f;
                i = 2;
            } else {
                adTemplate = this.f;
                i = 1;
            }
            adTemplate.mInitVoiceStatus = i;
        }
    }
}
