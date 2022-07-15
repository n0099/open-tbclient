package com.repackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public abstract class iq6 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> q0;
    public static HashSet<Integer> r0;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsTopView A;
    public View B;
    public View C;
    public FrsVoiceRoomListLayout D;
    public EMTextView E;
    public boolean F;
    public SignActivityInfo G;
    public PopupWindow H;
    public View I;
    public TextView J;
    public TextView K;
    public ImageView L;
    public PopupWindow M;
    public BarImageView N;
    public UserIconBox O;
    public ArrayList<zn4> P;
    public zp6 Q;
    public yp6 R;
    public FrsLikeRecommendLayout S;
    public String T;
    public String U;
    public String V;
    public String W;
    public FrsViewData X;
    public ThreadData Y;
    public int Z;
    public TbPageContext a;
    public int a0;
    public FrsFragment b;
    public int b0;
    public Handler c;
    public int c0;
    public View d;
    public int d0;
    public TextView e;
    public int e0;
    public TextView f;
    public int f0;
    public TextView g;
    public boolean g0;
    public List<TBSpecificationBtn> h;
    public boolean h0;
    public List<TBSpecificationBtn> i;
    public boolean i0;
    public TextView j;
    public boolean j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public float l0;
    public View m;
    public ViewGroup m0;
    public TextView n;
    public wk6 n0;
    public TextView o;
    public boolean o0;
    public RelativeLayout p;
    public final Runnable p0;
    public RelativeLayout q;
    public View r;
    public TextView s;
    public RelativeLayout t;
    public RelativeLayout u;
    public LinearGradientView v;
    public TbImageView w;
    public ServiceAreaView x;
    public FrameLayout y;
    public bg6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq6 a;

        public a(iq6 iq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iq6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.a.H) != null && popupWindow.isShowing()) {
                iq6 iq6Var = this.a;
                if (iq6Var.h0) {
                    return;
                }
                sg.d(iq6Var.H, iq6Var.a.getPageActivity());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        /* loaded from: classes6.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
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
                    b bVar = this.a;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.a, "scaleX", 0.0f, bVar.b);
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

        public b(iq6 iq6Var, View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq6Var, view2, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = f;
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "scaleX", 1.0f, 0.0f);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755609757, "Lcom/repackage/iq6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755609757, "Lcom/repackage/iq6;");
                return;
            }
        }
        q0 = new HashMap<>();
        r0 = new HashSet<>();
        q0.put(1, "c0117");
        q0.put(2, "c0124");
        q0.put(3, "c0125");
        q0.put(4, "c0126");
        q0.put(5, "c0127");
    }

    public iq6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.o0 = false;
        this.p0 = new a(this);
    }

    public void A(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            B(false, f);
        }
    }

    public abstract void B(boolean z, float f);

    public abstract void C();

    public abstract void D();

    public abstract void E();

    public abstract void F();

    public abstract void G(View.OnClickListener onClickListener);

    public abstract void H(ForumData forumData, FrsViewData frsViewData);

    public void I(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.d0));
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f05d1);
            String string2 = this.a.getString(R.string.obfuscated_res_0x7f0f0aa4);
            int i = this.e0;
            if (i >= 10000) {
                if (i % 10000 == 0) {
                    textView2.setText(string + String.valueOf(this.e0 / 10000) + string2);
                    return;
                }
                textView2.setText(string + String.valueOf(i / 10000.0f) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(this.e0));
        }
    }

    public void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 0) {
                this.g0 = false;
                this.o0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            v(this.g0);
        }
    }

    public void K(int i, String str, int i2, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            this.V = str;
            this.Z = i2;
            if (i == 0) {
                this.g0 = false;
                this.o0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.o0) {
                    X();
                    this.o0 = true;
                }
            }
            v(this.g0);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 0) {
                this.i0 = false;
                F();
                return;
            }
            this.i0 = true;
            E();
        }
    }

    public void M(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, signData) == null) || signData == null) {
            return;
        }
        L(signData.is_signed);
        if (signData.forum_rank == -2) {
            a(false);
            return;
        }
        a(true);
        L(signData.is_signed);
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    public void O(yp6 yp6Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, yp6Var) == null) || yp6Var == null || (list = this.h) == null) {
            return;
        }
        this.R = yp6Var;
        yp6Var.g(list);
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f0 = i;
        }
    }

    public void Q(zp6 zp6Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, zp6Var) == null) || zp6Var == null || (list = this.i) == null) {
            return;
        }
        this.Q = zp6Var;
        zp6Var.i(list);
    }

    public void R(xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, xnVar) == null) {
        }
    }

    public abstract void S(View view2, boolean z);

    public abstract void T();

    public void U(List<ch8> list) {
        ForumData forum;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, list) != null) || this.a == null || this.X == null || TextUtils.isEmpty(this.U) || ListUtils.isEmpty(list) || (forum = this.X.getForum()) == null || forum.getThemeColorInfo() == null || !d(forum.getThemeColorInfo())) {
        }
    }

    public abstract void V();

    public void W(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            view2.setPivotX(0.0f);
            b bVar = new b(this, view2, f2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(bVar);
            ofFloat.start();
        }
    }

    public abstract void X();

    public void Y(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) || f == f2) {
            return;
        }
        view2.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", f, f2);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void Z();

    public void a(boolean z) {
        zp6 zp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (zp6Var = this.Q) == null) {
            return;
        }
        zp6Var.j(z);
    }

    public abstract void b();

    public abstract void c(int i);

    public final boolean d(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, themeColorInfo)) == null) ? (themeColorInfo == null || (themeElement = themeColorInfo.day) == null || themeColorInfo.dark == null || themeColorInfo.night == null || StringUtils.isNull(themeElement.font_color) || StringUtils.isNull(themeColorInfo.dark.font_color) || StringUtils.isNull(themeColorInfo.night.font_color)) ? false : true : invokeL.booleanValue;
    }

    public abstract String e();

    public BarImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.N : (BarImageView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public abstract SignActivityInfo k();

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.g0 : invokeV.booleanValue;
    }

    public abstract void n();

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            PopupWindow popupWindow2 = this.H;
            if (popupWindow2 == null || !popupWindow2.isShowing()) {
                return;
            }
            this.H.dismiss();
        }
    }

    public void p() {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (frsLikeRecommendLayout = this.S) != null && frsLikeRecommendLayout.getVisibility() == 0) {
            this.S.f();
        }
    }

    public abstract boolean q();

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.j0 : invokeV.booleanValue;
    }

    public abstract boolean s();

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int[] iArr = new int[2];
            try {
                this.L.getLocationOnScreen(iArr);
                return iArr[0] >= 160 && iArr[1] >= 105;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.h0 = true;
            r0.clear();
        }
    }

    public abstract void v(boolean z);

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z) == null) || z) {
            return;
        }
        o();
        n();
    }

    public abstract void y();

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            o();
            n();
        }
    }
}
