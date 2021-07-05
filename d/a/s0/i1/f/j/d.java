package d.a.s0.i1.f.j;

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
/* loaded from: classes9.dex */
public class d extends d.a.c.a.d<OfficialBarHistoryActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity f61561a;

    /* renamed from: b  reason: collision with root package name */
    public View f61562b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f61563c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f61564d;

    /* renamed from: e  reason: collision with root package name */
    public OfficialBarHistoryAdapter f61565e;

    /* renamed from: f  reason: collision with root package name */
    public View f61566f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f61567g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61561a = baseActivity;
        e();
    }

    public void d(List<ResponseHistoryMessage.a> list) {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null || list.size() <= 0 || (noDataView = this.f61567g) == null) {
            return;
        }
        noDataView.setVisibility(8);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61562b = View.inflate(this.f61561a.getPageContext().getContext(), R.layout.official_bar_history_activity, null);
            this.f61561a.getPageContext().getPageActivity().setContentView(this.f61562b);
            NavigationBar navigationBar = (NavigationBar) this.f61562b.findViewById(R.id.view_navigation_bar);
            this.f61564d = navigationBar;
            navigationBar.setTitleText(R.string.officical_bar_info_history);
            this.f61564d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f61563c = (BdListView) this.f61562b.findViewById(R.id.bar_history_list);
            BaseActivity baseActivity = this.f61561a;
            OfficialBarHistoryAdapter officialBarHistoryAdapter = new OfficialBarHistoryAdapter(baseActivity, baseActivity.getPageContext().getContext());
            this.f61565e = officialBarHistoryAdapter;
            this.f61563c.setAdapter((ListAdapter) officialBarHistoryAdapter);
            View inflate = View.inflate(this.f61561a.getPageContext().getContext(), R.layout.official_bar_history_item_occupy, null);
            this.f61566f = inflate;
            this.f61563c.addHeaderView(inflate);
            this.f61563c.addFooterView(this.f61566f);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61565e.getCount() != 0 && this.f61563c.getLastVisiblePosition() - this.f61563c.getHeaderViewsCount() < this.f61565e.getCount() - 1 : invokeV.booleanValue;
    }

    public void g(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            this.f61565e.c(list);
            d(list);
        }
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pVar) == null) {
            this.f61563c.setOnSrollToBottomListener(pVar);
        }
    }

    public void i(List<ResponseHistoryMessage.a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            if (list == null || list.size() == 0) {
                if (this.f61567g == null) {
                    this.f61567g = NoDataViewFactory.a(this.f61561a.getPageContext().getPageActivity(), this.f61562b, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, 400), NoDataViewFactory.e.a(R.string.no_data_text), null);
                }
                this.f61567g.f(this.f61561a.getPageContext(), TbadkApplication.getInst().getSkinType());
                this.f61567g.setVisibility(0);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f61561a.getLayoutMode().k(i2 == 1);
            this.f61561a.getLayoutMode().j(this.f61562b);
            this.f61564d.onChangeSkinType(this.f61561a.getPageContext(), i2);
        }
    }
}
