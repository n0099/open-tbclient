package d.a.j0.q.e.a;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.j0.q.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f57447a;

    /* renamed from: b  reason: collision with root package name */
    public View f57448b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57449c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f57450d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f57451e;

    /* renamed from: f  reason: collision with root package name */
    public a f57452f;

    /* renamed from: g  reason: collision with root package name */
    public g f57453g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f57454h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f57447a = newFriendsActivity;
        this.f57448b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f57447a.findViewById(R.id.view_navigation_bar);
        this.f57449c = navigationBar;
        navigationBar.setTitleText(this.f57447a.getPageContext().getString(R.string.new_friends));
        this.f57449c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f57449c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f57447a).findViewById(R.id.new_friend_search);
        this.f57450d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f57451e = (BdListView) this.f57447a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f57447a);
        this.f57452f = aVar;
        this.f57451e.setAdapter((ListAdapter) aVar);
        this.f57451e.setOnItemClickListener(this.f57447a);
        this.f57451e.setOnItemLongClickListener(this.f57447a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f57453g = gVar;
        this.f57451e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f57447a.getActivity(), this.f57451e, BdListViewHelper.HeadType.DEFAULT);
        this.f57454h = NoDataViewFactory.a(this.f57447a.getPageContext().getPageActivity(), this.f57448b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f57447a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.i0.r.c cVar, int i2) {
        cVar.k(i2 == 1);
        this.f57449c.onChangeSkinType(this.f57447a.getPageContext(), i2);
        this.f57453g.I(i2);
        cVar.j(this.f57448b);
        this.f57454h.f(this.f57447a.getPageContext(), i2);
        this.f57450d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f57451e.A(0L);
    }

    public a f() {
        return this.f57452f;
    }

    public void g(d.a.j0.e1.g.a aVar) {
        this.f57452f.d(aVar);
        this.f57452f.notifyDataSetChanged();
    }

    public void h(List<d.a.j0.e1.g.a> list) {
        this.f57451e.setEmptyView(this.f57454h);
        this.f57452f.e(list);
        this.f57452f.notifyDataSetChanged();
    }

    public void j(f.g gVar) {
        this.f57453g.a(gVar);
    }

    public void k(a.c cVar) {
        this.f57452f.f(cVar);
    }

    public void l() {
        this.f57451e.F();
    }

    public void m(List<d.a.j0.e1.g.a> list) {
        this.f57452f.h(list);
        this.f57452f.notifyDataSetChanged();
    }
}
