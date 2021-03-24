package d.b.i0.p0.l2;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.p0.l2.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a extends d.b.i0.p0.l2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f57806e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f57807f;

    /* renamed from: d.b.i0.p0.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1395a implements ValueAnimator.AnimatorUpdateListener {
        public C1395a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                a.this.f57834a.f57855a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f57834a.f57855a.setAlpha(1.0f);
            a aVar = a.this;
            aVar.f57836c = 2;
            b.a aVar2 = aVar.f57837d;
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
                a.this.f57834a.f57855a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f57834a.f57855a.setAlpha(0.0f);
            a aVar = a.this;
            aVar.f57836c = 0;
            b.a aVar2 = aVar.f57837d;
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

        /* renamed from: d.b.i0.p0.l2.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1396a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57813e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57814f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f57815g;

            public C1396a(float f2, float f3, float f4) {
                this.f57813e = f2;
                this.f57814f = f3;
                this.f57815g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = a.this.f57834a.f57856b;
                float f2 = this.f57813e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = a.this.f57834a.f57856b;
                float f3 = this.f57813e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = a.this.f57834a.f57856b;
                float f4 = this.f57814f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = a.this.f57834a.f57856b;
                float f5 = this.f57815g;
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
                a.this.f57834a.f57856b.setScaleX(1.0f);
                a.this.f57834a.f57856b.setScaleY(1.0f);
                a.this.f57834a.f57856b.setTranslationX(0.0f);
                a.this.f57834a.f57856b.setTranslationY(0.0f);
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
            float min = Math.min(269.0f / a.this.f57834a.f57856b.getWidth(), 141.0f / a.this.f57834a.f57856b.getHeight());
            float left = 516.0f - ((a.this.f57834a.f57856b.getLeft() + a.this.f57834a.f57856b.getRight()) / 2.0f);
            float top = 529.0f - ((a.this.f57834a.f57856b.getTop() + a.this.f57834a.f57856b.getBottom()) / 2.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1396a(min, left, top));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f57818e;

        /* renamed from: d.b.i0.p0.l2.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1397a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57820e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57821f;

            public C1397a(float f2, float f3) {
                this.f57820e = f2;
                this.f57821f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = a.this.f57834a.f57859e;
                    float f2 = this.f57820e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = a.this.f57834a.f57859e;
                    float f3 = this.f57821f;
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
                a.this.f57834a.f57859e.setTranslationX(0.0f);
                a.this.f57834a.f57859e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f57818e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1397a(this.f57818e.left - a.this.f57834a.f57859e.getLeft(), this.f57818e.top - a.this.f57834a.f57859e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f57824e;

        /* renamed from: d.b.i0.p0.l2.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1398a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57826e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57827f;

            public C1398a(float f2, float f3) {
                this.f57826e = f2;
                this.f57827f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = a.this.f57834a.f57858d;
                    float f2 = this.f57826e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = a.this.f57834a.f57858d;
                    float f3 = this.f57827f;
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
                a.this.f57834a.f57858d.setTranslationX(0.0f);
                a.this.f57834a.f57858d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f57824e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1398a(this.f57824e.left - a.this.f57834a.f57858d.getLeft(), this.f57824e.top - a.this.f57834a.f57858d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: d.b.i0.p0.l2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1399a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f57831e;

            public C1399a(int i) {
                this.f57831e = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = a.this.f57834a.f57861g;
                    int i = this.f57831e;
                    linearLayout.setTranslationY(i - (i * floatValue));
                    a.this.f57834a.f57861g.setAlpha((floatValue / 2.0f) + 0.5f);
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
                a.this.f57834a.f57861g.setAlpha(1.0f);
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
            ofFloat.addUpdateListener(new C1399a(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public a(d.b.i0.p0.l2.g gVar, Intent intent) {
        super(gVar, intent);
        i();
    }

    @Override // d.b.i0.p0.l2.b
    public void c() {
        if (this.f57836c != 2) {
            return;
        }
        this.f57836c = 3;
        b.a aVar = this.f57837d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f57807f.start();
    }

    @Override // d.b.i0.p0.l2.b
    public void d() {
        if (this.f57836c != 0) {
            return;
        }
        this.f57836c = 1;
        b.a aVar = this.f57837d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f57806e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f57835b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f57834a.f57857c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        String stringExtra = this.f57835b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f57834a.j.W(stringExtra, 10, false);
        }
        this.f57834a.f57856b.post(new e());
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f57835b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f57835b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f57834a.f57858d.W(stringExtra, 10, false);
        this.f57834a.f57858d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f57835b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f57835b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f57834a.f57859e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f57834a.f57859e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f57835b == null || (linearLayout = this.f57834a.f57861g) == null) {
            return;
        }
        linearLayout.post(new h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f57806e = ofFloat;
        ofFloat.setDuration(270L);
        this.f57806e.addUpdateListener(new C1395a());
        this.f57806e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f57807f = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f57807f.addUpdateListener(new c());
        this.f57807f.addListener(new d());
    }
}
