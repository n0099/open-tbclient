package d.b.i0.e1.a.e;

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
import d.b.b.a.d;
/* loaded from: classes3.dex */
public class b extends d<StrangerListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f54360a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f54361b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54362c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f54363d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f54364e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f54365f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54366g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f54363d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f54361b;
    }

    public View e() {
        return this.f54366g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f54362c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f54362c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54362c.showBottomLine();
        this.f54366g = (ImageView) this.f54362c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f54363d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54366g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f54364e = viewGroup;
        this.f54365f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f54360a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f54360a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f54361b = strangerListAdapter;
        this.f54360a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i) {
        this.f54363d.getLayoutMode().k(i == 1);
        this.f54363d.getLayoutMode().j(this.f54364e);
        this.f54362c.onChangeSkinType(this.f54363d.getPageContext(), i);
        this.f54365f.c(this.f54363d.getPageContext(), i);
        this.f54361b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54366g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
