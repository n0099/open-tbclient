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
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes10.dex */
public final class a implements d {
    public static c asv;
    public static HashMap<String, WeakReference<Bitmap>> asu = new HashMap<>();
    public static final Handler asw = new HandlerC0706a();

    /* renamed from: com.kwad.sdk.core.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0706a extends Handler {
        public final SparseArray<Long> asx;

        public HandlerC0706a() {
            super(Looper.getMainLooper());
            this.asx = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (message.arg1 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (message.arg2 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (message.arg2 == 2) {
                z3 = true;
            }
            Long l = this.asx.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.xA().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.xA().bL(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            } else {
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.asx.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static String asy = "ksad_notification_default_icon";
        public String aaj;
        public String asA;
        public String asC;
        public String asz;
        public String name;
        public int progress;
        public File asB = null;
        public boolean asD = false;

        public static String Ca() {
            return asy;
        }

        public final String Cb() {
            return this.asz;
        }

        public final String Cc() {
            return this.asA;
        }

        public final String Cd() {
            return this.aaj;
        }

        public final File Ce() {
            return this.asB;
        }

        public final String Cf() {
            return "正在下载 " + this.progress + "%";
        }

        public final String Cg() {
            return this.asC;
        }

        public final String getName() {
            String str = this.name;
            if (str == null) {
                return "";
            }
            return str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.asD;
        }

        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File bO = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bO(downloadParams.mAppIcon);
                if (bO != null && bO.exists()) {
                    bVar.asB = bO;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.asD = downloadTask.isPaused();
            bVar.aaj = str;
            bVar.asC = str2;
            bVar.asz = a.Z(downloadTask.getSmallFileSoFarBytes()) + " / " + a.Z(downloadTask.getSmallFileTotalBytes());
            bVar.asA = a.Z((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public static b a(DownloadParams downloadParams, String str, String str2) {
            File bO;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (bO = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bO(downloadParams.mAppIcon)) != null && bO.exists()) {
                bVar.asB = bO;
            }
            bVar.aaj = str;
            bVar.asA = a.Z(downloadParams.mAppSize);
            bVar.asC = str2;
            return bVar;
        }
    }

    public static void BZ() {
        if (asv != null) {
            return;
        }
        asv = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN);
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        ServiceProvider.Jn().registerReceiver(asv, intentFilter);
    }

    /* loaded from: classes10.dex */
    public static class c extends BroadcastReceiver {
        public static void d(@NonNull Intent intent) {
            DownloadTask f = f(intent);
            if (f == null) {
                return;
            }
            com.kwad.sdk.c.xA().bN(f.getId());
        }

        public static void e(@NonNull Intent intent) {
            DownloadTask f = f(intent);
            if (f == null) {
                return;
            }
            f.setNotificationRemoved(true);
        }

