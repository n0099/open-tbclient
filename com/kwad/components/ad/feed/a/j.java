package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes5.dex */
public final class j extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public RoundAngleImageView dI;
    public TextView de;
    public ImageView dg;
    public DownloadProgressView dk;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void bi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.bq.T(this.mAdTemplate);
            this.dk.F(this.mAdTemplate);
            com.kwad.sdk.b.kwai.a.a(this, this.de, this.dI, this.dk);
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, this.dk.getAppDownloadListener());
                this.mApkDownloadHelper = cVar;
                cVar.d(this.dk.getAppDownloadListener());
                this.mApkDownloadHelper.setOnShowListener(this);
                this.mApkDownloadHelper.setOnDismissListener(this);
                bf();
                g(true);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f091027);
            ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09109e)).setRatio(0.66f);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f09102d);
            this.dI = roundAngleImageView;
            roundAngleImageView.setRadius(com.kwad.sdk.b.kwai.a.a(getContext(), 3.0f));
            this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f091029);
            this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091040);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091094);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.bj();
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar != null) {
                cVar.c(this.dk.getAppDownloadListener());
            }
            g(false);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            super.c((j) adTemplate);
            this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            List<String> aA = com.kwad.sdk.core.response.a.a.aA(this.mAdInfo);
            if (aA.size() > 0) {
                KSImageLoader.loadFeeImage(this.dI, aA.get(0), this.mAdTemplate);
            } else {
                com.kwad.sdk.core.e.b.e("FeedTextLeftImageView", "getImageUrlList size less than one");
            }
            bi();
            this.dg.setOnClickListener(this);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public final com.kwad.components.core.c.a.c getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mApkDownloadHelper : (com.kwad.components.core.c.a.c) invokeV.objValue;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0423 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.dg) {
                pX();
                return;
            }
            int i = 35;
            if (view2 == this.de) {
                i = 25;
            } else if (view2 == this.dI) {
                i = 100;
            } else if (view2 == this.dk) {
                i = 1;
            }
            g(false);
            com.kwad.components.core.c.a.a.a(new a.C0352a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.dk ? 1 : 2).aj(view2 == this.dk).a(new a.b(this, i) { // from class: com.kwad.components.ad.feed.a.j.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ j dJ;
                public final /* synthetic */ int dl;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.dJ = this;
                    this.dl = i;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.dJ.aq(this.dl);
                    }
                }
            }));
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public final void setPaddingToShowAnim(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || view2.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        viewGroup.setPadding(com.kwad.sdk.b.kwai.a.a(this.mContext, 4.0f), 0, 0, com.kwad.sdk.b.kwai.a.a(this.mContext, 2.0f));
        viewGroup.setClipToPadding(false);
    }
}
