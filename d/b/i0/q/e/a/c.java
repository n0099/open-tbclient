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
import d.b.b.a.d;
import d.b.b.e.p.l;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.q.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d<NewFriendsActivity> {

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f59234a;

    /* renamed from: b  reason: collision with root package name */
    public View f59235b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59236c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59237d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59238e;

    /* renamed from: f  reason: collision with root package name */
    public a f59239f;

    /* renamed from: g  reason: collision with root package name */
    public g f59240g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f59241h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f59234a = newFriendsActivity;
        this.f59235b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f59234a.findViewById(R.id.view_navigation_bar);
        this.f59236c = navigationBar;
        navigationBar.setTitleText(this.f59234a.getPageContext().getString(R.string.new_friends));
        this.f59236c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f59236c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f59234a).findViewById(R.id.new_friend_search);
        this.f59237d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f59238e = (BdListView) this.f59234a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f59234a);
        this.f59239f = aVar;
        this.f59238e.setAdapter((ListAdapter) aVar);
        this.f59238e.setOnItemClickListener(this.f59234a);
        this.f59238e.setOnItemLongClickListener(this.f59234a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f59240g = gVar;
        this.f59238e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f59234a.getActivity(), this.f59238e, BdListViewHelper.HeadType.DEFAULT);
        this.f59241h = NoDataViewFactory.a(this.f59234a.getPageContext().getPageActivity(), this.f59235b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f59234a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.b.h0.r.c cVar, int i) {
        cVar.k(i == 1);
        this.f59236c.onChangeSkinType(this.f59234a.getPageContext(), i);
        this.f59240g.I(i);
        cVar.j(this.f59235b);
        this.f59241h.f(this.f59234a.getPageContext(), i);
        this.f59237d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f59238e.A(0L);
    }

    public a f() {
        return this.f59239f;
    }

    public void g(d.b.i0.d1.g.a aVar) {
        this.f59239f.d(aVar);
        this.f59239f.notifyDataSetChanged();
    }

    public void h(List<d.b.i0.d1.g.a> list) {
        this.f59238e.setEmptyView(this.f59241h);
        this.f59239f.e(list);
        this.f59239f.notifyDataSetChanged();
    }

    public void i(f.g gVar) {
        this.f59240g.b(gVar);
    }

    public void k(a.c cVar) {
        this.f59239f.f(cVar);
    }

    public void l() {
        this.f59238e.F();
    }

    public void m(List<d.b.i0.d1.g.a> list) {
        this.f59239f.h(list);
        this.f59239f.notifyDataSetChanged();
    }
}
