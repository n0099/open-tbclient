package d.a.o0.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class p extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View U;
    public BaseMenuView V;
    public Context W;
    public View X;
    public MainMenuView Y;
    public FrameLayout Z;
    public d.a.o0.k.a a0;
    public boolean b0;
    public int c0;

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f51088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ p f51089f;

        public a(p pVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51089f = pVar;
            this.f51088e = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51089f.Y.a(this.f51088e.getHeight());
                this.f51089f.d0();
                this.f51088e.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f51090e;

        public b(p pVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51090e = pVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                Context context = this.f51090e.W;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                p.super.r();
                p pVar = this.f51090e;
                BaseMenuView baseMenuView = pVar.V;
                if (baseMenuView != pVar.Y) {
                    baseMenuView.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, View view, @Nullable d.a.o0.k.a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, aVar};
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
        this.b0 = true;
        this.c0 = 0;
        this.W = context;
        this.X = view;
        this.a0 = aVar;
        G(false);
        I(true);
        M(true);
        F(new ColorDrawable(0));
        O(-1);
        J(-1);
        if (Build.VERSION.SDK_INT > 29) {
            K(true);
        }
        Z();
    }

    public void X() {
        d.a.o0.k.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (aVar = this.a0) == null) {
            return;
        }
        aVar.a(this.Y);
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z) {
                super.r();
            } else if (x()) {
                ObjectAnimator c2 = c.c(this.U);
                ObjectAnimator e2 = c.e(this.V);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new b(this));
                animatorSet.playTogether(c2, e2);
                animatorSet.start();
            }
        }
    }

    public final void Z() {
        int b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.W).inflate(j.aiapp_menu_layout, (ViewGroup) null);
            this.Z = frameLayout;
            this.U = frameLayout.findViewById(i.mask);
            this.Y = (MainMenuView) this.Z.findViewById(i.aiapp_menu_body);
            if (d.a.o0.t.e.d() && (this.W instanceof Activity)) {
                FrameLayout frameLayout2 = (FrameLayout) this.Z.findViewById(i.menu_layout);
                if (d.a.o0.t.e.e((Activity) this.W)) {
                    b2 = d.a.o0.t.e.a((Activity) this.W);
                } else {
                    b2 = (int) d.a.o0.t.e.b((Activity) this.W);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, -1);
                layoutParams.gravity = 17;
                if (frameLayout2 != null) {
                    frameLayout2.setLayoutParams(layoutParams);
                }
            }
            this.U.setOnClickListener(this);
            this.Y.setClickListener(this);
            this.Y.setFitsSystemWindows(true);
            this.Z.measure(0, 0);
            H(this.Z);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.Y.f();
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.c0 = i2;
        }
    }

    public void c0(List<List<o>> list, View view, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, view, Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            this.Y.h(list, view, z, i2);
            e0();
        }
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.U.setAlpha(0.0f);
            MainMenuView mainMenuView = this.Y;
            mainMenuView.setTranslationY(mainMenuView.getHeight());
            ObjectAnimator d2 = c.d(this.U, this.Y);
            ObjectAnimator b2 = c.b(this.Y);
            ArrayList arrayList = new ArrayList();
            arrayList.add(d2);
            arrayList.add(b2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || x()) {
            return;
        }
        X();
        this.Y.g();
        this.V = this.Y;
        if (this.b0) {
            I(false);
        }
        Activity activity = (Activity) this.W;
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        Q(this.X, 81, 0, 0);
        if (this.b0) {
            v().setSystemUiVisibility(this.c0 | 1024 | 4096);
            I(true);
            S();
        }
        View contentView = this.Y.getContentView();
        if (contentView.getHeight() == 0) {
            contentView.getViewTreeObserver().addOnGlobalLayoutListener(new a(this, contentView));
        } else {
            d0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            int id = view.getId();
            if (id == i.cancel || id == i.mask) {
                Y(true);
            }
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Y(true);
        }
    }
}
