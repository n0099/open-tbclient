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
public class xx7 extends my7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public rq7 c;
    public final List<an> d;
    public jt7 e;
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
    public tr7 r;
    public View.OnLongClickListener s;

    public xx7(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.my7
    public ArrayList<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(sh8 sh8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sh8Var) == null) || sh8Var == null || this.c == null || sh8Var.getAdvertAppInfo() == null) {
            return;
        }
        sh8Var.getAdvertAppInfo().i = new dn4();
        if (this.c.y() != null) {
            sh8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        sh8Var.getAdvertAppInfo().i.a = sh8Var.P0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            sh8Var.getAdvertAppInfo().i.c = l.getId();
            sh8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            sh8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            sh8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        sh8Var.getAdvertAppInfo().i.g = sh8Var.getAdvertAppInfo().g;
        sh8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof sh8) {
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
            jt7 jt7Var = new jt7(this.a.B(), PostData.y0);
            this.e = jt7Var;
            jt7Var.Q0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.E0);
            this.g = x88.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.h = x88.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.w);
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

    public void f(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, rq7Var) == null) || rq7Var == null) {
            return;
        }
        this.c = rq7Var;
        if (rq7Var != null && rq7Var.O() != null && rq7Var.O().getAuthor() != null) {
            this.l = rq7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        rq7 rq7Var2 = this.c;
        if (rq7Var2 != null && rq7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.s(rq7Var);
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
        if (anVar != null && (anVar instanceof t88)) {
            ((t88) anVar).j(this.n);
        }
        ArrayList<nn> arrayList = new ArrayList<>(rq7Var.F());
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

    public void m(tr7 tr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tr7Var) == null) {
            this.r = tr7Var;
        }
    }

    public final void n() {
        rq7 rq7Var;
        sh8 sh8Var;
        sh8 sh8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (rq7Var = this.c) == null || rq7Var.a0 || rq7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = rq7Var.F();
        ArrayList<sh8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<sh8> it = e.iterator();
        while (it.hasNext()) {
            sh8 next = it.next();
            if (next != null && next.O0() != null) {
                sb.append(next.O0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<sh8> it2 = e.iterator();
        while (it2.hasNext()) {
            sh8 next2 = it2.next();
            if (next2 != null) {
                next2.O0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<sh8> it3 = e.iterator();
        while (it3.hasNext()) {
            sh8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ja8.j(next3, n);
                    if (n != 28 && n != 31) {
                        next3.getAdvertAppInfo().c = -1001;
                        Log.e("cq", "updateAppData，Data InValidate: " + n);
                    }
                }
                sparseArray.put(next3.getPosition(), next3);
            }
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < sparseArray.size(); i++) {
            sh8 sh8Var3 = (sh8) sparseArray.get(sparseArray.keyAt(i));
            if (sh8Var3 != null && (sh8Var2 = (sh8) hashMap.put(sh8Var3.N0(), sh8Var3)) != null) {
                ja8.j(sh8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (sh8Var = (sh8) entry.getValue()) != null) {
                sparseArray.put(sh8Var.getPosition(), sh8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            sh8 sh8Var4 = (sh8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                sh8Var4.I0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                sh8Var4.L0 = ng.g(this.c.O().getId(), 0L);
            }
            rq7 rq7Var2 = this.c;
            if (rq7Var2 != null && rq7Var2.y() != null) {
                sh8Var4.M0 = this.c.y().a();
            }
            b(sh8Var4);
            int position = sh8Var4.getPosition() + this.c.Z;
            if (position >= F.size()) {
                sh8Var4.O0 = position;
                ja8.k(sh8Var4, 2, position + i3, oc7.i(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                sh8Var4.O0 = position;
            }
            if (position < 0) {
                ja8.j(sh8Var4, 23);
            } else if (c(F, position)) {
                ja8.j(sh8Var4, 1);
            } else {
                F.add(position, sh8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", sh8Var4.getAdvertAppInfo().p);
            }
        }
    }
}
