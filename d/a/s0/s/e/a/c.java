package d.a.s0.s.e.a;

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
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.s0.s.e.a.a;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NewFriendsActivity f65189a;

    /* renamed from: b  reason: collision with root package name */
    public View f65190b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f65191c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f65192d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f65193e;

    /* renamed from: f  reason: collision with root package name */
    public a f65194f;

    /* renamed from: g  reason: collision with root package name */
    public g f65195g;

    /* renamed from: h  reason: collision with root package name */
    public NoDataView f65196h;

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
        this.f65189a = newFriendsActivity;
        this.f65190b = newFriendsActivity.findViewById(R.id.new_friend_activity);
        NavigationBar navigationBar = (NavigationBar) this.f65189a.findViewById(R.id.view_navigation_bar);
        this.f65191c = navigationBar;
        navigationBar.setTitleText(this.f65189a.getPageContext().getString(R.string.new_friends));
        this.f65191c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.f65191c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.add_new_friend_text, this.f65189a).findViewById(R.id.new_friend_search);
        this.f65192d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.f65193e = (BdListView) this.f65189a.findViewById(R.id.new_friend_listview);
        a aVar = new a(this.f65189a);
        this.f65194f = aVar;
        this.f65193e.setAdapter((ListAdapter) aVar);
        this.f65193e.setOnItemClickListener(this.f65189a);
        this.f65193e.setOnItemLongClickListener(this.f65189a);
        g gVar = new g(newFriendsActivity.getPageContext());
        this.f65195g = gVar;
        this.f65193e.setPullRefresh(gVar);
        BdListViewHelper.d(this.f65189a.getActivity(), this.f65193e, BdListViewHelper.HeadType.DEFAULT);
        this.f65196h = NoDataViewFactory.a(this.f65189a.getPageContext().getPageActivity(), this.f65190b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(this.f65189a.getActivity(), R.dimen.ds320)), NoDataViewFactory.e.a(R.string.no_new_friend_hint), null);
    }

    public void d(d.a.r0.r.c cVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, cVar, i2) == null) {
            cVar.k(i2 == 1);
            this.f65191c.onChangeSkinType(this.f65189a.getPageContext(), i2);
            this.f65195g.I(i2);
            cVar.j(this.f65190b);
            this.f65196h.f(this.f65189a.getPageContext(), i2);
            this.f65192d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f65193e.A(0L);
        }
    }

    public a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65194f : (a) invokeV.objValue;
    }

    public void g(d.a.s0.i1.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f65194f.d(aVar);
            this.f65194f.notifyDataSetChanged();
        }
    }

    public void h(List<d.a.s0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f65193e.setEmptyView(this.f65196h);
            this.f65194f.e(list);
            this.f65194f.notifyDataSetChanged();
        }
    }

    public void i(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.f65195g.a(gVar);
        }
    }

    public void k(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f65194f.f(cVar);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65193e.F();
        }
    }

    public void m(List<d.a.s0.i1.g.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f65194f.h(list);
            this.f65194f.notifyDataSetChanged();
        }
    }
}
