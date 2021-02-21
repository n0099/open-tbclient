package com.win.opensdk.downloader;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.win.opensdk.az;
import com.win.opensdk.bt;
import com.win.opensdk.bu;
import com.win.opensdk.bv;
import com.win.opensdk.core.Info;
import com.win.opensdk.d;
import com.win.opensdk.i;
import com.win.opensdk.w;
import com.win.opensdk.x;
import com.win.opensdk.z;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class WDownLoadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private String f13746a;

    /* renamed from: case  reason: not valid java name */
    private String f51case;
    private Notification java;

    /* renamed from: java  reason: collision with other field name */
    private NotificationManager f52java;

    /* renamed from: java  reason: collision with other field name */
    private String f53java;

    @Override // android.app.Service
    public void onCreate() {
        this.f52java = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        final Info info = null;
        try {
            this.f51case = intent.getStringExtra("down_load_apk_url");
            this.f13746a = intent.getStringExtra("down_load_pkg_name");
            this.f53java = bv.iS(getApplicationContext()) + File.separator + "win" + File.separator + bv.abU(this.f51case);
            File parentFile = new File(this.f53java).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                info = (Info) az.bK(getApplicationContext(), this.f13746a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (info != null) {
                java(info, info.getDl_name(), getString(d.e.wdownload_start), 0);
            } else {
                java(info, getString(d.e.wdownload_start), getString(d.e.wdownload_start), 0);
            }
            w.iN(getApplicationContext()).b(new x(info), this.f51case).hD("desc", w.abU(this.f53java)).eIX();
            try {
                z.a(info, 300);
                if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                    z.abR(info.getVv_downs_urls());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            bu eJy = bu.eJy();
            String str = this.f51case;
            String str2 = this.f53java;
            bt btVar = new bt() { // from class: com.win.opensdk.downloader.WDownLoadService.1
                @Override // com.win.opensdk.bt
                public final void Sf(int i3) {
                    bu.eJy().qjq = true;
                    if (info != null) {
                        WDownLoadService.this.java(info, info.getDl_name(), WDownLoadService.this.getString(d.e.wdownload_processing), i3);
                    } else {
                        WDownLoadService.this.java(info, WDownLoadService.this.getString(d.e.wdownload_processing), WDownLoadService.this.getString(d.e.wdownload_processing), i3);
                    }
                }

                @Override // com.win.opensdk.bt
                public final void eIX() {
                    bu.eJy().qjq = false;
                    if (info != null) {
                        WDownLoadService.this.java(info, info.getDl_name(), WDownLoadService.this.getString(d.e.wdownload_failed_msg), 0);
                    } else {
                        WDownLoadService.this.java(info, WDownLoadService.this.getString(d.e.wdownload_failed), WDownLoadService.this.getString(d.e.wdownload_failed_msg), 0);
                    }
                    WDownLoadService.m76java(WDownLoadService.this);
                    WDownLoadService.this.stopSelf();
                    w.iN(WDownLoadService.this.getApplicationContext()).b(new x(info), 1).eIX();
                }

                @Override // com.win.opensdk.bt
                public final void eIY() {
                    bu.eJy().qjq = false;
                    w.iN(WDownLoadService.this.getApplicationContext()).b(new x(info), 200).eIX();
                    Info info2 = info;
                    try {
                        z.a(info2, 301);
                        if (info2 != null && !TextUtils.isEmpty(info2.getVv_downf_urls())) {
                            z.abR(info2.getVv_downf_urls());
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    WDownLoadService.java(WDownLoadService.this, info);
                    WDownLoadService.this.stopSelf();
                    w.iN(WDownLoadService.this.getApplicationContext()).g(new x(info), WDownLoadService.this.f53java).eIX();
                    bv.a(info, WDownLoadService.this.getApplicationContext(), WDownLoadService.this.f53java);
                }

                @Override // com.win.opensdk.bt
                public final void a() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.win.opensdk.downloader.WDownLoadService.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Toast.makeText(WDownLoadService.this.getApplicationContext(), d.e.win_toast_network_error2, 0).show();
                        }
                    });
                    bu.eJy().qjq = false;
                    w.iN(WDownLoadService.this.getApplicationContext()).b(new x(info), 2).eIX();
                    if (info != null) {
                        WDownLoadService.this.java(info, info.getDl_name(), WDownLoadService.this.getString(d.e.wdownload_failed_msg), 0);
                    } else {
                        WDownLoadService.this.java(info, WDownLoadService.this.getString(d.e.wdownload_failed), WDownLoadService.this.getString(d.e.wdownload_failed_msg), 0);
                    }
                    try {
                        WDownLoadService.m76java(WDownLoadService.this);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    WDownLoadService.this.stopSelf();
                }
            };
            if (!eJy.qjq) {
                File file = new File(str2.substring(0, str2.lastIndexOf("/") + 1));
                File file2 = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (!file2.exists()) {
                    try {
                        file2.createNewFile();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                eJy.qlc = new i(str, str2, btVar);
                new WeakReference(eJy.qkN.submit(eJy.qlc));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            if (info != null) {
                w.iN(getApplicationContext()).a(new x(info), 3).hD("desc", e4.getMessage()).eIX();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public final void java(Info info, String str, String str2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            m75case(info, str, str2, i);
        } else {
            a(info, str, str2, i);
        }
    }

    /* renamed from: case  reason: not valid java name */
    private void m75case(Info info, String str, String str2, int i) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
            NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
            builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(d.a.win_downloadicon).setTicker(str).setContentText(str2).build();
            if (i > 0 && i <= 100) {
                builder.setProgress(100, i, false);
            } else {
                builder.setProgress(0, 0, false);
                builder.setContentText(str2);
            }
            builder.setContentIntent(i >= 100 ? java(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
            notificationManager.notify(232, builder.build());
        }
    }

    private void a(Info info, String str, String str2, int i) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(d.a.win_downloadicon);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), d.a.win_downloadicon));
        builder.setContentTitle(str);
        if (i > 0 && i < 100) {
            builder.setProgress(100, i, false);
        } else {
            builder.setProgress(0, 0, false);
            builder.setContentText(str2);
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setTicker(str);
        builder.setContentIntent(i >= 100 ? java(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
        this.java = builder.build();
        this.f52java.notify(232, this.java);
    }

    private PendingIntent java(Info info) {
        return PendingIntent.getActivity(this, 0, bv.b(info, getApplicationContext(), this.f53java), 134217728);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            bu.eJy().qjq = false;
            if (this.f52java != null) {
                this.f52java.cancel(232);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: java  reason: collision with other method in class */
    static /* synthetic */ boolean m76java(WDownLoadService wDownLoadService) {
        File file = new File(wDownLoadService.f53java);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    static /* synthetic */ void java(WDownLoadService wDownLoadService, final Info info) {
        new Handler().postDelayed(new Runnable() { // from class: com.win.opensdk.downloader.WDownLoadService.2
            @Override // java.lang.Runnable
            public final void run() {
                if (info != null) {
                    WDownLoadService.this.java(info, info.getDl_name(), WDownLoadService.this.getString(d.e.wdownload_download_finish), 100);
                } else {
                    WDownLoadService.this.java(info, WDownLoadService.this.getString(d.e.wdownload_download_finish), WDownLoadService.this.getString(d.e.wdownload_download_finish), 100);
                }
            }
        }, 400L);
    }
}
