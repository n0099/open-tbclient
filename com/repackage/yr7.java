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
/* loaded from: classes7.dex */
public class yr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp7 A;
    public ArrayList<PostData> B;
    public ArrayList<jn> C;
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
    public mq7 U;
    public View.OnLongClickListener V;
    public SortSwitchButton.f W;
    public final List<wm> X;
    public final List<wm> Y;
    public Runnable Z;
    public PbFragment a;
    public int a0;
    public BdTypeListView b;
    public int b0;
    public is7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public ThreadData d0;
    public PbFirstFloorEnterForumAdapter e;
    public List<PostData> e0;
    public PbFirstFloorItemAdapter f;
    public final CustomMessageListener f0;
    public vt7 g;
    public CustomMessageListener g0;
    public ht7 h;
    public final CustomMessageListener h0;
    public vs7 i;
    public final View.OnClickListener i0;
    public ht7 j;
    public CustomMessageListener j0;
    public cs7 k;
    public List<wm> k0;
    public fw7 l;
    public gx5 m;
    public wm n;
    public wm o;
    public wm p;
    public wm q;
    public wm r;
    public et7 s;
    public ft7 t;
    public dt7 u;
    public PbReplyLoadMoreAdapter v;
    public ArrayList<zq7> w;
    public zr7 x;
    public ps7 y;
    public ar7 z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(yr7 yr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var, Integer.valueOf(i)};
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
            this.a = yr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof zg8)) {
                return;
            }
            zg8 zg8Var = (zg8) customResponsedMessage.getData();
            if (this.a.d0 == null || this.a.d0.funAdData != zg8Var) {
                return;
            }
            this.a.d0.funAdData.m(true);
            this.a.b.setData(this.a.C);
            this.a.Z();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yr7 yr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var, Integer.valueOf(i)};
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
            this.a = yr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof pg8)) {
                AbsDelegateAdapterList a = ((pg8) customResponsedMessage.getData()).a();
                Iterator<wm<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    wm<?, ?> next = it.next();
                    if (next instanceof es7) {
                        ((es7) next).a0(this.a.a);
                        if (next instanceof zq7) {
                            this.a.w.add((zq7) next);
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

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

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
                    this.a.a.Z();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(yr7 yr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var, Integer.valueOf(i)};
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
            this.a = yr7Var;
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
                mg.a().postDelayed(new a(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

        public d(yr7 yr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yr7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.A == null || this.a.A.T() == null) {
                return;
            }
            this.a.a.Z4().T0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ yr7 b;

        public e(yr7 yr7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yr7Var;
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

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(yr7 yr7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr7Var, Integer.valueOf(i)};
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
            this.a = yr7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.k0)) {
                this.a.n();
                yr7 yr7Var = this.a;
                yr7Var.g0(yr7Var.A, false);
            }
        }
    }

    public yr7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.M = li.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.h0);
        this.b0 = li.i(this.a.getContext()) / 3;
    }

    public final int A(kp7 kp7Var, ArrayList<jn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, kp7Var, arrayList)) == null) {
            if (kp7Var == null || ListUtils.isEmpty(kp7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(kp7Var.F(), 0)) == null) {
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
                jn jnVar = arrayList.get(i);
                if (jnVar instanceof PostData) {
                    PostData postData = (PostData) jnVar;
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
        kp7 kp7Var;
        ah8 ah8Var;
        ah8 ah8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (kp7Var = this.A) == null || kp7Var.a0 || kp7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = kp7Var.F();
        ArrayList<ah8> e2 = this.A.e();
        if (db7.e(F) || db7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ah8> it = e2.iterator();
        while (it.hasNext()) {
            ah8 next = it.next();
            if (next != null && next.N0() != null) {
                sb.append(next.N0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<ah8> it2 = e2.iterator();
        while (it2.hasNext()) {
            ah8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<ah8> it3 = e2.iterator();
        while (it3.hasNext()) {
            ah8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    c98.j(next3, q);
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
            ah8 ah8Var3 = (ah8) sparseArray.valueAt(i);
            if (ah8Var3 != null && (ah8Var2 = (ah8) hashMap.put(ah8Var3.M0(), ah8Var3)) != null) {
                c98.j(ah8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (ah8Var = (ah8) entry.getValue()) != null) {
                sparseArray.put(ah8Var.getPosition(), ah8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            db7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < db7.i(arrayList); i3++) {
            ah8 ah8Var4 = (ah8) sparseArray.get(((Integer) db7.d(arrayList, i3)).intValue());
            if (this.A.l() != null) {
                ah8Var4.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                ah8Var4.K0 = jg.g(this.A.O().getId(), 0L);
            }
            kp7 kp7Var2 = this.A;
            if (kp7Var2 != null && kp7Var2.y() != null) {
                ah8Var4.L0 = this.A.y().a();
            }
            l(ah8Var4);
            int position = ah8Var4.getPosition() + this.A.Z;
            if (position >= db7.i(F)) {
                ah8Var4.N0 = position;
                c98.k(ah8Var4, 2, position, db7.i(F));
                return;
            }
            if (!this.G) {
                position--;
                ah8Var4.N0 = position;
            }
            if (position < 0) {
                c98.j(ah8Var4, 23);
            } else {
                db7.b(F, ah8Var4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ah8Var4.getAdvertAppInfo().p);
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
                jn jnVar = this.b.getData().get(i);
                if (jnVar != null && jnVar.getType() == xp7.h) {
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

    public int C(kp7 kp7Var, ArrayList<jn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, kp7Var, arrayList, z)) == null) {
            if (kp7Var == null || kp7Var.F() == null || kp7Var.D() == null || kp7Var.F().size() == 0 || kp7Var.O() == null || arrayList == null || !kp7Var.D().M0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (kp7Var.F().get(0) == null || kp7Var.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (kp7Var.y() == null || kp7Var.y().a() != kp7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int D(kp7 kp7Var, ArrayList<jn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, kp7Var, arrayList, z)) == null) {
            if (kp7Var == null || kp7Var.F() == null || kp7Var.E() == null || kp7Var.F().size() == 0 || kp7Var.O() == null || arrayList == null || !kp7Var.E().M0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (kp7Var.F().get(0) == null || kp7Var.F().get(0).A() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (kp7Var.y() == null || kp7Var.y().a() != kp7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public final int F(kp7 kp7Var, ArrayList<jn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, kp7Var, arrayList, z)) == null) {
            if (kp7Var == null || ListUtils.isEmpty(kp7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (kp7Var == null || !kp7Var.r0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (kp7Var.F().get(0) == null || kp7Var.F().get(0).A() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int G(kp7 kp7Var, ArrayList<jn> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kp7Var, arrayList)) == null) {
            int i = -1;
            if (kp7Var == null || kp7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = kp7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.E) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof xp7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return kp7Var.L() == 4 ? i + 1 : i;
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

    public final ArrayList<jn> I(List<jn> list, List<jn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, list, list2)) == null) {
            ArrayList<jn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            qp7 qp7Var = new qp7();
            PbListView X0 = this.a.Z4().X0();
            if (X0 != null && X0.n()) {
                qp7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0dd0);
                qp7Var.b = true;
            } else {
                qp7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09f3);
                qp7Var.b = false;
            }
            arrayList.add(qp7Var);
            jx5 jx5Var = new jx5();
            jx5Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6c);
            jx5Var.needTopMargin = false;
            arrayList.add(jx5Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            is7 is7Var = this.c;
            if (is7Var == null || is7Var.o0() == null) {
                return null;
            }
            if (this.c.o0().u != null && this.c.o0().u.isShown()) {
                return this.c.o0().u;
            }
            return this.c.o0().t;
        }
        return (View) invokeV.objValue;
    }

    public final void K(ArrayList<jn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = lv4.i();
        int j = lv4.j() - 1;
        if (bool.booleanValue()) {
            jn jnVar = arrayList.get(0);
            if ((jnVar instanceof PostData) && ((PostData) jnVar).A() == 1) {
                j++;
            }
        }
        int k = lv4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.v() != null && this.a.v().Z1() == 3) {
            this.e0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, pbFragment, bdTypeListView) == null) {
            is7 is7Var = new is7(pbFragment, PostData.w0);
            this.c = is7Var;
            is7Var.B0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, yp7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, mp7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), np7.c);
            this.g = new vt7(pbFragment, fp7.c);
            this.h = new ht7(pbFragment, xp7.h);
            this.i = new vs7(pbFragment, sp7.c);
            this.j = new ht7(pbFragment, xp7.i);
            cs7 cs7Var = new cs7(pbFragment, PostData.x0);
            this.k = cs7Var;
            cs7Var.Q0(pbFragment);
            this.n = q78.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.u);
            this.o = q78.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.w);
            this.p = lp6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.C);
            this.q = lp6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.r = lp6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.u = new dt7(pbFragment, up7.L0);
            this.s = new et7(pbFragment, ct7.I0);
            this.t = new ft7(pbFragment, to4.O0);
            this.v = new PbReplyLoadMoreAdapter(pbFragment, PostData.D0);
            this.l = new fw7(pbFragment, gw7.a);
            this.m = new gx5(pbFragment.getPageContext());
            this.x = new zr7(pbFragment, fn4.e);
            this.y = new ps7(pbFragment, pbFragment.getUniqueId());
            ar7 ar7Var = new ar7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.z = ar7Var;
            this.X.addAll(ar7Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new pg8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.X);
        }
    }

    public final void M(@NonNull kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, kp7Var) == null) {
            this.c.t(kp7Var);
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
            this.k.t(kp7Var);
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
            wm wmVar = this.o;
            if (wmVar != null && (wmVar instanceof m78)) {
                ((m78) wmVar).j(this.D);
            }
            Iterator<zq7> it = this.w.iterator();
            while (it.hasNext()) {
                zq7 next = it.next();
                if (next != null) {
                    next.t(kp7Var);
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
            this.h.t(kp7Var);
            this.g.t(kp7Var);
            this.j.t(kp7Var);
            this.s.t(kp7Var);
            this.t.t(kp7Var);
            this.x.f0(kp7Var);
            this.x.e0(this.a.s1);
            this.y.d0(kp7Var);
            this.z.f(kp7Var);
        }
    }

    public final jn N(ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            if (this.A == null) {
                return null;
            }
            ah8 i1 = this.a.v().i1();
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
                c98.j(i1, q);
                if (q != 28 && q != 31) {
                    i1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.A.l() != null) {
                i1.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                i1.K0 = jg.g(this.A.O().getId(), 0L);
            }
            kp7 kp7Var = this.A;
            if (kp7Var != null && kp7Var.y() != null) {
                i1.L0 = this.A.y().a();
            }
            l(i1);
            if (i >= 0) {
                db7.b(arrayList, i1, i);
                return i1;
            }
            return null;
        }
        return (jn) invokeLI.objValue;
    }

    public final boolean O(kp7 kp7Var, ArrayList<jn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{kp7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(kp7Var.f()) && kp7Var.f().size() > 2) {
                int min = Math.min(kp7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    fn4 fn4Var = kp7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        fn4Var.q(true);
                    }
                    if (fn4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            fn4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        fn4Var.s(true);
                    } else if (i5 == min - 1) {
                        fn4Var.r(true);
                    }
                    arrayList2.add(fn4Var);
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

    public final jn P(kp7 kp7Var, ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLLI;
        fp7 fp7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048593, this, kp7Var, arrayList, i)) == null) {
            if (i < 0 || kp7Var == null || !kp7Var.k || (fp7Var = kp7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, fp7Var);
            return fp7Var;
        }
        return (jn) invokeLLI.objValue;
    }

    public final jn Q(ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLI;
        kp7 kp7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (kp7Var = this.A) != null && kp7Var.n0()) {
                String d2 = qp6.e().d("pb_banner");
                if (this.d0 == null && kp6.j().o(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.d0 = threadData;
                    threadData.funAdData = new zg8();
                    kp7 kp7Var2 = this.A;
                    if (kp7Var2 != null) {
                        this.d0.funAdData.j(kp7Var2.m());
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
        return (jn) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
            return;
        }
        ListIterator<jn> listIterator = arrayList.listIterator();
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
                    zg8 zg8Var = new zg8();
                    kp7 kp7Var = this.A;
                    zg8Var.j(kp7Var != null ? kp7Var.m() : "");
                    kp7 kp7Var2 = this.A;
                    zg8Var.n(kp7Var2 != null ? kp7Var2.Q() : "");
                    zg8Var.k(true);
                    postData.s0 = zg8Var;
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
        zg8 zg8Var2 = new zg8();
        kp7 kp7Var3 = this.A;
        zg8Var2.j(kp7Var3 != null ? kp7Var3.m() : "");
        kp7 kp7Var4 = this.A;
        zg8Var2.n(kp7Var4 != null ? kp7Var4.Q() : "");
        zg8Var2.k(true);
        postData2.s0 = zg8Var2;
        listIterator.add(postData2);
        this.e0.add(postData2);
    }

    public final jn S(kp7 kp7Var, ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLLI;
        mp7 mp7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048596, this, kp7Var, arrayList, i)) == null) {
            if (kp7Var.l() == null || StringUtils.isNull(kp7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(kp7Var.l().getName(), this.a.v().o1()) && this.a.v().u1()) {
                return null;
            }
            if (!this.a.isSimpleForum() && !ListUtils.isEmpty(kp7Var.p())) {
                mp7Var = new mp7(kp7Var.p().get(0));
            } else {
                mp7Var = new mp7(kp7Var.l());
            }
            mp7Var.g = this.a.v().h2();
            ListUtils.add(arrayList, i + 1, mp7Var);
            return mp7Var;
        }
        return (jn) invokeLLI.objValue;
    }

    public final jn T(kp7 kp7Var, PostData postData, ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048597, this, kp7Var, postData, arrayList, i)) == null) {
            np7 np7Var = null;
            if (kp7Var.l() == null || StringUtils.isNull(kp7Var.l().getName()) || !TextUtils.equals(kp7Var.l().getName(), this.a.v().o1()) || !this.a.v().u1()) {
                if (postData != null) {
                    if (postData.o0 != null) {
                        np7Var = new np7(postData.o0);
                    }
                } else {
                    PostData postData2 = this.O;
                    if (postData2 != null && postData2.o0 != null) {
                        np7Var = new np7(this.O.o0);
                    }
                }
                if (np7Var != null) {
                    np7Var.b = this.a.v().h2();
                    ListUtils.add(arrayList, i + 1, np7Var);
                }
                return np7Var;
            }
            return null;
        }
        return (jn) invokeLLLI.objValue;
    }

    public final qs7 U(ArrayList<jn> arrayList, jn jnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048598, this, arrayList, jnVar, i, i2)) == null) {
            qs7 B = this.A.B();
            if (B != null) {
                if (jnVar != null) {
                    if (i2 >= 0 || jnVar.getType() == AdvertAppInfo.w) {
                        i2 = jnVar.getType() != AdvertAppInfo.w ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof qs7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (qs7) invokeLLII.objValue;
    }

    public final void V(kp7 kp7Var, ArrayList<jn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048599, this, kp7Var, arrayList, i) == null) {
            xp7 xp7Var = new xp7(xp7.h);
            ThreadData O = kp7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            xp7Var.d = this.a.u5();
            xp7Var.c = kp7Var.g;
            kp7Var.c();
            xp7Var.e = kp7Var.g0();
            xp7Var.g = kp7Var.f;
            ListUtils.add(arrayList, i, xp7Var);
            if (kp7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new wp7());
            }
        }
    }

    public final jn W(ArrayList<jn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048600, this, arrayList, i)) == null) {
            if (i < 0 || (v = this.a.v()) == null || TextUtils.isEmpty(v.T1())) {
                return null;
            }
            ah8 ah8Var = new ah8();
            l(ah8Var);
            ListUtils.add(arrayList, i + 1, ah8Var);
            return ah8Var;
        }
        return (jn) invokeLI.objValue;
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
            if (this.b.getAdapter2() instanceof an) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.Z4() == null) {
                return;
            }
            this.a.Z4().b2();
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            if (i == 1) {
                is7 is7Var = this.c;
                if (is7Var != null) {
                    is7Var.u0();
                }
                wm wmVar = this.o;
                if (wmVar instanceof h78) {
                    ((h78) wmVar).onPause();
                }
                wm wmVar2 = this.p;
                if (wmVar2 instanceof h78) {
                    ((h78) wmVar2).onPause();
                }
                wm wmVar3 = this.r;
                if (wmVar3 instanceof h78) {
                    ((h78) wmVar3).onPause();
                }
                ds7.a().j(this.a.w());
                u65.a().d();
            } else if (i == 2) {
                is7 is7Var2 = this.c;
                if (is7Var2 != null) {
                    is7Var2.w0();
                }
                wm wmVar4 = this.o;
                if (wmVar4 instanceof h78) {
                    ((h78) wmVar4).onResume();
                }
                wm wmVar5 = this.p;
                if (wmVar5 instanceof h78) {
                    ((h78) wmVar5).onResume();
                }
                wm wmVar6 = this.r;
                if (wmVar6 instanceof h78) {
                    ((h78) wmVar6).onResume();
                }
                f0(false);
                e0();
            } else if (i != 3) {
            } else {
                is7 is7Var3 = this.c;
                if (is7Var3 != null) {
                    is7Var3.v0();
                }
                wm wmVar7 = this.o;
                if (wmVar7 instanceof h78) {
                    ((h78) wmVar7).onDestroy();
                }
                wm wmVar8 = this.p;
                if (wmVar8 instanceof h78) {
                    ((h78) wmVar8).onDestroy();
                }
                wm wmVar9 = this.r;
                if (wmVar9 instanceof h78) {
                    ((h78) wmVar9).onDestroy();
                }
                ds7.a().d();
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            mg.a().removeCallbacks(this.Z);
            ht7 ht7Var = this.h;
            if (ht7Var != null) {
                ht7Var.onDestroy();
            }
            ht7 ht7Var2 = this.j;
            if (ht7Var2 != null) {
                ht7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            vt7 vt7Var = this.g;
            if (vt7Var != null) {
                vt7Var.onDestroy();
            }
        }
    }

    public void c0(boolean z) {
        is7 is7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048606, this, z) == null) || (is7Var = this.c) == null) {
            return;
        }
        is7Var.t0(z);
    }

    public final void d0(boolean z, boolean z2, int i, List<jn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.J && !this.I) || i == -1 || ListUtils.isEmpty(list) || this.K) {
            return;
        }
        this.Z = new e(this, list);
        mg.a().post(this.Z);
    }

    public void e0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.A == null || (postData = this.O) == null || postData.N() == null || this.c.o0() == null) {
            return;
        }
        u65.a().c(this.A.Q(), this.A.m(), this.O.N(), this.c.o0().o);
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048609, this, z) == null) || this.a.Z4() == null || this.a.w() == null || this.a.w().getPbModel() == null) {
            return;
        }
        ds7.a().g(this.a.w().getPbModel().y2(), this.h.c0(), this.a.Z4().Z0(), this.a.w().getPageStayDurationItem(), z, this.z.b(), this.a.getListView());
    }

    public void g0(kp7 kp7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        int i2;
        qs7 qs7Var;
        List<jn> list;
        int i3;
        boolean z8;
        jn jnVar;
        int i4;
        PostData postData2;
        PostData postData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048610, this, kp7Var, z) == null) || kp7Var == null) {
            return;
        }
        this.A = kp7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            A0();
        }
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.clear();
        kp7 kp7Var2 = this.A;
        if (kp7Var2 != null && kp7Var2.F() != null && this.A.F().size() > 0) {
            this.B.addAll(this.A.F());
        }
        if (kp7Var.O() != null && kp7Var.O().getAuthor() != null) {
            this.N = kp7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        M(kp7Var);
        ArrayList<jn> arrayList = new ArrayList<>(kp7Var.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!rp6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.A.n0()) {
            K(arrayList, Boolean.valueOf(z9));
        }
        if (p != null) {
            this.O = p;
        }
        if (this.G || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (kp7Var.r0() && p.P() != null) {
                p.C0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || kp7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = kp7Var.j();
            if (!this.G && kp7Var.r0() && j.P() != null) {
                j.C0(null);
            }
            postData = (this.G || (postData3 = this.O) == null || j.m0 != null) ? j : postData3;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.N4()) {
            if (kp7Var.F().size() > 0 && (postData2 = kp7Var.F().get(0)) != null && postData2.A() == 1 && !ListUtils.isEmpty(arrayList)) {
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
        zf8.f(arrayList, 1);
        int A = A(kp7Var, arrayList);
        if (A >= 0) {
            V(kp7Var, arrayList, A);
            z4 = true;
        } else {
            z4 = false;
        }
        int G = G(kp7Var, arrayList);
        if (G >= 0) {
            sp7 sp7Var = new sp7(sp7.c);
            sp7Var.b(true);
            ListUtils.add(arrayList, G, sp7Var);
        }
        int u = u(kp7Var, arrayList);
        List<jn> v = v(kp7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            jn jnVar2 = (jn) ListUtils.getItem(arrayList, u);
            if (jnVar2 instanceof PostData) {
                ((PostData) jnVar2).P = true;
            }
            ListUtils.addAll(arrayList, u, v);
            z4 = true;
        }
        int F = z9 ? F(kp7Var, arrayList, this.G) : -1;
        if (F < 0 || kp7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, F, kp7Var.S());
            z5 = true;
            z6 = true;
        }
        boolean z10 = T(kp7Var, postData, arrayList, F) != null;
        if (z10) {
            F++;
        }
        if (!z10 && S(kp7Var, arrayList, F) != null) {
            F++;
        }
        if (P(kp7Var, arrayList, F) != null) {
            F++;
        }
        if (z9) {
            jn W = W(arrayList, F);
            boolean z11 = W != null;
            if (z11) {
                z8 = z11;
                jnVar = W;
                i4 = -1;
            } else {
                i4 = F >= 0 ? F + 1 : u >= 0 ? u : A >= 0 ? A : -1;
                jnVar = N(arrayList, i4);
                z8 = jnVar != null;
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
                qs7Var = null;
            } else {
                qs7 U = U(arrayList, jnVar, F, i4);
                if (U != null) {
                    if (!z8) {
                        i2 = i4;
                        qs7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                i2 = i4;
                qs7Var = U;
                z7 = z8;
            }
            i = F;
        } else {
            i = F;
            z7 = false;
            i2 = -1;
            qs7Var = null;
        }
        if (z9) {
            list = v;
            int i5 = i;
            i3 = u;
            boolean O = O(kp7Var, arrayList, z7, qs7Var != null, i2, i5, u, A);
            if (qs7Var != null) {
                qs7Var.n = O;
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
        if (kp7Var.S() != null) {
            kp7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.C = arrayList;
            List<jn> R = kp7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.C);
            }
        }
        d0(z0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<jn> R2 = kp7Var.R();
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
            wm wmVar = this.o;
            if (wmVar != null && (wmVar instanceof m78)) {
                ((m78) wmVar).j(z);
            }
            Iterator<zq7> it = this.w.iterator();
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

    public final void l(ah8 ah8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, ah8Var) == null) || ah8Var == null || this.A == null || ah8Var.getAdvertAppInfo() == null) {
            return;
        }
        ah8Var.getAdvertAppInfo().i = new tm4();
        if (this.A.y() != null) {
            ah8Var.getAdvertAppInfo().i.b = this.A.y().a();
        }
        ah8Var.getAdvertAppInfo().i.a = ah8Var.O0();
        if (this.A.l() != null && (l = this.A.l()) != null) {
            ah8Var.getAdvertAppInfo().i.c = l.getId();
            ah8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            ah8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ah8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        ah8Var.getAdvertAppInfo().i.g = ah8Var.getAdvertAppInfo().g;
        ah8Var.getAdvertAppInfo().i.h = false;
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
            ArrayList<BdUniqueId> g = zf8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                va7 b2 = ac7.d().b(this.a.getPageContext(), g.get(i), 2);
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

    public final void o(List<jn> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.L())) {
                    eo4 eo4Var = new eo4();
                    eo4Var.i(postData.L());
                    list.set(i, eo4Var);
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

    public final PostData p(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, arrayList)) == null) {
            Iterator<jn> it = arrayList.iterator();
            while (it.hasNext()) {
                jn next = it.next();
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

    public final boolean q(PostData postData, ArrayList<jn> arrayList, boolean z) {
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
        cs7 cs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048626, this, z) == null) || (cs7Var = this.k) == null) {
            return;
        }
        cs7Var.O0(z);
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

    public ArrayList<jn> s() {
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
            is7 is7Var = this.c;
            if (is7Var == null || is7Var.o0() == null) {
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

    public final int u(kp7 kp7Var, ArrayList<jn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, kp7Var, arrayList)) == null) {
            if (this.I || kp7Var == null || ListUtils.isEmpty(kp7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (kp7Var != null && kp7Var.r0() && this.G) ? 0 : -1;
            } else if (this.a.v() == null || !this.a.v().y1()) {
                if (this.a.Z4() == null || !this.a.Z4().P0()) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            i = -1;
                            break;
                        }
                        jn jnVar = arrayList.get(i);
                        if (jnVar instanceof PostData) {
                            PostData postData = (PostData) jnVar;
                            if (postData.A() == 1 && postData.M == 0) {
                                z = true;
                                break;
                            }
                        }
                        i++;
                    }
                    return !z ? kp7Var.r0() ? 0 : -1 : i + 1;
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

    public final List<jn> v(kp7 kp7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, kp7Var)) == null) {
            if (kp7Var == null || kp7Var.T() == null || ListUtils.isEmpty(kp7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = kp7Var.T().a;
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
            if (ListUtils.getCount(kp7Var.T().b) > 2) {
                jn jnVar = (jn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (jnVar instanceof PostData) {
                    ((PostData) jnVar).N = false;
                }
                arrayList.add(new gw7());
            } else {
                jn jnVar2 = (jn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (jnVar2 instanceof PostData) {
                    ((PostData) jnVar2).N = true;
                }
            }
            xp7 xp7Var = new xp7(xp7.i);
            xp7Var.a = kp7Var.T().c;
            arrayList.add(0, xp7Var);
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

    public jn x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048639, this, i)) == null) ? this.b.G(i) : (jn) invokeI.objValue;
    }

    public void x0(mq7 mq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, mq7Var) == null) {
            this.U = mq7Var;
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
        vs7 vs7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048642, this) == null) || (vs7Var = this.i) == null) {
            return;
        }
        vs7Var.e0(2);
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
