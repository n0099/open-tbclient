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
import com.kwad.sdk.utils.ao;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class a implements f {
    public static c Xd;
    public static HashMap<String, WeakReference<Bitmap>> Xc = new HashMap<>();
    public static final Handler Xe = new HandlerC0629a();

    /* renamed from: com.kwad.sdk.core.download.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class HandlerC0629a extends Handler {
        public final SparseArray<Long> Xf;

        public HandlerC0629a() {
            super(Looper.getMainLooper());
            this.Xf = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            boolean z2 = message.arg2 == 1;
            boolean z3 = message.arg2 == 2;
            Long l = this.Xf.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.ksad.download.b.getContext().getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (notificationManager == null) {
                return;
            }
            if (d.N().s(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else if (!z && l != null && System.currentTimeMillis() - l.longValue() < 110) {
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            } else {
                if (z2) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.Xf.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static String Xg = "ksad_notification_default_icon";
        public String NY;
        public String Xh;
        public String Xi;
        public String Xk;
        public String name;
        public int progress;
        public File Xj = null;
        public boolean Xl = false;

        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File ad = ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).ad(downloadParams.mAppIcon);
                if (ad != null && ad.exists()) {
                    bVar.Xj = ad;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.Xl = downloadTask.isPaused();
            bVar.NY = str;
            bVar.Xk = str2;
            bVar.Xh = a.x(downloadTask.getSmallFileSoFarBytes()) + " / " + a.x(downloadTask.getSmallFileTotalBytes());
            bVar.Xi = a.x((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        public static b a(DownloadParams downloadParams, String str, String str2) {
            File ad;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (ad = ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).ad(downloadParams.mAppIcon)) != null && ad.exists()) {
                bVar.Xj = ad;
            }
            bVar.NY = str;
            bVar.Xi = a.x(downloadParams.mAppSize);
            bVar.Xk = str2;
            return bVar;
        }

        public static String sY() {
            return Xg;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.Xl;
        }

        public final String sZ() {
            return this.Xh;
        }

        public final String ta() {
            return this.Xi;
        }

        public final String tb() {
            return this.NY;
        }

        public final File tc() {
            return this.Xj;
        }

        public final String td() {
            return "正在下载 " + this.progress + "%";
        }

        public final String te() {
            return this.Xk;
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends BroadcastReceiver {
        public static void g(@NonNull Intent intent) {
            DownloadTask i = i(intent);
            if (i == null) {
                return;
            }
            d.N().u(i.getId());
        }

        public static void h(@NonNull Intent intent) {
            DownloadTask i = i(intent);
            if (i == null) {
                return;
            }
            i.setNotificationRemoved(true);
        }

        @Nullable
        public static DownloadTask i(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return d.N().s(i);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if (RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN.equals(action)) {
                g(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                h(intent);
            }
        }
    }

    public a(Context context) {
        bq(context);
    }

    public static void a(int i, Notification notification) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
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
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    public static void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ao.ab(context, "ksad_notification_small_icon"));
        if (z2) {
            builder.setDeleteIntent(b(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i));
        }
        Xe.removeMessages(i);
        Xe.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private void a(Context context, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File tc = bVar2.tc();
        if (!((tc == null || !tc.exists()) ? false : a(bVar, tc))) {
            a(context, bVar, b.sY());
        }
        bVar.setStatus(bVar2.tb());
        bVar.setSize(bVar2.ta());
        bVar.setInstallText(bVar2.te());
    }

    private void a(Context context, com.kwad.sdk.core.download.a.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File tc = bVar.tc();
        if (!((tc == null || !tc.exists()) ? false : a(cVar, tc))) {
            a(context, cVar, b.sY());
        }
        cVar.setStatus(bVar.tb());
        cVar.setSize(bVar.sZ());
        cVar.setPercentNum(bVar.td());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.b bVar, String str) {
        try {
            bVar.setIcon(t(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.service.a.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.c cVar, String str) {
        try {
            cVar.setIcon(t(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.service.a.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.b bVar, File file) {
        try {
            bVar.setIcon(n(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.service.a.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.c cVar, File file) {
        try {
            cVar.setIcon(n(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            com.kwad.sdk.service.a.gatherException(e);
            return false;
        }
    }

    public static PendingIntent b(Context context, String str, int i) {
        Intent intent = new Intent(str);
        intent.putExtra("taskId", i);
        return PendingIntent.getBroadcast(context, i, intent, 0);
    }

    public static void bq(Context context) {
        if (Xd != null || context == null) {
            return;
        }
        Xd = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN);
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        context.registerReceiver(Xd, intentFilter);
    }

    public static DownloadParams m(DownloadTask downloadTask) {
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

    public static Bitmap n(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = Xc.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
            Xc.put(absolutePath, new WeakReference<>(decodeFile));
            return decodeFile;
        }
        return bitmap;
    }

    public static Bitmap t(Context context, String str) {
        WeakReference<Bitmap> weakReference = Xc.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null || bitmap.isRecycled()) {
            Bitmap decodeResource = BitmapFactory.decodeResource(ao.cH(context), ao.ab(context, str));
            Xc.put(str, new WeakReference<>(decodeResource));
            return decodeResource;
        }
        return bitmap;
    }

    @SuppressLint({"DefaultLocale"})
    public static String x(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    @Override // com.ksad.download.f
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.a.c a;
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null || downloadTask.isNotificationRemoved() || (a = com.kwad.sdk.core.download.a.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(context, a, b.a(downloadTask, "正在下载", (String) null));
        a(context, a.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public final void c(File file) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        DownloadParams bm = com.kwad.sdk.core.a.rD().bm(file.getAbsolutePath());
        com.kwad.sdk.core.a.rD().bn(file.getAbsolutePath());
        if (context == null || bm == null) {
            return;
        }
        AdTemplate bo = com.kwad.sdk.core.a.rD().bo(bm.mDownloadid);
        if (bo != null) {
            bo.installFrom = "recall";
            e.sV().am(bo);
        }
        b a = b.a(bm, "下载完成", "立即安装");
        com.kwad.sdk.core.download.a.b br = com.kwad.sdk.core.download.a.b.br(context);
        a(context, br, a);
        a(context, br.build(), false, false, g.a(file, bm.mTaskId, bm.requestInstallPermission), bm.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.f
    public final void h(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File ad = ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).ad(str);
            if (ad == null || !ad.exists()) {
                ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.ksad.download.f
    public final void i(DownloadTask downloadTask) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b a = b.a(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.a.c a2 = com.kwad.sdk.core.download.a.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (a2 == null) {
            return;
        }
        a(context, a2, a);
        a(context, a2.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public final void j(DownloadTask downloadTask) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        DownloadParams m = m(downloadTask);
        com.kwad.sdk.core.download.a.b br = com.kwad.sdk.core.download.a.b.br(context);
        a(context, br, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.rD().a(downloadTask.getTargetFilePath(), m);
        com.kwad.sdk.core.a.rD().a(m.mPkgname, m);
        a(context, br.build(), false, false, g.k(downloadTask), downloadTask.getId(), 1, 1);
    }

    @Override // com.ksad.download.f
    public final void o(String str) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        DownloadParams bm = com.kwad.sdk.core.a.rD().bm(str);
        com.kwad.sdk.core.a.rD().bn(str);
        if (context == null || bm == null) {
            return;
        }
        com.kwad.sdk.core.a.rD().bn(bm.filePath);
        b a = b.a(bm, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.a.b br = com.kwad.sdk.core.download.a.b.br(context);
        a(context, br, a);
        a(context, br.build(), false, false, g.e(bm.mPkgname, bm.mTaskId), bm.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.f
    public final void v(int i) {
        Context context = ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i);
    }
}
