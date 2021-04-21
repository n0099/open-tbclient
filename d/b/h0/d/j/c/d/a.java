package d.b.h0.d.j.c.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.b.h0.a.i2.e;
import d.b.h0.a.k;
import d.b.h0.d.j.c.b;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC0957b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48254b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f48255a = false;

    /* renamed from: d.b.h0.d.j.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0958a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.u.c f48256e;

        public DialogInterface$OnClickListenerC0958a(d.b.h0.a.e0.u.c cVar) {
            this.f48256e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (-2 == i) {
                this.f48256e.onFail();
                return;
            }
            a.this.j();
            a.this.l(this.f48256e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.i2.u0.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.e0.u.c f48258e;

        public b(d.b.h0.a.e0.u.c cVar) {
            this.f48258e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (a.f48254b) {
                Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
            }
            a.this.f48255a = false;
            a.this.i();
            if (bool.booleanValue()) {
                this.f48258e.onSuccess();
            } else {
                this.f48258e.onFail();
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
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
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
            d.b.h0.a.r1.d.e().r(LoadingActivity.EVENT_ID_HIDE);
        }
    }

    @Override // d.b.h0.d.j.c.b.InterfaceC0957b
    public d.b.h0.l.o.b a() {
        return new d.b.h0.t.c();
    }

    @Override // d.b.h0.d.j.c.b.InterfaceC0957b
    public void b(boolean z, d.b.h0.a.e0.u.c cVar) {
        if (this.f48255a) {
            if (!z) {
                j();
            }
            l(cVar);
        } else if (z) {
            l(cVar);
        } else {
            k(new DialogInterface$OnClickListenerC0958a(cVar));
        }
    }

    public final void i() {
        d.b.h0.a.r1.d.g().post(new d(this));
    }

    public final void j() {
        d.b.h0.a.r1.d.g().post(new c(this));
    }

    public final void k(DialogInterface.OnClickListener onClickListener) {
        BaseActivityDialog.c newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.A(d.b.h0.d.e.aiapps_t7_download_tip_title);
        newBuilder.t(d.b.h0.d.e.aiapps_t7_download_tip_msg);
        newBuilder.v(d.b.h0.d.e.aiapps_t7_download_tip_btn_cancel, onClickListener);
        newBuilder.y(d.b.h0.d.e.aiapps_t7_download_tip_btn_ok, onClickListener);
        newBuilder.C();
    }

    public final void l(d.b.h0.a.e0.u.c cVar) {
        this.f48255a = true;
        if (f48254b) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        d.b.h0.a.j0.i.c cVar2 = d.b.h0.a.j0.i.c.f45553d;
        d.b.h0.a.j0.i.d dVar = new d.b.h0.a.j0.i.d();
        dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(cVar));
        cVar2.w(dVar);
    }
}
