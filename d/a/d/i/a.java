package d.a.d.i;

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
import d.a.d.e.p.j;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f42276e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IPackageGetCallback f42277a;

    /* renamed from: b  reason: collision with root package name */
    public volatile ResultData f42278b;

    /* renamed from: c  reason: collision with root package name */
    public volatile ErrorInfo f42279c;

    /* renamed from: d  reason: collision with root package name */
    public RequestParams.Channel f42280d;

    /* renamed from: d.a.d.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0570a implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPackageGetCallback f42281a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f42282b;

        public C0570a(a aVar, IPackageGetCallback iPackageGetCallback) {
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
            this.f42282b = aVar;
            this.f42281a = iPackageGetCallback;
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
                this.f42282b.n(errorInfo, this.f42281a);
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                this.f42282b.o(resultData, this.f42281a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements PackageCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f42283a;

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
            this.f42283a = aVar;
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
                synchronized (this.f42283a) {
                    this.f42283a.f42279c = errorInfo;
                    this.f42283a.p();
                }
            }
        }

        @Override // com.baidu.searchbox.pms.callback.PackageCallback
        public void onResultData(ResultData resultData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) {
                synchronized (this.f42283a) {
                    boolean unused = a.f42276e = true;
                    this.f42283a.f42278b = resultData;
                    this.f42283a.p();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1725437392, "Ld/a/d/i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1725437392, "Ld/a/d/i/a;");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f42276e : invokeV.booleanValue;
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
                arrayList.add(new d.a.d.g.a(packageInfo));
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
                    PmsManager.getInstance().download(h2, downloadOptions, new d.a.d.g.b(iPackageDownloadCallback));
                    return;
                } else {
                    iPackageDownloadCallback.onPackageDownloadFail(h2.packageName, -1, "no wifi");
                    return;
                }
            }
            PmsManager.getInstance().download(h2, downloadOptions, new d.a.d.g.b(iPackageDownloadCallback));
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
            channel.setCallback(new C0570a(this, iPackageGetCallback));
            requestParams.addChannel(channel);
            PmsManager.getInstance().execute(requestParams);
        }
    }

    public void k(List<IBundleInfo> list, IPackageGetCallback iPackageGetCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, list, iPackageGetCallback) == null) {
            if (list == null || list.isEmpty()) {
                synchronized (this) {
                    this.f42277a = iPackageGetCallback;
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
            RequestParams.Channel channel = this.f42280d;
            if (channel != null) {
                return channel;
            }
            RequestParams.Channel channel2 = new RequestParams.Channel();
            this.f42280d = channel2;
            channel2.setFetchAllPackages(true);
            this.f42280d.setChannelId(ApsConstants.TYPE_ANDROID_PLUGIN);
            this.f42280d.setCallback(new b(this));
            return this.f42280d;
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
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f42277a == null) {
            return;
        }
        if (this.f42279c != null) {
            n(this.f42279c, this.f42277a);
            this.f42277a = null;
            this.f42279c = null;
        } else if (this.f42278b != null) {
            o(this.f42278b, this.f42277a);
            this.f42277a = null;
            this.f42278b = null;
        }
    }
}
