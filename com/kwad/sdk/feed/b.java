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
    public KsFeedAd.AdInteractionListener f72716a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f72717b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f72718c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72719d;

    /* renamed from: e  reason: collision with root package name */
    public int f72720e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f72721f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f72722g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f72723h;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f72728a;

        /* renamed from: b  reason: collision with root package name */
        public int f72729b;

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
            this.f72728a = i2;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i2 = this.f72729b + 1;
                this.f72729b = i2;
                return i2 == this.f72728a;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC2008b {
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
        this.f72723h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(c.t()).build();
        this.f72721f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f72722g = com.kwad.sdk.core.response.b.c.i(adTemplate);
        this.f72719d = z;
        this.f72720e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            if (c.e(context).exists() && a() && this.f72719d) {
                l lVar = new l(context);
                lVar.setVideoPlayConfig(this.f72723h);
                return lVar;
            }
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f72721f.type), com.kwad.sdk.core.response.b.a.H(this.f72722g));
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.feed.widget.base.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC2009a(this, aVar) { // from class: com.kwad.sdk.feed.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.feed.widget.base.a f72726a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f72727b;

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
                this.f72727b = this;
                this.f72726a = aVar;
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2009a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f72727b.f72716a == null) {
                    return;
                }
                this.f72727b.f72716a.onAdClicked();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2009a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f72727b.f72716a == null) {
                    return;
                }
                this.f72727b.f72716a.onAdShow();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC2009a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72727b.f72716a == null) {
                    return;
                }
                this.f72727b.f72716a.onDislikeClicked();
                try {
                    if (this.f72726a.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f72726a.getParent()).removeView(this.f72726a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? !TextUtils.isEmpty(this.f72722g.adStyleInfo.feedAdInfo.templateConfig) : invokeV.booleanValue;
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
    public com.kwad.sdk.feed.widget.base.a a(InterfaceC2008b interfaceC2008b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC2008b)) == null) {
            Context context = KsAdSDK.getContext();
            if (context == null) {
                interfaceC2008b.a();
            }
            this.f72718c = a(context);
            this.f72718c.setMargin(av.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.f72718c;
            if (aVar != null) {
                if (aVar instanceof l) {
                    l lVar = (l) aVar;
                    int i2 = this.f72720e;
                    if (i2 > 0) {
                        lVar.setWidth(i2);
                    }
                    lVar.a(this.f72721f, new l.a(this, interfaceC2008b) { // from class: com.kwad.sdk.feed.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC2008b f72724a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f72725b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC2008b};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f72725b = this;
                            this.f72724a = interfaceC2008b;
                        }

                        @Override // com.kwad.sdk.feed.widget.l.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                b bVar = this.f72725b;
                                bVar.a(bVar.f72718c);
                                InterfaceC2008b interfaceC2008b2 = this.f72724a;
                                if (interfaceC2008b2 != null) {
                                    interfaceC2008b2.a();
                                }
                            }
                        }
                    });
                } else {
                    aVar.a(this.f72721f);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.f72718c;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f72723h);
                    }
                    a(this.f72718c);
                }
            }
            return this.f72718c;
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.x(this.f72722g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            com.kwad.sdk.feed.widget.base.a aVar = this.f72717b;
            if (aVar == null) {
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f72718c;
                if (aVar2 != null) {
                    this.f72717b = aVar2;
                    return aVar2;
                }
                this.f72717b = a(context);
            } else if (aVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f72717b.getParent()).removeView(this.f72717b);
            }
            com.kwad.sdk.feed.widget.base.a aVar3 = this.f72717b;
            if (aVar3 != null) {
                aVar3.a(this.f72721f);
                com.kwad.sdk.feed.widget.base.a aVar4 = this.f72717b;
                if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f72723h);
                }
                a(this.f72717b);
            }
            return this.f72717b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getInteractionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? com.kwad.sdk.core.response.b.a.w(this.f72722g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getMaterialType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? com.kwad.sdk.core.response.b.a.H(this.f72722g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, adInteractionListener) == null) {
            this.f72716a = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            AdTemplate adTemplate = this.f72721f;
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
        this.f72723h.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
        this.f72723h.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        com.kwad.sdk.feed.widget.base.a aVar = this.f72718c;
        if (aVar instanceof l) {
            ((l) aVar).setVideoPlayConfig(ksAdVideoPlayConfig);
        }
        if (this.f72723h.isVideoSoundEnable()) {
            adTemplate = this.f72721f;
            i2 = 2;
        } else {
            adTemplate = this.f72721f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
        if (this.f72721f.mAdScene == null || KsAdSDKImpl.get().getContext() == null) {
            return;
        }
        am.a(KsAdSDKImpl.get().getContext(), String.valueOf(this.f72721f.mAdScene.posId), ksAdVideoPlayConfig.isDataFlowAutoStart() ? 1 : 0);
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f72723h.setVideoSoundEnable(z);
            if (this.f72723h.isVideoSoundEnable()) {
                adTemplate = this.f72721f;
                i2 = 2;
            } else {
                adTemplate = this.f72721f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }
}
