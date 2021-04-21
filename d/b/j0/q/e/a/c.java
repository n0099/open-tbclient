package d.b.j0.q.e.a;

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
import d.b.c.a.d;
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.j0.q.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f59408a;

    /* renamed from: b  reason: collision with root package name */
    public View f59409b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59410c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59411d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59412e;

    /* renamed from: f  reason: collision with root package name */
    public a f59413f;

    /* renamed from: g  reason: collision with root package name */
    public g f59414g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f59415h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f59408a = newFriendsActivity;
        this.f59409b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f59408a.findViewById(R.id.view_navigation_bar);
        this.f59410c = navigationBar;
        navigationBar.setTitleText(this.f59408a.getPageContext().getString(R.string.new_friends));
        this.f59410c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f59410c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f59408a).findViewById(R.id.new_friend_search);
        this.f59411d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f59412e = (BdListView) this.f59408a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f59408a);
        this.f59413f = aVar;
        this.f59412e.setAdapter((ListAdapter) aVar);
        this.f59412e.setOnItemClickListener(this.f59408a);
        this.f59412e.setOnItemLongClickListener(this.f59408a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f59414g = gVar;
        this.f59412e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f59408a.getActivity(), this.f59412e, BdListViewHelper.HeadType.DEFAULT);
        this.f59415h = NoDataViewFactory.a(this.f59408a.getPageContext().getPageActivity(), this.f59409b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f59408a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.b.i0.r.c cVar, int i) {
        cVar.k(i == 1);
        this.f59410c.onChangeSkinType(this.f59408a.getPageContext(), i);
        this.f59414g.I(i);
        cVar.j(this.f59409b);
        this.f59415h.f(this.f59408a.getPageContext(), i);
        this.f59411d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f59412e.A(0L);
    }

    public a f() {
        return this.f59413f;
    }

    public void g(d.b.j0.e1.g.a aVar) {
        this.f59413f.d(aVar);
        this.f59413f.notifyDataSetChanged();
    }

    public void h(List<d.b.j0.e1.g.a> list) {
        this.f59412e.setEmptyView(this.f59415h);
        this.f59413f.e(list);
        this.f59413f.notifyDataSetChanged();
    }

    public void i(f.g gVar) {
        this.f59414g.b(gVar);
    }

    public void k(a.c cVar) {
        this.f59413f.f(cVar);
    }

    public void l() {
        this.f59412e.F();
    }

    public void m(List<d.b.j0.e1.g.a> list) {
        this.f59413f.h(list);
        this.f59413f.notifyDataSetChanged();
    }
}
