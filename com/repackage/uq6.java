package com.repackage;

import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.util.PageType;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
/* loaded from: classes7.dex */
public class uq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;
        public final /* synthetic */ FrsViewData b;

        public b(TbPageContext tbPageContext, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = frsViewData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                gf.n().j(false);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.a.getPageActivity(), this.b.getForum().getName(), this.b.getForum().getId(), this.b.getUserData().getUserId(), this.b.getForum().getSpecialForumType())));
            }
        }
    }

    public static void a(FrsFragment frsFragment, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65536, null, frsFragment, i) == null) || frsFragment == null) {
            return;
        }
        FrsViewData g0 = frsFragment.g0();
        FrsModelController b0 = frsFragment.b0();
        if (g0 != null) {
            if ((b0 != null || g0.getForum() == null) && !WriteActivityConfig.isAsyncWriting()) {
                int i2 = -1;
                if (b0 != null && de6.a().b(1) != null) {
                    i2 = b0.X();
                }
                WriteActivityConfig.newInstance(frsFragment.getPageContext().getPageActivity()).setType(i).setForumData(g0.getForum()).setAntiData(g0.getAnti()).setCategoryId(i2).send();
            }
        }
    }

    public static void b(TbPageContext tbPageContext, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, frsViewData) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.CAMERA");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.RECORD_AUDIO");
        permissionJudgePolicy.setOnPermissionsGrantedListener(new b(tbPageContext, frsViewData));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public static void c(FrsViewData frsViewData, TbPageContext tbPageContext) {
        Plugin plugin2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, frsViewData, tbPageContext) == null) {
            TiebaStatic.log(new StatisticItem("c11839").param("uid", TbadkCoreApplication.getCurrentAccount()));
            if (tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
                return;
            }
            if (Build.VERSION.SDK_INT < 21) {
                cr4 cr4Var = new cr4(tbPageContext.getPageActivity());
                cr4Var.setAutoNight(false);
                cr4Var.setTitle(R.string.obfuscated_res_0x7f0f0eec);
                cr4Var.setMessage(tbPageContext.getResources().getString(R.string.obfuscated_res_0x7f0f04e1));
                cr4Var.setTitleShowCenter(true);
                cr4Var.setMessageShowCenter(true);
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0984, new a());
                cr4Var.create(tbPageContext).show();
            } else if (!TbadkCoreApplication.isLogin()) {
                if (frsViewData != null && frsViewData.getAnti() != null) {
                    frsViewData.getAnti().setIfpost(1);
                }
                ViewHelper.skipToLoginActivity(tbPageContext.getPageActivity());
            } else {
                AntiData anti = frsViewData.getAnti();
                if (anti != null && (AntiHelper.n(anti) || AntiHelper.g(anti) || AntiHelper.h(anti))) {
                    anti.setBlock_forum_name(frsViewData.getForum().getName());
                    anti.setBlock_forum_id(frsViewData.getForum().getId());
                    anti.setUser_name(frsViewData.getUserData().getUserName());
                    anti.setUser_id(frsViewData.getUserData().getUserId());
                    if (AntiHelper.x(tbPageContext.getPageActivity(), anti, AntiHelper.OperationType.CREATE_THREAD, PageType.FRS)) {
                        return;
                    }
                }
                if (!BdBaseApplication.getInst().isDebugMode() && (plugin2 = PluginCenter.getInstance().getPlugin("com.baidu.tieba.pluginAla")) != null && !plugin2.isLoaded()) {
                    oi.M(tbPageContext.getPageActivity(), R.string.obfuscated_res_0x7f0f0e5a);
                } else if (frsViewData.getUserData() != null) {
                    b(tbPageContext, frsViewData);
                }
            }
        }
    }
}
