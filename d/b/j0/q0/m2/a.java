package d.b.j0.q0.m2;

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
import d.b.j0.q0.m2.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.b.j0.q0.m2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59937e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f59938f;

    /* renamed from: d.b.j0.q0.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1482a implements ValueAnimator.AnimatorUpdateListener {
        public C1482a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                a.this.f59965a.f59986a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f59965a.f59986a.setAlpha(1.0f);
            a aVar = a.this;
            aVar.f59967c = 2;
            b.a aVar2 = aVar.f59968d;
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
                a.this.f59965a.f59986a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f59965a.f59986a.setAlpha(0.0f);
            a aVar = a.this;
            aVar.f59967c = 0;
            b.a aVar2 = aVar.f59968d;
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

        /* renamed from: d.b.j0.q0.m2.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1483a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59944e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59945f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f59946g;

            public C1483a(float f2, float f3, float f4) {
                this.f59944e = f2;
                this.f59945f = f3;
                this.f59946g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = a.this.f59965a.f59987b;
                float f2 = this.f59944e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = a.this.f59965a.f59987b;
                float f3 = this.f59944e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = a.this.f59965a.f59987b;
                float f4 = this.f59945f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = a.this.f59965a.f59987b;
                float f5 = this.f59946g;
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
                a.this.f59965a.f59987b.setScaleX(1.0f);
                a.this.f59965a.f59987b.setScaleY(1.0f);
                a.this.f59965a.f59987b.setTranslationX(0.0f);
                a.this.f59965a.f59987b.setTranslationY(0.0f);
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
            float min = Math.min(269.0f / a.this.f59965a.f59987b.getWidth(), 141.0f / a.this.f59965a.f59987b.getHeight());
            float left = 516.0f - ((a.this.f59965a.f59987b.getLeft() + a.this.f59965a.f59987b.getRight()) / 2.0f);
            float top = 529.0f - ((a.this.f59965a.f59987b.getTop() + a.this.f59965a.f59987b.getBottom()) / 2.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1483a(min, left, top));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f59949e;

        /* renamed from: d.b.j0.q0.m2.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1484a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59951e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59952f;

            public C1484a(float f2, float f3) {
                this.f59951e = f2;
                this.f59952f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = a.this.f59965a.f59990e;
                    float f2 = this.f59951e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = a.this.f59965a.f59990e;
                    float f3 = this.f59952f;
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
                a.this.f59965a.f59990e.setTranslationX(0.0f);
                a.this.f59965a.f59990e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f59949e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1484a(this.f59949e.left - a.this.f59965a.f59990e.getLeft(), this.f59949e.top - a.this.f59965a.f59990e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f59955e;

        /* renamed from: d.b.j0.q0.m2.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1485a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f59957e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f59958f;

            public C1485a(float f2, float f3) {
                this.f59957e = f2;
                this.f59958f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = a.this.f59965a.f59989d;
                    float f2 = this.f59957e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = a.this.f59965a.f59989d;
                    float f3 = this.f59958f;
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
                a.this.f59965a.f59989d.setTranslationX(0.0f);
                a.this.f59965a.f59989d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f59955e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1485a(this.f59955e.left - a.this.f59965a.f59989d.getLeft(), this.f59955e.top - a.this.f59965a.f59989d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: d.b.j0.q0.m2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1486a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f59962e;

            public C1486a(int i) {
                this.f59962e = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = a.this.f59965a.f59992g;
                    int i = this.f59962e;
                    linearLayout.setTranslationY(i - (i * floatValue));
                    a.this.f59965a.f59992g.setAlpha((floatValue / 2.0f) + 0.5f);
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
                a.this.f59965a.f59992g.setAlpha(1.0f);
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
            ofFloat.addUpdateListener(new C1486a(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public a(d.b.j0.q0.m2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.b.j0.q0.m2.b
    public void c() {
        if (this.f59967c != 2) {
            return;
        }
        this.f59967c = 3;
        b.a aVar = this.f59968d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f59938f.start();
    }

    @Override // d.b.j0.q0.m2.b
    public void d() {
        if (this.f59967c != 0) {
            return;
        }
        this.f59967c = 1;
        b.a aVar = this.f59968d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f59937e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f59966b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f59965a.f59988c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        String stringExtra = this.f59966b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f59965a.j.W(stringExtra, 10, false);
        }
        this.f59965a.f59987b.post(new e());
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f59966b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f59966b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f59965a.f59989d.W(stringExtra, 10, false);
        this.f59965a.f59989d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f59966b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f59966b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f59965a.f59990e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f59965a.f59990e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f59966b == null || (linearLayout = this.f59965a.f59992g) == null) {
            return;
        }
        linearLayout.post(new h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f59937e = ofFloat;
        ofFloat.setDuration(270L);
        this.f59937e.addUpdateListener(new C1482a());
        this.f59937e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f59938f = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f59938f.addUpdateListener(new c());
        this.f59938f.addListener(new d());
    }
}
