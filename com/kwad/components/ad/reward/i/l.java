package com.kwad.components.ad.reward.i;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class l extends d implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.l a;
    public ViewStub b;
    public ViewGroup c;
    public KSCornerImageView d;
    public TextView e;
    public TextView f;
    public KsPriceView g;
    public KsStyledTextButton h;
    public KsStyledTextButton i;
    public TextView j;
    public View k;
    public TextView l;

    public l(com.kwad.components.ad.reward.l lVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = viewGroup;
        this.a = lVar;
    }

    public l(com.kwad.components.ad.reward.l lVar, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lVar, viewStub};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = viewStub;
        this.a = lVar;
    }

    private void a(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, view2, z) == null) {
            if (view2.equals(this.i)) {
                this.a.a(view2.getContext(), z ? 38 : 153, 1);
            } else if (view2.equals(this.h)) {
                this.a.a(view2.getContext(), z ? 37 : 153, 1);
            } else if (view2.equals(this.c)) {
                this.a.a(view2.getContext(), z ? 2 : 153, 2);
            }
        }
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, adTemplate, aVar) == null) {
            KSImageLoader.loadAppIcon(this.d, aVar.a(), adTemplate, 8);
            this.e.setText(aVar.b());
            this.f.setText(aVar.c());
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cf);
            this.g.getConfig().a(dimensionPixelSize).c(dimensionPixelSize).b(this.c.getResources().getColor(R.color.obfuscated_res_0x7f060755));
            this.g.a(aVar.e(), aVar.f(), true);
            String h = aVar.h();
            this.k.setVisibility(TextUtils.isEmpty(h) ? 8 : 0);
            if (h != null) {
                this.j.setText(h);
            }
            this.l.setText(aVar.i());
        }
    }

    private void e() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (viewGroup = this.c) == null) {
            return;
        }
        this.d = (KSCornerImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091129);
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09112b);
        this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091128);
        this.g = (KsPriceView) this.c.findViewById(R.id.obfuscated_res_0x7f09112a);
        this.h = (KsStyledTextButton) this.c.findViewById(R.id.obfuscated_res_0x7f091125);
        this.i = (KsStyledTextButton) this.c.findViewById(R.id.obfuscated_res_0x7f091124);
        this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091118);
        this.k = this.c.findViewById(R.id.obfuscated_res_0x7f091119);
        this.l = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09111a);
        new com.kwad.sdk.widget.f(this.h, this);
        new com.kwad.sdk.widget.f(this.i, this);
        new com.kwad.sdk.widget.f(this.c, this);
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) {
            super.a(wVar);
            a(wVar.a(), com.kwad.components.ad.reward.model.a.c(wVar.a()));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            a(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(this.a.g)) {
            a(view2, false);
        }
    }

    public final void c() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.c == null && (viewStub = this.b) != null) {
                this.c = (ViewGroup) viewStub.inflate();
                e();
            }
            if (this.e == null) {
                e();
            }
            this.c.setVisibility(0);
        }
    }

    public final void d() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }
}
