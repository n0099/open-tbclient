package d.a.k0.r1.h.c;

import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f60565a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f60566b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60567c;

    /* renamed from: d  reason: collision with root package name */
    public View f60568d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f60569e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60570f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60571g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f60566b = baseActivity;
        this.f60568d = baseActivity.findViewById(R.id.tail_management_root);
        this.f60565a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f60567c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f60570f = this.f60567c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f60566b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f60567c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f60571g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60570f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f60566b, R.dimen.ds16);
        this.f60570f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f60571g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f60566b, R.dimen.ds16);
        this.f60571g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f60566b, R.dimen.tbds27);
        this.f60571g.setPadding(g2, 0, g2, 0);
        this.f60569e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f60565a.addFooterView(view);
        this.f60565a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f60570f;
    }

    public TextView b() {
        return this.f60571g;
    }

    public void c(int i2) {
        this.f60566b.getLayoutMode().k(i2 == 1);
        this.f60566b.getLayoutMode().j(this.f60568d);
        this.f60569e.c(this.f60566b.getPageContext(), i2);
        this.f60567c.onChangeSkinType(this.f60566b.getPageContext(), i2);
        SkinManager.setViewTextColor(this.f60571g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f60570f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f60571g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f60565a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f60571g.setText(this.f60566b.getPageContext().getString(R.string.done));
            return;
        }
        this.f60571g.setText(this.f60566b.getPageContext().getString(R.string.edit));
        this.f60571g.setEnabled(!z2);
    }
}
