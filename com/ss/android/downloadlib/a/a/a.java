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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13223a = a.class.getSimpleName();
    private static a pVi;
    private String e;
    private boolean d = false;
    private b pVk = new b();
    @NonNull
    private CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> pVj = this.pVk.hs("sp_ad_install_back_dialog", "key_uninstalled_list");

    /* renamed from: com.ss.android.downloadlib.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1233a {
        void a();
    }

    private a() {
    }

    public static a eFQ() {
        if (pVi == null) {
            pVi = new a();
        }
        return pVi;
    }

    public boolean a(Context context, boolean z, InterfaceC1233a interfaceC1233a) {
        long j;
        boolean z2;
        h.i(f13223a, "tryShowInstallDialog canBackRefresh:" + z, null);
        if (j.i().optInt("disable_install_app_dialog") == 1 || this.d) {
            return false;
        }
        com.ss.android.socialbase.downloader.g.c iv = iv(context);
        if (iv == null && this.pVj.isEmpty()) {
            return false;
        }
        if (iv != null && this.pVj.isEmpty()) {
            a(context, new com.ss.android.downloadlib.a.b.a(iv.g(), 0L, 0L, iv.D(), iv.i(), null, iv.n()), z, interfaceC1233a);
            return true;
        }
        if (iv == null) {
            j = 0;
        } else {
            j = new File(iv.n()).lastModified();
        }
        ListIterator<com.ss.android.downloadlib.a.b.a> listIterator = this.pVj.listIterator(this.pVj.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                z2 = false;
                break;
            }
            com.ss.android.downloadlib.a.b.a previous = listIterator.previous();
            if (previous != null && !i.d(context, previous.d) && i.a(previous.g)) {
                if (new File(previous.g).lastModified() >= j) {
                    a(context, previous, z, interfaceC1233a);
                    z2 = true;
                } else {
                    a(context, new com.ss.android.downloadlib.a.b.a(iv.g(), 0L, 0L, iv.D(), iv.i(), null, iv.n()), z, interfaceC1233a);
                    z2 = true;
                }
            }
        }
        h.i(f13223a, "tryShowInstallDialog isShow:" + z2, null);
        return z2;
    }

    public void a(Context context, com.ss.android.downloadlib.a.b.a aVar, boolean z, InterfaceC1233a interfaceC1233a) {
        this.pVj.clear();
        a(context, aVar, interfaceC1233a, z);
        this.d = true;
        com.ss.android.downloadlib.i.iz(context).c();
        this.pVk.b("sp_ad_install_back_dialog", "key_uninstalled_list");
        h.i(f13223a, "tryShowInstallDialog isShow:true", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
        if (r2 > r4) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.ss.android.socialbase.downloader.g.c iv(Context context) {
        List<com.ss.android.socialbase.downloader.g.c> b2;
        long j;
        long lastModified;
        com.ss.android.socialbase.downloader.g.c cVar = null;
        long b3 = com.ss.android.downloadlib.i.iz(context).b();
        if (j.i().optInt("enable_miniapp_dialog", 0) != 0 && (b2 = f.iA(context).b("application/vnd.android.package-archive")) != null && !b2.isEmpty()) {
            j = 0;
            for (com.ss.android.socialbase.downloader.g.c cVar2 : b2) {
                if (cVar2 != null && !i.d(context, cVar2.D()) && i.a(cVar2.n())) {
                    lastModified = new File(cVar2.n()).lastModified();
                    if (lastModified >= b3 && cVar2.C() != null) {
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
            if (i2 < this.pVj.size()) {
                com.ss.android.downloadlib.a.b.a aVar = this.pVj.get(i2);
                if (aVar == null || aVar.f13230b != j2) {
                    i = i2 + 1;
                } else {
                    this.pVj.set(i2, new com.ss.android.downloadlib.a.b.a(j, j2, j3, str, str2, str3, str4));
                    this.pVk.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.pVj);
                    return;
                }
            } else {
                this.pVj.add(new com.ss.android.downloadlib.a.b.a(j, j2, j3, str, str2, str3, str4));
                this.pVk.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.pVj);
                return;
            }
        }
    }

    private void a(final Context context, final com.ss.android.downloadlib.a.b.a aVar, final InterfaceC1233a interfaceC1233a, boolean z) {
        final com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eFT().jb(aVar.f13230b);
        if (jb == null) {
            i.b();
            return;
        }
        k eGf = j.eGf();
        c.a aal = new c.a(context).aal(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(aVar.e) ? "刚刚下载的应用" : aVar.e;
        eGf.b(aal.aam(String.format("%1$s下载完成，是否立即安装？", objArr)).aan("立即安装").aao(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).Bt(false).I(i.a(context, aVar.g)).a(new c.b() { // from class: com.ss.android.downloadlib.a.a.a.1
            @Override // com.ss.android.a.a.d.c.b
            public void a(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.eGB().a("backdialog_install", jb);
                com.ss.android.socialbase.appdownloader.d.a(context, (int) aVar.f13229a);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.a.a.d.c.b
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.e.a.eGB().a("backdialog_exit", jb);
                if (interfaceC1233a != null) {
                    interfaceC1233a.a();
                }
                a.this.b("");
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.a.a.d.c.b
            public void c(DialogInterface dialogInterface) {
                a.this.b("");
            }
        }).RX(1).eFC());
        com.ss.android.downloadlib.e.a.eGB().a("backdialog_show", jb);
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
