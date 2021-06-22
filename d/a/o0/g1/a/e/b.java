package d.a.o0.g1.a.e;

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
import d.a.c.a.d;
/* loaded from: classes4.dex */
public class b extends d<StrangerListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f58810a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f58811b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58812c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f58813d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f58814e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f58815f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f58816g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f58813d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f58811b;
    }

    public View e() {
        return this.f58816g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f58812c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f58812c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58812c.showBottomLine();
        this.f58816g = (ImageView) this.f58812c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f58813d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58816g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f58814e = viewGroup;
        this.f58815f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f58810a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f58810a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f58811b = strangerListAdapter;
        this.f58810a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i2) {
        this.f58813d.getLayoutMode().k(i2 == 1);
        this.f58813d.getLayoutMode().j(this.f58814e);
        this.f58812c.onChangeSkinType(this.f58813d.getPageContext(), i2);
        this.f58815f.c(this.f58813d.getPageContext(), i2);
        this.f58811b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f58816g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
