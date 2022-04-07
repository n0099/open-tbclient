package com.repackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public abstract class lr6 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> o0;
    public static HashSet<Integer> p0;
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
    public ArrayList<co4> P;
    public zq6 Q;
    public yq6 R;
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
    public boolean m0;
    public TextView n;
    public final Runnable n0;
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
    public gg6 z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr6 a;

        public a(lr6 lr6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.a.H) != null && popupWindow.isShowing()) {
                lr6 lr6Var = this.a;
                if (lr6Var.h0) {
                    return;
                }
                rg.d(lr6Var.H, lr6Var.a.getPageActivity());
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
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.a, AnimationProperty.SCALE_X, 0.0f, bVar.b);
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

        public b(lr6 lr6Var, View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr6Var, view2, Float.valueOf(f)};
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
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, AnimationProperty.SCALE_X, 1.0f, 0.0f);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755519423, "Lcom/repackage/lr6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755519423, "Lcom/repackage/lr6;");
                return;
            }
        }
        o0 = new HashMap<>();
        p0 = new HashSet<>();
        o0.put(1, "c0117");
        o0.put(2, "c0124");
        o0.put(3, "c0125");
        o0.put(4, "c0126");
        o0.put(5, "c0127");
    }

    public lr6() {
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
        this.m0 = false;
        this.n0 = new a(this);
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || z) {
            return;
        }
        p();
        o();
    }

    public abstract void B();

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p();
            o();
        }
    }

    public void D(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            E(false, f);
        }
    }

    public abstract void E(boolean z, float f);

    public abstract void F();

    public abstract void G();

    public abstract void H();

    public abstract void I();

    public abstract void J(View.OnClickListener onClickListener);

    public abstract void K(ForumData forumData, FrsViewData frsViewData);

    public void L(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.d0));
            String string = this.a.getString(R.string.obfuscated_res_0x7f0f05c6);
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

    public void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i == 0) {
                this.g0 = false;
                this.m0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            y(this.g0);
        }
    }

    public void N(int i, String str, int i2, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            this.V = str;
            this.Z = i2;
            if (i == 0) {
                this.g0 = false;
                this.m0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.m0) {
                    a0();
                    this.m0 = true;
                }
            }
            y(this.g0);
        }
    }

    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (i == 0) {
                this.i0 = false;
                I();
                return;
            }
            this.i0 = true;
            H();
        }
    }

    public void P(SignData signData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, signData) == null) || signData == null) {
            return;
        }
        O(signData.is_signed);
        if (signData.forum_rank == -2) {
            b(false);
            return;
        }
        b(true);
        O(signData.is_signed);
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    public void R(yq6 yq6Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, yq6Var) == null) || yq6Var == null || (list = this.h) == null) {
            return;
        }
        this.R = yq6Var;
        yq6Var.g(list);
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.f0 = i;
        }
    }

    public void T(zq6 zq6Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, zq6Var) == null) || zq6Var == null || (list = this.i) == null) {
            return;
        }
        this.Q = zq6Var;
        zq6Var.i(list);
    }

    public void U(dp dpVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dpVar) == null) {
        }
    }

    public abstract void V(View view2, boolean z);

    public abstract void W();

    public void X(List<jj8> list) {
        ForumData forum;
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, list) == null) || this.a == null || TextUtils.isEmpty(this.U) || ListUtils.isEmpty(list) || (forum = this.X.getForum()) == null || forum.getThemeColorInfo() == null) {
            return;
        }
        ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
        if (e(themeColorInfo) && UbsABTestHelper.isFrsModifyABTestA() && (frsLikeRecommendLayout = this.S) != null) {
            frsLikeRecommendLayout.setHeightChangeListener(new wn6() { // from class: com.repackage.jr6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.repackage.wn6
                public final void a(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        lr6.this.v(i);
                    }
                }
            });
            this.S.setThemeColor(themeColorInfo);
            this.S.i(this.a, this.U, list);
            this.S.setCloseListener(new View.OnClickListener() { // from class: com.repackage.ir6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        lr6.this.w(view2);
                    }
                }
            });
        }
    }

    public abstract void Y();

    public void Z(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            view2.setPivotX(0.0f);
            b bVar = new b(this, view2, f2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(bVar);
            ofFloat.start();
        }
    }

    public abstract void a();

    public abstract void a0();

    public void b(boolean z) {
        zq6 zq6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (zq6Var = this.Q) == null) {
            return;
        }
        zq6Var.j(z);
    }

    public void b0(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) || f == f2) {
            return;
        }
        view2.setPivotX(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, AnimationProperty.SCALE_X, f, f2);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    public abstract void c();

    public abstract void c0();

    public abstract void d(int i);

    public final boolean e(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, themeColorInfo)) == null) ? (themeColorInfo == null || (themeElement = themeColorInfo.day) == null || themeColorInfo.dark == null || themeColorInfo.night == null || StringUtils.isNull(themeElement.font_color) || StringUtils.isNull(themeColorInfo.dark.font_color) || StringUtils.isNull(themeColorInfo.night.font_color)) ? false : true : invokeL.booleanValue;
    }

    public abstract String f();

    public BarImageView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.N : (BarImageView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public abstract SignActivityInfo l();

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.g0 : invokeV.booleanValue;
    }

    public abstract void o();

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
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

    public void q() {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (frsLikeRecommendLayout = this.S) != null && frsLikeRecommendLayout.getVisibility() == 0) {
            this.S.j();
        }
    }

    public abstract boolean r();

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.j0 : invokeV.booleanValue;
    }

    public abstract boolean t();

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
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

    public /* synthetic */ void v(int i) {
        a();
    }

    public /* synthetic */ void w(View view2) {
        this.S.j();
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.h0 = true;
            p0.clear();
        }
    }

    public abstract void y(boolean z);

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
        }
    }
}
