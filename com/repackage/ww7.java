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
public class ww7 extends tw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zw7 A;
    public PbFirstFloorItemAdapter B;
    public wm C;
    public wm D;
    public View.OnClickListener E;
    public cs7 n;
    public ax7 o;
    public PbFirstFloorCommentAndPraiseAdapter p;
    public xw7 q;
    public PbFirstFloorEnterForumAdapter r;
    public ht7 s;
    public PbReplyLoadMoreAdapter t;
    public dt7 u;
    public ts7 v;
    public us7 w;
    public bs7 x;
    public zr7 y;
    public rs7 z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww7 a;

        public a(ww7 ww7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f09198f) {
                    if (this.a.K(11009)) {
                        this.a.M(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091cb6 && this.a.K(11009)) {
                    this.a.M(3);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends mc5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww7 a;

        public b(ww7 ww7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mc5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return fv7.d(this.a.L(), ShareSwitch.isOn() ? 1 : 6, this.a.b.v());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements tb5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ww7 b;

        public c(ww7 ww7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ww7Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.tb5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.tw7
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.v.d0(onClickListener);
        }
    }

    @Override // com.repackage.tw7
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.w.d0(onClickListener);
        }
    }

    @Override // com.repackage.tw7
    public void C(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp7Var) == null) {
            this.s.t(kp7Var);
        }
    }

    @Override // com.repackage.tw7
    public void D(mq7 mq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mq7Var) == null) {
            super.D(mq7Var);
            this.n.P0(mq7Var);
        }
    }

    @Override // com.repackage.tw7
    public void E(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kp7Var) == null) {
            this.o.A0(kp7Var);
        }
    }

    @Override // com.repackage.tw7
    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.o.q(str);
        }
    }

    public final boolean K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.w(), true, i)));
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
            kp7 kp7Var = this.d;
            if (kp7Var == null || kp7Var.O() == null) {
                return -1;
            }
            return this.d.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void M(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            pc5.b(new b(this), new c(this, i));
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
            AbsVideoPbFragment s = this.b.s();
            this.o = new ax7(s, s, PostData.w0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.b.s(), yp7.f);
            this.p = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.E);
            this.q = new xw7(this.b.getContext(), fq7.b);
            this.r = new PbFirstFloorEnterForumAdapter(this.b, mp7.i);
            this.s = new ht7(this.b.s(), xp7.h);
            this.v = new ts7(this.b.s(), qp7.c, this.b.getUniqueId());
            this.w = new us7(this.b.s(), rp7.a);
            this.u = new dt7(this.b.s(), up7.L0);
            this.x = new bs7(this.b.s(), jp7.c);
            zr7 zr7Var = new zr7(this.b.s(), fn4.e);
            this.y = zr7Var;
            zr7Var.g0(true);
            this.z = new rs7(this.b.s());
            cs7 cs7Var = new cs7(this.b.s(), PostData.x0);
            this.n = cs7Var;
            cs7Var.Q0(this.b.s());
            this.t = new PbReplyLoadMoreAdapter(this.b.s(), PostData.D0);
            this.C = q78.l().a(this.b.s().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.D = q78.l().a(this.b.s().getBaseFragmentActivity(), AdvertAppInfo.w);
            zw7 zw7Var = new zw7(this.b.getPageContext(), ThreadData.TYPE_ITEM, this.b.getUniqueId());
            this.A = zw7Var;
            zw7Var.b0(this.c);
            this.B = new PbFirstFloorItemAdapter(this.b.getContext(), np7.c);
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
            this.e.add(new PbPrivateTitleAdapter(this.b.s()));
            this.c.a(this.e);
        }
    }

    @Override // com.repackage.tw7
    public ht7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.s : (ht7) invokeV.objValue;
    }

    @Override // com.repackage.tw7
    public cs7 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : (cs7) invokeV.objValue;
    }

    @Override // com.repackage.tw7
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.p : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.repackage.tw7
    public void m() {
        ax7 ax7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ax7Var = this.o) == null) {
            return;
        }
        ax7Var.H();
    }

    @Override // com.repackage.tw7
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ht7 ht7Var = this.s;
            if (ht7Var != null) {
                ht7Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.p;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // com.repackage.tw7
    public void p(boolean z) {
        wm wmVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && (wmVar = this.D) != null && (wmVar instanceof m78)) {
            ((m78) wmVar).j(z);
        }
    }

    @Override // com.repackage.tw7
    public void q(kp7 kp7Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{kp7Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.n.t(kp7Var);
            this.n.setFromCDN(z);
            this.n.q(str);
            this.n.c(z2);
        }
    }

    @Override // com.repackage.tw7
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            super.v(onClickListener);
            this.n.l(onClickListener);
        }
    }

    @Override // com.repackage.tw7
    public void w(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, yVar) == null) {
            super.w(yVar);
            this.n.o(yVar);
        }
    }

    @Override // com.repackage.tw7
    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            super.x(onLongClickListener);
            this.n.d(onLongClickListener);
        }
    }

    @Override // com.repackage.tw7
    public void y(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) {
            super.y(fVar);
            this.s.f0(fVar);
        }
    }

    @Override // com.repackage.tw7
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
