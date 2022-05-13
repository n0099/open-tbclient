package com.repackage;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryAdapter;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class x47 extends z8<OfficialBarHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity a;
    public View b;
    public BdListView c;
    public NavigationBar d;
    public OfficialBarHistoryAdapter e;
    public View f;
    public NoDataView g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x47(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
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
        g();
    }

    public void e(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0 || (noDataView = this.g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b = View.inflate(this.a.getPageContext().getContext(), R.layout.obfuscated_res_0x7f0d062a, null);
            this.a.getPageContext().getPageActivity().setContentView(this.b);
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f0923fd);
            this.d = navigationBar;
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f0cc9);
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f09030f);
            BaseActivity baseActivity = this.a;
            OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
            this.e = officialBarHistoryAdapter;
            this.c.setAdapter((ListAdapter) officialBarHistoryAdapter);
            View inflate = View.inflate(this.a.getPageContext().getContext(), R.layout.obfuscated_res_0x7f0d062b, null);
            this.f = inflate;
            this.c.addHeaderView(inflate);
            this.c.addFooterView(this.f);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e.getCount() != 0 && this.c.getLastVisiblePosition() - this.c.getHeaderViewsCount() < this.e.getCount() - 1 : invokeV.booleanValue;
    }

    public void i(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.e.c(list);
            e(list);
        }
    }

    public void j(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            this.c.setOnSrollToBottomListener(pVar);
        }
    }

    public void k(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list == null || list.size() == 0) {
                if (this.g == null) {
                    this.g = NoDataViewFactory.a(this.a.getPageContext().getPageActivity(), this.b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.obfuscated_res_0x7f0f0c45), null);
                }
                this.g.f(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
                this.g.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.b);
            this.d.onChangeSkinType(this.a.getPageContext(), i);
        }
    }
}
