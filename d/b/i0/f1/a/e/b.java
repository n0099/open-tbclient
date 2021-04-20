package d.b.i0.f1.a.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListActivity;
import com.baidu.tieba.imMessageCenter.im.stranger.StrangerListAdapter;
import d.b.c.a.d;
/* loaded from: classes4.dex */
public class b extends d<StrangerListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f55801a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f55802b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f55803c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f55804d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f55805e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f55806f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55807g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f55804d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f55802b;
    }

    public View e() {
        return this.f55807g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f55803c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f55803c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55803c.showBottomLine();
        this.f55807g = (ImageView) this.f55803c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f55804d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55807g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f55805e = viewGroup;
        this.f55806f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f55801a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f55801a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f55802b = strangerListAdapter;
        this.f55801a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i) {
        this.f55804d.getLayoutMode().k(i == 1);
        this.f55804d.getLayoutMode().j(this.f55805e);
        this.f55803c.onChangeSkinType(this.f55804d.getPageContext(), i);
        this.f55806f.c(this.f55804d.getPageContext(), i);
        this.f55802b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55807g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
