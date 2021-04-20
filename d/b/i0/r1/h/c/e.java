package d.b.i0.r1.h.c;

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
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f61243a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f61244b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61245c;

    /* renamed from: d  reason: collision with root package name */
    public View f61246d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61247e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61248f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61249g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f61244b = baseActivity;
        this.f61246d = baseActivity.findViewById(R.id.tail_management_root);
        this.f61243a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f61245c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f61248f = this.f61245c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f61244b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f61245c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f61249g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61248f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f61244b, R.dimen.ds16);
        this.f61248f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f61249g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f61244b, R.dimen.ds16);
        this.f61249g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f61244b, R.dimen.tbds27);
        this.f61249g.setPadding(g2, 0, g2, 0);
        this.f61247e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f61243a.addFooterView(view);
        this.f61243a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f61248f;
    }

    public TextView b() {
        return this.f61249g;
    }

    public void c(int i) {
        this.f61244b.getLayoutMode().k(i == 1);
        this.f61244b.getLayoutMode().j(this.f61246d);
        this.f61247e.c(this.f61244b.getPageContext(), i);
        this.f61245c.onChangeSkinType(this.f61244b.getPageContext(), i);
        SkinManager.setViewTextColor(this.f61249g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f61248f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f61249g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f61243a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f61249g.setText(this.f61244b.getPageContext().getString(R.string.done));
            return;
        }
        this.f61249g.setText(this.f61244b.getPageContext().getString(R.string.edit));
        this.f61249g.setEnabled(!z2);
    }
}
