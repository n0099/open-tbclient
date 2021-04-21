package d.b.j0.r1.h.c;

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
    public BdListView f61664a;

    /* renamed from: b  reason: collision with root package name */
    public BaseActivity<?> f61665b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61666c;

    /* renamed from: d  reason: collision with root package name */
    public View f61667d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f61668e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61669f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61670g;

    public e(BaseActivity<?> baseActivity, View.OnClickListener onClickListener) {
        this.f61665b = baseActivity;
        this.f61667d = baseActivity.findViewById(R.id.tail_management_root);
        this.f61664a = (BdListView) baseActivity.findViewById(R.id.tail_management_listview);
        NavigationBar navigationBar = (NavigationBar) baseActivity.findViewById(R.id.tail_management_navigation_bar);
        this.f61666c = navigationBar;
        navigationBar.setCenterTextTitle(baseActivity.getPageContext().getString(R.string.tail_management));
        this.f61669f = this.f61666c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.f61665b.getString(R.string.cancel), onClickListener);
        TextView addTextButton = this.f61666c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getPageContext().getString(R.string.edit), onClickListener);
        this.f61670g = addTextButton;
        addTextButton.setGravity(17);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f61669f.getLayoutParams();
        layoutParams.leftMargin = l.g(this.f61665b, R.dimen.ds16);
        this.f61669f.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f61670g.getLayoutParams();
        layoutParams2.rightMargin = l.g(this.f61665b, R.dimen.ds16);
        this.f61670g.setLayoutParams(layoutParams2);
        int g2 = l.g(this.f61665b, R.dimen.tbds27);
        this.f61670g.setPadding(g2, 0, g2, 0);
        this.f61668e = (NoNetworkView) baseActivity.findViewById(R.id.tail_view_no_network);
        View view = new View(baseActivity.getPageContext().getPageActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds70)));
        View view2 = new View(baseActivity.getPageContext().getPageActivity());
        view2.setLayoutParams(new AbsListView.LayoutParams(-1, (int) baseActivity.getResources().getDimension(R.dimen.ds28)));
        this.f61664a.addFooterView(view);
        this.f61664a.addHeaderView(view2);
    }

    public TextView a() {
        return this.f61669f;
    }

    public TextView b() {
        return this.f61670g;
    }

    public void c(int i) {
        this.f61665b.getLayoutMode().k(i == 1);
        this.f61665b.getLayoutMode().j(this.f61667d);
        this.f61668e.c(this.f61665b.getPageContext(), i);
        this.f61666c.onChangeSkinType(this.f61665b.getPageContext(), i);
        SkinManager.setViewTextColor(this.f61670g, R.color.navbar_btn_color);
        SkinManager.setViewTextColor(this.f61669f, R.color.navi_back_text_color);
        SkinManager.setBackgroundResource(this.f61670g, R.drawable.s_navbar_button_bg);
    }

    public void d(a aVar) {
        this.f61664a.setAdapter((ListAdapter) aVar);
    }

    public void e(boolean z, boolean z2) {
        if (z) {
            this.f61670g.setText(this.f61665b.getPageContext().getString(R.string.done));
            return;
        }
        this.f61670g.setText(this.f61665b.getPageContext().getString(R.string.edit));
        this.f61670g.setEnabled(!z2);
    }
}
