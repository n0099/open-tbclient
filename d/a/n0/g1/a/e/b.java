package d.a.n0.g1.a.e;

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
    public BdListView f54996a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f54997b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54998c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f54999d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f55000e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f55001f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55002g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f54999d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f54997b;
    }

    public View e() {
        return this.f55002g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f54998c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f54998c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54998c.showBottomLine();
        this.f55002g = (ImageView) this.f54998c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f54999d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55002g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f55000e = viewGroup;
        this.f55001f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f54996a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f54996a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f54997b = strangerListAdapter;
        this.f54996a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i2) {
        this.f54999d.getLayoutMode().k(i2 == 1);
        this.f54999d.getLayoutMode().j(this.f55000e);
        this.f54998c.onChangeSkinType(this.f54999d.getPageContext(), i2);
        this.f55001f.c(this.f54999d.getPageContext(), i2);
        this.f54997b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55002g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
