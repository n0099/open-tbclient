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
import com.kuaishou.weapon.un.w0;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.reward.d.d;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bb;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends d implements View.OnClickListener {
    public final ViewGroup a;
    public int[] b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public Button h;
    @Nullable
    public b i;

    /* renamed from: com.kwad.sdk.reward.kwai.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ AdTemplate a;
        public final /* synthetic */ long b;

        public AnonymousClass1(AdTemplate adTemplate, long j) {
            this.a = adTemplate;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            final Animator a = aVar.a(aVar.c);
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.kwai.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.removeListener(this);
                    com.kwad.sdk.core.report.a.c(AnonymousClass1.this.a, w0.w, null);
                    a aVar2 = a.this;
                    aVar2.a(aVar2.d, AnonymousClass1.this.b).start();
                    ax.a(new Runnable() { // from class: com.kwad.sdk.reward.kwai.a.1.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.b();
                        }
                    }, null, AnonymousClass1.this.b);
                }
            });
            a.start();
        }
    }

    /* renamed from: com.kwad.sdk.reward.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0343a {
        public CharSequence a;
        public CharSequence b;
        public CharSequence c;
        public CharSequence d;

        public C0343a(@NonNull CouponInfo couponInfo) {
            this.a = couponInfo.displayTitle;
            this.b = couponInfo.displayValue;
            this.c = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.d = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0343a a(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo aK = com.kwad.sdk.core.response.a.a.aK(com.kwad.sdk.core.response.a.d.j(adTemplate));
            if (aK == null || (list = aK.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(aK.couponList.get(0));
        }

        @Nullable
        public static C0343a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0343a(couponInfo);
        }

        public CharSequence a() {
            return this.a;
        }

        public CharSequence a(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035d));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.b));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public CharSequence b() {
            return this.c;
        }

        public CharSequence c() {
            return this.d;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.b = iArr;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0442, viewGroup, false);
        this.a = viewGroup2;
        a(context, viewGroup2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_Y, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator a(ImageView imageView, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, AnimationProperty.OPACITY, imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.c = viewGroup.findViewById(R.id.obfuscated_res_0x7f091018);
        this.d = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091016);
        this.e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09101b);
        this.f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091019);
        this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09101a);
        Button button = (Button) viewGroup.findViewById(R.id.obfuscated_res_0x7f091017);
        this.h = button;
        button.setOnClickListener(this);
    }

    private void a(C0343a c0343a) {
        if (c0343a == null) {
            return;
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(c0343a.a());
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText(c0343a.a(this.a.getContext()));
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setText(c0343a.b());
        }
        Button button = this.h;
        if (button != null) {
            button.setText(c0343a.c());
        }
    }

    private Animator b(View view2) {
        ObjectAnimator objectAnimator;
        int[] c;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_Y, 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.b;
        ObjectAnimator objectAnimator2 = null;
        if (iArr == null || iArr.length < 2 || (c = bb.c(view2)) == null) {
            objectAnimator = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view2, AnimationProperty.TRANSLATE_X, this.b[0] - c[0]);
            objectAnimator = ObjectAnimator.ofFloat(view2, AnimationProperty.TRANSLATE_Y, this.b[1] - c[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, AnimationProperty.OPACITY, 1.0f, 0.0f);
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
        final Animator b2 = b(this.c);
        b2.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.reward.kwai.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b2.removeListener(this);
                if (a.this.i != null) {
                    a.this.i.b();
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
        a(C0343a.a(adTemplate));
        this.a.post(new AnonymousClass1(adTemplate, com.kwad.sdk.core.config.b.aN()));
    }

    public void a(@Nullable b bVar) {
        this.i = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        b bVar;
        if (!view2.equals(this.h) || (bVar = this.i) == null) {
            return;
        }
        bVar.a();
    }
}
