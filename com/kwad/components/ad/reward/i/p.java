package com.kwad.components.ad.reward.i;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.widget.KSRatingBar;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class p extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.components.ad.reward.l a;
    public ViewStub b;
    public ViewGroup c;
    public ViewGroup d;
    public KsLogoView e;
    public ImageView f;
    public TextView g;
    public KSRatingBar h;
    public TextView i;
    public TextView j;
    public KsStyledTextButton k;
    public TextView l;
    public AdTemplate m;
    public int n;
    public DetailVideoView o;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public float c;
        public String d;
        public String e;

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

        public static a a(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
                if (adInfo == null) {
                    return null;
                }
                a aVar = new a();
                aVar.b = com.kwad.sdk.core.response.a.a.aC(adInfo);
                aVar.e = com.kwad.sdk.core.response.a.a.z(adInfo);
                aVar.a = com.kwad.sdk.core.response.a.a.aE(adInfo);
                aVar.c = com.kwad.sdk.core.response.a.a.F(adInfo);
                aVar.d = com.kwad.sdk.core.response.a.a.D(adInfo);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public final String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (String) invokeV.objValue;
        }

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public final float c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.floatValue;
        }

        public final String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public final String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (String) invokeV.objValue;
        }
    }

    public p(AdTemplate adTemplate, com.kwad.components.ad.reward.l lVar, ViewGroup viewGroup, DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, lVar, viewGroup, detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = Integer.MIN_VALUE;
        this.m = adTemplate;
        this.c = viewGroup;
        this.a = lVar;
        this.o = detailVideoView;
    }

    public p(AdTemplate adTemplate, com.kwad.components.ad.reward.l lVar, ViewStub viewStub, DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, lVar, viewStub, detailVideoView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = Integer.MIN_VALUE;
        this.m = adTemplate;
        this.b = viewStub;
        this.a = lVar;
        this.o = detailVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, view2) == null) || view2 == null || view2.getWidth() == 0) {
            return;
        }
        if (ae.e(view2.getContext())) {
            view2.setVisibility(0);
            Animator a2 = t.a(this.m, this.d, this.o);
            if (a2 != null) {
                a2.start();
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = -view2.getWidth();
            this.d.setLayoutParams(marginLayoutParams);
            Animator a3 = t.a(this.m, this.o, view2);
            view2.setVisibility(0);
            if (a3 != null) {
                a3.start();
            }
        }
    }

    private void f() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (viewGroup = this.d) == null) {
            return;
        }
        boolean e = ae.e(viewGroup.getContext());
        if (this.d.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (e) {
                int dimensionPixelSize = this.d.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070392);
                layoutParams.width = -1;
                layoutParams.height = dimensionPixelSize;
            } else {
                layoutParams.width = com.kwad.sdk.b.kwai.a.c(this.d.getContext()) / 2;
                layoutParams.height = -1;
            }
            this.d.setLayoutParams(layoutParams);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.d = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f0910a5);
            this.e = (KsLogoView) this.c.findViewById(R.id.obfuscated_res_0x7f0910a9);
            this.f = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0910a8);
            this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0910ac);
            this.h = (KSRatingBar) this.c.findViewById(R.id.obfuscated_res_0x7f0910ab);
            this.i = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0910a6);
            this.j = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0910a7);
            this.k = (KsStyledTextButton) this.c.findViewById(R.id.obfuscated_res_0x7f0910a4);
            this.l = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0910a3);
            this.d.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.k.setOnClickListener(this);
        }
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
            AdTemplate a2 = wVar.a();
            this.e.a(a2);
            AdInfo i = com.kwad.sdk.core.response.a.d.i(a2);
            a a3 = a.a(i);
            this.g.setText(a3.b());
            this.i.setText(a3.d());
            this.j.setText(a3.e());
            this.k.setText(com.kwad.sdk.core.response.a.a.H(i));
            boolean I = com.kwad.sdk.core.response.a.a.I(i);
            boolean e = ae.e(this.d.getContext());
            Resources resources = this.d.getResources();
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            int i2 = 18;
            if (layoutParams != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070393);
                if (!e) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070395);
                    i2 = 14;
                } else if (I) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070394);
                    i2 = 24;
                }
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.f.setLayoutParams(layoutParams);
            }
            KSImageLoader.loadAppIcon(this.f, a3.a(), a2, i2);
            if (e && I) {
                if (a3.c() < 0.0f) {
                    this.h.setVisibility(8);
                } else {
                    this.h.setVisibility(0);
                    this.h.setStar(a3.c());
                }
                if (a3.d() == null) {
                    this.i.setVisibility(8);
                } else {
                    this.i.setVisibility(0);
                    this.i.setText(a3.d());
                }
            }
            if (I) {
                return;
            }
            this.i.setVisibility(8);
            this.h.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            Resources resources = this.d.getResources();
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (z) {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = a().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070390);
                }
                this.d.setBackgroundColor(-1);
                this.g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06075c));
                this.j.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060758));
                this.n = com.kwad.sdk.b.kwai.a.c(this.o);
                com.kwad.sdk.b.kwai.a.c(this.o, 49);
            } else {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = 0;
                }
                this.g.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06075d));
                this.j.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060759));
                this.d.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f06075a));
            }
            if (marginLayoutParams != null) {
                this.d.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final void c() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.c == null && (viewStub = this.b) != null) {
                this.c = (ViewGroup) viewStub.inflate();
                g();
            }
            if (this.e == null) {
                g();
            }
            if (this.c != null) {
                f();
                this.c.setVisibility(0);
                this.c.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.i.p.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ p a;

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

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            p pVar = this.a;
                            pVar.a(pVar.d);
                        }
                    }
                });
                u.b bVar = new u.b();
                bVar.I = 205;
                com.kwad.sdk.core.report.a.a(this.m, 164, bVar, (JSONObject) null);
            }
        }
    }

    public final void d() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (viewGroup = this.c) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void e() {
        DetailVideoView detailVideoView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (detailVideoView = this.o) == null || (i = this.n) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.b.kwai.a.c(detailVideoView, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view2) == null) {
            if (view2.equals(this.l)) {
                this.a.e();
                com.kwad.sdk.core.report.a.k(this.m, 164);
            } else if (view2.equals(this.d)) {
                this.a.a(view2.getContext(), 2, 2);
            } else if (view2.equals(this.k)) {
                this.a.a(view2.getContext(), 2, 1);
            }
        }
    }
}
