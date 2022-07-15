package com.kwad.components.ad.reward.i;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
/* loaded from: classes5.dex */
public final class i extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ViewGroup b;
    public KSCornerImageView c;
    public TextView d;
    public KSCornerImageView e;
    public b f;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Nullable
        public static a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
                a aVar = new a();
                aVar.b = com.kwad.components.ad.c.b.a();
                aVar.a = com.kwad.sdk.core.response.a.a.aZ(i);
                return aVar;
            }
            return (a) invokeL.objValue;
        }
    }

    public i(ViewGroup viewGroup, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, bVar};
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
        this.f = bVar;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091113);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091111);
            this.e = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f091114);
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091115);
            this.d.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.b.setOnClickListener(this);
            if (ae.e(this.a.getContext())) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                this.a.setLayoutParams((FrameLayout.LayoutParams) layoutParams);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) {
            super.a(wVar);
            AdTemplate a2 = wVar.a();
            a a3 = a.a(a2);
            if (a3 == null) {
                return;
            }
            this.d.setText(a3.b);
            KSImageLoader.loadImage(this.c, a3.a, a2);
            String c = com.kwad.components.ad.c.b.c();
            if (at.a(c)) {
                return;
            }
            KSImageLoader.loadImage(this.e, c, a2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.f == null) {
            return;
        }
        if (view2.equals(this.d)) {
            this.f.d();
        } else if (view2.equals(this.c)) {
            this.f.e();
        } else if (view2.equals(this.b)) {
            this.f.g();
        }
    }
}
