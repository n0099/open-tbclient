package d.b.j0.j3.d;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.b.c.e.p.l;
import d.b.j0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.b.c.a.d<AvatarPendantActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d f58096a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f58097b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f58098c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f58099d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f58100e;

    /* renamed from: f  reason: collision with root package name */
    public int f58101f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f58102g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58103h;
    public AvatarPendantActivity i;
    public View j;
    public TextView k;

    /* loaded from: classes5.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f58101f = 0;
        this.i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f58101f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f58097b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f58098c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f58100e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58100e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f58099d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f58099d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f58102g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f58103h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f58097b.x(this.k, 0);
        this.f58097b.addFooterView(this.f58103h);
        d dVar = new d(avatarPendantActivity);
        this.f58096a = dVar;
        this.f58097b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        this.f58098c.a(bVar);
    }

    public void e() {
        this.i.hideNetRefreshView(this.j);
        this.f58097b.setVisibility(0);
    }

    public MemberRecommendView f() {
        return this.f58099d;
    }

    public View h() {
        return this.j;
    }

    public TextView i() {
        return this.k;
    }

    public void k() {
        this.f58097b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f58096a.notifyDataSetChanged();
        this.f58100e.onChangeSkinType(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f58098c.c(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f58099d.d();
        SkinManager.setBackgroundColor(this.f58102g, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f58103h, R.color.CAM_X0201);
    }

    public void l(List<d.b.j0.j3.d.a> list) {
        if (list != null && list.size() > 0) {
            this.f58097b.setVisibility(0);
            this.f58096a.c(list);
            this.f58096a.notifyDataSetChanged();
            return;
        }
        this.f58097b.setVisibility(8);
    }

    public final boolean m(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58099d.setVisibility(0);
            this.f58099d.e(eVar);
            return true;
        }
        this.f58099d.setVisibility(8);
        return false;
    }

    public void n(a aVar) {
        this.f58096a.b(aVar);
    }

    public void o() {
        this.f58097b.setVisibility(8);
        String string = this.i.getPageContext().getResources().getString(R.string.no_data_text);
        this.i.setNetRefreshViewTopMargin(this.f58101f);
        this.i.showNetRefreshView(this.j, string, false);
    }

    public void q(e eVar, List<d.b.j0.j3.d.a> list) {
        if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
            e();
            if (m(eVar)) {
                this.f58097b.removeHeaderView(this.f58102g);
                this.f58097b.addHeaderView(this.f58102g);
            } else {
                this.f58097b.removeHeaderView(this.f58102g);
            }
            l(list);
            return;
        }
        o();
    }
}
