package com.kwad.components.ad.reward.a;

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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.bd;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends d implements View.OnClickListener {
    public TextView eQ;
    public final ViewGroup es;
    public TextView iu;
    public int[] oi;
    public View oj;
    public ImageView ok;
    public TextView ol;
    public Button om;
    @Nullable
    public b on;

    /* renamed from: com.kwad.components.ad.reward.a.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ u oo;
        public final /* synthetic */ long op;

        public AnonymousClass1(u uVar, long j) {
            this.oo = uVar;
            this.op = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            final Animator a = a.a(aVar, aVar.oj);
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.a.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.removeListener(this);
                    com.kwad.sdk.core.report.a.c(AnonymousClass1.this.oo.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.ok, AnonymousClass1.this.op).start();
                    bd.a(new Runnable() { // from class: com.kwad.components.ad.reward.a.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.gk();
                        }
                    }, null, AnonymousClass1.this.op);
                }
            });
            a.start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0618a {
        public CharSequence ov;
        public CharSequence ow;
        public CharSequence ox;
        public CharSequence title;

        public C0618a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.ov = couponInfo.displayValue;
            this.ow = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.ox = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0618a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0618a(couponInfo);
        }

        @Nullable
        public static C0618a u(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
            if (bN == null || (list = bN.couponList) == null || list.size() <= 0) {
                return null;
            }
            return a(bN.couponList.get(0));
        }

        public final CharSequence N(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070499));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.ov));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final CharSequence gl() {
            return this.ow;
        }

        public final CharSequence gm() {
            return this.ox;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void gn();

        void go();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.oi = iArr;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04c9, viewGroup, false);
        this.es = viewGroup2;
        d(viewGroup2);
    }

    public static Animator a(ImageView imageView, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ALPHA, imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public static /* synthetic */ Animator a(a aVar, View view2) {
        return l(view2);
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    private void a(C0618a c0618a) {
        if (c0618a == null) {
            return;
        }
        TextView textView = this.eQ;
        if (textView != null) {
            textView.setText(c0618a.getTitle());
        }
        TextView textView2 = this.ol;
        if (textView2 != null) {
            textView2.setText(c0618a.N(this.es.getContext()));
        }
        TextView textView3 = this.iu;
        if (textView3 != null) {
            textView3.setText(c0618a.gl());
        }
        Button button = this.om;
        if (button != null) {
            button.setText(c0618a.gm());
        }
    }

    private void d(ViewGroup viewGroup) {
        this.oj = viewGroup.findViewById(R.id.obfuscated_res_0x7f091284);
        this.ok = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091282);
        this.eQ = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091287);
        this.ol = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091285);
        this.iu = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091286);
        Button button = (Button) viewGroup.findViewById(R.id.obfuscated_res_0x7f091283);
        this.om = button;
        button.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk() {
        final Animator m = m(this.oj);
        m.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.a.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                m.removeListener(this);
                if (a.this.on != null) {
                    a.this.on.go();
                }
            }
        });
        m.start();
    }

    public static Animator l(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private Animator m(View view2) {
        ObjectAnimator objectAnimator;
        int[] z;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.oi;
        ObjectAnimator objectAnimator2 = null;
        if (iArr == null || iArr.length < 2 || (z = com.kwad.sdk.b.kwai.a.z(view2)) == null) {
            objectAnimator = null;
        } else {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, this.oi[0] - z[0]);
            objectAnimator = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, this.oi[1] - z[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 1.0f);
        ofFloat3.setDuration(200L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
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

    public final void a(@Nullable b bVar) {
        this.on = bVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        super.a(uVar);
        a(C0618a.u(uVar.getAdTemplate()));
        this.es.post(new AnonymousClass1(uVar, com.kwad.components.ad.reward.kwai.b.ge()));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        return this.es;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        b bVar;
        if (!view2.equals(this.om) || (bVar = this.on) == null) {
            return;
        }
        bVar.gn();
    }
}
