package com.repackage;

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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class uv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uu7 A;
    public et7 B;
    public ArrayList<PostData> C;
    public ArrayList<on> D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public String O;
    public PostData P;
    public PostData Q;
    public View.OnClickListener R;
    public View.OnClickListener S;
    public View.OnClickListener T;
    public TbRichTextView.y U;
    public View.OnClickListener V;
    public gu7 W;
    public View.OnLongClickListener X;
    public SortSwitchButton.f Y;
    public final List<bn> Z;
    public PbFragment a;
    public final List<bn> a0;
    public BdTypeListView b;
    public Runnable b0;
    public ew7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public int d0;
    public PbFirstFloorEnterForumAdapter e;
    public int e0;
    public PbFirstFloorItemAdapter f;
    public ThreadData f0;
    public ux7 g;
    public List<PostData> g0;
    public cx7 h;
    public final CustomMessageListener h0;
    public rw7 i;
    public CustomMessageListener i0;
    public cx7 j;
    public final CustomMessageListener j0;
    public yv7 k;
    public final View.OnClickListener k0;
    public gx7 l;
    public CustomMessageListener l0;
    public i08 m;
    public List<bn> m0;
    public v06 n;
    public bn o;
    public bn p;
    public bn q;
    public bn r;
    public bn s;
    public zw7 t;
    public ax7 u;
    public yw7 v;
    public PbReplyLoadMoreAdapter w;
    public ArrayList<tu7> x;
    public vv7 y;
    public lw7 z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(uv7 uv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof zk8)) {
                return;
            }
            zk8 zk8Var = (zk8) customResponsedMessage.getData();
            if (this.a.f0 == null || this.a.f0.funAdData != zk8Var) {
                return;
            }
            this.a.f0.funAdData.p(true);
            this.a.b.setData(this.a.D);
            this.a.a0();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(uv7 uv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof qk8)) {
                AbsDelegateAdapterList a = ((qk8) customResponsedMessage.getData()).a();
                Iterator<bn<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    bn<?, ?> next = it.next();
                    if (next instanceof aw7) {
                        ((aw7) next).t(this.a.a);
                        if (next instanceof tu7) {
                            this.a.x.add((tu7) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.a0.clear();
                this.a.a0.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.a0();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(uv7 uv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.B == null || h9.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                rg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        public d(uv7 uv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.B == null || this.a.B.T() == null) {
                return;
            }
            this.a.a.S5().T0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ uv7 b;

        public e(uv7 uv7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = uv7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.d0);
                this.b.L = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uv7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(uv7 uv7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uv7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.m0)) {
                this.a.n();
                uv7 uv7Var = this.a;
                uv7Var.i0(uv7Var.B, false);
            }
        }
    }

    public uv7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new ArrayList<>();
        this.C = new ArrayList<>();
        this.E = false;
        this.F = false;
        this.G = true;
        this.H = true;
        this.I = false;
        this.J = false;
        this.M = false;
        this.N = 0;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = new ArrayList();
        this.a0 = new ArrayList();
        this.c0 = -1;
        this.d0 = 0;
        this.e0 = -1;
        this.g0 = new ArrayList();
        this.h0 = new a(this, 2921523);
        this.i0 = new b(this, 2004015);
        this.j0 = new c(this, 2001118);
        this.k0 = new d(this);
        this.l0 = new f(this, 2016470);
        this.N = qi.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.j0);
        this.d0 = qi.i(this.a.getContext()) / 3;
    }

    public final int A(et7 et7Var, ArrayList<on> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, et7Var, arrayList)) == null) {
            if (et7Var == null || ListUtils.isEmpty(et7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(et7Var.F(), 0)) == null) {
                return 0;
            }
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = false;
                    i = 0;
                    break;
                }
                on onVar = arrayList.get(i);
                if (onVar instanceof PostData) {
                    PostData postData = (PostData) onVar;
                    if (postData.B() == 1 && postData.M == 0) {
                        z = true;
                        break;
                    }
                }
                i++;
            }
            if (z) {
                return i + 1;
            }
            return 0;
        }
        return invokeLL.intValue;
    }

    public void A0(gu7 gu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gu7Var) == null) {
            this.W = gu7Var;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i = 0; i < this.b.getData().size(); i++) {
                on onVar = this.b.getData().get(i);
                if (onVar != null && onVar.getType() == rt7.i) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0() {
        rw7 rw7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (rw7Var = this.i) == null) {
            return;
        }
        rw7Var.x(2);
    }

    public int C(et7 et7Var, ArrayList<on> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, et7Var, arrayList, z)) == null) {
            if (et7Var == null || et7Var.F() == null || et7Var.D() == null || et7Var.F().size() == 0 || et7Var.O() == null || arrayList == null || !et7Var.D().i1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (et7Var.F().get(0) == null || et7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (et7Var.y() == null || et7Var.y().a() != et7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final boolean C0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, postData)) == null) ? (this.a.K() == null || postData == null || postData.K() == null || !postData.K().equals(this.a.K().s2())) ? false : true : invokeL.booleanValue;
    }

    public int D(et7 et7Var, ArrayList<on> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, et7Var, arrayList, z)) == null) {
            if (et7Var == null || et7Var.F() == null || et7Var.E() == null || et7Var.F().size() == 0 || et7Var.O() == null || arrayList == null || !et7Var.E().i1()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (et7Var.F().get(0) == null || et7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (et7Var.y() == null || et7Var.y().a() != et7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public final void D0() {
        et7 et7Var;
        al8 al8Var;
        al8 al8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (et7Var = this.B) == null || et7Var.b0 || et7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = et7Var.F();
        ArrayList<al8> e2 = this.B.e();
        if (af7.e(F) || af7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<al8> it = e2.iterator();
        while (it.hasNext()) {
            al8 next = it.next();
            if (next != null && next.j1() != null) {
                sb.append(next.j1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<al8> it2 = e2.iterator();
        while (it2.hasNext()) {
            al8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<al8> it3 = e2.iterator();
        while (it3.hasNext()) {
            al8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ld8.j(next3, n);
                    if (n != 28 && n != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            al8 al8Var3 = (al8) sparseArray.valueAt(i);
            if (al8Var3 != null && (al8Var2 = (al8) hashMap.put(al8Var3.i1(), al8Var3)) != null) {
                ld8.j(al8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (al8Var = (al8) entry.getValue()) != null) {
                sparseArray.put(al8Var.getPosition(), al8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            af7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        int i3 = 1;
        for (int i4 = 0; i4 < af7.i(arrayList); i4++) {
            al8 al8Var4 = (al8) sparseArray.get(((Integer) af7.d(arrayList, i4)).intValue());
            if (this.B.l() != null) {
                al8Var4.V0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                al8Var4.Y0 = og.g(this.B.O().getId(), 0L);
            }
            et7 et7Var2 = this.B;
            if (et7Var2 != null && et7Var2.y() != null) {
                al8Var4.Z0 = this.B.y().a();
            }
            l(al8Var4);
            int position = al8Var4.getPosition() + this.B.a0;
            if (position >= af7.i(F)) {
                al8Var4.b1 = position;
                ld8.k(al8Var4, 2, position, af7.i(F));
                return;
            }
            if (!this.H) {
                position--;
                al8Var4.b1 = position;
            }
            if (position < 0) {
                ld8.j(al8Var4, 23);
            } else {
                al8Var4.c1 = i3;
                af7.b(F, al8Var4, position);
                i3++;
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", al8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void E0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (i = this.e0) <= 0 || Q(this.D, i) == null) {
            return;
        }
        this.e0 = -1;
        this.b.setData(this.D);
        a0();
    }

    public final int F(et7 et7Var, ArrayList<on> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, et7Var, arrayList, z)) == null) {
            if (et7Var == null || ListUtils.isEmpty(et7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (et7Var == null || !et7Var.u0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (et7Var.F().get(0) == null || et7Var.F().get(0).B() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(et7 et7Var, ArrayList<on> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, et7Var, arrayList)) == null) {
            int i = -1;
            if (et7Var == null || et7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = et7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.F) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof rt7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return et7Var.L() == 4 ? i + 1 : i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c0 : invokeV.intValue;
    }

    public final ArrayList<on> I(List<on> list, List<on> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, list, list2)) == null) {
            ArrayList<on> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            kt7 kt7Var = new kt7();
            PbListView X0 = this.a.S5().X0();
            if (X0 != null && X0.n()) {
                kt7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ddf);
                kt7Var.b = true;
            } else {
                kt7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e9);
                kt7Var.b = false;
            }
            arrayList.add(kt7Var);
            y06 y06Var = new y06();
            y06Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f91);
            y06Var.needTopMargin = false;
            arrayList.add(y06Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ew7 ew7Var = this.c;
            if (ew7Var == null || ew7Var.J() == null) {
                return null;
            }
            if (this.c.J().w != null && this.c.J().w.isShown()) {
                return this.c.J().w;
            }
            return this.c.J().v;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<on> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = ox4.i();
        int j = ox4.j() - 1;
        if (bool.booleanValue()) {
            on onVar = arrayList.get(0);
            if ((onVar instanceof PostData) && ((PostData) onVar).B() == 1) {
                j++;
            }
        }
        int k = ox4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.K() != null && this.a.K().c2() == 3) {
            this.g0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, pbFragment, bdTypeListView) == null) {
            ew7 ew7Var = new ew7(pbFragment, PostData.J0);
            this.c = ew7Var;
            ew7Var.W(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, st7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, gt7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), ht7.c);
            this.g = new ux7(pbFragment, zs7.c);
            this.h = new cx7(pbFragment, rt7.i);
            this.i = new rw7(pbFragment, mt7.c);
            this.j = new cx7(pbFragment, rt7.j);
            yv7 yv7Var = new yv7(pbFragment, PostData.K0);
            this.k = yv7Var;
            yv7Var.w0(pbFragment);
            gx7 gx7Var = new gx7(pbFragment, PostData.L0);
            this.l = gx7Var;
            gx7Var.s0(pbFragment);
            this.o = yb8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.p = yb8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.q = ss6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.r = ss6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.s = ss6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.v = new yw7(pbFragment, ot7.Z0);
            this.t = new zw7(pbFragment, xw7.W0);
            this.u = new ax7(pbFragment, kq4.c1);
            this.w = new PbReplyLoadMoreAdapter(pbFragment, PostData.R0);
            this.m = new i08(pbFragment, j08.a);
            this.n = new v06(pbFragment.getPageContext());
            this.y = new vv7(pbFragment, wo4.e);
            this.z = new lw7(pbFragment, pbFragment.getUniqueId());
            uu7 uu7Var = new uu7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.A = uu7Var;
            this.Z.addAll(uu7Var.a());
            this.Z.add(this.c);
            this.Z.add(this.d);
            this.Z.add(this.e);
            this.Z.add(this.f);
            this.Z.add(this.g);
            this.Z.add(this.k);
            this.Z.add(this.l);
            this.Z.add(this.h);
            this.Z.add(this.i);
            this.Z.add(this.j);
            this.Z.add(this.o);
            this.Z.add(this.p);
            this.Z.add(this.q);
            this.Z.add(this.r);
            this.Z.add(this.s);
            this.Z.add(this.v);
            this.Z.add(this.t);
            this.Z.add(this.u);
            this.Z.add(this.m);
            this.Z.add(this.w);
            this.Z.add(this.n);
            this.Z.add(this.y);
            this.Z.add(this.z);
            this.Z.add(new PbPrivateTitleAdapter(pbFragment));
            this.i0.setPriority(1);
            this.i0.setSelfListener(true);
            pbFragment.registerListener(this.i0);
            pbFragment.registerListener(this.h0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new qk8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.Z);
        }
    }

    public final void M(@NonNull et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, et7Var) == null) {
            this.c.r(et7Var);
            this.c.setFromCDN(this.E);
            this.c.l(this.N);
            this.c.c(this.G);
            this.c.e(this.S);
            this.c.k(this.R);
            this.c.n(this.U);
            this.c.d(this.X);
            this.c.T(this.V);
            this.c.V(this.W);
            this.f.w(this.V);
            this.k.r(et7Var);
            this.k.setFromCDN(this.E);
            this.k.o(this.O);
            this.k.c(this.G);
            this.k.e(this.S);
            this.k.k(this.R);
            this.k.n(this.U);
            this.k.d(this.X);
            this.k.v0(this.W);
            this.l.r(et7Var);
            this.l.setFromCDN(this.E);
            this.l.o(this.O);
            this.l.c(this.G);
            this.l.e(this.S);
            this.l.k(this.R);
            this.l.n(this.U);
            this.l.d(this.X);
            this.l.r0(this.W);
            this.d.G(this.S);
            this.w.w(this.S);
            this.m.w(this.k0);
            bn bnVar = this.p;
            if (bnVar != null && (bnVar instanceof ub8)) {
                ((ub8) bnVar).setIsFromCDN(this.E);
            }
            Iterator<tu7> it = this.x.iterator();
            while (it.hasNext()) {
                tu7 next = it.next();
                if (next != null) {
                    next.r(et7Var);
                    next.setFromCDN(this.E);
                    next.o(this.O);
                    next.l(this.N);
                    next.c(this.G);
                    next.f(this.H);
                    next.q(this.M);
                    next.e(this.S);
                    next.k(this.R);
                    next.n(this.U);
                    next.d(this.X);
                }
            }
            this.h.e(this.S);
            this.h.z(this.Y);
            this.i.e(this.T);
            this.j.e(this.S);
            this.h.r(et7Var);
            this.g.r(et7Var);
            this.j.r(et7Var);
            this.t.r(et7Var);
            this.u.r(et7Var);
            this.y.y(et7Var);
            this.y.x(this.a.u1);
            this.z.w(et7Var);
            this.A.f(et7Var);
        }
    }

    public final on N(ArrayList<on> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (this.B == null) {
                return null;
            }
            al8 l1 = this.a.K().l1();
            if (l1 == null) {
                l1 = this.B.z();
            }
            if (l1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert l12 = l1.l1();
            if (l12 != null) {
                l12.setAdvertAppInfo(l1.getAdvertAppInfo());
            }
            int n = l1.getAdvertAppInfo().n();
            if (n != 0) {
                ld8.j(l1, n);
                if (n != 28 && n != 31) {
                    l1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.B.l() != null) {
                l1.V0 = this.B.l().getId();
            }
            if (this.B.O() != null) {
                l1.Y0 = og.g(this.B.O().getId(), 0L);
            }
            et7 et7Var = this.B;
            if (et7Var != null && et7Var.y() != null) {
                l1.Z0 = this.B.y().a();
            }
            l(l1);
            if (i >= 0) {
                l1.c1 = 1;
                xl5.k().q(true);
                af7.b(arrayList, l1, i);
                return l1;
            }
            return null;
        }
        return (on) invokeLI.objValue;
    }

    public final boolean O(et7 et7Var, ArrayList<on> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{et7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(et7Var.f()) && et7Var.f().size() > 2) {
                int min = Math.min(et7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    wo4 wo4Var = et7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        wo4Var.n(true);
                    }
                    if (wo4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            wo4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        wo4Var.s(true);
                    } else if (i5 == min - 1) {
                        wo4Var.r(true);
                    }
                    arrayList2.add(wo4Var);
                }
            }
            if (arrayList2.size() > 0) {
                int i6 = (!z || i < 0) ? z ? i2 + 2 : i2 >= 0 ? i2 + 1 : i3 >= 0 ? i3 : i4 >= 0 ? i4 : -1 : i + 1;
                if (i6 >= 0 && arrayList2.size() > 1) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ListUtils.add(arrayList, i6, arrayList2.get(size));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final on P(et7 et7Var, ArrayList<on> arrayList, int i) {
        InterceptResult invokeLLI;
        zs7 zs7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, et7Var, arrayList, i)) == null) {
            if (i < 0 || et7Var == null || !et7Var.k || (zs7Var = et7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, zs7Var);
            return zs7Var;
        }
        return (on) invokeLLI.objValue;
    }

    public final on Q(ArrayList<on> arrayList, int i) {
        InterceptResult invokeLI;
        et7 et7Var;
        zk8 zk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (et7Var = this.B) != null && et7Var.q0()) {
                String d2 = xs6.e().d("pb_banner");
                if (this.f0 == null && rs6.m().v(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.f0 = threadData;
                    threadData.funAdData = new zk8();
                    et7 et7Var2 = this.B;
                    if (et7Var2 != null) {
                        this.f0.funAdData.m(et7Var2.m());
                        this.f0.funAdData.r(this.B.Q());
                    }
                }
                ThreadData threadData2 = this.f0;
                if (threadData2 != null && (zk8Var = threadData2.funAdData) != null) {
                    zk8Var.j(1);
                    xl5.k().q(true);
                    ListUtils.add(arrayList, i, this.f0);
                }
            }
            return this.f0;
        }
        return (on) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<on> listIterator = arrayList.listIterator();
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                if (i5 >= i3) {
                    break;
                }
                if (i5 < this.g0.size()) {
                    listIterator.add(this.g0.get(i5));
                } else {
                    PostData postData = new PostData();
                    zk8 zk8Var = new zk8();
                    et7 et7Var = this.B;
                    zk8Var.m(et7Var != null ? et7Var.m() : "");
                    et7 et7Var2 = this.B;
                    zk8Var.r(et7Var2 != null ? et7Var2.Q() : "");
                    zk8Var.n(true);
                    postData.t0 = zk8Var;
                    zk8Var.j(i6);
                    listIterator.add(postData);
                    i6++;
                    this.g0.add(postData);
                }
                i5++;
            }
            listIterator.next();
            i4++;
        }
        if (i4 != i || i5 >= i3) {
            return;
        }
        PostData postData2 = new PostData();
        zk8 zk8Var2 = new zk8();
        et7 et7Var3 = this.B;
        zk8Var2.m(et7Var3 != null ? et7Var3.m() : "");
        et7 et7Var4 = this.B;
        zk8Var2.r(et7Var4 != null ? et7Var4.Q() : "");
        zk8Var2.n(true);
        postData2.t0 = zk8Var2;
        zk8Var2.j(1);
        listIterator.add(postData2);
        this.g0.add(postData2);
    }

    public final on S(et7 et7Var, ArrayList<on> arrayList, int i) {
        InterceptResult invokeLLI;
        gt7 gt7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048599, this, et7Var, arrayList, i)) == null) {
            if (et7Var.l() == null || StringUtils.isNull(et7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(et7Var.l().getName(), this.a.K().r1()) && this.a.K().x1()) {
                return null;
            }
            if (!this.a.u0() && !ListUtils.isEmpty(et7Var.p())) {
                gt7Var = new gt7(et7Var.p().get(0));
            } else {
                gt7Var = new gt7(et7Var.l());
            }
            gt7Var.g = this.a.K().m2();
            ListUtils.add(arrayList, i + 1, gt7Var);
            return gt7Var;
        }
        return (on) invokeLLI.objValue;
    }

    public final on T(et7 et7Var, PostData postData, ArrayList<on> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048600, this, et7Var, postData, arrayList, i)) == null) {
            ht7 ht7Var = null;
            if (et7Var.l() == null || StringUtils.isNull(et7Var.l().getName()) || !TextUtils.equals(et7Var.l().getName(), this.a.K().r1()) || !this.a.K().x1()) {
                if (postData != null) {
                    if (postData.i0 != null) {
                        ht7Var = new ht7(postData.i0);
                    }
                } else {
                    PostData postData2 = this.P;
                    if (postData2 != null && postData2.i0 != null) {
                        ht7Var = new ht7(this.P.i0);
                    }
                }
                if (ht7Var != null) {
                    ht7Var.b = this.a.K().m2();
                    ListUtils.add(arrayList, i + 1, ht7Var);
                }
                return ht7Var;
            }
            return null;
        }
        return (on) invokeLLLI.objValue;
    }

    public final mw7 U(ArrayList<on> arrayList, on onVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048601, this, arrayList, onVar, i, i2)) == null) {
            mw7 B = this.B.B();
            if (B != null) {
                if (onVar != null) {
                    if (i2 >= 0 || onVar.getType() == AdvertAppInfo.z) {
                        i2 = onVar.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof mw7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (mw7) invokeLLII.objValue;
    }

    public final void V(et7 et7Var, ArrayList<on> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048602, this, et7Var, arrayList, i) == null) {
            rt7 rt7Var = new rt7(rt7.i);
            ThreadData O = et7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            rt7Var.d = this.a.o6();
            rt7Var.c = et7Var.g;
            et7Var.c();
            rt7Var.e = et7Var.i0();
            rt7Var.g = et7Var.f;
            rt7Var.h = O != null && O.isQuestionThread();
            ListUtils.add(arrayList, i, rt7Var);
            if (et7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new qt7());
            }
        }
    }

    public final on W(ArrayList<on> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, arrayList, i)) == null) {
            if (i < 0 || (K = this.a.K()) == null || TextUtils.isEmpty(K.W1())) {
                return null;
            }
            al8 al8Var = new al8();
            l(al8Var);
            ListUtils.add(arrayList, i + 1, al8Var);
            return al8Var;
        }
        return (on) invokeLI.objValue;
    }

    public final void X(PostData postData, ArrayList<on> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048604, this, postData, arrayList, i) == null) {
            postData.a1(true);
            arrayList.add(i, postData);
        }
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.G : invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.c0 = B();
            if (this.b.getAdapter2() instanceof fn) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == 1) {
                ew7 ew7Var = this.c;
                if (ew7Var != null) {
                    ew7Var.P();
                }
                bn bnVar = this.p;
                if (bnVar instanceof pb8) {
                    ((pb8) bnVar).onPause();
                }
                bn bnVar2 = this.q;
                if (bnVar2 instanceof pb8) {
                    ((pb8) bnVar2).onPause();
                }
                bn bnVar3 = this.s;
                if (bnVar3 instanceof pb8) {
                    ((pb8) bnVar3).onPause();
                }
                zv7.a().j(this.a.P());
                j95.a().d();
            } else if (i == 2) {
                ew7 ew7Var2 = this.c;
                if (ew7Var2 != null) {
                    ew7Var2.R();
                }
                bn bnVar4 = this.p;
                if (bnVar4 instanceof pb8) {
                    ((pb8) bnVar4).onResume();
                }
                bn bnVar5 = this.q;
                if (bnVar5 instanceof pb8) {
                    ((pb8) bnVar5).onResume();
                }
                bn bnVar6 = this.s;
                if (bnVar6 instanceof pb8) {
                    ((pb8) bnVar6).onResume();
                }
                h0(false);
                g0();
            } else if (i != 3) {
            } else {
                ew7 ew7Var3 = this.c;
                if (ew7Var3 != null) {
                    ew7Var3.Q();
                }
                bn bnVar7 = this.p;
                if (bnVar7 instanceof pb8) {
                    ((pb8) bnVar7).onDestroy();
                }
                bn bnVar8 = this.q;
                if (bnVar8 instanceof pb8) {
                    ((pb8) bnVar8).onDestroy();
                }
                bn bnVar9 = this.s;
                if (bnVar9 instanceof pb8) {
                    ((pb8) bnVar9).onDestroy();
                }
                zv7.a().d();
            }
        }
    }

    public void c0(boolean z, int i) {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (pbFragment = this.a) == null || pbFragment.S5() == null) {
            return;
        }
        this.a.S5().e2(z, i);
    }

    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            rg.a().removeCallbacks(this.b0);
            cx7 cx7Var = this.h;
            if (cx7Var != null) {
                cx7Var.onDestroy();
            }
            cx7 cx7Var2 = this.j;
            if (cx7Var2 != null) {
                cx7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            ux7 ux7Var = this.g;
            if (ux7Var != null) {
                ux7Var.onDestroy();
            }
            xl5.k().q(false);
        }
    }

    public void e0(boolean z) {
        ew7 ew7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || (ew7Var = this.c) == null) {
            return;
        }
        ew7Var.O(z);
    }

    public final void f0(boolean z, boolean z2, int i, List<on> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.K && !this.J) || i == -1 || ListUtils.isEmpty(list) || this.L) {
            return;
        }
        this.b0 = new e(this, list);
        rg.a().post(this.b0);
    }

    public void g0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.B == null || (postData = this.P) == null || postData.S() == null || this.c.J() == null) {
            return;
        }
        j95.a().c(this.B.Q(), this.B.m(), this.P.S(), this.c.J().p);
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048614, this, z) == null) || this.a.S5() == null || this.a.P() == null || this.a.P().b1() == null) {
            return;
        }
        zv7.a().g(this.a.P().b1().D2(), this.h.v(), this.a.S5().Z0(), this.a.P().getPageStayDurationItem(), z, this.A.b(), this.a.getListView());
    }

    public void i0(et7 et7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        mw7 mw7Var;
        boolean z7;
        List<on> list;
        int i3;
        on onVar;
        int i4;
        PostData postData2;
        PostData postData3;
        PostData postData4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048615, this, et7Var, z) == null) || et7Var == null) {
            return;
        }
        this.B = et7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            D0();
        }
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.clear();
        et7 et7Var2 = this.B;
        if (et7Var2 != null && et7Var2.F() != null && this.B.F().size() > 0) {
            this.C.addAll(this.B.F());
        }
        if (et7Var.O() != null && et7Var.O().getAuthor() != null) {
            this.O = et7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(et7Var);
        ArrayList<on> arrayList = new ArrayList<>(et7Var.F());
        PostData p = p(arrayList);
        PostData q = this.B.O().isQuestionThread() ? q(et7Var) : null;
        if (q != null) {
            arrayList.remove(q);
        }
        boolean z8 = p != null;
        if (!ys6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.B.q0()) {
            K(arrayList, Boolean.valueOf(z8));
        }
        if (p != null) {
            this.P = p;
        }
        if (this.H || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (et7Var.u0() && p.V() != null) {
                p.U0(null);
            }
            z8 = true;
            z2 = true;
        }
        if (z8 || et7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = et7Var.j();
            if (!this.H && et7Var.u0() && j.V() != null) {
                j.U0(null);
            }
            if (this.H || (postData4 = this.P) == null || j.g0 != null) {
                postData = j;
            } else {
                et7Var.D0(postData4);
                postData = postData4;
            }
            z8 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.F5()) {
            if (et7Var.F().size() > 0 && (postData3 = et7Var.F().get(0)) != null && postData3.B() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.B, arrayList, this.H);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.B.D());
            }
        }
        int D = D(this.B, arrayList, this.H);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.B.E());
        }
        ak8.f(arrayList, 1);
        int A = A(et7Var, arrayList);
        if (A >= 0) {
            V(et7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(et7Var, arrayList);
        if (G >= 0) {
            mt7 mt7Var = new mt7(mt7.c);
            mt7Var.b(true);
            ListUtils.add(arrayList, G, mt7Var);
        }
        int u = u(et7Var, arrayList);
        List<on> v = v(et7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            on onVar2 = (on) ListUtils.getItem(arrayList, u);
            if (onVar2 instanceof PostData) {
                ((PostData) onVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z8 ? F(et7Var, arrayList, this.H) : -1;
        if (F < 0 || et7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, et7Var.S());
            z5 = true;
            z6 = true;
        }
        if ((this.B.O().isQuestionThread() && q != null) || (this.B.O().isQuestionThread() && this.Q != null)) {
            if (q == null && (postData2 = this.Q) != null) {
                q = postData2;
            }
            if (!arrayList.contains(q)) {
                F++;
                X(q, arrayList, F);
            }
        }
        boolean z9 = T(et7Var, postData, arrayList, F) != null;
        if (z9) {
            F++;
        }
        if (!z9 && S(et7Var, arrayList, F) != null) {
            F++;
        }
        if (P(et7Var, arrayList, F) != null) {
            F++;
        }
        if (z8) {
            on W = W(arrayList, F);
            boolean z10 = W != null;
            if (z10) {
                z7 = z10;
                onVar = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                onVar = N(arrayList, i4);
                z7 = onVar != null;
            }
            boolean z11 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z11 && this.B.q0()) {
                this.e0 = i4;
                if (Q(arrayList, i4) != null) {
                    this.e0 = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z11) {
                i = F;
                mw7Var = null;
            } else {
                mw7 U = U(arrayList, onVar, F, i4);
                if (U != null) {
                    if (!z7) {
                        mw7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                mw7Var = U;
                i = F;
            }
            i2 = i4;
        } else {
            i = F;
            i2 = -1;
            mw7Var = null;
            z7 = false;
        }
        if (z8) {
            list = v;
            i3 = u;
            boolean O = O(et7Var, arrayList, z7, mw7Var != null, i2, i, u, A);
            if (mw7Var != null) {
                mw7Var.n = O;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.c.U(!z5);
        boolean C0 = C0(postData);
        if (this.I && !C0) {
            arrayList.remove(postData);
            this.I = false;
        }
        if (et7Var.S() != null) {
            et7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.D = arrayList;
            List<on> R = et7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.D);
            }
        }
        f0(C0, z, i3, list);
        if (r(postData, arrayList, z3)) {
            List<on> R2 = et7Var.R();
            if (!ListUtils.isEmpty(R2)) {
                this.b.setData(I(arrayList, R2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.E = z;
            this.c.setFromCDN(z);
            bn bnVar = this.p;
            if (bnVar != null && (bnVar instanceof ub8)) {
                ((ub8) bnVar).setIsFromCDN(z);
            }
            Iterator<tu7> it = this.x.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.I = z;
        }
    }

    public final void l(al8 al8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, al8Var) == null) || al8Var == null || this.B == null || al8Var.getAdvertAppInfo() == null) {
            return;
        }
        al8Var.getAdvertAppInfo().i = new ko4();
        if (this.B.y() != null) {
            al8Var.getAdvertAppInfo().i.b = this.B.y().a();
        }
        al8Var.getAdvertAppInfo().i.a = al8Var.k1();
        if (this.B.l() != null && (l = this.B.l()) != null) {
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

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.G = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.l0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.M = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.m0 = new ArrayList();
            ArrayList<BdUniqueId> g = ak8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                se7 b2 = xf7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.Z.add(b2);
                    this.m0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.m0)) {
                return true;
            }
            this.b.a(this.m0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.J = z;
        }
    }

    public final void o(List<on> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.Q())) {
                    vp4 vp4Var = new vp4();
                    vp4Var.h(postData.Q());
                    list.set(i, vp4Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.K = z;
        }
    }

    public final PostData p(ArrayList<on> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, arrayList)) == null) {
            Iterator<on> it = arrayList.iterator();
            while (it.hasNext()) {
                on next = it.next();
                if (next instanceof PostData) {
                    PostData postData = (PostData) next;
                    if (postData.B() == 1) {
                        return postData;
                    }
                }
            }
            return null;
        }
        return (PostData) invokeL.objValue;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.H = z;
        }
    }

    public final PostData q(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, et7Var)) == null) {
            if (et7Var == null || et7Var.U() == null) {
                return null;
            }
            PostData U = et7Var.U();
            this.Q = U;
            return U;
        }
        return (PostData) invokeL.objValue;
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.L = z;
        }
    }

    public final boolean r(PostData postData, ArrayList<on> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048630, this, postData, arrayList, z)) == null) {
            if (postData != null) {
                if (z) {
                    ListUtils.add(arrayList, 0, postData);
                    return true;
                }
                return false;
            }
            PostData postData2 = this.P;
            if (postData2 != null && !this.J) {
                ListUtils.add(arrayList, 0, postData2);
            } else {
                PostData postData3 = new PostData();
                postData3.C0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.A.b() : (View) invokeV.objValue;
    }

    public void s0(boolean z) {
        yv7 yv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048633, this, z) == null) || (yv7Var = this.k) == null) {
            return;
        }
        yv7Var.t0(z);
    }

    public ArrayList<on> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.D : (ArrayList) invokeV.objValue;
    }

    public void t0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final int u(et7 et7Var, ArrayList<on> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048636, this, et7Var, arrayList)) == null) {
            if (this.J || et7Var == null || ListUtils.isEmpty(et7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (et7Var != null && et7Var.u0() && this.H) ? 0 : -1;
            } else if (this.a.K() == null || !this.a.K().B1()) {
                if (this.a.S5() == null || !this.a.S5().P0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        on onVar = arrayList.get(i);
                        if (onVar instanceof PostData) {
                            PostData postData = (PostData) onVar;
                            if (postData.B() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? et7Var.u0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            yv7 yv7Var = this.k;
            if (yv7Var != null) {
                yv7Var.u0(z);
            }
            cx7 cx7Var = this.h;
            if (cx7Var != null) {
                cx7Var.y(z);
            }
            bn bnVar = this.s;
            if (bnVar != null) {
                bnVar.setMulDel(z);
            }
            bn bnVar2 = this.p;
            if (bnVar2 != null) {
                bnVar2.setMulDel(z);
            }
            ew7 ew7Var = this.c;
            if (ew7Var != null) {
                ew7Var.setMulDel(z);
            }
        }
    }

    public final List<on> v(et7 et7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, et7Var)) == null) {
            if (et7Var == null || et7Var.T() == null || ListUtils.isEmpty(et7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = et7Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.a0 = true;
                    postData.N = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(et7Var.T().b) > 2) {
                on onVar = (on) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (onVar instanceof PostData) {
                    ((PostData) onVar).N = false;
                }
                arrayList.add(new j08());
            } else {
                on onVar2 = (on) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (onVar2 instanceof PostData) {
                    ((PostData) onVar2).N = true;
                }
            }
            rt7 rt7Var = new rt7(rt7.j);
            rt7Var.a = et7Var.T().c;
            arrayList.add(0, rt7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, yVar) == null) {
            this.U = yVar;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.b.getHeaderViewsCount() : invokeV.intValue;
    }

    public void w0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onLongClickListener) == null) {
            this.X = onLongClickListener;
        }
    }

    public on x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) ? this.b.G(i) : (on) invokeI.objValue;
    }

    public void x0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) {
            this.Y = fVar;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048644, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, onClickListener) == null) {
            this.S = onClickListener;
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void z0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, onClickListener) == null) {
            this.V = onClickListener;
        }
    }
}
