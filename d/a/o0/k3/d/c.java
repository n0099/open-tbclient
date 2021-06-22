package d.a.o0.k3.d;

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
import d.a.o0.k3.h.e;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends d.a.c.a.d<AvatarPendantActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d f60780a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f60781b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f60782c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f60783d;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f60784e;

    /* renamed from: f  reason: collision with root package name */
    public int f60785f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60786g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60787h;

    /* renamed from: i  reason: collision with root package name */
    public AvatarPendantActivity f60788i;
    public View j;
    public TextView k;

    /* loaded from: classes5.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    public c(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        this.f60785f = 0;
        this.f60788i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.avatar_pendant_activity_layout);
        this.j = avatarPendantActivity.findViewById(R.id.root_view);
        this.f60785f = l.g(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.ds320);
        this.f60781b = (BdListView) avatarPendantActivity.findViewById(R.id.avatar_pedant_listview);
        this.f60782c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.view_no_network);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.view_navigation_bar);
        this.f60784e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60784e.setTitleText(R.string.avatar_pendant);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.avatar_pendant_theme_recommend);
        this.f60783d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.f60783d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.f60786g = textView;
        textView.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds104));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(avatarPendantActivity.getActivity(), R.dimen.ds98));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.f60787h = textView2;
        textView2.setHeight(l.g(avatarPendantActivity.getActivity(), R.dimen.ds50));
        this.k.setLayoutParams(layoutParams);
        this.f60781b.x(this.k, 0);
        this.f60781b.addFooterView(this.f60787h);
        d dVar = new d(avatarPendantActivity);
        this.f60780a = dVar;
        this.f60781b.setAdapter((ListAdapter) dVar);
    }

    public void d(NoNetworkView.b bVar) {
        this.f60782c.a(bVar);
    }

    public void e() {
        this.f60788i.hideNetRefreshView(this.j);
        this.f60781b.setVisibility(0);
    }

    public MemberRecommendView f() {
        return this.f60783d;
    }

    public View h() {
        return this.j;
    }

    public TextView i() {
        return this.k;
    }

    public void k() {
        this.f60781b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f60780a.notifyDataSetChanged();
        this.f60784e.onChangeSkinType(this.f60788i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f60782c.c(this.f60788i.getPageContext(), TbadkApplication.getInst().getSkinType());
        this.f60783d.d();
        SkinManager.setBackgroundColor(this.f60786g, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f60787h, R.color.CAM_X0201);
    }

    public void l(List<d.a.o0.k3.d.a> list) {
        if (list != null && list.size() > 0) {
            this.f60781b.setVisibility(0);
            this.f60780a.c(list);
            this.f60780a.notifyDataSetChanged();
            return;
        }
        this.f60781b.setVisibility(8);
    }

    public final boolean m(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60783d.setVisibility(0);
            this.f60783d.e(eVar);
            return true;
        }
        this.f60783d.setVisibility(8);
        return false;
    }

    public void n(a aVar) {
        this.f60780a.b(aVar);
    }

    public void o() {
        this.f60781b.setVisibility(8);
        String string = this.f60788i.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60788i.setNetRefreshViewTopMargin(this.f60785f);
        this.f60788i.showNetRefreshView(this.j, string, false);
    }

    public void p(e eVar, List<d.a.o0.k3.d.a> list) {
        if ((eVar != null && !StringUtils.isNull(eVar.c())) || (list != null && list.size() > 0)) {
            e();
            if (m(eVar)) {
                this.f60781b.removeHeaderView(this.f60786g);
                this.f60781b.addHeaderView(this.f60786g);
            } else {
                this.f60781b.removeHeaderView(this.f60786g);
            }
            l(list);
            return;
        }
        o();
    }
}
