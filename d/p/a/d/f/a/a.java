package d.p.a.d.f.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.a.a.d.c;
import d.p.a.d.f.c;
import d.p.a.d.f.n;
import d.p.a.d.j;
import d.p.a.d.l;
import d.p.a.d.n.k;
import d.p.a.e.a.e;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final String f67624e = "a";

    /* renamed from: f  reason: collision with root package name */
    public static a f67625f;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<c.b> f67626a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67627b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f67628c;

    /* renamed from: d  reason: collision with root package name */
    public d.p.a.d.f.a.b f67629d;

    /* renamed from: d.p.a.d.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1862a implements c.InterfaceC1857c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.p.a.b.a.c.b f67630a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f67631b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.b f67632c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f67633d;

        public C1862a(d.p.a.b.a.c.b bVar, Context context, c.b bVar2, b bVar3) {
            this.f67630a = bVar;
            this.f67631b = context;
            this.f67632c = bVar2;
            this.f67633d = bVar3;
        }

        @Override // d.p.a.a.a.d.c.InterfaceC1857c
        public void a(DialogInterface dialogInterface) {
            j.c.a().n("backdialog_exit", this.f67630a);
            b bVar = this.f67633d;
            if (bVar != null) {
                bVar.a();
            }
            a.this.j("");
            dialogInterface.dismiss();
        }

        @Override // d.p.a.a.a.d.c.InterfaceC1857c
        public void b(DialogInterface dialogInterface) {
            j.c.a().n("backdialog_install", this.f67630a);
            e.s(this.f67631b, (int) this.f67632c.f67653a);
            dialogInterface.dismiss();
        }

        @Override // d.p.a.a.a.d.c.InterfaceC1857c
        public void c(DialogInterface dialogInterface) {
            a.this.j("");
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    public a() {
        d.p.a.d.f.a.b bVar = new d.p.a.d.f.a.b();
        this.f67629d = bVar;
        this.f67626a = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        if (f67625f == null) {
            f67625f = new a();
        }
        return f67625f;
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
        if (n.s().optInt("enable_miniapp_dialog", 0) != 0 && (o = d.p.a.e.b.g.a.l(context).o("application/vnd.android.package-archive")) != null && !o.isEmpty()) {
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
        for (int i = 0; i < this.f67626a.size(); i++) {
            c.b bVar = this.f67626a.get(i);
            if (bVar != null && bVar.f67654b == j2) {
                this.f67626a.set(i, new c.b(j, j2, j3, str, str2, str3, str4));
                this.f67629d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f67626a);
                return;
            }
        }
        this.f67626a.add(new c.b(j, j2, j3, str, str2, str3, str4));
        this.f67629d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f67626a);
    }

    public final void d(Context context, c.b bVar, b bVar2, boolean z) {
        d.p.a.b.a.c.b u = c.g.e().u(bVar.f67654b);
        if (u == null) {
            k.B();
            return;
        }
        d.p.a.a.a.a.k n = n.n();
        c.b bVar3 = new c.b(context);
        bVar3.e(z ? "应用安装确认" : "退出确认");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(bVar.f67657e) ? "刚刚下载的应用" : bVar.f67657e;
        bVar3.h(String.format("%1$s下载完成，是否立即安装？", objArr));
        bVar3.j("立即安装");
        bVar3.l(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes)));
        bVar3.f(false);
        bVar3.c(k.i(context, bVar.f67659g));
        bVar3.d(new C1862a(u, context, bVar, bVar2));
        bVar3.b(1);
        n.b(bVar3.g());
        j.c.a().n("backdialog_show", u);
        this.f67628c = bVar.f67656d;
    }

    public void e(Context context, c.b bVar, boolean z, b bVar2) {
        this.f67626a.clear();
        d(context, bVar, bVar2, z);
        this.f67627b = true;
        l.b(context).l();
        this.f67629d.c("sp_ad_install_back_dialog", "key_uninstalled_list");
        d.p.a.d.n.j.a(f67624e, "tryShowInstallDialog isShow:true", null);
    }

    public void f(d.p.a.b.a.c.b bVar) {
        if (n.s().optInt("enable_open_app_dialog", 0) == 1 && !bVar.U() && bVar.q()) {
            bVar.U0(true);
            TTDelegateActivity.a(bVar);
        }
    }

    public final boolean g(Activity activity, DownloadInfo downloadInfo, boolean z, b bVar) {
        if (downloadInfo == null) {
            try {
                if (this.f67626a.isEmpty()) {
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (activity != null && !activity.isFinishing()) {
            boolean z2 = true;
            if (downloadInfo != null && this.f67626a.isEmpty()) {
                e(activity, new c.b(downloadInfo.c0(), 0L, 0L, downloadInfo.v0(), downloadInfo.P0(), null, downloadInfo.K0()), z, bVar);
                return true;
            }
            long lastModified = downloadInfo != null ? new File(downloadInfo.K0()).lastModified() : 0L;
            ListIterator<c.b> listIterator = this.f67626a.listIterator(this.f67626a.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    z2 = false;
                    break;
                }
                c.b previous = listIterator.previous();
                if (previous != null && !k.I(n.a(), previous.f67656d) && k.x(previous.f67659g)) {
                    if (new File(previous.f67659g).lastModified() >= lastModified) {
                        e(activity, previous, z, bVar);
                    } else {
                        e(activity, new c.b(downloadInfo.c0(), 0L, 0L, downloadInfo.v0(), downloadInfo.P0(), null, downloadInfo.K0()), z, bVar);
                    }
                }
            }
            String str = f67624e;
            d.p.a.d.n.j.a(str, "tryShowInstallDialog isShow:" + z2, null);
            return z2;
        }
        return false;
    }

    @MainThread
    public boolean h(Activity activity, boolean z, b bVar) {
        if (n.s().optInt("disable_install_app_dialog") == 1 || this.f67627b) {
            return false;
        }
        return g(activity, b(activity), z, bVar);
    }

    public boolean i(String str) {
        return TextUtils.equals(this.f67628c, str);
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f67628c = "";
        } else if (TextUtils.equals(this.f67628c, str)) {
            this.f67628c = "";
        }
    }
}
