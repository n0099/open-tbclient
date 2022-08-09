package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class ai0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<gj0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-528122612, "Lcom/repackage/ai0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-528122612, "Lcom/repackage/ai0$a;");
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
            try {
                a[AdDownloadAction.FAIL_RETRY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[AdDownloadAction.FAIL_PERMISSION_DENY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final ai0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-528122581, "Lcom/repackage/ai0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-528122581, "Lcom/repackage/ai0$b;");
                    return;
                }
            }
            a = new ai0(null);
        }
    }

    public /* synthetic */ ai0(a aVar) {
        this();
    }

    public static ai0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (ai0) invokeV.objValue;
    }

    public static void c(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, oi0Var) == null) {
            if (TextUtils.isEmpty(oi0Var.p.c) || !mg0.b(oi0Var.p.c)) {
                qj0.f(oi0Var.d);
                d(AdDownloadAction.OPEN, oi0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, oi0Var) == null) {
            e(adDownloadAction, oi0Var, null);
        }
    }

    public static void e(@NonNull AdDownloadAction adDownloadAction, @NonNull oi0 oi0Var, @Nullable wi0 wi0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65541, null, adDownloadAction, oi0Var, wi0Var) == null) || TextUtils.isEmpty(oi0Var.p.a)) {
            return;
        }
        String str = oi0Var.q.j;
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
            case 9:
                logType = ClogBuilder.LogType.DOWNLOAD_RETRY;
                break;
            default:
                return;
        }
        if (TextUtils.isEmpty(str)) {
            str = ClogBuilder.Area.DOWNLOAD_BUTTON.type;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(logType).p(oi0Var.p.a).v(oi0Var.q.a).j(str).k(oi0Var.d).l(oi0Var.q.a).m(oi0Var.q.b).n(oi0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(oi0Var.q.d)) {
            xx0.f(jSONObject, "ad_download_content_type", oi0Var.q.d);
        }
        long j = oi0Var.q.e;
        if (j > 0) {
            xx0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = oi0Var.n;
        if (i > 0) {
            xx0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(oi0Var.o)) {
            xx0.f(jSONObject, "version_name", oi0Var.o);
        }
        if (wi0Var != null) {
            Exception exc = wi0Var.a;
            if (exc != null) {
                xx0.f(jSONObject, "failed_reason", exc.getClass().toString());
            }
            String str2 = wi0Var.b;
            if (str2 != null) {
                xx0.f(jSONObject, "failed_reason", str2);
            }
        }
        if (jSONObject.length() > 0) {
            clogBuilder.o(jSONObject.toString());
        }
        hy0.b(clogBuilder);
    }

    public void a(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oi0Var) == null) || oi0Var.f()) {
            return;
        }
        this.c.b(oi0Var);
        oi0Var.c = AdDownloadStatus.NONE;
        f(AdDownloadAction.FAIL, oi0Var);
    }

    public void f(@NonNull AdDownloadAction adDownloadAction, @NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, oi0Var) == null) {
            g(adDownloadAction, oi0Var, null);
        }
    }

    public void g(@NonNull AdDownloadAction adDownloadAction, @NonNull oi0 oi0Var, @Nullable wi0 wi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, adDownloadAction, oi0Var, wi0Var) == null) {
            e(adDownloadAction, oi0Var, wi0Var);
            this.b.readLock().lock();
            try {
                List list = (List) yx0.b(this.a, oi0Var.e());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != wx0.k(list); i++) {
                    gj0 gj0Var = (gj0) wx0.d(list, i);
                    if (gj0Var != null && gj0Var.getData() != null) {
                        gj0Var.getData().i(oi0Var);
                        gj0Var.a(adDownloadAction, gj0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void h(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oi0Var) == null) {
            this.c.c(oi0Var);
        }
    }

    public void i(String str, gj0 gj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, gj0Var) == null) || TextUtils.isEmpty(str) || gj0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) yx0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                yx0.e(this.a, str, list);
            }
            wx0.b(list, gj0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void j(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, oi0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, oi0Var);
            this.c.d(oi0Var, new bi0(oi0Var));
        }
    }

    public void k(@NonNull oi0 oi0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oi0Var) == null) {
            f(AdDownloadAction.PROGRESS_UPDATE, oi0Var);
            oi0Var.b = this.c.a(oi0Var, new bi0(oi0Var));
            oi0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void l(String str, gj0 gj0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, gj0Var) == null) || TextUtils.isEmpty(str) || gj0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) yx0.b(this.a, str);
            if (list == null) {
                return;
            }
            wx0.j(list, gj0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public ai0() {
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
        this.c = ij0.b();
    }
}
