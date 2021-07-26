package d.a.q0.h2.o.f;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.q;
import d.a.q0.h2.h.l;
import d.a.q0.h2.h.p;
import d.a.q0.h2.h.v;
import d.a.q0.h2.k.e.m;
import d.a.q0.h2.k.e.n0;
import d.a.q0.h3.h0.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class a extends d.a.q0.h2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f58329a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoAndReplyFragment f58330b;

    /* renamed from: c  reason: collision with root package name */
    public BdTypeRecyclerView f58331c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.h2.h.e f58332d;

    /* renamed from: e  reason: collision with root package name */
    public final List<d.a.d.k.e.a> f58333e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f58334f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f58335g;

    /* renamed from: h  reason: collision with root package name */
    public String f58336h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f58337i;
    public boolean j;
    public int k;
    public int l;

    public a(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.f58329a = BdUniqueId.gen();
        this.f58333e = new ArrayList();
        this.f58334f = true;
        this.f58336h = null;
        this.f58337i = true;
        this.j = false;
        this.k = -1;
        this.l = -1;
        this.f58330b = detailInfoAndReplyFragment;
        this.f58331c = bdTypeRecyclerView;
    }

    public abstract void A(d.a.q0.h2.h.e eVar);

    public void B(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
        }
    }

    public abstract void C(d.a.q0.h2.h.e eVar);

    public abstract void D(String str);

    public final void E() {
        d.a.q0.h2.h.e eVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (eVar = this.f58332d) == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> E = eVar.E();
        ArrayList<o> e2 = this.f58332d.e();
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
                int z4 = next3.getAdvertAppInfo().z4();
                if (z4 != 0) {
                    d.a.q0.w2.i0.d.j(next3, z4);
                    if (z4 != 28 && z4 != 31) {
                        next3.getAdvertAppInfo().T3 = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + z4);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            o oVar3 = (o) sparseArray.get(sparseArray.keyAt(i2));
            if (oVar3 != null && (oVar2 = (o) hashMap.put(oVar3.C0(), oVar3)) != null) {
                d.a.q0.w2.i0.d.j(oVar2, 30);
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
            if (this.f58332d.m() != null) {
                oVar4.E0 = this.f58332d.m().getId();
            }
            if (this.f58332d.N() != null) {
                oVar4.H0 = d.a.d.e.m.b.f(this.f58332d.N().d0(), 0L);
            }
            d.a.q0.h2.h.e eVar2 = this.f58332d;
            if (eVar2 != null && eVar2.x() != null) {
                oVar4.I0 = this.f58332d.x().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f58332d.X;
            if (position >= E.size()) {
                oVar4.K0 = position;
                d.a.q0.w2.i0.d.k(oVar4, 2, position + i4, E.size());
                return;
            }
            if (!this.f58334f) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.q0.w2.i0.d.j(oVar4, 23);
            } else if (h(E, position)) {
                d.a.q0.w2.i0.d.j(oVar4, 1);
            } else {
                E.add(position, oVar4);
                TiebaStatic.eventStat(this.f58330b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().j4);
            }
        }
    }

    @Override // d.a.q0.h2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58335g : (ArrayList) invokeV.objValue;
    }

    public final void b(o oVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, oVar) == null) || oVar == null || this.f58332d == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().a4 = new d.a.p0.s.q.e();
        if (this.f58332d.x() != null) {
            oVar.getAdvertAppInfo().a4.f53297b = this.f58332d.x().a();
        }
        oVar.getAdvertAppInfo().a4.f53296a = oVar.E0();
        if (this.f58332d.m() != null && (m = this.f58332d.m()) != null) {
            oVar.getAdvertAppInfo().a4.f53299d = m.getId();
            oVar.getAdvertAppInfo().a4.f53300e = m.getFirst_class();
            oVar.getAdvertAppInfo().a4.f53301f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().a4.f53302g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().a4.f53303h = oVar.getAdvertAppInfo().Y3;
        oVar.getAdvertAppInfo().a4.f53304i = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.intValue;
    }

    public abstract n0 e();

    public abstract m f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, arrayList, i2)) == null) {
            for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
                if (arrayList.get(max) instanceof o) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.f58330b.y() != null) {
                return this.f58330b.y().q0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && (this.f58331c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f58331c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void l();

    public abstract void m();

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i2 = 0; i2 < this.f58335g.size(); i2++) {
                n nVar = this.f58335g.get(i2);
                if (nVar instanceof d.a.q0.h2.h.o) {
                    this.k = i2;
                    z = true;
                } else if ((nVar instanceof d.a.q0.h2.h.d) && ((d.a.q0.h2.h.d) nVar).b() == this.f58329a) {
                    this.l = i2;
                    z2 = true;
                }
            }
            if (!z) {
                this.k = -1;
            }
            if (z2) {
                return;
            }
            this.l = -1;
        }
    }

    public abstract void o(boolean z);

    public abstract void p(d.a.q0.h2.h.e eVar, boolean z, String str, boolean z2);

    public void q(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
            r(eVar, false);
        }
    }

    public void r(d.a.q0.h2.h.e eVar, boolean z) {
        o oVar;
        PostData postData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048598, this, eVar, z) == null) || eVar == null) {
            return;
        }
        this.f58332d = eVar;
        if (eVar != null && eVar.N() != null && eVar.N().H() != null) {
            this.f58336h = eVar.N().H().getUserId();
        }
        if (this.f58335g == null) {
            this.f58335g = new ArrayList<>();
        }
        this.f58335g.clear();
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
            this.f58335g.add(postData);
        }
        C(eVar);
        D(this.f58336h);
        if (d.a.p0.e1.b.e.d()) {
            if (this.f58331c != null) {
                ArrayList<n> arrayList = this.f58335g;
                ListUtils.removeSubList(arrayList, 1, arrayList.size());
            }
            this.f58331c.setData(this.f58335g);
            return;
        }
        int i2 = 0;
        if (!ListUtils.isEmpty(eVar.E()) && eVar.E().get(0) != null && eVar.N() != null) {
            eVar.N().H3(eVar.E().get(0).F());
            eVar.N().J3(eVar.E().get(0).G());
        }
        if (eVar.N() != null && eVar.N().L0() != null) {
            a2 a2Var = new a2();
            a2Var.w = eVar.N();
            a2Var.r = true;
            this.f58335g.add(a2Var);
        }
        p pVar = new p(eVar.N(), eVar.d());
        pVar.j(false);
        pVar.f57480f = false;
        this.f58335g.add(pVar);
        if (postData == null || postData.p0 == null || (eVar.m() != null && TextUtils.equals(eVar.m().getName(), this.f58330b.y().n0()) && this.f58330b.y().r0())) {
            z2 = false;
        } else {
            d.a.q0.h2.h.h hVar = new d.a.q0.h2.h.h(postData.p0);
            hVar.f57453f = this.f58330b.y().b1();
            this.f58335g.add(hVar);
            z2 = true;
        }
        if (!z2 && eVar.m() != null && !StringUtils.isNull(eVar.m().getName()) && (!TextUtils.equals(eVar.m().getName(), this.f58330b.y().n0()) || !this.f58330b.y().r0())) {
            d.a.q0.h2.h.g gVar = new d.a.q0.h2.h.g(eVar.m());
            gVar.k = this.f58330b.y().b1();
            gVar.f57450i = false;
            this.f58335g.add(gVar);
            pVar.j(false);
            pVar.f57480f = false;
        }
        if (eVar.N() != null && !StringUtils.isNull(eVar.N().X())) {
            v vVar = new v();
            vVar.f57505e = eVar.N();
            this.f58335g.add(vVar);
        } else if (eVar.N() != null && !StringUtils.isNull(eVar.o())) {
            eVar.N().s3(eVar.o());
            v vVar2 = new v();
            vVar2.f57505e = eVar.N();
            this.f58335g.add(vVar2);
        }
        d.a.q0.h2.h.o oVar2 = new d.a.q0.h2.h.o(d.a.q0.h2.h.o.l);
        b2 N = eVar.N();
        if (N != null) {
            N.Q0();
        }
        this.f58330b.y().Z0();
        oVar2.f57477h = j();
        oVar2.f57476g = eVar.f57443g;
        eVar.c();
        oVar2.f57478i = eVar.e0();
        oVar2.k = eVar.f57442f;
        A(eVar);
        this.f58335g.add(oVar2);
        if (eVar.K() == 4) {
            this.f58335g.add(new d.a.q0.h2.h.n());
        }
        E();
        o(i());
        Iterator<PostData> it2 = eVar.E().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.f58335g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && (!z || !d.a.d.e.p.j.z())) {
            l lVar = new l();
            lVar.D0 = TbadkCoreApplication.getInst().getContext().getString(R.string.mention_replyme_nodata);
            lVar.C0 = R.drawable.new_pic_emotion_03;
            lVar.E0 = -2;
            lVar.F0 = d.a.d.e.p.l.g(this.f58330b.getContext(), R.dimen.tbds74);
            this.f58335g.add(lVar);
        }
        p(eVar, this.j, this.f58336h, this.f58337i);
        if (eVar.x().b() == 0) {
            if (z3) {
                z(this.f58330b.v().h3());
                d.a.q0.h2.h.j jVar = new d.a.q0.h2.h.j();
                jVar.f57457e = TbadkCoreApplication.getInst().getResources().getString(R.string.list_has_no_more);
                this.f58335g.add(jVar);
            }
            List<o> X = eVar.X();
            int i3 = -1;
            if (X != null && !X.isEmpty()) {
                oVar = X.get(0);
                i3 = oVar.getPosition();
            }
            if (!ListUtils.isEmpty(eVar.f())) {
                d.a.q0.h2.h.d dVar = new d.a.q0.h2.h.d();
                dVar.e(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                dVar.d(this.f58329a);
                this.f58335g.add(dVar);
                int i4 = 1;
                for (q qVar : eVar.f()) {
                    if (X != null && i4 == i3) {
                        if (oVar != null) {
                            b(oVar);
                            this.f58335g.add(oVar);
                            i2++;
                            if (oVar.getType() != AdvertAppInfo.m4) {
                                i4++;
                            }
                        }
                        if (i2 < X.size()) {
                            o oVar3 = X.get(i2);
                            oVar = oVar3;
                            i3 = oVar3.getPosition();
                        }
                    }
                    this.f58335g.add(qVar);
                    i4++;
                    if (i4 == 4 && eVar.B() != null) {
                        this.f58335g.add(eVar.B());
                        i4++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f58331c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.f58335g);
        }
        n();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.j = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f58334f = z;
        }
    }

    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
        }
    }

    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, zVar) == null) {
        }
    }

    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onLongClickListener) == null) {
        }
    }

    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, fVar) == null) {
        }
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void z(View.OnClickListener onClickListener);
}
