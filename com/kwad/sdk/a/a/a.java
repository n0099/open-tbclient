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
/* loaded from: classes10.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f71320a;

    /* renamed from: b  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f71321b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f71322c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f71323d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.b.b f71324e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public KsAdVideoPlayConfig f71325f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.b> f71326g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f71327h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1977a f71328i;

    /* renamed from: j  reason: collision with root package name */
    public b f71329j;
    public Handler k;

    /* renamed from: com.kwad.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1977a {
        void a();
    }

    /* loaded from: classes10.dex */
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
        this.f71326g = new ArrayList();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.removeCallbacksAndMessages(null);
            this.f71326g.clear();
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
            if (com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.i(this.f71320a)) && (bVar = this.f71327h) != null && bVar.d()) {
                j.b(this.f71320a);
                this.f71327h.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f71320a));
                this.f71327h.a();
            } else if ((com.kwad.sdk.core.config.c.af() || z) && com.kwad.sdk.core.download.b.a.a(av.a(view), this.f71320a, new a.InterfaceC1992a(this, z2) { // from class: com.kwad.sdk.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f71330a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f71331b;

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
                    this.f71331b = this;
                    this.f71330a = z2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f71331b.a(this.f71330a);
                    }
                }
            }, this.f71323d, z) == 0 && this.f71322c != null) {
                this.k.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.a.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f71332a;

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
                        this.f71332a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f71332a.f71322c.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public void a(InterfaceC1977a interfaceC1977a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1977a) == null) {
            this.f71328i = interfaceC1977a;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f71329j = bVar;
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || this.f71326g.contains(bVar)) {
            return;
        }
        this.f71326g.add(bVar);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                com.kwad.sdk.core.report.a.a(this.f71320a, (v.a) null);
            }
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f71321b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    public void b() {
        InterfaceC1977a interfaceC1977a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (interfaceC1977a = this.f71328i) == null) {
            return;
        }
        interfaceC1977a.a();
    }

    public void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.f71329j) == null) {
            return;
        }
        bVar.a();
    }
}
