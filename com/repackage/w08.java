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
public abstract class w08 extends i18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public et7 d;
    public final List<bn> e;
    public boolean f;
    public ArrayList<on> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public w08(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
        }
    }

    public abstract void B(View.OnClickListener onClickListener);

    public abstract void C(View.OnClickListener onClickListener);

    public abstract void D(et7 et7Var);

    public void E(gu7 gu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gu7Var) == null) {
        }
    }

    public abstract void F(et7 et7Var);

    public abstract void G(String str);

    public final void H() {
        et7 et7Var;
        al8 al8Var;
        al8 al8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (et7Var = this.d) == null || et7Var.b0 || et7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = et7Var.F();
        ArrayList<al8> e = this.d.e();
        if (e == null || e.isEmpty() || F == null || F.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<al8> it = e.iterator();
        while (it.hasNext()) {
            al8 next = it.next();
            if (next != null && next.j1() != null) {
                sb.append(next.j1());
                sb.append(",");
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Iterator<al8> it2 = e.iterator();
        while (it2.hasNext()) {
            al8 next2 = it2.next();
            if (next2 != null) {
                next2.b1 = next2.getPosition() - 1;
            }
        }
        SparseArray sparseArray = new SparseArray();
        Iterator<al8> it3 = e.iterator();
        while (it3.hasNext()) {
            al8 next3 = it3.next();
            if (next3.getAdvertAppInfo() != null) {
                int n = next3.getAdvertAppInfo().n();
                if (n != 0) {
                    ld8.j(next3, n);
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
            al8 al8Var3 = (al8) sparseArray.get(sparseArray.keyAt(i));
            if (al8Var3 != null && (al8Var2 = (al8) hashMap.put(al8Var3.i1(), al8Var3)) != null) {
                ld8.j(al8Var2, 30);
            }
        }
        sparseArray.clear();
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry != null && (al8Var = (al8) entry.getValue()) != null) {
                sparseArray.put(al8Var.getPosition(), al8Var);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            arrayList.add(Integer.valueOf(sparseArray.keyAt(i2)));
        }
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            al8 al8Var4 = (al8) sparseArray.get(((Integer) arrayList.get(i3)).intValue());
            if (this.d.l() != null) {
                al8Var4.V0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                al8Var4.Y0 = og.g(this.d.O().getId(), 0L);
            }
            et7 et7Var2 = this.d;
            if (et7Var2 != null && et7Var2.y() != null) {
                al8Var4.Z0 = this.d.y().a();
            }
            b(al8Var4);
            int position = al8Var4.getPosition() + this.d.a0;
            if (position >= F.size()) {
                al8Var4.b1 = position;
                ld8.k(al8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                al8Var4.b1 = position;
            }
            if (position < 0) {
                ld8.j(al8Var4, 23);
            } else if (h(F, position)) {
                ld8.j(al8Var4, 1);
            } else {
                F.add(position, al8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", al8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.repackage.i18
    public ArrayList<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(al8 al8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, al8Var) == null) || al8Var == null || this.d == null || al8Var.getAdvertAppInfo() == null) {
            return;
        }
        al8Var.getAdvertAppInfo().i = new ko4();
        if (this.d.y() != null) {
            al8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        al8Var.getAdvertAppInfo().i.a = al8Var.k1();
        if (this.d.l() != null && (l = this.d.l()) != null) {
            al8Var.getAdvertAppInfo().i.c = l.getId();
            al8Var.getAdvertAppInfo().i.d = l.getFirst_class();
            al8Var.getAdvertAppInfo().i.e = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            al8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        al8Var.getAdvertAppInfo().i.g = al8Var.getAdvertAppInfo().g;
        al8Var.getAdvertAppInfo().i.h = false;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    public abstract cx7 e();

    public abstract yv7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof al8) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? 12 == this.k : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.b.K() != null) {
                return this.b.K().v1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (this.c.getAdapter() instanceof BdRecyclerAdapter)) {
            this.c.getAdapter().notifyDataSetChanged();
        }
    }

    public abstract void m();

    public abstract void n();

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.g.size(); i++) {
                on onVar = this.g.get(i);
                if (onVar instanceof rt7) {
                    this.l = i;
                    z = true;
                } else if ((onVar instanceof dt7) && ((dt7) onVar).a() == this.a) {
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

    public abstract void q(et7 et7Var, boolean z, String str, boolean z2);

    public void r(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, et7Var) == null) {
            s(et7Var, false);
        }
    }

    public void s(et7 et7Var, boolean z) {
        al8 al8Var;
        PostData postData;
        boolean z2;
        et7 et7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, et7Var, z) == null) || et7Var == null) {
            return;
        }
        this.d = et7Var;
        if (et7Var != null && et7Var.O() != null && et7Var.O().getAuthor() != null) {
            this.h = et7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = et7Var.F().iterator();
        while (true) {
            al8Var = null;
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
        if (postData == null && et7Var.j() != null) {
            postData = et7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(et7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(et7Var.F()) && et7Var.F().get(0) != null && et7Var.O() != null) {
            et7Var.O().setItem(et7Var.F().get(0).O());
            et7Var.O().setItemStar(et7Var.F().get(0).P());
        }
        if (et7Var.O() != null && et7Var.O().getRawThreadInfo() != null) {
            ir4 ir4Var = new ir4();
            ir4Var.t = et7Var.O();
            ir4Var.n = true;
            this.g.add(ir4Var);
        }
        st7 st7Var = new st7(et7Var.O(), et7Var.d());
        st7Var.j(false);
        st7Var.b = false;
        this.g.add(st7Var);
        if (postData == null || postData.i0 == null || (et7Var.l() != null && TextUtils.equals(et7Var.l().getName(), this.b.K().r1()) && this.b.K().x1())) {
            z2 = false;
        } else {
            ht7 ht7Var = new ht7(postData.i0);
            ht7Var.b = this.b.K().m2();
            this.g.add(ht7Var);
            z2 = true;
        }
        if (!z2 && et7Var.l() != null && !StringUtils.isNull(et7Var.l().getName()) && (!TextUtils.equals(et7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
            gt7 gt7Var = new gt7(et7Var.l());
            gt7Var.g = this.b.K().m2();
            gt7Var.e = false;
            this.g.add(gt7Var);
            st7Var.j(false);
            st7Var.b = false;
        }
        if (et7Var.O() != null && !StringUtils.isNull(et7Var.O().getForum_name())) {
            yt7 yt7Var = new yt7();
            yt7Var.a = et7Var.O();
            this.g.add(yt7Var);
        } else if (et7Var.O() != null && !StringUtils.isNull(et7Var.n())) {
            et7Var.O().setForum_name(et7Var.n());
            yt7 yt7Var2 = new yt7();
            yt7Var2.a = et7Var.O();
            this.g.add(yt7Var2);
        }
        if (j() && et7Var.y() != null && et7Var.y().c() == 1) {
            mt7 mt7Var = new mt7(mt7.c);
            mt7Var.b(true);
            this.g.add(mt7Var);
        }
        rt7 rt7Var = new rt7(rt7.i);
        ThreadData O = et7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.K().k2();
        rt7Var.d = k();
        rt7Var.c = et7Var.g;
        et7Var.c();
        rt7Var.e = et7Var.i0();
        rt7Var.g = et7Var.f;
        D(et7Var);
        this.g.add(rt7Var);
        if (et7Var.L() == 4) {
            this.g.add(new qt7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = et7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.B() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !oi.z()) && ((et7Var2 = this.d) == null || !et7Var2.t()))) {
            ot7 ot7Var = new ot7();
            ot7Var.U0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ac8);
            ot7Var.T0 = R.drawable.new_pic_emotion_03;
            ot7Var.V0 = -2;
            ot7Var.W0 = qi.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(ot7Var);
        }
        q(et7Var, this.j, this.h, this.i);
        if (et7Var.y().b() == 0) {
            et7 et7Var3 = this.d;
            if (et7Var3 != null && et7Var3.t()) {
                C(this.b.B().R3());
                this.g.add(new lt7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().R3());
                kt7 kt7Var = new kt7();
                kt7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e9);
                this.g.add(kt7Var);
            }
            List<al8> Z = et7Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                al8Var = Z.get(0);
                i2 = al8Var.getPosition();
            }
            if (!ListUtils.isEmpty(et7Var.f())) {
                dt7 dt7Var = new dt7();
                dt7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fbe));
                dt7Var.c(this.a);
                this.g.add(dt7Var);
                int i3 = 1;
                for (wo4 wo4Var : et7Var.f()) {
                    if (Z != null && i3 == i2) {
                        if (al8Var != null) {
                            b(al8Var);
                            this.g.add(al8Var);
                            i++;
                            if (al8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            al8 al8Var2 = Z.get(i);
                            al8Var = al8Var2;
                            i2 = al8Var2.getPosition();
                        }
                    }
                    this.g.add(wo4Var);
                    i3++;
                    if (i3 == 4 && et7Var.C() != null) {
                        this.g.add(et7Var.C());
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
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.j = z;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.f = z;
        }
    }

    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, onClickListener) == null) {
        }
    }

    public abstract void w(boolean z);

    public void x(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, yVar) == null) {
        }
    }

    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onLongClickListener) == null) {
        }
    }

    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, fVar) == null) {
        }
    }
}
