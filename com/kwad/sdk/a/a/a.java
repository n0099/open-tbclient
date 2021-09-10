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
    public AdTemplate f70966a;

    /* renamed from: b  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f70967b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f70968c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f70969d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.b.b f70970e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public KsAdVideoPlayConfig f70971f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.b> f70972g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f70973h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1971a f70974i;

    /* renamed from: j  reason: collision with root package name */
    public b f70975j;
    public Handler k;

    /* renamed from: com.kwad.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1971a {
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
        this.f70972g = new ArrayList();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.removeCallbacksAndMessages(null);
            this.f70972g.clear();
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
            if (com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.i(this.f70966a)) && (bVar = this.f70973h) != null && bVar.d()) {
                j.b(this.f70966a);
                this.f70973h.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f70966a));
                this.f70973h.a();
            } else if ((com.kwad.sdk.core.config.c.af() || z) && com.kwad.sdk.core.download.b.a.a(av.a(view), this.f70966a, new a.InterfaceC1986a(this, z2) { // from class: com.kwad.sdk.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f70976a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f70977b;

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
                    this.f70977b = this;
                    this.f70976a = z2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f70977b.a(this.f70976a);
                    }
                }
            }, this.f70969d, z) == 0 && this.f70968c != null) {
                this.k.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.a.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f70978a;

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
                        this.f70978a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f70978a.f70968c.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public void a(InterfaceC1971a interfaceC1971a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC1971a) == null) {
            this.f70974i = interfaceC1971a;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f70975j = bVar;
        }
    }

    public void a(a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || this.f70972g.contains(bVar)) {
            return;
        }
        this.f70972g.add(bVar);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                com.kwad.sdk.core.report.a.a(this.f70966a, (v.a) null);
            }
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f70967b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    public void b() {
        InterfaceC1971a interfaceC1971a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (interfaceC1971a = this.f70974i) == null) {
            return;
        }
        interfaceC1971a.a();
    }

    public void c() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bVar = this.f70975j) == null) {
            return;
        }
        bVar.a();
    }
}
