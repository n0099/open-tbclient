package d.a.q0.s.e.a;

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
import d.a.d.a.d;
import d.a.d.a.f;
import d.a.d.e.p.l;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.q0.s.e.a.a;
import java.util.List;
/* loaded from: classes8.dex */
public class c extends d<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f62581a;

    /* renamed from: b  reason: collision with root package name */
    public View f62582b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62583c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f62584d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f62585e;

    /* renamed from: f  reason: collision with root package name */
    public a f62586f;

    /* renamed from: g  reason: collision with root package name */
    public g f62587g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f62588h;

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
        this.f62581a = newFriendsActivity;
        this.f62582b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f62581a.findViewById(R.id.view_navigation_bar);
        this.f62583c = navigationBar;
        navigationBar.setTitleText(this.f62581a.getPageContext().getString(R.string.new_friends));
        this.f62583c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f62583c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f62581a).findViewById(R.id.new_friend_search);
        this.f62584d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f62585e = (BdListView) this.f62581a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f62581a);
        this.f62586f = aVar;
        this.f62585e.setAdapter((ListAdapter) aVar);
        this.f62585e.setOnItemClickListener(this.f62581a);
        this.f62585e.setOnItemLongClickListener(this.f62581a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f62587g = gVar;
        this.f62585e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f62581a.getActivity(), this.f62585e, BdListViewHelper.HeadType.DEFAULT);
        this.f62588h = NoDataViewFactory.a(this.f62581a.getPageContext().getPageActivity(), this.f62582b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f62581a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.p0.s.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f62583c.onChangeSkinType(this.f62581a.getPageContext(), i2);
            this.f62587g.I(i2);
            cVar.j(this.f62582b);
            this.f62588h.f(this.f62581a.getPageContext(), i2);
            this.f62584d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62585e.A(0L);
        }
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62586f : (a) invokeV.objValue;
    }

    public void g(d.a.q0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f62586f.d(aVar);
            this.f62586f.notifyDataSetChanged();
        }
    }

    public void h(List<d.a.q0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f62585e.setEmptyView(this.f62588h);
            this.f62586f.e(list);
            this.f62586f.notifyDataSetChanged();
        }
    }

    public void j(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f62587g.a(gVar);
        }
    }

    public void k(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f62586f.f(cVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62585e.F();
        }
    }

    public void m(List<d.a.q0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f62586f.h(list);
            this.f62586f.notifyDataSetChanged();
        }
    }
}
