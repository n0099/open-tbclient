package d.a.n0.s1.f;

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
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f60565a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f60566b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60567c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f60568d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60569e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60570f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60571g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60572h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f60573i;
    public TextView j;
    public TextView k;
    public int l = 3;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(g.this.f60566b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f60565a = tbPageContext.getPageActivity();
        this.f60566b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.f60567c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60567c.showBottomLine();
        this.f60568d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.f60567c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f60569e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.f60570f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.f60571g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.f60573i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.f60572h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.j = textView;
        textView.setOnClickListener(new a());
        c();
    }

    public void b(String str) {
        this.f60571g.setText(String.format(this.f60565a.getString(R.string.pay_member_content), str));
    }

    public final void c() {
        this.k = this.f60567c.setCenterTextTitle(this.f60565a.getString(R.string.card_box_nav_title));
        this.f60568d.c(this.f60566b, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setImageResource(this.f60569e, R.drawable.icon_send_ok);
        SkinManager.setViewTextColor(this.f60570f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60571g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60573i, R.color.CAM_X0305);
        SkinManager.setViewTextColor(this.f60572h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
    }

    public void d(int i2) {
        if (this.l != i2) {
            this.f60567c.onChangeSkinType(this.f60566b, i2);
            this.f60568d.c(this.f60566b, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f60569e, R.drawable.icon_send_ok);
            SkinManager.setViewTextColor(this.f60570f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60571g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60573i, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f60572h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
        this.l = i2;
    }
}
