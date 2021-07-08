package d.l.a.d.b.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.MainThread;
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
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.a.a.c.k;
import d.l.a.a.a.f.c;
import d.l.a.d.b.c;
import d.l.a.d.b.l;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: e  reason: collision with root package name */
    public static final String f71216e = "a";

    /* renamed from: f  reason: collision with root package name */
    public static a f71217f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public CopyOnWriteArrayList<c.b> f71218a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71219b;

    /* renamed from: c  reason: collision with root package name */
    public String f71220c;

    /* renamed from: d  reason: collision with root package name */
    public d.l.a.d.b.a.b f71221d;

    /* renamed from: d.l.a.d.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C2016a implements c.InterfaceC2012c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.l.a.b.a.c.b f71222a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f71223b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c.b f71224c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f71225d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f71226e;

        public C2016a(a aVar, d.l.a.b.a.c.b bVar, Context context, c.b bVar2, b bVar3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, context, bVar2, bVar3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71226e = aVar;
            this.f71222a = bVar;
            this.f71223b = context;
            this.f71224c = bVar2;
            this.f71225d = bVar3;
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2012c
        public void a(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                e.c.a().v("backdialog_install", this.f71222a);
                d.l.a.e.a.e.t(this.f71223b, (int) this.f71224c.f71246a);
                dialogInterface.dismiss();
            }
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2012c
        public void b(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                e.c.a().v("backdialog_exit", this.f71222a);
                b bVar = this.f71225d;
                if (bVar != null) {
                    bVar.a();
                }
                this.f71226e.j("");
                dialogInterface.dismiss();
            }
        }

        @Override // d.l.a.a.a.f.c.InterfaceC2012c
        public void c(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                this.f71226e.j("");
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(56609928, "Ld/l/a/d/b/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(56609928, "Ld/l/a/d/b/a/a;");
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
        this.f71219b = false;
        d.l.a.d.b.a.b bVar = new d.l.a.d.b.a.b();
        this.f71221d = bVar;
        this.f71218a = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f71217f == null) {
                f71217f = new a();
            }
            return f71217f;
        }
        return (a) invokeV.objValue;
    }

    public DownloadInfo b(Context context) {
        InterceptResult invokeL;
        long k;
        List<DownloadInfo> p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            DownloadInfo downloadInfo = null;
            try {
                k = h.b(context).k();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (l.v().optInt("enable_miniapp_dialog", 0) != 0 && (p = d.l.a.e.b.g.a.H(context).p("application/vnd.android.package-archive")) != null && !p.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : p) {
                    if (downloadInfo2 != null && !h.r.G(context, downloadInfo2.getPackageName()) && h.r.w(downloadInfo2.getTargetFilePath())) {
                        long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (lastModified >= k && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j == 0 || lastModified > j)) {
                                    downloadInfo = downloadInfo2;
                                    j = lastModified;
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                return downloadInfo;
            }
            return null;
        }
        return (DownloadInfo) invokeL.objValue;
    }

    public void c(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, str4}) == null) {
            for (int i2 = 0; i2 < this.f71218a.size(); i2++) {
                c.b bVar = this.f71218a.get(i2);
                if (bVar != null && bVar.f71247b == j2) {
                    this.f71218a.set(i2, new c.b(j, j2, j3, str, str2, str3, str4));
                    this.f71221d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f71218a);
                    return;
                }
            }
            this.f71218a.add(new c.b(j, j2, j3, str, str2, str3, str4));
            this.f71221d.b("sp_ad_install_back_dialog", "key_uninstalled_list", this.f71218a);
        }
    }

    public final void d(Context context, c.b bVar, b bVar2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, bVar, bVar2, Boolean.valueOf(z)}) == null) {
            d.l.a.b.a.c.b u = c.g.e().u(bVar.f71247b);
            if (u == null) {
                f.e.b().d("showBackInstallDialog nativeModel null");
                return;
            }
            k p = l.p();
            c.b bVar3 = new c.b(context);
            bVar3.e(z ? "应用安装确认" : "退出确认");
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(bVar.f71250e) ? "刚刚下载的应用" : bVar.f71250e;
            bVar3.h(String.format("%1$s下载完成，是否立即安装？", objArr));
            bVar3.j("立即安装");
            bVar3.l(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes)));
            bVar3.f(false);
            bVar3.c(h.r.i(context, bVar.f71252g));
            bVar3.d(new C2016a(this, u, context, bVar, bVar2));
            bVar3.b(1);
            p.b(bVar3.g());
            e.c.a().v("backdialog_show", u);
            this.f71220c = bVar.f71249d;
        }
    }

    public void e(Context context, c.b bVar, boolean z, b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, bVar, Boolean.valueOf(z), bVar2}) == null) {
            this.f71218a.clear();
            d(context, bVar, bVar2, z);
            this.f71219b = true;
            h.b(context).n();
            this.f71221d.c("sp_ad_install_back_dialog", "key_uninstalled_list");
            h.q.b(f71216e, "tryShowInstallDialog isShow:true", null);
        }
    }

    public void f(d.l.a.b.a.c.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) && l.v().optInt("enable_open_app_dialog", 0) == 1 && !bVar.W() && bVar.q()) {
            bVar.W0(true);
            TTDelegateActivity.a(bVar);
        }
    }

    public final boolean g(Activity activity, DownloadInfo downloadInfo, boolean z, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{activity, downloadInfo, Boolean.valueOf(z), bVar})) == null) {
            if (downloadInfo == null) {
                try {
                    if (this.f71218a.isEmpty()) {
                        return false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (activity != null && !activity.isFinishing()) {
                boolean z2 = true;
                if (downloadInfo != null && this.f71218a.isEmpty()) {
                    e(activity, new c.b(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, bVar);
                    return true;
                }
                long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
                ListIterator<c.b> listIterator = this.f71218a.listIterator(this.f71218a.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        z2 = false;
                        break;
                    }
                    c.b previous = listIterator.previous();
                    if (previous != null && !h.r.G(l.a(), previous.f71249d) && h.r.w(previous.f71252g)) {
                        if (new File(previous.f71252g).lastModified() >= lastModified) {
                            e(activity, previous, z, bVar);
                        } else {
                            e(activity, new c.b(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, bVar);
                        }
                    }
                }
                String str = f71216e;
                h.q.b(str, "tryShowInstallDialog isShow:" + z2, null);
                return z2;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @MainThread
    public boolean h(Activity activity, boolean z, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{activity, Boolean.valueOf(z), bVar})) == null) {
            if (l.v().optInt("disable_install_app_dialog") == 1 || this.f71219b) {
                return false;
            }
            return g(activity, b(activity), z, bVar);
        }
        return invokeCommon.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? TextUtils.equals(this.f71220c, str) : invokeL.booleanValue;
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f71220c = "";
            } else if (TextUtils.equals(this.f71220c, str)) {
                this.f71220c = "";
            }
        }
    }
}
