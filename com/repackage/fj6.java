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
public class fj6 implements tj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public un b;
    public List<bn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<on> e;
    public FrsViewData f;
    public boolean g;
    public final se6 h;
    public sj6 i;
    public bn j;
    public nj6 k;
    public zi6 l;
    public kj6 m;
    public hj6 n;
    public yi6 o;
    public bj6 p;
    public lj6 q;
    public pj6 r;
    public jj6 s;
    public gj6 t;
    public oj6 u;
    public aj6 v;
    public ij6 w;

    public fj6(FrsFragment frsFragment, un unVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, unVar, Boolean.valueOf(z)};
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
        this.b = unVar;
        this.h = new se6();
        p(frsFragment, unVar);
        this.d = new HashMap<>();
        n(z);
    }

    public final void A(List<bn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (bn bnVar : list) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).w(this.h);
            }
        }
    }

    @Override // com.repackage.tj6
    public void a(String str) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (bn bnVar : list) {
            if (bnVar instanceof zz5) {
                ((zz5) bnVar).a(str);
            }
        }
    }

    @Override // com.repackage.tj6
    public void b() {
        un unVar;
        List<on> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (unVar = this.b) == null || unVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (on onVar : data) {
            if (onVar instanceof ThreadData) {
                ThreadData threadData = (ThreadData) onVar;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (onVar instanceof ir4) {
                ir4 ir4Var = (ir4) onVar;
                if (ir4Var.t.getIs_top() != 0) {
                    ir4Var.t.parser_title();
                }
            }
        }
    }

    @Override // com.repackage.tj6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b01;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.tj6
    public void d(yn ynVar) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, ynVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).setOnAdapterItemClickListener(ynVar);
            } else if ((bnVar instanceof ij6) || (bnVar instanceof oj6)) {
                bnVar.setOnAdapterItemClickListener(ynVar);
            }
        }
    }

    @Override // com.repackage.tj6
    public void e() {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).m(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        A(this.c);
    }

    @Override // com.repackage.tj6
    public List<on> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            un unVar = this.b;
            if (unVar != null) {
                return unVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.repackage.tj6
    public void g(ArrayList<on> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, arrayList, frsViewData) == null) {
            w(frsViewData);
            v();
            bk8.f(arrayList, 1);
            o(arrayList);
            y(arrayList);
            s(arrayList);
            Iterator<on> it = arrayList.iterator();
            while (it.hasNext()) {
                on next = it.next();
                if ((next instanceof ir4) && ((ir4) next).t.isTop()) {
                    it.remove();
                }
            }
            this.b.setData(arrayList);
            this.f = frsViewData;
            x();
            z();
            this.e = arrayList;
        }
    }

    @Override // com.repackage.tj6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.repackage.tj6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090adc;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.tj6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ba6;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.tj6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (bn bnVar : this.c) {
                if (bnVar != null && bnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.tj6
    public void l(pe6 pe6Var) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, pe6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).x(pe6Var);
            }
        }
    }

    @Override // com.repackage.tj6
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (bn bnVar : this.c) {
                if (bnVar instanceof ue6) {
                    ((ue6) bnVar).v();
                } else if (bnVar instanceof qb8) {
                    ((qb8) bnVar).onDestroy();
                }
            }
        }
    }

    @Override // com.repackage.tj6
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    @Override // com.repackage.tj6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<on> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i = 0; i < arrayList.size(); i++) {
                on onVar = arrayList.get(i);
                if (onVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i));
                    HashMap<Integer, ThreadData> hashMap = this.d;
                    if (hashMap != null && !hashMap.containsValue(onVar)) {
                        this.d.put(Integer.valueOf(i), (ThreadData) onVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, frsFragment, unVar) == null) {
            this.a = frsFragment;
            this.j = oe6.e().c(frsFragment.getPageContext(), ek8.d, this.a.getUniqueId(), false);
            nj6 nj6Var = new nj6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = nj6Var;
            nj6Var.A(unVar);
            zi6 zi6Var = new zi6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = zi6Var;
            zi6Var.A(unVar);
            kj6 kj6Var = new kj6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = kj6Var;
            kj6Var.A(unVar);
            hj6 hj6Var = new hj6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = hj6Var;
            hj6Var.A(unVar);
            yi6 yi6Var = new yi6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = yi6Var;
            yi6Var.A(unVar);
            bj6 bj6Var = new bj6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = bj6Var;
            bj6Var.A(unVar);
            pj6 pj6Var = new pj6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = pj6Var;
            pj6Var.A(unVar);
            lj6 lj6Var = new lj6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = lj6Var;
            lj6Var.A(unVar);
            jj6 jj6Var = new jj6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = jj6Var;
            jj6Var.A(unVar);
            gj6 gj6Var = new gj6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = gj6Var;
            gj6Var.A(unVar);
            oj6 oj6Var = new oj6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = oj6Var;
            oj6Var.A(unVar);
            aj6 aj6Var = new aj6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = aj6Var;
            aj6Var.A(unVar);
            ej6 ej6Var = new ej6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ej6Var.A(unVar);
            mj6 mj6Var = new mj6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            mj6Var.A(unVar);
            oi6 oi6Var = new oi6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            oi6Var.A(unVar);
            oi6Var.p(1);
            qi6 qi6Var = new qi6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            qi6Var.A(unVar);
            pi6 pi6Var = new pi6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            pi6Var.A(unVar);
            pi6Var.e0(true);
            ui6 ui6Var = new ui6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ui6Var.A(unVar);
            ui6Var.e0(true);
            vi6 vi6Var = new vi6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            vi6Var.A(unVar);
            vi6Var.f0(true);
            oj6 oj6Var2 = new oj6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            oj6Var2.A(unVar);
            dj6 dj6Var = new dj6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            dj6Var.A(unVar);
            cj6 cj6Var = new cj6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            cj6Var.A(unVar);
            this.i = new sj6(frsFragment.getPageContext(), wj8.c, this.a.getUniqueId());
            ij6 ij6Var = new ij6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = ij6Var;
            ij6Var.A(unVar);
            bn<? extends ir4, ? extends TypeAdapter.ViewHolder> a = oe6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            bn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = oe6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            bf6 bf6Var = new bf6(frsFragment.getPageContext(), cf6.b);
            wi6 wi6Var = new wi6(frsFragment.getPageContext(), ef6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), gf6.e, this.a.getUniqueId());
            si6 si6Var = new si6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            si6Var.v((BdTypeRecyclerView) unVar);
            xi6 xi6Var = new xi6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
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
            this.c.add(ej6Var);
            this.c.add(mj6Var);
            this.c.add(oi6Var);
            this.c.add(qi6Var);
            this.c.add(pi6Var);
            this.c.add(ui6Var);
            this.c.add(vi6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(bf6Var);
            this.c.add(wi6Var);
            this.c.add(dj6Var);
            this.c.add(cj6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(oj6Var2);
            this.c.add(si6Var);
            this.c.add(xi6Var);
            this.c.add(ts6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            ok5 ok5Var = new ok5(this.a, 1);
            ok5Var.u(this.c);
            ok5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ok5Var));
            A(this.c);
            unVar.a(this.c);
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
            Iterator<bn<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                bn<?, ?> next = it.next();
                if (next instanceof ue6) {
                    ((ue6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<bn> list = this.c;
            if (list != null) {
                list.addAll(arrayList);
            }
            un unVar2 = this.b;
            if (unVar2 != null) {
                unVar2.a(arrayList);
            }
        }
    }

    public final boolean q(on onVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, onVar)) == null) {
            if (onVar == null) {
                return false;
            }
            BdUniqueId type = onVar.getType();
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ArrayList<on> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                on onVar = (on) ListUtils.getItem(arrayList, i - 1);
                on onVar2 = (on) ListUtils.getItem(arrayList, i);
                if (onVar2 instanceof ir4) {
                    ThreadData threadData = ((ir4) onVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (onVar instanceof ef6) {
                        threadData.needTopMargin = false;
                    } else if (onVar != null && !q(onVar)) {
                        threadData.needTopMargin = false;
                    } else if ((onVar instanceof ir4) && q(onVar) && !TextUtils.isEmpty(((ir4) onVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (q(onVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.repackage.tj6
    public void setFromCDN(boolean z) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).setFromCDN(z);
            }
        }
        nj6 nj6Var = this.k;
        if (nj6Var != null) {
            nj6Var.setFromCDN(z);
        }
        zi6 zi6Var = this.l;
        if (zi6Var != null) {
            zi6Var.setFromCDN(z);
        }
        kj6 kj6Var = this.m;
        if (kj6Var != null) {
            kj6Var.setFromCDN(z);
        }
        hj6 hj6Var = this.n;
        if (hj6Var != null) {
            hj6Var.setFromCDN(z);
        }
        yi6 yi6Var = this.o;
        if (yi6Var != null) {
            yi6Var.setFromCDN(z);
        }
        bj6 bj6Var = this.p;
        if (bj6Var != null) {
            bj6Var.setFromCDN(z);
        }
        oj6 oj6Var = this.u;
        if (oj6Var != null) {
            oj6Var.setFromCDN(z);
        }
        ij6 ij6Var = this.w;
        if (ij6Var != null) {
            ij6Var.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (bn bnVar : list) {
            if (bnVar instanceof pl5) {
                ((pl5) bnVar).g(str);
            }
        }
    }

    public void u(String str) {
        List<bn> list;
        Class<?> cls;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        try {
            cls = Class.forName("com.baidu.tieba.InjectPlugin.FrsFeedAd.FrsFeedAdAdapter");
            cls2 = Class.forName("com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar != null) {
                Class<?> cls3 = bnVar.getClass();
                if (cls3 == cls) {
                    try {
                        cls3.getDeclaredMethod("setTab", String.class).invoke(bnVar, str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (cls3 == cls2) {
                    try {
                        cls3.getDeclaredMethod("setPageTab", String.class).invoke(bnVar, str);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                e.printStackTrace();
                return;
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void w(FrsViewData frsViewData) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).y(frsViewData);
            }
        }
    }

    public final void x() {
        xp6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f == null) {
            return;
        }
        for (bn bnVar : this.c) {
            if ((bnVar instanceof zp6) && (i = ((zp6) bnVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.K0() != null) {
                    int U = this.a.K0().U();
                    if (U == -1) {
                        U = this.a.K0().T();
                    }
                    i.b = U;
                }
            }
        }
    }

    public final void y(ArrayList<on> arrayList) {
        List<bn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<on> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (bn bnVar : this.c) {
            if (bnVar instanceof ue6) {
                ((ue6) bnVar).D(i);
            }
        }
    }

    public final void z() {
        FrsViewData frsViewData;
        sj6 sj6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (sj6Var = this.i) == null) {
            return;
        }
        sj6Var.K(this.f.getForum().getId());
    }
}
