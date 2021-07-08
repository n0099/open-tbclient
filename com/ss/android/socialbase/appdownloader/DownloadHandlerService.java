package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.a.d;
import d.l.a.e.b.f.i;
import d.l.a.e.b.g.e;
import d.l.a.e.b.l.f;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class DownloadHandlerService extends Service {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f38354a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadHandlerService f38355e;

        public a(DownloadHandlerService downloadHandlerService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadHandlerService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38355e = downloadHandlerService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("application/vnd.android.package-archive");
                    arrayList.add("mime_type_plg");
                    d.l.a.e.b.g.a.H(e.n()).z(arrayList);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f38356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.f f38357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.l.a.e.b.f.d f38358g;

        public b(DownloadInfo downloadInfo, d.f fVar, d.l.a.e.b.f.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadInfo, fVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38356e = downloadInfo;
            this.f38357f = fVar;
            this.f38358g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageInfo i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    File file = new File(this.f38356e.getSavePath(), this.f38356e.getName());
                    if (file.exists()) {
                        try {
                            String str = (e.n() == null || (i2 = d.i(this.f38356e, file)) == null) ? "" : i2.packageName;
                            if (this.f38357f != null) {
                                this.f38357f.b(this.f38356e.getId(), 3, str, -3, this.f38356e.getDownloadTime());
                            }
                            if (this.f38358g != null) {
                                this.f38358g.a(3, this.f38356e, str, "");
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(680531539, "Lcom/ss/android/socialbase/appdownloader/DownloadHandlerService;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(680531539, "Lcom/ss/android/socialbase/appdownloader/DownloadHandlerService;");
                return;
            }
        }
        f38354a = DownloadHandlerService.class.getSimpleName();
    }

    public DownloadHandlerService() {
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

    private boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, intent)) == null) {
            if (intent == null) {
                return false;
            }
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return false;
            }
            int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            intent.getIntExtra("extra_click_download_type", 0);
            d.f u = d.l.a.e.a.e.G().u();
            d.l.a.e.b.f.d i2 = d.l.a.e.b.g.a.H(this).i(intExtra);
            boolean z = true;
            if (intent.getBooleanExtra("extra_from_notification", false) && d.l.a.e.b.j.a.d(intExtra).m("notification_opt_2") == 1) {
                d.l.a.e.b.p.b.a().m(intExtra);
            }
            DownloadInfo f2 = d.l.a.e.b.g.a.H(this).f(intExtra);
            if (f2 == null) {
                return false;
            }
            if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
                a(f2, u, i2);
            } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
                a(this, f2, u, i2);
            } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
                if (f2.getStatus() == 0) {
                    return false;
                }
                a(this, f2, u, i2);
                if (f2.isDownloadOverStatus() && d.l.a.e.b.j.a.d(intExtra).b("no_hide_notification", 0) == 0) {
                    if (!((d.l.a.e.b.j.a.d(intExtra).m("enable_notification_ui") < 2 || f2.getStatus() != -1) ? false : false)) {
                        d.l.a.e.b.p.b.a().b(intExtra);
                        d.l.a.e.b.p.b.a().m(intExtra);
                    }
                }
            } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
                b(f2, u, i2);
            } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
                d.l.a.e.b.p.b.a().b(intExtra);
            } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
                e.A0().execute(new a(this));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void b(@NonNull DownloadInfo downloadInfo, d.f fVar, d.l.a.e.b.f.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, this, downloadInfo, fVar, dVar) == null) {
            int id = downloadInfo.getId();
            Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
            intent.putExtra("extra_click_download_ids", id);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            startActivity(intent);
            d.l.a.e.b.p.b.a().b(id);
            downloadInfo.updateDownloadTime();
            if (fVar != null) {
                fVar.b(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }
            if (dVar != null) {
                dVar.a(7, downloadInfo, "", "");
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            e.C(this);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, intent, i2, i3)) == null) {
            super.onStartCommand(intent, i2, i3);
            if (d.l.a.e.b.c.a.e()) {
                d.l.a.e.b.c.a.g(f38354a, "onStartCommand");
            }
            a(intent);
            stopSelf();
            return 2;
        }
        return invokeLII.intValue;
    }

    public static void a(Context context, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, context, downloadInfo) == null) && f.g0(context.getApplicationContext()) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    public static void a(Context context, d.f fVar, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, fVar, downloadInfo) == null) || downloadInfo == null) {
            return;
        }
        d.l.a.e.b.f.d i2 = d.l.a.e.b.g.a.H(context).i(downloadInfo.getId());
        if (fVar == null && i2 == null) {
            return;
        }
        e.A0().execute(new b(downloadInfo, fVar, i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(@NonNull DownloadInfo downloadInfo, d.f fVar, d.l.a.e.b.f.d dVar) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, this, downloadInfo, fVar, dVar) != null) {
            return;
        }
        int id = downloadInfo.getId();
        i I = d.l.a.e.b.g.f.c().I(id);
        if (I != null) {
            try {
                a2 = I.a(downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (a2) {
                Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
                intent.putExtra("extra_click_download_ids", id);
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                startActivity(intent);
                d.l.a.e.b.p.b.a().b(id);
                downloadInfo.updateDownloadTime();
                if (fVar != null) {
                    fVar.b(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (dVar != null) {
                    dVar.a(7, downloadInfo, "", "");
                    return;
                }
                return;
            }
            return;
        }
        a2 = false;
        if (a2) {
        }
    }

    public static void a(Context context, int i2, boolean z) {
        boolean z2;
        i I;
        DownloadInfo f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z && (I = d.l.a.e.b.g.f.c().I(i2)) != null) {
                try {
                    f2 = d.l.a.e.b.g.a.H(context).f(i2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (f2 != null) {
                    z2 = I.b(f2);
                    if (z2 && d.d(context, i2, true) == 0) {
                        Toast.makeText(context, "Open Fail!", 0).show();
                    }
                    return;
                }
            }
            z2 = false;
            if (z2) {
                return;
            }
            Toast.makeText(context, "Open Fail!", 0).show();
        }
    }

    public static void a(Context context, DownloadInfo downloadInfo, d.f fVar, d.l.a.e.b.f.d dVar) {
        d.l.a.e.b.p.a l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, downloadInfo, fVar, dVar) == null) {
            int id = downloadInfo.getId();
            i I = d.l.a.e.b.g.f.c().I(id);
            if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && I != null && d.v(context, downloadInfo) && I.c(downloadInfo)) {
                return;
            }
            boolean z = false;
            switch (downloadInfo.getStatus()) {
                case -4:
                case -1:
                    if (d.l.a.e.b.j.a.d(id).m("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                        downloadInfo.setOnlyWifi(false);
                    }
                    d.l.a.e.b.g.a.H(context).y(id);
                    return;
                case -3:
                    a(e.n(), id, true);
                    a(context, fVar, downloadInfo);
                    if (d.l.a.e.b.j.a.d(id).b("notification_click_install_auto_cancel", 1) != 0 || (l = d.l.a.e.b.p.b.a().l(id)) == null) {
                        z = true;
                    } else {
                        l.p();
                        l.c(-3, null, false, true);
                    }
                    if (z) {
                        d.l.a.e.b.p.b.a().b(id);
                        return;
                    }
                    return;
                case -2:
                    if (d.l.a.e.b.g.f.c().B(id)) {
                        d.l.a.e.b.g.a.H(context).B(id);
                    } else {
                        d.s(downloadInfo, true, false);
                    }
                    if (fVar != null) {
                        fVar.b(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                    }
                    if (dVar != null) {
                        dVar.a(6, downloadInfo, "", "");
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    d.l.a.e.b.g.a.H(context).u(id);
                    a(context, downloadInfo);
                    if (fVar != null) {
                        fVar.b(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                    }
                    if (dVar != null) {
                        dVar.a(5, downloadInfo, "", "");
                        return;
                    }
                    return;
            }
        }
    }
}
