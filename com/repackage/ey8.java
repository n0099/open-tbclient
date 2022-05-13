package com.repackage;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fy8;
import com.repackage.nr4;
import com.repackage.zx8;
import tbclient.ItemInfo;
/* loaded from: classes6.dex */
public class ey8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public ViewGroup b;
    public zx8 c;
    public boolean d;
    public fy8 e;
    public ForumWriteData f;
    public int g;
    public String h;
    public String i;
    public int j;
    public String k;
    public int l;
    public boolean m;
    @Nullable
    public final gy4 n;
    public fy8.a o;
    public ItemInfo p;

    /* loaded from: classes6.dex */
    public class a implements fy8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey8 a;

        public a(ey8 ey8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ey8Var;
        }

        @Override // com.repackage.fy8.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    this.a.d = true;
                    w55.b().c();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921401, 0));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921467, 0));
                } else if (i == 4) {
                    this.a.d = false;
                    w55.b().o();
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
        public final /* synthetic */ nr4 a;
        public final /* synthetic */ ey8 b;

        public b(ey8 ey8Var, nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, nr4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ey8Var;
            this.a = nr4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nr4 nr4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (nr4Var = this.a) == null) {
                return;
            }
            nr4Var.dismiss();
            iu4.k().u("commodity_goods_show_first_dialog", true);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 1).param("fid", this.b.f.forumId).param("fname", this.b.f.forumName));
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
        }
    }

    /* loaded from: classes6.dex */
    public class c implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ey8 ey8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                nr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumWriteData a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ey8 c;

        public d(ey8 ey8Var, ForumWriteData forumWriteData, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ey8Var, forumWriteData, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ey8Var;
            this.a = forumWriteData;
            this.b = str;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                gf.n().j(false);
                ForumWriteData forumWriteData = this.a;
                if (forumWriteData != null) {
                    String str4 = forumWriteData.forumId;
                    String str5 = forumWriteData.forumName;
                    str3 = forumWriteData.specialForumType;
                    str = str4;
                    str2 = str5;
                } else {
                    str = "0";
                    str2 = null;
                    str3 = null;
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.b).param("obj_type", 4));
                if (this.c.j != 1) {
                    if (this.c.j == 2) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.FRS_PUBLISH_ALA_CLICK).param("fid", str));
                    }
                } else {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.HOME_PUBLISH_ALA_CLICK));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.c.a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public e(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {intentConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = intentConfig;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, this.a));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ey8(TbPageContext tbPageContext, ViewGroup viewGroup, String str, @Nullable gy4 gy4Var) {
        this(tbPageContext, viewGroup, str, 1, gy4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, gy4Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (ViewGroup) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (gy4) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean B(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new e(intentConfig));
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public void A(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, tbPageContext, str, forumWriteData) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
        permissionJudgePolicy.setOnPermissionsGrantedListener(new d(this, forumWriteData, str));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public void C() {
        zx8 zx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zx8Var = this.c) == null) {
            return;
        }
        zx8Var.a();
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.m = z;
        }
    }

    public void E(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, forumWriteData) == null) {
            this.f = forumWriteData;
        }
    }

    public void F(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, itemInfo) == null) {
            this.p = itemInfo;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            zx8 zx8Var = this.c;
            if (zx8Var instanceof zx8.c) {
                ((zx8.c) zx8Var).g(z);
            }
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.k = str;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            zx8 zx8Var = this.c;
            if (zx8Var instanceof zx8.c) {
                ((zx8.c) zx8Var).G.setIconFade(i);
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str == null) {
                str = "";
            }
            this.h = str;
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.l = i;
        }
    }

    public void L(boolean z, View view2, View view3) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), view2, view3}) == null) || this.b == null) {
            return;
        }
        if (this.c.a.getParent() == null) {
            v45.a(this.b).a(this.b, this.c.a, z);
        }
        this.e.a(view2, view3);
        this.e.f();
        TiebaStatic.log(new StatisticItem("c12052").param("obj_locate", this.k));
        if (ki.x()) {
            String q = iu4.k().q("key_baidu_sim_card_writting_tip", "");
            if (!li.isEmpty(q)) {
                BdToast.c(this.a.getContext(), q).q();
                iu4.k().D("key_baidu_sim_card_writting_tip");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : invokeV.intValue;
    }

    @Nullable
    public ForumWriteData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f : (ForumWriteData) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    @NonNull
    public gy4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            gy4 gy4Var = this.n;
            return gy4Var != null ? gy4Var : gy4.b;
        }
        return (gy4) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public final boolean l() {
        InterceptResult invokeV;
        FrsTabInfoData frsTabInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.e.b(z);
            if (z) {
                return;
            }
            zx8 zx8Var = this.c;
            if (zx8Var instanceof zx8.c) {
                ((zx8.c) zx8Var).G.h();
            }
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (this.f != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", this.f.forumName);
                albumFloatActivityConfig.setProfessionZone(this.f.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(this.f.frsTabInfo);
                albumFloatActivityConfig.setCanChangeBarName(false);
                albumFloatActivityConfig.setBarName(this.f.forumName);
                albumFloatActivityConfig.setBarID(this.f.forumId);
                ForumWriteData forumWriteData = this.f;
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.i);
            albumFloatActivityConfig.getIntent().putExtra("write_title", this.h);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.j);
            if (B(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void p(b9 b9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, b9Var) == null) {
            if (hy8.b()) {
                ForumWriteData forumWriteData = this.f;
                if (forumWriteData != null) {
                    hy8.f(b9Var, null, null, forumWriteData.forumId, forumWriteData.forumName, 4, Boolean.FALSE, "", "", "");
                    return;
                } else {
                    hy8.f(b9Var, null, null, null, null, 4, Boolean.TRUE, "", "", "");
                    return;
                }
            }
            o();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            m(false);
            if (Build.VERSION.SDK_INT < 21) {
                nr4 nr4Var = new nr4(this.a.getPageActivity());
                nr4Var.setAutoNight(false);
                nr4Var.setTitle(R.string.obfuscated_res_0x7f0f0f0a);
                nr4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04e7));
                nr4Var.setTitleShowCenter(true);
                nr4Var.setMessageShowCenter(true);
                nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0988, new c(this));
                nr4Var.create(this.a).show();
                return;
            }
            A(this.a, this.k, this.f);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 2));
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (this.f != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", this.f.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", this.f.forumName);
                albumFloatActivityConfig.setProfessionZone(this.f.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(this.f.frsTabInfo);
                ForumWriteData forumWriteData = this.f;
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.i);
            albumFloatActivityConfig.getIntent().putExtra("write_title", this.h);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(false);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.getIntent().putExtra(WriteActivityConfig.RICH_MODE_ENABLE, true);
            albumFloatActivityConfig.setStatisticFrom(this.j);
            if (B(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 1));
            WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.f).setFrom(this.i).setTitle(str).setCallFrom("2").setStatisticFrom(this.j).setRichModeEnable(true).send();
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i) == null) || this.g == i) {
            return;
        }
        this.g = i;
        this.c.c(i);
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!l()) {
                BdToast.i(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0eba), R.drawable.obfuscated_res_0x7f0809be, true).q();
            } else if (!this.m) {
                BdToast.i(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0ebb), R.drawable.obfuscated_res_0x7f0809be, true).q();
            } else {
                if (this.f != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 1).param("fid", this.f.forumId).param("fname", this.f.forumName));
                }
                m(false);
                if (!iu4.k().h("commodity_goods_show_first_dialog", false)) {
                    nr4 nr4Var = new nr4(this.a.getPageActivity());
                    nr4Var.setContentViewSize(2);
                    nr4Var.setCanceledOnTouchOutside(false);
                    FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.a.getPageActivity());
                    frsPublishFineGoodsDialogView.setConfirmButtonListener(new b(this, nr4Var));
                    nr4Var.setContentView(frsPublishFineGoodsDialogView);
                    StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 1);
                    ForumWriteData forumWriteData = this.f;
                    StatisticItem param2 = param.param("fid", forumWriteData != null ? forumWriteData.forumId : "");
                    ForumWriteData forumWriteData2 = this.f;
                    TiebaStatic.log(param2.param("fname", forumWriteData2 != null ? forumWriteData2.forumName : ""));
                    nr4Var.create(this.a).show();
                    return;
                }
                String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=10"));
            }
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
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

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            WorkPublishManager.setObjLocate(this.k);
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 3));
            int a2 = hy8.a();
            if (hy8.c(a2)) {
                hy8.e(this.a.getPageActivity(), a2, i);
            } else if (hy8.b()) {
                ForumWriteData forumWriteData = this.f;
                if (forumWriteData != null) {
                    hy8.g(null, null, forumWriteData.forumId, forumWriteData.forumName, i, Boolean.FALSE);
                } else {
                    hy8.g(null, null, null, null, i, Boolean.TRUE);
                }
            } else {
                o();
            }
        }
    }

    public void x(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            m(false);
            new BjhMasterActivityConfig(TbadkCoreApplication.getInst(), str, str2).start();
            ((n55) ServiceManager.getService(n55.a.a())).c(Long.valueOf(kg.g(str, 0L)), str2);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.k).param("obj_type", 5));
            m(false);
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
            writeVoteActivityConfig.setExtraTitle(str);
            if (this.f == null) {
                this.f = new ForumWriteData("0", null, null, null);
            }
            ForumWriteData forumWriteData = this.f;
            forumWriteData.mFrom = this.i;
            forumWriteData.writeCallFrom = "2";
            forumWriteData.statisticFrom = this.j;
            writeVoteActivityConfig.setExtraData(forumWriteData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 1));
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            m(false);
            if (WriteActivityConfig.isAsyncWriting()) {
                return;
            }
            WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.f).setIsEvaluate(true).setFrom(this.i).setCallFrom("2").setStatisticFrom(this.j);
            ItemInfo itemInfo = this.p;
            if (itemInfo != null) {
                statisticFrom.setScoreItemInfo(new SerializableItemInfo(itemInfo)).setItemIsSchool(this.p.is_school.intValue() == 1).setStarCount(this.p.score.comment_star.intValue());
            }
            statisticFrom.send();
        }
    }

    public ey8(TbPageContext tbPageContext, ViewGroup viewGroup, String str, int i, @Nullable gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup, str, Integer.valueOf(i), gy4Var};
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
        this.h = "";
        this.i = AlbumActivityConfig.FROM_WRITE;
        this.k = "0";
        this.m = false;
        this.o = new a(this);
        this.a = tbPageContext;
        this.b = viewGroup;
        this.i = str;
        if ("main_tab".equals(str)) {
            i4 = 1;
        } else if ("frs".equals(this.i)) {
            i4 = 2;
        }
        this.j = i4;
        this.n = gy4Var;
        if (i == 3) {
            zx8.b bVar = new zx8.b(this.a, this);
            this.c = bVar;
            this.e = new dy8(tbPageContext.getPageActivity(), bVar);
        } else {
            zx8.c cVar = new zx8.c(this.a, this);
            this.c = cVar;
            this.e = new cy8(tbPageContext.getPageActivity(), cVar);
        }
        t(TbadkCoreApplication.getInst().getSkinType());
        this.e.e(this.o);
    }
}
