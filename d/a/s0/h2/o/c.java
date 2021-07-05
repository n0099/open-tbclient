package d.a.s0.h2.o;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.s0.h2.k.e.m;
import d.a.s0.h3.h0.o;
import d.a.s0.w2.s;
import d.a.s0.w2.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class c extends d.a.s0.h2.o.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ReplyFragment f60970a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f60971b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.h2.h.e f60972c;

    /* renamed from: d  reason: collision with root package name */
    public final List<d.a.c.k.e.a> f60973d;

    /* renamed from: e  reason: collision with root package name */
    public m f60974e;

    /* renamed from: f  reason: collision with root package name */
    public PbReplyLoadMoreAdapter f60975f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.k.e.a f60976g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.k.e.a f60977h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f60978i;
    public ArrayList<PostData> j;
    public ArrayList<n> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.x q;
    public d.a.s0.h2.i.c r;
    public View.OnLongClickListener s;

    public c(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60973d = new ArrayList();
        this.f60978i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.f60970a = replyFragment;
        this.f60971b = bdTypeRecyclerView;
        d();
    }

    @Override // d.a.s0.h2.o.h.a
    public ArrayList<n> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(o oVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oVar) == null) || oVar == null || this.f60972c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().U3 = new d.a.r0.r.q.e();
        if (this.f60972c.x() != null) {
            oVar.getAdvertAppInfo().U3.f55918b = this.f60972c.x().a();
        }
        oVar.getAdvertAppInfo().U3.f55917a = oVar.E0();
        if (this.f60972c.m() != null && (m = this.f60972c.m()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i2)) == null) {
            for (int max = Math.max(i2 - 4, 0); max < arrayList.size() && max < i2 + 4; max++) {
                if (arrayList.get(max) instanceof o) {
                    return true;
                }
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            m mVar = new m(this.f60970a.v(), PostData.u0);
            this.f60974e = mVar;
            mVar.Z0(this.f60970a.v());
            this.f60975f = new PbReplyLoadMoreAdapter(this.f60970a.v(), PostData.A0);
            this.f60976g = w.p().a(this.f60970a.v().getBaseFragmentActivity(), AdvertAppInfo.g4);
            this.f60977h = w.p().a(this.f60970a.v().getBaseFragmentActivity(), AdvertAppInfo.i4);
            this.f60973d.add(this.f60976g);
            this.f60973d.add(this.f60977h);
            this.f60973d.add(this.f60974e);
            this.f60973d.add(this.f60975f);
            this.f60971b.a(this.f60973d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.f60971b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.f60971b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f60972c = eVar;
        if (eVar != null && eVar.N() != null && eVar.N().H() != null) {
            this.l = eVar.N().H().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        d.a.s0.h2.h.e eVar2 = this.f60972c;
        if (eVar2 != null && eVar2.E() != null && this.f60972c.E().size() > 0) {
            this.j.addAll(this.f60972c.E());
        }
        this.f60974e.t(eVar);
        this.f60974e.setFromCDN(this.n);
        this.f60974e.q(this.l);
        this.f60974e.c(this.m);
        this.f60974e.e(this.p);
        this.f60974e.m(this.o);
        this.f60974e.p(this.q);
        this.f60974e.d(this.s);
        this.f60974e.Y0(this.r);
        this.f60975f.j0(this.p);
        n();
        d.a.c.k.e.a aVar = this.f60977h;
        if (aVar != null && (aVar instanceof s)) {
            ((s) aVar).k(this.n);
        }
        ArrayList<n> arrayList = new ArrayList<>(eVar.E());
        boolean z = false;
        PostData postData = null;
        Iterator<n> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            n next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.A() == 1) {
                    postData = postData2;
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.remove(postData);
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.f60971b;
        if (bdTypeRecyclerView != null) {
            this.k = arrayList;
            bdTypeRecyclerView.setData(arrayList);
        }
    }

    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.n = z;
        }
    }

    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f60978i = z;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void j(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, xVar) == null) {
            this.q = xVar;
        }
    }

    public void k(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onLongClickListener) == null) {
            this.s = onLongClickListener;
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void m(d.a.s0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.r = cVar;
        }
    }

    public final void n() {
        d.a.s0.h2.h.e eVar;
        o oVar;
        o oVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (eVar = this.f60972c) == null || eVar.Y || eVar.Z == 2) {
            return;
        }
        ArrayList<PostData> E = eVar.E();
        ArrayList<o> e2 = this.f60972c.e();
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
                    d.a.s0.w2.i0.d.i(next3, w4);
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
                d.a.s0.w2.i0.d.i(oVar2, 30);
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
            if (this.f60972c.m() != null) {
                oVar4.E0 = this.f60972c.m().getId();
            }
            if (this.f60972c.N() != null) {
                oVar4.H0 = d.a.c.e.m.b.f(this.f60972c.N().c0(), 0L);
            }
            d.a.s0.h2.h.e eVar2 = this.f60972c;
            if (eVar2 != null && eVar2.x() != null) {
                oVar4.I0 = this.f60972c.x().a();
            }
            b(oVar4);
            int position = oVar4.getPosition() + this.f60972c.X;
            if (position >= E.size()) {
                oVar4.K0 = position;
                d.a.s0.w2.i0.d.j(oVar4, 2, position + i4, d.a.s0.n1.o.k.a.k(arrayList));
                return;
            }
            if (!this.f60978i) {
                position--;
                oVar4.K0 = position;
            }
            if (position < 0) {
                d.a.s0.w2.i0.d.i(oVar4, 23);
            } else if (c(E, position)) {
                d.a.s0.w2.i0.d.i(oVar4, 1);
            } else {
                E.add(position, oVar4);
                TiebaStatic.eventStat(this.f60970a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", oVar4.getAdvertAppInfo().d4);
            }
        }
    }
}
