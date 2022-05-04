package com.repackage;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.widget.layout.FlowLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.view.TextSizeSeekBar;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class rv7 extends z8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int x;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public View b;
    public FlowLayout c;
    public EMTextView d;
    public EMTextView e;
    public EMTextView f;
    public EMTextView g;
    public EMTextView h;
    public EMTextView i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public EMTextView q;
    public LinearLayout r;
    public TextSizeSeekBar s;
    public EMTextView t;
    public View u;
    public View.OnClickListener v;
    public boolean w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755336802, "Lcom/repackage/rv7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755336802, "Lcom/repackage/rv7;");
                return;
            }
        }
        x = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rv7(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = null;
        this.v = null;
        this.a = baseFragment;
        this.v = onClickListener;
        v();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.i.setVisibility(z ? 0 : 8);
        }
    }

    public void D(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.q.setVisibility(z ? 0 : 8);
            if (z2) {
                this.q.setText(R.string.obfuscated_res_0x7f0f081c);
            } else {
                this.q.setText(R.string.obfuscated_res_0x7f0f081d);
            }
        }
    }

    public void E(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.o.setVisibility(z ? 0 : 8);
            if (z2) {
                this.o.setText(R.string.obfuscated_res_0x7f0f07de);
                P(this.o, R.drawable.obfuscated_res_0x7f080936);
                return;
            }
            this.o.setText(R.string.obfuscated_res_0x7f0f1506);
            P(this.o, R.drawable.obfuscated_res_0x7f080946);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.o.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.d.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.e.getLayoutParams().width = 201;
            this.f.getLayoutParams().width = 201;
            this.n.getLayoutParams().width = 201;
            this.g.getLayoutParams().width = 201;
            this.h.getLayoutParams().width = 201;
            this.i.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
            this.q.getLayoutParams().width = 201;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public void H(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.m.setVisibility(z ? 0 : 8);
            if (z2) {
                this.m.setText(R.string.obfuscated_res_0x7f0f0d95);
                P(this.m, R.drawable.obfuscated_res_0x7f080938);
                return;
            }
            this.m.setText(R.string.obfuscated_res_0x7f0f0404);
            P(this.m, R.drawable.obfuscated_res_0x7f080937);
        }
    }

    public void I(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.j.setVisibility(z ? 0 : 8);
            if (z2) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0d96);
                P(this.j, R.drawable.obfuscated_res_0x7f080955);
                return;
            }
            this.j.setText(R.string.obfuscated_res_0x7f0f1404);
            P(this.j, R.drawable.obfuscated_res_0x7f080954);
        }
    }

    public void K(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                this.l.setVisibility(z ? 0 : 8);
                if (z2) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f0c6d);
                    P(this.l, R.drawable.obfuscated_res_0x7f08093e);
                    return;
                }
                this.l.setText(R.string.obfuscated_res_0x7f0f05cc);
                P(this.l, R.drawable.obfuscated_res_0x7f08094b);
                return;
            }
            this.l.setVisibility(8);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.n.setVisibility(z ? 0 : 8);
        }
    }

    public void N(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setVisibility(z ? 0 : 8);
            if (z2) {
                this.k.setText(R.string.obfuscated_res_0x7f0f150d);
            } else {
                this.k.setText(R.string.obfuscated_res_0x7f0f0485);
            }
            this.k.setText(R.string.obfuscated_res_0x7f0f118e);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.d.setVisibility(z ? 0 : 8);
        }
    }

    public final void P(TextView textView, int i) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048590, this, textView, i) == null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i2 = x;
        pureDrawable.setBounds(0, 0, i2, i2);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.s.setVisibility(z ? 0 : 8);
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            MaskView.d(this.m, z);
            MaskView.d(this.j, z);
            MaskView.d(this.f, z);
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.t : (TextView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.h : (TextView) invokeV.objValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.i : (TextView) invokeV.objValue;
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.d : (TextView) invokeV.objValue;
    }

    public TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.e : (TextView) invokeV.objValue;
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public TextView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d068f, (ViewGroup) null);
            this.b = inflate;
            this.c = (FlowLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0916e9);
            EMTextView eMTextView = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f5);
            this.o = eMTextView;
            eMTextView.setOnClickListener(this.v);
            EMTextView eMTextView2 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916fc);
            this.k = eMTextView2;
            eMTextView2.setOnClickListener(this.v);
            EMTextView eMTextView3 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f6);
            this.d = eMTextView3;
            eMTextView3.setOnClickListener(this.v);
            EMTextView eMTextView4 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f9);
            this.l = eMTextView4;
            eMTextView4.setOnClickListener(this.v);
            EMTextView eMTextView5 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f7);
            this.e = eMTextView5;
            eMTextView5.setOnClickListener(this.v);
            EMTextView eMTextView6 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f1);
            this.f = eMTextView6;
            eMTextView6.setOnClickListener(this.v);
            EMTextView eMTextView7 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916fb);
            this.n = eMTextView7;
            eMTextView7.setOnClickListener(this.v);
            EMTextView eMTextView8 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f0);
            this.g = eMTextView8;
            eMTextView8.setOnClickListener(this.v);
            EMTextView eMTextView9 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f2);
            this.h = eMTextView9;
            eMTextView9.setOnClickListener(this.v);
            EMTextView eMTextView10 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f3);
            this.i = eMTextView10;
            eMTextView10.setOnClickListener(this.v);
            EMTextView eMTextView11 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f8);
            this.j = eMTextView11;
            eMTextView11.setOnClickListener(this.v);
            EMTextView eMTextView12 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916ef);
            this.m = eMTextView12;
            eMTextView12.setOnClickListener(this.v);
            EMTextView eMTextView13 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916fa);
            this.p = eMTextView13;
            eMTextView13.setOnClickListener(this.v);
            EMTextView eMTextView14 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916f4);
            this.q = eMTextView14;
            eMTextView14.setOnClickListener(this.v);
            this.s = (TextSizeSeekBar) this.b.findViewById(R.id.obfuscated_res_0x7f0916ec);
            this.r = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091d1a);
            EMTextView eMTextView15 = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f0916e8);
            this.t = eMTextView15;
            eMTextView15.setOnClickListener(this.v);
            this.u = this.b.findViewById(R.id.obfuscated_res_0x7f0916e7);
            if (w()) {
                return;
            }
            F();
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.densityDpi;
            return i % 160 == 0 || ((double) ((((float) i) * 1.0f) / 160.0f)) == 1.5d;
        }
        return invokeV.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    public void y() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0213);
            vr4 d = vr4.d(this.r);
            d.n(R.string.J_X14);
            d.f(R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.u, R.color.CAM_X0213);
            SkinManager.setBackgroundResource(this.t, R.color.CAM_X0213);
            SkinManager.setViewTextColorSelector(this.t, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (w()) {
                i = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i = (width - 1005) / 4;
            }
            this.c.setHorizontalSpacing(i);
            P(this.d, R.drawable.obfuscated_res_0x7f080948);
            EMTextView eMTextView = this.n;
            int i2 = R.drawable.obfuscated_res_0x7f080950;
            P(eMTextView, R.drawable.obfuscated_res_0x7f080950);
            P(this.e, R.drawable.obfuscated_res_0x7f080947);
            P(this.f, R.drawable.obfuscated_res_0x7f080943);
            this.f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
            P(this.g, R.drawable.obfuscated_res_0x7f080958);
            EMTextView eMTextView2 = this.h;
            if (!this.w) {
                i2 = R.drawable.obfuscated_res_0x7f08093f;
            }
            P(eMTextView2, i2);
            P(this.i, R.drawable.obfuscated_res_0x7f080939);
            P(this.p, R.drawable.obfuscated_res_0x7f08094f);
            P(this.q, R.drawable.obfuscated_res_0x7f080944);
            P(this.k, R.drawable.obfuscated_res_0x7f080953);
            TextSizeSeekBar textSizeSeekBar = this.s;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.e();
            }
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }
}
