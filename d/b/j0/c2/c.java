package d.b.j0.c2;

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
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class c extends d.b.c.a.d<PaymentConfirmActivity> {

    /* renamed from: a  reason: collision with root package name */
    public PaymentConfirmActivity f54061a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f54062b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54063c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f54064d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f54065e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f54066f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54067g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f54068h;
    public TextView i;
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

    public c(PaymentConfirmActivity paymentConfirmActivity, boolean z) {
        super(paymentConfirmActivity.getPageContext());
        this.w = false;
        this.f54061a = paymentConfirmActivity;
        this.w = z;
        paymentConfirmActivity.setContentView(R.layout.payment_confirm_activity);
        v(paymentConfirmActivity);
        u(paymentConfirmActivity);
    }

    public final SpannableString d(String str, int i, int i2, int i3) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
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
        this.f54065e.setVisibility(0);
        PaymentConfirmInfoData.GoodsInfo goods_info = paymentConfirmInfoData.getGoods_info();
        if (goods_info != null) {
            this.f54066f.W(goods_info.getGoods_pic(), 10, false);
            this.f54067g.setText(goods_info.getGoods_name());
            String numFormatOver10000 = StringHelper.numFormatOver10000(goods_info.getGoods_num());
            this.f54068h.setText(x(this.f54061a.getResources().getString(R.string.payment_confirm_goods_num, numFormatOver10000) + goods_info.getGoods_unit(), numFormatOver10000, SkinManager.getColor(R.color.CAM_X0305)));
            int goods_duration = goods_info.getGoods_duration();
            if (goods_duration > 0) {
                String numFormatOver100002 = StringHelper.numFormatOver10000(goods_duration);
                this.i.setText(x(this.f54061a.getResources().getString(R.string.payment_confirm_goods_timelength, numFormatOver100002), numFormatOver100002, SkinManager.getColor(R.color.CAM_X0305)));
            } else {
                this.i.setText(d(this.f54061a.getResources().getString(R.string.payment_confirm_goods_timelength_default), 3, 5, SkinManager.getColor(R.color.CAM_X0305)));
            }
            this.j.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.icon_huobi_tdou), (Drawable) null, (Drawable) null, (Drawable) null);
            this.j.setText(StringHelper.numFormatOver10000wan(goods_info.getTdou_num()));
            this.k.setText(this.f54061a.getResources().getString(R.string.payment_confirm_goods_name_tip, goods_info.getGoods_name()));
            if (z) {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                this.l.setText(i(goods_info.getTdou_num()));
            } else {
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0301, 1);
                this.l.setText(R.string.payment_confirm_goods_price_tip_notenough);
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
                    this.o.W(icon, 10, false);
                    this.p.setText(desc);
                } else {
                    this.n.setVisibility(8);
                }
            }
            if (cpath.getTip_exist() == 1) {
                this.m.setButtonDrawable(SkinManager.getDrawable(R.drawable.payment_confirm_price_tip_check_button));
                this.m.setVisibility(0);
                this.m.setText(this.f54061a.getResources().getString(R.string.payment_confirm_notshow_page, Integer.valueOf(cpath.getTip_days())));
            } else {
                this.m.setVisibility(8);
            }
        }
        if (z) {
            if (this.w) {
                this.q.setText(R.string.buy_now);
                return;
            } else {
                this.q.setText(R.string.goto_exchange);
                return;
            }
        }
        this.q.setText(R.string.get_tdou);
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

    public final SpannableStringBuilder i(long j) {
        String str = "" + j;
        String s = s(str);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(s);
        int indexOf = s.indexOf(str);
        if (indexOf >= 0) {
            spannableStringBuilder.insert(indexOf, (CharSequence) " ");
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0305));
            int i = indexOf + 1;
            spannableStringBuilder.setSpan(new d.b.c.j.b(getPageContext().getPageActivity(), SkinManager.getBitmap(R.drawable.icon_huobi_tdou), 1), indexOf, i, 33);
            spannableStringBuilder.setSpan(foregroundColorSpan, i, str.length() + i, 33);
        }
        return spannableStringBuilder;
    }

    public ViewGroup k() {
        return this.f54064d;
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

    public void onChangeSkinType(int i) {
        d.b.i0.s0.a.a(this.f54061a.getPageContext(), this.f54062b);
        this.f54063c.onChangeSkinType(this.f54061a.getPageContext(), i);
    }

    public ViewGroup q() {
        if (this.r == null) {
            this.r = (ViewGroup) LayoutInflater.from(this.f54061a.getPageContext().getPageActivity()).inflate(R.layout.input_password_dialog, (ViewGroup) null, false);
            d.b.i0.s0.a.a(this.f54061a.getPageContext(), this.r);
            this.s = (EditText) this.r.findViewById(R.id.dialog_input);
            this.t = (ViewGroup) this.r.findViewById(R.id.password_tip_layout);
            this.u = (TextView) this.r.findViewById(R.id.password_input_tip);
            this.v = (TextView) this.r.findViewById(R.id.password_use_tip);
        }
        return this.r;
    }

    public TextView r() {
        return this.q;
    }

    public final String s(String str) {
        return this.w ? this.f54061a.getResources().getString(R.string.payment_confirm_goods_price_buy_tip, str) : this.f54061a.getResources().getString(R.string.payment_confirm_goods_price_tip, str);
    }

    public final void u(PaymentConfirmActivity paymentConfirmActivity) {
        this.f54064d = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_content);
        this.f54065e = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_view_operate);
        this.f54066f = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_goods_pic);
        this.f54067g = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name);
        this.f54068h = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_num);
        this.i = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_timelength);
        this.j = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price);
        this.k = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_name_tip);
        this.l = (TextView) paymentConfirmActivity.findViewById(R.id.payment_goods_price_tip);
        this.m = (CheckBox) paymentConfirmActivity.findViewById(R.id.payment_page_show);
        this.n = (ViewGroup) paymentConfirmActivity.findViewById(R.id.payment_member_show);
        this.o = (TbImageView) paymentConfirmActivity.findViewById(R.id.payment_member_icon);
        this.p = (TextView) paymentConfirmActivity.findViewById(R.id.payment_member_desc);
        this.q = (TextView) paymentConfirmActivity.findViewById(R.id.payment_performance);
    }

    public final void v(PaymentConfirmActivity paymentConfirmActivity) {
        this.f54062b = (ViewGroup) this.f54061a.findViewById(R.id.payment_root);
        NavigationBar navigationBar = (NavigationBar) this.f54061a.findViewById(R.id.payment_navigation_bar);
        this.f54063c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        if (this.w) {
            this.f54063c.setTitleText(this.f54061a.getPageContext().getString(R.string.payment_confirm_buy_title));
        } else {
            this.f54063c.setTitleText(this.f54061a.getPageContext().getString(R.string.payment_confirm_title));
        }
    }

    public void w() {
        ViewGroup viewGroup = this.r;
        if (viewGroup == null || viewGroup.getParent() == null) {
            return;
        }
        ((ViewGroup) this.r.getParent()).removeAllViews();
    }

    public final SpannableString x(String str, String str2, int i) {
        int indexOf;
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && (indexOf = str.indexOf(str2)) >= 0) {
            return d(str, indexOf, str2.length() + indexOf, i);
        }
        return new SpannableString(str);
    }

    public void y(int i) {
        ViewGroup viewGroup = this.t;
        if (viewGroup != null) {
            if (i == 5) {
                viewGroup.setVisibility(0);
                this.u.setText("");
                this.v.setText(R.string.payment_input_password_forget);
            } else if (i > 0) {
                viewGroup.setVisibility(0);
                this.u.setText(this.f54061a.getResources().getString(R.string.payment_input_password_remainder_time, Integer.valueOf(i)));
                this.v.setText(R.string.payment_input_password_forget);
            } else {
                viewGroup.setVisibility(0);
                this.u.setText(this.f54061a.getResources().getString(R.string.payment_input_password_remainder_no_time));
                this.v.setText(R.string.sapi_forget_password_title);
            }
        }
    }

    public void z(long j) {
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
        this.l.setText(i(j));
        this.q.setText(R.string.goto_exchange);
    }
}
