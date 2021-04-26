package d.a.j0.r1.d;

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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59592a;

    /* renamed from: b  reason: collision with root package name */
    public Context f59593b;

    /* renamed from: c  reason: collision with root package name */
    public View f59594c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59595d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59596e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59597f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f59598g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f59599h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59600i;
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
        this.f59592a = pageContext;
        this.f59593b = pageContext.getPageActivity();
        memberExchangeActivity.setContentView(R.layout.member_exchange_layout);
        View findViewById = memberExchangeActivity.findViewById(R.id.member_exchange_root);
        this.f59594c = findViewById;
        findViewById.setOnClickListener(memberExchangeActivity);
        NavigationBar navigationBar = (NavigationBar) memberExchangeActivity.findViewById(R.id.navigation_bar);
        this.f59595d = navigationBar;
        navigationBar.setOnClickListener(memberExchangeActivity);
        this.f59597f = this.f59595d.setCenterTextTitle(this.f59592a.getString(R.string.exchange_member));
        this.f59596e = (NoNetworkView) memberExchangeActivity.findViewById(R.id.no_network_view);
        this.f59595d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f59595d.showBottomLine();
        HeadImageView headImageView = (HeadImageView) memberExchangeActivity.findViewById(R.id.member_header_image);
        this.f59598g = headImageView;
        headImageView.setIsRound(true);
        this.f59599h = (TextView) memberExchangeActivity.findViewById(R.id.member_name);
        this.f59600i = (TextView) memberExchangeActivity.findViewById(R.id.member_content);
        this.j = (TbImageView) memberExchangeActivity.findViewById(R.id.member_level);
        this.k = (EditText) memberExchangeActivity.findViewById(R.id.exchange_code);
        l.x(this.f59592a.getPageActivity(), this.k);
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
        this.f59598g.V(str, 12, false);
        this.f59599h.setText(str2);
        if (!k.isEmpty(str3)) {
            this.j.setVisibility(0);
            this.j.V(str3, 10, false);
        } else {
            this.j.setVisibility(8);
        }
        if (!k.isEmpty(str4)) {
            TextView textView = this.f59600i;
            textView.setText(this.f59592a.getString(R.string.vip_member_end_time_tips) + str4);
            return;
        }
        this.f59600i.setText(str5);
    }

    public EditText b() {
        return this.k;
    }

    public void c(int i2) {
        if (this.q != i2) {
            this.f59595d.onChangeSkinType(this.f59592a, i2);
            this.f59596e.c(this.f59592a, i2);
            SkinManager.setViewTextColor(this.f59599h, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f59600i, R.color.CAM_X0109);
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
        this.q = i2;
    }
}
