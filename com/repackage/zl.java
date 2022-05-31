package com.repackage;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.DegradeData;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.bean.ResultData;
import com.baidu.searchbox.pms.callback.DefaultDownloadCallback;
import com.baidu.searchbox.pms.callback.DefaultPackageCallback;
import com.baidu.searchbox.pms.download.DownloadOptions;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class zl extends DefaultPackageCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DefaultDownloadCallback a;
    public bm b;

    public zl(DefaultDownloadCallback defaultDownloadCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultDownloadCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = defaultDownloadCallback;
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onDegradeData(DegradeData degradeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, degradeData) == null) {
            super.onDegradeData(degradeData);
        }
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onFetchError(ErrorInfo errorInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorInfo) == null) || errorInfo == null) {
            return;
        }
        BdLog.e(errorInfo.errorMsg);
    }

    @Override // com.baidu.searchbox.pms.callback.DefaultPackageCallback, com.baidu.searchbox.pms.callback.PackageCallback
    public void onResultData(ResultData resultData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, resultData) == null) || resultData == null) {
            return;
        }
        DebugUtils.log(resultData);
        ArrayList<PackageInfo> arrayList = new ArrayList();
        arrayList.addAll(resultData.addList);
        arrayList.addAll(resultData.updateList);
        if (!arrayList.isEmpty()) {
            for (PackageInfo packageInfo : arrayList) {
                if (packageInfo != null && !StringUtils.isNull(packageInfo.name)) {
                    DownloadOptions downloadOptions = new DownloadOptions();
                    downloadOptions.fileDir = am.a(packageInfo.name);
                    PmsManager.getInstance().download(packageInfo, downloadOptions, new yl(this.a));
                }
            }
        }
        arrayList.clear();
        arrayList.addAll(resultData.configChangeList);
        arrayList.addAll(resultData.filterList);
        if (!arrayList.isEmpty()) {
            for (PackageInfo packageInfo2 : arrayList) {
                if (packageInfo2 != null && !StringUtils.isNull(packageInfo2.name)) {
                    if (!packageInfo2.name.contains(".so")) {
                        ConcurrentHashMap<String, String> resHashMap = BdBaseApplication.getInst().getResHashMap();
                        String str = packageInfo2.name;
                        resHashMap.put(str, am.a(str));
                    } else if (cm.a(BdBaseApplication.getInst().getContext(), am.a(packageInfo2.name))) {
                        ConcurrentHashMap<String, String> resHashMap2 = BdBaseApplication.getInst().getResHashMap();
                        String str2 = packageInfo2.name;
                        resHashMap2.put(str2, am.a(str2));
                        bm bmVar = this.b;
                        if (bmVar != null) {
                            bmVar.onSoFileLoaded(packageInfo2.name);
                        }
                    }
                }
            }
        }
        if (resultData.invalidList.isEmpty()) {
            return;
        }
        BdAsyncTask<?, ?, ?> searchTask = BdAsyncTask.searchTask("key_res_del");
        if (searchTask == null || searchTask.getStatus() != BdAsyncTask.BdAsyncTaskStatus.PENDING) {
            xl xlVar = new xl();
            xlVar.setKey("key_res_del");
            xlVar.execute(resultData.invalidList);
        }
    }

    public zl(DefaultDownloadCallback defaultDownloadCallback, bm bmVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultDownloadCallback, bmVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = defaultDownloadCallback;
        this.b = bmVar;
    }
}
