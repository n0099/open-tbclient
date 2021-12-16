package com.dxmpay.wallet.download;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import c.f.b.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.downloadmanager.ApollonDownloadManager;
import com.dxmpay.apollon.downloadmanager.DownloadItemInfo;
import com.dxmpay.apollon.permission.PermissionManager;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.FileUtils;
import com.dxmpay.wallet.utils.ZipUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class PayDownloadModule implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_DOWNLOAD_FAIL = 2;
    public static final String STATUS_DOWNLOAD_MSG_FAIL = "下载失败";
    public static final String STATUS_DOWNLOAD_MSG_SUCCESS = "下载成功";
    public static final int STATUS_DOWNLOAD_RUNNING = 1;
    public static final int STATUS_DOWNLOAD_SUCCESS = 0;
    public static final int STATUS_UN_ZIP_FAIL = 3;
    public static final String STATUS_UN_ZIP_MSG_FAIL = "解压失败";
    public static final String TAG = "PayDownloadModule";
    public transient /* synthetic */ FieldHolder $fh;
    public Context context;
    public ExecutorService executorService;
    public PayDownloadCallBack mPayDownloadCallBack;
    public String moduleName;

    /* loaded from: classes2.dex */
    public interface PayDownloadCallBack {
        void onDownloadStatus(String str, int i2);
    }

    /* loaded from: classes2.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f56117b;

        public a(PayDownloadModule payDownloadModule, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDownloadModule, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56117b = payDownloadModule;
            this.a = str;
        }

        @Override // c.f.b.c.b.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f56117b.downloadFileSuccess(str, this.a, true);
            }
        }

        @Override // c.f.b.c.b.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f56117b.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (this.f56117b.mPayDownloadCallBack != null) {
                    this.f56117b.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            }
        }

        @Override // c.f.b.c.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56117b.mPayDownloadCallBack == null) {
                return;
            }
            this.f56117b.mPayDownloadCallBack.onDownloadStatus("", 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ApollonDownloadManager.DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f56118b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f56119c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f56120d;

        public b(PayDownloadModule payDownloadModule, long j2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDownloadModule, Long.valueOf(j2), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56120d = payDownloadModule;
            this.a = j2;
            this.f56118b = str;
            this.f56119c = str2;
        }

        @Override // com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.DownloadListener
        public void onChanged(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                if (downloadItemInfo.getDownloadState() == 8) {
                    ApollonDownloadManager.getInstance(this.f56120d.context).unregisterObserver(this.f56120d.context, this.a, this);
                    this.f56120d.downloadFileSuccess(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + this.f56118b + this.f56119c, this.f56118b, false);
                } else if (downloadItemInfo.getDownloadState() == 2) {
                    if (this.f56120d.mPayDownloadCallBack != null) {
                        this.f56120d.mPayDownloadCallBack.onDownloadStatus("", 1);
                    }
                } else if (downloadItemInfo.getDownloadState() == 16) {
                    this.f56120d.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    if (this.f56120d.mPayDownloadCallBack != null) {
                        this.f56120d.mPayDownloadCallBack.onDownloadStatus("", 2);
                    }
                } else {
                    this.f56120d.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    if (this.f56120d.mPayDownloadCallBack != null) {
                        this.f56120d.mPayDownloadCallBack.onDownloadStatus("", 2);
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f56121b;

        public c(PayDownloadModule payDownloadModule, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDownloadModule, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56121b = payDownloadModule;
            this.a = str;
        }

        @Override // c.f.b.c.b.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f56121b.downloadFileSuccess(str, this.a, true);
            }
        }

        @Override // c.f.b.c.b.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f56121b.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (this.f56121b.mPayDownloadCallBack != null) {
                    this.f56121b.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            }
        }

        @Override // c.f.b.c.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f56121b.mPayDownloadCallBack == null) {
                return;
            }
            this.f56121b.mPayDownloadCallBack.onDownloadStatus("", 1);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f56122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f56123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f56124g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f56125h;

        public d(PayDownloadModule payDownloadModule, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDownloadModule, str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56125h = payDownloadModule;
            this.f56122e = str;
            this.f56123f = str2;
            this.f56124g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(Md5Utils.getMd5FromFileV2(this.f56122e), this.f56123f)) {
                    this.f56125h.setDownloadModuleStatusPoint(0, PayDownloadModule.STATUS_DOWNLOAD_MSG_SUCCESS);
                    if (ZipUtils.unzip(this.f56122e, this.f56125h.getInternalUnZipPath(this.f56123f))) {
                        if (this.f56125h.mPayDownloadCallBack != null) {
                            if (!TextUtils.isEmpty(PayDownloadCache.getDownloadFileMd5Value(this.f56125h.context, this.f56125h.moduleName))) {
                                PayDownloadModule payDownloadModule = this.f56125h;
                                FileUtils.deleteDir(new File(payDownloadModule.getInternalUnZipPath(PayDownloadCache.getDownloadFileMd5Value(payDownloadModule.context, this.f56125h.moduleName))), true);
                            }
                            PayDownloadCache.setDownloadFileMd5Value(this.f56125h.context, this.f56125h.moduleName, this.f56123f);
                            this.f56125h.mPayDownloadCallBack.onDownloadStatus(this.f56125h.getInternalUnZipPath(this.f56123f), 0);
                        }
                    } else {
                        this.f56125h.setDownloadModuleStatusPoint(3, PayDownloadModule.STATUS_UN_ZIP_MSG_FAIL);
                        if (this.f56125h.mPayDownloadCallBack != null) {
                            this.f56125h.mPayDownloadCallBack.onDownloadStatus("", 3);
                        }
                    }
                } else {
                    this.f56125h.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    if (this.f56125h.mPayDownloadCallBack != null) {
                        this.f56125h.mPayDownloadCallBack.onDownloadStatus("", 2);
                    }
                }
                if (this.f56124g) {
                    FileUtils.deleteFile(this.f56122e);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1885143638, "Lcom/dxmpay/wallet/download/PayDownloadModule;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1885143638, "Lcom/dxmpay/wallet/download/PayDownloadModule;");
        }
    }

    public PayDownloadModule(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.context = context;
        this.moduleName = str;
        this.executorService = Executors.newSingleThreadExecutor();
    }

    private boolean checkUpdate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, str)) == null) ? !TextUtils.equals(str, PayDownloadCache.getDownloadFileMd5Value(this.context, this.moduleName)) : invokeL.booleanValue;
    }

    private boolean checkUpdateExternal(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, str2)) == null) {
            String str3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str + str2;
            if (new File(str3).exists()) {
                return TextUtils.equals(str, Md5Utils.getMd5FromFileV2(str3));
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFileSuccess(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65545, this, str, str2, z) == null) {
            this.executorService.submit(new d(this, str, str2, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDownloadModuleStatusPoint(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65546, this, i2, str) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(i2 + "");
            arrayList.add(str + "");
            arrayList.add(this.moduleName + "");
            StatisticManager.onEventEndWithValues(StatServiceEvent.DOWNLOAD_MODULE_STATUS, arrayList);
        }
    }

    private void setPreviousDownloadCompletedPoint() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.moduleName);
            StatisticManager.onEventEndWithValues(StatServiceEvent.DOWNLOAD_MODULE_PREVIOUS_DOWNLOAD_COMPLETED, arrayList);
        }
    }

    @Deprecated
    public void download(String str, String str2, boolean z, boolean z2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3}) == null) {
            if (checkUpdate(str2)) {
                if (Build.VERSION.SDK_INT < 29 && PermissionManager.checkCallingPermission(this.context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    if (checkUpdateExternal(str2, str3)) {
                        setPreviousDownloadCompletedPoint();
                        downloadFileSuccess(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str2 + str3, str2, false);
                        return;
                    }
                    ApollonDownloadManager apollonDownloadManager = new ApollonDownloadManager(this.context, this.moduleName);
                    String str4 = Environment.DIRECTORY_DOWNLOADS;
                    long doDownload = apollonDownloadManager.doDownload(str4, str2 + "", str, z, z2, false, str3);
                    if (doDownload != -1) {
                        apollonDownloadManager.registerObserver(this.context, doDownload, new b(this, doDownload, str2, str3));
                        return;
                    }
                    PayDownloadCallBack payDownloadCallBack = this.mPayDownloadCallBack;
                    if (payDownloadCallBack != null) {
                        payDownloadCallBack.onDownloadStatus("", 2);
                        return;
                    }
                    return;
                }
                new c.f.b.c.b(this.moduleName).b(str, str2, getInternalZipPath(str2, str3), new a(this, str2));
            } else if (this.mPayDownloadCallBack != null) {
                setPreviousDownloadCompletedPoint();
                PayDownloadCallBack payDownloadCallBack2 = this.mPayDownloadCallBack;
                payDownloadCallBack2.onDownloadStatus(this.context.getDir(this.moduleName, 0) + File.separator + str2, 0);
            }
        }
    }

    public String getInternalRootPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.context.getDir(this.moduleName, 0).getAbsolutePath() : (String) invokeV.objValue;
    }

    public String getInternalUnZipPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String internalRootPath = getInternalRootPath();
            return new File(internalRootPath + File.separator + str).getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public String getInternalZipPath(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            String internalRootPath = getInternalRootPath();
            return new File(internalRootPath + File.separator + str + str2).getAbsolutePath();
        }
        return (String) invokeLL.objValue;
    }

    public void resetMD5AndDeleteDownloadFiles(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, context) == null) || context == null) {
            return;
        }
        PayDownloadCache.setDownloadFileMd5Value(context, this.moduleName, "");
        FileUtils.deleteDir(new File(getInternalRootPath()), true);
    }

    @Deprecated
    public void resetMD5AndDeleteFiles(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, context) == null) || context == null) {
            return;
        }
        PayDownloadCache.setDownloadFileMd5Value(context, BeanConstants.SDK_DOLEAD_FILE_FAEC_MODULE_NAME, "");
        FileUtils.deleteDir(new File(getInternalRootPath()), true);
    }

    public void setPayDownloadCallBack(PayDownloadCallBack payDownloadCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, payDownloadCallBack) == null) {
            this.mPayDownloadCallBack = payDownloadCallBack;
        }
    }

    public void download(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, str3) == null) {
            if (checkUpdate(str2)) {
                new c.f.b.c.b(this.moduleName).b(str, str2, getInternalZipPath(str2, str3), new c(this, str2));
            } else if (this.mPayDownloadCallBack != null) {
                setPreviousDownloadCompletedPoint();
                PayDownloadCallBack payDownloadCallBack = this.mPayDownloadCallBack;
                payDownloadCallBack.onDownloadStatus(this.context.getDir(this.moduleName, 0) + File.separator + str2, 0);
            }
        }
    }
}
