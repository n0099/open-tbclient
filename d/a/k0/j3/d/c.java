package d.a.k0.j3.d;

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
import d.a.c.e.p.l;
import d.a.k0.j3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d<AvatarPendantActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d f56786a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f56787b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f56788c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f56789d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f56790e;

    /* renamed from: f  reason: collision with root package name */
    public int f56791f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56792g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56793h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f56794i;
    public View j;
    public TextView k;

    /* loaded from: classes5.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f56791f = 0;
        this.f56794i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f56791f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f56787b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f56788c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f56790e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56790e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f56789d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f56789d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f56792g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f56793h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f56787b.x(this.k, 0);
        this.f56787b.addFooterView(this.f56793h);
        d dVar = new d(avatarPendantActivity);
        this.f56786a = dVar;
        this.f56787b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        this.f56788c.a(bVar);
    }

    public void e() {
        this.f56794i.hideNetRefreshView(this.j);
        this.f56787b.setVisibility(0);
    }

    public MemberRecommendView f() {
        return this.f56789d;
    }

    public View g() {
        return this.j;
    }

    public TextView h() {
        return this.k;
    }

    public void j() {
        this.f56787b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f56786a.notifyDataSetChanged();
        this.f56790e.onChangeSkinType(this.f56794i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f56788c.c(this.f56794i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f56789d.d();
        SkinManager.setBackgroundColor(this.f56792g, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f56793h, R.color.CAM_X0201);
    }

    public void k(List<d.a.k0.j3.d.a> list) {
        if (list != null && list.size() > 0) {
            this.f56787b.setVisibility(0);
            this.f56786a.c(list);
            this.f56786a.notifyDataSetChanged();
            return;
        }
        this.f56787b.setVisibility(8);
    }

    public final boolean l(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56789d.setVisibility(0);
            this.f56789d.e(eVar);
            return true;
        }
        this.f56789d.setVisibility(8);
        return false;
    }

    public void m(a aVar) {
        this.f56786a.b(aVar);
    }

    public void n() {
        this.f56787b.setVisibility(8);
        String string = this.f56794i.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56794i.setNetRefreshViewTopMargin(this.f56791f);
        this.f56794i.showNetRefreshView(this.j, string, false);
    }

    public void o(e eVar, List<d.a.k0.j3.d.a> list) {
        if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
            e();
            if (l(eVar)) {
                this.f56787b.removeHeaderView(this.f56792g);
                this.f56787b.addHeaderView(this.f56792g);
            } else {
                this.f56787b.removeHeaderView(this.f56792g);
            }
            k(list);
            return;
        }
        n();
    }
}
