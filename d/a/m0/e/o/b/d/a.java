package d.a.m0.e.o.b.d;

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
import d.a.m0.a.h0.s.b;
import d.a.m0.a.k;
import d.a.m0.a.v2.f;
import d.a.m0.e.e;
import d.a.m0.e.o.b.b;
/* loaded from: classes3.dex */
public class a implements b.InterfaceC1028b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50350b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public boolean f50351a = false;

    /* renamed from: d.a.m0.e.o.b.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class DialogInterface$OnClickListenerC1029a implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.s.c f50352e;

        public DialogInterface$OnClickListenerC1029a(d.a.m0.a.h0.s.c cVar) {
            this.f50352e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (-2 == i2) {
                return;
            }
            a.this.j();
            a.this.l(this.f50352e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<Boolean> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.h0.s.c f50354e;

        /* renamed from: d.a.m0.e.o.b.d.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1030a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Boolean f50356a;

            public C1030a(Boolean bool) {
                this.f50356a = bool;
            }

            @Override // d.a.m0.a.h0.s.b.c
            public void a() {
                b bVar = b.this;
                a.this.i(this.f50356a, bVar.f50354e);
            }
        }

        public b(d.a.m0.a.h0.s.c cVar) {
            this.f50354e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(Boolean bool) {
            if (a.f50350b) {
                Log.i("SailorSoDownloadAdapter", "startDownload onCallback: " + bool);
            }
            if (!bool.booleanValue()) {
                a.this.i(bool, this.f50354e);
            } else {
                SwanAppInitHelper.doWebViewInit(d.a.m0.a.a2.d.g(), new C1030a(bool));
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
            d.a.m0.a.a2.d.g().q(LoadingActivity.EVENT_ID_HIDE);
        }
    }

    @Override // d.a.m0.e.o.b.b.InterfaceC1028b
    public d.a.m0.n.l.b a() {
        return new d.a.m0.w.c();
    }

    @Override // d.a.m0.e.o.b.b.InterfaceC1028b
    public void b(boolean z, d.a.m0.a.h0.s.c cVar) {
        if (this.f50351a) {
            if (!z) {
                j();
            }
            l(cVar);
        } else if (z) {
            l(cVar);
        } else {
            k(new DialogInterface$OnClickListenerC1029a(cVar));
        }
    }

    @Override // d.a.m0.e.o.b.b.InterfaceC1028b
    public Bitmap d() {
        return null;
    }

    public void h() {
        d.a.m0.a.a2.d.i().post(new d(this));
    }

    public final void i(Boolean bool, d.a.m0.a.h0.s.c cVar) {
        this.f50351a = false;
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
        d.a.m0.a.a2.d.i().post(new c(this));
    }

    public void k(DialogInterface.OnClickListener onClickListener) {
        BaseActivityDialog.e newBuilder = SwanAppErrorDialog.newBuilder();
        newBuilder.B(e.aiapps_t7_download_tip_title);
        newBuilder.u(e.aiapps_t7_download_tip_msg);
        newBuilder.w(e.aiapps_t7_download_tip_btn_cancel, onClickListener);
        newBuilder.z(e.aiapps_t7_download_tip_btn_ok, onClickListener);
        newBuilder.D();
    }

    public final void l(d.a.m0.a.h0.s.c cVar) {
        this.f50351a = true;
        if (f50350b) {
            Log.i("SailorSoDownloadAdapter", "startDownload: ");
        }
        d.a.m0.a.n0.k.c cVar2 = d.a.m0.a.n0.k.c.f47429d;
        d.a.m0.a.n0.k.d dVar = new d.a.m0.a.n0.k.d();
        dVar.h(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, new b(cVar));
        cVar2.C(dVar);
    }
}
