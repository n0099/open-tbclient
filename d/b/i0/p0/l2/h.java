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
public class h extends d.b.i0.p0.l2.b {

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f57864e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f57865f;

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator.isRunning()) {
                h.this.f57834a.f57855a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f57834a.f57855a.setAlpha(1.0f);
            h hVar = h.this;
            hVar.f57836c = 2;
            b.a aVar = hVar.f57837d;
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
                h.this.f57834a.f57855a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            h.this.f57834a.f57855a.setAlpha(0.0f);
            h hVar = h.this;
            hVar.f57836c = 0;
            b.a aVar = hVar.f57837d;
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
        public final /* synthetic */ Rect f57870e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57872e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57873f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ float f57874g;

            public a(float f2, float f3, float f4) {
                this.f57872e = f2;
                this.f57873f = f3;
                this.f57874g = f4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout relativeLayout = h.this.f57834a.f57856b;
                float f2 = this.f57872e;
                relativeLayout.setScaleX(f2 + ((1.0f - f2) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout2 = h.this.f57834a.f57856b;
                float f3 = this.f57872e;
                relativeLayout2.setScaleY(f3 + ((1.0f - f3) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
                RelativeLayout relativeLayout3 = h.this.f57834a.f57856b;
                float f4 = this.f57873f;
                relativeLayout3.setTranslationX(f4 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f4));
                RelativeLayout relativeLayout4 = h.this.f57834a.f57856b;
                float f5 = this.f57874g;
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
                h.this.f57834a.f57856b.setScaleX(1.0f);
                h.this.f57834a.f57856b.setScaleY(1.0f);
                h.this.f57834a.f57856b.setTranslationX(0.0f);
                h.this.f57834a.f57856b.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public e(Rect rect) {
            this.f57870e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(Math.min((this.f57870e.width() * 1.0f) / h.this.f57834a.f57856b.getWidth(), (this.f57870e.height() * 1.0f) / h.this.f57834a.f57856b.getHeight()), this.f57870e.centerX() - ((h.this.f57834a.f57856b.getLeft() + h.this.f57834a.f57856b.getRight()) / 2.0f), this.f57870e.centerY() - ((h.this.f57834a.f57856b.getTop() + h.this.f57834a.f57856b.getBottom()) / 2.0f)));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f57877e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57879e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57880f;

            public a(float f2, float f3) {
                this.f57879e = f2;
                this.f57880f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    TextView textView = h.this.f57834a.f57859e;
                    float f2 = this.f57879e;
                    textView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    TextView textView2 = h.this.f57834a.f57859e;
                    float f3 = this.f57880f;
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
                h.this.f57834a.f57859e.setTranslationX(0.0f);
                h.this.f57834a.f57859e.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public f(Rect rect) {
            this.f57877e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f57877e.left - h.this.f57834a.f57859e.getLeft(), this.f57877e.top - h.this.f57834a.f57859e.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f57883e;

        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f57885e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f57886f;

            public a(float f2, float f3) {
                this.f57885e = f2;
                this.f57886f = f3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    BarImageView barImageView = h.this.f57834a.f57858d;
                    float f2 = this.f57885e;
                    barImageView.setTranslationX(f2 - (((Float) valueAnimator.getAnimatedValue()).floatValue() * f2));
                    BarImageView barImageView2 = h.this.f57834a.f57858d;
                    float f3 = this.f57886f;
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
                h.this.f57834a.f57858d.setTranslationX(0.0f);
                h.this.f57834a.f57858d.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public g(Rect rect) {
            this.f57883e = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(220L);
            ofFloat.addUpdateListener(new a(this.f57883e.left - h.this.f57834a.f57858d.getLeft(), this.f57883e.top - h.this.f57834a.f57858d.getTop()));
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    /* renamed from: d.b.i0.p0.l2.h$h  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1400h implements Runnable {

        /* renamed from: d.b.i0.p0.l2.h$h$a */
        /* loaded from: classes4.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f57890e;

            public a(int i) {
                this.f57890e = i;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LinearLayout linearLayout = h.this.f57834a.f57861g;
                    int i = this.f57890e;
                    linearLayout.setTranslationY(i - (i * floatValue));
                    h.this.f57834a.f57861g.setAlpha((floatValue / 2.0f) + 0.5f);
                }
            }
        }

        /* renamed from: d.b.i0.p0.l2.h$h$b */
        /* loaded from: classes4.dex */
        public class b implements Animator.AnimatorListener {
            public b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.f57834a.f57861g.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public RunnableC1400h() {
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

    public h(d.b.i0.p0.l2.g gVar, Intent intent) {
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
        this.f57865f.start();
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
        this.f57864e.start();
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
        Rect rect = (Rect) this.f57835b.getParcelableExtra("info_forum_head_background_rect");
        if (rect == null) {
            return;
        }
        String stringExtra = this.f57835b.getStringExtra("info_forum_head_background_vector");
        if (!k.isEmpty(stringExtra)) {
            this.f57834a.j.W(stringExtra, 10, false);
        }
        this.f57834a.f57856b.post(new e(rect));
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
        linearLayout.post(new RunnableC1400h());
    }

    public final void i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f57864e = ofFloat;
        ofFloat.setDuration(270L);
        this.f57864e.addUpdateListener(new a());
        this.f57864e.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f57865f = ofFloat2;
        ofFloat2.setDuration(800L);
        this.f57865f.addUpdateListener(new c());
        this.f57865f.addListener(new d());
    }
}
