package d.a.q0.p0;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePurchaseRecordsActivity;
import com.baidu.tieba.faceshop.FacePurchaseRecordsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.f0.f;
/* loaded from: classes8.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePurchaseRecordsActivity> f61820a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61821b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f61822c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f61823d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f61824e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.p0.s.f0.g f61825f;

    /* renamed from: g  reason: collision with root package name */
    public View f61826g;

    /* renamed from: h  reason: collision with root package name */
    public k f61827h;

    public l(TbPageContext<FacePurchaseRecordsActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61820a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_purchase_records_layout);
        View findViewById = tbPageContext.getPageActivity().findViewById(R.id.purchase_record);
        this.f61821b = findViewById;
        NavigationBar navigationBar = (NavigationBar) findViewById.findViewById(R.id.view_navigation_bar);
        this.f61822c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.purchase_record));
        this.f61822c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61823d = (NoNetworkView) this.f61821b.findViewById(R.id.view_no_network);
        this.f61824e = (BdListView) this.f61821b.findViewById(R.id.purchase_record_list);
        d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(tbPageContext);
        this.f61825f = gVar;
        this.f61824e.setPullRefresh(gVar);
        this.f61826g = BdListViewHelper.d(this.f61820a.getPageActivity(), this.f61824e, BdListViewHelper.HeadType.DEFAULT);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f61823d.a(bVar);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            BdListViewHelper.c(this.f61826g, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f61824e.A(0L);
        }
    }

    public k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61827h : (k) invokeV.objValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            d.a.p0.s.c layoutMode = this.f61820a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f61821b);
            this.f61822c.onChangeSkinType(this.f61820a, i2);
            this.f61823d.c(this.f61820a, i2);
            this.f61825f.I(i2);
        }
    }

    public void f(FacePurchaseRecordsData facePurchaseRecordsData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, facePurchaseRecordsData) == null) {
            if (this.f61827h == null) {
                k kVar = new k(this.f61820a.getOrignalPage());
                this.f61827h = kVar;
                this.f61824e.setAdapter((ListAdapter) kVar);
            }
            this.f61827h.e(facePurchaseRecordsData);
            c();
        }
    }

    public void g(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f61823d.d(bVar);
        }
    }

    public void h(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onItemClickListener) == null) {
            this.f61824e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void i(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.f61825f.a(gVar);
        }
    }
}
