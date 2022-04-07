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
/* loaded from: classes5.dex */
public class dz7 extends sz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public yr7 c;
    public final List<ho> d;
    public nu7 e;
    public PbReplyLoadMoreAdapter f;
    public ho g;
    public ho h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<uo> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public ws7 r;
    public View.OnLongClickListener s;

    public dz7(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.sz7
    public ArrayList<uo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(vk8 vk8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vk8Var) == null) || vk8Var == null || this.c == null || vk8Var.getAdvertAppInfo() == null) {
            return;
        }
        vk8Var.getAdvertAppInfo().j = new vn4();
        if (this.c.y() != null) {
            vk8Var.getAdvertAppInfo().j.b = this.c.y().a();
        }
        vk8Var.getAdvertAppInfo().j.a = vk8Var.O0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof vk8) {
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
            nu7 nu7Var = new nu7(this.a.t(), PostData.x0);
            this.e = nu7Var;
            nu7Var.Q0(this.a.t());
            this.f = new PbReplyLoadMoreAdapter(this.a.t(), PostData.D0);
            this.g = fa8.q().a(this.a.t().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = fa8.q().a(this.a.t().getBaseFragmentActivity(), AdvertAppInfo.z);
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

    public void f(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, yr7Var) == null) || yr7Var == null) {
            return;
        }
        this.c = yr7Var;
        if (yr7Var != null && yr7Var.O() != null && yr7Var.O().getAuthor() != null) {
            this.l = yr7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        yr7 yr7Var2 = this.c;
        if (yr7Var2 != null && yr7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.t(yr7Var);
        this.e.setFromCDN(this.n);
        this.e.p(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.l(this.o);
        this.e.o(this.q);
        this.e.d(this.s);
        this.e.P0(this.r);
        this.f.d0(this.p);
        n();
        ho hoVar = this.h;
        if (hoVar != null && (hoVar instanceof aa8)) {
            ((aa8) hoVar).j(this.n);
        }
        ArrayList<uo> arrayList = new ArrayList<>(yr7Var.F());
        boolean z = false;
        PostData postData = null;
        Iterator<uo> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            uo next = it.next();
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

    public void m(ws7 ws7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ws7Var) == null) {
            this.r = ws7Var;
        }
    }

    public final void n() {
        yr7 yr7Var;
        vk8 vk8Var;
        vk8 vk8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (yr7Var = this.c) == null || yr7Var.a0 || yr7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = yr7Var.F();
        ArrayList<vk8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<vk8> it = e.iterator();
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
        Iterator<vk8> it2 = e.iterator();
        while (it2.hasNext()) {
            vk8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<vk8> it3 = e.iterator();
        while (it3.hasNext()) {
            vk8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    tc8.k(next3, q);
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
            vk8 vk8Var3 = (vk8) sparseArray.get(sparseArray.keyAt(i));
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
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            vk8 vk8Var4 = (vk8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                vk8Var4.H0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                vk8Var4.K0 = mg.g(this.c.O().getId(), 0L);
            }
            yr7 yr7Var2 = this.c;
            if (yr7Var2 != null && yr7Var2.y() != null) {
                vk8Var4.L0 = this.c.y().a();
            }
            b(vk8Var4);
            int position = vk8Var4.getPosition() + this.c.Z;
            if (position >= F.size()) {
                vk8Var4.N0 = position;
                tc8.l(vk8Var4, 2, position + i3, gd7.k(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                vk8Var4.N0 = position;
            }
            if (position < 0) {
                tc8.k(vk8Var4, 23);
            } else if (c(F, position)) {
                tc8.k(vk8Var4, 1);
            } else {
                F.add(position, vk8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", vk8Var4.getAdvertAppInfo().s);
            }
        }
    }
}
