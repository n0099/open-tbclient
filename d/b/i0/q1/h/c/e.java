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
    public BdListView f59548a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f59549b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59550c;

    /* renamed from: d  reason: collision with root package name */
    public View f59551d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59552e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59553f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59554g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f59549b = baseActivity;
        this.f59551d = baseActivity.findViewById(R.id.tail_management_root);
        this.f59548a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f59550c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f59553f = this.f59550c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f59549b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f59550c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f59554g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59553f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f59549b, R.dimen.ds16);
        this.f59553f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f59554g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f59549b, R.dimen.ds16);
        this.f59554g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f59549b, R.dimen.tbds27);
        this.f59554g.setPadding(g2, 0, g2, 0);
        this.f59552e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f59548a.addFooterView(view);
        this.f59548a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f59553f;
    }

    public TextView b() {
        return this.f59554g;
    }

    public void c(int i) {
        this.f59549b.getLayoutMode().k(i == 1);
        this.f59549b.getLayoutMode().j(this.f59551d);
        this.f59552e.c(this.f59549b.getPageContext(), i);
        this.f59550c.onChangeSkinType(this.f59549b.getPageContext(), i);
        SkinManager.setViewTextColor(this.f59554g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f59553f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f59554g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f59548a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f59554g.setText(this.f59549b.getPageContext().getString(R.string.done));
            return;
        }
        this.f59554g.setText(this.f59549b.getPageContext().getString(R.string.edit));
        this.f59554g.setEnabled(!z2);
    }
}
