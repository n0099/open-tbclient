package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a extends KSFrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int k = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public TextView c;
    public ImageView d;
    public ImageView e;
    public KsLogoView f;
    public ComplianceTextView g;
    public DownloadProgressView h;
    public com.kwad.components.ad.reflux.a i;
    public b.InterfaceC0528b j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(583988027, "Lcom/kwad/components/ad/reflux/kwai/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(583988027, "Lcom/kwad/components/ad/reflux/kwai/a;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context, null, 0);
    }

    private void a(int i, boolean z) {
        com.kwad.components.ad.reflux.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (aVar = this.i) == null) {
            return;
        }
        AdTemplate c = aVar.c();
        com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this)).a(c).a(this.i.n()).a(i).a(true).a(new a.b(this, c) { // from class: com.kwad.components.ad.reflux.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ a b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, c};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = this;
                this.a = c;
            }

            @Override // com.kwad.components.core.c.a.a.b
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.b.a(this.a);
                }
            }
        }));
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65539, this, context, attributeSet, i) == null) {
            a(context);
            DownloadProgressView downloadProgressView = this.h;
            if (downloadProgressView != null) {
                downloadProgressView.setOnClickListener(this);
            }
            setOnClickListener(this);
        }
    }

    private void c() {
        com.kwad.components.ad.reflux.a aVar;
        b.InterfaceC0528b interfaceC0528b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (aVar = this.i) == null) {
            return;
        }
        AdTemplate c = aVar.c();
        if (!c.mPvReported && (interfaceC0528b = this.j) != null) {
            interfaceC0528b.b();
        }
        f fVar = new f();
        com.kwad.components.ad.reflux.a aVar2 = this.i;
        if (aVar2 != null) {
            fVar.g(aVar2.j());
        }
        com.kwad.components.core.l.c.a().a(c, null, fVar);
    }

    public abstract void a(@NonNull Context context);

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.a(view2);
            com.kwad.sdk.core.d.b.a("BaseRefluxCardView", "onFirstVisible: " + getClass().getSimpleName());
            c();
        }
    }

    public void a(com.kwad.components.ad.reflux.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        this.i = aVar;
        if (this.a != null && aVar.d() != null) {
            this.a.setText(aVar.d());
        }
        if (this.b != null && aVar.f() != null) {
            this.b.setText(aVar.f());
        }
        if (this.c != null && aVar.g() != null) {
            this.c.setText(aVar.g());
        }
        AdTemplate c = aVar.c();
        if (c != null) {
            if (this.d != null && aVar.e() != null) {
                KSImageLoader.loadAppIcon(this.d, aVar.e(), c, k);
            }
            if (this.e != null && aVar.h() != null) {
                KSImageLoader.loadImage(this.e, aVar.h(), c);
            }
            KsLogoView ksLogoView = this.f;
            if (ksLogoView != null) {
                ksLogoView.a(c);
            }
            ComplianceTextView complianceTextView = this.g;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(c);
            }
            DownloadProgressView downloadProgressView = this.h;
            if (downloadProgressView != null) {
                downloadProgressView.a(c);
            }
            AdInfo i = d.i(c);
            DownloadProgressView downloadProgressView2 = this.h;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(i, aVar.l(), aVar.m());
            }
        }
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
            f a = new f().a(getTouchCoords());
            com.kwad.components.ad.reflux.a aVar = this.i;
            if (aVar != null) {
                a.g(aVar.j());
            }
            com.kwad.sdk.core.report.a.a(adTemplate, a, (JSONObject) null);
            b.InterfaceC0528b interfaceC0528b = this.j;
            if (interfaceC0528b != null) {
                interfaceC0528b.a();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.equals(this.h)) {
                a(1, true);
            } else if (view2.equals(this)) {
                a(3, true);
            }
        }
    }

    public void setAdClickListener(b.InterfaceC0528b interfaceC0528b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0528b) == null) {
            this.j = interfaceC0528b;
        }
    }
}
