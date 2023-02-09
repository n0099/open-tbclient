package com.kwad.components.ad.reward.k;

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
/* loaded from: classes8.dex */
public final class q extends p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @IdRes
    public int we;
    public ImageView wf;
    @Nullable
    public com.kwad.components.ad.reward.model.a wg;
    public View wh;

    public q(@IdRes int i) {
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
        this.we = i;
        this.wc = R.layout.obfuscated_res_0x7f0d046f;
        this.wd = false;
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final void a(com.kwad.components.ad.reward.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.a(aVar);
            this.wg = aVar;
        }
    }

    public final void a(AdInfo adInfo, boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adInfo, z) == null) || (imageView = this.wf) == null || adInfo == null) {
            return;
        }
        imageView.setVisibility(0);
        com.kwad.components.ad.reward.presenter.b.a(this.wf, com.kwad.sdk.core.response.a.a.K(adInfo));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void aa(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.aa(z);
            ViewGroup viewGroup = this.pV;
            if (viewGroup == null) {
                return;
            }
            Resources resources = viewGroup.getResources();
            ImageView imageView = this.ll;
            if (imageView != null && this.wg != null) {
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
                    this.ll.setLayoutParams(layoutParams);
                    KSImageLoader.loadAppIcon(this.ll, this.wg.eL(), this.wg.gA(), i);
                }
            }
            TextView textView = this.nH;
            if (textView != null && (textView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.wg != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.nH.getLayoutParams();
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039b);
                if (!this.wg.gC() && z) {
                    dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07039a);
                }
                marginLayoutParams.topMargin = dimensionPixelSize2;
                this.nH.setLayoutParams(marginLayoutParams);
            }
            View view2 = this.wh;
            if (view2 == null || !(view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || this.wg == null) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.wh.getLayoutParams();
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070398);
            if (z) {
                dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070397);
            }
            marginLayoutParams2.topMargin = dimensionPixelSize3;
            this.wh.setLayoutParams(marginLayoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final void g(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, viewGroup) == null) || viewGroup == null) {
            return;
        }
        this.bq = (KsLogoView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091221);
        this.ll = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09121f);
        this.li = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091220);
        this.uu = (KsAppTagsView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091228);
        this.nH = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09121e);
        this.vX = (KSCornerButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f091223);
        this.vY = (KsConvertButton) viewGroup.findViewById(R.id.obfuscated_res_0x7f09121a);
        this.vZ = viewGroup.findViewById(R.id.obfuscated_res_0x7f091222);
        this.wf = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091219);
        this.wh = viewGroup.findViewById(R.id.obfuscated_res_0x7f09121b);
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final int jb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.we : invokeV.intValue;
    }

    @Override // com.kwad.components.ad.reward.k.p
    public final int jc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? R.id.obfuscated_res_0x7f09121c : invokeV.intValue;
    }
}
