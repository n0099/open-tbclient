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
    public static final String a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static a f61169b;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.b.a> f61170c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f61171d;

    /* renamed from: e  reason: collision with root package name */
    public String f61172e;

    /* renamed from: f  reason: collision with root package name */
    public b f61173f;

    /* renamed from: com.ss.android.downloadlib.addownload.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC2099a {
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
        this.f61171d = false;
        b bVar = new b();
        this.f61173f = bVar;
        this.f61170c = bVar.a("sp_ad_install_back_dialog", "key_uninstalled_list");
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f61169b == null) {
                f61169b = new a();
            }
            return f61169b;
        }
        return (a) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.f61172e = "";
            } else if (TextUtils.equals(this.f61172e, str)) {
                this.f61172e = "";
            }
        }
    }

    private boolean a(Activity activity, DownloadInfo downloadInfo, boolean z, InterfaceC2099a interfaceC2099a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{activity, downloadInfo, Boolean.valueOf(z), interfaceC2099a})) == null) {
            if (downloadInfo == null) {
                try {
                    if (this.f61170c.isEmpty()) {
                        return false;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (activity != null && !activity.isFinishing()) {
                boolean z2 = true;
                if (downloadInfo != null && this.f61170c.isEmpty()) {
                    a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC2099a);
                    return true;
                }
                long lastModified = downloadInfo != null ? new File(downloadInfo.getTargetFilePath()).lastModified() : 0L;
                ListIterator<com.ss.android.downloadlib.addownload.b.a> listIterator = this.f61170c.listIterator(this.f61170c.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        z2 = false;
                        break;
                    }
                    com.ss.android.downloadlib.addownload.b.a previous = listIterator.previous();
                    if (previous != null && !l.d(j.getContext(), previous.f61195d) && l.a(previous.f61198g)) {
                        if (new File(previous.f61198g).lastModified() >= lastModified) {
                            a(activity, previous, z, interfaceC2099a);
                        } else {
                            a(activity, new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), 0L, 0L, downloadInfo.getPackageName(), downloadInfo.getTitle(), null, downloadInfo.getTargetFilePath()), z, interfaceC2099a);
                        }
                    }
                }
                String str = a;
                k.a(str, "tryShowInstallDialog isShow:" + z2, null);
                return z2;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @MainThread
    public boolean a(Activity activity, boolean z, InterfaceC2099a interfaceC2099a) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{activity, Boolean.valueOf(z), interfaceC2099a})) == null) {
            if (j.i().optInt("disable_install_app_dialog") == 1 || this.f61171d) {
                return false;
            }
            return a(activity, a(activity), z, interfaceC2099a);
        }
        return invokeCommon.booleanValue;
    }

    public void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, boolean z, InterfaceC2099a interfaceC2099a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, aVar, Boolean.valueOf(z), interfaceC2099a}) == null) {
            this.f61170c.clear();
            a(context, aVar, interfaceC2099a, z);
            this.f61171d = true;
            g.a(context).c();
            this.f61173f.b("sp_ad_install_back_dialog", "key_uninstalled_list");
            k.a(a, "tryShowInstallDialog isShow:true", null);
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
                long j2 = 0;
                for (DownloadInfo downloadInfo2 : successedDownloadInfosWithMimeType) {
                    if (downloadInfo2 != null && !l.d(context, downloadInfo2.getPackageName()) && l.a(downloadInfo2.getTargetFilePath())) {
                        long lastModified = new File(downloadInfo2.getTargetFilePath()).lastModified();
                        if (lastModified >= b2 && downloadInfo2.getExtra() != null) {
                            try {
                                if (new JSONObject(downloadInfo2.getExtra()).has("isMiniApp") && (j2 == 0 || lastModified > j2)) {
                                    downloadInfo = downloadInfo2;
                                    j2 = lastModified;
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

    public void a(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, str2, str3, str4}) == null) {
            for (int i2 = 0; i2 < this.f61170c.size(); i2++) {
                com.ss.android.downloadlib.addownload.b.a aVar = this.f61170c.get(i2);
                if (aVar != null && aVar.f61193b == j3) {
                    this.f61170c.set(i2, new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
                    this.f61173f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f61170c);
                    return;
                }
            }
            this.f61170c.add(new com.ss.android.downloadlib.addownload.b.a(j2, j3, j4, str, str2, str3, str4));
            this.f61173f.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.f61170c);
        }
    }

    private void a(Context context, com.ss.android.downloadlib.addownload.b.a aVar, InterfaceC2099a interfaceC2099a, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{context, aVar, interfaceC2099a, Boolean.valueOf(z)}) == null) {
            com.ss.android.downloadad.api.a.b d2 = f.a().d(aVar.f61193b);
            if (d2 == null) {
                com.ss.android.downloadlib.e.c.a().a("showBackInstallDialog nativeModel null");
                return;
            }
            com.ss.android.download.api.config.k c2 = j.c();
            b.a a2 = new b.a(context).a(z ? "应用安装确认" : "退出确认");
            Object[] objArr = new Object[1];
            objArr[0] = TextUtils.isEmpty(aVar.f61196e) ? "刚刚下载的应用" : aVar.f61196e;
            c2.b(a2.b(String.format("%1$s下载完成，是否立即安装？", objArr)).c("立即安装").d(z ? "暂不安装" : String.format("退出%1$s", context.getResources().getString(context.getApplicationContext().getApplicationInfo().labelRes))).a(false).a(l.a(context, aVar.f61198g)).a(new b.InterfaceC2094b(this, d2, context, aVar, interfaceC2099a) { // from class: com.ss.android.downloadlib.addownload.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.ss.android.downloadad.api.a.b a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Context f61174b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadlib.addownload.b.a f61175c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ InterfaceC2099a f61176d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f61177e;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr2 = {this, d2, context, aVar, interfaceC2099a};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61177e = this;
                    this.a = d2;
                    this.f61174b = context;
                    this.f61175c = aVar;
                    this.f61176d = interfaceC2099a;
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2094b
                public void a(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                        com.ss.android.downloadlib.d.a.a().b("backdialog_install", this.a);
                        com.ss.android.socialbase.appdownloader.d.a(this.f61174b, (int) this.f61175c.a);
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2094b
                public void b(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) {
                        com.ss.android.downloadlib.d.a.a().b("backdialog_exit", this.a);
                        InterfaceC2099a interfaceC2099a2 = this.f61176d;
                        if (interfaceC2099a2 != null) {
                            interfaceC2099a2.a();
                        }
                        this.f61177e.b("");
                        dialogInterface.dismiss();
                    }
                }

                @Override // com.ss.android.download.api.model.b.InterfaceC2094b
                public void c(DialogInterface dialogInterface) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) {
                        this.f61177e.b("");
                    }
                }
            }).a(1).a());
            com.ss.android.downloadlib.d.a.a().b("backdialog_show", d2);
            this.f61172e = aVar.f61195d;
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? TextUtils.equals(this.f61172e, str) : invokeL.booleanValue;
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) && j.i().optInt("enable_open_app_dialog", 0) == 1 && !bVar.Z() && bVar.q()) {
            bVar.k(true);
            TTDelegateActivity.a(bVar);
        }
    }
}
