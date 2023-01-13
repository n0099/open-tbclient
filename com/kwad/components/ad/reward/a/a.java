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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k.d;
import com.kwad.components.ad.reward.k.u;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.bd;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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
    /* loaded from: classes8.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u oo;
        public final /* synthetic */ long op;
        public final /* synthetic */ a oq;

        public AnonymousClass1(a aVar, u uVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, uVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.oq = aVar;
            this.oo = uVar;
            this.op = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.oq;
                Animator a = a.a(aVar, aVar.oj);
                a.addListener(new AnimatorListenerAdapter(this, a) { // from class: com.kwad.components.ad.reward.a.a.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Animator or;
                    public final /* synthetic */ AnonymousClass1 os;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, a};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.os = this;
                        this.or = a;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                            this.or.removeListener(this);
                            com.kwad.sdk.core.report.a.c(this.os.oo.getAdTemplate(), 169, (JSONObject) null);
                            a aVar2 = this.os.oq;
                            a.a(aVar2, aVar2.ok, this.os.op).start();
                            bd.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.a.a.1.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ C05631 ot;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.ot = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.ot.os.oq.gk();
                                    }
                                }
                            }, null, this.os.op);
                        }
                    }
                });
                a.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0565a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence ov;
        public CharSequence ow;
        public CharSequence ox;
        public CharSequence title;

        public C0565a(@NonNull CouponInfo couponInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {couponInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.title = couponInfo.displayTitle;
            this.ov = couponInfo.displayValue;
            this.ow = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.ox = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0565a a(CouponInfo couponInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, couponInfo)) == null) {
                if (couponInfo == null) {
                    return null;
                }
                return new C0565a(couponInfo);
            }
            return (C0565a) invokeL.objValue;
        }

        @Nullable
        public static C0565a u(AdTemplate adTemplate) {
            InterceptResult invokeL;
            List<CouponInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
                if (bN == null || (list = bN.couponList) == null || list.size() <= 0) {
                    return null;
                }
                return a(bN.couponList.get(0));
            }
            return (C0565a) invokeL.objValue;
        }

        public final CharSequence N(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035b));
                SpannableString spannableString = new SpannableString("¥" + ((Object) this.ov));
                spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
                return spannableString;
            }
            return (CharSequence) invokeL.objValue;
        }

        public final CharSequence getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.title : (CharSequence) invokeV.objValue;
        }

        public final CharSequence gl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ow : (CharSequence) invokeV.objValue;
        }

        public final CharSequence gm() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ox : (CharSequence) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void gn();

        void go();
    }

    public a(Context context, @Nullable ViewGroup viewGroup, @Nullable int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, iArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.oi = iArr;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d046e, viewGroup, false);
        this.es = viewGroup2;
        d(viewGroup2);
    }

    public static Animator a(ImageView imageView, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, imageView, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, Key.ALPHA, imageView.getAlpha(), 0.0f);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (Animator) invokeLJ.objValue;
    }

    public static /* synthetic */ Animator a(a aVar, View view2) {
        return l(view2);
    }

    public static /* synthetic */ Animator a(a aVar, ImageView imageView, long j) {
        return a(imageView, j);
    }

    private void a(C0565a c0565a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, this, c0565a) == null) || c0565a == null) {
            return;
        }
        TextView textView = this.eQ;
        if (textView != null) {
            textView.setText(c0565a.getTitle());
        }
        TextView textView2 = this.ol;
        if (textView2 != null) {
            textView2.setText(c0565a.N(this.es.getContext()));
        }
        TextView textView3 = this.iu;
        if (textView3 != null) {
            textView3.setText(c0565a.gl());
        }
        Button button = this.om;
        if (button != null) {
            button.setText(c0565a.gm());
        }
    }

    private void d(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, viewGroup) == null) {
            this.oj = viewGroup.findViewById(R.id.obfuscated_res_0x7f09112c);
            this.ok = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112a);
            this.eQ = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112f);
            this.ol = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112d);
            this.iu = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112e);
            Button button = (Button) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112b);
            this.om = button;
            button.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Animator m = m(this.oj);
            m.addListener(new AnimatorListenerAdapter(this, m) { // from class: com.kwad.components.ad.reward.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a oq;
                public final /* synthetic */ Animator ou;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, m};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.oq = this;
                    this.ou = m;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.ou.removeListener(this);
                        if (this.oq.on != null) {
                            this.oq.on.go();
                        }
                    }
                }
            });
            m.start();
        }
    }

    public static Animator l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    private Animator m(View view2) {
        InterceptResult invokeL;
        ObjectAnimator objectAnimator;
        int[] z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, view2)) == null) {
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
        return (Animator) invokeL.objValue;
    }

    public final void a(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.on = bVar;
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uVar) == null) {
            super.a(uVar);
            a(C0565a.u(uVar.getAdTemplate()));
            this.es.post(new AnonymousClass1(this, uVar, com.kwad.components.ad.reward.kwai.b.ge()));
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.es : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2.equals(this.om) && (bVar = this.on) != null) {
            bVar.gn();
        }
    }
}
