package d.b.i0.j3.d;

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
import d.b.i0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.b.c.a.d<AvatarPendantActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d f57675a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f57676b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f57677c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f57678d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f57679e;

    /* renamed from: f  reason: collision with root package name */
    public int f57680f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57681g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57682h;
    public AvatarPendantActivity i;
    public View j;
    public TextView k;

    /* loaded from: classes5.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f57680f = 0;
        this.i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f57680f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f57676b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f57677c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f57679e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57679e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f57678d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f57678d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f57681g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f57682h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f57676b.x(this.k, 0);
        this.f57676b.addFooterView(this.f57682h);
        d dVar = new d(avatarPendantActivity);
        this.f57675a = dVar;
        this.f57676b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        this.f57677c.a(bVar);
    }

    public void e() {
        this.i.hideNetRefreshView(this.j);
        this.f57676b.setVisibility(0);
    }

    public MemberRecommendView f() {
        return this.f57678d;
    }

    public View h() {
        return this.j;
    }

    public TextView i() {
        return this.k;
    }

    public void k() {
        this.f57676b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f57675a.notifyDataSetChanged();
        this.f57679e.onChangeSkinType(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f57677c.c(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f57678d.d();
        SkinManager.setBackgroundColor(this.f57681g, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f57682h, R.color.CAM_X0201);
    }

    public void l(List<d.b.i0.j3.d.a> list) {
        if (list != null && list.size() > 0) {
            this.f57676b.setVisibility(0);
            this.f57675a.c(list);
            this.f57675a.notifyDataSetChanged();
            return;
        }
        this.f57676b.setVisibility(8);
    }

    public final boolean m(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57678d.setVisibility(0);
            this.f57678d.e(eVar);
            return true;
        }
        this.f57678d.setVisibility(8);
        return false;
    }

    public void n(a aVar) {
        this.f57675a.b(aVar);
    }

    public void o() {
        this.f57676b.setVisibility(8);
        String string = this.i.getPageContext().getResources().getString(R.string.no_data_text);
        this.i.setNetRefreshViewTopMargin(this.f57680f);
        this.i.showNetRefreshView(this.j, string, false);
    }

    public void q(e eVar, List<d.b.i0.j3.d.a> list) {
        if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
            e();
            if (m(eVar)) {
                this.f57676b.removeHeaderView(this.f57681g);
                this.f57676b.addHeaderView(this.f57681g);
            } else {
                this.f57676b.removeHeaderView(this.f57681g);
            }
            l(list);
            return;
        }
        o();
    }
}
