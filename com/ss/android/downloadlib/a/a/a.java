package com.ss.android.downloadlib.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.a.a.a.k;
import com.ss.android.a.a.d.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.f.h;
import com.ss.android.downloadlib.f.i;
import com.ss.android.socialbase.downloader.downloader.f;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7688a = a.class.getSimpleName();
    private static a qcb;
    private String e;
    private boolean d = false;
    private b qcc = new b();
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> c = this.qcc.hA("sp_ad_install_back_dialog", "key_uninstalled_list");

    /* renamed from: com.ss.android.downloadlib.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1212a {
        void a();
    }

    private a() {
    }

    public static a eEC() {
        if (qcb == null) {
            qcb = new a();
        }
        return qcb;
    }

    public boolean a(Context context, boolean z, InterfaceC1212a interfaceC1212a) {
        long j;
        boolean z2;
        h.i(f7688a, "tryShowInstallDialog canBackRefresh:" + z, null);
        if (j.i().optInt("disable_install_app_dialog") == 1 || this.d) {
            return false;
        }
        com.ss.android.socialbase.downloader.g.c ix = ix(context);
        if (ix == null && this.c.isEmpty()) {
            return false;
        }
        if (ix != null && this.c.isEmpty()) {
            a(context, new com.ss.android.downloadlib.a.b.a(ix.g(), 0L, 0L, ix.D(), ix.i(), null, ix.n()), z, interfaceC1212a);
            return true;
        }
        if (ix == null) {
            j = 0;
        } else {
            j = new File(ix.n()).lastModified();
        }
        ListIterator<com.ss.android.downloadlib.a.b.a> listIterator = this.c.listIterator(this.c.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                z2 = false;
                break;
            }
            com.ss.android.downloadlib.a.b.a previous = listIterator.previous();
            if (previous != null && !i.d(context, previous.d) && i.a(previous.g)) {
                if (new File(previous.g).lastModified() >= j) {
                    a(context, previous, z, interfaceC1212a);
                    z2 = true;
                } else {
                    a(context, new com.ss.android.downloadlib.a.b.a(ix.g(), 0L, 0L, ix.D(), ix.i(), null, ix.n()), z, interfaceC1212a);
                    z2 = true;
                }
            }
        }
        h.i(f7688a, "tryShowInstallDialog isShow:" + z2, null);
        return z2;
    }

    public void a(Context context, com.ss.android.downloadlib.a.b.a aVar, boolean z, InterfaceC1212a interfaceC1212a) {
        this.c.clear();
        a(context, aVar, interfaceC1212a, z);
        this.d = true;
        com.ss.android.downloadlib.i.iB(context).c();
        this.qcc.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        h.i(f7688a, "tryShowInstallDialog isShow:true", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (r2 > r4) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.ss.android.socialbase.downloader.g.c ix(Context context) {
        List<com.ss.android.socialbase.downloader.g.c> b;
        long j;
        long lastModified;
        com.ss.android.socialbase.downloader.g.c cVar = null;
        long b2 = com.ss.android.downloadlib.i.iB(context).b();
        if (j.i().optInt("enable_miniapp_dialog", 0) != 0 && (b = f.iC(context).b("application/vnd.android.package-archive")) != null && !b.isEmpty()) {
            j = 0;
            for (com.ss.android.socialbase.downloader.g.c cVar2 : b) {
                if (cVar2 != null && !i.d(context, cVar2.D()) && i.a(cVar2.n())) {
                    lastModified = new File(cVar2.n()).lastModified();
                    if (lastModified >= b2 && cVar2.C() != null) {
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (new JSONObject(cVar2.C()).has("isMiniApp")) {
                            if (j != 0) {
                            }
                            j = lastModified;
                            cVar = cVar2;
                        }
                    }
                }
            }
        }
        return cVar;
        lastModified = j;
        cVar2 = cVar;
        j = lastModified;
        cVar = cVar2;
    }

    public void a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.c.size()) {
                com.ss.android.downloadlib.a.b.a aVar = this.c.get(i2);
                if (aVar == null || aVar.b != j2) {
                    i = i2 + 1;
                } else {
                    this.c.set(i2, new com.ss.android.downloadlib.a.b.a(j, j2, j3, str, str2, str3, str4));
                    this.qcc.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
                    return;
                }
            } else {
                this.c.add(new com.ss.android.downloadlib.a.b.a(j, j2, j3, str, str2, str3, str4));
                this.qcc.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
                return;
            }
        }
    }

    private void a(final Context context, final com.ss.android.downloadlib.a.b.a aVar, final InterfaceC1212a interfaceC1212a, boolean z) {
        final com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEF().je(aVar.b);
        if (je == null) {
            i.b();
            return;
        }
        k eER = j.eER();
        c.a aaw = new c.a(context).aaw(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.e) ? "刚刚下载的应用" : aVar.e;
        eER.b(aaw.aax(String.format("%1$s下载完成，是否立即安装？", objArr)).aay("立即安装").aaz(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).BH(false).I(i.a(context, aVar.g)).a(new c.b() { // from class: com.ss.android.downloadlib.a.a.a.1
            @Override // com.ss.android.a.a.d.c.b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.eFo().a("backdialog_install", je);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.f7691a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.a.a.d.c.b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.eFo().a("backdialog_exit", je);
                if (interfaceC1212a != null) {
                    interfaceC1212a.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.a.a.d.c.b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).QQ(1).eEo());
        com.ss.android.downloadlib.e.a.eFo().a("backdialog_show", je);
        this.e = aVar.d;
    }

    public boolean a(String str) {
        return TextUtils.equals(this.e, str);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.e = "";
        } else if (TextUtils.equals(this.e, str)) {
            this.e = "";
        }
    }

    public void a(long j) {
        if (j.i().optInt("enable_open_app_dialog", 0) == 1) {
            TTDelegateActivity.a(j);
        }
    }
}
