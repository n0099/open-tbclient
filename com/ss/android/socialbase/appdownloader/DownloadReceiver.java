package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.e.a.d;
import d.p.a.e.a.k;
import d.p.a.e.b.g.d;
import d.p.a.e.b.l.e;
import d.p.a.e.b.p.b;
import java.util.List;
/* loaded from: classes6.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39064a = DownloadReceiver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Handler f39065b = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f39066e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f39067f;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0495a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f39069e;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0496a implements Runnable {
                public RunnableC0496a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RunnableC0495a.this.f39069e.O1()) {
                            e.Z(RunnableC0495a.this.f39069e);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public RunnableC0495a(a aVar, DownloadInfo downloadInfo) {
                this.f39069e = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.w0().execute(new RunnableC0496a());
            }
        }

        public a(Intent intent, Context context) {
            this.f39066e = intent;
            this.f39067f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri data = this.f39066e.getData();
            if (data == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            d.f t = d.p.a.e.a.e.F().t();
            if (t != null) {
                t.a(this.f39067f, schemeSpecificPart);
            }
            List<DownloadInfo> o = d.p.a.e.b.g.a.l(this.f39067f).o("application/vnd.android.package-archive");
            if (o != null) {
                for (DownloadInfo downloadInfo : o) {
                    if (downloadInfo != null && d.p.a.e.a.d.A(downloadInfo, schemeSpecificPart)) {
                        d.p.a.e.b.f.d i = d.p.a.e.b.g.a.l(this.f39067f).i(downloadInfo.c0());
                        if (i != null && e.I0(i.a())) {
                            i.a(9, downloadInfo, schemeSpecificPart, "");
                        }
                        d.p.a.e.b.p.a l = b.a().l(downloadInfo.c0());
                        if (l != null) {
                            l.g(null, false);
                        }
                        if (d.p.a.e.b.j.a.d(downloadInfo.c0()).b("install_queue_enable", 0) == 1) {
                            k.d().g(downloadInfo, schemeSpecificPart);
                        }
                        DownloadReceiver.this.f39065b.postDelayed(new RunnableC0495a(this, downloadInfo), 1000L);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        d.e b2 = d.p.a.e.a.e.F().b();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (b2 == null || b2.a())) {
            if (d.p.a.e.b.c.a.e()) {
                d.p.a.e.b.c.a.c(f39064a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (d.p.a.e.b.c.a.e()) {
                d.p.a.e.b.c.a.c(f39064a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            a(context, action);
        } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL) || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            d.p.a.e.b.g.d.w0().execute(new a(intent, context));
        }
    }

    private void a(Context context, String str) {
        if (d.p.a.e.b.g.d.f()) {
            try {
                Intent intent = new Intent(context, DownloadHandlerService.class);
                intent.setAction(str);
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
