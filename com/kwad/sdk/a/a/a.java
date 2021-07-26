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
/* loaded from: classes6.dex */
public class a extends com.kwad.sdk.core.e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f33864a;

    /* renamed from: b  reason: collision with root package name */
    public KsInterstitialAd.AdInteractionListener f33865b;

    /* renamed from: c  reason: collision with root package name */
    public Dialog f33866c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f33867d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.a.b.b f33868e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public KsAdVideoPlayConfig f33869f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.b> f33870g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.video.videoview.b f33871h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0400a f33872i;
    public b j;
    public Handler k;

    /* renamed from: com.kwad.sdk.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0400a {
        void a();
    }

    /* loaded from: classes6.dex */
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
        this.f33870g = new ArrayList();
    }

    @Override // com.kwad.sdk.core.e.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.removeCallbacksAndMessages(null);
            this.f33870g.clear();
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
            if (com.kwad.sdk.core.response.b.a.F(com.kwad.sdk.core.response.b.c.i(this.f33864a)) && (bVar = this.f33871h) != null && bVar.d()) {
                j.b(this.f33864a);
                this.f33871h.setKsPlayLogParam(com.kwad.sdk.contentalliance.detail.video.b.a(this.f33864a));
                this.f33871h.a();
            } else if ((com.kwad.sdk.core.config.c.af() || z) && com.kwad.sdk.core.download.b.a.a(av.a(view), this.f33864a, new a.InterfaceC0415a(this, z2) { // from class: com.kwad.sdk.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f33873a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f33874b;

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
                    this.f33874b = this;
                    this.f33873a = z2;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f33874b.a(this.f33873a);
                    }
                }
            }, this.f33867d, z) == 0 && this.f33866c != null) {
                this.k.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.a.a.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f33875a;

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
                        this.f33875a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f33875a.f33866c.dismiss();
                        }
                    }
                }, 500L);
            }
        }
    }

    public void a(InterfaceC0400a interfaceC0400a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, interfaceC0400a) == null) {
            this.f33872i = interfaceC0400a;
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
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || this.f33870g.contains(bVar)) {
            return;
        }
        this.f33870g.add(bVar);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                com.kwad.sdk.core.report.a.a(this.f33864a, (v.a) null);
            }
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.f33865b;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClicked();
            }
        }
    }

    public void b() {
        InterfaceC0400a interfaceC0400a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (interfaceC0400a = this.f33872i) == null) {
            return;
        }
        interfaceC0400a.a();
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
