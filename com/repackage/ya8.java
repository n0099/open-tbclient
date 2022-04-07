package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class ya8 implements uj5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String d = "ya8";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, DownloadCacheKey> b;
    public final sj5 c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b implements sj5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya8 a;

        public b(ya8 ya8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ya8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ya8Var;
        }

        @Override // com.repackage.sj5
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                qj5 a = lj5.d().a((DownloadCacheKey) this.a.b.get(str));
                if (a == null) {
                    return;
                }
                a.a(str, i);
            }
        }

        @Override // com.repackage.sj5
        public void b(String str, StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) {
                qj5 a = lj5.d().a((DownloadCacheKey) this.a.b.get(str));
                if (a == null) {
                    return;
                }
                a.b(str, stopStatus);
            }
        }

        @Override // com.repackage.sj5
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                qj5 a = lj5.d().a((DownloadCacheKey) this.a.b.get(str));
                if (a == null) {
                    return;
                }
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04fe), 1).show();
                a.c(str);
            }
        }

        @Override // com.repackage.sj5
        public void d(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, str, i) == null) {
                qj5 a = lj5.d().a((DownloadCacheKey) this.a.b.get(str));
                if (a == null) {
                    return;
                }
                a.d(str, i);
            }
        }

        @Override // com.repackage.sj5
        public void onSuccess(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                DownloadCacheKey downloadCacheKey = (DownloadCacheKey) this.a.b.get(str);
                String a = hj5.a(TbadkCoreApplication.getInst(), str2);
                if (downloadCacheKey == null) {
                    downloadCacheKey = DownloadCacheKey.create(str, "");
                    this.a.b.put(str, downloadCacheKey);
                    if (vm4.e()) {
                        Log.e(ya8.d, "onSuccess : cache key is null");
                    }
                }
                if (!TextUtils.isEmpty(a)) {
                    downloadCacheKey.mPackageName = a;
                }
                AdDownloadData b = lj5.d().b(downloadCacheKey);
                if (!TextUtils.isEmpty(a)) {
                    b.setupPkgName(a);
                }
                qj5 a2 = lj5.d().a(downloadCacheKey);
                if (a2 == null) {
                    return;
                }
                if (hj5.b(TbadkCoreApplication.getInst(), a)) {
                    a2.g();
                } else {
                    a2.onSuccess(str, str2);
                }
            }
        }

        public /* synthetic */ b(ya8 ya8Var, a aVar) {
            this(ya8Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755148415, "Lcom/repackage/ya8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755148415, "Lcom/repackage/ya8;");
        }
    }

    public ya8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap();
        this.c = new b(this, null);
    }

    @Override // com.repackage.uj5
    public void a(String str) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (downloadCacheKey = this.b.get(str)) == null) {
            return;
        }
        hb8.j().f(downloadCacheKey.mDownloadUrl, str, true);
    }

    @Override // com.repackage.uj5
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey, adDownloadData) == null) {
            this.b.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(hb8.k(downloadCacheKey.mPackageName).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            if (vm4.e()) {
                String str = d;
                Log.e(str, "start download ad id:" + downloadData.getId());
                String str2 = d;
                Log.e(str2, "start download ad pkg:" + downloadData.getName());
                String str3 = d;
                Log.e(str3, "start download ad url:" + downloadData.getUrl());
            }
            hb8.j().u(downloadData);
        }
    }

    @Override // com.repackage.uj5
    public sj5 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (sj5) invokeV.objValue;
    }

    @Override // com.repackage.uj5
    public void d(String str) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (downloadCacheKey = this.b.get(str)) == null) {
            return;
        }
        this.b.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(hb8.k(downloadData.getName()).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        hb8.j().u(downloadData);
    }
}
