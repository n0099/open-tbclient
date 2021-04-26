package d.a.j0.q0.m2;

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
import d.a.j0.q0.m2.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h extends d.a.j0.q0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58074e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f58075f;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                h.this.f58043a.f58064a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f58043a.f58064a.setAlpha(1.0f);
            h hVar = h.this;
            hVar.f58045c = 2;
            b.a aVar = hVar.f58046d;
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
                h.this.f58043a.f58064a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f58043a.f58064a.setAlpha(0.0f);
            h hVar = h.this;
            hVar.f58045c = 0;
            b.a aVar = hVar.f58046d;
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
        public final /* synthetic */ Rect f58080e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58082e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f58083f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f58084g;

            public a(float f2, float f3, float f4) {
                this.f58082e = f2;
                this.f58083f = f3;
                this.f58084g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = h.this.f58043a.f58065b;
                float f2 = this.f58082e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = h.this.f58043a.f58065b;
                float f3 = this.f58082e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = h.this.f58043a.f58065b;
                float f4 = this.f58083f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = h.this.f58043a.f58065b;
                float f5 = this.f58084g;
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
                h.this.f58043a.f58065b.setScaleX(1.0f);
                h.this.f58043a.f58065b.setScaleY(1.0f);
                h.this.f58043a.f58065b.setTranslationX(0.0f);
                h.this.f58043a.f58065b.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e(Rect rect) {
            this.f58080e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(Math.min((this.f58080e.width() * 1.0f) / h.this.f58043a.f58065b.getWidth(), (this.f58080e.height() * 1.0f) / h.this.f58043a.f58065b.getHeight()), this.f58080e.centerX() - ((h.this.f58043a.f58065b.getLeft() + h.this.f58043a.f58065b.getRight()) / 2.0f), this.f58080e.centerY() - ((h.this.f58043a.f58065b.getTop() + h.this.f58043a.f58065b.getBottom()) / 2.0f)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f58087e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58089e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f58090f;

            public a(float f2, float f3) {
                this.f58089e = f2;
                this.f58090f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = h.this.f58043a.f58068e;
                    float f2 = this.f58089e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = h.this.f58043a.f58068e;
                    float f3 = this.f58090f;
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
                h.this.f58043a.f58068e.setTranslationX(0.0f);
                h.this.f58043a.f58068e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f58087e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f58087e.left - h.this.f58043a.f58068e.getLeft(), this.f58087e.top - h.this.f58043a.f58068e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f58093e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58095e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f58096f;

            public a(float f2, float f3) {
                this.f58095e = f2;
                this.f58096f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = h.this.f58043a.f58067d;
                    float f2 = this.f58095e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = h.this.f58043a.f58067d;
                    float f3 = this.f58096f;
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
                h.this.f58043a.f58067d.setTranslationX(0.0f);
                h.this.f58043a.f58067d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f58093e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f58093e.left - h.this.f58043a.f58067d.getLeft(), this.f58093e.top - h.this.f58043a.f58067d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* renamed from: d.a.j0.q0.m2.h$h  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1426h implements Runnable {

        /* renamed from: d.a.j0.q0.m2.h$h$a */
        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58100e;

            public a(int i2) {
                this.f58100e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = h.this.f58043a.f58070g;
                    int i2 = this.f58100e;
                    linearLayout.setTranslationY(i2 - (i2 * floatValue));
                    h.this.f58043a.f58070g.setAlpha((floatValue / 2.0f) + 0.5f);
                }
            }
        }

        /* renamed from: d.a.j0.q0.m2.h$h$b */
        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.f58043a.f58070g.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public RunnableC1426h() {
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

    public h(d.a.j0.q0.m2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.a.j0.q0.m2.b
    public void c() {
        if (this.f58045c != 2) {
            return;
        }
        this.f58045c = 3;
        b.a aVar = this.f58046d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f58075f.start();
    }

    @Override // d.a.j0.q0.m2.b
    public void d() {
        if (this.f58045c != 0) {
            return;
        }
        this.f58045c = 1;
        b.a aVar = this.f58046d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f58074e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f58044b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f58043a.f58066c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        Rect rect = (Rect) this.f58044b.getParcelableExtra("info_forum_head_background_rect");
        if (rect == null) {
            return;
        }
        String stringExtra = this.f58044b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f58043a.j.V(stringExtra, 10, false);
        }
        this.f58043a.f58065b.post(new e(rect));
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f58044b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f58044b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f58043a.f58067d.V(stringExtra, 10, false);
        this.f58043a.f58067d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f58044b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f58044b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f58043a.f58068e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f58043a.f58068e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f58044b == null || (linearLayout = this.f58043a.f58070g) == null) {
            return;
        }
        linearLayout.post(new RunnableC1426h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f58074e = ofFloat;
        ofFloat.setDuration(270L);
        this.f58074e.addUpdateListener(new a());
        this.f58074e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f58075f = ofFloat2;
        ofFloat2.setDuration(800L);
        this.f58075f.addUpdateListener(new c());
        this.f58075f.addListener(new d());
    }
}
