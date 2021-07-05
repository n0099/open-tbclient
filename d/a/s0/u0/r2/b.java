package d.a.s0.u0.r2;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.w;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.l;
import d.a.s0.u0.o2.f;
import d.a.s0.u0.o2.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import tbclient.SignActivityInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> m0;
    public static HashSet<Integer> n0;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTopView A;
    public View B;
    public View C;
    public EMTextView D;
    public boolean E;
    public SignActivityInfo F;
    public PopupWindow G;
    public View H;
    public TextView I;
    public TextView J;
    public ImageView K;
    public PopupWindow L;
    public BarImageView M;
    public UserIconBox N;
    public ArrayList<l> O;
    public g P;
    public f Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public FrsViewData V;
    public b2 W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f66982a;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public FrsFragment f66983b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public Handler f66984c;
    public int c0;

    /* renamed from: d  reason: collision with root package name */
    public View f66985d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66986e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66987f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66988g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f66989h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f66990i;
    public boolean i0;
    public TextView j;
    public float j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public final Runnable l0;
    public View m;
    public TextView n;
    public TextView o;
    public RelativeLayout p;
    public RelativeLayout q;
    public View r;
    public TextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public LinearGradientView v;
    public TbImageView w;
    public ServiceAreaView x;
    public FrameLayout y;
    public d.a.s0.u0.g1.g z;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66991e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66991e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.f66991e.G) != null && popupWindow.isShowing()) {
                b bVar = this.f66991e;
                if (bVar.f0) {
                    return;
                }
                d.a.c.e.m.g.d(bVar.G, bVar.f66982a.getPageActivity());
            }
        }
    }

    /* renamed from: d.a.s0.u0.r2.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1766b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f66992e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f66993f;

        /* renamed from: d.a.s0.u0.r2.b$b$a */
        /* loaded from: classes9.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ C1766b f66994e;

            public a(C1766b c1766b) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1766b};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f66994e = c1766b;
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
                    C1766b c1766b = this.f66994e;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(c1766b.f66992e, "scaleX", 0.0f, c1766b.f66993f);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }
        }

        public C1766b(b bVar, View view, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view, Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66992e = view;
            this.f66993f = f2;
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
                a aVar = new a(this);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f66992e, "scaleX", 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(aVar);
                ofFloat.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-155816799, "Ld/a/s0/u0/r2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-155816799, "Ld/a/s0/u0/r2/b;");
                return;
            }
        }
        m0 = new HashMap<>();
        n0 = new HashSet<>();
        m0.put(1, "c0117");
        m0.put(2, "c0124");
        m0.put(3, "c0125");
        m0.put(4, "c0126");
        m0.put(5, "c0127");
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k0 = false;
        this.l0 = new a(this);
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(ForumData forumData, FrsViewData frsViewData);

    public void C(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.b0));
            String string = this.f66982a.getString(R.string.experience_divider);
            String string2 = this.f66982a.getString(R.string.member_count_unit);
            int i2 = this.c0;
            if (i2 >= 10000) {
                if (i2 % 10000 == 0) {
                    textView2.setText(string + String.valueOf(this.c0 / 10000) + string2);
                    return;
                }
                textView2.setText(string + String.valueOf(i2 / 10000.0f) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(this.c0));
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 == 0) {
                this.e0 = false;
                this.k0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.f66989h.setVisibility(0);
                this.f66990i.setVisibility(8);
                return;
            }
            this.e0 = true;
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.f66989h.setVisibility(8);
            this.f66990i.setVisibility(0);
        }
    }

    public void E(int i2, String str, int i3, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            this.T = str;
            this.X = i3;
            if (i2 == 0) {
                this.e0 = false;
                this.k0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.f66989h.setVisibility(0);
                this.f66990i.setVisibility(8);
                return;
            }
            this.e0 = true;
            this.p.setVisibility(8);
            this.q.setVisibility(0);
            this.f66989h.setVisibility(8);
            this.f66990i.setVisibility(0);
            if (!z || this.k0) {
                return;
            }
            Q();
            this.k0 = true;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 == 0) {
                this.g0 = false;
                this.f66990i.setText(this.f66982a.getString(R.string.sign));
                z();
                return;
            }
            this.g0 = true;
            this.f66990i.setText(this.f66982a.getString(R.string.signed));
            y();
        }
    }

    public void G(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, signData) == null) || signData == null) {
            return;
        }
        F(signData.is_signed);
        if (signData.forum_rank == -2) {
            a(false);
            return;
        }
        a(true);
        F(signData.is_signed);
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
        }
    }

    public void I(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null) {
            return;
        }
        this.Q = fVar;
        fVar.j(this.f66989h);
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.d0 = i2;
        }
    }

    public void K(g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) || gVar == null) {
            return;
        }
        this.P = gVar;
        gVar.i(this.f66990i);
    }

    public void L(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, wVar) == null) {
        }
    }

    public abstract void M(View view, boolean z);

    public abstract void N();

    public abstract void O();

    public void P(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            view.setPivotX(0.0f);
            C1766b c1766b = new C1766b(this, view, f3);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(c1766b);
            ofFloat.start();
        }
    }

    public abstract void Q();

    public void R(View view, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)}) == null) || f2 == f3) {
            return;
        }
        view.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", f2, f3);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void S();

    public void a(boolean z) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (gVar = this.P) == null) {
            return;
        }
        gVar.j(z);
    }

    public abstract void b();

    public abstract void c(int i2);

    public abstract String d();

    public BarImageView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.M : (BarImageView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f66988g : (TextView) invokeV.objValue;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.g0 : invokeV.booleanValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public abstract SignActivityInfo j();

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f66985d : (View) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.e0 : invokeV.booleanValue;
    }

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            PopupWindow popupWindow = this.L;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.L.dismiss();
            }
            PopupWindow popupWindow2 = this.G;
            if (popupWindow2 == null || !popupWindow2.isShowing()) {
                return;
            }
            this.G.dismiss();
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.h0 : invokeV.booleanValue;
    }

    public abstract boolean p();

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            int[] iArr = new int[2];
            try {
                this.K.getLocationOnScreen(iArr);
                return iArr[0] >= 160 && iArr[1] >= 105;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.f0 = true;
            n0.clear();
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z) == null) || z) {
            return;
        }
        n();
        m();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            n();
            m();
        }
    }

    public void u(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048615, this, f2) == null) {
            v(false, f2);
        }
    }

    public abstract void v(boolean z, float f2);

    public abstract void w();

    public abstract void x();

    public abstract void y();

    public abstract void z();
}
