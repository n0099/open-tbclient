package com.ss.android.downloadlib.addownload.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    public static final String a = "a";
    public static a b;
    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> c;
    public boolean d = false;
    public String e;
    public b f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0730a {
        void a();
    }

    public a() {
        b bVar = new b();
        this.f = bVar;
        this.c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    private void a(final Context context, final com.ss.android.downloadlib.addownload.b.a aVar, final InterfaceC0730a interfaceC0730a, boolean z) {
        String str;
        String str2;
        String format;
        final com.ss.android.downloadad.api.a.b d = f.a().d(aVar.b);
        if (d == null) {
            com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
            return;
        }
        k c = j.c();
        b.a aVar2 = new b.a(context);
        if (z) {
            str = "应用安装确认";
        } else {
            str = "退出确认";
        }
        b.a a2 = aVar2.a(str);
        Object[] objArr = new Object[1];
        if (TextUtils.isEmpty(aVar.e)) {
            str2 = "刚刚下载的应用";
        } else {
            str2 = aVar.e;
        }
        objArr[0] = str2;
        b.a c2 = a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装");
        if (z) {
            format = "暂不安装";
        } else {
            format = String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes));
        }
        c.b(c2.d(format).a(false).a(l.a(context, aVar.g)).a(new b.InterfaceC0725b() { // from class: com.ss.android.downloadlib.addownload.a.a.1
            @Override // com.ss.android.download.api.model.b.InterfaceC0725b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_install", d);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0725b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.d.a.a().b("backdialog_exit", d);
                InterfaceC0730a interfaceC0730a2 = interfaceC0730a;
                if (interfaceC0730a2 != null) {
                    interfaceC0730a2.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.b.InterfaceC0725b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).a(1).a());
        com.ss.android.downloadlib.d.a.a().b("backdialog_show", d);
        this.e = aVar.d;
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC0730a interfaceC0730a) {
        if (downloadInfo == null) {
            try {
                if (this.c.isEmpty()) {
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.c.isEmpty()) {
                a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0730a);
                return true;
            }
            long j = 0;
            if (downloadInfo != null) {
                j = new File(downloadInfo.getTargetFilePath()).lastModified();
            }
            ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = this.c.listIterator(this.c.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                    if (previous != null && !l.d(j.getContext(), previous.d) && l.a(previous.g)) {
                        if (new File(previous.g).lastModified() >= j) {
                            a(activity, previous, z, interfaceC0730a);
                        } else {
                            a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC0730a);
                        }
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            String str = a;
            com.ss.android.downloadlib.g.k.a(str, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    public DownloadInfo a(Context context) {
        long b2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        DownloadInfo downloadInfo = null;
        try {
            b2 = g.a(context).b();
        } catch (Exception e) {
            e.printStackTrace();
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
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            return downloadInfo;
        }
        return null;
    }

    public void a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i = 0; i < this.c.size(); i++) {
            com.ss.android.downloadlib.addownload.b.a aVar = this.c.get(i);
            if (aVar != null && aVar.b == j2) {
                this.c.set(i, new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
                this.f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
                return;
            }
        }
        this.c.add(new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
        this.f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC0730a interfaceC0730a) {
        this.c.clear();
        a(context, aVar, interfaceC0730a, z);
        this.d = true;
        g.a(context).c();
        this.f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        com.ss.android.downloadlib.g.k.a(a, "tryShowInstallDialog isShow:true", null);
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        if (j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e = "";
        } else if (TextUtils.equals(this.e, str)) {
            this.e = "";
        }
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC0730a interfaceC0730a) {
        if (j.i().optInt("disable_install_app_dialog") != 1 && !this.d) {
            return a(activity, a(activity), z, interfaceC0730a);
        }
        return false;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.e, str);
    }
}
