package d.b.i0.r1.f;

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
    public Context f61125a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f61126b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61127c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f61128d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f61129e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61130f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61131g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f61132h;
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
            UrlManager.getInstance().dealOneLink(g.this.f61126b, new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
        }
    }

    public g(TbPageContext tbPageContext) {
        this.f61125a = tbPageContext.getPageActivity();
        this.f61126b = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.member_pay_result_layout);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.navigation_bar);
        this.f61127c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61127c.showBottomLine();
        this.f61128d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.no_network_view);
        this.f61127c.onChangeSkinType(tbPageContext, TbadkApplication.getInst().getSkinType());
        this.f61129e = (TbImageView) tbPageContext.getPageActivity().findViewById(R.id.success_img);
        this.f61130f = (TextView) tbPageContext.getPageActivity().findViewById(R.id.success_text);
        this.f61131g = (TextView) tbPageContext.getPageActivity().findViewById(R.id.pay_content);
        this.i = (TextView) tbPageContext.getPageActivity().findViewById(R.id.super_member);
        this.f61132h = (TextView) tbPageContext.getPageActivity().findViewById(R.id.tip_content);
        TextView textView = (TextView) tbPageContext.getPageActivity().findViewById(R.id.open_card_box_view);
        this.j = textView;
        textView.setOnClickListener(new a());
        c();
    }

    public void b(String str) {
        this.f61131g.setText(String.format(this.f61125a.getString(R.string.pay_member_content), str));
    }

    public final void c() {
        this.k = this.f61127c.setCenterTextTitle(this.f61125a.getString(R.string.card_box_nav_title));
        this.f61128d.c(this.f61126b, TbadkApplication.getInst().getSkinType());
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
        SkinManager.setImageResource(this.f61129e, R.drawable.icon_send_ok);
        SkinManager.setViewTextColor(this.f61130f, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f61131g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0305);
        SkinManager.setViewTextColor(this.f61132h, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
    }

    public void d(int i) {
        if (this.l != i) {
            this.f61127c.onChangeSkinType(this.f61126b, i);
            this.f61128d.c(this.f61126b, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105);
            SkinManager.setImageResource(this.f61129e, R.drawable.icon_send_ok);
            SkinManager.setViewTextColor(this.f61130f, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f61131g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0305);
            SkinManager.setViewTextColor(this.f61132h, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_orange);
        }
        this.l = i;
    }
}
