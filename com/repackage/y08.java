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
public class y08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<bn> a;
    public DetailInfoFragment b;
    public et7 c;
    public BdTypeRecyclerView d;
    public List<on> e;
    public d18 f;
    public b18 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public xv7 i;
    public vv7 j;
    public nw7 k;
    public PbFirstFloorItemAdapter l;
    public lx7 m;
    public bn n;
    public bn o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y08 a;

        /* renamed from: com.repackage.y08$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0631a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.repackage.y08$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0632a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0631a a;

                public RunnableC0632a(C0631a c0631a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0631a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0631a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.K().o3(3);
                    }
                }
            }

            public C0631a(a aVar) {
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
                    if (!oi.z()) {
                        this.a.a.b.J1();
                    } else {
                        rg.a().postDelayed(new RunnableC0632a(this), 10L);
                    }
                }
            }
        }

        public a(y08 y08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.b.K() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0631a(this));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y08 a;

        public b(y08 y08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y08Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091ade) {
                    if (this.a.f(11009)) {
                        this.a.i(8);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e43) {
                    if (this.a.f(11009)) {
                        this.a.i(3);
                    }
                } else if (this.a.b == null || this.a.b.B() == null || this.a.b.B().R3() == null) {
                } else {
                    this.a.b.B().R3().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends cf5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y08 a;

        public c(y08 y08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = y08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return gz7.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.b.K());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements je5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ y08 b;

        public d(y08 y08Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y08Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = y08Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.je5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public y08(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(al8 al8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, al8Var) == null) || al8Var == null || this.c == null || al8Var.getAdvertAppInfo() == null) {
            return;
        }
        al8Var.getAdvertAppInfo().i = new ko4();
        if (this.c.y() != null) {
            al8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        al8Var.getAdvertAppInfo().i.a = al8Var.k1();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            al8Var.getAdvertAppInfo().i.c = l.getId();
            al8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            al8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            al8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        al8Var.getAdvertAppInfo().i.g = al8Var.getAdvertAppInfo().g;
        al8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.P(), true, i)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<on> g(et7 et7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, et7Var)) == null) {
            al8 al8Var = null;
            if (et7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = et7Var.F().iterator();
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
            if (postData == null && et7Var.j() != null) {
                postData = et7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            yt7 yt7Var = new yt7();
            ThreadData O = et7Var.O();
            yt7Var.a = O;
            if (O != null && pi.isEmpty(O.getForum_name())) {
                yt7Var.a.setForum_name(et7Var.n());
            }
            this.e.add(yt7Var);
            st7 st7Var = new st7(et7Var.O(), et7Var.d());
            st7Var.b = true;
            this.e.add(st7Var);
            if (postData != null && postData.i0 != null && (et7Var.l() == null || !TextUtils.equals(et7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
                ht7 ht7Var = new ht7(postData.i0);
                ht7Var.b = this.b.K().m2();
                this.e.add(ht7Var);
            }
            List<al8> Z = et7Var.Z();
            int i = 0;
            int i2 = -1;
            if (!af7.e(Z) && (al8Var = (al8) af7.d(Z, 0)) != null) {
                i2 = al8Var.getPosition();
            }
            if (et7Var.f() != null) {
                dt7 dt7Var = new dt7();
                dt7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fbe));
                this.e.add(dt7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new tt7());
                } else {
                    int i3 = 1;
                    for (wo4 wo4Var : et7Var.f()) {
                        if (Z != null && i3 == i2) {
                            if (al8Var != null) {
                                e(al8Var);
                                af7.a(this.e, al8Var);
                                i++;
                                if (al8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < Z.size() && (al8Var = (al8) af7.d(Z, i)) != null) {
                                i2 = al8Var.getPosition();
                            }
                        }
                        af7.a(this.e, wo4Var);
                        i3++;
                        if (i3 == 4 && et7Var.C() != null) {
                            af7.a(this.e, et7Var.C());
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
            et7 et7Var = this.c;
            if (et7Var == null || et7Var.O() == null) {
                return -1;
            }
            return this.c.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            gf5.b(new c(this), new d(this, i));
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
            this.n = yb8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = yb8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment B = detailInfoFragment.B();
            this.f = new d18(B, B, PostData.J0);
            this.g = new b18(detailInfoFragment.getContext(), yt7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.B(), st7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.G(this.q);
            this.i = new xv7(detailInfoFragment.B(), dt7.c);
            vv7 vv7Var = new vv7(detailInfoFragment.B(), wo4.e);
            this.j = vv7Var;
            vv7Var.z(true);
            this.k = new nw7(detailInfoFragment.B());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), ht7.c);
            lx7 lx7Var = new lx7(detailInfoFragment.B(), tt7.a);
            this.m = lx7Var;
            lx7Var.x(this.p);
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
        d18 d18Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (d18Var = this.f) == null) {
            return;
        }
        d18Var.notifyDataSetChanged();
    }

    public void n(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, et7Var) == null) || et7Var == null) {
            return;
        }
        this.c = et7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(et7Var);
        this.j.y(et7Var);
        this.k.w(et7Var);
        this.d.setData(g(et7Var));
    }
}
