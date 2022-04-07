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
/* loaded from: classes5.dex */
public class a implements f {
    public static c b;
    public static HashMap<String, WeakReference<Bitmap>> a = new HashMap<>();
    public static final Handler c = new HandlerC0297a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class HandlerC0297a extends Handler {
        public final SparseArray<Long> a;

        public HandlerC0297a() {
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
                File b = com.kwad.sdk.core.diskcache.a.a.a().b(downloadParams.mAppIcon);
                if (b != null && b.exists()) {
                    bVar.g = b;
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
            File b;
            b bVar = new b();
            bVar.b = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (b = com.kwad.sdk.core.diskcache.a.a.a().b(downloadParams.mAppIcon)) != null && b.exists()) {
                bVar.g = b;
            }
            bVar.c = str;
            bVar.e = a.b(downloadParams.mAppSize);
            bVar.h = str2;
            return bVar;
        }

        public String b() {
            String str = this.b;
            return str == null ? "" : str;
        }

        public String c() {
            return this.d;
        }

        public String d() {
            return this.e;
        }

        public String e() {
            return this.c;
        }

        public File f() {
            return this.g;
        }

        public String g() {
            return "正在下载 " + this.f + "%";
        }

        public int h() {
            return this.f;
        }

        public String i() {
            return this.h;
        }

        public boolean j() {
            return this.i;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends BroadcastReceiver {
        private void a(@NonNull Intent intent) {
            DownloadTask c = c(intent);
            if (c == null) {
                return;
            }
            d.a().f(c.getId());
        }

        private void b(@NonNull Intent intent) {
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

    public static PendingIntent a(Context context, String str, int i) {
        Intent intent = new Intent(str);
        intent.putExtra("taskId", i);
        return PendingIntent.getBroadcast(context, i, intent, 0);
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
        if (b != null || context == null) {
            return;
        }
        b = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN);
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        context.registerReceiver(b, intentFilter);
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(z).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(am.a(context, "ksad_notification_small_icon"));
        if (z2) {
            builder.setDeleteIntent(a(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i));
        }
        c.removeMessages(i);
        c.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.a(a(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.kwai.a.a(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.a(a(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.kwai.a.a(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.a(b(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.kwai.a.a(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.a(b(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.kwai.a.a(e);
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
    public static String b(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    public static void b(int i, Notification notification) {
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
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
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
    public void a(int i) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i);
    }

    public void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.a(bVar2.b());
        File f = bVar2.f();
        if (!((f == null || !f.exists()) ? false : a(bVar, f))) {
            a(context, bVar, b.a());
        }
        bVar.b(bVar2.e());
        bVar.c(bVar2.d());
        bVar.d(bVar2.i());
    }

    public void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
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
        DownloadParams d = d(downloadTask);
        com.kwad.sdk.core.download.b.b a2 = com.kwad.sdk.core.download.b.b.a(context);
        a(context, a2, b.b(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.a().a(downloadTask.getTargetFilePath(), d);
        com.kwad.sdk.core.a.a().a(d.mPkgname, d);
        a(context, a2.a(), false, false, g.a(downloadTask), downloadTask.getId(), 1, 1);
    }
}
