package d.a.k0.q.e.a;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import d.a.k0.q.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f58189a;

    /* renamed from: b  reason: collision with root package name */
    public View f58190b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58191c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f58192d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58193e;

    /* renamed from: f  reason: collision with root package name */
    public a f58194f;

    /* renamed from: g  reason: collision with root package name */
    public g f58195g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f58196h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f58189a = newFriendsActivity;
        this.f58190b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f58189a.findViewById(R.id.view_navigation_bar);
        this.f58191c = navigationBar;
        navigationBar.setTitleText(this.f58189a.getPageContext().getString(R.string.new_friends));
        this.f58191c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f58191c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f58189a).findViewById(R.id.new_friend_search);
        this.f58192d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f58193e = (BdListView) this.f58189a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f58189a);
        this.f58194f = aVar;
        this.f58193e.setAdapter((ListAdapter) aVar);
        this.f58193e.setOnItemClickListener(this.f58189a);
        this.f58193e.setOnItemLongClickListener(this.f58189a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f58195g = gVar;
        this.f58193e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f58189a.getActivity(), this.f58193e, BdListViewHelper.HeadType.DEFAULT);
        this.f58196h = NoDataViewFactory.a(this.f58189a.getPageContext().getPageActivity(), this.f58190b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58189a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.j0.r.c cVar, int i2) {
        cVar.k(i2 == 1);
        this.f58191c.onChangeSkinType(this.f58189a.getPageContext(), i2);
        this.f58195g.I(i2);
        cVar.j(this.f58190b);
        this.f58196h.f(this.f58189a.getPageContext(), i2);
        this.f58192d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f58193e.A(0L);
    }

    public a f() {
        return this.f58194f;
    }

    public void g(d.a.k0.e1.g.a aVar) {
        this.f58194f.d(aVar);
        this.f58194f.notifyDataSetChanged();
    }

    public void h(List<d.a.k0.e1.g.a> list) {
        this.f58193e.setEmptyView(this.f58196h);
        this.f58194f.e(list);
        this.f58194f.notifyDataSetChanged();
    }

    public void j(f.g gVar) {
        this.f58195g.a(gVar);
    }

    public void k(a.c cVar) {
        this.f58194f.f(cVar);
    }

    public void l() {
        this.f58193e.F();
    }

    public void m(List<d.a.k0.e1.g.a> list) {
        this.f58194f.h(list);
        this.f58194f.notifyDataSetChanged();
    }
}
