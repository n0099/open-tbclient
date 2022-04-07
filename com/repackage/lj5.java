package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class lj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<DownloadCacheKey, qj5> a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final lj5 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-212129444, "Lcom/repackage/lj5$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-212129444, "Lcom/repackage/lj5$b;");
                    return;
                }
            }
            a = new lj5(null);
        }
    }

    public /* synthetic */ lj5(a aVar) {
        this();
    }

    public static lj5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (lj5) invokeV.objValue;
    }

    public qj5 a(DownloadCacheKey downloadCacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadCacheKey)) == null) ? this.a.get(downloadCacheKey) : (qj5) invokeL.objValue;
    }

    @NonNull
    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey)) == null) {
            AdDownloadData a2 = ij5.c().a(downloadCacheKey);
            if (a2 == null) {
                AdDownloadData f = new AdDownloadData.b(downloadCacheKey).f();
                ij5.c().d(downloadCacheKey, f);
                return f;
            }
            return a2;
        }
        return (AdDownloadData) invokeL.objValue;
    }

    public pj5 c(@NonNull hk0<?> hk0Var, @NonNull oj5 oj5Var, @NonNull AdDownloadData adDownloadData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, hk0Var, oj5Var, adDownloadData)) == null) {
            if (rg5.h().y()) {
                return new fj5(oj5Var, hk0Var, adDownloadData);
            }
            return new gj5(oj5Var, adDownloadData);
        }
        return (pj5) invokeLLL.objValue;
    }

    public void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        AdDownloadData adDownloadData = null;
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : ij5.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                adDownloadData = value;
            }
        }
        for (qj5 qj5Var : l(str)) {
            if (qj5Var != null && qj5Var.l() != 4) {
                qj5Var.k(4);
                qj5Var.g();
            }
        }
        h98.b(str);
        mj5.g().j(context, adDownloadData);
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            uj5.a.get().a(str);
            g(ij5.c().a(h(str)), 702);
        }
    }

    public void g(@NonNull AdDownloadData adDownloadData, int i) {
        DownloadCacheKey h;
        qj5 qj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, adDownloadData, i) == null) || (h = h(adDownloadData.adId())) == null || (qj5Var = this.a.get(h)) == null) {
            return;
        }
        qj5Var.j(i, adDownloadData.getPkgName(), adDownloadData.getExtInfo(), adDownloadData);
    }

    @Nullable
    public DownloadCacheKey h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<DownloadCacheKey, qj5> entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (DownloadCacheKey) invokeL.objValue;
    }

    @Nullable
    public DownloadCacheKey i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry<DownloadCacheKey, qj5> entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                    return entry.getKey();
                }
            }
            return null;
        }
        return (DownloadCacheKey) invokeL.objValue;
    }

    public void j(@NonNull DownloadCacheKey downloadCacheKey, tj5 tj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, downloadCacheKey, tj5Var) == null) {
            qj5 qj5Var = this.a.get(downloadCacheKey);
            if (qj5Var == null) {
                qj5Var = new qj5(downloadCacheKey);
                this.a.put(downloadCacheKey, qj5Var);
            }
            if (tj5Var != null) {
                qj5Var.e(tj5Var);
            }
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            uj5.a.get().d(str);
            g(ij5.c().a(h(str)), IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH);
        }
    }

    public final Set<qj5> l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            HashSet hashSet = new HashSet(this.a.size());
            if (TextUtils.isEmpty(str)) {
                return hashSet;
            }
            for (Map.Entry<DownloadCacheKey, qj5> entry : this.a.entrySet()) {
                if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                    hashSet.add(entry.getValue());
                }
            }
            return hashSet;
        }
        return (Set) invokeL.objValue;
    }

    public String m(@NonNull DownloadCacheKey downloadCacheKey, @Nullable tj5 tj5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, downloadCacheKey, tj5Var)) == null) {
            if (tj5Var != null) {
                j(downloadCacheKey, tj5Var);
            }
            AdDownloadData a2 = ij5.c().a(downloadCacheKey);
            uj5.a.get().b(downloadCacheKey, a2);
            g(a2, 701);
            return downloadCacheKey.mAdId;
        }
        return (String) invokeLL.objValue;
    }

    public boolean n(Context context, DownloadCacheKey downloadCacheKey, @NonNull String str) {
        InterceptResult invokeLLL;
        AdDownloadData a2;
        DownloadCacheKey downloadCacheKey2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, context, downloadCacheKey, str)) == null) {
            boolean b2 = ga8.b(str);
            if (!b2) {
                h98.c(new File(str));
            }
            if (downloadCacheKey != null && (a2 = ij5.c().a(downloadCacheKey)) != null) {
                if (TextUtils.isEmpty(a2.pkgName())) {
                    a2.setupPkgName(hj5.a(context, str));
                }
                if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                    downloadCacheKey.mPackageName = a2.pkgName();
                }
                qj5 qj5Var = this.a.get(downloadCacheKey);
                if (qj5Var != null && (downloadCacheKey2 = qj5Var.c) != null && TextUtils.isEmpty(downloadCacheKey2.mPackageName)) {
                    qj5Var.c.mPackageName = a2.pkgName();
                }
                a2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
                a2.extra().setDownloadPath(str);
                g(a2, 705);
            }
            return b2;
        }
        return invokeLLL.booleanValue;
    }

    public boolean o(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) ? n(TbadkCoreApplication.getInst(), h(str), str2) : invokeLL.booleanValue;
    }

    public boolean p(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, context, str)) == null) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : ij5.c().b(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                    g(value, 706);
                }
            }
            return hj5.c(context, str);
        }
        return invokeLL.booleanValue;
    }

    public void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : ij5.c().b(str).entrySet()) {
            AdDownloadData value = entry.getValue();
            if (value != null) {
                value.extra().setStatus(DownloadStatus.STATUS_NONE);
            }
        }
        for (qj5 qj5Var : l(str)) {
            if (qj5Var != null && qj5Var.l() != 0) {
                qj5Var.k(0);
                qj5Var.h();
            }
        }
    }

    public void r(DownloadCacheKey downloadCacheKey, tj5 tj5Var) {
        qj5 qj5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, downloadCacheKey, tj5Var) == null) || (qj5Var = this.a.get(downloadCacheKey)) == null) {
            return;
        }
        qj5Var.i(tj5Var);
    }

    public lj5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        mj5.g().k();
    }
}
