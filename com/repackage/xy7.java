package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xy7 extends uy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public az7 A;
    public PbFirstFloorItemAdapter B;
    public an C;
    public an D;
    public View.OnClickListener E;
    public bu7 n;
    public bz7 o;
    public PbFirstFloorCommentAndPraiseAdapter p;
    public yy7 q;
    public PbFirstFloorEnterForumAdapter r;
    public gv7 s;
    public PbReplyLoadMoreAdapter t;
    public cv7 u;
    public su7 v;
    public tu7 w;
    public au7 x;
    public yt7 y;
    public qu7 z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy7 a;

        public a(xy7 xy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091a2e) {
                    if (this.a.K(11009)) {
                        this.a.M(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51 && this.a.K(11009)) {
                    this.a.M(3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends de5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xy7 a;

        public b(xy7 xy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return gx7.d(this.a.L(), ShareSwitch.isOn() ? 1 : 6, this.a.b.F());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements jd5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ xy7 b;

        public c(xy7 xy7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xy7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xy7Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xy7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = new a(this);
        N();
    }

    @Override // com.repackage.uy7
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.v.d0(onClickListener);
        }
    }

    @Override // com.repackage.uy7
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.w.d0(onClickListener);
        }
    }

    @Override // com.repackage.uy7
    public void C(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jr7Var) == null) {
            this.s.s(jr7Var);
        }
    }

    @Override // com.repackage.uy7
    public void D(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ls7Var) == null) {
            super.D(ls7Var);
            this.n.P0(ls7Var);
        }
    }

    @Override // com.repackage.uy7
    public void E(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jr7Var) == null) {
            this.o.A0(jr7Var);
        }
    }

    @Override // com.repackage.uy7
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.o.p(str);
        }
    }

    public final boolean K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.N(), true, i)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            jr7 jr7Var = this.d;
            if (jr7Var == null || jr7Var.O() == null) {
                return -1;
            }
            return this.d.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            he5.b(new b(this), new c(this, i));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AbsVideoPbFragment B = this.b.B();
            this.o = new bz7(B, B, PostData.z0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.b.B(), xr7.f);
            this.p = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.E);
            this.q = new yy7(this.b.getContext(), es7.b);
            this.r = new PbFirstFloorEnterForumAdapter(this.b, lr7.i);
            this.s = new gv7(this.b.B(), wr7.h);
            this.v = new su7(this.b.B(), pr7.c, this.b.getUniqueId());
            this.w = new tu7(this.b.B(), qr7.a);
            this.u = new cv7(this.b.B(), tr7.O0);
            this.x = new au7(this.b.B(), ir7.c);
            yt7 yt7Var = new yt7(this.b.B(), eo4.e);
            this.y = yt7Var;
            yt7Var.g0(true);
            this.z = new qu7(this.b.B());
            bu7 bu7Var = new bu7(this.b.B(), PostData.A0);
            this.n = bu7Var;
            bu7Var.Q0(this.b.B());
            this.t = new PbReplyLoadMoreAdapter(this.b.B(), PostData.G0);
            this.C = s98.l().a(this.b.B().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.D = s98.l().a(this.b.B().getBaseFragmentActivity(), AdvertAppInfo.w);
            az7 az7Var = new az7(this.b.getPageContext(), ThreadData.TYPE_ITEM, this.b.getUniqueId());
            this.A = az7Var;
            az7Var.b0(this.c);
            this.B = new PbFirstFloorItemAdapter(this.b.getContext(), mr7.c);
            this.e.add(this.o);
            this.e.add(this.p);
            this.e.add(this.q);
            this.e.add(this.r);
            this.e.add(this.s);
            this.e.add(this.u);
            this.e.add(this.v);
            this.e.add(this.w);
            this.e.add(this.x);
            this.e.add(this.y);
            this.e.add(this.z);
            this.e.add(this.C);
            this.e.add(this.D);
            this.e.add(this.n);
            this.e.add(this.t);
            this.e.add(this.A);
            this.e.add(this.B);
            this.e.add(new PbPrivateTitleAdapter(this.b.B()));
            this.c.a(this.e);
        }
    }

    @Override // com.repackage.uy7
    public gv7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : (gv7) invokeV.objValue;
    }

    @Override // com.repackage.uy7
    public bu7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (bu7) invokeV.objValue;
    }

    @Override // com.repackage.uy7
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.repackage.uy7
    public void m() {
        bz7 bz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bz7Var = this.o) == null) {
            return;
        }
        bz7Var.G();
    }

    @Override // com.repackage.uy7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            gv7 gv7Var = this.s;
            if (gv7Var != null) {
                gv7Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.p;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // com.repackage.uy7
    public void p(boolean z) {
        an anVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (anVar = this.D) != null && (anVar instanceof o98)) {
            ((o98) anVar).j(z);
        }
    }

    @Override // com.repackage.uy7
    public void q(jr7 jr7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{jr7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.n.s(jr7Var);
            this.n.setFromCDN(z);
            this.n.p(str);
            this.n.c(z2);
        }
    }

    @Override // com.repackage.uy7
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            super.v(onClickListener);
            this.n.l(onClickListener);
        }
    }

    @Override // com.repackage.uy7
    public void w(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yVar) == null) {
            super.w(yVar);
            this.n.o(yVar);
        }
    }

    @Override // com.repackage.uy7
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.n.d(onLongClickListener);
        }
    }

    @Override // com.repackage.uy7
    public void y(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            super.y(fVar);
            this.s.f0(fVar);
        }
    }

    @Override // com.repackage.uy7
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            super.z(onClickListener);
            this.n.e(onClickListener);
            this.s.e(onClickListener);
            this.t.d0(onClickListener);
        }
    }
}
