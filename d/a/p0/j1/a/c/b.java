package d.a.p0.j1.a.c;

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
/* loaded from: classes8.dex */
public class b extends d.a.c.a.d<IMBlackListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IMBlackListActivity f58893a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f58894b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58895c;

    /* renamed from: d  reason: collision with root package name */
    public View f58896d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58897e;

    /* renamed from: f  reason: collision with root package name */
    public a f58898f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f58899g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f58900h;

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
        this.f58893a = iMBlackListActivity;
        f();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f58893a.getLayoutMode().k(skinType == 1);
            this.f58893a.getLayoutMode().j(this.f58896d);
            this.f58895c.onChangeSkinType(this.f58893a.getPageContext(), skinType);
            this.f58899g.f(this.f58893a.getPageContext(), skinType);
            this.f58894b.c(this.f58893a.getPageContext(), skinType);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f58900h.setVisibility(8);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58893a.setContentView(R.layout.im_black_list);
            View findViewById = this.f58893a.findViewById(R.id.root_view);
            this.f58896d = findViewById;
            this.f58894b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f58896d.findViewById(R.id.view_navigation_bar);
            this.f58895c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f58895c.setTitleText(R.string.chat_black_list_title);
            this.f58897e = (BdListView) this.f58896d.findViewById(R.id.black_list);
            this.f58899g = NoDataViewFactory.a(this.f58893a.getPageContext().getContext(), this.f58896d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13196a), NoDataViewFactory.e.a(R.string.black_list_no_data_text), null);
            this.f58900h = (ProgressBar) this.f58896d.findViewById(R.id.progress);
            a aVar = new a(this.f58893a);
            this.f58898f = aVar;
            this.f58897e.setAdapter((ListAdapter) aVar);
            d();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f58900h.setVisibility(0);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f58898f.getCount() <= 0) {
                this.f58897e.setVisibility(8);
                this.f58899g.setVisibility(0);
                return;
            }
            this.f58897e.setVisibility(0);
            this.f58899g.setVisibility(8);
            this.f58898f.notifyDataSetChanged();
        }
    }

    public void j(ArrayList<BlackListItemData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            if (arrayList != null && arrayList.size() > 0) {
                this.f58897e.setVisibility(0);
                this.f58899g.setVisibility(8);
                this.f58898f.f(arrayList);
                this.f58898f.notifyDataSetChanged();
                return;
            }
            this.f58897e.setVisibility(8);
            this.f58899g.setVisibility(0);
        }
    }

    public void k(BlackListItemData blackListItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, blackListItemData) == null) {
            this.f58898f.e(blackListItemData);
            if (this.f58898f.getCount() <= 0) {
                this.f58897e.setVisibility(8);
                this.f58899g.setVisibility(0);
                return;
            }
            this.f58897e.setVisibility(0);
            this.f58899g.setVisibility(8);
            this.f58898f.notifyDataSetChanged();
        }
    }
}
