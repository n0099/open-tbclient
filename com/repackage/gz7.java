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
/* loaded from: classes6.dex */
public abstract class gz7 extends sz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public yr7 d;
    public final List<ho> e;
    public boolean f;
    public ArrayList<uo> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public gz7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.t() != null && detailInfoAndReplyFragment.t().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.t().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(yr7 yr7Var);

    public void D(ws7 ws7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ws7Var) == null) {
        }
    }

    public abstract void E(yr7 yr7Var);

    public abstract void F(String str);

    public final void G() {
        yr7 yr7Var;
        vk8 vk8Var;
        vk8 vk8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (yr7Var = this.d) == null || yr7Var.a0 || yr7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = yr7Var.F();
        ArrayList<vk8> e = this.d.e();
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
            if (this.d.l() != null) {
                vk8Var4.H0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                vk8Var4.K0 = mg.g(this.d.O().getId(), 0L);
            }
            yr7 yr7Var2 = this.d;
            if (yr7Var2 != null && yr7Var2.y() != null) {
                vk8Var4.L0 = this.d.y().a();
            }
            b(vk8Var4);
            int position = vk8Var4.getPosition() + this.d.Z;
            if (position >= F.size()) {
                vk8Var4.N0 = position;
                tc8.l(vk8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                vk8Var4.N0 = position;
            }
            if (position < 0) {
                tc8.k(vk8Var4, 23);
            } else if (h(F, position)) {
                tc8.k(vk8Var4, 1);
            } else {
                F.add(position, vk8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", vk8Var4.getAdvertAppInfo().s);
            }
        }
    }

    @Override // com.repackage.sz7
    public ArrayList<uo> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(vk8 vk8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vk8Var) == null) || vk8Var == null || this.d == null || vk8Var.getAdvertAppInfo() == null) {
            return;
        }
        vk8Var.getAdvertAppInfo().j = new vn4();
        if (this.d.y() != null) {
            vk8Var.getAdvertAppInfo().j.b = this.d.y().a();
        }
        vk8Var.getAdvertAppInfo().j.a = vk8Var.O0();
        if (this.d.l() != null && (l = this.d.l()) != null) {
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

    public abstract sv7 e();

    public abstract nu7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof vk8) {
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
            if (this.b.w() != null) {
                return this.b.w().w0();
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
                uo uoVar = this.g.get(i);
                if (uoVar instanceof ls7) {
                    this.l = i;
                    z = true;
                } else if ((uoVar instanceof xr7) && ((xr7) uoVar).a() == this.a) {
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

    public abstract void q(yr7 yr7Var, boolean z, String str, boolean z2);

    public void r(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, yr7Var) == null) {
            s(yr7Var, false);
        }
    }

    public void s(yr7 yr7Var, boolean z) {
        vk8 vk8Var;
        PostData postData;
        boolean z2;
        yr7 yr7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, yr7Var, z) == null) || yr7Var == null) {
            return;
        }
        this.d = yr7Var;
        if (yr7Var != null && yr7Var.O() != null && yr7Var.O().getAuthor() != null) {
            this.h = yr7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = yr7Var.F().iterator();
        while (true) {
            vk8Var = null;
            if (!it.hasNext()) {
                postData = null;
                break;
            }
            PostData next = it.next();
            if (next instanceof PostData) {
                postData = next;
                if (postData.A() == 1) {
                    break;
                }
            }
        }
        if (postData == null && yr7Var.j() != null) {
            postData = yr7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        E(yr7Var);
        F(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(yr7Var.F()) && yr7Var.F().get(0) != null && yr7Var.O() != null) {
            yr7Var.O().setItem(yr7Var.F().get(0).J());
            yr7Var.O().setItemStar(yr7Var.F().get(0).K());
        }
        if (yr7Var.O() != null && yr7Var.O().getRawThreadInfo() != null) {
            rq4 rq4Var = new rq4();
            rq4Var.s = yr7Var.O();
            rq4Var.n = true;
            this.g.add(rq4Var);
        }
        ms7 ms7Var = new ms7(yr7Var.O(), yr7Var.d());
        ms7Var.j(false);
        ms7Var.b = false;
        this.g.add(ms7Var);
        if (postData == null || postData.o0 == null || (yr7Var.l() != null && TextUtils.equals(yr7Var.l().getName(), this.b.w().s0()) && this.b.w().y0())) {
            z2 = false;
        } else {
            bs7 bs7Var = new bs7(postData.o0);
            bs7Var.b = this.b.w().l1();
            this.g.add(bs7Var);
            z2 = true;
        }
        if (!z2 && yr7Var.l() != null && !StringUtils.isNull(yr7Var.l().getName()) && (!TextUtils.equals(yr7Var.l().getName(), this.b.w().s0()) || !this.b.w().y0())) {
            as7 as7Var = new as7(yr7Var.l());
            as7Var.g = this.b.w().l1();
            as7Var.e = false;
            this.g.add(as7Var);
            ms7Var.j(false);
            ms7Var.b = false;
        }
        if (yr7Var.O() != null && !StringUtils.isNull(yr7Var.O().getForum_name())) {
            ss7 ss7Var = new ss7();
            ss7Var.a = yr7Var.O();
            this.g.add(ss7Var);
        } else if (yr7Var.O() != null && !StringUtils.isNull(yr7Var.n())) {
            yr7Var.O().setForum_name(yr7Var.n());
            ss7 ss7Var2 = new ss7();
            ss7Var2.a = yr7Var.O();
            this.g.add(ss7Var2);
        }
        if (j() && yr7Var.y() != null && yr7Var.y().c() == 1) {
            gs7 gs7Var = new gs7(gs7.c);
            gs7Var.b(true);
            this.g.add(gs7Var);
        }
        ls7 ls7Var = new ls7(ls7.h);
        ThreadData O = yr7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.w().j1();
        ls7Var.d = k();
        ls7Var.c = yr7Var.g;
        yr7Var.c();
        ls7Var.e = yr7Var.g0();
        ls7Var.g = yr7Var.f;
        C(yr7Var);
        this.g.add(ls7Var);
        if (yr7Var.L() == 4) {
            this.g.add(new ks7());
        }
        G();
        p(i());
        Iterator<PostData> it2 = yr7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !mi.z()) && ((yr7Var2 = this.d) == null || !yr7Var2.t()))) {
            is7 is7Var = new is7();
            is7Var.G0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ab8);
            is7Var.F0 = R.drawable.new_pic_emotion_03;
            is7Var.H0 = -2;
            is7Var.I0 = oi.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(is7Var);
        }
        q(yr7Var, this.j, this.h, this.i);
        if (yr7Var.y().b() == 0) {
            yr7 yr7Var3 = this.d;
            if (yr7Var3 != null && yr7Var3.t()) {
                B(this.b.t().Y2());
                this.g.add(new fs7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.b.t().Y2());
                es7 es7Var = new es7();
                es7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e6);
                this.g.add(es7Var);
            }
            List<vk8> Y = yr7Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                vk8Var = Y.get(0);
                i2 = vk8Var.getPosition();
            }
            if (!ListUtils.isEmpty(yr7Var.f())) {
                xr7 xr7Var = new xr7();
                xr7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f6e));
                xr7Var.e(this.a);
                this.g.add(xr7Var);
                int i3 = 1;
                for (ho4 ho4Var : yr7Var.f()) {
                    if (Y != null && i3 == i2) {
                        if (vk8Var != null) {
                            b(vk8Var);
                            this.g.add(vk8Var);
                            i++;
                            if (vk8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            vk8 vk8Var2 = Y.get(i);
                            vk8Var = vk8Var2;
                            i2 = vk8Var2.getPosition();
                        }
                    }
                    this.g.add(ho4Var);
                    i3++;
                    if (i3 == 4 && yr7Var.C() != null) {
                        this.g.add(yr7Var.C());
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
