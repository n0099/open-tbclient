package com.repackage;

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
import com.repackage.ik5;
import com.repackage.pu4;
import java.util.List;
/* loaded from: classes6.dex */
public class kk5 extends z8<NewFriendsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NewFriendsActivity a;
    public View b;
    public NavigationBar c;
    public ImageView d;
    public BdListView e;
    public ik5 f;
    public qu4 g;
    public NoDataView h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kk5(NewFriendsActivity newFriendsActivity) {
        super(newFriendsActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newFriendsActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = newFriendsActivity;
        this.b = newFriendsActivity.findViewById(R.id.obfuscated_res_0x7f091560);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923fd);
        this.c = navigationBar;
        navigationBar.setTitleText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0c32));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView imageView = (ImageView) this.c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d007b, this.a).findViewById(R.id.obfuscated_res_0x7f091562);
        this.d = imageView;
        imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        this.e = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091561);
        ik5 ik5Var = new ik5(this.a);
        this.f = ik5Var;
        this.e.setAdapter((ListAdapter) ik5Var);
        this.e.setOnItemClickListener(this.a);
        this.e.setOnItemLongClickListener(this.a);
        qu4 qu4Var = new qu4(newFriendsActivity.getPageContext());
        this.g = qu4Var;
        this.e.setPullRefresh(qu4Var);
        BdListViewHelper.d(this.a.getActivity(), this.e, BdListViewHelper.HeadType.DEFAULT);
        this.h = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, mi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702a1)), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c6b), null);
    }

    public void e(dn4 dn4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, dn4Var, i) == null) {
            dn4Var.k(i == 1);
            this.c.onChangeSkinType(this.a.getPageContext(), i);
            this.g.H(i);
            dn4Var.j(this.b);
            this.h.f(this.a.getPageContext(), i);
            this.d.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809e3, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e.A(0L);
        }
    }

    public ik5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (ik5) invokeV.objValue;
    }

    public void i(l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, l57Var) == null) {
            this.f.d(l57Var);
            this.f.notifyDataSetChanged();
        }
    }

    public void j(List<l57> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.e.setEmptyView(this.h);
            this.f.e(list);
            this.f.notifyDataSetChanged();
        }
    }

    public void k(pu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            this.g.e(gVar);
        }
    }

    public void l(ik5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.f.f(cVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.F();
        }
    }

    public void n(List<l57> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.f.h(list);
            this.f.notifyDataSetChanged();
        }
    }
}
