package d.a.s0.j1.a.c;

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
import d.a.c.a.f;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b extends d.a.c.a.d<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f62128a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f62129b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f62130c;

    /* renamed from: d  reason: collision with root package name */
    public View f62131d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f62132e;

    /* renamed from: f  reason: collision with root package name */
    public a f62133f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f62134g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f62135h;

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
        this.f62128a = iMBlackListActivity;
        f();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f62128a.getLayoutMode().k(skinType == 1);
            this.f62128a.getLayoutMode().j(this.f62131d);
            this.f62130c.onChangeSkinType(this.f62128a.getPageContext(), skinType);
            this.f62134g.f(this.f62128a.getPageContext(), skinType);
            this.f62129b.c(this.f62128a.getPageContext(), skinType);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f62135h.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f62128a.setContentView(R.layout.im_black_list);
            View findViewById = this.f62128a.findViewById(R.id.root_view);
            this.f62131d = findViewById;
            this.f62129b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f62131d.findViewById(R.id.view_navigation_bar);
            this.f62130c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f62130c.setTitleText(R.string.chat_black_list_title);
            this.f62132e = (BdListView) this.f62131d.findViewById(R.id.black_list);
            this.f62134g = NoDataViewFactory.a(this.f62128a.getPageContext().getContext(), this.f62131d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13179a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
            this.f62135h = (ProgressBar) this.f62131d.findViewById(R.id.progress);
            a aVar = new a(this.f62128a);
            this.f62133f = aVar;
            this.f62132e.setAdapter((ListAdapter) aVar);
            d();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f62135h.setVisibility(0);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f62133f.getCount() <= 0) {
                this.f62132e.setVisibility(8);
                this.f62134g.setVisibility(0);
                return;
            }
            this.f62132e.setVisibility(0);
            this.f62134g.setVisibility(8);
            this.f62133f.notifyDataSetChanged();
        }
    }

    public void k(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f62132e.setVisibility(0);
                this.f62134g.setVisibility(8);
                this.f62133f.f(arrayList);
                this.f62133f.notifyDataSetChanged();
                return;
            }
            this.f62132e.setVisibility(8);
            this.f62134g.setVisibility(0);
        }
    }

    public void l(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f62133f.e(blackListItemData);
            if (this.f62133f.getCount() <= 0) {
                this.f62132e.setVisibility(8);
                this.f62134g.setVisibility(0);
                return;
            }
            this.f62132e.setVisibility(0);
            this.f62134g.setVisibility(8);
            this.f62133f.notifyDataSetChanged();
        }
    }
}
