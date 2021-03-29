package d.b.i0.q1.d;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.memberExchange.MemberExchangeActivity;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59332a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59333b;

    /* renamed from: c  reason: collision with root package name */
    public View f59334c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59335d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59336e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59337f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f59338g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59339h;
    public TextView i;
    public TbImageView j;
    public EditText k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public int q = 3;

    public a(MemberExchangeActivity memberExchangeActivity) {
        TbPageContext<MemberExchangeActivity> pageContext = memberExchangeActivity.getPageContext();
        this.f59332a = pageContext;
        this.f59333b = pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        View findViewById = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.f59334c = findViewById;
        findViewById.setOnClickListener(memberExchangeActivity);
        NavigationBar navigationBar = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.f59335d = navigationBar;
        navigationBar.setOnClickListener(memberExchangeActivity);
        this.f59337f = this.f59335d.setCenterTextTitle(this.f59332a.getString(R.string.exchange_member));
        this.f59336e = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.f59335d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59335d.showBottomLine();
        HeadImageView headImageView = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.f59338g = headImageView;
        headImageView.setIsRound(true);
        this.f59339h = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.i = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.j = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.k = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.w(this.f59332a.getPageActivity(), this.k);
        TextView textView = (TextView) memberExchangeActivity.findViewById(R.id.go_to_exchange);
        this.l = textView;
        textView.setOnClickListener(memberExchangeActivity);
        TextView textView2 = (TextView) memberExchangeActivity.findViewById(R.id.rule_title);
        this.m = textView2;
        textView2.setOnClickListener(null);
        TextView textView3 = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_1);
        this.n = textView3;
        textView3.setClickable(false);
        TextView textView4 = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_2);
        this.o = textView4;
        textView4.setClickable(false);
        TextView textView5 = (TextView) memberExchangeActivity.findViewById(R.id.rule_text_3);
        this.p = textView5;
        textView5.setClickable(false);
        c(TbadkApplication.getInst().getSkinType());
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        this.f59338g.W(str, 12, false);
        this.f59339h.setText(str2);
        if (!k.isEmpty(str3)) {
            this.j.setVisibility(0);
            this.j.W(str3, 10, false);
        } else {
            this.j.setVisibility(8);
        }
        if (!k.isEmpty(str4)) {
            TextView textView = this.i;
            textView.setText(this.f59332a.getString(R.string.vip_member_end_time_tips) + str4);
            return;
        }
        this.i.setText(str5);
    }

    public EditText b() {
        return this.k;
    }

    public void c(int i) {
        if (this.q != i) {
            this.f59335d.onChangeSkinType(this.f59332a, i);
            this.f59336e.c(this.f59332a, i);
            SkinManager.setViewTextColor(this.f59339h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
            this.k.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SkinManager.setBackgroundResource(this.k, R.drawable.exchange_edit_text_bg);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.l, R.drawable.btn_all_orange);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        }
        this.q = i;
    }
}