        @Nullable
        public static DownloadTask f(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return com.kwad.sdk.c.xA().bL(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getExtras() != null) {
                String action = intent.getAction();
                if (RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN.equals(action)) {
                    d(intent);
                } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                    e(intent);
                }
            }
        }
    }

    public static Bitmap E(Context context, String str) {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = asu.get(str);
        if (weakReference != null) {
            bitmap = weakReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(as.cu(context), as.at(context, str));
            asu.put(str, new WeakReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    public static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String Z(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    public static int aX(Context context) {
        int i;
        try {
            i = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i = 0;
        }
        if (i <= 0) {
            return as.at(context, "ksad_notification_small_icon");
        }
        return i;
    }

    public static DownloadParams m(DownloadTask downloadTask) {
        DownloadParams downloadParams;
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
        } else {
            downloadParams = new DownloadParams();
        }
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    public static Bitmap q(File file) {
        Bitmap bitmap;
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = asu.get(absolutePath);
        if (weakReference != null) {
            bitmap = weakReference.get();
        } else {
            bitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
            asu.put(absolutePath, new WeakReference<>(decodeFile));
            return decodeFile;
        }
        return bitmap;
    }

    @Override // com.kwad.sdk.d
    public final void bO(int i) {
        Context Jn = ServiceProvider.Jn();
        if (Jn == null) {
            return;
        }
        ((NotificationManager) Jn.getSystemService("notification")).cancel(i);
    }

    public static void a(int i, Notification notification) {
        BZ();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.Jn().getSystemService("notification");
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
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(aX(context));
        a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i);
            builder.setDeleteIntent(al.a(context, i, intent));
        }
        asw.removeMessages(i);
        asw.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        boolean z;
        bVar.setName(bVar2.getName());
        File Ce = bVar2.Ce();
        if (Ce != null && Ce.exists()) {
            z = a(bVar, Ce);
        } else {
            z = false;
        }
        if (!z) {
            a(context, bVar, b.Ca());
        }
        bVar.setStatus(bVar2.Cd());
        bVar.setSize(bVar2.Cc());
        bVar.setInstallText(bVar2.Cg());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        boolean z;
        cVar.setName(bVar.getName());
        File Ce = bVar.Ce();
        if (Ce != null && Ce.exists()) {
            z = a(cVar, Ce);
        } else {
            z = false;
        }
        if (!z) {
            a(context, cVar, b.Ca());
        }
        cVar.setStatus(bVar.Cd());
        cVar.setSize(bVar.Cb());
        cVar.setPercentNum(bVar.Cf());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(E(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(E(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.service.c.gatherException(e);
            return false;
        }
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.b.c a;
        Context Jn = ServiceProvider.Jn();
        if (Jn == null || downloadTask.isNotificationRemoved() || (a = com.kwad.sdk.core.download.b.c.a(Jn, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(Jn, a, b.a(downloadTask, "正在下载", (String) null));
        a(Jn, a.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void bM(String str) {
        Context Jn = ServiceProvider.Jn();
        DownloadParams cF = com.kwad.sdk.core.a.Ai().cF(str);
        com.kwad.sdk.core.a.Ai().cG(str);
        if (Jn != null && cF != null) {
            com.kwad.sdk.core.a.Ai().cG(cF.filePath);
            b a = b.a(cF, "安装完成", "立刻打开");
            com.kwad.sdk.core.download.b.b aY = com.kwad.sdk.core.download.b.b.aY(Jn);
            if (aY == null) {
                return;
            }
            a(Jn, aY, a);
            a(Jn, aY.build(), false, false, al.d(Jn, cF.mPkgname, cF.mTaskId), cF.mTaskId, 1, 2);
        }
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context Jn = ServiceProvider.Jn();
        if (Jn == null) {
            return;
        }
        DownloadParams cF = com.kwad.sdk.core.a.Ai().cF(file.getAbsolutePath());
        com.kwad.sdk.core.a.Ai().cG(file.getAbsolutePath());
        if (cF == null) {
            return;
        }
        AdTemplate cH = com.kwad.sdk.core.a.Ai().cH(cF.mDownloadid);
        if (cH != null) {
            cH.installFrom = "recall";
        }
        b a = b.a(cF, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b aY = com.kwad.sdk.core.download.b.b.aY(Jn);
        if (aY == null) {
            return;
        }
        a(Jn, aY, a);
        a(Jn, aY.build(), false, false, al.a(Jn, file, cF.mTaskId, cF.requestInstallPermission), cF.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        boolean z;
        String str;
        Context Jn = ServiceProvider.Jn();
        if (Jn == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        if (downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            str = "正在下载";
        } else {
            str = "准备下载";
        }
        b a = b.a(downloadTask, str, (String) null);
        com.kwad.sdk.core.download.b.c a2 = com.kwad.sdk.core.download.b.c.a(Jn, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a2 == null) {
            return;
        }
        a(Jn, a2, a);
        a(Jn, a2.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams m;
        com.kwad.sdk.core.download.b.b aY;
        Context Jn = ServiceProvider.Jn();
        if (Jn == null || (m = m(downloadTask)) == null || (aY = com.kwad.sdk.core.download.b.b.aY(Jn)) == null) {
            return;
        }
        a(Jn, aY, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.Ai().a(downloadTask.getTargetFilePath(), m);
        com.kwad.sdk.core.a.Ai().a(m.mPkgname, m);
        a(Jn, aY.build(), false, false, al.a(Jn, new File(downloadTask.getTargetFilePath()), m.mTaskId, m.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (!TextUtils.isEmpty(str)) {
                File bO = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).bO(str);
                if (bO == null || !bO.exists()) {
                    ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
                }
            }
        }
    }
}
