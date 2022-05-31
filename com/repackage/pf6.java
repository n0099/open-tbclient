package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class pf6 implements dg6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public pn b;
    public List<wm> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<jn> e;
    public FrsViewData f;
    public boolean g;
    public final db6 h;
    public cg6 i;
    public wm j;
    public xf6 k;
    public jf6 l;
    public uf6 m;
    public rf6 n;
    public if6 o;
    public lf6 p;
    public vf6 q;
    public zf6 r;
    public tf6 s;
    public qf6 t;
    public yf6 u;
    public kf6 v;
    public sf6 w;

    public pf6(FrsFragment frsFragment, pn pnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, pnVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.g = false;
        this.b = pnVar;
        this.h = new db6();
        p(frsFragment, pnVar);
        this.d = new HashMap<>();
        n(z);
    }

    @Override // com.repackage.dg6
    public void a(String str) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof lw5) {
                ((lw5) wmVar).a(str);
            }
        }
    }

    @Override // com.repackage.dg6
    public void b() {
        pn pnVar;
        List<jn> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (pnVar = this.b) == null || pnVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (jn jnVar : data) {
            if (jnVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) jnVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (jnVar instanceof rp4) {
                rp4 rp4Var = (rp4) jnVar;
                if (rp4Var.s.getIs_top() != 0) {
                    rp4Var.s.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.dg6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ad6;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dg6
    public void d(tn tnVar) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tnVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).V(tnVar);
            } else if ((wmVar instanceof sf6) || (wmVar instanceof yf6)) {
                wmVar.V(tnVar);
            }
        }
    }

    @Override // com.repackage.dg6
    public void e() {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).n(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.repackage.dg6
    public List<jn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            pn pnVar = this.b;
            if (pnVar != null) {
                return pnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.dg6
    public void g(ArrayList<jn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            zf8.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<jn> it = arrayList.iterator();
            while (it.hasNext()) {
                jn next = it.next();
                if ((next instanceof rp4) && ((rp4) next).s.isTop()) {
                    it.remove();
                }
            }
            this.b.setData(arrayList);
            this.f = frsViewData;
            w();
            y();
            this.e = arrayList;
        }
    }

    @Override // com.repackage.dg6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.dg6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ab1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dg6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b7a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.dg6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (wm wmVar : this.c) {
                if (wmVar != null && wmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.dg6
    public void l(ab6 ab6Var) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ab6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).e0(ab6Var);
            }
        }
    }

    @Override // com.repackage.dg6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (wm wmVar : this.c) {
                if (wmVar instanceof fb6) {
                    ((fb6) wmVar).c0();
                } else if (wmVar instanceof h78) {
                    ((h78) wmVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.dg6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.dg6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<jn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                jn jnVar = arrayList.get(i);
                if (jnVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(jnVar)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) jnVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, pn pnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, frsFragment, pnVar) == null) {
            this.a = frsFragment;
            this.j = za6.e().c(frsFragment.getPageContext(), cg8.d, this.a.getUniqueId(), false);
            xf6 xf6Var = new xf6(frsFragment.i(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = xf6Var;
            xf6Var.h0(pnVar);
            jf6 jf6Var = new jf6(frsFragment.i(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = jf6Var;
            jf6Var.h0(pnVar);
            uf6 uf6Var = new uf6(frsFragment.i(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = uf6Var;
            uf6Var.h0(pnVar);
            rf6 rf6Var = new rf6(frsFragment.i(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = rf6Var;
            rf6Var.h0(pnVar);
            if6 if6Var = new if6(frsFragment.i(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = if6Var;
            if6Var.h0(pnVar);
            lf6 lf6Var = new lf6(frsFragment.i(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = lf6Var;
            lf6Var.h0(pnVar);
            zf6 zf6Var = new zf6(frsFragment.i(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = zf6Var;
            zf6Var.h0(pnVar);
            vf6 vf6Var = new vf6(frsFragment.i(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = vf6Var;
            vf6Var.h0(pnVar);
            tf6 tf6Var = new tf6(frsFragment.i(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = tf6Var;
            tf6Var.h0(pnVar);
            qf6 qf6Var = new qf6(frsFragment.i(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = qf6Var;
            qf6Var.h0(pnVar);
            yf6 yf6Var = new yf6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = yf6Var;
            yf6Var.h0(pnVar);
            kf6 kf6Var = new kf6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = kf6Var;
            kf6Var.h0(pnVar);
            of6 of6Var = new of6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            of6Var.h0(pnVar);
            wf6 wf6Var = new wf6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            wf6Var.h0(pnVar);
            ze6 ze6Var = new ze6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            ze6Var.h0(pnVar);
            ze6Var.r(1);
            bf6 bf6Var = new bf6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            bf6Var.h0(pnVar);
            af6 af6Var = new af6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            af6Var.h0(pnVar);
            af6Var.K0(true);
            ff6 ff6Var = new ff6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ff6Var.h0(pnVar);
            ff6Var.K0(true);
            gf6 gf6Var = new gf6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            gf6Var.h0(pnVar);
            gf6Var.L0(true);
            yf6 yf6Var2 = new yf6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            yf6Var2.h0(pnVar);
            nf6 nf6Var = new nf6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            nf6Var.h0(pnVar);
            mf6 mf6Var = new mf6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            mf6Var.h0(pnVar);
            this.i = new cg6(frsFragment.getPageContext(), uf8.c, this.a.getUniqueId());
            sf6 sf6Var = new sf6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = sf6Var;
            sf6Var.h0(pnVar);
            wm<? extends rp4, ? extends TypeAdapter.ViewHolder> a = za6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            wm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = za6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            mb6 mb6Var = new mb6(frsFragment.getPageContext(), nb6.b);
            hf6 hf6Var = new hf6(frsFragment.getPageContext(), pb6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), rb6.e, this.a.getUniqueId());
            df6 df6Var = new df6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            df6Var.c0((BdTypeRecyclerView) pnVar);
            this.c.add(this.j);
            this.c.add(this.k);
            this.c.add(this.l);
            this.c.add(this.m);
            this.c.add(this.n);
            this.c.add(this.o);
            this.c.add(this.p);
            this.c.add(this.q);
            this.c.add(this.r);
            this.c.add(this.s);
            this.c.add(this.t);
            this.c.add(this.i);
            this.c.add(of6Var);
            this.c.add(wf6Var);
            this.c.add(ze6Var);
            this.c.add(bf6Var);
            this.c.add(af6Var);
            this.c.add(ff6Var);
            this.c.add(gf6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(mb6Var);
            this.c.add(hf6Var);
            this.c.add(nf6Var);
            this.c.add(mf6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(yf6Var2);
            this.c.add(df6Var);
            this.c.add(lp6.e().b(this.a.getBaseFragmentActivity(), AdvertAppInfo.E));
            bh5 bh5Var = new bh5(this.a, 1);
            bh5Var.t(this.c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bh5Var));
            z(this.c);
            pnVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            t("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<wm<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                wm<?, ?> next = it.next();
                if (next instanceof fb6) {
                    ((fb6) next).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<wm> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            pn pnVar2 = this.b;
            if (pnVar2 != null) {
                pnVar2.a(arrayList);
            }
        }
    }

    public final boolean q(jn jnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jnVar)) == null) {
            if (jnVar == null) {
                return false;
            }
            BdUniqueId type = jnVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<jn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                jn jnVar = (jn) ListUtils.getItem(arrayList, i - 1);
                jn jnVar2 = (jn) ListUtils.getItem(arrayList, i);
                if (jnVar2 instanceof rp4) {
                    ThreadData threadData = ((rp4) jnVar2).s;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (jnVar instanceof pb6) {
                        threadData.needTopMargin = false;
                    } else if (jnVar != null && !q(jnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((jnVar instanceof rp4) && q(jnVar) && !TextUtils.isEmpty(((rp4) jnVar).s.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(jnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.repackage.dg6
    public void setFromCDN(boolean z) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).setFromCDN(z);
            }
        }
        xf6 xf6Var = this.k;
        if (xf6Var != null) {
            xf6Var.setFromCDN(z);
        }
        jf6 jf6Var = this.l;
        if (jf6Var != null) {
            jf6Var.setFromCDN(z);
        }
        uf6 uf6Var = this.m;
        if (uf6Var != null) {
            uf6Var.setFromCDN(z);
        }
        rf6 rf6Var = this.n;
        if (rf6Var != null) {
            rf6Var.setFromCDN(z);
        }
        if6 if6Var = this.o;
        if (if6Var != null) {
            if6Var.setFromCDN(z);
        }
        lf6 lf6Var = this.p;
        if (lf6Var != null) {
            lf6Var.setFromCDN(z);
        }
        yf6 yf6Var = this.u;
        if (yf6Var != null) {
            yf6Var.setFromCDN(z);
        }
        sf6 sf6Var = this.w;
        if (sf6Var != null) {
            sf6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof ci5) {
                ((ci5) wmVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).j0(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).f0(frsViewData);
            }
        }
    }

    public final void w() {
        nm6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f == null) {
            return;
        }
        for (wm wmVar : this.c) {
            if ((wmVar instanceof pm6) && (i = ((pm6) wmVar).i()) != null) {
                if (this.f.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.f.getForum() != null) {
                    i.c = this.f.getForum().getId();
                    i.d = this.f.getForum().getName();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.c0() != null) {
                    int T = this.a.c0().T();
                    if (T == -1) {
                        T = this.a.c0().S();
                    }
                    i.b = T;
                }
            }
        }
    }

    public final void x(ArrayList<jn> arrayList) {
        List<wm> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<jn> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (wm wmVar : this.c) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).k0(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        cg6 cg6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (cg6Var = this.i) == null) {
            return;
        }
        cg6Var.q0(this.f.getForum().getId());
    }

    public final void z(List<wm> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (wm wmVar : list) {
            if (wmVar instanceof fb6) {
                ((fb6) wmVar).d0(this.h);
            }
        }
    }
}
