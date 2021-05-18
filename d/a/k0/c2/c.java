package d.a.k0.c2;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.payment.PaymentConfirmActivity;
import com.baidu.tieba.payment.data.PaymentConfirmInfoData;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class c extends d.a.c.a.d<PaymentConfirmActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PaymentConfirmActivity f52533a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f52534b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f52535c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f52536d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f52537e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f52538f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52539g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f52540h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f52541i;
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

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z, int i2) {
        super(paymentConfirmActivity.getPageContext());
        this.w = false;
        this.f52533a = paymentConfirmActivity;
        this.w = z;
        this.x = i2;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        t(paymentConfirmActivity);
        s(paymentConfirmActivity);
    }

    public final SpannableString d(String str, int i2, int i3, int i4) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
        return spannableString;
    }

    public void e() {
        EditText editText = this.s;
        if (editText != null) {
            editText.setText("");
        }
    }

    public void f(PaymentConfirmInfoData paymentConfirmInfoData, boolean z) {
        PaymentConfirmInfoData.OrderInfo.Cpath cpath;
        if (paymentConfirmInfoData == null) {
            return;
        }
        this.f52537e.setVisibility(0);
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (goods_info != null) {
            this.f52538f.V(goods_info.getGoods_pic(), 10, false);
            this.f52539g.setText(goods_info.getGoods_name());
            String numFormatOver10000 = StringHelper.numFormatOver10000(goods_info.getGoods_num());
            this.f52540h.setText(v(this.f52533a.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, SkinManager.getColor(R.color.CAM_X0305)));
            int goods_duration = goods_info.getGoods_duration();
            if (goods_duration > 0) {
                String numFormatOver100002 = StringHelper.numFormatOver10000(goods_duration);
                this.f52541i.setText(v(this.f52533a.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, SkinManager.getColor(R.color.CAM_X0305)));
            } else {
                this.f52541i.setText(d(this.f52533a.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, SkinManager.getColor(R.color.CAM_X0305)));
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(CurrencySwitchUtil.getMoneyIcon(goods_info.getCurrency()), (Drawable) null, (Drawable) null, (Drawable) null);
            if (CurrencySwitchUtil.isYyIsConvert(goods_info.getCurrency())) {
                this.j.setText(CurrencyHelper.getFormatOverBaiwanNum(goods_info.getCurrency(), goods_info.getTdou_num()));
            } else {
                this.j.setText(StringHelper.numFormatOver10000wan(goods_info.getTdou_num()));
            }
            this.k.setText(this.f52533a.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
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
                    this.o.V(icon, 10, false);
                    this.p.setText(desc);
                } else {
                    this.n.setVisibility(8);
                }
            }
            if (cpath.getTip_exist() == 1) {
                this.m.setButtonDrawable(SkinManager.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                this.m.setVisibility(0);
                this.m.setText(this.f52533a.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
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
        EditText editText = this.s;
        if (editText != null) {
            editText.setEnabled(z);
        }
    }

    public void h(boolean z) {
        this.q.setEnabled(z);
    }

    public final SpannableStringBuilder j(long j, int i2) {
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
            d.a.c.j.b bVar = new d.a.c.j.b(getPageContext().getPageActivity(), CurrencySwitchUtil.getMoneyIconBitmap(i2), 1);
            int i3 = indexOf + 1;
            spannableStringBuilder.setSpan(bVar, indexOf, i3, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, i3, str.length() + i3, 33);
        }
        return spannableStringBuilder;
    }

    public ViewGroup k() {
        return this.f52536d;
    }

    public String l() {
        EditText editText = this.s;
        return editText != null ? editText.getText().toString() : "";
    }

    public CheckBox m() {
        return this.m;
    }

    public EditText n() {
        return this.s;
    }

    public TextView o() {
        return this.v;
    }

    public void onChangeSkinType(int i2) {
        d.a.j0.s0.a.a(this.f52533a.getPageContext(), this.f52534b);
        this.f52535c.onChangeSkinType(this.f52533a.getPageContext(), i2);
    }

    public ViewGroup p() {
        if (this.r == null) {
            this.r = (ViewGroup) LayoutInflater.from(this.f52533a.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            d.a.j0.s0.a.a(this.f52533a.getPageContext(), this.r);
            this.s = (EditText) this.r.findViewById(R.id.dialog_input);
            this.t = (ViewGroup) this.r.findViewById(R.id.password_tip_layout);
            this.u = (TextView) this.r.findViewById(R.id.password_input_tip);
            this.v = (TextView) this.r.findViewById(R.id.password_use_tip);
        }
        return this.r;
    }

    public TextView q() {
        return this.q;
    }

    public final String r(String str) {
        return this.w ? this.f52533a.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.f52533a.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
    }

    public final void s(PaymentConfirmActivity paymentConfirmActivity) {
        this.f52536d = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.f52537e = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.f52538f = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.f52539g = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.f52540h = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.f52541i = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.j = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.k = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.l = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.m = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.n = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.o = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.p = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.q = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public final void t(PaymentConfirmActivity paymentConfirmActivity) {
        this.f52534b = (ViewGroup) this.f52533a.findViewById(R.id.payment_root);
        NavigationBar navigationBar = (NavigationBar) this.f52533a.findViewById(R.id.payment_navigation_bar);
        this.f52535c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (CurrencySwitchUtil.isYyIsConvert(this.x)) {
            if (this.w) {
                this.f52535c.setTitleText(this.f52533a.getPageContext().getString(R.string.payment_ybean_confirm_buy_title));
            } else {
                this.f52535c.setTitleText(this.f52533a.getPageContext().getString(R.string.payment_ybean_confirm_title));
            }
        } else if (this.w) {
            this.f52535c.setTitleText(this.f52533a.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.f52535c.setTitleText(this.f52533a.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    public void u() {
        ViewGroup viewGroup = this.r;
        if (viewGroup == null || viewGroup.getParent() == null) {
            return;
        }
        ((ViewGroup) this.r.getParent()).removeAllViews();
    }

    public final SpannableString v(String str, String str2, int i2) {
        int indexOf;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (indexOf = str.indexOf(str2)) >= 0) {
            return d(str, indexOf, str2.length() + indexOf, i2);
        }
        return new SpannableString(str);
    }

    public void w(int i2) {
        ViewGroup viewGroup = this.t;
        if (viewGroup != null) {
            if (i2 == 5) {
                viewGroup.setVisibility(0);
                this.u.setText("");
                this.v.setText(R.string.payment_input_password_forget);
            } else if (i2 > 0) {
                viewGroup.setVisibility(0);
                this.u.setText(this.f52533a.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i2)));
                this.v.setText(R.string.payment_input_password_forget);
            } else {
                viewGroup.setVisibility(0);
                this.u.setText(this.f52533a.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.v.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void x(long j, int i2) {
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
        this.l.setText(j(j, i2));
        this.q.setText(R.string.goto_exchange);
    }
}
