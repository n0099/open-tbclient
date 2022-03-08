package com.kwad.sdk.core.download.b;

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
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.am;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a implements f {

    /* renamed from: b  reason: collision with root package name */
    public static c f54330b;
    public static HashMap<String, WeakReference<Bitmap>> a = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f54331c = new HandlerC2096a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC2096a extends Handler {
        public final SparseArray<Long> a;

        public HandlerC2096a() {
            super(Looper.getMainLooper());
            this.a = new SparseArray<>();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
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

    /* loaded from: classes7.dex */
    public static class b {
        public static String a = "ksad_notification_default_icon";

        /* renamed from: b  reason: collision with root package name */
        public String f54332b;

        /* renamed from: c  reason: collision with root package name */
        public String f54333c;

        /* renamed from: d  reason: collision with root package name */
        public String f54334d;

        /* renamed from: e  reason: collision with root package name */
        public String f54335e;

        /* renamed from: f  reason: collision with root package name */
        public int f54336f;

        /* renamed from: h  reason: collision with root package name */
        public String f54338h;

        /* renamed from: g  reason: collision with root package name */
        public File f54337g = null;

        /* renamed from: i  reason: collision with root package name */
        public boolean f54339i = false;

        public static String a() {
            return a;
        }

        public static b b(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(downloadParams.mAppIcon);
                if (b2 != null && b2.exists()) {
                    bVar.f54337g = b2;
                }
                bVar.f54332b = downloadParams.mAppName;
            }
            bVar.f54339i = downloadTask.isPaused();
            bVar.f54333c = str;
            bVar.f54338h = str2;
            bVar.f54334d = a.b(downloadTask.getSmallFileSoFarBytes()) + " / " + a.b(downloadTask.getSmallFileTotalBytes());
            bVar.f54335e = a.b((long) downloadTask.getSmallFileTotalBytes());
            bVar.f54336f = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public static b b(DownloadParams downloadParams, String str, String str2) {
            File b2;
            b bVar = new b();
            bVar.f54332b = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (b2 = com.kwad.sdk.core.diskcache.a.a.a().b(downloadParams.mAppIcon)) != null && b2.exists()) {
                bVar.f54337g = b2;
            }
            bVar.f54333c = str;
            bVar.f54335e = a.b(downloadParams.mAppSize);
            bVar.f54338h = str2;
            return bVar;
        }

        public String b() {
            String str = this.f54332b;
            return str == null ? "" : str;
        }

        public String c() {
            return this.f54334d;
        }

        public String d() {
            return this.f54335e;
        }

        public String e() {
            return this.f54333c;
        }

        public File f() {
            return this.f54337g;
        }

        public String g() {
            return "正在下载 " + this.f54336f + "%";
        }

        public int h() {
            return this.f54336f;
        }

        public String i() {
            return this.f54338h;
        }

        public boolean j() {
            return this.f54339i;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends BroadcastReceiver {
        private void a(@NonNull Intent intent) {
            DownloadTask c2 = c(intent);
            if (c2 == null) {
                return;
            }
            d.a().f(c2.getId());
        }

        private void b(@NonNull Intent intent) {
            DownloadTask c2 = c(intent);
            if (c2 == null) {
                return;
            }
            c2.setNotificationRemoved(true);
        }

        @Nullable
        public static DownloadTask c(Intent intent) {
            int i2 = intent.getExtras().getInt(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, 0);
            if (i2 == 0) {
                return null;
            }
            return d.a().a(i2);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
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

    public static PendingIntent a(Context context, String str, int i2) {
        Intent intent = new Intent(str);
        intent.putExtra(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, i2);
        return PendingIntent.getBroadcast(context, i2, intent, 0);
    }

    private Bitmap a(Context context, String str) {
        WeakReference<Bitmap> weakReference = a.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(am.a(context), am.a(context, str));
            a.put(str, new WeakReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    private void a(Context context) {
        if (f54330b != null || context == null) {
            return;
        }
        f54330b = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN);
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        context.registerReceiver(f54330b, intentFilter);
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i2, int i3, int i4) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(z).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(am.a(context, "ksad_notification_small_icon"));
        if (z2) {
            builder.setDeleteIntent(a(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i2));
        }
        f54331c.removeMessages(i2);
        f54331c.obtainMessage(i2, i3, i4, builder.build()).sendToTarget();
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.a(a(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.kwai.a.a(e2);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.a(a(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.kwai.a.a(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.a(b(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.kwai.a.a(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.a(b(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
            com.kwad.sdk.core.kwai.a.a(e2);
            return false;
        }
    }

    private Bitmap b(File file) {
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
    public static String b(long j2) {
        return String.format("%.2fMB", Float.valueOf((((float) j2) / 1000.0f) / 1000.0f));
    }

    public static void b(int i2, Notification notification) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i2, notification);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    private DownloadParams d(DownloadTask downloadTask) {
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
    public void a(int i2) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i2);
    }

    public void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.a(bVar2.b());
        File f2 = bVar2.f();
        if (!((f2 == null || !f2.exists()) ? false : a(bVar, f2))) {
            a(context, bVar, b.a());
        }
        bVar.b(bVar2.e());
        bVar.c(bVar2.d());
        bVar.d(bVar2.i());
    }

    public void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.a(bVar.b());
        File f2 = bVar.f();
        if (!((f2 == null || !f2.exists()) ? false : a(cVar, f2))) {
            a(context, cVar, b.a());
        }
        cVar.b(bVar.e());
        cVar.c(bVar.c());
        cVar.d(bVar.g());
        cVar.a(100, bVar.h(), false);
        cVar.a(bVar.j());
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File b2 = com.kwad.sdk.core.diskcache.a.a.a().b(str);
            if (b2 == null || !b2.exists()) {
                com.kwad.sdk.core.diskcache.a.a.a().a(str);
            }
        }
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask, boolean z) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        com.kwad.sdk.core.download.b.c a2 = com.kwad.sdk.core.download.b.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        a(context, a2, b.b(downloadTask, "正在下载", (String) null));
        a(context, a2.a(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public void a(File file) {
        Context context = KsAdSDKImpl.get().getContext();
        DownloadParams a2 = com.kwad.sdk.core.a.a().a(file.getAbsolutePath());
        com.kwad.sdk.core.a.a().b(file.getAbsolutePath());
        if (context == null || a2 == null) {
            return;
        }
        AdTemplate c2 = com.kwad.sdk.core.a.a().c(a2.mDownloadid);
        if (c2 != null) {
            c2.installFrom = "recall";
            DownloadStatusManager.a().a(c2);
        }
        b b2 = b.b(a2, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b a3 = com.kwad.sdk.core.download.b.b.a(context);
        a(context, a3, b2);
        a(context, a3.a(), false, false, g.a(file, a2.mTaskId, a2.requestInstallPermission), a2.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.f
    public void a(String str) {
        Context context = KsAdSDKImpl.get().getContext();
        DownloadParams a2 = com.kwad.sdk.core.a.a().a(str);
        com.kwad.sdk.core.a.a().b(str);
        if (context == null || a2 == null) {
            return;
        }
        com.kwad.sdk.core.a.a().b(a2.filePath);
        b b2 = b.b(a2, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b a3 = com.kwad.sdk.core.download.b.b.a(context);
        a(context, a3, b2);
        a(context, a3.a(), false, false, g.a(a2.mPkgname, a2.mTaskId), a2.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.f
    public void b(DownloadTask downloadTask) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b b2 = b.b(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.b.c a2 = com.kwad.sdk.core.download.b.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        a(context, a2, b2);
        a(context, a2.a(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public void c(DownloadTask downloadTask) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        DownloadParams d2 = d(downloadTask);
        com.kwad.sdk.core.download.b.b a2 = com.kwad.sdk.core.download.b.b.a(context);
        a(context, a2, b.b(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.a().a(downloadTask.getTargetFilePath(), d2);
        com.kwad.sdk.core.a.a().a(d2.mPkgname, d2);
        a(context, a2.a(), false, false, g.a(downloadTask), downloadTask.getId(), 1, 1);
    }
}
