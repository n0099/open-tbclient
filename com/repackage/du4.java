package com.repackage;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.PullViewHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class du4 extends jo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public LinearLayout h;
    public ImageView i;
    public g j;
    public f k;
    public h l;
    public e m;
    public AnimationDrawable n;
    public ContinuousAnimationView o;
    public int p;
    public boolean q;
    public SmartBubbleAnimatedView r;
    public j s;
    public i t;
    public boolean u;
    public boolean v;
    public boolean w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public final Animator.AnimatorListener z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du4 a;

        public a(du4 du4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.x == null) {
                return;
            }
            this.a.x.onClick(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du4 a;

        public b(du4 du4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimationDrawable animationDrawable;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (animationDrawable = this.a.n) == null) {
                return;
            }
            animationDrawable.start();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du4 a;

        public c(du4 du4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du4Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.a.w) {
                return;
            }
            this.a.w = true;
            this.a.o.setSpeed(1.0f);
            this.a.o.setMinAndMaxFrame(45, 105);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements SmartBubbleAnimatedView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ du4 a;

        public d(du4 du4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {du4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = du4Var;
        }

        @Override // com.baidu.tieba.frs.SmartBubbleAnimatedView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.s == null) {
                return;
            }
            this.a.s.onAnimationEnd();
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(View view2, boolean z);
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(boolean z);
    }

    /* loaded from: classes5.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;

        public i(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface j {
        void a(int i);

        void onAnimationEnd();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du4(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.p = Integer.MIN_VALUE;
        this.q = false;
        this.u = true;
        this.v = true;
        this.w = false;
        this.x = null;
        this.y = new a(this);
        this.z = new c(this);
    }

    public void H(int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (M() && this.p != i2 && (continuousAnimationView = this.o) != null && !continuousAnimationView.isAnimating()) {
                this.p = i2;
                SkinManager.setLottieAnimation(this.o, R.raw.lottie_common_pull_refresh);
            }
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.r;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
        }
    }

    public void I() {
        SmartBubbleAnimatedView smartBubbleAnimatedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.h == null || (smartBubbleAnimatedView = this.r) == null || smartBubbleAnimatedView.getParent() == null) {
            return;
        }
        this.h.removeView(this.r);
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g == null) {
                this.g = n();
            }
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public g K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (g) invokeV.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.r;
            if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
                this.h.removeView(this.r);
            }
            if (M()) {
                ImageView imageView = this.i;
                if (imageView == null || this.o == null) {
                    return;
                }
                if (imageView.getVisibility() != 8) {
                    this.i.setVisibility(8);
                }
                if (this.o.getVisibility() != 0) {
                    this.o.setVisibility(0);
                }
                if (this.o.isAnimating()) {
                    this.o.cancelAnimation();
                }
                this.o.setMinAndMaxProgress(0.0f, 1.0f);
                this.o.setFrame(0);
                this.o.setSpeed(1.3f);
                return;
            }
            ImageView imageView2 = this.i;
            if (imageView2 == null || this.o == null) {
                return;
            }
            if (imageView2.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
            if (this.o.getVisibility() != 8) {
                this.o.setVisibility(8);
            }
        }
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? PullViewHelper.getInstance().isShouldShowLoadingView() : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void O() {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && M() && (animationDrawable = this.n) != null) {
            animationDrawable.stop();
            this.n = null;
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.u = z;
        }
    }

    public void Q(int i2) {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (continuousAnimationView = this.o) == null) {
            return;
        }
        SkinManager.setLottieAnimation(continuousAnimationView, i2);
    }

    public void R(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
            this.t = iVar;
        }
    }

    public void S(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void T(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jVar) == null) {
            this.s = jVar;
        }
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (N() && this.u && this.t != null && this.h != null) {
                this.i.setVisibility(8);
                this.o.setVisibility(8);
                if (this.r == null) {
                    SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(getContext());
                    this.r = smartBubbleAnimatedView;
                    smartBubbleAnimatedView.setExtrusionRemind(true);
                }
                this.r.a = this.t.b();
                this.r.b = this.t.a();
                if (this.r.getParent() != null) {
                    this.h.removeView(this.r);
                }
                this.h.addView(this.r);
                this.r.setOnBubbleAnimateListener(new d(this));
                j jVar = this.s;
                if (jVar != null) {
                    jVar.a(this.r.getTipViewHeight());
                }
                this.r.g();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && M() && (continuousAnimationView = this.o) != null) {
            continuousAnimationView.loop(false);
        }
    }

    public final void W() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (continuousAnimationView = this.o) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.o.cancelAnimation();
        }
        this.w = false;
        this.o.loop(true);
        this.o.setMinFrame(27);
        this.o.setRepeatMode(1);
        this.o.removeAllAnimatorListeners();
        this.o.addAnimatorListener(this.z);
        this.o.playAnimation();
    }

    @Override // com.repackage.jo, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public void c(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.c(f2, f3);
            if (M()) {
                this.o.setAlpha(f2);
                this.o.setFrame((int) Math.min(27.0f, ((f2 * 27.0f) * 5.0f) / 3.0f));
            }
        }
    }

    public void f(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.j = gVar;
        }
    }

    public void g(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hVar) == null) {
            this.l = hVar;
        }
    }

    @Override // com.repackage.jo, com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.i
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return 600L;
        }
        return invokeV.longValue;
    }

    public void k(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.m = eVar;
        }
    }

    public void m(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, fVar) == null) {
            this.k = fVar;
        }
    }

    @Override // com.repackage.jo
    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d080a, (ViewGroup) null);
            this.g = inflate;
            this.h = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091959);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.g.findViewById(R.id.obfuscated_res_0x7f0906f7);
            this.o = continuousAnimationView;
            SkinManager.setLottieAnimation(continuousAnimationView, R.raw.lottie_common_pull_refresh);
            this.o.setOnClickListener(this.y);
            ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091954);
            this.i = imageView;
            imageView.setOnClickListener(this.y);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            int i2 = this.p;
            if (i2 != Integer.MIN_VALUE) {
                skinType = i2;
            }
            if (!M()) {
                this.n = PullViewHelper.getInstance().getDefaultAnimationDrawable(skinType);
            }
            this.i.setBackgroundDrawable(this.n);
            L();
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.jo
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.v = true;
            if (M() && this.o.isAnimating()) {
                this.o.cancelAnimation();
            } else {
                AnimationDrawable animationDrawable = this.n;
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
            }
            O();
            f fVar = this.k;
            if (fVar != null) {
                fVar.a(this.g, z);
            }
        }
    }

    @Override // com.repackage.jo
    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || r()) {
            return;
        }
        e eVar = this.m;
        if (eVar != null) {
            eVar.a();
        }
        if (!U()) {
            V();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.o;
        if (continuousAnimationView == null || !continuousAnimationView.isAnimating()) {
            return;
        }
        this.o.cancelAnimation();
    }

    @Override // com.repackage.jo
    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || r()) {
            return;
        }
        g gVar = this.j;
        if (gVar != null && this.v) {
            gVar.onListPullRefresh(z);
        }
        this.v = true;
    }

    @Override // com.repackage.jo
    public void w(boolean z) {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            h hVar = this.l;
            if (hVar != null) {
                hVar.a(z);
            }
            L();
            if (M() || (animationDrawable = this.n) == null || this.i == null) {
                return;
            }
            animationDrawable.stop();
            this.i.setBackgroundDrawable(this.n.getFrame(0));
        }
    }

    @Override // com.repackage.jo
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            L();
            if (M()) {
                if (r()) {
                    return;
                }
                W();
                return;
            }
            AnimationDrawable animationDrawable = this.n;
            if (animationDrawable == null || this.i == null) {
                return;
            }
            animationDrawable.stop();
            this.i.setBackgroundDrawable(this.n);
            this.i.post(new b(this));
        }
    }

    @Override // com.repackage.jo
    public void y() {
        AnimationDrawable animationDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || M() || (animationDrawable = this.n) == null || this.i == null) {
            return;
        }
        animationDrawable.stop();
        this.i.setBackgroundDrawable(this.n.getFrame(0));
    }
}
