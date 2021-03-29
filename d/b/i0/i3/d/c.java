package d.b.i0.i3.d;

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
import d.b.b.e.p.l;
import d.b.i0.i3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.b.b.a.d<AvatarPendantActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d f56228a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f56229b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56230c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f56231d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f56232e;

    /* renamed from: f  reason: collision with root package name */
    public int f56233f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56234g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56235h;
    public AvatarPendantActivity i;
    public View j;
    public TextView k;

    /* loaded from: classes5.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f56233f = 0;
        this.i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f56233f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f56229b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f56230c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f56232e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56232e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f56231d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f56231d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f56234g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f56235h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f56229b.x(this.k, 0);
        this.f56229b.addFooterView(this.f56235h);
        d dVar = new d(avatarPendantActivity);
        this.f56228a = dVar;
        this.f56229b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        this.f56230c.a(bVar);
    }

    public void e() {
        this.i.hideNetRefreshView(this.j);
        this.f56229b.setVisibility(0);
    }

    public MemberRecommendView f() {
        return this.f56231d;
    }

    public View h() {
        return this.j;
    }

    public TextView i() {
        return this.k;
    }

    public void k() {
        this.f56229b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f56228a.notifyDataSetChanged();
        this.f56232e.onChangeSkinType(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f56230c.c(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f56231d.d();
        SkinManager.setBackgroundColor(this.f56234g, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f56235h, R.color.CAM_X0201);
    }

    public void l(List<d.b.i0.i3.d.a> list) {
        if (list != null && list.size() > 0) {
            this.f56229b.setVisibility(0);
            this.f56228a.c(list);
            this.f56228a.notifyDataSetChanged();
            return;
        }
        this.f56229b.setVisibility(8);
    }

    public final boolean m(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56231d.setVisibility(0);
            this.f56231d.e(eVar);
            return true;
        }
        this.f56231d.setVisibility(8);
        return false;
    }

    public void n(a aVar) {
        this.f56228a.b(aVar);
    }

    public void o() {
        this.f56229b.setVisibility(8);
        String string = this.i.getPageContext().getResources().getString(R.string.no_data_text);
        this.i.setNetRefreshViewTopMargin(this.f56233f);
        this.i.showNetRefreshView(this.j, string, false);
    }

    public void q(e eVar, List<d.b.i0.i3.d.a> list) {
        if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
            e();
            if (m(eVar)) {
                this.f56229b.removeHeaderView(this.f56234g);
                this.f56229b.addHeaderView(this.f56234g);
            } else {
                this.f56229b.removeHeaderView(this.f56234g);
            }
            l(list);
            return;
        }
        o();
    }
}
