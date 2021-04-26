package d.a.j0.v3;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.PublishVideoThreadSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.webkit.sdk.PermissionRequest;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.j;
import d.a.i0.r.s.a;
import java.lang.reflect.Field;
/* loaded from: classes5.dex */
public class i {

    /* loaded from: classes5.dex */
    public static class a implements PermissionJudgePolicy.OnPermissionsGrantedListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61940a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f61941b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f61942c;

        public a(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
            this.f61940a = tbPageContext;
            this.f61941b = str;
            this.f61942c = forumWriteData;
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
        public void onPermissionsGranted() {
            i.c(this.f61940a, this.f61941b, this.f61942c);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f61943e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ForumWriteData f61944f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PluginNetConfigInfos.PluginConfig f61945g;

        public b(TbPageContext tbPageContext, ForumWriteData forumWriteData, PluginNetConfigInfos.PluginConfig pluginConfig) {
            this.f61943e = tbPageContext;
            this.f61944f = forumWriteData;
            this.f61945g = pluginConfig;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
            e eVar = new e(this.f61943e, this.f61944f, i.f(this.f61943e));
            if (PluginPackageManager.O().Z(XiaoyingUtil.PKG_NAME_VIDEO)) {
                PluginPackageManager.O().u0(eVar);
            } else {
                PluginPackageManager.O().x0(this.f61945g, eVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a.e {
        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            PluginPackageManager.O().u0(null);
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements d.a.c.h.j.d {

        /* renamed from: a  reason: collision with root package name */
        public TbPageContext f61946a;

        /* renamed from: b  reason: collision with root package name */
        public ForumWriteData f61947b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.i0.r.s.d f61948c;

        public e(TbPageContext tbPageContext, ForumWriteData forumWriteData, d.a.i0.r.s.d dVar) {
            this.f61946a = null;
            this.f61946a = tbPageContext;
            this.f61947b = forumWriteData;
            this.f61948c = dVar;
        }

        @Override // d.a.c.h.j.d
        public void a(BdFileDownloadData bdFileDownloadData) {
            d.a.i0.r.s.d dVar = this.f61948c;
            if (dVar != null) {
                d.a.c.e.m.g.b(dVar, this.f61946a);
            }
            this.f61946a.showToast(R.string.plugin_video_installing);
        }

        @Override // d.a.c.h.j.d
        public void b(BdFileDownloadData bdFileDownloadData) {
            TbPageContext tbPageContext;
            d.a.i0.r.s.d dVar = this.f61948c;
            if (dVar != null) {
                d.a.c.e.m.g.b(dVar, this.f61946a);
            }
            if (bdFileDownloadData != null && bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) && (tbPageContext = this.f61946a) != null) {
                tbPageContext.showToast(bdFileDownloadData.getStatusMsg());
            }
            PluginPackageManager.O().u0(null);
        }

        @Override // d.a.c.h.j.d
        public void c(BdFileDownloadData bdFileDownloadData, int i2, String str) {
            d.a.i0.r.s.d dVar = this.f61948c;
            if (dVar != null) {
                d.a.c.e.m.g.b(dVar, this.f61946a);
            }
            if (i2 == 0) {
                i.d(this.f61946a, "", this.f61947b);
            } else {
                TbPageContext tbPageContext = this.f61946a;
                tbPageContext.showToast(this.f61946a.getString(R.string.install_failed) + str);
            }
            PluginPackageManager.O().u0(null);
        }

        @Override // d.a.c.h.j.d
        public void d(BdFileDownloadData bdFileDownloadData) {
            d.a.i0.r.s.d dVar;
            if (bdFileDownloadData == null || !bdFileDownloadData.getId().equals(XiaoyingUtil.PKG_NAME_VIDEO) || (dVar = this.f61948c) == null) {
                return;
            }
            dVar.b((int) ((bdFileDownloadData.getLength() * 100) / bdFileDownloadData.getSize()));
        }
    }

    public static boolean b() {
        return SwitchManager.getInstance().findType(PublishVideoThreadSwitch.PUBLISH_VIDEO_THREAD_KEY) != 1;
    }

    public static void c(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        PluginNetConfigInfos.PluginConfig pluginConfig;
        int i2;
        if (forumWriteData == null || tbPageContext == null) {
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
            d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(tbPageContext.getPageActivity());
            aVar.setMessage(string2);
            aVar.setPositiveButton(string, new b(tbPageContext, forumWriteData, pluginConfig));
            aVar.setNegativeButton(R.string.cancel, new c());
            aVar.create(tbPageContext).show();
        }
    }

    public static void d(TbPageContext tbPageContext, String str, ForumWriteData forumWriteData) {
        if (forumWriteData == null || tbPageContext == null) {
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
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i2));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static d.a.i0.r.s.d f(TbPageContext tbPageContext) {
        d.a.i0.r.s.d dVar = new d.a.i0.r.s.d(tbPageContext.getPageActivity());
        dVar.setOnCancelListener(new d());
        dVar.setCancelable(true);
        dVar.setCanceledOnTouchOutside(false);
        dVar.a(tbPageContext.getPageActivity().getString(R.string.on_downloading));
        d.a.c.e.m.g.i(dVar, tbPageContext.getPageActivity());
        return dVar;
    }
}
