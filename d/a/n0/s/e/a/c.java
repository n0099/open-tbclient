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
    public NewFriendsActivity f64041a;

    /* renamed from: b  reason: collision with root package name */
    public View f64042b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f64043c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f64044d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f64045e;

    /* renamed from: f  reason: collision with root package name */
    public a f64046f;

    /* renamed from: g  reason: collision with root package name */
    public g f64047g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f64048h;

    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        this.f64041a = newFriendsActivity;
        this.f64042b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f64041a.findViewById(R.id.view_navigation_bar);
        this.f64043c = navigationBar;
        navigationBar.setTitleText(this.f64041a.getPageContext().getString(R.string.new_friends));
        this.f64043c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f64043c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f64041a).findViewById(R.id.new_friend_search);
        this.f64044d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f64045e = (BdListView) this.f64041a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f64041a);
        this.f64046f = aVar;
        this.f64045e.setAdapter((ListAdapter) aVar);
        this.f64045e.setOnItemClickListener(this.f64041a);
        this.f64045e.setOnItemLongClickListener(this.f64041a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f64047g = gVar;
        this.f64045e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f64041a.getActivity(), this.f64045e, BdListViewHelper.HeadType.DEFAULT);
        this.f64048h = NoDataViewFactory.a(this.f64041a.getPageContext().getPageActivity(), this.f64042b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f64041a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.m0.r.c cVar, int i2) {
        cVar.k(i2 == 1);
        this.f64043c.onChangeSkinType(this.f64041a.getPageContext(), i2);
        this.f64047g.I(i2);
        cVar.j(this.f64042b);
        this.f64048h.f(this.f64041a.getPageContext(), i2);
        this.f64044d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
    }

    public void e() {
        this.f64045e.A(0L);
    }

    public a f() {
        return this.f64046f;
    }

    public void g(d.a.n0.f1.g.a aVar) {
        this.f64046f.d(aVar);
        this.f64046f.notifyDataSetChanged();
    }

    public void h(List<d.a.n0.f1.g.a> list) {
        this.f64045e.setEmptyView(this.f64048h);
        this.f64046f.e(list);
        this.f64046f.notifyDataSetChanged();
    }

    public void i(f.g gVar) {
        this.f64047g.a(gVar);
    }

    public void k(a.c cVar) {
        this.f64046f.f(cVar);
    }

    public void l() {
        this.f64045e.F();
    }

    public void m(List<d.a.n0.f1.g.a> list) {
        this.f64046f.h(list);
        this.f64046f.notifyDataSetChanged();
    }
}
