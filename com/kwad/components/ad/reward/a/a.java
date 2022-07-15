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
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.i.d;
import com.kwad.components.ad.reward.i.w;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.az;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* renamed from: com.kwad.components.ad.reward.a.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;
        public final /* synthetic */ long b;
        public final /* synthetic */ a c;

        public AnonymousClass1(a aVar, w wVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, wVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aVar;
            this.a = wVar;
            this.b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Animator a = a.a(this.c.c);
                a.addListener(new AnimatorListenerAdapter(this, a) { // from class: com.kwad.components.ad.reward.a.a.1.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Animator a;
                    public final /* synthetic */ AnonymousClass1 b;

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
                        this.b = this;
                        this.a = a;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            super.onAnimationEnd(animator);
                            this.a.removeListener(this);
                            com.kwad.sdk.core.report.a.c(this.b.a.a(), 169, (JSONObject) null);
                            a.a(this.b.c.d, this.b.b).start();
                            az.a(new Runnable(this) { // from class: com.kwad.components.ad.reward.a.a.1.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ C04751 a;

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
                                    this.a = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.a.b.c.c();
                                    }
                                }
                            }, null, this.b.b);
                        }
                    }
                });
                a.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0477a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;
        public CharSequence b;
        public CharSequence c;
        public CharSequence d;

        public C0477a(@NonNull CouponInfo couponInfo) {
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
            this.a = couponInfo.displayTitle;
            this.b = couponInfo.displayValue;
            this.c = !TextUtils.isEmpty(couponInfo.displayBase) ? String.format("满%s可用", couponInfo.displayBase) : "";
            this.d = couponInfo.displayActionWords;
        }

        @Nullable
        public static C0477a a(AdTemplate adTemplate) {
            InterceptResult invokeL;
            List<CouponInfo> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
                AdProductInfo bd = com.kwad.sdk.core.response.a.a.bd(com.kwad.sdk.core.response.a.d.i(adTemplate));
                if (bd == null || (list = bd.couponList) == null || list.size() <= 0) {
                    return null;
                }
                return a(bd.couponList.get(0));
            }
            return (C0477a) invokeL.objValue;
        }

        @Nullable
        public static C0477a a(CouponInfo couponInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, couponInfo)) == null) {
                if (couponInfo == null) {
                    return null;
                }
                return new C0477a(couponInfo);
            }
            return (C0477a) invokeL.objValue;
        }

        public final CharSequence a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (CharSequence) invokeV.objValue;
        }

        public final CharSequence a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07035d));
                SpannableString spannableString = new SpannableString("¥" + ((Object) this.b));
                spannableString.setSpan(absoluteSizeSpan, 0, 1, 17);
                return spannableString;
            }
            return (CharSequence) invokeL.objValue;
        }

        public final CharSequence b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (CharSequence) invokeV.objValue;
        }

        public final CharSequence c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (CharSequence) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
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
        this.b = iArr;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d044f, viewGroup, false);
        this.a = viewGroup2;
        a(viewGroup2);
    }

    public static Animator a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 0.0f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "scaleY", 0.0f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(300L);
            animatorSet.playTogether(ofFloat, ofFloat2);
            return animatorSet;
        }
        return (Animator) invokeL.objValue;
    }

    public static Animator a(ImageView imageView, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, imageView, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "alpha", imageView.getAlpha(), 0.0f);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (Animator) invokeLJ.objValue;
    }

    private void a(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, viewGroup) == null) {
            this.c = viewGroup.findViewById(R.id.obfuscated_res_0x7f09101f);
            this.d = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09101d);
            this.e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091022);
            this.f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091020);
            this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091021);
            Button button = (Button) viewGroup.findViewById(R.id.obfuscated_res_0x7f09101e);
            this.h = button;
            button.setOnClickListener(this);
        }
    }

    private void a(C0477a c0477a) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, this, c0477a) == null) || c0477a == null) {
            return;
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(c0477a.a());
        }
        TextView textView2 = this.f;
        if (textView2 != null) {
            textView2.setText(c0477a.a(this.a.getContext()));
        }
        TextView textView3 = this.g;
        if (textView3 != null) {
            textView3.setText(c0477a.b());
        }
        Button button = this.h;
        if (button != null) {
            button.setText(c0477a.c());
        }
    }

    private Animator b(View view2) {
        InterceptResult invokeL;
        ObjectAnimator objectAnimator;
        int[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, view2)) == null) {
            Interpolator create = PathInterpolatorCompat.create(0.89f, 0.02f, 0.72f, 1.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 0.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, "scaleY", 1.0f, 0.0f);
            ofFloat.setInterpolator(create);
            ofFloat2.setInterpolator(create);
            int[] iArr = this.b;
            ObjectAnimator objectAnimator2 = null;
            if (iArr == null || iArr.length < 2 || (b2 = com.kwad.sdk.b.kwai.a.b(view2)) == null) {
                objectAnimator = null;
            } else {
                Interpolator create2 = PathInterpolatorCompat.create(0.33f, 0.0f, 0.83f, 1.0f);
                objectAnimator2 = ObjectAnimator.ofFloat(view2, "translationX", this.b[0] - b2[0]);
                objectAnimator = ObjectAnimator.ofFloat(view2, "translationY", this.b[1] - b2[1]);
                objectAnimator2.setInterpolator(create2);
                objectAnimator.setInterpolator(create2);
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 1.0f);
            ofFloat3.setDuration(200L);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "alpha", 1.0f, 0.0f);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            Animator b2 = b(this.c);
            b2.addListener(new AnimatorListenerAdapter(this, b2) { // from class: com.kwad.components.ad.reward.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Animator a;
                public final /* synthetic */ a b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, b2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = b2;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                        super.onAnimationEnd(animator);
                        this.a.removeListener(this);
                        if (this.b.i != null) {
                            this.b.i.b();
                        }
                    }
                }
            });
            b2.start();
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final ViewGroup a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (ViewGroup) invokeV.objValue;
    }

    public final void a(@Nullable b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.i = bVar;
        }
    }

    @Override // com.kwad.components.ad.reward.i.d
    public final void a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wVar) == null) {
            super.a(wVar);
            a(C0477a.a(wVar.a()));
            this.a.post(new AnonymousClass1(this, wVar, com.kwad.components.ad.reward.kwai.b.k()));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && view2.equals(this.h) && (bVar = this.i) != null) {
            bVar.a();
        }
    }
}
