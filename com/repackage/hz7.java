package com.repackage;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class hz7 extends wz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public bs7 c;
    public final List<eo> d;
    public tu7 e;
    public PbReplyLoadMoreAdapter f;
    public eo g;
    public eo h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<ro> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public dt7 r;
    public View.OnLongClickListener s;

    public hz7(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new ArrayList();
        this.i = true;
        this.l = null;
        this.m = true;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.a = replyFragment;
        this.b = bdTypeRecyclerView;
        d();
    }

    @Override // com.repackage.wz7
    public ArrayList<ro> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(zj8 zj8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zj8Var) == null) || zj8Var == null || this.c == null || zj8Var.getAdvertAppInfo() == null) {
            return;
        }
        zj8Var.getAdvertAppInfo().i = new eo4();
        if (this.c.y() != null) {
            zj8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        zj8Var.getAdvertAppInfo().i.a = zj8Var.O0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof zj8) {
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
            tu7 tu7Var = new tu7(this.a.s(), PostData.x0);
            this.e = tu7Var;
            tu7Var.Q0(this.a.s());
            this.f = new PbReplyLoadMoreAdapter(this.a.s(), PostData.D0);
            this.g = ja8.l().a(this.a.s().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.h = ja8.l().a(this.a.s().getBaseFragmentActivity(), AdvertAppInfo.w);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.e);
            this.d.add(this.f);
            this.b.a(this.d);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.b.getAdapter() instanceof BdRecyclerAdapter)) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void f(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bs7Var) == null) || bs7Var == null) {
            return;
        }
        this.c = bs7Var;
        if (bs7Var != null && bs7Var.O() != null && bs7Var.O().getAuthor() != null) {
            this.l = bs7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        bs7 bs7Var2 = this.c;
        if (bs7Var2 != null && bs7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.t(bs7Var);
        this.e.setFromCDN(this.n);
        this.e.q(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.l(this.o);
        this.e.o(this.q);
        this.e.d(this.s);
        this.e.P0(this.r);
        this.f.d0(this.p);
        n();
        eo eoVar = this.h;
        if (eoVar != null && (eoVar instanceof fa8)) {
            ((fa8) eoVar).j(this.n);
        }
        ArrayList<ro> arrayList = new ArrayList<>(bs7Var.F());
        boolean z = false;
        PostData postData = null;
        Iterator<ro> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ro next = it.next();
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
        BdTypeRecyclerView bdTypeRecyclerView = this.b;
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
            this.i = z;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void j(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yVar) == null) {
            this.q = yVar;
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

    public void m(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dt7Var) == null) {
            this.r = dt7Var;
        }
    }

    public final void n() {
        bs7 bs7Var;
        zj8 zj8Var;
        zj8 zj8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bs7Var = this.c) == null || bs7Var.a0 || bs7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = bs7Var.F();
        ArrayList<zj8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<zj8> it = e.iterator();
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
        Iterator<zj8> it2 = e.iterator();
        while (it2.hasNext()) {
            zj8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<zj8> it3 = e.iterator();
        while (it3.hasNext()) {
            zj8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    vb8.j(next3, q);
                    if (q != 28 && q != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + q);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            zj8 zj8Var3 = (zj8) sparseArray.get(sparseArray.keyAt(i));
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
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            zj8 zj8Var4 = (zj8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                zj8Var4.H0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                zj8Var4.K0 = kg.g(this.c.O().getId(), 0L);
            }
            bs7 bs7Var2 = this.c;
            if (bs7Var2 != null && bs7Var2.y() != null) {
                zj8Var4.L0 = this.c.y().a();
            }
            b(zj8Var4);
            int position = zj8Var4.getPosition() + this.c.Z;
            if (position >= F.size()) {
                zj8Var4.N0 = position;
                vb8.k(zj8Var4, 2, position + i3, pd7.i(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                zj8Var4.N0 = position;
            }
            if (position < 0) {
                vb8.j(zj8Var4, 23);
            } else if (c(F, position)) {
                vb8.j(zj8Var4, 1);
            } else {
                F.add(position, zj8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", zj8Var4.getAdvertAppInfo().p);
            }
        }
    }
}
