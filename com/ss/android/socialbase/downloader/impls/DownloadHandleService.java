package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import d.o.a.e.b.g.d;
import d.o.a.e.b.g.e;
/* loaded from: classes7.dex */
public class DownloadHandleService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39847a = DownloadHandleService.class.getSimpleName();

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f39848e;

        public a(int i2) {
            this.f39848e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e.c().J(this.f39848e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void a(Intent intent) {
        int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
            d.w0().execute(new a(intExtra));
        } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
            e.c().K(intExtra);
        } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
            d.Y();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d.y(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        super.onStartCommand(intent, i2, i3);
        a(intent);
        return 2;
    }
}
