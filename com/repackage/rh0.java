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
public class rh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<ti0>> a;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-42350566, "Lcom/repackage/rh0$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-42350566, "Lcom/repackage/rh0$a;");
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
        public static final rh0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-42350535, "Lcom/repackage/rh0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-42350535, "Lcom/repackage/rh0$b;");
                    return;
                }
            }
            a = new rh0(null);
        }
    }

    public /* synthetic */ rh0(a aVar) {
        this();
    }

    public static rh0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.a : (rh0) invokeV.objValue;
    }

    public static void c(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ei0Var) == null) {
            if (TextUtils.isEmpty(ei0Var.p.c) || !gg0.b(ei0Var.p.c)) {
                cj0.f(ei0Var.d);
                d(AdDownloadAction.OPEN, ei0Var);
            }
        }
    }

    public static void d(@NonNull AdDownloadAction adDownloadAction, @NonNull ei0 ei0Var) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, adDownloadAction, ei0Var) == null) || TextUtils.isEmpty(ei0Var.p.a)) {
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
        clogBuilder.w(logType).n(ei0Var.p.a).h(ei0Var.q.i).i(ei0Var.d).j(ei0Var.q.a).k(ei0Var.q.b).l(ei0Var.g);
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(ei0Var.q.c)) {
            hx0.f(jSONObject, "ad_download_content_type", ei0Var.q.c);
        }
        long j = ei0Var.q.d;
        if (j > 0) {
            hx0.e(jSONObject, "ad_download_content_length", j);
        }
        int i = ei0Var.n;
        if (i > 0) {
            hx0.d(jSONObject, "version_code", i);
        }
        if (!TextUtils.isEmpty(ei0Var.o)) {
            hx0.f(jSONObject, "version_name", ei0Var.o);
        }
        if (jSONObject.length() > 0) {
            clogBuilder.m(jSONObject.toString());
        }
        rx0.c(clogBuilder);
    }

    public void a(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, ei0Var) == null) || ei0Var.e()) {
            return;
        }
        this.c.d(ei0Var.b);
        ei0Var.c = AdDownloadStatus.NONE;
        e(AdDownloadAction.FAIL, ei0Var);
    }

    public void e(@NonNull AdDownloadAction adDownloadAction, @NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adDownloadAction, ei0Var) == null) {
            d(adDownloadAction, ei0Var);
            this.b.readLock().lock();
            try {
                List list = (List) ix0.b(this.a, ei0Var.d());
                if (list == null) {
                    return;
                }
                for (int i = 0; i != gx0.k(list); i++) {
                    ti0 ti0Var = (ti0) gx0.d(list, i);
                    if (ti0Var != null && ti0Var.getData() != null) {
                        ti0Var.getData().h(ei0Var);
                        ti0Var.a(adDownloadAction, ti0Var.getData());
                    }
                }
            } finally {
                this.b.readLock().unlock();
            }
        }
    }

    public void f(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ei0Var) == null) {
            this.c.b(ei0Var.b);
        }
    }

    public void g(String str, ti0 ti0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, ti0Var) == null) || TextUtils.isEmpty(str) || ti0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) ix0.b(this.a, str);
            if (list == null) {
                list = new ArrayList();
                ix0.e(this.a, str, list);
            }
            gx0.b(list, ti0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public void h(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, ei0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, ei0Var);
            this.c.c(ei0Var.b, ei0Var.g, new sh0(ei0Var));
        }
    }

    public void i(@NonNull ei0 ei0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ei0Var) == null) {
            e(AdDownloadAction.PROGRESS_UPDATE, ei0Var);
            ei0Var.b = this.c.a(ei0Var.g, new sh0(ei0Var));
            ei0Var.c = AdDownloadStatus.DOWNLOADING;
        }
    }

    public void j(String str, ti0 ti0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, ti0Var) == null) || TextUtils.isEmpty(str) || ti0Var == null) {
            return;
        }
        this.b.writeLock().lock();
        try {
            List list = (List) ix0.b(this.a, str);
            if (list == null) {
                return;
            }
            gx0.j(list, ti0Var);
        } finally {
            this.b.writeLock().unlock();
        }
    }

    public rh0() {
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
        this.c = wi0.b();
    }
}
