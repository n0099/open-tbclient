package d.b.i0.q.e.a;

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
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.q.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f58987a;

    /* renamed from: b  reason: collision with root package name */
    public View f58988b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58989c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f58990d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58991e;

    /* renamed from: f  reason: collision with root package name */
    public a f58992f;

    /* renamed from: g  reason: collision with root package name */
    public g f58993g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f58994h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f58987a = newFriendsActivity;
        this.f58988b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f58987a.findViewById(R.id.view_navigation_bar);
        this.f58989c = navigationBar;
        navigationBar.setTitleText(this.f58987a.getPageContext().getString(R.string.new_friends));
        this.f58989c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f58989c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f58987a).findViewById(R.id.new_friend_search);
        this.f58990d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f58991e = (BdListView) this.f58987a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f58987a);
        this.f58992f = aVar;
        this.f58991e.setAdapter((ListAdapter) aVar);
        this.f58991e.setOnItemClickListener(this.f58987a);
        this.f58991e.setOnItemLongClickListener(this.f58987a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f58993g = gVar;
        this.f58991e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f58987a.getActivity(), this.f58991e, BdListViewHelper.HeadType.DEFAULT);
        this.f58994h = NoDataViewFactory.a(this.f58987a.getPageContext().getPageActivity(), this.f58988b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f58987a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.b.h0.r.c cVar, int i) {
        cVar.k(i == 1);
        this.f58989c.onChangeSkinType(this.f58987a.getPageContext(), i);
        this.f58993g.I(i);
        cVar.j(this.f58988b);
        this.f58994h.f(this.f58987a.getPageContext(), i);
        this.f58990d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f58991e.A(0L);
    }

    public a f() {
        return this.f58992f;
    }

    public void g(d.b.i0.e1.g.a aVar) {
        this.f58992f.d(aVar);
        this.f58992f.notifyDataSetChanged();
    }

    public void h(List<d.b.i0.e1.g.a> list) {
        this.f58991e.setEmptyView(this.f58994h);
        this.f58992f.e(list);
        this.f58992f.notifyDataSetChanged();
    }

    public void i(f.g gVar) {
        this.f58993g.b(gVar);
    }

    public void k(a.c cVar) {
        this.f58992f.f(cVar);
    }

    public void l() {
        this.f58991e.F();
    }

    public void m(List<d.b.i0.e1.g.a> list) {
        this.f58992f.h(list);
        this.f58992f.notifyDataSetChanged();
    }
}
