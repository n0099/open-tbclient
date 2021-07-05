package d.a.s0.h2.k.e;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbFirstFloorViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.e1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<d.a.c.k.e.n> A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public String K;
    public PostData L;
    public View.OnClickListener M;
    public View.OnClickListener N;
    public TbRichTextView.x O;
    public View.OnClickListener P;
    public d.a.s0.h2.i.c Q;
    public View.OnLongClickListener R;
    public SortSwitchButton.f S;
    public final List<d.a.c.k.e.a> T;
    public final List<d.a.c.k.e.a> U;
    public Runnable V;
    public int W;
    public int X;
    public int Y;
    public b2 Z;

    /* renamed from: a  reason: collision with root package name */
    public PbFragment f60575a;
    public final CustomMessageListener a0;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f60576b;
    public CustomMessageListener b0;

    /* renamed from: c  reason: collision with root package name */
    public s f60577c;
    public final CustomMessageListener c0;

    /* renamed from: d  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f60578d;
    public final View.OnClickListener d0;

    /* renamed from: e  reason: collision with root package name */
    public PbFirstFloorEnterForumAdapter f60579e;
    public CustomMessageListener e0;

    /* renamed from: f  reason: collision with root package name */
    public PbFirstFloorItemAdapter f60580f;
    public List<d.a.c.k.e.a> f0;

    /* renamed from: g  reason: collision with root package name */
    public d.a.s0.h2.k.e.z0.a f60581g;

    /* renamed from: h  reason: collision with root package name */
    public n0 f60582h;

    /* renamed from: i  reason: collision with root package name */
    public n0 f60583i;
    public m j;
    public d.a.s0.h2.n.a k;
    public d.a.s0.a0.f0.a l;
    public d.a.c.k.e.a m;
    public d.a.c.k.e.a n;
    public d.a.c.k.e.a o;
    public d.a.c.k.e.a p;
    public k0 q;
    public l0 r;
    public j0 s;
    public PbReplyLoadMoreAdapter t;
    public ArrayList<d.a.s0.h2.k.c.a> u;
    public j v;
    public x w;
    public d.a.s0.h2.k.c.b x;
    public d.a.s0.h2.h.e y;
    public ArrayList<PostData> z;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60584a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60584a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof d.a.s0.h3.h0.n)) {
                return;
            }
            d.a.s0.h3.h0.n nVar = (d.a.s0.h3.h0.n) customResponsedMessage.getData();
            if (this.f60584a.Z == null || this.f60584a.Z.G2 != nVar) {
                return;
            }
            this.f60584a.Z.G2.m(true);
            this.f60584a.f60576b.setData(this.f60584a.A);
            this.f60584a.V();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60585a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60585a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof d.a.s0.h3.h0.d)) {
                AbsDelegateAdapterList a2 = ((d.a.s0.h3.h0.d) customResponsedMessage.getData()).a();
                Iterator<d.a.c.k.e.a<?, ?>> it = a2.iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof o) {
                        ((o) next).g0(this.f60585a.f60575a);
                        if (next instanceof d.a.s0.h2.k.c.a) {
                            this.f60585a.u.add((d.a.s0.h2.k.c.a) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a2);
                this.f60585a.U.clear();
                this.f60585a.U.addAll(arrayList);
                if (this.f60585a.f60576b != null) {
                    this.f60585a.f60576b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60586a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f60587e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f60587e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f60587e.f60586a.V();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60586a = iVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.ResponsedMessage] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public /* bridge */ /* synthetic */ void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            onMessage2((CustomResponsedMessage) customResponsedMessage);
        }

        /* renamed from: onMessage  reason: avoid collision after fix types in other method */
        public void onMessage2(CustomResponsedMessage customResponsedMessage) {
            List<DownloadData> data;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f60586a.y == null || d.a.c.a.j.c(this.f60586a.f60575a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
                return;
            }
            boolean z = false;
            Iterator<DownloadData> it = data.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getStatus() == 0) {
                    z = true;
                    break;
                }
            }
            if (z) {
                d.a.c.e.m.e.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f60588e;

        public d(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60588e = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60588e.f60575a == null || this.f60588e.y == null || this.f60588e.y.S() == null) {
                return;
            }
            this.f60588e.f60575a.P4().D0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f60589e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ i f60590f;

        public e(i iVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60590f = iVar;
            this.f60589e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f60590f.f60576b.setSelectionFromTop(this.f60590f.f60576b.getHeaderViewsCount() + this.f60589e.size(), 0 - this.f60590f.X);
                this.f60590f.H = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f60591a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i iVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60591a = iVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f60591a.f0)) {
                this.f60591a.n();
                i iVar = this.f60591a;
                iVar.a0(iVar.y, false);
            }
        }
    }

    public i(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new ArrayList<>();
        this.z = new ArrayList<>();
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = false;
        this.F = false;
        this.I = false;
        this.J = 0;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = new ArrayList();
        this.U = new ArrayList();
        this.W = -1;
        this.X = 0;
        this.Y = -1;
        this.a0 = new a(this, 2921523);
        this.b0 = new b(this, 2004015);
        this.c0 = new c(this, 2001118);
        this.d0 = new d(this);
        this.e0 = new f(this, 2016470);
        this.J = d.a.c.e.p.l.k(pbFragment.getPageContext().getPageActivity());
        this.f60575a = pbFragment;
        this.f60576b = bdTypeListView;
        I(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.c0);
        this.X = d.a.c.e.p.l.i(this.f60575a.getContext()) / 3;
    }

    public final int A(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, arrayList)) == null) {
            if (eVar == null || ListUtils.isEmpty(eVar.E()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(eVar.E(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    z = false;
                    i2 = 0;
                    break;
                }
                d.a.c.k.e.n nVar = arrayList.get(i2);
                if (nVar instanceof PostData) {
                    PostData postData = (PostData) nVar;
                    if (postData.A() == 1 && postData.O == 0) {
                        z = true;
                        break;
                    }
                }
                i2++;
            }
            if (z) {
                return i2 + 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            BdTypeListView bdTypeListView = this.f60576b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i2 = 0; i2 < this.f60576b.getData().size(); i2++) {
                d.a.c.k.e.n nVar = this.f60576b.getData().get(i2);
                if (nVar != null && nVar.getType() == d.a.s0.h2.h.o.l) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int C(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, eVar, arrayList, z)) == null) {
            if (eVar == null || eVar.E() == null || eVar.C() == null || eVar.E().size() == 0 || eVar.N() == null || arrayList == null || !eVar.C().C0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (eVar.E().get(0) == null || eVar.E().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (eVar.x() == null || eVar.x().a() != eVar.x().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, eVar, arrayList, z)) == null) {
            if (eVar == null || eVar.E() == null || eVar.D() == null || eVar.E().size() == 0 || eVar.N() == null || arrayList == null || !eVar.D().C0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (eVar.E().get(0) == null || eVar.E().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (eVar.x() == null || eVar.x().a() != eVar.x().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.z : (ArrayList) invokeV.objValue;
    }

    public final int F(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, eVar, arrayList, z)) == null) {
            if (eVar == null || ListUtils.isEmpty(eVar.E()) || arrayList == null || arrayList.size() <= 0) {
                return (eVar == null || !eVar.l0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (eVar.E().get(0) == null || eVar.E().get(0).A() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.W : invokeV.intValue;
    }

    public View H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            s sVar = this.f60577c;
            if (sVar == null || sVar.y0() == null) {
                return null;
            }
            if (this.f60577c.y0().s != null && this.f60577c.y0().s.isShown()) {
                return this.f60577c.y0().s;
            }
            return this.f60577c.y0().r;
        }
        return (View) invokeV.objValue;
    }

    public void I(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbFragment, bdTypeListView) == null) {
            s sVar = new s(pbFragment, PostData.t0);
            this.f60577c = sVar;
            sVar.J0(pbFragment);
            this.f60578d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, d.a.s0.h2.h.p.j);
            this.f60579e = new PbFirstFloorEnterForumAdapter(pbFragment.getContext(), d.a.s0.h2.h.g.l);
            this.f60580f = new PbFirstFloorItemAdapter(pbFragment.getContext(), d.a.s0.h2.h.h.f60151g);
            this.f60581g = new d.a.s0.h2.k.e.z0.a(pbFragment, d.a.s0.h2.h.a.f60122g);
            this.f60582h = new n0(pbFragment, d.a.s0.h2.h.o.l);
            this.f60583i = new n0(pbFragment, d.a.s0.h2.h.o.m);
            m mVar = new m(pbFragment, PostData.u0);
            this.j = mVar;
            mVar.Z0(pbFragment);
            this.m = d.a.s0.w2.w.p().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.g4);
            this.n = d.a.s0.w2.w.p().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.i4);
            this.o = d.a.s0.v0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.o4);
            this.p = d.a.s0.v0.b.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.p4);
            this.s = new j0(pbFragment, d.a.s0.h2.h.l.I0);
            this.q = new k0(pbFragment, i0.F0);
            this.r = new l0(pbFragment, e1.L0);
            this.t = new PbReplyLoadMoreAdapter(pbFragment, PostData.A0);
            this.k = new d.a.s0.h2.n.a(pbFragment, d.a.s0.h2.n.b.f60907e);
            this.l = new d.a.s0.a0.f0.a(pbFragment.getPageContext());
            this.v = new j(pbFragment, d.a.r0.r.q.q.P3);
            this.w = new x(pbFragment, pbFragment.getUniqueId());
            d.a.s0.h2.k.c.b bVar = new d.a.s0.h2.k.c.b(pbFragment, pbFragment.getUniqueId(), this.f60576b);
            this.x = bVar;
            this.T.addAll(bVar.a());
            this.T.add(this.f60577c);
            this.T.add(this.f60578d);
            this.T.add(this.f60579e);
            this.T.add(this.f60580f);
            this.T.add(this.f60581g);
            this.T.add(this.j);
            this.T.add(this.f60582h);
            this.T.add(this.f60583i);
            this.T.add(this.m);
            this.T.add(this.n);
            this.T.add(this.o);
            this.T.add(this.p);
            this.T.add(this.s);
            this.T.add(this.q);
            this.T.add(this.r);
            this.T.add(this.k);
            this.T.add(this.t);
            this.T.add(this.l);
            this.T.add(this.v);
            this.T.add(this.w);
            this.T.add(new PbPrivateTitleAdapter(pbFragment));
            this.b0.setPriority(1);
            this.b0.setSelfListener(true);
            pbFragment.registerListener(this.b0);
            pbFragment.registerListener(this.a0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new d.a.s0.h3.h0.d(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.T);
        }
    }

    public final void J(@NonNull d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) {
            this.f60577c.t(eVar);
            this.f60577c.setFromCDN(this.B);
            this.f60577c.n(this.J);
            this.f60577c.c(this.C);
            this.f60577c.e(this.N);
            this.f60577c.m(this.M);
            this.f60577c.p(this.O);
            this.f60577c.d(this.R);
            this.f60577c.G0(this.P);
            this.f60577c.I0(this.Q);
            this.f60580f.j0(this.P);
            this.j.t(eVar);
            this.j.setFromCDN(this.B);
            this.j.q(this.K);
            this.j.c(this.C);
            this.j.e(this.N);
            this.j.m(this.M);
            this.j.p(this.O);
            this.j.d(this.R);
            this.j.Y0(this.Q);
            this.f60578d.t0(this.N);
            this.t.j0(this.N);
            this.k.j0(this.d0);
            d.a.c.k.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof d.a.s0.w2.s)) {
                ((d.a.s0.w2.s) aVar).k(this.B);
            }
            Iterator<d.a.s0.h2.k.c.a> it = this.u.iterator();
            while (it.hasNext()) {
                d.a.s0.h2.k.c.a next = it.next();
                if (next != null) {
                    next.t(eVar);
                    next.setFromCDN(this.B);
                    next.q(this.K);
                    next.n(this.J);
                    next.c(this.C);
                    next.f(this.D);
                    next.s(this.I);
                    next.e(this.N);
                    next.m(this.M);
                    next.p(this.O);
                    next.d(this.R);
                }
            }
            this.f60582h.e(this.N);
            this.f60582h.l0(this.S);
            this.f60583i.e(this.N);
            this.f60582h.t(eVar);
            this.f60581g.t(eVar);
            this.f60583i.t(eVar);
            this.q.t(eVar);
            this.r.t(eVar);
            this.v.l0(eVar);
            this.v.k0(this.f60575a.n1);
            this.w.j0(eVar);
            this.x.f(eVar);
        }
    }

    public final d.a.c.k.e.n K(ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, arrayList, i2)) == null) {
            if (this.y == null) {
                return null;
            }
            d.a.s0.h3.h0.o Z = this.f60575a.y().Z();
            if (Z == null) {
                Z = this.y.y();
            }
            if (Z == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert F0 = Z.F0();
            if (F0 != null) {
                F0.setAdvertAppInfo(Z.getAdvertAppInfo());
            }
            int w4 = Z.getAdvertAppInfo().w4();
            if (w4 != 0) {
                d.a.s0.w2.i0.d.i(Z, w4);
                if (w4 != 28 && w4 != 31) {
                    Z.getAdvertAppInfo().N3 = -1001;
                }
                return null;
            }
            if (this.y.m() != null) {
                Z.E0 = this.y.m().getId();
            }
            if (this.y.N() != null) {
                Z.H0 = d.a.c.e.m.b.f(this.y.N().c0(), 0L);
            }
            d.a.s0.h2.h.e eVar = this.y;
            if (eVar != null && eVar.x() != null) {
                Z.I0 = this.y.x().a();
            }
            l(Z);
            if (i2 >= 0) {
                d.a.s0.n1.o.k.a.b(arrayList, Z, i2);
                return Z;
            }
            return null;
        }
        return (d.a.c.k.e.n) invokeLI.objValue;
    }

    public final boolean L(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{eVar, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(eVar.f()) && eVar.f().size() > 2) {
                int min = Math.min(eVar.f().size(), 7);
                for (int i6 = 0; i6 < min; i6++) {
                    d.a.r0.r.q.q qVar = eVar.f().get(i6);
                    if (!z2 && i6 == 0) {
                        qVar.w4(true);
                    }
                    if (qVar.l1() == null) {
                        if (i6 == min - 1) {
                            qVar.y4(true);
                        }
                    } else if (i6 == min - 2) {
                        qVar.y4(true);
                    } else if (i6 == min - 1) {
                        qVar.x4(true);
                    }
                    arrayList2.add(qVar);
                }
            }
            if (arrayList2.size() > 0) {
                int i7 = (!z || i2 < 0) ? z ? i3 + 2 : i3 >= 0 ? i3 + 1 : i4 >= 0 ? i4 : i5 >= 0 ? i5 : -1 : i2 + 1;
                if (i7 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i7, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final d.a.c.k.e.n M(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        d.a.s0.h2.h.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048588, this, eVar, arrayList, i2)) == null) {
            if (i2 < 0 || eVar == null || !eVar.k || (aVar = eVar.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i2, aVar);
            return aVar;
        }
        return (d.a.c.k.e.n) invokeLLI.objValue;
    }

    public final d.a.c.k.e.n N(ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, arrayList, i2)) == null) {
            if (d.a.r0.b.d.B() && i2 > 0) {
                String d2 = d.a.s0.v0.d.c.e().d("pb_banner");
                if (this.Z == null && d.a.s0.v0.a.h().k(d2)) {
                    b2 b2Var = new b2();
                    this.Z = b2Var;
                    b2Var.G2 = new d.a.s0.h3.h0.n();
                    d.a.s0.h2.h.e eVar = this.y;
                    if (eVar != null) {
                        this.Z.G2.j(eVar.n());
                        this.Z.G2.n(this.y.P());
                    }
                }
                b2 b2Var2 = this.Z;
                if (b2Var2 != null && b2Var2.G2 != null) {
                    ListUtils.add(arrayList, i2, b2Var2);
                }
            }
            return this.Z;
        }
        return (d.a.c.k.e.n) invokeLI.objValue;
    }

    public final d.a.c.k.e.n O(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        InterceptResult invokeLLI;
        d.a.s0.h2.h.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048590, this, eVar, arrayList, i2)) == null) {
            if (eVar.m() == null || StringUtils.isNull(eVar.m().getName())) {
                return null;
            }
            if (TextUtils.equals(eVar.m().getName(), this.f60575a.y().f0()) && this.f60575a.y().j0()) {
                return null;
            }
            if (!this.f60575a.isSimpleForum() && !ListUtils.isEmpty(eVar.q())) {
                gVar = new d.a.s0.h2.h.g(eVar.q().get(0));
            } else {
                gVar = new d.a.s0.h2.h.g(eVar.m());
            }
            gVar.k = this.f60575a.y().T0();
            ListUtils.add(arrayList, i2 + 1, gVar);
            return gVar;
        }
        return (d.a.c.k.e.n) invokeLLI.objValue;
    }

    public final d.a.c.k.e.n P(d.a.s0.h2.h.e eVar, PostData postData, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048591, this, eVar, postData, arrayList, i2)) == null) {
            d.a.s0.h2.h.h hVar = null;
            if (eVar.m() == null || StringUtils.isNull(eVar.m().getName()) || !TextUtils.equals(eVar.m().getName(), this.f60575a.y().f0()) || !this.f60575a.y().j0()) {
                if (postData != null) {
                    if (postData.p0 != null) {
                        hVar = new d.a.s0.h2.h.h(postData.p0);
                    }
                } else {
                    PostData postData2 = this.L;
                    if (postData2 != null && postData2.p0 != null) {
                        hVar = new d.a.s0.h2.h.h(this.L.p0);
                    }
                }
                if (hVar != null) {
                    hVar.f60153f = this.f60575a.y().T0();
                    ListUtils.add(arrayList, i2 + 1, hVar);
                }
                return hVar;
            }
            return null;
        }
        return (d.a.c.k.e.n) invokeLLLI.objValue;
    }

    public final y Q(ArrayList<d.a.c.k.e.n> arrayList, d.a.c.k.e.n nVar, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048592, this, arrayList, nVar, i2, i3)) == null) {
            y A = this.y.A();
            if (A != null) {
                if (nVar != null) {
                    if (i3 >= 0 || nVar.getType() == AdvertAppInfo.i4) {
                        i3 = nVar.getType() != AdvertAppInfo.i4 ? i3 + 1 : -1;
                    } else {
                        i3 = i2 + 2;
                    }
                }
                if (i3 <= 0 || !(A instanceof y)) {
                    return null;
                }
                ListUtils.add(arrayList, i3, A);
                return A;
            }
            return null;
        }
        return (y) invokeLLII.objValue;
    }

    public final void R(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048593, this, eVar, arrayList, i2) == null) {
            d.a.s0.h2.h.o oVar = new d.a.s0.h2.h.o(d.a.s0.h2.h.o.l);
            b2 N = eVar.N();
            if (N != null) {
                N.P0();
            }
            oVar.f60177h = this.f60575a.h5();
            oVar.f60176g = eVar.f60143g;
            eVar.c();
            oVar.f60178i = eVar.e0();
            oVar.k = eVar.f60142f;
            ListUtils.add(arrayList, i2, oVar);
            if (eVar.K() == 4) {
                ListUtils.add(arrayList, i2 + 1, new d.a.s0.h2.h.n());
            }
        }
    }

    public final d.a.c.k.e.n S(ArrayList<d.a.c.k.e.n> arrayList, int i2) {
        InterceptResult invokeLI;
        PbModel y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i2)) == null) {
            if (i2 < 0 || (y = this.f60575a.y()) == null || TextUtils.isEmpty(y.H0())) {
                return null;
            }
            d.a.s0.h3.h0.o oVar = new d.a.s0.h3.h0.o();
            l(oVar);
            ListUtils.add(arrayList, i2 + 1, oVar);
            return oVar;
        }
        return (d.a.c.k.e.n) invokeLI.objValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.W = B();
            if (this.f60576b.getAdapter2() instanceof d.a.c.k.e.e) {
                this.f60576b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            if (i2 == 1) {
                s sVar = this.f60577c;
                if (sVar != null) {
                    sVar.C0();
                }
                d.a.c.k.e.a aVar = this.n;
                if (aVar instanceof d.a.s0.w2.o) {
                    ((d.a.s0.w2.o) aVar).onPause();
                }
                d.a.c.k.e.a aVar2 = this.o;
                if (aVar2 instanceof d.a.s0.w2.o) {
                    ((d.a.s0.w2.o) aVar2).onPause();
                }
                n.a().j(this.f60575a.z());
            } else if (i2 == 2) {
                s sVar2 = this.f60577c;
                if (sVar2 != null) {
                    sVar2.E0();
                }
                d.a.c.k.e.a aVar3 = this.n;
                if (aVar3 instanceof d.a.s0.w2.o) {
                    ((d.a.s0.w2.o) aVar3).onResume();
                }
                d.a.c.k.e.a aVar4 = this.o;
                if (aVar4 instanceof d.a.s0.w2.o) {
                    ((d.a.s0.w2.o) aVar4).onResume();
                }
                Z(false);
            } else if (i2 != 3) {
            } else {
                s sVar3 = this.f60577c;
                if (sVar3 != null) {
                    sVar3.D0();
                }
                d.a.c.k.e.a aVar5 = this.n;
                if (aVar5 instanceof d.a.s0.w2.o) {
                    ((d.a.s0.w2.o) aVar5).onDestroy();
                }
                d.a.c.k.e.a aVar6 = this.o;
                if (aVar6 instanceof d.a.s0.w2.o) {
                    ((d.a.s0.w2.o) aVar6).onDestroy();
                }
                n.a().d();
            }
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.V);
            n0 n0Var = this.f60582h;
            if (n0Var != null) {
                n0Var.onDestroy();
            }
            n0 n0Var2 = this.f60583i;
            if (n0Var2 != null) {
                n0Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f60578d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            d.a.s0.h2.k.e.z0.a aVar = this.f60581g;
            if (aVar != null) {
                aVar.onDestroy();
            }
        }
    }

    public final void Y(boolean z, boolean z2, int i2, List<d.a.c.k.e.n> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), list}) == null) || z || z2) {
            return;
        }
        if ((!this.G && !this.F) || i2 == -1 || ListUtils.isEmpty(list) || this.H) {
            return;
        }
        this.V = new e(this, list);
        d.a.c.e.m.e.a().post(this.V);
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || this.f60575a.P4() == null || this.f60575a.z() == null || this.f60575a.z().getPbModel() == null) {
            return;
        }
        n.a().g(this.f60575a.z().getPbModel().c1(), this.f60582h.i0(), this.f60575a.P4().I0(), this.f60575a.z().getPageStayDurationItem(), z, this.x.b(), this.f60575a.getListView());
    }

    public void a0(d.a.s0.h2.h.e eVar, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        boolean z7;
        y yVar;
        int i3;
        List<d.a.c.k.e.n> list;
        int i4;
        boolean z8;
        boolean z9;
        d.a.c.k.e.n nVar;
        int i5;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, eVar, z) == null) || eVar == null) {
            return;
        }
        this.y = eVar;
        s0();
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        this.z.clear();
        d.a.s0.h2.h.e eVar2 = this.y;
        if (eVar2 != null && eVar2.E() != null && this.y.E().size() > 0) {
            this.z.addAll(this.y.E());
        }
        if (eVar.N() != null && eVar.N().H() != null) {
            this.K = eVar.N().H().getUserId();
        }
        if (this.f60577c == null) {
            return;
        }
        J(eVar);
        ArrayList<d.a.c.k.e.n> arrayList = new ArrayList<>(eVar.E());
        if (d.a.r0.c1.b.e.d()) {
            this.f60576b.setData(arrayList.subList(0, 1));
            this.f60577c.H0(false);
            return;
        }
        PostData p = p(arrayList);
        boolean z10 = p != null;
        if (p != null) {
            this.L = p;
        }
        if (this.D || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (eVar.l0() && p.K() != null) {
                p.t0(null);
            }
            z10 = true;
            z2 = true;
        }
        if (z10 || eVar.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = eVar.j();
            if (!this.D && eVar.l0() && j.K() != null) {
                j.t0(null);
            }
            postData = j;
            z10 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.f60575a.D4()) {
            if (eVar.E().size() > 0 && (postData2 = eVar.E().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.y, arrayList, this.D);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.y.C());
            }
        }
        int D = D(this.y, arrayList, this.D);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.y.D());
        }
        d.a.s0.h3.v.f(arrayList, 1);
        int A = A(eVar, arrayList);
        if (A >= 0) {
            R(eVar, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int u = u(eVar, arrayList);
        List<d.a.c.k.e.n> v = v(eVar);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(arrayList, u);
            if (nVar2 instanceof PostData) {
                ((PostData) nVar2).R = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z10 ? F(eVar, arrayList, this.D) : -1;
        if (F < 0 || eVar.R() == null) {
            if (postData != null) {
                postData.Q = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, eVar.R());
            z5 = true;
            z6 = true;
        }
        boolean z11 = P(eVar, postData, arrayList, F) != null;
        if (z11) {
            F++;
        }
        if (!z11 && O(eVar, arrayList, F) != null) {
            F++;
        }
        if (M(eVar, arrayList, F) != null) {
            F++;
        }
        if (z10) {
            d.a.c.k.e.n S = S(arrayList, F);
            boolean z12 = S != null;
            if (z12) {
                z9 = z12;
                nVar = S;
                i5 = -1;
            } else {
                i5 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                nVar = K(arrayList, i5);
                z9 = nVar != null;
            }
            boolean z13 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z13) {
                this.Y = i5;
                if (N(arrayList, i5) != null) {
                    this.Y = -1;
                    F++;
                }
            }
            if (d.a.r0.b.d.B() && z13) {
                i2 = F;
                z7 = z9;
                yVar = null;
            } else {
                y Q = Q(arrayList, nVar, F, i5);
                if (Q != null) {
                    if (!z9) {
                        i3 = i5;
                        yVar = Q;
                        i2 = F;
                        z7 = true;
                    } else if (i5 > 0) {
                        i5++;
                    } else {
                        F++;
                    }
                }
                yVar = Q;
                i2 = F;
                z7 = z9;
            }
            i3 = i5;
        } else {
            i2 = F;
            z7 = false;
            yVar = null;
            i3 = -1;
        }
        if (z10) {
            y yVar2 = yVar;
            list = v;
            i4 = u;
            boolean L = L(eVar, arrayList, z7, yVar != null, i3, i2, u, A);
            if (yVar2 != null) {
                yVar2.r = L;
            }
        } else {
            list = v;
            i4 = u;
        }
        this.f60577c.H0(!z5);
        boolean r0 = r0(postData);
        if (this.E && !r0) {
            arrayList.remove(postData);
            this.E = false;
        }
        if (eVar.R() != null) {
            eVar.R().j(!z6);
        }
        if (this.f60576b != null) {
            this.A = arrayList;
            List<d.a.c.k.e.n> Q2 = eVar.Q();
            if (!ListUtils.isEmpty(Q2)) {
                ArrayList arrayList2 = new ArrayList(arrayList.size() + Q2.size() + 2);
                arrayList2.addAll(arrayList);
                d.a.s0.h2.h.j jVar = new d.a.s0.h2.h.j();
                PbListView G0 = this.f60575a.P4().G0();
                if (G0 != null && G0.m()) {
                    jVar.f60157e = TbadkCoreApplication.getInst().getString(R.string.pb_no_replay);
                    jVar.f60158f = true;
                    z8 = false;
                } else {
                    jVar.f60157e = TbadkCoreApplication.getInst().getString(R.string.list_has_no_more);
                    z8 = false;
                    jVar.f60158f = false;
                }
                arrayList2.add(jVar);
                d.a.s0.a0.f0.e eVar3 = new d.a.s0.a0.f0.e();
                eVar3.f57090e = TbadkCoreApplication.getInst().getString(R.string.recommed_for_you);
                eVar3.needTopMargin = z8;
                arrayList2.add(eVar3);
                arrayList2.addAll(Q2);
                this.f60576b.setData(arrayList2);
            } else {
                this.f60576b.setData(this.A);
            }
        }
        Y(r0, z, i4, list);
        if (q(postData, arrayList, z3)) {
            this.f60576b.setData(arrayList);
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.B = z;
            this.f60577c.setFromCDN(z);
            d.a.c.k.e.a aVar = this.n;
            if (aVar != null && (aVar instanceof d.a.s0.w2.s)) {
                ((d.a.s0.w2.s) aVar).k(z);
            }
            Iterator<d.a.s0.h2.k.c.a> it = this.u.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void c0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.E = z;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.C = z;
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.I = z;
        }
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.F = z;
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.G = z;
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.D = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.H = z;
        }
    }

    public void j0(boolean z) {
        m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (mVar = this.j) == null) {
            return;
        }
        mVar.X0(z);
    }

    public void k0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, onClickListener) == null) {
            this.M = onClickListener;
        }
    }

    public final void l(d.a.s0.h3.h0.o oVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, oVar) == null) || oVar == null || this.y == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().U3 = new d.a.r0.r.q.e();
        if (this.y.x() != null) {
            oVar.getAdvertAppInfo().U3.f55918b = this.y.x().a();
        }
        oVar.getAdvertAppInfo().U3.f55917a = oVar.E0();
        if (this.y.m() != null && (m = this.y.m()) != null) {
            oVar.getAdvertAppInfo().U3.f55920d = m.getId();
            oVar.getAdvertAppInfo().U3.f55921e = m.getFirst_class();
            oVar.getAdvertAppInfo().U3.f55922f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().U3.f55923g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().U3.f55924h = oVar.getAdvertAppInfo().S3;
        oVar.getAdvertAppInfo().U3.f55925i = false;
    }

    public void l0(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, xVar) == null) {
            this.O = xVar;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.f60575a == null || n()) {
            return;
        }
        this.f60575a.registerListener(this.e0);
    }

    public void m0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onLongClickListener) == null) {
            this.R = onLongClickListener;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.f60575a == null) {
                return false;
            }
            this.f0 = new ArrayList();
            ArrayList<BdUniqueId> g2 = d.a.s0.h3.v.g();
            if (g2 == null || g2.size() <= 0) {
                return false;
            }
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.s0.n1.o.g.a b2 = d.a.s0.n1.r.b.d().b(this.f60575a.getPageContext(), g2.get(i2), 2);
                if (b2 != null) {
                    this.T.add(b2);
                    this.f0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.f0)) {
                return true;
            }
            this.f60576b.a(this.f0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, fVar) == null) {
            this.S = fVar;
        }
    }

    public final void o(List<d.a.c.k.e.n> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) instanceof PostData) {
                PostData postData = (PostData) list.get(i2);
                if (!TextUtils.isEmpty(postData.H())) {
                    d.a.r0.r.q.o0 o0Var = new d.a.r0.r.q.o0();
                    o0Var.e(postData.H());
                    list.set(i2, o0Var);
                }
            }
        }
    }

    public void o0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.N = onClickListener;
        }
    }

    public final PostData p(ArrayList<d.a.c.k.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, arrayList)) == null) {
            Iterator<d.a.c.k.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                d.a.c.k.e.n next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.A() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void p0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onClickListener) == null) {
            this.P = onClickListener;
        }
    }

    public final boolean q(PostData postData, ArrayList<d.a.c.k.e.n> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048623, this, postData, arrayList, z)) == null) {
            if (postData != null) {
                if (z) {
                    ListUtils.add(arrayList, 0, postData);
                    return true;
                }
                return false;
            }
            PostData postData2 = this.L;
            if (postData2 != null && !this.F) {
                ListUtils.add(arrayList, 0, postData2);
            } else {
                PostData postData3 = new PostData();
                postData3.i0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void q0(d.a.s0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, cVar) == null) {
            this.Q = cVar;
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.x.b() : (View) invokeV.objValue;
    }

    public final boolean r0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, postData)) == null) ? (this.f60575a.y() == null || postData == null || postData.E() == null || !postData.E().equals(this.f60575a.y().X0())) ? false : true : invokeL.booleanValue;
    }

    public ArrayList<d.a.c.k.e.n> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.A : (ArrayList) invokeV.objValue;
    }

    public final void s0() {
        d.a.s0.h2.h.e eVar;
        d.a.s0.h3.h0.o oVar;
        d.a.s0.h3.h0.o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (eVar = this.y) == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> E = eVar.E();
        ArrayList<d.a.s0.h3.h0.o> e2 = this.y.e();
        if (d.a.s0.n1.o.k.a.e(E) || d.a.s0.n1.o.k.a.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<d.a.s0.h3.h0.o> it = e2.iterator();
        while (it.hasNext()) {
            d.a.s0.h3.h0.o next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<d.a.s0.h3.h0.o> it2 = e2.iterator();
        while (it2.hasNext()) {
            d.a.s0.h3.h0.o next2 = it2.next();
            if (next2 != null) {
                next2.K0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<d.a.s0.h3.h0.o> it3 = e2.iterator();
        while (it3.hasNext()) {
            d.a.s0.h3.h0.o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int w4 = next3.getAdvertAppInfo().w4();
                if (w4 != 0) {
                    d.a.s0.w2.i0.d.i(next3, w4);
                    if (w4 != 28 && w4 != 31) {
                        next3.getAdvertAppInfo().N3 = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            d.a.s0.h3.h0.o oVar3 = (d.a.s0.h3.h0.o) sparseArray.valueAt(i2);
            if (oVar3 != null && (oVar2 = (d.a.s0.h3.h0.o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.s0.w2.i0.d.i(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (d.a.s0.h3.h0.o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            d.a.s0.n1.o.k.a.a(arrayList, Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < d.a.s0.n1.o.k.a.k(arrayList); i4++) {
            d.a.s0.h3.h0.o oVar4 = (d.a.s0.h3.h0.o) sparseArray.get(((Integer) d.a.s0.n1.o.k.a.d(arrayList, i4)).intValue());
            if (this.y.m() != null) {
                oVar4.E0 = this.y.m().getId();
            }
            if (this.y.N() != null) {
                oVar4.H0 = d.a.c.e.m.b.f(this.y.N().c0(), 0L);
            }
            d.a.s0.h2.h.e eVar2 = this.y;
            if (eVar2 != null && eVar2.x() != null) {
                oVar4.I0 = this.y.x().a();
            }
            l(oVar4);
            int position = oVar4.getPosition() + this.y.X;
            if (position >= d.a.s0.n1.o.k.a.k(E)) {
                oVar4.K0 = position;
                d.a.s0.w2.i0.d.j(oVar4, 2, position, d.a.s0.n1.o.k.a.k(E));
                return;
            }
            if (!this.D) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.s0.w2.i0.d.i(oVar4, 23);
            } else {
                d.a.s0.n1.o.k.a.b(E, oVar4, position);
                TiebaStatic.eventStat(this.f60575a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().d4);
            }
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            s sVar = this.f60577c;
            if (sVar == null || sVar.y0() == null) {
                return null;
            }
            return this.f60577c.y0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void t0() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (i2 = this.Y) <= 0 || N(this.A, i2) == null) {
            return;
        }
        this.Y = -1;
        this.f60576b.setData(this.A);
        V();
    }

    public final int u(d.a.s0.h2.h.e eVar, ArrayList<d.a.c.k.e.n> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048631, this, eVar, arrayList)) == null) {
            if (this.F || eVar == null || ListUtils.isEmpty(eVar.E()) || arrayList == null || arrayList.size() <= 0) {
                return (eVar != null && eVar.l0() && this.D) ? 0 : -1;
            } else if (this.f60575a.y() == null || !this.f60575a.y().n0()) {
                if (this.f60575a.P4() == null || !this.f60575a.P4().z0()) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z = false;
                            i2 = -1;
                            break;
                        }
                        d.a.c.k.e.n nVar = arrayList.get(i2);
                        if (nVar instanceof PostData) {
                            PostData postData = (PostData) nVar;
                            if (postData.A() == 1 && postData.O == 0) {
                                z = true;
                                break;
                            }
                        }
                        i2++;
                    }
                    return !z ? eVar.l0() ? 0 : -1 : i2 + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public final List<d.a.c.k.e.n> v(d.a.s0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, eVar)) == null) {
            if (eVar == null || eVar.S() == null || ListUtils.isEmpty(eVar.S().f60195a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = eVar.S().f60195a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i2 = 0; i2 < min; i2++) {
                PostData postData = list.get(i2);
                if (postData != null) {
                    postData.c0 = true;
                    postData.P = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(eVar.S().f60196b) > 2) {
                d.a.c.k.e.n nVar = (d.a.c.k.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar instanceof PostData) {
                    ((PostData) nVar).P = false;
                }
                arrayList.add(new d.a.s0.h2.n.b());
            } else {
                d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nVar2 instanceof PostData) {
                    ((PostData) nVar2).P = true;
                }
            }
            d.a.s0.h2.h.o oVar = new d.a.s0.h2.h.o(d.a.s0.h2.h.o.m);
            oVar.f60174e = eVar.S().f60197c;
            arrayList.add(0, oVar);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f60576b.getHeaderViewsCount() : invokeV.intValue;
    }

    public d.a.c.k.e.n x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) ? this.f60576b.G(i2) : (d.a.c.k.e.n) invokeI.objValue;
    }

    public BdUniqueId y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            if (this.f60576b.G(i2) != null) {
                return this.f60576b.G(i2).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f60578d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }
}
