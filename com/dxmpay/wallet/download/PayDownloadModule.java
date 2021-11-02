package com.dxmpay.wallet.download;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import b.f.b.c.b;
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
/* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
    public interface PayDownloadCallBack {
        void onDownloadStatus(String str, int i2);
    }

    /* loaded from: classes11.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f62614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f62615b;

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
            this.f62615b = payDownloadModule;
            this.f62614a = str;
        }

        @Override // b.f.b.c.b.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f62615b.downloadFileSuccess(str, this.f62614a, true);
            }
        }

        @Override // b.f.b.c.b.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f62615b.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (this.f62615b.mPayDownloadCallBack != null) {
                    this.f62615b.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            }
        }

        @Override // b.f.b.c.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62615b.mPayDownloadCallBack == null) {
                return;
            }
            this.f62615b.mPayDownloadCallBack.onDownloadStatus("", 1);
        }
    }

    /* loaded from: classes11.dex */
    public class b implements ApollonDownloadManager.DownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f62616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f62617b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f62618c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f62619d;

        public b(PayDownloadModule payDownloadModule, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payDownloadModule, Long.valueOf(j), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62619d = payDownloadModule;
            this.f62616a = j;
            this.f62617b = str;
            this.f62618c = str2;
        }

        @Override // com.dxmpay.apollon.downloadmanager.ApollonDownloadManager.DownloadListener
        public void onChanged(DownloadItemInfo downloadItemInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadItemInfo) == null) {
                if (downloadItemInfo.getDownloadState() == 8) {
                    ApollonDownloadManager.getInstance(this.f62619d.context).unregisterObserver(this.f62619d.context, this.f62616a, this);
                    this.f62619d.downloadFileSuccess(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + this.f62617b + this.f62618c, this.f62617b, false);
                } else if (downloadItemInfo.getDownloadState() == 2) {
                    if (this.f62619d.mPayDownloadCallBack != null) {
                        this.f62619d.mPayDownloadCallBack.onDownloadStatus("", 1);
                    }
                } else if (downloadItemInfo.getDownloadState() == 16) {
                    this.f62619d.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    if (this.f62619d.mPayDownloadCallBack != null) {
                        this.f62619d.mPayDownloadCallBack.onDownloadStatus("", 2);
                    }
                } else {
                    this.f62619d.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    if (this.f62619d.mPayDownloadCallBack != null) {
                        this.f62619d.mPayDownloadCallBack.onDownloadStatus("", 2);
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f62620a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f62621b;

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
            this.f62621b = payDownloadModule;
            this.f62620a = str;
        }

        @Override // b.f.b.c.b.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f62621b.downloadFileSuccess(str, this.f62620a, true);
            }
        }

        @Override // b.f.b.c.b.a
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f62621b.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                if (this.f62621b.mPayDownloadCallBack != null) {
                    this.f62621b.mPayDownloadCallBack.onDownloadStatus("", 2);
                }
            }
        }

        @Override // b.f.b.c.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62621b.mPayDownloadCallBack == null) {
                return;
            }
            this.f62621b.mPayDownloadCallBack.onDownloadStatus("", 1);
        }
    }

    /* loaded from: classes11.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f62623f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f62624g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PayDownloadModule f62625h;

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
            this.f62625h = payDownloadModule;
            this.f62622e = str;
            this.f62623f = str2;
            this.f62624g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(Md5Utils.getMd5FromFileV2(this.f62622e), this.f62623f)) {
                    this.f62625h.setDownloadModuleStatusPoint(0, PayDownloadModule.STATUS_DOWNLOAD_MSG_SUCCESS);
                    if (ZipUtils.unzip(this.f62622e, this.f62625h.getInternalUnZipPath(this.f62623f))) {
                        if (this.f62625h.mPayDownloadCallBack != null) {
                            if (!TextUtils.isEmpty(PayDownloadCache.getDownloadFileMd5Value(this.f62625h.context, this.f62625h.moduleName))) {
                                PayDownloadModule payDownloadModule = this.f62625h;
                                FileUtils.deleteDir(new File(payDownloadModule.getInternalUnZipPath(PayDownloadCache.getDownloadFileMd5Value(payDownloadModule.context, this.f62625h.moduleName))), true);
                            }
                            PayDownloadCache.setDownloadFileMd5Value(this.f62625h.context, this.f62625h.moduleName, this.f62623f);
                            this.f62625h.mPayDownloadCallBack.onDownloadStatus(this.f62625h.getInternalUnZipPath(this.f62623f), 0);
                        }
                    } else {
                        this.f62625h.setDownloadModuleStatusPoint(3, PayDownloadModule.STATUS_UN_ZIP_MSG_FAIL);
                        if (this.f62625h.mPayDownloadCallBack != null) {
                            this.f62625h.mPayDownloadCallBack.onDownloadStatus("", 3);
                        }
                    }
                } else {
                    this.f62625h.setDownloadModuleStatusPoint(2, PayDownloadModule.STATUS_DOWNLOAD_MSG_FAIL);
                    if (this.f62625h.mPayDownloadCallBack != null) {
                        this.f62625h.mPayDownloadCallBack.onDownloadStatus("", 2);
                    }
                }
                if (this.f62624g) {
                    FileUtils.deleteFile(this.f62622e);
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
                new b.f.b.c.b(this.moduleName).b(str, str2, getInternalZipPath(str2, str3), new a(this, str2));
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
                new b.f.b.c.b(this.moduleName).b(str, str2, getInternalZipPath(str2, str3), new c(this, str2));
            } else if (this.mPayDownloadCallBack != null) {
                setPreviousDownloadCompletedPoint();
                PayDownloadCallBack payDownloadCallBack = this.mPayDownloadCallBack;
                payDownloadCallBack.onDownloadStatus(this.context.getDir(this.moduleName, 0) + File.separator + str2, 0);
            }
        }
    }
}
