package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes5.dex */
public final class f extends KSFrameLayout implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @Nullable
    public View b;
    public ImageView c;
    public KSFrameLayout d;
    public KSFrameLayout e;
    public KsLogoView f;
    public ImageView g;
    public TextProgressBar h;
    public ViewGroup i;
    public ViewGroup j;
    public ImageView k;
    public View l;
    public View m;
    public TextView n;
    public ImageView o;
    public ImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextProgressBar u;
    public TextView v;
    public h w;
    public final a x;
    public boolean y;
    public AdTemplate z;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public boolean b;
        public int c;
        public boolean d;

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
                    return;
                }
            }
            this.a = false;
            this.b = false;
            this.c = 0;
            this.d = true;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : invokeV.intValue;
        }

        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.c = i;
            }
        }

        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        public final void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.b = z;
            }
        }

        public final boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.booleanValue;
        }

        public final void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.d = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull Context context, a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
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
        this.a = "%s秒后进入试玩页";
        this.y = false;
        this.x = aVar;
        FrameLayout.inflate(context, aVar.b() ? R.layout.obfuscated_res_0x7f0d0430 : R.layout.obfuscated_res_0x7f0d042f, this);
        c(this.x.a);
    }

    private void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view2, i) == null) {
            com.kwad.sdk.b.kwai.a.a(view2, 0, com.kwad.sdk.b.kwai.a.a(getContext(), i), 0, 0);
        }
    }

    private void a(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, this, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = com.kwad.sdk.b.kwai.a.a(getContext(), i);
            layoutParams.height = com.kwad.sdk.b.kwai.a.a(getContext(), i2);
            view2.setLayoutParams(layoutParams);
        }
    }

    private void a(View view2, boolean z) {
        h hVar;
        h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, view2, z) == null) {
            h hVar3 = this.w;
            if (hVar3 != null) {
                hVar3.b(z);
                this.w.a(this.e);
            }
            if (view2.equals(this)) {
                h hVar4 = this.w;
                if (hVar4 != null) {
                    hVar4.a();
                }
            } else if (view2.equals(this.l)) {
                if (!(1 == this.x.a()) || (hVar2 = this.w) == null) {
                    return;
                }
                hVar2.b();
            } else if (view2.equals(this.u)) {
                h hVar5 = this.w;
                if (hVar5 != null) {
                    hVar5.c();
                }
            } else if (view2.equals(this.j)) {
                h hVar6 = this.w;
                if (hVar6 != null) {
                    hVar6.n();
                }
            } else if (view2.equals(this.h)) {
                h hVar7 = this.w;
                if (hVar7 != null) {
                    hVar7.d();
                }
            } else if (view2.equals(this.m)) {
                h hVar8 = this.w;
                if (hVar8 != null) {
                    hVar8.g();
                }
            } else if (view2.equals(this.d)) {
                h hVar9 = this.w;
                if (hVar9 != null) {
                    hVar9.e();
                }
            } else if (view2.equals(this.g)) {
                h hVar10 = this.w;
                if (hVar10 != null) {
                    hVar10.f();
                }
            } else if (view2.equals(this.p)) {
                h hVar11 = this.w;
                if (hVar11 != null) {
                    hVar11.h();
                }
            } else if (view2.equals(this.q)) {
                h hVar12 = this.w;
                if (hVar12 != null) {
                    hVar12.i();
                }
            } else if (view2.equals(this.r)) {
                h hVar13 = this.w;
                if (hVar13 != null) {
                    hVar13.j();
                }
            } else if (view2.equals(this.o)) {
                h hVar14 = this.w;
                if (hVar14 != null) {
                    hVar14.k();
                }
            } else if (view2.equals(this.s)) {
                h hVar15 = this.w;
                if (hVar15 != null) {
                    hVar15.l();
                }
            } else if (!view2.equals(this.t) || (hVar = this.w) == null) {
            } else {
                hVar.m();
            }
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, this, kSFrameLayout, z) == null) {
            kSFrameLayout.setClickable(true);
            new com.kwad.sdk.widget.f(kSFrameLayout, this);
            this.d.setWidthBasedRatio(!z);
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            setClickable(true);
            this.e = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09106b);
            this.d = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09106c);
            this.b = findViewById(R.id.obfuscated_res_0x7f091060);
            this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091070);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911d3);
            this.f = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f090fe5);
            this.i = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09106f);
            this.j = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09106d);
            this.h = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09105f);
            this.l = findViewById(R.id.obfuscated_res_0x7f09105c);
            this.h.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f));
            this.h.setTextColor(-1);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f091068);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f09105d);
            this.o = (ImageView) findViewById(R.id.obfuscated_res_0x7f091067);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f091069);
            this.t = (TextView) findViewById(R.id.obfuscated_res_0x7f09105e);
            this.u = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f090ff3);
            this.m = findViewById(R.id.obfuscated_res_0x7f090fde);
            this.p = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff5);
            this.q = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff9);
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f090ff1);
            new com.kwad.sdk.widget.f(this, this);
            new com.kwad.sdk.widget.f(this.g, this);
            new com.kwad.sdk.widget.f(this.h, this);
            new com.kwad.sdk.widget.f(this.u, this);
            new com.kwad.sdk.widget.f(this.l, this);
            new com.kwad.sdk.widget.f(this.j, this);
            new com.kwad.sdk.widget.f(this.n, this);
            new com.kwad.sdk.widget.f(this.m, this);
            new com.kwad.sdk.widget.f(this.p, this);
            new com.kwad.sdk.widget.f(this.q, this);
            new com.kwad.sdk.widget.f(this.r, this);
            new com.kwad.sdk.widget.f(this.o, this);
            new com.kwad.sdk.widget.f(this.s, this);
            new com.kwad.sdk.widget.f(this.t, this);
            this.k.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.interstitial.widget.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.a.k.setSelected(!this.a.k.isSelected());
                        if (this.a.w != null) {
                            this.a.w.a(this.a.k.isSelected());
                        }
                    }
                }
            });
            this.v = (TextView) findViewById(R.id.obfuscated_res_0x7f09106e);
            a(this.d, z);
            if (ae.a()) {
                return;
            }
            g();
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            a(this.o, 40, 40);
            a(this.u, 130, 30);
            this.s.setTextSize(14.0f);
            a(this.u, 11);
            a(this.s, 7);
            a(this.t, 7);
        }
    }

    public final void a(float f, com.kwad.sdk.core.video.videoview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), aVar}) == null) {
            this.d.setRatio(f);
            this.d.addView(aVar);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            aVar.setLayoutParams(layoutParams);
        }
    }

    public final void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.width = i;
            marginLayoutParams.height = i2;
            setLayoutParams(marginLayoutParams);
            requestLayout();
        }
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            this.f.a(adTemplate);
        }
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String aC;
        TextProgressBar textProgressBar;
        String H;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adTemplate, adInfo) == null) {
            this.o.setImageResource(R.drawable.obfuscated_res_0x7f080bc0);
            if (com.kwad.sdk.core.response.a.a.aT(adInfo)) {
                KSImageLoader.loadCircleIcon(this.o, com.kwad.sdk.core.response.a.a.aZ(adInfo), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080bc0));
                this.s.setText(com.kwad.sdk.core.response.a.a.aD(adInfo));
                this.t.setText(com.kwad.sdk.core.response.a.a.z(adInfo));
                if (com.kwad.sdk.core.response.a.a.aU(adInfo)) {
                    textProgressBar = this.u;
                    H = com.kwad.components.ad.c.b.a();
                } else {
                    textProgressBar = this.u;
                    H = com.kwad.components.ad.c.b.d();
                }
            } else if (com.kwad.components.ad.interstitial.kwai.b.b(adInfo)) {
                AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(adInfo);
                KSImageLoader.loadWithRadius(this.o, bd.icon, adTemplate, 4);
                this.s.setText(bd.name);
                this.t.setVisibility(8);
                textProgressBar = this.u;
                H = com.kwad.components.ad.c.b.b();
            } else {
                if (com.kwad.sdk.core.response.a.a.I(adInfo)) {
                    KSImageLoader.loadWithRadius(this.o, com.kwad.sdk.core.response.a.a.aE(adInfo), adTemplate, 4);
                    textView = this.s;
                    aC = com.kwad.sdk.core.response.a.a.A(adInfo);
                } else {
                    KSImageLoader.loadWithRadius(this.o, com.kwad.sdk.core.response.a.d.m(adTemplate), adTemplate, 4);
                    textView = this.s;
                    aC = com.kwad.sdk.core.response.a.a.aC(adInfo);
                }
                textView.setText(aC);
                this.t.setText(com.kwad.sdk.core.response.a.a.z(adInfo));
                textProgressBar = this.u;
                H = com.kwad.sdk.core.response.a.a.H(adInfo);
            }
            textProgressBar.a(H, 0);
        }
    }

    public final void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (textView = this.n) == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.x.b || this.y || this.n.getVisibility() == 0) {
            return;
        }
        this.n.setVisibility(0);
    }

    public final void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i) == null) {
            TextProgressBar textProgressBar = this.h;
            if (textProgressBar != null) {
                textProgressBar.a(str, 0);
            }
            TextProgressBar textProgressBar2 = this.u;
            if (textProgressBar2 != null) {
                textProgressBar2.a(str, 0);
            }
        }
    }

    public final void a(String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, adTemplate) == null) || at.a(str)) {
            return;
        }
        this.g.setImageDrawable(null);
        KSImageLoader.loadImage(this.g, str, adTemplate);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.i == null) {
            return;
        }
        this.i.setVisibility(z ? 0 : 8);
    }

    public final void a(boolean z, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (textView = this.v) == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.v.setText(String.format(this.a, String.valueOf(i)));
        }
    }

    public final void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.g == null) {
            return;
        }
        this.g.setVisibility(z ? 0 : 8);
        this.g.setClickable(z2);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a_(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            a(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && com.kwad.sdk.core.response.a.c.d(this.z)) {
            a(view2, false);
        }
    }

    public final void b(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (imageView = this.k) == null) {
            return;
        }
        imageView.setSelected(z);
    }

    public final void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (textView = this.n) == null) {
            return;
        }
        textView.setVisibility(8);
        this.y = true;
    }

    public final void d() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (view2 = this.l) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            a(false);
            this.j.setVisibility(0);
            this.c.setVisibility(0);
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ViewGroup viewGroup = this.j;
            return viewGroup != null && viewGroup.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public final View getBlurBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final ImageView getTailFrameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c : (ImageView) invokeV.objValue;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, adTemplate) == null) {
            this.z = adTemplate;
        }
    }

    public final void setViewListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hVar) == null) {
            this.w = hVar;
        }
    }
}
