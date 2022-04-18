package com.repackage;

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
import com.repackage.cu4;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class l96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<FaceShopActivity> a;
    public final LinearLayout b;
    public final NavigationBar c;
    public final TextView d;
    public final BdListView e;
    public final k96 f;
    public final NoNetworkView g;
    public final du4 h;
    public final a i;
    public final f96 j;

    /* loaded from: classes6.dex */
    public class a extends io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TbPageContext<?> b;
        public TextView c;
        public ProgressBar d;
        public View e;
        public View f;

        public a(l96 l96Var, TbPageContext<?> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l96Var, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = null;
            this.d = null;
            this.e = null;
            this.b = tbPageContext;
        }

        @Override // com.repackage.io
        public View a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                View inflate = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0600, (ViewGroup) null);
                this.e = inflate;
                inflate.setPadding(0, this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be), 0, this.b.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be));
                this.c = (TextView) this.e.findViewById(R.id.obfuscated_res_0x7f0916eb);
                View findViewById = this.e.findViewById(R.id.obfuscated_res_0x7f0916ee);
                this.f = findViewById;
                findViewById.setVisibility(8);
                this.d = (ProgressBar) this.e.findViewById(R.id.obfuscated_res_0x7f09191d);
                h(TbadkApplication.getInst().getSkinType());
                this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return this.e;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.io
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.e.setVisibility(0);
            }
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.e.setVisibility(8);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.d.setVisibility(8);
                this.c.setText(R.string.obfuscated_res_0x7f0f0a2b);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.d.setVisibility(0);
                this.c.setText(this.b.getPageActivity().getText(R.string.obfuscated_res_0x7f0f0a2e));
                this.f.setVisibility(0);
            }
        }

        public void h(int i) {
            TbPageContext<?> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048582, this, i) == null) || (tbPageContext = this.b) == null) {
                return;
            }
            tbPageContext.getLayoutMode().k(i == 1);
            this.b.getLayoutMode().j(this.f);
        }
    }

    public l96(TbPageContext<FaceShopActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        tbPageContext.getPageActivity().setContentView(R.layout.obfuscated_res_0x7f0d0290);
        this.b = (LinearLayout) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090960);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0923ac);
        this.c = navigationBar;
        navigationBar.setTitleText(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f05e6));
        this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f0a77));
        this.d = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0106, 1);
        this.g = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f0923ae);
        this.e = (BdListView) tbPageContext.getPageActivity().findViewById(R.id.obfuscated_res_0x7f090961);
        this.h = new du4(tbPageContext);
        this.f = new k96(tbPageContext.getOrignalPage());
        this.i = new a(this, tbPageContext);
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setPullRefresh(this.h);
        this.e.setNextPage(this.i);
        try {
            this.d.setOnClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.j = new f96(tbPageContext, R.style.obfuscated_res_0x7f10039f);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.g.a(bVar);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i.f();
            this.e.A(0L);
        }
    }

    public k96 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f : (k96) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (TextView) invokeV.objValue;
    }

    public void e() {
        f96 f96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (f96Var = this.j) == null) {
            return;
        }
        rg.b(f96Var, this.a);
    }

    public void f() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (aVar = this.i) == null) {
            return;
        }
        aVar.e();
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            sm4 layoutMode = this.a.getLayoutMode();
            layoutMode.k(i == 1);
            layoutMode.j(this.b);
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            du4 du4Var = this.h;
            if (du4Var != null) {
                du4Var.H(i);
            }
            a aVar = this.i;
            if (aVar != null) {
                aVar.h(i);
            }
            NoNetworkView noNetworkView = this.g;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
        }
    }

    public void h() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (noNetworkView = this.g) != null && noNetworkView.getVisibility() == 0 && mi.z()) {
            this.g.update(false);
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
            this.g.d(bVar);
        }
    }

    public void l() {
        f96 f96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (f96Var = this.j) == null) {
            return;
        }
        f96Var.c();
    }

    public void m(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onItemClickListener) == null) {
            this.e.setOnItemClickListener(onItemClickListener);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.i.g();
        }
    }

    public void o(cu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.h.f(gVar);
        }
    }

    public void p(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, pVar) == null) {
            this.e.setOnSrollToBottomListener(pVar);
        }
    }

    public void q() {
        f96 f96Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (f96Var = this.j) == null) {
            return;
        }
        f96Var.d();
        rg.j(this.j, this.a);
    }

    public void r() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (aVar = this.i) == null) {
            return;
        }
        aVar.d();
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.F();
        }
    }
}
