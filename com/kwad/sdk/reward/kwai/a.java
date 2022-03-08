package com.kwad.sdk.reward.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.reward.d.d;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends d implements View.OnClickListener {
    public final ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f55863b;

    /* renamed from: c  reason: collision with root package name */
    public View f55864c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f55865d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55866e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55867f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55868g;

    /* renamed from: h  reason: collision with root package name */
    public Button f55869h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public b f55870i;

    /* renamed from: com.kwad.sdk.reward.kwai.a$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ AdTemplate a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f55871b;

        public AnonymousClass1(AdTemplate adTemplate, long j2) {
            this.a = adTemplate;
            this.f55871b = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            final Animator a = aVar.a(aVar.f55864c);
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.kwai.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.removeListener(this);
                    com.kwad.sdk.core.report.a.c(AnonymousClass1.this.a, 169, null);
                    a aVar2 = a.this;
                    aVar2.a(aVar2.f55865d, AnonymousClass1.this.f55871b).start();
                    ax.a(new Runnable() { // from class: com.kwad.sdk.reward.kwai.a.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.b();
                        }
                    }, null, AnonymousClass1.this.f55871b);
                }
            });
            a.start();
        }
    }

    /* renamed from: com.kwad.sdk.reward.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2134a {
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f55875b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f55876c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f55877d;

        public C2134a(@NonNull CouponInfo couponInfo) {
            this.a = couponInfo.displayTitle;
            this.f55875b = couponInfo.displayValue;
            this.f55876c = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.f55877d = couponInfo.displayActionWords;
        }

        @Nullable
        public static C2134a a(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.j(adTemplate));
            if (aK == null || (list = aK.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(aK.couponList.get(0));
        }

        @Nullable
        public static C2134a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C2134a(couponInfo);
        }

        public CharSequence a() {
            return this.a;
        }

        public CharSequence a(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.ksad_coupon_dialog_value_prefix_text_size));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.f55875b));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public CharSequence b() {
            return this.f55876c;
        }

        public CharSequence c() {
            return this.f55877d;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();

        void b();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.f55863b = iArr;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ksad_reward_coupon_dialog, viewGroup, false);
        this.a = viewGroup2;
        a(context, viewGroup2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_Y, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(ImageView imageView, long j2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, AnimationProperty.OPACITY, imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j2);
        return ofFloat;
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.f55864c = viewGroup.findViewById(R.id.ksad_coupon_dialog_card);
        this.f55865d = (ImageView) viewGroup.findViewById(R.id.ksad_coupon_dialog_bg);
        this.f55866e = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_title);
        this.f55867f = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_content);
        this.f55868g = (TextView) viewGroup.findViewById(R.id.ksad_coupon_dialog_desc);
        Button button = (Button) viewGroup.findViewById(R.id.ksad_coupon_dialog_btn_action);
        this.f55869h = button;
        button.setOnClickListener(this);
    }

    private void a(C2134a c2134a) {
        if (c2134a == null) {
            return;
        }
        TextView textView = this.f55866e;
        if (textView != null) {
            textView.setText(c2134a.a());
        }
        TextView textView2 = this.f55867f;
        if (textView2 != null) {
            textView2.setText(c2134a.a(this.a.getContext()));
        }
        TextView textView3 = this.f55868g;
        if (textView3 != null) {
            textView3.setText(c2134a.b());
        }
        Button button = this.f55869h;
        if (button != null) {
            button.setText(c2134a.c());
        }
    }

    private Animator b(View view) {
        ObjectAnimator objectAnimator;
        int[] c2;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, AnimationProperty.SCALE_Y, 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.f55863b;
        ObjectAnimator objectAnimator2 = null;
        if (iArr == null || iArr.length < 2 || (c2 = bb.c(view)) == null) {
            objectAnimator = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_X, this.f55863b[0] - c2[0]);
            objectAnimator = ObjectAnimator.ofFloat(view, AnimationProperty.TRANSLATE_Y, this.f55863b[1] - c2[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, AnimationProperty.OPACITY, 1.0f, 0.0f);
        ofFloat4.setDuration(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat3, ofFloat4);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        if (objectAnimator2 != null) {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet, objectAnimator2, objectAnimator);
        } else {
            animatorSet2.playTogether(ofFloat, ofFloat2, animatorSet);
        }
        return animatorSet2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        final Animator b2 = b(this.f55864c);
        b2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.kwai.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b2.removeListener(this);
                if (a.this.f55870i != null) {
                    a.this.f55870i.b();
                }
            }
        });
        b2.start();
    }

    @Override // com.kwad.sdk.reward.d.d
    public ViewGroup a() {
        return this.a;
    }

    @Override // com.kwad.sdk.reward.d.d
    public void a(AdTemplate adTemplate) {
        super.a(adTemplate);
        a(C2134a.a(adTemplate));
        this.a.post(new AnonymousClass1(adTemplate, com.kwad.sdk.core.config.b.aN()));
    }

    public void a(@Nullable b bVar) {
        this.f55870i = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        if (!view.equals(this.f55869h) || (bVar = this.f55870i) == null) {
            return;
        }
        bVar.a();
    }
}
