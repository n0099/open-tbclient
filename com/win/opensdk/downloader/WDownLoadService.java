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
import com.win.opensdk.aj;
import com.win.opensdk.ao;
import com.win.opensdk.ar;
import com.win.opensdk.bd;
import com.win.opensdk.bp;
import com.win.opensdk.bx;
import com.win.opensdk.ca;
import com.win.opensdk.cd;
import com.win.opensdk.core.Info;
import com.win.opensdk.v;
import com.win.opensdk.z;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONException;
/* loaded from: classes14.dex */
public class WDownLoadService extends Service {

    /* renamed from: a */
    public String f8155a;
    public String b;
    public String c;
    public NotificationManager d;
    public Notification e;

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.ao.b():void] */
    public static /* synthetic */ void a(WDownLoadService wDownLoadService, Info info) {
        wDownLoadService.b(info);
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.win.opensdk.ao.a():void, com.win.opensdk.ao.c():void] */
    public static /* synthetic */ boolean a(WDownLoadService wDownLoadService) {
        return wDownLoadService.a();
    }

    public final PendingIntent a(Info info) {
        return PendingIntent.getActivity(this, 0, v.b(info, getApplicationContext(), this.f8155a), 134217728);
    }

    public void a(Info info, String str, String str2, int i) {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                notificationManager.createNotificationChannel(new NotificationChannel("win_download_id", "win_download", 2));
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "win_download_id");
                builder.setChannelId("win_download_id").setContentTitle(str).setSmallIcon(bd.a.win_downloadicon).setTicker(str).setContentText(str2).build();
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
        builder2.setSmallIcon(bd.a.win_downloadicon);
        builder2.setLargeIcon(BitmapFactory.decodeResource(getResources(), bd.a.win_downloadicon));
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
        this.e = builder2.build();
        this.d.notify(232, this.e);
    }

    public final boolean a() {
        File file = new File(this.f8155a);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public final void b(Info info) {
        new Handler().postDelayed(new ar(this, info), 400L);
    }

    public final void c(Info info) {
        bx iT = ca.iT(getApplicationContext());
        cd cdVar = new cd(info);
        String str = this.b;
        try {
            iT.qlo = ca.a("wdst", cdVar);
            iT.hD("msg", ca.a(str));
        } catch (JSONException e) {
        }
        String str2 = this.f8155a;
        try {
            str2 = v.a(str2);
        } catch (Exception e2) {
        }
        iT.hD("desc", str2).a();
        try {
            v.a(info, 300, "");
            if (info != null && !TextUtils.isEmpty(info.getVv_downs_urls())) {
                v.i(info.getVv_downs_urls());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        z zVar = z.qkE;
        String str3 = this.b;
        String str4 = this.f8155a;
        ao aoVar = new ao(this, info);
        if (!zVar.c) {
            File file = new File(str4.substring(0, str4.lastIndexOf("/") + 1));
            File file2 = new File(str4);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!file2.exists()) {
                try {
                    file2.createNewFile();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            zVar.qkF = new aj(str3, str4, aoVar);
            new WeakReference(zVar.f8180a.submit(zVar.qkF));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.d = (NotificationManager) getSystemService(ActionJsonData.TAG_NOTIFICATION);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        try {
            z.qkE.c = false;
            if (this.d != null) {
                this.d.cancel(232);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String string;
        String string2;
        Info info;
        WDownLoadService wDownLoadService;
        Info info2 = null;
        try {
            this.b = intent.getStringExtra("down_load_apk_url");
            this.c = intent.getStringExtra("down_load_pkg_name");
            this.f8155a = v.a(getApplicationContext()) + File.separator + "win" + File.separator + v.e(this.b);
            File parentFile = new File(this.f8155a).getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                info2 = (Info) bp.b(getApplicationContext(), this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (info2 != null) {
                string = info2.getDl_name();
                string2 = getString(bd.e.wdownload_start);
                info = info2;
                wDownLoadService = this;
            } else {
                string = getString(bd.e.wdownload_start);
                string2 = getString(bd.e.wdownload_start);
                info = info2;
                wDownLoadService = this;
            }
            wDownLoadService.a(info, string, string2, 0);
            c(info2);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (info2 != null) {
                ca.iT(getApplicationContext()).a(new cd(info2), 3).hD("desc", e2.getMessage()).a();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
