package d.a.o0.s1.f;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f64381a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f64382b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64383c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f64384d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f64385e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64386f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64387g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64388h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f64389i;
    public TextView j;
    public TextView k;
    public int l = 3;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(g.this.f64382b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f64381a = tbPageContext.getPageActivity();
        this.f64382b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.f64383c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64383c.showBottomLine();
        this.f64384d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.f64383c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f64385e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.f64386f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.f64387g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.f64389i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.f64388h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.j = textView;
        textView.setOnClickListener(new a());
        c();
    }

    public void b(String str) {
        this.f64387g.setText(String.format(this.f64381a.getString(R.string.pay_member_content), str));
    }

    public final void c() {
        this.k = this.f64383c.setCenterTextTitle(this.f64381a.getString(R.string.card_box_nav_title));
        this.f64384d.c(this.f64382b, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setImageResource(this.f64385e, R.drawable.icon_send_ok);
        SkinManager.setViewTextColor(this.f64386f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f64387g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f64389i, R.color.CAM_X0305);
        SkinManager.setViewTextColor(this.f64388h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
    }

    public void d(int i2) {
        if (this.l != i2) {
            this.f64383c.onChangeSkinType(this.f64382b, i2);
            this.f64384d.c(this.f64382b, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f64385e, R.drawable.icon_send_ok);
            SkinManager.setViewTextColor(this.f64386f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f64387g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f64389i, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f64388h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
        this.l = i2;
    }
}
