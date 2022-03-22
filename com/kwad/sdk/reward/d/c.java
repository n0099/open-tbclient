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
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSRatingBar;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.widget.d {
    public static long l = 1600;
    public static long m = 1600;
    public static long n = 200;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f40765b;

    /* renamed from: c  reason: collision with root package name */
    public Button f40766c;

    /* renamed from: d  reason: collision with root package name */
    public Button f40767d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f40768e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f40769f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40770g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40771h;
    public KSRatingBar i;
    public LinearLayout j;
    public a k;
    @Nullable
    public Animator p;
    public AdTemplate r;
    public volatile boolean o = false;
    public boolean q = false;

    /* loaded from: classes7.dex */
    public interface a {
        void a(c cVar, View view, boolean z);
    }

    /* loaded from: classes7.dex */
    public static class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f40776b;

        /* renamed from: c  reason: collision with root package name */
        public float f40777c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f40778d;

        /* renamed from: e  reason: collision with root package name */
        public String f40779e;

        /* renamed from: f  reason: collision with root package name */
        public int f40780f = 15;

        /* renamed from: g  reason: collision with root package name */
        public String f40781g;

        public static b a(AdTemplate adTemplate) {
            String str;
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            b bVar = new b();
            bVar.f40776b = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.u(j) : com.kwad.sdk.core.response.a.a.t(j);
            bVar.f40777c = com.kwad.sdk.core.response.a.a.y(j);
            bVar.f40779e = com.kwad.sdk.core.response.a.a.s(j);
            bVar.a = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.aE(j) : com.kwad.sdk.core.response.a.a.au(j);
            if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
                bVar.f40780f = com.kwad.sdk.core.config.b.az();
                str = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.f40780f = com.kwad.sdk.core.config.b.aA();
                str = "浏览详情页%s秒，领取奖励";
            }
            bVar.f40781g = str;
            bVar.f40778d = com.kwad.sdk.core.response.a.c.i(adTemplate);
            return bVar;
        }

        public String a() {
            return String.format(this.f40781g, Integer.valueOf(this.f40780f));
        }
    }

    /* renamed from: com.kwad.sdk.reward.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1991c implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public c(View view) {
        this.a = view;
        c();
    }

    public static Animator a(final View view, float f2, final float f3) {
        final float f4 = f2 / f3;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f3);
        ofFloat.setDuration(n);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.obfuscated_res_0x7f07036a);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.d.c.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f5 = f4 * floatValue;
                float f6 = f3;
                if (f6 != 0.0f) {
                    float f7 = (floatValue / f6) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f7);
                    }
                }
                com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "onAnimationUpdate: " + floatValue + ", currentWidth:" + f5 + ", ratio:" + f4);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f5;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    public static Animator a(final View view, View view2, int i, int i2) {
        Animator c2 = c(view);
        float f2 = i;
        float f3 = i2;
        Animator a2 = a(view2, f2, f3);
        a2.addListener(new C1991c() { // from class: com.kwad.sdk.reward.d.c.3
            @Override // com.kwad.sdk.reward.d.c.C1991c, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
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

    private void a(LinearLayout linearLayout, String str) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0462, (ViewGroup) linearLayout, false);
        textView.setText(str);
        this.j.addView(textView);
    }

    public static Animator c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
        ofFloat.setDuration(n);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void c() {
        this.f40766c = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910e7);
        this.f40767d = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910e9);
        this.f40765b = this.a.findViewById(R.id.obfuscated_res_0x7f0910e8);
        this.f40769f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e6);
        this.f40768e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910ea);
        this.f40770g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e4);
        this.i = (KSRatingBar) this.a.findViewById(R.id.obfuscated_res_0x7f0910eb);
        this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0910ed);
    }

    private void d() {
        Animator animator = this.p;
        if (animator != null) {
            animator.cancel();
            this.q = true;
        }
    }

    public void a() {
        com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "startAnimation");
        int height = this.f40765b.getHeight();
        int width = this.f40765b.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.p == null) {
            Animator a2 = a(this.f40767d, this.f40766c, width, height);
            this.p = a2;
            a2.addListener(new C1991c() { // from class: com.kwad.sdk.reward.d.c.2
                @Override // com.kwad.sdk.reward.d.c.C1991c, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(final Animator animator) {
                    if (c.this.q) {
                        return;
                    }
                    ax.a(new Runnable() { // from class: com.kwad.sdk.reward.d.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            animator.start();
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

    public void a(View view, boolean z) {
        int id = view.getId();
        if (id == R.id.obfuscated_res_0x7f0910e8 || id == R.id.obfuscated_res_0x7f0910e7 || id == R.id.obfuscated_res_0x7f0910e9) {
            com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "onClick install");
            this.o = true;
            a aVar = this.k;
            if (aVar != null) {
                aVar.a(this, view, z);
            }
        }
    }

    public void a(AdTemplate adTemplate, boolean z) {
        this.r = adTemplate;
        b a2 = b.a(adTemplate);
        if (a2 == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.f40769f, a2.a, adTemplate, 12);
        this.f40768e.setText(a2.f40776b);
        this.f40770g.setText(a2.f40779e);
        this.i.setStar(a2.f40777c);
        int i = 0;
        if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
            this.f40767d.setText("开始下载");
            this.i.setVisibility(0);
        } else {
            this.f40767d.setText("查看详情");
            this.i.setVisibility(8);
        }
        this.f40766c.setText(a2.a());
        this.f40766c.setClickable(true);
        this.f40767d.setClickable(true);
        this.f40765b.setClickable(true);
        new com.kwad.sdk.widget.f(this.f40766c, this);
        new com.kwad.sdk.widget.f(this.f40767d, this);
        new com.kwad.sdk.widget.f(this.f40765b, this);
        List<String> list = a2.f40778d;
        if (z && list.size() == 0) {
            this.f40770g.setVisibility(8);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e5);
            this.f40771h = textView;
            textView.setVisibility(0);
            this.f40771h.setText(a2.f40779e);
        }
        if (list.size() == 0) {
            this.j.setVisibility(8);
        }
        for (String str : list) {
            i++;
            if (i > 3) {
                break;
            }
            a(this.j, str);
        }
        this.f40765b.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                int height = c.this.f40765b.getHeight();
                com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", hashCode() + " parentHeight: " + height);
                if (c.this.o) {
                    return;
                }
                c.this.a();
            }
        }, l);
    }

    public void a(a aVar) {
        this.k = aVar;
    }

    public void a(String str, int i, boolean z) {
        Button button = this.f40767d;
        if (button != null && str != null) {
            button.setText(str);
        }
        if (z) {
            a();
        } else {
            d();
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        a(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        if (com.kwad.sdk.core.response.a.c.g(this.r)) {
            a(view, false);
        }
    }
}
