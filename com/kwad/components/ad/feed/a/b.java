package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.view.View;
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
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class b extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public TextView cE;
    public ImageView cw;
    public TextView cx;
    public TextView de;
    public ImageView df;
    public ImageView dg;
    public TextView dh;
    public TextView di;
    public View dj;
    public DownloadProgressView dk;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context) {
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

    private void bh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f09102e).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f09102d).setVisibility(8);
            this.di = (TextView) findViewById(R.id.obfuscated_res_0x7f09109b);
            this.cE = (TextView) findViewById(R.id.obfuscated_res_0x7f09109d);
            this.dj = findViewById(R.id.obfuscated_res_0x7f09109e);
            this.di.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            this.cE.setText(com.kwad.sdk.core.response.a.a.al(this.mAdInfo));
            this.dj.setOnClickListener(this);
            this.di.setOnClickListener(this);
            this.cE.setOnClickListener(this);
        }
    }

    private void bi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f09102d).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f09102e).setVisibility(8);
            this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091044);
            this.cx = (TextView) findViewById(R.id.obfuscated_res_0x7f091048);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091040);
            this.dh = textView;
            com.kwad.sdk.b.kwai.a.a(this, this.cw, this.cx, textView);
            this.cx.setText(com.kwad.sdk.core.response.a.a.ae(this.mAdInfo));
            this.cw.setImageResource(R.drawable.obfuscated_res_0x7f080be8);
            KSImageLoader.loadAppIcon(this.cw, com.kwad.sdk.core.response.a.a.bn(this.mAdInfo), this.mAdTemplate, 8);
            this.dh.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            bf();
            this.dk.F(this.mAdTemplate);
            this.dk.setOnClickListener(this);
            com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate, null, this.dk.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.dk.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            g(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.de = (TextView) findViewById(R.id.obfuscated_res_0x7f091029);
            ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f0910a0)).setRatio(0.56f);
            this.df = (ImageView) findViewById(R.id.obfuscated_res_0x7f09102f);
            this.dg = (ImageView) findViewById(R.id.obfuscated_res_0x7f09102b);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f09102c);
            this.dk = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f091042);
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
            super.c((b) adTemplate);
            this.de.setText(com.kwad.components.ad.feed.f.d(this.mAdTemplate));
            this.bq.T(adTemplate);
            List<String> aA = com.kwad.sdk.core.response.a.a.aA(this.mAdInfo);
            if (aA.size() > 0) {
                KSImageLoader.loadFeeImage(this.df, aA.get(0), this.mAdTemplate);
            } else {
                com.kwad.sdk.core.e.b.e("BaseFeedTextImageView", "getImageUrlList size less than one");
            }
            if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                bi();
            } else {
                bh();
            }
            com.kwad.sdk.b.kwai.a.a(this, this.de, this.df, this.dg);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public com.kwad.components.core.c.a.c getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mApkDownloadHelper : (com.kwad.components.core.c.a.c) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2 == this.dg) {
                pX();
                return;
            }
            int i = 35;
            if (view2 == this.de) {
                i = 25;
            } else if (view2 == this.df) {
                i = 100;
            } else if (view2 == this.dk || view2 == this.cE || view2 == this.dj) {
                i = 1;
            } else if (view2 == this.cw) {
                i = 13;
            } else if (view2 == this.cx) {
                i = 14;
            } else if (view2 == this.dh || view2 == this.di) {
                i = 101;
            }
            g(false);
            com.kwad.components.core.c.a.a.a(new a.C0569a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(view2 == this.dk ? 1 : 2).aj(view2 == this.dk).a(new a.b(this, i) { // from class: com.kwad.components.ad.feed.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int dl;
                public final /* synthetic */ b dm;

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
                    this.dm = this;
                    this.dl = i;
                }

                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.dm.aq(this.dl);
                    }
                }
            }));
        }
    }
}
