package d.b.j0.r1.f;

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
    public Context f61546a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61547b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61548c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f61549d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f61550e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61551f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61552g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61553h;
    public TextView i;
    public TextView j;
    public TextView k;
    public int l = 3;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(g.this.f61547b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f61546a = tbPageContext.getPageActivity();
        this.f61547b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.f61548c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61548c.showBottomLine();
        this.f61549d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.f61548c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f61550e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.f61551f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.f61552g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.f61553h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.j = textView;
        textView.setOnClickListener(new a());
        c();
    }

    public void b(String str) {
        this.f61552g.setText(String.format(this.f61546a.getString(R.string.pay_member_content), str));
    }

    public final void c() {
        this.k = this.f61548c.setCenterTextTitle(this.f61546a.getString(R.string.card_box_nav_title));
        this.f61549d.c(this.f61547b, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setImageResource(this.f61550e, R.drawable.icon_send_ok);
        SkinManager.setViewTextColor(this.f61551f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61552g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0305);
        SkinManager.setViewTextColor(this.f61553h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
    }

    public void d(int i) {
        if (this.l != i) {
            this.f61548c.onChangeSkinType(this.f61547b, i);
            this.f61549d.c(this.f61547b, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f61550e, R.drawable.icon_send_ok);
            SkinManager.setViewTextColor(this.f61551f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61552g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f61553h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
        this.l = i;
    }
}
