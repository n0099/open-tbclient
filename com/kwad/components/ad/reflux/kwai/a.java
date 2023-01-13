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
/* loaded from: classes8.dex */
public abstract class a extends KSFrameLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int hE = 8;
    public transient /* synthetic */ FieldHolder $fh;
    public ComplianceTextView bc;
    public DownloadProgressView dk;
    public TextView li;
    public TextView lj;
    public TextView lk;
    public ImageView ll;
    public ImageView lm;
    public KsLogoView ln;
    public com.kwad.components.ad.reflux.a lo;
    public b.InterfaceC0617b lp;

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

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, this, context, attributeSet, i) == null) {
            M(context);
            DownloadProgressView downloadProgressView = this.dk;
            if (downloadProgressView != null) {
                downloadProgressView.setOnClickListener(this);
            }
            setOnClickListener(this);
        }
    }

    private void br() {
        com.kwad.components.ad.reflux.a aVar;
        b.InterfaceC0617b interfaceC0617b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (aVar = this.lo) == null) {
            return;
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.mPvReported && (interfaceC0617b = this.lp) != null) {
            interfaceC0617b.onAdShow();
        }
        f fVar = new f();
        com.kwad.components.ad.reflux.a aVar2 = this.lo;
        if (aVar2 != null) {
            fVar.aO(aVar2.eQ());
        }
        com.kwad.components.core.m.c.ox().a(adTemplate, null, fVar);
    }

    private void c(int i, boolean z) {
        com.kwad.components.ad.reflux.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) || (aVar = this.lo) == null) {
            return;
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        com.kwad.components.core.c.a.a.a(new a.C0593a(com.kwad.sdk.b.kwai.a.x(this)).L(adTemplate).b(this.lo.getApkDownloadHelper()).ae(i).aj(true).a(new a.b(this, adTemplate) { // from class: com.kwad.components.ad.reflux.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate kp;
            public final /* synthetic */ a lq;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, adTemplate};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.lq = this;
                this.kp = adTemplate;
            }

            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.lq.k(this.kp);
                }
            }
        }));
    }

    public abstract void M(@NonNull Context context);

    public void a(com.kwad.components.ad.reflux.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        this.lo = aVar;
        if (this.li != null && aVar.getTitle() != null) {
            this.li.setText(aVar.getTitle());
        }
        if (this.lj != null && aVar.eM() != null) {
            this.lj.setText(aVar.eM());
        }
        if (this.lk != null && aVar.eN() != null) {
            this.lk.setText(aVar.eN());
        }
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (adTemplate != null) {
            if (this.ll != null && aVar.eL() != null) {
                KSImageLoader.loadAppIcon(this.ll, aVar.eL(), adTemplate, hE);
            }
            if (this.lm != null && aVar.eO() != null) {
                KSImageLoader.loadImage(this.lm, aVar.eO(), adTemplate);
            }
            KsLogoView ksLogoView = this.ln;
            if (ksLogoView != null) {
                ksLogoView.T(adTemplate);
            }
            ComplianceTextView complianceTextView = this.bc;
            if (complianceTextView != null) {
                complianceTextView.setAdTemplate(adTemplate);
            }
            DownloadProgressView downloadProgressView = this.dk;
            if (downloadProgressView != null) {
                downloadProgressView.F(adTemplate);
            }
            AdInfo bQ = d.bQ(adTemplate);
            DownloadProgressView downloadProgressView2 = this.dk;
            if (downloadProgressView2 != null) {
                downloadProgressView2.a(bQ, aVar.eS(), aVar.eT());
            }
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, com.kwad.sdk.widget.i
    public final void k(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.k(view2);
            com.kwad.sdk.core.e.b.d("BaseRefluxCardView", "onFirstVisible: " + getClass().getSimpleName());
            br();
        }
    }

    public final void k(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, adTemplate) == null) {
            f b = new f().b(getTouchCoords());
            com.kwad.components.ad.reflux.a aVar = this.lo;
            if (aVar != null) {
                b.aO(aVar.eQ());
            }
            com.kwad.sdk.core.report.a.a(adTemplate, b, (JSONObject) null);
            b.InterfaceC0617b interfaceC0617b = this.lp;
            if (interfaceC0617b != null) {
                interfaceC0617b.onAdClicked();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2.equals(this.dk)) {
                c(1, true);
            } else if (view2.equals(this)) {
                c(3, true);
            }
        }
    }

    public void setAdClickListener(b.InterfaceC0617b interfaceC0617b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0617b) == null) {
            this.lp = interfaceC0617b;
        }
    }
}
