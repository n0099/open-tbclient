package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.content.DialogInterface;
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
/* loaded from: classes5.dex */
public abstract class b extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public ImageView b;
    public ImageView c;
    public com.kwad.components.core.c.a.b d;
    public KsLogoView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public DownloadProgressView i;
    public TextView n;
    public TextView o;
    public View p;

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

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f090fdf).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f090fde).setVisibility(8);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09104c);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f09104e);
            this.p = findViewById(R.id.obfuscated_res_0x7f09104f);
            this.n.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            this.o.setText(com.kwad.sdk.core.response.a.a.H(this.k));
            this.p.setOnClickListener(this);
            this.n.setOnClickListener(this);
            this.o.setOnClickListener(this);
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            findViewById(R.id.obfuscated_res_0x7f090fde).setVisibility(0);
            findViewById(R.id.obfuscated_res_0x7f090fdf).setVisibility(8);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff9);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff1);
            this.h = textView;
            com.kwad.sdk.b.kwai.a.a(this, this.f, this.g, textView);
            this.g.setText(com.kwad.sdk.core.response.a.a.A(this.k));
            this.f.setImageResource(R.drawable.obfuscated_res_0x7f080bc0);
            KSImageLoader.loadAppIcon(this.f, com.kwad.sdk.core.response.a.a.aE(this.k), this.j, 8);
            this.h.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            a((View.OnClickListener) this);
            this.i.a(this.j);
            this.i.setOnClickListener(this);
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.j, null, this.i.getAppDownloadListener());
            this.d = bVar;
            bVar.c(this.i.getAppDownloadListener());
            this.d.a((DialogInterface.OnShowListener) this);
            this.d.a((DialogInterface.OnDismissListener) this);
            a(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a((b) adTemplate);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            this.e.a(adTemplate);
            List<String> V = com.kwad.sdk.core.response.a.a.V(this.k);
            if (V.size() > 0) {
                KSImageLoader.loadFeeImage(this.b, V.get(0), this.j);
            } else {
                com.kwad.sdk.core.d.b.e("BaseFeedTextImageView", "getImageUrlList size less than one");
            }
            if (com.kwad.sdk.core.response.a.a.I(this.k)) {
                i();
            } else {
                f();
            }
            com.kwad.sdk.b.kwai.a.a(this, this.a, this.b, this.c);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fda);
            ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091051)).setRatio(0.56f);
            this.b = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe0);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdc);
            this.e = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f090fdd);
            this.i = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f090ff3);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            com.kwad.components.core.c.a.b bVar = this.d;
            if (bVar != null) {
                bVar.b(this.i.getAppDownloadListener());
            }
            a(false);
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public com.kwad.components.core.c.a.b getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (com.kwad.components.core.c.a.b) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            if (view2 == this.c) {
                h();
                return;
            }
            int i = 35;
            if (view2 == this.a) {
                i = 25;
            } else if (view2 == this.b) {
                i = 100;
            } else if (view2 == this.i || view2 == this.o || view2 == this.p) {
                i = 1;
            } else if (view2 == this.f) {
                i = 13;
            } else if (view2 == this.g) {
                i = 14;
            } else if (view2 == this.h || view2 == this.n) {
                i = 101;
            }
            a(false);
            com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this)).a(this.j).a(this.d).a(view2 == this.i ? 1 : 2).a(view2 == this.i).a(new a.b(this, i) { // from class: com.kwad.components.ad.feed.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ b b;

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
                    this.b = this;
                    this.a = i;
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
    }
}
