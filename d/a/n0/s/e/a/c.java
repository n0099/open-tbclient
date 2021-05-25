package d.a.n0.s.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import d.a.c.a.d;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.n0.s.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f60352a;

    /* renamed from: b  reason: collision with root package name */
    public View f60353b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60354c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60355d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60356e;

    /* renamed from: f  reason: collision with root package name */
    public a f60357f;

    /* renamed from: g  reason: collision with root package name */
    public g f60358g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f60359h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f60352a = newFriendsActivity;
        this.f60353b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f60352a.findViewById(R.id.view_navigation_bar);
        this.f60354c = navigationBar;
        navigationBar.setTitleText(this.f60352a.getPageContext().getString(R.string.new_friends));
        this.f60354c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f60354c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f60352a).findViewById(R.id.new_friend_search);
        this.f60355d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f60356e = (BdListView) this.f60352a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f60352a);
        this.f60357f = aVar;
        this.f60356e.setAdapter((ListAdapter) aVar);
        this.f60356e.setOnItemClickListener(this.f60352a);
        this.f60356e.setOnItemLongClickListener(this.f60352a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f60358g = gVar;
        this.f60356e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f60352a.getActivity(), this.f60356e, BdListViewHelper.HeadType.DEFAULT);
        this.f60359h = NoDataViewFactory.a(this.f60352a.getPageContext().getPageActivity(), this.f60353b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f60352a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.m0.r.c cVar, int i2) {
        cVar.k(i2 == 1);
        this.f60354c.onChangeSkinType(this.f60352a.getPageContext(), i2);
        this.f60358g.I(i2);
        cVar.j(this.f60353b);
        this.f60359h.f(this.f60352a.getPageContext(), i2);
        this.f60355d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f60356e.A(0L);
    }

    public a f() {
        return this.f60357f;
    }

    public void g(d.a.n0.f1.g.a aVar) {
        this.f60357f.d(aVar);
        this.f60357f.notifyDataSetChanged();
    }

    public void h(List<d.a.n0.f1.g.a> list) {
        this.f60356e.setEmptyView(this.f60359h);
        this.f60357f.e(list);
        this.f60357f.notifyDataSetChanged();
    }

    public void j(f.g gVar) {
        this.f60358g.a(gVar);
    }

    public void k(a.c cVar) {
        this.f60357f.f(cVar);
    }

    public void l() {
        this.f60356e.F();
    }

    public void m(List<d.a.n0.f1.g.a> list) {
        this.f60357f.h(list);
        this.f60357f.notifyDataSetChanged();
    }
}
