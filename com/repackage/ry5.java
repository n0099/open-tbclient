package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.chosen.posts.ChosenPostActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.cu4;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class ry5 extends z8<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChosenPostActivity a;
    public View b;
    public NavigationBar c;
    public BdListView d;
    public qy5 e;
    public f75 f;
    public boolean g;
    public g45 h;
    public NoNetworkView i;
    public h45 j;
    public int k;
    public int l;
    public du4 m;

    /* loaded from: classes7.dex */
    public class a implements cu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry5 a;

        public a(ry5 ry5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry5Var;
        }

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.a.getModelController().H(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry5 a;

        public b(ry5 ry5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry5Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            tinfo item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.e.getItem(i)) == null) {
                return;
            }
            TiebaStatic.eventStat(this.a.getActivity(), "kantie_5", null, 1, "threadId", item.thread_id);
            this.a.getPageContext().sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.a.getActivity()).createNormalCfg(String.valueOf(item.thread_id), null, null)));
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry5 a;

        /* loaded from: classes7.dex */
        public class a implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cr4 a;

            public a(c cVar, cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cr4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cr4Var;
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    this.a.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements cr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cr4 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ c c;

            public b(c cVar, cr4 cr4Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cr4Var, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = cVar;
                this.a = cr4Var;
                this.b = i;
            }

            @Override // com.repackage.cr4.e
            public void onClick(cr4 cr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                    this.a.dismiss();
                    s65 s65Var = new s65(4101, null, null, null);
                    s65Var.g(this.c.a.e.getItem(this.b));
                    s65Var.i(this.c.a.a.getUniqueId());
                    this.c.a.a.getEventCenter().dispatchMvcEvent(s65Var);
                }
            }
        }

        public c(ry5 ry5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry5Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                cr4 cr4Var = new cr4(this.a.getActivity());
                cr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f03d0));
                cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new a(this, cr4Var));
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new b(this, cr4Var, i));
                cr4Var.create(this.a.a.getPageContext());
                cr4Var.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry5 a;

        public d(ry5 ry5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void n(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (oi.C()) {
                    this.a.a.getModelController().E();
                } else if (this.a.f != null) {
                    this.a.f.d();
                    this.a.f.g(R.string.obfuscated_res_0x7f0f0c48);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ry5 a;

        public e(ry5 ry5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ry5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ry5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ry5 ry5Var = this.a;
                ry5Var.o(ry5Var.m());
                this.a.h.attachView(this.a.m(), true);
                this.a.w();
            }
        }

        public /* synthetic */ e(ry5 ry5Var, a aVar) {
            this(ry5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ry5(ChosenPostActivity chosenPostActivity) {
        super(chosenPostActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chosenPostActivity};
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
        this.g = false;
        this.a = chosenPostActivity;
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (BdListView) invokeV.objValue;
    }

    public du4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new du4(this.a.getPageContext());
            }
            return this.m;
        }
        return (du4) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void n(s65 s65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s65Var) == null) {
            Object c2 = s65Var.c();
            if (c2 instanceof Long) {
                this.e.o(((Long) c2).longValue());
                if (this.e.getCount() <= 5) {
                    w();
                }
            }
        }
    }

    public final void o(View view2) {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, view2) == null) || (h45Var = this.j) == null) {
            return;
        }
        h45Var.dettachView(view2);
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, errorData) == null) {
            g45 g45Var = this.h;
            if (g45Var != null) {
                g45Var.dettachView(m());
            }
            if (errorData != null && this.e.c() <= 0) {
                x(m(), getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c16, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.d.A(0L);
            f75 f75Var = this.f;
            if (f75Var != null) {
                f75Var.g(R.string.obfuscated_res_0x7f0f0c48);
            }
        }
    }

    public void p(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i);
            }
            qy5 qy5Var = this.e;
            if (qy5Var != null) {
                qy5Var.onChangeSkinType(tbPageContext, i);
            }
            f75 f75Var = this.f;
            if (f75Var != null) {
                f75Var.onChangeSkinType(tbPageContext, i);
            }
            NoNetworkView noNetworkView = this.i;
            if (noNetworkView != null) {
                noNetworkView.c(tbPageContext, i);
            }
            du4 du4Var = this.m;
            if (du4Var != null) {
                du4Var.H(i);
            }
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = this.a.getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01e8, (ViewGroup) null);
            this.b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public boolean s(s65 s65Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, s65Var)) == null) {
            int b2 = s65Var.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.g = false;
                        break;
                    case 4098:
                        this.g = true;
                        break;
                    case 4099:
                        u(s65Var.a());
                        break;
                }
            } else {
                n(s65Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070237);
            this.l = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070250);
            NavigationBar navigationBar = (NavigationBar) m().findViewById(R.id.obfuscated_res_0x7f090653);
            this.c = navigationBar;
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f0f4f);
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (BdListView) m().findViewById(R.id.obfuscated_res_0x7f090652);
            this.i = (NoNetworkView) m().findViewById(R.id.obfuscated_res_0x7f0923af);
            qy5 qy5Var = new qy5(this.a.getPageContext(), new Class[]{uy5.class, ty5.class, sy5.class}, new int[]{R.layout.obfuscated_res_0x7f0d01e7, R.layout.obfuscated_res_0x7f0d01de, R.layout.obfuscated_res_0x7f0d01dd}, this.a.getEventCenter());
            this.e = qy5Var;
            this.d.setAdapter((ListAdapter) qy5Var);
            du4 l = l();
            this.m = l;
            this.d.setPullRefresh(l);
            this.m.f(new a(this));
            this.d.setOnItemClickListener(new b(this));
            this.d.setOnItemLongClickListener(new c(this));
            this.d.setExOnSrollToBottomListener(new d(this));
            f75 f75Var = new f75(this.a);
            this.f = f75Var;
            f75Var.a();
            k().setNextPage(this.f);
            g45 g45Var = new g45(getActivity());
            this.h = g45Var;
            g45Var.onChangeSkinType();
            this.h.attachView(m(), true);
            this.a.getModelController().C();
        }
    }

    public void u(i65 i65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, i65Var) == null) && (i65Var instanceof xy5)) {
            List<tinfo> a2 = ((xy5) i65Var).a();
            if (a2 != null && a2.size() > 0) {
                this.d.setVisibility(0);
            }
            g45 g45Var = this.h;
            if (g45Var != null) {
                g45Var.dettachView(m());
            }
            if (this.g) {
                this.e.i(a2);
                return;
            }
            this.e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.obfuscated_res_0x7f0f03d1, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void v(v65 v65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, v65Var) == null) && (v65Var instanceof u65)) {
            u65 u65Var = (u65) v65Var;
            if (u65Var.d()) {
                this.f.d();
                if (u65Var.b()) {
                    this.f.f(R.string.obfuscated_res_0x7f0f0a2e);
                } else if (!u65Var.a()) {
                    this.f.g(R.string.obfuscated_res_0x7f0f0c48);
                }
            } else {
                this.f.e();
            }
            if (u65Var.c()) {
                return;
            }
            this.d.A(0L);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s65 s65Var = new s65(4100, null, null, null);
            s65Var.i(this.a.getUniqueId());
            this.a.getEventCenter().dispatchMvcEvent(s65Var);
        }
    }

    public final void x(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view2, str, z) == null) {
            if (this.j == null) {
                this.j = new h45(getPageContext().getPageActivity(), new e(this, null));
            }
            this.j.m(str);
            this.j.attachView(view2, z);
            this.j.p();
        }
    }
}
