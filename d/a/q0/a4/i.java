package d.a.q0.a4;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
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
import d.a.d.e.p.j;
import d.a.p0.s.s.a;
import java.lang.reflect.Field;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f54698a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f54699b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f54700c;

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
            this.f54698a = tbPageContext;
            this.f54699b = str;
            this.f54700c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                i.c(this.f54698a, this.f54699b, this.f54700c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f54701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f54702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PluginNetConfigInfos.PluginConfig f54703g;

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
            this.f54701e = tbPageContext;
            this.f54702f = forumWriteData;
            this.f54703g = pluginConfig;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                e eVar = new e(this.f54701e, this.f54702f, i.f(this.f54701e));
                if (PluginPackageManager.O().Z(XiaoyingUtil.PKG_NAME_VIDEO)) {
                    PluginPackageManager.O().u0(eVar);
                } else {
                    PluginPackageManager.O().x0(this.f54703g, eVar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public static class e implements d.a.d.h.j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext f54704a;

        /* renamed from: b  reason: collision with root package name */
        public ForumWriteData f54705b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.p0.s.s.d f54706c;

        public e(TbPageContext tbPageContext, ForumWriteData forumWriteData, d.a.p0.s.s.d dVar) {
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
            this.f54704a = null;
            this.f54704a = tbPageContext;
            this.f54705b = forumWriteData;
            this.f54706c = dVar;
        }

        @Override // d.a.d.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdFileDownloadData) == null) {
                d.a.p0.s.s.d dVar = this.f54706c;
                if (dVar != null) {
                    d.a.d.e.m.g.b(dVar, this.f54704a);
                }
                this.f54704a.showToast(R.string.plugin_video_installing);
            }
        }

        @Override // d.a.d.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            TbPageContext tbPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdFileDownloadData) == null) {
                d.a.p0.s.s.d dVar = this.f54706c;
                if (dVar != null) {
                    d.a.d.e.m.g.b(dVar, this.f54704a);
                }
                if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && (tbPageContext = this.f54704a) != null) {
                    tbPageContext.showToast(bdFileDownloadData.getStatusMsg());
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // d.a.d.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, bdFileDownloadData, i2, str) == null) {
                d.a.p0.s.s.d dVar = this.f54706c;
                if (dVar != null) {
                    d.a.d.e.m.g.b(dVar, this.f54704a);
                }
                if (i2 == 0) {
                    i.d(this.f54704a, "", this.f54705b);
                } else {
                    TbPageContext tbPageContext = this.f54704a;
                    tbPageContext.showToast(this.f54704a.getString(R.string.install_failed) + str);
                }
                PluginPackageManager.O().u0(null);
            }
        }

        @Override // d.a.d.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            d.a.p0.s.s.d dVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bdFileDownloadData) == null) || bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || (dVar = this.f54706c) == null) {
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
        } else if (d.a.d.h.j.f.d.c().d() == null || (pluginConfig = d.a.d.h.j.f.d.c().d().getPluginConfig(XiaoyingUtil.PKG_NAME_VIDEO)) == null) {
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
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(tbPageContext.getPageActivity());
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
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, editText, i2) == null) {
            try {
                Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, Integer.valueOf(i2));
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static d.a.p0.s.s.d f(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, tbPageContext)) == null) {
            d.a.p0.s.s.d dVar = new d.a.p0.s.s.d(tbPageContext.getPageActivity());
            dVar.setOnCancelListener(new d());
            dVar.setCancelable(true);
            dVar.setCanceledOnTouchOutside(false);
            dVar.a(tbPageContext.getPageActivity().getString(R.string.on_downloading));
            d.a.d.e.m.g.i(dVar, tbPageContext.getPageActivity());
            return dVar;
        }
        return (d.a.p0.s.s.d) invokeL.objValue;
    }
}
