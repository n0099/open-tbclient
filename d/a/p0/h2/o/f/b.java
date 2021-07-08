package d.a.p0.h2.o.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import d.a.o0.r.q.q;
import d.a.o0.z0.f0;
import d.a.o0.z0.i0;
import d.a.p0.h2.h.g;
import d.a.p0.h2.h.h;
import d.a.p0.h2.h.p;
import d.a.p0.h2.h.v;
import d.a.p0.h2.k.e.b0;
import d.a.p0.h2.k.e.j;
import d.a.p0.h2.k.e.j0;
import d.a.p0.h2.k.e.l;
import d.a.p0.h2.k.e.m;
import d.a.p0.h2.k.e.n0;
import d.a.p0.h2.k.e.z;
import d.a.p0.h3.h0.o;
import d.a.p0.w2.s;
import d.a.p0.w2.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class b extends d.a.p0.h2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public View.OnClickListener C;
    public View.OnClickListener D;
    public TbRichTextView.x E;
    public d.a.p0.h2.i.c F;
    public View.OnLongClickListener G;
    public SortSwitchButton.f H;
    public View.OnClickListener I;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f57773a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f57774b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f57775c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.h2.h.e f57776d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f57777e;

    /* renamed from: f  reason: collision with root package name */
    public m f57778f;

    /* renamed from: g  reason: collision with root package name */
    public f f57779g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f57780h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.p0.h2.o.f.c f57781i;
    public PbFirstFloorEnterForumAdapter j;
    public n0 k;
    public PbReplyLoadMoreAdapter l;
    public j0 m;
    public b0 n;
    public l o;
    public j p;
    public z q;
    public e r;
    public PbFirstFloorItemAdapter s;
    public d.a.c.k.e.a t;
    public d.a.c.k.e.a u;
    public boolean v;
    public ArrayList<n> w;
    public String x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f57782e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57782e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f57782e.g(11009)) {
                        this.f57782e.o(8);
                    }
                } else if (view.getId() == R.id.share_num_container && this.f57782e.g(11009)) {
                    this.f57782e.o(3);
                }
            }
        }
    }

    /* renamed from: d.a.p0.h2.o.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1438b extends f0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f57783a;

        public C1438b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57783a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return d.a.p0.h2.k.e.f1.b.c(this.f57783a.f57774b.getContext(), this.f57783a.h(), ShareSwitch.isOn() ? 1 : 6, this.f57783a.f57774b.y());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.o0.z0.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f57784a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f57785b;

        public c(b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57785b = bVar;
            this.f57784a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f57785b.f57774b.getContext(), this.f57784a, shareItem, false));
            }
        }
    }

    public b(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57773a = BdUniqueId.gen();
        this.f57777e = new ArrayList();
        this.v = true;
        this.x = null;
        this.y = true;
        this.z = false;
        this.A = -1;
        this.B = -1;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = new a(this);
        this.f57774b = detailInfoAndReplyFragment;
        this.f57775c = bdTypeRecyclerView;
        p();
    }

    public void A(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xVar) == null) {
            this.E = xVar;
        }
    }

    public void B(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
            this.G = onLongClickListener;
        }
    }

    public void C(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.H = fVar;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.D = onClickListener;
        }
    }

    public void E(d.a.p0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.F = cVar;
        }
    }

    public final void F() {
        d.a.p0.h2.h.e eVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (eVar = this.f57776d) == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> E = eVar.E();
        ArrayList<o> e2 = this.f57776d.e();
        if (e2 == null || e2.isEmpty() || E == null || E.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<o> it = e2.iterator();
        while (it.hasNext()) {
            o next = it.next();
            if (next != null && next.D0() != null) {
                sb.append(next.D0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<o> it2 = e2.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            if (next2 != null) {
                next2.K0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<o> it3 = e2.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int w4 = next3.getAdvertAppInfo().w4();
                if (w4 != 0) {
                    d.a.p0.w2.i0.d.j(next3, w4);
                    if (w4 != 28 && w4 != 31) {
                        next3.getAdvertAppInfo().N3 = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + w4);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.p0.w2.i0.d.j(oVar2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (oVar = (o) entry.getValue()) != null) {
                sparseArray.put(oVar.getPosition(), oVar);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i3)));
        }
        Collections.sort(arrayList);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            o oVar4 = (o) sparseArray.get(((Integer) arrayList.get(i4)).intValue());
            if (this.f57776d.m() != null) {
                oVar4.E0 = this.f57776d.m().getId();
            }
            if (this.f57776d.N() != null) {
                oVar4.H0 = d.a.c.e.m.b.f(this.f57776d.N().c0(), 0L);
            }
            d.a.p0.h2.h.e eVar2 = this.f57776d;
            if (eVar2 != null && eVar2.x() != null) {
                oVar4.I0 = this.f57776d.x().a();
            }
            f(oVar4);
            int position = oVar4.getPosition() + this.f57776d.X;
            if (position >= E.size()) {
                oVar4.K0 = position;
                d.a.p0.w2.i0.d.k(oVar4, 2, position + i4, E.size());
                return;
            }
            if (!this.v) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.p0.w2.i0.d.j(oVar4, 23);
            } else if (n(E, position)) {
                d.a.p0.w2.i0.d.j(oVar4, 1);
            } else {
                E.add(position, oVar4);
                TiebaStatic.eventStat(this.f57774b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().d4);
            }
        }
    }

    @Override // d.a.p0.h2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.w : (ArrayList) invokeV.objValue;
    }

    public final void f(o oVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, oVar) == null) || oVar == null || this.f57776d == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().U3 = new d.a.o0.r.q.e();
        if (this.f57776d.x() != null) {
            oVar.getAdvertAppInfo().U3.f52633b = this.f57776d.x().a();
        }
        oVar.getAdvertAppInfo().U3.f52632a = oVar.E0();
        if (this.f57776d.m() != null && (m = this.f57776d.m()) != null) {
            oVar.getAdvertAppInfo().U3.f52635d = m.getId();
            oVar.getAdvertAppInfo().U3.f52636e = m.getFirst_class();
            oVar.getAdvertAppInfo().U3.f52637f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().U3.f52638g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().U3.f52639h = oVar.getAdvertAppInfo().S3;
        oVar.getAdvertAppInfo().U3.f52640i = false;
    }

    public final boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f57774b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f57774b.z(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.p0.h2.h.e eVar = this.f57776d;
            if (eVar == null || eVar.N() == null) {
                return -1;
            }
            return this.f57776d.N().q();
        }
        return invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.B : invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.A : invokeV.intValue;
    }

    public n0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : (n0) invokeV.objValue;
    }

    public m l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57778f : (m) invokeV.objValue;
    }

    public PbFirstFloorCommentAndPraiseAdapter m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f57780h : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    public final boolean n(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i2)) == null) {
            for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
                if (arrayList.get(max) instanceof o) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            i0.b(new C1438b(this), new c(this, i2));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i2 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f57779g = new f(this.f57774b.v(), PostData.t0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f57774b.v(), p.j);
            this.f57780h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.I);
            this.f57781i = new d.a.p0.h2.o.f.c(this.f57774b.getContext(), v.f56957f);
            this.j = new PbFirstFloorEnterForumAdapter(this.f57774b.getContext(), g.l);
            this.k = new n0(this.f57774b.v(), d.a.p0.h2.h.o.l);
            this.n = new b0(this.f57774b.v(), d.a.p0.h2.h.j.f56912g, this.f57774b.getUniqueId());
            this.m = new j0(this.f57774b.v(), d.a.p0.h2.h.l.I0);
            this.o = new l(this.f57774b.v(), d.a.p0.h2.h.d.f56890g);
            j jVar = new j(this.f57774b.v(), q.P3);
            this.p = jVar;
            jVar.m0(true);
            this.q = new z(this.f57774b.v());
            m mVar = new m(this.f57774b.v(), PostData.u0);
            this.f57778f = mVar;
            mVar.Z0(this.f57774b.v());
            this.l = new PbReplyLoadMoreAdapter(this.f57774b.v(), PostData.A0);
            this.t = w.o().a(this.f57774b.v().getBaseFragmentActivity(), AdvertAppInfo.g4);
            this.u = w.o().a(this.f57774b.v().getBaseFragmentActivity(), AdvertAppInfo.i4);
            e eVar = new e(this.f57774b.getPageContext(), b2.f3, this.f57774b.getUniqueId());
            this.r = eVar;
            eVar.h0(this.f57775c);
            this.s = new PbFirstFloorItemAdapter(this.f57774b.getContext(), h.f56907g);
            this.f57777e.add(this.f57779g);
            this.f57777e.add(this.f57780h);
            this.f57777e.add(this.f57781i);
            this.f57777e.add(this.j);
            this.f57777e.add(this.k);
            this.f57777e.add(this.m);
            this.f57777e.add(this.n);
            this.f57777e.add(this.o);
            this.f57777e.add(this.p);
            this.f57777e.add(this.q);
            this.f57777e.add(this.t);
            this.f57777e.add(this.u);
            this.f57777e.add(this.f57778f);
            this.f57777e.add(this.l);
            this.f57777e.add(this.r);
            this.f57777e.add(this.s);
            this.f57777e.add(new PbPrivateTitleAdapter(this.f57774b.v()));
            this.f57775c.a(this.f57777e);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f57774b.y() != null) {
                return this.f57774b.y().i0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (this.f57775c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f57775c.getAdapter().notifyDataSetChanged();
        }
    }

    public void s() {
        f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fVar = this.f57779g) == null) {
            return;
        }
        fVar.L();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            n0 n0Var = this.k;
            if (n0Var != null) {
                n0Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.f57780h;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.w.size(); i2++) {
                n nVar = this.w.get(i2);
                if (nVar instanceof d.a.p0.h2.h.o) {
                    this.A = i2;
                    z = true;
                } else if ((nVar instanceof d.a.p0.h2.h.d) && ((d.a.p0.h2.h.d) nVar).b() == this.f57773a) {
                    this.B = i2;
                    z2 = true;
                }
            }
            if (!z) {
                this.A = -1;
            }
            if (z2) {
                return;
            }
            this.B = -1;
        }
    }

    public void v(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, eVar) == null) {
            w(eVar, false);
        }
    }

    public void w(d.a.p0.h2.h.e eVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048600, this, eVar, z) == null) || eVar == null) {
            return;
        }
        this.f57776d = eVar;
        if (eVar != null && eVar.N() != null && eVar.N().H() != null) {
            this.x = eVar.N().H().getUserId();
        }
        if (this.w == null) {
            this.w = new ArrayList<>();
        }
        this.w.clear();
        Iterator<PostData> it = eVar.E().iterator();
        while (true) {
            oVar = null;
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.A() == 1) {
                    break;
                }
            }
        }
        if (postData == null && eVar.j() != null) {
            postData = eVar.j();
        }
        if (postData != null) {
            this.w.add(postData);
        }
        this.f57779g.I0(eVar);
        this.f57779g.q(this.x);
        if (d.a.o0.c1.b.e.d()) {
            if (this.f57775c != null) {
                ArrayList<n> arrayList = this.w;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f57775c.setData(this.w);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.E()) && eVar.E().get(0) != null && eVar.N() != null) {
            eVar.N().E3(eVar.E().get(0).F());
            eVar.N().G3(eVar.E().get(0).G());
        }
        if (eVar.N() != null && eVar.N().K0() != null) {
            a2 a2Var = new a2();
            a2Var.w = eVar.N();
            a2Var.r = true;
            this.w.add(a2Var);
        }
        p pVar = new p(eVar.N(), eVar.d());
        pVar.j(false);
        pVar.f56936f = false;
        this.w.add(pVar);
        if (postData == null || postData.p0 == null || (eVar.m() != null && TextUtils.equals(eVar.m().getName(), this.f57774b.y().f0()) && this.f57774b.y().j0())) {
            z2 = false;
        } else {
            h hVar = new h(postData.p0);
            hVar.f56909f = this.f57774b.y().T0();
            this.w.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.m() != null && !StringUtils.isNull(eVar.m().getName()) && (!TextUtils.equals(eVar.m().getName(), this.f57774b.y().f0()) || !this.f57774b.y().j0())) {
            g gVar = new g(eVar.m());
            gVar.k = this.f57774b.y().T0();
            gVar.f56906i = false;
            this.w.add(gVar);
            pVar.j(false);
            pVar.f56936f = false;
        }
        d.a.p0.h2.h.o oVar2 = new d.a.p0.h2.h.o(d.a.p0.h2.h.o.l);
        b2 N = eVar.N();
        if (N != null) {
            N.P0();
        }
        this.f57774b.y().R0();
        oVar2.f56933h = q();
        oVar2.f56932g = eVar.f56899g;
        eVar.c();
        oVar2.f56934i = eVar.e0();
        oVar2.k = eVar.f56898f;
        this.k.t(eVar);
        this.w.add(oVar2);
        if (eVar.K() == 4) {
            this.w.add(new d.a.p0.h2.h.n());
        }
        F();
        d.a.c.k.e.a aVar = this.u;
        if (aVar != null && (aVar instanceof s)) {
            ((s) aVar).k(this.z);
        }
        Iterator<PostData> it2 = eVar.E().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.w.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !d.a.c.e.p.j.z())) {
            d.a.p0.h2.h.l lVar = new d.a.p0.h2.h.l();
            lVar.D0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.C0 = R.drawable.new_pic_emotion_03;
            lVar.E0 = -2;
            lVar.F0 = d.a.c.e.p.l.g(this.f57774b.getContext(), R.dimen.tbds74);
            this.w.add(lVar);
        }
        this.f57778f.t(eVar);
        this.f57778f.setFromCDN(this.z);
        this.f57778f.q(this.x);
        this.f57778f.c(this.y);
        this.f57778f.e(this.D);
        this.f57778f.m(this.C);
        this.f57778f.p(this.E);
        this.f57778f.d(this.G);
        this.f57778f.Y0(this.F);
        this.k.e(this.D);
        this.k.l0(this.H);
        this.l.j0(this.D);
        if (eVar.x().b() == 0) {
            if (z3) {
                this.n.j0(this.f57774b.v().d3());
                d.a.p0.h2.h.j jVar = new d.a.p0.h2.h.j();
                jVar.f56913e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.w.add(jVar);
            }
            List<o> X = eVar.X();
            int i3 = -1;
            if (X != null && !X.isEmpty()) {
                oVar = X.get(0);
                i3 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                d.a.p0.h2.h.d dVar = new d.a.p0.h2.h.d();
                dVar.e(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.d(this.f57773a);
                this.w.add(dVar);
                int i4 = 1;
                for (q qVar : eVar.f()) {
                    if (X != null && i4 == i3) {
                        if (oVar != null) {
                            f(oVar);
                            this.w.add(oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.g4) {
                                i4++;
                            }
                        }
                        if (i2 < X.size()) {
                            o oVar3 = X.get(i2);
                            oVar = oVar3;
                            i3 = oVar3.getPosition();
                        }
                    }
                    this.w.add(qVar);
                    i4++;
                    if (i4 == 4 && eVar.B() != null) {
                        this.w.add(eVar.B());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f57775c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.w);
        }
        u();
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.z = z;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.v = z;
        }
    }

    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.C = onClickListener;
        }
    }
}
