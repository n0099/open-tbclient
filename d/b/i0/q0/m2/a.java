package d.b.i0.q0.m2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Rect;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.q0.m2.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.b.i0.q0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59516e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f59517f;

    /* renamed from: d.b.i0.q0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1459a implements ValueAnimator.AnimatorUpdateListener {
        public C1459a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                a.this.f59544a.f59565a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f59544a.f59565a.setAlpha(1.0f);
            a aVar = a.this;
            aVar.f59546c = 2;
            b.a aVar2 = aVar.f59547d;
            if (aVar2 != null) {
                aVar2.onStateChanged(2);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                a.this.f59544a.f59565a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f59544a.f59565a.setAlpha(0.0f);
            a aVar = a.this;
            aVar.f59546c = 0;
            b.a aVar2 = aVar.f59547d;
            if (aVar2 != null) {
                aVar2.onStateChanged(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: d.b.i0.q0.m2.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1460a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59523e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59524f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f59525g;

            public C1460a(float f2, float f3, float f4) {
                this.f59523e = f2;
                this.f59524f = f3;
                this.f59525g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = a.this.f59544a.f59566b;
                float f2 = this.f59523e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = a.this.f59544a.f59566b;
                float f3 = this.f59523e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = a.this.f59544a.f59566b;
                float f4 = this.f59524f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = a.this.f59544a.f59566b;
                float f5 = this.f59525g;
                relativeLayout4.setTranslationY(f5 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f5));
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f59544a.f59566b.setScaleX(1.0f);
                a.this.f59544a.f59566b.setScaleY(1.0f);
                a.this.f59544a.f59566b.setTranslationX(0.0f);
                a.this.f59544a.f59566b.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float min = Math.min(269.0f / a.this.f59544a.f59566b.getWidth(), 141.0f / a.this.f59544a.f59566b.getHeight());
            float left = 516.0f - ((a.this.f59544a.f59566b.getLeft() + a.this.f59544a.f59566b.getRight()) / 2.0f);
            float top = 529.0f - ((a.this.f59544a.f59566b.getTop() + a.this.f59544a.f59566b.getBottom()) / 2.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1460a(min, left, top));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f59528e;

        /* renamed from: d.b.i0.q0.m2.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1461a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59530e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59531f;

            public C1461a(float f2, float f3) {
                this.f59530e = f2;
                this.f59531f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = a.this.f59544a.f59569e;
                    float f2 = this.f59530e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = a.this.f59544a.f59569e;
                    float f3 = this.f59531f;
                    textView2.setTranslationY(f3 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f3));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f59544a.f59569e.setTranslationX(0.0f);
                a.this.f59544a.f59569e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f59528e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1461a(this.f59528e.left - a.this.f59544a.f59569e.getLeft(), this.f59528e.top - a.this.f59544a.f59569e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f59534e;

        /* renamed from: d.b.i0.q0.m2.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1462a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59536e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59537f;

            public C1462a(float f2, float f3) {
                this.f59536e = f2;
                this.f59537f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = a.this.f59544a.f59568d;
                    float f2 = this.f59536e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = a.this.f59544a.f59568d;
                    float f3 = this.f59537f;
                    barImageView2.setTranslationY(f3 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f3));
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f59544a.f59568d.setTranslationX(0.0f);
                a.this.f59544a.f59568d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f59534e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1462a(this.f59534e.left - a.this.f59544a.f59568d.getLeft(), this.f59534e.top - a.this.f59544a.f59568d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: d.b.i0.q0.m2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1463a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59541e;

            public C1463a(int i) {
                this.f59541e = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = a.this.f59544a.f59571g;
                    int i = this.f59541e;
                    linearLayout.setTranslationY(i - (i * floatValue));
                    a.this.f59544a.f59571g.setAlpha((floatValue / 2.0f) + 0.5f);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f59544a.f59571g.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1463a(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public a(d.b.i0.q0.m2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.b.i0.q0.m2.b
    public void c() {
        if (this.f59546c != 2) {
            return;
        }
        this.f59546c = 3;
        b.a aVar = this.f59547d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f59517f.start();
    }

    @Override // d.b.i0.q0.m2.b
    public void d() {
        if (this.f59546c != 0) {
            return;
        }
        this.f59546c = 1;
        b.a aVar = this.f59547d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f59516e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f59545b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f59544a.f59567c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        String stringExtra = this.f59545b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f59544a.j.W(stringExtra, 10, false);
        }
        this.f59544a.f59566b.post(new e());
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f59545b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f59545b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f59544a.f59568d.W(stringExtra, 10, false);
        this.f59544a.f59568d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f59545b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f59545b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f59544a.f59569e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f59544a.f59569e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f59545b == null || (linearLayout = this.f59544a.f59571g) == null) {
            return;
        }
        linearLayout.post(new h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f59516e = ofFloat;
        ofFloat.setDuration(270L);
        this.f59516e.addUpdateListener(new C1459a());
        this.f59516e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f59517f = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f59517f.addUpdateListener(new c());
        this.f59517f.addListener(new d());
    }
}
