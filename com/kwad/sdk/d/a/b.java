package com.kwad.sdk.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.TextProgressBar;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.KsLogoView;
import com.kwad.sdk.widget.f;
/* loaded from: classes2.dex */
public class b extends KSFrameLayout implements CompoundButton.OnCheckedChangeListener, com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public View f58228b;

    /* renamed from: c  reason: collision with root package name */
    public KSFrameLayout f58229c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f58230d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f58231e;

    /* renamed from: f  reason: collision with root package name */
    public TextProgressBar f58232f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f58233g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f58234h;

    /* renamed from: i  reason: collision with root package name */
    public ViewGroup f58235i;

    /* renamed from: j  reason: collision with root package name */
    public CompoundButton f58236j;

    /* renamed from: k  reason: collision with root package name */
    public View f58237k;
    public View l;
    public TextView m;
    public ImageView n;
    public TextView o;
    public TextView p;
    public TextProgressBar q;
    public TextView r;
    public d s;
    public final a t;
    public boolean u;
    public AdTemplate v;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f58238b;

        /* renamed from: c  reason: collision with root package name */
        public int f58239c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f58240d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.f58238b = false;
            this.f58239c = 0;
            this.f58240d = true;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f58239c : invokeV.intValue;
        }

        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                this.f58239c = i2;
            }
        }

        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.f58238b = z;
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58240d : invokeV.booleanValue;
        }

        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.f58240d = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull Context context, a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "%s秒后进入试玩页";
        this.u = false;
        this.t = aVar == null ? new a() : aVar;
        FrameLayout.inflate(context, this.t.b() ? R.layout.ksad_interstitial_native_above : R.layout.ksad_interstitial_native, this);
        c(this.t.a);
    }

    private void a(View view, boolean z) {
        d dVar;
        d dVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, this, view, z) == null) {
            d dVar3 = this.s;
            if (dVar3 != null) {
                dVar3.b(z);
            }
            if (view.equals(this)) {
                d dVar4 = this.s;
                if (dVar4 != null) {
                    dVar4.a(this);
                }
            } else if (view.equals(this.f58237k)) {
                if (!(1 == this.t.a()) || (dVar2 = this.s) == null) {
                    return;
                }
                dVar2.a();
            } else if (view.equals(this.m)) {
                d dVar5 = this.s;
                if (dVar5 != null) {
                    dVar5.b();
                }
            } else if (view.equals(this.q)) {
                d dVar6 = this.s;
                if (dVar6 != null) {
                    dVar6.b(view);
                }
            } else if (view.equals(this.f58234h)) {
                d dVar7 = this.s;
                if (dVar7 != null) {
                    dVar7.h(view);
                }
            } else if (view.equals(this.f58232f)) {
                d dVar8 = this.s;
                if (dVar8 != null) {
                    dVar8.c(view);
                }
            } else if (view.equals(this.l)) {
                d dVar9 = this.s;
                if (dVar9 != null) {
                    dVar9.f(view);
                }
            } else if (view.equals(this.f58229c)) {
                d dVar10 = this.s;
                if (dVar10 != null) {
                    dVar10.d(view);
                }
            } else if (view.equals(this.f58231e)) {
                d dVar11 = this.s;
                if (dVar11 != null) {
                    dVar11.e(view);
                }
            } else if (!view.equals(this.f58235i) || (dVar = this.s) == null) {
            } else {
                dVar.g(view);
            }
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, this, kSFrameLayout, z) == null) {
            kSFrameLayout.setClickable(true);
            new f(kSFrameLayout, this);
            this.f58229c.setWidthBasedRatio(!z);
        }
    }

    private void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
            setClickable(true);
            this.f58229c = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
            this.f58228b = findViewById(R.id.ksad_interstitial_full_bg);
            this.f58231e = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
            this.f58230d = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
            this.f58233g = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
            this.f58234h = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
            this.f58232f = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
            this.f58235i = (ViewGroup) findViewById(R.id.ksad_ad_desc_layout);
            this.f58237k = findViewById(R.id.ksad_interstitial_close_outer);
            this.f58232f.setTextDimen(bb.a(getContext(), 10.0f));
            this.f58232f.setTextColor(-1);
            this.f58236j = (CompoundButton) findViewById(R.id.ksad_interstitial_mute);
            this.m = (TextView) findViewById(R.id.ksad_interstitial_count_down);
            this.n = (ImageView) findViewById(R.id.ksad_interstitial_logo);
            this.o = (TextView) findViewById(R.id.ksad_interstitial_name);
            this.p = (TextView) findViewById(R.id.ksad_interstitial_desc);
            this.q = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
            this.l = findViewById(R.id.ksad_ad_download_container);
            new f(this, this);
            new f(this.f58231e, this);
            new f(this.f58232f, this);
            new f(this.q, this);
            new f(this.f58237k, this);
            new f(this.f58234h, this);
            new f(this.m, this);
            new f(this.l, this);
            new f(this.f58235i, this);
            this.f58236j.setOnCheckedChangeListener(this);
            this.r = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
            a(this.f58229c, z);
        }
    }

    public void a(float f2, com.kwad.sdk.core.video.videoview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), bVar}) == null) {
            this.f58229c.setRatio(f2);
            this.f58229c.addView(bVar);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            bVar.setLayoutParams(layoutParams);
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.width = i2;
            marginLayoutParams.height = i3;
            setLayoutParams(marginLayoutParams);
            requestLayout();
        }
    }

    public void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) {
            this.f58230d.a(adTemplate);
        }
    }

    public void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String at;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, adTemplate, adInfo) == null) {
            if (com.kwad.sdk.core.response.a.a.B(adInfo)) {
                this.n.setVisibility(0);
                this.n.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(this.n, com.kwad.sdk.core.response.a.a.au(adInfo), adTemplate, 4);
                textView = this.o;
                at = com.kwad.sdk.core.response.a.a.t(adInfo);
            } else {
                this.n.setVisibility(0);
                this.n.setImageResource(R.drawable.ksad_default_app_icon);
                KSImageLoader.loadWithRadius(this.n, com.kwad.sdk.core.response.a.d.o(adTemplate), adTemplate, 4);
                textView = this.o;
                at = com.kwad.sdk.core.response.a.a.at(adInfo);
            }
            textView.setText(at);
            this.p.setText(com.kwad.sdk.core.response.a.a.s(adInfo));
            this.q.a(com.kwad.sdk.core.response.a.a.A(adInfo), 0);
        }
    }

    public void a(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (textView = this.m) == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.t.f58238b || this.u || this.m.getVisibility() == 0) {
            return;
        }
        this.m.setVisibility(0);
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, str, i2) == null) {
            TextProgressBar textProgressBar = this.f58232f;
            if (textProgressBar != null) {
                textProgressBar.a(str, i2);
            }
            TextProgressBar textProgressBar2 = this.q;
            if (textProgressBar2 != null) {
                textProgressBar2.a(str, i2);
            }
        }
    }

    public void a(String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, adTemplate) == null) || at.a(str)) {
            return;
        }
        this.f58231e.setImageDrawable(null);
        KSImageLoader.loadImage(this.f58231e, str, adTemplate);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || this.f58233g == null) {
            return;
        }
        this.f58233g.setVisibility(z ? 0 : 8);
    }

    public void a(boolean z, int i2) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || (textView = this.r) == null) {
            return;
        }
        textView.setVisibility(z ? 0 : 8);
        if (i2 >= 0) {
            this.r.setText(String.format(this.a, String.valueOf(i2)));
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f58231e == null) {
            return;
        }
        this.f58231e.setVisibility(z ? 0 : 8);
        this.f58231e.setClickable(z2);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.v)) {
            a(view, false);
        }
    }

    public void b(boolean z) {
        CompoundButton compoundButton;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (compoundButton = this.f58236j) == null) {
            return;
        }
        compoundButton.setChecked(z);
    }

    public void c() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (textView = this.m) == null) {
            return;
        }
        textView.setVisibility(8);
        this.u = true;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            a(false);
            this.f58234h.setVisibility(0);
        }
    }

    @Nullable
    public View getBlurBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f58228b : (View) invokeV.objValue;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048592, this, compoundButton, z) == null) || (dVar = this.s) == null) {
            return;
        }
        dVar.a(z);
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adTemplate) == null) {
            this.v = adTemplate;
        }
    }

    public void setViewListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.s = dVar;
        }
    }
}
