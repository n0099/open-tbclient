package d.a.j0.f1.a.e;

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
    public BdListView f54101a;

    /* renamed from: b  reason: collision with root package name */
    public StrangerListAdapter f54102b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54103c;

    /* renamed from: d  reason: collision with root package name */
    public StrangerListActivity f54104d;

    /* renamed from: e  reason: collision with root package name */
    public ViewGroup f54105e;

    /* renamed from: f  reason: collision with root package name */
    public NoNetworkView f54106f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54107g;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.f54104d = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    public StrangerListAdapter d() {
        return this.f54102b;
    }

    public View e() {
        return this.f54107g;
    }

    public final void f(StrangerListActivity strangerListActivity) {
        NavigationBar navigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.f54103c = navigationBar;
        navigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.f54103c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54103c.showBottomLine();
        this.f54107g = (ImageView) this.f54103c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.f54104d);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54107g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        ViewGroup viewGroup = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.f54105e = viewGroup;
        this.f54106f = (NoNetworkView) viewGroup.findViewById(R.id.no_network_view);
    }

    public final void g(StrangerListActivity strangerListActivity) {
        BdListView bdListView = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.f54101a = bdListView;
        bdListView.setOnItemClickListener(strangerListActivity);
        this.f54101a.setOnItemLongClickListener(strangerListActivity);
        StrangerListAdapter strangerListAdapter = new StrangerListAdapter(strangerListActivity);
        this.f54102b = strangerListAdapter;
        this.f54101a.setAdapter((ListAdapter) strangerListAdapter);
    }

    public void onChangeSkinType(int i2) {
        this.f54104d.getLayoutMode().k(i2 == 1);
        this.f54104d.getLayoutMode().j(this.f54105e);
        this.f54103c.onChangeSkinType(this.f54104d.getPageContext(), i2);
        this.f54106f.c(this.f54104d.getPageContext(), i2);
        this.f54102b.notifyDataSetChanged();
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54107g, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }
}
