package d.l.a.d;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.f.c;
import d.l.a.d.b.c;
import d.l.a.d.b.d;
import d.l.a.d.b.l;
import d.l.a.d.e;
import d.l.a.d.h;
import d.l.a.e.a.d;
import d.l.a.e.b.a.a;
import d.l.a.e.b.f.p;
import d.l.a.e.b.f.q;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d implements d.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f71443a;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.p().a(5, l.a(), null, "无网络，请检查网络设置", null, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.e.b.j.a f71444e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.l.a.a.a.d.d f71445f;

        public b(d dVar, d.l.a.e.b.j.a aVar, d.l.a.a.a.d.d dVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, aVar, dVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71444e = aVar;
            this.f71445f = dVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.p().a(2, l.a(), this.f71445f, this.f71444e.h("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b.a.c.b f71446e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f71447f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f71448g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ double f71449h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ DownloadInfo f71450i;

        public c(d dVar, d.l.a.b.a.c.b bVar, long j, long j2, double d2, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, bVar, Long.valueOf(j), Long.valueOf(j2), Double.valueOf(d2), downloadInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71446e = bVar;
            this.f71447f = j;
            this.f71448g = j2;
            this.f71449h = d2;
            this.f71450i = downloadInfo;
        }

        @Override // d.l.a.e.b.a.a.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!h.r.C(this.f71446e)) {
                    long j = this.f71447f;
                    if (j <= -1 || this.f71448g <= -1 || j >= this.f71449h) {
                        return;
                    }
                    e.c.a().r("clean_space_install", d.l.a.d.b.f.d("install_no_enough_space"), this.f71446e);
                    if (d.l.a.d.b.f.p(this.f71450i, ((long) this.f71449h) - this.f71447f)) {
                        d.l.a.e.b.a.a.c().i(this);
                        this.f71446e.I0(true);
                        return;
                    }
                    return;
                }
                d.l.a.e.b.a.a.c().i(this);
            }
        }

        @Override // d.l.a.e.b.a.a.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // d.l.a.e.b.f.q
        public void a(DownloadInfo downloadInfo) throws BaseException {
            PackageInfo h2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) || (h2 = d.l.a.e.a.d.h(l.a(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName())) == null) {
                return;
            }
            downloadInfo.setAppVersionCode(h2.versionCode);
        }

        @Override // d.l.a.e.b.f.q
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo)) == null) ? downloadInfo != null && h.k.h() && downloadInfo.getPackageInfo() == null : invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class h implements d.l.a.e.b.e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        @Override // d.l.a.e.b.e.c
        public void a(int i2, String str, JSONObject jSONObject) {
            DownloadInfo f2;
            d.l.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i2, str, jSONObject) == null) || (f2 = d.l.a.e.b.g.a.H(l.a()).f(i2)) == null || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            e.c.a().r(str, jSONObject, c2);
        }

        @Override // d.l.a.e.b.e.c
        public void b(int i2, String str, JSONObject jSONObject) {
            DownloadInfo f2;
            d.l.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, jSONObject) == null) || (f2 = d.l.a.e.b.g.a.H(l.a()).f(i2)) == null || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            if ("install_view_result".equals(str)) {
                jSONObject = h.r.n(jSONObject);
                d.l.a.d.a.g(jSONObject, f2);
                h.r.q(jSONObject, "model_id", Long.valueOf(c2.b()));
            }
            e.c.a().w(str, jSONObject, c2);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Context f71452a;

        public i(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71452a = context.getApplicationContext();
        }

        @Override // d.l.a.e.a.d.f
        public void a(Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
                d.l.a.d.a.d().p(str);
            }
        }

        @Override // d.l.a.e.a.d.f
        public void b(int i2, int i3, String str, int i4, long j) {
            Context context;
            DownloadInfo f2;
            d.l.a.b.a.c.b c2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4), Long.valueOf(j)}) == null) || (context = this.f71452a) == null || (f2 = d.l.a.e.b.g.a.H(context).f(i2)) == null || f2.getStatus() == 0 || (c2 = c.g.e().c(f2)) == null) {
                return;
            }
            if (i3 == 1) {
                d.l.a.d.a.n(f2, c2);
                if ("application/vnd.android.package-archive".equals(f2.getMimeType())) {
                    d.l.a.d.b.b.a().c(f2, c2.b(), c2.l(), c2.e(), f2.getTitle(), c2.d(), f2.getTargetFilePath());
                }
            } else if (i3 == 3) {
                JSONObject jSONObject = new JSONObject();
                d.l.a.d.a.t(jSONObject, f2);
                e.c.a().p("download_notification", "download_notification_install", jSONObject, c2);
            } else if (i3 == 5) {
                e.c.a().n("download_notification", "download_notification_pause", c2);
            } else if (i3 == 6) {
                e.c.a().n("download_notification", "download_notification_continue", c2);
            } else if (i3 != 7) {
            } else {
                e.c.a().n("download_notification", "download_notification_click", c2);
            }
        }

        @Override // d.l.a.e.a.d.f
        public boolean a(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (l.A() != null) {
                    return l.A().a(z);
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // d.l.a.e.a.d.f
        public void a(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) || downloadInfo == null) {
                return;
            }
            d.l.a.d.g.b().g(downloadInfo);
            if (d.l.a.e.b.j.a.d(downloadInfo.getId()).b("report_download_cancel", 1) == 1) {
                e.c.a().i(downloadInfo, new BaseException(1012, ""));
            } else {
                e.c.a().u(downloadInfo, new BaseException(1012, ""));
            }
        }

        @Override // d.l.a.e.a.d.f
        public void a(int i2, int i3, String str, String str2, String str3) {
            Context context;
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3}) == null) || (context = this.f71452a) == null || (f2 = d.l.a.e.b.g.a.H(context).f(i2)) == null || f2.getStatus() != -3) {
                return;
            }
            f2.setPackageName(str2);
            d.l.a.d.b.c.a().b(this.f71452a, f2);
        }

        @Override // d.l.a.e.a.d.f
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.l.a.d.b.c.a().c() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class j extends d.c {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static String f71453a = "d$j";
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements d.n {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public c.b f71454a;

            /* renamed from: b  reason: collision with root package name */
            public DialogInterface.OnClickListener f71455b;

            /* renamed from: c  reason: collision with root package name */
            public DialogInterface.OnClickListener f71456c;

            /* renamed from: d  reason: collision with root package name */
            public DialogInterface.OnCancelListener f71457d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Context f71458e;

            /* renamed from: d.l.a.d.d$j$a$a  reason: collision with other inner class name */
            /* loaded from: classes8.dex */
            public class C2029a implements c.InterfaceC2012c {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f71459a;

                public C2029a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f71459a = aVar;
                }

                @Override // d.l.a.a.a.f.c.InterfaceC2012c
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.f71459a.f71455b == null) {
                        return;
                    }
                    this.f71459a.f71455b.onClick(dialogInterface, -1);
                }

                @Override // d.l.a.a.a.f.c.InterfaceC2012c
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) || this.f71459a.f71456c == null) {
                        return;
                    }
                    this.f71459a.f71456c.onClick(dialogInterface, -2);
                }

                @Override // d.l.a.a.a.f.c.InterfaceC2012c
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) || this.f71459a.f71457d == null || dialogInterface == null) {
                        return;
                    }
                    this.f71459a.f71457d.onCancel(dialogInterface);
                }
            }

            public a(j jVar, Context context) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71458e = context;
                this.f71454a = new c.b(this.f71458e);
            }

            @Override // d.l.a.e.a.d.n
            public d.n a(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                    this.f71454a.e(this.f71458e.getResources().getString(i2));
                    return this;
                }
                return (d.n) invokeI.objValue;
            }

            @Override // d.l.a.e.a.d.n
            public d.n b(int i2, DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, onClickListener)) == null) {
                    this.f71454a.j(this.f71458e.getResources().getString(i2));
                    this.f71455b = onClickListener;
                    return this;
                }
                return (d.n) invokeIL.objValue;
            }

            @Override // d.l.a.e.a.d.n
            public d.n c(DialogInterface.OnCancelListener onCancelListener) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, onCancelListener)) == null) {
                    this.f71457d = onCancelListener;
                    return this;
                }
                return (d.n) invokeL.objValue;
            }

            @Override // d.l.a.e.a.d.n
            public d.n a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    this.f71454a.h(str);
                    return this;
                }
                return (d.n) invokeL.objValue;
            }

            @Override // d.l.a.e.a.d.n
            public d.n a(int i2, DialogInterface.OnClickListener onClickListener) {
                InterceptResult invokeIL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, onClickListener)) == null) {
                    this.f71454a.l(this.f71458e.getResources().getString(i2));
                    this.f71456c = onClickListener;
                    return this;
                }
                return (d.n) invokeIL.objValue;
            }

            @Override // d.l.a.e.a.d.n
            public d.n a(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                    this.f71454a.f(z);
                    return this;
                }
                return (d.n) invokeZ.objValue;
            }

            @Override // d.l.a.e.a.d.n
            public d.m a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f71454a.d(new C2029a(this));
                    h.q.b(j.f71453a, "getThemedAlertDlgBuilder", null);
                    this.f71454a.b(3);
                    return new b(l.p().b(this.f71454a.g()));
                }
                return (d.m) invokeV.objValue;
            }
        }

        /* loaded from: classes8.dex */
        public static class b implements d.m {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public Dialog f71460a;

            public b(Dialog dialog) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dialog};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                if (dialog != null) {
                    this.f71460a = dialog;
                    a();
                }
            }

            @Override // d.l.a.e.a.d.m
            public void a() {
                Dialog dialog;
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (dialog = this.f71460a) == null) {
                    return;
                }
                dialog.show();
            }

            @Override // d.l.a.e.a.d.m
            public boolean b() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    Dialog dialog = this.f71460a;
                    if (dialog != null) {
                        return dialog.isShowing();
                    }
                    return false;
                }
                return invokeV.booleanValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(768822436, "Ld/l/a/d/d$j;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(768822436, "Ld/l/a/d/d$j;");
            }
        }

        public j() {
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

        @Override // d.l.a.e.a.d.c, d.l.a.e.a.d.e
        public d.n a(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? new a(this, context) : (d.n) invokeL.objValue;
        }

        @Override // d.l.a.e.a.d.c, d.l.a.e.a.d.e
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f71461e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f71462f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f71463g;

            public a(k kVar, int i2, d.l.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71463g = kVar;
                this.f71461e = i2;
                this.f71462f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(this.f71461e);
                    JSONObject jSONObject = new JSONObject();
                    h.r.q(jSONObject, "ttdownloader_type", 1);
                    h.l.g(f2, jSONObject);
                    if (f2 != null && -2 == f2.getRealStatus() && !f2.isPauseReserveOnWifi()) {
                        this.f71463g.c(this.f71461e, this.f71462f, jSONObject);
                    } else {
                        h.r.q(jSONObject, "error_code", 1001);
                    }
                    e.c.a().w("download_notification_try_show", jSONObject, this.f71462f);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f71464e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f71465f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f71466g;

            public b(k kVar, int i2, d.l.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71466g = kVar;
                this.f71464e = i2;
                this.f71465f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(this.f71464e);
                    JSONObject jSONObject = new JSONObject();
                    h.r.q(jSONObject, "ttdownloader_type", 2);
                    h.l.g(f2, jSONObject);
                    if (!h.r.C(this.f71465f)) {
                        this.f71466g.c(this.f71464e, this.f71465f, jSONObject);
                    } else {
                        h.r.q(jSONObject, "error_code", 1002);
                    }
                    e.c.a().w("download_notification_try_show", jSONObject, this.f71465f);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f71467e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d.l.a.b.a.c.b f71468f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ k f71469g;

            public c(k kVar, int i2, d.l.a.b.a.c.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i2), bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71469g = kVar;
                this.f71467e = i2;
                this.f71468f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(this.f71467e);
                    JSONObject jSONObject = new JSONObject();
                    h.r.q(jSONObject, "ttdownloader_type", 3);
                    h.l.g(f2, jSONObject);
                    if (!h.r.F(this.f71468f.e())) {
                        this.f71469g.c(this.f71467e, this.f71468f, jSONObject);
                    } else {
                        h.r.q(jSONObject, "error_code", 1003);
                    }
                    e.c.a().w("download_notification_try_show", jSONObject, this.f71468f);
                }
            }
        }

        /* renamed from: d.l.a.d.d$k$d  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static class C2030d {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static k f71470a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(103996931, "Ld/l/a/d/d$k$d;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(103996931, "Ld/l/a/d/d$k$d;");
                        return;
                    }
                }
                f71470a = new k(null);
            }
        }

        public /* synthetic */ k(a aVar) {
            this();
        }

        public static k a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2030d.f71470a : (k) invokeV.objValue;
        }

        public void b(int i2) {
            DownloadInfo f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && com.ss.android.socialbase.appdownloader.e.c.d().b(i2) == null && (f2 = d.l.a.e.b.g.a.H(l.a()).f(i2)) != null) {
                com.ss.android.socialbase.appdownloader.e.c.d().f(i2, f2.getIconUrl());
            }
        }

        public final void c(int i2, d.l.a.b.a.c.b bVar, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bVar, jSONObject) == null) {
                if (!d.l.a.e.a.f.c.d()) {
                    h.r.q(jSONObject, "error_code", 1004);
                    return;
                }
                DownloadInfo f2 = d.l.a.e.b.g.a.H(l.a()).f(i2);
                if (f2 == null) {
                    h.r.q(jSONObject, "error_code", 1005);
                    return;
                }
                if (d.l.a.e.b.p.b.a().l(i2) != null) {
                    d.l.a.e.b.p.b.a().m(i2);
                }
                d.l.a.e.a.f.a aVar = new d.l.a.e.a.f.a(l.a(), i2, f2.getTitle(), f2.getSavePath(), f2.getName(), f2.getExtra());
                aVar.d(f2.getCurBytes());
                aVar.k(f2.getTotalBytes());
                aVar.c(f2.getStatus(), null, false, false);
                d.l.a.e.b.p.b.a().e(aVar);
                aVar.g(null, false);
                e.c.a().w("download_notification_show", jSONObject, bVar);
            }
        }

        public void d(d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
                h(bVar, 5L);
            }
        }

        public void e(@NonNull d.l.a.b.a.c.b bVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, bVar, j) == null) {
                int s = bVar.s();
                if (d.l.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                    return;
                }
                b(s);
                d.l.a.d.e.a().c(new c(this, s, bVar), j * 1000);
            }
        }

        public void g(d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
                return;
            }
            h(bVar, d.l.a.e.b.j.a.d(bVar.s()).b("noti_continue_delay_secs", 5));
        }

        public final void h(@NonNull d.l.a.b.a.c.b bVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, bVar, j) == null) {
                int s = bVar.s();
                if (d.l.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                    return;
                }
                b(s);
                d.l.a.d.e.a().c(new a(this, s, bVar), j * 1000);
            }
        }

        public void i(@NonNull d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
                j(bVar, 5L);
            }
        }

        public final void j(@NonNull d.l.a.b.a.c.b bVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048583, this, bVar, j) == null) {
                int s = bVar.s();
                if (d.l.a.e.b.j.a.d(s).m("notification_opt_2") != 1) {
                    return;
                }
                b(s);
                d.l.a.d.e.a().c(new b(this, s, bVar), j * 1000);
            }
        }

        public void k(@NonNull d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
                j(bVar, d.l.a.e.b.j.a.d(bVar.s()).b("noti_install_delay_secs", 5));
            }
        }

        public void l(@NonNull d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
                e(bVar, 5L);
            }
        }

        public void m(@NonNull d.l.a.b.a.c.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) {
                e(bVar, d.l.a.e.b.j.a.d(bVar.s()).b("noti_open_delay_secs", 5));
            }
        }

        public k() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(179570794, "Ld/l/a/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(179570794, "Ld/l/a/d/d;");
        }
    }

    public d() {
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
        this.f71443a = new Handler(Looper.getMainLooper());
    }

    @Override // d.l.a.e.a.d.j
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        d.l.a.a.a.d.d a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            h.l.g(downloadInfo, jSONObject);
            d.l.a.d.a.g(jSONObject, downloadInfo);
            h.q.a("download_failed", jSONObject.toString());
        }
        d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
        if (c2 == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    d.l.a.d.a.n(downloadInfo, c2);
                    return;
                } else if (i2 == 2001) {
                    d.l.a.d.a.d().o(downloadInfo, c2, 2001);
                    return;
                } else if (i2 == 11) {
                    d.l.a.d.a.d().o(downloadInfo, c2, 2000);
                    if (c2.P()) {
                        return;
                    }
                    b(downloadInfo, c2);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (d.l.a.e.b.j.a.d(downloadInfo.getId()).b("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f71443a.post(new a(this));
                }
                if (d.l.a.e.b.l.f.V0(baseException)) {
                    if (l.y() != null) {
                        l.y().a(c2.b());
                    }
                    e.c.a().m("download_failed_for_space", c2);
                    if (!c2.N()) {
                        e.c.a().m("download_can_restart", c2);
                        a(downloadInfo);
                    }
                    if ((l.y() == null || !l.y().d()) && (a2 = c.g.e().a(c2.b())) != null && a2.k()) {
                        d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(downloadInfo.getId());
                        if (d2.b("show_no_enough_space_toast", 0) == 1) {
                            this.f71443a.post(new b(this, d2, a2));
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), h.r.l(baseException.getMessage(), l.v().optInt("exception_msg_length", 500)));
            }
            e.c.a().u(downloadInfo, baseException2);
            d.l.a.d.g.b().h(downloadInfo, baseException, "");
        } catch (Exception e2) {
            l.F().a(e2, "onAppDownloadMonitorSend");
        }
    }

    public final void b(DownloadInfo downloadInfo, d.l.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, bVar) == null) {
            long f2 = h.r.f(Environment.getDataDirectory(), -1L);
            long min = Math.min(524288000L, h.r.e(Environment.getDataDirectory()) / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = (totalBytes * 2.5d) + min;
            if (f2 > -1 && totalBytes > -1) {
                double d3 = f2;
                if (d3 < d2 && d2 - d3 > d.l.a.d.b.f.q()) {
                    d.l.a.d.b.f.e(downloadInfo.getId());
                }
            }
            d.l.a.e.b.a.a.c().f(new c(this, bVar, f2, totalBytes, d2, downloadInfo));
        }
    }

    /* renamed from: d.l.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2028d implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.l.a.d.d$d$a */
        /* loaded from: classes8.dex */
        public class a implements MediaScannerConnection.OnScanCompletedListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DownloadInfo f71451a;

            public a(C2028d c2028d, DownloadInfo downloadInfo) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c2028d, downloadInfo};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f71451a = downloadInfo;
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str, Uri uri) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, uri) == null) || uri == null) {
                    return;
                }
                this.f71451a.safePutToDBJsonData("file_content_uri", uri.toString());
                d.l.a.e.b.g.e.M0().a(this.f71451a);
            }
        }

        public C2028d() {
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

        @Override // d.l.a.e.b.f.q
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) && downloadInfo != null && c(downloadInfo)) {
                a(l.a(), downloadInfo);
            }
        }

        @Override // d.l.a.e.b.f.q
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo != null) {
                    return h.k.j(d.l.a.e.b.j.a.d(downloadInfo.getId()));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final boolean c(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, downloadInfo)) == null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                String d2 = d.l.a.e.a.h.a.d.d(l.a(), d.l.a.e.a.d.i(downloadInfo, file), str);
                boolean z = false;
                if (!TextUtils.isEmpty(d2)) {
                    String str2 = d2 + ".apk";
                    if (str2.equals(downloadInfo.getName())) {
                        return true;
                    }
                    try {
                        z = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                        if (z) {
                            downloadInfo.setName(str2);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        public final void a(Context context, DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, downloadInfo) == null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
                if (query != null && query.moveToFirst()) {
                    downloadInfo.safePutToDBJsonData("file_content_uri", ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), query.getInt(query.getColumnIndex("_id"))).toString());
                } else {
                    MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new a(this, downloadInfo));
                }
                d.l.a.e.b.l.f.D(query);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements q {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
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

        @Override // d.l.a.e.b.f.q
        public void a(DownloadInfo downloadInfo) throws BaseException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                d.l.a.a.a.c.l w = l.w();
                if (downloadInfo == null || w == null) {
                    return;
                }
                String packageName = downloadInfo.getPackageName();
                String targetFilePath = downloadInfo.getTargetFilePath();
                File a2 = a(packageName, targetFilePath);
                d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                w.a(packageName, targetFilePath, a2, c2 != null ? h.r.n(c2.g()) : null);
                downloadInfo.setMimeType("application/vnd.android.package-archive");
                downloadInfo.setName(a2.getName());
                downloadInfo.setMd5(null);
            }
        }

        @Override // d.l.a.e.b.f.q
        public boolean b(DownloadInfo downloadInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo)) == null) {
                if (downloadInfo != null) {
                    return d.l.a.a.a.g.b.f(d.l.a.e.b.j.a.d(downloadInfo.getId()), downloadInfo.getMimeType());
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final File a(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                File file = new File(str2);
                String name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    str = name.substring(0, lastIndexOf);
                }
                return new File(file.getParent(), str + ".apk");
            }
            return (File) invokeLL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements d.i, p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo f2;
                int spIntVal;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.g.e().q();
                    for (d.l.a.b.a.c.b bVar : c.g.e().t().values()) {
                        int s = bVar.s();
                        if (s != 0) {
                            d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(s);
                            if (d2.m("notification_opt_2") == 1 && (f2 = d.l.a.e.b.g.a.H(l.a()).f(s)) != null) {
                                if (h.r.C(bVar) && !h.r.F(bVar.e())) {
                                    int spIntVal2 = f2.getSpIntVal("restart_notify_open_app_count");
                                    if (spIntVal2 < d2.b("noti_open_restart_times", 1)) {
                                        k.a().l(bVar);
                                        f2.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                    }
                                } else if (f2.getRealStatus() == -2) {
                                    int spIntVal3 = f2.getSpIntVal("restart_notify_continue_count");
                                    if (spIntVal3 < d2.b("noti_continue_restart_times", 1)) {
                                        k.a().d(bVar);
                                        f2.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                    }
                                } else if (f2.getRealStatus() == -3 && d.l.a.e.b.l.f.t0(f2) && !h.r.C(bVar) && (spIntVal = f2.getSpIntVal("restart_notify_install_count")) < d2.b("noti_install_restart_times", 1)) {
                                    k.a().i(bVar);
                                    f2.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                                }
                            }
                        }
                    }
                }
            }
        }

        public g() {
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

        @Override // d.l.a.e.b.f.p
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.l.a.e.a.d.i
        public void a(DownloadInfo downloadInfo, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo, z) == null) || downloadInfo == null) {
                return;
            }
            b(downloadInfo, downloadInfo.getRealStatus(), z);
        }

        @Override // d.l.a.e.a.d.i
        public void a(List<DownloadInfo> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            }
        }

        @WorkerThread
        public void b(DownloadInfo downloadInfo, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                c.g.e().q();
                d.l.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
                if (c2 == null) {
                    return;
                }
                try {
                    if (z) {
                        c2.p0(downloadInfo.getFailedResumeCount());
                    } else if (c2.A() == -1) {
                        return;
                    } else {
                        c2.p0(-1);
                    }
                    c.j.b().c(c2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("url", downloadInfo.getUrl());
                    jSONObject.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject.put("download_status", i2);
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    int i3 = 1;
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    if (!z) {
                        i3 = 2;
                    }
                    jSONObject.put("launch_resumed", i3);
                    jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                    e.c.a().p("embeded_ad", "download_uncompleted", jSONObject, c2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        @Override // d.l.a.e.b.f.p
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                d.l.a.d.e.a().c(new a(this), 5000L);
            }
        }
    }

    public final void a(@NonNull DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) && h.k.r(downloadInfo.getId())) {
            d.l.a.d.e.a().f(new d.c(downloadInfo));
        }
    }
}
