package com.kwad.components.ad.reward.i;

import android.content.Context;
import android.text.SpannableString;
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
public final class h extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup a;
    public ViewGroup b;
    public KSCornerImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public KSCornerImageView g;
    public View h;
    public b i;
    public boolean j;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public SpannableString e;

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
                aVar.d = com.kwad.components.ad.c.b.d();
                aVar.b = com.kwad.sdk.core.response.a.a.aX(i);
                aVar.a = com.kwad.sdk.core.response.a.a.aY(i);
                aVar.c = com.kwad.sdk.core.response.a.a.aZ(i);
                aVar.e = com.kwad.sdk.core.response.a.a.a(i, com.kwad.components.core.widget.f.a);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public final CharSequence a(boolean z) {
            InterceptResult invokeZ;
            SpannableString spannableString;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? (z || (spannableString = this.e) == null) ? this.b : spannableString : (CharSequence) invokeZ.objValue;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    public h(ViewGroup viewGroup, boolean z, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup, Boolean.valueOf(z), bVar};
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
        this.j = z;
        this.i = bVar;
        c();
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f091110);
            this.c = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09110d);
            this.d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f09110f);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f091100);
            this.f = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910fe);
            this.g = (KSCornerImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09110e);
            this.h = this.a.findViewById(R.id.obfuscated_res_0x7f091176);
            this.f.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.h.setOnClickListener(this);
            Context context = this.a.getContext();
            if (ae.e(context)) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b7);
                this.a.setLayoutParams(layoutParams2);
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
            this.c.setVisibility(this.j ? 8 : 0);
            KSImageLoader.loadImage(this.c, a3.c, a2);
            String c = com.kwad.components.ad.c.b.c();
            if (!at.a(c)) {
                KSImageLoader.loadImage(this.g, c, a2);
            }
            this.d.setText(a3.a());
            this.e.setText(a3.a(this.j));
            this.f.setText(a3.d);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.i == null) {
            return;
        }
        if (view2.equals(this.f)) {
            this.i.d();
        } else if (view2.equals(this.c)) {
            this.i.e();
        } else if (view2.equals(this.h)) {
            this.i.g();
        }
    }
}
