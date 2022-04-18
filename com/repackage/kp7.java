package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
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
import com.baidu.tieba.newinterest.adapter.InterestedForumAdapter;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.tieba.newinterest.model.InterestedForumModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.List;
/* loaded from: classes6.dex */
public class kp7 implements InterestedForumModel.d, InterestedForumAdapter.c, View.OnClickListener, InterestedForumModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final InterestedForumFragment a;
    public final InterestedForumModel b;
    public final BdRecyclerView c;
    public InterestedForumAdapter d;
    public PbListView e;
    public final TBSpecificationBtn f;
    public final TBSpecificationBtn g;
    public final TbPageContext<BaseFragmentActivity> h;
    public boolean i;
    public pp7 j;
    public int k;
    public final boolean l;
    public BdListView.p m;
    public View.OnClickListener n;

    /* loaded from: classes6.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp7 a;

        public a(kp7 kp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kp7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.i();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kp7 a;

        public b(kp7 kp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kp7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.i();
            }
        }
    }

    public kp7(InterestedForumFragment interestedForumFragment, BdRecyclerView bdRecyclerView, TBSpecificationBtn tBSpecificationBtn, TBSpecificationBtn tBSpecificationBtn2, TbPageContext<BaseFragmentActivity> tbPageContext, InterestedForumModel interestedForumModel, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {interestedForumFragment, bdRecyclerView, tBSpecificationBtn, tBSpecificationBtn2, tbPageContext, interestedForumModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
        this.a = interestedForumFragment;
        this.c = bdRecyclerView;
        this.b = interestedForumModel;
        this.h = tbPageContext;
        this.g = tBSpecificationBtn;
        this.f = tBSpecificationBtn2;
        this.k = i;
        this.l = z;
        g();
        h();
    }

    @Override // com.baidu.tieba.newinterest.adapter.InterestedForumAdapter.c
    public void a(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i > 0 && !this.g.isEnabled()) {
                this.g.setEnabled(true);
                this.g.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f11cc));
            } else if (i == 0) {
                this.g.setEnabled(false);
                this.g.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f142c));
            }
            lu4 lu4Var = new lu4();
            if (!z) {
                this.f.setText(this.h.getString(R.string.obfuscated_res_0x7f0f10c1));
                this.f.setConfig(lu4Var);
                return;
            }
            this.f.setText(this.h.getString(R.string.obfuscated_res_0x7f0f148a));
            lu4Var.t(R.color.CAM_X0109);
            this.f.setConfig(lu4Var);
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
                this.a.getActivity().finish();
            } else if (UbsABTestHelper.isFirstLoginTestB()) {
                this.a.getActivity().setResult(-1);
                this.a.getActivity().finish();
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.h.getPageActivity()).createNormalCfg(0)));
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void c(pp7 pp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pp7Var) == null) {
            pp7 pp7Var2 = this.j;
            if (pp7Var2 == null || ListUtils.isEmpty(pp7Var2.a)) {
                this.j = pp7Var;
            } else if (pp7Var != null) {
                this.j.a.addAll(pp7Var.a);
            }
            if (pp7Var != null && !ListUtils.isEmpty(pp7Var.a)) {
                if (this.c.getVisibility() == 8) {
                    this.c.setVisibility(0);
                }
                this.d.n(pp7Var.a);
                this.a.C0();
            }
            if (this.b.p()) {
                return;
            }
            l();
        }
    }

    public String e(List<np7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (np7 np7Var : list) {
                if (np7Var != null && !ListUtils.isEmpty(np7Var.a)) {
                    for (tp7 tp7Var : np7Var.a) {
                        if (tp7Var != null && tp7Var.b && tp7Var.a != null) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(tp7Var.a.forum_id);
                        }
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void f(List<op7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.b.t(list);
            this.b.o();
            if (this.i || this.l) {
                return;
            }
            this.b.g();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d = new InterestedForumAdapter();
            BdRecyclerView bdRecyclerView = this.c;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(bdRecyclerView.getContext()));
            this.c.setAdapter(this.d);
            PbListView pbListView = new PbListView(this.c.getContext());
            this.e = pbListView;
            pbListView.a();
            this.e.p(R.color.CAM_X0205);
            this.e.x();
            this.e.E(SkinManager.getColor(R.color.CAM_X0109));
            this.e.G(R.dimen.tbfontsize33);
            this.e.A(R.color.CAM_X0110);
            this.e.B(this.n);
            this.c.setNextPage(this.e);
            k();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.setOnSrollToBottomListener(this.m);
            this.b.v(this);
            this.b.u(this);
            this.d.x(this);
            this.g.setOnClickListener(this);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.b.p()) {
            InterestedForumModel interestedForumModel = this.b;
            if (interestedForumModel.f) {
                return;
            }
            interestedForumModel.o();
            k();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.d.u();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.e.J();
            this.e.Q();
            this.e.C(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f09e7));
            this.e.L(oi.f(this.c.getContext(), R.dimen.tbds217));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.e.D(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f091b), oi.f(this.c.getContext(), R.dimen.tbds178));
            this.e.G(R.dimen.tbds36);
            this.e.A(R.color.CAM_X0109);
            this.e.f();
            this.e.B(null);
            this.e.L(oi.f(this.c.getContext(), R.dimen.tbds217));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, view2) == null) && view2 == this.g) {
            List<np7> o = this.d.o();
            try {
                this.b.i(o);
                vp7.a(2, 1, this.a.B0(), "", e(o));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.newinterest.model.InterestedForumModel.d
    public void onError(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            pp7 pp7Var = this.j;
            if (pp7Var != null && !ListUtils.isEmpty(pp7Var.a)) {
                PbListView pbListView = this.e;
                if (pbListView != null) {
                    pbListView.C(this.c.getContext().getString(R.string.obfuscated_res_0x7f0f0da9));
                    this.e.f();
                    return;
                }
                return;
            }
            this.a.D0(str);
        }
    }
}
