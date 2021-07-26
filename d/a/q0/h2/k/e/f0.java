package d.a.q0.h2.k.e;

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
public class f0 extends d.a.d.a.d {
    public static /* synthetic */ Interceptable $ic;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseFragment f57837a;

    /* renamed from: b  reason: collision with root package name */
    public View f57838b;

    /* renamed from: c  reason: collision with root package name */
    public FlowLayout f57839c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f57840d;

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f57841e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f57842f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f57843g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f57844h;

    /* renamed from: i  reason: collision with root package name */
    public EMTextView f57845i;
    public EMTextView j;
    public EMTextView k;
    public EMTextView l;
    public EMTextView m;
    public EMTextView n;
    public EMTextView o;
    public EMTextView p;
    public LinearLayout q;
    public TextSizeSeekBar r;
    public EMTextView s;
    public View t;
    public View.OnClickListener u;
    public boolean v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1844568087, "Ld/a/q0/h2/k/e/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1844568087, "Ld/a/q0/h2/k/e/f0;");
                return;
            }
        }
        w = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds78);
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = null;
        this.u = null;
        this.f57837a = baseFragment;
        this.u = onClickListener;
        initUI();
    }

    public void A(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.n.setVisibility(z ? 0 : 8);
            if (z2) {
                this.n.setText(R.string.group_info_intro_more);
                O(this.n, R.drawable.icon_pure_pb_recommend_all30);
                return;
            }
            this.n.setText(R.string.view_host);
            O(this.n, R.drawable.icon_pure_pb_recommend_host30);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.n.getLayoutParams().width = 201;
            this.j.getLayoutParams().width = 201;
            this.f57840d.getLayoutParams().width = 201;
            this.k.getLayoutParams().width = 201;
            this.f57841e.getLayoutParams().width = 201;
            this.f57842f.getLayoutParams().width = 201;
            this.m.getLayoutParams().width = 201;
            this.f57843g.getLayoutParams().width = 201;
            this.f57844h.getLayoutParams().width = 201;
            this.f57845i.getLayoutParams().width = 201;
            this.l.getLayoutParams().width = 201;
            this.o.getLayoutParams().width = 201;
            this.p.getLayoutParams().width = 201;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f57841e.setVisibility(z ? 0 : 8);
        }
    }

    public void G(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.l.setVisibility(z ? 0 : 8);
            if (z2) {
                this.l.setText(R.string.pb_cancel_good);
                O(this.l, R.drawable.icon_pure_pb_recommend_bested30);
                return;
            }
            this.l.setText(R.string.commit_good);
            O(this.l, R.drawable.icon_pure_pb_recommend_best30);
        }
    }

    public void H(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.f57845i.setVisibility(z ? 0 : 8);
            if (z2) {
                this.f57845i.setText(R.string.pb_cancel_top);
                O(this.f57845i, R.drawable.icon_pure_pb_recommend_toped30);
                return;
            }
            this.f57845i.setText(R.string.top);
            O(this.f57845i, R.drawable.icon_pure_pb_recommend_top30);
        }
    }

    public void I(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.k.setVisibility(z ? 0 : 8);
            if (z2) {
                this.k.setText(R.string.normal_mode);
                O(this.k, R.drawable.icon_pure_pb_recommend_daytime30);
                return;
            }
            this.k.setText(R.string.eyeshield_mode);
            O(this.k, R.drawable.icon_pure_pb_recommend_night30);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.o.setVisibility(z ? 0 : 8);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m.setVisibility(z ? 0 : 8);
        }
    }

    public void L(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.j.setVisibility(z ? 0 : 8);
            if (z2) {
                this.j.setText(R.string.view_reverse);
            } else {
                this.j.setText(R.string.default_sort);
            }
            this.j.setText(R.string.sort_selector);
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f57840d.setVisibility(z ? 0 : 8);
        }
    }

    public final void O(TextView textView, int i2) {
        Drawable pureDrawable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, textView, i2) == null) || textView == null || (pureDrawable = WebPManager.getPureDrawable(i2, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS)) == null) {
            return;
        }
        int i3 = w;
        pureDrawable.setBounds(0, 0, i3, i3);
        textView.setCompoundDrawables(null, pureDrawable, null, null);
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.r.setVisibility(z ? 0 : 8);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            MaskView.b(this.l, z);
            MaskView.b(this.f57845i, z);
            MaskView.b(this.f57842f, z);
        }
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57842f : (TextView) invokeV.objValue;
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (TextView) invokeV.objValue;
    }

    public TextView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f57843g : (TextView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f57844h : (TextView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.p : (TextView) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            View inflate = LayoutInflater.from(this.f57837a.getPageContext().getPageActivity()).inflate(R.layout.pb_more_pop_view, (ViewGroup) null);
            this.f57838b = inflate;
            this.f57839c = (FlowLayout) inflate.findViewById(R.id.pb_more_flowlayout);
            EMTextView eMTextView = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_host_only);
            this.n = eMTextView;
            eMTextView.setOnClickListener(this.u);
            EMTextView eMTextView2 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_reversed);
            this.j = eMTextView2;
            eMTextView2.setOnClickListener(this.u);
            EMTextView eMTextView3 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_jump);
            this.f57840d = eMTextView3;
            eMTextView3.setOnClickListener(this.u);
            EMTextView eMTextView4 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_night_style);
            this.k = eMTextView4;
            eMTextView4.setOnClickListener(this.u);
            EMTextView eMTextView5 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_jump_top);
            this.f57841e = eMTextView5;
            eMTextView5.setOnClickListener(this.u);
            EMTextView eMTextView6 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_call_fans);
            this.f57842f = eMTextView6;
            eMTextView6.setOnClickListener(this.u);
            EMTextView eMTextView7 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_report);
            this.m = eMTextView7;
            eMTextView7.setOnClickListener(this.u);
            EMTextView eMTextView8 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_delete);
            this.f57843g = eMTextView8;
            eMTextView8.setOnClickListener(this.u);
            EMTextView eMTextView9 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_forbidden);
            this.f57844h = eMTextView9;
            eMTextView9.setOnClickListener(this.u);
            EMTextView eMTextView10 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_make_top);
            this.f57845i = eMTextView10;
            eMTextView10.setOnClickListener(this.u);
            EMTextView eMTextView11 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_add_good);
            this.l = eMTextView11;
            eMTextView11.setOnClickListener(this.u);
            EMTextView eMTextView12 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_private);
            this.o = eMTextView12;
            eMTextView12.setOnClickListener(this.u);
            EMTextView eMTextView13 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_view_item_heating_thread);
            this.p = eMTextView13;
            eMTextView13.setOnClickListener(this.u);
            this.r = (TextSizeSeekBar) this.f57838b.findViewById(R.id.pb_more_text_size_seekbar);
            this.q = (LinearLayout) this.f57838b.findViewById(R.id.size_seek_bar_group);
            EMTextView eMTextView14 = (EMTextView) this.f57838b.findViewById(R.id.pb_more_cancel);
            this.s = eMTextView14;
            eMTextView14.setOnClickListener(this.u);
            this.t = this.f57838b.findViewById(R.id.pb_more_bomb_enter_anim_place_holder);
            if (t()) {
                return;
            }
            B();
        }
    }

    public TextView j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.n : (TextView) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f57840d : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f57841e : (TextView) invokeV.objValue;
    }

    public TextView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.l : (TextView) invokeV.objValue;
    }

    public TextView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f57845i : (TextView) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public TextView p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.o : (TextView) invokeV.objValue;
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.m : (TextView) invokeV.objValue;
    }

    public TextView r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f57838b : (View) invokeV.objValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) this.f57837a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.densityDpi;
            return i2 % 160 == 0 || ((double) ((((float) i2) * 1.0f) / 160.0f)) == 1.5d;
        }
        return invokeV.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    public void v() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            SkinManager.setBackgroundColor(this.f57839c, R.color.CAM_X0204);
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.q);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.t, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0204);
            SkinManager.setViewTextColorSelector(this.s, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f57840d, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57841e, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57842f, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57843g, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57845i, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.f57844h, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0107, 1);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0107, 1);
            int width = ((WindowManager) this.f57837a.getBaseFragmentActivity().getSystemService("window")).getDefaultDisplay().getWidth() - (UtilHelper.getDimenPixelSize(R.dimen.M_W_X007) * 2);
            if (t()) {
                i2 = (width - (UtilHelper.getDimenPixelSize(R.dimen.tbds201) * 5)) / 4;
            } else {
                i2 = (width - 1005) / 4;
            }
            this.f57839c.setHorizontalSpacing(i2);
            O(this.f57840d, R.drawable.icon_pure_pb_recommend_jump30);
            O(this.m, R.drawable.icon_pure_pb_recommend_report30);
            O(this.f57841e, R.drawable.icon_pure_pb_recommend_initial30);
            O(this.f57842f, R.drawable.icon_pure_pb_recommend_fans30);
            this.f57842f.setAlpha(TbSingleton.getInstance().mCanCallFans ? 1.0f : 0.33f);
            O(this.f57843g, this.v ? R.drawable.icon_pure_pb_recommend_report30 : R.drawable.icon_pure_pb_recommend_delete30);
            O(this.f57844h, R.drawable.icon_pure_pb_recommend_block30);
            O(this.o, R.drawable.icon_pure_pb_recommend_private30);
            O(this.p, R.drawable.icon_pure_pb_recommend_fire_30);
            O(this.j, R.drawable.icon_pure_pb_recommend_sort30);
            TextSizeSeekBar textSizeSeekBar = this.r;
            if (textSizeSeekBar != null) {
                textSizeSeekBar.e();
            }
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.f57842f.setVisibility(z ? 0 : 8);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.f57843g.setVisibility(z ? 0 : 8);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.f57844h.setVisibility(z ? 0 : 8);
        }
    }

    public void z(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.p.setVisibility(z ? 0 : 8);
            if (z2) {
                this.p.setText(R.string.heating_thread);
            } else {
                this.p.setText(R.string.help_heating_thread);
            }
        }
    }
}
