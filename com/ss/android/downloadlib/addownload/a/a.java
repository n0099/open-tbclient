package com.ss.android.downloadlib.addownload.a;

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
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68446a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static a f68447b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f68448c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68449d;

    /* renamed from: e  reason: collision with root package name */
    public String f68450e;

    /* renamed from: f  reason: collision with root package name */
    public b f68451f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC1970a {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1166649093, "Lcom/ss/android/downloadlib/addownload/a/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1166649093, "Lcom/ss/android/downloadlib/addownload/a/a;");
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
        this.f68449d = false;
        b bVar = new b();
        this.f68451f = bVar;
        this.f68448c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68447b == null) {
                f68447b = new a();
            }
            return f68447b;
        }
        return (a) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f68450e = "";
            } else if (TextUtils.equals(this.f68450e, str)) {
                this.f68450e = "";
            }
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC1970a interfaceC1970a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, downloadInfo, Boolean.valueOf(z), interfaceC1970a})) == null) {
            if (downloadInfo == null) {
                try {
                    if (this.f68448c.isEmpty()) {
                        return false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (activity != null && !activity.isFinishing()) {
                boolean z2 = true;
                if (downloadInfo != null && this.f68448c.isEmpty()) {
                    a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC1970a);
                    return true;
                }
                long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
                ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = this.f68448c.listIterator(this.f68448c.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        z2 = false;
                        break;
                    }
                    com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                    if (previous != null && !l.d(j.getContext(), previous.f68481d) && l.a(previous.f68484g)) {
                        if (new File(previous.f68484g).lastModified() >= lastModified) {
                            a(activity, previous, z, interfaceC1970a);
                        } else {
                            a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC1970a);
                        }
                    }
                }
                String str = f68446a;
                k.a(str, "tryShowInstallDialog isShow:" + z2, null);
                return z2;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC1970a interfaceC1970a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{activity, Boolean.valueOf(z), interfaceC1970a})) == null) {
            if (j.i().optInt("disable_install_app_dialog") == 1 || this.f68449d) {
                return false;
            }
            return a(activity, a(activity), z, interfaceC1970a);
        }
        return invokeCommon.booleanValue;
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC1970a interfaceC1970a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, Boolean.valueOf(z), interfaceC1970a}) == null) {
            this.f68448c.clear();
            a(context, aVar, interfaceC1970a, z);
            this.f68449d = true;
            g.a(context).c();
            this.f68451f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
            k.a(f68446a, "tryShowInstallDialog isShow:true", null);
        }
    }

    public DownloadInfo a(Context context) {
        InterceptResult invokeL;
        long b2;
        List<DownloadInfo> successedDownloadInfosWithMimeType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            DownloadInfo downloadInfo = null;
            try {
                b2 = g.a(context).b();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (j.i().optInt("enable_miniapp_dialog", 0) != 0 && (successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive")) != null && !successedDownloadInfosWithMimeType.isEmpty()) {
                long j = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !l.d(context, downloadInfo2.getPackageName()) && l.a(downloadInfo2.getTargetFilePath())) {
                        long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (lastModified >= b2 && downloadInfo2.getExtra() != null) {
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

    public void a(long j, long j2, long j3, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, str2, str3, str4}) == null) {
            for (int i2 = 0; i2 < this.f68448c.size(); i2++) {
                com.ss.android.downloadlib.addownload.b.a aVar = this.f68448c.get(i2);
                if (aVar != null && aVar.f68479b == j2) {
                    this.f68448c.set(i2, new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
                    this.f68451f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f68448c);
                    return;
                }
            }
            this.f68448c.add(new com.ss.android.downloadlib.addownload.b.a(j, j2, j3, str, str2, str3, str4));
            this.f68451f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f68448c);
        }
    }

    private void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, InterfaceC1970a interfaceC1970a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, aVar, interfaceC1970a, Boolean.valueOf(z)}) == null) {
            com.ss.android.downloadad.api.a.b d2 = f.a().d(aVar.f68479b);
            if (d2 == null) {
                com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
                return;
            }
            com.ss.android.download.api.config.k c2 = j.c();
            b.a a2 = new b.a(context).a(z ? "应用安装确认" : "退出确认");
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(aVar.f68482e) ? "刚刚下载的应用" : aVar.f68482e;
            c2.b(a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(l.a(context, aVar.f68484g)).a(new b.InterfaceC1965b(this, d2, context, aVar, interfaceC1970a) { // from class: com.ss.android.downloadlib.addownload.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f68452a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f68453b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadlib.addownload.b.a f68454c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ InterfaceC1970a f68455d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f68456e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, d2, context, aVar, interfaceC1970a};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68456e = this;
                    this.f68452a = d2;
                    this.f68453b = context;
                    this.f68454c = aVar;
                    this.f68455d = interfaceC1970a;
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.ss.android.downloadlib.d.a.a().b("backdialog_install", this.f68452a);
                        com.ss.android.socialbase.appdownloader.d.a(this.f68453b, (int) this.f68454c.f68478a);
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        com.ss.android.downloadlib.d.a.a().b("backdialog_exit", this.f68452a);
                        InterfaceC1970a interfaceC1970a2 = this.f68455d;
                        if (interfaceC1970a2 != null) {
                            interfaceC1970a2.a();
                        }
                        this.f68456e.b("");
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC1965b
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                        this.f68456e.b("");
                    }
                }
            }).a(1).a());
            com.ss.android.downloadlib.d.a.a().b("backdialog_show", d2);
            this.f68450e = aVar.f68481d;
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? TextUtils.equals(this.f68450e, str) : invokeL.booleanValue;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
