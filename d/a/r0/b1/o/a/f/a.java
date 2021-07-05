package d.a.r0.b1.o.a.f;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f55078e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f55079f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f55080g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f55081h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.b1.o.a.c.a f55082i;
    public d.a.r0.b1.o.a.d.c j;
    public boolean k;
    public Animation l;
    public Animation m;
    public boolean n;
    public int o;
    public Dialog p;
    public View q;
    public boolean r;
    public View.OnKeyListener s;
    public final View.OnTouchListener t;

    /* renamed from: d.a.r0.b1.o.a.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1232a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55083e;

        public View$OnClickListenerC1232a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55083e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f55083e.f();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55084a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55084a = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f55084a.i();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55085e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55085e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f55085e;
                aVar.f55082i.y.removeView(aVar.f55080g);
                this.f55085e.n = false;
                this.f55085e.k = false;
                if (this.f55085e.j != null) {
                    this.f55085e.j.a(this.f55085e);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55086e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55086e = aVar;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 4 && keyEvent.getAction() == 0 && this.f55086e.q()) {
                    this.f55086e.f();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55087e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55087e = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 0) {
                    this.f55087e.f();
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f55088e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55088e = aVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f55088e.j == null) {
                return;
            }
            this.f55088e.j.a(this.f55088e);
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 80;
        this.r = true;
        this.s = new d(this);
        this.t = new e(this);
        this.f55078e = context;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55081h == null) {
            return;
        }
        Dialog dialog = new Dialog(this.f55078e, R.style.custom_dialog2);
        this.p = dialog;
        dialog.setCancelable(this.f55082i.S);
        this.p.setContentView(this.f55081h);
        Window window = this.p.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.picker_view_scale_anim);
            window.setGravity(17);
        }
        this.p.setOnDismissListener(new f(this));
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (p()) {
                h();
            } else if (this.k) {
            } else {
                if (this.r) {
                    this.l.setAnimationListener(new b(this));
                    this.f55079f.startAnimation(this.l);
                } else {
                    i();
                }
                this.k = true;
            }
        }
    }

    public final void h() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.dismiss();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f55082i.y.post(new c(this));
        }
    }

    public View j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? this.f55079f.findViewById(i2) : (View) invokeI.objValue;
    }

    public Dialog k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.p : (Dialog) invokeV.objValue;
    }

    public final Animation l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? AnimationUtils.loadAnimation(this.f55078e, d.a.r0.b1.o.a.e.c.a(this.o, true)) : (Animation) invokeV.objValue;
    }

    public final Animation m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? AnimationUtils.loadAnimation(this.f55078e, d.a.r0.b1.o.a.e.c.a(this.o, false)) : (Animation) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.m = l();
            this.l = m();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            LayoutInflater from = LayoutInflater.from(this.f55078e);
            if (p()) {
                ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
                this.f55081h = viewGroup;
                viewGroup.setBackgroundColor(0);
                ViewGroup viewGroup2 = (ViewGroup) this.f55081h.findViewById(R.id.content_container);
                this.f55079f = viewGroup2;
                layoutParams.leftMargin = 30;
                layoutParams.rightMargin = 30;
                viewGroup2.setLayoutParams(layoutParams);
                e();
                this.f55081h.setOnClickListener(new View$OnClickListenerC1232a(this));
            } else {
                d.a.r0.b1.o.a.c.a aVar = this.f55082i;
                if (aVar.y == null) {
                    aVar.y = (ViewGroup) ((Activity) this.f55078e).getWindow().getDecorView();
                }
                ViewGroup viewGroup3 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, this.f55082i.y, false);
                this.f55080g = viewGroup3;
                viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                int i2 = this.f55082i.P;
                if (i2 != -1) {
                    this.f55080g.setBackgroundColor(i2);
                }
                ViewGroup viewGroup4 = (ViewGroup) this.f55080g.findViewById(R.id.content_container);
                this.f55079f = viewGroup4;
                viewGroup4.setLayoutParams(layoutParams);
            }
            t(true);
        }
    }

    public abstract boolean p();

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (p()) {
                return false;
            }
            return this.f55080g.getParent() != null || this.n;
        }
        return invokeV.booleanValue;
    }

    public final void r(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            this.f55082i.y.addView(view);
            if (this.r) {
                this.f55079f.startAnimation(this.m);
            }
        }
    }

    public void s() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.setCancelable(this.f55082i.S);
    }

    public void t(boolean z) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (p()) {
                viewGroup = this.f55081h;
            } else {
                viewGroup = this.f55080g;
            }
            viewGroup.setFocusable(z);
            viewGroup.setFocusableInTouchMode(z);
            if (z) {
                viewGroup.setOnKeyListener(this.s);
            } else {
                viewGroup.setOnKeyListener(null);
            }
        }
    }

    public a u(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            ViewGroup viewGroup = this.f55080g;
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(R.id.outmost_container);
                if (z) {
                    findViewById.setOnTouchListener(this.t);
                } else {
                    findViewById.setOnTouchListener(null);
                }
            }
            return this;
        }
        return (a) invokeZ.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (p()) {
                w();
            } else if (q()) {
            } else {
                this.n = true;
                r(this.f55080g);
                this.f55080g.requestFocus();
            }
        }
    }

    public final void w() {
        Dialog dialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (dialog = this.p) == null) {
            return;
        }
        dialog.show();
    }
}
