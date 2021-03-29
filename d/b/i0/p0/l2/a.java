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
    public ValueAnimator f57807e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f57808f;

    /* renamed from: d.b.i0.p0.l2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1396a implements ValueAnimator.AnimatorUpdateListener {
        public C1396a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                a.this.f57835a.f57856a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f57835a.f57856a.setAlpha(1.0f);
            a aVar = a.this;
            aVar.f57837c = 2;
            b.a aVar2 = aVar.f57838d;
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
                a.this.f57835a.f57856a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            a.this.f57835a.f57856a.setAlpha(0.0f);
            a aVar = a.this;
            aVar.f57837c = 0;
            b.a aVar2 = aVar.f57838d;
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
        public class C1397a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57814e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57815f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f57816g;

            public C1397a(float f2, float f3, float f4) {
                this.f57814e = f2;
                this.f57815f = f3;
                this.f57816g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = a.this.f57835a.f57857b;
                float f2 = this.f57814e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = a.this.f57835a.f57857b;
                float f3 = this.f57814e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = a.this.f57835a.f57857b;
                float f4 = this.f57815f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = a.this.f57835a.f57857b;
                float f5 = this.f57816g;
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
                a.this.f57835a.f57857b.setScaleX(1.0f);
                a.this.f57835a.f57857b.setScaleY(1.0f);
                a.this.f57835a.f57857b.setTranslationX(0.0f);
                a.this.f57835a.f57857b.setTranslationY(0.0f);
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
            float min = Math.min(269.0f / a.this.f57835a.f57857b.getWidth(), 141.0f / a.this.f57835a.f57857b.getHeight());
            float left = 516.0f - ((a.this.f57835a.f57857b.getLeft() + a.this.f57835a.f57857b.getRight()) / 2.0f);
            float top = 529.0f - ((a.this.f57835a.f57857b.getTop() + a.this.f57835a.f57857b.getBottom()) / 2.0f);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1397a(min, left, top));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f57819e;

        /* renamed from: d.b.i0.p0.l2.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1398a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57821e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57822f;

            public C1398a(float f2, float f3) {
                this.f57821e = f2;
                this.f57822f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = a.this.f57835a.f57860e;
                    float f2 = this.f57821e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = a.this.f57835a.f57860e;
                    float f3 = this.f57822f;
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
                a.this.f57835a.f57860e.setTranslationX(0.0f);
                a.this.f57835a.f57860e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f57819e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1398a(this.f57819e.left - a.this.f57835a.f57860e.getLeft(), this.f57819e.top - a.this.f57835a.f57860e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f57825e;

        /* renamed from: d.b.i0.p0.l2.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1399a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57827e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57828f;

            public C1399a(float f2, float f3) {
                this.f57827e = f2;
                this.f57828f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = a.this.f57835a.f57859d;
                    float f2 = this.f57827e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = a.this.f57835a.f57859d;
                    float f3 = this.f57828f;
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
                a.this.f57835a.f57859d.setTranslationX(0.0f);
                a.this.f57835a.f57859d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f57825e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new C1399a(this.f57825e.left - a.this.f57835a.f57859d.getLeft(), this.f57825e.top - a.this.f57835a.f57859d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {

        /* renamed from: d.b.i0.p0.l2.a$h$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1400a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f57832e;

            public C1400a(int i) {
                this.f57832e = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = a.this.f57835a.f57862g;
                    int i = this.f57832e;
                    linearLayout.setTranslationY(i - (i * floatValue));
                    a.this.f57835a.f57862g.setAlpha((floatValue / 2.0f) + 0.5f);
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
                a.this.f57835a.f57862g.setAlpha(1.0f);
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
            ofFloat.addUpdateListener(new C1400a(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds160)));
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
        if (this.f57837c != 2) {
            return;
        }
        this.f57837c = 3;
        b.a aVar = this.f57838d;
        if (aVar != null) {
            aVar.onStateChanged(3);
        }
        this.f57808f.start();
    }

    @Override // d.b.i0.p0.l2.b
    public void d() {
        if (this.f57837c != 0) {
            return;
        }
        this.f57837c = 1;
        b.a aVar = this.f57838d;
        if (aVar != null) {
            aVar.onStateChanged(1);
        }
        this.f57807e.start();
        f();
        g();
        e();
        h();
    }

    public final void e() {
        Intent intent = this.f57836b;
        if (intent == null) {
            return;
        }
        ArrayList<Integer> integerArrayListExtra = intent.getIntegerArrayListExtra("info_forum_head_background_color");
        if (integerArrayListExtra != null && integerArrayListExtra.size() == 6) {
            this.f57835a.f57858c.setGradientColor(integerArrayListExtra.get(0).intValue(), integerArrayListExtra.get(1).intValue(), integerArrayListExtra.get(2).intValue(), integerArrayListExtra.get(3).intValue(), integerArrayListExtra.get(4).intValue(), integerArrayListExtra.get(5).intValue());
        }
        String stringExtra = this.f57836b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f57835a.j.W(stringExtra, 10, false);
        }
        this.f57835a.f57857b.post(new e());
    }

    public final void f() {
        Rect rect;
        Intent intent = this.f57836b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_image_rect")) == null) {
            return;
        }
        String stringExtra = this.f57836b.getStringExtra("info_forum_image_url");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f57835a.f57859d.W(stringExtra, 10, false);
        this.f57835a.f57859d.post(new g(rect));
    }

    public final void g() {
        Rect rect;
        Intent intent = this.f57836b;
        if (intent == null || (rect = (Rect) intent.getParcelableExtra("info_forum_name_rect")) == null) {
            return;
        }
        String stringExtra = this.f57836b.getStringExtra("info_forum_name_text");
        if (k.isEmpty(stringExtra)) {
            return;
        }
        this.f57835a.f57860e.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.chosen_pb_original_bar), stringExtra));
        this.f57835a.f57860e.post(new f(rect));
    }

    public final void h() {
        LinearLayout linearLayout;
        if (this.f57836b == null || (linearLayout = this.f57835a.f57862g) == null) {
            return;
        }
        linearLayout.post(new h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f57807e = ofFloat;
        ofFloat.setDuration(270L);
        this.f57807e.addUpdateListener(new C1396a());
        this.f57807e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f57808f = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f57808f.addUpdateListener(new c());
        this.f57808f.addListener(new d());
    }
}
