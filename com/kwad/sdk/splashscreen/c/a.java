package com.kwad.sdk.splashscreen.c;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.a.b;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.splashscreen.e;
import com.kwad.sdk.splashscreen.f;
import com.kwad.sdk.widget.d;
/* loaded from: classes3.dex */
public class a implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub a;

    /* renamed from: b  reason: collision with root package name */
    public KsAdWebView f60135b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f60136c;

    /* renamed from: d  reason: collision with root package name */
    public View f60137d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f60138e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f60139f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60140g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60141h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public f f60142i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.widget.f f60143j;

    /* renamed from: k  reason: collision with root package name */
    public b f60144k;
    public com.kwad.sdk.splashscreen.a l;

    public a(ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, ksAdWebView, Boolean.valueOf(z), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewStub;
        this.f60135b = ksAdWebView;
        this.f60144k = bVar;
        this.f60141h = z;
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, viewGroup) == null) {
            this.f60137d = viewGroup.findViewById(R.id.ksad_splash_actionbar_native);
            this.f60140g = (TextView) viewGroup.findViewById(R.id.ksad_splash_actionbar_text);
            this.f60143j = new com.kwad.sdk.widget.f(this.f60137d.getContext(), this.f60137d, this);
            a(e.a(this.f60138e, this.f60139f, this.f60144k));
        }
    }

    private void a(e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, eVar) == null) || eVar == null) {
            return;
        }
        a(eVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || (textView = this.f60140g) == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void a(boolean z, boolean z2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (fVar = this.f60142i) == null) {
            return;
        }
        fVar.a(z, z2);
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.d.a.a("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.a + ", mSplashWebView: " + this.f60135b);
            ViewStub viewStub = this.a;
            if (viewStub == null || this.f60135b == null) {
                return;
            }
            if (this.f60136c == null) {
                ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
                this.f60136c = viewGroup;
                a(viewGroup);
            }
            this.f60136c.setVisibility(0);
            this.f60135b.setVisibility(8);
        }
    }

    public void a(AdTemplate adTemplate) {
        com.kwad.sdk.splashscreen.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate) == null) {
            this.f60138e = adTemplate;
            com.kwad.sdk.splashscreen.a aVar2 = this.l;
            if (aVar2 == null) {
                this.l = new com.kwad.sdk.splashscreen.a(this, adTemplate) { // from class: com.kwad.sdk.splashscreen.c.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ a f60145b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(adTemplate);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, adTemplate};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((AdTemplate) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f60145b = this;
                    }

                    @Override // com.kwad.sdk.splashscreen.a
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.f60145b.a(str);
                        }
                    }
                };
            } else {
                aVar2.a(adTemplate);
            }
            if (adTemplate != null) {
                this.f60139f = com.kwad.sdk.core.response.a.d.j(adTemplate);
            }
            b bVar = this.f60144k;
            if (bVar == null || (aVar = this.l) == null) {
                return;
            }
            bVar.a(aVar);
        }
    }

    public void a(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.f60142i = fVar;
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            a(true, view.equals(this.f60137d));
        }
    }

    public void b() {
        b bVar;
        com.kwad.sdk.splashscreen.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.f60144k) == null || (aVar = this.l) == null) {
            return;
        }
        bVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && this.f60141h) {
            a(false, view.equals(this.f60137d));
        }
    }
}
