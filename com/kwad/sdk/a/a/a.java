package com.kwad.sdk.a.a;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f64717a;

    /* renamed from: b  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f64718b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f64719c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f64720d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.b.b f64721e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public KsAdVideoPlayConfig f64722f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.b> f64723g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f64724h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1926a f64725i;
    public b j;
    public Handler k;

    /* renamed from: com.kwad.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1926a {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    public a() {
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
        this.k = new Handler(Looper.getMainLooper());
        this.f64723g = new ArrayList();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.removeCallbacksAndMessages(null);
            this.f64723g.clear();
        }
    }

    public void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, z) == null) {
            a(view, z, true);
        }
    }

    public void a(View view, boolean z, boolean z2) {
        com.kwad.sdk.core.video.videoview.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.i(this.f64717a)) && (bVar = this.f64724h) != null && bVar.d()) {
                j.b(this.f64717a);
                this.f64724h.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f64717a));
                this.f64724h.a();
            } else if ((com.kwad.sdk.core.config.c.af() || z) && com.kwad.sdk.core.download.b.a.a(av.a(view), this.f64717a, new a.InterfaceC1941a(this, z2) { // from class: com.kwad.sdk.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f64726a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f64727b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f64727b = this;
                    this.f64726a = z2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1941a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f64727b.a(this.f64726a);
                    }
                }
            }, this.f64720d, z) == 0 && this.f64719c != null) {
                this.k.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.a.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f64728a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f64728a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f64728a.f64719c.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public void a(InterfaceC1926a interfaceC1926a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1926a) == null) {
            this.f64725i = interfaceC1926a;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || this.f64723g.contains(bVar)) {
            return;
        }
        this.f64723g.add(bVar);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                com.kwad.sdk.core.report.a.a(this.f64717a, (v.a) null);
            }
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f64718b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    public void b() {
        InterfaceC1926a interfaceC1926a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (interfaceC1926a = this.f64725i) == null) {
            return;
        }
        interfaceC1926a.a();
    }

    public void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.j) == null) {
            return;
        }
        bVar.a();
    }
}
