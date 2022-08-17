package com.repackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad.FrsAdVideoView;
import com.baidu.tieba.frs.ad.ScanningView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public final ScanningView b;
    public final Activity c;
    public final e9<?> d;
    public final ViewGroup e;
    public final FrsAdVideoView f;
    public final TbImageView g;
    public final AnimatorSet h;
    public final AnimatorSet i;
    public long j;
    public ForumData k;
    public lj8 l;
    public Dialog m;
    public int n;
    public int o;
    public final m p;

    /* loaded from: classes7.dex */
    public class a implements n {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        /* renamed from: com.repackage.rh6$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0575a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0575a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.p();
                }
            }
        }

        public a(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // com.repackage.rh6.n
        public void I(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && i == 3) {
                this.a.a.post(new RunnableC0575a(this));
                this.a.p.f();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || wh5.a(this.a.c, this.a.l.h())) {
                return;
            }
            br6.b((TbPageContext) h9.a(this.a.c), this.a.l.j(), this.a.l.o(), this.a.l.i());
        }
    }

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        public b(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921682, 2));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.b.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        public c(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.f.setVisibility(8);
                tg.a(this.a.m, this.a.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        public d(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // com.repackage.rh6.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zq6.a("common_click", this.a.l, this.a.k, 2, "video");
            }
        }

        @Override // com.repackage.rh6.m
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zq6.k("common_exp", this.a.l, this.a.k, 2, "video");
            }
        }

        @Override // com.repackage.rh6.m
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                zq6.a("common_click", this.a.l, this.a.k, 2, "frontpage");
            }
        }

        @Override // com.repackage.rh6.m
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                zq6.g("c14592", this.a.l, this.a.k);
            }
        }

        @Override // com.repackage.rh6.m
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                zq6.k("common_exp", this.a.l, this.a.k, 2, "frontpage");
            }
        }

        @Override // com.repackage.rh6.m
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                zq6.g("c14593", this.a.l, this.a.k);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements DialogInterface.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        public e(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, dialogInterface, i, keyEvent)) == null) {
                if (i == 4) {
                    this.a.p.f();
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewGroup.LayoutParams e;
        public final /* synthetic */ rh6 f;

        public f(rh6 rh6Var, int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rh6Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a;
                int i2 = i + ((int) ((this.b - i) * floatValue));
                int i3 = this.c;
                int i4 = i3 + ((int) ((this.d - i3) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.e;
                if (i2 == layoutParams.width && i4 == layoutParams.height) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = this.e;
                layoutParams2.width = i2;
                layoutParams2.height = i4;
                rh6 rh6Var = this.f;
                FrsAdVideoView frsAdVideoView = rh6Var.f;
                int i5 = this.f.n;
                int i6 = this.f.o;
                ViewGroup.LayoutParams layoutParams3 = this.e;
                rh6Var.v(frsAdVideoView, i5, i6, layoutParams3.width, layoutParams3.height, this.f.e.getHeight());
                this.f.f.setLayoutParams(this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ rh6 d;

        public g(rh6 rh6Var, ViewGroup.LayoutParams layoutParams, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var, layoutParams, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rh6Var;
            this.a = layoutParams;
            this.b = i;
            this.c = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                int[] iArr = new int[2];
                this.d.b.getLocationInWindow(iArr);
                rh6 rh6Var = this.d;
                rh6Var.n = iArr[0] + (rh6Var.b.getWidth() / 2);
                rh6 rh6Var2 = this.d;
                rh6Var2.o = iArr[1] + (rh6Var2.b.getHeight() / 2);
                ViewGroup.LayoutParams layoutParams = this.a;
                layoutParams.width = this.b;
                layoutParams.height = this.c;
                rh6 rh6Var3 = this.d;
                FrsAdVideoView frsAdVideoView = rh6Var3.f;
                int i = this.d.n;
                int i2 = this.d.o;
                ViewGroup.LayoutParams layoutParams2 = this.a;
                rh6Var3.v(frsAdVideoView, i, i2, layoutParams2.width, layoutParams2.height, this.d.e.getHeight());
                this.d.f.setLayoutParams(this.a);
                this.d.f.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ViewGroup.LayoutParams c;
        public final /* synthetic */ rh6 d;

        public h(rh6 rh6Var, int i, int i2, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var, Integer.valueOf(i), Integer.valueOf(i2), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = rh6Var;
            this.a = i;
            this.b = i2;
            this.c = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int k = this.a + ((int) ((qi.k(this.d.c) - this.a) * floatValue));
                int height = this.b + ((int) ((this.d.e.getHeight() - this.b) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.c;
                if (k == layoutParams.width && height == layoutParams.height) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = this.c;
                layoutParams2.width = k;
                layoutParams2.height = height;
                rh6 rh6Var = this.d;
                FrsAdVideoView frsAdVideoView = rh6Var.f;
                int i = this.d.n;
                int i2 = this.d.o;
                ViewGroup.LayoutParams layoutParams3 = this.c;
                rh6Var.v(frsAdVideoView, i, i2, layoutParams3.width, layoutParams3.height, this.d.e.getHeight());
                this.d.f.setLayoutParams(this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        public i(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.f.x(1000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rh6 a;

        public j(rh6 rh6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rh6Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != this.a.g.getAlpha()) {
                    this.a.g.setAlpha(floatValue);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ rh6 b;

        public k(rh6 rh6Var, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = rh6Var;
            this.a = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = this.a;
                if (intValue != layoutParams.height) {
                    layoutParams.height = intValue;
                    rh6 rh6Var = this.b;
                    FrsAdVideoView frsAdVideoView = rh6Var.f;
                    int i = this.b.n;
                    int i2 = this.b.o;
                    ViewGroup.LayoutParams layoutParams2 = this.a;
                    rh6Var.v(frsAdVideoView, i, i2, layoutParams2.width, layoutParams2.height, this.b.e.getHeight());
                    this.b.f.setLayoutParams(this.a);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewGroup.LayoutParams e;
        public final /* synthetic */ rh6 f;

        public l(rh6 rh6Var, int i, int i2, int i3, int i4, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rh6Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = rh6Var;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                int i = this.a;
                int i2 = i - ((int) ((i - this.b) * floatValue));
                int i3 = this.c;
                int i4 = i3 - ((int) ((i3 - this.d) * floatValue));
                ViewGroup.LayoutParams layoutParams = this.e;
                if (i2 == layoutParams.width && i4 == layoutParams.height) {
                    return;
                }
                ViewGroup.LayoutParams layoutParams2 = this.e;
                layoutParams2.width = i2;
                layoutParams2.height = i4;
                rh6 rh6Var = this.f;
                FrsAdVideoView frsAdVideoView = rh6Var.f;
                int i5 = this.f.n;
                int i6 = this.f.o;
                ViewGroup.LayoutParams layoutParams3 = this.e;
                rh6Var.v(frsAdVideoView, i5, i6, layoutParams3.width, layoutParams3.height, this.f.e.getHeight());
                this.f.f.setLayoutParams(this.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface m {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* loaded from: classes7.dex */
    public interface n extends View.OnClickListener {
        void I(int i);
    }

    public rh6(Context context, View view2, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, tbImageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new AnimatorSet();
        this.i = new AnimatorSet();
        this.p = new d(this);
        this.a = view2;
        this.g = tbImageView;
        this.b = (ScanningView) view2.findViewById(R.id.obfuscated_res_0x7f090bfc);
        if (!(context instanceof e9)) {
            this.c = null;
            this.e = null;
            this.f = null;
            this.d = null;
            return;
        }
        e9<?> e9Var = (e9) context;
        this.d = e9Var;
        Activity pageActivity = e9Var.getPageContext().getPageActivity();
        this.c = pageActivity;
        this.e = (ViewGroup) pageActivity.findViewById(16908290);
        FrsAdVideoView frsAdVideoView = new FrsAdVideoView(this.c);
        this.f = frsAdVideoView;
        frsAdVideoView.setVisibility(8);
        this.f.setStateListener(new a(this));
        this.f.setFrsAdVideoStatisticListener(this.p);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c == null || this.e == null || this.f == null) {
            return;
        }
        int[] iArr = new int[2];
        this.b.getLocationInWindow(iArr);
        this.n = iArr[0] + (this.b.getWidth() / 2);
        this.o = iArr[1] + (this.b.getHeight() / 2);
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        ValueAnimator ofInt = ValueAnimator.ofInt(this.e.getHeight(), this.e.getWidth());
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new k(this, layoutParams));
        int width = this.e.getWidth();
        int width2 = (this.e.getWidth() * 3) / 4;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new l(this, width, width2, this.e.getWidth(), width2 / 5, layoutParams));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setDuration(320L);
        ofFloat2.addListener(new b(this));
        ofFloat2.setStartDelay(640L);
        ofFloat2.start();
        this.i.addListener(new c(this));
        this.i.play(ofInt).before(ofFloat);
        this.i.start();
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f.s();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f.isPlayStarted()) {
            this.f.stopPlay();
        }
    }

    public void s(lj8 lj8Var, ForumData forumData, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{lj8Var, forumData, Long.valueOf(j2)}) == null) || this.c == null || this.e == null || this.f == null || lj8Var == null || StringUtils.isNull(lj8Var.p())) {
            return;
        }
        this.j = j2;
        this.k = forumData;
        this.l = lj8Var;
        this.f.setVideoData(lj8Var.p(), this.l.b());
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Dialog dialog = new Dialog(this.c, R.style.obfuscated_res_0x7f1001af);
            this.m = dialog;
            dialog.requestWindowFeature(1);
            this.m.setContentView(this.f);
            this.m.setCancelable(true);
            this.m.setCanceledOnTouchOutside(true);
            if (this.m.getWindow() != null) {
                this.m.getWindow().getDecorView().setSystemUiVisibility(1280);
                this.m.getWindow().addFlags(Integer.MIN_VALUE);
                this.m.getWindow().setStatusBarColor(0);
                this.m.getWindow().setNavigationBarColor(0);
                WindowManager.LayoutParams attributes = this.m.getWindow().getAttributes();
                if (attributes != null) {
                    attributes.width = -1;
                    attributes.height = -1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        attributes.layoutInDisplayCutoutMode = 1;
                    }
                    this.m.getWindow().setAttributes(attributes);
                }
            }
            this.m.setOnKeyListener(new e(this));
            this.m.show();
            ru4 k2 = ru4.k();
            k2.x("key_frs_video_ad_last_show_time" + this.j, System.currentTimeMillis());
            this.p.e();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.c == null || this.e == null || this.f == null) {
            return;
        }
        t();
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        int width = this.b.getWidth() / 3;
        int height = this.b.getHeight() / 9;
        int k2 = (qi.k(this.c) * 2) / 3;
        int k3 = (qi.k(this.c) * 2) / 3;
        int[] iArr = new int[2];
        this.b.getLocationInWindow(iArr);
        this.n = iArr[0] + (this.b.getWidth() / 2);
        this.o = iArr[1] + (this.b.getHeight() / 2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(180L);
        ofFloat.addUpdateListener(new f(this, width, k2, height, k3, layoutParams));
        ofFloat.addListener(new g(this, layoutParams, width, height));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setDuration(520L);
        ofFloat2.addUpdateListener(new h(this, k2, k3, layoutParams));
        this.h.addListener(new i(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setDuration(360L);
        ofFloat3.setStartDelay(240L);
        ofFloat3.addUpdateListener(new j(this));
        ofFloat3.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat4.setDuration(1000L);
        this.h.setStartDelay(300L);
        this.h.play(ofFloat).before(ofFloat2).before(ofFloat4);
        this.h.start();
    }

    public final void v(View view2, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            int i7 = i2 - (i4 / 2);
            int max = Math.max(i3 - (i5 / 2), 0);
            if (max + i5 > i6) {
                max = i6 - i5;
            }
            float f2 = i7;
            if (view2.getX() == f2 && view2.getY() == max) {
                return;
            }
            view2.setX(f2);
            view2.setY(max);
        }
    }
}
