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
public class xt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jr7 A;
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
    public ls7 U;
    public View.OnLongClickListener V;
    public SortSwitchButton.f W;
    public final List<an> X;
    public final List<an> Y;
    public Runnable Z;
    public PbFragment a;
    public int a0;
    public BdTypeListView b;
    public int b0;
    public hu7 c;
    public int c0;
    public PbFirstFloorCommentAndPraiseAdapter d;
    public ThreadData d0;
    public PbFirstFloorEnterForumAdapter e;
    public List<PostData> e0;
    public PbFirstFloorItemAdapter f;
    public final CustomMessageListener f0;
    public vv7 g;
    public CustomMessageListener g0;
    public gv7 h;
    public final CustomMessageListener h0;
    public uu7 i;
    public final View.OnClickListener i0;
    public gv7 j;
    public CustomMessageListener j0;
    public bu7 k;
    public List<an> k0;
    public gy7 l;
    public dz5 m;
    public an n;
    public an o;
    public an p;
    public an q;
    public an r;
    public dv7 s;
    public ev7 t;
    public cv7 u;
    public PbReplyLoadMoreAdapter v;
    public ArrayList<ys7> w;
    public yt7 x;
    public ou7 y;
    public zs7 z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xt7 xt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var, Integer.valueOf(i)};
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
            this.a = xt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof mi8)) {
                return;
            }
            mi8 mi8Var = (mi8) customResponsedMessage.getData();
            if (this.a.d0 == null || this.a.d0.funAdData != mi8Var) {
                return;
            }
            this.a.d0.funAdData.m(true);
            this.a.b.setData(this.a.C);
            this.a.Y();
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(xt7 xt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var, Integer.valueOf(i)};
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
            this.a = xt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2004015 && (customResponsedMessage.getData() instanceof di8)) {
                AbsDelegateAdapterList a = ((di8) customResponsedMessage.getData()).a();
                Iterator<an<?, ?>> it = a.iterator();
                while (it.hasNext()) {
                    an<?, ?> next = it.next();
                    if (next instanceof du7) {
                        ((du7) next).a0(this.a.a);
                        if (next instanceof ys7) {
                            this.a.w.add((ys7) next);
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
        public final /* synthetic */ xt7 a;

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
                    this.a.a.Y();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(xt7 xt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var, Integer.valueOf(i)};
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
            this.a = xt7Var;
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

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xt7 a;

        public d(xt7 xt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.A == null || this.a.A.T() == null) {
                return;
            }
            this.a.a.O5().T0().v();
            TiebaStatic.log(new StatisticItem("c12040"));
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ xt7 b;

        public e(xt7 xt7Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xt7Var;
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
        public final /* synthetic */ xt7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(xt7 xt7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xt7Var, Integer.valueOf(i)};
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
            this.a = xt7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.k0)) {
                this.a.n();
                xt7 xt7Var = this.a;
                xt7Var.f0(xt7Var.A, false);
            }
        }
    }

    public xt7(PbFragment pbFragment, BdTypeListView bdTypeListView) {
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
        K(pbFragment, bdTypeListView);
        pbFragment.registerListener(this.h0);
        this.b0 = pi.i(this.a.getContext()) / 3;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdTypeListView bdTypeListView = this.b;
            if (bdTypeListView == null || bdTypeListView.getData() == null) {
                return -1;
            }
            for (int i = 0; i < this.b.getData().size(); i++) {
                nn nnVar = this.b.getData().get(i);
                if (nnVar != null && nnVar.getType() == wr7.h) {
                    return i;
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void A0() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (i = this.c0) <= 0 || P(this.C, i) == null) {
            return;
        }
        this.c0 = -1;
        this.b.setData(this.C);
        Y();
    }

    public int B(jr7 jr7Var, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, jr7Var, arrayList, z)) == null) {
            if (jr7Var == null || jr7Var.F() == null || jr7Var.D() == null || jr7Var.F().size() == 0 || jr7Var.O() == null || arrayList == null || !jr7Var.D().Q0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (jr7Var.F().get(0) == null || jr7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (jr7Var.y() == null || jr7Var.y().a() != jr7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public int C(jr7 jr7Var, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048579, this, jr7Var, arrayList, z)) == null) {
            if (jr7Var == null || jr7Var.F() == null || jr7Var.E() == null || jr7Var.F().size() == 0 || jr7Var.O() == null || arrayList == null || !jr7Var.E().Q0()) {
                return -1;
            }
            int size = arrayList.size();
            if (z) {
                return (jr7Var.F().get(0) == null || jr7Var.F().get(0).B() != 1) ? -1 : 1;
            } else if (size == 0) {
                return 0;
            } else {
                return (jr7Var.y() == null || jr7Var.y().a() != jr7Var.y().h()) ? -1 : 0;
            }
        }
        return invokeLLZ.intValue;
    }

    public ArrayList<PostData> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.B : (ArrayList) invokeV.objValue;
    }

    public final int E(jr7 jr7Var, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, jr7Var, arrayList, z)) == null) {
            if (jr7Var == null || ListUtils.isEmpty(jr7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (jr7Var == null || !jr7Var.r0()) ? -1 : 0;
            }
            arrayList.size();
            if (z) {
                return (jr7Var.F().get(0) == null || jr7Var.F().get(0).B() != 1) ? -1 : 1;
            }
            return 0;
        }
        return invokeLLZ.intValue;
    }

    public final int F(jr7 jr7Var, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jr7Var, arrayList)) == null) {
            int i = -1;
            if (jr7Var == null || jr7Var.y() == null) {
                return -1;
            }
            int i2 = 0;
            boolean z = jr7Var.y().c() == 1;
            int size = arrayList.size();
            if (z && this.E) {
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (arrayList.get(i2) instanceof wr7) {
                        i = i2 + 1;
                        break;
                    } else {
                        i2++;
                    }
                }
                return jr7Var.L() == 4 ? i + 1 : i;
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a0 : invokeV.intValue;
    }

    public final ArrayList<nn> H(List<nn> list, List<nn> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, list2)) == null) {
            ArrayList<nn> arrayList = new ArrayList<>(list.size() + list2.size() + 2);
            arrayList.addAll(list);
            pr7 pr7Var = new pr7();
            PbListView X0 = this.a.O5().X0();
            if (X0 != null && X0.n()) {
                pr7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0db2);
                pr7Var.b = true;
            } else {
                pr7Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f09cf);
                pr7Var.b = false;
            }
            arrayList.add(pr7Var);
            gz5 gz5Var = new gz5();
            gz5Var.a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f5b);
            gz5Var.needTopMargin = false;
            arrayList.add(gz5Var);
            arrayList.addAll(list2);
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public View I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            hu7 hu7Var = this.c;
            if (hu7Var == null || hu7Var.o0() == null) {
                return null;
            }
            if (this.c.o0().u != null && this.c.o0().u.isShown()) {
                return this.c.o0().u;
            }
            return this.c.o0().t;
        }
        return (View) invokeV.objValue;
    }

    public final void J(ArrayList<nn> arrayList, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, arrayList, bool) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        int i = uw4.i();
        int j = uw4.j() - 1;
        if (bool.booleanValue()) {
            nn nnVar = arrayList.get(0);
            if ((nnVar instanceof PostData) && ((PostData) nnVar).B() == 1) {
                j++;
            }
        }
        int k = uw4.k() + 1;
        PbFragment pbFragment = this.a;
        if (pbFragment != null && pbFragment.F() != null && this.a.F().b2() == 3) {
            this.e0.clear();
        }
        Q(j, i, k, arrayList);
    }

    public void K(PbFragment pbFragment, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, pbFragment, bdTypeListView) == null) {
            hu7 hu7Var = new hu7(pbFragment, PostData.z0);
            this.c = hu7Var;
            hu7Var.B0(pbFragment);
            this.d = new PbFirstFloorCommentAndPraiseAdapter(pbFragment, xr7.f);
            this.e = new PbFirstFloorEnterForumAdapter(pbFragment, lr7.i);
            this.f = new PbFirstFloorItemAdapter(pbFragment.getContext(), mr7.c);
            this.g = new vv7(pbFragment, er7.c);
            this.h = new gv7(pbFragment, wr7.h);
            this.i = new uu7(pbFragment, rr7.c);
            this.j = new gv7(pbFragment, wr7.i);
            bu7 bu7Var = new bu7(pbFragment, PostData.A0);
            this.k = bu7Var;
            bu7Var.Q0(pbFragment);
            this.n = s98.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.u);
            this.o = s98.l().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.w);
            this.p = ar6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.C);
            this.q = ar6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.D);
            this.r = ar6.e().a(pbFragment.getBaseFragmentActivity(), AdvertAppInfo.F);
            this.u = new cv7(pbFragment, tr7.O0);
            this.s = new dv7(pbFragment, bv7.L0);
            this.t = new ev7(pbFragment, tp4.R0);
            this.v = new PbReplyLoadMoreAdapter(pbFragment, PostData.G0);
            this.l = new gy7(pbFragment, hy7.a);
            this.m = new dz5(pbFragment.getPageContext());
            this.x = new yt7(pbFragment, fo4.e);
            this.y = new ou7(pbFragment, pbFragment.getUniqueId());
            zs7 zs7Var = new zs7(pbFragment, pbFragment.getUniqueId(), this.b);
            this.z = zs7Var;
            this.X.addAll(zs7Var.a());
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
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2004015, new di8(pbFragment.getPageContext().getPageActivity(), new AbsDelegateAdapterList()));
            CustomMessage customMessage = new CustomMessage(2004015);
            customMessage.setTag(pbFragment.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            bdTypeListView.a(this.X);
        }
    }

    public final void L(@NonNull jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jr7Var) == null) {
            this.c.s(jr7Var);
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
            this.k.s(jr7Var);
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
            if (anVar != null && (anVar instanceof o98)) {
                ((o98) anVar).j(this.D);
            }
            Iterator<ys7> it = this.w.iterator();
            while (it.hasNext()) {
                ys7 next = it.next();
                if (next != null) {
                    next.s(jr7Var);
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
            this.h.s(jr7Var);
            this.g.s(jr7Var);
            this.j.s(jr7Var);
            this.s.s(jr7Var);
            this.t.s(jr7Var);
            this.x.f0(jr7Var);
            this.x.e0(this.a.t1);
            this.y.d0(jr7Var);
            this.z.f(jr7Var);
        }
    }

    public final nn M(ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, arrayList, i)) == null) {
            if (this.A == null) {
                return null;
            }
            ni8 k1 = this.a.F().k1();
            if (k1 == null) {
                k1 = this.A.z();
            }
            if (k1 == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert T0 = k1.T0();
            if (T0 != null) {
                T0.setAdvertAppInfo(k1.getAdvertAppInfo());
            }
            int m = k1.getAdvertAppInfo().m();
            if (m != 0) {
                eb8.j(k1, m);
                if (m != 28 && m != 31) {
                    k1.getAdvertAppInfo().c = -1001;
                }
                return null;
            }
            if (this.A.l() != null) {
                k1.K0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                k1.N0 = ng.g(this.A.O().getId(), 0L);
            }
            jr7 jr7Var = this.A;
            if (jr7Var != null && jr7Var.y() != null) {
                k1.O0 = this.A.y().a();
            }
            l(k1);
            if (i >= 0) {
                gd7.b(arrayList, k1, i);
                return k1;
            }
            return null;
        }
        return (nn) invokeLI.objValue;
    }

    public final boolean N(jr7 jr7Var, ArrayList<nn> arrayList, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{jr7Var, arrayList, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            ArrayList arrayList2 = new ArrayList();
            if (!ListUtils.isEmpty(jr7Var.f()) && jr7Var.f().size() > 2) {
                int min = Math.min(jr7Var.f().size(), 7);
                for (int i5 = 0; i5 < min; i5++) {
                    fo4 fo4Var = jr7Var.f().get(i5);
                    if (!z2 && i5 == 0) {
                        fo4Var.m(true);
                    }
                    if (fo4Var.getThreadVideoInfo() == null) {
                        if (i5 == min - 1) {
                            fo4Var.s(true);
                        }
                    } else if (i5 == min - 2) {
                        fo4Var.s(true);
                    } else if (i5 == min - 1) {
                        fo4Var.o(true);
                    }
                    arrayList2.add(fo4Var);
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

    public final nn O(jr7 jr7Var, ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLLI;
        er7 er7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048591, this, jr7Var, arrayList, i)) == null) {
            if (i < 0 || jr7Var == null || !jr7Var.k || (er7Var = jr7Var.l) == null) {
                return null;
            }
            ListUtils.add(arrayList, i, er7Var);
            return er7Var;
        }
        return (nn) invokeLLI.objValue;
    }

    public final nn P(ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLI;
        jr7 jr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, arrayList, i)) == null) {
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && i > 0 && (jr7Var = this.A) != null && jr7Var.n0()) {
                String d2 = fr6.e().d("pb_banner");
                if (this.d0 == null && zq6.m().w(d2)) {
                    ThreadData threadData = new ThreadData();
                    this.d0 = threadData;
                    threadData.funAdData = new mi8();
                    jr7 jr7Var2 = this.A;
                    if (jr7Var2 != null) {
                        this.d0.funAdData.j(jr7Var2.m());
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

    public final void Q(int i, int i2, int i3, ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), arrayList}) == null) || ListUtils.isEmpty(arrayList) || i < 0 || i2 < 1) {
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
                    mi8 mi8Var = new mi8();
                    jr7 jr7Var = this.A;
                    mi8Var.j(jr7Var != null ? jr7Var.m() : "");
                    jr7 jr7Var2 = this.A;
                    mi8Var.n(jr7Var2 != null ? jr7Var2.Q() : "");
                    mi8Var.k(true);
                    postData.t0 = mi8Var;
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
        mi8 mi8Var2 = new mi8();
        jr7 jr7Var3 = this.A;
        mi8Var2.j(jr7Var3 != null ? jr7Var3.m() : "");
        jr7 jr7Var4 = this.A;
        mi8Var2.n(jr7Var4 != null ? jr7Var4.Q() : "");
        mi8Var2.k(true);
        postData2.t0 = mi8Var2;
        listIterator.add(postData2);
        this.e0.add(postData2);
    }

    public final nn R(jr7 jr7Var, ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLLI;
        lr7 lr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, jr7Var, arrayList, i)) == null) {
            if (jr7Var.l() == null || StringUtils.isNull(jr7Var.l().getName())) {
                return null;
            }
            if (TextUtils.equals(jr7Var.l().getName(), this.a.F().q1()) && this.a.F().w1()) {
                return null;
            }
            if (!this.a.v0() && !ListUtils.isEmpty(jr7Var.p())) {
                lr7Var = new lr7(jr7Var.p().get(0));
            } else {
                lr7Var = new lr7(jr7Var.l());
            }
            lr7Var.g = this.a.F().j2();
            ListUtils.add(arrayList, i + 1, lr7Var);
            return lr7Var;
        }
        return (nn) invokeLLI.objValue;
    }

    public final nn S(jr7 jr7Var, PostData postData, ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048595, this, jr7Var, postData, arrayList, i)) == null) {
            mr7 mr7Var = null;
            if (jr7Var.l() == null || StringUtils.isNull(jr7Var.l().getName()) || !TextUtils.equals(jr7Var.l().getName(), this.a.F().q1()) || !this.a.F().w1()) {
                if (postData != null) {
                    if (postData.i0 != null) {
                        mr7Var = new mr7(postData.i0);
                    }
                } else {
                    PostData postData2 = this.O;
                    if (postData2 != null && postData2.i0 != null) {
                        mr7Var = new mr7(this.O.i0);
                    }
                }
                if (mr7Var != null) {
                    mr7Var.b = this.a.F().j2();
                    ListUtils.add(arrayList, i + 1, mr7Var);
                }
                return mr7Var;
            }
            return null;
        }
        return (nn) invokeLLLI.objValue;
    }

    public final pu7 T(ArrayList<nn> arrayList, nn nnVar, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048596, this, arrayList, nnVar, i, i2)) == null) {
            pu7 B = this.A.B();
            if (B != null) {
                if (nnVar != null) {
                    if (i2 >= 0 || nnVar.getType() == AdvertAppInfo.w) {
                        i2 = nnVar.getType() != AdvertAppInfo.w ? i2 + 1 : -1;
                    } else {
                        i2 = i + 2;
                    }
                }
                if (i2 <= 0 || !(B instanceof pu7)) {
                    return null;
                }
                ListUtils.add(arrayList, i2, B);
                return B;
            }
            return null;
        }
        return (pu7) invokeLLII.objValue;
    }

    public final void U(jr7 jr7Var, ArrayList<nn> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048597, this, jr7Var, arrayList, i) == null) {
            wr7 wr7Var = new wr7(wr7.h);
            ThreadData O = jr7Var.O();
            if (O != null) {
                O.getReply_num();
            }
            wr7Var.d = this.a.j6();
            wr7Var.c = jr7Var.g;
            jr7Var.c();
            wr7Var.e = jr7Var.g0();
            wr7Var.g = jr7Var.f;
            ListUtils.add(arrayList, i, wr7Var);
            if (jr7Var.L() == 4) {
                ListUtils.add(arrayList, i + 1, new vr7());
            }
        }
    }

    public final nn V(ArrayList<nn> arrayList, int i) {
        InterceptResult invokeLI;
        PbModel F;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048598, this, arrayList, i)) == null) {
            if (i < 0 || (F = this.a.F()) == null || TextUtils.isEmpty(F.V1())) {
                return null;
            }
            ni8 ni8Var = new ni8();
            l(ni8Var);
            ListUtils.add(arrayList, i + 1, ni8Var);
            return ni8Var;
        }
        return (nn) invokeLI.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.a0 = A();
            if (this.b.getAdapter2() instanceof en) {
                this.b.getAdapter2().notifyDataSetChanged();
            }
            PbFragment pbFragment = this.a;
            if (pbFragment == null || pbFragment.O5() == null) {
                return;
            }
            this.a.O5().b2();
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            if (i == 1) {
                hu7 hu7Var = this.c;
                if (hu7Var != null) {
                    hu7Var.u0();
                }
                an anVar = this.o;
                if (anVar instanceof j98) {
                    ((j98) anVar).onPause();
                }
                an anVar2 = this.p;
                if (anVar2 instanceof j98) {
                    ((j98) anVar2).onPause();
                }
                an anVar3 = this.r;
                if (anVar3 instanceof j98) {
                    ((j98) anVar3).onPause();
                }
                cu7.a().j(this.a.N());
                l85.a().d();
            } else if (i == 2) {
                hu7 hu7Var2 = this.c;
                if (hu7Var2 != null) {
                    hu7Var2.w0();
                }
                an anVar4 = this.o;
                if (anVar4 instanceof j98) {
                    ((j98) anVar4).onResume();
                }
                an anVar5 = this.p;
                if (anVar5 instanceof j98) {
                    ((j98) anVar5).onResume();
                }
                an anVar6 = this.r;
                if (anVar6 instanceof j98) {
                    ((j98) anVar6).onResume();
                }
                e0(false);
                d0();
            } else if (i != 3) {
            } else {
                hu7 hu7Var3 = this.c;
                if (hu7Var3 != null) {
                    hu7Var3.v0();
                }
                an anVar7 = this.o;
                if (anVar7 instanceof j98) {
                    ((j98) anVar7).onDestroy();
                }
                an anVar8 = this.p;
                if (anVar8 instanceof j98) {
                    ((j98) anVar8).onDestroy();
                }
                an anVar9 = this.r;
                if (anVar9 instanceof j98) {
                    ((j98) anVar9).onDestroy();
                }
                cu7.a().d();
            }
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            qg.a().removeCallbacks(this.Z);
            gv7 gv7Var = this.h;
            if (gv7Var != null) {
                gv7Var.onDestroy();
            }
            gv7 gv7Var2 = this.j;
            if (gv7Var2 != null) {
                gv7Var2.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.d;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
            vv7 vv7Var = this.g;
            if (vv7Var != null) {
                vv7Var.onDestroy();
            }
        }
    }

    public void b0(boolean z) {
        hu7 hu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z) == null) || (hu7Var = this.c) == null) {
            return;
        }
        hu7Var.t0(z);
    }

    public final void c0(boolean z, boolean z2, int i, List<nn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), list}) == null) || z || z2) {
            return;
        }
        if ((!this.J && !this.I) || i == -1 || ListUtils.isEmpty(list) || this.K) {
            return;
        }
        this.Z = new e(this, list);
        qg.a().post(this.Z);
    }

    public void d0() {
        PostData postData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.A == null || (postData = this.O) == null || postData.O() == null || this.c.o0() == null) {
            return;
        }
        l85.a().c(this.A.Q(), this.A.m(), this.O.O(), this.c.o0().o);
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048607, this, z) == null) || this.a.O5() == null || this.a.N() == null || this.a.N().M0() == null) {
            return;
        }
        cu7.a().g(this.a.N().M0().A2(), this.h.c0(), this.a.O5().Z0(), this.a.N().getPageStayDurationItem(), z, this.z.b(), this.a.getListView());
    }

    public void f0(jr7 jr7Var, boolean z) {
        boolean z2;
        PostData postData;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        boolean z7;
        int i2;
        pu7 pu7Var;
        List<nn> list;
        int i3;
        boolean z8;
        nn nnVar;
        int i4;
        PostData postData2;
        PostData postData3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048608, this, jr7Var, z) == null) || jr7Var == null) {
            return;
        }
        this.A = jr7Var;
        if (!UbsABTestHelper.isPbCommentFunAdABTest()) {
            z0();
        }
        if (this.B == null) {
            this.B = new ArrayList<>();
        }
        this.B.clear();
        jr7 jr7Var2 = this.A;
        if (jr7Var2 != null && jr7Var2.F() != null && this.A.F().size() > 0) {
            this.B.addAll(this.A.F());
        }
        if (jr7Var.O() != null && jr7Var.O().getAuthor() != null) {
            this.N = jr7Var.O().getAuthor().getUserId();
        }
        if (this.c == null) {
            return;
        }
        L(jr7Var);
        ArrayList<nn> arrayList = new ArrayList<>(jr7Var.F());
        PostData p = p(arrayList);
        boolean z9 = p != null;
        if (!gr6.f() && UbsABTestHelper.isPbCommentFunAdABTest() && this.A.n0()) {
            J(arrayList, Boolean.valueOf(z9));
        }
        if (p != null) {
            this.O = p;
        }
        if (this.G || p == null) {
            z2 = false;
        } else {
            arrayList.remove(p);
            if (jr7Var.r0() && p.Q() != null) {
                p.F0(null);
            }
            z9 = true;
            z2 = true;
        }
        if (z9 || jr7Var.j() == null) {
            postData = p;
            z3 = z2;
        } else {
            PostData j = jr7Var.j();
            if (!this.G && jr7Var.r0() && j.Q() != null) {
                j.F0(null);
            }
            postData = (this.G || (postData3 = this.O) == null || j.g0 != null) ? j : postData3;
            z9 = true;
            z3 = true;
        }
        o(arrayList);
        if (this.a.C5()) {
            if (jr7Var.F().size() > 0 && (postData2 = jr7Var.F().get(0)) != null && postData2.B() == 1 && !ListUtils.isEmpty(arrayList)) {
                arrayList.remove(0);
            }
        } else {
            int B = B(this.A, arrayList, this.G);
            if (B >= 0) {
                ListUtils.add(arrayList, B, this.A.D());
            }
        }
        int C = C(this.A, arrayList, this.G);
        if (C >= 0) {
            ListUtils.add(arrayList, C, this.A.E());
        }
        nh8.f(arrayList, 1);
        int z10 = z(jr7Var, arrayList);
        if (z10 >= 0) {
            U(jr7Var, arrayList, z10);
            z4 = true;
        } else {
            z4 = false;
        }
        int F = F(jr7Var, arrayList);
        if (F >= 0) {
            rr7 rr7Var = new rr7(rr7.c);
            rr7Var.b(true);
            ListUtils.add(arrayList, F, rr7Var);
        }
        int t = t(jr7Var, arrayList);
        List<nn> u = u(jr7Var);
        if (!ListUtils.isEmpty(u) && t >= 0) {
            nn nnVar2 = (nn) ListUtils.getItem(arrayList, t);
            if (nnVar2 instanceof PostData) {
                ((PostData) nnVar2).P = true;
            }
            ListUtils.addAll(arrayList, t, u);
            z4 = true;
        }
        int E = z9 ? E(jr7Var, arrayList, this.G) : -1;
        if (E < 0 || jr7Var.S() == null) {
            if (postData != null) {
                postData.O = true;
            }
            z5 = z4;
            z6 = false;
        } else {
            ListUtils.add(arrayList, E, jr7Var.S());
            z5 = true;
            z6 = true;
        }
        boolean z11 = S(jr7Var, postData, arrayList, E) != null;
        if (z11) {
            E++;
        }
        if (!z11 && R(jr7Var, arrayList, E) != null) {
            E++;
        }
        if (O(jr7Var, arrayList, E) != null) {
            E++;
        }
        if (z9) {
            nn V = V(arrayList, E);
            boolean z12 = V != null;
            if (z12) {
                z8 = z12;
                nnVar = V;
                i4 = -1;
            } else {
                i4 = E >= 0 ? E + 1 : t >= 0 ? t : z10 >= 0 ? z10 : -1;
                nnVar = M(arrayList, i4);
                z8 = nnVar != null;
            }
            boolean z13 = TbadkCoreApplication.getCurrentAccountInfo() == null || TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() != 1;
            if (z13 && this.A.n0()) {
                this.c0 = i4;
                if (P(arrayList, i4) != null) {
                    this.c0 = -1;
                    E++;
                }
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && z13) {
                i2 = i4;
                z7 = z8;
                pu7Var = null;
            } else {
                pu7 T = T(arrayList, nnVar, E, i4);
                if (T != null) {
                    if (!z8) {
                        i2 = i4;
                        pu7Var = T;
                        i = E;
                        z7 = true;
                    } else if (i4 > 0) {
                        i4++;
                    } else {
                        E++;
                    }
                }
                i2 = i4;
                pu7Var = T;
                z7 = z8;
            }
            i = E;
        } else {
            i = E;
            z7 = false;
            i2 = -1;
            pu7Var = null;
        }
        if (z9) {
            list = u;
            int i5 = i;
            i3 = t;
            boolean N = N(jr7Var, arrayList, z7, pu7Var != null, i2, i5, t, z10);
            if (pu7Var != null) {
                pu7Var.n = N;
            }
        } else {
            list = u;
            i3 = t;
        }
        this.c.z0(!z5);
        boolean y0 = y0(postData);
        if (this.H && !y0) {
            arrayList.remove(postData);
            this.H = false;
        }
        if (jr7Var.S() != null) {
            jr7Var.S().i(!z6);
        }
        if (this.b != null) {
            this.C = arrayList;
            List<nn> R = jr7Var.R();
            if (!ListUtils.isEmpty(R)) {
                this.b.setData(H(arrayList, R));
            } else {
                this.b.setData(this.C);
            }
        }
        c0(y0, z, i3, list);
        if (q(postData, arrayList, z3)) {
            List<nn> R2 = jr7Var.R();
            if (!ListUtils.isEmpty(R2)) {
                this.b.setData(H(arrayList, R2));
            } else {
                this.b.setData(arrayList);
            }
        }
    }

    public void g0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.D = z;
            this.c.setFromCDN(z);
            an anVar = this.o;
            if (anVar != null && (anVar instanceof o98)) {
                ((o98) anVar).j(z);
            }
            Iterator<ys7> it = this.w.iterator();
            while (it.hasNext()) {
                it.next().setFromCDN(z);
            }
        }
    }

    public void h0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.H = z;
        }
    }

    public void i0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.F = z;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.L = z;
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.I = z;
        }
    }

    public final void l(ni8 ni8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, ni8Var) == null) || ni8Var == null || this.A == null || ni8Var.getAdvertAppInfo() == null) {
            return;
        }
        ni8Var.getAdvertAppInfo().i = new tn4();
        if (this.A.y() != null) {
            ni8Var.getAdvertAppInfo().i.b = this.A.y().a();
        }
        ni8Var.getAdvertAppInfo().i.a = ni8Var.S0();
        if (this.A.l() != null && (l = this.A.l()) != null) {
            ni8Var.getAdvertAppInfo().i.c = l.getId();
            ni8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            ni8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ni8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        ni8Var.getAdvertAppInfo().i.g = ni8Var.getAdvertAppInfo().g;
        ni8Var.getAdvertAppInfo().i.h = false;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.J = z;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || this.a == null || n()) {
            return;
        }
        this.a.registerListener(this.j0);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.G = z;
        }
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.a == null) {
                return false;
            }
            this.k0 = new ArrayList();
            ArrayList<BdUniqueId> g = nh8.g();
            if (g == null || g.size() <= 0) {
                return false;
            }
            int size = g.size();
            for (int i = 0; i < size; i++) {
                yc7 b2 = de7.d().b(this.a.getPageContext(), g.get(i), 2);
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
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.K = z;
        }
    }

    public final void o(List<nn> list) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, list) == null) || list == null || (size = list.size()) <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            if (list.get(i) instanceof PostData) {
                PostData postData = (PostData) list.get(i);
                if (!TextUtils.isEmpty(postData.M())) {
                    ep4 ep4Var = new ep4();
                    ep4Var.g(postData.M());
                    list.set(i, ep4Var);
                }
            }
        }
    }

    public void o0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            this.R = onClickListener;
        }
    }

    public final PostData p(ArrayList<nn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, arrayList)) == null) {
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

    public void p0(boolean z) {
        bu7 bu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z) == null) || (bu7Var = this.k) == null) {
            return;
        }
        bu7Var.O0(z);
    }

    public final boolean q(PostData postData, ArrayList<nn> arrayList, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048624, this, postData, arrayList, z)) == null) {
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
                postData3.s0(1);
                ListUtils.add(arrayList, 0, postData3);
            }
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    public void q0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, onClickListener) == null) {
            this.P = onClickListener;
        }
    }

    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.z.b() : (View) invokeV.objValue;
    }

    public void r0(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, yVar) == null) {
            this.S = yVar;
        }
    }

    public ArrayList<nn> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.C : (ArrayList) invokeV.objValue;
    }

    public void s0(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, onLongClickListener) == null) {
            this.V = onLongClickListener;
        }
    }

    public final int t(jr7 jr7Var, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048630, this, jr7Var, arrayList)) == null) {
            if (this.I || jr7Var == null || ListUtils.isEmpty(jr7Var.F()) || arrayList == null || arrayList.size() <= 0) {
                return (jr7Var != null && jr7Var.r0() && this.G) ? 0 : -1;
            } else if (this.a.F() == null || !this.a.F().A1()) {
                if (this.a.O5() == null || !this.a.O5().P0()) {
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
                    return !z ? jr7Var.r0() ? 0 : -1 : i + 1;
                }
                return -1;
            } else {
                return -1;
            }
        }
        return invokeLL.intValue;
    }

    public void t0(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, fVar) == null) {
            this.W = fVar;
        }
    }

    public final List<nn> u(jr7 jr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, jr7Var)) == null) {
            if (jr7Var == null || jr7Var.T() == null || ListUtils.isEmpty(jr7Var.T().a)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            List<PostData> list = jr7Var.T().a;
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
            if (ListUtils.getCount(jr7Var.T().b) > 2) {
                nn nnVar = (nn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nnVar instanceof PostData) {
                    ((PostData) nnVar).N = false;
                }
                arrayList.add(new hy7());
            } else {
                nn nnVar2 = (nn) ListUtils.getItem(arrayList, arrayList.size() - 1);
                if (nnVar2 instanceof PostData) {
                    ((PostData) nnVar2).N = true;
                }
            }
            wr7 wr7Var = new wr7(wr7.i);
            wr7Var.a = jr7Var.T().c;
            arrayList.add(0, wr7Var);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void u0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, onClickListener) == null) {
            this.Q = onClickListener;
        }
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.b.getHeaderViewsCount() : invokeV.intValue;
    }

    public void v0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            this.T = onClickListener;
        }
    }

    public nn w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) ? this.b.G(i) : (nn) invokeI.objValue;
    }

    public void w0(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, ls7Var) == null) {
            this.U = ls7Var;
        }
    }

    public BdUniqueId x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i)) == null) {
            if (this.b.G(i) != null) {
                return this.b.G(i).getType();
            }
            return null;
        }
        return (BdUniqueId) invokeI.objValue;
    }

    public void x0() {
        uu7 uu7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || (uu7Var = this.i) == null) {
            return;
        }
        uu7Var.e0(2);
    }

    public PbFirstFloorCommentAndPraiseAdapter y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.d : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean y0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, postData)) == null) ? (this.a.F() == null || postData == null || postData.J() == null || !postData.J().equals(this.a.F().p2())) ? false : true : invokeL.booleanValue;
    }

    public final int z(jr7 jr7Var, ArrayList<nn> arrayList) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048642, this, jr7Var, arrayList)) == null) {
            if (jr7Var == null || ListUtils.isEmpty(jr7Var.F()) || ListUtils.isEmpty(arrayList) || ((PostData) ListUtils.getItem(jr7Var.F(), 0)) == null) {
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

    public final void z0() {
        jr7 jr7Var;
        ni8 ni8Var;
        ni8 ni8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || (jr7Var = this.A) == null || jr7Var.a0 || jr7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = jr7Var.F();
        ArrayList<ni8> e2 = this.A.e();
        if (gd7.e(F) || gd7.e(e2)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ni8> it = e2.iterator();
        while (it.hasNext()) {
            ni8 next = it.next();
            if (next != null && next.R0() != null) {
                sb.append(next.R0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<ni8> it2 = e2.iterator();
        while (it2.hasNext()) {
            ni8 next2 = it2.next();
            if (next2 != null) {
                next2.Q0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<ni8> it3 = e2.iterator();
        while (it3.hasNext()) {
            ni8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int m = next3.getAdvertAppInfo().m();
                if (m != 0) {
                    eb8.j(next3, m);
                    if (m != 28 && m != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        e2.clear();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            ni8 ni8Var3 = (ni8) sparseArray.valueAt(i);
            if (ni8Var3 != null && (ni8Var2 = (ni8) hashMap.put(ni8Var3.Q0(), ni8Var3)) != null) {
                eb8.j(ni8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (ni8Var = (ni8) entry.getValue()) != null) {
                sparseArray.put(ni8Var.getPosition(), ni8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            gd7.a(arrayList, Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < gd7.i(arrayList); i3++) {
            ni8 ni8Var4 = (ni8) sparseArray.get(((Integer) gd7.d(arrayList, i3)).intValue());
            if (this.A.l() != null) {
                ni8Var4.K0 = this.A.l().getId();
            }
            if (this.A.O() != null) {
                ni8Var4.N0 = ng.g(this.A.O().getId(), 0L);
            }
            jr7 jr7Var2 = this.A;
            if (jr7Var2 != null && jr7Var2.y() != null) {
                ni8Var4.O0 = this.A.y().a();
            }
            l(ni8Var4);
            int position = ni8Var4.getPosition() + this.A.Z;
            if (position >= gd7.i(F)) {
                ni8Var4.Q0 = position;
                eb8.k(ni8Var4, 2, position, gd7.i(F));
                return;
            }
            if (!this.G) {
                position--;
                ni8Var4.Q0 = position;
            }
            if (position < 0) {
                eb8.j(ni8Var4, 23);
            } else {
                gd7.b(F, ni8Var4, position);
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.getPageContext() != null && this.a.getPageContext().getContext() != null) {
                    TiebaStatic.eventStat(this.a.getPageContext().getContext(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ni8Var4.getAdvertAppInfo().p);
                }
            }
        }
    }
}
