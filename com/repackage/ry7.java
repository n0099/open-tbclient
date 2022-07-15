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
/* loaded from: classes7.dex */
public class ry7 extends gz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public jr7 c;
    public final List<an> d;
    public bu7 e;
    public PbReplyLoadMoreAdapter f;
    public an g;
    public an h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<nn> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public ls7 r;
    public View.OnLongClickListener s;

    public ry7(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.gz7
    public ArrayList<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(ni8 ni8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ni8Var) == null) || ni8Var == null || this.c == null || ni8Var.getAdvertAppInfo() == null) {
            return;
        }
        ni8Var.getAdvertAppInfo().i = new sn4();
        if (this.c.y() != null) {
            ni8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        ni8Var.getAdvertAppInfo().i.a = ni8Var.S0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
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

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ni8) {
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
            bu7 bu7Var = new bu7(this.a.B(), PostData.A0);
            this.e = bu7Var;
            bu7Var.Q0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.G0);
            this.g = s98.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.h = s98.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.w);
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

    public void f(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, jr7Var) == null) || jr7Var == null) {
            return;
        }
        this.c = jr7Var;
        if (jr7Var != null && jr7Var.O() != null && jr7Var.O().getAuthor() != null) {
            this.l = jr7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        jr7 jr7Var2 = this.c;
        if (jr7Var2 != null && jr7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.s(jr7Var);
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
        an anVar = this.h;
        if (anVar != null && (anVar instanceof o98)) {
            ((o98) anVar).j(this.n);
        }
        ArrayList<nn> arrayList = new ArrayList<>(jr7Var.F());
        boolean z = false;
        PostData postData = null;
        Iterator<nn> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            nn next = it.next();
            if (next instanceof PostData) {
                PostData postData2 = (PostData) next;
                if (postData2.B() == 1) {
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

    public void m(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ls7Var) == null) {
            this.r = ls7Var;
        }
    }

    public final void n() {
        jr7 jr7Var;
        ni8 ni8Var;
        ni8 ni8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jr7Var = this.c) == null || jr7Var.a0 || jr7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = jr7Var.F();
        ArrayList<ni8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ni8> it = e.iterator();
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
        Iterator<ni8> it2 = e.iterator();
        while (it2.hasNext()) {
            ni8 next2 = it2.next();
            if (next2 != null) {
                next2.Q0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<ni8> it3 = e.iterator();
        while (it3.hasNext()) {
            ni8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int m = next3.getAdvertAppInfo().m();
                if (m != 0) {
                    eb8.j(next3, m);
                    if (m != 28 && m != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + m);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            ni8 ni8Var3 = (ni8) sparseArray.get(sparseArray.keyAt(i));
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
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ni8 ni8Var4 = (ni8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                ni8Var4.K0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                ni8Var4.N0 = ng.g(this.c.O().getId(), 0L);
            }
            jr7 jr7Var2 = this.c;
            if (jr7Var2 != null && jr7Var2.y() != null) {
                ni8Var4.O0 = this.c.y().a();
            }
            b(ni8Var4);
            int position = ni8Var4.getPosition() + this.c.Z;
            if (position >= F.size()) {
                ni8Var4.Q0 = position;
                eb8.k(ni8Var4, 2, position + i3, gd7.i(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                ni8Var4.Q0 = position;
            }
            if (position < 0) {
                eb8.j(ni8Var4, 23);
            } else if (c(F, position)) {
                eb8.j(ni8Var4, 1);
            } else {
                F.add(position, ni8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ni8Var4.getAdvertAppInfo().p);
            }
        }
    }
}
