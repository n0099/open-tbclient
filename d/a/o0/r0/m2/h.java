package d.a.o0.r0.m2;

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
import d.a.o0.r0.m2.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends d.a.o0.r0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f62773e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f62774f;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                h.this.f62742a.f62763a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f62742a.f62763a.setAlpha(1.0f);
            h hVar = h.this;
            hVar.f62744c = 2;
            b.a aVar = hVar.f62745d;
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
                h.this.f62742a.f62763a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f62742a.f62763a.setAlpha(0.0f);
            h hVar = h.this;
            hVar.f62744c = 0;
            b.a aVar = hVar.f62745d;
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
        public final /* synthetic */ Rect f62779e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f62781e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f62782f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f62783g;

            public a(float f2, float f3, float f4) {
                this.f62781e = f2;
                this.f62782f = f3;
                this.f62783g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = h.this.f62742a.f62764b;
                float f2 = this.f62781e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = h.this.f62742a.f62764b;
                float f3 = this.f62781e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = h.this.f62742a.f62764b;
                float f4 = this.f62782f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = h.this.f62742a.f62764b;
                float f5 = this.f62783g;
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
                h.this.f62742a.f62764b.setScaleX(1.0f);
                h.this.f62742a.f62764b.setScaleY(1.0f);
                h.this.f62742a.f62764b.setTranslationX(0.0f);
                h.this.f62742a.f62764b.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e(Rect rect) {
            this.f62779e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(Math.min((this.f62779e.width() * 1.0f) / h.this.f62742a.f62764b.getWidth(), (this.f62779e.height() * 1.0f) / h.this.f62742a.f62764b.getHeight()), this.f62779e.centerX() - ((h.this.f62742a.f62764b.getLeft() + h.this.f62742a.f62764b.getRight()) / 2.0f), this.f62779e.centerY() - ((h.this.f62742a.f62764b.getTop() + h.this.f62742a.f62764b.getBottom()) / 2.0f)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f62786e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f62788e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f62789f;

            public a(float f2, float f3) {
                this.f62788e = f2;
                this.f62789f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = h.this.f62742a.f62767e;
                    float f2 = this.f62788e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = h.this.f62742a.f62767e;
                    float f3 = this.f62789f;
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
                h.this.f62742a.f62767e.setTranslationX(0.0f);
                h.this.f62742a.f62767e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f62786e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f62786e.left - h.this.f62742a.f62767e.getLeft(), this.f62786e.top - h.this.f62742a.f62767e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f62792e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f62794e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f62795f;

            public a(float f2, float f3) {
                this.f62794e = f2;
                this.f62795f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = h.this.f62742a.f62766d;
                    float f2 = this.f62794e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = h.this.f62742a.f62766d;
                    float f3 = this.f62795f;
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
                h.this.f62742a.f62766d.setTranslationX(0.0f);
                h.this.f62742a.f62766d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f62792e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f62792e.left - h.this.f62742a.f62766d.getLeft(), this.f62792e.top - h.this.f62742a.f62766d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* renamed from: d.a.o0.r0.m2.h$h  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1573h implements Runnable {

        /* renamed from: d.a.o0.r0.m2.h$h$a */
        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f62799e;

            public a(int i2) {
                this.f62799e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = h.this.f62742a.f62769g;
                    int i2 = this.f62799e;
                    linearLayout.setTranslationY(i2 - (i2 * floatValue));
                    h.this.f62742a.f62769g.setAlpha((floatValue / 2.0f) + 0.5f);
                }
            }
        }

        /* renamed from: d.a.o0.r0.m2.h$h$b */
        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.f62742a.f62769g.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public RunnableC1573h() {
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

    public h(d.a.o0.r0.m2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.a.o0.r0.m2.b
    public void c() {
        if (this.f62744c != 2) {
            return;
        }
        this.f62744c = 3;
        b.a aVar = this.f62745d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f62774f.start();
    }

    @Override // d.a.o0.r0.m2.b
    public void d() {
        if (this.f62744c != 0) {
            return;
        }
        this.f62744c = 1;
        b.a aVar = this.f62745d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f62773e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f62743b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f62742a.f62765c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        Rect rect = (Rect) this.f62743b.getParcelableExtra("info_forum_head_background_rect");
        if (rect == null) {
            return;
        }
        String stringExtra = this.f62743b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f62742a.j.U(stringExtra, 10, false);
        }
        this.f62742a.f62764b.post(new e(rect));
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f62743b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f62743b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f62742a.f62766d.U(stringExtra, 10, false);
        this.f62742a.f62766d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f62743b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f62743b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f62742a.f62767e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f62742a.f62767e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f62743b == null || (linearLayout = this.f62742a.f62769g) == null) {
            return;
        }
        linearLayout.post(new RunnableC1573h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f62773e = ofFloat;
        ofFloat.setDuration(270L);
        this.f62773e.addUpdateListener(new a());
        this.f62773e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f62774f = ofFloat2;
        ofFloat2.setDuration(800L);
        this.f62774f.addUpdateListener(new c());
        this.f62774f.addListener(new d());
    }
}
