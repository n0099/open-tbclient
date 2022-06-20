package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerAdapter;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class ay7 extends my7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public rq7 d;
    public final List<an> e;
    public boolean f;
    public ArrayList<nn> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public ay7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.e = new ArrayList();
        this.f = true;
        this.h = null;
        this.i = true;
        this.j = false;
        this.l = -1;
        this.m = -1;
        this.b = detailInfoAndReplyFragment;
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.B() != null && detailInfoAndReplyFragment.B().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.B().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(rq7 rq7Var);

    public void D(tr7 tr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tr7Var) == null) {
        }
    }

    public abstract void E(rq7 rq7Var);

    public abstract void F(String str);

    public final void G() {
        rq7 rq7Var;
        sh8 sh8Var;
        sh8 sh8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (rq7Var = this.d) == null || rq7Var.a0 || rq7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = rq7Var.F();
        ArrayList<sh8> e = this.d.e();
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
            if (this.d.l() != null) {
                sh8Var4.I0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                sh8Var4.L0 = ng.g(this.d.O().getId(), 0L);
            }
            rq7 rq7Var2 = this.d;
            if (rq7Var2 != null && rq7Var2.y() != null) {
                sh8Var4.M0 = this.d.y().a();
            }
            b(sh8Var4);
            int position = sh8Var4.getPosition() + this.d.Z;
            if (position >= F.size()) {
                sh8Var4.O0 = position;
                ja8.k(sh8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                sh8Var4.O0 = position;
            }
            if (position < 0) {
                ja8.j(sh8Var4, 23);
            } else if (h(F, position)) {
                ja8.j(sh8Var4, 1);
            } else {
                F.add(position, sh8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", sh8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.repackage.my7
    public ArrayList<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(sh8 sh8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sh8Var) == null) || sh8Var == null || this.d == null || sh8Var.getAdvertAppInfo() == null) {
            return;
        }
        sh8Var.getAdvertAppInfo().i = new dn4();
        if (this.d.y() != null) {
            sh8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        sh8Var.getAdvertAppInfo().i.a = sh8Var.P0();
        if (this.d.l() != null && (l = this.d.l()) != null) {
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

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.l : invokeV.intValue;
    }

    public abstract ou7 e();

    public abstract jt7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof sh8) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? 12 == this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.b.F() != null) {
                return this.b.F().t1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (this.c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void m();

    public abstract void n();

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                nn nnVar = this.g.get(i);
                if (nnVar instanceof er7) {
                    this.l = i;
                    z = true;
                } else if ((nnVar instanceof qq7) && ((qq7) nnVar).a() == this.a) {
                    this.m = i;
                    z2 = true;
                }
            }
            if (!z) {
                this.l = -1;
            }
            if (z2) {
                return;
            }
            this.m = -1;
        }
    }

    public abstract void p(boolean z);

    public abstract void q(rq7 rq7Var, boolean z, String str, boolean z2);

    public void r(rq7 rq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, rq7Var) == null) {
            s(rq7Var, false);
        }
    }

    public void s(rq7 rq7Var, boolean z) {
        sh8 sh8Var;
        PostData postData;
        boolean z2;
        rq7 rq7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, rq7Var, z) == null) || rq7Var == null) {
            return;
        }
        this.d = rq7Var;
        if (rq7Var != null && rq7Var.O() != null && rq7Var.O().getAuthor() != null) {
            this.h = rq7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = rq7Var.F().iterator();
        while (true) {
            sh8Var = null;
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.B() == 1) {
                    break;
                }
            }
        }
        if (postData == null && rq7Var.j() != null) {
            postData = rq7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        E(rq7Var);
        F(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(rq7Var.F()) && rq7Var.F().get(0) != null && rq7Var.O() != null) {
            rq7Var.O().setItem(rq7Var.F().get(0).K());
            rq7Var.O().setItemStar(rq7Var.F().get(0).L());
        }
        if (rq7Var.O() != null && rq7Var.O().getRawThreadInfo() != null) {
            bq4 bq4Var = new bq4();
            bq4Var.s = rq7Var.O();
            bq4Var.n = true;
            this.g.add(bq4Var);
        }
        fr7 fr7Var = new fr7(rq7Var.O(), rq7Var.d());
        fr7Var.j(false);
        fr7Var.b = false;
        this.g.add(fr7Var);
        if (postData == null || postData.o0 == null || (rq7Var.l() != null && TextUtils.equals(rq7Var.l().getName(), this.b.F().p1()) && this.b.F().v1())) {
            z2 = false;
        } else {
            uq7 uq7Var = new uq7(postData.o0);
            uq7Var.b = this.b.F().i2();
            this.g.add(uq7Var);
            z2 = true;
        }
        if (!z2 && rq7Var.l() != null && !StringUtils.isNull(rq7Var.l().getName()) && (!TextUtils.equals(rq7Var.l().getName(), this.b.F().p1()) || !this.b.F().v1())) {
            tq7 tq7Var = new tq7(rq7Var.l());
            tq7Var.g = this.b.F().i2();
            tq7Var.e = false;
            this.g.add(tq7Var);
            fr7Var.j(false);
            fr7Var.b = false;
        }
        if (rq7Var.O() != null && !StringUtils.isNull(rq7Var.O().getForum_name())) {
            lr7 lr7Var = new lr7();
            lr7Var.a = rq7Var.O();
            this.g.add(lr7Var);
        } else if (rq7Var.O() != null && !StringUtils.isNull(rq7Var.n())) {
            rq7Var.O().setForum_name(rq7Var.n());
            lr7 lr7Var2 = new lr7();
            lr7Var2.a = rq7Var.O();
            this.g.add(lr7Var2);
        }
        if (j() && rq7Var.y() != null && rq7Var.y().c() == 1) {
            zq7 zq7Var = new zq7(zq7.c);
            zq7Var.b(true);
            this.g.add(zq7Var);
        }
        er7 er7Var = new er7(er7.h);
        ThreadData O = rq7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.F().g2();
        er7Var.d = k();
        er7Var.c = rq7Var.g;
        rq7Var.c();
        er7Var.e = rq7Var.g0();
        er7Var.g = rq7Var.f;
        C(rq7Var);
        this.g.add(er7Var);
        if (rq7Var.L() == 4) {
            this.g.add(new dr7());
        }
        G();
        p(i());
        Iterator<PostData> it2 = rq7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.B() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !ni.z()) && ((rq7Var2 = this.d) == null || !rq7Var2.t()))) {
            br7 br7Var = new br7();
            br7Var.H0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ac9);
            br7Var.G0 = R.drawable.new_pic_emotion_03;
            br7Var.I0 = -2;
            br7Var.J0 = pi.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(br7Var);
        }
        q(rq7Var, this.j, this.h, this.i);
        if (rq7Var.y().b() == 0) {
            rq7 rq7Var3 = this.d;
            if (rq7Var3 != null && rq7Var3.t()) {
                B(this.b.B().R3());
                this.g.add(new yq7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.b.B().R3());
                xq7 xq7Var = new xq7();
                xq7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f8);
                this.g.add(xq7Var);
            }
            List<sh8> Y = rq7Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                sh8Var = Y.get(0);
                i2 = sh8Var.getPosition();
            }
            if (!ListUtils.isEmpty(rq7Var.f())) {
                qq7 qq7Var = new qq7();
                qq7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa4));
                qq7Var.c(this.a);
                this.g.add(qq7Var);
                int i3 = 1;
                for (pn4 pn4Var : rq7Var.f()) {
                    if (Y != null && i3 == i2) {
                        if (sh8Var != null) {
                            b(sh8Var);
                            this.g.add(sh8Var);
                            i++;
                            if (sh8Var.getType() != AdvertAppInfo.u) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            sh8 sh8Var2 = Y.get(i);
                            sh8Var = sh8Var2;
                            i2 = sh8Var2.getPosition();
                        }
                    }
                    this.g.add(pn4Var);
                    i3++;
                    if (i3 == 4 && rq7Var.C() != null) {
                        this.g.add(rq7Var.C());
                        i3++;
                    }
                }
            }
        }
        BdTypeRecyclerView bdTypeRecyclerView = this.c;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setData(this.g);
        }
        o();
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.j = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.f = z;
        }
    }

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
        }
    }

    public void w(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, yVar) == null) {
        }
    }

    public void x(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, onLongClickListener) == null) {
        }
    }

    public void y(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, fVar) == null) {
        }
    }

    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onClickListener) == null) {
        }
    }
}
