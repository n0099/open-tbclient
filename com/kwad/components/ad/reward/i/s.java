package com.kwad.components.ad.reward.i;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsAppTagsView;
import com.kwad.components.core.widget.KSCornerButton;
import com.kwad.components.core.widget.KsConvertButton;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
/* loaded from: classes5.dex */
public final class s extends r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @IdRes
    public int n;
    public ImageView o;
    @Nullable
    public com.kwad.components.ad.reward.model.a p;
    public View q;

    public s(@IdRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = i;
        this.k = R.layout.obfuscated_res_0x7f0d044e;
        this.l = false;
    }

    @Override // com.kwad.components.ad.reward.i.r
    public final void a(com.kwad.components.ad.reward.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.a(aVar);
            this.p = aVar;
        }
    }

    public final void a(AdInfo adInfo, boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo, z) == null) || (imageView = this.o) == null || adInfo == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(this.o, com.kwad.sdk.core.response.a.a.k(adInfo));
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.a(z);
            ViewGroup viewGroup = this.m;
            if (viewGroup == null) {
                return;
            }
            Resources resources = viewGroup.getResources();
            ImageView imageView = this.f;
            if (imageView != null && this.p != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i = 18;
                if (layoutParams != null) {
                    int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070393);
                    if (!z) {
                        dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070395);
                        i = 14;
                    }
                    layoutParams.width = dimensionPixelSize;
                    layoutParams.height = dimensionPixelSize;
                    this.f.setLayoutParams(layoutParams);
                    KSImageLoader.loadAppIcon(this.f, this.p.a(), this.p.j(), i);
                }
            }
            TextView textView = this.g;
            if (textView != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.p != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039b);
                if (!this.p.m() && z) {
                    dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039a);
                }
                marginLayoutParams.topMargin = dimensionPixelSize2;
                this.g.setLayoutParams(marginLayoutParams);
            }
            View view2 = this.q;
            if (view2 == null || !(view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || this.p == null) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070398);
            if (z) {
                dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070397);
            }
            marginLayoutParams2.topMargin = dimensionPixelSize3;
            this.q.setLayoutParams(marginLayoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.i.r
    public final void b(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        this.a = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910bd);
        this.f = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910bb);
        this.e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910bc);
        this.i = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910c4);
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910ba);
        this.b = (KSCornerButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910bf);
        this.c = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910b6);
        this.d = viewGroup.findViewById(R.id.obfuscated_res_0x7f0910be);
        this.o = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0910b5);
        this.q = viewGroup.findViewById(R.id.obfuscated_res_0x7f0910b7);
    }

    @Override // com.kwad.components.ad.reward.i.r
    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    @Override // com.kwad.components.ad.reward.i.r
    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.id.obfuscated_res_0x7f0910b8 : invokeV.intValue;
    }
}
