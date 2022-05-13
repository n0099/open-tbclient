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
public abstract class kz7 extends wz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public bs7 d;
    public final List<eo> e;
    public boolean f;
    public ArrayList<ro> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public kz7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        if (detailInfoAndReplyFragment != null && detailInfoAndReplyFragment.s() != null && detailInfoAndReplyFragment.s().getArguments() != null) {
            this.k = detailInfoAndReplyFragment.s().getArguments().getInt(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE);
        }
        this.c = bdTypeRecyclerView;
    }

    public abstract void A(View.OnClickListener onClickListener);

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(bs7 bs7Var);

    public void D(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dt7Var) == null) {
        }
    }

    public abstract void E(bs7 bs7Var);

    public abstract void F(String str);

    public final void G() {
        bs7 bs7Var;
        zj8 zj8Var;
        zj8 zj8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bs7Var = this.d) == null || bs7Var.a0 || bs7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = bs7Var.F();
        ArrayList<zj8> e = this.d.e();
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
            if (this.d.l() != null) {
                zj8Var4.H0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                zj8Var4.K0 = kg.g(this.d.O().getId(), 0L);
            }
            bs7 bs7Var2 = this.d;
            if (bs7Var2 != null && bs7Var2.y() != null) {
                zj8Var4.L0 = this.d.y().a();
            }
            b(zj8Var4);
            int position = zj8Var4.getPosition() + this.d.Z;
            if (position >= F.size()) {
                zj8Var4.N0 = position;
                vb8.k(zj8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                zj8Var4.N0 = position;
            }
            if (position < 0) {
                vb8.j(zj8Var4, 23);
            } else if (h(F, position)) {
                vb8.j(zj8Var4, 1);
            } else {
                F.add(position, zj8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", zj8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.repackage.wz7
    public ArrayList<ro> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(zj8 zj8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zj8Var) == null) || zj8Var == null || this.d == null || zj8Var.getAdvertAppInfo() == null) {
            return;
        }
        zj8Var.getAdvertAppInfo().i = new eo4();
        if (this.d.y() != null) {
            zj8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        zj8Var.getAdvertAppInfo().i.a = zj8Var.O0();
        if (this.d.l() != null && (l = this.d.l()) != null) {
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

    public abstract yv7 e();

    public abstract tu7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof zj8) {
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
            if (this.b.v() != null) {
                return this.b.v().s1();
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
                ro roVar = this.g.get(i);
                if (roVar instanceof os7) {
                    this.l = i;
                    z = true;
                } else if ((roVar instanceof as7) && ((as7) roVar).a() == this.a) {
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

    public abstract void q(bs7 bs7Var, boolean z, String str, boolean z2);

    public void r(bs7 bs7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bs7Var) == null) {
            s(bs7Var, false);
        }
    }

    public void s(bs7 bs7Var, boolean z) {
        zj8 zj8Var;
        PostData postData;
        boolean z2;
        bs7 bs7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, bs7Var, z) == null) || bs7Var == null) {
            return;
        }
        this.d = bs7Var;
        if (bs7Var != null && bs7Var.O() != null && bs7Var.O().getAuthor() != null) {
            this.h = bs7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = bs7Var.F().iterator();
        while (true) {
            zj8Var = null;
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
        if (postData == null && bs7Var.j() != null) {
            postData = bs7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        E(bs7Var);
        F(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(bs7Var.F()) && bs7Var.F().get(0) != null && bs7Var.O() != null) {
            bs7Var.O().setItem(bs7Var.F().get(0).J());
            bs7Var.O().setItemStar(bs7Var.F().get(0).K());
        }
        if (bs7Var.O() != null && bs7Var.O().getRawThreadInfo() != null) {
            br4 br4Var = new br4();
            br4Var.s = bs7Var.O();
            br4Var.n = true;
            this.g.add(br4Var);
        }
        ps7 ps7Var = new ps7(bs7Var.O(), bs7Var.d());
        ps7Var.j(false);
        ps7Var.b = false;
        this.g.add(ps7Var);
        if (postData == null || postData.o0 == null || (bs7Var.l() != null && TextUtils.equals(bs7Var.l().getName(), this.b.v().o1()) && this.b.v().u1())) {
            z2 = false;
        } else {
            es7 es7Var = new es7(postData.o0);
            es7Var.b = this.b.v().h2();
            this.g.add(es7Var);
            z2 = true;
        }
        if (!z2 && bs7Var.l() != null && !StringUtils.isNull(bs7Var.l().getName()) && (!TextUtils.equals(bs7Var.l().getName(), this.b.v().o1()) || !this.b.v().u1())) {
            ds7 ds7Var = new ds7(bs7Var.l());
            ds7Var.g = this.b.v().h2();
            ds7Var.e = false;
            this.g.add(ds7Var);
            ps7Var.j(false);
            ps7Var.b = false;
        }
        if (bs7Var.O() != null && !StringUtils.isNull(bs7Var.O().getForum_name())) {
            vs7 vs7Var = new vs7();
            vs7Var.a = bs7Var.O();
            this.g.add(vs7Var);
        } else if (bs7Var.O() != null && !StringUtils.isNull(bs7Var.n())) {
            bs7Var.O().setForum_name(bs7Var.n());
            vs7 vs7Var2 = new vs7();
            vs7Var2.a = bs7Var.O();
            this.g.add(vs7Var2);
        }
        if (j() && bs7Var.y() != null && bs7Var.y().c() == 1) {
            js7 js7Var = new js7(js7.c);
            js7Var.b(true);
            this.g.add(js7Var);
        }
        os7 os7Var = new os7(os7.h);
        ThreadData O = bs7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.v().f2();
        os7Var.d = k();
        os7Var.c = bs7Var.g;
        bs7Var.c();
        os7Var.e = bs7Var.g0();
        os7Var.g = bs7Var.f;
        C(bs7Var);
        this.g.add(os7Var);
        if (bs7Var.L() == 4) {
            this.g.add(new ns7());
        }
        G();
        p(i());
        Iterator<PostData> it2 = bs7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !ki.z()) && ((bs7Var2 = this.d) == null || !bs7Var2.t()))) {
            ls7 ls7Var = new ls7();
            ls7Var.G0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0abe);
            ls7Var.F0 = R.drawable.new_pic_emotion_03;
            ls7Var.H0 = -2;
            ls7Var.I0 = mi.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(ls7Var);
        }
        q(bs7Var, this.j, this.h, this.i);
        if (bs7Var.y().b() == 0) {
            bs7 bs7Var3 = this.d;
            if (bs7Var3 != null && bs7Var3.t()) {
                B(this.b.s().Z2());
                this.g.add(new is7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.b.s().Z2());
                hs7 hs7Var = new hs7();
                hs7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09ec);
                this.g.add(hs7Var);
            }
            List<zj8> Y = bs7Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                zj8Var = Y.get(0);
                i2 = zj8Var.getPosition();
            }
            if (!ListUtils.isEmpty(bs7Var.f())) {
                as7 as7Var = new as7();
                as7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f88));
                as7Var.e(this.a);
                this.g.add(as7Var);
                int i3 = 1;
                for (qo4 qo4Var : bs7Var.f()) {
                    if (Y != null && i3 == i2) {
                        if (zj8Var != null) {
                            b(zj8Var);
                            this.g.add(zj8Var);
                            i++;
                            if (zj8Var.getType() != AdvertAppInfo.u) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            zj8 zj8Var2 = Y.get(i);
                            zj8Var = zj8Var2;
                            i2 = zj8Var2.getPosition();
                        }
                    }
                    this.g.add(qo4Var);
                    i3++;
                    if (i3 == 4 && bs7Var.C() != null) {
                        this.g.add(bs7Var.C());
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
