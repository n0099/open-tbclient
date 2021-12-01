package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.ss.android.downloadlib.addownload.b.d;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.c.h;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements com.ss.android.downloadad.api.a, b.c, a.InterfaceC2112a, ag {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "a";

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f61129d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f61130b;

    /* renamed from: c  reason: collision with root package name */
    public b f61131c;

    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC2095a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public final int f61139b;

        public RunnableC2095a(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f61139b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    com.ss.android.downloadlib.addownload.b.f.a().b();
                    ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c2 = com.ss.android.downloadlib.addownload.b.f.a().c();
                    if (c2 == null || c2.isEmpty()) {
                        return;
                    }
                    this.a.a(c2, this.f61139b);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public int f61140b;

        /* renamed from: c  reason: collision with root package name */
        public long f61141c;

        /* renamed from: d  reason: collision with root package name */
        public int f61142d;

        /* renamed from: e  reason: collision with root package name */
        public long f61143e;

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.f61143e = System.currentTimeMillis();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    if (a()) {
                        a.a().a(this.a, this.f61140b);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public b(long j2, int i2, long j3, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(j3), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j2;
            this.f61140b = i2;
            this.f61141c = j3;
            this.f61142d = i3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
            if (r9 < r1) goto L20;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a() {
            InterceptResult invokeV;
            DownloadInfo downloadInfo;
            double d2;
            JSONObject jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                com.ss.android.downloadad.api.a.b d3 = com.ss.android.downloadlib.addownload.b.f.a().d(this.a);
                boolean z = false;
                if (d3 == null || l.b(d3) || d3.f61120c.get() || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(d3.s())) == null) {
                    return false;
                }
                long M = d3.M();
                long a = l.a(Environment.getDataDirectory());
                long min = Math.min(524288000L, a / 10);
                long totalBytes = downloadInfo.getTotalBytes();
                double d4 = totalBytes;
                double d5 = min + (2.5d * d4);
                if (M <= -1 || totalBytes <= -1) {
                    d2 = d4;
                } else {
                    d2 = d4;
                }
                z = true;
                boolean a2 = com.ss.android.socialbase.appdownloader.b.a(j.getContext());
                JSONObject jSONObject2 = new JSONObject();
                int a3 = a(z, d3, downloadInfo, a2, jSONObject2);
                this.f61142d = a3;
                try {
                    jSONObject = jSONObject2;
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = jSONObject2;
                }
                try {
                    jSONObject.putOpt("fail_status", Integer.valueOf(a3));
                    jSONObject.putOpt("available_space", Long.valueOf(M / 1048576));
                    jSONObject.putOpt("total_space", Long.valueOf(a / 1048576));
                    int i2 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
                    if (i2 > 0) {
                        jSONObject.putOpt("package_size", Long.valueOf(totalBytes / 1048576));
                    }
                    jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                    if (M > 0 && i2 > 0) {
                        jSONObject.put("available_space_ratio", M / d2);
                    }
                    jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(a2 ? 1 : 2));
                    jSONObject.put("is_update_download", d3.V() ? 1 : 2);
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    com.ss.android.downloadlib.d.a.a().b("install_failed", jSONObject, d3);
                    return true;
                }
                com.ss.android.downloadlib.d.a.a().b("install_failed", jSONObject, d3);
                return true;
            }
            return invokeV.booleanValue;
        }

        private int a(boolean z, com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), bVar, downloadInfo, Boolean.valueOf(z2), jSONObject})) == null) {
                com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                int i2 = 1;
                if (a.a("install_failed_check_ttmd5", 1) == 1) {
                    int checkMd5Status = downloadInfo.checkMd5Status();
                    try {
                        jSONObject.put("ttmd5_status", checkMd5Status);
                    } catch (Throwable unused) {
                    }
                    if (!com.ss.android.socialbase.downloader.i.f.a(checkMd5Status)) {
                        return 2005;
                    }
                }
                int i3 = this.f61142d;
                if (i3 != 2000) {
                    return i3;
                }
                if (a.a("install_failed_check_signature", 1) == 1 && l.d(j.getContext(), bVar.e()) && !l.a(l.h(j.getContext(), downloadInfo.getTargetFilePath()), l.g(j.getContext(), bVar.e()))) {
                    return 2006;
                }
                if (z) {
                    long j2 = this.f61143e;
                    long j3 = this.f61141c;
                    if (j2 > j3) {
                        try {
                            jSONObject.put("install_time", j2 - j3);
                            if (bVar.C() <= this.f61141c) {
                                i2 = 0;
                            }
                            jSONObject.put("install_again", i2);
                        } catch (Throwable unused2) {
                        }
                        return !z2 ? 2003 : 2004;
                    }
                    return 2000;
                }
                return 2002;
            }
            return invokeCommon.intValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: b  reason: collision with root package name */
        public final com.ss.android.downloadad.api.a.b f61159b;

        public c(a aVar, com.ss.android.downloadad.api.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f61159b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        this.f61159b.j(true);
                        this.a.c(this.f61159b);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    this.f61159b.j(false);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1020732065, "Lcom/ss/android/downloadlib/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1020732065, "Lcom/ss/android/downloadlib/a;");
        }
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
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static JSONObject b(JSONObject jSONObject, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, jSONObject, downloadInfo)) == null) {
            if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                long a2 = l.a(0L);
                double d2 = a2;
                jSONObject.put("available_space", d2 / 1048576.0d);
                long totalBytes = downloadInfo.getTotalBytes();
                double d3 = totalBytes;
                jSONObject.put("apk_size", d3 / 1048576.0d);
                if (a2 > 0 && totalBytes > 0) {
                    jSONObject.put("available_space_ratio", d2 / d3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, bVar) == null) {
            SystemClock.sleep(20000L);
            int i2 = 15;
            while (i2 > 0) {
                if (l.b(bVar)) {
                    a(bVar.e());
                    return;
                }
                i2--;
                if (i2 == 0) {
                    return;
                }
                SystemClock.sleep(20000L);
            }
        }
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                b bVar = this.f61131c;
                if (bVar != null) {
                    bVar.b();
                    this.f61131c = null;
                }
            }
        }
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f61129d == null) {
                synchronized (a.class) {
                    if (f61129d == null) {
                        f61129d = new a();
                    }
                }
            }
            return f61129d;
        }
        return (a) invokeV.objValue;
    }

    public static String c(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, downloadInfo, bVar)) == null) {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            String str = null;
            if (file.exists()) {
                try {
                    PackageInfo packageArchiveInfo = j.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                    if (packageArchiveInfo != null) {
                        str = packageArchiveInfo.packageName;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("real_package_name", str);
                    jSONObject.put("input_package_name", downloadInfo.getPackageName());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                com.ss.android.downloadlib.d.a.a().a("embeded_ad", "package_name_error", jSONObject, bVar);
                return str;
            }
            return downloadInfo.getPackageName();
        }
        return (String) invokeLL.objValue;
    }

    private int d(com.ss.android.downloadad.api.a.b bVar) {
        InterceptResult invokeL;
        int realStatus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, bVar)) == null) {
            double a2 = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("download_failed_finally_hours", 48.0d);
            if (a2 <= 0.0d) {
                return -1;
            }
            if (System.currentTimeMillis() - bVar.H() < a2 * 60.0d * 60.0d * 1000.0d) {
                return 1;
            }
            if (bVar.f61121d.get()) {
                return 0;
            }
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
            if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
                return -1;
            }
            if (!DownloadStatus.isDownloading(realStatus) && bVar.f61121d.compareAndSet(false, true)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    a(jSONObject, downloadInfo);
                    jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                    jSONObject.putOpt("fail_status", Integer.valueOf(bVar.E()));
                    jSONObject.putOpt("fail_msg", bVar.F());
                    jSONObject.put("download_failed_times", bVar.x());
                    if (downloadInfo.getTotalBytes() > 0) {
                        jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                    }
                    jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
                    com.ss.android.downloadlib.d.a.a().a(bVar.j(), "download_failed_finally", jSONObject, bVar);
                    i.a().a(bVar);
                    return 0;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return 1;
        }
        return invokeL.intValue;
    }

    @WorkerThread
    public static synchronized void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, downloadInfo, bVar) == null) {
            synchronized (a.class) {
                if (downloadInfo == null) {
                    com.ss.android.downloadlib.e.c.a().a("onDownloadFinish info null");
                } else if (bVar == null) {
                    com.ss.android.downloadlib.e.c.a().a("onDownloadFinish nativeModel null");
                } else if (bVar.G() != 1) {
                } else {
                    h.a().d(bVar);
                    String c2 = c(downloadInfo, bVar);
                    com.ss.android.downloadlib.addownload.b.f.a().b(downloadInfo.getUrl(), c2);
                    Map<Long, com.ss.android.downloadad.api.a.b> a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getUrl(), c2);
                    bVar.f(System.currentTimeMillis());
                    bVar.e(2);
                    bVar.b(c2);
                    a2.put(Long.valueOf(bVar.b()), bVar);
                    i.a().a(a2.values());
                    b(bVar);
                    f.a().a(downloadInfo, c2);
                    if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                        a().a(bVar);
                        a().b(downloadInfo, bVar);
                        if (bVar.L()) {
                            com.ss.android.downloadlib.addownload.a.a.a().a(downloadInfo.getId(), bVar.b(), bVar.l(), c2, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
                        }
                        com.ss.android.downloadlib.addownload.e.a.a(downloadInfo, bVar.b(), bVar.d(), c2);
                    }
                }
            }
        }
    }

    public void b(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, downloadInfo, bVar) == null) || downloadInfo == null || bVar == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        d.a().b(new Runnable(this, targetFilePath, bVar) { // from class: com.ss.android.downloadlib.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ com.ss.android.downloadad.api.a.b f61135b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f61136c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, targetFilePath, bVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61136c = this;
                this.a = targetFilePath;
                this.f61135b = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    String a2 = com.ss.android.downloadlib.g.a.a(this.a);
                    if (TextUtils.isEmpty(a2)) {
                        return;
                    }
                    j.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(this.f61135b.b()), a2).apply();
                }
            }
        });
    }

    public static void b(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, bVar) == null) || bVar == null) {
            return;
        }
        String P = TextUtils.isEmpty(bVar.P()) ? "" : bVar.P();
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
        bVar.l("");
        i.a().a(bVar);
        JSONObject a2 = a(new JSONObject(), downloadInfo);
        int i2 = 1;
        try {
            a2.putOpt("finish_reason", P);
            a2.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        com.ss.android.downloadlib.g.f.a(a2, downloadInfo.getId());
        try {
            a2.put("download_failed_times", a3.x());
            a2.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                a2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            a2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            a2.put("has_send_download_failed_finally", a3.f61121d.get() ? 1 : 2);
            if (!a3.V()) {
                i2 = 2;
            }
            a2.put("is_update_download", i2);
            com.ss.android.downloadlib.g.f.a(a3, a2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("download_finish", a2, bVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2112a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            com.ss.android.socialbase.downloader.c.a.b(a, "onAppBackground()");
            a(6);
        }
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2112a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            com.ss.android.socialbase.downloader.c.a.b(a, "onAppForeground()");
            d();
            a(5);
        }
    }

    @WorkerThread
    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!l.a()) {
                    com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(str);
                    if (a2 == null) {
                        com.ss.android.downloadlib.addownload.b.d.a().a(str);
                        return;
                    }
                    com.ss.android.downloadlib.addownload.e a3 = f.a().a(a2.a());
                    if (a3 != null) {
                        a3.f();
                    }
                    if (a2.f61120c.get()) {
                        return;
                    }
                    if (com.ss.android.socialbase.downloader.g.a.a(a2.s()).b("notification_opt_2") == 1) {
                        com.ss.android.socialbase.downloader.notification.b.a().f(a2.s());
                    }
                    new com.ss.android.downloadlib.b.b().a(a2, new com.ss.android.downloadlib.b.g(this, a2, str) { // from class: com.ss.android.downloadlib.a.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.ss.android.downloadad.api.a.b a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ String f61132b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ a f61133c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, a2, str};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61133c = this;
                            this.a = a2;
                            this.f61132b = str;
                        }

                        @Override // com.ss.android.downloadlib.b.g
                        public void a(boolean z) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                                String str2 = a.a;
                                com.ss.android.socialbase.downloader.c.a.b(str2, "appBackForeground->" + z);
                                if (z) {
                                    if (!(com.ss.android.downloadlib.b.f.c(this.a) ? com.ss.android.downloadlib.b.a.a(this.f61132b, this.a) : false) && com.ss.android.downloadlib.b.f.d(this.a) && this.a.K() == 4) {
                                        com.ss.android.downloadlib.addownload.a.a.a().a(this.a);
                                    }
                                } else if (com.ss.android.downloadlib.b.a.a(this.f61132b, this.a) || this.a.K() != 4) {
                                } else {
                                    com.ss.android.downloadlib.addownload.a.a.a().a(this.a);
                                }
                            }
                        }
                    }, com.ss.android.downloadlib.g.e.a(a2).a("try_applink_delay_after_installed", 0));
                    h.a().f(a2);
                    a(str, a2);
                    com.ss.android.downloadlib.addownload.a.a.a().b(str);
                    DownloadInfo a4 = a(Downloader.getInstance(j.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
                    if (a4 != null) {
                        if (com.ss.android.socialbase.downloader.g.a.a(a4.getId()).b("no_hide_notification") != 1) {
                            com.ss.android.socialbase.downloader.notification.b.a().a(a4.getId());
                        }
                        f.a().b(a4, str);
                        com.ss.android.downloadlib.addownload.c.d.a(a4);
                    } else {
                        f.a().b(null, str);
                    }
                    return;
                }
                throw new RuntimeException("handleAppInstalled in main thread.");
            }
        }
    }

    private JSONObject b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, downloadInfo, aVar)) == null) {
            com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a2 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            aVar.a(jSONObject);
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, a2);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar, int i2) {
        long max;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048581, this, downloadInfo, bVar, i2) == null) || downloadInfo == null || bVar == null) {
            return;
        }
        d();
        long currentTimeMillis = System.currentTimeMillis();
        bVar.b(currentTimeMillis);
        bVar.g(l.a(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            max = 2000;
        } else {
            long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("check_install_failed_delay_time", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            if (a2 < 0) {
                return;
            }
            max = Math.max(a2, 30000L);
        }
        long j2 = max;
        b bVar2 = new b(bVar.b(), downloadInfo.getId(), currentTimeMillis, i2);
        d.a().a(bVar2, j2);
        this.f61131c = bVar2;
        i.a().a(bVar);
    }

    public void a(long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            long a2 = com.ss.android.socialbase.downloader.g.a.a(i2).a("check_install_finish_hijack_delay_time", 900000L);
            if (a2 < 0) {
                return;
            }
            d.a().a(new Runnable(this, j2) { // from class: com.ss.android.downloadlib.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f61134b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61134b = this;
                    this.a = j2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a.a().a(this.a);
                    }
                }
            }, Math.max(a2, 300000L));
        }
    }

    public void a(long j2) {
        d.a a2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            try {
                com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j2);
                if (d2 != null && !l.b(d2) && !d2.f61120c.get()) {
                    Pair<d.a, Integer> b2 = com.ss.android.downloadlib.addownload.b.d.a().b(d2);
                    if (b2 != null) {
                        a2 = (d.a) b2.first;
                        i2 = ((Integer) b2.second).intValue();
                    } else {
                        a2 = com.ss.android.downloadlib.addownload.b.d.a().a(d2);
                        i2 = -1;
                    }
                    if (a2 == null) {
                        return;
                    }
                    com.ss.android.downloadlib.addownload.b.d.a().b(a2.a);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installed_app_name", a2.f61221d);
                    jSONObject.put("installed_pkg_name", a2.a);
                    if (i2 != -1) {
                        jSONObject.put("error_code", i2);
                        com.ss.android.downloadlib.g.f.a(jSONObject, d2.s());
                        com.ss.android.downloadlib.d.a.a().b("install_finish_hijack", jSONObject, d2);
                        return;
                    }
                    com.ss.android.downloadlib.d.a.a().b("install_finish_may_hijack", jSONObject, d2);
                }
            } catch (Throwable th) {
                com.ss.android.downloadlib.e.c.a().a(th, "trySendInstallFinishHijack");
            }
        }
    }

    public void a(String str, com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, str, bVar) == null) && bVar != null && l.b(bVar) && bVar.f61120c.compareAndSet(false, true)) {
            com.ss.android.downloadlib.d.a.a().a(bVar.j(), "install_finish", a(bVar, str, bVar.K() != 4 ? 3 : 4), bVar);
            i.a().a(bVar);
        }
    }

    public static DownloadInfo a(List<DownloadInfo> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, str)) == null) {
            if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
                for (DownloadInfo downloadInfo : list) {
                    if (downloadInfo != null) {
                        if (str.equals(downloadInfo.getPackageName())) {
                            return downloadInfo;
                        }
                        if (l.a(j.getContext(), downloadInfo.getTargetFilePath(), str)) {
                            return downloadInfo;
                        }
                    }
                }
            }
            return null;
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, jSONObject, downloadInfo)) == null) {
            if (jSONObject != null && downloadInfo != null) {
                int i2 = 1;
                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                    return jSONObject;
                }
                try {
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put(DownloadDataConstants.Columns.COLUMN_TOTAL_BYTES, downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    jSONObject.put("current_network_quality", k.a().b().name());
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                    jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                    jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                    jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                    jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                    jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                    jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                    jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                    jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                    jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                    jSONObject.put(PackageTable.MD5, downloadInfo.getMd5());
                    jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                    jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                    jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                    double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                    double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                    if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                        double d2 = curBytes / realDownloadTime;
                        try {
                            jSONObject.put("download_speed", d2);
                        } catch (Exception unused) {
                        }
                        String str = a;
                        com.ss.android.socialbase.downloader.c.a.b(str, "download speed : " + d2 + "MB/s");
                    }
                    try {
                        jSONObject.put("is_download_service_foreground", Downloader.getInstance(j.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (downloadInfo.getBackUpUrls() != null) {
                        jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                        jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                    }
                    jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.c.d.a().b(downloadInfo.getUrl()));
                    jSONObject.put("mime_type", downloadInfo.getMimeType());
                    if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                        i2 = 2;
                    }
                    jSONObject.put("network_available", i2);
                    jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                    b(jSONObject, downloadInfo);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    private int a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, bVar, downloadInfo, str, jSONObject)) == null) {
            int b2 = com.ss.android.socialbase.appdownloader.c.b(j.getContext(), downloadInfo);
            int b3 = l.b(j.getContext(), str);
            if (b2 > 0 && b3 > 0 && b2 != b3) {
                return b3 > b2 ? SpeedStatsStampTable.NEW_LOGO_ACTIVITY_END_STAMP_KEY : SpeedStatsStampTable.NEW_LOGO_ACTIVITY_ON_DESTROY_END_STAMP_KEY;
            } else if (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("install_finish_check_ttmd5", 1) == 1) {
                String string = j.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
                if (TextUtils.isEmpty(string) && downloadInfo != null) {
                    string = com.ss.android.downloadlib.g.a.a(downloadInfo.getTargetFilePath());
                }
                int a2 = com.ss.android.downloadlib.g.a.a(string, com.ss.android.downloadlib.g.a.b(str));
                try {
                    jSONObject.put("ttmd5_status", a2);
                } catch (Throwable unused) {
                }
                if (a2 == 0) {
                    return 3000;
                }
                return a2 == 1 ? 3002 : 3001;
            } else {
                return 3001;
            }
        }
        return invokeLLLL.intValue;
    }

    @Override // com.ss.android.downloadad.api.a
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f61130b < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
                return;
            }
            d.a().a(new RunnableC2095a(this, i2), this.f61130b > 0 ? 2000L : 8000L);
            this.f61130b = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, this, concurrentHashMap, i2) == null) {
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (com.ss.android.downloadad.api.a.b bVar : concurrentHashMap.values()) {
                if (bVar.f61120c.get()) {
                    if (currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", w0.d0) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                } else if (bVar.G() == 1) {
                    if (d(bVar) <= 0 && currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", w0.d0) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                } else if (bVar.G() == 2) {
                    if (!bVar.Y()) {
                        if (l.b(bVar)) {
                            if (bVar.K() == 4) {
                                i2 = bVar.K();
                            }
                            com.ss.android.downloadlib.d.a.a().a(a(bVar, bVar.e(), i2), bVar);
                            arrayList.add(Long.valueOf(bVar.b()));
                            com.ss.android.downloadlib.addownload.c.d.a(bVar);
                        } else if (currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("finish_event_expire_hours", w0.d0) * 60 * 60 * 1000) {
                            arrayList.add(Long.valueOf(bVar.b()));
                        } else if (TextUtils.isEmpty(bVar.e())) {
                            arrayList.add(Long.valueOf(bVar.b()));
                        }
                    }
                } else {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            }
            com.ss.android.downloadlib.addownload.b.f.a().a(arrayList);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, downloadInfo, aVar) == null) || downloadInfo == null || aVar == null) {
            return;
        }
        JSONArray e2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_report_config");
        if (aVar.f61462b != 0) {
            downloadInfo.getTempCacheData().remove("intent");
        }
        if (e2 == null || (b2 = b(downloadInfo, aVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", b2);
    }

    @Override // com.ss.android.socialbase.downloader.depend.ag
    public void a(@Nullable DownloadInfo downloadInfo, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, downloadInfo, str) == null) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.e.c.a().a("info is null");
            } else if ((com.ss.android.socialbase.downloader.g.a.a(downloadInfo).b("check_applink_mode") & 2) != 0) {
                com.ss.android.downloadlib.b.e.a().b(new com.ss.android.downloadlib.b.d(this, downloadInfo, (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json")) { // from class: com.ss.android.downloadlib.a.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DownloadInfo a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ JSONObject f61137b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ a f61138c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, downloadInfo, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61138c = this;
                        this.a = downloadInfo;
                        this.f61137b = r8;
                    }

                    @Override // com.ss.android.downloadlib.b.d
                    public void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            if (!z) {
                                Intent intent = (Intent) this.a.getTempCacheData().get("intent");
                                if (intent != null) {
                                    this.a.getTempCacheData().remove("intent");
                                    com.ss.android.socialbase.appdownloader.c.a(j.getContext(), intent);
                                    l.a(this.f61137b, UnitedSchemeConstants.UNITED_SCHEME_BACKUP, (Object) 1);
                                } else {
                                    l.a(this.f61137b, UnitedSchemeConstants.UNITED_SCHEME_BACKUP, (Object) 2);
                                }
                            }
                            com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(this.a);
                            if (a2 != null) {
                                com.ss.android.downloadlib.d.a.a().a(z ? "installer_delay_success" : "installer_delay_failed", this.f61137b, a2);
                            } else {
                                com.ss.android.downloadlib.e.c.a().b("ah nativeModel=null");
                            }
                            if (z) {
                                j.t().a(j.getContext(), null, null, null, null, 1);
                            }
                        }
                    }
                });
            }
        }
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            d.a().a(new c(this, bVar));
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.b bVar, String str, int i2) {
        InterceptResult invokeLLI;
        com.ss.android.socialbase.appdownloader.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, this, bVar, str, i2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
                jSONObject.putOpt("scene", Integer.valueOf(i2));
                com.ss.android.downloadlib.g.f.a(jSONObject, bVar.s());
                com.ss.android.downloadlib.g.f.a(bVar, jSONObject);
                jSONObject.put("is_update_download", bVar.V() ? 1 : 2);
                jSONObject.put("install_after_back_app", bVar.ab() ? 1 : 2);
                jSONObject.putOpt("clean_space_install_params", bVar.R() ? "1" : "2");
                if (downloadInfo != null) {
                    a(jSONObject, downloadInfo);
                    try {
                        jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                        if (bVar.C() > 0) {
                            jSONObject.put("install_time", System.currentTimeMillis() - bVar.C());
                        }
                    } catch (Throwable unused) {
                    }
                    String a3 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                    if (!TextUtils.isEmpty(a3) && (a2 = com.ss.android.socialbase.appdownloader.a.a(a3)) != null) {
                        a2.a(jSONObject);
                    }
                }
                int a4 = a(bVar, downloadInfo, str, jSONObject);
                jSONObject.put("fail_status", a4);
                if (a4 == 3000) {
                    jSONObject.put("hijack", 2);
                } else if (a4 == 3001) {
                    jSONObject.put("hijack", 0);
                } else {
                    jSONObject.put("hijack", 1);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLI.objValue;
    }

    public void a(DownloadInfo downloadInfo, long j2, long j3, long j4, long j5, long j6, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{downloadInfo, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Boolean.valueOf(z)}) == null) {
            com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a2 == null) {
                com.ss.android.downloadlib.e.c.a().a("trySendClearSpaceEvent nativeModel null");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("space_before", Double.valueOf(j2 / 1048576.0d));
                jSONObject.putOpt("space_cleaned", Double.valueOf((j3 - j2) / 1048576.0d));
                jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j5));
                jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
                jSONObject.putOpt("byte_required", Long.valueOf(j4));
                jSONObject.putOpt("byte_required_after", Double.valueOf((j4 - j3) / 1048576.0d));
                jSONObject.putOpt("clear_sleep_time", Long.valueOf(j6));
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                com.ss.android.downloadlib.d.a.a().a("cleanup", jSONObject, a2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
