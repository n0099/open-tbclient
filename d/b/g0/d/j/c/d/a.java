package d.b.g0.d.j.c.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.b.g0.a.i2.e;
import d.b.g0.a.k;
import d.b.g0.d.j.c.b;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC0924b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47532b = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47533a = false;

    /* renamed from: d.b.g0.d.j.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0925a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.u.c f47534e;

        public DialogInterface$OnClickListenerC0925a(d.b.g0.a.e0.u.c cVar) {
            this.f47534e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (-2 == i) {
                this.f47534e.onFail();
                return;
            }
            a.this.j();
            a.this.l(this.f47534e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.u.c f47536e;

        public b(d.b.g0.a.e0.u.c cVar) {
            this.f47536e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (a.f47532b) {
                Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
            }
            a.this.f47533a = false;
            a.this.i();
            if (bool.booleanValue()) {
                this.f47536e.onSuccess();
            } else {
                this.f47536e.onFail();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context appContext = AppRuntime.getAppContext();
            Intent intent = new Intent(appContext, LoadingActivity.class);
            intent.addFlags(268435456);
            intent.putExtra(LoadingActivity.EXT_SO_LIB_NAME, ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
            e.f(appContext, intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.a.r1.d.e().r(LoadingActivity.EVENT_ID_HIDE);
        }
    }

    @Override // d.b.g0.d.j.c.b.InterfaceC0924b
    public d.b.g0.l.o.b a() {
        return new d.b.g0.t.c();
    }

    @Override // d.b.g0.d.j.c.b.InterfaceC0924b
    public void b(boolean z, d.b.g0.a.e0.u.c cVar) {
        if (this.f47533a) {
            if (!z) {
                j();
            }
            l(cVar);
        } else if (z) {
            l(cVar);
        } else {
            k(new DialogInterface$OnClickListenerC0925a(cVar));
        }
    }

    public final void i() {
        d.b.g0.a.r1.d.g().post(new d(this));
    }

    public final void j() {
        d.b.g0.a.r1.d.g().post(new c(this));
    }

    public final void k(DialogInterface.OnClickListener onClickListener) {
        BaseActivityDialog.c newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.A(d.b.g0.d.e.aiapps_t7_download_tip_title);
        newBuilder.t(d.b.g0.d.e.aiapps_t7_download_tip_msg);
        newBuilder.v(d.b.g0.d.e.aiapps_t7_download_tip_btn_cancel, onClickListener);
        newBuilder.y(d.b.g0.d.e.aiapps_t7_download_tip_btn_ok, onClickListener);
        newBuilder.C();
    }

    public final void l(d.b.g0.a.e0.u.c cVar) {
        this.f47533a = true;
        if (f47532b) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        d.b.g0.a.j0.i.c cVar2 = d.b.g0.a.j0.i.c.f44831d;
        d.b.g0.a.j0.i.d dVar = new d.b.g0.a.j0.i.d();
        dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(cVar));
        cVar2.w(dVar);
    }
}
