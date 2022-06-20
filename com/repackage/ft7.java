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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class ft7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rq7 A;
    public ArrayList<PostData> B;
    public ArrayList<nn> C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public String N;
    public PostData O;
    public View.OnClickListener P;
    public View.OnClickListener Q;
    public View.OnClickListener R;
    public TbRichTextView.y S;
    public View.OnClickListener T;
    public tr7 U;
    public View.OnLongClickListener V;
    public SortSwitchButton.f W;
    public final List<an> X;
    public final List<an> Y;
    public Runnable Z;
    public PbFragment a;
    public int a0;
    public BdTypeListView b;
    public int b0;
    public pt7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public ThreadData d0;
    public PbFirstFloorEnterForumAdapter e;
    public List<PostData> e0;
    public PbFirstFloorItemAdapter f;
    public final CustomMessageListener f0;
    public cv7 g;
    public CustomMessageListener g0;
    public ou7 h;
    public final CustomMessageListener h0;
    public cu7 i;
    public final View.OnClickListener i0;
    public ou7 j;
    public CustomMessageListener j0;
    public jt7 k;
    public List<an> k0;
    public mx7 l;
    public gy5 m;
    public an n;
    public an o;
    public an p;
    public an q;
    public an r;
    public lu7 s;
    public mu7 t;
    public ku7 u;
    public PbReplyLoadMoreAdapter v;
    public ArrayList<gs7> w;
    public gt7 x;
    public wt7 y;
    public hs7 z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ft7 ft7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, Integer.valueOf(i)};
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
            this.a = ft7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof rh8)) {
                return;
            }
            rh8 rh8Var = (rh8) customResponsedMessage.getData();
            if (this.a.d0 == null || this.a.d0.funAdData != rh8Var) {
                return;
            }
            this.a.d0.funAdData.m(true);
            this.a.b.setData(this.a.C);
            this.a.Z();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ft7 ft7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, Integer.valueOf(i)};
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
            this.a = ft7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof ih8)) {
                AbsDelegateAdapterList a = ((ih8) customResponsedMessage.getData()).a();
                Iterator<an<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    an<?, ?> next = it.next();
                    if (next instanceof lt7) {
                        ((lt7) next).a0(this.a.a);
                        if (next instanceof gs7) {
                            this.a.w.add((gs7) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.Y.clear();
                this.a.Y.addAll(arrayList);
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        /* loaded from: classes6.dex */
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
                    this.a.a.Z();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ft7 ft7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, Integer.valueOf(i)};
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
            this.a = ft7Var;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.A == null || h9.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                qg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        public d(ft7 ft7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.A == null || this.a.A.T() == null) {
                return;
            }
            this.a.a.N5().T0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ ft7 b;

        public e(ft7 ft7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ft7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.b0);
                this.b.K = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ft7 ft7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft7Var, Integer.valueOf(i)};
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
            this.a = ft7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.k0)) {
                this.a.n();
                ft7 ft7Var = this.a;
                ft7Var.g0(ft7Var.A, false);
            }
        }
    }

    public ft7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.w = new ArrayList<>();
        this.B = new ArrayList<>();
        this.D = false;
        this.E = false;
        this.F = true;
        this.G = true;
        this.H = false;
        this.I = false;
        this.L = false;
        this.M = 0;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = new ArrayList();
        this.Y = new ArrayList();
        this.a0 = -1;
        this.b0 = 0;
        this.c0 = -1;
        this.e0 = new ArrayList();
        this.f0 = new a(this, 2921523);
        this.g0 = new b(this, 2004015);
        this.h0 = new c(this, 2001118);
        this.i0 = new d(this);
        this.j0 = new f(this, 2016470);
        this.M = pi.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.h0);
        this.b0 = pi.i(this.a.getContext()) / 3;
    }

    public final int A(rq7 rq7Var, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, rq7Var, arrayList)) == null) {
            if (rq7Var == null || ListUtils.isEmpty(rq7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(rq7Var.F(), 0)) == null) {
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
                nn nnVar = arrayList.get(i);
                if (nnVar instanceof PostData) {
                    PostData postData = (PostData) nnVar;
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

    public final void A0() {
        rq7 rq7Var;
        sh8 sh8Var;
        sh8 sh8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (rq7Var = this.A) == null || rq7Var.a0 || rq7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = rq7Var.F();
        ArrayList<sh8> e2 = this.A.e();
        if (oc7.e(F) || oc7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<sh8> it = e2.iterator();
        while (it.hasNext()) {
            sh8 next = it.next();
            if (next != null && next.O0() != null) {
                sb.append(next.O0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<sh8> it2 = e2.iterator();
        while (it2.hasNext()) {
            sh8 next2 = it2.next();
            if (next2 != null) {
                next2.O0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<sh8> it3 = e2.iterator();
        while (it3.hasNext()) {
            sh8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ja8.j(next3, n);
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
            sh8 sh8Var3 = (sh8) sparseArray.valueAt(i);
            if (sh8Var3 != null && (sh8Var2 = (sh8) hashMap.put(sh8Var3.N0(), sh8Var3)) != null) {
                ja8.j(sh8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (sh8Var = (sh8) entry.getValue()) != null) {
                sparseArray.put(sh8Var.getPosition(), sh8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            oc7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < oc7.i(arrayList); i3++) {
            sh8 sh8Var4 = (sh8) sparseArray.get(((Integer) oc7.d(arrayList, i3)).intValue());
            if (this.A.l() != null) {
                sh8Var4.I0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                sh8Var4.L0 = ng.g(this.A.O().getId(), 0L);
            }
            rq7 rq7Var2 = this.A;
            if (rq7Var2 != null && rq7Var2.y() != null) {
                sh8Var4.M0 = this.A.y().a();
            }
            l(sh8Var4);
            int position = sh8Var4.getPosition() + this.A.Z;
            if (position >= oc7.i(F)) {
                sh8Var4.O0 = position;
                ja8.k(sh8Var4, 2, position, oc7.i(F));
                return;
            }
            if (!this.G) {
                position--;
                sh8Var4.O0 = position;
            }
            if (position < 0) {
                ja8.j(sh8Var4, 23);
            } else {
                oc7.b(F, sh8Var4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", sh8Var4.getAdvertAppInfo().p);
            }
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
                nn nnVar = this.b.getData().get(i);
                if (nnVar != null && nnVar.getType() == er7.h) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i = this.c0) <= 0 || Q(this.C, i) == null) {
            return;
        }
        this.c0 = -1;
        this.b.setData(this.C);
        Z();
    }

    public int C(rq7 rq7Var, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, rq7Var, arrayList, z)) == null) {
            if (rq7Var == null || rq7Var.F() == null || rq7Var.D() == null || rq7Var.F().size() == 0 || rq7Var.O() == null || arrayList == null || !rq7Var.D().N0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (rq7Var.F().get(0) == null || rq7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (rq7Var.y() == null || rq7Var.y().a() != rq7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(rq7 rq7Var, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, rq7Var, arrayList, z)) == null) {
            if (rq7Var == null || rq7Var.F() == null || rq7Var.E() == null || rq7Var.F().size() == 0 || rq7Var.O() == null || arrayList == null || !rq7Var.E().N0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (rq7Var.F().get(0) == null || rq7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (rq7Var.y() == null || rq7Var.y().a() != rq7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public final int F(rq7 rq7Var, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, rq7Var, arrayList, z)) == null) {
            if (rq7Var == null || ListUtils.isEmpty(rq7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (rq7Var == null || !rq7Var.r0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (rq7Var.F().get(0) == null || rq7Var.F().get(0).B() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(rq7 rq7Var, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rq7Var, arrayList)) == null) {
            int i = -1;
            if (rq7Var == null || rq7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = rq7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.E) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof er7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return rq7Var.L() == 4 ? i + 1 : i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public final ArrayList<nn> I(List<nn> list, List<nn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, list, list2)) == null) {
            ArrayList<nn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            xq7 xq7Var = new xq7();
            PbListView X0 = this.a.N5().X0();
            if (X0 != null && X0.n()) {
                xq7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dd6);
                xq7Var.b = true;
            } else {
                xq7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f8);
                xq7Var.b = false;
            }
            arrayList.add(xq7Var);
            jy5 jy5Var = new jy5();
            jy5Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f77);
            jy5Var.needTopMargin = false;
            arrayList.add(jy5Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            pt7 pt7Var = this.c;
            if (pt7Var == null || pt7Var.o0() == null) {
                return null;
            }
            if (this.c.o0().u != null && this.c.o0().u.isShown()) {
                return this.c.o0().u;
            }
            return this.c.o0().t;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<nn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = vv4.i();
        int j = vv4.j() - 1;
        if (bool.booleanValue()) {
            nn nnVar = arrayList.get(0);
            if ((nnVar instanceof PostData) && ((PostData) nnVar).B() == 1) {
                j++;
            }
        }
        int k = vv4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.F() != null && this.a.F().a2() == 3) {
            this.e0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, pbFragment, bdTypeListView) == null) {
            pt7 pt7Var = new pt7(pbFragment, PostData.x0);
            this.c = pt7Var;
            pt7Var.B0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, fr7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, tq7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), uq7.c);
            this.g = new cv7(pbFragment, mq7.c);
            this.h = new ou7(pbFragment, er7.h);
            this.i = new cu7(pbFragment, zq7.c);
            this.j = new ou7(pbFragment, er7.i);
            jt7 jt7Var = new jt7(pbFragment, PostData.y0);
            this.k = jt7Var;
            jt7Var.Q0(pbFragment);
            this.n = x88.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.u);
            this.o = x88.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.w);
            this.p = oq6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.C);
            this.q = oq6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.r = oq6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.u = new ku7(pbFragment, br7.M0);
            this.s = new lu7(pbFragment, ju7.J0);
            this.t = new mu7(pbFragment, dp4.P0);
            this.v = new PbReplyLoadMoreAdapter(pbFragment, PostData.E0);
            this.l = new mx7(pbFragment, nx7.a);
            this.m = new gy5(pbFragment.getPageContext());
            this.x = new gt7(pbFragment, pn4.e);
            this.y = new wt7(pbFragment, pbFragment.getUniqueId());
            hs7 hs7Var = new hs7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.z = hs7Var;
            this.X.addAll(hs7Var.a());
            this.X.add(this.c);
            this.X.add(this.d);
            this.X.add(this.e);
            this.X.add(this.f);
            this.X.add(this.g);
            this.X.add(this.k);
            this.X.add(this.h);
            this.X.add(this.i);
            this.X.add(this.j);
            this.X.add(this.n);
            this.X.add(this.o);
            this.X.add(this.p);
            this.X.add(this.q);
            this.X.add(this.r);
            this.X.add(this.u);
            this.X.add(this.s);
            this.X.add(this.t);
            this.X.add(this.l);
            this.X.add(this.v);
            this.X.add(this.m);
            this.X.add(this.x);
            this.X.add(this.y);
            this.X.add(new PbPrivateTitleAdapter(pbFragment));
            this.g0.setPriority(1);
            this.g0.setSelfListener(true);
            pbFragment.registerListener(this.g0);
            pbFragment.registerListener(this.f0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new ih8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.X);
        }
    }

    public final void M(@NonNull rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rq7Var) == null) {
            this.c.s(rq7Var);
            this.c.setFromCDN(this.D);
            this.c.m(this.M);
            this.c.c(this.F);
            this.c.e(this.Q);
            this.c.l(this.P);
            this.c.o(this.S);
            this.c.d(this.V);
            this.c.y0(this.T);
            this.c.A0(this.U);
            this.f.d0(this.T);
            this.k.s(rq7Var);
            this.k.setFromCDN(this.D);
            this.k.p(this.N);
            this.k.c(this.F);
            this.k.e(this.Q);
            this.k.l(this.P);
            this.k.o(this.S);
            this.k.d(this.V);
            this.k.P0(this.U);
            this.d.n0(this.Q);
            this.v.d0(this.Q);
            this.l.d0(this.i0);
            an anVar = this.o;
            if (anVar != null && (anVar instanceof t88)) {
                ((t88) anVar).j(this.D);
            }
            Iterator<gs7> it = this.w.iterator();
            while (it.hasNext()) {
                gs7 next = it.next();
                if (next != null) {
                    next.s(rq7Var);
                    next.setFromCDN(this.D);
                    next.p(this.N);
                    next.m(this.M);
                    next.c(this.F);
                    next.f(this.G);
                    next.r(this.L);
                    next.e(this.Q);
                    next.l(this.P);
                    next.o(this.S);
                    next.d(this.V);
                }
            }
            this.h.e(this.Q);
            this.h.f0(this.W);
            this.i.e(this.R);
            this.j.e(this.Q);
            this.h.s(rq7Var);
            this.g.s(rq7Var);
            this.j.s(rq7Var);
            this.s.s(rq7Var);
            this.t.s(rq7Var);
            this.x.f0(rq7Var);
            this.x.e0(this.a.t1);
            this.y.d0(rq7Var);
            this.z.f(rq7Var);
        }
    }

    public final nn N(ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            if (this.A == null) {
                return null;
            }
            sh8 j1 = this.a.F().j1();
            if (j1 == null) {
                j1 = this.A.z();
            }
            if (j1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert Q0 = j1.Q0();
            if (Q0 != null) {
                Q0.setAdvertAppInfo(j1.getAdvertAppInfo());
            }
            int n = j1.getAdvertAppInfo().n();
            if (n != 0) {
                ja8.j(j1, n);
                if (n != 28 && n != 31) {
                    j1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.A.l() != null) {
                j1.I0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                j1.L0 = ng.g(this.A.O().getId(), 0L);
            }
            rq7 rq7Var = this.A;
            if (rq7Var != null && rq7Var.y() != null) {
                j1.M0 = this.A.y().a();
            }
            l(j1);
            if (i >= 0) {
                oc7.b(arrayList, j1, i);
                return j1;
            }
            return null;
        }
        return (nn) invokeLI.objValue;
    }

    public final boolean O(rq7 rq7Var, ArrayList<nn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{rq7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(rq7Var.f()) && rq7Var.f().size() > 2) {
                int min = Math.min(rq7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    pn4 pn4Var = rq7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        pn4Var.n(true);
                    }
                    if (pn4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            pn4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        pn4Var.s(true);
                    } else if (i5 == min - 1) {
                        pn4Var.r(true);
                    }
                    arrayList2.add(pn4Var);
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

    public final nn P(rq7 rq7Var, ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLLI;
        mq7 mq7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048593, this, rq7Var, arrayList, i)) == null) {
            if (i < 0 || rq7Var == null || !rq7Var.k || (mq7Var = rq7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, mq7Var);
            return mq7Var;
        }
        return (nn) invokeLLI.objValue;
    }

    public final nn Q(ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLI;
        rq7 rq7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (rq7Var = this.A) != null && rq7Var.n0()) {
                String d2 = tq6.e().d("pb_banner");
                if (this.d0 == null && nq6.m().w(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.d0 = threadData;
                    threadData.funAdData = new rh8();
                    rq7 rq7Var2 = this.A;
                    if (rq7Var2 != null) {
                        this.d0.funAdData.j(rq7Var2.m());
                        this.d0.funAdData.n(this.A.Q());
                    }
                }
                ThreadData threadData2 = this.d0;
                if (threadData2 != null && threadData2.funAdData != null) {
                    ListUtils.add(arrayList, i, threadData2);
                }
            }
            return this.d0;
        }
        return (nn) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<nn> listIterator = arrayList.listIterator();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                if (i5 >= i3) {
                    break;
                }
                if (i5 < this.e0.size()) {
                    listIterator.add(this.e0.get(i5));
                } else {
                    PostData postData = new PostData();
                    rh8 rh8Var = new rh8();
                    rq7 rq7Var = this.A;
                    rh8Var.j(rq7Var != null ? rq7Var.m() : "");
                    rq7 rq7Var2 = this.A;
                    rh8Var.n(rq7Var2 != null ? rq7Var2.Q() : "");
                    rh8Var.k(true);
                    postData.t0 = rh8Var;
                    listIterator.add(postData);
                    this.e0.add(postData);
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
        rh8 rh8Var2 = new rh8();
        rq7 rq7Var3 = this.A;
        rh8Var2.j(rq7Var3 != null ? rq7Var3.m() : "");
        rq7 rq7Var4 = this.A;
        rh8Var2.n(rq7Var4 != null ? rq7Var4.Q() : "");
        rh8Var2.k(true);
        postData2.t0 = rh8Var2;
        listIterator.add(postData2);
        this.e0.add(postData2);
    }

    public final nn S(rq7 rq7Var, ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLLI;
        tq7 tq7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, rq7Var, arrayList, i)) == null) {
            if (rq7Var.l() == null || StringUtils.isNull(rq7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(rq7Var.l().getName(), this.a.F().p1()) && this.a.F().v1()) {
                return null;
            }
            if (!this.a.v0() && !ListUtils.isEmpty(rq7Var.p())) {
                tq7Var = new tq7(rq7Var.p().get(0));
            } else {
                tq7Var = new tq7(rq7Var.l());
            }
            tq7Var.g = this.a.F().i2();
            ListUtils.add(arrayList, i + 1, tq7Var);
            return tq7Var;
        }
        return (nn) invokeLLI.objValue;
    }

    public final nn T(rq7 rq7Var, PostData postData, ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048597, this, rq7Var, postData, arrayList, i)) == null) {
            uq7 uq7Var = null;
            if (rq7Var.l() == null || StringUtils.isNull(rq7Var.l().getName()) || !TextUtils.equals(rq7Var.l().getName(), this.a.F().p1()) || !this.a.F().v1()) {
                if (postData != null) {
                    if (postData.o0 != null) {
                        uq7Var = new uq7(postData.o0);
                    }
                } else {
                    PostData postData2 = this.O;
                    if (postData2 != null && postData2.o0 != null) {
                        uq7Var = new uq7(this.O.o0);
                    }
                }
                if (uq7Var != null) {
                    uq7Var.b = this.a.F().i2();
                    ListUtils.add(arrayList, i + 1, uq7Var);
                }
                return uq7Var;
            }
            return null;
        }
        return (nn) invokeLLLI.objValue;
    }

    public final xt7 U(ArrayList<nn> arrayList, nn nnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048598, this, arrayList, nnVar, i, i2)) == null) {
            xt7 B = this.A.B();
            if (B != null) {
                if (nnVar != null) {
                    if (i2 >= 0 || nnVar.getType() == AdvertAppInfo.w) {
                        i2 = nnVar.getType() != AdvertAppInfo.w ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof xt7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (xt7) invokeLLII.objValue;
    }

    public final void V(rq7 rq7Var, ArrayList<nn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, rq7Var, arrayList, i) == null) {
            er7 er7Var = new er7(er7.h);
            ThreadData O = rq7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            er7Var.d = this.a.i6();
            er7Var.c = rq7Var.g;
            rq7Var.c();
            er7Var.e = rq7Var.g0();
            er7Var.g = rq7Var.f;
            ListUtils.add(arrayList, i, er7Var);
            if (rq7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new dr7());
            }
        }
    }

    public final nn W(ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, arrayList, i)) == null) {
            if (i < 0 || (F = this.a.F()) == null || TextUtils.isEmpty(F.U1())) {
                return null;
            }
            sh8 sh8Var = new sh8();
            l(sh8Var);
            ListUtils.add(arrayList, i + 1, sh8Var);
            return sh8Var;
        }
        return (nn) invokeLI.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.a0 = B();
            if (this.b.getAdapter2() instanceof en) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.N5() == null) {
                return;
            }
            this.a.N5().b2();
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            if (i == 1) {
                pt7 pt7Var = this.c;
                if (pt7Var != null) {
                    pt7Var.u0();
                }
                an anVar = this.o;
                if (anVar instanceof o88) {
                    ((o88) anVar).onPause();
                }
                an anVar2 = this.p;
                if (anVar2 instanceof o88) {
                    ((o88) anVar2).onPause();
                }
                an anVar3 = this.r;
                if (anVar3 instanceof o88) {
                    ((o88) anVar3).onPause();
                }
                kt7.a().j(this.a.N());
                i75.a().d();
            } else if (i == 2) {
                pt7 pt7Var2 = this.c;
                if (pt7Var2 != null) {
                    pt7Var2.w0();
                }
                an anVar4 = this.o;
                if (anVar4 instanceof o88) {
                    ((o88) anVar4).onResume();
                }
                an anVar5 = this.p;
                if (anVar5 instanceof o88) {
                    ((o88) anVar5).onResume();
                }
                an anVar6 = this.r;
                if (anVar6 instanceof o88) {
                    ((o88) anVar6).onResume();
                }
                f0(false);
                e0();
            } else if (i != 3) {
            } else {
                pt7 pt7Var3 = this.c;
                if (pt7Var3 != null) {
                    pt7Var3.v0();
                }
                an anVar7 = this.o;
                if (anVar7 instanceof o88) {
                    ((o88) anVar7).onDestroy();
                }
                an anVar8 = this.p;
                if (anVar8 instanceof o88) {
                    ((o88) anVar8).onDestroy();
                }
                an anVar9 = this.r;
                if (anVar9 instanceof o88) {
                    ((o88) anVar9).onDestroy();
                }
                kt7.a().d();
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            qg.a().removeCallbacks(this.Z);
            ou7 ou7Var = this.h;
            if (ou7Var != null) {
                ou7Var.onDestroy();
            }
            ou7 ou7Var2 = this.j;
            if (ou7Var2 != null) {
                ou7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            cv7 cv7Var = this.g;
            if (cv7Var != null) {
                cv7Var.onDestroy();
            }
        }
    }

    public void c0(boolean z) {
        pt7 pt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (pt7Var = this.c) == null) {
            return;
        }
        pt7Var.t0(z);
    }

    public final void d0(boolean z, boolean z2, int i, List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.J && !this.I) || i == -1 || ListUtils.isEmpty(list) || this.K) {
            return;
        }
        this.Z = new e(this, list);
        qg.a().post(this.Z);
    }

    public void e0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.A == null || (postData = this.O) == null || postData.O() == null || this.c.o0() == null) {
            return;
        }
        i75.a().c(this.A.Q(), this.A.m(), this.O.O(), this.c.o0().o);
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.a.N5() == null || this.a.N() == null || this.a.N().N0() == null) {
            return;
        }
        kt7.a().g(this.a.N().N0().z2(), this.h.c0(), this.a.N5().Z0(), this.a.N().getPageStayDurationItem(), z, this.z.b(), this.a.getListView());
    }

    public void g0(rq7 rq7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        int i2;
        xt7 xt7Var;
        List<nn> list;
        int i3;
        boolean z8;
        nn nnVar;
        int i4;
        PostData postData2;
        PostData postData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048610, this, rq7Var, z) == null) || rq7Var == null) {
            return;
        }
        this.A = rq7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            A0();
        }
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.clear();
        rq7 rq7Var2 = this.A;
        if (rq7Var2 != null && rq7Var2.F() != null && this.A.F().size() > 0) {
            this.B.addAll(this.A.F());
        }
        if (rq7Var.O() != null && rq7Var.O().getAuthor() != null) {
            this.N = rq7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(rq7Var);
        ArrayList<nn> arrayList = new ArrayList<>(rq7Var.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!uq6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.A.n0()) {
            K(arrayList, Boolean.valueOf(z9));
        }
        if (p != null) {
            this.O = p;
        }
        if (this.G || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (rq7Var.r0() && p.Q() != null) {
                p.D0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || rq7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = rq7Var.j();
            if (!this.G && rq7Var.r0() && j.Q() != null) {
                j.D0(null);
            }
            postData = (this.G || (postData3 = this.O) == null || j.m0 != null) ? j : postData3;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.B5()) {
            if (rq7Var.F().size() > 0 && (postData2 = rq7Var.F().get(0)) != null && postData2.B() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.A, arrayList, this.G);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.A.D());
            }
        }
        int D = D(this.A, arrayList, this.G);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.A.E());
        }
        sg8.f(arrayList, 1);
        int A = A(rq7Var, arrayList);
        if (A >= 0) {
            V(rq7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(rq7Var, arrayList);
        if (G >= 0) {
            zq7 zq7Var = new zq7(zq7.c);
            zq7Var.b(true);
            ListUtils.add(arrayList, G, zq7Var);
        }
        int u = u(rq7Var, arrayList);
        List<nn> v = v(rq7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            nn nnVar2 = (nn) ListUtils.getItem(arrayList, u);
            if (nnVar2 instanceof PostData) {
                ((PostData) nnVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z9 ? F(rq7Var, arrayList, this.G) : -1;
        if (F < 0 || rq7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, rq7Var.S());
            z5 = true;
            z6 = true;
        }
        boolean z10 = T(rq7Var, postData, arrayList, F) != null;
        if (z10) {
            F++;
        }
        if (!z10 && S(rq7Var, arrayList, F) != null) {
            F++;
        }
        if (P(rq7Var, arrayList, F) != null) {
            F++;
        }
        if (z9) {
            nn W = W(arrayList, F);
            boolean z11 = W != null;
            if (z11) {
                z8 = z11;
                nnVar = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                nnVar = N(arrayList, i4);
                z8 = nnVar != null;
            }
            boolean z12 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z12 && this.A.n0()) {
                this.c0 = i4;
                if (Q(arrayList, i4) != null) {
                    this.c0 = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                i2 = i4;
                z7 = z8;
                xt7Var = null;
            } else {
                xt7 U = U(arrayList, nnVar, F, i4);
                if (U != null) {
                    if (!z8) {
                        i2 = i4;
                        xt7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                i2 = i4;
                xt7Var = U;
                z7 = z8;
            }
            i = F;
        } else {
            i = F;
            z7 = false;
            i2 = -1;
            xt7Var = null;
        }
        if (z9) {
            list = v;
            int i5 = i;
            i3 = u;
            boolean O = O(rq7Var, arrayList, z7, xt7Var != null, i2, i5, u, A);
            if (xt7Var != null) {
                xt7Var.n = O;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.c.z0(!z5);
        boolean z0 = z0(postData);
        if (this.H && !z0) {
            arrayList.remove(postData);
            this.H = false;
        }
        if (rq7Var.S() != null) {
            rq7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.C = arrayList;
            List<nn> R = rq7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.C);
            }
        }
        d0(z0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<nn> R2 = rq7Var.R();
            if (!ListUtils.isEmpty(R2)) {
                this.b.setData(I(arrayList, R2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.D = z;
            this.c.setFromCDN(z);
            an anVar = this.o;
            if (anVar != null && (anVar instanceof t88)) {
                ((t88) anVar).j(z);
            }
            Iterator<gs7> it = this.w.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.H = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.F = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.L = z;
        }
    }

    public final void l(sh8 sh8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, sh8Var) == null) || sh8Var == null || this.A == null || sh8Var.getAdvertAppInfo() == null) {
            return;
        }
        sh8Var.getAdvertAppInfo().i = new dn4();
        if (this.A.y() != null) {
            sh8Var.getAdvertAppInfo().i.b = this.A.y().a();
        }
        sh8Var.getAdvertAppInfo().i.a = sh8Var.P0();
        if (this.A.l() != null && (l = this.A.l()) != null) {
            sh8Var.getAdvertAppInfo().i.c = l.getId();
            sh8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            sh8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            sh8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        sh8Var.getAdvertAppInfo().i.g = sh8Var.getAdvertAppInfo().g;
        sh8Var.getAdvertAppInfo().i.h = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.I = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.j0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.J = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.k0 = new ArrayList();
            ArrayList<BdUniqueId> g = sg8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                gc7 b2 = ld7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.X.add(b2);
                    this.k0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.k0)) {
                return true;
            }
            this.b.a(this.k0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.G = z;
        }
    }

    public final void o(List<nn> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.M())) {
                    oo4 oo4Var = new oo4();
                    oo4Var.h(postData.M());
                    list.set(i, oo4Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.K = z;
        }
    }

    public final PostData p(ArrayList<nn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, arrayList)) == null) {
            Iterator<nn> it = arrayList.iterator();
            while (it.hasNext()) {
                nn next = it.next();
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

    public void p0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final boolean q(PostData postData, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048625, this, postData, arrayList, z)) == null) {
            if (postData != null) {
                if (z) {
                    ListUtils.add(arrayList, 0, postData);
                    return true;
                }
                return false;
            }
            PostData postData2 = this.O;
            if (postData2 != null && !this.I) {
                ListUtils.add(arrayList, 0, postData2);
            } else {
                PostData postData3 = new PostData();
                postData3.q0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void q0(boolean z) {
        jt7 jt7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (jt7Var = this.k) == null) {
            return;
        }
        jt7Var.O0(z);
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.z.b() : (View) invokeV.objValue;
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            this.P = onClickListener;
        }
    }

    public ArrayList<nn> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void s0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, yVar) == null) {
            this.S = yVar;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            pt7 pt7Var = this.c;
            if (pt7Var == null || pt7Var.o0() == null) {
                return null;
            }
            return this.c.o0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void t0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onLongClickListener) == null) {
            this.V = onLongClickListener;
        }
    }

    public final int u(rq7 rq7Var, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, rq7Var, arrayList)) == null) {
            if (this.I || rq7Var == null || ListUtils.isEmpty(rq7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (rq7Var != null && rq7Var.r0() && this.G) ? 0 : -1;
            } else if (this.a.F() == null || !this.a.F().z1()) {
                if (this.a.N5() == null || !this.a.N5().P0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        nn nnVar = arrayList.get(i);
                        if (nnVar instanceof PostData) {
                            PostData postData = (PostData) nnVar;
                            if (postData.B() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? rq7Var.r0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public final List<nn> v(rq7 rq7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, rq7Var)) == null) {
            if (rq7Var == null || rq7Var.T() == null || ListUtils.isEmpty(rq7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = rq7Var.T().a;
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            int min = Math.min(2, list.size());
            for (int i = 0; i < min; i++) {
                PostData postData = list.get(i);
                if (postData != null) {
                    postData.g0 = true;
                    postData.N = true;
                    arrayList.add(postData);
                }
            }
            if (ListUtils.getCount(rq7Var.T().b) > 2) {
                nn nnVar = (nn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nnVar instanceof PostData) {
                    ((PostData) nnVar).N = false;
                }
                arrayList.add(new nx7());
            } else {
                nn nnVar2 = (nn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nnVar2 instanceof PostData) {
                    ((PostData) nnVar2).N = true;
                }
            }
            er7 er7Var = new er7(er7.i);
            er7Var.a = rq7Var.T().c;
            arrayList.add(0, er7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, onClickListener) == null) {
            this.Q = onClickListener;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.b.getHeaderViewsCount() : invokeV.intValue;
    }

    public void w0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public nn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) ? this.b.G(i) : (nn) invokeI.objValue;
    }

    public void x0(tr7 tr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, tr7Var) == null) {
            this.U = tr7Var;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048641, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0() {
        cu7 cu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (cu7Var = this.i) == null) {
            return;
        }
        cu7Var.e0(2);
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean z0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, postData)) == null) ? (this.a.F() == null || postData == null || postData.J() == null || !postData.J().equals(this.a.F().o2())) ? false : true : invokeL.booleanValue;
    }
}
