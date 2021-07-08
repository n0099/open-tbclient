package d.a.p0.s.e.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.a.d;
import d.a.c.a.f;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import d.a.p0.s.e.a.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f61967a;

    /* renamed from: b  reason: collision with root package name */
    public View f61968b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f61969c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f61970d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f61971e;

    /* renamed from: f  reason: collision with root package name */
    public a f61972f;

    /* renamed from: g  reason: collision with root package name */
    public g f61973g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f61974h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61967a = newFriendsActivity;
        this.f61968b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f61967a.findViewById(R.id.view_navigation_bar);
        this.f61969c = navigationBar;
        navigationBar.setTitleText(this.f61967a.getPageContext().getString(R.string.new_friends));
        this.f61969c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f61969c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f61967a).findViewById(R.id.new_friend_search);
        this.f61970d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f61971e = (BdListView) this.f61967a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f61967a);
        this.f61972f = aVar;
        this.f61971e.setAdapter((ListAdapter) aVar);
        this.f61971e.setOnItemClickListener(this.f61967a);
        this.f61971e.setOnItemLongClickListener(this.f61967a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f61973g = gVar;
        this.f61971e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f61967a.getActivity(), this.f61971e, BdListViewHelper.HeadType.DEFAULT);
        this.f61974h = NoDataViewFactory.a(this.f61967a.getPageContext().getPageActivity(), this.f61968b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f61967a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.o0.r.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f61969c.onChangeSkinType(this.f61967a.getPageContext(), i2);
            this.f61973g.I(i2);
            cVar.j(this.f61968b);
            this.f61974h.f(this.f61967a.getPageContext(), i2);
            this.f61970d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61971e.A(0L);
        }
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61972f : (a) invokeV.objValue;
    }

    public void g(d.a.p0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f61972f.d(aVar);
            this.f61972f.notifyDataSetChanged();
        }
    }

    public void h(List<d.a.p0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f61971e.setEmptyView(this.f61974h);
            this.f61972f.e(list);
            this.f61972f.notifyDataSetChanged();
        }
    }

    public void j(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f61973g.a(gVar);
        }
    }

    public void k(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f61972f.f(cVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f61971e.F();
        }
    }

    public void m(List<d.a.p0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f61972f.h(list);
            this.f61972f.notifyDataSetChanged();
        }
    }
}
