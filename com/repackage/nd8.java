package com.repackage;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.setting.usermutelist.UserMuteListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nd8 extends z8<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<UserMuteListActivity> a;
    public NoNetworkView b;
    public NavigationBar c;
    public View d;
    public BdListView e;
    public NoDataView f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nd8(BaseActivity<UserMuteListActivity> baseActivity, md8 md8Var) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, md8Var};
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
        this.a = baseActivity;
        h();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.d);
            this.c.onChangeSkinType(this.a.getPageContext(), skinType);
            this.f.f(this.a.getPageContext(), skinType);
            this.b.c(this.a.getPageContext(), skinType);
        }
    }

    public BdListView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (BdListView) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView((int) R.layout.obfuscated_res_0x7f0d0853);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091b2c);
            this.d = findViewById;
            this.b = (NoNetworkView) findViewById.findViewById(R.id.obfuscated_res_0x7f0923ff);
            NavigationBar navigationBar = (NavigationBar) this.d.findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(R.string.obfuscated_res_0x7f0f14dc);
            this.e = (BdListView) this.d.findViewById(R.id.obfuscated_res_0x7f0914a2);
            this.f = NoDataViewFactory.a(this.a.getPageContext().getContext(), this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f14db), null);
            e();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f14db));
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
            this.f.setTextOption(NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0f84));
        }
    }
}
