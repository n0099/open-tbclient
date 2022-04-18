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
public class qu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public bs7 A;
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
    public final List<ho> X;
    public final List<ho> Y;
    public Runnable Z;
    public PbFragment a;
    public int a0;
    public BdTypeListView b;
    public int b0;
    public av7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public ThreadData d0;
    public PbFirstFloorEnterForumAdapter e;
    public List<PostData> e0;
    public PbFirstFloorItemAdapter f;
    public final CustomMessageListener f0;
    public nw7 g;
    public CustomMessageListener g0;
    public zv7 h;
    public final CustomMessageListener h0;
    public nv7 i;
    public final View.OnClickListener i0;
    public zv7 j;
    public CustomMessageListener j0;
    public uu7 k;
    public List<ho> k0;
    public zy7 l;
    public my5 m;
    public ho n;
    public ho o;
    public ho p;
    public ho q;
    public ho r;
    public wv7 s;
    public xv7 t;
    public vv7 u;
    public PbReplyLoadMoreAdapter v;
    public ArrayList<qt7> w;
    public ru7 x;
    public hv7 y;
    public rt7 z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qu7 qu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var, Integer.valueOf(i)};
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
            this.a = qu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof bl8)) {
                return;
            }
            bl8 bl8Var = (bl8) customResponsedMessage.getData();
            if (this.a.d0 == null || this.a.d0.funAdData != bl8Var) {
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
        public final /* synthetic */ qu7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qu7 qu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var, Integer.valueOf(i)};
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
            this.a = qu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof rk8)) {
                AbsDelegateAdapterList a = ((rk8) customResponsedMessage.getData()).a();
                Iterator<ho<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    ho<?, ?> next = it.next();
                    if (next instanceof wu7) {
                        ((wu7) next).a0(this.a.a);
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

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu7 a;

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
        public c(qu7 qu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var, Integer.valueOf(i)};
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
            this.a = qu7Var;
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

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu7 a;

        public d(qu7 qu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.A == null || this.a.A.T() == null) {
                return;
            }
            this.a.a.P4().N0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ qu7 b;

        public e(qu7 qu7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qu7Var;
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
        public final /* synthetic */ qu7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(qu7 qu7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu7Var, Integer.valueOf(i)};
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
            this.a = qu7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.k0)) {
                this.a.n();
                qu7 qu7Var = this.a;
                qu7Var.g0(qu7Var.A, false);
            }
        }
    }

    public qu7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        this.M = oi.k(pbFragment.getPageContext().getPageActivity());
        this.a = pbFragment;
        this.b = bdTypeListView;
        L(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.h0);
        this.b0 = oi.i(this.a.getContext()) / 3;
    }

    public final int A(bs7 bs7Var, ArrayList<uo> arrayList) {
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

    public final boolean A0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData)) == null) ? (this.a.w() == null || postData == null || postData.I() == null || !postData.I().equals(this.a.w().r1())) ? false : true : invokeL.booleanValue;
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
                if (uoVar != null && uoVar.getType() == os7.h) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void B0() {
        bs7 bs7Var;
        cl8 cl8Var;
        cl8 cl8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bs7Var = this.A) == null || bs7Var.a0 || bs7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = bs7Var.F();
        ArrayList<cl8> e2 = this.A.e();
        if (jd7.e(F) || jd7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<cl8> it = e2.iterator();
        while (it.hasNext()) {
            cl8 next = it.next();
            if (next != null && next.N0() != null) {
                sb.append(next.N0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<cl8> it2 = e2.iterator();
        while (it2.hasNext()) {
            cl8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<cl8> it3 = e2.iterator();
        while (it3.hasNext()) {
            cl8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    ad8.k(next3, q);
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
            cl8 cl8Var3 = (cl8) sparseArray.valueAt(i);
            if (cl8Var3 != null && (cl8Var2 = (cl8) hashMap.put(cl8Var3.M0(), cl8Var3)) != null) {
                ad8.k(cl8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (cl8Var = (cl8) entry.getValue()) != null) {
                sparseArray.put(cl8Var.getPosition(), cl8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            jd7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < jd7.k(arrayList); i3++) {
            cl8 cl8Var4 = (cl8) sparseArray.get(((Integer) jd7.d(arrayList, i3)).intValue());
            if (this.A.l() != null) {
                cl8Var4.H0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                cl8Var4.K0 = mg.g(this.A.O().getId(), 0L);
            }
            bs7 bs7Var2 = this.A;
            if (bs7Var2 != null && bs7Var2.y() != null) {
                cl8Var4.L0 = this.A.y().a();
            }
            l(cl8Var4);
            int position = cl8Var4.getPosition() + this.A.Z;
            if (position >= jd7.k(F)) {
                cl8Var4.N0 = position;
                ad8.l(cl8Var4, 2, position, jd7.k(F));
                return;
            }
            if (!this.G) {
                position--;
                cl8Var4.N0 = position;
            }
            if (position < 0) {
                ad8.k(cl8Var4, 23);
            } else {
                jd7.b(F, cl8Var4, position);
                TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", cl8Var4.getAdvertAppInfo().s);
            }
        }
    }

    public int C(bs7 bs7Var, ArrayList<uo> arrayList, boolean z) {
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

    public void C0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (i = this.c0) <= 0 || Q(this.C, i) == null) {
            return;
        }
        this.c0 = -1;
        this.b.setData(this.C);
        Z();
    }

    public int D(bs7 bs7Var, ArrayList<uo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, bs7Var, arrayList, z)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public final int F(bs7 bs7Var, ArrayList<uo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, bs7Var, arrayList, z)) == null) {
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

    public final int G(bs7 bs7Var, ArrayList<uo> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, bs7Var, arrayList)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public final ArrayList<uo> I(List<uo> list, List<uo> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, list, list2)) == null) {
            ArrayList<uo> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            hs7 hs7Var = new hs7();
            PbListView R0 = this.a.P4().R0();
            if (R0 != null && R0.n()) {
                hs7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0db2);
                hs7Var.b = true;
            } else {
                hs7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09e6);
                hs7Var.b = false;
            }
            arrayList.add(hs7Var);
            py5 py5Var = new py5();
            py5Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f3e);
            py5Var.needTopMargin = false;
            arrayList.add(py5Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            av7 av7Var = this.c;
            if (av7Var == null || av7Var.o0() == null) {
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
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = iw4.i();
        int j = iw4.j() - 1;
        if (bool.booleanValue()) {
            uo uoVar = arrayList.get(0);
            if ((uoVar instanceof PostData) && ((PostData) uoVar).A() == 1) {
                j++;
            }
        }
        int k = iw4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.w() != null && this.a.w().d1() == 3) {
            this.e0.clear();
        }
        R(j, i, k, arrayList);
    }

    public void L(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, pbFragment, bdTypeListView) == null) {
            av7 av7Var = new av7(pbFragment, PostData.w0);
            this.c = av7Var;
            av7Var.B0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, ps7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, ds7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), es7.c);
            this.g = new nw7(pbFragment, wr7.c);
            this.h = new zv7(pbFragment, os7.h);
            this.i = new nv7(pbFragment, js7.c);
            this.j = new zv7(pbFragment, os7.i);
            uu7 uu7Var = new uu7(pbFragment, PostData.x0);
            this.k = uu7Var;
            uu7Var.Q0(pbFragment);
            this.n = ma8.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = ma8.q().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.z);
            this.p = fs6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.q = fs6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.G);
            this.r = fs6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.I);
            this.u = new vv7(pbFragment, ls7.L0);
            this.s = new wv7(pbFragment, uv7.I0);
            this.t = new xv7(pbFragment, tp4.O0);
            this.v = new PbReplyLoadMoreAdapter(pbFragment, PostData.D0);
            this.l = new zy7(pbFragment, az7.a);
            this.m = new my5(pbFragment.getPageContext());
            this.x = new ru7(pbFragment, go4.e);
            this.y = new hv7(pbFragment, pbFragment.getUniqueId());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new rk8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.X);
        }
    }

    public final void M(@NonNull bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bs7Var) == null) {
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
            ho hoVar = this.o;
            if (hoVar != null && (hoVar instanceof ha8)) {
                ((ha8) hoVar).j(this.D);
            }
            Iterator<qt7> it = this.w.iterator();
            while (it.hasNext()) {
                qt7 next = it.next();
                if (next != null) {
                    next.t(bs7Var);
                    next.setFromCDN(this.D);
                    next.p(this.N);
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

    public final uo N(ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, arrayList, i)) == null) {
            if (this.A == null) {
                return null;
            }
            cl8 m0 = this.a.w().m0();
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
                ad8.k(m0, q);
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
            bs7 bs7Var = this.A;
            if (bs7Var != null && bs7Var.y() != null) {
                m0.L0 = this.A.y().a();
            }
            l(m0);
            if (i >= 0) {
                jd7.b(arrayList, m0, i);
                return m0;
            }
            return null;
        }
        return (uo) invokeLI.objValue;
    }

    public final boolean O(bs7 bs7Var, ArrayList<uo> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{bs7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(bs7Var.f()) && bs7Var.f().size() > 2) {
                int min = Math.min(bs7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    go4 go4Var = bs7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        go4Var.q(true);
                    }
                    if (go4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            go4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        go4Var.s(true);
                    } else if (i5 == min - 1) {
                        go4Var.r(true);
                    }
                    arrayList2.add(go4Var);
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

    public final uo P(bs7 bs7Var, ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLLI;
        wr7 wr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, bs7Var, arrayList, i)) == null) {
            if (i < 0 || bs7Var == null || !bs7Var.k || (wr7Var = bs7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, wr7Var);
            return wr7Var;
        }
        return (uo) invokeLLI.objValue;
    }

    public final uo Q(ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLI;
        bs7 bs7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048595, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (bs7Var = this.A) != null && bs7Var.n0()) {
                String d2 = ks6.e().d("pb_banner");
                if (this.d0 == null && es6.j().o(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.d0 = threadData;
                    threadData.funAdData = new bl8();
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
        return (uo) invokeLI.objValue;
    }

    public final void R(int i, int i2, int i3, ArrayList<uo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
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
                if (i5 < this.e0.size()) {
                    listIterator.add(this.e0.get(i5));
                } else {
                    PostData postData = new PostData();
                    bl8 bl8Var = new bl8();
                    bs7 bs7Var = this.A;
                    bl8Var.j(bs7Var != null ? bs7Var.m() : "");
                    bs7 bs7Var2 = this.A;
                    bl8Var.n(bs7Var2 != null ? bs7Var2.Q() : "");
                    bl8Var.k(true);
                    postData.s0 = bl8Var;
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
        bl8 bl8Var2 = new bl8();
        bs7 bs7Var3 = this.A;
        bl8Var2.j(bs7Var3 != null ? bs7Var3.m() : "");
        bs7 bs7Var4 = this.A;
        bl8Var2.n(bs7Var4 != null ? bs7Var4.Q() : "");
        bl8Var2.k(true);
        postData2.s0 = bl8Var2;
        listIterator.add(postData2);
        this.e0.add(postData2);
    }

    public final uo S(bs7 bs7Var, ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLLI;
        ds7 ds7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, bs7Var, arrayList, i)) == null) {
            if (bs7Var.l() == null || StringUtils.isNull(bs7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(bs7Var.l().getName(), this.a.w().s0()) && this.a.w().y0()) {
                return null;
            }
            if (!this.a.isSimpleForum() && !ListUtils.isEmpty(bs7Var.p())) {
                ds7Var = new ds7(bs7Var.p().get(0));
            } else {
                ds7Var = new ds7(bs7Var.l());
            }
            ds7Var.g = this.a.w().l1();
            ListUtils.add(arrayList, i + 1, ds7Var);
            return ds7Var;
        }
        return (uo) invokeLLI.objValue;
    }

    public final uo T(bs7 bs7Var, PostData postData, ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048598, this, bs7Var, postData, arrayList, i)) == null) {
            es7 es7Var = null;
            if (bs7Var.l() == null || StringUtils.isNull(bs7Var.l().getName()) || !TextUtils.equals(bs7Var.l().getName(), this.a.w().s0()) || !this.a.w().y0()) {
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
                    es7Var.b = this.a.w().l1();
                    ListUtils.add(arrayList, i + 1, es7Var);
                }
                return es7Var;
            }
            return null;
        }
        return (uo) invokeLLLI.objValue;
    }

    public final iv7 U(ArrayList<uo> arrayList, uo uoVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048599, this, arrayList, uoVar, i, i2)) == null) {
            iv7 B = this.A.B();
            if (B != null) {
                if (uoVar != null) {
                    if (i2 >= 0 || uoVar.getType() == AdvertAppInfo.z) {
                        i2 = uoVar.getType() != AdvertAppInfo.z ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof iv7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (iv7) invokeLLII.objValue;
    }

    public final void V(bs7 bs7Var, ArrayList<uo> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048600, this, bs7Var, arrayList, i) == null) {
            os7 os7Var = new os7(os7.h);
            ThreadData O = bs7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            os7Var.d = this.a.k5();
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

    public final uo W(ArrayList<uo> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048601, this, arrayList, i)) == null) {
            if (i < 0 || (w = this.a.w()) == null || TextUtils.isEmpty(w.X0())) {
                return null;
            }
            cl8 cl8Var = new cl8();
            l(cl8Var);
            ListUtils.add(arrayList, i + 1, cl8Var);
            return cl8Var;
        }
        return (uo) invokeLI.objValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.a0 = B();
            if (this.b.getAdapter2() instanceof lo) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.P4() == null) {
                return;
            }
            this.a.P4().U1();
        }
    }

    public void a0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (i == 1) {
                av7 av7Var = this.c;
                if (av7Var != null) {
                    av7Var.u0();
                }
                ho hoVar = this.o;
                if (hoVar instanceof ca8) {
                    ((ca8) hoVar).onPause();
                }
                ho hoVar2 = this.p;
                if (hoVar2 instanceof ca8) {
                    ((ca8) hoVar2).onPause();
                }
                ho hoVar3 = this.r;
                if (hoVar3 instanceof ca8) {
                    ((ca8) hoVar3).onPause();
                }
                vu7.a().j(this.a.x());
                j75.a().d();
            } else if (i == 2) {
                av7 av7Var2 = this.c;
                if (av7Var2 != null) {
                    av7Var2.w0();
                }
                ho hoVar4 = this.o;
                if (hoVar4 instanceof ca8) {
                    ((ca8) hoVar4).onResume();
                }
                ho hoVar5 = this.p;
                if (hoVar5 instanceof ca8) {
                    ((ca8) hoVar5).onResume();
                }
                ho hoVar6 = this.r;
                if (hoVar6 instanceof ca8) {
                    ((ca8) hoVar6).onResume();
                }
                f0(false);
                e0();
            } else if (i != 3) {
            } else {
                av7 av7Var3 = this.c;
                if (av7Var3 != null) {
                    av7Var3.v0();
                }
                ho hoVar7 = this.o;
                if (hoVar7 instanceof ca8) {
                    ((ca8) hoVar7).onDestroy();
                }
                ho hoVar8 = this.p;
                if (hoVar8 instanceof ca8) {
                    ((ca8) hoVar8).onDestroy();
                }
                ho hoVar9 = this.r;
                if (hoVar9 instanceof ca8) {
                    ((ca8) hoVar9).onDestroy();
                }
                vu7.a().d();
            }
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            pg.a().removeCallbacks(this.Z);
            zv7 zv7Var = this.h;
            if (zv7Var != null) {
                zv7Var.onDestroy();
            }
            zv7 zv7Var2 = this.j;
            if (zv7Var2 != null) {
                zv7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            nw7 nw7Var = this.g;
            if (nw7Var != null) {
                nw7Var.onDestroy();
            }
        }
    }

    public void c0(boolean z) {
        av7 av7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || (av7Var = this.c) == null) {
            return;
        }
        av7Var.t0(z);
    }

    public final void d0(boolean z, boolean z2, int i, List<uo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.J && !this.I) || i == -1 || ListUtils.isEmpty(list) || this.K) {
            return;
        }
        this.Z = new e(this, list);
        pg.a().post(this.Z);
    }

    public void e0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.A == null || (postData = this.O) == null || postData.N() == null || this.c.o0() == null) {
            return;
        }
        j75.a().c(this.A.Q(), this.A.m(), this.O.N(), this.c.o0().o, this.c.o0().r);
    }

    public void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048610, this, z) == null) || this.a.P4() == null || this.a.x() == null || this.a.x().getPbModel() == null) {
            return;
        }
        vu7.a().g(this.a.x().getPbModel().C1(), this.h.c0(), this.a.P4().T0(), this.a.x().getPageStayDurationItem(), z, this.z.b(), this.a.getListView());
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
        iv7 iv7Var;
        List<uo> list;
        int i3;
        boolean z8;
        uo uoVar;
        int i4;
        PostData postData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048611, this, bs7Var, z) == null) || bs7Var == null) {
            return;
        }
        this.A = bs7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            B0();
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
        ArrayList<uo> arrayList = new ArrayList<>(bs7Var.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!ls6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.A.n0()) {
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
        if (this.a.D4()) {
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
        bk8.f(arrayList, 1);
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
        List<uo> v = v(bs7Var);
        if (!ListUtils.isEmpty(v) && u >= 0) {
            uo uoVar2 = (uo) ListUtils.getItem(arrayList, u);
            if (uoVar2 instanceof PostData) {
                ((PostData) uoVar2).P = true;
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
                this.c0 = i4;
                if (Q(arrayList, i4) != null) {
                    this.c0 = -1;
                    F++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z12) {
                i2 = i4;
                z7 = z8;
                iv7Var = null;
            } else {
                iv7 U = U(arrayList, uoVar, F, i4);
                if (U != null) {
                    if (!z8) {
                        i2 = i4;
                        iv7Var = U;
                        i = F;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        F++;
                    }
                }
                i2 = i4;
                iv7Var = U;
                z7 = z8;
            }
            i = F;
        } else {
            i = F;
            z7 = false;
            i2 = -1;
            iv7Var = null;
        }
        if (z9) {
            list = v;
            int i5 = i;
            i3 = u;
            boolean O = O(bs7Var, arrayList, z7, iv7Var != null, i2, i5, u, A);
            if (iv7Var != null) {
                iv7Var.n = O;
            }
        } else {
            list = v;
            i3 = u;
        }
        this.c.z0(!z5);
        boolean A0 = A0(postData);
        if (this.H && !A0) {
            arrayList.remove(postData);
            this.H = false;
        }
        if (bs7Var.S() != null) {
            bs7Var.S().j(!z6);
        }
        if (this.b != null) {
            this.C = arrayList;
            List<uo> R = bs7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(I(arrayList, R));
            } else {
                this.b.setData(this.C);
            }
        }
        d0(A0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<uo> R2 = bs7Var.R();
            if (!ListUtils.isEmpty(R2)) {
                this.b.setData(I(arrayList, R2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.D = z;
            this.c.setFromCDN(z);
            ho hoVar = this.o;
            if (hoVar != null && (hoVar instanceof ha8)) {
                ((ha8) hoVar).j(z);
            }
            Iterator<qt7> it = this.w.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.E = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.H = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.F = z;
        }
    }

    public final void l(cl8 cl8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, cl8Var) == null) || cl8Var == null || this.A == null || cl8Var.getAdvertAppInfo() == null) {
            return;
        }
        cl8Var.getAdvertAppInfo().j = new un4();
        if (this.A.y() != null) {
            cl8Var.getAdvertAppInfo().j.b = this.A.y().a();
        }
        cl8Var.getAdvertAppInfo().j.a = cl8Var.O0();
        if (this.A.l() != null && (l = this.A.l()) != null) {
            cl8Var.getAdvertAppInfo().j.d = l.getId();
            cl8Var.getAdvertAppInfo().j.e = l.getFirst_class();
            cl8Var.getAdvertAppInfo().j.f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            cl8Var.getAdvertAppInfo().j.g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        cl8Var.getAdvertAppInfo().j.h = cl8Var.getAdvertAppInfo().h;
        cl8Var.getAdvertAppInfo().j.i = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.L = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048618, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.j0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.I = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.k0 = new ArrayList();
            ArrayList<BdUniqueId> g = bk8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                bd7 b2 = ie7.d().b(this.a.getPageContext(), g.get(i), 2);
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
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.J = z;
        }
    }

    public final void o(List<uo> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.L())) {
                    ep4 ep4Var = new ep4();
                    ep4Var.i(postData.L());
                    list.set(i, ep4Var);
                }
            }
        }
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.G = z;
        }
    }

    public final PostData p(ArrayList<uo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, arrayList)) == null) {
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

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.K = z;
        }
    }

    public final boolean q(PostData postData, ArrayList<uo> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048626, this, postData, arrayList, z)) == null) {
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

    public void q0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.z.b() : (View) invokeV.objValue;
    }

    public void r0(boolean z) {
        uu7 uu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z) == null) || (uu7Var = this.k) == null) {
            return;
        }
        uu7Var.O0(z);
    }

    public ArrayList<uo> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void s0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, onClickListener) == null) {
            this.P = onClickListener;
        }
    }

    public PbFirstFloorViewHolder t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            av7 av7Var = this.c;
            if (av7Var == null || av7Var.o0() == null) {
                return null;
            }
            return this.c.o0();
        }
        return (PbFirstFloorViewHolder) invokeV.objValue;
    }

    public void t0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, yVar) == null) {
            this.S = yVar;
        }
    }

    public final int u(bs7 bs7Var, ArrayList<uo> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, bs7Var, arrayList)) == null) {
            if (this.I || bs7Var == null || ListUtils.isEmpty(bs7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (bs7Var != null && bs7Var.r0() && this.G) ? 0 : -1;
            } else if (this.a.w() == null || !this.a.w().C0()) {
                if (this.a.P4() == null || !this.a.P4().J0()) {
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
                    return !z ? bs7Var.r0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void u0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onLongClickListener) == null) {
            this.V = onLongClickListener;
        }
    }

    public final List<uo> v(bs7 bs7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, bs7Var)) == null) {
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
                uo uoVar = (uo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (uoVar instanceof PostData) {
                    ((PostData) uoVar).N = false;
                }
                arrayList.add(new az7());
            } else {
                uo uoVar2 = (uo) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (uoVar2 instanceof PostData) {
                    ((PostData) uoVar2).N = true;
                }
            }
            os7 os7Var = new os7(os7.i);
            os7Var.a = bs7Var.T().c;
            arrayList.add(0, os7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void v0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.b.getHeaderViewsCount() : invokeV.intValue;
    }

    public void w0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, onClickListener) == null) {
            this.Q = onClickListener;
        }
    }

    public uo x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i)) == null) ? this.b.G(i) : (uo) invokeI.objValue;
    }

    public void x0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public BdUniqueId y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048642, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void y0(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, dt7Var) == null) {
            this.U = dt7Var;
        }
    }

    public PbFirstFloorCommentAndPraiseAdapter z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public void z0() {
        nv7 nv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || (nv7Var = this.i) == null) {
            return;
        }
        nv7Var.e0(2);
    }
}
