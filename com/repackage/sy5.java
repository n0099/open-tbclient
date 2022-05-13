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
import com.repackage.nr4;
import com.repackage.pu4;
import java.util.List;
import tbclient.HotThread.tinfo;
/* loaded from: classes7.dex */
public class sy5 extends z8<ChosenPostActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChosenPostActivity a;
    public View b;
    public NavigationBar c;
    public BdListView d;
    public ry5 e;
    public v75 f;
    public boolean g;
    public x45 h;
    public NoNetworkView i;
    public y45 j;
    public int k;
    public int l;
    public qu4 m;

    /* loaded from: classes7.dex */
    public class a implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy5 a;

        public a(sy5 sy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy5Var;
        }

        @Override // com.repackage.pu4.g
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
        public final /* synthetic */ sy5 a;

        public b(sy5 sy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy5Var;
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
        public final /* synthetic */ sy5 a;

        /* loaded from: classes7.dex */
        public class a implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nr4 a;

            public a(c cVar, nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, nr4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nr4Var;
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    this.a.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nr4 a;
            public final /* synthetic */ int b;
            public final /* synthetic */ c c;

            public b(c cVar, nr4 nr4Var, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, nr4Var, Integer.valueOf(i)};
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
                this.a = nr4Var;
                this.b = i;
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    this.a.dismiss();
                    i75 i75Var = new i75(4101, null, null, null);
                    i75Var.g(this.c.a.e.getItem(this.b));
                    i75Var.i(this.c.a.a.getUniqueId());
                    this.c.a.a.getEventCenter().dispatchMvcEvent(i75Var);
                }
            }
        }

        public c(sy5 sy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy5Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                nr4 nr4Var = new nr4(this.a.getActivity());
                nr4Var.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f03d5));
                nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new a(this, nr4Var));
                nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0428, new b(this, nr4Var, i));
                nr4Var.create(this.a.a.getPageContext());
                nr4Var.show();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements BdListView.q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy5 a;

        public d(sy5 sy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy5Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void m(BdListView bdListView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdListView) == null) {
                if (mi.C()) {
                    this.a.a.getModelController().E();
                } else if (this.a.f != null) {
                    this.a.f.d();
                    this.a.f.g(R.string.obfuscated_res_0x7f0f0c5f);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy5 a;

        public e(sy5 sy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                sy5 sy5Var = this.a;
                sy5Var.q(sy5Var.n());
                this.a.h.attachView(this.a.n(), true);
                this.a.x();
            }
        }

        public /* synthetic */ e(sy5 sy5Var, a aVar) {
            this(sy5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sy5(ChosenPostActivity chosenPostActivity) {
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

    public BdListView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (BdListView) invokeV.objValue;
    }

    public qu4 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.m == null) {
                this.m = new qu4(this.a.getPageContext());
            }
            return this.m;
        }
        return (qu4) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public final void o(i75 i75Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, i75Var) == null) {
            Object c2 = i75Var.c();
            if (c2 instanceof Long) {
                this.e.o(((Long) c2).longValue());
                if (this.e.getCount() <= 5) {
                    x();
                }
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, errorData) == null) {
            x45 x45Var = this.h;
            if (x45Var != null) {
                x45Var.dettachView(n());
            }
            if (errorData != null && this.e.c() <= 0) {
                y(n(), getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c2c, errorData.getError_msg(), Integer.valueOf(errorData.getError_code())), true);
            }
            this.d.A(0L);
            v75 v75Var = this.f;
            if (v75Var != null) {
                v75Var.g(R.string.obfuscated_res_0x7f0f0c5f);
            }
        }
    }

    public final void q(View view2) {
        y45 y45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view2) == null) || (y45Var = this.j) == null) {
            return;
        }
        y45Var.dettachView(view2);
    }

    public void r(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            NavigationBar navigationBar = this.c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(tbPageContext, i);
            }
            ry5 ry5Var = this.e;
            if (ry5Var != null) {
                ry5Var.onChangeSkinType(tbPageContext, i);
            }
            v75 v75Var = this.f;
            if (v75Var != null) {
                v75Var.onChangeSkinType(tbPageContext, i);
            }
            NoNetworkView noNetworkView = this.i;
            if (noNetworkView != null) {
                noNetworkView.c(tbPageContext, i);
            }
            qu4 qu4Var = this.m;
            if (qu4Var != null) {
                qu4Var.H(i);
            }
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View inflate = this.a.getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d01e1, (ViewGroup) null);
            this.b = inflate;
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    public boolean t(i75 i75Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, i75Var)) == null) {
            int b2 = i75Var.b();
            if (b2 != 4102) {
                switch (b2) {
                    case 4097:
                        this.g = false;
                        break;
                    case 4098:
                        this.g = true;
                        break;
                    case 4099:
                        v(i75Var.a());
                        break;
                }
            } else {
                o(i75Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.k = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070237);
            this.l = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070250);
            NavigationBar navigationBar = (NavigationBar) n().findViewById(R.id.obfuscated_res_0x7f09064b);
            this.c = navigationBar;
            navigationBar.setTitleText(R.string.obfuscated_res_0x7f0f0f6b);
            this.c.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d = (BdListView) n().findViewById(R.id.obfuscated_res_0x7f09064a);
            this.i = (NoNetworkView) n().findViewById(R.id.obfuscated_res_0x7f0923ff);
            ry5 ry5Var = new ry5(this.a.getPageContext(), new Class[]{vy5.class, uy5.class, ty5.class}, new int[]{R.layout.obfuscated_res_0x7f0d01e0, R.layout.obfuscated_res_0x7f0d01d7, R.layout.obfuscated_res_0x7f0d01d6}, this.a.getEventCenter());
            this.e = ry5Var;
            this.d.setAdapter((ListAdapter) ry5Var);
            qu4 m = m();
            this.m = m;
            this.d.setPullRefresh(m);
            this.m.e(new a(this));
            this.d.setOnItemClickListener(new b(this));
            this.d.setOnItemLongClickListener(new c(this));
            this.d.setExOnSrollToBottomListener(new d(this));
            v75 v75Var = new v75(this.a);
            this.f = v75Var;
            v75Var.a();
            l().setNextPage(this.f);
            x45 x45Var = new x45(getActivity());
            this.h = x45Var;
            x45Var.onChangeSkinType();
            this.h.attachView(n(), true);
            this.a.getModelController().C();
        }
    }

    public void v(y65 y65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, y65Var) == null) && (y65Var instanceof yy5)) {
            List<tinfo> a2 = ((yy5) y65Var).a();
            if (a2 != null && a2.size() > 0) {
                this.d.setVisibility(0);
            }
            x45 x45Var = this.h;
            if (x45Var != null) {
                x45Var.dettachView(n());
            }
            if (this.g) {
                this.e.i(a2);
                return;
            }
            this.e.k(a2);
            if (a2 == null) {
                return;
            }
            BdToast d2 = BdToast.d(getActivity(), getActivity().getString(R.string.obfuscated_res_0x7f0f03d6, new Object[]{Integer.valueOf(a2.size())}), 0);
            d2.l(48);
            d2.n(this.k);
            d2.o(this.l);
            d2.a();
            d2.q();
        }
    }

    public void w(l75 l75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, l75Var) == null) && (l75Var instanceof k75)) {
            k75 k75Var = (k75) l75Var;
            if (k75Var.d()) {
                this.f.d();
                if (k75Var.b()) {
                    this.f.f(R.string.obfuscated_res_0x7f0f0a34);
                } else if (!k75Var.a()) {
                    this.f.g(R.string.obfuscated_res_0x7f0f0c5f);
                }
            } else {
                this.f.e();
            }
            if (k75Var.c()) {
                return;
            }
            this.d.A(0L);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            i75 i75Var = new i75(4100, null, null, null);
            i75Var.i(this.a.getUniqueId());
            this.a.getEventCenter().dispatchMvcEvent(i75Var);
        }
    }

    public final void y(View view2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048590, this, view2, str, z) == null) {
            if (this.j == null) {
                this.j = new y45(getPageContext().getPageActivity(), new e(this, null));
            }
            this.j.m(str);
            this.j.attachView(view2, z);
            this.j.p();
        }
    }
}
