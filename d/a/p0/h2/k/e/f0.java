package d.a.p0.h2.k.e;

import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes8.dex */
public class f0 extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public static final int v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f57260a;

    /* renamed from: b  reason: collision with root package name */
    public View f57261b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f57262c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f57263d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f57264e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f57265f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f57266g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f57267h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f57268i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public LinearLayout p;
    public TextSizeSeekBar q;
    public EMTextView r;
    public View s;
    public View.OnClickListener t;
    public boolean u;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1551165080, "Ld/a/p0/h2/k/e/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1551165080, "Ld/a/p0/h2/k/e/f0;");
                return;
            }
        }
        v = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(BaseFragment baseFragment, View.OnClickListener onClickListener) {
        super(baseFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = null;
        this.t = null;
        this.f57260a = baseFragment;
        this.t = onClickListener;
        initUI();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f57264e.setVisibility(z ? 0 : 8);
        }
    }

    public void B(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.l.setVisibility(z ? 0 : 8);
            if (z2) {
                this.l.setText(R.string.pb_cancel_good);
                L(this.l, R.drawable.icon_pure_pb_recommend_bested30);
                return;
            }
            this.l.setText(R.string.commit_good);
            L(this.l, R.drawable.icon_pure_pb_recommend_best30);
        }
    }

    public void F(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f57268i.setVisibility(z ? 0 : 8);
            if (z2) {
                this.f57268i.setText(R.string.pb_cancel_top);
                L(this.f57268i, R.drawable.icon_pure_pb_recommend_toped30);
                return;
            }
            this.f57268i.setText(R.string.top);
            L(this.f57268i, R.drawable.icon_pure_pb_recommend_top30);
        }
    }

    public void G(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setVisibility(z ? 0 : 8);
            if (z2) {
                this.k.setText(R.string.normal_mode);
                L(this.k, R.drawable.icon_pure_pb_recommend_daytime30);
                return;
            }
            this.k.setText(R.string.eyeshield_mode);
            L(this.k, R.drawable.icon_pure_pb_recommend_night30);
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.o.setVisibility(z ? 0 : 8);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.m.setVisibility(z ? 0 : 8);
        }
    }

    public void J(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.j.setVisibility(z ? 0 : 8);
            if (z2) {
                this.j.setText(R.string.view_reverse);
            } else {
                this.j.setText(R.string.default_sort);
            }
            this.j.setText(R.string.sort_selector);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f57263d.setVisibility(z ? 0 : 8);
        }
    }

    public final void L(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, textView, i2) == null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = v;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.q.setVisibility(z ? 0 : 8);
        }
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            MaskView.b(this.l, z);
            MaskView.b(this.f57268i, z);
            MaskView.b(this.f57265f, z);
        }
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f57265f : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.r : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57266g : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f57267h : (TextView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            View inflate = LayoutInflater.from(this.f57260a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
            this.f57261b = inflate;
            this.f57262c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
            EMTextView eMTextView = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_host_only);
            this.n = eMTextView;
            eMTextView.setOnClickListener(this.t);
            EMTextView eMTextView2 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_reversed);
            this.j = eMTextView2;
            eMTextView2.setOnClickListener(this.t);
            EMTextView eMTextView3 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_jump);
            this.f57263d = eMTextView3;
            eMTextView3.setOnClickListener(this.t);
            EMTextView eMTextView4 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_night_style);
            this.k = eMTextView4;
            eMTextView4.setOnClickListener(this.t);
            EMTextView eMTextView5 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_jump_top);
            this.f57264e = eMTextView5;
            eMTextView5.setOnClickListener(this.t);
            EMTextView eMTextView6 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_call_fans);
            this.f57265f = eMTextView6;
            eMTextView6.setOnClickListener(this.t);
            EMTextView eMTextView7 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_report);
            this.m = eMTextView7;
            eMTextView7.setOnClickListener(this.t);
            EMTextView eMTextView8 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_delete);
            this.f57266g = eMTextView8;
            eMTextView8.setOnClickListener(this.t);
            EMTextView eMTextView9 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_forbidden);
            this.f57267h = eMTextView9;
            eMTextView9.setOnClickListener(this.t);
            EMTextView eMTextView10 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_make_top);
            this.f57268i = eMTextView10;
            eMTextView10.setOnClickListener(this.t);
            EMTextView eMTextView11 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_add_good);
            this.l = eMTextView11;
            eMTextView11.setOnClickListener(this.t);
            EMTextView eMTextView12 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_view_item_private);
            this.o = eMTextView12;
            eMTextView12.setOnClickListener(this.t);
            this.q = (TextSizeSeekBar) this.f57261b.findViewById(R.id.pb_more_text_size_seekbar);
            this.p = (LinearLayout) this.f57261b.findViewById(R.id.size_seek_bar_group);
            EMTextView eMTextView13 = (EMTextView) this.f57261b.findViewById(R.id.pb_more_cancel);
            this.r = eMTextView13;
            eMTextView13.setOnClickListener(this.t);
            this.s = this.f57261b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
            if (s()) {
                return;
            }
            z();
        }
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f57263d : (TextView) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f57264e : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f57268i : (TextView) invokeV.objValue;
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f57261b : (View) invokeV.objValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.f57260a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.densityDpi;
            return i2 % 160 == 0 || ((double) ((((float) i2) * 1.0f) / 160.0f)) == 1.5d;
        }
        return invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    public void u() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            SkinManager.setBackgroundColor(this.f57262c, R.color.CAM_X0204);
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.p);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.r, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f57263d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57264e, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57265f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57266g, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57268i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57267h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.f57260a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (s()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i2 = (width - 1005) / 4;
            }
            this.f57262c.setHorizontalSpacing(i2);
            L(this.f57263d, R.drawable.icon_pure_pb_recommend_jump30);
            L(this.m, R.drawable.icon_pure_pb_recommend_report30);
            L(this.f57264e, R.drawable.icon_pure_pb_recommend_initial30);
            L(this.f57265f, R.drawable.icon_pure_pb_recommend_fans30);
            this.f57265f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
            L(this.f57266g, this.u ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
            L(this.f57267h, R.drawable.icon_pure_pb_recommend_block30);
            L(this.o, R.drawable.icon_pure_pb_recommend_private30);
            L(this.j, R.drawable.icon_pure_pb_recommend_sort30);
            TextSizeSeekBar textSizeSeekBar = this.q;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.e();
            }
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.f57265f.setVisibility(z ? 0 : 8);
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.f57266g.setVisibility(z ? 0 : 8);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.f57267h.setVisibility(z ? 0 : 8);
        }
    }

    public void y(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.n.setVisibility(z ? 0 : 8);
            if (z2) {
                this.n.setText(R.string.group_info_intro_more);
                L(this.n, R.drawable.icon_pure_pb_recommend_all30);
                return;
            }
            this.n.setText(R.string.view_host);
            L(this.n, R.drawable.icon_pure_pb_recommend_host30);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.n.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.f57263d.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.f57264e.getLayoutParams().width = 201;
            this.f57265f.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.f57266g.getLayoutParams().width = 201;
            this.f57267h.getLayoutParams().width = 201;
            this.f57268i.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.o.getLayoutParams().width = 201;
        }
    }
}
