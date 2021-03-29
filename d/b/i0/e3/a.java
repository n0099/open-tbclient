package d.b.i0.e3;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tbadk.util.PageDialogHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbean.BuyTBeanActivity;
import com.baidu.tieba.tbean.view.BuyTBeanGiftBagView;
import com.baidu.tieba.tbean.view.RoundRelativeLayout;
import com.baidu.tieba.view.NoScrollGridView;
import com.baidu.tieba.view.bubbleView.BubbleLayout;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import java.util.List;
import tbclient.GetIconList.Custom;
import tbclient.GetIconList.IconInfo;
import tbclient.GetIconList.Setting;
import tbclient.GetIconList.UserInfo;
/* loaded from: classes5.dex */
public class a {
    public int A;
    public int B;
    public int C;
    public RelativeLayout D;
    public BubbleLayout E;
    public boolean F;
    public View.OnClickListener G = new View$OnClickListenerC1243a();
    public View.OnClickListener H = new b();
    public AdapterView.OnItemClickListener I = new c();
    public BuyTBeanGiftBagView.b J = new d();
    public Runnable K = new e();
    public TextWatcher L = new f();

    /* renamed from: a  reason: collision with root package name */
    public BuyTBeanActivity f54573a;

    /* renamed from: b  reason: collision with root package name */
    public View f54574b;

    /* renamed from: c  reason: collision with root package name */
    public RoundRelativeLayout f54575c;

    /* renamed from: d  reason: collision with root package name */
    public NoScrollGridView f54576d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.e3.d.a f54577e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54578f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54579g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f54580h;
    public TextView i;
    public d.b.i0.e3.e.c j;
    public TextView k;
    public LinearLayout l;
    public TextView m;
    public boolean n;
    public TextView o;
    public LinearLayout p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public SpannableString u;
    public ImageView v;
    public TextView w;
    public BuyTBeanGiftBagView x;
    public UserInfo y;
    public RelativeLayout z;

