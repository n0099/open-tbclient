package d.a.q0.p0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FaceShopActivity;
import com.baidu.tieba.faceshop.FaceShopData;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.f0.f;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FaceShopActivity> f61850a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f61851b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f61852c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f61853d;

    /* renamed from: e  reason: collision with root package name */
    public final BdListView f61854e;

    /* renamed from: f  reason: collision with root package name */
    public final m f61855f;

    /* renamed from: g  reason: collision with root package name */
    public final NoNetworkView f61856g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.p0.s.f0.g f61857h;

    /* renamed from: i  reason: collision with root package name */
    public final a f61858i;
    public final h j;

    /* loaded from: classes8.dex */
    public class a extends d.a.d.k.e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final TbPageContext<?> f61859f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61860g;

        /* renamed from: h  reason: collision with root package name */
        public ProgressBar f61861h;

        /* renamed from: i  reason: collision with root package name */
        public View f61862i;
        public View j;

        public a(n nVar, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61860g = null;
            this.f61861h = null;
            this.f61862i = null;
            this.f61859f = tbPageContext;
        }

        @Override // d.a.d.k.e.b
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.f61859f.getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
                this.f61862i = inflate;
                inflate.setPadding(0, this.f61859f.getResources().getDimensionPixelSize(R.dimen.ds16), 0, this.f61859f.getResources().getDimensionPixelSize(R.dimen.ds16));
                this.f61860g = (TextView) this.f61862i.findViewById(R.id.pb_more_text);
                View findViewById = this.f61862i.findViewById(R.id.pb_more_view);
                this.j = findViewById;
                findViewById.setVisibility(8);
                this.f61861h = (ProgressBar) this.f61862i.findViewById(R.id.progress);
                h(TbadkApplication.getInst().getSkinType());
                this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.f61862i;
            }
            return (View) invokeV.objValue;
        }

        @Override // d.a.d.k.e.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f61862i.setVisibility(0);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f61862i.setVisibility(8);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f61861h.setVisibility(8);
                this.f61860g.setText(R.string.load_more);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f61861h.setVisibility(0);
                this.f61860g.setText(this.f61859f.getPageActivity().getText(R.string.loading));
                this.j.setVisibility(0);
            }
        }

        public void h(int i2) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (tbPageContext = this.f61859f) == null) {
                return;
            }
            tbPageContext.getLayoutMode().k(i2 == 1);
            this.f61859f.getLayoutMode().j(this.j);
        }
    }

    public n(TbPageContext<FaceShopActivity> tbPageContext) {
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
        this.f61850a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.face_shop_activity);
        this.f61851b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.face_shop);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f61852c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.face_store));
        this.f61852c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.f61852c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.manage));
        this.f61853d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.f61856g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.f61854e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.face_shop_list);
        this.f61857h = new d.a.p0.s.f0.g(tbPageContext);
        this.f61855f = new m(tbPageContext.getOrignalPage());
        this.f61858i = new a(this, tbPageContext);
        this.f61854e.setAdapter((ListAdapter) this.f61855f);
        this.f61854e.setPullRefresh(this.f61857h);
        this.f61854e.setNextPage(this.f61858i);
        try {
            this.f61853d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.j = new h(tbPageContext, R.style.common_alert_dialog);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f61856g.a(bVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f61858i.f();
            this.f61854e.A(0L);
        }
    }

    public m c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61855f : (m) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f61853d : (TextView) invokeV.objValue;
    }

    public void e() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.j) == null) {
            return;
        }
        d.a.d.e.m.g.b(hVar, this.f61850a);
    }

    public void f() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.f61858i) == null) {
            return;
        }
        aVar.e();
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            d.a.p0.s.c layoutMode = this.f61850a.getLayoutMode();
            layoutMode.k(i2 == 1);
            layoutMode.j(this.f61851b);
            NavigationBar navigationBar = this.f61852c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f61850a, i2);
            }
            d.a.p0.s.f0.g gVar = this.f61857h;
            if (gVar != null) {
                gVar.I(i2);
            }
            a aVar = this.f61858i;
            if (aVar != null) {
                aVar.h(i2);
            }
            NoNetworkView noNetworkView = this.f61856g;
            if (noNetworkView != null) {
                noNetworkView.c(this.f61850a, i2);
            }
        }
    }

    public void h() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (noNetworkView = this.f61856g) != null && noNetworkView.getVisibility() == 0 && d.a.d.e.p.j.z()) {
            this.f61856g.e(false);
        }
    }

    public void i(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(arrayList));
    }

    public void j(FaceShopData faceShopData) {
        ArrayList<FacePackageData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, faceShopData) == null) {
            b();
            if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.size() <= 0) {
                return;
            }
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<FacePackageData> it = faceShopData.pack_list.iterator();
            while (it.hasNext()) {
                arrayList2.add(String.valueOf(it.next().pid));
            }
            i(arrayList2);
        }
    }

    public void k(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
            this.f61856g.d(bVar);
        }
    }

    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.c();
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            this.f61854e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f61858i.g();
        }
    }

    public void o(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.f61857h.a(gVar);
        }
    }

    public void p(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            this.f61854e.setOnSrollToBottomListener(pVar);
        }
    }

    public void q() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (hVar = this.j) == null) {
            return;
        }
        hVar.d();
        d.a.d.e.m.g.j(this.j, this.f61850a);
    }

    public void r() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.f61858i) == null) {
            return;
        }
        aVar.d();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f61854e.F();
        }
    }
}
