package d.a.p0.z2.f;

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
import d.a.c.a.d;
import d.a.c.a.f;
/* loaded from: classes8.dex */
public class b extends d<UserMuteListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<UserMuteListActivity> f66709a;

    /* renamed from: b  reason: collision with root package name */
    public NoNetworkView f66710b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f66711c;

    /* renamed from: d  reason: collision with root package name */
    public View f66712d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f66713e;

    /* renamed from: f  reason: collision with root package name */
    public NoDataView f66714f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(BaseActivity<UserMuteListActivity> baseActivity, a aVar) {
        super(baseActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, aVar};
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
        this.f66709a = baseActivity;
        initUI();
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f66709a.getLayoutMode().k(skinType == 1);
            this.f66709a.getLayoutMode().j(this.f66712d);
            this.f66711c.onChangeSkinType(this.f66709a.getPageContext(), skinType);
            this.f66714f.f(this.f66709a.getPageContext(), skinType);
            this.f66710b.c(this.f66709a.getPageContext(), skinType);
        }
    }

    public BdListView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66713e : (BdListView) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66713e.setVisibility(8);
            this.f66714f.setVisibility(0);
            this.f66714f.setTextOption(NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text));
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f66713e.setVisibility(8);
            this.f66714f.setVisibility(0);
            this.f66714f.setTextOption(NoDataViewFactory.e.a(R.string.refresh_view_title_text));
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f66709a.setContentView(R.layout.user_mute_list_activity);
            View findViewById = this.f66709a.findViewById(R.id.root_view);
            this.f66712d = findViewById;
            this.f66710b = (NoNetworkView) findViewById.findViewById(R.id.view_no_network);
            NavigationBar navigationBar = (NavigationBar) this.f66712d.findViewById(R.id.view_navigation_bar);
            this.f66711c = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f66711c.setTitleText(R.string.user_mute_list_text);
            this.f66713e = (BdListView) this.f66712d.findViewById(R.id.mute_user_list);
            this.f66714f = NoDataViewFactory.a(this.f66709a.getPageContext().getContext(), this.f66712d, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, BdListViewHelper.f13196a), NoDataViewFactory.e.a(R.string.user_mute_list_no_data_text), null);
            d();
        }
    }
}
