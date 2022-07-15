package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.content.DialogInterface;
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
public final class k extends a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public RoundAngleImageView b;
    public ImageView c;
    public com.kwad.components.core.c.a.b d;
    public KsLogoView e;
    public DownloadProgressView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NonNull Context context) {
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
            this.e.a(this.j);
            this.f.a(this.j);
            this.f.setOnClickListener(this);
            if (com.kwad.sdk.core.response.a.a.I(this.k)) {
                com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(this.j, null, this.f.getAppDownloadListener());
                this.d = bVar;
                bVar.c(this.f.getAppDownloadListener());
                this.d.a((DialogInterface.OnShowListener) this);
                this.d.a((DialogInterface.OnDismissListener) this);
                a((View.OnClickListener) this);
                a(true);
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void a(@NonNull AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            super.a((k) adTemplate);
            this.a.setText(com.kwad.sdk.core.response.a.a.z(this.k));
            List<String> V = com.kwad.sdk.core.response.a.a.V(this.k);
            if (V.size() > 0) {
                KSImageLoader.loadFeeImage(this.b, V.get(0), this.j);
            } else {
                com.kwad.sdk.core.d.b.e("FeedTextRightImageView", "getImageUrlList size less than one");
            }
            f();
            com.kwad.sdk.b.kwai.a.a(this, this.a, this.b, this.f, this.c);
            setOnClickListener(this);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090fda);
            ((RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f091051)).setRatio(0.66f);
            RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.obfuscated_res_0x7f090fe0);
            this.b = roundAngleImageView;
            roundAngleImageView.setRadius(com.kwad.sdk.b.kwai.a.a(getContext(), 3.0f));
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdc);
            this.f = (DownloadProgressView) findViewById(R.id.obfuscated_res_0x7f090ff3);
            this.e = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091047);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            com.kwad.components.core.c.a.b bVar = this.d;
            if (bVar != null) {
                bVar.b(this.f.getAppDownloadListener());
            }
            a(false);
        }
    }

    @Override // com.kwad.components.ad.feed.a.a
    public final com.kwad.components.core.c.a.b getApkDownloadHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (com.kwad.components.core.c.a.b) invokeV.objValue;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? R.layout.obfuscated_res_0x7f0d0421 : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2 == this.c) {
                h();
                return;
            }
            int i = 35;
            if (view2 == this.a) {
                i = 25;
            } else if (view2 == this.b) {
                i = 100;
            } else if (view2 == this.f) {
                i = 1;
            }
            a(false);
            com.kwad.components.core.c.a.a.a(new a.C0507a(com.kwad.sdk.b.kwai.a.a(this)).a(this.j).a(this.d).a(view2 == this.f ? 1 : 2).a(view2 == this.f).a(new a.b(this, i) { // from class: com.kwad.components.ad.feed.a.k.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;
                public final /* synthetic */ k b;

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

    @Override // com.kwad.components.ad.feed.a.a
    public final void setPaddingToShowAnim(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || view2.getParent() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        viewGroup.setPadding(com.kwad.sdk.b.kwai.a.a(this.m, 4.0f), 0, 0, com.kwad.sdk.b.kwai.a.a(this.m, 2.0f));
        viewGroup.setClipToPadding(false);
    }
}
