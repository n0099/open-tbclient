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
import com.win.opensdk.A;
import com.win.opensdk.E;
import com.win.opensdk.G;
import com.win.opensdk.H;
import com.win.opensdk.R;
import com.win.opensdk.core.Info;
import com.win.opensdk.s1;
import com.win.opensdk.w0;
import com.win.opensdk.x0;
import com.win.opensdk.y0;
import com.win.opensdk.z;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes6.dex */
public class WDownLoadService extends Service {

    /* renamed from: a */
    public String f37854a;

    /* renamed from: b */
    public String f37855b;

    /* renamed from: c */
    public String f37856c;

    /* renamed from: d */
    public NotificationManager f37857d;

    /* renamed from: e */
    public Notification f37858e;

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.G.b():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.G.a():void, com.win.opensdk.G.c():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        return PendingIntent.getActivity(this, 0, z.a(info, getApplicationContext(), this.f37854a), 134217728);
    }

    public void a(Info info, String str, String str2, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
                builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(R.drawable.win_downloadicon).setTicker(str).setContentText(str2).build();
                if (i2 <= 0 || i2 > 100) {
                    builder.setProgress(0, 0, false);
                    builder.setContentText(str2);
                } else {
                    builder.setProgress(100, i2, false);
                }
                builder.setContentIntent(i2 >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
                notificationManager.notify(232, builder.build());
                return;
            }
            return;
        }
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this);
        builder2.setSmallIcon(R.drawable.win_downloadicon);
        builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.win_downloadicon));
        builder2.setContentTitle(str);
        if (i2 <= 0 || i2 >= 100) {
            builder2.setProgress(0, 0, false);
            builder2.setContentText(str2);
        } else {
            builder2.setProgress(100, i2, false);
        }
        builder2.setWhen(System.currentTimeMillis());
        builder2.setTicker(str);
        builder2.setContentIntent(i2 >= 100 ? a(info) : PendingIntent.getActivity(this, 0, new Intent(), 134217728));
        Notification build = builder2.build();
        this.f37858e = build;
        this.f37857d.notify(232, build);
    }

    public final boolean a() {
        File file = new File(this.f37854a);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public final void b(Info info) {
        new Handler().postDelayed(new H(this, info), 400L);
    }

    public final void c(Info info) {
        w0 a2 = x0.a(getApplicationContext());
        y0 y0Var = new y0(info);
        String str = this.f37855b;
        try {
            a2.f37984b = x0.a("wdst", y0Var);
            a2.a("msg", x0.a(str));
        } catch (JSONException unused) {
        }
        String str2 = this.f37854a;
        try {
            str2 = z.a(str2);
        } catch (Exception unused2) {
        }
        a2.a("desc", str2).a();
        try {
            z.a(info, 300, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                z.g(info.getVv_downs_urls());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        A a3 = A.f37602d;
        String str3 = this.f37855b;
        String str4 = this.f37854a;
        G g2 = new G(this, info);
        if (a3.f37605c) {
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
        E e4 = new E(str3, str4, g2);
        a3.f37604b = e4;
        new WeakReference(a3.f37603a.submit(e4));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.f37857d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            A.f37602d.f37605c = false;
            if (this.f37857d != null) {
                this.f37857d.cancel(232);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        String string;
        int i4;
        Info info = null;
        try {
            this.f37855b = intent.getStringExtra("down_load_apk_url");
            this.f37856c = intent.getStringExtra("down_load_pkg_name");
            this.f37854a = z.a(getApplicationContext()) + File.separator + "win" + File.separator + z.e(this.f37855b);
            File parentFile = new File(this.f37854a).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                info = (Info) s1.b(getApplicationContext(), this.f37856c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (info != null) {
                string = info.getDl_name();
                i4 = R.string.win_wdownload_start;
            } else {
                string = getString(R.string.win_wdownload_start);
                i4 = R.string.win_wdownload_start;
            }
            a(info, string, getString(i4), 0);
            c(info);
        } catch (Exception e3) {
            e3.printStackTrace();
            if (info != null) {
                x0.a(getApplicationContext()).b(new y0(info), 3).a("desc", e3.getMessage()).a();
            }
        }
        return super.onStartCommand(intent, i2, i3);
    }
}
