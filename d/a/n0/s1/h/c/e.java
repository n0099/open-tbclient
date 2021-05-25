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
    public BdListView f60688a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f60689b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60690c;

    /* renamed from: d  reason: collision with root package name */
    public View f60691d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f60692e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60693f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60694g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f60689b = baseActivity;
        this.f60691d = baseActivity.findViewById(R.id.tail_management_root);
        this.f60688a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f60690c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f60693f = this.f60690c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f60689b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f60690c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f60694g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f60693f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f60689b, R.dimen.ds16);
        this.f60693f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f60694g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f60689b, R.dimen.ds16);
        this.f60694g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f60689b, R.dimen.tbds27);
        this.f60694g.setPadding(g2, 0, g2, 0);
        this.f60692e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f60688a.addFooterView(view);
        this.f60688a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f60693f;
    }

    public TextView b() {
        return this.f60694g;
    }

    public void c(int i2) {
        this.f60689b.getLayoutMode().k(i2 == 1);
        this.f60689b.getLayoutMode().j(this.f60691d);
        this.f60692e.c(this.f60689b.getPageContext(), i2);
        this.f60690c.onChangeSkinType(this.f60689b.getPageContext(), i2);
        SkinManager.setViewTextColor(this.f60694g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f60693f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f60694g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f60688a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f60694g.setText(this.f60689b.getPageContext().getString(R.string.done));
            return;
        }
        this.f60694g.setText(this.f60689b.getPageContext().getString(R.string.edit));
        this.f60694g.setEnabled(!z2);
    }
}
