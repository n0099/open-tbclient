package com.repackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.forum.broadcast.adapter.FroumBroadMajorHistoryAdapter;
import com.baidu.tieba.im.forum.broadcast.data.ForumBroadcastMajorResidueData;
import com.baidu.tieba.im.forum.broadcast.view.ForumBroadcastMajorQuestionDialogView;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class v67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final s67 b;
    public View c;
    public NavigationBar d;
    public BdRecyclerView e;
    public PbListView f;
    public boolean g;
    public FroumBroadMajorHistoryAdapter h;
    public List<u67> i;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public h45 p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public BdListView.p t;
    public km4<u67> u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* loaded from: classes7.dex */
    public class a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public a(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e != null) {
                    this.a.e.stopScroll();
                }
                this.a.p();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements km4<u67> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public b(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.km4
        /* renamed from: b */
        public void c(View view2, u67 u67Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, u67Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.km4
        /* renamed from: d */
        public void a(View view2, u67 u67Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, u67Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || u67Var == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13875").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.a.n).param("tid", u67Var.j() != null ? u67Var.j().tid.longValue() : 0L));
            String str = "";
            if (view2.getId() == R.id.obfuscated_res_0x7f090a46) {
                if (fc5.a()) {
                    return;
                }
                if (this.a.r) {
                    this.a.q();
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.a.a.getPageActivity());
                String str2 = u67Var.b() + "";
                String str3 = this.a.o;
                String str4 = this.a.n;
                if (u67Var.j() != null) {
                    str = u67Var.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, u67Var.k(), u67Var.c(), u67Var.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (u67Var.j() != null && u67Var.j().is_deleted.intValue() != 1) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.a.a.getPageActivity());
                pbActivityConfig.createNormalCfg(u67Var.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            } else {
                BdTopToast bdTopToast = new BdTopToast(this.a.a.getPageActivity());
                bdTopToast.i(false);
                bdTopToast.h(this.a.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f064d));
                bdTopToast.j((ViewGroup) this.a.c.findViewById(R.id.obfuscated_res_0x7f090a65));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public c(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", this.a.n);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a.a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public d(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.t();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public e(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || fc5.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.a.a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(this.a.n, this.a.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public f(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                if (fc5.a()) {
                    return;
                }
                this.a.q();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public g(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.e != null) {
                    this.a.e.stopScroll();
                }
                if (this.a.f == null || this.a.b == null || !mi.z()) {
                    return;
                }
                this.a.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.a.f.B(null);
                if (this.a.g) {
                    this.a.f.N();
                    this.a.b.loadMore();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v67 a;

        public h(v67 v67Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v67Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && mi.A() && this.a.b != null) {
                this.a.k();
                this.a.b.refresh();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cr4 a;

        public i(v67 v67Var, cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v67Var, cr4Var};
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            cr4 cr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (cr4Var = this.a) == null) {
                return;
            }
            cr4Var.dismiss();
        }
    }

    public v67(TbPageContext<?> tbPageContext, s67 s67Var, View view2, String str, String str2, String str3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, s67Var, view2, str, str2, str3, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ArrayList();
        this.t = new a(this);
        this.u = new b(this);
        this.v = new d(this);
        this.w = new e(this);
        this.x = new f(this);
        this.y = new g(this);
        this.a = tbPageContext;
        this.b = s67Var;
        this.n = str;
        this.o = str2;
        l(view2, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (h45Var = this.p) == null) {
            return;
        }
        h45Var.dettachView(this.q);
        this.p = null;
    }

    public final void l(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, str) == null) {
            this.c = view2;
            this.d = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0914f9);
            this.q = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090a64);
            this.d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j = (ImageView) this.d.getCenterImgBox();
            LinearLayout linearLayout = (LinearLayout) this.d.getCenterImgBoxLayout();
            this.k = linearLayout;
            linearLayout.setGravity(16);
            int f2 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            int f3 = oi.f(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            SkinManager.setNavbarIconSrc(this.j, R.drawable.obfuscated_res_0x7f0805e3, R.drawable.obfuscated_res_0x7f0805e3);
            this.d.showBottomLine();
            this.m = this.d.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f11f5));
            this.j.setPadding(f2, f2, f2, f2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.leftMargin = f2;
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
            int i2 = f3 + f2 + f2;
            layoutParams2.width = i2;
            layoutParams2.height = i2;
            this.j.setLayoutParams(layoutParams2);
            this.j.setVisibility(0);
            this.j.setOnClickListener(this.v);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f0903f7);
            this.e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            this.e.setOverScrollMode(2);
            this.e.setOnSrollToBottomListener(this.t);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.a.getPageActivity());
            this.h = froumBroadMajorHistoryAdapter;
            froumBroadMajorHistoryAdapter.h(this.u);
            this.e.setAdapter(this.h);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.f = pbListView;
            pbListView.b();
            this.f.p(R.color.CAM_X0204);
            this.f.t(oi.f(this.a.getPageActivity(), R.dimen.tbds182));
            this.f.x();
            this.f.G(R.dimen.tbfontsize33);
            this.f.E(SkinManager.getColor(R.color.CAM_X0107));
            this.f.A(R.color.CAM_X0110);
            this.f.s();
            this.f.B(this.y);
            if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
                s();
                int g2 = x8.f().g();
                Activity e2 = x8.f().e(g2 - 2);
                Activity e3 = x8.f().e(g2 - 3);
                if (e2 == null || e3 == null || !"FlutterPageActivity".equals(e2.getClass().getSimpleName()) || !"ForumBroadCastMajorHistoryActivity".equals(e3.getClass().getSimpleName())) {
                    return;
                }
                e3.finish();
            }
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.d.onChangeSkinType(this.a, i2);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
            this.f.d(i2);
            this.h.notifyDataSetChanged();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.i = null;
            this.s = null;
        }
    }

    public void o(t67 t67Var) {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, t67Var) == null) || t67Var == null || t67Var.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(t67Var.b()) && StringUtils.isEmpty(this.n)) {
            u67 u67Var = t67Var.b().get(0);
            if (u67Var.e() != null) {
                this.n = u67Var.e().forum_id + "";
            }
        }
        this.g = t67Var.a();
        if (t67Var.c()) {
            if (!ListUtils.isEmpty(t67Var.b())) {
                this.i.clear();
                this.i.addAll(t67Var.b());
            }
        } else if (!ListUtils.isEmpty(t67Var.b())) {
            this.i.addAll(t67Var.b());
        }
        this.h.i(this.i);
        if (!t67Var.c() || (bdRecyclerView = this.e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.e.scrollToPosition(0);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f == null || this.b == null) {
            return;
        }
        if (mi.z()) {
            this.e.setNextPage(this.f);
            this.f.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f.B(null);
            if (this.g) {
                this.f.N();
                this.b.loadMore();
                return;
            }
            this.f.C(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f09e6));
            this.f.f();
            return;
        }
        this.e.setNextPage(null);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ScreenTopToast screenTopToast = this.s;
            if (screenTopToast == null || !screenTopToast.g()) {
                ScreenTopToast screenTopToast2 = new ScreenTopToast(this.a.getPageActivity());
                screenTopToast2.m(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0650));
                screenTopToast2.k(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0725));
                screenTopToast2.j(new c(this));
                this.s = screenTopToast2;
                screenTopToast2.n((ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f090a65));
            }
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            h45 h45Var = this.p;
            if (h45Var == null || !h45Var.isViewAttached()) {
                if (this.p == null) {
                    this.p = new h45(this.a.getPageActivity(), new h(this));
                }
                this.p.m(null);
                this.p.k(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
                this.p.attachView(this.q, false);
                this.p.p();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.c == null) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(this.a.getPageActivity());
        bdTopToast.i(true);
        bdTopToast.h(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f06c5));
        bdTopToast.j((ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f090a65));
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            cr4 cr4Var = new cr4(this.a.getPageActivity());
            cr4Var.setContentViewSize(2);
            cr4Var.setCanceledOnTouchOutside(false);
            ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.a.getPageActivity());
            forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, cr4Var));
            cr4Var.setContentView(forumBroadcastMajorQuestionDialogView);
            cr4Var.create(this.a).show();
        }
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, forumBroadcastMajorResidueData) == null) && this.l == null) {
            if (forumBroadcastMajorResidueData == null) {
                TextView addTextButton = this.d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f050c), this.w);
                this.l = addTextButton;
                SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.z() >= forumBroadcastMajorResidueData.y()) {
                this.r = true;
                TextView addTextButton2 = this.d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f050c), this.x);
                this.l = addTextButton2;
                SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.l.setAlpha(0.33f);
            } else {
                TextView addTextButton3 = this.d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f050c), this.w);
                this.l = addTextButton3;
                SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }
}
