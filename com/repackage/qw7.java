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
public class qw7 extends fx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public kp7 c;
    public final List<wm> d;
    public cs7 e;
    public PbReplyLoadMoreAdapter f;
    public wm g;
    public wm h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<jn> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public mq7 r;
    public View.OnLongClickListener s;

    public qw7(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.fx7
    public ArrayList<jn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(ah8 ah8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ah8Var) == null) || ah8Var == null || this.c == null || ah8Var.getAdvertAppInfo() == null) {
            return;
        }
        ah8Var.getAdvertAppInfo().i = new tm4();
        if (this.c.y() != null) {
            ah8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        ah8Var.getAdvertAppInfo().i.a = ah8Var.O0();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            ah8Var.getAdvertAppInfo().i.c = l.getId();
            ah8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            ah8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            ah8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        ah8Var.getAdvertAppInfo().i.g = ah8Var.getAdvertAppInfo().g;
        ah8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ah8) {
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
            cs7 cs7Var = new cs7(this.a.s(), PostData.x0);
            this.e = cs7Var;
            cs7Var.Q0(this.a.s());
            this.f = new PbReplyLoadMoreAdapter(this.a.s(), PostData.D0);
            this.g = q78.l().a(this.a.s().getBaseFragmentActivity(), AdvertAppInfo.u);
            this.h = q78.l().a(this.a.s().getBaseFragmentActivity(), AdvertAppInfo.w);
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

    public void f(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, kp7Var) == null) || kp7Var == null) {
            return;
        }
        this.c = kp7Var;
        if (kp7Var != null && kp7Var.O() != null && kp7Var.O().getAuthor() != null) {
            this.l = kp7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        kp7 kp7Var2 = this.c;
        if (kp7Var2 != null && kp7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.t(kp7Var);
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
        wm wmVar = this.h;
        if (wmVar != null && (wmVar instanceof m78)) {
            ((m78) wmVar).j(this.n);
        }
        ArrayList<jn> arrayList = new ArrayList<>(kp7Var.F());
        boolean z = false;
        PostData postData = null;
        Iterator<jn> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            jn next = it.next();
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

    public void m(mq7 mq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mq7Var) == null) {
            this.r = mq7Var;
        }
    }

    public final void n() {
        kp7 kp7Var;
        ah8 ah8Var;
        ah8 ah8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (kp7Var = this.c) == null || kp7Var.a0 || kp7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = kp7Var.F();
        ArrayList<ah8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<ah8> it = e.iterator();
        while (it.hasNext()) {
            ah8 next = it.next();
            if (next != null && next.N0() != null) {
                sb.append(next.N0());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<ah8> it2 = e.iterator();
        while (it2.hasNext()) {
            ah8 next2 = it2.next();
            if (next2 != null) {
                next2.N0 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<ah8> it3 = e.iterator();
        while (it3.hasNext()) {
            ah8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int q = next3.getAdvertAppInfo().q();
                if (q != 0) {
                    c98.j(next3, q);
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
            ah8 ah8Var3 = (ah8) sparseArray.get(sparseArray.keyAt(i));
            if (ah8Var3 != null && (ah8Var2 = (ah8) hashMap.put(ah8Var3.M0(), ah8Var3)) != null) {
                c98.j(ah8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (ah8Var = (ah8) entry.getValue()) != null) {
                sparseArray.put(ah8Var.getPosition(), ah8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ah8 ah8Var4 = (ah8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                ah8Var4.H0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                ah8Var4.K0 = jg.g(this.c.O().getId(), 0L);
            }
            kp7 kp7Var2 = this.c;
            if (kp7Var2 != null && kp7Var2.y() != null) {
                ah8Var4.L0 = this.c.y().a();
            }
            b(ah8Var4);
            int position = ah8Var4.getPosition() + this.c.Z;
            if (position >= F.size()) {
                ah8Var4.N0 = position;
                c98.k(ah8Var4, 2, position + i3, db7.i(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                ah8Var4.N0 = position;
            }
            if (position < 0) {
                c98.j(ah8Var4, 23);
            } else if (c(F, position)) {
                c98.j(ah8Var4, 1);
            } else {
                F.add(position, ah8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ah8Var4.getAdvertAppInfo().p);
            }
        }
    }
}
