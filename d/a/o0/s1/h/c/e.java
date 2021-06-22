package d.a.o0.s1.h.c;

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
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f64504a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f64505b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64506c;

    /* renamed from: d  reason: collision with root package name */
    public View f64507d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f64508e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64509f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64510g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f64505b = baseActivity;
        this.f64507d = baseActivity.findViewById(R.id.tail_management_root);
        this.f64504a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f64506c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f64509f = this.f64506c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f64505b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f64506c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f64510g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f64509f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f64505b, R.dimen.ds16);
        this.f64509f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f64510g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f64505b, R.dimen.ds16);
        this.f64510g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f64505b, R.dimen.tbds27);
        this.f64510g.setPadding(g2, 0, g2, 0);
        this.f64508e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f64504a.addFooterView(view);
        this.f64504a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f64509f;
    }

    public TextView b() {
        return this.f64510g;
    }

    public void c(int i2) {
        this.f64505b.getLayoutMode().k(i2 == 1);
        this.f64505b.getLayoutMode().j(this.f64507d);
        this.f64508e.c(this.f64505b.getPageContext(), i2);
        this.f64506c.onChangeSkinType(this.f64505b.getPageContext(), i2);
        SkinManager.setViewTextColor(this.f64510g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f64509f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f64510g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f64504a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f64510g.setText(this.f64505b.getPageContext().getString(R.string.done));
            return;
        }
        this.f64510g.setText(this.f64505b.getPageContext().getString(R.string.edit));
        this.f64510g.setEnabled(!z2);
    }
}
