package d.a.n0.s1.h.c;

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
    public BdListView f64379a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f64380b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64381c;

    /* renamed from: d  reason: collision with root package name */
    public View f64382d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f64383e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f64384f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f64385g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f64380b = baseActivity;
        this.f64382d = baseActivity.findViewById(R.id.tail_management_root);
        this.f64379a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f64381c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f64384f = this.f64381c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f64380b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f64381c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f64385g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f64384f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f64380b, R.dimen.ds16);
        this.f64384f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f64385g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f64380b, R.dimen.ds16);
        this.f64385g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f64380b, R.dimen.tbds27);
        this.f64385g.setPadding(g2, 0, g2, 0);
        this.f64383e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f64379a.addFooterView(view);
        this.f64379a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f64384f;
    }

    public TextView b() {
        return this.f64385g;
    }

    public void c(int i2) {
        this.f64380b.getLayoutMode().k(i2 == 1);
        this.f64380b.getLayoutMode().j(this.f64382d);
        this.f64383e.c(this.f64380b.getPageContext(), i2);
        this.f64381c.onChangeSkinType(this.f64380b.getPageContext(), i2);
        SkinManager.setViewTextColor(this.f64385g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f64384f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f64385g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f64379a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f64385g.setText(this.f64380b.getPageContext().getString(R.string.done));
            return;
        }
        this.f64385g.setText(this.f64380b.getPageContext().getString(R.string.edit));
        this.f64385g.setEnabled(!z2);
    }
}
