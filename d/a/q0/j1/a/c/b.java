package d.a.q0.j1.a.c;

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
import d.a.d.a.f;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b extends d.a.d.a.d<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f59507a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f59508b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59509c;

    /* renamed from: d  reason: collision with root package name */
    public View f59510d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f59511e;

    /* renamed from: f  reason: collision with root package name */
    public a f59512f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f59513g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f59514h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(IMBlackListActivity iMBlackListActivity) {
        super(iMBlackListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iMBlackListActivity};
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
        this.f59507a = iMBlackListActivity;
        f();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f59507a.getLayoutMode().k(skinType == 1);
            this.f59507a.getLayoutMode().j(this.f59510d);
            this.f59509c.onChangeSkinType(this.f59507a.getPageContext(), skinType);
            this.f59513g.f(this.f59507a.getPageContext(), skinType);
            this.f59508b.c(this.f59507a.getPageContext(), skinType);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59514h.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59507a.setContentView(R.layout.im_black_list);
            View findViewById = this.f59507a.findViewById(R.id.root_view);
            this.f59510d = findViewById;
            this.f59508b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f59510d.findViewById(R.id.view_navigation_bar);
            this.f59509c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f59509c.setTitleText(R.string.chat_black_list_title);
            this.f59511e = (BdListView) this.f59510d.findViewById(R.id.black_list);
            this.f59513g = NoDataViewFactory.a(this.f59507a.getPageContext().getContext(), this.f59510d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13245a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
            this.f59514h = (ProgressBar) this.f59510d.findViewById(R.id.progress);
            a aVar = new a(this.f59507a);
            this.f59512f = aVar;
            this.f59511e.setAdapter((ListAdapter) aVar);
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59514h.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f59512f.getCount() <= 0) {
                this.f59511e.setVisibility(8);
                this.f59513g.setVisibility(0);
                return;
            }
            this.f59511e.setVisibility(0);
            this.f59513g.setVisibility(8);
            this.f59512f.notifyDataSetChanged();
        }
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f59511e.setVisibility(0);
                this.f59513g.setVisibility(8);
                this.f59512f.f(arrayList);
                this.f59512f.notifyDataSetChanged();
                return;
            }
            this.f59511e.setVisibility(8);
            this.f59513g.setVisibility(0);
        }
    }

    public void k(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f59512f.e(blackListItemData);
            if (this.f59512f.getCount() <= 0) {
                this.f59511e.setVisibility(8);
                this.f59513g.setVisibility(0);
                return;
            }
            this.f59511e.setVisibility(0);
            this.f59513g.setVisibility(8);
            this.f59512f.notifyDataSetChanged();
        }
    }
}
