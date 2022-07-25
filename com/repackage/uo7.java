package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes7.dex */
public class uo7 implements InterestedForumModel.d, hp7, View.OnClickListener, InterestedForumModel.c, gp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public to7 a;
    public final BaseInterestedForumFragment b;
    public final InterestedForumModel c;
    public final BdTypeRecyclerView d;
    public PbListView e;
    public final TBSpecificationBtn f;
    public final TBSpecificationBtn g;
    public final TbPageContext<BaseFragmentActivity> h;
    public boolean i;
    public yo7 j;
    public int k;
    public final boolean l;
    public BdListView.p m;
    public View.OnClickListener n;

    /* loaded from: classes7.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo7 a;

        public a(uo7 uo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo7 a;

        public b(uo7 uo7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uo7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.j();
            }
        }
    }

    public uo7(BaseInterestedForumFragment baseInterestedForumFragment, BdTypeRecyclerView bdTypeRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, InterestedForumModel interestedForumModel, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseInterestedForumFragment, bdTypeRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, interestedForumModel, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.k = 0;
        this.m = new a(this);
        this.n = new b(this);
        this.b = baseInterestedForumFragment;
        this.d = bdTypeRecyclerView;
        this.c = interestedForumModel;
        this.h = tbPageContext;
        this.g = tBSpecificationBtn;
        this.f = tBSpecificationBtn2;
        this.k = i;
        this.l = z;
        this.a = new to7(tbPageContext.getPageActivity(), this.d);
        h();
        i();
    }

    @Override // com.repackage.hp7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.e()) {
                this.g.setEnabled(true);
                this.g.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f11b0));
            } else {
                this.g.setEnabled(false);
                this.g.setText(this.d.getResources().getString(R.string.obfuscated_res_0x7f0f091e));
            }
            wu4 wu4Var = new wu4();
            this.f.setTextSize(R.dimen.T_X06);
            if (!this.a.f()) {
                this.f.setText(this.h.getString(R.string.obfuscated_res_0x7f0f0924));
                wu4Var.p(R.color.CAM_X0304);
                this.f.setConfig(wu4Var);
                return;
            }
            this.f.setText(this.h.getString(R.string.obfuscated_res_0x7f0f0926));
            wu4Var.r(R.color.CAM_X0105);
            this.f.setConfig(wu4Var);
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.i) {
                this.i = true;
            } else if (this.k == 5) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921632));
                this.b.getActivity().finish();
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.b.getActivity().setResult(-1);
                this.b.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.h.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void c(yo7 yo7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yo7Var) == null) {
            yo7 yo7Var2 = this.j;
            if (yo7Var2 == null || ListUtils.isEmpty(yo7Var2.a)) {
                this.j = yo7Var;
            } else if (yo7Var != null) {
                this.j.a.addAll(yo7Var.a);
            }
            if (yo7Var != null && !ListUtils.isEmpty(yo7Var.a)) {
                if (this.d.getVisibility() == 8) {
                    this.d.setVisibility(0);
                }
                this.a.j(yo7Var.a);
                this.b.t1();
            }
            if (this.c.n()) {
                return;
            }
            n();
        }
    }

    @Override // com.repackage.gp7
    public void d(int i, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) {
            ep7.b(str);
            this.a.a(i, this.j, i2);
        }
    }

    public String f(List<nn> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                nn nnVar = list.get(i);
                if (nnVar instanceof zo7) {
                    zo7 zo7Var = (zo7) nnVar;
                    if (zo7Var.k()) {
                        if (sb.length() > 0) {
                            sb.append("|");
                        }
                        sb.append(zo7Var.c());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void g(List<xo7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.c.r(list);
            this.c.m();
            if (this.i || this.l) {
                return;
            }
            this.c.g();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PbListView pbListView = new PbListView(this.d.getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.p(R.color.CAM_X0601);
            this.e.x();
            this.e.E(SkinManager.getColor(R.color.CAM_X0109));
            this.e.G(R.dimen.tbfontsize33);
            this.e.A(R.color.CAM_X0110);
            this.e.B(this.n);
            this.d.setNextPage(this.e);
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setOnSrollToBottomListener(this.m);
            this.c.t(this);
            this.c.s(this);
            this.a.k(this);
            this.a.i(this);
            this.g.setOnClickListener(this);
            this.f.setOnClickListener(this);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.c.n()) {
            InterestedForumModel interestedForumModel = this.c;
            if (interestedForumModel.f) {
                return;
            }
            interestedForumModel.m();
            m();
        }
    }

    public void k(int i) {
        to7 to7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (to7Var = this.a) == null) {
            return;
        }
        to7Var.g(i);
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.a.b(z);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.J();
            this.e.Q();
            this.e.C(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f09d2));
            this.e.L(pi.f(this.d.getContext(), R.dimen.tbds217));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.D(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f0920), pi.f(this.d.getContext(), R.dimen.tbds178));
            this.e.G(R.dimen.tbds36);
            this.e.A(R.color.CAM_X0109);
            this.e.f();
            this.e.B(null);
            this.e.L(pi.f(this.d.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, view2) == null) {
            if (view2 == this.g) {
                List<nn> c = this.a.c();
                try {
                    this.c.i(c);
                    ep7.a(2, 1, this.b.s1(), "", f(c));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else if (view2 != this.f || hd5.a()) {
            } else {
                if (this.h.getString(R.string.obfuscated_res_0x7f0f0924).equals(this.f.getText())) {
                    l(true);
                } else if (this.h.getString(R.string.obfuscated_res_0x7f0f0926).equals(this.f.getText())) {
                    l(false);
                }
                a();
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            yo7 yo7Var = this.j;
            if (yo7Var != null && !ListUtils.isEmpty(yo7Var.a)) {
                PbListView pbListView = this.e;
                if (pbListView != null) {
                    pbListView.C(this.d.getContext().getString(R.string.obfuscated_res_0x7f0f0daa));
                    this.e.f();
                    return;
                }
                return;
            }
            this.b.u1(str);
        }
    }
}
