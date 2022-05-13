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
public class pu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bs7 A;
    public ArrayList<PostData> B;
    public ArrayList<ro> C;
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
    public dt7 U;
    public View.OnLongClickListener V;
    public SortSwitchButton.f W;
    public final List<eo> X;
    public final List<eo> Y;
    public Runnable Z;
    public PbFragment a;
    public int a0;
    public BdTypeListView b;
    public int b0;
    public zu7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public ThreadData d0;
    public PbFirstFloorEnterForumAdapter e;
    public List<PostData> e0;
    public PbFirstFloorItemAdapter f;
    public final CustomMessageListener f0;
    public mw7 g;
    public CustomMessageListener g0;
    public yv7 h;
    public final CustomMessageListener h0;
    public mv7 i;
    public final View.OnClickListener i0;
    public yv7 j;
    public CustomMessageListener j0;
    public tu7 k;
    public List<eo> k0;
    public wy7 l;
    public ny5 m;
    public eo n;
    public eo o;
    public eo p;
    public eo q;
    public eo r;
    public vv7 s;
    public wv7 t;
    public uv7 u;
    public PbReplyLoadMoreAdapter v;
    public ArrayList<qt7> w;
    public qu7 x;
    public gv7 y;
    public rt7 z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pu7 pu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, Integer.valueOf(i)};
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
            this.a = pu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof yj8)) {
                return;
            }
            yj8 yj8Var = (yj8) customResponsedMessage.getData();
            if (this.a.d0 == null || this.a.d0.funAdData != yj8Var) {
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
        public final /* synthetic */ pu7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(pu7 pu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, Integer.valueOf(i)};
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
            this.a = pu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof oj8)) {
                AbsDelegateAdapterList a = ((oj8) customResponsedMessage.getData()).a();
                Iterator<eo<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    eo<?, ?> next = it.next();
                    if (next instanceof vu7) {
                        ((vu7) next).a0(this.a.a);
                        if (next instanceof qt7) {
                            this.a.w.add((qt7) next);
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
        public final /* synthetic */ pu7 a;

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
        public c(pu7 pu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, Integer.valueOf(i)};
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
            this.a = pu7Var;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.a.A == null || f9.c(this.a.a.getActivity()).isScroll() || customResponsedMessage.getCmd() != 2001118 || !(customResponsedMessage instanceof DownloadMessage) || (data = ((DownloadMessage) customResponsedMessage).getData()) == null || data.size() == 0) {
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
                ng.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu7 a;

        public d(pu7 pu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pu7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.A == null || this.a.A.T() == null) {
                return;
            }
            this.a.a.Q4().P0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ pu7 b;

        public e(pu7 pu7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pu7Var;
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
        public final /* synthetic */ pu7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(pu7 pu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu7Var, Integer.valueOf(i)};
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
            this.a = pu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.k0)) {
                this.a.n();
                pu7 pu7Var = this.a;
                pu7Var.g0(pu7Var.A, false);
            }
        }
    }

    public pu7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.M = mi.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.h0);
        this.b0 = mi.i(this.a.getContext()) / 3;
    }

    public final int A(bs7 bs7Var, ArrayList<ro> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bs7Var, arrayList)) == null) {
            if (bs7Var == null || ListUtils.isEmpty(bs7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(bs7Var.F(), 0)) == null) {
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
                ro roVar = arrayList.get(i);
                if (roVar instanceof PostData) {
                    PostData postData = (PostData) roVar;
                    if (postData.A() == 1 && postData.M == 0) {
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
        bs7 bs7Var;
        zj8 zj8Var;
        zj8 zj8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bs7Var = this.A) == null || bs7Var.a0 || bs7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = bs7Var.F();
        ArrayList<zj8> e2 = this.A.e();
        if (pd7.e(F) || pd7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<zj8> it = e2.iterator();
        while (it.hasNext()) {
            zj8 next = it.next();
            if (next != null && next.N0() != null) {
                sb.append(next.N0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<zj8> it2 = e2.iterator();
        while (it2.hasNext()) {
            zj8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<zj8> it3 = e2.iterator();
        while (it3.hasNext()) {
            zj8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    vb8.j(next3, q);
                    if (q != 28 && q != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            zj8 zj8Var3 = (zj8) sparseArray.valueAt(i);
            if (zj8Var3 != null && (zj8Var2 = (zj8) hashMap.put(zj8Var3.M0(), zj8Var3)) != null) {
                vb8.j(zj8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (zj8Var = (zj8) entry.getValue()) != null) {
                sparseArray.put(zj8Var.getPosition(), zj8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            pd7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < pd7.i(arrayList); i3++) {
            zj8 zj8Var4 = (zj8) sparseArray.get(((Integer) pd7.d(arrayList, i3)).intValue());
            if (this.A.l() != null) {
                zj8Var4.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                zj8Var4.K0 = kg.g(this.A.O().getId(), 0L);
            }
            bs7 bs7Var2 = this.A;
            if (bs7Var2 != null && bs7Var2.y() != null) {
                zj8Var4.L0 = this.A.y().a();
            }
            l(zj8Var4);
            int position = zj8Var4.getPosition() + this.A.Z;
            if (position >= pd7.i(F)) {
                zj8Var4.N0 = position;
                vb8.k(zj8Var4, 2, position, pd7.i(F));
                return;
            }
            if (!this.G) {
                position--;
                zj8Var4.N0 = position;
            }
            if (position < 0) {
                vb8.j(zj8Var4, 23);
            } else {
                pd7.b(F, zj8Var4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", zj8Var4.getAdvertAppInfo().p);
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
                ro roVar = this.b.getData().get(i);
                if (roVar != null && roVar.getType() == os7.h) {
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

    public int C(bs7 bs7Var, ArrayList<ro> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, bs7Var, arrayList, z)) == null) {
            if (bs7Var == null || bs7Var.F() == null || bs7Var.D() == null || bs7Var.F().size() == 0 || bs7Var.O() == null || arrayList == null || !bs7Var.D().M0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (bs7Var.F().get(0) == null || bs7Var.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (bs7Var.y() == null || bs7Var.y().a() != bs7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(bs7 bs7Var, ArrayList<ro> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, bs7Var, arrayList, z)) == null) {
            if (bs7Var == null || bs7Var.F() == null || bs7Var.E() == null || bs7Var.F().size() == 0 || bs7Var.O() == null || arrayList == null || !bs7Var.E().M0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (bs7Var.F().get(0) == null || bs7Var.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (bs7Var.y() == null || bs7Var.y().a() != bs7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public final int F(bs7 bs7Var, ArrayList<ro> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, bs7Var, arrayList, z)) == null) {
            if (bs7Var == null || ListUtils.isEmpty(bs7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (bs7Var == null || !bs7Var.r0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (bs7Var.F().get(0) == null || bs7Var.F().get(0).A() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(bs7 bs7Var, ArrayList<ro> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bs7Var, arrayList)) == null) {
            int i = -1;
            if (bs7Var == null || bs7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = bs7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.E) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof os7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return bs7Var.L() == 4 ? i + 1 : i;
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

    public final ArrayList<ro> I(List<ro> list, List<ro> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, list, list2)) == null) {
            ArrayList<ro> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            hs7 hs7Var = new hs7();
            PbListView T0 = this.a.Q4().T0();
            if (T0 != null && T0.n()) {
                hs7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dcc);
                hs7Var.b = true;
            } else {
                hs7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09ec);
                hs7Var.b = false;
            }
            arrayList.add(hs7Var);
            qy5 qy5Var = new qy5();
            qy5Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f5b);
            qy5Var.needTopMargin = false;
            arrayList.add(qy5Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            zu7 zu7Var = this.c;
            if (zu7Var == null || zu7Var.o0() == null) {
                return null;
            }
            if (this.c.o0().x != null && this.c.o0().x.isShown()) {
                return this.c.o0().x;
            }
            return this.c.o0().w;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<ro> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = vw4.i();
        int j = vw4.j() - 1;
        if (bool.booleanValue()) {
            ro roVar = arrayList.get(0);
            if ((roVar instanceof PostData) && ((PostData) roVar).A() == 1) {
                j++;
            }
        }
        int k = vw4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.v() != null && this.a.v().Z1() == 3) {
            this.e0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, pbFragment, bdTypeListView) == null) {
            zu7 zu7Var = new zu7(pbFragment, PostData.w0);
            this.c = zu7Var;
            zu7Var.B0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, ps7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, ds7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), es7.c);
            this.g = new mw7(pbFragment, wr7.c);
            this.h = new yv7(pbFragment, os7.h);
            this.i = new mv7(pbFragment, js7.c);
            this.j = new yv7(pbFragment, os7.i);
            tu7 tu7Var = new tu7(pbFragment, PostData.x0);
            this.k = tu7Var;
            tu7Var.Q0(pbFragment);
            this.n = ja8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.u);
            this.o = ja8.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.w);
            this.p = fr6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.C);
            this.q = fr6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.r = fr6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.u = new uv7(pbFragment, ls7.L0);
            this.s = new vv7(pbFragment, tv7.I0);
            this.t = new wv7(pbFragment, eq4.O0);
            this.v = new PbReplyLoadMoreAdapter(pbFragment, PostData.D0);
            this.l = new wy7(pbFragment, xy7.a);
            this.m = new ny5(pbFragment.getPageContext());
            this.x = new qu7(pbFragment, qo4.e);
            this.y = new gv7(pbFragment, pbFragment.getUniqueId());
            rt7 rt7Var = new rt7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.z = rt7Var;
            this.X.addAll(rt7Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new oj8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.X);
        }
    }

    public final void M(@NonNull bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bs7Var) == null) {
            this.c.t(bs7Var);
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
            this.k.t(bs7Var);
            this.k.setFromCDN(this.D);
            this.k.q(this.N);
            this.k.c(this.F);
            this.k.e(this.Q);
            this.k.l(this.P);
            this.k.o(this.S);
            this.k.d(this.V);
            this.k.P0(this.U);
            this.d.n0(this.Q);
            this.v.d0(this.Q);
            this.l.d0(this.i0);
            eo eoVar = this.o;
            if (eoVar != null && (eoVar instanceof fa8)) {
                ((fa8) eoVar).j(this.D);
            }
            Iterator<qt7> it = this.w.iterator();
            while (it.hasNext()) {
                qt7 next = it.next();
                if (next != null) {
                    next.t(bs7Var);
                    next.setFromCDN(this.D);
                    next.q(this.N);
                    next.m(this.M);
                    next.c(this.F);
                    next.f(this.G);
                    next.s(this.L);
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
            this.h.t(bs7Var);
            this.g.t(bs7Var);
            this.j.t(bs7Var);
            this.s.t(bs7Var);
            this.t.t(bs7Var);
            this.x.f0(bs7Var);
            this.x.e0(this.a.p1);
            this.y.d0(bs7Var);
            this.z.f(bs7Var);
        }
    }

    public final ro N(ArrayList<ro> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            if (this.A == null) {
                return null;
            }
            zj8 i1 = this.a.v().i1();
            if (i1 == null) {
                i1 = this.A.z();
            }
            if (i1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert P0 = i1.P0();
            if (P0 != null) {
                P0.setAdvertAppInfo(i1.getAdvertAppInfo());
            }
            int q = i1.getAdvertAppInfo().q();
            if (q != 0) {
                vb8.j(i1, q);
                if (q != 28 && q != 31) {
                    i1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.A.l() != null) {
                i1.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                i1.K0 = kg.g(this.A.O().getId(), 0L);
            }
            bs7 bs7Var = this.A;
            if (bs7Var != null && bs7Var.y() != null) {
                i1.L0 = this.A.y().a();
            }
            l(i1);
            if (i >= 0) {
                pd7.b(arrayList, i1, i);
                return i1;
            }
            return null;
        }
        return (ro) invokeLI.objValue;
    }

    public final boolean O(bs7 bs7Var, ArrayList<ro> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{bs7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(bs7Var.f()) && bs7Var.f().size() > 2) {
                int min = Math.min(bs7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    qo4 qo4Var = bs7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        qo4Var.q(true);
                    }
                    if (qo4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            qo4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        qo4Var.s(true);
                    } else if (i5 == min - 1) {
                        qo4Var.r(true);
                    }
                    arrayList2.add(qo4Var);
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

    public final ro P(bs7 bs7Var, ArrayList<ro> arrayList, int i) {
        InterceptResult invokeLLI;
        wr7 wr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048593, this, bs7Var, arrayList, i)) == null) {
            if (i < 0 || bs7Var == null || !bs7Var.k || (wr7Var = bs7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, wr7Var);
            return wr7Var;
        }
        return (ro) invokeLLI.objValue;
    }

    public final ro Q(ArrayList<ro> arrayList, int i) {
        InterceptResult invokeLI;
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (bs7Var = this.A) != null && bs7Var.n0()) {
                String d2 = kr6.e().d("pb_banner");
                if (this.d0 == null && er6.j().o(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.d0 = threadData;
                    threadData.funAdData = new yj8();
                    bs7 bs7Var2 = this.A;
                    if (bs7Var2 != null) {
                        this.d0.funAdData.j(bs7Var2.m());
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
        return (ro) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<ro> listIterator = arrayList.listIterator();
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
                    yj8 yj8Var = new yj8();
                    bs7 bs7Var = this.A;
                    yj8Var.j(bs7Var != null ? bs7Var.m() : "");
                    bs7 bs7Var2 = this.A;
                    yj8Var.n(bs7Var2 != null ? bs7Var2.Q() : "");
                    yj8Var.k(true);
                    postData.s0 = yj8Var;
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
        yj8 yj8Var2 = new yj8();
        bs7 bs7Var3 = this.A;
        yj8Var2.j(bs7Var3 != null ? bs7Var3.m() : "");
        bs7 bs7Var4 = this.A;
        yj8Var2.n(bs7Var4 != null ? bs7Var4.Q() : "");
        yj8Var2.k(true);
        postData2.s0 = yj8Var2;
        listIterator.add(postData2);
        this.e0.add(postData2);
    }

    public final ro S(bs7 bs7Var, ArrayList<ro> arrayList, int i) {
        InterceptResult invokeLLI;
        ds7 ds7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, bs7Var, arrayList, i)) == null) {
            if (bs7Var.l() == null || StringUtils.isNull(bs7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(bs7Var.l().getName(), this.a.v().o1()) && this.a.v().u1()) {
                return null;
            }
            if (!this.a.isSimpleForum() && !ListUtils.isEmpty(bs7Var.p())) {
                ds7Var = new ds7(bs7Var.p().get(0));
            } else {
                ds7Var = new ds7(bs7Var.l());
            }
            ds7Var.g = this.a.v().h2();
            ListUtils.add(arrayList, i + 1, ds7Var);
            return ds7Var;
        }
        return (ro) invokeLLI.objValue;
    }

    public final ro T(bs7 bs7Var, PostData postData, ArrayList<ro> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048597, this, bs7Var, postData, arrayList, i)) == null) {
            es7 es7Var = null;
            if (bs7Var.l() == null || StringUtils.isNull(bs7Var.l().getName()) || !TextUtils.equals(bs7Var.l().getName(), this.a.v().o1()) || !this.a.v().u1()) {
                if (postData != null) {
                    if (postData.o0 != null) {
                        es7Var = new es7(postData.o0);
                    }
                } else {
                    PostData postData2 = this.O;
                    if (postData2 != null && postData2.o0 != null) {
                        es7Var = new es7(this.O.o0);
                    }
                }
                if (es7Var != null) {
                    es7Var.b = this.a.v().h2();
                    ListUtils.add(arrayList, i + 1, es7Var);
                }
                return es7Var;
            }
            return null;
        }
        return (ro) invokeLLLI.objValue;
    }

    public final hv7 U(ArrayList<ro> arrayList, ro roVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048598, this, arrayList, roVar, i, i2)) == null) {
            hv7 B = this.A.B();
            if (B != null) {
                if (roVar != null) {
                    if (i2 >= 0 || roVar.getType() == AdvertAppInfo.w) {
                        i2 = roVar.getType() != AdvertAppInfo.w ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof hv7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (hv7) invokeLLII.objValue;
    }

    public final void V(bs7 bs7Var, ArrayList<ro> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, bs7Var, arrayList, i) == null) {
            os7 os7Var = new os7(os7.h);
            ThreadData O = bs7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            os7Var.d = this.a.l5();
            os7Var.c = bs7Var.g;
            bs7Var.c();
            os7Var.e = bs7Var.g0();
            os7Var.g = bs7Var.f;
            ListUtils.add(arrayList, i, os7Var);
            if (bs7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new ns7());
            }
        }
    }

    public final ro W(ArrayList<ro> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, arrayList, i)) == null) {
            if (i < 0 || (v = this.a.v()) == null || TextUtils.isEmpty(v.T1())) {
                return null;
            }
            zj8 zj8Var = new zj8();
            l(zj8Var);
            ListUtils.add(arrayList, i + 1, zj8Var);
            return zj8Var;
        }
        return (ro) invokeLI.objValue;
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
            if (this.b.getAdapter2() instanceof io) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.Q4() == null) {
                return;
            }
            this.a.Q4().W1();
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            if (i == 1) {
                zu7 zu7Var = this.c;
                if (zu7Var != null) {
                    zu7Var.u0();
                }
                eo eoVar = this.o;
                if (eoVar instanceof aa8) {
                    ((aa8) eoVar).onPause();
                }
                eo eoVar2 = this.p;
                if (eoVar2 instanceof aa8) {
                    ((aa8) eoVar2).onPause();
                }
                eo eoVar3 = this.r;
                if (eoVar3 instanceof aa8) {
                    ((aa8) eoVar3).onPause();
                }
                uu7.a().j(this.a.w());
                a85.a().d();
            } else if (i == 2) {
                zu7 zu7Var2 = this.c;
                if (zu7Var2 != null) {
                    zu7Var2.w0();
                }
                eo eoVar4 = this.o;
                if (eoVar4 instanceof aa8) {
                    ((aa8) eoVar4).onResume();
                }
                eo eoVar5 = this.p;
                if (eoVar5 instanceof aa8) {
                    ((aa8) eoVar5).onResume();
                }
                eo eoVar6 = this.r;
                if (eoVar6 instanceof aa8) {
                    ((aa8) eoVar6).onResume();
                }
                f0(false);
                e0();
            } else if (i != 3) {
            } else {
                zu7 zu7Var3 = this.c;
                if (zu7Var3 != null) {
                    zu7Var3.v0();
                }
                eo eoVar7 = this.o;
                if (eoVar7 instanceof aa8) {
                    ((aa8) eoVar7).onDestroy();
                }
                eo eoVar8 = this.p;
                if (eoVar8 instanceof aa8) {
                    ((aa8) eoVar8).onDestroy();
                }
                eo eoVar9 = this.r;
                if (eoVar9 instanceof aa8) {
                    ((aa8) eoVar9).onDestroy();
                }
                uu7.a().d();
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ng.a().removeCallbacks(this.Z);
            yv7 yv7Var = this.h;
            if (yv7Var != null) {
                yv7Var.onDestroy();
            }
            yv7 yv7Var2 = this.j;
            if (yv7Var2 != null) {
                yv7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            mw7 mw7Var = this.g;
            if (mw7Var != null) {
                mw7Var.onDestroy();
            }
        }
    }

    public void c0(boolean z) {
        zu7 zu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (zu7Var = this.c) == null) {
            return;
        }
        zu7Var.t0(z);
    }

    public final void d0(boolean z, boolean z2, int i, List<ro> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.J && !this.I) || i == -1 || ListUtils.isEmpty(list) || this.K) {
            return;
        }
        this.Z = new e(this, list);
        ng.a().post(this.Z);
    }

    public void e0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.A == null || (postData = this.O) == null || postData.N() == null || this.c.o0() == null) {
            return;
        }
        a85.a().c(this.A.Q(), this.A.m(), this.O.N(), this.c.o0().o, this.c.o0().r);
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.a.Q4() == null || this.a.w() == null || this.a.w().getPbModel() == null) {
            return;
        }
        uu7.a().g(this.a.w().getPbModel().y2(), this.h.c0(), this.a.Q4().V0(), this.a.w().getPageStayDurationItem(), z, this.z.b(), this.a.getListView());
    }

    public void g0(bs7 bs7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        int i2;
        hv7 hv7Var;
        List<ro> list;
        int i3;
        boolean z8;
        ro roVar;
        int i4;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048610, this, bs7Var, z) == null) || bs7Var == null) {
            return;
        }
        this.A = bs7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            A0();
        }
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.clear();
        bs7 bs7Var2 = this.A;
        if (bs7Var2 != null && bs7Var2.F() != null && this.A.F().size() > 0) {
            this.B.addAll(this.A.F());
        }
        if (bs7Var.O() != null && bs7Var.O().getAuthor() != null) {
            this.N = bs7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(bs7Var);
        ArrayList<ro> arrayList = new ArrayList<>(bs7Var.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!lr6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.A.n0()) {
            K(arrayList, Boolean.valueOf(z9));
        }
        if (p != null) {
            this.O = p;
        }
        if (this.G || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (bs7Var.r0() && p.P() != null) {
                p.C0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || bs7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = bs7Var.j();
            if (!this.G && bs7Var.r0() && j.P() != null) {
                j.C0(null);
            }
            postData = j;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.E4()) {
            if (bs7Var.F().size() > 0 && (postData2 = bs7Var.F().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        yi8.f(arrayList, 1);
        int A = A(bs7Var, arrayList);
        if (A >= 0) {
            V(bs7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(bs7Var, arrayList);
        if (G >= 0) {
            js7 js7Var = new js7(js7.c);
            js7Var.b(true);
            ListUtils.add(arrayList, G, js7Var);
        }
        int u = u(bs7Var, arrayList);
        List<ro> v = v(bs7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            ro roVar2 = (ro) ListUtils.getItem(arrayList, u);
            if (roVar2 instanceof PostData) {
                ((PostData) roVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z9 ? F(bs7Var, arrayList, this.G) : -1;
        if (F < 0 || bs7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, bs7Var.S());
            z5 = true;
            z6 = true;
        }
        boolean z10 = T(bs7Var, postData, arrayList, F) != null;
        if (z10) {
            F++;
        }
        if (!z10 && S(bs7Var, arrayList, F) != null) {
            F++;
        }
        if (P(bs7Var, arrayList, F) != null) {
            F++;
        }
        if (z9) {
            ro W = W(arrayList, F);
            boolean z11 = W != null;
            if (z11) {
                z8 = z11;
                roVar = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                roVar = N(arrayList, i4);
                z8 = roVar != null;
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
                hv7Var = null;
            } else {
                hv7 U = U(arrayList, roVar, F, i4);
                if (U != null) {
                    if (!z8) {
                        i2 = i4;
                        hv7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                i2 = i4;
                hv7Var = U;
                z7 = z8;
            }
            i = F;
        } else {
            i = F;
            z7 = false;
            i2 = -1;
            hv7Var = null;
        }
        if (z9) {
            list = v;
            int i5 = i;
            i3 = u;
            boolean O = O(bs7Var, arrayList, z7, hv7Var != null, i2, i5, u, A);
            if (hv7Var != null) {
                hv7Var.n = O;
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
        if (bs7Var.S() != null) {
            bs7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.C = arrayList;
            List<ro> R = bs7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.C);
            }
        }
        d0(z0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<ro> R2 = bs7Var.R();
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
            eo eoVar = this.o;
            if (eoVar != null && (eoVar instanceof fa8)) {
                ((fa8) eoVar).j(z);
            }
            Iterator<qt7> it = this.w.iterator();
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

    public final void l(zj8 zj8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, zj8Var) == null) || zj8Var == null || this.A == null || zj8Var.getAdvertAppInfo() == null) {
            return;
        }
        zj8Var.getAdvertAppInfo().i = new eo4();
        if (this.A.y() != null) {
            zj8Var.getAdvertAppInfo().i.b = this.A.y().a();
        }
        zj8Var.getAdvertAppInfo().i.a = zj8Var.O0();
        if (this.A.l() != null && (l = this.A.l()) != null) {
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
            ArrayList<BdUniqueId> g = yi8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                hd7 b2 = me7.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public final void o(List<ro> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.L())) {
                    pp4 pp4Var = new pp4();
                    pp4Var.i(postData.L());
                    list.set(i, pp4Var);
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

    public final PostData p(ArrayList<ro> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, arrayList)) == null) {
            Iterator<ro> it = arrayList.iterator();
            while (it.hasNext()) {
                ro next = it.next();
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
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final boolean q(PostData postData, ArrayList<ro> arrayList, boolean z) {
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
                postData3.p0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void q0(boolean z) {
        tu7 tu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (tu7Var = this.k) == null) {
            return;
        }
        tu7Var.O0(z);
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

    public ArrayList<ro> s() {
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
            zu7 zu7Var = this.c;
            if (zu7Var == null || zu7Var.o0() == null) {
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

    public final int u(bs7 bs7Var, ArrayList<ro> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, bs7Var, arrayList)) == null) {
            if (this.I || bs7Var == null || ListUtils.isEmpty(bs7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (bs7Var != null && bs7Var.r0() && this.G) ? 0 : -1;
            } else if (this.a.v() == null || !this.a.v().y1()) {
                if (this.a.Q4() == null || !this.a.Q4().L0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        ro roVar = arrayList.get(i);
                        if (roVar instanceof PostData) {
                            PostData postData = (PostData) roVar;
                            if (postData.A() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? bs7Var.r0() ? 0 : -1 : i + 1;
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

    public final List<ro> v(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, bs7Var)) == null) {
            if (bs7Var == null || bs7Var.T() == null || ListUtils.isEmpty(bs7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = bs7Var.T().a;
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
            if (ListUtils.getCount(bs7Var.T().b) > 2) {
                ro roVar = (ro) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (roVar instanceof PostData) {
                    ((PostData) roVar).N = false;
                }
                arrayList.add(new xy7());
            } else {
                ro roVar2 = (ro) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (roVar2 instanceof PostData) {
                    ((PostData) roVar2).N = true;
                }
            }
            os7 os7Var = new os7(os7.i);
            os7Var.a = bs7Var.T().c;
            arrayList.add(0, os7Var);
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

    public ro x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) ? this.b.G(i) : (ro) invokeI.objValue;
    }

    public void x0(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, dt7Var) == null) {
            this.U = dt7Var;
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
        mv7 mv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (mv7Var = this.i) == null) {
            return;
        }
        mv7Var.e0(2);
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean z0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, postData)) == null) ? (this.a.v() == null || postData == null || postData.I() == null || !postData.I().equals(this.a.v().n2())) ? false : true : invokeL.booleanValue;
    }
}
