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
public class a extends d.a.n0.r0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58898e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f58899f;

    /* renamed from: d.a.n0.r0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1508a implements ValueAnimator.AnimatorUpdateListener {
        public C1508a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                a.this.f58926a.f58947a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f58926a.f58947a.setAlpha(1.0f);
            a aVar = a.this;
            aVar.f58928c = 2;
            b.a aVar2 = aVar.f58929d;
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
                a.this.f58926a.f58947a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f58926a.f58947a.setAlpha(0.0f);
            a aVar = a.this;
            aVar.f58928c = 0;
            b.a aVar2 = aVar.f58929d;
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

        /* renamed from: d.a.n0.r0.m2.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1509a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58905e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f58906f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f58907g;

            public C1509a(float f2, float f3, float f4) {
                this.f58905e = f2;
                this.f58906f = f3;
                this.f58907g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = a.this.f58926a.f58948b;
                float f2 = this.f58905e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = a.this.f58926a.f58948b;
                float f3 = this.f58905e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = a.this.f58926a.f58948b;
                float f4 = this.f58906f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = a.this.f58926a.f58948b;
                float f5 = this.f58907g;
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
                a.this.f58926a.f58948b.setScaleX(1.0f);
                a.this.f58926a.f58948b.setScaleY(1.0f);
                a.this.f58926a.f58948b.setTranslationX(0.0f);
                a.this.f58926a.f58948b.setTranslationY(0.0f);
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
            float min = Math.min(269.0f / a.this.f58926a.f58948b.getWidth(), 141.0f / a.this.f58926a.f58948b.getHeight());
            float left = 516.0f - ((a.this.f58926a.f58948b.getLeft() + a.this.f58926a.f58948b.getRight()) / 2.0f);
            float top = 529.0f - ((a.this.f58926a.f58948b.getTop() + a.this.f58926a.f58948b.getBottom()) / 2.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1509a(min, left, top));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f58910e;

        /* renamed from: d.a.n0.r0.m2.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1510a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58912e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f58913f;

            public C1510a(float f2, float f3) {
                this.f58912e = f2;
                this.f58913f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = a.this.f58926a.f58951e;
                    float f2 = this.f58912e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = a.this.f58926a.f58951e;
                    float f3 = this.f58913f;
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
                a.this.f58926a.f58951e.setTranslationX(0.0f);
                a.this.f58926a.f58951e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f58910e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1510a(this.f58910e.left - a.this.f58926a.f58951e.getLeft(), this.f58910e.top - a.this.f58926a.f58951e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f58916e;

        /* renamed from: d.a.n0.r0.m2.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1511a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f58918e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f58919f;

            public C1511a(float f2, float f3) {
                this.f58918e = f2;
                this.f58919f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = a.this.f58926a.f58950d;
                    float f2 = this.f58918e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = a.this.f58926a.f58950d;
                    float f3 = this.f58919f;
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
                a.this.f58926a.f58950d.setTranslationX(0.0f);
                a.this.f58926a.f58950d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f58916e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1511a(this.f58916e.left - a.this.f58926a.f58950d.getLeft(), this.f58916e.top - a.this.f58926a.f58950d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: d.a.n0.r0.m2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1512a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f58923e;

            public C1512a(int i2) {
                this.f58923e = i2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = a.this.f58926a.f58953g;
                    int i2 = this.f58923e;
                    linearLayout.setTranslationY(i2 - (i2 * floatValue));
                    a.this.f58926a.f58953g.setAlpha((floatValue / 2.0f) + 0.5f);
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
                a.this.f58926a.f58953g.setAlpha(1.0f);
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
            ofFloat.addUpdateListener(new C1512a(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public a(d.a.n0.r0.m2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.a.n0.r0.m2.b
    public void c() {
        if (this.f58928c != 2) {
            return;
        }
        this.f58928c = 3;
        b.a aVar = this.f58929d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f58899f.start();
    }

    @Override // d.a.n0.r0.m2.b
    public void d() {
        if (this.f58928c != 0) {
            return;
        }
        this.f58928c = 1;
        b.a aVar = this.f58929d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f58898e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f58927b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f58926a.f58949c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        String stringExtra = this.f58927b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f58926a.j.V(stringExtra, 10, false);
        }
        this.f58926a.f58948b.post(new e());
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f58927b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f58927b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f58926a.f58950d.V(stringExtra, 10, false);
        this.f58926a.f58950d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f58927b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f58927b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f58926a.f58951e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f58926a.f58951e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f58927b == null || (linearLayout = this.f58926a.f58953g) == null) {
            return;
        }
        linearLayout.post(new h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f58898e = ofFloat;
        ofFloat.setDuration(270L);
        this.f58898e.addUpdateListener(new C1508a());
        this.f58898e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f58899f = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f58899f.addUpdateListener(new c());
        this.f58899f.addListener(new d());
    }
}
