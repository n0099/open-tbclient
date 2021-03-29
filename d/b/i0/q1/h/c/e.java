package d.b.i0.q1.h.c;

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
import d.b.b.e.p.l;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f59549a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f59550b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59551c;

    /* renamed from: d  reason: collision with root package name */
    public View f59552d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59553e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59554f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59555g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f59550b = baseActivity;
        this.f59552d = baseActivity.findViewById(R.id.tail_management_root);
        this.f59549a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f59551c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f59554f = this.f59551c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f59550b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f59551c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f59555g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59554f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f59550b, R.dimen.ds16);
        this.f59554f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f59555g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f59550b, R.dimen.ds16);
        this.f59555g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f59550b, R.dimen.tbds27);
        this.f59555g.setPadding(g2, 0, g2, 0);
        this.f59553e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f59549a.addFooterView(view);
        this.f59549a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f59554f;
    }

    public TextView b() {
        return this.f59555g;
    }

    public void c(int i) {
        this.f59550b.getLayoutMode().k(i == 1);
        this.f59550b.getLayoutMode().j(this.f59552d);
        this.f59553e.c(this.f59550b.getPageContext(), i);
        this.f59551c.onChangeSkinType(this.f59550b.getPageContext(), i);
        SkinManager.setViewTextColor(this.f59555g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f59554f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f59555g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f59549a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f59555g.setText(this.f59550b.getPageContext().getString(R.string.done));
            return;
        }
        this.f59555g.setText(this.f59550b.getPageContext().getString(R.string.edit));
        this.f59555g.setEnabled(!z2);
    }
}
