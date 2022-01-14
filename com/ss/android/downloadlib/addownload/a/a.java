package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static a f59410b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f59411c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59412d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f59413e;

    /* renamed from: f  reason: collision with root package name */
    public b f59414f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2184a {
        void a();
    }

    public a() {
        b bVar = new b();
        this.f59414f = bVar;
        this.f59411c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (f59410b == null) {
            f59410b = new a();
        }
        return f59410b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f59413e = "";
        } else if (TextUtils.equals(this.f59413e, str)) {
            this.f59413e = "";
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC2184a interfaceC2184a) {
        if (downloadInfo == null) {
            try {
                if (this.f59411c.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f59411c.isEmpty()) {
                a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC2184a);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = this.f59411c.listIterator(this.f59411c.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                if (previous != null && !l.d(j.getContext(), previous.f59436d) && l.a(previous.f59439g)) {
                    if (new File(previous.f59439g).lastModified() >= lastModified) {
                        a(activity, previous, z, interfaceC2184a);
                    } else {
                        a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC2184a);
                    }
                }
            }
            String str = a;
            k.a(str, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC2184a interfaceC2184a) {
        if (j.i().optInt("disable_install_app_dialog") == 1 || this.f59412d) {
            return false;
        }
        return a(activity, a(activity), z, interfaceC2184a);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC2184a interfaceC2184a) {
        this.f59411c.clear();
        a(context, aVar, interfaceC2184a, z);
        this.f59412d = true;
        g.a(context).c();
        this.f59414f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        k.a(a, "tryShowInstallDialog isShow:true", null);
    }

    public DownloadInfo a(Context context) {
        long b2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            b2 = g.a(context).b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (j.i().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
            long j2 = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !l.d(context, downloadInfo2.getPackageName()) && l.a(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= b2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j2 == 0 || lastModified > j2)) {
                                downloadInfo = downloadInfo2;
                                j2 = lastModified;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.f59411c.size(); i2++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.f59411c.get(i2);
            if (aVar != null && aVar.f59434b == j3) {
                this.f59411c.set(i2, new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
                this.f59414f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f59411c);
                return;
            }
        }
        this.f59411c.add(new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
        this.f59414f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f59411c);
    }

    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final InterfaceC2184a interfaceC2184a, boolean z) {
        final com.ss.android.downloadad.api.a.b d2 = f.a().d(aVar.f59434b);
        if (d2 == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.k c2 = j.c();
        b.a a2 = new b.a(context).a(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.f59437e) ? "刚刚下载的应用" : aVar.f59437e;
        c2.b(a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(l.a(context, aVar.f59439g)).a(new b.InterfaceC2179b() { // from class: com.ss.android.downloadlib.addownload.a.a.1
            @Override // com.ss.android.download.api.model.b.InterfaceC2179b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", d2);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC2179b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d2);
                InterfaceC2184a interfaceC2184a2 = interfaceC2184a;
                if (interfaceC2184a2 != null) {
                    interfaceC2184a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC2179b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", d2);
        this.f59413e = aVar.f59436d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.f59413e, str);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
