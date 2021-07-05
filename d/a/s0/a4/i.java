package d.a.s0.a4;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginServerConfig.PluginNetConfigInfos;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.j;
import d.a.r0.r.s.a;
import java.lang.reflect.Field;
/* loaded from: classes9.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f57409a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f57410b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f57411c;

        public a(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, str, forumWriteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57409a = tbPageContext;
            this.f57410b = str;
            this.f57411c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.c(this.f57409a, this.f57410b, this.f57411c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f57412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f57413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PluginNetConfigInfos.PluginConfig f57414g;

        public b(TbPageContext tbPageContext, ForumWriteData forumWriteData, PluginNetConfigInfos.PluginConfig pluginConfig) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, forumWriteData, pluginConfig};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57412e = tbPageContext;
            this.f57413f = forumWriteData;
            this.f57414g = pluginConfig;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                e eVar = new e(this.f57412e, this.f57413f, i.f(this.f57412e));
                if (PluginPackageManager.O().Z(XiaoyingUtil.PKG_NAME_VIDEO)) {
                    PluginPackageManager.O().u0(eVar);
                } else {
                    PluginPackageManager.O().x0(this.f57414g, eVar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                PluginPackageManager.O().u0(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements d.a.c.h.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext f57415a;

        /* renamed from: b  reason: collision with root package name */
        public ForumWriteData f57416b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.r0.r.s.d f57417c;

        public e(TbPageContext tbPageContext, ForumWriteData forumWriteData, d.a.r0.r.s.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, forumWriteData, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57415a = null;
            this.f57415a = tbPageContext;
            this.f57416b = forumWriteData;
            this.f57417c = dVar;
        }

        @Override // d.a.c.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) {
                d.a.r0.r.s.d dVar = this.f57417c;
                if (dVar != null) {
                    d.a.c.e.m.g.b(dVar, this.f57415a);
                }
                this.f57415a.showToast(R.string.plugin_video_installing);
            }
        }

        @Override // d.a.c.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData) == null) {
                d.a.r0.r.s.d dVar = this.f57417c;
                if (dVar != null) {
                    d.a.c.e.m.g.b(dVar, this.f57415a);
                }
                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && (tbPageContext = this.f57415a) != null) {
                    tbPageContext.showToast(bdFileDownloadData.getStatusMsg());
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // d.a.c.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2, str) == null) {
                d.a.r0.r.s.d dVar = this.f57417c;
                if (dVar != null) {
                    d.a.c.e.m.g.b(dVar, this.f57415a);
                }
                if (i2 == 0) {
                    i.d(this.f57415a, "", this.f57416b);
                } else {
                    TbPageContext tbPageContext = this.f57415a;
                    tbPageContext.showToast(this.f57415a.getString(R.string.install_failed) + str);
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // d.a.c.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            d.a.r0.r.s.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || (dVar = this.f57417c) == null) {
                return;
            }
            dVar.b((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1 : invokeV.booleanValue;
    }

    public static void c(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
            return;
        }
        if (b()) {
            RecordVideoActivityConfig recordVideoActivityConfig = new RecordVideoActivityConfig(tbPageContext.getPageActivity(), 1, forumWriteData, null, str, 0);
            recordVideoActivityConfig.setShowType(0);
            if (forumWriteData != null) {
                recordVideoActivityConfig.setExtraData(forumWriteData.antiData, forumWriteData.prefixData, forumWriteData.firstDir, forumWriteData.secondDir);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, recordVideoActivityConfig));
        } else if (XiaoyingUtil.isXiaoyingInstalled()) {
            if (XiaoyingUtil.isXiaoyingForbidden()) {
                XiaoyingUtil.showGoPluginDetailDialog(tbPageContext, tbPageContext.getPageActivity().getString(R.string.plugin_video_not_active), tbPageContext.getPageActivity().getString(R.string.setup));
            } else {
                XiaoyingUtil.startXiaoying(tbPageContext.getPageActivity(), false, forumWriteData.forumId, forumWriteData.forumName, str);
            }
        } else if (!j.z()) {
            tbPageContext.showToast(R.string.neterror);
        } else if (d.a.c.h.j.f.d.c().d() == null || (pluginConfig = d.a.c.h.j.f.d.c().d().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) == null) {
        } else {
            PluginNetConfigInfos.Newest newest = pluginConfig.newest;
            float f2 = (newest == null || (i2 = newest.size) <= 0) ? 0.0f : i2 / 1048576.0f;
            String string = tbPageContext.getPageActivity().getString(R.string.plugin_imme_install);
            String string2 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_wifi);
            if (j.x()) {
                String string3 = tbPageContext.getPageActivity().getString(R.string.plugin_video_install_tips_mobile);
                if (f2 > 0.0f) {
                    string2 = string3 + "（" + f2 + "MB）";
                } else {
                    string2 = string3;
                }
                string = tbPageContext.getPageActivity().getString(R.string.install_app);
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(string2);
            aVar.setPositiveButton(string, new b(tbPageContext, forumWriteData, pluginConfig));
            aVar.setNegativeButton(R.string.cancel, new c());
            aVar.create(tbPageContext).show();
        }
    }

    public static void d(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, tbPageContext, str, forumWriteData) == null) || forumWriteData == null || tbPageContext == null) {
            return;
        }
        PermissionJudgePolicy permissionJudgePolicy = new PermissionJudgePolicy();
        permissionJudgePolicy.clearRequestPermissionList();
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_VIDEO_CAPTURE);
        permissionJudgePolicy.appendRequestPermission(tbPageContext.getPageActivity(), PermissionRequest.RESOURCE_AUDIO_CAPTURE);
        permissionJudgePolicy.setOnPermissionsGrantedListener(new a(tbPageContext, str, forumWriteData));
        permissionJudgePolicy.startRequestPermission(tbPageContext.getPageActivity());
    }

    public static void e(EditText editText, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65540, null, editText, i2) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static d.a.r0.r.s.d f(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, tbPageContext)) == null) {
            d.a.r0.r.s.d dVar = new d.a.r0.r.s.d(tbPageContext.getPageActivity());
            dVar.setOnCancelListener(new d());
            dVar.setCancelable(true);
            dVar.setCanceledOnTouchOutside(false);
            dVar.a(tbPageContext.getPageActivity().getString(R.string.on_downloading));
            d.a.c.e.m.g.i(dVar, tbPageContext.getPageActivity());
            return dVar;
        }
        return (d.a.r0.r.s.d) invokeL.objValue;
    }
}
