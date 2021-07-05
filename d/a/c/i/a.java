package d.a.c.i;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.interfa.IPackageDownloadCallback;
import com.baidu.nps.interfa.IPackageGetCallback;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f44756e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IPackageGetCallback f44757a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ResultData f44758b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ErrorInfo f44759c;

    /* renamed from: d  reason: collision with root package name */
    public RequestParams.Channel f44760d;

    /* renamed from: d.a.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0600a implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPackageGetCallback f44761a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f44762b;

        public C0600a(a aVar, IPackageGetCallback iPackageGetCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, iPackageGetCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44762b = aVar;
            this.f44761a = iPackageGetCallback;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) {
                this.f44762b.n(errorInfo, this.f44761a);
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                this.f44762b.o(resultData, this.f44761a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f44763a;

        public b(a aVar) {
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
            this.f44763a = aVar;
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onDegradeData(DegradeData degradeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onFetchError(ErrorInfo errorInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) {
                synchronized (this.f44763a) {
                    this.f44763a.f44759c = errorInfo;
                    this.f44763a.p();
                }
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                synchronized (this.f44763a) {
                    boolean unused = a.f44756e = true;
                    this.f44763a.f44758b = resultData;
                    this.f44763a.p();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1754066543, "Ld/a/c/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1754066543, "Ld/a/c/i/a;");
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
            }
        }
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f44756e : invokeV.booleanValue;
    }

    public final List<IBundleInfo> g(List<PackageInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list == null || list.isEmpty()) {
                return null;
            }
            for (PackageInfo packageInfo : list) {
                arrayList.add(new d.a.c.g.a(packageInfo));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final PackageInfo h(IBundleInfo iBundleInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iBundleInfo)) == null) {
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.channelId = ApsConstants.TYPE_ANDROID_PLUGIN;
            packageInfo.packageName = iBundleInfo.getPackageName();
            packageInfo.md5 = iBundleInfo.getMd5();
            packageInfo.downloadUrl = iBundleInfo.getDownloadUrl();
            packageInfo.isSilence = 1;
            return packageInfo;
        }
        return (PackageInfo) invokeL.objValue;
    }

    public void i(IBundleInfo iBundleInfo, String str, int i2, IPackageDownloadCallback iPackageDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, iBundleInfo, str, i2, iPackageDownloadCallback) == null) {
            PackageInfo h2 = h(iBundleInfo);
            h2.filePath = str;
            DownloadOptions downloadOptions = new DownloadOptions();
            downloadOptions.saveToDb = false;
            if (i2 == 49) {
                if (j.H()) {
                    PmsManager.getInstance().download(h2, downloadOptions, new d.a.c.g.b(iPackageDownloadCallback));
                    return;
                } else {
                    iPackageDownloadCallback.onPackageDownloadFail(h2.packageName, -1, "no wifi");
                    return;
                }
            }
            PmsManager.getInstance().download(h2, downloadOptions, new d.a.c.g.b(iPackageDownloadCallback));
        }
    }

    public final void j(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, list, iPackageGetCallback) == null) {
            RequestParams requestParams = new RequestParams();
            requestParams.setRunType(ApsConstants.RUN_TYPE_ANDROID_PLUGIN);
            RequestParams.Channel channel = new RequestParams.Channel();
            channel.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            ArrayList arrayList = new ArrayList();
            for (IBundleInfo iBundleInfo : list) {
                arrayList.add(iBundleInfo.getPackageName());
            }
            channel.setPackageNames(arrayList);
            channel.setCallback(new C0600a(this, iPackageGetCallback));
            requestParams.addChannel(channel);
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public void k(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, iPackageGetCallback) == null) {
            if (list == null || list.isEmpty()) {
                synchronized (this) {
                    this.f44757a = iPackageGetCallback;
                    p();
                }
                return;
            }
            j(list, iPackageGetCallback);
        }
    }

    public RequestParams.Channel l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequestParams.Channel channel = this.f44760d;
            if (channel != null) {
                return channel;
            }
            RequestParams.Channel channel2 = new RequestParams.Channel();
            this.f44760d = channel2;
            channel2.setFetchAllPackages(true);
            this.f44760d.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            this.f44760d.setCallback(new b(this));
            return this.f44760d;
        }
        return (RequestParams.Channel) invokeV.objValue;
    }

    public final void n(ErrorInfo errorInfo, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, errorInfo, iPackageGetCallback) == null) {
            iPackageGetCallback.onBundleInfoGetFail(errorInfo.code, errorInfo.errorMsg);
        }
    }

    public final void o(ResultData resultData, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, resultData, iPackageGetCallback) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(resultData.addList);
            arrayList.addAll(resultData.updateList);
            iPackageGetCallback.onBundleInfoGetSuccess(g(arrayList));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f44757a == null) {
            return;
        }
        if (this.f44759c != null) {
            n(this.f44759c, this.f44757a);
            this.f44757a = null;
            this.f44759c = null;
        } else if (this.f44758b != null) {
            o(this.f44758b, this.f44757a);
            this.f44757a = null;
            this.f44758b = null;
        }
    }
}
