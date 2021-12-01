package com.kwad.sdk.feed;

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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.feed.widget.l;
import com.kwad.sdk.utils.as;
/* loaded from: classes2.dex */
public class b extends AbstractKsFeedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsFeedAd.AdInteractionListener a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f58507b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f58508c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f58509d;

    /* renamed from: e  reason: collision with root package name */
    public int f58510e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f58511f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f58512g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f58513h;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f58516b;

        public a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f58516b + 1;
                this.f58516b = i2;
                return i2 == this.a;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2041b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(@NonNull AdTemplate adTemplate) {
        this(adTemplate, 0, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AdTemplate) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b(@NonNull AdTemplate adTemplate, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58513h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(com.kwad.sdk.core.config.b.o()).build();
        this.f58511f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f58512g = d.j(adTemplate);
        this.f58509d = z;
        this.f58510e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            if (this.f58509d && com.kwad.sdk.core.response.a.b.m(this.f58511f)) {
                l lVar = new l(context);
                lVar.setVideoPlayConfig(this.f58513h);
                return lVar;
            }
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f58511f.type), com.kwad.sdk.core.response.a.a.R(this.f58512g));
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f58511f == null) {
            return;
        }
        com.kwad.sdk.core.diskcache.a.a a2 = com.kwad.sdk.core.diskcache.a.a.a();
        a2.d("feed_ad_cache_" + this.f58511f.posId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.feed.widget.base.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.setInnerAdInteractionListener(new a.InterfaceC2042a(this, aVar) { // from class: com.kwad.sdk.feed.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.kwad.sdk.feed.widget.base.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f58515b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58515b = this;
                this.a = aVar;
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2042a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f58515b.a == null) {
                    return;
                }
                this.f58515b.a.onAdClicked();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2042a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f58515b.a == null) {
                    return;
                }
                this.f58515b.a.onAdShow();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2042a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f58515b.a == null) {
                    return;
                }
                this.f58515b.a.onDislikeClicked();
                try {
                    if (this.a.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.a.getParent()).removeView(this.a);
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2042a
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f58515b.a == null) {
                    return;
                }
                try {
                    this.f58515b.a.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2042a
            public void e() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.f58515b.a == null) {
                    return;
                }
                try {
                    this.f58515b.a.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (r5 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        r5.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwad.sdk.feed.widget.base.a a(InterfaceC2041b interfaceC2041b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC2041b)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            if (context == null) {
                interfaceC2041b.a();
                return null;
            }
            com.kwad.sdk.feed.widget.base.a a2 = a(context);
            this.f58508c = a2;
            if (a2 != null) {
                this.f58508c.setMargin(com.kwad.sdk.a.kwai.a.a(context, 16.0f));
                com.kwad.sdk.feed.widget.base.a aVar = this.f58508c;
                if (aVar instanceof l) {
                    l lVar = (l) aVar;
                    int i2 = this.f58510e;
                    if (i2 > 0) {
                        lVar.setWidth(i2);
                    }
                    lVar.a(this.f58511f, new l.a(this, interfaceC2041b) { // from class: com.kwad.sdk.feed.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InterfaceC2041b a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f58514b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC2041b};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f58514b = this;
                            this.a = interfaceC2041b;
                        }

                        @Override // com.kwad.sdk.feed.widget.l.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                b bVar = this.f58514b;
                                bVar.a(bVar.f58508c);
                                InterfaceC2041b interfaceC2041b2 = this.a;
                                if (interfaceC2041b2 != null) {
                                    interfaceC2041b2.a();
                                }
                            }
                        }
                    });
                } else {
                    aVar.a(this.f58511f);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.f58508c;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f58513h);
                    }
                    a(this.f58508c);
                }
            }
            return this.f58508c;
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.a.a.F(this.f58512g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            com.kwad.sdk.feed.widget.base.a aVar = this.f58507b;
            if (aVar == null) {
                a();
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f58508c;
                if (aVar2 != null) {
                    this.f58507b = aVar2;
                    return aVar2;
                } else if (context == null) {
                    return null;
                } else {
                    this.f58507b = a(context);
                }
            } else if (aVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f58507b.getParent()).removeView(this.f58507b);
            }
            com.kwad.sdk.feed.widget.base.a aVar3 = this.f58507b;
            if (aVar3 != null) {
                aVar3.a(this.f58511f);
                com.kwad.sdk.feed.widget.base.a aVar4 = this.f58507b;
                if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f58513h);
                }
                a(this.f58507b);
            }
            return this.f58507b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.a.a.E(this.f58512g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.a.a.R(this.f58512g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, adExposureFailedReason) == null) {
            com.kwad.sdk.core.report.a.a(this.f58511f, i2, adExposureFailedReason);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, adInteractionListener) == null) {
            this.a = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            AdTemplate adTemplate = this.f58511f;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ksAdVideoPlayConfig) == null) || ksAdVideoPlayConfig == null) {
            return;
        }
        this.f58513h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.f58513h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        com.kwad.sdk.feed.widget.base.a aVar = this.f58508c;
        if (aVar instanceof l) {
            ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
        }
        if (this.f58513h.isVideoSoundEnable()) {
            adTemplate = this.f58511f;
            i2 = 2;
        } else {
            adTemplate = this.f58511f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
        if (this.f58511f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        as.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f58511f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f58513h.setVideoSoundEnable(z);
            if (this.f58513h.isVideoSoundEnable()) {
                adTemplate = this.f58511f;
                i2 = 2;
            } else {
                adTemplate = this.f58511f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }
}
