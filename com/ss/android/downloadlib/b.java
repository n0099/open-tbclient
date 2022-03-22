package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.sapi2.SapiWebView;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.e.b;
import com.ss.android.downloadlib.g.i;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements com.ss.android.downloadad.api.b {
    public static String a = "b";

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f42870b;

    /* renamed from: c  reason: collision with root package name */
    public g f42871c = g.a(j.getContext());

    public static DownloadEventConfig c() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag("landing_h5_download_ad_button").setClickItemTag("landing_h5_download_ad_button").setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog b(Context context, String str, boolean z, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i, boolean z2) {
        if (b(downloadModel.getId())) {
            if (z2) {
                a(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                a(downloadModel.getId());
            }
            return null;
        } else if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        } else {
            this.f42871c.a(context, i, downloadStatusChangeListener, downloadModel);
            boolean z3 = true;
            final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) l.a(downloadEventConfig, c());
            final DownloadController downloadController2 = (DownloadController) l.a(downloadController, b());
            downloadEventConfig2.setDownloadScene(1);
            boolean z4 = (j.i().optInt("disable_lp_dialog", 0) == 1) | z;
            if (!downloadController2.enableShowComplianceDialog() || !com.ss.android.downloadlib.addownload.compliance.b.a().a(downloadModel)) {
                z3 = z4;
            }
            if (z3) {
                this.f42871c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                return null;
            }
            String str2 = a;
            k.a(str2, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
            Dialog b2 = j.c().b(new b.a(context).a(downloadModel.getName()).b("确认要下载此应用吗？").c("确认").d(SapiWebView.HTTPS_SSL_DATE_INVALID_DIALOG_CANCEL).a(new b.InterfaceC2035b() { // from class: com.ss.android.downloadlib.b.2
                @Override // com.ss.android.download.api.model.b.InterfaceC2035b
                public void a(DialogInterface dialogInterface) {
                    b.this.f42871c.a(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                    com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_confirm", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2035b
                public void b(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                    dialogInterface.dismiss();
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2035b
                public void c(DialogInterface dialogInterface) {
                    com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_cancel", downloadModel, downloadEventConfig2, downloadController2);
                }
            }).a(0).a());
            com.ss.android.downloadlib.d.a.a().a("landing_download_dialog_show", downloadModel, downloadEventConfig2, downloadController2);
            return b2;
        }
    }

    public static b a() {
        if (f42870b == null) {
            synchronized (b.class) {
                if (f42870b == null) {
                    f42870b = new b();
                }
            }
        }
        return f42870b;
    }

    @Override // com.ss.android.downloadad.api.b
    public Dialog a(Context context, String str, boolean z, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        return a(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, false);
    }

    public Dialog a(final Context context, final String str, final boolean z, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i, final boolean z2) {
        return (Dialog) com.ss.android.downloadlib.e.b.a(new b.a<Dialog>() { // from class: com.ss.android.downloadlib.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Dialog b() {
                return b.this.b(context, str, z, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i, z2);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i) {
        com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
        if (d2 != null) {
            this.f42871c.a(context, i, downloadStatusChangeListener, d2.af());
            return true;
        }
        DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
        if (a2 != null) {
            this.f42871c.a(context, i, downloadStatusChangeListener, a2);
            return true;
        }
        return false;
    }

    public void a(long j, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
        com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
        if (a2 == null && d2 != null) {
            a2 = d2.af();
        }
        if (a2 == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.c) && !(downloadController instanceof com.ss.android.download.api.download.b)) {
            downloadEventConfig.setDownloadScene(1);
            this.f42871c.a(a2.getDownloadUrl(), j, 2, downloadEventConfig, downloadController);
            return;
        }
        a(j);
    }

    public void a(long j) {
        DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j);
        com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
        if (a2 == null && d2 != null) {
            a2 = d2.af();
        }
        if (a2 == null) {
            return;
        }
        DownloadEventConfig b2 = com.ss.android.downloadlib.addownload.b.f.a().b(j);
        DownloadController c2 = com.ss.android.downloadlib.addownload.b.f.a().c(j);
        if (b2 instanceof com.ss.android.download.api.download.c) {
            b2 = null;
        }
        if (c2 instanceof com.ss.android.download.api.download.b) {
            c2 = null;
        }
        if (d2 == null) {
            if (b2 == null) {
                b2 = c();
            }
            if (c2 == null) {
                c2 = b();
            }
        } else {
            if (b2 == null) {
                b2 = new AdDownloadEventConfig.Builder().setClickButtonTag(d2.j()).setRefer(d2.i()).setIsEnableV3Event(d2.m()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (c2 == null) {
                c2 = d2.ah();
            }
        }
        DownloadEventConfig downloadEventConfig = b2;
        downloadEventConfig.setDownloadScene(1);
        this.f42871c.a(a2.getDownloadUrl(), j, 2, downloadEventConfig, c2);
    }

    public boolean b(long j) {
        return (com.ss.android.downloadlib.addownload.b.f.a().a(j) == null && com.ss.android.downloadlib.addownload.b.f.a().d(j) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadController downloadController2 = downloadController;
        if (com.ss.android.download.api.c.a.a(uri) && j.i().optInt("disable_market") != 1) {
            Context context2 = context == null ? j.getContext() : context;
            String b2 = com.ss.android.download.api.c.a.b(uri);
            if (downloadModel == null) {
                return i.a(context2, b2).getType() == 5;
            }
            if (!TextUtils.isEmpty(b2) && (downloadModel instanceof AdDownloadModel)) {
                ((AdDownloadModel) downloadModel).setPackageName(b2);
            }
            if (downloadController2 != null) {
                downloadController2.setDownloadMode(2);
            } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
                ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
                downloadController2 = a(true);
            } else if (downloadModel.getDownloadUrl().startsWith("market")) {
                downloadController2 = a(true);
            } else {
                downloadController2 = b();
            }
            com.ss.android.downloadlib.addownload.b.e eVar = new com.ss.android.downloadlib.addownload.b.e(downloadModel.getId(), downloadModel, (DownloadEventConfig) l.a(downloadEventConfig, c()), downloadController2);
            com.ss.android.downloadlib.addownload.b.f.a().a(eVar.f42774b);
            com.ss.android.downloadlib.addownload.b.f.a().a(eVar.a, eVar.f42775c);
            com.ss.android.downloadlib.addownload.b.f.a().a(eVar.a, eVar.f42776d);
            if (l.a(downloadModel) && com.ss.android.socialbase.downloader.g.a.c().b("app_link_opt") == 1 && com.ss.android.downloadlib.b.a.a(eVar)) {
                return true;
            }
            JSONObject jSONObject = new JSONObject();
            l.a(jSONObject, "market_url", uri.toString());
            l.a(jSONObject, "download_scene", (Object) 1);
            com.ss.android.downloadlib.d.a.a().b("market_click_open", jSONObject, eVar);
            com.ss.android.downloadlib.addownload.b.g a2 = i.a(context2, eVar, b2);
            String a3 = l.a(a2.b(), "open_market");
            if (a2.getType() == 5) {
                com.ss.android.downloadlib.b.a.a(a3, jSONObject, eVar, true);
                return true;
            } else if (a2.getType() == 6) {
                l.a(jSONObject, "error_code", Integer.valueOf(a2.a()));
                com.ss.android.downloadlib.d.a.a().b("market_open_failed", jSONObject, eVar);
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override // com.ss.android.downloadad.api.b
    public boolean a(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        return ((Boolean) com.ss.android.downloadlib.e.b.a(new b.a<Boolean>() { // from class: com.ss.android.downloadlib.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.ss.android.downloadlib.e.b.a
            /* renamed from: a */
            public Boolean b() {
                return Boolean.valueOf(b.this.b(context, uri, downloadModel, downloadEventConfig, downloadController));
            }
        })).booleanValue();
    }

    public static DownloadController a(boolean z) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    public static DownloadController b() {
        return a(false);
    }
}
