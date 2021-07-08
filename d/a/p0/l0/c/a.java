package d.a.p0.l0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.o0.r.q.o1;
import d.a.o0.r.q.p1;
import d.a.o0.r.q.q1;
import d.a.o0.r.q.x;
import d.a.o0.r.s.a;
import d.a.p0.h3.n0.f;
import d.a.p0.l0.h.b;
import d.a.p0.l0.m.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59518e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f59519f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.p0.l0.m.f f59520g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.l0.h.b f59521h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f59522i;
    public List<x> j;
    public boolean k;
    public d.a.p0.l0.d.c l;
    public d.a.p0.l0.m.b m;
    public HashSet<Long> n;
    public f.c o;

    /* renamed from: d.a.p0.l0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1516a implements f.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.l0.m.b f59523a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f59524b;

        public C1516a(a aVar, d.a.p0.l0.m.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59524b = aVar;
            this.f59523a = bVar;
        }

        @Override // d.a.p0.l0.m.f.j
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59524b.notifyDataSetChanged();
                this.f59523a.r0(this.f59524b.f59520g.s());
                this.f59523a.s0(this.f59524b.f59520g.t());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements b.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f59525a;

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
            this.f59525a = aVar;
        }

        @Override // d.a.p0.l0.h.b.d
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f59525a.f59522i.I(true, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59526e;

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
            this.f59526e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59526e.f59519f == null) {
                return;
            }
            this.f59526e.f59519f.dispatchMvcEvent(new d.a.o0.g0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59527e;

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
            this.f59527e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59527e.f59519f == null) {
                return;
            }
            this.f59527e.f59519f.dispatchMvcEvent(new d.a.o0.g0.c.b(6, null, null, null));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f59528e;

        /* renamed from: d.a.p0.l0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C1517a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f59529e;

            public C1517a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f59529e = eVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    d.a.p0.h3.n0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", this.f59529e.f59528e.o);
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public c(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

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
            this.f59528e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log("c13379");
                if (this.f59528e.f59522i.y()) {
                    if (this.f59528e.f59519f != null) {
                        this.f59528e.f59519f.dispatchMvcEvent(new d.a.o0.g0.c.b(14, null, null, null));
                        return;
                    }
                    return;
                }
                boolean z = false;
                ForumCreateInfoData b2 = this.f59528e.f59522i.A().b();
                if (b2 != null) {
                    int x = b2.x();
                    if (x == 220012) {
                        BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                        blockPopInfoData.block_info = k.isEmpty(b2.w()) ? this.f59528e.f59518e.getResources().getString(R.string.create_forum_block_tip) : b2.w();
                        blockPopInfoData.ahead_info = this.f59528e.f59518e.getResources().getString(R.string.create_forum_feed);
                        blockPopInfoData.ok_info = this.f59528e.f59518e.getResources().getString(R.string.know);
                        blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                        AntiHelper.s(this.f59528e.f59518e.getPageActivity(), blockPopInfoData);
                    } else if (x == 2121002) {
                        d.a.o0.s.h.a.b(this.f59528e.f59518e, null, this.f59528e.f59518e.getResources().getString(R.string.create_forum_register_mobile_tip), this.f59528e.f59518e.getResources().getString(R.string.to_binding), this.f59528e.f59518e.getResources().getString(R.string.think_more), new C1517a(this), new b(this)).show();
                    }
                    z = true;
                }
                if (z) {
                    return;
                }
                String string = this.f59528e.f59518e.getResources().getString(R.string.create_forum_err);
                if (b2 != null) {
                    string = k.isEmpty(b2.w()) ? this.f59528e.f59518e.getResources().getString(R.string.create_forum_err) : b2.w();
                }
                d.a.o0.s.h.a.b(this.f59528e.f59518e, null, string, this.f59528e.f59518e.getResources().getString(R.string.know), null, new c(this), null).show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // d.a.p0.h3.n0.f.c
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f59530a;

        /* renamed from: b  reason: collision with root package name */
        public View f59531b;

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
                }
            }
        }

        public /* synthetic */ g(a aVar, C1516a c1516a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f59532a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59533b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59534c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f59535d;

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
                }
            }
        }

        public /* synthetic */ h(a aVar, C1516a c1516a) {
            this(aVar);
        }
    }

    /* loaded from: classes8.dex */
    public class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f59536a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59537b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f59538c;

        public i(a aVar) {
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
                }
            }
        }

        public /* synthetic */ i(a aVar, C1516a c1516a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, d.a.p0.l0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewEventCenter, recentlyVisitedForumModel, enterForumModel, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new ArrayList();
        this.k = true;
        this.o = new f(this);
        this.f59518e = tbPageContext;
        this.f59519f = viewEventCenter;
        this.n = new HashSet<>();
        this.m = bVar;
        d.a.p0.l0.m.f fVar = new d.a.p0.l0.m.f(this.f59518e, recentlyVisitedForumModel, viewEventCenter);
        this.f59520g = fVar;
        fVar.E(new C1516a(this, bVar));
        this.f59522i = enterForumModel;
        d.a.p0.l0.h.b bVar2 = new d.a.p0.l0.h.b(this.f59518e.getPageActivity(), Integer.valueOf(d.a.o0.r.d0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f59520g);
        this.f59521h = bVar2;
        bVar2.u(new b(this));
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.p0.l0.m.f fVar = this.f59520g;
            if (fVar == null) {
                return false;
            }
            return fVar.k();
        }
        return invokeV.booleanValue;
    }

    public void g() {
        d.a.p0.l0.m.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (fVar = this.f59520g) == null) {
            return;
        }
        fVar.x();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            int size = this.j.size();
            if (size <= 0 || i2 >= size) {
                return null;
            }
            return this.j.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            List<x> list = this.j;
            if (list == null || (i2 < list.size() && i2 >= 0)) {
                return i2;
            }
            return -1L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (i2 >= this.j.size() || i2 < 0) {
                return 6;
            }
            return this.j.get(i2).c();
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        i iVar;
        d.a.p0.l0.m.c cVar;
        x xVar;
        g gVar;
        h hVar;
        d.a.p0.l0.n.a aVar;
        d.a.p0.l0.n.e eVar;
        d.a.p0.l0.n.f fVar;
        d.a.p0.l0.n.d dVar;
        d.a.p0.l0.n.b bVar;
        d.a.p0.l0.n.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i2, view, viewGroup)) == null) {
            switch (getItemViewType(i2)) {
                case 0:
                    if (view != null && (view.getTag() instanceof i)) {
                        iVar = (i) view.getTag();
                    } else {
                        view = this.f59518e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                        iVar = new i(this, null);
                        iVar.f59536a = (TextView) view.findViewById(R.id.title);
                        iVar.f59537b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                        iVar.f59538c = (RelativeLayout) view.findViewById(R.id.container);
                        view.setTag(iVar);
                    }
                    if (this.j.get(i2) instanceof d.a.p0.l0.d.e) {
                        d.a.p0.l0.d.e eVar2 = (d.a.p0.l0.d.e) this.j.get(i2);
                        this.f59521h.v(iVar.f59537b);
                        this.f59521h.r();
                        this.f59521h.q(TbadkCoreApplication.getInst().getSkinType());
                        if (eVar2 != null) {
                            iVar.f59536a.setText(eVar2.f59556h);
                            SkinManager.setViewTextColor(iVar.f59536a, R.color.CAM_X0105);
                            d.a.p0.l0.d.c cVar3 = this.l;
                            if (cVar3 != null && cVar3.f59543a) {
                                SkinManager.setBackgroundResource(iVar.f59538c, R.drawable.enter_forum_attenten_bar_ad_bg);
                            } else {
                                SkinManager.setBackgroundColor(iVar.f59538c, R.color.CAM_X0205);
                            }
                            TextView textView = iVar.f59537b;
                            if (textView != null) {
                                if (eVar2.f59557i) {
                                    textView.setVisibility(0);
                                } else {
                                    textView.setVisibility(8);
                                }
                                SkinManager.setBackgroundColor(iVar.f59537b, R.color.transparent);
                                return view;
                            }
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 1:
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.m.c)) {
                        cVar = (d.a.p0.l0.m.c) view.getTag();
                    } else {
                        view = this.f59518e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                        cVar = new d.a.p0.l0.m.c(this.f59518e, view, this.f59519f);
                        view.setTag(cVar);
                    }
                    if ((this.j.get(i2) instanceof x) && (xVar = this.j.get(i2)) != null) {
                        cVar.k(xVar);
                    }
                    cVar.m(this.l);
                    return view;
                case 2:
                    if (view != null && (view.getTag() instanceof g)) {
                        gVar = (g) view.getTag();
                    } else {
                        view = this.f59518e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                        gVar = new g(this, null);
                        gVar.f59530a = (TextView) view.findViewById(R.id.footer_text);
                        gVar.f59531b = view.findViewById(R.id.container);
                        view.setTag(gVar);
                    }
                    View view2 = gVar.f59531b;
                    if (view2 != null) {
                        view2.setOnClickListener(new c(this));
                    }
                    SkinManager.setViewTextColor(gVar.f59530a, R.color.CAM_X0304);
                    return view;
                case 3:
                    if (view != null && (view.getTag() instanceof h)) {
                        hVar = (h) view.getTag();
                    } else {
                        view = this.f59518e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                        hVar = new h(this, null);
                        hVar.f59532a = view.findViewById(R.id.root);
                        hVar.f59533b = (ImageView) view.findViewById(R.id.image);
                        hVar.f59534c = (TextView) view.findViewById(R.id.hint_text);
                        hVar.f59535d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                        d.a.o0.r.f0.n.a aVar2 = new d.a.o0.r.f0.n.a();
                        hVar.f59535d.setTextSize(R.dimen.tbds42);
                        hVar.f59535d.setConfig(aVar2);
                        view.setTag(hVar);
                    }
                    if (!TbadkCoreApplication.isLogin()) {
                        hVar.f59534c.setText(R.string.enter_forum_login_interest);
                        hVar.f59535d.setText(this.f59518e.getResources().getString(R.string.click_here_to_login_in));
                        hVar.f59535d.setTextHorizontalCenter(true);
                        SkinManager.setImageResource(hVar.f59533b, R.drawable.new_pic_emotion_09);
                    } else {
                        hVar.f59534c.setText(R.string.forum_waiting_for_your_attention);
                        hVar.f59535d.setText(this.f59518e.getResources().getString(R.string.click_here_to_explore_more_forum));
                        SkinManager.setImageResource(hVar.f59533b, R.drawable.new_pic_emotion_01);
                    }
                    SkinManager.setViewTextColor(hVar.f59534c, R.color.CAM_X0107);
                    SkinManager.setBackgroundColor(hVar.f59532a, R.color.CAM_X0205);
                    hVar.f59535d.k();
                    TBSpecificationBtn tBSpecificationBtn = hVar.f59535d;
                    if (tBSpecificationBtn != null) {
                        tBSpecificationBtn.setOnClickListener(new d(this));
                        return view;
                    }
                    return view;
                case 4:
                    View o = this.f59520g.o();
                    this.f59520g.z();
                    return o;
                case 5:
                    m();
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.n.a)) {
                        aVar = (d.a.p0.l0.n.a) view.getTag();
                    } else {
                        aVar = new d.a.p0.l0.n.a(this.f59518e);
                        view = aVar.b();
                        view.setTag(aVar);
                    }
                    aVar.a();
                    aVar.c(new e(this));
                    return view;
                case 6:
                default:
                    return view;
                case 7:
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.n.e)) {
                        eVar = (d.a.p0.l0.n.e) view.getTag();
                    } else {
                        eVar = new d.a.p0.l0.n.e(this.f59518e);
                        view = eVar.d();
                        view.setTag(eVar);
                    }
                    if (this.j.get(i2) instanceof q1) {
                        eVar.c((q1) this.j.get(i2));
                    }
                    if (this.f59522i.A() == null || this.f59522i.A().e() == null || this.f59522i.A().e().b() == null) {
                        return view;
                    }
                    eVar.e(this.f59522i.A().e().b().size() > 0);
                    return view;
                case 8:
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.n.f)) {
                        fVar = (d.a.p0.l0.n.f) view.getTag();
                    } else {
                        fVar = new d.a.p0.l0.n.f(this.f59518e);
                        view = fVar.k();
                        view.setTag(fVar);
                    }
                    if (this.j.get(i2) instanceof o1) {
                        o1 o1Var = (o1) this.j.get(i2);
                        fVar.g(o1Var);
                        if (this.m.K().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.n.contains(Long.valueOf(o1Var.h()))) {
                            StatisticItem statisticItem = new StatisticItem("c13642");
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("fid", o1Var.h());
                            statisticItem.param("obj_locate", 1);
                            if (this.f59522i.A() != null && this.f59522i.A().e() != null && this.f59522i.A().e().b() != null) {
                                boolean z = this.f59522i.A().e().b().size() > 0;
                                statisticItem.param("obj_type", z ? 3 : 1);
                                fVar.m(z);
                            }
                            TiebaStatic.log(statisticItem);
                            this.n.add(Long.valueOf(o1Var.h()));
                            return view;
                        }
                        return view;
                    }
                    return view;
                case 9:
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.n.d)) {
                        dVar = (d.a.p0.l0.n.d) view.getTag();
                    } else {
                        dVar = new d.a.p0.l0.n.d(this.f59518e);
                        view = dVar.c();
                        view.setTag(dVar);
                    }
                    if (this.j.get(i2) instanceof p1) {
                        dVar.b((p1) this.j.get(i2));
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c13641");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem2);
                    return view;
                case 10:
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.n.b)) {
                        bVar = (d.a.p0.l0.n.b) view.getTag();
                    } else {
                        bVar = new d.a.p0.l0.n.b(this.f59518e);
                        view = bVar.d();
                        view.setTag(bVar);
                    }
                    if (this.j.get(i2) instanceof d.a.p0.l0.d.a) {
                        bVar.c((d.a.p0.l0.d.a) this.j.get(i2));
                    }
                    if (this.f59522i.A() == null || this.f59522i.A().e() == null || this.f59522i.A().e().b() == null) {
                        return view;
                    }
                    bVar.e(this.f59522i.A().e().b().size() > 0);
                    return view;
                case 11:
                    if (view != null && (view.getTag() instanceof d.a.p0.l0.n.c)) {
                        cVar2 = (d.a.p0.l0.n.c) view.getTag();
                    } else {
                        cVar2 = new d.a.p0.l0.n.c(this.f59518e);
                        view = cVar2.b();
                        view.setTag(cVar2);
                    }
                    cVar2.a();
                    return view;
            }
        }
        return (View) invokeILL.objValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? x.f52812g.length : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = true;
            this.n.clear();
        }
    }

    public void i(int i2) {
        d.a.p0.l0.h.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bVar = this.f59521h) == null) {
            return;
        }
        bVar.t(i2);
    }

    public void j(d.a.p0.l0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            if (cVar != this.l) {
                this.l = cVar;
                boolean z = cVar.f59543a;
                boolean z2 = cVar.f59544b;
                int i2 = cVar.f59545c;
                notifyDataSetChanged();
            }
            d.a.p0.l0.m.f fVar = this.f59520g;
            if (fVar != null) {
                fVar.C(cVar);
            }
        }
    }

    public void k(List<x> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, list, z) == null) {
            d.a.p0.l0.h.b bVar = this.f59521h;
            if (bVar != null) {
                bVar.p();
            }
            this.j.clear();
            if (list != null) {
                this.j.addAll(list);
            }
            this.m.V(z);
        }
    }

    public void l(BdUniqueId bdUniqueId) {
        d.a.p0.l0.m.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, bdUniqueId) == null) || (fVar = this.f59520g) == null) {
            return;
        }
        fVar.F(bdUniqueId);
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.k) {
            TiebaStatic.log("c13378");
            this.k = false;
        }
    }
}
