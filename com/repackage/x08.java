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
public abstract class x08 extends j18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public ft7 d;
    public final List<bn> e;
    public boolean f;
    public ArrayList<on> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public x08(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public abstract void D(ft7 ft7Var);

    public void E(hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hu7Var) == null) {
        }
    }

    public abstract void F(ft7 ft7Var);

    public abstract void G(String str);

    public final void H() {
        ft7 ft7Var;
        bl8 bl8Var;
        bl8 bl8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (ft7Var = this.d) == null || ft7Var.b0 || ft7Var.c0 == 2) {
            return;
        }
        ArrayList<PostData> F = ft7Var.F();
        ArrayList<bl8> e = this.d.e();
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
            if (this.d.l() != null) {
                bl8Var4.V0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                bl8Var4.Y0 = og.g(this.d.O().getId(), 0L);
            }
            ft7 ft7Var2 = this.d;
            if (ft7Var2 != null && ft7Var2.y() != null) {
                bl8Var4.Z0 = this.d.y().a();
            }
            b(bl8Var4);
            int position = bl8Var4.getPosition() + this.d.a0;
            if (position >= F.size()) {
                bl8Var4.b1 = position;
                md8.k(bl8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                bl8Var4.b1 = position;
            }
            if (position < 0) {
                md8.j(bl8Var4, 23);
            } else if (h(F, position)) {
                md8.j(bl8Var4, 1);
            } else {
                F.add(position, bl8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", bl8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.repackage.j18
    public ArrayList<on> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(bl8 bl8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, bl8Var) == null) || bl8Var == null || this.d == null || bl8Var.getAdvertAppInfo() == null) {
            return;
        }
        bl8Var.getAdvertAppInfo().i = new ko4();
        if (this.d.y() != null) {
            bl8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        bl8Var.getAdvertAppInfo().i.a = bl8Var.k1();
        if (this.d.l() != null && (l = this.d.l()) != null) {
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

    public abstract dx7 e();

    public abstract zv7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof bl8) {
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
                return this.b.K().t1();
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
                if (onVar instanceof st7) {
                    this.l = i;
                    z = true;
                } else if ((onVar instanceof et7) && ((et7) onVar).a() == this.a) {
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

    public abstract void q(ft7 ft7Var, boolean z, String str, boolean z2);

    public void r(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ft7Var) == null) {
            s(ft7Var, false);
        }
    }

    public void s(ft7 ft7Var, boolean z) {
        bl8 bl8Var;
        PostData postData;
        boolean z2;
        ft7 ft7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048602, this, ft7Var, z) == null) || ft7Var == null) {
            return;
        }
        this.d = ft7Var;
        if (ft7Var != null && ft7Var.O() != null && ft7Var.O().getAuthor() != null) {
            this.h = ft7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = ft7Var.F().iterator();
        while (true) {
            bl8Var = null;
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
        if (postData == null && ft7Var.j() != null) {
            postData = ft7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        F(ft7Var);
        G(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(ft7Var.F()) && ft7Var.F().get(0) != null && ft7Var.O() != null) {
            ft7Var.O().setItem(ft7Var.F().get(0).O());
            ft7Var.O().setItemStar(ft7Var.F().get(0).P());
        }
        if (ft7Var.O() != null && ft7Var.O().getRawThreadInfo() != null) {
            ir4 ir4Var = new ir4();
            ir4Var.t = ft7Var.O();
            ir4Var.n = true;
            this.g.add(ir4Var);
        }
        tt7 tt7Var = new tt7(ft7Var.O(), ft7Var.d());
        tt7Var.j(false);
        tt7Var.b = false;
        this.g.add(tt7Var);
        if (postData == null || postData.i0 == null || (ft7Var.l() != null && TextUtils.equals(ft7Var.l().getName(), this.b.K().p1()) && this.b.K().v1())) {
            z2 = false;
        } else {
            it7 it7Var = new it7(postData.i0);
            it7Var.b = this.b.K().i2();
            this.g.add(it7Var);
            z2 = true;
        }
        if (!z2 && ft7Var.l() != null && !StringUtils.isNull(ft7Var.l().getName()) && (!TextUtils.equals(ft7Var.l().getName(), this.b.K().p1()) || !this.b.K().v1())) {
            ht7 ht7Var = new ht7(ft7Var.l());
            ht7Var.g = this.b.K().i2();
            ht7Var.e = false;
            this.g.add(ht7Var);
            tt7Var.j(false);
            tt7Var.b = false;
        }
        if (ft7Var.O() != null && !StringUtils.isNull(ft7Var.O().getForum_name())) {
            zt7 zt7Var = new zt7();
            zt7Var.a = ft7Var.O();
            this.g.add(zt7Var);
        } else if (ft7Var.O() != null && !StringUtils.isNull(ft7Var.n())) {
            ft7Var.O().setForum_name(ft7Var.n());
            zt7 zt7Var2 = new zt7();
            zt7Var2.a = ft7Var.O();
            this.g.add(zt7Var2);
        }
        if (j() && ft7Var.y() != null && ft7Var.y().c() == 1) {
            nt7 nt7Var = new nt7(nt7.c);
            nt7Var.b(true);
            this.g.add(nt7Var);
        }
        st7 st7Var = new st7(st7.i);
        ThreadData O = ft7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.K().g2();
        st7Var.d = k();
        st7Var.c = ft7Var.g;
        ft7Var.c();
        st7Var.e = ft7Var.i0();
        st7Var.g = ft7Var.f;
        D(ft7Var);
        this.g.add(st7Var);
        if (ft7Var.L() == 4) {
            this.g.add(new rt7());
        }
        H();
        p(i());
        Iterator<PostData> it2 = ft7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.B() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !oi.z()) && ((ft7Var2 = this.d) == null || !ft7Var2.t()))) {
            pt7 pt7Var = new pt7();
            pt7Var.U0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ac7);
            pt7Var.T0 = R.drawable.new_pic_emotion_03;
            pt7Var.V0 = -2;
            pt7Var.W0 = qi.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(pt7Var);
        }
        q(ft7Var, this.j, this.h, this.i);
        if (ft7Var.y().b() == 0) {
            ft7 ft7Var3 = this.d;
            if (ft7Var3 != null && ft7Var3.t()) {
                C(this.b.B().R3());
                this.g.add(new mt7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                B(this.b.B().R3());
                lt7 lt7Var = new lt7();
                lt7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09e8);
                this.g.add(lt7Var);
            }
            List<bl8> Z = ft7Var.Z();
            int i2 = -1;
            if (Z != null && !Z.isEmpty()) {
                bl8Var = Z.get(0);
                i2 = bl8Var.getPosition();
            }
            if (!ListUtils.isEmpty(ft7Var.f())) {
                et7 et7Var = new et7();
                et7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fbd));
                et7Var.c(this.a);
                this.g.add(et7Var);
                int i3 = 1;
                for (wo4 wo4Var : ft7Var.f()) {
                    if (Z != null && i3 == i2) {
                        if (bl8Var != null) {
                            b(bl8Var);
                            this.g.add(bl8Var);
                            i++;
                            if (bl8Var.getType() != AdvertAppInfo.x) {
                                i3++;
                            }
                        }
                        if (i < Z.size()) {
                            bl8 bl8Var2 = Z.get(i);
                            bl8Var = bl8Var2;
                            i2 = bl8Var2.getPosition();
                        }
                    }
                    this.g.add(wo4Var);
                    i3++;
                    if (i3 == 4 && ft7Var.C() != null) {
                        this.g.add(ft7Var.C());
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
