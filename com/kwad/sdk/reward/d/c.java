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
/* loaded from: classes5.dex */
public class c implements com.kwad.sdk.widget.d {
    public static long l = 1600;
    public static long m = 1600;
    public static long n = 200;
    public View a;
    public View b;
    public Button c;
    public Button d;
    public TextView e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public KSRatingBar i;
    public LinearLayout j;
    public a k;
    @Nullable
    public Animator p;
    public AdTemplate r;
    public volatile boolean o = false;
    public boolean q = false;

    /* loaded from: classes5.dex */
    public interface a {
        void a(c cVar, View view2, boolean z);
    }

    /* loaded from: classes5.dex */
    public static class b {
        public String a;
        public String b;
        public float c;
        public List<String> d;
        public String e;
        public int f = 15;
        public String g;

        public static b a(AdTemplate adTemplate) {
            String str;
            if (adTemplate == null) {
                return null;
            }
            AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
            b bVar = new b();
            bVar.b = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.u(j) : com.kwad.sdk.core.response.a.a.t(j);
            bVar.c = com.kwad.sdk.core.response.a.a.y(j);
            bVar.e = com.kwad.sdk.core.response.a.a.s(j);
            bVar.a = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.aE(j) : com.kwad.sdk.core.response.a.a.au(j);
            if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
                bVar.f = com.kwad.sdk.core.config.b.az();
                str = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.f = com.kwad.sdk.core.config.b.aA();
                str = "浏览详情页%s秒，领取奖励";
            }
            bVar.g = str;
            bVar.d = com.kwad.sdk.core.response.a.c.i(adTemplate);
            return bVar;
        }

        public String a() {
            return String.format(this.g, Integer.valueOf(this.f));
        }
    }

    /* renamed from: com.kwad.sdk.reward.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0331c implements Animator.AnimatorListener {
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

    public c(View view2) {
        this.a = view2;
        c();
    }

    public static Animator a(final View view2, float f, final float f2) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(n);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f070374);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.reward.d.c.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3 * floatValue;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = (floatValue / f5) * dimension;
                    View view3 = view2;
                    if (view3 instanceof TextView) {
                        ((TextView) view3).setTextSize(0, f6);
                    }
                }
                com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "onAnimationUpdate: " + floatValue + ", currentWidth:" + f4 + ", ratio:" + f3);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f4;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    public static Animator a(final View view2, View view3, int i, int i2) {
        Animator c = c(view2);
        float f = i;
        float f2 = i2;
        Animator a2 = a(view3, f, f2);
        a2.addListener(new C0331c() { // from class: com.kwad.sdk.reward.d.c.3
            @Override // com.kwad.sdk.reward.d.c.C0331c, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, AnimationProperty.SCALE_X, 1.0f, 1.0f);
        ofFloat.setDuration(m);
        Animator c2 = c(view3);
        Animator a3 = a(view2, f, f2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(c, a2, ofFloat, c2, a3);
        return animatorSet;
    }

    private void a(LinearLayout linearLayout, String str) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.obfuscated_res_0x7f0d045d, (ViewGroup) linearLayout, false);
        textView.setText(str);
        this.j.addView(textView);
    }

    public static Animator c(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 1.0f, 0.0f);
        ofFloat.setDuration(n);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void c() {
        this.c = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910e0);
        this.d = (Button) this.a.findViewById(R.id.obfuscated_res_0x7f0910e2);
        this.b = this.a.findViewById(R.id.obfuscated_res_0x7f0910e1);
        this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0910df);
        this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910e3);
        this.g = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910dd);
        this.i = (KSRatingBar) this.a.findViewById(R.id.obfuscated_res_0x7f0910e4);
        this.j = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0910e6);
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
        int height = this.b.getHeight();
        int width = this.b.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.p == null) {
            Animator a2 = a(this.d, this.c, width, height);
            this.p = a2;
            a2.addListener(new C0331c() { // from class: com.kwad.sdk.reward.d.c.2
                @Override // com.kwad.sdk.reward.d.c.C0331c, android.animation.Animator.AnimatorListener
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

    public void a(View view2, boolean z) {
        int id = view2.getId();
        if (id == R.id.obfuscated_res_0x7f0910e1 || id == R.id.obfuscated_res_0x7f0910e0 || id == R.id.obfuscated_res_0x7f0910e2) {
            com.kwai.sodler.lib.a.b("ApkInfoCardViewHelper", "onClick install");
            this.o = true;
            a aVar = this.k;
            if (aVar != null) {
                aVar.a(this, view2, z);
            }
        }
    }

    public void a(AdTemplate adTemplate, boolean z) {
        this.r = adTemplate;
        b a2 = b.a(adTemplate);
        if (a2 == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.f, a2.a, adTemplate, 12);
        this.e.setText(a2.b);
        this.g.setText(a2.e);
        this.i.setStar(a2.c);
        int i = 0;
        if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
            this.d.setText("开始下载");
            this.i.setVisibility(0);
        } else {
            this.d.setText("查看详情");
            this.i.setVisibility(8);
        }
        this.c.setText(a2.a());
        this.c.setClickable(true);
        this.d.setClickable(true);
        this.b.setClickable(true);
        new com.kwad.sdk.widget.f(this.c, this);
        new com.kwad.sdk.widget.f(this.d, this);
        new com.kwad.sdk.widget.f(this.b, this);
        List<String> list = a2.d;
        if (z && list.size() == 0) {
            this.g.setVisibility(8);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0910de);
            this.h = textView;
            textView.setVisibility(0);
            this.h.setText(a2.e);
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
        this.b.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                int height = c.this.b.getHeight();
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
        Button button = this.d;
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
    public void a_(View view2) {
        a(view2, true);
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        if (com.kwad.sdk.core.response.a.c.g(this.r)) {
            a(view2, false);
        }
    }
}
