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
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.win.opensdk.G;
import com.win.opensdk.H;
import com.win.opensdk.L;
import com.win.opensdk.N;
import com.win.opensdk.O;
import com.win.opensdk.R;
import com.win.opensdk.V1;
import com.win.opensdk.Z0;
import com.win.opensdk.a1;
import com.win.opensdk.b1;
import com.win.opensdk.core.Info;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes7.dex */
public class WDownLoadService extends Service {

    /* renamed from: a */
    public String f39921a;

    /* renamed from: b */
    public String f39922b;

    /* renamed from: c */
    public String f39923c;

    /* renamed from: d */
    public NotificationManager f39924d;

    /* renamed from: e */
    public Notification f39925e;

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.N.b():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.N.a():void, com.win.opensdk.N.c():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        return PendingIntent.getActivity(this, 0, G.a(info, getApplicationContext(), this.f39921a), 134217728);
    }

    public void a(Info info, String str, String str2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
                builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(R.drawable.win_downloadicon).setTicker(str).setContentText(str2).build();
                if (i <= 0 || i > 100) {
                    builder.setProgress(0, 0, false);
                    builder.setContentText(str2);
                } else {
                    builder.setProgress(100, i, false);
                }
                builder.setContentIntent(i >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
                notificationManager.notify(232, builder.build());
                return;
            }
            return;
        }
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this);
        builder2.setSmallIcon(R.drawable.win_downloadicon);
        builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.win_downloadicon));
        builder2.setContentTitle(str);
        if (i <= 0 || i >= 100) {
            builder2.setProgress(0, 0, false);
            builder2.setContentText(str2);
        } else {
            builder2.setProgress(100, i, false);
        }
        builder2.setWhen(System.currentTimeMillis());
        builder2.setTicker(str);
        builder2.setContentIntent(i >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
        Notification build = builder2.build();
        this.f39925e = build;
        this.f39924d.notify(232, build);
    }

    public final boolean a() {
        File file = new File(this.f39921a);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public final void b(Info info) {
        new Handler().postDelayed(new O(this, info), 400L);
    }

    public final void c(Info info) {
        Z0 a2 = a1.a(getApplicationContext());
        b1 b1Var = new b1(info);
        String str = this.f39922b;
        try {
            a2.f39850b = a1.a("wdst", b1Var);
            a2.a("msg", a1.a(str));
        } catch (JSONException unused) {
        }
        String str2 = this.f39921a;
        try {
            str2 = G.a(str2);
        } catch (Exception unused2) {
        }
        a2.a("desc", str2).a();
        try {
            G.a(info, 300, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                G.i(info.getVv_downs_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        H h2 = H.f39674d;
        String str3 = this.f39922b;
        String str4 = this.f39921a;
        N n = new N(this, info);
        if (h2.f39677c) {
            return;
        }
        File file = new File(str4.substring(0, str4.lastIndexOf("/") + 1));
        File file2 = new File(str4);
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
        L l = new L(str3, str4, n);
        h2.f39676b = l;
        new WeakReference(h2.f39675a.submit(l));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f39924d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            H.f39674d.f39677c = false;
            if (this.f39924d != null) {
                this.f39924d.cancel(232);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String string;
        int i3;
        Info info = null;
        try {
            this.f39922b = intent.getStringExtra("down_load_apk_url");
            this.f39923c = intent.getStringExtra("down_load_pkg_name");
            this.f39921a = G.a(getApplicationContext()) + File.separator + "win" + File.separator + G.e(this.f39922b);
            File parentFile = new File(this.f39921a).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                info = (Info) V1.b(getApplicationContext(), this.f39923c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (info != null) {
                string = info.getDl_name();
                i3 = R.string.wdownload_start;
            } else {
                string = getString(R.string.wdownload_start);
                i3 = R.string.wdownload_start;
            }
            a(info, string, getString(i3), 0);
            c(info);
        } catch (Exception e3) {
            e3.printStackTrace();
            if (info != null) {
                a1.a(getApplicationContext()).b(new b1(info), 3).a("desc", e3.getMessage()).a();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
