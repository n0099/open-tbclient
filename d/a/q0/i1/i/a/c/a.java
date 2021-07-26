package d.a.q0.i1.i.a.c;

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
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.ScreenTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.util.StringUtils;
import d.a.d.e.p.j;
import d.a.p0.b1.l;
import d.a.q0.h3.h0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f59064a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q0.i1.i.a.a f59065b;

    /* renamed from: c  reason: collision with root package name */
    public View f59066c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f59067d;

    /* renamed from: e  reason: collision with root package name */
    public BdRecyclerView f59068e;

    /* renamed from: f  reason: collision with root package name */
    public PbListView f59069f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59070g;

    /* renamed from: h  reason: collision with root package name */
    public FroumBroadMajorHistoryAdapter f59071h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.q0.i1.i.a.b.b> f59072i;
    public ImageView j;
    public LinearLayout k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public d.a.p0.f0.h p;
    public RelativeLayout q;
    public boolean r;
    public ScreenTopToast s;
    public BdListView.p t;
    public d.a.p0.n.f<d.a.q0.i1.i.a.b.b> u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public View.OnClickListener x;
    public View.OnClickListener y;

    /* renamed from: d.a.q0.i1.i.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1468a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59073e;

        public C1468a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59073e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f59073e.f59068e != null) {
                    this.f59073e.f59068e.stopScroll();
                }
                this.f59073e.p();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.p0.n.f<d.a.q0.i1.i.a.b.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59074e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59074e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.n.f
        /* renamed from: b */
        public void c(View view, d.a.q0.i1.i.a.b.b bVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.n.f
        /* renamed from: d */
        public void a(View view, d.a.q0.i1.i.a.b.b bVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, bVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) || bVar == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13875").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.f59074e.n).param("tid", bVar.j() != null ? bVar.j().tid.longValue() : 0L));
            String str = "";
            if (view.getId() == R.id.forum_fail_edit) {
                if (l.a()) {
                    return;
                }
                if (this.f59074e.r) {
                    this.f59074e.q();
                    return;
                }
                ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f59074e.f59064a.getPageActivity());
                String str2 = bVar.b() + "";
                String str3 = this.f59074e.o;
                String str4 = this.f59074e.n;
                if (bVar.j() != null) {
                    str = bVar.j().tid + "";
                }
                forumBroadcastHelper.jumpFlutterEditRelease(str2, str3, str4, str, bVar.k(), bVar.c(), bVar.f(), ForumBroadcastHelper.VALUE_PARMARS_BCAST_FROM_EDIT, "2");
                forumBroadcastHelper.start();
            } else if (bVar.j() != null && bVar.j().is_deleted.intValue() != 1) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.f59074e.f59064a.getPageActivity());
                pbActivityConfig.createNormalCfg(bVar.j().tid + "", null, null);
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
            } else {
                BdTopToast bdTopToast = new BdTopToast(this.f59074e.f59064a.getPageActivity());
                bdTopToast.i(false);
                bdTopToast.h(this.f59074e.f59064a.getPageActivity().getString(R.string.forum_broadcast_major_history_pb_deleted));
                bdTopToast.j((ViewGroup) this.f59074e.f59066c.findViewById(R.id.forum_major_history));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59075e;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59075e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", this.f59075e.n);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.f59075e.f59064a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59076e;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59076e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13873").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.f59076e.t();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59077e;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59077e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || l.a()) {
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(this.f59077e.f59064a.getPageActivity());
            forumBroadcastHelper.jumpFlutterEditGenear(this.f59077e.n, this.f59077e.o, "2");
            forumBroadcastHelper.start();
            TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59078e;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59078e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem("c13874").param("uid", TbadkCoreApplication.getCurrentAccountId()));
                if (l.a()) {
                    return;
                }
                this.f59078e.q();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59079e;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59079e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f59079e.f59068e != null) {
                    this.f59079e.f59068e.stopScroll();
                }
                if (this.f59079e.f59069f == null || this.f59079e.f59065b == null || !j.z()) {
                    return;
                }
                this.f59079e.f59069f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.f59079e.f59069f.z(null);
                if (this.f59079e.f59070g) {
                    this.f59079e.f59069f.L();
                    this.f59079e.f59065b.loadMore();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59080e;

        public h(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59080e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && j.A() && this.f59080e.f59065b != null) {
                this.f59080e.k();
                this.f59080e.f59065b.refresh();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f59081e;

        public i(a aVar, d.a.p0.s.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59081e = aVar2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.p0.s.s.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f59081e) == null) {
                return;
            }
            aVar.dismiss();
        }
    }

    public a(TbPageContext<?> tbPageContext, d.a.q0.i1.i.a.a aVar, View view, String str, String str2, String str3, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, aVar, view, str, str2, str3, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59072i = new ArrayList();
        this.t = new C1468a(this);
        this.u = new b(this);
        this.v = new d(this);
        this.w = new e(this);
        this.x = new f(this);
        this.y = new g(this);
        this.f59064a = tbPageContext;
        this.f59065b = aVar;
        this.n = str;
        this.o = str2;
        l(view, str3);
        TiebaStatic.log(new StatisticItem("c13872").param("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    public void k() {
        d.a.p0.f0.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (hVar = this.p) == null) {
            return;
        }
        hVar.dettachView(this.q);
        this.p = null;
    }

    public final void l(View view, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, str) == null) {
            this.f59066c = view;
            this.f59067d = (NavigationBar) view.findViewById(R.id.navi_forum_major_history_title);
            this.q = (RelativeLayout) view.findViewById(R.id.forum_major_contain);
            this.f59067d.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j = (ImageView) this.f59067d.getCenterImgBox();
            LinearLayout linearLayout = (LinearLayout) this.f59067d.getCenterImgBoxLayout();
            this.k = linearLayout;
            linearLayout.setGravity(16);
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            ImageView imageView = this.j;
            int i2 = R.drawable.ic_icon_creation_question16_svg;
            SkinManager.setNavbarIconSrc(imageView, i2, i2);
            this.f59067d.showBottomLine();
            this.m = this.f59067d.setCenterTextTitle(this.f59064a.getResources().getString(R.string.subscribe_bar_title));
            this.j.setPadding(g2, g2, g2, g2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            layoutParams.leftMargin = g2;
            layoutParams.rightMargin = 0;
            this.m.setLayoutParams(layoutParams);
            int i3 = g3 + g2 + g2;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.j.setLayoutParams(layoutParams2);
            this.j.setVisibility(0);
            this.j.setOnClickListener(this.v);
            BdRecyclerView bdRecyclerView = (BdRecyclerView) view.findViewById(R.id.broadcast_history_recycler_view);
            this.f59068e = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.f59064a.getPageActivity()));
            this.f59068e.setOverScrollMode(2);
            this.f59068e.setOnSrollToBottomListener(this.t);
            SkinManager.setBackgroundColor(this.f59068e, R.color.CAM_X0204);
            FroumBroadMajorHistoryAdapter froumBroadMajorHistoryAdapter = new FroumBroadMajorHistoryAdapter(this.f59064a.getPageActivity());
            this.f59071h = froumBroadMajorHistoryAdapter;
            froumBroadMajorHistoryAdapter.h(this.u);
            this.f59068e.setAdapter(this.f59071h);
            PbListView pbListView = new PbListView(this.f59064a.getPageActivity());
            this.f59069f = pbListView;
            pbListView.b();
            this.f59069f.o(R.color.CAM_X0204);
            this.f59069f.r(d.a.d.e.p.l.g(this.f59064a.getPageActivity(), R.dimen.tbds182));
            this.f59069f.v();
            this.f59069f.E(R.dimen.tbfontsize33);
            this.f59069f.C(SkinManager.getColor(R.color.CAM_X0107));
            this.f59069f.y(R.color.CAM_X0110);
            this.f59069f.q();
            this.f59069f.z(this.y);
            if (ForumBroadcastHelper.VALUE_INTENT_BCAST_FROM_EDIT_SUCCESS.equals(str)) {
                s();
                int g4 = d.a.d.a.b.f().g();
                Activity e2 = d.a.d.a.b.f().e(g4 - 2);
                Activity e3 = d.a.d.a.b.f().e(g4 - 3);
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
            this.f59067d.onChangeSkinType(this.f59064a, i2);
            SkinManager.setBackgroundColor(this.f59068e, R.color.CAM_X0204);
            this.f59069f.d(i2);
            this.f59071h.notifyDataSetChanged();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f59072i = null;
            this.s = null;
        }
    }

    public void o(d.a.q0.i1.i.a.b.a aVar) {
        BdRecyclerView bdRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.b() == null) {
            return;
        }
        if (!ListUtils.isEmpty(aVar.b()) && StringUtils.isEmpty(this.n)) {
            d.a.q0.i1.i.a.b.b bVar = aVar.b().get(0);
            if (bVar.e() != null) {
                this.n = bVar.e().forum_id + "";
            }
        }
        this.f59070g = aVar.a();
        if (aVar.c()) {
            if (!ListUtils.isEmpty(aVar.b())) {
                this.f59072i.clear();
                this.f59072i.addAll(aVar.b());
            }
        } else if (!ListUtils.isEmpty(aVar.b())) {
            this.f59072i.addAll(aVar.b());
        }
        this.f59071h.i(this.f59072i);
        if (!aVar.c() || (bdRecyclerView = this.f59068e) == null || bdRecyclerView.getChildCount() <= 0) {
            return;
        }
        this.f59068e.scrollToPosition(0);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f59069f == null || this.f59065b == null) {
            return;
        }
        if (j.z()) {
            this.f59068e.setNextPage(this.f59069f);
            this.f59069f.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f59069f.z(null);
            if (this.f59070g) {
                this.f59069f.L();
                this.f59065b.loadMore();
                return;
            }
            this.f59069f.A(this.f59064a.getResources().getString(R.string.list_has_no_more));
            this.f59069f.f();
            return;
        }
        this.f59068e.setNextPage(null);
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ScreenTopToast screenTopToast = this.s;
            if (screenTopToast == null || !screenTopToast.g()) {
                ScreenTopToast screenTopToast2 = new ScreenTopToast(this.f59064a.getPageActivity());
                screenTopToast2.m(this.f59064a.getPageActivity().getString(R.string.forum_broadcast_major_residue_none_hint));
                screenTopToast2.k(this.f59064a.getPageActivity().getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast2.j(new c(this));
                this.s = screenTopToast2;
                screenTopToast2.n((ViewGroup) this.f59066c.findViewById(R.id.forum_major_history));
            }
        }
    }

    public void r(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, str, z) == null) {
            d.a.p0.f0.h hVar = this.p;
            if (hVar == null || !hVar.isViewAttached()) {
                if (this.p == null) {
                    this.p = new d.a.p0.f0.h(this.f59064a.getPageActivity(), new h(this));
                }
                this.p.l(null);
                this.p.j(this.f59064a.getResources().getDimensionPixelSize(R.dimen.ds272));
                this.p.attachView(this.q, false);
                this.p.o();
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f59066c == null) {
            return;
        }
        BdTopToast bdTopToast = new BdTopToast(this.f59064a.getPageActivity());
        bdTopToast.i(true);
        bdTopToast.h(this.f59064a.getPageActivity().getString(R.string.frs_forum_bcast_publish_success_tip));
        bdTopToast.j((ViewGroup) this.f59066c.findViewById(R.id.forum_major_history));
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f59064a.getPageActivity());
            aVar.setContentViewSize(2);
            aVar.setCanceledOnTouchOutside(false);
            ForumBroadcastMajorQuestionDialogView forumBroadcastMajorQuestionDialogView = new ForumBroadcastMajorQuestionDialogView(this.f59064a.getPageActivity());
            forumBroadcastMajorQuestionDialogView.setConfirmButtonListener(new i(this, aVar));
            aVar.setContentView(forumBroadcastMajorQuestionDialogView);
            aVar.create(this.f59064a).show();
        }
    }

    public void u(ForumBroadcastMajorResidueData forumBroadcastMajorResidueData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, forumBroadcastMajorResidueData) == null) && this.l == null) {
            if (forumBroadcastMajorResidueData == null) {
                TextView addTextButton = this.f59067d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f59064a.getString(R.string.dynamic_publish), this.w);
                this.l = addTextButton;
                SkinManager.setViewTextColorSelector(addTextButton, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            } else if (forumBroadcastMajorResidueData.x() >= forumBroadcastMajorResidueData.w()) {
                this.r = true;
                TextView addTextButton2 = this.f59067d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f59064a.getString(R.string.dynamic_publish), this.x);
                this.l = addTextButton2;
                SkinManager.setViewTextColorSelector(addTextButton2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
                this.l.setAlpha(0.33f);
            } else {
                TextView addTextButton3 = this.f59067d.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.f59064a.getString(R.string.dynamic_publish), this.w);
                this.l = addTextButton3;
                SkinManager.setViewTextColorSelector(addTextButton3, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
            }
        }
    }
}
