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
import d.o.a.e.a.d;
import d.o.a.e.a.k;
import d.o.a.e.b.g.d;
import d.o.a.e.b.l.e;
import d.o.a.e.b.p.b;
import java.util.List;
/* loaded from: classes6.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36650a = DownloadReceiver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public Handler f36651b = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Intent f36652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f36653f;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0439a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f36655e;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0440a implements Runnable {
                public RunnableC0440a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RunnableC0439a.this.f36655e.O1()) {
                            e.Z(RunnableC0439a.this.f36655e);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public RunnableC0439a(a aVar, DownloadInfo downloadInfo) {
                this.f36655e = downloadInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.w0().execute(new RunnableC0440a());
            }
        }

        public a(Intent intent, Context context) {
            this.f36652e = intent;
            this.f36653f = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri data = this.f36652e.getData();
            if (data == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            d.f t = d.o.a.e.a.e.F().t();
            if (t != null) {
                t.a(this.f36653f, schemeSpecificPart);
            }
            List<DownloadInfo> o = d.o.a.e.b.g.a.l(this.f36653f).o("application/vnd.android.package-archive");
            if (o != null) {
                for (DownloadInfo downloadInfo : o) {
                    if (downloadInfo != null && d.o.a.e.a.d.A(downloadInfo, schemeSpecificPart)) {
                        d.o.a.e.b.f.d i2 = d.o.a.e.b.g.a.l(this.f36653f).i(downloadInfo.c0());
                        if (i2 != null && e.I0(i2.a())) {
                            i2.a(9, downloadInfo, schemeSpecificPart, "");
                        }
                        d.o.a.e.b.p.a l = b.a().l(downloadInfo.c0());
                        if (l != null) {
                            l.g(null, false);
                        }
                        if (d.o.a.e.b.j.a.d(downloadInfo.c0()).b("install_queue_enable", 0) == 1) {
                            k.d().g(downloadInfo, schemeSpecificPart);
                        }
                        DownloadReceiver.this.f36651b.postDelayed(new RunnableC0439a(this, downloadInfo), 1000L);
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
        d.e b2 = d.o.a.e.a.e.F().b();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (b2 == null || b2.a())) {
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.c(f36650a, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            a(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (d.o.a.e.b.c.a.e()) {
                d.o.a.e.b.c.a.c(f36650a, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            a(context, action);
        } else if (action.equals(PackageChangedReceiver.ACTION_INSTALL) || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            d.o.a.e.b.g.d.w0().execute(new a(intent, context));
        }
    }

    private void a(Context context, String str) {
        if (d.o.a.e.b.g.d.f()) {
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
