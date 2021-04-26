package d.a.h0.d.j.c.d;

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
import d.a.h0.a.i2.e;
import d.a.h0.a.k;
import d.a.h0.d.j.c.b;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC0896b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45704b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f45705a = false;

    /* renamed from: d.a.h0.d.j.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0897a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.u.c f45706e;

        public DialogInterface$OnClickListenerC0897a(d.a.h0.a.e0.u.c cVar) {
            this.f45706e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (-2 == i2) {
                this.f45706e.onFail();
                return;
            }
            a.this.j();
            a.this.l(this.f45706e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.u.c f45708e;

        public b(d.a.h0.a.e0.u.c cVar) {
            this.f45708e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (a.f45704b) {
                Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
            }
            a.this.f45705a = false;
            a.this.i();
            if (bool.booleanValue()) {
                this.f45708e.onSuccess();
            } else {
                this.f45708e.onFail();
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
            d.a.h0.a.r1.d.e().o(LoadingActivity.EVENT_ID_HIDE);
        }
    }

    @Override // d.a.h0.d.j.c.b.InterfaceC0896b
    public d.a.h0.l.o.b a() {
        return new d.a.h0.t.c();
    }

    @Override // d.a.h0.d.j.c.b.InterfaceC0896b
    public void b(boolean z, d.a.h0.a.e0.u.c cVar) {
        if (this.f45705a) {
            if (!z) {
                j();
            }
            l(cVar);
        } else if (z) {
            l(cVar);
        } else {
            k(new DialogInterface$OnClickListenerC0897a(cVar));
        }
    }

    public final void i() {
        d.a.h0.a.r1.d.g().post(new d(this));
    }

    public final void j() {
        d.a.h0.a.r1.d.g().post(new c(this));
    }

    public final void k(DialogInterface.OnClickListener onClickListener) {
        BaseActivityDialog.c newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.A(d.a.h0.d.e.aiapps_t7_download_tip_title);
        newBuilder.t(d.a.h0.d.e.aiapps_t7_download_tip_msg);
        newBuilder.v(d.a.h0.d.e.aiapps_t7_download_tip_btn_cancel, onClickListener);
        newBuilder.y(d.a.h0.d.e.aiapps_t7_download_tip_btn_ok, onClickListener);
        newBuilder.C();
    }

    public final void l(d.a.h0.a.e0.u.c cVar) {
        this.f45705a = true;
        if (f45704b) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        d.a.h0.a.j0.i.c cVar2 = d.a.h0.a.j0.i.c.f42874d;
        d.a.h0.a.j0.i.d dVar = new d.a.h0.a.j0.i.d();
        dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(cVar));
        cVar2.w(dVar);
    }
}
