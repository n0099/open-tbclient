package com.kwad.sdk.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.core.AbstractKsFeedAd;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.feed.widget.base.a;
import com.kwad.sdk.feed.widget.l;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends AbstractKsFeedAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public KsFeedAd.AdInteractionListener f37408a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f37409b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.feed.widget.base.a f37410c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f37411d;

    /* renamed from: e  reason: collision with root package name */
    public int f37412e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f37413f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f37414g;

    /* renamed from: h  reason: collision with root package name */
    public KsAdVideoPlayConfig f37415h;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f37420a;

        /* renamed from: b  reason: collision with root package name */
        public int f37421b;

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
            this.f37420a = i2;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37421b : invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.f37421b + 1;
                this.f37421b = i2;
                return i2 == this.f37420a;
            }
            return invokeV.booleanValue;
        }
    }

    /* renamed from: com.kwad.sdk.feed.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0451b {
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
        this.f37415h = new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).dataFlowAutoStart(false).build();
        this.f37413f = adTemplate;
        adTemplate.mInitVoiceStatus = 1;
        this.f37414g = c.j(adTemplate);
        this.f37411d = z;
        this.f37412e = i2;
    }

    @Nullable
    private com.kwad.sdk.feed.widget.base.a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            if (com.kwad.sdk.core.config.c.c(context).exists() && a() && this.f37411d) {
                l lVar = new l(context);
                lVar.setVideoPlayConfig(this.f37415h);
                return lVar;
            }
            return com.kwad.sdk.feed.a.a(context, FeedType.fromInt(this.f37413f.type), com.kwad.sdk.core.response.b.a.L(this.f37414g));
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.feed.widget.base.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) || aVar == null) {
            return;
        }
        aVar.setAdClickListener(new a.InterfaceC0452a(this, aVar) { // from class: com.kwad.sdk.feed.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.kwad.sdk.feed.widget.base.a f37418a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f37419b;

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
                this.f37419b = this;
                this.f37418a = aVar;
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0452a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f37419b.f37408a == null) {
                    return;
                }
                this.f37419b.f37408a.onAdClicked();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0452a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f37419b.f37408a == null) {
                    return;
                }
                this.f37419b.f37408a.onAdShow();
            }

            @Override // com.kwad.sdk.feed.widget.base.a.InterfaceC0452a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f37419b.f37408a == null) {
                    return;
                }
                this.f37419b.f37408a.onDislikeClicked();
                try {
                    if (this.f37418a.getParent() instanceof ViewGroup) {
                        ((ViewGroup) this.f37418a.getParent()).removeView(this.f37418a);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) ? !TextUtils.isEmpty(this.f37414g.adStyleInfo.feedAdInfo.templateConfig) : invokeV.booleanValue;
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
    public com.kwad.sdk.feed.widget.base.a a(InterfaceC0451b interfaceC0451b) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, interfaceC0451b)) == null) {
            Context context = KsAdSDK.getContext();
            if (context == null) {
                interfaceC0451b.a();
            }
            this.f37410c = a(context);
            this.f37410c.setMargin(ao.a(context, 16.0f));
            com.kwad.sdk.feed.widget.base.a aVar = this.f37410c;
            if (aVar != null) {
                if (aVar instanceof l) {
                    l lVar = (l) aVar;
                    int i2 = this.f37412e;
                    if (i2 > 0) {
                        lVar.setWidth(i2);
                    }
                    lVar.a(this.f37413f, new l.a(this, interfaceC0451b) { // from class: com.kwad.sdk.feed.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ InterfaceC0451b f37416a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f37417b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, interfaceC0451b};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f37417b = this;
                            this.f37416a = interfaceC0451b;
                        }

                        @Override // com.kwad.sdk.feed.widget.l.a
                        public void a() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                b bVar = this.f37417b;
                                bVar.a(bVar.f37410c);
                                InterfaceC0451b interfaceC0451b2 = this.f37416a;
                                if (interfaceC0451b2 != null) {
                                    interfaceC0451b2.a();
                                }
                            }
                        }
                    });
                } else {
                    aVar.a(this.f37413f);
                    com.kwad.sdk.feed.widget.base.a aVar2 = this.f37410c;
                    if (aVar2 instanceof com.kwad.sdk.feed.widget.a) {
                        ((com.kwad.sdk.feed.widget.a) aVar2).a(this.f37415h);
                    }
                    a(this.f37410c);
                }
            }
            return this.f37410c;
        }
        return (com.kwad.sdk.feed.widget.base.a) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public int getECPM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? com.kwad.sdk.core.response.b.a.A(this.f37414g) : invokeV.intValue;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsFeedAd
    public View getFeedView2(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            com.kwad.sdk.feed.widget.base.a aVar = this.f37409b;
            if (aVar == null) {
                com.kwad.sdk.feed.widget.base.a aVar2 = this.f37410c;
                if (aVar2 != null) {
                    this.f37409b = aVar2;
                    return aVar2;
                }
                this.f37409b = a(context);
            } else if (aVar.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f37409b.getParent()).removeView(this.f37409b);
            }
            com.kwad.sdk.feed.widget.base.a aVar3 = this.f37409b;
            if (aVar3 != null) {
                aVar3.a(this.f37413f);
                com.kwad.sdk.feed.widget.base.a aVar4 = this.f37409b;
                if (aVar4 instanceof com.kwad.sdk.feed.widget.a) {
                    ((com.kwad.sdk.feed.widget.a) aVar4).a(this.f37415h);
                }
                a(this.f37409b);
            }
            return this.f37409b;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setAdInteractionListener(KsFeedAd.AdInteractionListener adInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adInteractionListener) == null) {
            this.f37408a = adInteractionListener;
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setBidEcpm(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            AdTemplate adTemplate = this.f37413f;
            adTemplate.mBidEcpm = i2;
            com.kwad.sdk.core.report.b.m(adTemplate);
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoPlayConfig(@Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ksAdVideoPlayConfig) == null) || ksAdVideoPlayConfig == null) {
            return;
        }
        this.f37415h = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig.isVideoSoundEnable()) {
            adTemplate = this.f37413f;
            i2 = 2;
        } else {
            adTemplate = this.f37413f;
            i2 = 1;
        }
        adTemplate.mInitVoiceStatus = i2;
    }

    @Override // com.kwad.sdk.api.KsFeedAd
    public void setVideoSoundEnable(boolean z) {
        AdTemplate adTemplate;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f37415h.setVideoSoundEnable(z);
            if (this.f37415h.isVideoSoundEnable()) {
                adTemplate = this.f37413f;
                i2 = 2;
            } else {
                adTemplate = this.f37413f;
                i2 = 1;
            }
            adTemplate.mInitVoiceStatus = i2;
        }
    }
}
