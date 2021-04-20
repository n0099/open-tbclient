package d.b.i0.q0.n2;

import android.os.Build;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
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
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.b.h0.r.s.a;
import d.b.i0.q0.d0;
/* loaded from: classes4.dex */
public class n {

    /* loaded from: classes4.dex */
    public static class a implements a.e {
        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f59779a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FrsViewData f59780b;

        public b(TbPageContext tbPageContext, FrsViewData frsViewData) {
            this.f59779a = tbPageContext;
            this.f59780b = frsViewData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
            d.b.c.e.i.a.l().h(false);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.f59779a.getPageActivity(), this.f59780b.getForum().getName(), this.f59780b.getForum().getId(), this.f59780b.getUserData().getUserId(), this.f59780b.getForum().getSpecialForumType())));
        }
    }

    public static void a() {
        PluginPackageManager.O().u0(null);
    }

    public static void b(FrsFragment frsFragment, int i) {
        if (frsFragment == null) {
            return;
        }
        FrsViewData S = frsFragment.S();
        FrsModelController M = frsFragment.M();
        if (S != null) {
            if ((M != null || S.getForum() == null) && !WriteActivityConfig.isAsyncWriting()) {
                int i2 = -1;
                if (M != null && d0.a().b(1) != null) {
                    i2 = M.R();
                }
                WriteActivityConfig.newInstance(frsFragment.getPageContext().getPageActivity()).setType(i).setForumData(S.getForum()).setAntiData(S.getAnti()).setCategoryId(i2).send();
            }
        }
    }

    public static void c(TbPageContext tbPageContext, FrsViewData frsViewData) {
        if (tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new b(tbPageContext, frsViewData));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public static void d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        Plugin plugin2;
        TiebaStatic.log(new StatisticItem("c11839").param("uid", TbadkCoreApplication.getCurrentAccount()));
        if (tbPageContext == null || frsViewData == null || frsViewData.getForum() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
            aVar.setAutoNight(false);
            aVar.setTitle(R.string.prompt);
            aVar.setMessage(tbPageContext.getResources().getString(R.string.disallow_open_live_by_android_v5_0));
            aVar.setTitleShowCenter(true);
            aVar.setMessageShowCenter(true);
            aVar.setPositiveButton(R.string.know, new a());
            aVar.create(tbPageContext).show();
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
                d.b.c.e.p.l.K(tbPageContext.getPageActivity(), R.string.plugin_config_not_found);
            } else if (frsViewData.getUserData() != null) {
                c(tbPageContext, frsViewData);
            }
        }
    }
}
