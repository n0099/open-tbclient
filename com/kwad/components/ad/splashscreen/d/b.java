package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.e;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public ViewGroup a;
    public ViewStub b;
    public KsAdWebView c;
    public ViewGroup d;
    public View e;
    @Nullable
    public AdTemplate f;
    @Nullable
    public AdInfo g;
    public TextView h;
    public boolean i;
    @Nullable
    public f j;
    public com.kwad.sdk.widget.f k;
    public com.kwad.components.core.c.a.b l;
    public a m;

    public b(@NonNull ViewGroup viewGroup, ViewStub viewStub, KsAdWebView ksAdWebView, boolean z, com.kwad.components.core.c.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, viewStub, ksAdWebView, Boolean.valueOf(z), bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = viewGroup;
        this.b = viewStub;
        this.c = ksAdWebView;
        this.l = bVar;
        this.i = z;
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        this.e = viewGroup.findViewById(R.id.obfuscated_res_0x7f09119f);
        this.h = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0911a2);
        this.k = new com.kwad.sdk.widget.f(this.e.getContext(), this.e, this);
        this.e.getContext();
        a(e.a(this.f, this.g, this.l, 4));
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
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) || (textView = this.h) == null || str == null) {
            return;
        }
        textView.setText(str);
    }

    private void a(boolean z, boolean z2) {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (fVar = this.j) == null) {
            return;
        }
        fVar.a(z, z2);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwad.sdk.core.d.b.a("SplashActionBarNativeHelper", "rollBackToNative mRootViewStub: " + this.b + ", mSplashWebView: " + this.c);
            if (this.c == null) {
                return;
            }
            if (this.d == null) {
                ViewStub viewStub = this.b;
                this.d = (ViewGroup) ((viewStub == null || viewStub.getParent() == null) ? this.a.findViewById(R.id.obfuscated_res_0x7f0911a0) : this.b.inflate());
                a(this.d);
            }
            ViewGroup viewGroup = this.d;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
                this.c.setVisibility(8);
            }
        }
    }

    public final void a(@Nullable f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.j = fVar;
        }
    }

    public final void a(AdTemplate adTemplate) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            this.f = adTemplate;
            a aVar2 = this.m;
            if (aVar2 == null) {
                this.m = new a(this, this.b.getContext(), this.f) { // from class: com.kwad.components.ad.splashscreen.d.b.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9, r10);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r9, r10};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                Object[] objArr2 = newInitContext.callArgs;
                                super((Context) objArr2[0], (AdTemplate) objArr2[1]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.components.ad.splashscreen.d.a
                    public final void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            this.a.a(str);
                        }
                    }
                };
            } else {
                aVar2.a(adTemplate);
            }
            if (adTemplate != null) {
                this.g = d.i(adTemplate);
            }
            com.kwad.components.core.c.a.b bVar = this.l;
            if (bVar == null || (aVar = this.m) == null) {
                return;
            }
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            a(true, view2.equals(this.e));
        }
    }

    public final void b() {
        com.kwad.components.core.c.a.b bVar;
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (bVar = this.l) == null || (aVar = this.m) == null) {
            return;
        }
        bVar.b(aVar);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && this.i) {
            a(false, view2.equals(this.e));
        }
    }
}
