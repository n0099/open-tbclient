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
/* loaded from: classes7.dex */
public class a {
    public static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static a f42723b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f42724c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f42725d = false;

    /* renamed from: e  reason: collision with root package name */
    public String f42726e;

    /* renamed from: f  reason: collision with root package name */
    public b f42727f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC2040a {
        void a();
    }

    public a() {
        b bVar = new b();
        this.f42727f = bVar;
        this.f42724c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (f42723b == null) {
            f42723b = new a();
        }
        return f42723b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f42726e = "";
        } else if (TextUtils.equals(this.f42726e, str)) {
            this.f42726e = "";
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC2040a interfaceC2040a) {
        if (downloadInfo == null) {
            try {
                if (this.f42724c.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f42724c.isEmpty()) {
                a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC2040a);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
            ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = this.f42724c.listIterator(this.f42724c.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                if (previous != null && !l.d(j.getContext(), previous.f42748d) && l.a(previous.f42751g)) {
                    if (new File(previous.f42751g).lastModified() >= lastModified) {
                        a(activity, previous, z, interfaceC2040a);
                    } else {
                        a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC2040a);
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
    public boolean a(Activity activity, boolean z, InterfaceC2040a interfaceC2040a) {
        if (j.i().optInt("disable_install_app_dialog") == 1 || this.f42725d) {
            return false;
        }
        return a(activity, a(activity), z, interfaceC2040a);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC2040a interfaceC2040a) {
        this.f42724c.clear();
        a(context, aVar, interfaceC2040a, z);
        this.f42725d = true;
        g.a(context).c();
        this.f42727f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
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
            long j = 0;
            for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                if (downloadInfo2 != null && !l.d(context, downloadInfo2.getPackageName()) && l.a(downloadInfo2.getTargetFilePath())) {
                    long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                    if (lastModified >= b2 && downloadInfo2.getExtra() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                downloadInfo = downloadInfo2;
                                j = lastModified;
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

    public void a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.f42724c.size(); i++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.f42724c.get(i);
            if (aVar != null && aVar.f42746b == j2) {
                this.f42724c.set(i, new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
                this.f42727f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f42724c);
                return;
            }
        }
        this.f42724c.add(new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
        this.f42727f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f42724c);
    }

    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final InterfaceC2040a interfaceC2040a, boolean z) {
        final com.ss.android.downloadad.api.a.b d2 = f.a().d(aVar.f42746b);
        if (d2 == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        com.ss.android.download.api.config.k c2 = j.c();
        b.a a2 = new b.a(context).a(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.f42749e) ? "刚刚下载的应用" : aVar.f42749e;
        c2.b(a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(l.a(context, aVar.f42751g)).a(new b.InterfaceC2035b() { // from class: com.ss.android.downloadlib.addownload.a.a.1
            @Override // com.ss.android.download.api.model.b.InterfaceC2035b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", d2);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC2035b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d2);
                InterfaceC2040a interfaceC2040a2 = interfaceC2040a;
                if (interfaceC2040a2 != null) {
                    interfaceC2040a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC2035b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", d2);
        this.f42726e = aVar.f42748d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.f42726e, str);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
