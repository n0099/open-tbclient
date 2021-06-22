package d.a.o0.s.e.a;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.o0.s.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f64166a;

    /* renamed from: b  reason: collision with root package name */
    public View f64167b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64168c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f64169d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f64170e;

    /* renamed from: f  reason: collision with root package name */
    public a f64171f;

    /* renamed from: g  reason: collision with root package name */
    public g f64172g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f64173h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f64166a = newFriendsActivity;
        this.f64167b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f64166a.findViewById(R.id.view_navigation_bar);
        this.f64168c = navigationBar;
        navigationBar.setTitleText(this.f64166a.getPageContext().getString(R.string.new_friends));
        this.f64168c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f64168c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f64166a).findViewById(R.id.new_friend_search);
        this.f64169d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f64170e = (BdListView) this.f64166a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f64166a);
        this.f64171f = aVar;
        this.f64170e.setAdapter((ListAdapter) aVar);
        this.f64170e.setOnItemClickListener(this.f64166a);
        this.f64170e.setOnItemLongClickListener(this.f64166a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f64172g = gVar;
        this.f64170e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f64166a.getActivity(), this.f64170e, BdListViewHelper.HeadType.DEFAULT);
        this.f64173h = NoDataViewFactory.a(this.f64166a.getPageContext().getPageActivity(), this.f64167b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f64166a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.n0.r.c cVar, int i2) {
        cVar.k(i2 == 1);
        this.f64168c.onChangeSkinType(this.f64166a.getPageContext(), i2);
        this.f64172g.I(i2);
        cVar.j(this.f64167b);
        this.f64173h.f(this.f64166a.getPageContext(), i2);
        this.f64169d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f64170e.A(0L);
    }

    public a f() {
        return this.f64171f;
    }

    public void g(d.a.o0.f1.g.a aVar) {
        this.f64171f.d(aVar);
        this.f64171f.notifyDataSetChanged();
    }

    public void h(List<d.a.o0.f1.g.a> list) {
        this.f64170e.setEmptyView(this.f64173h);
        this.f64171f.e(list);
        this.f64171f.notifyDataSetChanged();
    }

    public void i(f.g gVar) {
        this.f64172g.a(gVar);
    }

    public void k(a.c cVar) {
        this.f64171f.f(cVar);
    }

    public void l() {
        this.f64170e.F();
    }

    public void m(List<d.a.o0.f1.g.a> list) {
        this.f64171f.h(list);
        this.f64171f.notifyDataSetChanged();
    }
}
