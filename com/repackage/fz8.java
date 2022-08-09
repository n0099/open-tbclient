package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gz8;
import com.repackage.iz8;
import com.repackage.zy8;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class fz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ViewGroup b;
    public zy8 c;
    public boolean d;
    public gz8 e;
    public ForumWriteData f;
    public int g;
    public iz8 h;
    public String i;
    public String j;
    public int k;
    public String l;
    public int m;
    public boolean n;
    @Nullable
    public final cz4 o;
    public gz8.a p;

    /* loaded from: classes6.dex */
    public class a implements gz8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz8 a;

        public a(fz8 fz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz8Var;
        }

        @Override // com.repackage.gz8.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    this.a.d = true;
                    g75.b().c();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i == 4) {
                    this.a.d = false;
                    g75.b().o();
                    if (this.a.c.a.getParent() == this.a.b && this.a.b != null && this.a.c.a != null && this.a.b.indexOfChild(this.a.c.a) > 0) {
                        this.a.b.removeView(this.a.c.a);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 1));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 1));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur4 a;
        public final /* synthetic */ fz8 b;

        public b(fz8 fz8Var, ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz8Var, ur4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fz8Var;
            this.a = ur4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ur4 ur4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (ur4Var = this.a) == null) {
                return;
            }
            ur4Var.dismiss();
            ru4.k().u("commodity_goods_show_first_dialog", true);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", this.b.f.forumId).param("fname", this.b.f.forumName));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements iz8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz8 a;

        public c(fz8 fz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz8Var;
        }

        @Override // com.repackage.iz8.d
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.a.f != null ? this.a.f.forumId : "0";
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.a.l).param("obj_type", 4));
                if (this.a.k != 1) {
                    if (this.a.k == 2) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fz8(TbPageContext tbPageContext, ViewGroup viewGroup, String str, @Nullable cz4 cz4Var) {
        this(tbPageContext, viewGroup, str, 1, cz4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, cz4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (ViewGroup) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (cz4) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.n = z;
        }
    }

    public void B(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumWriteData) == null) {
            this.f = forumWriteData;
        }
    }

    public void C(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemInfo) == null) {
        }
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            zy8 zy8Var = this.c;
            if (zy8Var instanceof zy8.c) {
                ((zy8.c) zy8Var).g(z);
            }
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            zy8 zy8Var = this.c;
            if (zy8Var instanceof zy8.c) {
                ((zy8.c) zy8Var).G.setIconFade(i);
            }
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.i = str;
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    public void I(boolean z, View view2, View view3) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), view2, view3}) == null) || this.b == null) {
            return;
        }
        if (this.c.a.getParent() == null) {
            e65.a(this.b).a(this.b, this.c.a, z);
        }
        this.e.a(view2, view3);
        this.e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.l));
        if (oi.x()) {
            String q = ru4.k().q("key_baidu_sim_card_writting_tip", "");
            if (!pi.isEmpty(q)) {
                BdToast.b(this.a.getContext(), q).h();
                ru4.k().D("key_baidu_sim_card_writting_tip");
            }
        }
        ForumWriteData forumWriteData = this.f;
        if (forumWriteData == null || (antiData = forumWriteData.antiData) == null || !antiData.getCanGoods()) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.f.forumId).param("fname", this.f.forumName));
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.intValue;
    }

    @Nullable
    public ForumWriteData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f : (ForumWriteData) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    @NonNull
    public cz4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            cz4 cz4Var = this.o;
            return cz4Var != null ? cz4Var : cz4.b;
        }
        return (cz4) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        FrsTabInfoData frsTabInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ForumWriteData forumWriteData = this.f;
            if (forumWriteData != null && (frsTabInfoData = forumWriteData.frsTabInfo) != null && !ListUtils.isEmpty(frsTabInfoData.tabList)) {
                for (FrsTabItemData frsTabItemData : this.f.frsTabInfo.tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.e.b(z);
            if (z) {
                return;
            }
            zy8 zy8Var = this.c;
            if (zy8Var instanceof zy8.c) {
                ((zy8.c) zy8Var).G.h();
            }
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public void o(d9 d9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, d9Var) == null) {
            this.h.c(d9Var, this.f, this.i);
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            m(false);
            this.h.d(this.f, new c(this));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            m(false);
            this.h.f(this.f, this.i);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.l).param("obj_type", 2));
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            m(false);
            this.h.h(this.f, str);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.l).param("obj_type", 1));
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || this.g == i) {
            return;
        }
        this.g = i;
        this.c.c(i);
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (!l()) {
                BdToast b2 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0ed9));
                b2.f(BdToast.ToastIcon.FAILURE);
                b2.h();
            } else if (!this.n) {
                BdToast b3 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0eda));
                b3.f(BdToast.ToastIcon.FAILURE);
                b3.h();
            } else {
                if (this.f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f.forumId).param("fname", this.f.forumName));
                }
                m(false);
                if (!ru4.k().h("commodity_goods_show_first_dialog", false)) {
                    ur4 ur4Var = new ur4(this.a.getPageActivity());
                    ur4Var.setContentViewSize(2);
                    ur4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.a.getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(this, ur4Var));
                    ur4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1);
                    ForumWriteData forumWriteData = this.f;
                    StatisticItem param2 = param.param("fid", forumWriteData != null ? forumWriteData.forumId : "");
                    ForumWriteData forumWriteData2 = this.f;
                    TiebaStatic.log(param2.param("fname", forumWriteData2 != null ? forumWriteData2.forumName : ""));
                    ur4Var.create(this.a).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            View view2 = this.c.a;
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                ViewGroup viewGroup = this.b;
                if (parent == viewGroup) {
                    viewGroup.removeView(this.c.a);
                }
            }
            this.e.d();
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            WorkPublishManager.setObjLocate(this.l);
            m(false);
            this.h.j(this.f, i, this.i);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.l).param("obj_type", 3));
        }
    }

    public void w(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            m(false);
            this.h.n(str, str2);
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.l).param("obj_type", 5));
            m(false);
            this.h.o(str, this.f);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 1));
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            m(false);
            this.h.p(this.f);
        }
    }

    public void z() {
        zy8 zy8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (zy8Var = this.c) == null) {
            return;
        }
        zy8Var.a();
    }

    public fz8(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i, @Nullable cz4 cz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, Integer.valueOf(i), cz4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = 0;
        this.d = false;
        this.g = 3;
        this.i = "";
        this.j = AlbumActivityConfig.FROM_WRITE;
        this.l = "0";
        this.n = false;
        this.p = new a(this);
        this.a = tbPageContext;
        this.b = viewGroup;
        this.j = str;
        if ("main_tab".equals(str)) {
            i4 = 1;
        } else if ("frs".equals(this.j)) {
            i4 = 2;
        }
        this.k = i4;
        this.h = new iz8(tbPageContext, str);
        this.o = cz4Var;
        if (i == 3) {
            zy8.b bVar = new zy8.b(this.a, this);
            this.c = bVar;
            this.e = new dz8(tbPageContext.getPageActivity(), bVar);
        } else {
            zy8.c cVar = new zy8.c(this.a, this);
            this.c = cVar;
            this.e = new cz8(tbPageContext.getPageActivity(), cVar);
        }
        s(TbadkCoreApplication.getInst().getSkinType());
        this.e.e(this.p);
    }
}
