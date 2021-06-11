package d.a.n0.r0.m2;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r0.m2.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends d.a.n0.r0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f62648e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f62649f;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                h.this.f62617a.f62638a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f62617a.f62638a.setAlpha(1.0f);
            h hVar = h.this;
            hVar.f62619c = 2;
            b.a aVar = hVar.f62620d;
            if (aVar != null) {
                aVar.onStateChanged(2);
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
                h.this.f62617a.f62638a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f62617a.f62638a.setAlpha(0.0f);
            h hVar = h.this;
            hVar.f62619c = 0;
            b.a aVar = hVar.f62620d;
            if (aVar != null) {
                aVar.onStateChanged(0);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f62654e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f62656e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f62657f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f62658g;

            public a(float f2, float f3, float f4) {
                this.f62656e = f2;
                this.f62657f = f3;
                this.f62658g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = h.this.f62617a.f62639b;
                float f2 = this.f62656e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = h.this.f62617a.f62639b;
                float f3 = this.f62656e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = h.this.f62617a.f62639b;
                float f4 = this.f62657f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = h.this.f62617a.f62639b;
                float f5 = this.f62658g;
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
                h.this.f62617a.f62639b.setScaleX(1.0f);
                h.this.f62617a.f62639b.setScaleY(1.0f);
                h.this.f62617a.f62639b.setTranslationX(0.0f);
                h.this.f62617a.f62639b.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e(Rect rect) {
            this.f62654e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(Math.min((this.f62654e.width() * 1.0f) / h.this.f62617a.f62639b.getWidth(), (this.f62654e.height() * 1.0f) / h.this.f62617a.f62639b.getHeight()), this.f62654e.centerX() - ((h.this.f62617a.f62639b.getLeft() + h.this.f62617a.f62639b.getRight()) / 2.0f), this.f62654e.centerY() - ((h.this.f62617a.f62639b.getTop() + h.this.f62617a.f62639b.getBottom()) / 2.0f)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f62661e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f62663e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f62664f;

            public a(float f2, float f3) {
                this.f62663e = f2;
                this.f62664f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = h.this.f62617a.f62642e;
                    float f2 = this.f62663e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = h.this.f62617a.f62642e;
                    float f3 = this.f62664f;
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
                h.this.f62617a.f62642e.setTranslationX(0.0f);
                h.this.f62617a.f62642e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f62661e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f62661e.left - h.this.f62617a.f62642e.getLeft(), this.f62661e.top - h.this.f62617a.f62642e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f62667e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f62669e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f62670f;

            public a(float f2, float f3) {
                this.f62669e = f2;
                this.f62670f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = h.this.f62617a.f62641d;
                    float f2 = this.f62669e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = h.this.f62617a.f62641d;
                    float f3 = this.f62670f;
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
                h.this.f62617a.f62641d.setTranslationX(0.0f);
                h.this.f62617a.f62641d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f62667e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f62667e.left - h.this.f62617a.f62641d.getLeft(), this.f62667e.top - h.this.f62617a.f62641d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* renamed from: d.a.n0.r0.m2.h$h  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1569h implements Runnable {

        /* renamed from: d.a.n0.r0.m2.h$h$a */
        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f62674e;

            public a(int i2) {
                this.f62674e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = h.this.f62617a.f62644g;
                    int i2 = this.f62674e;
                    linearLayout.setTranslationY(i2 - (i2 * floatValue));
                    h.this.f62617a.f62644g.setAlpha((floatValue / 2.0f) + 0.5f);
                }
            }
        }

        /* renamed from: d.a.n0.r0.m2.h$h$b */
        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.f62617a.f62644g.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public RunnableC1569h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public h(d.a.n0.r0.m2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.a.n0.r0.m2.b
    public void c() {
        if (this.f62619c != 2) {
            return;
        }
        this.f62619c = 3;
        b.a aVar = this.f62620d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f62649f.start();
    }

    @Override // d.a.n0.r0.m2.b
    public void d() {
        if (this.f62619c != 0) {
            return;
        }
        this.f62619c = 1;
        b.a aVar = this.f62620d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f62648e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f62618b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f62617a.f62640c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        Rect rect = (Rect) this.f62618b.getParcelableExtra("info_forum_head_background_rect");
        if (rect == null) {
            return;
        }
        String stringExtra = this.f62618b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f62617a.j.U(stringExtra, 10, false);
        }
        this.f62617a.f62639b.post(new e(rect));
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f62618b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f62618b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f62617a.f62641d.U(stringExtra, 10, false);
        this.f62617a.f62641d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f62618b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f62618b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f62617a.f62642e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f62617a.f62642e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f62618b == null || (linearLayout = this.f62617a.f62644g) == null) {
            return;
        }
        linearLayout.post(new RunnableC1569h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f62648e = ofFloat;
        ofFloat.setDuration(270L);
        this.f62648e.addUpdateListener(new a());
        this.f62648e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f62649f = ofFloat2;
        ofFloat2.setDuration(800L);
        this.f62649f.addUpdateListener(new c());
        this.f62649f.addListener(new d());
    }
}
