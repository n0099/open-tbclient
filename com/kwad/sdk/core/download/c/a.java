package com.kwad.sdk.core.download.c;

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
import androidx.core.view.InputDeviceCompat;
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
import com.ksad.download.d;
import com.ksad.download.f;
import com.ksad.download.g;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.download.DownloadStatusManager;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ai;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class a implements f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, WeakReference<Bitmap>> f72030a;

    /* renamed from: b  reason: collision with root package name */
    public static c f72031b;

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f72032c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.sdk.core.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC1993a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final SparseArray<Long> f72033a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1993a() {
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
            this.f72033a = new SparseArray<>();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                boolean z = message.arg1 == 1;
                boolean z2 = message.arg2 == 1;
                boolean z3 = message.arg2 == 2;
                Long l = this.f72033a.get(message.what);
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
                    this.f72033a.put(message.what, Long.valueOf(System.currentTimeMillis()));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static String f72034a = "ksad_notification_default_icon";
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public String f72035b;

        /* renamed from: c  reason: collision with root package name */
        public String f72036c;

        /* renamed from: d  reason: collision with root package name */
        public String f72037d;

        /* renamed from: e  reason: collision with root package name */
        public String f72038e;

        /* renamed from: f  reason: collision with root package name */
        public int f72039f;

        /* renamed from: g  reason: collision with root package name */
        public File f72040g;

        /* renamed from: h  reason: collision with root package name */
        public String f72041h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f72042i;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(624125370, "Lcom/kwad/sdk/core/download/c/a$b;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(624125370, "Lcom/kwad/sdk/core/download/c/a$b;");
            }
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f72040g = null;
            this.f72042i = false;
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f72034a : (String) invokeV.objValue;
        }

        public static b b(DownloadTask downloadTask, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, downloadTask, str, str2)) == null) {
                b bVar = new b();
                Object tag = downloadTask.getTag();
                if (tag instanceof DownloadParams) {
                    DownloadParams downloadParams = (DownloadParams) tag;
                    File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(downloadParams.mAppIcon);
                    if (b2 != null && b2.exists()) {
                        bVar.f72040g = b2;
                    }
                    bVar.f72035b = downloadParams.mAppName;
                }
                bVar.f72042i = downloadTask.isPaused();
                bVar.f72036c = str;
                bVar.f72041h = str2;
                bVar.f72037d = a.b(downloadTask.getSmallFileSoFarBytes()) + " / " + a.b(downloadTask.getSmallFileTotalBytes());
                bVar.f72038e = a.b((long) downloadTask.getSmallFileTotalBytes());
                bVar.f72039f = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
                return bVar;
            }
            return (b) invokeLLL.objValue;
        }

        public static b b(DownloadParams downloadParams, String str, String str2) {
            InterceptResult invokeLLL;
            File b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, downloadParams, str, str2)) == null) {
                b bVar = new b();
                bVar.f72035b = downloadParams.mAppName;
                if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (b2 = com.kwad.sdk.core.diskcache.b.a.a().b(downloadParams.mAppIcon)) != null && b2.exists()) {
                    bVar.f72040g = b2;
                }
                bVar.f72036c = str;
                bVar.f72038e = a.b(downloadParams.mAppSize);
                bVar.f72041h = str2;
                return bVar;
            }
            return (b) invokeLLL.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.f72035b;
                return str == null ? "" : str;
            }
            return (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72037d : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f72038e : (String) invokeV.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72036c : (String) invokeV.objValue;
        }

        public File f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f72040g : (File) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "正在下载 " + this.f72039f + "%";
            }
            return (String) invokeV.objValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f72039f : invokeV.intValue;
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f72041h : (String) invokeV.objValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f72042i : invokeV.booleanValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private void a(@NonNull Intent intent) {
            DownloadTask c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, intent) == null) || (c2 = c(intent)) == null) {
                return;
            }
            d.a().f(c2.getId());
        }

        private void b(@NonNull Intent intent) {
            DownloadTask c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, intent) == null) || (c2 = c(intent)) == null) {
                return;
            }
            c2.setNotificationRemoved(true);
        }

        @Nullable
        public static DownloadTask c(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, intent)) == null) {
                int i2 = intent.getExtras().getInt(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, 0);
                if (i2 == 0) {
                    return null;
                }
                return d.a().a(i2);
            }
            return (DownloadTask) invokeL.objValue;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null || intent.getExtras() == null) {
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
        f72030a = new HashMap<>();
        f72032c = new HandlerC1993a();
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    public static PendingIntent a(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, str, i2)) == null) {
            Intent intent = new Intent(str);
            intent.putExtra(RemoteViewBuilder.ProgressRemoteViewImpl.KEY_TASKID, i2);
            return PendingIntent.getBroadcast(context, i2, intent, 0);
        }
        return (PendingIntent) invokeLLI.objValue;
    }

    private Bitmap a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, context, str)) == null) {
            WeakReference<Bitmap> weakReference = f72030a.get(str);
            Bitmap bitmap = weakReference != null ? weakReference.get() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap decodeResource = BitmapFactory.decodeResource(ai.a(context), ai.a(context, str));
                f72030a.put(str, new WeakReference<>(decodeResource));
                return decodeResource;
            }
            return bitmap;
        }
        return (Bitmap) invokeLL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, context) == null) && f72031b == null && context != null) {
            f72031b = new c();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(RemoteViewBuilder.ProgressRemoteViewImpl.ACTION_CLICK_CONTROL_BTN);
            intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            context.registerReceiver(f72031b, intentFilter);
        }
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, @Nullable PendingIntent pendingIntent, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{context, remoteViews, Boolean.valueOf(z), Boolean.valueOf(z2), pendingIntent, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
            builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(z).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ai.a(context, "ksad_notification_small_icon"));
            if (z2) {
                builder.setDeleteIntent(a(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i2));
            }
            f72032c.removeMessages(i2);
            f72032c.obtainMessage(i2, i3, i4, builder.build()).sendToTarget();
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.c.b bVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, this, context, bVar, str)) == null) {
            try {
                bVar.a(a(context, str));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(Context context, com.kwad.sdk.core.download.c.c cVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, this, context, cVar, str)) == null) {
            try {
                cVar.a(a(context, str));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    private boolean a(com.kwad.sdk.core.download.c.b bVar, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, bVar, file)) == null) {
            try {
                bVar.a(b(file));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private boolean a(com.kwad.sdk.core.download.c.c cVar, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, cVar, file)) == null) {
            try {
                cVar.a(b(file));
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                com.kwad.sdk.core.a.a.a(e2);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private Bitmap b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, file)) == null) {
            String absolutePath = file.getAbsolutePath();
            WeakReference<Bitmap> weakReference = f72030a.get(absolutePath);
            Bitmap bitmap = weakReference != null ? weakReference.get() : null;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
                f72030a.put(absolutePath, new WeakReference<>(decodeFile));
                return decodeFile;
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65549, null, j2)) == null) ? String.format("%.2fMB", Float.valueOf((((float) j2) / 1000.0f) / 1000.0f)) : (String) invokeJ.objValue;
    }

    public static void b(int i2, Notification notification) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65550, null, i2, notification) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
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
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, downloadTask)) == null) {
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
        return (DownloadParams) invokeL.objValue;
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

    public void a(Context context, com.kwad.sdk.core.download.c.b bVar, b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bVar, bVar2) == null) {
            bVar.a(bVar2.b());
            File f2 = bVar2.f();
            if (!((f2 == null || !f2.exists()) ? false : a(bVar, f2))) {
                a(context, bVar, b.a());
            }
            bVar.b(bVar2.e());
            bVar.c(bVar2.d());
            bVar.d(bVar2.i());
        }
    }

    public void a(Context context, com.kwad.sdk.core.download.c.c cVar, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, cVar, bVar) == null) {
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
    }

    @Override // com.ksad.download.f
    public void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadTask) == null) {
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048580, this, downloadTask, z) == null) || (context = KsAdSDKImpl.get().getContext()) == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        com.kwad.sdk.core.download.c.c a2 = com.kwad.sdk.core.download.c.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        a(context, a2, b.b(downloadTask, "正在下载", (String) null));
        a(context, a2.a(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, file) == null) {
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
            com.kwad.sdk.core.download.c.b a3 = com.kwad.sdk.core.download.c.b.a(context);
            a(context, a3, b2);
            a(context, a3.a(), false, false, g.a(file, a2.mTaskId), a2.mTaskId, 1, 2);
        }
    }

    @Override // com.ksad.download.f
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            DownloadParams a2 = com.kwad.sdk.core.a.a().a(str);
            com.kwad.sdk.core.a.a().b(str);
            if (context == null || a2 == null) {
                return;
            }
            com.kwad.sdk.core.a.a().b(a2.filePath);
            b b2 = b.b(a2, "安装完成", "立刻打开");
            com.kwad.sdk.core.download.c.b a3 = com.kwad.sdk.core.download.c.b.a(context);
            a(context, a3, b2);
            a(context, a3.a(), false, false, g.a(a2.mPkgname, a2.mTaskId), a2.mTaskId, 1, 2);
        }
    }

    @Override // com.ksad.download.f
    public void b(DownloadTask downloadTask) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, downloadTask) == null) || (context = KsAdSDKImpl.get().getContext()) == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b b2 = b.b(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.c.c a2 = com.kwad.sdk.core.download.c.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        a(context, a2, b2);
        a(context, a2.a(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.f
    public void c(DownloadTask downloadTask) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadTask) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        DownloadParams d2 = d(downloadTask);
        com.kwad.sdk.core.download.c.b a2 = com.kwad.sdk.core.download.c.b.a(context);
        a(context, a2, b.b(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.a().a(downloadTask.getTargetFilePath(), d2);
        com.kwad.sdk.core.a.a().a(d2.mPkgname, d2);
        a(context, a2.a(), false, false, g.a(downloadTask), downloadTask.getId(), 1, 1);
    }
}
