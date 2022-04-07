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
public class ju7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yr7 A;
    public ArrayList<PostData> B;
    public ArrayList<uo> C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public String M;
    public PostData N;
    public View.OnClickListener O;
    public View.OnClickListener P;
    public View.OnClickListener Q;
    public TbRichTextView.y R;
    public View.OnClickListener S;
    public ws7 T;
    public View.OnLongClickListener U;
    public SortSwitchButton.f V;
    public final List<ho> W;
    public final List<ho> X;
    public Runnable Y;
    public int Z;
    public PbFragment a;
    public int a0;
    public BdTypeListView b;
    public int b0;
    public tu7 c;
    public ThreadData c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public List<PostData> d0;
    public PbFirstFloorEnterForumAdapter e;
    public final CustomMessageListener e0;
    public PbFirstFloorItemAdapter f;
    public CustomMessageListener f0;
    public gw7 g;
    public final CustomMessageListener g0;
    public sv7 h;
    public final View.OnClickListener h0;
    public gv7 i;
    public CustomMessageListener i0;
    public sv7 j;
    public List<ho> j0;
    public nu7 k;
    public sy7 l;
    public ky5 m;
    public ho n;
    public ho o;
    public ho p;
    public ho q;
    public ho r;
    public pv7 s;
    public qv7 t;
    public ov7 u;
    public PbReplyLoadMoreAdapter v;
    public ArrayList<jt7> w;
    public ku7 x;
    public av7 y;
    public kt7 z;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ju7 ju7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju7Var, Integer.valueOf(i)};
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
            this.a = ju7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof uk8)) {
                return;
            }
            uk8 uk8Var = (uk8) customResponsedMessage.getData();
            if (this.a.c0 == null || this.a.c0.funAdData != uk8Var) {
                return;
            }
            this.a.c0.funAdData.m(true);
            this.a.b.setData(this.a.C);
            this.a.Z();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ju7 ju7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju7Var, Integer.valueOf(i)};
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
            this.a = ju7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof kk8)) {
                AbsDelegateAdapterList a = ((kk8) customResponsedMessage.getData()).a();
                Iterator<ho<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    ho<?, ?> next = it.next();
                    if (next instanceof pu7) {
                        ((pu7) next).a0(this.a.a);
                        if (next instanceof jt7) {
                            this.a.w.add((jt7) next);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(a);
                this.a.X.clear();
                this.a.X.addAll(arrayList);
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
        public final /* synthetic */ ju7 a;

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
        public c(ju7 ju7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju7Var, Integer.valueOf(i)};
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
            this.a = ju7Var;
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
                pg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju7 a;

        public d(ju7 ju7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ju7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.A == null || this.a.A.T() == null) {
                return;
            }
            this.a.a.P4().K0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ ju7 b;

        public e(ju7 ju7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ju7Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.setSelectionFromTop(this.b.b.getHeaderViewsCount() + this.a.size(), 0 - this.b.a0);
                this.b.J = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ju7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ju7 ju7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ju7Var, Integer.valueOf(i)};
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
            this.a = ju7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.j0)) {
                this.a.n();
                ju7 ju7Var = this.a;
                ju7Var.g0(ju7Var.A, false);
            }
        }
    }

    public ju7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = false;
        this.K = false;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = new ArrayList();
        this.X = new ArrayList();
        this.Z = -1;
        this.a0 = 0;
        this.b0 = -1;
        this.d0 = new ArrayList();
        this.e0 = new a(this, 2921523);
        this.f0 = new b(this, 2004015);
        this.g0 = new c(this, 2001118);
        this.h0 = new d(this);
        this.i0 = new f(this, 2016470);
        this.L = oi.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.g0);
        this.a0 = oi.i(this.a.getContext()) / 3;
    }

    public final int A(yr7 yr7Var, ArrayList<uo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, yr7Var, arrayList)) == null) {
            if (yr7Var == null || ListUtils.isEmpty(yr7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(yr7Var.F(), 0)) == null) {
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
                uo uoVar = arrayList.get(i);
                if (uoVar instanceof PostData) {
                    PostData postData = (PostData) uoVar;
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
        yr7 yr7Var;
        vk8 vk8Var;
        vk8 vk8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (yr7Var = this.A) == null || yr7Var.a0 || yr7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = yr7Var.F();
        ArrayList<vk8> e2 = this.A.e();
        if (gd7.e(F) || gd7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<vk8> it = e2.iterator();
        while (it.hasNext()) {
            vk8 next = it.next();
            if (next != null && next.N0() != null) {
                sb.append(next.N0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<vk8> it2 = e2.iterator();
        while (it2.hasNext()) {
            vk8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<vk8> it3 = e2.iterator();
        while (it3.hasNext()) {
            vk8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    tc8.k(next3, q);
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
            vk8 vk8Var3 = (vk8) sparseArray.valueAt(i);
            if (vk8Var3 != null && (vk8Var2 = (vk8) hashMap.put(vk8Var3.M0(), vk8Var3)) != null) {
                tc8.k(vk8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (vk8Var = (vk8) entry.getValue()) != null) {
                sparseArray.put(vk8Var.getPosition(), vk8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            gd7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < gd7.k(arrayList); i3++) {
            vk8 vk8Var4 = (vk8) sparseArray.get(((Integer) gd7.d(arrayList, i3)).intValue());
            if (this.A.l() != null) {
                vk8Var4.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                vk8Var4.K0 = mg.g(this.A.O().getId(), 0L);
            }
            yr7 yr7Var2 = this.A;
            if (yr7Var2 != null && yr7Var2.y() != null) {
                vk8Var4.L0 = this.A.y().a();
            }
            l(vk8Var4);
            int position = vk8Var4.getPosition() + this.A.Z;
            if (position >= gd7.k(F)) {
                vk8Var4.N0 = position;
                tc8.l(vk8Var4, 2, position, gd7.k(F));
                return;
            }
            if (!this.F) {
                position--;
                vk8Var4.N0 = position;
            }
            if (position < 0) {
                tc8.k(vk8Var4, 23);
            } else {
                gd7.b(F, vk8Var4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", vk8Var4.getAdvertAppInfo().s);
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
                uo uoVar = this.b.getData().get(i);
                if (uoVar != null && uoVar.getType() == ls7.h) {
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
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i = this.b0) <= 0 || Q(this.C, i) == null) {
            return;
        }
        this.b0 = -1;
        this.b.setData(this.C);
        Z();
    }

    public int C(yr7 yr7Var, ArrayList<uo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, yr7Var, arrayList, z)) == null) {
            if (yr7Var == null || yr7Var.F() == null || yr7Var.D() == null || yr7Var.F().size() == 0 || yr7Var.O() == null || arrayList == null || !yr7Var.D().M0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (yr7Var.F().get(0) == null || yr7Var.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (yr7Var.y() == null || yr7Var.y().a() != yr7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(yr7 yr7Var, ArrayList<uo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, yr7Var, arrayList, z)) == null) {
            if (yr7Var == null || yr7Var.F() == null || yr7Var.E() == null || yr7Var.F().size() == 0 || yr7Var.O() == null || arrayList == null || !yr7Var.E().M0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (yr7Var.F().get(0) == null || yr7Var.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (yr7Var.y() == null || yr7Var.y().a() != yr7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public final int F(yr7 yr7Var, ArrayList<uo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, yr7Var, arrayList, z)) == null) {
            if (yr7Var == null || ListUtils.isEmpty(yr7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (yr7Var == null || !yr7Var.r0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (yr7Var.F().get(0) == null || yr7Var.F().get(0).A() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(yr7 yr7Var, ArrayList<uo> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yr7Var, arrayList)) == null) {
            int i = -1;
            if (yr7Var == null || yr7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = yr7Var.y().c() == 1;
            int size = arrayList.size();
            if (z) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof ls7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return yr7Var.L() == 4 ? i + 1 : i;
        }
        return invokeLL.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.Z : invokeV.intValue;
    }

    public final ArrayList<uo> I(List<uo> list, List<uo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, list, list2)) == null) {
            ArrayList<uo> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            es7 es7Var = new es7();
            PbListView O0 = this.a.P4().O0();
            if (O0 != null && O0.n()) {
                es7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0db3);
                es7Var.b = true;
            } else {
                es7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e6);
                es7Var.b = false;
            }
            arrayList.add(es7Var);
            ny5 ny5Var = new ny5();
            ny5Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3f);
            ny5Var.needTopMargin = false;
            arrayList.add(ny5Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            tu7 tu7Var = this.c;
            if (tu7Var == null || tu7Var.o0() == null) {
                return null;
            }
            if (this.c.o0().x != null && this.c.o0().x.isShown()) {
                return this.c.o0().x;
            }
            return this.c.o0().w;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<uo> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = jw4.i();
        int j = jw4.j() - 1;
        if (bool.booleanValue()) {
            uo uoVar = arrayList.get(0);
            if ((uoVar instanceof PostData) && ((PostData) uoVar).A() == 1) {
                j++;
            }
        }
        int k = jw4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.w() != null && this.a.w().d1() == 3) {
            this.d0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, pbFragment, bdTypeListView) == null) {
            tu7 tu7Var = new tu7(pbFragment, PostData.w0);
            this.c = tu7Var;
            tu7Var.B0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, ms7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, as7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), bs7.c);
            this.g = new gw7(pbFragment, tr7.c);
            this.h = new sv7(pbFragment, ls7.h);
            this.i = new gv7(pbFragment, gs7.c);
            this.j = new sv7(pbFragment, ls7.i);
            nu7 nu7Var = new nu7(pbFragment, PostData.x0);
            this.k = nu7Var;
            nu7Var.Q0(pbFragment);
            this.n = fa8.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = fa8.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.p = ds6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.q = ds6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.r = ds6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.u = new ov7(pbFragment, is7.L0);
            this.s = new pv7(pbFragment, nv7.I0);
            this.t = new qv7(pbFragment, up4.O0);
            this.v = new PbReplyLoadMoreAdapter(pbFragment, PostData.D0);
            this.l = new sy7(pbFragment, ty7.a);
            this.m = new ky5(pbFragment.getPageContext());
            this.x = new ku7(pbFragment, ho4.e);
            this.y = new av7(pbFragment, pbFragment.getUniqueId());
            kt7 kt7Var = new kt7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.z = kt7Var;
            this.W.addAll(kt7Var.a());
            this.W.add(this.c);
            this.W.add(this.d);
            this.W.add(this.e);
            this.W.add(this.f);
            this.W.add(this.g);
            this.W.add(this.k);
            this.W.add(this.h);
            this.W.add(this.i);
            this.W.add(this.j);
            this.W.add(this.n);
            this.W.add(this.o);
            this.W.add(this.p);
            this.W.add(this.q);
            this.W.add(this.r);
            this.W.add(this.u);
            this.W.add(this.s);
            this.W.add(this.t);
            this.W.add(this.l);
            this.W.add(this.v);
            this.W.add(this.m);
            this.W.add(this.x);
            this.W.add(this.y);
            this.W.add(new PbPrivateTitleAdapter(pbFragment));
            this.f0.setPriority(1);
            this.f0.setSelfListener(true);
            pbFragment.registerListener(this.f0);
            pbFragment.registerListener(this.e0);
            m();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new kk8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.W);
        }
    }

    public final void M(@NonNull yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, yr7Var) == null) {
            this.c.t(yr7Var);
            this.c.setFromCDN(this.D);
            this.c.m(this.L);
            this.c.c(this.E);
            this.c.e(this.P);
            this.c.l(this.O);
            this.c.o(this.R);
            this.c.d(this.U);
            this.c.y0(this.S);
            this.c.A0(this.T);
            this.f.d0(this.S);
            this.k.t(yr7Var);
            this.k.setFromCDN(this.D);
            this.k.p(this.M);
            this.k.c(this.E);
            this.k.e(this.P);
            this.k.l(this.O);
            this.k.o(this.R);
            this.k.d(this.U);
            this.k.P0(this.T);
            this.d.n0(this.P);
            this.v.d0(this.P);
            this.l.d0(this.h0);
            ho hoVar = this.o;
            if (hoVar != null && (hoVar instanceof aa8)) {
                ((aa8) hoVar).j(this.D);
            }
            Iterator<jt7> it = this.w.iterator();
            while (it.hasNext()) {
                jt7 next = it.next();
                if (next != null) {
                    next.t(yr7Var);
                    next.setFromCDN(this.D);
                    next.p(this.M);
                    next.m(this.L);
                    next.c(this.E);
                    next.f(this.F);
                    next.s(this.K);
                    next.e(this.P);
                    next.l(this.O);
                    next.o(this.R);
                    next.d(this.U);
                }
            }
            this.h.e(this.P);
            this.h.f0(this.V);
            this.i.e(this.Q);
            this.j.e(this.P);
            this.h.t(yr7Var);
            this.g.t(yr7Var);
            this.j.t(yr7Var);
            this.s.t(yr7Var);
            this.t.t(yr7Var);
            this.x.f0(yr7Var);
            this.x.e0(this.a.p1);
            this.y.d0(yr7Var);
            this.z.f(yr7Var);
        }
    }

    public final uo N(ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            if (this.A == null) {
                return null;
            }
            vk8 m0 = this.a.w().m0();
            if (m0 == null) {
                m0 = this.A.z();
            }
            if (m0 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert P0 = m0.P0();
            if (P0 != null) {
                P0.setAdvertAppInfo(m0.getAdvertAppInfo());
            }
            int q = m0.getAdvertAppInfo().q();
            if (q != 0) {
                tc8.k(m0, q);
                if (q != 28 && q != 31) {
                    m0.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.A.l() != null) {
                m0.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                m0.K0 = mg.g(this.A.O().getId(), 0L);
            }
            yr7 yr7Var = this.A;
            if (yr7Var != null && yr7Var.y() != null) {
                m0.L0 = this.A.y().a();
            }
            l(m0);
            if (i >= 0) {
                gd7.b(arrayList, m0, i);
                return m0;
            }
            return null;
        }
        return (uo) invokeLI.objValue;
    }

    public final boolean O(yr7 yr7Var, ArrayList<uo> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{yr7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(yr7Var.f()) && yr7Var.f().size() > 2) {
                int min = Math.min(yr7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    ho4 ho4Var = yr7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        ho4Var.q(true);
                    }
                    if (ho4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            ho4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        ho4Var.s(true);
                    } else if (i5 == min - 1) {
                        ho4Var.r(true);
                    }
                    arrayList2.add(ho4Var);
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

    public final uo P(yr7 yr7Var, ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLLI;
        tr7 tr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048593, this, yr7Var, arrayList, i)) == null) {
            if (i < 0 || yr7Var == null || !yr7Var.k || (tr7Var = yr7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, tr7Var);
            return tr7Var;
        }
        return (uo) invokeLLI.objValue;
    }

    public final uo Q(ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLI;
        yr7 yr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (yr7Var = this.A) != null && yr7Var.n0()) {
                String d2 = is6.e().d("pb_banner");
                if (this.c0 == null && cs6.j().o(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.c0 = threadData;
                    threadData.funAdData = new uk8();
                    yr7 yr7Var2 = this.A;
                    if (yr7Var2 != null) {
                        this.c0.funAdData.j(yr7Var2.m());
                        this.c0.funAdData.n(this.A.Q());
                    }
                }
                ThreadData threadData2 = this.c0;
                if (threadData2 != null && threadData2.funAdData != null) {
                    ListUtils.add(arrayList, i, threadData2);
                }
            }
            return this.c0;
        }
        return (uo) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<uo> listIterator = arrayList.listIterator();
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
                if (i5 < this.d0.size()) {
                    listIterator.add(this.d0.get(i5));
                } else {
                    PostData postData = new PostData();
                    uk8 uk8Var = new uk8();
                    yr7 yr7Var = this.A;
                    uk8Var.j(yr7Var != null ? yr7Var.m() : "");
                    yr7 yr7Var2 = this.A;
                    uk8Var.n(yr7Var2 != null ? yr7Var2.Q() : "");
                    uk8Var.k(true);
                    postData.s0 = uk8Var;
                    listIterator.add(postData);
                    this.d0.add(postData);
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
        uk8 uk8Var2 = new uk8();
        yr7 yr7Var3 = this.A;
        uk8Var2.j(yr7Var3 != null ? yr7Var3.m() : "");
        yr7 yr7Var4 = this.A;
        uk8Var2.n(yr7Var4 != null ? yr7Var4.Q() : "");
        uk8Var2.k(true);
        postData2.s0 = uk8Var2;
        listIterator.add(postData2);
        this.d0.add(postData2);
    }

    public final uo S(yr7 yr7Var, ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLLI;
        as7 as7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, yr7Var, arrayList, i)) == null) {
            if (yr7Var.l() == null || StringUtils.isNull(yr7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(yr7Var.l().getName(), this.a.w().s0()) && this.a.w().y0()) {
                return null;
            }
            if (!this.a.isSimpleForum() && !ListUtils.isEmpty(yr7Var.p())) {
                as7Var = new as7(yr7Var.p().get(0));
            } else {
                as7Var = new as7(yr7Var.l());
            }
            as7Var.g = this.a.w().l1();
            ListUtils.add(arrayList, i + 1, as7Var);
            return as7Var;
        }
        return (uo) invokeLLI.objValue;
    }

    public final uo T(yr7 yr7Var, PostData postData, ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048597, this, yr7Var, postData, arrayList, i)) == null) {
            bs7 bs7Var = null;
            if (yr7Var.l() == null || StringUtils.isNull(yr7Var.l().getName()) || !TextUtils.equals(yr7Var.l().getName(), this.a.w().s0()) || !this.a.w().y0()) {
                if (postData != null) {
                    if (postData.o0 != null) {
                        bs7Var = new bs7(postData.o0);
                    }
                } else {
                    PostData postData2 = this.N;
                    if (postData2 != null && postData2.o0 != null) {
                        bs7Var = new bs7(this.N.o0);
                    }
                }
                if (bs7Var != null) {
                    bs7Var.b = this.a.w().l1();
                    ListUtils.add(arrayList, i + 1, bs7Var);
                }
                return bs7Var;
            }
            return null;
        }
        return (uo) invokeLLLI.objValue;
    }

    public final bv7 U(ArrayList<uo> arrayList, uo uoVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048598, this, arrayList, uoVar, i, i2)) == null) {
            bv7 B = this.A.B();
            if (B != null) {
                if (uoVar != null) {
                    if (i2 >= 0 || uoVar.getType() == AdvertAppInfo.z) {
                        i2 = uoVar.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof bv7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (bv7) invokeLLII.objValue;
    }

    public final void V(yr7 yr7Var, ArrayList<uo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, yr7Var, arrayList, i) == null) {
            ls7 ls7Var = new ls7(ls7.h);
            ThreadData O = yr7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            ls7Var.d = this.a.k5();
            ls7Var.c = yr7Var.g;
            yr7Var.c();
            ls7Var.e = yr7Var.g0();
            ls7Var.g = yr7Var.f;
            ListUtils.add(arrayList, i, ls7Var);
            if (yr7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new ks7());
            }
        }
    }

    public final uo W(ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, arrayList, i)) == null) {
            if (i < 0 || (w = this.a.w()) == null || TextUtils.isEmpty(w.X0())) {
                return null;
            }
            vk8 vk8Var = new vk8();
            l(vk8Var);
            ListUtils.add(arrayList, i + 1, vk8Var);
            return vk8Var;
        }
        return (uo) invokeLI.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.Z = B();
            if (this.b.getAdapter2() instanceof lo) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.P4() == null) {
                return;
            }
            this.a.P4().R1();
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            if (i == 1) {
                tu7 tu7Var = this.c;
                if (tu7Var != null) {
                    tu7Var.u0();
                }
                ho hoVar = this.o;
                if (hoVar instanceof v98) {
                    ((v98) hoVar).onPause();
                }
                ho hoVar2 = this.p;
                if (hoVar2 instanceof v98) {
                    ((v98) hoVar2).onPause();
                }
                ho hoVar3 = this.r;
                if (hoVar3 instanceof v98) {
                    ((v98) hoVar3).onPause();
                }
                ou7.a().j(this.a.x());
                j75.a().d();
            } else if (i == 2) {
                tu7 tu7Var2 = this.c;
                if (tu7Var2 != null) {
                    tu7Var2.w0();
                }
                ho hoVar4 = this.o;
                if (hoVar4 instanceof v98) {
                    ((v98) hoVar4).onResume();
                }
                ho hoVar5 = this.p;
                if (hoVar5 instanceof v98) {
                    ((v98) hoVar5).onResume();
                }
                ho hoVar6 = this.r;
                if (hoVar6 instanceof v98) {
                    ((v98) hoVar6).onResume();
                }
                f0(false);
                e0();
            } else if (i != 3) {
            } else {
                tu7 tu7Var3 = this.c;
                if (tu7Var3 != null) {
                    tu7Var3.v0();
                }
                ho hoVar7 = this.o;
                if (hoVar7 instanceof v98) {
                    ((v98) hoVar7).onDestroy();
                }
                ho hoVar8 = this.p;
                if (hoVar8 instanceof v98) {
                    ((v98) hoVar8).onDestroy();
                }
                ho hoVar9 = this.r;
                if (hoVar9 instanceof v98) {
                    ((v98) hoVar9).onDestroy();
                }
                ou7.a().d();
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            pg.a().removeCallbacks(this.Y);
            sv7 sv7Var = this.h;
            if (sv7Var != null) {
                sv7Var.onDestroy();
            }
            sv7 sv7Var2 = this.j;
            if (sv7Var2 != null) {
                sv7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            gw7 gw7Var = this.g;
            if (gw7Var != null) {
                gw7Var.onDestroy();
            }
        }
    }

    public void c0(boolean z) {
        tu7 tu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (tu7Var = this.c) == null) {
            return;
        }
        tu7Var.t0(z);
    }

    public final void d0(boolean z, boolean z2, int i, List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.I && !this.H) || i == -1 || ListUtils.isEmpty(list) || this.J) {
            return;
        }
        this.Y = new e(this, list);
        pg.a().post(this.Y);
    }

    public void e0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.A == null || (postData = this.N) == null || postData.N() == null || this.c.o0() == null) {
            return;
        }
        j75.a().c(this.A.Q(), this.A.m(), this.N.N(), this.c.o0().o, this.c.o0().r);
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.a.P4() == null || this.a.x() == null || this.a.x().getPbModel() == null) {
            return;
        }
        ou7.a().g(this.a.x().getPbModel().C1(), this.h.c0(), this.a.P4().Q0(), this.a.x().getPageStayDurationItem(), z, this.z.b(), this.a.getListView());
    }

    public void g0(yr7 yr7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        int i2;
        bv7 bv7Var;
        List<uo> list;
        int i3;
        boolean z8;
        uo uoVar;
        int i4;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048610, this, yr7Var, z) == null) || yr7Var == null) {
            return;
        }
        this.A = yr7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            A0();
        }
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.clear();
        yr7 yr7Var2 = this.A;
        if (yr7Var2 != null && yr7Var2.F() != null && this.A.F().size() > 0) {
            this.B.addAll(this.A.F());
        }
        if (yr7Var.O() != null && yr7Var.O().getAuthor() != null) {
            this.M = yr7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(yr7Var);
        ArrayList<uo> arrayList = new ArrayList<>(yr7Var.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!js6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.A.n0()) {
            K(arrayList, Boolean.valueOf(z9));
        }
        if (p != null) {
            this.N = p;
        }
        if (this.F || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (yr7Var.r0() && p.P() != null) {
                p.C0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || yr7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = yr7Var.j();
            if (!this.F && yr7Var.r0() && j.P() != null) {
                j.C0(null);
            }
            postData = j;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.D4()) {
            if (yr7Var.F().size() > 0 && (postData2 = yr7Var.F().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int C = C(this.A, arrayList, this.F);
            if (C >= 0) {
                ListUtils.add(arrayList, C, this.A.D());
            }
        }
        int D = D(this.A, arrayList, this.F);
        if (D >= 0) {
            ListUtils.add(arrayList, D, this.A.E());
        }
        uj8.f(arrayList, 1);
        int A = A(yr7Var, arrayList);
        if (A >= 0) {
            V(yr7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(yr7Var, arrayList);
        if (G >= 0) {
            gs7 gs7Var = new gs7(gs7.c);
            gs7Var.b(true);
            ListUtils.add(arrayList, G, gs7Var);
        }
        int u = u(yr7Var, arrayList);
        List<uo> v = v(yr7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            uo uoVar2 = (uo) ListUtils.getItem(arrayList, u);
            if (uoVar2 instanceof PostData) {
                ((PostData) uoVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z9 ? F(yr7Var, arrayList, this.F) : -1;
        if (F < 0 || yr7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, yr7Var.S());
            z5 = true;
            z6 = true;
        }
        boolean z10 = T(yr7Var, postData, arrayList, F) != null;
        if (z10) {
            F++;
        }
        if (!z10 && S(yr7Var, arrayList, F) != null) {
            F++;
        }
        if (P(yr7Var, arrayList, F) != null) {
            F++;
        }
        if (z9) {
            uo W = W(arrayList, F);
            boolean z11 = W != null;
            if (z11) {
                z8 = z11;
                uoVar = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                uoVar = N(arrayList, i4);
                z8 = uoVar != null;
            }
            boolean z12 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z12 && this.A.n0()) {
                this.b0 = i4;
                if (Q(arrayList, i4) != null) {
                    this.b0 = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                i2 = i4;
                z7 = z8;
                bv7Var = null;
            } else {
                bv7 U = U(arrayList, uoVar, F, i4);
                if (U != null) {
                    if (!z8) {
                        i2 = i4;
                        bv7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                i2 = i4;
                bv7Var = U;
                z7 = z8;
            }
            i = F;
        } else {
            i = F;
            z7 = false;
            i2 = -1;
            bv7Var = null;
        }
        if (z9) {
            list = v;
            int i5 = i;
            i3 = u;
            boolean O = O(yr7Var, arrayList, z7, bv7Var != null, i2, i5, u, A);
            if (bv7Var != null) {
                bv7Var.n = O;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.c.z0(!z5);
        boolean z0 = z0(postData);
        if (this.G && !z0) {
            arrayList.remove(postData);
            this.G = false;
        }
        if (yr7Var.S() != null) {
            yr7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.C = arrayList;
            List<uo> R = yr7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.C);
            }
        }
        d0(z0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<uo> R2 = yr7Var.R();
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
            ho hoVar = this.o;
            if (hoVar != null && (hoVar instanceof aa8)) {
                ((aa8) hoVar).j(z);
            }
            Iterator<jt7> it = this.w.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.G = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.E = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.K = z;
        }
    }

    public final void l(vk8 vk8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, vk8Var) == null) || vk8Var == null || this.A == null || vk8Var.getAdvertAppInfo() == null) {
            return;
        }
        vk8Var.getAdvertAppInfo().j = new vn4();
        if (this.A.y() != null) {
            vk8Var.getAdvertAppInfo().j.b = this.A.y().a();
        }
        vk8Var.getAdvertAppInfo().j.a = vk8Var.O0();
        if (this.A.l() != null && (l = this.A.l()) != null) {
            vk8Var.getAdvertAppInfo().j.d = l.getId();
            vk8Var.getAdvertAppInfo().j.e = l.getFirst_class();
            vk8Var.getAdvertAppInfo().j.f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            vk8Var.getAdvertAppInfo().j.g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        vk8Var.getAdvertAppInfo().j.h = vk8Var.getAdvertAppInfo().h;
        vk8Var.getAdvertAppInfo().j.i = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.H = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.i0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.I = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.j0 = new ArrayList();
            ArrayList<BdUniqueId> g = uj8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                yc7 b2 = fe7.d().b(this.a.getPageContext(), g.get(i), 2);
                if (b2 != null) {
                    this.W.add(b2);
                    this.j0.add(b2);
                }
            }
            if (ListUtils.isEmpty(this.j0)) {
                return true;
            }
            this.b.a(this.j0);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.F = z;
        }
    }

    public final void o(List<uo> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.L())) {
                    fp4 fp4Var = new fp4();
                    fp4Var.i(postData.L());
                    list.set(i, fp4Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.J = z;
        }
    }

    public final PostData p(ArrayList<uo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, arrayList)) == null) {
            Iterator<uo> it = arrayList.iterator();
            while (it.hasNext()) {
                uo next = it.next();
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
            this.Q = onClickListener;
        }
    }

    public final boolean q(PostData postData, ArrayList<uo> arrayList, boolean z) {
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
            PostData postData2 = this.N;
            if (postData2 != null && !this.H) {
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
        nu7 nu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (nu7Var = this.k) == null) {
            return;
        }
        nu7Var.O0(z);
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.z.b() : (View) invokeV.objValue;
    }

    public void r0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onClickListener) == null) {
            this.O = onClickListener;
        }
    }

    public ArrayList<uo> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void s0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, yVar) == null) {
            this.R = yVar;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            tu7 tu7Var = this.c;
            if (tu7Var == null || tu7Var.o0() == null) {
                return null;
            }
            return this.c.o0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void t0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, onLongClickListener) == null) {
            this.U = onLongClickListener;
        }
    }

    public final int u(yr7 yr7Var, ArrayList<uo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, yr7Var, arrayList)) == null) {
            if (this.H || yr7Var == null || ListUtils.isEmpty(yr7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (yr7Var != null && yr7Var.r0() && this.F) ? 0 : -1;
            } else if (this.a.w() == null || !this.a.w().C0()) {
                if (this.a.P4() == null || !this.a.P4().G0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        uo uoVar = arrayList.get(i);
                        if (uoVar instanceof PostData) {
                            PostData postData = (PostData) uoVar;
                            if (postData.A() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? yr7Var.r0() ? 0 : -1 : i + 1;
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
            this.V = fVar;
        }
    }

    public final List<uo> v(yr7 yr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, yr7Var)) == null) {
            if (yr7Var == null || yr7Var.T() == null || ListUtils.isEmpty(yr7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = yr7Var.T().a;
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
            if (ListUtils.getCount(yr7Var.T().b) > 2) {
                uo uoVar = (uo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (uoVar instanceof PostData) {
                    ((PostData) uoVar).N = false;
                }
                arrayList.add(new ty7());
            } else {
                uo uoVar2 = (uo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (uoVar2 instanceof PostData) {
                    ((PostData) uoVar2).N = true;
                }
            }
            ls7 ls7Var = new ls7(ls7.i);
            ls7Var.a = yr7Var.T().c;
            arrayList.add(0, ls7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, onClickListener) == null) {
            this.P = onClickListener;
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
            this.S = onClickListener;
        }
    }

    public uo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) ? this.b.G(i) : (uo) invokeI.objValue;
    }

    public void x0(ws7 ws7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, ws7Var) == null) {
            this.T = ws7Var;
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
        gv7 gv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (gv7Var = this.i) == null) {
            return;
        }
        gv7Var.e0(2);
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean z0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, postData)) == null) ? (this.a.w() == null || postData == null || postData.I() == null || !postData.I().equals(this.a.w().r1())) ? false : true : invokeL.booleanValue;
    }
}
