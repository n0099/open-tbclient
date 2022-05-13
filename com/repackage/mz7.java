package com.repackage;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class mz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<eo> a;
    public DetailInfoFragment b;
    public bs7 c;
    public BdTypeRecyclerView d;
    public List<ro> e;
    public rz7 f;
    public pz7 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public su7 i;
    public qu7 j;
    public iv7 k;
    public PbFirstFloorItemAdapter l;
    public ew7 m;
    public eo n;
    public eo o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        /* renamed from: com.repackage.mz7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0467a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.mz7$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0468a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0467a a;

                public RunnableC0468a(C0467a c0467a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0467a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0467a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.v().j3(3);
                    }
                }
            }

            public C0467a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!ki.z()) {
                        this.a.a.b.T0();
                    } else {
                        ng.a().postDelayed(new RunnableC0468a(this), 10L);
                    }
                }
            }
        }

        public a(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.b.v() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0467a(this));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        public b(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0919db) {
                    if (this.a.f(11009)) {
                        this.a.i(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d0b) {
                    if (this.a.f(11009)) {
                        this.a.i(3);
                    }
                } else if (this.a.b == null || this.a.b.s() == null || this.a.b.s().Z2() == null) {
                } else {
                    this.a.b.s().Z2().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends sd5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz7 a;

        public c(mz7 mz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.sd5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return wx7.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.b.v());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements zc5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ mz7 b;

        public d(mz7 mz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mz7Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.zc5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public mz7(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.b = detailInfoFragment;
        this.d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(zj8 zj8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, zj8Var) == null) || zj8Var == null || this.c == null || zj8Var.getAdvertAppInfo() == null) {
            return;
        }
        zj8Var.getAdvertAppInfo().i = new eo4();
        if (this.c.y() != null) {
            zj8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        zj8Var.getAdvertAppInfo().i.a = zj8Var.O0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            zj8Var.getAdvertAppInfo().i.c = l.getId();
            zj8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            zj8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            zj8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        zj8Var.getAdvertAppInfo().i.g = zj8Var.getAdvertAppInfo().g;
        zj8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.w(), true, i)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<ro> g(bs7 bs7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bs7Var)) == null) {
            zj8 zj8Var = null;
            if (bs7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = bs7Var.F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.A() == 1) {
                        break;
                    }
                }
            }
            if (postData == null && bs7Var.j() != null) {
                postData = bs7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            vs7 vs7Var = new vs7();
            ThreadData O = bs7Var.O();
            vs7Var.a = O;
            if (O != null && li.isEmpty(O.getForum_name())) {
                vs7Var.a.setForum_name(bs7Var.n());
            }
            this.e.add(vs7Var);
            ps7 ps7Var = new ps7(bs7Var.O(), bs7Var.d());
            ps7Var.b = true;
            this.e.add(ps7Var);
            if (postData != null && postData.o0 != null && (bs7Var.l() == null || !TextUtils.equals(bs7Var.l().getName(), this.b.v().o1()) || !this.b.v().u1())) {
                es7 es7Var = new es7(postData.o0);
                es7Var.b = this.b.v().h2();
                this.e.add(es7Var);
            }
            List<zj8> Y = bs7Var.Y();
            int i = 0;
            int i2 = -1;
            if (!pd7.e(Y) && (zj8Var = (zj8) pd7.d(Y, 0)) != null) {
                i2 = zj8Var.getPosition();
            }
            if (bs7Var.f() != null) {
                as7 as7Var = new as7();
                as7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f88));
                this.e.add(as7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new qs7());
                } else {
                    int i3 = 1;
                    for (qo4 qo4Var : bs7Var.f()) {
                        if (Y != null && i3 == i2) {
                            if (zj8Var != null) {
                                e(zj8Var);
                                pd7.a(this.e, zj8Var);
                                i++;
                                if (zj8Var.getType() != AdvertAppInfo.u) {
                                    i3++;
                                }
                            }
                            if (i < Y.size() && (zj8Var = (zj8) pd7.d(Y, i)) != null) {
                                i2 = zj8Var.getPosition();
                            }
                        }
                        pd7.a(this.e, qo4Var);
                        i3++;
                        if (i3 == 4 && bs7Var.C() != null) {
                            pd7.a(this.e, bs7Var.C());
                            i3++;
                        }
                    }
                }
            }
            return this.e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            bs7 bs7Var = this.c;
            if (bs7Var == null || bs7Var.O() == null) {
                return -1;
            }
            return this.c.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            vd5.b(new c(this), new d(this, i));
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

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = ja8.l().a(detailInfoFragment.s().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.o = ja8.l().a(detailInfoFragment.s().getBaseFragmentActivity(), AdvertAppInfo.w);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment s = detailInfoFragment.s();
            this.f = new rz7(s, s, PostData.w0);
            this.g = new pz7(detailInfoFragment.getContext(), vs7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.s(), ps7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.q);
            this.i = new su7(detailInfoFragment.s(), as7.c);
            qu7 qu7Var = new qu7(detailInfoFragment.s(), qo4.e);
            this.j = qu7Var;
            qu7Var.g0(true);
            this.k = new iv7(detailInfoFragment.s());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), es7.c);
            ew7 ew7Var = new ew7(detailInfoFragment.s(), qs7.a);
            this.m = ew7Var;
            ew7Var.e0(this.p);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.a(this.a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        rz7 rz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (rz7Var = this.f) == null) {
            return;
        }
        rz7Var.H();
    }

    public void n(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bs7Var) == null) || bs7Var == null) {
            return;
        }
        this.c = bs7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.A0(bs7Var);
        this.j.f0(bs7Var);
        this.k.d0(bs7Var);
        this.d.setData(g(bs7Var));
    }
}
