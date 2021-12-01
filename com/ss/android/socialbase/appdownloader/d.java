package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.appdownloader.c.j;
import com.ss.android.socialbase.appdownloader.c.m;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.r;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f61493b;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f61494f;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f61495g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f61496c;

    /* renamed from: d  reason: collision with root package name */
    public String f61497d;

    /* renamed from: e  reason: collision with root package name */
    public DownloadReceiver f61498e;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61499h;

    /* renamed from: i  reason: collision with root package name */
    public com.ss.android.socialbase.appdownloader.c.c f61500i;

    /* renamed from: j  reason: collision with root package name */
    public com.ss.android.socialbase.appdownloader.c.d f61501j;

    /* renamed from: k  reason: collision with root package name */
    public com.ss.android.socialbase.appdownloader.c.h f61502k;
    public com.ss.android.socialbase.appdownloader.c.g l;
    public m m;
    public com.ss.android.socialbase.appdownloader.c.f n;
    public j o;
    public ad p;
    public ag q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1522867436, "Lcom/ss/android/socialbase/appdownloader/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1522867436, "Lcom/ss/android/socialbase/appdownloader/d;");
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
        this.f61499h = false;
    }

    public static d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f61493b == null) {
                synchronized (d.class) {
                    if (f61493b == null) {
                        f61493b = new d();
                    }
                }
            }
            return f61493b;
        }
        return (d) invokeV.objValue;
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || f61495g) {
            return;
        }
        if (this.f61498e == null) {
            this.f61498e = new DownloadReceiver();
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.intent.action.BOOT_COMPLETED");
            intentFilter.addAction("android.ss.intent.action.DOWNLOAD_COMPLETE");
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(PackageChangedReceiver.ACTION_INSTALL);
            intentFilter2.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter2.addDataScheme("package");
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter3.addDataScheme("file");
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f61498e, intentFilter);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f61498e, intentFilter2);
            com.ss.android.socialbase.downloader.downloader.c.N().registerReceiver(this.f61498e, intentFilter3);
            f61495g = true;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65550, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        r.a(new r.b(this) { // from class: com.ss.android.socialbase.appdownloader.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.ss.android.socialbase.downloader.impls.r.b
            public void a(DownloadInfo downloadInfo, long j2, boolean z, int i2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{downloadInfo, Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                    RetryJobSchedulerService.a(downloadInfo, j2, z, i2);
                }
            }
        });
    }

    public com.ss.android.socialbase.appdownloader.c.d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f61501j : (com.ss.android.socialbase.appdownloader.c.d) invokeV.objValue;
    }

    public com.ss.android.socialbase.appdownloader.c.h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f61502k : (com.ss.android.socialbase.appdownloader.c.h) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f61497d : (String) invokeV.objValue;
    }

    public com.ss.android.socialbase.appdownloader.c.f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.n : (com.ss.android.socialbase.appdownloader.c.f) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? com.ss.android.socialbase.downloader.g.a.b().optInt("package_flag_config", 1) == 1 : invokeV.booleanValue;
    }

    public j g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.o : (j) invokeV.objValue;
    }

    public File h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getGlobalSaveDir() : (File) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.f61496c : (String) invokeV.objValue;
    }

    public m k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.m : (m) invokeV.objValue;
    }

    public com.ss.android.socialbase.appdownloader.c.g l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.l : (com.ss.android.socialbase.appdownloader.c.g) invokeV.objValue;
    }

    public com.ss.android.socialbase.downloader.downloader.r m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener() : (com.ss.android.socialbase.downloader.downloader.r) invokeV.objValue;
    }

    public ad n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p : (ad) invokeV.objValue;
    }

    public ag o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.q : (ag) invokeV.objValue;
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65546, this, context) == null) || context == null || f61494f) {
            return;
        }
        com.ss.android.socialbase.downloader.constants.e.a("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.c.a(context);
        com.ss.android.socialbase.downloader.downloader.c.a(new com.ss.android.socialbase.appdownloader.d.b());
        q();
        r();
        f61494f = true;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setDefaultSavePath(str);
        }
    }

    private DownloadInfo b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, this, context, str)) == null) {
            List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
            if (downloadInfoList != null) {
                for (DownloadInfo downloadInfo : downloadInfoList) {
                    if (downloadInfo != null && downloadInfo.isSavePathRedirected()) {
                        return downloadInfo;
                    }
                }
                return null;
            }
            return null;
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public com.ss.android.socialbase.appdownloader.c.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f61500i : (com.ss.android.socialbase.appdownloader.c.c) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.f61497d = str;
    }

    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jVar) == null) {
            this.o = jVar;
        }
    }

    public List<DownloadInfo> b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, context)) == null) ? Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive") : (List) invokeL.objValue;
    }

    @Deprecated
    public void a(Context context, String str, com.ss.android.socialbase.appdownloader.c.c cVar, com.ss.android.socialbase.appdownloader.c.d dVar, com.ss.android.socialbase.appdownloader.c.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, context, str, cVar, dVar, hVar) == null) {
            if (cVar != null) {
                this.f61500i = cVar;
            }
            if (dVar != null) {
                this.f61501j = dVar;
            }
            if (hVar != null) {
                this.f61502k = hVar;
            }
            c(context);
        }
    }

    public static boolean a(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, context, i2)) == null) ? c.a(context, i2, true) == 1 : invokeLI.booleanValue;
    }

    public void a(Context context, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, context, i2, i3) == null) {
            try {
                switch (i3) {
                    case -4:
                    case -1:
                        Downloader.getInstance(context).restart(i2);
                        break;
                    case -3:
                        c.a(context, i2, true);
                        break;
                    case -2:
                        Downloader.getInstance(context).resume(i2);
                        break;
                    case 0:
                    case 6:
                    default:
                        return;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        Downloader.getInstance(context).pause(i2);
                        break;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:39|(2:43|44)|47|(1:115)(1:54)|55|(2:61|(1:63)(19:64|65|(1:67)|68|(3:70|(2:73|71)|74)|75|76|77|(1:79)(1:112)|80|81|(6:86|(1:109)(1:90)|91|(1:95)|(1:(1:107)(1:106))|108)|110|(1:88)|109|91|(2:93|95)|(0)|108))|114|65|(0)|68|(0)|75|76|77|(0)(0)|80|81|(8:83|86|(0)|109|91|(0)|(0)|108)|110|(0)|109|91|(0)|(0)|108) */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013b A[Catch: all -> 0x038c, TryCatch #2 {all -> 0x038c, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x032c, B:95:0x0336, B:98:0x0341, B:100:0x0347, B:102:0x034d, B:104:0x0357, B:106:0x035d, B:107:0x036d), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014a A[Catch: all -> 0x038c, TryCatch #2 {all -> 0x038c, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x032c, B:95:0x0336, B:98:0x0341, B:100:0x0347, B:102:0x034d, B:104:0x0357, B:106:0x035d, B:107:0x036d), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0168 A[Catch: all -> 0x0189, TryCatch #1 {all -> 0x0189, blocks: (B:74:0x0162, B:76:0x0168, B:78:0x0173, B:77:0x016e), top: B:124:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016e A[Catch: all -> 0x0189, TryCatch #1 {all -> 0x0189, blocks: (B:74:0x0162, B:76:0x0168, B:78:0x0173, B:77:0x016e), top: B:124:0x0162 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019b A[Catch: all -> 0x038c, TryCatch #2 {all -> 0x038c, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x032c, B:95:0x0336, B:98:0x0341, B:100:0x0347, B:102:0x034d, B:104:0x0357, B:106:0x035d, B:107:0x036d), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x032c A[Catch: all -> 0x038c, TryCatch #2 {all -> 0x038c, blocks: (B:10:0x0014, B:13:0x0027, B:17:0x0030, B:19:0x003e, B:20:0x0046, B:22:0x004e, B:23:0x0057, B:26:0x005e, B:28:0x006a, B:31:0x0076, B:33:0x0084, B:34:0x0088, B:36:0x008f, B:39:0x0097, B:41:0x00ab, B:44:0x00c5, B:47:0x00de, B:49:0x00e4, B:53:0x00f5, B:55:0x00fb, B:57:0x0101, B:59:0x0107, B:61:0x010d, B:63:0x011b, B:64:0x0135, B:66:0x013b, B:67:0x0140, B:69:0x014a, B:70:0x014e, B:72:0x0154, B:73:0x015e, B:79:0x0189, B:81:0x018f, B:87:0x019b, B:89:0x01a8, B:91:0x01b8, B:93:0x032c, B:95:0x0336, B:98:0x0341, B:100:0x0347, B:102:0x034d, B:104:0x0357, B:106:0x035d, B:107:0x036d), top: B:126:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x033f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(f fVar) {
        InterceptResult invokeL;
        int i2;
        String str;
        n N;
        List<com.ss.android.socialbase.downloader.depend.m> A;
        String k2;
        boolean z;
        int i3;
        DownloadTask autoInstall;
        JSONObject jSONObject;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            if (fVar == null || fVar.getContext() == null) {
                return 0;
            }
            try {
                List<com.ss.android.socialbase.downloader.model.c> a2 = a(fVar.d());
                String a3 = fVar.a();
                if (TextUtils.isEmpty(a3)) {
                    return 0;
                }
                int s = fVar.s();
                boolean z2 = s == 0;
                String L = fVar.L();
                String b2 = fVar.b();
                if (TextUtils.isEmpty(L)) {
                    L = c.a(a3, b2, fVar.l(), z2);
                }
                if (L.length() > 255) {
                    L = L.substring(L.length() - 255);
                }
                if (TextUtils.isEmpty(b2)) {
                    b2 = L;
                }
                String l = fVar.l();
                if (L.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && !c.c(fVar.l())) {
                    l = "application/vnd.android.package-archive";
                }
                String c2 = fVar.c();
                if (TextUtils.isEmpty(fVar.c())) {
                    c2 = c.b();
                }
                String str2 = c2;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(L)) {
                    int a4 = com.ss.android.socialbase.downloader.downloader.c.a(a3, str2);
                    if (com.ss.android.socialbase.downloader.g.a.a(fVar.ad()).a("resume_task_override_settings") && (downloadInfo = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getDownloadInfo(a4)) != null) {
                        try {
                            fVar.a(new JSONObject(downloadInfo.getDownloadSettingString()));
                        } catch (Throwable unused) {
                        }
                    }
                    com.ss.android.socialbase.downloader.g.a.a(a4, fVar.ad());
                    boolean K = fVar.K();
                    boolean z3 = (com.ss.android.socialbase.downloader.g.a.a(a4).a("modify_force", 1) == 1 && !K && com.ss.android.socialbase.downloader.i.f.d(str2, L) && Downloader.getInstance(fVar.getContext()).getDownloadInfo(a4) == null) ? true : K;
                    com.ss.android.socialbase.appdownloader.e.b j2 = fVar.j();
                    if (j2 == null && (fVar.e() || fVar.f())) {
                        if (fVar.n() != null) {
                            j2 = new com.ss.android.socialbase.appdownloader.e.b(fVar.n());
                        } else {
                            i2 = a4;
                            str = str2;
                            j2 = new com.ss.android.socialbase.appdownloader.e.b(fVar.getContext(), a4, b2, str, L, fVar.k());
                            N = fVar.N();
                            if (N == null) {
                                N = new n(this) { // from class: com.ss.android.socialbase.appdownloader.d.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ d a;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i4 = newInitContext.flag;
                                            if ((i4 & 1) != 0) {
                                                int i5 = i4 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = this;
                                    }

                                    @Override // com.ss.android.socialbase.downloader.depend.n
                                    public void a(DownloadInfo downloadInfo2, BaseException baseException, int i4) {
                                        Interceptable interceptable2 = $ic;
                                        if (!(interceptable2 == null || interceptable2.invokeLLI(1048576, this, downloadInfo2, baseException, i4) == null) || this.a.f61502k == null) {
                                            return;
                                        }
                                        this.a.f61502k.a(downloadInfo2, baseException, i4);
                                    }
                                };
                            }
                            A = com.ss.android.socialbase.downloader.downloader.c.A();
                            if (!A.isEmpty()) {
                                for (com.ss.android.socialbase.downloader.depend.m mVar : A) {
                                    fVar.a(mVar);
                                }
                            }
                            k2 = fVar.k();
                            if (TextUtils.isEmpty(k2)) {
                                jSONObject = new JSONObject(k2);
                            } else {
                                jSONObject = new JSONObject();
                            }
                            jSONObject.put("auto_install_with_notification", fVar.g());
                            jSONObject.put("auto_install_without_notification", fVar.f());
                            String jSONObject2 = jSONObject.toString();
                            if (!fVar.e() && !fVar.f()) {
                                z = false;
                                if (z || com.ss.android.socialbase.downloader.g.a.a(i2).b("enable_notification_ui") < 1) {
                                    i3 = i2;
                                } else {
                                    i3 = i2;
                                    com.ss.android.socialbase.appdownloader.e.c.a().a(i3, fVar.aa());
                                }
                                autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z).extra(jSONObject2).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j2).notificationEventListener(a(fVar.O())).force(z3).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                                if (autoInstall != null && !fVar.R().isEmpty()) {
                                    autoInstall.setDownloadCompleteHandlers(fVar.R());
                                }
                                if (autoInstall != null) {
                                    if (z && fVar.S() && fVar.getActivity() != null && !fVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.e.d.a()) {
                                        com.ss.android.socialbase.appdownloader.e.d.a(fVar.getActivity(), new com.ss.android.socialbase.appdownloader.c.n(this, b2, autoInstall, s, z2) { // from class: com.ss.android.socialbase.appdownloader.d.3
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ String a;

                                            /* renamed from: b  reason: collision with root package name */
                                            public final /* synthetic */ DownloadTask f61503b;

                                            /* renamed from: c  reason: collision with root package name */
                                            public final /* synthetic */ int f61504c;

                                            /* renamed from: d  reason: collision with root package name */
                                            public final /* synthetic */ boolean f61505d;

                                            /* renamed from: e  reason: collision with root package name */
                                            public final /* synthetic */ d f61506e;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this, b2, autoInstall, Integer.valueOf(s), Boolean.valueOf(z2)};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i4 = newInitContext.flag;
                                                    if ((i4 & 1) != 0) {
                                                        int i5 = i4 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.f61506e = this;
                                                this.a = b2;
                                                this.f61503b = autoInstall;
                                                this.f61504c = s;
                                                this.f61505d = z2;
                                            }

                                            @Override // com.ss.android.socialbase.appdownloader.c.n
                                            public void a() {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                                    String str3 = d.a;
                                                    com.ss.android.socialbase.downloader.c.a.b(str3, "notification permission granted, start download :" + this.a);
                                                    this.f61506e.a(this.f61503b, this.f61504c, this.f61505d);
                                                }
                                            }

                                            @Override // com.ss.android.socialbase.appdownloader.c.n
                                            public void b() {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                                    String str3 = d.a;
                                                    com.ss.android.socialbase.downloader.c.a.b(str3, "notification permission denied, start download :" + this.a);
                                                    this.f61506e.a(this.f61503b, this.f61504c, this.f61505d);
                                                }
                                            }
                                        });
                                    } else {
                                        String str3 = a;
                                        com.ss.android.socialbase.downloader.c.a.b(str3, "notification permission need not request, start download :" + b2);
                                        a(autoInstall, s, z2);
                                        autoInstall.getDownloadInfo();
                                    }
                                }
                                return i3;
                            }
                            z = true;
                            if (z) {
                            }
                            i3 = i2;
                            autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z).extra(jSONObject2).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j2).notificationEventListener(a(fVar.O())).force(z3).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                            if (autoInstall != null) {
                                autoInstall.setDownloadCompleteHandlers(fVar.R());
                            }
                            if (autoInstall != null) {
                            }
                            return i3;
                        }
                    }
                    i2 = a4;
                    str = str2;
                    N = fVar.N();
                    if (N == null) {
                    }
                    A = com.ss.android.socialbase.downloader.downloader.c.A();
                    if (!A.isEmpty()) {
                    }
                    k2 = fVar.k();
                    if (TextUtils.isEmpty(k2)) {
                    }
                    jSONObject.put("auto_install_with_notification", fVar.g());
                    jSONObject.put("auto_install_without_notification", fVar.f());
                    String jSONObject22 = jSONObject.toString();
                    if (!fVar.e()) {
                        z = false;
                        if (z) {
                        }
                        i3 = i2;
                        autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z).extra(jSONObject22).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j2).notificationEventListener(a(fVar.O())).force(z3).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                        if (autoInstall != null) {
                        }
                        if (autoInstall != null) {
                        }
                        return i3;
                    }
                    z = true;
                    if (z) {
                    }
                    i3 = i2;
                    autoInstall = com.ss.android.socialbase.downloader.downloader.b.with(fVar.getContext()).url(a3).backUpUrls(fVar.ab()).name(L).title(b2).savePath(str).onlyWifi(fVar.h()).extraHeaders(a2).depend(N).retryCount(fVar.w()).backUpUrlRetryCount(fVar.x()).showNotification(z).extra(jSONObject22).mimeType(l).minProgressTimeMsInterval(fVar.D()).maxProgressCount(fVar.E()).mainThreadListener(fVar.i()).notificationListener(j2).notificationEventListener(a(fVar.O())).force(z3).autoResumed(fVar.q()).showNotificationForAutoResumed(fVar.r()).chunkStategy(fVar.o()).chunkAdjustCalculator(fVar.p()).needHttpsToHttpRetry(fVar.m()).packageName(fVar.t()).md5(fVar.u()).expectFileLength(fVar.v()).needRetryDelay(fVar.y()).retryDelayTimeArray(fVar.z()).needDefaultHttpServiceBackUp(fVar.A()).needReuseFirstConnection(fVar.B()).needReuseChunkRunnable(fVar.F()).needIndependentProcess(fVar.G()).enqueueType(fVar.J()).monitorDepend(fVar.M()).retryDelayTimeCalculator(fVar.C()).headConnectionAvailable(fVar.H()).fileUriProvider(fVar.P()).diskSpaceHandler(fVar.ac()).needChunkDowngradeRetry(fVar.I()).notificationClickCallback(fVar.Q()).downloadSetting(fVar.ad()).iconUrl(fVar.aa()).needSDKMonitor(fVar.V()).monitorScene(fVar.W()).extraMonitorStatus(fVar.X()).executorGroup(fVar.T()).throttleNetSpeed(fVar.U()).distinctDirectory(fVar.Y()).setAutoInstall(fVar.Z());
                    if (autoInstall != null) {
                    }
                    if (autoInstall != null) {
                    }
                    return i3;
                }
                return 0;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.d.a.a(fVar.M(), (DownloadInfo) null, new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(th, "addDownloadTask")), 0);
                com.ss.android.socialbase.downloader.c.a.e(a, String.format("add download task error:%s", th));
                return 0;
            }
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadTask downloadTask, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, this, new Object[]{downloadTask, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            downloadInfo.setAntiHijackErrorCode(i2);
        }
        if (downloadInfo == null || !z) {
            return;
        }
        downloadInfo.setSavePathRedirected(z);
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            if (list != null && list.size() > 0) {
                for (com.ss.android.socialbase.downloader.model.c cVar : list) {
                    if (cVar != null && !TextUtils.isEmpty(cVar.a()) && !TextUtils.isEmpty(cVar.b())) {
                        if (cVar.a().equals("User-Agent")) {
                            z = true;
                        }
                        arrayList.add(new com.ss.android.socialbase.downloader.model.c(cVar.a(), cVar.b()));
                    }
                }
            }
            if (!z) {
                arrayList.add(new com.ss.android.socialbase.downloader.model.c("User-Agent", com.ss.android.socialbase.appdownloader.b.a.a));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) ? (TextUtils.isEmpty(str) || !str.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) || c.c(str2)) ? str2 : "application/vnd.android.package-archive" : (String) invokeLL.objValue;
    }

    private z a(com.ss.android.socialbase.appdownloader.c.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            return new z(this, eVar) { // from class: com.ss.android.socialbase.appdownloader.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.socialbase.appdownloader.c.e a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f61507b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, eVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61507b = this;
                    this.a = eVar;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public void a(int i2, DownloadInfo downloadInfo, String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), downloadInfo, str, str2}) == null) {
                        if (i2 != 1 && i2 != 3) {
                            switch (i2) {
                                case 5:
                                case 6:
                                case 7:
                                    break;
                                case 8:
                                    this.a.a(i2, downloadInfo.getPackageName(), str, str2);
                                    return;
                                case 9:
                                    this.a.a(com.ss.android.socialbase.downloader.downloader.c.N(), str);
                                    return;
                                case 10:
                                    this.a.a(downloadInfo);
                                    return;
                                default:
                                    return;
                            }
                        }
                        this.a.a(i2, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public boolean a(boolean z) {
                    InterceptResult invokeZ;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeZ = interceptable2.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) ? this.a.a(z) : invokeZ.booleanValue;
                }

                @Override // com.ss.android.socialbase.downloader.depend.z
                public String a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.a.a() : (String) invokeV.objValue;
                }
            };
        }
        return (z) invokeL.objValue;
    }

    public DownloadInfo a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    DownloadInfo a2 = a(context, str, h());
                    if (a2 == null) {
                        a2 = a(context, str, context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
                    }
                    if (a2 == null) {
                        a2 = a(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                    }
                    if (a2 == null) {
                        a2 = a(context, str, context.getFilesDir());
                    }
                    return (a2 == null && com.ss.android.socialbase.downloader.g.a.c().a("get_download_info_by_list")) ? b(context, str) : a2;
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.c.a.b(a, String.format("getAppDownloadInfo error:%s", th.getMessage()));
                }
            }
            return null;
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    private DownloadInfo a(Context context, String str, File file) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, file)) == null) {
            if (context == null || TextUtils.isEmpty(str) || file == null) {
                return null;
            }
            return Downloader.getInstance(context).getDownloadInfo(str, file.getAbsolutePath());
        }
        return (DownloadInfo) invokeLLL.objValue;
    }

    public List<DownloadInfo> a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive") : (List) invokeL.objValue;
    }

    public void a(com.ss.android.socialbase.appdownloader.c.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
            this.l = gVar;
        }
    }

    public void a(com.ss.android.socialbase.downloader.downloader.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rVar) == null) {
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).setReserveWifiStatusListener(rVar);
        }
    }

    public void a(ad adVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, adVar) == null) {
            this.p = adVar;
        }
    }

    public void a(ag agVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, agVar) == null) {
            this.q = agVar;
        }
    }
}
