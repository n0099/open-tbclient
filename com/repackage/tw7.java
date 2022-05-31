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
public abstract class tw7 extends fx7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public DetailInfoAndReplyFragment b;
    public BdTypeRecyclerView c;
    public kp7 d;
    public final List<wm> e;
    public boolean f;
    public ArrayList<jn> g;
    public String h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;

    public tw7(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public abstract void C(kp7 kp7Var);

    public void D(mq7 mq7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mq7Var) == null) {
        }
    }

    public abstract void E(kp7 kp7Var);

    public abstract void F(String str);

    public final void G() {
        kp7 kp7Var;
        ah8 ah8Var;
        ah8 ah8Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (kp7Var = this.d) == null || kp7Var.a0 || kp7Var.b0 == 2) {
            return;
        }
        ArrayList<PostData> F = kp7Var.F();
        ArrayList<ah8> e = this.d.e();
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
            if (this.d.l() != null) {
                ah8Var4.H0 = this.d.l().getId();
            }
            if (this.d.O() != null) {
                ah8Var4.K0 = jg.g(this.d.O().getId(), 0L);
            }
            kp7 kp7Var2 = this.d;
            if (kp7Var2 != null && kp7Var2.y() != null) {
                ah8Var4.L0 = this.d.y().a();
            }
            b(ah8Var4);
            int position = ah8Var4.getPosition() + this.d.Z;
            if (position >= F.size()) {
                ah8Var4.N0 = position;
                c98.k(ah8Var4, 2, position + i3, F.size());
                return;
            }
            if (!this.f) {
                position--;
                ah8Var4.N0 = position;
            }
            if (position < 0) {
                c98.j(ah8Var4, 23);
            } else if (h(F, position)) {
                c98.j(ah8Var4, 1);
            } else {
                F.add(position, ah8Var4);
                TiebaStatic.eventStat(this.b.getPageContext().getPageActivity(), CommonStatisticKey.PB_SHOW_APP, "", 1, "app_name", ah8Var4.getAdvertAppInfo().p);
            }
        }
    }

    @Override // com.repackage.fx7
    public ArrayList<jn> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : (ArrayList) invokeV.objValue;
    }

    public final void b(ah8 ah8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ah8Var) == null) || ah8Var == null || this.d == null || ah8Var.getAdvertAppInfo() == null) {
            return;
        }
        ah8Var.getAdvertAppInfo().i = new tm4();
        if (this.d.y() != null) {
            ah8Var.getAdvertAppInfo().i.b = this.d.y().a();
        }
        ah8Var.getAdvertAppInfo().i.a = ah8Var.O0();
        if (this.d.l() != null && (l = this.d.l()) != null) {
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

    public abstract ht7 e();

    public abstract cs7 f();

    public abstract PbFirstFloorCommentAndPraiseAdapter g();

    public final boolean h(ArrayList<PostData> arrayList, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, arrayList, i)) == null) {
            for (int max = Math.max(i - 4, 0); max < arrayList.size() && max < i + 4; max++) {
                if (arrayList.get(max) instanceof ah8) {
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
                jn jnVar = this.g.get(i);
                if (jnVar instanceof xp7) {
                    this.l = i;
                    z = true;
                } else if ((jnVar instanceof jp7) && ((jp7) jnVar).a() == this.a) {
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

    public abstract void q(kp7 kp7Var, boolean z, String str, boolean z2);

    public void r(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, kp7Var) == null) {
            s(kp7Var, false);
        }
    }

    public void s(kp7 kp7Var, boolean z) {
        ah8 ah8Var;
        PostData postData;
        boolean z2;
        kp7 kp7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, kp7Var, z) == null) || kp7Var == null) {
            return;
        }
        this.d = kp7Var;
        if (kp7Var != null && kp7Var.O() != null && kp7Var.O().getAuthor() != null) {
            this.h = kp7Var.O().getAuthor().getUserId();
        }
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        this.g.clear();
        Iterator<PostData> it = kp7Var.F().iterator();
        while (true) {
            ah8Var = null;
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
        if (postData == null && kp7Var.j() != null) {
            postData = kp7Var.j();
        }
        if (postData != null) {
            this.g.add(postData);
        }
        E(kp7Var);
        F(this.h);
        int i = 0;
        if (!ListUtils.isEmpty(kp7Var.F()) && kp7Var.F().get(0) != null && kp7Var.O() != null) {
            kp7Var.O().setItem(kp7Var.F().get(0).J());
            kp7Var.O().setItemStar(kp7Var.F().get(0).K());
        }
        if (kp7Var.O() != null && kp7Var.O().getRawThreadInfo() != null) {
            rp4 rp4Var = new rp4();
            rp4Var.s = kp7Var.O();
            rp4Var.n = true;
            this.g.add(rp4Var);
        }
        yp7 yp7Var = new yp7(kp7Var.O(), kp7Var.d());
        yp7Var.j(false);
        yp7Var.b = false;
        this.g.add(yp7Var);
        if (postData == null || postData.o0 == null || (kp7Var.l() != null && TextUtils.equals(kp7Var.l().getName(), this.b.v().o1()) && this.b.v().u1())) {
            z2 = false;
        } else {
            np7 np7Var = new np7(postData.o0);
            np7Var.b = this.b.v().h2();
            this.g.add(np7Var);
            z2 = true;
        }
        if (!z2 && kp7Var.l() != null && !StringUtils.isNull(kp7Var.l().getName()) && (!TextUtils.equals(kp7Var.l().getName(), this.b.v().o1()) || !this.b.v().u1())) {
            mp7 mp7Var = new mp7(kp7Var.l());
            mp7Var.g = this.b.v().h2();
            mp7Var.e = false;
            this.g.add(mp7Var);
            yp7Var.j(false);
            yp7Var.b = false;
        }
        if (kp7Var.O() != null && !StringUtils.isNull(kp7Var.O().getForum_name())) {
            eq7 eq7Var = new eq7();
            eq7Var.a = kp7Var.O();
            this.g.add(eq7Var);
        } else if (kp7Var.O() != null && !StringUtils.isNull(kp7Var.n())) {
            kp7Var.O().setForum_name(kp7Var.n());
            eq7 eq7Var2 = new eq7();
            eq7Var2.a = kp7Var.O();
            this.g.add(eq7Var2);
        }
        if (j() && kp7Var.y() != null && kp7Var.y().c() == 1) {
            sp7 sp7Var = new sp7(sp7.c);
            sp7Var.b(true);
            this.g.add(sp7Var);
        }
        xp7 xp7Var = new xp7(xp7.h);
        ThreadData O = kp7Var.O();
        if (O != null) {
            O.getReply_num();
        }
        this.b.v().f2();
        xp7Var.d = k();
        xp7Var.c = kp7Var.g;
        kp7Var.c();
        xp7Var.e = kp7Var.g0();
        xp7Var.g = kp7Var.f;
        C(kp7Var);
        this.g.add(xp7Var);
        if (kp7Var.L() == 4) {
            this.g.add(new wp7());
        }
        G();
        p(i());
        Iterator<PostData> it2 = kp7Var.F().iterator();
        boolean z3 = false;
        while (it2.hasNext()) {
            PostData next2 = it2.next();
            if ((next2 instanceof PostData) && next2.A() != 1) {
                this.g.add(next2);
                z3 = true;
            }
        }
        if (!z3 && ((!z || !ji.z()) && ((kp7Var2 = this.d) == null || !kp7Var2.t()))) {
            up7 up7Var = new up7();
            up7Var.G0 = TbadkCoreApplication.getInst().getContext().getString(R.string.obfuscated_res_0x7f0f0ac5);
            up7Var.F0 = R.drawable.new_pic_emotion_03;
            up7Var.H0 = -2;
            up7Var.I0 = li.f(this.b.getContext(), R.dimen.tbds74);
            this.g.add(up7Var);
        }
        q(kp7Var, this.j, this.h, this.i);
        if (kp7Var.y().b() == 0) {
            kp7 kp7Var3 = this.d;
            if (kp7Var3 != null && kp7Var3.t()) {
                B(this.b.s().d3());
                this.g.add(new rp7());
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_PB_FOLD_ICON_SHOW);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("fid", this.d.m());
                statisticItem.param("fname", this.d.n());
                statisticItem.param("tid", this.d.Q());
                TiebaStatic.log(statisticItem);
            } else if (z3) {
                A(this.b.s().d3());
                qp7 qp7Var = new qp7();
                qp7Var.a = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f09f3);
                this.g.add(qp7Var);
            }
            List<ah8> Y = kp7Var.Y();
            int i2 = -1;
            if (Y != null && !Y.isEmpty()) {
                ah8Var = Y.get(0);
                i2 = ah8Var.getPosition();
            }
            if (!ListUtils.isEmpty(kp7Var.f())) {
                jp7 jp7Var = new jp7();
                jp7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f99));
                jp7Var.e(this.a);
                this.g.add(jp7Var);
                int i3 = 1;
                for (fn4 fn4Var : kp7Var.f()) {
                    if (Y != null && i3 == i2) {
                        if (ah8Var != null) {
                            b(ah8Var);
                            this.g.add(ah8Var);
                            i++;
                            if (ah8Var.getType() != AdvertAppInfo.u) {
                                i3++;
                            }
                        }
                        if (i < Y.size()) {
                            ah8 ah8Var2 = Y.get(i);
                            ah8Var = ah8Var2;
                            i2 = ah8Var2.getPosition();
                        }
                    }
                    this.g.add(fn4Var);
                    i3++;
                    if (i3 == 4 && kp7Var.C() != null) {
                        this.g.add(kp7Var.C());
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
