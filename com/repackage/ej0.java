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
/* loaded from: classes5.dex */
public class ej0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<gk0>> a;
    public final ReentrantReadWriteLock b;
    public final IAdDownloader c;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-412682487, "Lcom/repackage/ej0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-412682487, "Lcom/repackage/ej0$a;");
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ej0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-412682456, "Lcom/repackage/ej0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-412682456, "Lcom/repackage/ej0$b;");
                    return;
                }
            }
            a = new ej0(null);
        }
    }

    public /* synthetic */ ej0(a aVar) {
        this();
    }

    public static ej0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (ej0) invokeV.objValue;
    }

    public static void c(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, rj0Var) == null) {
            if (TextUtils.isEmpty(rj0Var.p.c) || !th0.b(rj0Var.p.c)) {
                pk0.f(rj0Var.d);
                d(AdDownloadAction.OPEN, rj0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull rj0 rj0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, rj0Var) == null) || TextUtils.isEmpty(rj0Var.p.a)) {
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
        clogBuilder.w(logType).n(rj0Var.p.a).h(rj0Var.q.i).i(rj0Var.d).j(rj0Var.q.a).k(rj0Var.q.b).l(rj0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(rj0Var.q.c)) {
            uy0.f(jSONObject, "ad_download_content_type", rj0Var.q.c);
        }
        long j = rj0Var.q.d;
        if (j > 0) {
            uy0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = rj0Var.n;
        if (i > 0) {
            uy0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(rj0Var.o)) {
            uy0.f(jSONObject, "version_name", rj0Var.o);
        }
        if (jSONObject.length() > 0) {
            clogBuilder.m(jSONObject.toString());
        }
        ez0.c(clogBuilder);
    }

    public void a(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, rj0Var) == null) || rj0Var.e()) {
            return;
        }
        this.c.d(rj0Var.b);
        rj0Var.c = AdDownloadStatus.NONE;
        e(AdDownloadAction.FAIL, rj0Var);
    }

    public void e(@NonNull AdDownloadAction adDownloadAction, @NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, rj0Var) == null) {
            d(adDownloadAction, rj0Var);
            this.b.readLock().lock();
            try {
                List list = (List) vy0.b(this.a, rj0Var.d());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != ty0.k(list); i++) {
                    gk0 gk0Var = (gk0) ty0.d(list, i);
                    if (gk0Var != null && gk0Var.getData() != null) {
                        gk0Var.getData().h(rj0Var);
                        gk0Var.a(adDownloadAction, gk0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void f(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rj0Var) == null) {
            this.c.b(rj0Var.b);
        }
    }

    public void g(String str, gk0 gk0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, gk0Var) == null) || TextUtils.isEmpty(str) || gk0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) vy0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                vy0.e(this.a, str, list);
            }
            ty0.b(list, gk0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void h(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, rj0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, rj0Var);
            this.c.c(rj0Var.b, rj0Var.g, new fj0(rj0Var));
        }
    }

    public void i(@NonNull rj0 rj0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, rj0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, rj0Var);
            rj0Var.b = this.c.a(rj0Var.g, new fj0(rj0Var));
            rj0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void j(String str, gk0 gk0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, gk0Var) == null) || TextUtils.isEmpty(str) || gk0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) vy0.b(this.a, str);
            if (list == null) {
                return;
            }
            ty0.j(list, gk0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public ej0() {
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
        this.c = jk0.b();
    }
}
