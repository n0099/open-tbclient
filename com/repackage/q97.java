package com.repackage;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.BlackListItemData;
import com.baidu.tieba.imMessageCenter.im.friend.IMBlackListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class q97 extends z8<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IMBlackListActivity a;
    public NoNetworkView b;
    public NavigationBar c;
    public View d;
    public BdListView e;
    public p97 f;
    public NoDataView g;
    public ProgressBar h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q97(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMBlackListActivity};
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
        this.a = iMBlackListActivity;
        g();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.a.getLayoutMode().k(skinType == 1);
            this.a.getLayoutMode().j(this.d);
            this.c.onChangeSkinType(this.a.getPageContext(), skinType);
            this.g.f(this.a.getPageContext(), skinType);
            this.b.c(this.a.getPageContext(), skinType);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.h.setVisibility(8);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d03c8);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091ade);
            this.d = findViewById;
            this.b = (NoNetworkView) findViewById.findViewById(R.id.obfuscated_res_0x7f0923af);
            NavigationBar navigationBar = (NavigationBar) this.d.findViewById(R.id.obfuscated_res_0x7f0923ad);
            this.c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c.setTitleText(R.string.obfuscated_res_0x7f0f03a4);
            this.e = (BdListView) this.d.findViewById(R.id.obfuscated_res_0x7f09038a);
            this.g = NoDataViewFactory.a(this.a.getPageContext().getContext(), this.d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.a), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0306), null);
            this.h = (ProgressBar) this.d.findViewById(R.id.obfuscated_res_0x7f09191d);
            p97 p97Var = new p97(this.a);
            this.f = p97Var;
            this.e.setAdapter((ListAdapter) p97Var);
            e();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h.setVisibility(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f.getCount() <= 0) {
                this.e.setVisibility(8);
                this.g.setVisibility(0);
                return;
            }
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            this.f.notifyDataSetChanged();
        }
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.e.setVisibility(0);
                this.g.setVisibility(8);
                this.f.f(arrayList);
                this.f.notifyDataSetChanged();
                return;
            }
            this.e.setVisibility(8);
            this.g.setVisibility(0);
        }
    }

    public void k(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f.e(blackListItemData);
            if (this.f.getCount() <= 0) {
                this.e.setVisibility(8);
                this.g.setVisibility(0);
                return;
            }
            this.e.setVisibility(0);
            this.g.setVisibility(8);
            this.f.notifyDataSetChanged();
        }
    }
}
