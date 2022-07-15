package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.ActionJsonData;
import com.ksad.download.DownloadTask;
import com.ksad.download.d;
import com.ksad.download.f;
import com.ksad.download.g;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class a implements f {
    public static c b;
    public static HashMap<String, WeakReference<Bitmap>> a = new HashMap<>();
    public static final Handler c = new HandlerC0540a();

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class HandlerC0540a extends Handler {
        public final SparseArray<Long> a;

        public HandlerC0540a() {
            super(Looper.getMainLooper());
            this.a = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            boolean z2 = message.arg2 == 1;
            boolean z3 = message.arg2 == 2;
            Long l = this.a.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.ksad.download.b.a().getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (notificationManager == null) {
                return;
            }
            if (d.a().a(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            } else {
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.b(message.what, (Notification) message.obj);
                this.a.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static String a = "ksad_notification_default_icon";
        public String b;
        public String c;
        public String d;
        public String e;
        public int f;
        public String h;
        public File g = null;
        public boolean i = false;

        public static String a() {
            return a;
        }

        public static b b(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File a2 = ((com.kwad.sdk.service.kwai.a) ServiceProvider.a(com.kwad.sdk.service.kwai.a.class)).a(downloadParams.mAppIcon);
                if (a2 != null && a2.exists()) {
                    bVar.g = a2;
                }
                bVar.b = downloadParams.mAppName;
            }
            bVar.i = downloadTask.isPaused();
            bVar.c = str;
            bVar.h = str2;
            bVar.d = a.b(downloadTask.getSmallFileSoFarBytes()) + " / " + a.b(downloadTask.getSmallFileTotalBytes());
            bVar.e = a.b((long) downloadTask.getSmallFileTotalBytes());
            bVar.f = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public static b b(DownloadParams downloadParams, String str, String str2) {
            File a2;
            b bVar = new b();
            bVar.b = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (a2 = ((com.kwad.sdk.service.kwai.a) ServiceProvider.a(com.kwad.sdk.service.kwai.a.class)).a(downloadParams.mAppIcon)) != null && a2.exists()) {
                bVar.g = a2;
            }
            bVar.c = str;
            bVar.e = a.b(downloadParams.mAppSize);
            bVar.h = str2;
            return bVar;
        }

        public final String b() {
            String str = this.b;
            return str == null ? "" : str;
        }

        public final String c() {
            return this.d;
        }

        public final String d() {
            return this.e;
        }

        public final String e() {
            return this.c;
        }

        public final File f() {
            return this.g;
        }

        public final String g() {
            return "正在下载 " + this.f + "%";
        }

        public final int h() {
            return this.f;
        }

        public final String i() {
            return this.h;
        }

        public final boolean j() {
            return this.i;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BroadcastReceiver {
        public static void a(@NonNull Intent intent) {
            DownloadTask c = c(intent);
            if (c == null) {
                return;
            }
            d.a().e(c.getId());
        }

        public static void b(@NonNull Intent intent) {
            DownloadTask c = c(intent);
            if (c == null) {
                return;
            }
            c.setNotificationRemoved(true);
        }

        @Nullable
        public static DownloadTask c(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return d.a().a(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if (RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN.equals(action)) {
                a(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                b(intent);
            }
        }
    }

    public a(Context context) {
        a(context);
    }

    public static PendingIntent a(Context context, String str, int i) {
        Intent intent = new Intent(str);
        intent.putExtra("taskId", i);
        return PendingIntent.getBroadcast(context, i, intent, 0);
    }

    public static Bitmap a(Context context, String str) {
        WeakReference<Bitmap> weakReference = a.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(al.a(context), al.a(context, str));
            a.put(str, new WeakReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    public static void a(Context context) {
        if (b != null || context == null) {
            return;
        }
        b = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN);
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        context.registerReceiver(b, intentFilter);
    }

    public static void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(al.a(context, "ksad_notification_small_icon"));
        if (z2) {
            builder.setDeleteIntent(a(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i));
        }
        c.removeMessages(i);
        c.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private void a(Context context, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        bVar.a(bVar2.b());
        File f = bVar2.f();
        if (!((f == null || !f.exists()) ? false : a(bVar, f))) {
            a(context, bVar, b.a());
        }
        bVar.b(bVar2.e());
        bVar.c(bVar2.d());
        bVar.d(bVar2.i());
    }

    private void a(Context context, com.kwad.sdk.core.download.a.c cVar, b bVar) {
        cVar.a(bVar.b());
        File f = bVar.f();
        if (!((f == null || !f.exists()) ? false : a(cVar, f))) {
            a(context, cVar, b.a());
        }
        cVar.b(bVar.e());
        cVar.c(bVar.c());
        cVar.d(bVar.g());
        cVar.a(100, bVar.h(), false);
        cVar.a(bVar.j());
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.b bVar, String str) {
        try {
            bVar.a(a(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            com.kwad.sdk.service.a.a(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.c cVar, String str) {
        try {
            cVar.a(a(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            com.kwad.sdk.service.a.a(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.b bVar, File file) {
        try {
            bVar.a(b(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            com.kwad.sdk.service.a.a(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.c cVar, File file) {
        try {
            cVar.a(b(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
            com.kwad.sdk.service.a.a(e);
            return false;
        }
    }

    public static Bitmap b(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = a.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
            a.put(absolutePath, new WeakReference<>(decodeFile));
            return decodeFile;
        }
        return bitmap;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    public static void b(int i, Notification notification) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) a2.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.a(e);
        }
    }

    public static DownloadParams d(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    @Override // com.ksad.download.f
    public final void a(int i) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null) {
            return;
        }
        ((NotificationManager) a2.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i);
    }

    @Override // com.ksad.download.f
    public final void a(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File a2 = ((com.kwad.sdk.service.kwai.a) ServiceProvider.a(com.kwad.sdk.service.kwai.a.class)).a(str);
            if (a2 == null || !a2.exists()) {
                ((com.kwad.sdk.service.kwai.a) ServiceProvider.a(com.kwad.sdk.service.kwai.a.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.ksad.download.f
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.a.c a2;
        Context a3 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a3 == null || downloadTask.isNotificationRemoved() || (a2 = com.kwad.sdk.core.download.a.c.a(a3, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(a3, a2, b.b(downloadTask, "正在下载", (String) null));
        a(a3, a2.a(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public final void a(File file) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        DownloadParams a3 = com.kwad.sdk.core.a.a().a(file.getAbsolutePath());
        com.kwad.sdk.core.a.a().b(file.getAbsolutePath());
        if (a2 == null || a3 == null) {
            return;
        }
        AdTemplate c2 = com.kwad.sdk.core.a.a().c(a3.mDownloadid);
        if (c2 != null) {
            c2.installFrom = "recall";
            e.a().a(c2);
        }
        b b2 = b.b(a3, "下载完成", "立即安装");
        com.kwad.sdk.core.download.a.b a4 = com.kwad.sdk.core.download.a.b.a(a2);
        a(a2, a4, b2);
        a(a2, a4.a(), false, false, g.a(file, a3.mTaskId, a3.requestInstallPermission), a3.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.f
    public final void a(String str) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        DownloadParams a3 = com.kwad.sdk.core.a.a().a(str);
        com.kwad.sdk.core.a.a().b(str);
        if (a2 == null || a3 == null) {
            return;
        }
        com.kwad.sdk.core.a.a().b(a3.filePath);
        b b2 = b.b(a3, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.a.b a4 = com.kwad.sdk.core.download.a.b.a(a2);
        a(a2, a4, b2);
        a(a2, a4.a(), false, false, g.a(a3.mPkgname, a3.mTaskId), a3.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.f
    public final void b(DownloadTask downloadTask) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b b2 = b.b(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.a.c a3 = com.kwad.sdk.core.download.a.c.a(a2, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a3 == null) {
            return;
        }
        a(a2, a3, b2);
        a(a2, a3.a(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public final void c(DownloadTask downloadTask) {
        Context a2 = ((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a();
        if (a2 == null) {
            return;
        }
        DownloadParams d = d(downloadTask);
        com.kwad.sdk.core.download.a.b a3 = com.kwad.sdk.core.download.a.b.a(a2);
        a(a2, a3, b.b(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.a().a(downloadTask.getTargetFilePath(), d);
        com.kwad.sdk.core.a.a().a(d.mPkgname, d);
        a(a2, a3.a(), false, false, g.a(downloadTask), downloadTask.getId(), 1, 1);
    }
}
