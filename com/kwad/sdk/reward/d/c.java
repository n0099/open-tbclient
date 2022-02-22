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
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSRatingBar;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes4.dex */
public class c implements com.kwad.sdk.widget.d {
    public static long l = 1600;
    public static long m = 1600;
    public static long n = 200;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public View f57441b;

    /* renamed from: c  reason: collision with root package name */
    public Button f57442c;

    /* renamed from: d  reason: collision with root package name */
    public Button f57443d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57444e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57445f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57446g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57447h;

    /* renamed from: i  reason: collision with root package name */
    public KSRatingBar f57448i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f57449j;
    public a k;
    @Nullable
    public Animator p;
    public AdTemplate r;
    public volatile boolean o = false;
    public boolean q = false;

    /* loaded from: classes4.dex */
    public interface a {
        void a(c cVar, View view, boolean z);
    }

    /* loaded from: classes4.dex */
    public static class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57454b;

        /* renamed from: c  reason: collision with root package name */
        public float f57455c;

        /* renamed from: d  reason: collision with root package name */
        public List<String> f57456d;

        /* renamed from: e  reason: collision with root package name */
        public String f57457e;

        /* renamed from: f  reason: collision with root package name */
        public int f57458f = 15;

        /* renamed from: g  reason: collision with root package name */
        public String f57459g;

        public static b a(AdTemplate adTemplate) {
            String str;
            if (adTemplate == null) {
                return null;
            }
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            b bVar = new b();
            bVar.f57454b = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.u(j2) : com.kwad.sdk.core.response.a.a.t(j2);
            bVar.f57455c = com.kwad.sdk.core.response.a.a.y(j2);
            bVar.f57457e = com.kwad.sdk.core.response.a.a.s(j2);
            bVar.a = com.kwad.sdk.core.response.a.d.v(adTemplate) ? com.kwad.sdk.core.response.a.a.aE(j2) : com.kwad.sdk.core.response.a.a.au(j2);
            if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
                bVar.f57458f = com.kwad.sdk.core.config.b.az();
                str = "安装并体验%s秒  可领取奖励";
            } else {
                bVar.f57458f = com.kwad.sdk.core.config.b.aA();
                str = "浏览详情页%s秒，领取奖励";
            }
            bVar.f57459g = str;
            bVar.f57456d = com.kwad.sdk.core.response.a.c.i(adTemplate);
            return bVar;
        }

        public String a() {
            return String.format(this.f57459g, Integer.valueOf(this.f57458f));
        }
    }

    /* renamed from: com.kwad.sdk.reward.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2151c implements Animator.AnimatorListener {
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
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
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

    public static Animator a(final View view, View view2, int i2, int i3) {
        Animator c2 = c(view);
        float f2 = i2;
        float f3 = i3;
        Animator a2 = a(view2, f2, f3);
        a2.addListener(new C2151c() { // from class: com.kwad.sdk.reward.d.c.3
            @Override // com.kwad.sdk.reward.d.c.C2151c, android.animation.Animator.AnimatorListener
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
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R.layout.ksad_reward_apk_info_card_tag_item, (ViewGroup) linearLayout, false);
        textView.setText(str);
        this.f57449j.addView(textView);
    }

    public static Animator c(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
        ofFloat.setDuration(n);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void c() {
        this.f57442c = (Button) this.a.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.f57443d = (Button) this.a.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.f57441b = this.a.findViewById(R.id.ksad_reward_apk_info_install_container);
        this.f57445f = (ImageView) this.a.findViewById(R.id.ksad_reward_apk_info_icon);
        this.f57444e = (TextView) this.a.findViewById(R.id.ksad_reward_apk_info_name);
        this.f57446g = (TextView) this.a.findViewById(R.id.ksad_reward_apk_info_desc);
        this.f57448i = (KSRatingBar) this.a.findViewById(R.id.ksad_reward_apk_info_score);
        this.f57449j = (LinearLayout) this.a.findViewById(R.id.ksad_reward_apk_info_tags);
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
        int height = this.f57441b.getHeight();
        int width = this.f57441b.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.p == null) {
            Animator a2 = a(this.f57443d, this.f57442c, width, height);
            this.p = a2;
            a2.addListener(new C2151c() { // from class: com.kwad.sdk.reward.d.c.2
                @Override // com.kwad.sdk.reward.d.c.C2151c, android.animation.Animator.AnimatorListener
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
        if (id == R.id.ksad_reward_apk_info_install_container || id == R.id.ksad_reward_apk_info_install_action || id == R.id.ksad_reward_apk_info_install_start) {
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
        KSImageLoader.loadAppIcon(this.f57445f, a2.a, adTemplate, 12);
        this.f57444e.setText(a2.f57454b);
        this.f57446g.setText(a2.f57457e);
        this.f57448i.setStar(a2.f57455c);
        int i2 = 0;
        if (com.kwad.sdk.core.response.a.d.u(adTemplate)) {
            this.f57443d.setText("开始下载");
            this.f57448i.setVisibility(0);
        } else {
            this.f57443d.setText("查看详情");
            this.f57448i.setVisibility(8);
        }
        this.f57442c.setText(a2.a());
        this.f57442c.setClickable(true);
        this.f57443d.setClickable(true);
        this.f57441b.setClickable(true);
        new com.kwad.sdk.widget.f(this.f57442c, this);
        new com.kwad.sdk.widget.f(this.f57443d, this);
        new com.kwad.sdk.widget.f(this.f57441b, this);
        List<String> list = a2.f57456d;
        if (z && list.size() == 0) {
            this.f57446g.setVisibility(8);
            TextView textView = (TextView) this.a.findViewById(R.id.ksad_reward_apk_info_desc_2);
            this.f57447h = textView;
            textView.setVisibility(0);
            this.f57447h.setText(a2.f57457e);
        }
        if (list.size() == 0) {
            this.f57449j.setVisibility(8);
        }
        for (String str : list) {
            i2++;
            if (i2 > 3) {
                break;
            }
            a(this.f57449j, str);
        }
        this.f57441b.postDelayed(new Runnable() { // from class: com.kwad.sdk.reward.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                int height = c.this.f57441b.getHeight();
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

    public void a(String str, int i2, boolean z) {
        Button button = this.f57443d;
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
