package d.o.a.d.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.d.c;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.j;
import d.o.a.d.l;
import d.o.a.d.n.k;
import d.o.a.e.a.e;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final String f66698e = "a";

    /* renamed from: f  reason: collision with root package name */
    public static a f66699f;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<c.b> f66700a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66701b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f66702c;

    /* renamed from: d  reason: collision with root package name */
    public d.o.a.d.f.a.b f66703d;

    /* renamed from: d.o.a.d.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1865a implements c.InterfaceC1860c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f66704a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f66705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.b f66706c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f66707d;

        public C1865a(d.o.a.b.a.c.b bVar, Context context, c.b bVar2, b bVar3) {
            this.f66704a = bVar;
            this.f66705b = context;
            this.f66706c = bVar2;
            this.f66707d = bVar3;
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1860c
        public void a(DialogInterface dialogInterface) {
            j.c.a().n("backdialog_install", this.f66704a);
            e.s(this.f66705b, (int) this.f66706c.f66728a);
            dialogInterface.dismiss();
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1860c
        public void b(DialogInterface dialogInterface) {
            j.c.a().n("backdialog_exit", this.f66704a);
            b bVar = this.f66707d;
            if (bVar != null) {
                bVar.a();
            }
            a.this.j("");
            dialogInterface.dismiss();
        }

        @Override // d.o.a.a.a.d.c.InterfaceC1860c
        public void c(DialogInterface dialogInterface) {
            a.this.j("");
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();
    }

    public a() {
        d.o.a.d.f.a.b bVar = new d.o.a.d.f.a.b();
        this.f66703d = bVar;
        this.f66700a = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (f66699f == null) {
            f66699f = new a();
        }
        return f66699f;
    }

    public DownloadInfo b(Context context) {
        long j;
        List<DownloadInfo> o;
        DownloadInfo downloadInfo = null;
        try {
            j = l.b(context).j();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (n.s().optInt("enable_miniapp_dialog", 0) != 0 && (o = d.o.a.e.b.g.a.l(context).o("application/vnd.android.package-archive")) != null && !o.isEmpty()) {
            long j2 = 0;
            for (DownloadInfo downloadInfo2 : o) {
                if (downloadInfo2 != null && !k.I(context, downloadInfo2.v0()) && k.x(downloadInfo2.K0())) {
                    long lastModified = new File(downloadInfo2.K0()).lastModified();
                    if (lastModified >= j && downloadInfo2.R() != null) {
                        try {
                            if (new JSONObject(downloadInfo2.R()).has("isMiniApp") && (j2 == 0 || lastModified > j2)) {
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

    public void c(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.f66700a.size(); i2++) {
            c.b bVar = this.f66700a.get(i2);
            if (bVar != null && bVar.f66729b == j2) {
                this.f66700a.set(i2, new c.b(j, j2, j3, str, str2, str3, str4));
                this.f66703d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f66700a);
                return;
            }
        }
        this.f66700a.add(new c.b(j, j2, j3, str, str2, str3, str4));
        this.f66703d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f66700a);
    }

    public final void d(Context context, c.b bVar, b bVar2, boolean z) {
        d.o.a.b.a.c.b u = c.g.e().u(bVar.f66729b);
        if (u == null) {
            k.B();
            return;
        }
        d.o.a.a.a.a.k n = n.n();
        c.b bVar3 = new c.b(context);
        bVar3.e(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(bVar.f66732e) ? "刚刚下载的应用" : bVar.f66732e;
        bVar3.h(String.format("%1$s下载完成，是否立即安装？", objArr));
        bVar3.j("立即安装");
        bVar3.l(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes)));
        bVar3.f(false);
        bVar3.c(k.i(context, bVar.f66734g));
        bVar3.d(new C1865a(u, context, bVar, bVar2));
        bVar3.b(1);
        n.b(bVar3.g());
        j.c.a().n("backdialog_show", u);
        this.f66702c = bVar.f66731d;
    }

    public void e(Context context, c.b bVar, boolean z, b bVar2) {
        this.f66700a.clear();
        d(context, bVar, bVar2, z);
        this.f66701b = true;
        l.b(context).l();
        this.f66703d.c("sp_ad_install_back_dialog", "key_uninstalled_list");
        d.o.a.d.n.j.a(f66698e, "tryShowInstallDialog isShow:true", null);
    }

    public void f(d.o.a.b.a.c.b bVar) {
        if (n.s().optInt("enable_open_app_dialog", 0) == 1 && !bVar.U() && bVar.q()) {
            bVar.U0(true);
            TTDelegateActivity.a(bVar);
        }
    }

    public final boolean g(Activity activity, DownloadInfo downloadInfo, boolean z, b bVar) {
        if (downloadInfo == null) {
            try {
                if (this.f66700a.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f66700a.isEmpty()) {
                e(activity, new c.b(downloadInfo.c0(), 0L, 0L, downloadInfo.v0(), downloadInfo.P0(), null, downloadInfo.K0()), z, bVar);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.K0()).lastModified() : 0L;
            ListIterator<c.b> listIterator = this.f66700a.listIterator(this.f66700a.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                c.b previous = listIterator.previous();
                if (previous != null && !k.I(n.a(), previous.f66731d) && k.x(previous.f66734g)) {
                    if (new File(previous.f66734g).lastModified() >= lastModified) {
                        e(activity, previous, z, bVar);
                    } else {
                        e(activity, new c.b(downloadInfo.c0(), 0L, 0L, downloadInfo.v0(), downloadInfo.P0(), null, downloadInfo.K0()), z, bVar);
                    }
                }
            }
            String str = f66698e;
            d.o.a.d.n.j.a(str, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean h(Activity activity, boolean z, b bVar) {
        if (n.s().optInt("disable_install_app_dialog") == 1 || this.f66701b) {
            return false;
        }
        return g(activity, b(activity), z, bVar);
    }

    public boolean i(String str) {
        return TextUtils.equals(this.f66702c, str);
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f66702c = "";
        } else if (TextUtils.equals(this.f66702c, str)) {
            this.f66702c = "";
        }
    }
}
