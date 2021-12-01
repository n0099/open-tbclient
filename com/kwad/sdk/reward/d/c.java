package com.kwad.sdk.reward.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSRatingBar;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes2.dex */
public class c implements com.kwad.sdk.widget.d {
    public static /* synthetic */ Interceptable $ic = null;
    public static long l = 1600;
    public static long m = 1600;
    public static long n = 200;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f58898b;

    /* renamed from: c  reason: collision with root package name */
    public Button f58899c;

    /* renamed from: d  reason: collision with root package name */
    public Button f58900d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f58901e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f58902f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58903g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58904h;

    /* renamed from: i  reason: collision with root package name */
    public KSRatingBar f58905i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f58906j;

    /* renamed from: k  reason: collision with root package name */
    public a f58907k;
    public volatile boolean o;
    @Nullable
    public Animator p;
    public boolean q;
    public AdTemplate r;

    /* loaded from: classes2.dex */
    public interface a {
        void a(c cVar, View view, boolean z);
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58912b;

        /* renamed from: c  reason: collision with root package name */
        public float f58913c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f58914d;

        /* renamed from: e  reason: collision with root package name */
        public String f58915e;

        /* renamed from: f  reason: collision with root package name */
        public int f58916f;

        /* renamed from: g  reason: collision with root package name */
        public String f58917g;

        public b() {
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
            this.f58916f = 15;
        }

