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
/* loaded from: classes4.dex */
public class b extends d<StrangerListActivity> {

    /* renamed from: a  reason: collision with root package name */
    public BdListView f54359a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f54360b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54361c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f54362d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f54363e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f54364f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54365g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f54362d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f54360b;
    }

    public View e() {
        return this.f54365g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f54361c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f54361c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54361c.showBottomLine();
        this.f54365g = (ImageView) this.f54361c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f54362d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54365g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f54363e = viewGroup;
        this.f54364f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f54359a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f54359a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f54360b = strangerListAdapter;
        this.f54359a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i) {
        this.f54362d.getLayoutMode().k(i == 1);
        this.f54362d.getLayoutMode().j(this.f54363e);
        this.f54361c.onChangeSkinType(this.f54362d.getPageContext(), i);
        this.f54364f.c(this.f54362d.getPageContext(), i);
        this.f54360b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54365g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
