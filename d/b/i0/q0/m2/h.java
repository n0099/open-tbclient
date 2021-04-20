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
public class h extends d.b.i0.q0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59574e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f59575f;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                h.this.f59544a.f59565a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f59544a.f59565a.setAlpha(1.0f);
            h hVar = h.this;
            hVar.f59546c = 2;
            b.a aVar = hVar.f59547d;
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
                h.this.f59544a.f59565a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f59544a.f59565a.setAlpha(0.0f);
            h hVar = h.this;
            hVar.f59546c = 0;
            b.a aVar = hVar.f59547d;
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
        public final /* synthetic */ Rect f59580e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59582e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59583f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f59584g;

            public a(float f2, float f3, float f4) {
                this.f59582e = f2;
                this.f59583f = f3;
                this.f59584g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = h.this.f59544a.f59566b;
                float f2 = this.f59582e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = h.this.f59544a.f59566b;
                float f3 = this.f59582e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = h.this.f59544a.f59566b;
                float f4 = this.f59583f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = h.this.f59544a.f59566b;
                float f5 = this.f59584g;
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
                h.this.f59544a.f59566b.setScaleX(1.0f);
                h.this.f59544a.f59566b.setScaleY(1.0f);
                h.this.f59544a.f59566b.setTranslationX(0.0f);
                h.this.f59544a.f59566b.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e(Rect rect) {
            this.f59580e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(Math.min((this.f59580e.width() * 1.0f) / h.this.f59544a.f59566b.getWidth(), (this.f59580e.height() * 1.0f) / h.this.f59544a.f59566b.getHeight()), this.f59580e.centerX() - ((h.this.f59544a.f59566b.getLeft() + h.this.f59544a.f59566b.getRight()) / 2.0f), this.f59580e.centerY() - ((h.this.f59544a.f59566b.getTop() + h.this.f59544a.f59566b.getBottom()) / 2.0f)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f59587e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59589e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59590f;

            public a(float f2, float f3) {
                this.f59589e = f2;
                this.f59590f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = h.this.f59544a.f59569e;
                    float f2 = this.f59589e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = h.this.f59544a.f59569e;
                    float f3 = this.f59590f;
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
                h.this.f59544a.f59569e.setTranslationX(0.0f);
                h.this.f59544a.f59569e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f59587e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f59587e.left - h.this.f59544a.f59569e.getLeft(), this.f59587e.top - h.this.f59544a.f59569e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f59593e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59595e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59596f;

            public a(float f2, float f3) {
                this.f59595e = f2;
                this.f59596f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = h.this.f59544a.f59568d;
                    float f2 = this.f59595e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = h.this.f59544a.f59568d;
                    float f3 = this.f59596f;
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
                h.this.f59544a.f59568d.setTranslationX(0.0f);
                h.this.f59544a.f59568d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f59593e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f59593e.left - h.this.f59544a.f59568d.getLeft(), this.f59593e.top - h.this.f59544a.f59568d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* renamed from: d.b.i0.q0.m2.h$h  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1464h implements Runnable {

        /* renamed from: d.b.i0.q0.m2.h$h$a */
        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59600e;

            public a(int i) {
                this.f59600e = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = h.this.f59544a.f59571g;
                    int i = this.f59600e;
                    linearLayout.setTranslationY(i - (i * floatValue));
                    h.this.f59544a.f59571g.setAlpha((floatValue / 2.0f) + 0.5f);
                }
            }
        }

        /* renamed from: d.b.i0.q0.m2.h$h$b */
        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.f59544a.f59571g.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public RunnableC1464h() {
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

    public h(d.b.i0.q0.m2.g gVar, Intent intent) {
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
        this.f59575f.start();
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
        this.f59574e.start();
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
        Rect rect = (Rect) this.f59545b.getParcelableExtra("info_forum_head_background_rect");
        if (rect == null) {
            return;
        }
        String stringExtra = this.f59545b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f59544a.j.W(stringExtra, 10, false);
        }
        this.f59544a.f59566b.post(new e(rect));
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
        linearLayout.post(new RunnableC1464h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f59574e = ofFloat;
        ofFloat.setDuration(270L);
        this.f59574e.addUpdateListener(new a());
        this.f59574e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f59575f = ofFloat2;
        ofFloat2.setDuration(800L);
        this.f59575f.addUpdateListener(new c());
        this.f59575f.addListener(new d());
    }
}
