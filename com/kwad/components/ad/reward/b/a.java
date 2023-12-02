package com.kwad.components.ad.reward.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
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
import com.kwad.components.ad.reward.n.d;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.bn;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a extends d implements View.OnClickListener {
    public final ViewGroup gS;
    public TextView hz;
    public TextView lv;
    public int[] qK;
    public View qL;
    public ImageView qM;
    public TextView qN;
    public Button qO;
    @Nullable
    public b qP;

    /* loaded from: classes10.dex */
    public interface b {
        void gH();

        void gI();
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public class AnonymousClass1 implements Runnable {
        public final /* synthetic */ r qQ;
        public final /* synthetic */ long qR;

        public AnonymousClass1(r rVar, long j) {
            this.qQ = rVar;
            this.qR = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            final Animator a = a.a(aVar, aVar.qL);
            a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.1.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    a.removeListener(this);
                    com.kwad.sdk.core.report.a.b(AnonymousClass1.this.qQ.getAdTemplate(), 169, (JSONObject) null);
                    a aVar2 = a.this;
                    a.a(aVar2, aVar2.qM, AnonymousClass1.this.qR).start();
                    bn.a(new Runnable() { // from class: com.kwad.components.ad.reward.b.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.gE();
                        }
                    }, null, AnonymousClass1.this.qR);
                }
            });
            a.start();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0610a {
        public CharSequence qX;
        public CharSequence qY;
        public CharSequence qZ;
        public CharSequence title;

        public C0610a(@NonNull CouponInfo couponInfo) {
            this.title = couponInfo.displayTitle;
            this.qX = couponInfo.displayValue;
            if (!TextUtils.isEmpty(couponInfo.displayBase)) {
                this.qY = String.format("满%s可用", couponInfo.displayBase);
            } else {
                this.qY = "";
            }
            this.qZ = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0610a H(AdTemplate adTemplate) {
            List<CouponInfo> list;
            AdProductInfo cM = com.kwad.sdk.core.response.b.a.cM(e.dP(adTemplate));
            if (cM != null && (list = cM.couponList) != null && list.size() > 0) {
                return a(cM.couponList.get(0));
            }
            return null;
        }

        @Nullable
        public static C0610a a(CouponInfo couponInfo) {
            if (couponInfo == null) {
                return null;
            }
            return new C0610a(couponInfo);
        }

        public final CharSequence L(Context context) {
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07049a));
            SpannableString spannableString = new SpannableString("¥" + ((Object) this.qX));
            spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
            return spannableString;
        }

        public final CharSequence gF() {
            return this.qY;
        }

        public final CharSequence gG() {
            return this.qZ;
        }

        public final CharSequence getTitle() {
            return this.title;
        }
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        this.qK = iArr;
        ViewGroup viewGroup2 = (ViewGroup) l.a(context, R.layout.obfuscated_res_0x7f0d04fe, viewGroup, false);
        this.gS = viewGroup2;
        d(viewGroup2);
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    public static Animator a(ImageView imageView, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ALPHA, imageView.getAlpha(), 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    public static /* synthetic */ Animator a(a aVar, View view2) {
        return m(view2);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        b bVar;
        if (view2.equals(this.qO) && (bVar = this.qP) != null) {
            bVar.gH();
        }
    }

    private void a(C0610a c0610a) {
        if (c0610a == null) {
            return;
        }
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(c0610a.getTitle());
        }
        TextView textView2 = this.qN;
        if (textView2 != null) {
            textView2.setText(c0610a.L(this.gS.getContext()));
        }
        TextView textView3 = this.lv;
        if (textView3 != null) {
            textView3.setText(c0610a.gF());
        }
        Button button = this.qO;
        if (button != null) {
            button.setText(c0610a.gG());
        }
    }

    private void d(ViewGroup viewGroup) {
        this.qL = viewGroup.findViewById(R.id.obfuscated_res_0x7f091340);
        this.qM = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09133e);
        this.hz = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091343);
        this.qN = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091341);
        this.lv = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091342);
        Button button = (Button) viewGroup.findViewById(R.id.obfuscated_res_0x7f09133f);
        this.qO = button;
        button.setOnClickListener(this);
    }

    public static Animator m(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(300L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE() {
        final Animator n = n(this.qL);
        n.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.b.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                n.removeListener(this);
                if (a.this.qP != null) {
                    a.this.qP.gI();
                }
            }
        });
        n.start();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gD() {
        return this.gS;
    }

    private Animator n(View view2) {
        ObjectAnimator objectAnimator;
        int[] E;
        Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, 0.0f);
        ofFloat.setInterpolator(create);
        ofFloat2.setInterpolator(create);
        int[] iArr = this.qK;
        ObjectAnimator objectAnimator2 = null;
        if (iArr != null && iArr.length >= 2 && (E = com.kwad.sdk.d.a.a.E(view2)) != null) {
            Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
            objectAnimator2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, this.qK[0] - E[0]);
            objectAnimator = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, this.qK[1] - E[1]);
            objectAnimator2.setInterpolator(create2);
            objectAnimator.setInterpolator(create2);
        } else {
            objectAnimator = null;
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
        this.qP = bVar;
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(C0610a.H(rVar.getAdTemplate()));
        this.gS.post(new AnonymousClass1(rVar, com.kwad.components.ad.reward.a.b.gw()));
    }
}
