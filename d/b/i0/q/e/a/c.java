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
    public NewFriendsActivity f59233a;

    /* renamed from: b  reason: collision with root package name */
    public View f59234b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59235c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59236d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59237e;

    /* renamed from: f  reason: collision with root package name */
    public a f59238f;

    /* renamed from: g  reason: collision with root package name */
    public g f59239g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f59240h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f59233a = newFriendsActivity;
        this.f59234b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f59233a.findViewById(R.id.view_navigation_bar);
        this.f59235c = navigationBar;
        navigationBar.setTitleText(this.f59233a.getPageContext().getString(R.string.new_friends));
        this.f59235c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f59235c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f59233a).findViewById(R.id.new_friend_search);
        this.f59236d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f59237e = (BdListView) this.f59233a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f59233a);
        this.f59238f = aVar;
        this.f59237e.setAdapter((ListAdapter) aVar);
        this.f59237e.setOnItemClickListener(this.f59233a);
        this.f59237e.setOnItemLongClickListener(this.f59233a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f59239g = gVar;
        this.f59237e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f59233a.getActivity(), this.f59237e, BdListViewHelper.HeadType.DEFAULT);
        this.f59240h = NoDataViewFactory.a(this.f59233a.getPageContext().getPageActivity(), this.f59234b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f59233a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.b.h0.r.c cVar, int i) {
        cVar.k(i == 1);
        this.f59235c.onChangeSkinType(this.f59233a.getPageContext(), i);
        this.f59239g.I(i);
        cVar.j(this.f59234b);
        this.f59240h.f(this.f59233a.getPageContext(), i);
        this.f59236d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f59237e.A(0L);
    }

    public a f() {
        return this.f59238f;
    }

    public void g(d.b.i0.d1.g.a aVar) {
        this.f59238f.d(aVar);
        this.f59238f.notifyDataSetChanged();
    }

    public void h(List<d.b.i0.d1.g.a> list) {
        this.f59237e.setEmptyView(this.f59240h);
        this.f59238f.e(list);
        this.f59238f.notifyDataSetChanged();
    }

    public void i(f.g gVar) {
        this.f59239g.b(gVar);
    }

    public void k(a.c cVar) {
        this.f59238f.f(cVar);
    }

    public void l() {
        this.f59237e.F();
    }

    public void m(List<d.b.i0.d1.g.a> list) {
        this.f59238f.h(list);
        this.f59238f.notifyDataSetChanged();
    }
}
