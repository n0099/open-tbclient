package d.a.p0.g2;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.PaymentConfirmActivity;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class c extends d.a.c.a.d<PaymentConfirmActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public PaymentConfirmActivity f56556a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f56557b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56558c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f56559d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f56560e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f56561f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56562g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56563h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56564i;
    public TextView j;
    public TextView k;
    public TextView l;
    public CheckBox m;
    public ViewGroup n;
    public TbImageView o;
    public TextView p;
    public TextView q;
    public ViewGroup r;
    public EditText s;
    public ViewGroup t;
    public TextView u;
    public TextView v;
    public boolean w;
    public int x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z, int i2) {
        super(paymentConfirmActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {paymentConfirmActivity, Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = false;
        this.f56556a = paymentConfirmActivity;
        this.w = z;
        this.x = i2;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        t(paymentConfirmActivity);
        s(paymentConfirmActivity);
    }

    public final SpannableString d(String str, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, str, i2, i3, i4)) == null) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
            return spannableString;
        }
        return (SpannableString) invokeLIII.objValue;
    }

    public void e() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.s) == null) {
            return;
        }
        editText.setText("");
    }

    public void f(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, paymentConfirmInfoData, z) == null) || paymentConfirmInfoData == null) {
            return;
        }
        this.f56560e.setVisibility(0);
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (goods_info != null) {
            this.f56561f.M(goods_info.getGoods_pic(), 10, false);
            this.f56562g.setText(goods_info.getGoods_name());
            String numFormatOver10000 = StringHelper.numFormatOver10000(goods_info.getGoods_num());
            this.f56563h.setText(v(this.f56556a.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, SkinManager.getColor(R.color.CAM_X0305)));
            int goods_duration = goods_info.getGoods_duration();
            if (goods_duration > 0) {
                String numFormatOver100002 = StringHelper.numFormatOver10000(goods_duration);
                this.f56564i.setText(v(this.f56556a.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, SkinManager.getColor(R.color.CAM_X0305)));
            } else {
                this.f56564i.setText(d(this.f56556a.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, SkinManager.getColor(R.color.CAM_X0305)));
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(CurrencySwitchUtil.getMoneyIcon(goods_info.getCurrency()), (Drawable) null, (Drawable) null, (Drawable) null);
            if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                this.j.setText(CurrencyHelper.getFormatOverBaiwanNum(goods_info.getCurrency(), goods_info.getTdou_num()));
            } else {
                this.j.setText(StringHelper.numFormatOver10000wan(goods_info.getTdou_num()));
            }
            this.k.setText(this.f56556a.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
            if (z) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                this.l.setText(j(goods_info.getTdou_num(), goods_info.getCurrency()));
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0301, 1);
                if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                    this.l.setText(R.string.payment_ybean_confirm_goods_price_tip_notenough);
                } else {
                    this.l.setText(R.string.payment_confirm_goods_price_tip_notenough);
                }
            }
        }
        PaymentConfirmInfoData.OrderInfo order_info = paymentConfirmInfoData.getOrder_info();
        if (order_info != null && (cpath = order_info.getCpath()) != null) {
            PaymentConfirmInfoData.OrderInfo.Cpath.Member member = cpath.getMember();
            if (member != null) {
                String icon = member.getIcon();
                String desc = member.getDesc();
                if (!StringUtils.isNull(icon) && !StringUtils.isNull(desc)) {
                    this.n.setVisibility(0);
                    this.o.M(icon, 10, false);
                    this.p.setText(desc);
                } else {
                    this.n.setVisibility(8);
                }
            }
            if (cpath.getTip_exist() == 1) {
                this.m.setButtonDrawable(SkinManager.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                this.m.setVisibility(0);
                this.m.setText(this.f56556a.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
            } else {
                this.m.setVisibility(8);
            }
        }
        if (z) {
            if (this.w) {
                this.q.setText(R.string.buy_now);
            } else {
                this.q.setText(R.string.goto_exchange);
            }
        } else if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
            this.q.setText(R.string.get_ybean);
        } else {
            this.q.setText(R.string.get_tdou);
        }
    }

    public void g(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (editText = this.s) == null) {
            return;
        }
        editText.setEnabled(z);
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.q.setEnabled(z);
        }
    }

    public final SpannableStringBuilder j(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) {
            String str = "" + j;
            if (CurrencySwitchUtil.isYyIsConvert(i2)) {
                str = "" + CurrencyHelper.getFormatOverBaiwanNum(i2, j);
            }
            String r = r(str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(r);
            int indexOf = r.indexOf(str);
            if (indexOf >= 0) {
                spannableStringBuilder.insert(indexOf, (CharSequence) " ");
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
                d.a.c.k.b bVar = new d.a.c.k.b(getPageContext().getPageActivity(), CurrencySwitchUtil.getMoneyIconBitmap(i2), 1);
                int i3 = indexOf + 1;
                spannableStringBuilder.setSpan(bVar, indexOf, i3, 33);
                spannableStringBuilder.setSpan(foregroundColorSpan, i3, str.length() + i3, 33);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public ViewGroup k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f56559d : (ViewGroup) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            EditText editText = this.s;
            return editText != null ? editText.getText().toString() : "";
        }
        return (String) invokeV.objValue;
    }

    public CheckBox m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (CheckBox) invokeV.objValue;
    }

    public EditText n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.s : (EditText) invokeV.objValue;
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v : (TextView) invokeV.objValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            d.a.o0.s0.a.a(this.f56556a.getPageContext(), this.f56557b);
            this.f56558c.onChangeSkinType(this.f56556a.getPageContext(), i2);
        }
    }

    public ViewGroup p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.r == null) {
                this.r = (ViewGroup) LayoutInflater.from(this.f56556a.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
                d.a.o0.s0.a.a(this.f56556a.getPageContext(), this.r);
                this.s = (EditText) this.r.findViewById(R.id.dialog_input);
                this.t = (ViewGroup) this.r.findViewById(R.id.password_tip_layout);
                this.u = (TextView) this.r.findViewById(R.id.password_input_tip);
                this.v = (TextView) this.r.findViewById(R.id.password_use_tip);
            }
            return this.r;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.q : (TextView) invokeV.objValue;
    }

    public final String r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.w ? this.f56556a.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.f56556a.getResources().getString(R.string.payment_confirm_goods_price_tip, str) : (String) invokeL.objValue;
    }

    public final void s(PaymentConfirmActivity paymentConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, paymentConfirmActivity) == null) {
            this.f56559d = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
            this.f56560e = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
            this.f56561f = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
            this.f56562g = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
            this.f56563h = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
            this.f56564i = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
            this.j = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
            this.k = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
            this.l = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
            this.m = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
            this.n = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
            this.o = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
            this.p = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
            this.q = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
        }
    }

    public final void t(PaymentConfirmActivity paymentConfirmActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, paymentConfirmActivity) == null) {
            this.f56557b = (ViewGroup) this.f56556a.findViewById(R.id.payment_root);
            NavigationBar navigationBar = (NavigationBar) this.f56556a.findViewById(R.id.payment_navigation_bar);
            this.f56558c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
                if (this.w) {
                    this.f56558c.setTitleText(this.f56556a.getPageContext().getString(R.string.payment_ybean_confirm_buy_title));
                } else {
                    this.f56558c.setTitleText(this.f56556a.getPageContext().getString(R.string.payment_ybean_confirm_title));
                }
            } else if (this.w) {
                this.f56558c.setTitleText(this.f56556a.getPageContext().getString(R.string.payment_confirm_buy_title));
            } else {
                this.f56558c.setTitleText(this.f56556a.getPageContext().getString(R.string.payment_confirm_title));
            }
        }
    }

    public void u() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (viewGroup = this.r) == null || viewGroup.getParent() == null) {
            return;
        }
        ((ViewGroup) this.r.getParent()).removeAllViews();
    }

    public final SpannableString v(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, str, str2, i2)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (indexOf = str.indexOf(str2)) >= 0) {
                return d(str, indexOf, str2.length() + indexOf, i2);
            }
            return new SpannableString(str);
        }
        return (SpannableString) invokeLLI.objValue;
    }

    public void w(int i2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (viewGroup = this.t) == null) {
            return;
        }
        if (i2 == 5) {
            viewGroup.setVisibility(0);
            this.u.setText("");
            this.v.setText(R.string.payment_input_password_forget);
        } else if (i2 > 0) {
            viewGroup.setVisibility(0);
            this.u.setText(this.f56556a.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i2)));
            this.v.setText(R.string.payment_input_password_forget);
        } else {
            viewGroup.setVisibility(0);
            this.u.setText(this.f56556a.getResources().getString(R.string.payment_input_password_remainder_no_time));
            this.v.setText(R.string.sapi_forget_password_title);
        }
    }

    public void x(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
            this.l.setText(j(j, i2));
            this.q.setText(R.string.goto_exchange);
        }
    }
}
