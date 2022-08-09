package com.repackage;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.BaseWriteConfig;
import com.baidu.tbadk.core.atomData.BjhMasterActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.repackage.ur4;
/* loaded from: classes6.dex */
public class iz8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public String b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public String l;
    public String m;

    /* loaded from: classes6.dex */
    public class a implements ur4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(iz8 iz8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.ur4.e
        public void onClick(ur4 ur4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ur4Var) == null) {
                ur4Var.dismiss();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumWriteData a;
        public final /* synthetic */ d b;
        public final /* synthetic */ iz8 c;

        public b(iz8 iz8Var, ForumWriteData forumWriteData, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz8Var, forumWriteData, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = iz8Var;
            this.a = forumWriteData;
            this.b = dVar;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_ALA_VERIFY_STRATEGY));
                kf.n().j(false);
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
                d dVar = this.b;
                if (dVar != null) {
                    dVar.onSuccess();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaMasterLiveRoomActivityConfig(this.c.a.getPageActivity(), str2, str, TbadkCoreApplication.getCurrentAccount(), str3)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IntentConfig a;

        public c(IntentConfig intentConfig) {
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

    /* loaded from: classes6.dex */
    public interface d {
        void onSuccess();
    }

    public iz8(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = AlbumActivityConfig.FROM_WRITE;
        this.e = 1;
        this.f = 2;
        this.g = 3;
        this.h = 4;
        this.i = 8;
        this.j = 2;
        this.k = 8;
        this.l = "1";
        this.m = "0";
        this.a = tbPageContext;
        this.b = str;
        this.c = "main_tab".equals(str) ? 1 : "frs".equals(this.b) ? 2 : 0;
    }

    public static boolean r(Activity activity, IntentConfig intentConfig) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, activity, intentConfig)) == null) {
            PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
            permissionJudgePolicy.clearRequestPermissionList();
            permissionJudgePolicy.appendRequestPermission(activity, "android.permission.WRITE_EXTERNAL_STORAGE");
            permissionJudgePolicy.setOnPermissionsGrantedListener(new c(intentConfig));
            return permissionJudgePolicy.startRequestPermission(activity);
        }
        return invokeLL.booleanValue;
    }

    public final void b(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, forumWriteData, str) == null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
            if (forumWriteData != null) {
                albumFloatActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
                albumFloatActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
                albumFloatActivityConfig.setProfessionZone(forumWriteData.defaultZone);
                albumFloatActivityConfig.setFrsTabInfo(forumWriteData.frsTabInfo);
                albumFloatActivityConfig.setCanChangeBarName(false);
                albumFloatActivityConfig.setBarName(forumWriteData.forumName);
                albumFloatActivityConfig.setBarID(forumWriteData.forumId);
                albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            albumFloatActivityConfig.getIntent().putExtra("from", this.b);
            albumFloatActivityConfig.getIntent().putExtra(BaseWriteConfig.TITLE, str);
            albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
            albumFloatActivityConfig.setAlbumThread(0);
            albumFloatActivityConfig.setCanSelectVideo(true);
            albumFloatActivityConfig.setCanSelectOnlyVideo(true);
            albumFloatActivityConfig.setCanEditImage(false);
            albumFloatActivityConfig.setFromWrite(4);
            albumFloatActivityConfig.setCallFrom("2");
            albumFloatActivityConfig.setStatisticFrom(this.c);
            if (r(this.a.getPageActivity(), albumFloatActivityConfig)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
        }
    }

    public void c(d9 d9Var, ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d9Var, forumWriteData, str) == null) {
            if (!jz8.b()) {
                b(forumWriteData, str);
                return;
            }
            if (forumWriteData != null) {
                jz8.f(d9Var, null, null, forumWriteData.forumId, forumWriteData.forumName, 4, Boolean.FALSE, "", "", "");
            } else {
                jz8.f(d9Var, null, null, null, null, 4, Boolean.TRUE, "", "", "");
            }
        }
    }

    public void d(ForumWriteData forumWriteData, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumWriteData, dVar) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                ur4 ur4Var = new ur4(this.a.getPageActivity());
                ur4Var.setAutoNight(false);
                ur4Var.setTitle(R.string.obfuscated_res_0x7f0f0f2b);
                ur4Var.setMessage(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f04f2));
                ur4Var.setTitleShowCenter(true);
                ur4Var.setMessageShowCenter(true);
                ur4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f09a0, new a(this));
                ur4Var.create(this.a).show();
                return;
            }
            q(this.a, dVar, forumWriteData);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public void f(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, forumWriteData, str) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getPageActivity(), "", true, true);
        if (forumWriteData != null) {
            albumFloatActivityConfig.getIntent().putExtra("forum_id", forumWriteData.forumId);
            albumFloatActivityConfig.getIntent().putExtra("forum_name", forumWriteData.forumName);
            albumFloatActivityConfig.setProfessionZone(forumWriteData.defaultZone);
            albumFloatActivityConfig.setFrsTabInfo(forumWriteData.frsTabInfo);
            albumFloatActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
        }
        albumFloatActivityConfig.getIntent().putExtra("from", this.b);
        albumFloatActivityConfig.getIntent().putExtra(BaseWriteConfig.TITLE, str);
        albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
        albumFloatActivityConfig.setAlbumThread(0);
        albumFloatActivityConfig.setCanSelectVideo(false);
        albumFloatActivityConfig.setCanEditImage(false);
        albumFloatActivityConfig.setFromWrite(4);
        albumFloatActivityConfig.setCallFrom("2");
        albumFloatActivityConfig.getIntent().putExtra(WriteActivityConfig.RICH_MODE_ENABLE, !this.d);
        albumFloatActivityConfig.setStatisticFrom(this.c);
        if (r(this.a.getPageActivity(), albumFloatActivityConfig)) {
            return;
        }
        g();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.g);
            TiebaStatic.log(statisticItem);
        }
    }

    public void h(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, forumWriteData, str) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setFrom(this.b).setTitle(str).setCallFrom("2").setStatisticFrom(this.c).setRichModeEnable(!this.d).setRichTextMode(this.d).setFromArticle(this.l).send();
        i();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.i);
            TiebaStatic.log(statisticItem);
        }
    }

    public void j(ForumWriteData forumWriteData, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, forumWriteData, i, str) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        int a2 = jz8.a();
        if (jz8.c(a2)) {
            jz8.e(this.a.getPageActivity(), a2, i);
        } else if (!jz8.b()) {
            b(forumWriteData, str);
        } else if (forumWriteData != null) {
            jz8.g(null, null, forumWriteData.forumId, forumWriteData.forumName, i, Boolean.FALSE);
        } else {
            jz8.g(null, null, null, null, i, Boolean.TRUE);
        }
        m();
    }

    public void k(ForumWriteData forumWriteData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, forumWriteData, str) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setFrom(this.b).setTitle(str).setCallFrom("2").setStatisticFrom(this.c).setFromArticle(this.m).send();
        l();
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.e);
            TiebaStatic.log(statisticItem);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
            if ("main_tab".equals(this.b)) {
                statisticItem.param("obj_locate", this.k);
            } else {
                statisticItem.param("obj_locate", this.j);
            }
            statisticItem.param("obj_type", this.f);
            TiebaStatic.log(statisticItem);
        }
    }

    public void n(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            new BjhMasterActivityConfig(TbadkCoreApplication.getInst(), str, str2).start();
            ((x65) ServiceManager.getService(x65.a.a())).c(Long.valueOf(og.g(str, 0L)), str2);
        }
    }

    public void o(String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, forumWriteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
            writeVoteActivityConfig.setExtraTitle(str);
            if (forumWriteData == null) {
                forumWriteData = new ForumWriteData("0", null, null, null);
            }
            forumWriteData.mFrom = this.b;
            forumWriteData.writeCallFrom = "2";
            forumWriteData.statisticFrom = this.c;
            writeVoteActivityConfig.setExtraData(forumWriteData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    public void p(ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, forumWriteData) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(forumWriteData).setIsQuestionThread(true).setFrom(this.b).setCallFrom("2").setStatisticFrom(this.c).send();
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", this.c == 1 ? 8 : 2).param("obj_type", 8));
    }

    public final void q(TbPageContext tbPageContext, d dVar, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048591, this, tbPageContext, dVar, forumWriteData) == null) || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new b(this, forumWriteData, dVar));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
        e();
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.d = z;
        }
    }
}
