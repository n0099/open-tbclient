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
/* loaded from: classes7.dex */
public class wy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<an> a;
    public DetailInfoFragment b;
    public jr7 c;
    public BdTypeRecyclerView d;
    public List<nn> e;
    public bz7 f;
    public zy7 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public au7 i;
    public yt7 j;
    public qu7 k;
    public PbFirstFloorItemAdapter l;
    public mv7 m;
    public an n;
    public an o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy7 a;

        /* renamed from: com.repackage.wy7$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0766a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.wy7$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0767a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0766a a;

                public RunnableC0767a(C0766a c0766a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0766a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0766a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.F().l3(3);
                    }
                }
            }

            public C0766a(a aVar) {
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
                    if (!ni.z()) {
                        this.a.a.b.K1();
                    } else {
                        qg.a().postDelayed(new RunnableC0767a(this), 10L);
                    }
                }
            }
        }

        public a(wy7 wy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.b.F() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0766a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy7 a;

        public b(wy7 wy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091a2e) {
                    if (this.a.f(11009)) {
                        this.a.i(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091d51) {
                    if (this.a.f(11009)) {
                        this.a.i(3);
                    }
                } else if (this.a.b == null || this.a.b.B() == null || this.a.b.B().S3() == null) {
                } else {
                    this.a.b.B().S3().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends de5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy7 a;

        public c(wy7 wy7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.de5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return gx7.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.b.F());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements jd5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ wy7 b;

        public d(wy7 wy7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wy7Var;
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

    public wy7(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(ni8 ni8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ni8Var) == null) || ni8Var == null || this.c == null || ni8Var.getAdvertAppInfo() == null) {
            return;
        }
        ni8Var.getAdvertAppInfo().i = new sn4();
        if (this.c.y() != null) {
            ni8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        ni8Var.getAdvertAppInfo().i.a = ni8Var.S0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            ni8Var.getAdvertAppInfo().i.c = l.getId();
            ni8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            ni8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ni8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        ni8Var.getAdvertAppInfo().i.g = ni8Var.getAdvertAppInfo().g;
        ni8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.N(), true, i)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<nn> g(jr7 jr7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jr7Var)) == null) {
            ni8 ni8Var = null;
            if (jr7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = jr7Var.F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.B() == 1) {
                        break;
                    }
                }
            }
            if (postData == null && jr7Var.j() != null) {
                postData = jr7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            ds7 ds7Var = new ds7();
            ThreadData O = jr7Var.O();
            ds7Var.a = O;
            if (O != null && oi.isEmpty(O.getForum_name())) {
                ds7Var.a.setForum_name(jr7Var.n());
            }
            this.e.add(ds7Var);
            xr7 xr7Var = new xr7(jr7Var.O(), jr7Var.d());
            xr7Var.b = true;
            this.e.add(xr7Var);
            if (postData != null && postData.o0 != null && (jr7Var.l() == null || !TextUtils.equals(jr7Var.l().getName(), this.b.F().q1()) || !this.b.F().w1())) {
                mr7 mr7Var = new mr7(postData.o0);
                mr7Var.b = this.b.F().j2();
                this.e.add(mr7Var);
            }
            List<ni8> Y = jr7Var.Y();
            int i = 0;
            int i2 = -1;
            if (!gd7.e(Y) && (ni8Var = (ni8) gd7.d(Y, 0)) != null) {
                i2 = ni8Var.getPosition();
            }
            if (jr7Var.f() != null) {
                ir7 ir7Var = new ir7();
                ir7Var.d(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f9f));
                this.e.add(ir7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new yr7());
                } else {
                    int i3 = 1;
                    for (eo4 eo4Var : jr7Var.f()) {
                        if (Y != null && i3 == i2) {
                            if (ni8Var != null) {
                                e(ni8Var);
                                gd7.a(this.e, ni8Var);
                                i++;
                                if (ni8Var.getType() != AdvertAppInfo.u) {
                                    i3++;
                                }
                            }
                            if (i < Y.size() && (ni8Var = (ni8) gd7.d(Y, i)) != null) {
                                i2 = ni8Var.getPosition();
                            }
                        }
                        gd7.a(this.e, eo4Var);
                        i3++;
                        if (i3 == 4 && jr7Var.C() != null) {
                            gd7.a(this.e, jr7Var.C());
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
            jr7 jr7Var = this.c;
            if (jr7Var == null || jr7Var.O() == null) {
                return -1;
            }
            return this.c.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            he5.b(new c(this), new d(this, i));
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
            this.n = s98.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.o = s98.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.w);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment B = detailInfoFragment.B();
            this.f = new bz7(B, B, PostData.z0);
            this.g = new zy7(detailInfoFragment.getContext(), ds7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.B(), xr7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.q);
            this.i = new au7(detailInfoFragment.B(), ir7.c);
            yt7 yt7Var = new yt7(detailInfoFragment.B(), eo4.e);
            this.j = yt7Var;
            yt7Var.g0(true);
            this.k = new qu7(detailInfoFragment.B());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), mr7.c);
            mv7 mv7Var = new mv7(detailInfoFragment.B(), yr7.a);
            this.m = mv7Var;
            mv7Var.e0(this.p);
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
        bz7 bz7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (bz7Var = this.f) == null) {
            return;
        }
        bz7Var.G();
    }

    public void n(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        this.c = jr7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.A0(jr7Var);
        this.j.f0(jr7Var);
        this.k.d0(jr7Var);
        this.d.setData(g(jr7Var));
    }
}