    /* renamed from: d.b.i0.e3.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1243a implements View.OnClickListener {
        public View$OnClickListenerC1243a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f54580h.requestFocus();
            l.J(a.this.f54573a, a.this.f54580h);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.u();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            IconInfo iconInfo;
            d.b.i0.e3.e.b item = a.this.f54577e.getItem(i);
            if (item == null || (iconInfo = item.f54596f) == null) {
                return;
            }
            a.this.E(item.f54596f.iconId, d.b.i0.e3.b.d(iconInfo.dubi.intValue()) * 1, 1, d.b.i0.e3.b.c(a.this.y, item.f54596f.non_member_t.intValue(), item.f54595e) * 1);
            StatisticItem statisticItem = new StatisticItem("c13147");
            statisticItem.param("obj_param1", item.f54596f.iconId);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements BuyTBeanGiftBagView.b {
        public d() {
        }

        @Override // com.baidu.tieba.tbean.view.BuyTBeanGiftBagView.b
        public void a(d.b.i0.e3.e.a aVar) {
            Custom custom;
            if (aVar == null || (custom = aVar.f54592e) == null) {
                return;
            }
            a.this.E(aVar.f54592e.icon_id, d.b.i0.e3.b.d(custom.dubi.intValue()) * 1, 1, aVar.f54592e.non_member_t.intValue() * 1);
            TiebaStatic.log("c13144");
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.E != null) {
                a.this.E.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = a.this.f54580h.getText().toString();
            if (StringUtils.isNull(obj)) {
                if (a.this.n) {
                    a.this.k.setVisibility(8);
                    a.this.m.setText(String.format(a.this.f54573a.getString(R.string.user_define_member_tbean_extra), a.this.j.f54600g.vip_extra_percent));
                }
                a.this.o.setEnabled(false);
                a.this.f54580h.setHint(a.this.u);
            } else if (obj.startsWith("0")) {
                if (a.this.n) {
                    a.this.k.setVisibility(8);
                    a.this.m.setText(String.format(a.this.f54573a.getString(R.string.user_define_member_tbean_extra), a.this.j.f54600g.vip_extra_percent));
                }
                a.this.f54580h.setText("");
            } else {
                a.this.o.setEnabled(true);
                if (!StringUtils.isNull(obj) && obj.length() >= 7) {
                    a.this.f54573a.showToast(R.string.buy_tbean_custom_price_max);
                    String substring = obj.substring(0, 6);
                    a.this.f54580h.setText(substring);
                    a.this.f54580h.setSelection(substring.length());
                    return;
                }
                long f2 = d.b.b.e.m.b.f(obj, 0L);
                if (f2 > 200000) {
                    a.this.f54573a.showToast(R.string.buy_tbean_custom_price_max);
                }
                if (f2 <= 0) {
                    a.this.i.setText(R.string.user_define_init_value);
                    return;
                }
                a.this.f54580h.setHint("");
                long j = f2 * 1000;
                a.this.i.setText(StringHelper.formatTosepara(j));
                if (!a.this.n || a.this.j == null || a.this.j.f54600g == null) {
                    return;
                }
                a.this.k.setVisibility(0);
                a.this.k.setText(d.b.i0.e3.b.b((j * a.this.j.f54600g.vip_extra_percent.intValue()) / 100));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredHeight = a.this.f54574b.getMeasuredHeight();
            int measuredHeight2 = a.this.p.getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a.this.p.getLayoutParams();
            if (layoutParams != null) {
                a.this.C = measuredHeight - measuredHeight2;
                layoutParams.topMargin = a.this.C;
                a.this.p.setLayoutParams(layoutParams);
            }
            a aVar = a.this;
            aVar.A = aVar.z.getHeight();
        }
    }

    public a(BuyTBeanActivity buyTBeanActivity) {
        this.f54573a = buyTBeanActivity;
        z();
    }

    public boolean A() {
        return this.F;
    }

    public void B(int i) {
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.p);
        a2.h(R.string.J_X14);
        a2.c(R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.f54579g, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.f54578f, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.s, R.color.common_color_10191, 1, i);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
        if (i != 1 && i != 4) {
            this.f54575c.setBgColorRes(R.color.CAM_X0201);
        } else {
            this.f54575c.setBgColorRes(R.color.CAM_X0201_1);
        }
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor(this.w, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0107, 1, i);
        SkinManager.setViewTextColor(this.f54580h, R.color.CAM_X0105, 1, i);
        SkinManager.setViewTextColor((TextView) this.f54574b.findViewById(R.id.buy_tbean_custom_price_prefix), R.color.CAM_X0105, 1, i);
        d.b.i0.e3.d.a aVar = this.f54577e;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public void C() {
        d.b.b.e.m.e.a().removeCallbacks(this.K);
    }

    public void D(boolean z) {
        if (z) {
            this.F = true;
            if (this.B <= 0) {
                this.B = (l.i(this.f54573a) - this.f54574b.getHeight()) - l.r(this.f54573a);
            }
            int height = ((this.B + this.f54575c.getHeight()) + this.D.getHeight()) - this.A;
            if (height > 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
                layoutParams.topMargin -= height;
                this.p.setLayoutParams(layoutParams);
                this.z.scrollTo(0, this.B - height);
            } else {
                this.z.scrollTo(0, this.B);
            }
            EditText editText = this.f54580h;
            editText.setSelection(editText.getText().length());
            TiebaStatic.log("c13145");
            return;
        }
        this.F = false;
        this.z.scrollTo(0, 0);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        layoutParams2.topMargin = this.C;
        this.p.setLayoutParams(layoutParams2);
        this.f54580h.clearFocus();
    }

    public final void E(String str, int i, int i2, int i3) {
        if (StringUtils.isNull(str) || i < 0 || i2 < 0 || i3 < 0) {
            return;
        }
        if (!j.z()) {
            BuyTBeanActivity buyTBeanActivity = this.f54573a;
            buyTBeanActivity.showToast(buyTBeanActivity.getResources().getString(R.string.network_not_available));
            return;
        }
        d.b.i0.e3.c.a("c10296");
        PayConfig payConfig = new PayConfig(2, "0", str, String.valueOf(i), String.valueOf(i2), true, String.valueOf(i3), this.f54573a.isPayDialog(), PageDialogHelper.PayForm.NOT_SET, this.f54573a.getReferPage(), this.f54573a.getClickZone());
        payConfig.setFromDecreaseGiftStepStrategy(this.f54573a.isFromDecreaseGiftStepStrategy());
        d.b.h0.l0.c.c().a(payConfig, this.f54573a);
    }

    public final void F(boolean z) {
        if (z) {
            this.o.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(0, R.id.buy_tbean_recharge);
            layoutParams.addRule(15);
            layoutParams.rightMargin = this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds34);
            this.f54580h.setLayoutParams(layoutParams);
            return;
        }
        this.o.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f54580h.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds42);
        }
    }

    public void G(List<d.b.i0.e3.e.b> list, d.b.i0.e3.e.c cVar, List<d.b.i0.e3.e.a> list2, UserInfo userInfo) {
        if (userInfo != null) {
            this.y = userInfo;
        }
        if (!ListUtils.isEmpty(list)) {
            int i = ListUtils.getCount(list) == 6 ? 3 : 2;
            this.f54576d.setNumColumns(i);
            this.f54577e.b(i);
            this.f54577e.c(list);
        }
        if (cVar != null) {
            this.j = cVar;
            Setting setting = cVar.f54600g;
            if (setting != null && setting.vip_extra_switch.intValue() == 1 && this.j.f54600g.vip_extra_percent.intValue() > 0) {
                this.n = true;
                this.l.setVisibility(0);
                this.k.setVisibility(8);
                this.m.setText(String.format(this.f54573a.getString(R.string.user_define_member_tbean_extra), this.j.f54600g.vip_extra_percent));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f54575c.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds208);
                    this.f54575c.setLayoutParams(layoutParams);
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds203);
                    this.o.setLayoutParams(layoutParams2);
                }
            } else {
                this.l.setVisibility(8);
                this.n = false;
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f54575c.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.height = this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds174);
                    this.f54575c.setLayoutParams(layoutParams3);
                }
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                if (layoutParams4 != null) {
                    layoutParams4.width = this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds176);
                    this.o.setLayoutParams(layoutParams4);
                }
            }
            Custom custom = this.j.f54598e;
            if (custom != null) {
                Integer num = custom.duration;
                this.w.setText(this.f54573a.getString(R.string.icon_name_valid_day, new Object[]{this.j.f54598e.name, Integer.valueOf(num == null ? 0 : num.intValue())}));
            }
        }
        if (!ListUtils.isEmpty(list2)) {
            this.x.d(list2);
        }
        this.p.post(new g());
    }

    public void H(long j) {
        if (j > 0) {
            EditText editText = this.f54580h;
            StringBuilder sb = new StringBuilder();
            long j2 = j / 1000;
            sb.append(j2);
            sb.append("");
            editText.setText(sb.toString());
            EditText editText2 = this.f54580h;
            editText2.setSelection(editText2.getText().length());
            TextView textView = this.s;
            textView.setText((j2 * 1000) + "");
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            if (d.b.h0.r.d0.b.i().g("key_tbean_buy_bubble_show", false)) {
                return;
            }
            BubbleLayout bubbleLayout = this.E;
            if (bubbleLayout != null) {
                bubbleLayout.setVisibility(0);
                d.b.h0.r.d0.b.i().s("key_tbean_buy_bubble_show", true);
            }
            d.b.b.e.m.e.a().removeCallbacks(this.K);
            d.b.b.e.m.e.a().postDelayed(this.K, PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL);
            return;
        }
        this.f54580h.setText("");
        this.E.setVisibility(8);
    }

    public void I() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds500);
            this.p.setLayoutParams(layoutParams);
        }
        BuyTBeanActivity buyTBeanActivity = this.f54573a;
        buyTBeanActivity.setNetRefreshViewTopMargin(buyTBeanActivity.getResources().getDimensionPixelSize(R.dimen.ds50));
        BuyTBeanActivity buyTBeanActivity2 = this.f54573a;
        buyTBeanActivity2.showNetRefreshView(this.z, buyTBeanActivity2.getResources().getString(R.string.neterror));
    }

    public void J() {
        View view = this.f54574b;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void u() {
        d.b.i0.e3.e.c cVar;
        UserInfo userInfo;
        int d2 = d.b.b.e.m.b.d(this.f54580h.getText().toString(), 0);
        int i = d2 * 1;
        if (i > 200000) {
            this.f54573a.showToast(R.string.buy_tbean_custom_price_max);
        } else if (i <= 0 || i <= 0 || (cVar = this.j) == null || (userInfo = cVar.f54599f) == null || cVar.f54598e == null) {
        } else {
            E(this.j.f54598e.icon_id, i, d2, d.b.i0.e3.b.c(userInfo, i * 1000, cVar.f54600g) * 1);
            TiebaStatic.log("c13141");
        }
    }

    public View v() {
        return this.f54574b;
    }

    public void w() {
        this.f54573a.hideNetRefreshView(this.z);
    }

    public void x() {
        View view = this.f54574b;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void y() {
        this.f54580h.clearFocus();
        l.w(this.f54573a, this.f54580h);
    }

    public final void z() {
        View inflate = LayoutInflater.from(this.f54573a).inflate(R.layout.buy_tbean_view_layout, (ViewGroup) null);
        this.f54574b = inflate;
        inflate.setFocusable(true);
        this.f54574b.setOnClickListener(this.f54573a);
        this.p = (LinearLayout) this.f54574b.findViewById(R.id.buy_tbean_panel_layout);
        RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) this.f54574b.findViewById(R.id.buy_tbean_custom_t_dou_layout);
        this.f54575c = roundRelativeLayout;
        roundRelativeLayout.setRadius(this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.f54575c.setOnClickListener(this.G);
        this.z = (RelativeLayout) this.f54574b.findViewById(R.id.buy_tbean_content_layout);
        this.r = (TextView) this.f54574b.findViewById(R.id.buy_tbean_title);
        this.f54576d = (NoScrollGridView) this.f54574b.findViewById(R.id.buy_tbean_gridview);
        d.b.i0.e3.d.a aVar = new d.b.i0.e3.d.a(this.f54573a.getPageContext());
        this.f54577e = aVar;
        this.f54576d.setAdapter((ListAdapter) aVar);
        this.f54576d.setOnItemClickListener(this.I);
        this.D = (RelativeLayout) this.f54574b.findViewById(R.id.buy_tbean_balance_layout);
        this.f54579g = (TextView) this.f54574b.findViewById(R.id.buy_tbean_balance_tip);
        TextView textView = (TextView) this.f54574b.findViewById(R.id.buy_tbean_balance);
        this.f54578f = textView;
        textView.setText(String.valueOf(TbadkCoreApplication.getInst().currentAccountTdouNum));
        Drawable drawable = this.f54573a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize = this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds46);
        drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
        this.f54578f.setCompoundDrawablePadding(this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds12));
        this.f54578f.setCompoundDrawables(drawable, null, null, null);
        this.f54580h = (EditText) this.f54574b.findViewById(R.id.buy_tbean_custom_price_edit);
        this.u = new SpannableString(this.f54573a.getString(R.string.buy_tbean_user_define_hint));
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.f54573a.getResources().getDimensionPixelSize(R.dimen.tbds42), false);
        SpannableString spannableString = this.u;
        spannableString.setSpan(absoluteSizeSpan, 0, spannableString.length(), 33);
        this.f54580h.setHint(this.u);
        this.f54580h.addTextChangedListener(this.L);
        TextView textView2 = (TextView) this.f54574b.findViewById(R.id.buy_tbean_custom_t_dou_num);
        this.i = textView2;
        textView2.setCompoundDrawablePadding(this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.i.setCompoundDrawables(drawable, null, null, null);
        this.l = (LinearLayout) this.f54574b.findViewById(R.id.buy_tbean_member_layout);
        this.k = (TextView) this.f54574b.findViewById(R.id.buy_tbean_member_privilege);
        Drawable drawable2 = this.f54573a.getResources().getDrawable(R.drawable.icon_huobi_tdou);
        int dimensionPixelSize2 = this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds20);
        drawable2.setBounds(0, 0, dimensionPixelSize2, dimensionPixelSize2);
        this.k.setCompoundDrawablePadding(this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds6));
        this.k.setCompoundDrawables(drawable2, null, null, null);
        this.m = (TextView) this.f54574b.findViewById(R.id.buy_tbean_member_prefix);
        TextView textView3 = (TextView) this.f54574b.findViewById(R.id.buy_tbean_recharge);
        this.o = textView3;
        textView3.setOnClickListener(this.H);
        TextView textView4 = (TextView) this.f54574b.findViewById(R.id.buy_tbean_use_rule);
        this.q = textView4;
        textView4.setOnClickListener(this.f54573a);
        TextView textView5 = (TextView) this.f54574b.findViewById(R.id.buy_tbean_diff_value);
        this.s = textView5;
        textView5.setCompoundDrawablePadding(this.f54573a.getResources().getDimensionPixelSize(R.dimen.ds8));
        this.s.setCompoundDrawables(drawable, null, null, null);
        this.t = (TextView) this.f54574b.findViewById(R.id.buy_tbean_diff_value_tip);
        ImageView imageView = (ImageView) this.f54574b.findViewById(R.id.buy_tbean_close_image);
        this.v = imageView;
        imageView.setOnClickListener(this.f54573a);
        this.w = (TextView) this.f54574b.findViewById(R.id.buy_tbean_yinji_time);
        BuyTBeanGiftBagView buyTBeanGiftBagView = (BuyTBeanGiftBagView) this.f54574b.findViewById(R.id.buy_tbean_gift_bag_layout);
        this.x = buyTBeanGiftBagView;
        buyTBeanGiftBagView.setClickListener(this.J);
        this.E = (BubbleLayout) this.f54574b.findViewById(R.id.buy_tbean_pop_view);
        F(true);
    }
}
