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
/* loaded from: classes7.dex */
public abstract class uy7 extends gz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public jr7 d;
    public final List<an> e;
    public boolean f;
    public ArrayList<nn> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public uy7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public abstract void C(jr7 jr7Var);

    public void D(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ls7Var) == null) {
        }
    }

    public abstract void E(jr7 jr7Var);

    public abstract void F(String str);

    public final void G() {
        jr7 jr7Var;
        ni8 ni8Var;
        ni8 ni8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (jr7Var = this.d) == null || jr7Var.a0 || jr7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = jr7Var.F();
        ArrayList<ni8> e = this.d.e();
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
            if (this.d.l() != null) {
                ni8Var4.K0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                ni8Var4.N0 = ng.g(this.d.O().getId(), 0L);
            }
            jr7 jr7Var2 = this.d;
            if (jr7Var2 != null && jr7Var2.y() != null) {
                ni8Var4.O0 = this.d.y().a();
            }
            b(ni8Var4);
            int position = ni8Var4.getPosition() + this.d.Z;
            if (position >= F.size()) {
                ni8Var4.Q0 = position;
                eb8.k(ni8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                ni8Var4.Q0 = position;
            }
            if (position < 0) {
                eb8.j(ni8Var4, 23);
            } else if (h(F, position)) {
                eb8.j(ni8Var4, 1);
            } else {
                F.add(position, ni8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ni8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.repackage.gz7
    public ArrayList<nn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(ni8 ni8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ni8Var) == null) || ni8Var == null || this.d == null || ni8Var.getAdvertAppInfo() == null) {
            return;
        }
        ni8Var.getAdvertAppInfo().i = new tn4();
        if (this.d.y() != null) {
            ni8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        ni8Var.getAdvertAppInfo().i.a = ni8Var.S0();
        if (this.d.l() != null && (l = this.d.l()) != null) {
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

    public abstract gv7 e();

    public abstract bu7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ni8) {
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
                return this.b.F().u1();
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
                if (nnVar instanceof wr7) {
                    this.l = i;
                    z = true;
                } else if ((nnVar instanceof ir7) && ((ir7) nnVar).a() == this.a) {
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

    public abstract void q(jr7 jr7Var, boolean z, String str, boolean z2);

    public void r(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, jr7Var) == null) {
            s(jr7Var, false);
        }
    }

    public void s(jr7 jr7Var, boolean z) {
        ni8 ni8Var;
        PostData postData;
        boolean z2;
        jr7 jr7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, jr7Var, z) == null) || jr7Var == null) {
            return;
        }
        this.d = jr7Var;
        if (jr7Var != null && jr7Var.O() != null && jr7Var.O().getAuthor() != null) {
            this.h = jr7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = jr7Var.F().iterator();
        while (true) {
            ni8Var = null;
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
        if (postData == null && jr7Var.j() != null) {
            postData = jr7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        E(jr7Var);
        F(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(jr7Var.F()) && jr7Var.F().get(0) != null && jr7Var.O() != null) {
            jr7Var.O().setItem(jr7Var.F().get(0).K());
            jr7Var.O().setItemStar(jr7Var.F().get(0).L());
        }
        if (jr7Var.O() != null && jr7Var.O().getRawThreadInfo() != null) {
            rq4 rq4Var = new rq4();
            rq4Var.s = jr7Var.O();
            rq4Var.n = true;
            this.g.add(rq4Var);
        }
        xr7 xr7Var = new xr7(jr7Var.O(), jr7Var.d());
        xr7Var.i(false);
        xr7Var.b = false;
        this.g.add(xr7Var);
        if (postData == null || postData.i0 == null || (jr7Var.l() != null && TextUtils.equals(jr7Var.l().getName(), this.b.F().q1()) && this.b.F().w1())) {
            z2 = false;
        } else {
            mr7 mr7Var = new mr7(postData.i0);
            mr7Var.b = this.b.F().j2();
            this.g.add(mr7Var);
            z2 = true;
        }
        if (!z2 && jr7Var.l() != null && !StringUtils.isNull(jr7Var.l().getName()) && (!TextUtils.equals(jr7Var.l().getName(), this.b.F().q1()) || !this.b.F().w1())) {
            lr7 lr7Var = new lr7(jr7Var.l());
            lr7Var.g = this.b.F().j2();
            lr7Var.e = false;
            this.g.add(lr7Var);
            xr7Var.i(false);
            xr7Var.b = false;
        }
        if (jr7Var.O() != null && !StringUtils.isNull(jr7Var.O().getForum_name())) {
            ds7 ds7Var = new ds7();
            ds7Var.a = jr7Var.O();
            this.g.add(ds7Var);
        } else if (jr7Var.O() != null && !StringUtils.isNull(jr7Var.n())) {
            jr7Var.O().setForum_name(jr7Var.n());
            ds7 ds7Var2 = new ds7();
            ds7Var2.a = jr7Var.O();
            this.g.add(ds7Var2);
        }
        if (j() && jr7Var.y() != null && jr7Var.y().c() == 1) {
            rr7 rr7Var = new rr7(rr7.c);
            rr7Var.b(true);
            this.g.add(rr7Var);
        }
        wr7 wr7Var = new wr7(wr7.h);
        ThreadData O = jr7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.F().h2();
        wr7Var.d = k();
        wr7Var.c = jr7Var.g;
        jr7Var.c();
        wr7Var.e = jr7Var.g0();
        wr7Var.g = jr7Var.f;
        C(jr7Var);
        this.g.add(wr7Var);
        if (jr7Var.L() == 4) {
            this.g.add(new vr7());
        }
        G();
        p(i());
        Iterator<PostData> it2 = jr7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.B() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !ni.z()) && ((jr7Var2 = this.d) == null || !jr7Var2.t()))) {
            tr7 tr7Var = new tr7();
            tr7Var.J0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0aa3);
            tr7Var.I0 = R.drawable.new_pic_emotion_03;
            tr7Var.K0 = -2;
            tr7Var.L0 = pi.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(tr7Var);
        }
        q(jr7Var, this.j, this.h, this.i);
        if (jr7Var.y().b() == 0) {
            jr7 jr7Var3 = this.d;
            if (jr7Var3 != null && jr7Var3.t()) {
                B(this.b.B().S3());
                this.g.add(new qr7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.b.B().S3());
                pr7 pr7Var = new pr7();
                pr7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09cf);
                this.g.add(pr7Var);
            }
            List<ni8> Y = jr7Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                ni8Var = Y.get(0);
                i2 = ni8Var.getPosition();
            }
            if (!ListUtils.isEmpty(jr7Var.f())) {
                ir7 ir7Var = new ir7();
                ir7Var.d(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f88));
                ir7Var.c(this.a);
                this.g.add(ir7Var);
                int i3 = 1;
                for (fo4 fo4Var : jr7Var.f()) {
                    if (Y != null && i3 == i2) {
                        if (ni8Var != null) {
                            b(ni8Var);
                            this.g.add(ni8Var);
                            i++;
                            if (ni8Var.getType() != AdvertAppInfo.u) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            ni8 ni8Var2 = Y.get(i);
                            ni8Var = ni8Var2;
                            i2 = ni8Var2.getPosition();
                        }
                    }
                    this.g.add(fo4Var);
                    i3++;
                    if (i3 == 4 && jr7Var.C() != null) {
                        this.g.add(jr7Var.C());
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
