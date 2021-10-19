package com.kwad.sdk.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.feed.widget.l;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.av;
/* loaded from: classes10.dex */
public class b extends AbstractKsFeedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsFeedAd.AdInteractionListener f73250a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f73251b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f73252c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73253d;

    /* renamed from: e  reason: collision with root package name */
    public int f73254e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f73255f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f73256g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f73257h;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f73262a;

        /* renamed from: b  reason: collision with root package name */
        public int f73263b;

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
            this.f73262a = i2;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f73263b + 1;
                this.f73263b = i2;
                return i2 == this.f73262a;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2014b {
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
        this.f73257h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(c.t()).build();
        this.f73255f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f73256g = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f73253d = z;
        this.f73254e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            if (c.e(context).exists() && a() && this.f73253d) {
                l lVar = new l(context);
                lVar.setVideoPlayConfig(this.f73257h);
                return lVar;
            }
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f73255f.type), com.kwad.sdk.core.response.b.a.H(this.f73256g));
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.feed.widget.base.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC2015a(this, aVar) { // from class: com.kwad.sdk.feed.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.feed.widget.base.a f73260a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f73261b;

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
                this.f73261b = this;
                this.f73260a = aVar;
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2015a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f73261b.f73250a == null) {
                    return;
                }
                this.f73261b.f73250a.onAdClicked();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2015a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f73261b.f73250a == null) {
                    return;
                }
                this.f73261b.f73250a.onAdShow();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2015a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f73261b.f73250a == null) {
                    return;
                }
                this.f73261b.f73250a.onDislikeClicked();
                try {
                    if (this.f73260a.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f73260a.getParent()).removeView(this.f73260a);
                    }
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            }
        });
    }

    private boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? !TextUtils.isEmpty(this.f73256g.adStyleInfo.feedAdInfo.templateConfig) : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r5 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r5 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
        r5.a();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.kwad.sdk.feed.widget.base.a a(InterfaceC2014b interfaceC2014b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC2014b)) == null) {
            Context context = KsAdSDK.getContext();
            if (context == null) {
                interfaceC2014b.a();
            }
            this.f73252c = a(context);
            this.f73252c.setMargin(av.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.f73252c;
            if (aVar != null) {
                if (aVar instanceof l) {
                    l lVar = (l) aVar;
                    int i2 = this.f73254e;
                    if (i2 > 0) {
                        lVar.setWidth(i2);
                    }
                    lVar.a(this.f73255f, new l.a(this, interfaceC2014b) { // from class: com.kwad.sdk.feed.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC2014b f73258a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f73259b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC2014b};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f73259b = this;
                            this.f73258a = interfaceC2014b;
                        }

                        @Override // com.kwad.sdk.feed.widget.l.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                b bVar = this.f73259b;
                                bVar.a(bVar.f73252c);
                                InterfaceC2014b interfaceC2014b2 = this.f73258a;
                                if (interfaceC2014b2 != null) {
                                    interfaceC2014b2.a();
                                }
                            }
                        }
                    });
                } else {
                    aVar.a(this.f73255f);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.f73252c;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f73257h);
                    }
                    a(this.f73252c);
                }
            }
            return this.f73252c;
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.x(this.f73256g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            com.kwad.sdk.feed.widget.base.a aVar = this.f73251b;
            if (aVar == null) {
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f73252c;
                if (aVar2 != null) {
                    this.f73251b = aVar2;
                    return aVar2;
                }
                this.f73251b = a(context);
            } else if (aVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f73251b.getParent()).removeView(this.f73251b);
            }
            com.kwad.sdk.feed.widget.base.a aVar3 = this.f73251b;
            if (aVar3 != null) {
                aVar3.a(this.f73255f);
                com.kwad.sdk.feed.widget.base.a aVar4 = this.f73251b;
                if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f73257h);
                }
                a(this.f73251b);
            }
            return this.f73251b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.w(this.f73256g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.b.a.H(this.f73256g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.f73250a = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            AdTemplate adTemplate = this.f73255f;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.a.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, ksAdVideoPlayConfig) == null) || ksAdVideoPlayConfig == null) {
            return;
        }
        this.f73257h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.f73257h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        com.kwad.sdk.feed.widget.base.a aVar = this.f73252c;
        if (aVar instanceof l) {
            ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
        }
        if (this.f73257h.isVideoSoundEnable()) {
            adTemplate = this.f73255f;
            i2 = 2;
        } else {
            adTemplate = this.f73255f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
        if (this.f73255f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        am.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f73255f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f73257h.setVideoSoundEnable(z);
            if (this.f73257h.isVideoSoundEnable()) {
                adTemplate = this.f73255f;
                i2 = 2;
            } else {
                adTemplate = this.f73255f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }
}
