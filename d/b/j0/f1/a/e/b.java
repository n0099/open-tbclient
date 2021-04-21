package d.b.j0.f1.a.e;

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
    public BdListView f56222a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f56223b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56224c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f56225d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f56226e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f56227f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56228g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f56225d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f56223b;
    }

    public View e() {
        return this.f56228g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f56224c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f56224c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56224c.showBottomLine();
        this.f56228g = (ImageView) this.f56224c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f56225d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56228g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f56226e = viewGroup;
        this.f56227f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f56222a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f56222a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f56223b = strangerListAdapter;
        this.f56222a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i) {
        this.f56225d.getLayoutMode().k(i == 1);
        this.f56225d.getLayoutMode().j(this.f56226e);
        this.f56224c.onChangeSkinType(this.f56225d.getPageContext(), i);
        this.f56227f.c(this.f56225d.getPageContext(), i);
        this.f56223b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56228g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
