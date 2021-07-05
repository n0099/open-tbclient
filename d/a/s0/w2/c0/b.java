package d.a.s0.w2.c0;

import android.text.TextUtils;
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
/* loaded from: classes9.dex */
public class b implements d.a.s0.q.d.i.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, DownloadCacheKey> f69003b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.s0.q.d.h.c f69004c;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.s0.w2.c0.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1870b implements d.a.s0.q.d.h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f69005a;

        public C1870b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69005a = bVar;
        }

        @Override // d.a.s0.q.d.h.c
        public void a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i2) == null) {
                d.a.s0.q.d.h.a a2 = d.a.s0.q.d.e.c().a((DownloadCacheKey) this.f69005a.f69003b.get(str));
                if (a2 == null) {
                    return;
                }
                a2.a(str, i2);
            }
        }

        @Override // d.a.s0.q.d.h.c
        public void b(String str, StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, stopStatus) == null) {
                d.a.s0.q.d.h.a a2 = d.a.s0.q.d.e.c().a((DownloadCacheKey) this.f69005a.f69003b.get(str));
                if (a2 == null) {
                    return;
                }
                a2.b(str, stopStatus);
            }
        }

        @Override // d.a.s0.q.d.h.c
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                d.a.s0.q.d.h.a a2 = d.a.s0.q.d.e.c().a((DownloadCacheKey) this.f69005a.f69003b.get(str));
                if (a2 == null) {
                    return;
                }
                Toast.makeText(TbadkCoreApplication.getInst(), TbadkApplication.getInst().getResources().getString(R.string.download_start_tips), 1).show();
                a2.c(str);
            }
        }

        @Override // d.a.s0.q.d.h.c
        public void d(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, str, i2) == null) {
                d.a.s0.q.d.h.a a2 = d.a.s0.q.d.e.c().a((DownloadCacheKey) this.f69005a.f69003b.get(str));
                if (a2 == null) {
                    return;
                }
                a2.d(str, i2);
            }
        }

        @Override // d.a.s0.q.d.h.c
        public void onSuccess(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
                DownloadCacheKey downloadCacheKey = (DownloadCacheKey) this.f69005a.f69003b.get(str);
                String a2 = d.a.s0.q.d.a.a(TbadkCoreApplication.getInst(), str2);
                if (downloadCacheKey == null) {
                    downloadCacheKey = DownloadCacheKey.create(str, "");
                    this.f69005a.f69003b.put(str, downloadCacheKey);
                }
                if (!TextUtils.isEmpty(a2)) {
                    downloadCacheKey.mPackageName = a2;
                }
                AdDownloadData b2 = d.a.s0.q.d.e.c().b(downloadCacheKey);
                if (!TextUtils.isEmpty(a2)) {
                    b2.setupPkgName(a2);
                }
                d.a.s0.q.d.h.a a3 = d.a.s0.q.d.e.c().a(downloadCacheKey);
                if (a3 == null) {
                    return;
                }
                if (d.a.s0.q.d.a.b(TbadkCoreApplication.getInst(), a2)) {
                    a3.g();
                } else {
                    a3.onSuccess(str, str2);
                }
            }
        }

        public /* synthetic */ C1870b(b bVar, a aVar) {
            this(bVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(795931540, "Ld/a/s0/w2/c0/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(795931540, "Ld/a/s0/w2/c0/b;");
        }
    }

    public b() {
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
        this.f69003b = new HashMap();
        this.f69004c = new C1870b(this, null);
    }

    @Override // d.a.s0.q.d.i.a
    public void a(String str) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (downloadCacheKey = this.f69003b.get(str)) == null) {
            return;
        }
        i.l().g(downloadCacheKey.mDownloadUrl, str, true);
    }

    @Override // d.a.s0.q.d.i.a
    public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadCacheKey, adDownloadData) == null) {
            this.f69003b.put(downloadCacheKey.mAdId, downloadCacheKey);
            DownloadData downloadData = new DownloadData();
            downloadData.setId(downloadCacheKey.mAdId);
            downloadData.setUrl(downloadCacheKey.mDownloadUrl);
            downloadData.setName(downloadCacheKey.mPackageName);
            downloadData.setType(12);
            downloadData.setNotifyId(i.m(downloadCacheKey.mPackageName).intValue());
            downloadData.setNeedNotify(true);
            downloadData.setNeedInvokeApk(true);
            downloadData.setPosition(0);
            i.l().w(downloadData);
        }
    }

    @Override // d.a.s0.q.d.i.a
    public d.a.s0.q.d.h.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69004c : (d.a.s0.q.d.h.c) invokeV.objValue;
    }

    @Override // d.a.s0.q.d.i.a
    public void d(String str) {
        DownloadCacheKey downloadCacheKey;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (downloadCacheKey = this.f69003b.get(str)) == null) {
            return;
        }
        this.f69003b.put(downloadCacheKey.mAdId, downloadCacheKey);
        DownloadData downloadData = new DownloadData();
        downloadData.setId(downloadCacheKey.mAdId);
        downloadData.setUrl(downloadCacheKey.mDownloadUrl);
        downloadData.setName(downloadCacheKey.mPackageName);
        downloadData.setType(12);
        downloadData.setNotifyId(i.m(downloadData.getName()).intValue());
        downloadData.setNeedNotify(true);
        downloadData.setNeedInvokeApk(true);
        downloadData.setPosition(0);
        i.l().w(downloadData);
    }
}
