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
public class u08 extends j18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyFragment a;
    public BdTypeRecyclerView b;
    public ft7 c;
    public final List<bn> d;
    public zv7 e;
    public PbReplyLoadMoreAdapter f;
    public bn g;
    public bn h;
    public boolean i;
    public ArrayList<PostData> j;
    public ArrayList<on> k;
    public String l;
    public boolean m;
    public boolean n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public TbRichTextView.y q;
    public hu7 r;
    public View.OnLongClickListener s;

    public u08(ReplyFragment replyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    @Override // com.repackage.j18
    public ArrayList<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public final void b(bl8 bl8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bl8Var) == null) || bl8Var == null || this.c == null || bl8Var.getAdvertAppInfo() == null) {
            return;
        }
        bl8Var.getAdvertAppInfo().i = new ko4();
        if (this.c.y() != null) {
            bl8Var.getAdvertAppInfo().i.b = this.c.y().a();
        }
        bl8Var.getAdvertAppInfo().i.a = bl8Var.k1();
        if (this.c.l() != null && (l = this.c.l()) != null) {
            bl8Var.getAdvertAppInfo().i.c = l.getId();
            bl8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            bl8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            bl8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        bl8Var.getAdvertAppInfo().i.g = bl8Var.getAdvertAppInfo().g;
        bl8Var.getAdvertAppInfo().i.h = false;
    }

    public final boolean c(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof bl8) {
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
            zv7 zv7Var = new zv7(this.a.B(), PostData.K0);
            this.e = zv7Var;
            zv7Var.s0(this.a.B());
            this.f = new PbReplyLoadMoreAdapter(this.a.B(), PostData.R0);
            this.g = zb8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.h = zb8.l().a(this.a.B().getBaseFragmentActivity(), AdvertAppInfo.z);
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

    public void f(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, ft7Var) == null) || ft7Var == null) {
            return;
        }
        this.c = ft7Var;
        if (ft7Var != null && ft7Var.O() != null && ft7Var.O().getAuthor() != null) {
            this.l = ft7Var.O().getAuthor().getUserId();
        }
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.clear();
        ft7 ft7Var2 = this.c;
        if (ft7Var2 != null && ft7Var2.F() != null && this.c.F().size() > 0) {
            this.j.addAll(this.c.F());
        }
        this.e.r(ft7Var);
        this.e.setFromCDN(this.n);
        this.e.o(this.l);
        this.e.c(this.m);
        this.e.e(this.p);
        this.e.k(this.o);
        this.e.n(this.q);
        this.e.d(this.s);
        this.e.r0(this.r);
        this.f.w(this.p);
        n();
        bn bnVar = this.h;
        if (bnVar != null && (bnVar instanceof vb8)) {
            ((vb8) bnVar).setIsFromCDN(this.n);
        }
        ArrayList<on> arrayList = new ArrayList<>(ft7Var.F());
        boolean z = false;
        PostData postData = null;
        Iterator<on> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            on next = it.next();
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

    public void m(hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hu7Var) == null) {
            this.r = hu7Var;
        }
    }

    public final void n() {
        ft7 ft7Var;
        bl8 bl8Var;
        bl8 bl8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (ft7Var = this.c) == null || ft7Var.b0 || ft7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = ft7Var.F();
        ArrayList<bl8> e = this.c.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<bl8> it = e.iterator();
        while (it.hasNext()) {
            bl8 next = it.next();
            if (next != null && next.j1() != null) {
                sb.append(next.j1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<bl8> it2 = e.iterator();
        while (it2.hasNext()) {
            bl8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<bl8> it3 = e.iterator();
        while (it3.hasNext()) {
            bl8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    md8.j(next3, n);
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
            bl8 bl8Var3 = (bl8) sparseArray.get(sparseArray.keyAt(i));
            if (bl8Var3 != null && (bl8Var2 = (bl8) hashMap.put(bl8Var3.i1(), bl8Var3)) != null) {
                md8.j(bl8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (bl8Var = (bl8) entry.getValue()) != null) {
                sparseArray.put(bl8Var.getPosition(), bl8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            bl8 bl8Var4 = (bl8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.c.l() != null) {
                bl8Var4.V0 = this.c.l().getId();
            }
            if (this.c.O() != null) {
                bl8Var4.Y0 = og.g(this.c.O().getId(), 0L);
            }
            ft7 ft7Var2 = this.c;
            if (ft7Var2 != null && ft7Var2.y() != null) {
                bl8Var4.Z0 = this.c.y().a();
            }
            b(bl8Var4);
            int position = bl8Var4.getPosition() + this.c.a0;
            if (position >= F.size()) {
                bl8Var4.b1 = position;
                md8.k(bl8Var4, 2, position + i3, bf7.i(arrayList));
                return;
            }
            if (!this.i) {
                position--;
                bl8Var4.b1 = position;
            }
            if (position < 0) {
                md8.j(bl8Var4, 23);
            } else if (c(F, position)) {
                md8.j(bl8Var4, 1);
            } else {
                F.add(position, bl8Var4);
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", bl8Var4.getAdvertAppInfo().p);
            }
        }
    }
}
