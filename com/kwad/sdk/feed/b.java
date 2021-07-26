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
/* loaded from: classes6.dex */
public class b extends AbstractKsFeedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsFeedAd.AdInteractionListener f35748a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35749b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f35750c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35751d;

    /* renamed from: e  reason: collision with root package name */
    public int f35752e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f35753f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f35754g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f35755h;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f35760a;

        /* renamed from: b  reason: collision with root package name */
        public int f35761b;

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
            this.f35760a = i2;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f35761b + 1;
                this.f35761b = i2;
                return i2 == this.f35760a;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0437b {
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
        this.f35755h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(c.t()).build();
        this.f35753f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f35754g = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f35751d = z;
        this.f35752e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            if (c.e(context).exists() && a() && this.f35751d) {
                l lVar = new l(context);
                lVar.setVideoPlayConfig(this.f35755h);
                return lVar;
            }
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f35753f.type), com.kwad.sdk.core.response.b.a.H(this.f35754g));
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.feed.widget.base.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0438a(this, aVar) { // from class: com.kwad.sdk.feed.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.feed.widget.base.a f35758a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f35759b;

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
                this.f35759b = this;
                this.f35758a = aVar;
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0438a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35759b.f35748a == null) {
                    return;
                }
                this.f35759b.f35748a.onAdClicked();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0438a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f35759b.f35748a == null) {
                    return;
                }
                this.f35759b.f35748a.onAdShow();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0438a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f35759b.f35748a == null) {
                    return;
                }
                this.f35759b.f35748a.onDislikeClicked();
                try {
                    if (this.f35758a.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f35758a.getParent()).removeView(this.f35758a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? !TextUtils.isEmpty(this.f35754g.adStyleInfo.feedAdInfo.templateConfig) : invokeV.booleanValue;
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
    public com.kwad.sdk.feed.widget.base.a a(InterfaceC0437b interfaceC0437b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC0437b)) == null) {
            Context context = KsAdSDK.getContext();
            if (context == null) {
                interfaceC0437b.a();
            }
            this.f35750c = a(context);
            this.f35750c.setMargin(av.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.f35750c;
            if (aVar != null) {
                if (aVar instanceof l) {
                    l lVar = (l) aVar;
                    int i2 = this.f35752e;
                    if (i2 > 0) {
                        lVar.setWidth(i2);
                    }
                    lVar.a(this.f35753f, new l.a(this, interfaceC0437b) { // from class: com.kwad.sdk.feed.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC0437b f35756a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f35757b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC0437b};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f35757b = this;
                            this.f35756a = interfaceC0437b;
                        }

                        @Override // com.kwad.sdk.feed.widget.l.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                b bVar = this.f35757b;
                                bVar.a(bVar.f35750c);
                                InterfaceC0437b interfaceC0437b2 = this.f35756a;
                                if (interfaceC0437b2 != null) {
                                    interfaceC0437b2.a();
                                }
                            }
                        }
                    });
                } else {
                    aVar.a(this.f35753f);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.f35750c;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f35755h);
                    }
                    a(this.f35750c);
                }
            }
            return this.f35750c;
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.x(this.f35754g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            com.kwad.sdk.feed.widget.base.a aVar = this.f35749b;
            if (aVar == null) {
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f35750c;
                if (aVar2 != null) {
                    this.f35749b = aVar2;
                    return aVar2;
                }
                this.f35749b = a(context);
            } else if (aVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f35749b.getParent()).removeView(this.f35749b);
            }
            com.kwad.sdk.feed.widget.base.a aVar3 = this.f35749b;
            if (aVar3 != null) {
                aVar3.a(this.f35753f);
                com.kwad.sdk.feed.widget.base.a aVar4 = this.f35749b;
                if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f35755h);
                }
                a(this.f35749b);
            }
            return this.f35749b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.w(this.f35754g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.b.a.H(this.f35754g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.f35748a = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            AdTemplate adTemplate = this.f35753f;
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
        this.f35755h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.f35755h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        com.kwad.sdk.feed.widget.base.a aVar = this.f35750c;
        if (aVar instanceof l) {
            ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
        }
        if (this.f35755h.isVideoSoundEnable()) {
            adTemplate = this.f35753f;
            i2 = 2;
        } else {
            adTemplate = this.f35753f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
        if (this.f35753f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        am.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f35753f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f35755h.setVideoSoundEnable(z);
            if (this.f35755h.isVideoSoundEnable()) {
                adTemplate = this.f35753f;
                i2 = 2;
            } else {
                adTemplate = this.f35753f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }
}
