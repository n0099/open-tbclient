package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.c;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.g;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e implements f, m.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "e";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final m f61292b;

    /* renamed from: c  reason: collision with root package name */
    public g f61293c;

    /* renamed from: d  reason: collision with root package name */
    public d f61294d;

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<Context> f61295e;

    /* renamed from: f  reason: collision with root package name */
    public final Map<Integer, Object> f61296f;

    /* renamed from: g  reason: collision with root package name */
    public DownloadShortInfo f61297g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadInfo f61298h;

    /* renamed from: i  reason: collision with root package name */
    public c f61299i;

    /* renamed from: j  reason: collision with root package name */
    public final IDownloadListener f61300j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f61301k;
    public long l;
    public long m;
    public DownloadModel n;
    public DownloadEventConfig o;
    public DownloadController p;
    public SoftReference<u> q;
    public boolean r;
    public final boolean s;
    public SoftReference<IDownloadButtonClickListener> t;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(long j2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2001018285, "Lcom/ss/android/downloadlib/addownload/e;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2001018285, "Lcom/ss/android/downloadlib/addownload/e;");
        }
    }

    public e() {
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
        this.f61292b = new m(Looper.getMainLooper(), this);
        this.f61296f = new ConcurrentHashMap();
        this.f61300j = new g.a(this.f61292b);
        this.m = -1L;
        this.n = null;
        this.o = null;
        this.p = null;
        this.f61293c = new g(this);
        this.f61294d = new d(this.f61292b);
        this.s = com.ss.android.socialbase.downloader.g.a.c().a("ttdownloader_callback_twice");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            WeakReference<Context> weakReference = this.f61295e;
            if (weakReference != null && weakReference.get() != null) {
                return this.f61295e.get();
            }
            return j.getContext();
        }
        return (Context) invokeV.objValue;
    }

    private void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            SoftReference<u> softReference = this.q;
            if (softReference != null && softReference.get() != null) {
                this.q.get().a(this.n, k(), l());
                this.q = null;
                return;
            }
            j.b().a(getContext(), this.n, l(), k());
        }
    }

    @NonNull
    private DownloadEventConfig k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            DownloadEventConfig downloadEventConfig = this.o;
            return downloadEventConfig == null ? new c.a().a() : downloadEventConfig;
        }
        return (DownloadEventConfig) invokeV.objValue;
    }

    @NonNull
    private DownloadController l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            if (this.p == null) {
                this.p = new com.ss.android.download.api.download.b();
            }
            return this.p;
        }
        return (DownloadController) invokeV.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            com.ss.android.downloadlib.g.k.a(a, "pICD", null);
            if (this.f61293c.d(this.f61298h)) {
                com.ss.android.downloadlib.g.k.a(a, "pICD BC", null);
                e(false);
                return;
            }
            com.ss.android.downloadlib.g.k.a(a, "pICD IC", null);
            j();
        }
    }

    private boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
                DownloadInfo downloadInfo = this.f61298h;
                if (downloadInfo == null) {
                    return true;
                }
                if ((downloadInfo.getStatus() == -3 && this.f61298h.getCurBytes() <= 0) || this.f61298h.getStatus() == 0 || this.f61298h.getStatus() == -4) {
                    return true;
                }
                return com.ss.android.socialbase.downloader.i.f.a(this.f61298h.getStatus(), this.f61298h.getSavePath(), this.f61298h.getName());
            }
            DownloadInfo downloadInfo2 = this.f61298h;
            if (downloadInfo2 == null) {
                return true;
            }
            return !(downloadInfo2.getStatus() == -3 || Downloader.getInstance(j.getContext()).canResume(this.f61298h.getId())) || this.f61298h.getStatus() == 0;
        }
        return invokeV.booleanValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65565, this) == null) {
            c cVar = this.f61299i;
            if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f61299i.cancel(true);
            }
            c cVar2 = new c();
            this.f61299i = cVar2;
            com.ss.android.downloadlib.g.b.a(cVar2, this.n.getDownloadUrl(), this.n.getPackageName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            if (this.f61297g == null) {
                this.f61297g = new DownloadShortInfo();
            }
            return this.f61297g;
        }
        return (DownloadShortInfo) invokeV.objValue;
    }

    private boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            SoftReference<IDownloadButtonClickListener> softReference = this.t;
            if (softReference != null && softReference.get() != null) {
                this.t.get().handleComplianceDialog(true);
                this.t = null;
                return true;
            }
            com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65554, this, z) == null) {
            for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f61296f)) {
                downloadStatusChangeListener.onDownloadStart(this.n, l());
            }
            int a2 = this.f61293c.a(j.getContext(), this.f61300j);
            String str = a;
            com.ss.android.downloadlib.g.k.a(str, "beginDown id:" + a2, null);
            if (a2 != 0) {
                if (this.f61298h != null && !com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
                    this.f61293c.a(this.f61298h, false);
                } else if (z) {
                    this.f61293c.a();
                }
            } else {
                DownloadInfo a3 = new DownloadInfo.a(this.n.getDownloadUrl()).a();
                a3.setStatus(-1);
                a(a3);
                com.ss.android.downloadlib.d.a.a().a(this.m, new BaseException(2, "start download failed, id=0"));
                com.ss.android.downloadlib.e.c.a().b("beginDown");
            }
            if (this.f61293c.a(c())) {
                String str2 = a;
                com.ss.android.downloadlib.g.k.a(str2, "beginDown IC id:" + a2, null);
                j();
            }
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            DownloadInfo downloadInfo = this.f61298h;
            return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.l : invokeV.longValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? j.i().optInt("quick_app_enable_switch", 0) == 0 && this.n.getQuickAppModel() != null && !TextUtils.isEmpty(this.n.getQuickAppModel().a()) && com.ss.android.downloadlib.addownload.c.a(this.f61298h) && com.ss.android.downloadlib.g.l.a(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.n.getQuickAppModel().a()))) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f61292b.post(new Runnable(this) { // from class: com.ss.android.downloadlib.addownload.e.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ e a;

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

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.a.f61296f)) {
                            downloadStatusChangeListener.onInstalled(this.a.p());
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            com.ss.android.downloadlib.addownload.b.f.a().f(this.m);
        }
    }

    private boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, this, i2)) == null) {
            if (e()) {
                int i3 = -1;
                String a2 = this.n.getQuickAppModel().a();
                if (i2 == 1) {
                    i3 = 5;
                } else if (i2 == 2) {
                    i3 = 4;
                }
                DownloadModel downloadModel = this.n;
                if (downloadModel instanceof AdDownloadModel) {
                    ((AdDownloadModel) downloadModel).setFunnelType(3);
                }
                boolean c2 = com.ss.android.downloadlib.g.i.c(j.getContext(), a2);
                if (c2) {
                    com.ss.android.downloadlib.d.a.a().a(this.m, i2);
                    Message obtain = Message.obtain();
                    obtain.what = i3;
                    obtain.obj = Long.valueOf(this.n.getId());
                    com.ss.android.downloadlib.addownload.c.a().a(this, i3, this.n);
                } else {
                    com.ss.android.downloadlib.d.a.a().a(this.m, false, 0);
                }
                return c2;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            if (com.ss.android.downloadlib.g.e.b(this.n).b("notification_opt_2") == 1 && this.f61298h != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(this.f61298h.getId());
            }
            e(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, this, z) == null) {
            this.f61294d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, k(), l()));
            this.f61294d.a(0, 0L, 0L, new a(this, z) { // from class: com.ss.android.downloadlib.addownload.e.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f61309b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61309b = this;
                    this.a = z;
                }

                @Override // com.ss.android.downloadlib.addownload.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f61309b.f61294d.a()) {
                        return;
                    }
                    this.f61309b.g(this.a);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            if (context != null) {
                this.f61295e = new WeakReference<>(context);
            }
            j.b(context);
            return this;
        }
        return (e) invokeL.objValue;
    }

    /* loaded from: classes2.dex */
    public class c extends AsyncTask<String, Void, DownloadInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                DownloadInfo downloadInfo = null;
                if (strArr != null) {
                    if (strArr.length < 1 || !TextUtils.isEmpty(strArr[0])) {
                        String str = strArr[0];
                        if (this.a.n != null && !TextUtils.isEmpty(this.a.n.getFilePath())) {
                            downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(str, this.a.n.getFilePath());
                        }
                        return downloadInfo == null ? com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), str) : downloadInfo;
                    }
                    return null;
                }
                return null;
            }
            return (DownloadInfo) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(DownloadInfo downloadInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                super.onPostExecute(downloadInfo);
                if (isCancelled() || this.a.n == null) {
                    return;
                }
                try {
                    com.ss.android.downloadlib.addownload.b.c a = com.ss.android.downloadlib.g.l.a(this.a.n.getPackageName(), this.a.n.getVersionCode(), this.a.n.getVersionName());
                    com.ss.android.downloadlib.addownload.b.h.a().a(this.a.n.getVersionCode(), a.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                    boolean a2 = a.a();
                    if (downloadInfo != null && downloadInfo.getId() != 0 && (a2 || !Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                        Downloader.getInstance(j.getContext()).removeTaskMainListener(downloadInfo.getId());
                        if (this.a.f61298h == null || this.a.f61298h.getStatus() != -4) {
                            this.a.f61298h = downloadInfo;
                            if (this.a.s) {
                                Downloader.getInstance(j.getContext()).setMainThreadListener(this.a.f61298h.getId(), this.a.f61300j, false);
                            } else {
                                Downloader.getInstance(j.getContext()).setMainThreadListener(this.a.f61298h.getId(), this.a.f61300j);
                            }
                        } else {
                            this.a.f61298h = null;
                        }
                        this.a.f61293c.a(this.a.f61298h, this.a.p(), g.a(this.a.f61296f));
                    } else {
                        if (downloadInfo != null && Downloader.getInstance(j.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                            com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                            this.a.f61298h = null;
                        }
                        if (this.a.f61298h != null) {
                            Downloader.getInstance(j.getContext()).removeTaskMainListener(this.a.f61298h.getId());
                            if (this.a.s) {
                                Downloader.getInstance(this.a.getContext()).setMainThreadListener(this.a.f61298h.getId(), this.a.f61300j, false);
                            } else {
                                Downloader.getInstance(this.a.getContext()).setMainThreadListener(this.a.f61298h.getId(), this.a.f61300j);
                            }
                        }
                        if (a2) {
                            this.a.f61298h = new DownloadInfo.a(this.a.n.getDownloadUrl()).a();
                            this.a.f61298h.setStatus(-3);
                            this.a.f61293c.a(this.a.f61298h, this.a.p(), g.a(this.a.f61296f));
                        } else {
                            for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.a.f61296f)) {
                                downloadStatusChangeListener.onIdle();
                            }
                            this.a.f61298h = null;
                        }
                    }
                    this.a.f61293c.c(this.a.f61298h);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void e(boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, this, z) == null) {
            com.ss.android.downloadlib.g.k.a(a, "pBCD", null);
            if (n()) {
                com.ss.android.downloadlib.addownload.b.e e2 = com.ss.android.downloadlib.addownload.b.f.a().e(this.m);
                DownloadInfo downloadInfo = this.f61298h;
                if (downloadInfo != null && downloadInfo.getStatus() != 0) {
                    a(z, true);
                    return;
                } else if (this.r) {
                    if (this.n.isAd() && this.t != null) {
                        if (q() && (downloadController2 = e2.f61225d) != null && downloadController2.isAutoDownloadOnCardShow()) {
                            a(z, true);
                            return;
                        }
                        return;
                    }
                    a(z, true);
                    return;
                } else if (this.n.isAd() && (downloadController = e2.f61225d) != null && downloadController.enableShowComplianceDialog() && e2.f61223b != null && com.ss.android.downloadlib.addownload.compliance.b.a().a(e2.f61223b) && com.ss.android.downloadlib.addownload.compliance.b.a().a(e2)) {
                    return;
                } else {
                    a(z, true);
                    return;
                }
            }
            String str = a;
            com.ss.android.downloadlib.g.k.a(str, "pBCD continue download, status:" + this.f61298h.getStatus(), null);
            DownloadInfo downloadInfo2 = this.f61298h;
            if (downloadInfo2 != null && (downloadModel = this.n) != null) {
                downloadInfo2.setOnlyWifi(downloadModel.isNeedWifi());
            }
            int status = this.f61298h.getStatus();
            int id = this.f61298h.getId();
            com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(this.f61298h);
            if (status != -2 && status != -1) {
                if (l.a(status)) {
                    if (this.n.enablePause()) {
                        this.f61294d.a(true);
                        com.ss.android.downloadlib.c.h.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.m));
                        com.ss.android.downloadlib.addownload.d.f.a().a(a2, status, new com.ss.android.downloadlib.addownload.d.c(this, z, a2, id, status) { // from class: com.ss.android.downloadlib.addownload.e.3
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ boolean a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ com.ss.android.downloadad.api.a.b f61304b;

                            /* renamed from: c  reason: collision with root package name */
                            public final /* synthetic */ int f61305c;

                            /* renamed from: d  reason: collision with root package name */
                            public final /* synthetic */ int f61306d;

                            /* renamed from: e  reason: collision with root package name */
                            public final /* synthetic */ e f61307e;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, Boolean.valueOf(z), a2, Integer.valueOf(id), Integer.valueOf(status)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61307e = this;
                                this.a = z;
                                this.f61304b = a2;
                                this.f61305c = id;
                                this.f61306d = status;
                            }

                            @Override // com.ss.android.downloadlib.addownload.d.c
                            public void a(com.ss.android.downloadad.api.a.b bVar) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                                    this.f61307e.f61293c.a(this.f61307e.f61298h, this.a);
                                    if (com.ss.android.socialbase.downloader.i.f.b(j.getContext()) && this.f61307e.f61298h.isPauseReserveOnWifi()) {
                                        this.f61307e.f61298h.stopPauseReserveOnWifi();
                                        com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", this.f61304b);
                                        return;
                                    }
                                    e eVar = this.f61307e;
                                    eVar.a(this.f61305c, this.f61306d, eVar.f61298h);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
                this.f61293c.a(this.f61298h, z);
                a(id, status, this.f61298h);
                return;
            }
            this.f61293c.a(this.f61298h, z);
            if (a2 != null) {
                a2.h(System.currentTimeMillis());
                a2.i(this.f61298h.getCurBytes());
            }
            this.f61298h.setDownloadFromReserveWifi(false);
            this.f61294d.a(new com.ss.android.downloadlib.addownload.b.e(this.m, this.n, k(), l()));
            this.f61294d.a(id, this.f61298h.getCurBytes(), this.f61298h.getTotalBytes(), new a(this, id, status) { // from class: com.ss.android.downloadlib.addownload.e.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ int a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ int f61302b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ e f61303c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(id), Integer.valueOf(status)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61303c = this;
                    this.a = id;
                    this.f61302b = status;
                }

                @Override // com.ss.android.downloadlib.addownload.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f61303c.f61294d.a()) {
                        return;
                    }
                    e eVar = this.f61303c;
                    eVar.a(this.a, this.f61302b, eVar.f61298h);
                }
            });
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, downloadStatusChangeListener)) == null) {
            if (downloadStatusChangeListener != null) {
                if (j.i().optInt("back_use_softref_listener") == 1) {
                    this.f61296f.put(Integer.valueOf(i2), downloadStatusChangeListener);
                } else {
                    this.f61296f.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
                }
            }
            return this;
        }
        return (e) invokeIL.objValue;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f61301k : invokeV.booleanValue;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                throw new IllegalArgumentException("error actionType");
            }
            this.f61293c.a(this.m);
            if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.m).y()) {
                com.ss.android.downloadlib.e.c.a().a("handleDownload ModelBox !isStrictValid");
            }
            if (this.f61293c.a(getContext(), i2, this.r)) {
                return;
            }
            boolean c2 = c(i2);
            if (i2 == 1) {
                if (c2) {
                    return;
                }
                String str = a;
                com.ss.android.downloadlib.g.k.a(str, "handleDownload id:" + this.m + ",pIC:", null);
                c(true);
            } else if (i2 == 2 && !c2) {
                String str2 = a;
                com.ss.android.downloadlib.g.k.a(str2, "handleDownload id:" + this.m + ",pBC:", null);
                b(true);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadModel downloadModel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadModel)) == null) {
            if (downloadModel != null) {
                if (downloadModel.isAd()) {
                    if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                        com.ss.android.downloadlib.e.c.a().a("setDownloadModel ad error");
                    }
                } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                    com.ss.android.downloadlib.e.c.a().a(false, "setDownloadModel id=0");
                    if (com.ss.android.socialbase.downloader.g.a.c().a("fix_model_id")) {
                        ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                    }
                }
                com.ss.android.downloadlib.addownload.b.f.a().a(downloadModel);
                this.m = downloadModel.getId();
                this.n = downloadModel;
                if (h.a(downloadModel)) {
                    ((AdDownloadModel) downloadModel).setExtraValue(3L);
                    com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.m);
                    if (d2 != null && d2.l() != 3) {
                        d2.e(3L);
                        com.ss.android.downloadlib.addownload.b.i.a().a(d2);
                    }
                }
            }
            return this;
        }
        return (e) invokeL.objValue;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            if (z) {
                com.ss.android.downloadlib.d.a.a().a(this.m, 1);
            }
            m();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.f61296f.size() == 0) {
            return;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : g.a(this.f61296f)) {
            downloadStatusChangeListener.onIdle();
        }
        DownloadInfo downloadInfo = this.f61298h;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            d(z);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadController downloadController) {
        InterceptResult invokeL;
        JSONObject extra;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadController)) == null) {
            this.p = downloadController;
            if (com.ss.android.downloadlib.g.e.b(this.n).b("force_auto_open") == 1) {
                l().setLinkMode(1);
            }
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_show_dialog") && (extra = this.n.getExtra()) != null && extra.optInt("subprocess") > 0) {
                l().setEnableNewActivity(false);
            }
            com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
            return this;
        }
        return (e) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ss.android.downloadlib.addownload.f
    /* renamed from: a */
    public e b(DownloadEventConfig downloadEventConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, downloadEventConfig)) == null) {
            this.o = downloadEventConfig;
            this.r = k().getDownloadScene() == 0;
            com.ss.android.downloadlib.addownload.b.f.a().a(this.m, k());
            return this;
        }
        return (e) invokeL.objValue;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(u uVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uVar)) == null) {
            if (uVar == null) {
                this.q = null;
            } else {
                this.q = new SoftReference<>(uVar);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f61301k = true;
            com.ss.android.downloadlib.addownload.b.f.a().a(this.m, k());
            com.ss.android.downloadlib.addownload.b.f.a().a(this.m, l());
            this.f61293c.a(this.m);
            o();
            if (j.i().optInt("enable_empty_listener", 1) == 1 && this.f61296f.get(Integer.MIN_VALUE) == null) {
                b(Integer.MIN_VALUE, new com.ss.android.download.api.config.a());
            }
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (i2 == 0) {
                this.f61296f.clear();
            } else {
                this.f61296f.remove(Integer.valueOf(i2));
            }
            if (this.f61296f.isEmpty()) {
                this.f61301k = false;
                this.l = System.currentTimeMillis();
                if (this.f61298h != null) {
                    Downloader.getInstance(j.getContext()).removeTaskMainListener(this.f61298h.getId());
                }
                c cVar = this.f61299i;
                if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                    this.f61299i.cancel(true);
                }
                this.f61293c.a(this.f61298h);
                String str = a;
                StringBuilder sb = new StringBuilder();
                sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
                DownloadInfo downloadInfo = this.f61298h;
                sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
                com.ss.android.downloadlib.g.k.a(str, sb.toString(), null);
                this.f61292b.removeCallbacksAndMessages(null);
                this.f61297g = null;
                this.f61298h = null;
                return true;
            }
            if (this.f61296f.size() == 1 && this.f61296f.containsKey(Integer.MIN_VALUE)) {
                this.f61293c.b(this.f61298h);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.f61298h == null) {
            return;
        }
        if (z) {
            com.ss.android.socialbase.appdownloader.c.d b2 = com.ss.android.socialbase.appdownloader.d.j().b();
            if (b2 != null) {
                b2.a(this.f61298h);
            }
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(this.f61298h.getId(), true);
            return;
        }
        Intent intent = new Intent(j.getContext(), DownloadHandlerService.class);
        intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
        intent.putExtra("extra_click_download_ids", this.f61298h.getId());
        j.getContext().startService(intent);
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (j2 != 0) {
                DownloadModel a2 = com.ss.android.downloadlib.addownload.b.f.a().a(j2);
                if (a2 != null) {
                    this.n = a2;
                    this.m = j2;
                    this.f61293c.a(j2);
                }
            } else {
                com.ss.android.downloadlib.e.c.a().a(false, "setModelId");
            }
            return this;
        }
        return (f) invokeJ.objValue;
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, message) == null) && message != null && this.f61301k && message.what == 3) {
            this.f61298h = (DownloadInfo) message.obj;
            this.f61293c.a(message, p(), this.f61296f);
        }
    }

    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                com.ss.android.downloadlib.d.a.a().a(this.m, 2);
            }
            if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE") && !l().enableNewActivity()) {
                this.n.setFilePath(this.f61293c.b());
            }
            if (com.ss.android.downloadlib.g.e.c(this.n) == 0) {
                com.ss.android.downloadlib.g.k.a(a, "pBCD not start", null);
                this.f61293c.a(new s(this, z2) { // from class: com.ss.android.downloadlib.addownload.e.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ e f61308b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61308b = this;
                        this.a = z2;
                    }

                    @Override // com.ss.android.download.api.config.s
                    public void a() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            com.ss.android.downloadlib.g.k.a(e.a, "pBCD start download", null);
                            this.f61308b.f(this.a);
                        }
                    }

                    @Override // com.ss.android.download.api.config.s
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                            com.ss.android.downloadlib.g.k.a(e.a, "pBCD onDenied", null);
                        }
                    }
                });
                return;
            }
            f(z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, i3, downloadInfo) == null) {
            if (com.ss.android.socialbase.downloader.g.a.c().a("fix_click_start")) {
                if (i3 != -3 && !com.ss.android.socialbase.downloader.downloader.d.a().e(i2)) {
                    a(false, false);
                    return;
                } else {
                    com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
                    return;
                }
            }
            com.ss.android.socialbase.appdownloader.d.j().a(j.getContext(), i2, i3);
        }
    }

    private void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, downloadInfo) == null) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            this.f61292b.sendMessage(obtain);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.f
    public f a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iDownloadButtonClickListener)) == null) {
            if (iDownloadButtonClickListener == null) {
                this.t = null;
            } else {
                this.t = new SoftReference<>(iDownloadButtonClickListener);
            }
            return this;
        }
        return (f) invokeL.objValue;
    }
}
