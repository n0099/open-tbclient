package d.a.i0.e.o.b.d;

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
import d.a.i0.a.h0.s.b;
import d.a.i0.a.k;
import d.a.i0.a.v2.f;
import d.a.i0.e.e;
import d.a.i0.e.o.b.b;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC0958b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46392b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46393a = false;

    /* renamed from: d.a.i0.e.o.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC0959a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.s.c f46394e;

        public DialogInterface$OnClickListenerC0959a(d.a.i0.a.h0.s.c cVar) {
            this.f46394e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (-2 == i2) {
                return;
            }
            a.this.j();
            a.this.l(this.f46394e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.s.c f46396e;

        /* renamed from: d.a.i0.e.o.b.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0960a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f46398a;

            public C0960a(Boolean bool) {
                this.f46398a = bool;
            }

            @Override // d.a.i0.a.h0.s.b.c
            public void a() {
                b bVar = b.this;
                a.this.i(this.f46398a, bVar.f46396e);
            }
        }

        public b(d.a.i0.a.h0.s.c cVar) {
            this.f46396e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (a.f46392b) {
                Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
            }
            if (!bool.booleanValue()) {
                a.this.i(bool, this.f46396e);
            } else {
                SwanAppInitHelper.doWebViewInit(d.a.i0.a.a2.d.g(), new C0960a(bool));
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
            d.a.i0.a.a2.d.g().q(LoadingActivity.EVENT_ID_HIDE);
        }
    }

    @Override // d.a.i0.e.o.b.b.InterfaceC0958b
    public d.a.i0.n.l.b a() {
        return new d.a.i0.w.c();
    }

    @Override // d.a.i0.e.o.b.b.InterfaceC0958b
    public void b(boolean z, d.a.i0.a.h0.s.c cVar) {
        if (this.f46393a) {
            if (!z) {
                j();
            }
            l(cVar);
        } else if (z) {
            l(cVar);
        } else {
            k(new DialogInterface$OnClickListenerC0959a(cVar));
        }
    }

    @Override // d.a.i0.e.o.b.b.InterfaceC0958b
    public Bitmap d() {
        return null;
    }

    public void h() {
        d.a.i0.a.a2.d.i().post(new d(this));
    }

    public final void i(Boolean bool, d.a.i0.a.h0.s.c cVar) {
        this.f46393a = false;
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
        d.a.i0.a.a2.d.i().post(new c(this));
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.B(e.aiapps_t7_download_tip_title);
        newBuilder.u(e.aiapps_t7_download_tip_msg);
        newBuilder.w(e.aiapps_t7_download_tip_btn_cancel, onClickListener);
        newBuilder.z(e.aiapps_t7_download_tip_btn_ok, onClickListener);
        newBuilder.D();
    }

    public final void l(d.a.i0.a.h0.s.c cVar) {
        this.f46393a = true;
        if (f46392b) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        d.a.i0.a.n0.k.c cVar2 = d.a.i0.a.n0.k.c.f43471d;
        d.a.i0.a.n0.k.d dVar = new d.a.i0.a.n0.k.d();
        dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(cVar));
        cVar2.C(dVar);
    }
}
