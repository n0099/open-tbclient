package d.a.l0.e.o.b.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import com.baidu.swan.facade.requred.webview.LoadingActivity;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import d.a.l0.a.h0.s.b;
import d.a.l0.a.k;
import d.a.l0.a.v2.f;
import d.a.l0.e.e;
import d.a.l0.e.o.b.b;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC1025b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50242b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50243a = false;

    /* renamed from: d.a.l0.e.o.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC1026a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.s.c f50244e;

        public DialogInterface$OnClickListenerC1026a(d.a.l0.a.h0.s.c cVar) {
            this.f50244e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (-2 == i2) {
                return;
            }
            a.this.j();
            a.this.l(this.f50244e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.h0.s.c f50246e;

        /* renamed from: d.a.l0.e.o.b.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1027a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f50248a;

            public C1027a(Boolean bool) {
                this.f50248a = bool;
            }

            @Override // d.a.l0.a.h0.s.b.c
            public void a() {
                b bVar = b.this;
                a.this.i(this.f50248a, bVar.f50246e);
            }
        }

        public b(d.a.l0.a.h0.s.c cVar) {
            this.f50246e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (a.f50242b) {
                Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
            }
            if (!bool.booleanValue()) {
                a.this.i(bool, this.f50246e);
            } else {
                SwanAppInitHelper.doWebViewInit(d.a.l0.a.a2.d.g(), new C1027a(bool));
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
            f.g(appContext, intent);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.a2.d.g().q(LoadingActivity.EVENT_ID_HIDE);
        }
    }

    @Override // d.a.l0.e.o.b.b.InterfaceC1025b
    public d.a.l0.n.l.b a() {
        return new d.a.l0.w.c();
    }

    @Override // d.a.l0.e.o.b.b.InterfaceC1025b
    public void b(boolean z, d.a.l0.a.h0.s.c cVar) {
        if (this.f50243a) {
            if (!z) {
                j();
            }
            l(cVar);
        } else if (z) {
            l(cVar);
        } else {
            k(new DialogInterface$OnClickListenerC1026a(cVar));
        }
    }

    @Override // d.a.l0.e.o.b.b.InterfaceC1025b
    public Bitmap d() {
        return null;
    }

    public void h() {
        d.a.l0.a.a2.d.i().post(new d(this));
    }

    public final void i(Boolean bool, d.a.l0.a.h0.s.c cVar) {
        this.f50243a = false;
        h();
        if (cVar != null) {
            if (bool.booleanValue()) {
                cVar.onSuccess();
            } else {
                cVar.onFail();
            }
        }
    }

    public void j() {
        d.a.l0.a.a2.d.i().post(new c(this));
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.B(e.aiapps_t7_download_tip_title);
        newBuilder.u(e.aiapps_t7_download_tip_msg);
        newBuilder.w(e.aiapps_t7_download_tip_btn_cancel, onClickListener);
        newBuilder.z(e.aiapps_t7_download_tip_btn_ok, onClickListener);
        newBuilder.D();
    }

    public final void l(d.a.l0.a.h0.s.c cVar) {
        this.f50243a = true;
        if (f50242b) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        d.a.l0.a.n0.k.c cVar2 = d.a.l0.a.n0.k.c.f47321d;
        d.a.l0.a.n0.k.d dVar = new d.a.l0.a.n0.k.d();
        dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(cVar));
        cVar2.C(dVar);
    }
}
