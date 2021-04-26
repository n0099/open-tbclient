package d.a.j0.r1.h.c;

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
    public BdListView f59820a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f59821b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59822c;

    /* renamed from: d  reason: collision with root package name */
    public View f59823d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f59824e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59825f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f59826g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f59821b = baseActivity;
        this.f59823d = baseActivity.findViewById(R.id.tail_management_root);
        this.f59820a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f59822c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f59825f = this.f59822c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f59821b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f59822c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f59826g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f59825f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f59821b, R.dimen.ds16);
        this.f59825f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f59826g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f59821b, R.dimen.ds16);
        this.f59826g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f59821b, R.dimen.tbds27);
        this.f59826g.setPadding(g2, 0, g2, 0);
        this.f59824e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f59820a.addFooterView(view);
        this.f59820a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f59825f;
    }

    public TextView b() {
        return this.f59826g;
    }

    public void c(int i2) {
        this.f59821b.getLayoutMode().k(i2 == 1);
        this.f59821b.getLayoutMode().j(this.f59823d);
        this.f59824e.c(this.f59821b.getPageContext(), i2);
        this.f59822c.onChangeSkinType(this.f59821b.getPageContext(), i2);
        SkinManager.setViewTextColor(this.f59826g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f59825f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f59826g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f59820a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f59826g.setText(this.f59821b.getPageContext().getString(R.string.done));
            return;
        }
        this.f59826g.setText(this.f59821b.getPageContext().getString(R.string.edit));
        this.f59826g.setEnabled(!z2);
    }
}
