package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class vh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<xi0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(72166038, "Lcom/repackage/vh0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(72166038, "Lcom/repackage/vh0$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadAction.values().length];
            a = iArr;
            try {
                iArr[AdDownloadAction.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AdDownloadAction.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AdDownloadAction.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AdDownloadAction.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AdDownloadAction.INSTALL_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AdDownloadAction.INSTALL_FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AdDownloadAction.OPEN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[AdDownloadAction.FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final vh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(72166069, "Lcom/repackage/vh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(72166069, "Lcom/repackage/vh0$b;");
                    return;
                }
            }
            a = new vh0(null);
        }
    }

    public /* synthetic */ vh0(a aVar) {
        this();
    }

    public static vh0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (vh0) invokeV.objValue;
    }

    public static void c(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ii0Var) == null) {
            if (TextUtils.isEmpty(ii0Var.p.c) || !kg0.b(ii0Var.p.c)) {
                gj0.f(ii0Var.d);
                d(AdDownloadAction.OPEN, ii0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull ii0 ii0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, ii0Var) == null) || TextUtils.isEmpty(ii0Var.p.a)) {
            return;
        }
        switch (a.a[adDownloadAction.ordinal()]) {
            case 1:
                logType = ClogBuilder.LogType.DOWNLOAD_START;
                break;
            case 2:
                logType = ClogBuilder.LogType.DOWNLOAD_PAUSE;
                break;
            case 3:
                logType = ClogBuilder.LogType.DOWNLOAD_CONTINUE;
                break;
            case 4:
                logType = ClogBuilder.LogType.DOWNLOAD_COMPLETE;
                break;
            case 5:
                logType = ClogBuilder.LogType.DOWNLOAD_INSTALL;
                break;
            case 6:
                logType = ClogBuilder.LogType.INSTALL_COMPLETE;
                break;
            case 7:
                logType = ClogBuilder.LogType.DEEP_LINK;
                break;
            case 8:
                logType = ClogBuilder.LogType.DOWNLOAD_FAILED;
                break;
            default:
                return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.w(logType).n(ii0Var.p.a).h(ii0Var.q.i).i(ii0Var.d).j(ii0Var.q.a).k(ii0Var.q.b).l(ii0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(ii0Var.q.c)) {
            lx0.f(jSONObject, "ad_download_content_type", ii0Var.q.c);
        }
        long j = ii0Var.q.d;
        if (j > 0) {
            lx0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = ii0Var.n;
        if (i > 0) {
            lx0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(ii0Var.o)) {
            lx0.f(jSONObject, "version_name", ii0Var.o);
        }
        if (jSONObject.length() > 0) {
            clogBuilder.m(jSONObject.toString());
        }
        vx0.c(clogBuilder);
    }

    public void a(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ii0Var) == null) || ii0Var.e()) {
            return;
        }
        this.c.d(ii0Var.b);
        ii0Var.c = AdDownloadStatus.NONE;
        e(AdDownloadAction.FAIL, ii0Var);
    }

    public void e(@NonNull AdDownloadAction adDownloadAction, @NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, ii0Var) == null) {
            d(adDownloadAction, ii0Var);
            this.b.readLock().lock();
            try {
                List list = (List) mx0.b(this.a, ii0Var.d());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != kx0.k(list); i++) {
                    xi0 xi0Var = (xi0) kx0.d(list, i);
                    if (xi0Var != null && xi0Var.getData() != null) {
                        xi0Var.getData().h(ii0Var);
                        xi0Var.a(adDownloadAction, xi0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void f(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ii0Var) == null) {
            this.c.b(ii0Var.b);
        }
    }

    public void g(String str, xi0 xi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, xi0Var) == null) || TextUtils.isEmpty(str) || xi0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) mx0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                mx0.e(this.a, str, list);
            }
            kx0.b(list, xi0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void h(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ii0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, ii0Var);
            this.c.c(ii0Var.b, ii0Var.g, new wh0(ii0Var));
        }
    }

    public void i(@NonNull ii0 ii0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ii0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, ii0Var);
            ii0Var.b = this.c.a(ii0Var.g, new wh0(ii0Var));
            ii0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void j(String str, xi0 xi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, xi0Var) == null) || TextUtils.isEmpty(str) || xi0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) mx0.b(this.a, str);
            if (list == null) {
                return;
            }
            kx0.j(list, xi0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public vh0() {
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
        this.a = new HashMap<>(32);
        this.b = new ReentrantReadWriteLock();
        this.c = aj0.b();
    }
}