        public static b a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                if (adTemplate == null) {
                    return null;
                }
                AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
                b bVar = new b();
                bVar.f58912b = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.u(j2) : com.kwad.sdk.core.response.a.a.t(j2);
                bVar.f58913c = com.kwad.sdk.core.response.a.a.y(j2);
                bVar.f58915e = com.kwad.sdk.core.response.a.a.s(j2);
                bVar.a = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.aE(j2) : com.kwad.sdk.core.response.a.a.au(j2);
                if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
                    bVar.f58916f = com.kwad.sdk.core.config.b.az();
                    str = "安装并体验%s秒  可领取奖励";
                } else {
                    bVar.f58916f = com.kwad.sdk.core.config.b.aA();
                    str = "浏览详情页%s秒，领取奖励";
                }
                bVar.f58917g = str;
                bVar.f58914d = com.kwad.sdk.core.response.a.c.i(adTemplate);
                return bVar;
            }
            return (b) invokeL.objValue;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? String.format(this.f58917g, Integer.valueOf(this.f58916f)) : (String) invokeV.objValue;
        }
    }

    /* renamed from: com.kwad.sdk.reward.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2050c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C2050c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(758132456, "Lcom/kwad/sdk/reward/d/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(758132456, "Lcom/kwad/sdk/reward/d/c;");
        }
    }

    public c(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o = false;
        this.q = false;
        this.a = view;
        c();
    }

    public static Animator a(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f3);
            ofFloat.setDuration(n);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(f2 / f3, f3, view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size), view) { // from class: com.kwad.sdk.reward.d.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ float a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ float f58909b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ float f58910c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ View f58911d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Float.valueOf(r6), Float.valueOf(f3), Float.valueOf(r8), view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = r6;
                    this.f58909b = f3;
                    this.f58910c = r8;
                    this.f58911d = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        float f4 = this.a * floatValue;
                        float f5 = this.f58909b;
                        if (f5 != 0.0f) {
                            float f6 = (floatValue / f5) * this.f58910c;
                            View view2 = this.f58911d;
                            if (view2 instanceof TextView) {
                                ((TextView) view2).setTextSize(0, f6);
                            }
                        }
                        com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "onAnimationUpdate: " + floatValue + ", currentWidth:" + f4 + ", ratio:" + this.a);
                        ViewGroup.LayoutParams layoutParams = this.f58911d.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.height = (int) floatValue;
                            layoutParams.width = (int) f4;
                            this.f58911d.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            return ofFloat;
        }
        return (Animator) invokeCommon.objValue;
    }

    public static Animator a(View view, View view2, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65539, null, view, view2, i2, i3)) == null) {
            Animator c2 = c(view);
            float f2 = i2;
            float f3 = i3;
            Animator a2 = a(view2, f2, f3);
            a2.addListener(new C2050c(view) { // from class: com.kwad.sdk.reward.d.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ View a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {view};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = view;
                }

                @Override // com.kwad.sdk.reward.d.c.C2050c, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.setAlpha(1.0f);
                        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = 0;
                            layoutParams.height = 0;
                            this.a.setLayoutParams(layoutParams);
                        }
                    }
                }
            });
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, 1.0f, 1.0f);
            ofFloat.setDuration(m);
            Animator c3 = c(view2);
            Animator a3 = a(view, f2, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(c2, a2, ofFloat, c3, a3);
            return animatorSet;
        }
        return (Animator) invokeLLII.objValue;
    }

    private void a(LinearLayout linearLayout, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, this, linearLayout, str) == null) {
            TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.ksad_reward_apk_info_card_tag_item, (ViewGroup) linearLayout, false);
            textView.setText(str);
            this.f58906j.addView(textView);
        }
    }

    public static Animator c(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, view)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
            ofFloat.setDuration(n);
            ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
            return ofFloat;
        }
        return (Animator) invokeL.objValue;
    }

    private void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.f58899c = (Button) this.a.findViewById(R.id.ksad_reward_apk_info_install_action);
            this.f58900d = (Button) this.a.findViewById(R.id.ksad_reward_apk_info_install_start);
            this.f58898b = this.a.findViewById(R.id.ksad_reward_apk_info_install_container);
            this.f58902f = (ImageView) this.a.findViewById(R.id.ksad_reward_apk_info_icon);
            this.f58901e = (TextView) this.a.findViewById(R.id.ksad_reward_apk_info_name);
            this.f58903g = (TextView) this.a.findViewById(R.id.ksad_reward_apk_info_desc);
            this.f58905i = (KSRatingBar) this.a.findViewById(R.id.ksad_reward_apk_info_score);
            this.f58906j = (LinearLayout) this.a.findViewById(R.id.ksad_reward_apk_info_tags);
        }
    }

    private void d() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65547, this) == null) || (animator = this.p) == null) {
            return;
        }
        animator.cancel();
        this.q = true;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "startAnimation");
            int height = this.f58898b.getHeight();
            int width = this.f58898b.getWidth();
            if (height == 0 || width == 0) {
                return;
            }
            if (this.p == null) {
                Animator a2 = a(this.f58900d, this.f58899c, width, height);
                this.p = a2;
                a2.addListener(new C2050c(this) { // from class: com.kwad.sdk.reward.d.c.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.sdk.reward.d.c.C2050c, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) || this.a.q) {
                            return;
                        }
                        ax.a(new Runnable(this, animator) { // from class: com.kwad.sdk.reward.d.c.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ Animator a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f58908b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, animator};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f58908b = this;
                                this.a = animator;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.a.start();
                                }
                            }
                        }, null, c.m);
                    }
                });
            }
            com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "mAnimator isStarted: " + this.p.isStarted());
            if (!this.p.isStarted()) {
                com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "mAnimator.start()");
                this.p.start();
            }
            this.q = false;
        }
    }

    public void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, z) == null) {
            int id = view.getId();
            if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
                com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "onClick install");
                this.o = true;
                a aVar = this.f58907k;
                if (aVar != null) {
                    aVar.a(this, view, z);
                }
            }
        }
    }

    public void a(AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, adTemplate, z) == null) {
            this.r = adTemplate;
            b a2 = b.a(adTemplate);
            if (a2 == null) {
                return;
            }
            KSImageLoader.loadAppIcon(this.f58902f, a2.a, adTemplate, 12);
            this.f58901e.setText(a2.f58912b);
            this.f58903g.setText(a2.f58915e);
            this.f58905i.setStar(a2.f58913c);
            int i2 = 0;
            if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
                this.f58900d.setText("开始下载");
                this.f58905i.setVisibility(0);
            } else {
                this.f58900d.setText("查看详情");
                this.f58905i.setVisibility(8);
            }
            this.f58899c.setText(a2.a());
            this.f58899c.setClickable(true);
            this.f58900d.setClickable(true);
            this.f58898b.setClickable(true);
            new com.kwad.sdk.widget.f(this.f58899c, this);
            new com.kwad.sdk.widget.f(this.f58900d, this);
            new com.kwad.sdk.widget.f(this.f58898b, this);
            List<String> list = a2.f58914d;
            if (z && list.size() == 0) {
                this.f58903g.setVisibility(8);
                TextView textView = (TextView) this.a.findViewById(R.id.ksad_reward_apk_info_desc_2);
                this.f58904h = textView;
                textView.setVisibility(0);
                this.f58904h.setText(a2.f58915e);
            }
            if (list.size() == 0) {
                this.f58906j.setVisibility(8);
            }
            for (String str : list) {
                i2++;
                if (i2 > 3) {
                    break;
                }
                a(this.f58906j, str);
            }
            this.f58898b.postDelayed(new Runnable(this) { // from class: com.kwad.sdk.reward.d.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ c a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        int height = this.a.f58898b.getHeight();
                        com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                        if (this.a.o) {
                            return;
                        }
                        this.a.a();
                    }
                }
            }, l);
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f58907k = aVar;
        }
    }

    public void a(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            Button button = this.f58900d;
            if (button != null && str != null) {
                button.setText(str);
            }
            if (z) {
                a();
            } else {
                d();
            }
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            a(view, true);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, view) == null) && com.kwad.sdk.core.response.a.c.g(this.r)) {
            a(view, false);
        }
    }
}
