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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class a implements f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f36071a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0427a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<Long> f36072a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0427a() {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36072a = new SparseArray<>();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                boolean z = message.arg1 == 1;
                boolean z2 = message.arg2 == 1;
                boolean z3 = message.arg2 == 2;
                Long l = this.f36072a.get(message.what);
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
                    this.f36072a.put(message.what, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-607171080, "Lcom/kwad/sdk/core/download/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-607171080, "Lcom/kwad/sdk/core/download/c/a;");
                return;
            }
        }
        f36071a = new HandlerC0427a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    public static String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? String.format("%.2fMB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f)) : (String) invokeJ.objValue;
    }

    private boolean a(Context context, ICompletedRemoteView iCompletedRemoteView, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, this, context, iCompletedRemoteView, str)) == null) {
            try {
                iCompletedRemoteView.setIcon(ab.a(context, str));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(Context context, IProgressRemoteView iProgressRemoteView, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, this, context, iProgressRemoteView, str)) == null) {
            try {
                iProgressRemoteView.setIcon(ab.a(context, str));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(ICompletedRemoteView iCompletedRemoteView, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, iCompletedRemoteView, file)) == null) {
            try {
                iCompletedRemoteView.setIcon(BitmapFactory.decodeFile(file.getAbsolutePath()));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(IProgressRemoteView iProgressRemoteView, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, iProgressRemoteView, file)) == null) {
            try {
                iProgressRemoteView.setIcon(BitmapFactory.decodeFile(file.getAbsolutePath()));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void b(int i2, Notification notification) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65544, null, i2, notification) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
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

    @Override // com.ksad.download.f
    public void a(int i2) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(i2);
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadTask) == null) {
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
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask, boolean z) {
        Context context;
        boolean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, downloadTask, z) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
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
        int smallFileSoFarBytes = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
        createProgressView.setPercentNum("下载进度：  " + smallFileSoFarBytes + "%");
        createProgressView.setProgress(100, smallFileSoFarBytes, false);
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(createProgressView.build()).setWhen(System.currentTimeMillis()).setOngoing(true).setOnlyAlertOnce(true).setPriority(-1).setSmallIcon(ab.a(context, "ksad_notification_small_icon"));
        f36071a.removeMessages(downloadTask.getId());
        f36071a.obtainMessage(downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0, builder.build()).sendToTarget();
    }

    @Override // com.ksad.download.f
    public void a(File file) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, file) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            DownloadParams a3 = com.kwad.sdk.core.a.a().a(file.getAbsolutePath());
            com.kwad.sdk.core.a.a().b(file.getAbsolutePath());
            if (context == null || a3 == null) {
                return;
            }
            AdTemplate c2 = com.kwad.sdk.core.a.a().c(a3.mDownloadid);
            if (c2 != null) {
                c2.installFrom = "recall";
                DownloadStatusManager.a().a(c2);
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
            f36071a.removeMessages(a3.mTaskId);
            f36071a.obtainMessage(a3.mTaskId, 1, 2, builder.build()).sendToTarget();
        }
    }

    @Override // com.ksad.download.f
    public void a(String str) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
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
            f36071a.removeMessages(a3.mTaskId);
            f36071a.obtainMessage(a3.mTaskId, 1, 2, builder.build()).sendToTarget();
        }
    }

    @Override // com.ksad.download.f
    public void b(DownloadTask downloadTask) {
        Context context;
        boolean a2;
        DownloadParams downloadParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, downloadTask) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
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
        f36071a.removeMessages(downloadTask.getId());
        f36071a.obtainMessage(downloadTask.getId(), 1, 1, builder.build()).sendToTarget();
    }
}
