package com.kwad.sdk.core.download.c;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.android.util.io.ActionJsonData;
import com.ksad.download.DownloadTask;
import com.ksad.download.b;
import com.ksad.download.d;
import com.ksad.download.f;
import com.ksad.download.g;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import java.io.File;
/* loaded from: classes4.dex */
public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f9117a = new HandlerC1089a();

    /* renamed from: com.kwad.sdk.core.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class HandlerC1089a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Long> f9118a;

        HandlerC1089a() {
            super(Looper.getMainLooper());
            this.f9118a = new SparseArray<>();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            boolean z2 = message.arg2 == 1;
            boolean z3 = message.arg2 == 2;
            Long l = this.f9118a.get(message.what);
            NotificationManager notificationManager = (NotificationManager) b.a().getSystemService(ActionJsonData.TAG_NOTIFICATION);
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
                this.f9118a.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String a(long j) {
        return String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f));
    }

    private boolean a(Context context, ICompletedRemoteView iCompletedRemoteView, String str) {
        try {
            iCompletedRemoteView.setIcon(ab.a(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.a.a.a(e);
            return false;
        }
    }

    private boolean a(Context context, IProgressRemoteView iProgressRemoteView, String str) {
        try {
            iProgressRemoteView.setIcon(ab.a(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.a.a.a(e);
            return false;
        }
    }

    private boolean a(ICompletedRemoteView iCompletedRemoteView, File file) {
        try {
            iCompletedRemoteView.setIcon(BitmapFactory.decodeFile(file.getAbsolutePath()));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.a.a.a(e);
            return false;
        }
    }

    private boolean a(IProgressRemoteView iProgressRemoteView, File file) {
        try {
            iProgressRemoteView.setIcon(BitmapFactory.decodeFile(file.getAbsolutePath()));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            com.kwad.sdk.core.a.a.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // com.ksad.download.f
    public void a(int i) {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i);
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(str);
            if (b2 == null || !b2.exists()) {
                com.kwad.sdk.core.diskcache.b.a.a().a(str);
            }
        }
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask, boolean z) {
        boolean a2;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        IProgressRemoteView createProgressView = RemoteViewBuilder.createProgressView(context);
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) tag;
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(downloadParams.mAppIcon);
            a2 = (b2 == null || !b2.exists()) ? a(context, createProgressView, "ksad_notification_default_icon") : a(createProgressView, b2);
            createProgressView.setName(downloadParams.mAppName);
        } else {
            a2 = a(context, createProgressView, "ksad_notification_default_icon");
        }
        if (!a2) {
            com.kwad.sdk.core.d.a.d("AdDownloadNotificationPerformer", "set icon failed ");
            return;
        }
        createProgressView.setStatus("正在下载");
        createProgressView.setSize(a(downloadTask.getSmallFileSoFarBytes()) + " / " + a(downloadTask.getSmallFileTotalBytes()));
        int smallFileSoFarBytes = (int) ((100.0f * downloadTask.getSmallFileSoFarBytes()) / downloadTask.getSmallFileTotalBytes());
        createProgressView.setPercentNum("下载进度：  " + smallFileSoFarBytes + "%");
        createProgressView.setProgress(100, smallFileSoFarBytes, false);
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(createProgressView.build()).setWhen(System.currentTimeMillis()).setOngoing(true).setOnlyAlertOnce(true).setPriority(-1).setSmallIcon(ab.a(context, "ksad_notification_small_icon"));
        f9117a.removeMessages(downloadTask.getId());
        f9117a.obtainMessage(downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0, builder.build()).sendToTarget();
    }

    @Override // com.ksad.download.f
    public void a(File file) {
        boolean a2;
        Context context = KsAdSDKImpl.get().getContext();
        DownloadParams a3 = com.kwad.sdk.core.a.a().a(file.getAbsolutePath());
        com.kwad.sdk.core.a.a().b(file.getAbsolutePath());
        if (context == null || a3 == null) {
            return;
        }
        AdTemplate c = com.kwad.sdk.core.a.a().c(a3.mDownloadid);
        if (c != null) {
            c.installFrom = "recall";
            DownloadStatusManager.a().a(c);
        }
        ICompletedRemoteView createCompletedView = RemoteViewBuilder.createCompletedView(context);
        if (TextUtils.isEmpty(a3.mAppIcon)) {
            a2 = a(context, createCompletedView, "ksad_notification_default_icon");
        } else {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a3.mAppIcon);
            a2 = (b2 == null || !b2.exists()) ? a(context, createCompletedView, "ksad_notification_default_icon") : a(createCompletedView, b2);
            createCompletedView.setName(a3.mAppName);
        }
        if (!a2) {
            com.kwad.sdk.core.d.a.d("AdDownloadNotificationPerformer", "set icon failed ");
            return;
        }
        createCompletedView.setStatus("下载完成");
        createCompletedView.setSize(a(a3.mAppSize));
        createCompletedView.setInstallText("立即安装");
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(createCompletedView.build()).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(g.a(file, a3.mTaskId)).setSmallIcon(ab.a(context, "ksad_notification_small_icon"));
        f9117a.removeMessages(a3.mTaskId);
        f9117a.obtainMessage(a3.mTaskId, 1, 2, builder.build()).sendToTarget();
    }

    @Override // com.ksad.download.f
    public void a(String str) {
        boolean a2;
        Context context = KsAdSDKImpl.get().getContext();
        DownloadParams a3 = com.kwad.sdk.core.a.a().a(str);
        com.kwad.sdk.core.a.a().b(str);
        if (context == null || a3 == null) {
            return;
        }
        com.kwad.sdk.core.a.a().b(a3.filePath);
        ICompletedRemoteView createCompletedView = RemoteViewBuilder.createCompletedView(context);
        if (TextUtils.isEmpty(a3.mAppIcon)) {
            a2 = a(context, createCompletedView, "ksad_notification_default_icon");
        } else {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(a3.mAppIcon);
            a2 = (b2 == null || !b2.exists()) ? a(context, createCompletedView, "ksad_notification_default_icon") : a(createCompletedView, b2);
            createCompletedView.setName(a3.mAppName);
        }
        if (!a2) {
            com.kwad.sdk.core.d.a.d("AdDownloadNotificationPerformer", "set icon failed ");
            return;
        }
        createCompletedView.setStatus("安装完成");
        createCompletedView.setSize(a(a3.mAppSize));
        createCompletedView.setInstallText("立刻打开");
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(createCompletedView.build()).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(true).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(g.a(a3.mPkgname, a3.mTaskId)).setSmallIcon(ab.a(context, "ksad_notification_small_icon"));
        f9117a.removeMessages(a3.mTaskId);
        f9117a.obtainMessage(a3.mTaskId, 1, 2, builder.build()).sendToTarget();
    }

    @Override // com.ksad.download.f
    public void b(DownloadTask downloadTask) {
        boolean a2;
        DownloadParams downloadParams;
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        ICompletedRemoteView createCompletedView = RemoteViewBuilder.createCompletedView(context);
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(downloadParams.mAppIcon);
            a2 = (b2 == null || !b2.exists()) ? a(context, createCompletedView, "ksad_notification_default_icon") : a(createCompletedView, b2);
            createCompletedView.setName(downloadParams.mAppName);
        } else {
            a2 = a(context, createCompletedView, "ksad_notification_default_icon");
            downloadParams = new DownloadParams();
        }
        if (!a2) {
            com.kwad.sdk.core.d.a.d("AdDownloadNotificationPerformer", "set icon failed ");
            return;
        }
        createCompletedView.setStatus("下载完成");
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        com.kwad.sdk.core.a.a().a(downloadTask.getTargetFilePath(), downloadParams);
        com.kwad.sdk.core.a.a().a(downloadParams.mPkgname, downloadParams);
        createCompletedView.setSize(a(downloadTask.getSmallFileTotalBytes()));
        createCompletedView.setInstallText("立即安装");
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(createCompletedView.build()).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(g.a(downloadTask)).setSmallIcon(ab.a(context, "ksad_notification_small_icon"));
        f9117a.removeMessages(downloadTask.getId());
        f9117a.obtainMessage(downloadTask.getId(), 1, 1, builder.build()).sendToTarget();
    }
}
